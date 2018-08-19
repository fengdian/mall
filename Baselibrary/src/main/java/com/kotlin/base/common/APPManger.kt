package com.kotlin.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class APPManger  private  constructor(){
    private  val  activityStack :Stack<Activity> = Stack()
    companion object {
        val  instance:APPManger by lazy { APPManger() }
    }
    fun  addActivity(activity: Activity){
        activityStack.add(activity)
    }
    fun   finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }
    fun  currentActivity():Activity{
        return  activityStack.lastElement()
    }
    fun  finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }
    fun exitApk(context : Context){
        finishAllActivity()
        val activityManger =context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManger.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}