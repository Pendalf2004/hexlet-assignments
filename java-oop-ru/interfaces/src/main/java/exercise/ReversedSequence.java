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

    @Override
    public char charAt(int n) {
        return sequence[n];
    }

    @Override
    public int length() {

        return this.length;
    }

    @Override
    public CharSequence subSequence(int from, int to) {
        if ((from >= to) || (this.length < 1)) {return new ReversedSequence("");}
        var length = to - from;
        char[] result = new char[length];
        for (int i = 0; i < (length); i++) {
            result[i] = this.sequence[from + i];
        }
        return new ReversedSequence(ReversedSequence(result.toString()));
    }
}
// END
