--===========================================================================================
-- [ȸ�� ���̺� ����]  *���̵� / ��� / �̸� / ���� / �ֹε�Ϲ�ȣ / ����ó / �̸��� / �ּ� / ����� / ���⿩�� / ���� �����ѵ� / �����

--===========================================================================================
CREATE TABLE MEMBER(
    MEMBER_ID VARCHAR2(20) NOT NULL CONSTRAINT PK_MEMBER_ID PRIMARY KEY,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    MEMBER_GENDER VARCHAR2(3) NOT NULL CHECK(MEMBER_GENDER IN('��','��')),
    MEMBER_SSN VARCHAR2(14) NOT NULL,
    MEMBER_PHONE VARCHAR2(13) NOT NULL,
    MEMBER_EMAIL VARCHAR2(30),
    MEMBER_ADDR VARCHAR2(100) NOT NULL,
    MEMBER_BANK VARCHAR2(20) NOT NULL,
    ENROLL_DATE DATE DEFAULT SYSDATE
);

COMMENT ON TABLE MEMBER IS 'ȸ������';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '���̵�';
COMMENT ON COLUMN MEMBER.MEMBER_PW IS '��й�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '�̸�';
COMMENT ON COLUMN MEMBER.MEMBER_GENDER IS '����';
COMMENT ON COLUMN MEMBER.MEMBER_SSN IS '�ֹε�Ϲ�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_PHONE IS '����ó';
COMMENT ON COLUMN MEMBER.MEMBER_EMAIL IS '�̸���';
COMMENT ON COLUMN MEMBER.MEMBER_ADDR IS '�ּ�';
COMMENT ON COLUMN MEMBER.MEMBER_BANK IS '�����';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '������';




--===========================================================================================
-- [���� ���̺� ����]  *�����ڸ� / ���¹�ȣ / �ܾ� / ���⿩�� / ���� �����ѵ� / �����
--===========================================================================================
-- SH����
CREATE TABLE SHBANK(
    SH_ID VARCHAR2(20) NOT NULL CONSTRAINT FK_SH_ID REFERENCES MEMBER(MEMBER_ID),
    SH_NAME VARCHAR2(20) NOT NULL,
    SH_NUM VARCHAR2(14) CONSTRAINT PK_SH_NUM PRIMARY KEY,
    SH_PW VARCHAR2(4) NOT NULL,
    SH_BALANCE NUMBER DEFAULT 0 NOT NULL,
    LOAN_YN VARCHAR2(1) DEFAULT 'Y' NOT NULL CHECK(LOAN_YN IN('Y', 'N')),
    LOAN_MONEY NUMBER DEFAULT 0 NOT NULL,
    LOAN_LIMIT NUMBER DEFAULT 100000000,
    ENROLL_DATE DATE DEFAULT SYSDATE
);
COMMENT ON COLUMN SHBANK.SH_ID IS '���̵�';
COMMENT ON COLUMN SHBANK.SH_NAME IS '�̸�';
COMMENT ON COLUMN SHBANK.SH_NUM IS '���¹�ȣ';
COMMENT ON COLUMN SHBANK.SH_PW IS '��й�ȣ';
COMMENT ON COLUMN SHBANK.SH_BALANCE IS '�ܾ�';
COMMENT ON COLUMN SHBANK.LOAN_YN IS '���Ⱑ�ɿ���';
COMMENT ON COLUMN SHBANK.LOAN_MONEY IS '����ݾ�';
COMMENT ON COLUMN SHBANK.LOAN_LIMIT IS '���������ѵ�';
COMMENT ON COLUMN SHBANK.ENROLL_DATE IS '�����';


--KB����
CREATE TABLE KBBANK(
    KB_ID VARCHAR2(20) NOT NULL CONSTRAINT FK_KB_ID REFERENCES MEMBER(MEMBER_ID),
    KB_NAME VARCHAR2(20) NOT NULL,
    KB_NUM VARCHAR2(14) CONSTRAINT PK_KB_NUM PRIMARY KEY,
    KB_PW VARCHAR2(4) NOT NULL,
    KB_BALANCE NUMBER DEFAULT 0 NOT NULL,
    LOAN_YN VARCHAR2(1) DEFAULT 'Y' NOT NULL CHECK(LOAN_YN IN('Y', 'N')),
    LOAN_MONEY NUMBER DEFAULT 0 NOT NULL,
    LOAN_LIMIT NUMBER DEFAULT 100000000,
    ENROLL_DATE DATE DEFAULT SYSDATE
);
COMMENT ON COLUMN KBBANK.KB_ID IS '���̵�';
COMMENT ON COLUMN KBBANK.KB_NAME IS '�̸�';
COMMENT ON COLUMN KBBANK.KB_NUM IS '���¹�ȣ';
COMMENT ON COLUMN KBBANK.KB_PW IS '��й�ȣ';
COMMENT ON COLUMN KBBANK.KB_BALANCE IS '�ܾ�';
COMMENT ON COLUMN KBBANK.LOAN_YN IS '���Ⱑ�ɿ���';
COMMENT ON COLUMN KBBANK.LOAN_MONEY IS '����ݾ�';
COMMENT ON COLUMN KBBANK.LOAN_LIMIT IS '���������ѵ�';
COMMENT ON COLUMN KBBANK.ENROLL_DATE IS '�����';



--===========================================================================================
-- �׽�Ʈ ������ �߰�
--===========================================================================================
SELECT * FROM MEMBER;
SELECT * FROM SHBANK;
INSERT INTO MEMBER
VALUES('admin', 'admin', '������', '��', '960120-1000700', '010-2345-5577', 'admin@bankhi.co.kr', '����� ������ ������ 12 BANKHi', 'SH����', DEFAULT);
INSERT INTO SHBANK VALUES('admin', '������', '110450573217', '1117', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('kim777', 'kim777', '���Ϻ�', '��', '950430-1267444', '010-3111-2433', 'test01@naver.com', '��⵵ ������ �Ϻ��� 477 3��', 'SH����', DEFAULT);
INSERT INTO SHBANK VALUES('kim777', '���Ϻ�', '110772657355', '1117', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('lee051', 'lee051', '�̹豸', '��', '910430-1048662', '010-8448-3194', 'ball051@naver.com', '����� ������ ������ 153-2', 'SH����', DEFAULT);
INSERT INTO SHBANK VALUES('lee051', '�̹豸', '110477563905', '2233', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('hwang12', 'hwang12', 'Ȳ����', '��', '960126-1071662', '010-6290-4332', 'soccer11@naver.com', '����� ������ ��� 777', 'SH����', DEFAULT);
INSERT INTO SHBANK VALUES('hwang12', 'Ȳ����', '110650321588', '1004', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('yezi27', 'yezi27', '������', '��', '930509-2747518', '010-8443-6902', 'dream22@naver.com', '����� ������ ������ 7-99', 'SH����', DEFAULT);
INSERT INTO SHBANK VALUES('yezi27', '������', '117633152044', '2727', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('green', 'green', '�̱׸�', '��', '950430-2051663', '010-2044-6874', 'greeny@naver.com', '����� �߱� �� 833-5', 'KB����', DEFAULT);
INSERT INTO KBBANK VALUES('green', '�̱׸�', '1002153787428', '2233', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('kwonss', 'kwonss', '�ǻ��', '��', '811104-1055603', '010-1234-8714', 'kwonss@naver.com', '����� ������ ���ﵿ 6-2', 'KB����', DEFAULT);
INSERT INTO KBBANK VALUES('kwonss', '�ǻ��', '1005903444215', '0005', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('shotgun', 'shotgun', '������', '��', '750604-1046422', '010-9963-4504', 'shotgun@naver.com', '����� �߱� ȸ���� 44-5', 'SH����', DEFAULT);
INSERT INTO SHBANK VALUES('shotgun', '������', '110630715320', '5757', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES('minji', 'minji', '�����', '��', '001204-4071023', '010-6671-2020', 'minji@naver.com', '����� ������ ������ 172', 'KB����', DEFAULT);
INSERT INTO KBBANK VALUES('minji', '�����', '1002457854469', '1010', DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);


--===========================================================================================
-- �α� ���̺� ����
--===========================================================================================
CREATE TABLE LOG(
    CONTENT VARCHAR2(200),
    TIME DATE
);

COMMIT;