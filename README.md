# 💻BankHi Program
#### [주제] 간단한 계좌 관리 프로그램
## 📌 요구사항 분석
#### ■구현
1. OOP로 구현할 것
2. MVC패턴으로 구현할 것
3. 보안을 위해 회원정보와 계좌정보를 구분하여 저장할 것
4. 관리자페이지는 인가된 사람만 접근할 수 있도록 할 것
5. 시큐어코딩을 통해 SQLi 취약점을 제거할 것
#### ■기능
* 회원가입
  - 회원가입 시 선택한 은행에 따라 규격에 맞는 계좌번호를 자동 생성할 것
* 로그인
  - 패스워드 검증을 통한 로그인을 구현할 것
  - 관리자로 로그인 시 일반회원과 다른 관리자 페이지 세션으로 접근하도록 할 것
  - 로그인 성공/실패 시 로그로 기록할 것
    + Brute-Force/Dictionary/RainbowTable Attack
  - SQLi취약점을 제거할 것
    + PreparedStatement
* 로그아웃
  - 로그인 후 로그아웃을 통해 메인세션으로 돌아갈 수 있도록 할 것
  - 로그아웃 성공 시 로그로 기록할 것
* 아이디/비밀번호 찾기
  - 이름과 핸드폰 번호를 기반으로 아이디 또는 비밀번호를 찾을 수 있도록 할 것
* 
* 전체 회원 목록 조회
  - 관리자만이 전체 회원 정보를 조회할 수 있도록 할 것
  - 목록을 조회할 때마다 로그로 기록할 것
* 
