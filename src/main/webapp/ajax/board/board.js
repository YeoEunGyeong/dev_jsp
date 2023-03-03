// 비동기 통신 객체 생성해서 담을 변수 선언
let xhrObject = null;
// 비동기 통신 객체 생성 함수 구현(단, 리턴 예약어가 없어 반환 불가)
function createRequest() {
  // 자바 스크립트에서도 예외 처리 가능
  // null, undefined, "", NaN
  try {
    xhrObject = new XMLHttpRequest();
  } catch (trymicrosoft) {
    try {
      // MS의 IE 사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
} // end createRequest

// span태그가 가지고 있는 텍스트 노드값을 읽어오기
// <td>100</td> 태그 이름이 없으면 속성, 아이디, 클래스 정의 못함 → 접근 불가
// 방안 : 텍스트 노드를 span으로 감싸 아이디를 줌
/* document.querySelector("#id")
document.querySelector(".class")
document.querySelector("태그 이름") */
// const costEl = document.querySelector("#cost"); // 구매가
// const priceEl = document.querySelector("#price"); // 소비자가

function getText(el) {
  let text = ""; // ES6(ECMAScript2015) ; 적용 안 되는 브라우저이면 bable(자바 스크립트 컴파일러) 필요
  // 또는 번들러(작성한 코드를 배포하는 버전에 따라 실제 운영 서버에 올릴 수 있게 변형) parcel(웹팩 - 리액트)
  if (el != null) {
    if (el.childNodes) {
      console.log(el + ", " + el.childNodes.length); // 1 1
      for (let i = 0; i < el.childNodes.length; i++) {
        // costEl, priceEl
        // el.childNodes.length
        // costEl, priceEl
        let childNode = el.childNodes[i];
        // 너 텍스트 노드?
        if (childNode.nodeValue != null) {
          text = text + childNode.nodeValue;
        }
      }
    }
  }
  return text;
}
//기존 TextNode의 값을 다른 문자열로 바꾸기
/***********************************************
	param1 :document.getElementById("boardSold")
	param1 :document.querySelector("#boardSold")
	param2 :xhrObject. 
	************************************************/
function replaceText(el, value) {
  // el = boardSoldEl(보드 판매량), cashEl(마진 계산)
  if (el != null) {
    // sapn
    clearText(el); //기존에 있던 10을 지워주세요.
    //새로운 텍스트 노드 15를 생성하기
    var newNode = document.createTextNode(value); //15
    //위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
    el.appendChild(newNode); // el boardSoldEl > <span>10</span> <span id = boardSole or cash></span> <span>20</span>
  }
}
//기존 태그안에 문자열 지우는 함수 구현
function clearText(el) {
  if (el != null) {
    if (el.childNodes) {
      // 자바 스크립트에서는 0이 아닌 것은 모두 참
      for (let i = 0; i < el.childNodes.length; i++) {
        let childNode = el.childNodes[i];
        el.removeChild(childNode); // 해당 el 삭제 > DOM API ; 직관적이지 않고 유지보수가 어려움
      }
    }
  }
}

function createRequest2() {
  try {
    xhrObject = new XMLHttpRequest(); // constructor
  } catch (trymicrosoft) {
    try {
      //MS의 IE 사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
  return xhrObject;
} // end createRequest
