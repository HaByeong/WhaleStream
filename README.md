# WhaleStream
김병하의 개인 장기 프로젝트
# 🐋 Whale Stream - 가상 매매 모의 투자 시스템
![WhaleStreamLogo](https://github.com/user-attachments/assets/b1d45a27-4979-4ab1-a04d-428e41efac98)
> **“고래처럼, 시장을 유영하듯.”**

> WhaleStream은 시장의 흐름을 이해하고 나만의 전략을 실험해볼 수 있는, 가상 모의 투자 플랫폼입니다.

---

## 1. 프로젝트 소개

저는 고래를 좋아합니다.

거대한 몸집을 지녔지만 유연하게 바다를 유영하는 고래는, 저마다의 이유로 수천 킬로미터를 이동하며 긴 여정을 이어갑니다.

그 모습은 자유로움과 깊이, 그리고 끝까지 나아가는 인내를 떠올리게 합니다.

저는 주식 시장도 좋아합니다.

단기적으로는 예측할 수 없는 파동 속에서도, 그 흐름 뒤에는 기업의 성과와 경제의 맥박, 투자자의 심리가 복잡하게 얽혀 있습니다.

그 움직임은 마치, 바다의 변화에 따라 방향을 바꾸고 목적을 가진채 바다를 항해하는 고래와도 같습니다.

- *주식 시장의 복합적인 흐름과 고래의 목적 있는 유영은 닮아 있습니다.*

WhaleStream은 그런 시장을 이해하고, 스스로의 여정을 설계하려는 투자자에게

- *작은 나침반이 되고자* 만들어졌습니다.
---

## 2. 핵심 기능
| 카테고리             | 주요 기능 |
|----------------------|-----------|
| 회원 시스템          | JWT + Spring Security 기반 로그인/회원가입 |
| 실시간 시세 조회      | C++ API 수신 → Redis → WebSocket으로 실시간 전달 |
| 가상 매매 시스템      | 시장가/지정가 주문 → 체결 → 잔고/보유 종목 반영 |
| 전략 분석 & 백테스트 | MA, RSI 등 전략 실행 및 수익률 분석 |
| 분석 리포트 도구     | 전략 결과 요약, 시각화, 리포트 출력 |
| 확장 목표            | 자동매매, GPT 연동 및 AI 전략 설명, UI 고도화 등 |
---

## 3. 기술 스택
| 영역            | 사용 기술 |
|-----------------|-----------|
| Backend         | Java, Spring Boot, Spring Security, JPA |
| Database        | MongoDB, Redis (Pub/Sub 처리 포함) |
| 실시간 수신     | C++ API → Redis Publisher → Spring WebSocket |
| 전략 분석       | Python (Pandas, Backtrader) 또는 Java |
| Frontend        | 미정(Vue 또는 React 예정) |
---

## 4. 기술 아키텍처 다이어그램
<img width="500" alt="다이어그램" src="https://github.com/user-attachments/assets/f3635ce1-fe61-4a2d-b6cd-7116607ed431" />

---

## 5. 시스템 구조 (실시간 흐름 예시)

```plaintext
[C++ 주가 수신 모듈]

└ 실시간 주가 수신

└ JSON 변환 → Redis 채널에 발행 (Publisher)

↓

[Spring Boot 서버]

└ Redis 구독 (Subscriber)

└ 수신된 데이터를 WebSocket으로 사용자에게 전송

└ 사용자 보유 종목 및 잔고 실시간 반영
```
---

### 6. 📅 개발 로드맵

| **기간**     | **개발 목표**                                     |
|--------------|--------------------------------------------------|
| 1~2개월      | Spring API 구축, JWT 로그인 구현                 |
| 3~4개월      | C++ → Redis → WebSocket 실시간 흐름 완성         |
| 5~7개월      | 주문/체결/자산 반영 로직 구현                    |
| 8~10개월     | 전략 분석 + 백테스트 시스템 구축                 |
| 11~12개월    | 전체 통합 + 확장                                 |
---

### 7. 🔄 진행 상황

**✔️ 2025년 5월 중 개발 시작 예정이며, 진행 상황은 순차적으로 업데이트될 예정입니다.**



