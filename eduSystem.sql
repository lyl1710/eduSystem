USE [EducationSystem]
GO
/****** Object:  Table [dbo].[Request]    Script Date: 08/12/2021 11:20:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[id] [int] NOT NULL,
	[studentID] [nvarchar](50) NOT NULL,
	[studentName] [nvarchar](50) NOT NULL,
	[id_Department] [int] NOT NULL,
	[dateCreated] [nvarchar](50) NOT NULL,
	[title] [nvarchar](50) NOT NULL,
	[content] [text] NOT NULL,
	[status] [nvarchar](50) NOT NULL,
	[closeDate] [nvarchar](50) NOT NULL,
	[detail] [bit] NOT NULL,
	[solution] [text] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (1, N'1', N'Dao Trong Duy', 1, N'2021-07-26', N'Inquery for PE result', N'I want check my solution PRJ321 subject', N'Reject', N'2021-08-10', 1, N'Send email')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (2, N'2', N'Trinh Van Manh', 1, N'2021-07-26', N'Inquery for PE result', N'I want check my solution PRJ311 subject', N'Approved', N'2021-07-27', 1, N'Send email')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (3, N'3', N'Dinh Sy Kien', 2, N'2021-07-29', N'student authentication', N'I want to made student authentication', N'in progress', N'2021-08-10', 0, NULL)
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (4, N'3', N'Dinh Sy Kien', 2, N'2021-07-26', N'student authentication', N'I want to made student authentication', N'in progress', N'2021-08-10', 0, NULL)
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (5, N'4', N'Pham Van Toan', 3, N'2021-07-27', N'save the semester', N'Because I busy for work next month, so i want to save the semester', N'Approved', N'2021-07-28', 1, N'Send email')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (6, N'5', N'Hoang Thuy Linh', 3, N'2021-07-27', N'Course registration', N'I want to course registration', N'Reject', N'2021-07-28', 1, N'Come to 102L')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (7, N'6', N'Nghiem Quoc Duong', 4, N'2021-07-30', N'change majors', N'I want to change majors', N'Approved', N'2021-07-30', 1, N'Please send application on FAP')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (8, N'6', N'Nghiem Quoc Duong', 5, N'2021-07-30', N'IT support', N'I need IT spport, because my laptop is broken', N'Approved', N'2021-07-30', 1, N'aaaaa')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (9, N'7', N'Le Tien Thang', 6, N'2021-07-28', N'markerting document', N'I need makerting document for exams', N'in progress', N'2021-08-10', 0, NULL)
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (10, N'7', N'Le Tien Thang', 7, N'2021-07-28', N'study document', N'I need study document for exams', N'in progress', N'2021-08-10', 0, NULL)
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (11, N'8', N'Phan Hai Long', 8, N'2021-07-29', N'student card registration', N'I want to made student card registration', N'in progress', N'2021-08-10', 0, NULL)
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (12, N'9', N'Tran Van Nam', 8, N'2021-07-29', N'student card registration', N'I want to made student card registration', N'Approved', N'2021-07-29', 1, N'Send email')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (13, N'9', N'Tran Van Nam', 8, N'2021-07-30', N'IT support', N'My EOS client has problems', N'in progress', N'2021-08-10', 0, NULL)
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (14, N'8', N'Phan Hai Long', 1, N'2021-07-29', N'IT support', N'My EOS client has problem', N'Approved', N'2021-07-29', 1, N'Please come to IT room')
INSERT [dbo].[Request] ([id], [studentID], [studentName], [id_Department], [dateCreated], [title], [content], [status], [closeDate], [detail], [solution]) VALUES (15, N'10', N'Le Thu Hien', 8, N'2021-07-30', N'Change major', N'I want to change my major', N'in progress', N'2021-8-10', 0, NULL)
/****** Object:  Table [dbo].[Department]    Script Date: 08/12/2021 11:20:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Department] ([id], [name]) VALUES (1, N'Department1')
INSERT [dbo].[Department] ([id], [name]) VALUES (2, N'Department2')
INSERT [dbo].[Department] ([id], [name]) VALUES (3, N'Department3')
INSERT [dbo].[Department] ([id], [name]) VALUES (4, N'Department4')
INSERT [dbo].[Department] ([id], [name]) VALUES (5, N'Department5')
INSERT [dbo].[Department] ([id], [name]) VALUES (6, N'Department6')
INSERT [dbo].[Department] ([id], [name]) VALUES (7, N'Department7')
INSERT [dbo].[Department] ([id], [name]) VALUES (8, N'Department8')
/****** Object:  Table [dbo].[Account]    Script Date: 08/12/2021 11:20:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'admin', N'123')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'long123', N'LONG1234')
INSERT [dbo].[Account] ([username], [password]) VALUES (N'longph', N'12345678')
