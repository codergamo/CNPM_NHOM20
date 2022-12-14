
Go 
Create Database DangKyDeTai;

Go
Use DangKyDeTai;

Go
Create Table Account(
	username varchar(100) primary key,
	password varchar(50),
	role int default 1 --1 sinh vien, 2 giao vien , 3 admin
)

Go
CREATE TABLE Majors(
    majorId INT IDENTITY(1,1) primary key,
    majorName NVARCHAR(32) NOT NULL UNIQUE,
)

Go
CREATE TABLE Students(
    studentId INT IDENTITY(1,1) primary key,
    studentName NVARCHAR(100),
    gender BIT ,
    birth DATE ,
    email VARCHAR(100) UNIQUE references Account(username),
    phone VARCHAR(11),
    address NVARCHAR(510),
	majorId INT references Majors(majorId)
)

Go
-- Giảng viên
CREATE TABLE Teachers(
	teacherId INT IDENTITY(1,1) primary key,
    teacherName NVARCHAR(32),
    gender BIT,
    birth DATE,
    email VARCHAR(100)UNIQUE references Account(username),
    phone VARCHAR(11),
	majorId INT references Majors(majorId)
)

GO
CREATE TABLE Admins(
    adminId INT IDENTITY(1,1) primary key,
    adminName NVARCHAR(32) ,
    gender BIT,
    birth DATE ,
    email VARCHAR(100) UNIQUE references  Account(username) ,
    phone VARCHAR(11)

)

Go
-- Đề tài
CREATE TABLE Topic(
    topicId INT IDENTITY(1,1) primary key,
    topicName NVARCHAR(50) NOT NULL UNIQUE,
	teacherId INT References Teachers(teacherId),
    detail NVARCHAR(500)
    
)

Go
Create Table TopicDetails(
	id Int  IDENTITY(1,1) primary key,
	topicId INT References Topic(topicId),
	studentId INT References Students(studentId),
	leader Bit,
	Scores Float -- Điểm số nhận được
)

-- Hội đồng
Go
Create table Council(
	id Int  IDENTITY(1,1) primary key,
	topicId INT References Topic(topicId),
	AverageScore Float
)

Go
Create table CouncilDetails(
	id Int  IDENTITY(1,1) primary key,
	CouncilId INT References Council(id),
	teacherId INT References Teachers(teacherId),
	leader Bit,
	Scores Float -- Điểm số từng giáo viên chấm
)

Go
--Tạo đợt đăng ký truy vấn bằng startTime và endTime
CREATE TABLE SignUp(
    signUpId INT IDENTITY(1,1) primary key,
    startTime DATETIME NOT NULL,
    endTime DATETIME NOT NULL,
    role bit Not Null -- 0 giáo viên 1 sinh viên
)
GO
