--USE [Client]
USE [NGZ_client_2021]

GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Clients](
	[users_id] int IDENTITY (1,1) PRIMARY KEY NOT NULL,
	[name] [nvarchar](30) NOT NULL,
	[first_name] [nchar](10) NOT NULL,
	[second_name] [nchar](10) NOT NULL,
	[address] [nchar](10) NOT NULL,
	[phone] [nchar](10) NOT NULL,
	[second_contact] [nchar](10) NOT NULL,
	[email] [nvarchar](30) NOT NULL,
	[password] [nvarchar](30) NOT NULL,
	time_stamp date NOT NULL)
GO


CREATE TABLE [dbo].[Issue](
	[report_number] [int] IDENTITY(100,1) NOT NULL PRIMARY KEY,
	[description] [nvarchar](50) NOT NULL,
	[users_id] int NOT NULL,
	[register_timestamp] date NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[contact_phone] [int] NOT NULL,
	[contact_email] [nvarchar](30) NOT NULL,
	[status] [nvarchar](50) NOT NULL,
	[support_user_assigned] [nvarchar](50) NOT NULL
	CONSTRAINT fk_issue_user FOREIGN KEY (users_id) 
	REFERENCES Clients (users_id)
 )
GO

CREATE TABLE [dbo].[Comment](
	[id] [int] NOT NULL PRIMARY KEY IDENTITY(1,1),
	[report_number] [int] NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[comment_timestamp] date NOT NULL
	CONSTRAINT fk_commentIssue FOREIGN KEY (report_number) 
	REFERENCES Issue (report_number) 
)
GO



CREATE TABLE [dbo].[Service](
	[Id] [int] NOT NULL PRIMARY KEY IDENTITY(1,1),
	[Name] [nvarchar](50) NOT NULL,
	[EmailUser] [nvarchar](30) NOT NULL,
	[ReportNumber] [int] NOT NULL
	CONSTRAINT fk_ServiceEmailUser FOREIGN KEY (EmailUser)
	REFERENCES [Clients] (email), 
	CONSTRAINT fk_ServiceReportNumber FOREIGN KEY (ReportNumber)
	REFERENCES Issue (ReportNumber),
) 
GO



