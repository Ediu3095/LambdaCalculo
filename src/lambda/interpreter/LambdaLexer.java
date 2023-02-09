// Generated from java-escape by ANTLR 4.11.1
package lambda.interpreter;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LambdaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LAMBDA=4, EQUIVALENCE=5, VAR=6, VARIABLE=7, EOL=8, 
		COMMENT=9, WHITESPACE=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "LAMBDA", "EQUIVALENCE", "VAR", "VARIABLE", "EOL", 
			"COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LAMBDA", "EQUIVALENCE", "VAR", "VARIABLE", "EOL", 
			"COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LambdaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lambda.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\nA\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003#\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006+\b\u0006\n\u0006\f\u0006.\t\u0006\u0001\u0007\u0004"+
		"\u00071\b\u0007\u000b\u0007\f\u00072\u0001\b\u0001\b\u0005\b7\b\b\n\b"+
		"\f\b:\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0000\u0000"+
		"\n\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0001\u0000\u0006\u0002\u0000::\u2261"+
		"\u2261\u0001\u0000az\u0002\u000009AZ\u0003\u000009AZaz\u0002\u0000\n\n"+
		"\r\r\u0002\u0000\t\t  D\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003\u0017\u0001\u0000"+
		"\u0000\u0000\u0005\u0019\u0001\u0000\u0000\u0000\u0007\"\u0001\u0000\u0000"+
		"\u0000\t$\u0001\u0000\u0000\u0000\u000b&\u0001\u0000\u0000\u0000\r(\u0001"+
		"\u0000\u0000\u0000\u000f0\u0001\u0000\u0000\u0000\u00114\u0001\u0000\u0000"+
		"\u0000\u0013=\u0001\u0000\u0000\u0000\u0015\u0016\u0005.\u0000\u0000\u0016"+
		"\u0002\u0001\u0000\u0000\u0000\u0017\u0018\u0005(\u0000\u0000\u0018\u0004"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0005)\u0000\u0000\u001a\u0006\u0001"+
		"\u0000\u0000\u0000\u001b#\u0005\u03bb\u0000\u0000\u001c\u001d\u0005l\u0000"+
		"\u0000\u001d\u001e\u0005a\u0000\u0000\u001e\u001f\u0005m\u0000\u0000\u001f"+
		" \u0005b\u0000\u0000 !\u0005d\u0000\u0000!#\u0005a\u0000\u0000\"\u001b"+
		"\u0001\u0000\u0000\u0000\"\u001c\u0001\u0000\u0000\u0000#\b\u0001\u0000"+
		"\u0000\u0000$%\u0007\u0000\u0000\u0000%\n\u0001\u0000\u0000\u0000&\'\u0007"+
		"\u0001\u0000\u0000\'\f\u0001\u0000\u0000\u0000(,\u0007\u0002\u0000\u0000"+
		")+\u0007\u0003\u0000\u0000*)\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000"+
		"\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u000e\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/1\u0007\u0004\u0000\u0000"+
		"0/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u00003\u0010\u0001\u0000\u0000\u000048\u0005"+
		";\u0000\u000057\b\u0004\u0000\u000065\u0001\u0000\u0000\u00007:\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;<\u0006\b\u0000\u0000"+
		"<\u0012\u0001\u0000\u0000\u0000=>\u0007\u0005\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0006\t\u0000\u0000@\u0014\u0001\u0000\u0000\u0000\u0005"+
		"\u0000\",28\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}