CREATE OR REPLACE PROCEDURE LEAADM.LEA_BAT_PAR_ITER_PRC(a_Proc_No IN number, a_Prc_Nm_In IN LEA_BAT_PAR_PRT.PRC_NM%TYPE)     
IS     
  v_seq LEA_BAT_PAR_PRT.PAR_PRT_SEQ%TYPE ;     
--  v_Key      LEA_BAT_PAR_PRT%ROWTYPE ;     
  v_msg varchar2(1024);     
  v_stmt varchar2(1024);     
BEGIN     
    EXECUTE IMMEDIATE 'ALTER SESSION ENABLE PARALLEL DML' ;     
     
    -- 작업 프로세스 테이블에 자신을 등록     
    MERGE INTO LEA_BAT_PROC a     
          USING (SELECT a_Proc_No PROC_NO FROM DUAL) s     
          ON (a.PROC_NO = s.PROC_NO) --MAPG_PRT_LVL    
       WHEN MATCHED THEN     
          UPDATE SET ORA_SESS_ID = USERENV('SID'),     
                     ST_TMS      = SYSTIMESTAMP,     
                     END_TMS     = NULL,     
                     RUN_PRT_SEQ = NULL     
       WHEN NOT MATCHED THEN     
        INSERT VALUES (a_Proc_No, USERENV('SID'), SYSTIMESTAMP, NULL, NULL) ;     
    COMMIT ;     
     
    LOOP     
        -- 처리대상데이타 조회방법     
        -- UPDATE하면서 처리할 SEQ 를 가져온다.     
        -- UPDATE 후 즉시 COMMIT 해야 다른 PROCESSOR에 LOCK 이 걸리지 않는다.     
        UPDATE LEA_BAT_PAR_PRT     
           SET PAR_PRT_STS_CD = 'P',     
               PROC_NO         = a_Proc_No     
         WHERE PAR_PRT_STS_CD = 'N'     
		   AND PRC_NM = a_Prc_Nm_In     
           AND PAR_PRT_SEQ = (SELECT MIN(PAR_PRT_SEQ)      
		                         FROM LEA_BAT_PAR_PRT      
								WHERE PAR_PRT_STS_CD = 'N'     
								  AND PRC_NM = a_Prc_Nm_In)     
        RETURNING PAR_PRT_SEQ INTO v_seq ;     
             
        IF SQL%ROWCOUNT < 1 THEN     
            EXIT ;     
        END IF ;     
             
        COMMIT ;     
             
        -- 더이상 처리한 데이타가 없으면 NULL 이 반환된다.     
        IF v_seq IS NULL THEN     
            EXIT ;     
        END IF ;     
             
        -- -- Row를 조회한다.     
        -- SELECT *     
          -- INTO v_Key     
          -- FROM LEA_BAT_PAR_PRT     
         -- WHERE PAR_PRT_SEQ = v_seq ;     
		      
        -- IF SQL%ROWCOUNT < 1 THEN     
            -- lea_log_prc('~~~~~~~~~~~~~~~~~~~~~~XXXXXXXXXXXXXXXXX~~~~~~~~~~~~~~');     
            -- EXIT ;     
        -- END IF ;     
             
		 -- v_msg := a_Prc_Nm_In||'('||a_Proc_No||') fetched '||v_seq ;     
		 -- lea_log_prc(v_msg||NVL('(VSL='||v_Key.vsl_cd||' VOY='||v_Key.skd_voy_no||' DIR='||v_Key.skd_dir_cd||' REVDIR='||v_Key.rev_dir_cd||     
							-- ' COST_CD='||v_Key.coa_cost_src_cd||' 1st_NOD='||v_Key.n1st_nod_cd, '<NULL>')) ;     
              
		UPDATE LEA_BAT_PROC     
		   SET RUN_PRT_SEQ = v_seq     
		 WHERE PROC_NO = a_Proc_No ;     
		COMMIT ;     
		     
        -- 조회한 Row는 처리할 범위를 지정하는 키를 가지고 있다.     
        -- 이 키를 처리하는 프로시저를 호출한다.     
        -- 테이블 LEA_BAT_ACT_MAPG_PRT 의 컬럼 (ST_TMS, END_TMS, ACT_MAPG_STS_CD, PROC_ROW_KNT)와     
        --        LEA_BAT_PROC(RUN_PRT_SEQ) 는      
        -- 처리 프로그램 LEA_ACT_COST_MAP_PRC가 기록해야 한다.(패키지를 만들어 쓰는게 좋을것으로 생각됨)     
        BEGIN     
            DBMS_APPLICATION_INFO.SET_ACTION(a_Prc_Nm_In||'('||v_seq||')') ;     
			-- IF upper(a_Prc_Nm_In) = 'LEA_ACCL_ESTM_PRC' then     
			    -- LEA_ACCL_ESTM_PRC(a_Prc_Nm_In, v_seq) ;     
			-- ELSIF upper(a_Prc_Nm_In) = 'LEA_ACT_COST_MAP_PRC' then     
				-- LEA_ACT_COST_MAP_PRC(a_Prc_Nm_In, v_seq) ;     
			-- ELSE     
                -- lea_log_prc('###################  PROCEDURE '||a_Prc_Nm_In||' not found') ;     
			-- END IF ;     
              
--			v_stmt := 'BEGIN '|| a_Prc_Nm_In||'(:prc_nm, :seq) ; END;' ;     
            -- lea_log_prc('LEA_BAT_PAR_ITER_PRC - executing : '||v_stmt) ;     
			--EXECUTE IMMEDIATE v_stmt USING a_Prc_Nm_In, v_seq ;     
         IF upper(a_Prc_Nm_In) = 'LEA_ACT_COST_MAPG_PRC'      
         then     
            LEA_ACT_COST_MAPG_PRC(a_Prc_Nm_In, v_seq) ;     
         END IF ;     
              
        EXCEPTION     
            WHEN OTHERS THEN     
                v_msg := DBMS_UTILITY.FORMAT_ERROR_BACKTRACE ;     
                lea_log_prc('###################  '||a_Prc_Nm_In||' : ' || v_msg) ;     
                UPDATE LEA_BAT_PAR_PRT     
                   SET PAR_PRT_STS_CD = 'F'  --###### 처리 실패!     
                 WHERE PRC_NM = a_Prc_Nm_In     
				   AND PAR_PRT_SEQ = v_seq ;     
                COMMIT ;     
        END ;     
    END LOOP ;     
         
    -- 작업 프로세스 테이블에 종료 표시하고 나감     
    UPDATE LEA_BAT_PROC     
       SET END_TMS = SYSTIMESTAMP     
     WHERE PROC_NO = a_Proc_No ;     
    COMMIT ;     
END ;