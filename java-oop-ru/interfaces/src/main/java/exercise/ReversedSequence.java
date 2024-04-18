package exercise;

// BEGIN
class ReversedSequence implements java.lang.CharSequence {
    private char[] sequence;
    private int length;

    ReversedSequence(String input) {
        char[] result = new char[input.length()];
        int index = 0;
        this.length = input.length();
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
        return this.length;
    }
    public char[] subSequence(int from, int to) {
        if ((from >= to) || (this.length < 1)) {return new char[0];}
        char[] result = new char[to - from];
        for (int i = 0; i < result.length(); i++) {
            result[i] = this.sequence[from + i];
        }
        return result;
    }
}
// END
