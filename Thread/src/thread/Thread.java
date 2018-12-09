/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

class woke implements Runnable{
private int id;
int i = 1;
int ganjil = 1;
//deklarasi variable
public woke(int id){
    this.id=id;
}
@Override
public void run() {
        //memulai 1 task

 
 for (int i = 1; i <= 100; i+=2) {
            System.out.println(this.id + " " + i);
            try {
                java.lang.Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(woke.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//To change body of generated methods, choose Tools | Templates.
        Thread.sleep(5000);
    //menyelesaikan 1task
 System.out.println("selesai task : Thread"+id);   
}
}

/**
 *
 * @author ACER
 */
public class Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ExecutorService service=Executors.newFixedThreadPool(5);
        //mensumbit 5 task dengan looping for  dari 2 thread yang bekerja di thread pool
        for (int i=0; i<100; i++){
            service.submit(new woke(i));
        }
        //mematiksn semua serviece setelah semua task tersubmt
        service.shutdown();
        //keterangan semua serviece telah di submit
        System.out.println("Semua Text telah di submit");
        //menggunakan try catch
        try{
            //method awaitTermination akan memblock, sampai semua task di eksekusi
            //setelah permintaan soutdown, dalam rentang waktu yang telah ditentukan
        service.awaitTermination(1, TimeUnit.DAYS);
        }
        
        catch (InterruptedException e){
            e.printStackTrace();
        }
        //keterangan semua task telah di eksekusi
        System.out.println("semua Task telh selesai");
        }

    static void sleep(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}

