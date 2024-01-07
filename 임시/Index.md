# **1. 인덱스**

<aside>
🍪 사전적 의미

**”색인”**

: 쉽게 찾아볼 수 있도록 일정한 순서에 따라 놓은 목록

</aside>

**Ex.** 책의 맨 앞 목차 또는 맨 뒤 인덱스 부분을 통해 원하는 정보의 위치를 빠르게 찾을 수 있도록 해준다.

### 인덱스를 이메일로 정한 경우

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/596d49f6-b88f-472e-82ab-d0d989b144bb)

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/909cc148-95e5-404c-a457-a24d991983d2)

1. 인덱스가 적용된 대상 :: email 로 정렬된 데이터
2. WHERE 절을 통해 검색

### 즉, DB에서 원하는 데이터를 빠르게 찾기위해서 이용하는 검색성능향상을 위한 자료구조

## 인덱스 특징

- 항상 최신의 정렬 상태를 유지
- 하나의 데이터베이스 객체
- 데이터베이스 크기의 약 10% 정도의 저장공간 필요

# 2. 인덱스 알고리즘

<aside>
🍪 **용어 설명**

”페이지”
→ 데이터가 저장되는 단위 (MySQL 에서는 16kbyte 가 디폴트)

</aside>

## Full Table Scan

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/ecf2b80c-5dad-4e66-a195-cef6b1a36a73)

특정 데이터를 찾기 위해 테이블의 모든 컬럼을 조회하는 경우.

### Full Table Scan 사용하는 이유

- 적용 가능한 **인덱스가 없는** 경우
- 인덱스 **처리 범위**가 **넓은** 경우
- 크기가 **작은 테이블**에 **엑세스**하는 경우

→ **즉, 인덱스를 설정해도 큰 변화가 없는 경우에 사용**

## B-Tree

- 이진 탐색 알고리즘을 사용
- 트리 높이가 같음
- 자식 노드를 2개 이상 가질 수 있음
- 기본 데이터베이스 인덱스 구조

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/1425676d-8d60-482a-bf23-365927ab1daf)

### → 인덱스는 SELECT 에서 성능 향상, INSERT, UPDATE, DELETE 에서는 성능 저하.

## 1. INSERT

 

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/8b2a1675-e2cb-44a3-bc01-883da7ac3998)

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/bb9c40af-6f69-41b8-b701-81a971abe938)

<aside>
🍪 “OOO” 가 삽입될 때, “PPP” 의 이동이 있었지만 페이지 내부에서 작업되었기 때문에 큰 부담은 없다.

</aside>

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/67f5ccd0-a052-4bc5-b95a-b4128b3a8462)

<aside>
🍪 새로운 데이터 “ZZZ”가 삽입될 때, 현재 페이지의 공간이 없기 때문에 삽입할 수 없다.

→ 페이지 분할을 통해 빈 페이지를 확보하고 문제가 있는 페이지의 데이터를 공평하게 나누어서 저장해야한다.

</aside>

### 페이지 분할

- 페이지에 새로운 데이터를 추가할 여유공간이 없어서 페이지에 변화가 발생
- DB가 느려지고 성능에 영향을 준다.

## 2. DELETE

<aside>
🍪 인덱스의 데이터를 실제로 지우기 않고 사용안함 표시를 한다.

</aside>

## 3. UPDATE

일련의 과정

- DELETE
- INSERT

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/8df234c8-9e9f-45f7-9fa8-327888c3fca5)

## 추가 ) B+Tree (MySQL)

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/c13bba7f-7bb5-430d-8cd1-9d4a0c5ba28c)


<aside>
🍪 기존의 B-Tree 구조의 문제점을 해결하기 위해 나온 구조이다. 
리프 노드들 끼리 Linked List 로 이어져 있어서 리프 노드 사이를 탐색이 가능하다는 큰 장점을 가지고 있다.

</aside>

# 3. 인덱스 종류

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/2087f6a9-1128-4ceb-b50d-02ff0e955bff)


.

.

.

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/29bbda3a-b6a8-4d84-a5cb-8ac5dfcf23b1)

→ 인덱스 2개

## 1. 클러스터링 인덱스

<aside>
🍪 실제 데이터와 같은 무리의 인덱스

조건 : NOT NULL, UNIQUE 조건이 만족해야 클러스터링 인덱스에 해당

</aside>

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/e77bc708-a9d3-436f-97a7-139366eef13c)


- 실제 데이터 자체가 정렬
- 테이블당 1개만 존재 가능
- 리프 페이지가 데이터 페이지
- 조건 :  NOT NULL, UNIQUE or Primary Key

## 2. 논-클러스터링 인덱스

<aside>
🍪 실제 데이터와 다른 무리의 별도의 인덱스

조건 : UNIQUE or 인덱스를 직접 생성하는 방법

리프 페이지 (데이터 페이지)는 변경되지 않는다.

별도의 인덱스 페이지를 추가하여 리프 페이지를 생성한다.
{ 도리 → 1002 페이지의 3번째 컬럼 }

</aside>

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/e05257df-338a-4097-a11d-87424b4d3b00)

- 실제 데이터 페이지는 그대로
- 별도의 인덱스 페이지 생성 → 추가 공간 필요
- 테이블당 여러 개 존재
- 리프 페이지에 실제 데이터 페이지 주소를 담고 있음
- unique 제약조건 적용시 자동 생성
- 직접 index 생성시 논-클러스터링 인덱스 생성

## 3. 클러스터링 + 논 클러스터링

![image](https://github.com/ssafy-nice-guys-cs-study/discussions/assets/96599232/cdf00aad-14f0-422f-84b3-1fc2d28df475)

- 리프 페이지에 실제 데이터 페이지 주소 → **클러스터링 인덱스가 적용된 컬럼의 실제 값**
    - 데이터가 바뀌고 인덱스가 수정되어야 할 때, 페이지 주소도 계속 바꿔주어야 하기 때문.

# 4. 인덱스 적용 기준

<aside>
🍪 **카디널리티가 높은 것 == 중복 수치가 낮은 것**

</aside>

# 5. 인덱스 사용시 주의사항

### 1. 잘 활용되지 않는 인덱스는 과감히 제거

### 2. 데이터 중복도가 높은 컬럼은 인덱스 효과가 적음

### 3. 자주 사용되더라도 INSERT, UPDATE, DELETE 가 자주 일어나는지 고려