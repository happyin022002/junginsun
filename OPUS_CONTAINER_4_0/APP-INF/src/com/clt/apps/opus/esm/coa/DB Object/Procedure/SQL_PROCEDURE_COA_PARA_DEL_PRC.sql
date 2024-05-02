CREATE OR REPLACE PROCEDURE OPUSADM."COA_PARA_DEL_PRC" 
Authid current_user
IS
/***************************************************************************************
   Name         :   COA_PARA_DEL_PRC
   Purpose      :   PARA 관련 임시 데이터를 삭제한다,(1) 1시간 이전 데이터만 삭제 대상
   Source       :   
   Target       :   coa_com_para, coa_com_cost_para                    
***************************************************************************************/
   CURSOR CALC_DEL_CURSOR(DEL_DATE TIMESTAMP)
   IS 
    --'C'상태이며 DEL_DATE이전에 배치작업이 이루어진 BKG
    SELECT BKG_NO 
    FROM COA_BKG_COST_CALC
    WHERE COA_BAT_CD = 'C' 
    AND COA_BAT_DT < DEL_DATE;
    
------------------------------[ 변수선언부             ]-----------------------
   v_prs_cnt      NUMBER;
   v_start_time   TIMESTAMP;
   v_del_date     DATE;
-------------------------------[ 업무로직 구현부       ]-----------------------
BEGIN
   --enis_log_prc (SYSDATE, 'coa_para_del_prc', '=================== [ COA_PARA_DEL_PRC V.2007040991119 07:40 ] ============================');
--   v_start_time := SYSTIMESTAMP;
--   enis_log_prc (SYSDATE, 'coa_para_del_prc', 'Start ' || TO_CHAR (v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));
   v_del_date := SYSDATE -(1 / 24);   -- 1 시간 전

   --enis_log_prc (SYSDATE, 'coa_para_del_prc', '삭제기준시간: ' || TO_CHAR (v_del_date, 'yyyy/mm/dd hh24:mi:ss'));


   DELETE FROM coa_com_qty_para
         WHERE cre_dt < v_del_date;

   DELETE FROM coa_com_cost_para
         WHERE cre_dt < v_del_date
           AND SUBSTR(pctl_no, 1, 1) != 'P'   -- RFA 에서 P로 시작하는건 계속 남아 있함어야 한다고함
                                           ;

   --enis_log_prc (SYSDATE, 'coa_para_del_prc', 'COA_COM_COST_PARA: ' || SQL%ROWCOUNT || ' Deleted');
   DELETE FROM coa_com_para
         WHERE cre_dt < v_del_date
           AND SUBSTR(pctl_no, 1, 1) != 'P'   -- RFA 에서 P로 시작하는건 계속 남아 있함어야 한다고함
                                           ;
--enis_log_prc (SYSDATE, 'coa_para_del_prc', 'COA_COM_PARA: ' || SQL%ROWCOUNT || ' Deleted');
--enis_log_prc (SYSDATE, 'coa_para_del_prc', 'End   ' || TO_CHAR (SYSTIMESTAMP, 'yyyy/mm/dd hh24:mi:ss.ff'));
--enis_log_prc (SYSDATE, 'coa_para_del_prc', 'Required ' || TO_CHAR (SYSTIMESTAMP - v_start_time, 'yyyy/mm/dd hh24:mi:ss.ff'));

   -- P상태로 완료가 안된 상태 초기화
    UPDATE COA_BKG_COST_CALC 
    SET    COA_BAT_CD = 'N' 
           , COA_BAT_SEQ = 0 
           , COA_BAT_DT = NULL 
           , COA_BAT_RMK = DECODE(UPD_USR_ID, 'COA_PARA_DEL_PRC', COA_BAT_RMK, REPLACE(COA_BAT_RMK, ' (COA COA_PARA_DEL_PRC INIT)', '') ||' (COA COA_PARA_DEL_PRC INIT)')
           , UPD_USR_ID = 'COA_PARA_DEL_PRC' 
           , UPD_DT = SYSDATE 
    WHERE  COA_BAT_CD IN ('P'); 
    
    
   
   --현재 남아있는 BKG리스트를 가져와서 하나
   FOR DEL_BKG_LIST IN CALC_DEL_CURSOR(V_DEL_DATE) 
   LOOP 
   
    INSERT INTO COA_BKG_COST_CALC_HIS
        (SELECT  A1.BKG_NO 
               , A1.COA_BAT_DT COST_BAT_DT
               , A1.COA_BAT_RMK COST_BAT_RMK 
               , A3.COST_YRMON 
               , A3.SLS_YRMON 
               , A3.COST_WK 
               , 'COA_PARA_DEL_PRC' CRE_USR_ID
               , SYSDATE CRE_DT
               , 'COA_PARA_DEL_PRC' UPD_USR_ID
               , SYSDATE UPD_DT
        FROM   COA_BKG_COST_CALC A1 
               , COA_RGST_BKG A2 
               , COA_MON_VVD A3 
        WHERE  1=1 
               AND A1.BKG_NO = DEL_BKG_LIST.BKG_NO
               AND A1.BKG_NO = A2.BKG_NO 
               AND A3.VSL_CD = A2.VSL_CD 
               AND A3.SKD_VOY_NO = A2.SKD_VOY_NO 
               AND A3.DIR_CD = A2.DIR_CD 
               AND A3.TRD_CD = A2.TRD_CD 
               AND A3.RLANE_CD = A2.RLANE_CD 
               AND A3.IOC_CD = A2.IOC_CD); 
               
     --INSER에 성공한 경우 테이블에서 삭제한다.        
     IF (SQL%ROWCOUNT>0) THEN
        DELETE FROM COA_BKG_COST_CALC WHERE BKG_NO = DEL_BKG_LIST.BKG_NO;
     
     END IF;
                    
   END LOOP;          
      
   --enis_log_prc (SYSDATE, 'coa_para_del_prc', 'sce_bkg_if(CD=P): ' || SQL%ROWCOUNT || ' Updated');

EXCEPTION
   WHEN OTHERS
   THEN
      enis_log_prc(SYSDATE, 'coa_para_del_prc', 'ERROR: ' || SQLERRM);
END coa_para_del_prc;