package homework5;

public class Main {
    public static void main(String[] args) {

        Main p = new Main();
        p.oneThread();
        p.twoThread();


    }

    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;




    public void oneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }


        System.out.println("Выполнено в 1 поток за " + (System.currentTimeMillis()-a) + "мс");
    }

    public void twoThread() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);



        Thread t1 = new Thread(new Runnable() {


            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + (i+HALF_SIZE) / 5) * Math.cos(0.2f + (i+HALF_SIZE) / 5) * Math.cos(0.4f + (i+HALF_SIZE) / 2));

                }

            }
        });

        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);

        System.out.println("Выполнено в 2 потока за " + (System.currentTimeMillis()-a) + "мс");
    }
}
