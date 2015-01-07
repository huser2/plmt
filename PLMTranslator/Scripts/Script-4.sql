CREATE TABLE "PLMT"."FAILEDJOBS" (
		"CONTAINER" VARCHAR(250),
		"MSGID_PROD" VARCHAR(250),
		"MSGID_SEQ" BIGINT,
		"EXPIRATION" BIGINT,
		"MSG" BLOB(2147483647),
		"PRIORITY" BIGINT,
		"XID" VARCHAR(250),
		"FAILED_ID" INTEGER primary key NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"QUEUE_ID" INTEGER NOT NULL,
		"CREATED_DATE" TIMESTAMP,
		"FAILED_DATE" TIMESTAMP
	);

CREATE TABLE "PLMT"."PLMTYPELIST" (
		"TYPE_ID" VARCHAR(100),
		"TYPE_NAME" VARCHAR(100),
		"PLM_NAME" VARCHAR(100),
		"ID" INTEGER primary key NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1)
	);

CREATE TABLE "PLMT"."COMPLETEDJOBS" (
		"CONTAINER" VARCHAR(250),
		"MSGID_PROD" VARCHAR(250),
		"MSGID_SEQ" BIGINT,
		"EXPIRATION" BIGINT,
		"MSG" BLOB(2147483647),
		"PRIORITY" BIGINT,
		"XID" VARCHAR(250),
		"COMPLETED_ID" INTEGER primary key NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"QUEUE_ID" INTEGER NOT NULL,
		"COMPLETED_DATE" TIMESTAMP,
		"CREATED_DATE" TIMESTAMP
	);

CREATE TABLE "PLMT"."PLMATTRIBUTEMAPPING" (
		"PLM1_TYPE_ID" VARCHAR(100) NOT NULL,
		"PLM1_TYPE_NAME" VARCHAR(100),
		"PLM1_NAME" VARCHAR(100) NOT NULL,
		"PLM1_ATTRIBUTE_ID" VARCHAR(100) NOT NULL,
		"PLM1_ATTRIBUTE_NAME" VARCHAR(100),
		"PLM2_TYPE_ID" VARCHAR(100) NOT NULL,
		"PLM2_TYPE_NAME" VARCHAR(100),
		"PLM2_NAME" VARCHAR(100) NOT NULL,
		"PLM2_ATTRIBUTE_ID" VARCHAR(100) NOT NULL,
		"PLM2_ATTRIBUTE_NAME" VARCHAR(100)
	);

CREATE TABLE "PLMT"."PLM_MAPPING" (
		"WNC_HOSTNAME" VARCHAR(100),
		"WNC_IPADDRESS" VARCHAR(100),
		"WNC_STATUS" VARCHAR(100),
		"PLM" VARCHAR(100) NOT NULL,
		"PLM_HOSTNAME" VARCHAR(100),
		"PLM_IPADDRESS" VARCHAR(100),
		"PLM_STATUS" VARCHAR(100)
	);

CREATE TABLE "PLMT"."PLMATTRIBUTELIST" (
		"ATTRIBUTE_ID" VARCHAR(100),
		"ATTRIBUTE_NAME" VARCHAR(100),
		"PLM_NAME" VARCHAR(100),
		"ID" INTEGER primary key NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1)
	);

CREATE TABLE "PLMT"."QUEUE" (
		"CONTAINER" VARCHAR(250),
		"MSGID_PROD" VARCHAR(250),
		"MSGID_SEQ" BIGINT,
		"EXPIRATION" BIGINT,
		"PRIORITY" BIGINT,
		"XID" VARCHAR(250),
		"MSG" BLOB(2147483647),
		"MSG_ID" VARCHAR(100) NOT NULL,
		"QUEUE_ID" INTEGER primary key NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		"CREATED_DATE" TIMESTAMP,
		"PROCESS_DATE" TIMESTAMP
	);

CREATE INDEX "PLMT"."FAILEDJOBS_CIDX" ON "PLMT"."FAILEDJOBS" ("CONTAINER" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141230115745090" ON "PLMT"."PLM_MAPPING" ("PLM" ASC);

CREATE INDEX "PLMT"."SQL141223130326710" ON "PLMT"."COMPLETEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_PIDX" ON "PLMT"."COMPLETEDJOBS" ("PRIORITY" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_MIDSEQX" ON "PLMT"."COMPLETEDJOBS" ("MSGID_SEQ" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_MIDSEQX" ON "PLMT"."FAILEDJOBS" ("MSGID_SEQ" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_MIDPRODX" ON "PLMT"."COMPLETEDJOBS" ("MSGID_PROD" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141223214738910" ON "PLMT"."FAILEDJOBS" ("FAILED_ID" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL150105132312350" ON "PLMT"."PLMTYPELIST" ("ID" ASC);

CREATE INDEX "PLMT"."QUEUE_MIDSEQX" ON "PLMT"."QUEUE" ("MSGID_SEQ" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL150103133239000" ON "PLMT"."PLMATTRIBUTELIST" ("ID" ASC);

CREATE INDEX "PLMT"."QUEUE_EIDX" ON "PLMT"."QUEUE" ("EXPIRATION" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_PIDX" ON "PLMT"."FAILEDJOBS" ("PRIORITY" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141223214738390" ON "PLMT"."QUEUE" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."QUEUE_PIDX" ON "PLMT"."QUEUE" ("PRIORITY" ASC);

CREATE INDEX "PLMT"."QUEUE_CIDX" ON "PLMT"."QUEUE" ("CONTAINER" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL150106115450110" ON "PLMT"."PLMATTRIBUTEMAPPING" ("PLM1_TYPE_ID" ASC, "PLM1_NAME" ASC, "PLM1_ATTRIBUTE_ID" ASC, "PLM2_NAME" ASC, "PLM2_ATTRIBUTE_ID" ASC, "PLM2_TYPE_ID" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_XIDX" ON "PLMT"."FAILEDJOBS" ("XID" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141223130321451" ON "PLMT"."COMPLETEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_MIDPRODX" ON "PLMT"."FAILEDJOBS" ("MSGID_PROD" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_EIDX" ON "PLMT"."COMPLETEDJOBS" ("EXPIRATION" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_CIDX" ON "PLMT"."COMPLETEDJOBS" ("CONTAINER" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141223130321531" ON "PLMT"."FAILEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."QUEUE_XIDX" ON "PLMT"."QUEUE" ("XID" ASC);

CREATE INDEX "PLMT"."QUEUE_MIDPRODX" ON "PLMT"."QUEUE" ("MSGID_PROD" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141223214738620" ON "PLMT"."COMPLETEDJOBS" ("COMPLETED_ID" ASC);

CREATE INDEX "PLMT"."SQL141223214747930" ON "PLMT"."FAILEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_EIDX" ON "PLMT"."FAILEDJOBS" ("EXPIRATION" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_XIDX" ON "PLMT"."COMPLETEDJOBS" ("XID" ASC);

CREATE INDEX "PLMT"."SQL141223214747780" ON "PLMT"."COMPLETEDJOBS" ("QUEUE_ID" ASC);

ALTER TABLE "PLMT"."PLMATTRIBUTELIST" ADD CONSTRAINT "SQL150103133239000" PRIMARY KEY ("ID");

ALTER TABLE "PLMT"."PLMATTRIBUTEMAPPING" ADD CONSTRAINT "PLMATTRIBUTEMAPPING_PK" PRIMARY KEY ("PLM1_TYPE_ID", "PLM1_NAME", "PLM1_ATTRIBUTE_ID", "PLM2_NAME", "PLM2_ATTRIBUTE_ID", "PLM2_TYPE_ID");

ALTER TABLE "PLMT"."PLMTYPELIST" ADD CONSTRAINT "SQL150105132312350" PRIMARY KEY ("ID");

ALTER TABLE "PLMT"."COMPLETEDJOBS" ADD CONSTRAINT "SQL141223214738620" PRIMARY KEY ("COMPLETED_ID");

ALTER TABLE "PLMT"."QUEUE" ADD CONSTRAINT "SQL141223214738390" PRIMARY KEY ("QUEUE_ID");

ALTER TABLE "PLMT"."PLM_MAPPING" ADD CONSTRAINT "PLM_MAPPING_PK" PRIMARY KEY ("PLM");

ALTER TABLE "PLMT"."FAILEDJOBS" ADD CONSTRAINT "SQL141223214738910" PRIMARY KEY ("FAILED_ID");

ALTER TABLE "PLMT"."FAILEDJOBS" ADD CONSTRAINT "FAILEDJOBS_QUEUE_FK" FOREIGN KEY ("QUEUE_ID")
	REFERENCES "PLMT"."QUEUE" ("QUEUE_ID")
	ON DELETE CASCADE;

ALTER TABLE "PLMT"."COMPLETEDJOBS" ADD CONSTRAINT "COMPLETEDJOBS_QUEUE_FK" FOREIGN KEY ("QUEUE_ID")
	REFERENCES "PLMT"."QUEUE" ("QUEUE_ID")
	ON DELETE CASCADE;