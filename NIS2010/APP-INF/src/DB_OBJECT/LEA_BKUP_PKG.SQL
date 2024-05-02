CREATE OR REPLACE PACKAGE LEA_BKUP_PKG
IS
    PROCEDURE analyze_table(table_name_in     IN VARCHAR2, 
                     partition_name_in IN VARCHAR2 := NULL) ; 
    PROCEDURE analyze_index(index_name_in     IN VARCHAR2, 
                     partition_name_in IN VARCHAR2 := NULL) ; 
    FUNCTION  get_backup_table_ddl_fnc(src_table_name_in    IN VARCHAR2, 
                                       backup_table_name_in IN VARCHAR2,
                              tablespace_name_in   IN VARCHAR2 := NULL) RETURN VARCHAR2 ;
        
    PROCEDURE set_table_index_logging_prc(table_name_in IN VARCHAR2, enable_in IN BOOLEAN) ;
    PROCEDURE set_indexes_unusable_prc(index_name_in IN VARCHAR2, 
                                      partition_name_in IN VARCHAR2 := NULL) ;
    PROCEDURE rebuild_indexes_prc(index_name_in IN VARCHAR2, 
                                      partition_name_in IN VARCHAR2 := NULL) ;

    PROCEDURE backup_table_indexes_prc(table_name_in IN VARCHAR2) ;
    PROCEDURE disable_table_constraints_prc(table_name_in IN VARCHAR2) ;
    PROCEDURE drop_table_indexes_prc(table_name_in IN VARCHAR2) ;
    PROCEDURE restore_table_indexes_prc(table_name_in IN VARCHAR2) ;
    PROCEDURE enable_table_constraints_prc(table_name_in IN VARCHAR2) ;
    
    PARTTION_TYPE_NOT_SUPPORTED EXCEPTION ;
    PRAGMA EXCEPTION_INIT(PARTTION_TYPE_NOT_SUPPORTED, -50000);
    NAME_ALREADY_USED EXCEPTION ;
    PRAGMA EXCEPTION_INIT(NAME_ALREADY_USED, -955);
END ; 
/
CREATE OR REPLACE PACKAGE BODY LEA_BKUP_PKG
IS
    c_PARALLEL_DEGREE CONSTANT NUMBER(2) := 24 ;
    
    PROCEDURE set_indexes_unusable_prc(index_name_in IN VARCHAR2, 
	                                   partition_name_in IN VARCHAR2 := NULL) IS
        v_stmt VARCHAR2(4000) ;
    BEGIN
		v_stmt := 'ALTER INDEX '|| index_name_in ;
		IF partition_name_in IS NOT NULL THEN
			v_stmt := v_stmt||' MODIFY PARTITION ' || partition_name_in ;
		END IF ;
		v_stmt := v_stmt||' UNUSABLE' ;

        --DBMS_OUTPUT.PUT_LINE(V_STMT) ;
--		BEGIN
			EXECUTE IMMEDIATE v_stmt ;
--		EXCEPTION WHEN OTHERS THEN
--			NULL ;
--		END ;  
	END ;
	
    PROCEDURE rebuild_indexes_prc(index_name_in IN VARCHAR2, 
	                                   partition_name_in IN VARCHAR2 := NULL) IS
        v_stmt VARCHAR2(4000) ;
    BEGIN
		IF partition_name_in IS NOT NULL THEN
			v_stmt := 'ALTER INDEX '|| index_name_in || ' REBUILD PARTITION ' || partition_name_in || ' NOLOGGING PARALLEL ' || c_PARALLEL_DEGREE ;
			--DBMS_OUTPUT.PUT_LINE(V_STMT) ;
			EXECUTE IMMEDIATE v_stmt ;
		ELSE
		    FOR c IN (SELECT PARTITION_NAME FROM USER_IND_PARTITIONS WHERE INDEX_NAME = UPPER(index_name_in))
			LOOP
				v_stmt := 'ALTER INDEX '|| index_name_in || ' REBUILD PARTITION ' || 
							c.partition_name || ' NOLOGGING PARALLEL ' || c_PARALLEL_DEGREE ;
				--DBMS_OUTPUT.PUT_LINE(V_STMT) ;
				EXECUTE IMMEDIATE v_stmt ;
			END LOOP ;
		END IF ;
	END ;
	
    PROCEDURE set_table_index_logging_prc(table_name_in IN VARCHAR2, enable_in IN BOOLEAN) IS
        v_stmt VARCHAR2(4000) ;
    BEGIN
		-- TABLE LOGGING
		v_stmt := 'ALTER TABLE '|| table_name_in ;
		IF enable_in THEN
			v_stmt := v_stmt||' LOGGING' ;
		ELSE
			v_stmt := v_stmt||' NOLOGGING' ;
		END IF ;
		--DBMS_OUTPUT.PUT_LINE(V_STMT) ;
		BEGIN
			EXECUTE IMMEDIATE v_stmt ;
		EXCEPTION WHEN OTHERS THEN
			NULL ;
		END ;  
		
        -- INDEX LOGGING		
        FOR C IN (SELECT INDEX_NAME FROM USER_INDEXES WHERE TABLE_NAME = table_name_in)
        LOOP
            v_stmt := 'ALTER INDEX '||C.INDEX_NAME ;
			IF enable_in THEN
			    v_stmt := v_stmt||' LOGGING' ;
			ELSE
			    v_stmt := v_stmt||' NOLOGGING' ;
			END IF ;
            --DBMS_OUTPUT.PUT_LINE(V_STMT) ;
			BEGIN
				EXECUTE IMMEDIATE v_stmt ;
			EXCEPTION WHEN OTHERS THEN
				NULL ;
			END ;            
        END LOOP ;
    /* Exception -----------------------------------------------------------------*/
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
        
    END ;

    PROCEDURE analyze_table(table_name_in     IN VARCHAR2, 
							partition_name_in IN VARCHAR2 := NULL) IS
		v_stmt varchar2(4000) ;
	begin
		--dbms_output.put_line(partition_name_in) ;
		IF partition_name_in IS NULL THEN
			v_stmt := 'ANALYZE TABLE '|| table_name_in || ' ESTIMATE STATISTICS' ;
		ELSE
			v_stmt := 'ANALYZE TABLE '|| table_name_in || ' PARTITION('|| partition_name_in ||') ESTIMATE STATISTICS' ;
		END IF ;
		--dbms_output.put_line(v_stmt) ;
		BEGIN
			EXECUTE IMMEDIATE v_stmt ;
		EXCEPTION WHEN OTHERS THEN
			NULL ;
		END ;
	end ;

    PROCEDURE analyze_index(index_name_in     IN VARCHAR2, 
							partition_name_in IN VARCHAR2 := NULL) IS
		v_stmt varchar2(4000) ;
	begin
		IF partition_name_in IS NULL THEN
			v_stmt := 'ANALYZE INDEX '|| index_name_in || ' ESTIMATE STATISTICS' ;
		ELSE
			v_stmt := 'ANALYZE INDEX '|| index_name_in || 'PARTITION('|| partition_name_in ||') ESTIMATE STATISTICS' ;
		END IF ;
		BEGIN
			EXECUTE IMMEDIATE v_stmt ;
		EXCEPTION WHEN OTHERS THEN
			NULL ;
		END ;
	end ;
	
    PROCEDURE enable_table_constraints_prc(table_name_in IN VARCHAR2) IS
        v_stmt varchar2(30000) ;
    begin
        FOR C IN (SELECT TABLE_NAME, CONSTRAINT_NAME 
                    FROM USER_CONSTRAINTS
                    WHERE TABLE_NAME = table_name_in
                      and CONSTRAINT_TYPE IN ('P', 'U')
                      and STATUS = 'DISABLED')
        LOOP
            v_stmt := 'ALTER TABLE '||C.TABLE_NAME||' ENABLE CONSTRAINT '||c.constraint_name ;
            --dbms_output.put_line(v_stmt) ;
            EXECUTE IMMEDIATE v_stmt ;
        END LOOP ;
    /* Exception -----------------------------------------------------------------*/
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
    end ;

    PROCEDURE drop_table_indexes_prc(table_name_in IN VARCHAR2) IS
        v_stmt varchar2(3000) ;
    begin
        FOR C IN (SELECT TABLE_NAME, INDEX_NAME 
                    FROM USER_INDEXES
                   WHERE TABLE_NAME = table_name_in)
        LOOP
            v_stmt := 'DROP INDEX '||C.INDEX_NAME ;
            --dbms_output.put_line(v_stmt) ;
            EXECUTE IMMEDIATE v_stmt ;
        END LOOP ;
    /* Exception -----------------------------------------------------------------*/
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
    end ;

    PROCEDURE disable_table_constraints_prc(table_name_in IN VARCHAR2) IS
        v_stmt varchar2(3000) ;
    begin
        FOR C IN (SELECT TABLE_NAME, CONSTRAINT_NAME 
                    FROM USER_CONSTRAINTS
                    WHERE TABLE_NAME = table_name_in
                      and CONSTRAINT_TYPE IN ('P', 'U'))
        LOOP
            v_stmt := 'ALTER TABLE '||C.TABLE_NAME||' DISABLE CONSTRAINT '||c.constraint_name ;
            --dbms_output.put_line(v_stmt) ;
            EXECUTE IMMEDIATE v_stmt ;
        END LOOP ;
    /* Exception -----------------------------------------------------------------*/
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
        
    end ;
    
    FUNCTION get_backup_table_ddl_fnc(src_table_name_in    IN VARCHAR2, 
                                      backup_table_name_in IN VARCHAR2,
									  tablespace_name_in   IN VARCHAR2 := NULL) RETURN VARCHAR2 IS
        NEW_LINE VARCHAR2(3) := CHR(10) ;
        v_stmt VARCHAR2(32767) ;
        v_line VARCHAR2(1000) ;
        cursor_name INTEGER;
        ret INTEGER;
        start_tm TIMESTAMP;
    BEGIN
        v_stmt := 'CREATE TABLE ' || backup_table_name_in ;
        IF tablespace_name_in IS NOT NULL THEN 
            v_stmt := v_stmt || NEW_LINE || ' TABLESPACE ' || tablespace_name_in ;
        END IF ;

        -- PARTITION
        FOR C1 IN (SELECT PARTITIONING_TYPE FROM USER_PART_TABLES WHERE TABLE_NAME = src_table_name_in)
        LOOP
            v_stmt := v_stmt || NEW_LINE || ' PARTITION BY ' || C1.PARTITIONING_TYPE || '(' ;
            FOR C2 IN (SELECT ROWNUM RN, COLUMN_NAME FROM USER_PART_KEY_COLUMNS WHERE NAME = src_table_name_in ORDER BY COLUMN_POSITION)
            LOOP
                IF C2.RN > 1 THEN
                    v_stmt := v_stmt || ',' ;
                END IF ;
                v_stmt := v_stmt || c2.column_name ;
            END LOOP ;
            v_stmt := v_stmt || ') ' || NEW_LINE || ' (' ;

            -- PARTITION DEFINITION
            FOR  C3 IN (SELECT ROWNUM RN, PARTITION_NAME, HIGH_VALUE 
                          FROM USER_TAB_PARTITIONS A 
                         WHERE TABLE_NAME = src_table_name_in ORDER BY PARTITION_POSITION)
            LOOP
                v_line := '  PARTITION ' || C3.PARTITION_NAME ;

                IF C1.PARTITIONING_TYPE = 'RANGE' THEN
                    v_line := v_line || ' VALUES LESS THAN (' || C3.HIGH_VALUE || ')' ;
                ELSIF C1.PARTITIONING_TYPE = 'LIST' THEN
                    v_line := v_line || ' VALUES (' || C3.HIGH_VALUE || ')' ;
                ELSE
                    RAISE PARTTION_TYPE_NOT_SUPPORTED ;
                END IF ;

                IF C3.RN > 1 THEN
                    v_stmt := v_stmt || ',' ;
                END IF ;
                v_stmt := v_stmt || NEW_LINE || v_line ;
            END LOOP ;

            v_stmt := v_stmt || NEW_LINE|| ' )' ;
        END LOOP ;

        v_stmt := v_stmt || NEW_LINE ||
                  'AS' || NEW_LINE || 'SELECT * FROM ' || src_table_name_in || ' A WHERE ROWNUM < 1' ;

        --DBMS_OUTPUT.PUT_LINE(V_STMT) ;
--        FOR C IN (SELECT 1 FROM USER_TABLES WHERE TABLE_NAME = backup_table_name_in)
--        LOOP
--            EXECUTE IMMEDIATE 'DROP TABLE '|| backup_table_name_in ;
--        END LOOP ;
--        EXECUTE IMMEDIATE V_STMT ;
--        EXECUTE IMMEDIATE 'ALTER TABLE '|| backup_table_name_in || ' NOPARALLEL' ;
        
--        lea_sys_email_prc(UPPER(src_table_name_in)||'->'||UPPER(backup_table_name_in)||' 테이블 백업작업 성공', '시작:'||start_tm || NEW_LINE ||'종료:'|| SYSTIMESTAMP); --Subject, Contents
    /* Exception -----------------------------------------------------------------*/
	    RETURN v_stmt ;
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
        
    end ;
        
    PROCEDURE backup_table_indexes_prc(table_name_in IN VARCHAR2) IS
        v_stmt CLOB ;
		v_sql varchar2(30000) ;
    BEGIN
        FOR C IN (SELECT INDEX_NAME FROM USER_INDEXES WHERE TABLE_NAME = table_name_in)
        LOOP
		    EXECUTE IMMEDIATE 'ALTER INDEX '||C.INDEX_NAME|| ' NOLOGGING ' ;
        END LOOP ;

        FOR C IN (SELECT INDEX_NAME FROM USER_INDEXES WHERE TABLE_NAME = table_name_in order by INDEX_NAME)
        LOOP
            v_stmt := dbms_metadata.get_ddl('INDEX', C.INDEX_NAME) ;
            --DBMS_OUTPUT.PUT_LINE(V_STMT) ;
            
            MERGE INTO LEA_TBL_IDX_BKUP A
            USING (SELECT table_name_in TBL_NM, c.index_name IDX_NM FROM DUAL) X
            ON (A.TBL_NM = X.TBL_NM AND 
                A.IDX_NM = X.IDX_NM)
            WHEN MATCHED THEN
                UPDATE SET IDX_SCRT_DESC = v_stmt,
                           UPD_USR_ID = 'Procedure_U',
                           UPD_DT = SYSDATE 
            WHEN NOT MATCHED THEN
                insert VALUES(table_name_in, c.index_name, v_stmt, 'Procedure_I', SYSDATE, 'Procedure_I', SYSDATE) ;
        END LOOP ;
        commit ;
    /* Exception -----------------------------------------------------------------*/
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
        
    END ;

    PROCEDURE restore_table_indexes_prc(table_name_in IN VARCHAR2) IS
        v_stmt varchar2(32767) ;
    BEGIN
        FOR C IN (SELECT IDX_NM, IDX_SCRT_DESC FROM LEA_TBL_IDX_BKUP WHERE TBL_NM = table_name_in order by IDX_NM)
        LOOP
            v_stmt := c.IDX_SCRT_DESC || ' PARALLEL ' || c_PARALLEL_DEGREE ;
            BEGIN
                execute immediate v_stmt ;
            EXCEPTION
              WHEN NAME_ALREADY_USED THEN
                -- Ignore if index already exists
                NULL ;
            END ;
            delete from LEA_TBL_IDX_BKUP WHERE TBL_NM = table_name_in and IDX_NM = c.IDX_NM;
            commit ;
            execute immediate 'ALTER INDEX '||C.IDX_NM||' NOPARALLEL LOGGING' ;
        END LOOP ;
    /* Exception -----------------------------------------------------------------*/
    EXCEPTION
    WHEN OTHERS
    THEN
       raise_application_error(-20000, SQLERRM || CHR(10) || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);        
        
    END ;
    
END ;
/
