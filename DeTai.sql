create database CNPM
go
use CNPM
go
-- ----------------------------
-- Table structure for HoiDong
-- ----------------------------
DROP TABLE IF EXISTS [HoiDong];
CREATE TABLE [HoiDong]  (
  [maHoiDong] varchar(255) NOT NULL,
  [tenHoiDong] varchar(255) NOT NULL,
  PRIMARY KEY ([maHoiDong]) 
)
go
-- ----------------------------
-- Table structure for LoaiDeTai
-- ----------------------------
DROP TABLE IF EXISTS [LoaiDeTai];
CREATE TABLE [LoaiDeTai]  (
  [maLoaiDeTai] varchar(255) NOT NULL,
  [tenLoaiDeTai] nvarchar(255) ,
  [hocKy] nvarchar(255),
  [nam] varchar(255),
  PRIMARY KEY ([maLoaiDeTai]),
) 
go
-- ----------------------------
-- Table structure for Nganh
-- ----------------------------
DROP TABLE IF EXISTS [Nganh];
CREATE TABLE [Nganh]  (
  [maNganh] varchar(255) NOT NULL,
  [tenNganh] nvarchar(255) ,
  PRIMARY KEY ([maNganh]),

) 
go
-- ----------------------------
-- Table structure for TaiKhoan
-- ----------------------------
--DROP TABLE IF EXISTS [TaiKhoan];
--CREATE TABLE [TaiKhoan]  (
--  [maTaiKhoan] varchar(255) NOT NULL,
--  [Role] varchar(255) NULL,
--  [email] varchar(255) NULL,
--  [password] varchar(255) NULL,
--  PRIMARY KEY ([maTaiKhoan])
--)
--go
-- ----------------------------
-- Table structure for Users
-- ----------------------------
DROP TABLE IF EXISTS [Users];
CREATE TABLE [Users]  (
  [Id] varchar(255) NOT NULL,
  [maNganh] varchar(255) NULL,
  [password] varchar(255) NULL,
  [fullname] nvarchar(255) NULL,
  [email] varchar(255) NULL,
  [birthday] datetime NULL,
  [schoolyear] varchar(255) NULL,
  [phone] varchar(255) NULL,
  [role] varchar(255) NULL,
  [maHoiDong] varchar(255) NULL,
  [address] nvarchar(255) NULL,
  PRIMARY KEY ([Id]),
  FOREIGN KEY ([maHoiDong]) REFERENCES [HoiDong] ([mahoidong]),
  FOREIGN KEY ([maNganh]) REFERENCES [Nganh] ([manganh])
)
go
-- ----------------------------
DROP TABLE IF EXISTS [DeTai];
CREATE TABLE [DeTai]  (
  [maDeTai] varchar(255) NOT NULL,
  [loaiDeTai] varchar(255) NULL,
  [maNganh] varchar(255) NULL,
  [gvHuongDan] varchar(255) NULL,
  [gvPhanBien] varchar(255) NULL,
  [maSinhVien] varchar(255) NULL,
  [maHoiDong] varchar(255) NULL,
  PRIMARY KEY ([maDeTai]),
  FOREIGN KEY ([maHoiDong]) REFERENCES [HoiDong]([maHoiDong]),
  FOREIGN KEY ([maNganh]) REFERENCES [Nganh]([manganh]),
  FOREIGN KEY ([loaiDeTai]) REFERENCES [LoaiDeTai]([maLoaiDeTai]),
  CONSTRAINT fk_gvHuongDan  FOREIGN KEY ([gvHuongDan]) REFERENCES [Users]([Id]),
  CONSTRAINT fk_gvPhanBien FOREIGN KEY ([gvPhanBien]) REFERENCES [Users]([Id]),
  CONSTRAINT fk_maSinhVien FOREIGN KEY ([maSinhVien]) REFERENCES [Users]([Id]),
) 
go
--drop database CNPM