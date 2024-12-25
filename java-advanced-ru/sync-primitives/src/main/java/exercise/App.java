package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        var safeList = new SafetyList();
        Thread firstThread = new ListThread(safeList);
        Thread secondThread = new ListThread(safeList);
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Safelist length - " + safeList.getSize());
        // END
    }
}

