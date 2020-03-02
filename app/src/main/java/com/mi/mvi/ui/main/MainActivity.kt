package com.mi.mvi.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mi.mvi.R
import com.mi.mvi.base.BaseActivity
import com.mi.mvi.ui.auth.AuthActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscriberObservers()
    }

    private fun subscriberObservers() {
        sessionManager.cachedToken.observe(this, Observer { authToken ->
            if (authToken == null || authToken.account_pk == -1 || authToken.token == null) {
                navAuthActivity()
            }
        })
    }

    private fun navAuthActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }
}