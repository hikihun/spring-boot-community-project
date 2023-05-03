# 📋 커뮤니티 프로젝트
사용자들과 소통할 수 있는 게시판 서비스입니다.

#

# 프로젝트 구조
![프로젝트 구조](https://user-images.githubusercontent.com/122556674/235897543-5cbd607c-f650-4b0d-a268-fec0c125fffd.jpg)

# ERD
![erd](https://user-images.githubusercontent.com/122556674/235897812-85d6e20a-e079-48fe-9b87-8e7a8a1e2b1b.jpg)


# 프로젝트 기능 및 설계
  - 회원가입
    - 사용자는 회원가입을 할 수 있다. 일반적으로 모든 사용자는 회원가입시 USER 권한을 지닌다.
    - 회원가입시 이메일, 이름, 패스워드를 입력받고, 이메일은 unique 해야한다.
    - 동일한 이메일이 존재할 경우 에러가 발생한다.
    - 회원가입시 입력한 이메일로 인증이 완료되면 회원가입을 완료한다.
    - 이메일 인증은 제한 시간내에 완료 해야한다.
  

  - 로그인 기능
    - 사용자는 로그인을 할 수 있다. 로그인시 회원가입에 사용한 이메일과 패스워드가 일치 해야한다.
    - OAuth2.0을 이용하여 구글 및 다른 소셜 계정으로 로그인을 할 수 있다.
    - 로그인 성공시 jwt 토큰을 발행하고, 토큰 만료시 refresh token을 발급한다.


  - 카테고리(게시판) 추가 기능
    - 어드민 권한을 가진 사용자는 카테고리를 추가할 수 있다.
    

  - 게시글 작성 기능
    - 로그인한 사용자는 권한에 관계없이 글을 작성할 수 있다.
    - 입력값은 카테고리와 제목, 내용을 받고, 이미지를 추가할 수 있다.
    

  - 게시글 목록 조회 기능
    - 로그인하지 않은 사용자를 포함한 모든 사용자는 게시글을 조회 할 수 있다.
    - 게시글은 카테고리별로 조회할 수 있다.
    - 게시글은 최신순으로 기본 정렬 되며, 댓글수 순, 추천수 순으로도 정렬이 가능하다.
    - 게시글 목록 조회시 응답에는 게시글 제목과 작성일, 댓글 수, 추천 수 등의 정보가 필요하다.
    - 게시글은 종류가 많을 수 있으므로 paging 처리를 한다.
    

  - 특정 게시글 조회 기능
    - 로그인하지 않은 사용자를 포함한 모든 사용자는 게시글을 조회할 수 있다.
    

  - 특정 게시글 수정/삭제 기능
    - 게시글 작성자는 해당 게시글에 대한 수정/삭제를 할 수 있다.
  

  - 댓글 목록 조회 기능
    - 특정 게시글 조회시 댓글 목록도 함께 조회한다.
    - 댓글을 최신순으로만 정렬되며, paging 처리를 한다.
  

  - 댓글 작성 기능
    - 로그인한 사용자는 권한에 관계없이 댓글을 작성할 수 있다.
    

  - 댓글 수정/삭제 기능
    - 댓글 작성자는 해당 댓글에 대한 수정/삭제를 할 수 있다.
    

  - 대댓글 작성 기능
    - 로그인한 사용자는 권한에 관계없이 특정 댓글에 대한 응답을 작성할 수 있다.
  

  - 대댓글 수정/삭제 기능
    - 작성자는 해당 댓글에 대한 수정/삭제를 할 수 있다.
    

  - 게시물 검색 기능
    - 로그인하지 않은 사용자를 포함한 모든 사용자는 게시글을 검색 할 수 있다.
  


# Trouble Shooting
[go to the trouble shooting section](doc/TROUBLE_SHOOTING.md)

# Tech Stack
  <div align=center>
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
    <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
    <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
    <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"> 
  </div>
  
