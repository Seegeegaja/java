1_hello_world.js
// 코멘트 작성 영역
console.log("hello world");
/**
 여러줄에 걸처 입력이 가능합니다. 두 곳 모두 수정 가능
 이곳은 주석 영역입니다. 두 곳 모두 수정 가능
*/
console.log("hello","world");


//번수 선언은 
let myName = "장준용";
console.log(myName);


2_variables.js
/**
 * 변수의 사용
 * 1. var : 더이상 사용하지 않는다
 * 2. let : 변수 선언
 * 3. const : 상수 선언
 */

var name = "장준용";
var age = 22;
console.log(age);

let ive = '아이브';
console.log (ive);

let girlGroup;
console.log(girlGroup);
//undefined : 선언은 되었으나 값이 할당되어있지 않은 상태
// 상수는 반드시 값이 할당되어야함 const는 한번 설정되면 값을 바꿀수 없음
const newJeans = '뉴진스';
console.log(newJeans);
newJeans = '뉴우진스';

3_hoisting.js
// 변수 호이스팅
// 모든 선언된 변수가 최상단으로 이동되는 것 같은 현상
// 번수를 선언한 후 --> 할당 개발환경 만들기 위해 --> var 쓰지말자
// var은 오류를 안낸다
console.log(kim);
var kim = '장원영';
console.log(kim);
// let은 선언한 이후에 쓸수있는 아이라고 생각 하면됨
let lee = '이순신';
console.log(lee);

4_data_type.js
/**
 * Number
 * String
 * Boolean
 * undefind
 * null
 * symbol
 * Object(Function, Array, object) : 객체 타입
 */

//Number 할당
const age = 20;
const pi = 3.141592;
console.log(typeof age);
console.log(typeof pi);

//String
const myTest = '코딩 테스트';
console.log(myTest);
//Escape Charater
const iveYukin = '아이브 \n \t 안유진';
console.log(iveYukin);

// Template Literal에서 백틱(`)...
const groupName = '아이브';
let idolName = '장원영';
console.log(groupName + '장원영');
// 템플릿 리터널... 빽틱 안에 넣을때만 %{변수명} 많이 씀 
console.log(`우리의 주인공은 ${groupName}
   그룹의 ${idolName}
    입니다 환영해 주세요`);

5_object_test.js
const colors = {
  red : '빨강색',
  origin : '주황색',
  yellow : '노랑색'
}

console.log(typeof colors);
console.log(colors);
console.log(colors.origin);

let product = {
  name : '콜라',
  price : 500,
  stock : 7,
}

console.log(product);

const iveMember = [
  '안유진',
  '장원영',
  '이서',
  '가을',
]

console.log(iveMember[3]);

6_operators.js
//산술 연산자
console.log(10 + 10);
console.log(7 % 3);

//증감연산자
console.log('=======증감연산자===========');
let number = 1;
number++;
console.log(number);

//간단 타입 변환
console.log('=======간단한 타입 변환===========');
let sampl = '99';
console.log(typeof sampl);
console.log(+sampl);
console.log(typeof + sampl);

//비교 연산자
console.log('==비교 연산자== : 값만 비교');
console.log(3 == 3);
console.log(3 == '3');

console.log('===비교 연산자===');
console.log("값과 타입을 같이 비교");
console.log(3 === 3);
console.log(3 === '3');

//삼항연사자 많이 씀
console.log(10 > 0 ? '10은 0보다 크다.' : '그렇지 않다.');

//논리 연산자(and : && , or : ||) or은 둘중에 하나가 참이면 참을 돌려줌

//단축 평가 - 오지게 많이 씀
console.log('==========================');
console.log(true || '아이브');
console.log(false || '아이브');
console.log(false ? '아이브' : 'true');
console.log(true ? '아이브' : 'true');
console.log('==========================');//true면 뒤에걸 확인하고 출력, false면 fals출력
console.log(false && '뉴진스');
console.log(true && '뉴진스');

console.log(true && true && '아일릿');
console.log(true && false && '아일릿');

console.log('==========================');
let name;
console.log(name);

name = name ?? '장준용';//앞의 값이null이거나 undefind면 뒤에걸 출력
console.log(name);

name = '' && '아이브';//null,0,undefind 은 false로 본다
console.log(name);

//스크립트에서 false로 보는 아이들은
//false, null , 0, undefind, ''(공백)

7_if_and_switch.js
//if 구문
let num = 5;
if (num % 2 === 0) {
  console.log(num + "짝수입니다.");
} else {
  console.log(`${num}는 홀수입니다`);
}

if (num % 2 === 0) {
  console.log(num + "2의 배수입니다.");
} else if (num % 3 === 0) {
  console.log(`${num}는 3배수 입니다`);
} else {
  console.log("모르겠습니다");
}

//switch구문
let number = 1;
switch (number) {
  case 1:
    console.log("홀수");
    break;
  case 2:
    console.log("짝수");
    break;

  default:
    break;
}


group_enter.js
const 하이브 = [
  [
    {
      groupName: '뉴진스',
      name: '하니',
      position: '센터',
      age: 21,
    },
    {
      groupName: '뉴진스',
      name: '민지',
      position: '보컬',
      age: 22,
    },
    {
      groupName: '뉴진스',
      name: '다니엘',
      position: '래퍼',
      age: 23,
    },
  ],
  [
    {
      groupName: '아일릿',
      name: '민주',
      position: '센터',
      age: 30,
    },
    {
      groupName: '아일릿',
      name: '윤아',
      position: '보컬',
      age: 31,
    },

  ]
]
//아일릿의 민주의 이름, 나이를 출력
console.log(하이브[1][0].name);
console.log(하이브[1][0].age);
let groupName = 하이브[1][0].name
let name = 하이브[1][0].name;
let age = 하이브[1][0].age;

console.log(`
  -그룹명 : ${groupName}
  -이름 : ${name} 
  -나이 : ${age}
  `)


//loop돌리기
for(let i=0; i<하이브.length; i++){
  console.log(하이브[i])
}

group_ive.js

const ive = [
  {
    name: '장원영',
    position: '센터',
    age: 21,
  },
  {
    name: '안유진',
    position: '보컬',
    age: 22,
  },
  {
    name: '이서',
    position: '래퍼',
    age: 23,
  },
]
//이서의 이름, 포지션,나이를 출력
let name = ive[2].name;
let position = ive[2].position;
let age = ive[2].age;

console.log(`
  -이름 : ${name} 
  -포지션 : ${position}
  -나이 : ${age}
  `)

console.log(ive[2]);

console.log(ive);

