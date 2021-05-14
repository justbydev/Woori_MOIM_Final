# 모임 결제 서비스

## 1. 간단한 설명
본 어플리케이션은 우리은행 온택트 해커톤(Digital 금융을 선도할 혁신적인 서비스) 예선 통과 후 본선 제출을 위해 개발된 모임 결제를 효율적으로 도와주는 어플리케이션입니다.

## 2. 서비스 요약
어플리케이션 이름은 "MOIM:모임" 으로써, 등록된 카드 정보를 통해 만들어진 바코드를 활용하여 결제 즉시 모임의 효율적인 1/n 계산을 돕고, 소비 패턴 분석을 통해 적합한 모임활동 및 상품을 추천하는 '모임 결제 앱 서비스' 입니다.

## 3. 서비스 설명
1) 결제
+ 먼저 모임을 결성합니다.
+ 결성된 모임의 모임원들은 각자의 카드 정보를 저장하고 카드 정보는 암호화되어 저장됩니다.
+ 또한, 모임 구성원들은 각자 계좌 번호도 등록하고 이 역시 암호화되어 저장되고 우리은행 계좌실명 api를 사용합니다.
+ 결제 시에는 결제 항목 카테고리, 정산 인원을 선택하고 대표자가 바코드를 통해 계산을 합니다.
+ 계산을 마치면 모임원들에게 1/n 된 결제 금액과 대표자 계좌 번호를 푸시 알람을 통해서 알립니다.
+ 푸시 알람을 클릭하면 바로 대표자의 계좌로 돈을 송금할 수 있는 페이지로 넘어가게 됩니다.
+ 이때 이체 시에는 우리은행 이체 api를 사용합니다.

2) 결제 내역
+ 소비 내역은 모두 기록되며 월별로 확인할 수 있습니다.
+ 모임의 모든 구성원들이 투명하게 확인할 수 있도록 합니다.
+ 소비 내역별 카테고리를 변경할 수 있고 만약 미납 금액이 있다면 대표자는 바로 미납 금액 이체 요청을 보낼 수 있습니다.

3) 소비패턴분석
+ 소비 내역은 모두 기록되어 시각화하여 보여줍니다.
+ 월별 소비 세부 항목, 모임의 월별 총 소비액, 모임 속 나의 월별 총 소비액, 모임 카테고리별 다음달 예측 소비액을 보여줍니다.
+ 월별 소비 세부 항목은 파이차트를 통해서 보여주고 나머지 항목은 막대 그래프로 보여줍니다.
+ 모임 카테고리별 다음달 예측 소비액은 회귀 기법을 통해 예측합니다.
+ 결제 내역에서 카테고리 변경 시 자동 분류를 통하여 보여주게 됩니다.

4) 추천
+ 카테고리별 관련된 혜택 카드 목록을 보여줍니다.
+ 모임 소비 중 가장 많은 카테고리에 해당하는 상품을 보여줍니다.

## 4. 개발 언어 및 환경
+ 안드로이드: 안드로이드 스튜디오/JAVA
+ 이미지: Glide
+ 파이 차트: MPAndroidChart Opensource
+ 막대 그래프: eazegraph Opensource
+ 바코드 생성: zxing Opensource
+ API: 우리은행 계좌실명 api, 계좌이체 api
+ 서버: 파이어베이스
+ 푸시 알림: FCM, Notification
+ FCM 및 api 통신: Retrofit2

## 5. 어플리케이션 버전
+ compileSkdVersion 30
+ minSdkVersion 24
+ targetSdkVersion 30

## 6. Dependencies
+ Firebase-database 19.7.0
+ Firebase-messaging 21.1.0
+ Retrofit2: 2.6.0
+ Converter-gson: 2.6.2
+ Glide: 4.12.0
+ MPAndroidChart v3.1.0
+ Eazegraph: 1.2.2@aar
+ Zxing 4.2.0

## 7. Permissions
+ android.permission.INTERNET

## 8. 역할 및 개발 기능
+ 기본적으로 안드로이드 어플리케이션 개발
+ 결제 바코드 생성-Zxing을 통해 카드 번호 사용 바코드 생성
+ 이체 요청 푸시 알람 보내기-FCM, PendingIntent, Notification 사용
+ 결제 목록 보여주기-Recyclerview 사용, notifyDataSetChanged() 사용하여 월별 교체
+ 미납 금액 이체 요청-FCM, PendingIntent, Notification 사용
+ 소비 패턴 분석 기능 개발-MPAndroidChart, eazegrpah 사용하여 시각화 제공, 자동 분류 개발
+ 다음달 예측 소비액 회귀 모델 개발-1차 선형 회귀 모델 활용(Y=W0+W1*X), analytical solution 사용
+ 월별 소비 세부 항목 달, 소비항목 선택-custom AlertDialog, View.inflate() 사용

## 9. 앱 이미지
![캡처](https://user-images.githubusercontent.com/17876424/118261246-40f5d180-b4ee-11eb-9ebb-7de743c8cff9.PNG)
![캡처](https://user-images.githubusercontent.com/17876424/118261529-a3e76880-b4ee-11eb-90a7-eab1ddfec8c5.PNG)
