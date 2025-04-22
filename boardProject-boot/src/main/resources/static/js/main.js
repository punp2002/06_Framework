// 쿠키에 저장된 이메일 input 창에 입력해놓기
// 로그인이 안된 경우 수행
const loginForm = document.querySelector("#loginForm");
// 쿠키에서 매개변수로 전달 받은 key와 일치하는 value 얻어와 반환하는 함수
const getCookie = (key) => {
  const cookies = document.cookie; // "K=V; K=V;...""

  //console.log(cookies);
  // cookies에 저장된 문자열을 배열형태로 변환
  const cookieList = cookies.split("; ") // ["k=v", k=v" , ...]
                    .map(el => el.split("=")); // ["k", "v" , ...]
     
    // 배열.map(함수) : 배열의 각 요소를 이용해 콜백함수 수행 후 
    //                 결과 값으로 새로운 배열을 만들어서 반환하는 js 내장 함수

    
    /*
    [
      ['saveId', 'user01@kh.or.kr'],
      ['test', 'testValue']   
      ]
      2차원 배열형태임
      
      */
     
    // 배열 -> js 객체로 변환 (그래야 다루기 쉬움)
    
    const obj = {}; // 비어있는 객체 선언
    for (let i = 0; i < cookieList.length; i++) {
      const k = cookieList[i][0];
      const v = cookieList[i][1];
      obj[k] = v; // obj 객체에 K:V 형태로 추가
      // obj["saveId"] = 'user01@kh.or.kr';
      }

     //console.log(obj);
    return obj[key]; // 매개변수로 전달 받은 key와
                     // obj 객체에 저장된 key가 일치하는 요소의 value 값 반환
}

// 이메일 작성 input 태그 요소
const loginEmail = document.querySelector("#loginForm input[name='memberEmail']");

if(loginEmail != null) { // 로그인폼의 이메일 input 태그가 화면상에 존재할 때

  // 쿠키 중 key 값이 "saveId"인 요소의 value 얻어오기
  const saveId = getCookie("saveId"); // 이메일 또는 undefiend

  // saveId 값이 있을 경우 
  if(saveId != undefined) {
    loginEmail.value = saveId; // 쿠키에서 얻어온 이메일 값을 input 요소의 value에 세팅

    // 아이디 저장 체크박스에 체크해두기
    document.querySelector("input[name='saveId']").checked = true;

  }
}

// 로그인 버튼 클릭 시 수행
loginForm.addEventListener("submit", function(e) {

  const email = loginForm.querySelector("input[name='memberEmail']");
  const password = loginForm.querySelector("input[name='memberPw']");

  // 이메일 입력 안 했을 때
  if (email.value.trim().length === 0) {
    alert("이메일을 입력해주세요.");
    email.focus();
    e.preventDefault(); // form 제출 막기
    return;
  }

  // 비밀번호 입력 안 했을 때
  if (password.value.trim().length === 0) {
    alert("비밀번호를 입력해주세요.");
    password.focus();
    e.preventDefault(); 
    return;
  }
});