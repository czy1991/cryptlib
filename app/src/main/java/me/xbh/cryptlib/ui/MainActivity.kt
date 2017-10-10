package me.xbh.cryptlib.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.xbh.cryptlib.R
import me.xbh.cryptlib.databinding.ActivityMainBinding
import me.xbh.lib.CryptManager
import me.xbh.lib.Md5
import me.xbh.lib.impl.AesImpl
import utils.MD5Util

/**
 * Created by lulu on 17-9-27.
 */
class MainActivity : AppCompatActivity() {

    val TAG = "Test"
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val manager = CryptManager.getInstance()
        tv_content.text = AesImpl().getRandomKey()
        val text = "wenbin.zhou@ehking.com"

        Log.i(TAG, "c_md5=>${Md5.digest(text)}")
        Log.i(TAG, "j_md5=>${MD5Util.getMD5(text)}")
        Log.i(TAG, "source=>$text")
    }

}