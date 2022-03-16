package com.nadiahassouni.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*

class RandomNumberGenerator(appContext : Context, workParams : WorkerParameters) : Worker(appContext , workParams) {
    override fun doWork(): Result {
        return try {
            startRandomNumberGenerator()
            Result.success()
        }catch (e : Exception){
            Result.failure()
        }
    }

     private fun startRandomNumberGenerator(){
         var i =0
         while (i<5){
             try{
                 Thread.sleep(1000)
                 val randomNumber = Random().nextInt()
                 Log.i("randomNumber" , "Random number $randomNumber ")
                 i++

             }catch (e : InterruptedException){
                 Log.i("randomNumber" , "Thread Interrupted")
             }
         }
     }

}