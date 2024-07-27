/*Creating a new schema and using it*/

CREATE DATABASE new_york;

USE new_york;

/* Origin_data contains details of origination bus stops*/

CREATE TABLE origin_data(
	OriginName VARCHAR(50),
	OriginLat FLOAT,
	OriginLong FLOAT,
	CONSTRAINT origin_data_PK PRIMARY KEY (OriginName)
);

/* destination_data contains details of destination bus stops*/

CREATE TABLE destination_data(
	DestinationName VARCHAR(50),
	DestinationLat FLOAT,
	DestinationLong FLOAT,
	CONSTRAINT destination_data_PK PRIMARY KEY (DestinationName)
);

/*new_york_city_bus is the main table containing data required for business need*/

CREATE TABLE new_york_city_bus(
	RecordID INT,
	DirectionRef BOOLEAN,
	PublishedLineName VARCHAR(10),
	OriginName VARCHAR(50),
	DestinationName VARCHAR(50),
	VehicleRef VARCHAR(20),
	VehicleLocationLatitude FLOAT,
	VehicleLocationLongitude FLOAT,
	NextStopPointName VARCHAR(50),
	ArrivalProximityText VARCHAR(50),
	DistanceFromStop FLOAT,
	ScheduledArrivalTime TIME,
	RecordedDate DATE,
	RecordedTime TIME,
	ExpectedArrDate DATE,
	ExpectedArrTime TIME,
	CONSTRAINT new_york_PK PRIMARY KEY (RecordID),
	CONSTRAINT new_york_FK1 FOREIGN KEY (OriginName) REFERENCES origin_data(OriginName),
	CONSTRAINT new_york_FK2 FOREIGN KEY (DestinationName) REFERENCES destination_data(DestinationName)
);

/*Following commands are used to load the data in the created tables. Data for new_york_city_bus is split into sections to allow easy load of data*/

load data local infile '/root/data/Destinationdata.csv' into table destination_data fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;
load data local infile '/root/data/Origindata.csv' into table origin_data fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;
load data local infile '/root/data/FinalPart1.csv' into table new_york_city_bus fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;load data local infile '/root/data/FinalPart2.csv' into table new_york_city_bus fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;load data local infile '/root/data/FinalPart3.csv' into table new_york_city_bus fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;load data local infile '/root/data/FinalPart4.csv' into table new_york_city_bus fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;load data local infile '/root/data/FinalPart5.csv' into table new_york_city_bus fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;load data local infile '/root/data/FinalPart6.csv' into table new_york_city_bus fields terminated by ',' lines terminated by '\r\n' ignore 1 lines;

GRANT ALL PRIVILEGES ON new_york.* To 'root'@'%' IDENTIFIED BY 'password1';