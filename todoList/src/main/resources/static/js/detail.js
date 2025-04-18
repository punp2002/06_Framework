const goToList = document.querySelector("#goToList");
goToList.addEventListener("click", () => {
  location.href = "/"; // 메인페이지 ("/") 요청 get방식
});

// 완료 여부 변경 버튼에 대한 동작 버튼
const completeBtn = document.querySelector(".complete-btn");
completeBtn.addEventListener("click", (e) => {

  // 요소.dataset : data-* 속성에 저장된 값 반환
  // data-todo-no 세팅한 속성값 얻어오기
  // (html) data-todo-no -> js(카멜케이스) dataset.todoNo
  const todoNo = e.target.dataset.todoNo;

  let complete = e.target.innerText; // 기존 완료 여부 값 얻어오기 ("Y"/"N")

  // Y <-> N 
  complete = (complete === 'Y') ? 'N' : 'Y';

  // 완료 여부 수정 요청하기
  location.href = `/todo/changeComplete?todoNo=${todoNo}&complete=${complete}`;
});

// ------------------------------------------------------------------

// 수정 버튼 클릭 시 동작
const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click", e => {

  const todoNo = e.target.dataset.todoNo;

  location.href = `/todo/update?todoNo=${todoNo}`;
});

// 삭제 버튼 클릭 시 동작
const deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener("click", (e) => {

    if (confirm("삭제하시겠습니까?")) {
    location.href = `/todo/delete?todoNo=${e.target.dataset.todoNo}`; 
  }
});

// js에서 버튼 눌러  get 방식으로 삭제요청 보내기
// 버튼 눌렀을 때 "삭제하시겠습니까?" 얼럿 후 확인 버튼 눌렀을 때만 삭제요청 보내기

// 삭제 성공 시 message는 "삭제 성공" 메인페이지 재요청
// 삭제 실패 시 message는 "삭제 실패" 해당 todo의 상세페이지로 재요청

