package exercise;

// BEGIN
class ReversedSequence implements java.lang.charsequence {
    private char[] sequence;

    public ReversedSequence(String input) {
        char[] result = new char[input.length()];
        int index = 0;
        for (var i = input.length() - 1; i >= 0; i--) {
            result[index] = input.charAt(i);
            index++;
        }
        this.sequence = result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return  java.util.Arrays.toString(sequence);
    }
    public char charAt(int n) {
        return sequence[n];
    }
    public int length() {
        return sequence.length();
    }
    public char[] subSequence(int from, int to) {
        if ((from >= to) || (this.sequence.length < 1)) {return new char[0];}
        char[] result = new char[to - from];
        for (int i = 0; i < result.length(); i++) {
            result[i] = this.sequence[from + i];
        }
        return result;
    }
}
// END
