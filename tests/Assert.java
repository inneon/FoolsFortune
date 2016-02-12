package tests;

public class Assert {

	public static boolean verbose = true;

	public static <T> void AreEqual(T expected, T actual, String message) throws Exception {
		if (expected != actual) {
			//PrintError(message);
			throw new Exception(message);
		}
	} 
	
	public static <T> void AreNotEqual(T notExpected, T actual, String message) throws Exception {
		if (notExpected == actual) {
			//PrintError(message);
			throw new Exception(message);
		}
	} 
	
	public static void IsTrue(boolean condition, String message) throws Exception {
		if (!condition) {
			//PrintError(message);
			throw new Exception(message);
		}
	}
	
	public static void PrintError(String message) {
		String ANSI_RESET = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		Print(ANSI_RED + message + ANSI_RESET);
	}
	
	public static void Print(String message) {
		if (verbose) {
			System.out.println(message);
		}
	}
}
