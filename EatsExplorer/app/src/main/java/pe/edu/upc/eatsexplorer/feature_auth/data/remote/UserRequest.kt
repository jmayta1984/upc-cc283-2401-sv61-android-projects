package pe.edu.upc.eatsexplorer.feature_auth.data.remote

data class UserRequest(
    val username: String,
    val lastName: String,
    val firstName: String,
    val password: String
)
