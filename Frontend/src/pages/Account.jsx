import React, { useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import { Route } from 'react-router-dom'
import Divider from '@mui/material/Divider'
import Box from '@mui/material/Box'

import { Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField, IconButton } from '@mui/material'
import Close from '@mui/icons-material/Close'

const ChangeNickname = (props) => {
  const user = props.user
  return (<Box textAlign='start' m={3}>
  <h3>닉네임 변경</h3>
  <p>새로 사용할 닉네임을 작성해주세요.</p>
  <Box textAlign='center'>
    <TextField value={user.nickname} sx={{mr: 1}} size='small' />
    <Button variant='contained' sx={{}}>변경</Button>
  </Box>
  </Box>)
}

const SignOut = (props) => {
  return (<Box textAlign='start' m={3}>
    <h3>회원 탈퇴</h3>
    <Box textAlign='center'>
      <Button variant='contained'>회원 탈퇴</Button>
    </Box>

  </Box>)
}

const SignOutModal = (props) => {
  return (<Dialog>
    <DialogTitle>회원탈퇴</DialogTitle>
    <IconButton edge='end' onClick={{}} sx={{position: 'absolute', right: 20, top: 20}}>
      <Close />
    </IconButton>
    <DialogContent>
      <p>정말로 탈퇴하시겠습니까?</p>
      <DialogActions>
        <Button>
          탈퇴
        </Button>
      </DialogActions>
      <DialogActions>
        <Button>
          취소
        </Button>
      </DialogActions>
    </DialogContent>



  </Dialog>)
}

export default function Account() {
  const [info, setInfo] = useState({})
  const user = useSelector((state) => state.user)
  
  useEffect(() => {
    if (user.isLoggedIn === false) {
      // 비로그인 사용자 처리
    }
    

  })

  return (
    <>
      <h1>회원 정보</h1>
      <ChangeNickname user={info} />
      <Divider sx={{my: 3}} />
      <SignOut />
    </>
  )
}
