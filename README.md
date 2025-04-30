## member-payment-project

- `구현 api`
  - 회원 등록
  - 회원 프로필 목록 조회
  - 회원 프로필 조회수 업데이트
  - 포인트 충전
  - 포인트 결제시 할인 쿠폰 사용

이 프로젝트에서 중요하게 생각한 부분입니다.  
우선 이 프로젝트에서 기준은 모놀리식 단일 서버 기준으로 구현했습니다.

- `회원 프로필 목록 조회`
  - 목록 조회시 인덱스 적용을 합니다. (이름순, 조회순, 등록 최신순)

- `회원 프로필 조회수 업데이트`와 `포인트 충전` 동시성 고민
  - `회원 프로필 조회수 업데이트`는 상태 변경 요소가 조회수 업데이트 하나 이므로 Java Lock를 사용하였습니다.
  - `포인트 충전`는 상태 변경 요소가 `충전`과 `사용`, `취소`등 다양하므로 DB Lock을 사용하였습니다.

### 실행 방법
#### Mysql

mysql docker compose 를 실행합니다.

```shell
cd docker

docker compose up -d
```

#### SpringBoot docker 실행

SpringBoot docker 생성 후 docker 실행을 합니다.

```shell
// root project

./gradlew clean build -x test

docker build -t member-payment-project .

docker run -d --name member-payment-api -e USE_PROFILE=prod --network docker_member_payment_test -p 8080:8080 member-payment-project
```

### Gradle 라이브러리 사용 목적
- io.rest-assured:rest-assured:5.4.0
  - 인수 테스트 사용을 위해 적용
- org.springframework.cloud:spring-cloud-starter-openfeign
  - 토스페이먼츠 결제 호출을 위해 적용
- com.googlecode.json-simple:json-simple:1.1.1
  - 토츠페이먼츠 테스트를 위해 적용, json 관련에 사용
- com.github.iamport:iamport-rest-client-java:0.2.23
  - 포트원 PG사를 이용하기 위해 적용
