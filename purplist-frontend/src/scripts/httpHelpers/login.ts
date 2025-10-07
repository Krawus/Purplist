const axios = require('axios').default

export async function login(username: string, password: string) {
  try {
    const response = await axios.post('http://localhost:3000/api/login', {
      username,
      password,
    })
    return response.data
  } catch (error) {
    console.error('Login error:', error)
    throw error
  }
}
