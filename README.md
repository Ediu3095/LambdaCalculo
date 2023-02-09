# Lambda Cálculo

Este repositorio contiene el código de un programa de terminal diseñado para resolver problemas de λ-cálculo. Concretamente, ejecución **paso a paso** de programas de λ-cálculo permitiendo la utilización de variables para almacenar **expresiones λ**.

## Motivación

Los problemas que intenta resolver este programa son problemas planteados en el Tema 4 de la asignatura [Conocimiento y Razonamiento Automatizado](https://www.uah.es/es/estudios/estudios-oficiales/grados/asignatura/Conocimiento-y-Razonamiento-Automatizado-780025/) del tercer curso del [Grado en Ingeniería Informática](https://www.uah.es/es/estudios/Grado-en-Ingenieria-Informatica/) de la [Universidad de Alcalá](https://www.uah.es/es/). Así pues, este programa intenta facilitar el estudio de esta asignatura proporcionando una herramienta para encontrar las soluciones de los problemas de manera consistente.

## Instalación

Este repositorio es un proyecto de [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/). Este tiene configurado un artefacto para crear un fichero **jar** que pueda utilizarse para ejecutar el programa. Se puede encontrar el fichero compilado para distintas versiones del jdk en el apartado de **releases** del repositorio.

### Compilación

Para compilarlo es necesario tener en la carpeta de dependencias el **jar** de la librería [ANTLR v4](https://www.antlr.org/). La versión con la que se han creado los ficheros de la gramática es la **4.11.1** por lo que el fichero necesario sería [antlr-runtime-4.11.1.jar](https://www.antlr.org/download/antlr-runtime-4.11.1.jar). Sin embargo, es posible hacer que el programa funcione con otras versiones de [ANTLR v4](https://www.antlr.org/) siempre y cuando se vuelvan a generar los archivos de código a partir de la gramática en el paquete **lambda.interpreter** del proyecto.

Una vez tenemos el código del programa y las dependencias correspondientes podemos compilarlo desde el menú `Build > Build Artifact... > LambdaCalculo:jar Build`. También se puede encontrar el fichero compilado para distintas versiones del jdk en el apartado de **releases** del repositorio.

## Uso

Para utilizar el programa desde la terminal escribiremos algo similar a lo siguiente:

```bash
java -jar LC-XX.jar [--verbose] <archivo>
```

En el anterior comando:

- `--verbose`. Es un argumento opcional que hace que el programa imprima no solo el resultado de las consultas sino también los pasos intermedios.
- `<archivo>`. Es la ruta del archivo que contiene las expresiones de λ-cálculo a procesar.

El archivo que debemos pasar como segundo argumento al programa deberá contener una expresión de λ-cálculo utilizando los siguientes operadores:

- `λ`. Operador Lambda, para la declaración de abstracciones.
- `≡`. Operador de equivalencia, para la declaración de expresiones con nombre (normalmente abstracciones).

También se permite el uso de paréntesis para agrupar expresiones y `;` para crear comentarios de línea.

Veamos a continuación algunos ejemplos de ejecución para distintas entradas.

### Consulta

```bash
java -jar LC-XX.jar consulta.cp
```

El programa distingue dos tipos de expresiones, la primera de las cuales es la **consulta**. Cada fichero puede tener una cantidad variable de consultas. Cada consulta debe estar en una línea nueva.

```
; Podemos realizar consultas introduciendo una línea con una expresión
λxy.(y x) a b

; Cada fichero puede tener una cantidad indeterminada de consultas
λx.(y) a
λy.(y) a
λxy.(x y) a

; Las 'constantes' de las expresiones lambda constan de una única letra minúscula
λxy.(yx) ab
λ x y.(y x) a b ; Esta expresión es igual que la anterior aunque las constantes como 'a' y 'b' estén separadas
```

El programa imprimirá el resultado de las consultas a través de la salida estándar. Si **no** se especifica el argumento `--verbose` solamente se imprimirán las consultas junto a los resultados:

```
Processing query: (((λxy.(y x)) a) b)
Query result: (b a)
---
Processing query: ((λx.y) a)
Query result: y
---
Processing query: ((λy.y) a)
Query result: a
---
Processing query: ((λxy.(x y)) a)
Query result: (λy.(a y))
---
Processing query: (((λxy.(y x)) a) b)
Query result: (b a)
---
Processing query: (((λxy.(y x)) a) b)
Query result: (b a)
---
```

Si, por el contrario, **si** se utiliza `--verbose`, también se imprimirán los pasos que se han seguido para llegar a este resultado:

```
Processing query: (((λxy.(y x)) a) b)
0: (((λxy.(y x)) a) b)
1: ((λy.(y a)) b)
2: (b a)
3: (b a)
Query result: (b a)
---
Processing query: ((λx.y) a)
0: ((λx.y) a)
1: y
2: y
Query result: y
---
Processing query: ((λy.y) a)
0: ((λy.y) a)
1: a
2: a
Query result: a
---
Processing query: ((λxy.(x y)) a)
0: ((λxy.(x y)) a)
1: (λy.(a y))
2: (λy.(a y))
Query result: (λy.(a y))
---
Processing query: (((λxy.(y x)) a) b)
0: (((λxy.(y x)) a) b)
1: ((λy.(y a)) b)
2: (b a)
3: (b a)
Query result: (b a)
---
Processing query: (((λxy.(y x)) a) b)
0: (((λxy.(y x)) a) b)
1: ((λy.(y a)) b)
2: (b a)
3: (b a)
Query result: (b a)
---
```

### Asignación

```bash
java -jar LC-XX.jar asignacion.lc
```

El segundo tipo de expresiones es la **asignación**. Al igual que con las consultas, puede haber una cantidad indeterminada de estas en el fichero de código. Las asignaciones pueden estar intercaladas con las consultas y sirven para simplificar la escritura de estas.

```
; Podemos crear variables con ≡
True  ≡ λxy.(x)
False ≡ λxy.(y)
If    ≡ λpxy.(pxy)

And ≡ λpq.(p q False)
Or  ≡ λpq.(p True q)
Not ≡ λp.(p False True)

; Las variables se pueden utilizar a la hora de realizar consultas
And True  True
And True  False
And False True
And False False
```

El resultado de las asignaciones **no** se muestra a través de la salida estándar. En su lugar, las variables se almacenarán en caso de que se utilicen en futuras consultas. Los nombres de las variables deben empezar por mayúscula o número y pueden estar conformados por uno o varios caracteres alfanuméricos. No se puede reasignar una variable.

```
Processing query: ((And True) True)
Query result: True
---
Processing query: ((And True) False)
Query result: False
---
Processing query: ((And False) True)
Query result: False
---
Processing query: ((And False) False)
Query result: False
---
```

### Recursividad

```bash
java -jar LC-XX.jar recursividad.lc
```

Se puede, declarar funciones recursivas a través del uso de combinadores de punto fijo. Sin embargo, no cualquier combinador de punto fijo sirve para este propósito. Por ello, se recomienda el uso del siguiente combinador de punto fijo:

```
A ≡ λar.(r(aar))
Y ≡ A A
```

Veamos un ejemplo, de uso del combinador de punto fijo

```
; Booleanos
True  ≡ λxy.(x)
False ≡ λxy.(y)
If    ≡ λpxy.(pxy)

And ≡ λpq.(p q False)
Or  ≡ λpq.(p True q)
Not ≡ λp.(p False True)

; Pares ordenados
Pair ≡ λxyt.(txy)
Fst  ≡ λp.(p True)
Snd  ≡ λp.(p False)

; Numeros naturales
0  ≡ λfx.(x)
1  ≡ λfx.(fx)
2  ≡ λfx.(f(fx))
3  ≡ λfx.(f(f(fx)))
4  ≡ λfx.(f(f(f(fx))))
5  ≡ λfx.(f(f(f(f(fx)))))
6  ≡ λfx.(f(f(f(f(f(fx))))))
7  ≡ λfx.(f(f(f(f(f(f(fx)))))))
8  ≡ λfx.(f(f(f(f(f(f(f(fx))))))))
9  ≡ λfx.(f(f(f(f(f(f(f(f(fx)))))))))
10 ≡ λfx.(f(f(f(f(f(f(f(f(f(fx))))))))))
11 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(fx)))))))))))
12 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(fx))))))))))))
13 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(fx)))))))))))))
14 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(fx))))))))))))))
15 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(f(fx)))))))))))))))
16 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(fx))))))))))))))))
17 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(fx)))))))))))))))))
18 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(fx))))))))))))))))))
19 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(fx)))))))))))))))))))
20 ≡ λfx.(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(f(fx))))))))))))))))))))

Sum  ≡ λmnfx.(mf(nfx))
Mult ≡ λmnfx.(m(nf)x)

; Operaciones básicas en los numerales de Church
Suc    ≡ λnfx.(f(nfx))
Iszero ≡ λn.(n (λx.(False)) True)

Prefn ≡ λfp.(Pair (f (Fst p)) (Fst p))

Pre ≡ λnfx.(Snd (n (Prefn f) (Pair xx)))
Sub ≡ λmn.(n Pre m)

; Listas
Nil  ≡ λz.(z)
Cons ≡ λxy.(Pair False (Pair xy))
Null ≡ Fst
Hd   ≡ λz.(Fst (Snd z))
Tl   ≡ λz.(Snd (Snd z))

; Combinadores de punto fijo
A ≡ λar.(r(aar))
Y ≡ A A

; Recursividad
Fact ≡ Y (λgn.(If (Iszero n) 1 (Mult n (g (Pre n)))))
Append ≡ Y (λgzw.(If (Null z) w (Cons (Hd z) (g (Tl z) w))))

; Consultas
Fact 0
Fact 1
Fact 2
Fact 3

; La ejecución no es muy eficiente por lo que la resolucion de algunas
; expresiones puede tardar mucho tiempo
; Fact 4

; Por otra parte la resolución de expresiones es perezosa, por lo que
; no se resolverán los argumentos internos si no es necesario hacerlo
Cons 1 (Cons 2 (Cons 3 Nil))
```

Que tiene la siguiente salida:

```
Processing query: (Fact 0)
Query result: 1
---
Processing query: (Fact 1)
Query result: 1
---
Processing query: (Fact 2)
Query result: 2
---
Processing query: (Fact 3)
Query result: 6
---
Processing query: ((Cons 1) ((Cons 2) ((Cons 3) Nil)))
Query result: (λt.((t False) ((Pair 1) ((Cons 2) ((Cons 3) Nil)))))
---
```

## Contribuir

En este momento, es posible que el programa tenga algunos errores de menor importancia. Esto se debe a que el programa se hizo en un corto lapso de tiempo y no tiene el código más limpio o eficiente. Puedes dejar un **issue** explicando cualquier error que te hayas encontrado de manera que quede documentado y así pueda arreglarlo. Si prefieres lanzarte a la aventura y arreglar tú los problemas que encuentres, te invito a crear un **fork** del repositorio y modificarlo como te plazca. Una vez hayas llevado a cabo los cambios que consideres si quieres que estos formen parte del repositorio siéntete libre de hacer un **pull request** para que los incluya.
