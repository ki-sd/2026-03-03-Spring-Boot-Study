# <img src="https://flagcdn.com/w20/kr.png" width="20" style="vertical-align: middle;"> JAVA AWS CI/CD 풀스택과정 - SpringBoot<br>
### <img src="https://flagcdn.com/w20/us.png" width="20" style="vertical-align: middle;"> JAVA AWS CI/CD Full-stack Course - SpringBoot<br>
### <img src="https://flagcdn.com/w20/jp.png" width="20" style="vertical-align: middle;"> JAVA AWS CI/CD フルスタック課程 - SpringBoot<br>

<br>
<br>

* **Progress** 
	<p>
		<img src="https://img.shields.io/badge/Progress-15%25-red?style=flat-square" align="absmiddle">
* **Language & Environment** 
	<p>
		<img src="https://img.shields.io/badge/Java_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white" align="absmiddle"> 
		<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black" align="absmiddle">
		<img src="https://img.shields.io/badge/Node.js-339933?style=flat-square&logo=nodedotjs&logoColor=white" align="absmiddle">
		<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white" align="absmiddle"> 
		<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white" align="absmiddle">
* **Framework & Library** 
	<p>
		<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white" align="absmiddle">
		<img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white" align="absmiddle">
		<img src="https://img.shields.io/badge/Vue.js-4FC08D?style=flat-square&logo=vuedotjs&logoColor=white" align="absmiddle"> 
		<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jquery&logoColor=white" align="absmiddle">
* **Network & API** 
	<p>
		<img src="https://img.shields.io/badge/Axios-5A29E4?style=flat-square&logo=axios&logoColor=white" align="absmiddle">
* **DataBase** 
	<p>
		<img src="https://img.shields.io/badge/Oracle_21c-F80000?style=flat-square&logo=oracle&logoColor=white" align="absmiddle">
* **Server** 
	<p>
		<img src="https://img.shields.io/badge/Apache_Tomcat-F8DC75?style=flat-square&logo=apachetomcat&logoColor=black" align="absmiddle">
* **Build Tools** 
	<p>
		<img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white" align="absmiddle">
* **IDE & Tools** 
	<p>
		<img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat-square&logo=eclipseide&logoColor=white" align="absmiddle"> 
		<img src="https://img.shields.io/badge/VS_Code-007ACC?style=flat-square&logo=visualstudiocode&logoColor=white" align="absmiddle"> 
		<img src="https://img.shields.io/badge/SQL_Developer-F80000?style=flat-square&logo=oracle&logoColor=white" align="absmiddle"> 
		<img src="https://img.shields.io/badge/DBeaver-382923?style=flat-square&logo=dbeaver&logoColor=white" align="absmiddle">
		
<br>
<br>

📅 학습 일지 (Study Log / 学習記録)
------------------------------

<br>
자세한 내용: <a href="https://ki-sd.tistory.com/category/Spring-Boot" target="_blank"><img src="https://img.shields.io/badge/Tistory-000000?style=flat-square&logo=tistory&logoColor=white&link=https://ki-sd.tistory.com/"></a>
<br>

#### 2026-07
| 날짜 | 학습 내용 (KR / US / JP) |
| :--- | :--- |
| **07-27** | <ul><li><img src="https://flagcdn.com/w20/kr.png" width="20"> <strong>[Spring Boot 초기 환경 구축]</strong> Spring Boot 프로젝트를 생성하고 필요한 의존성(Dependencies) 라이브러리 세팅을 완료함. 자동 설정(AutoConfiguration) 기반의 컨테이너 구동 방식을 확인함. <br><strong>[View Template 연동 및 테스트]</strong> 기본 데이터 출력과 더불어, 서버 사이드 렌더링(SSR)을 위한 두 가지 뷰 템플릿(JSP, Thymeleaf)을 각각 연동함. 레거시 뷰(JSP)와 모던 템플릿 엔진(Thymeleaf)의 View Resolver 라우팅 및 화면 출력 동작을 대조하여 테스트함.</li><li><img src="https://flagcdn.com/w20/us.png" width="20"> <strong>[Spring Boot Initialization]</strong> Set up a Spring Boot project and configured required dependency libraries. Verified the container startup process based on AutoConfiguration. <br><strong>[View Template Integration]</strong> Tested basic data outputs and integrated two distinct view templates (JSP, Thymeleaf) for Server-Side Rendering (SSR). Compared the View Resolver routing and output mechanics of the legacy JSP approach versus the modern Thymeleaf engine.</li><li><img src="https://flagcdn.com/w20/jp.png" width="20"> <strong>[Spring Bootの初期環境構築]</strong> Spring Bootプロジェクトを作成し、必要な依存ライブラリ(Dependencies)の設定を完了。自動設定(AutoConfiguration)に基づくコンテナ起動方式を確認。<br><strong>[View Templateの連動およびテスト]</strong> 基本的なデータ出力に加え、サーバーサイドレンダリング(SSR)のための2つのビューテンプレート(JSP, Thymeleaf)をそれぞれ連動。レガシービュー(JSP)とモダンテンプレートエンジン(Thymeleaf)のView Resolverルーティングおよび画面出力動作を対照してテスト。</li></ul> |
| **08-03** | <ul><li><img src="https://flagcdn.com/w20/kr.png" width="20"> <strong>[JPA 시퀀스 및 DTO 프로젝션]</strong> `BoardEntity`에 `@SequenceGenerator`와 `@GeneratedValue`를 설정하여 오라클 시퀀스(`jpb_no_seq`)를 매핑함. 또한 `BoardDTO` 인터페이스를 생성하여 네이티브 쿼리 결과를 엔티티가 아닌 DTO로 직접 프로젝션(Projection)받아 포맷팅된 날짜(`dbday`)를 추출함. <br><strong>[JPA 기반 CRUD 및 검증]</strong> `BoardServiceImpl`에서 `findById`로 기존 영속성 객체를 조회하고, 평문 비밀번호가 일치할 때만 `dao.save()`(수정) 또는 `dao.delete()`(삭제)를 수행하도록 비즈니스 로직을 구현함. <br><strong>[Thymeleaf 동적 제어]</strong> `@ModelAttribute`로 요청 폼 데이터를 수집하고, `delete_ok.html` 뷰 등에서 `th:if="${res=='no'}"`와 같은 조건문을 사용하여 컨트롤러 처리 결과에 따라 JavaScript 경고창 출력 및 리다이렉트 흐름을 동적으로 제어함.</li><li><img src="https://flagcdn.com/w20/us.png" width="20"> <strong>[JPA Sequences & DTO Projection]</strong> Mapped Oracle sequences (`jpb_no_seq`) in `BoardEntity` using `@SequenceGenerator` and `@GeneratedValue`. Created a `BoardDTO` interface to project native query results directly into a DTO to extract formatted dates (`dbday`). <br><strong>[JPA-based CRUD & Validation]</strong> Implemented business logic in `BoardServiceImpl` to fetch persistent objects via `findById`, performing `dao.save()` (update) or `dao.delete()` only when passwords match. <br><strong>[Thymeleaf Dynamic Control]</strong> Collected form data using `@ModelAttribute`, and utilized conditional statements like `th:if="${res=='no'}"` in `delete_ok.html` and others to dynamically execute JavaScript alerts or redirections based on processing results[cite: 23].</li><li><img src="https://flagcdn.com/w20/jp.png" width="20"> <strong>[JPAシーケンスとDTOプロジェクション]</strong> `BoardEntity`に`@SequenceGenerator`と`@GeneratedValue`を設定し、Oracleシーケンス（`jpb_no_seq`）をマッピング。また、`BoardDTO`インターフェースを作成し、ネイティブクエリの結果をエンティティではなくDTOに直接プロジェクション（Projection）してフォーマットされた日付（`dbday`）を抽出。<br><strong>[JPA基盤のCRUDと検証]</strong> `BoardServiceImpl`にて`findById`で既存の永続性オブジェクトを取得し、平文パスワードが一致する場合のみ`dao.save()`（修正）または`dao.delete()`（削除）を実行するビジネスロジックを実装。<br><strong>[Thymeleaf動的制御]</strong> `@ModelAttribute`でフォームデータを収集し、`delete_ok.html`ビュー等において`th:if="${res=='no'}"`などの条件文を用いて、処理結果に応じたJavaScriptの警告表示やリダイレクトを動的に制御[cite: 23]。</li></ul> |
| **08-04 (JPA Paging & Docker)** | <ul><li><a href="https://github.com/ki-sd/SpringThymeLeafFirstProject_2.git" target="_blank"><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white"></a></li><li><img src="https://flagcdn.com/w20/kr.png" width="20"> <strong>[JPA Paging & Service]</strong> `PageRequest`와 `Pageable`을 활용하여 페이징 및 정렬 조회 로직을 적용하고, `getTotalPages()`를 활용해 UI 블록 처리용 배열 연산을 서비스 계층에서 구현함. <br><strong>[AOP & Exception]</strong> `FoodAOP`에 `@Around`를 적용하여 모든 컨트롤러의 메서드 실행 시간 추적 로직을 구현하고, `@ControllerAdvice`를 통해 전역 예외 처리(Global Exception Handling) 체계를 구성함. <br><strong>[View & REST]</strong> Thymeleaf의 `#numbers.sequence`와 조건부 클래스 바인딩을 이용해 동적 페이징 UI를 구현함. 동시에 Vue 연동을 위해 `GoodsRestController`를 분리하고 `ResponseEntity` 기반의 JSON 응답을 구성함. <br><strong>[Docker 배포 실습]</strong> Ubuntu 환경에 Docker 엔진을 설치한 뒤, `eclipse-temurin:21-jdk` 베이스의 `Dockerfile`을 작성함. Spring Boot `.jar` 애플리케이션을 도커 이미지로 빌드하고, 개인 Docker Hub 저장소(`kisd09/springboot-app1`)에 Push 하는 컨테이너 배포 과정을 실습함.</li><li><img src="https://flagcdn.com/w20/us.png" width="20"> <strong>[JPA Paging & Service]</strong> Applied paging and sorting logic using `PageRequest` and `Pageable`, and implemented UI block array calculations in the service layer using `getTotalPages()`. <br><strong>[AOP & Exception]</strong> Implemented method execution time tracking for all controllers via `@Around` in `FoodAOP`[cite: 19], and established a global exception handling system using `@ControllerAdvice`[cite: 20]. <br><strong>[View & REST]</strong> Built dynamic pagination UIs using Thymeleaf's `#numbers.sequence` and conditional class binding[cite: 31]. Extracted `GoodsRestController` for Vue integration, providing JSON responses via `ResponseEntity`. <br><strong>[Docker Deployment Practice]</strong> Installed the Docker engine on Ubuntu and created a `Dockerfile` based on `eclipse-temurin:21-jdk`. Built the Spring Boot `.jar` application into a Docker image and pushed it to a personal Docker Hub repository (`kisd09/springboot-app1`)[cite: 32].</li><li><img src="https://flagcdn.com/w20/jp.png" width="20"> <strong>[JPA Paging & Service]</strong> `PageRequest`と`Pageable`を活用してページングおよびソートロジックを適用し、`getTotalPages()`を利用してUIブロック処理用の配列演算をサービス階層で実装[cite: 28, 29]。<br><strong>[AOP & Exception]</strong> `FoodAOP`に`@Around`を適用して全コントローラーのメソッド実行時間を追跡するロジックを実装し[cite: 19]、`@ControllerAdvice`を通じてグローバル例外処理（Global Exception Handling）体系を構築[cite: 20]。<br><strong>[View & REST]</strong> Thymeleafの`#numbers.sequence`と条件付きクラスバインディングを用いて動的なページングUIを実装[cite: 31]。同時にVue連携のため`GoodsRestController`を分離し、`ResponseEntity`基盤のJSON応答を構成[cite: 23]。<br><strong>[Dockerデプロイ実習]</strong> Ubuntu環境にDockerエンジンをインストールした後、`eclipse-temurin:21-jdk`ベースの`Dockerfile`を作成[cite: 32]。Spring Bootの`.jar`アプリケーションをDockerイメージとしてビルドし、個人のDocker Hubリポジトリ（`kisd09/springboot-app1`）にPushするコンテナデプロイ過程を実習[cite: 32]。</li></ul> |