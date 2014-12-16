--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "PLMT"."COMPLETEDJOBS" DROP CONSTRAINT "COMPLETEDJOBS_QUEUE_FK";

ALTER TABLE "PLMT"."FAILEDJOBS" DROP CONSTRAINT "FAILEDJOBS_QUEUE_FK";

ALTER TABLE "PLMT"."COMPLETEDJOBS" DROP CONSTRAINT "SQL141216125449340";

ALTER TABLE "PLMT"."FAILEDJOBS" DROP CONSTRAINT "SQL141216125445000";

ALTER TABLE "PLMT"."QUEUE" DROP CONSTRAINT "SQL141216125440030";

DROP INDEX "PLMT"."FAILEDJOBS_MIDPRODX";

DROP INDEX "PLMT"."SQL141216125731580";

DROP INDEX "PLMT"."QUEUE_EIDX";

DROP INDEX "PLMT"."QUEUE_CIDX";

DROP INDEX "PLMT"."QUEUE_MIDPRODX";

DROP INDEX "PLMT"."COMPLETEDJOBS_MIDSEQX";

DROP INDEX "PLMT"."COMPLETEDJOBS_XIDX";

DROP INDEX "PLMT"."QUEUE_XIDX";

DROP INDEX "PLMT"."SQL141216125445000";

DROP INDEX "PLMT"."FAILEDJOBS_XIDX";

DROP INDEX "PLMT"."COMPLETEDJOBS_EIDX";

DROP INDEX "PLMT"."COMPLETEDJOBS_CIDX";

DROP INDEX "PLMT"."SQL141216125744400";

DROP INDEX "PLMT"."FAILEDJOBS_CIDX";

DROP INDEX "PLMT"."FAILEDJOBS_MIDSEQX";

DROP INDEX "PLMT"."FAILEDJOBS_EIDX";

DROP INDEX "PLMT"."FAILEDJOBS_PIDX";

DROP INDEX "PLMT"."SQL141216125449340";

DROP INDEX "PLMT"."COMPLETEDJOBS_PIDX";

DROP INDEX "PLMT"."QUEUE_MIDSEQX";

DROP INDEX "PLMT"."SQL141216125440030";

DROP INDEX "PLMT"."QUEUE_PIDX";

DROP INDEX "PLMT"."COMPLETEDJOBS_MIDPRODX";

DROP TABLE "PLMT"."FAILEDJOBS";

DROP TABLE "PLMT"."QUEUE";

DROP TABLE "PLMT"."COMPLETEDJOBS";

CREATE TABLE "PLMT"."FAILEDJOBS" (
		"CONTAINER" VARCHAR(250),
		"MSGID_PROD" VARCHAR(250),
		"MSGID_SEQ" BIGINT,
		"EXPIRATION" BIGINT,
		"MSG" BLOB(2147483647),
		"PRIORITY" BIGINT,
		"XID" VARCHAR(250),
		"ID" VARCHAR(100) NOT NULL,
		"QUEUE_ID" INTEGER NOT NULL
	);

CREATE TABLE "PLMT"."QUEUE" (
		"CONTAINER" VARCHAR(250),
		"MSGID_PROD" VARCHAR(250),
		"MSGID_SEQ" BIGINT,
		"EXPIRATION" BIGINT,
		"PRIORITY" BIGINT,
		"XID" VARCHAR(250),
		"MSG" BLOB(2147483647),
		"ID" VARCHAR(100) NOT NULL,
		"QUEUE_ID" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
		);

CREATE TABLE "PLMT"."COMPLETEDJOBS" (
		"CONTAINER" VARCHAR(250),
		"MSGID_PROD" VARCHAR(250),
		"MSGID_SEQ" BIGINT,
		"EXPIRATION" BIGINT,
		"MSG" BLOB(2147483647),
		"PRIORITY" BIGINT,
		"XID" VARCHAR(250),
		"ID" VARCHAR(100) NOT NULL,
		"QUEUE_ID" INTEGER NOT NULL
	);

CREATE INDEX "PLMT"."FAILEDJOBS_MIDPRODX" ON "PLMT"."FAILEDJOBS" ("MSGID_PROD" ASC);

CREATE INDEX "PLMT"."SQL141216125731580" ON "PLMT"."COMPLETEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."QUEUE_EIDX" ON "PLMT"."QUEUE" ("EXPIRATION" ASC);

CREATE INDEX "PLMT"."QUEUE_CIDX" ON "PLMT"."QUEUE" ("CONTAINER" ASC);

CREATE INDEX "PLMT"."QUEUE_MIDPRODX" ON "PLMT"."QUEUE" ("MSGID_PROD" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_MIDSEQX" ON "PLMT"."COMPLETEDJOBS" ("MSGID_SEQ" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_XIDX" ON "PLMT"."COMPLETEDJOBS" ("XID" ASC);

CREATE INDEX "PLMT"."QUEUE_XIDX" ON "PLMT"."QUEUE" ("XID" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141216125445000" ON "PLMT"."FAILEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_XIDX" ON "PLMT"."FAILEDJOBS" ("XID" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_EIDX" ON "PLMT"."COMPLETEDJOBS" ("EXPIRATION" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_CIDX" ON "PLMT"."COMPLETEDJOBS" ("CONTAINER" ASC);

CREATE INDEX "PLMT"."SQL141216125744400" ON "PLMT"."FAILEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_CIDX" ON "PLMT"."FAILEDJOBS" ("CONTAINER" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_MIDSEQX" ON "PLMT"."FAILEDJOBS" ("MSGID_SEQ" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_EIDX" ON "PLMT"."FAILEDJOBS" ("EXPIRATION" ASC);

CREATE INDEX "PLMT"."FAILEDJOBS_PIDX" ON "PLMT"."FAILEDJOBS" ("PRIORITY" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141216125449340" ON "PLMT"."COMPLETEDJOBS" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_PIDX" ON "PLMT"."COMPLETEDJOBS" ("PRIORITY" ASC);

CREATE INDEX "PLMT"."QUEUE_MIDSEQX" ON "PLMT"."QUEUE" ("MSGID_SEQ" ASC);

CREATE UNIQUE INDEX "PLMT"."SQL141216125440030" ON "PLMT"."QUEUE" ("QUEUE_ID" ASC);

CREATE INDEX "PLMT"."QUEUE_PIDX" ON "PLMT"."QUEUE" ("PRIORITY" ASC);

CREATE INDEX "PLMT"."COMPLETEDJOBS_MIDPRODX" ON "PLMT"."COMPLETEDJOBS" ("MSGID_PROD" ASC);

ALTER TABLE "PLMT"."COMPLETEDJOBS" ADD CONSTRAINT "SQL141216125449340" PRIMARY KEY ("QUEUE_ID");

ALTER TABLE "PLMT"."FAILEDJOBS" ADD CONSTRAINT "SQL141216125445000" PRIMARY KEY ("QUEUE_ID");

ALTER TABLE "PLMT"."QUEUE" ADD CONSTRAINT "SQL141216125440030" PRIMARY KEY ("QUEUE_ID");

ALTER TABLE "PLMT"."COMPLETEDJOBS" ADD CONSTRAINT "COMPLETEDJOBS_QUEUE_FK" FOREIGN KEY ("QUEUE_ID")
	REFERENCES "PLMT"."QUEUE" ("QUEUE_ID")
	ON DELETE CASCADE;

ALTER TABLE "PLMT"."FAILEDJOBS" ADD CONSTRAINT "FAILEDJOBS_QUEUE_FK" FOREIGN KEY ("QUEUE_ID")
	REFERENCES "PLMT"."QUEUE" ("QUEUE_ID")
	ON DELETE CASCADE;

