package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers;

    public int[] getNumbers() {
        return numbers;
    }

    public int getSize() {
        return numbers.length;
    }

    public int get(int position) {
        return numbers[position];
    }

    public synchronized void add(int num) {
       if (numbers == null)
           numbers = new int[]{num};
       else {
            int newLength = numbers.length + 1;
            var newArray = new int[newLength];
            for(int i = 0; i < newLength - 1; i++)
                newArray[i] = numbers[i];

            newArray[newLength - 1] = num;
            numbers = newArray;
       }

        }

    // END
}
