- 고유의 player 가 존재
- txt 파일에서 이름과 요일 형식으로 되어 있음
- 선수 클래스 존재
  - 점수
  - 등급 (ENUM 설정)
  - 등급 판정 로직 (공통)
  - 탈락 후보 선정 로직 (공통)

처음 세팅 MAP<이름, PLAYER클래스>

ScorePerson
- 이름
- dayCount map
- grade
- totalCount

ScoreCalculator
- 요일별로 계산 로직 인자는 ScorePerson 클래스

GradeEvaluator
- Grade
  - 등급
  - 최소 점수
- 생성 시 Grade 초기화
- Grade 추가 로직 필요
- Grade 계산 로직

FileProcess
 - 파일을 읽어서 이름 ScorePerson 만드는 로직 필요
