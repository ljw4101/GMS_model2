--***************************
-- 2017.08.02
-- [1]MAJOR_TAB
-- [2]SUBJECT_TAB
-- [3]MEMBER_TAB
-- [4]PROF_TAB
-- [5]STUDENT_TAB
-- [6]GRADE_TAB
-- [7]BOARD_TAB
--***************************
-- 시퀀스가 제일 먼저 생성되어야 한다.
DROP SEQUENCE article_seq;
CREATE SEQUENCE seq
	START WITH 2000
	INCREMENT BY 1
	NOCACHE
	NOCYCLE;
	
select SEQUENCE;
	
--***************************
-- major table
-- 2017.08.02
-- 전공 테이블
-- major_id, title
--***************************
--DDL
create table major(
	major_id VARCHAR2(10),
	title VARCHAR2(10),
	PRIMARY KEY(major_id)
);
--DML
insert into major(major_id, title)values('computer', '컴퓨터');
insert into major(major_id, title)values('economics', '경제학');
insert into major(major_id, title)values('tourism', '관광학');
insert into major(major_id, title)values('art', '미술학');

select * from major;

--***************************
-- subject table
-- 2017.08.02
-- 과목 테이블
-- subj_id, title, major_id
--***************************
--DDL
create table subject(
	subj_id VARCHAR2(10),
	title VARCHAR2(10),
	major_id VARCHAR2(10),
	primary key(subj_id),
	foreign key(major_id) references major(major_id) on delete cascade
);
--DML
insert into subject(subj_id, title)values('java','자바');
insert into subject(subj_id, title)values('c','C언어');
insert into subject(subj_id, title)values('html','HTML');
insert into subject(subj_id, title)values('css','CSS');
insert into subject(subj_id, title)values('javascript','JavaScript');
insert into subject(subj_id, title)values('sql','SQL');

select * from subject;

--***************************
-- Member table
-- 2017.08.02
-- 회원관리 테이블
-- mem_id, name, pw, ssn, regdate
--***************************
--DDL
CREATE TABLE Member(
	id VARCHAR2(10), 
	name VARCHAR2(10),
	pw VARCHAR2(10), 
	ssn VARCHAR2(15), 
	regdate DATE,
	PRIMARY KEY(id)
);

--phone, email, major, subject, profile
ALTER TABLE Member ADD phone VARCHAR2(13);
ALTER TABLE Member ADD email VARCHAR2(30);
ALTER TABLE member ADD profile VARCHAR2(30);

DROP TABLE Member;

--DML
insert into member(id, name, pw, ssn, regdate) values ('hong','gildong','a','920615-234678',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('kang','Danel','1','940101-1234517',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('park','jihun','1','931230-1234527',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('lee','jihun','1','921230-1234537',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('kim','jihun','1','900201-1234547',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('ong','jihun','1','930301-1235567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('ong2','sung','1','930301-1235567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('la','kan','1','931230-2234517',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('jung', 'sehun','1','970101-2224567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('you', 'sunho','1','940620-2235567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('jung2', 'sehun','1','970101-2236567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('jun', 'jihun','1','970615-2234577',SYSDATE);
insert into member(mem_id, name, pw, ssn, regdate, phone, email, major_id, profile) values ('ha','sung','1','680301-1235567',SYSDATE, '010-0000-0001', 'ha@test.com', 'tourism', 'defaultimg.jpg');
insert into member(mem_id, name, pw, ssn, regdate, phone, email, major_id, profile) values ('jang','mimi','1','780301-1235567',SYSDATE, '010-0000-0002', 'jang@test.com', 'art', 'defaultimg.jpg');
insert into member(mem_id, name, pw, ssn, regdate, phone, email, major_id, profile) values ('jeung','tea','1','880301-1235567',SYSDATE, '010-0000-0003', 'jeung@test.com', 'economics', 'defaultimg.jpg');

SELECT * FROM MEMBER;
SELECT count(*) AS count FROM MEMBER;
SELECT * FROM member WHERE id='hong';

update MEMBER set pw='2' where id='hong';
update MEMBER set phone='010-1234-5678';
update member set major_id='computer';
update member set profile='defaultimg.jpg';

delete from MEMBER where id='test';

--***************************
-- Prof table
-- 2017.08.02
-- 교수 테이블
-- mem_id, salary
--***************************
--DDL
CREATE TABLE Prof(
	mem_id VARCHAR2(10),
	salary VARCHAR2(10),
	PRIMARY KEY(mem_id),
	FOREIGN KEY(mem_id) REFERENCES MEMBER(mem_id) ON DELETE CASCADE
);

--DML
insert into PROF(mem_id, salary) values ('kang','10000');
insert into PROF(mem_id, salary) values ('ha','5600');
insert into PROF(mem_id, salary) values ('jang','4800');
insert into PROF(mem_id, salary) values ('jeung','10100');

select m.mem_id, m.NAME, p.SALARY
from prof p, member m
where p.mem_id = m.mem_id;

--***************************
-- student table
-- 2017.08.02
-- 학생 테이블
-- mem_id, stu_no
--***************************
--DDL
CREATE TABLE student(
	mem_id VARCHAR2(10),
	stu_no VARCHAR2(8),
	PRIMARY KEY(mem_id),
	FOREIGN KEY(mem_id) REFERENCES MEMBER(mem_id) ON DELETE CASCADE
);
--DML
insert into STUDENT (mem_id, stu_no) values ('park', '20170001');
insert into STUDENT (mem_id, stu_no) values ('lee', '20170002');
insert into STUDENT (mem_id, stu_no) values ('kim', '20170003');
insert into STUDENT (mem_id, stu_no) values ('ong', '20170004');
insert into STUDENT (mem_id, stu_no) values ('ong2', '20160001');
insert into STUDENT (mem_id, stu_no) values ('la', '20160002');
insert into STUDENT (mem_id, stu_no) values ('jung', '20160003');
insert into STUDENT (mem_id, stu_no) values ('you', '20160004');
insert into STUDENT (mem_id, stu_no) values ('jung2', '20150001');
insert into STUDENT (mem_id, stu_no) values ('jun', '20150002');
insert into STUDENT (mem_id, stu_no) values ('lee3', '20150003');
insert into STUDENT (mem_id, stu_no) values ('hong', '20150004');

select m.mem_id, m.NAME, s.STU_NO, rownum
from STUDENT s, MEMBER m
where s.mem_id=m.mem_id;

--***************************
-- grade table
-- 2017.08.02
-- 성적 테이블
-- grade_seq, score, exam_date, subj_id, id
--***************************
--DDL
create table grade(
	grade_seq NUMBER,
	score VARCHAR2(3),
	exam_date VARCHAR2(12),
	subj_id VARCHAR2(10),
	mem_id VARCHAR2(10), 
	primary key(grade_seq),
	foreign key(mem_id) references MEMBER(mem_id) on delete cascade,
	foreign key(subj_id) references subject(subj_id) on delete cascade
);

--DML
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '90', '2017-03', 'java', 'park');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '70', '2017-04', 'java', 'park');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '66', '2017-05', 'java', 'park');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '85', '2017-06', 'java', 'park');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '100', '2017-03', 'java', 'lee');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '95', '2017-04', 'java', 'lee');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '85', '2017-05', 'java', 'lee');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '85', '2017-06', 'java', 'lee');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '95', '2017-03', 'java', 'kim');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '65', '2017-04', 'java', 'kim');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '66', '2017-05', 'java', 'kim');
insert into grade(grade_seq, score, exam_date, subj_id, mem_id) values (seq.nextval, '85', '2017-06', 'java', 'kim');


--***************************
-- board table
-- 2017.08.02
-- 게시판관리 테이블
-- article_seq, id, title, content, regdate, hitcount
--***************************
--DDL
CREATE TABLE board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	regdate DATE,
	hitcount NUMBER,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES MEMBER(id) ON DELETE CASCADE
);
--DML
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'hong', 'title hong', '반짝이는 이상을 발휘하기 꽃이 말이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'park', 'title park', '얼음과 거선의 원대하고, 새가 작고 운다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'kim', 'title kim', '보는 그들의 일월과 창공에 두손을 눈에 우리 아니다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'jun', 'title jun', '열매를 있는 인간에 새가 옷을 봄바람이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'jung', 'title jung', '청춘이 그들의 철환하였는가 소담스러운 봄바람이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'jung2', 'title jung2', '우리의 이상의 피는 같으며, 속에 우리는 황금시대다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'jung2', 'title jung2', '얼마나 크고 있는 뜨고, 이성은 싹이 대한 만물은 것이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'jun', 'title jun', '풍부하게 얼음에 끝까지 사막이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'la', 'title la', '것은 간에 인생에 피가 약동하다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'kang', 'title kang', '피부가 있을 석가는 투명하되 모래뿐일 뿐이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'ong', 'title ong', '우리 행복스럽고 청춘을 쓸쓸하랴?',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(seq.nextval, 'kang', 'title kang2', '끝까지 그들의 그와 힘차게 자신과 구하지 위하여 황금시대다',0,SYSDATE);

select * from board;

select  m.name, m.ssn
from member m, board b
where m.id = b.id



--***************************
-- member table
-- 2017.08.02
-- 회원 테이블
-- foreign key 추가: 없는 컬럼 추가후 제약조건 추가
--***************************
alter table member add major_id VARCHAR2(10);
alter table member add constraint member_fk_major
foreign key(major_id) references major(major_id);

--***************************
-- member, board, grade  table
-- 2017.08.02
-- 회원, 게시판, 성적 테이블
-- 컬럼명 수정: 외래키로 맺은 해당 컬럼이 들어가 있는 테이블 다 수정필요
--***************************
ALTER TABLE member RENAME COLUMN id TO mem_id;
ALTER TABLE board RENAME COLUMN id TO mem_id;
ALTER TABLE grade RENAME COLUMN id TO mem_id;


--***************************
-- join
-- 2017.08.02
--***************************
select avg(SCORE) from 
(select m.mem_id as id, m.name, mj.title as major, sj.TITLE as subject, g.SCORE, g.EXAM_DATE
  from member m, student s, grade g, subject sj, major mj
 where m.mem_id = s.mem_id
   and m.mem_id = g.MEM_ID
   and sj.MAJOR_ID = mj.MAJOR_ID
   and sj.SUBJ_ID = g.SUBJ_ID
 order by m.mem_id, g.EXAM_DATE
 )t
 where t.id = 'kim';

--mem_id를 입력하면 평균점수를 반환하는 sql
select avg() from (
select m.mem_id as id, m.name, mj.title as major, sj.TITLE as subject, g.SCORE, g.EXAM_DATE
  from member m, student s, grade g, subject sj, major mj
 where m.mem_id = s.mem_id
   and m.mem_id = g.MEM_ID
   and sj.MAJOR_ID = mj.MAJOR_ID
   and sj.SUBJ_ID = g.SUBJ_ID
 order by m.mem_id, g.EXAM_DATE
);


select t.id, avg(t.SCORE) 
from (select m.mem_id as id
           , g.SCORE
      from grade g
        inner join subject sj on sj.SUBJ_ID = g.SUBJ_ID
        inner join member m on m.mem_id = g.MEM_ID
     )t
group by t.id
having avg(t.SCORE) >70
order by avg(t.SCORE) desc
;

--paging처리
select rownum as no, t2.*  
from (
    select t.id, avg(t.SCORE) as avg
    from (select m.mem_id as id
               , g.SCORE
          from grade g
            inner join subject sj on sj.SUBJ_ID = g.SUBJ_ID
            inner join member m on m.mem_id = g.MEM_ID
         )t
    group by t.id
    order by avg(t.SCORE) desc
) t2
where rownum < 11
;

select t.id, avg(t.SCORE) as avg, ROW_NUMBER() OVER(ORDER BY avg(t.SCORE) DESC) rank
    from (select m.mem_id as id
               , g.SCORE
          from grade g
            inner join subject sj on sj.SUBJ_ID = g.SUBJ_ID
            inner join member m on m.mem_id = g.MEM_ID
         )t
    group by t.id
    order by avg(t.SCORE) desc
    ;

select * from (
select m.mem_id as id, m.name, mj.title as major, sj.TITLE as subject, g.SCORE
  from grade g
    inner join member m on m.mem_id= g.mem_id
    inner join student s on s.mem_id = m.mem_id
    inner join subject sj on sj.SUBJ_ID = g.SUBJ_ID
    inner join major mj on sj.MAJOR_ID = mj.MAJOR_ID
  where m.mem_id='park'
order by m.mem_id, g.EXAM_DATE
);



select * 
from member
where mem_id not in (
        select distinct m.mem_id
        from member m, board b
        where m.mem_id = b.mem_id
)
;

select * 
from member m
where NOT EXISTS (
        select 1
        from board b
        where m.mem_id = b.mem_id
)
;

select m.mem_id, m.name, b.title, b.content
from member m,
    (select mem_id, title, content from board
      where mem_id='jung2') b
where m.mem_id = b.mem_id
;