package com.example.wrappedwebviewpoc

import android.content.Context
import java.io.InputStream
import java.security.KeyStore
import java.security.PrivateKey
import java.security.cert.X509Certificate

object CertificateUtil {
    fun loadCertificate(context: Context, password: String): Pair<PrivateKey, Array<X509Certificate>> {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.badsslcom_clientcert_pkcs12)

        // Load the PKCS#12 file into a KeyStore
        val keyStore = KeyStore.getInstance("PKCS12")
        inputStream.use { stream ->
            keyStore.load(stream, password.toCharArray())
        }

        // Extract the private key and certificate chain
        val alias = keyStore.aliases().nextElement()
        val privateKey = keyStore.getKey(alias, password.toCharArray()) as PrivateKey
        val certChain = keyStore.getCertificateChain(alias).map { it as X509Certificate }.toTypedArray()

        return privateKey to certChain
    }
}