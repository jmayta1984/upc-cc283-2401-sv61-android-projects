package pe.edu.upc.eatsexplorer.feature_auth.data.repository

import android.util.Log
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.AuthService
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.AuthServiceFactory
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.UserRequest
import pe.edu.upc.eatsexplorer.feature_auth.data.remote.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository(private val authService: AuthService = AuthServiceFactory.getAuthService()) {

    fun signIn(username: String, password: String) {
        val signIn = authService.signIn(username, password)
        signIn.enqueue(object : Callback<List<UserResponse>> {
            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                t.message?.let {
                    Log.d("AuthRepository", it)
                }
            }
        })
    }

    fun signUp(userRequest: UserRequest, callback: (UserResponse) -> Unit) {
        val signUp = authService.signUp(userRequest)
        signUp.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userResponse = response.body() as UserResponse
                    callback(userResponse)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("AuthRepository", it)
                }
            }
        })

    }


}