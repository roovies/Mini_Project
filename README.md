# 💻BankHi Program
> **간단한 계좌 관리 프로그램**
## 📌 요구사항 분석
#### ■구현
1. OOP로 구현할 것
2. MVC패턴으로 구현할 것
3. 보안을 위해 회원정보와 계좌정보를 구분하여 저장할 것
4. 관리자페이지는 인가된 사람만 접근할 수 있도록 할 것
5. 시큐어코딩을 통해 SQLi 취약점을 제거할 것
#### ■기능
* **회원가입**
  - 회원가입 시 선택한 은행에 따라 규격에 맞는 계좌번호를 자동 생성할 것
* **로그인**
  - 패스워드 검증을 통한 로그인을 구현할 것
  - 관리자로 로그인 시 일반회원과 다른 관리자 페이지 세션으로 접근하도록 할 것
  - 로그인 성공/실패 시 로그로 기록할 것
    + Brute-Force/Dictionary/RainbowTable Attack
  - SQLi취약점을 제거할 것
    + PreparedStatement
* **로그아웃**
  - 로그인 후 로그아웃을 통해 메인세션으로 돌아갈 수 있도록 할 것
  - 로그아웃 성공 시 로그로 기록할 것
* **아이디/비밀번호 찾기**
  - 이름과 핸드폰 번호를 기반으로 아이디 또는 비밀번호를 찾을 수 있도록 할 것
* **전체 회원 목록 조회**
  - 관리자만이 전체 회원 정보를 조회할 수 있도록 할 것
  - 목록을 조회할 때마다 로그로 기록할 것
* **내 정보 조회**
  - 로그인 한 자신의 정보만 조회할 수 있도록 할 것
    + 패스워드는 마스킹 처리할 것
    + 주민등록번호 뒷자리를 제외한 생년월일만 보여줄 것
* **송금하기**
  - 현재 자신의 계좌잔액을 보여줄 것
  - 보유한 자산을 넘는 금액을 이체할 수 없도록 할 것
  - 동일 은행 뿐만 아닌 다른 은행으로도 송금할 수 있도록 할 것
  - 수취인의 계좌가 유효한지 검사할 것
  - 만약 수취인의 계좌가 유효하면, 수취인 계좌 정보를 간략히 보여줄 것
  - 계좌 비밀번호 인증을 통해 송금할 수 있도록 할 것
* **회원정보 수정**
  - 관리자 계정은 프로그램 내에서 수정할 수 없도록 할 것
  - 일반회원은 로그인 비밀번호 및 계좌 비밀번호를 수정할 수 있도록 할 것
    + 보안을 위해 현재 패스워드를 한 번 더 확인하도록 할 것
  - 회원정보 수정 시 로그로 기록할 것

## ▶ 동작화면
> **1. 초기 화면**
<img src="https://user-images.githubusercontent.com/119032680/210227934-e1ef88ff-3f0e-4643-8821-07ea63798425.png" width="50%" height="50%">

> **2. 회원가입**
1. **회원가입 성공**
* 회원가입 시 은행만 선택하면 계좌번호는 자동으로 생성
* 회원가입 성공 시 누가 가입에 성공했는지 **IP**와 **ID**를 로그로 기록함 
<img src="https://user-images.githubusercontent.com/119032680/210228994-7b8027fc-8bb3-4560-9cbd-ee55a4af95e7.png" width="50%" height="50%">
<img src="https://user-images.githubusercontent.com/119032680/210229766-827d09b0-b483-4c75-9292-185da020b0ea.png" width="40%" height="40%">

> **3. 로그인**
1. **로그인 실패**
* 패스워드 불일치 시 로그인 실패 메시지와 함께 로그를 기록하며, 초기 화면으로 돌아감
<img src="https://user-images.githubusercontent.com/119032680/210230529-cd5bcbf2-d8fa-4b7f-8df0-ff41d98b2574.png" width="50%" height="50%">

2. **로그인 성공**
* 로그인 성공 메시지와 함께 로그를 기록하며, 관리자인지 일반회원인지 판단한 후 그에 맞는 세션이 생성됨
<img src="https://user-images.githubusercontent.com/119032680/210242708-bec2b9ee-88f4-4e68-a9e3-acf72ea5ff5b.png" width="50%" height="50%">

> **4. 내정보 조회**
* 사용자의 은행이 어딘지 판단하여 사용자 정보와 계좌 정보가 함께 출력됨
* 별도의 성공 메시지를 출력되지 않으나, 로그에 기록함
<img src="https://user-images.githubusercontent.com/119032680/210243205-c9355046-a681-4051-96a2-c330013c73a6.png" width="50%" height="50%">

> **5. 송금하기**

① **잔액 검사**
* 소유한 잔액과 송금액을 비교하여 송금액이 더 클 경우 재입력하게 함
<img src="https://user-images.githubusercontent.com/119032680/210243797-ee2df69a-b6d9-433c-a740-3dfe3880e209.png" width="50%" height="50%">

2. **수취인 계좌 검사**
* 수취인의 계좌번호가 존재하지 않거나, 은행명이 일치하지 않을 경우 송금에 실패
* 수취인의 계좌번호와 은행명이 일치하는 경우 수취인의 계좌정보를 간략하게 출력
* 타 은행으로 송금 가능
<img src="https://user-images.githubusercontent.com/119032680/210244616-7849b0dd-6b39-4c33-b5aa-6426839b0f1b.png" width="50%" height="50%">
<img src="https://user-images.githubusercontent.com/119032680/210244998-14f1db2e-439d-4940-9797-e45d0987c16b.png" width="50%" height="50%">

3. **계좌 비밀번호 인증을 통한 송금완료**
* 계좌 비밀번호가 일치하지 않을 경우 송금에 실패
* 계좌 비밀번호가 일치할 경우 송금에 성공하고 로그에 기록함
<img src="https://user-images.githubusercontent.com/119032680/210245184-3a58f2a0-cc54-4270-b27c-3d19754d435e.png" width="50%" height="50%">
<img src="https://user-images.githubusercontent.com/119032680/210245513-be766612-811e-4e2a-bf48-648a84010fbf.png" width="40%" height="40%">
<img src="https://user-images.githubusercontent.com/119032680/210245970-1d0c87fd-2de5-44ff-9c2c-fd919d9b01c7.png" width="40%" height="40%">
