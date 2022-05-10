import { configureStore } from "@reduxjs/toolkit"
const initialUser = {
  username: "",
  email: "",
  nickname: "AnonymousUser"
}

function reducer(currentState, action) {

  // Store 기본값 설정
  if (currentState === undefined) {
    return {
      user: initialUser,
      isLoggedIn: (localStorage.getItem("token") !== null ? true : false)
    }
  }
  const newState = { ...currentState }


  // store Dispatch 작성
  // case 'dispatch명': 하고 작성하시면 됩니다.
  switch (action.type) {
    case "login":
      newState.user = action.payload
      newState.isLoggedIn = true
      break

    case "logout":
      newState.user = initialUser
      newState.isLoggedIn = false
      break

    default:
      break
  }

  // newState 출력
  return newState
}

const store = configureStore({reducer: reducer})
export default store