CREATE USER 'plmtuser'@'localhost' IDENTIFIED BY 'plmtuser';
CREATE USER 'plmtuser'@'%' IDENTIFIED BY 'plmtuser';

GRANT ALL ON plmt.* TO 'plmtuser'@'localhost';
GRANT ALL ON plmt.* TO 'plmtuser'@'%';