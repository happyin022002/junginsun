CREATE OR REPLACE FUNCTION NISADM.TPB_GET_IF_RMK_FNC 
 
/******************************************************************************* 
   1. Object Name      : TPB_GET_IF_RMK_FNC 
   2. Version          : 1.1 
   3. Create Date      : 2010.08.10 
   4. Sub System       : Third Party Billing 
   5. Author           : JS, AN 
   6. Description      : (TPB) GETTING IF REMARK NAME 
   7. Revision History : 2010.08.12  1.0  Created 
                         2010.10.05  RETURN 값에 대한 PL/SQL버퍼 문제 보완 
                         2011.05.    RETURN 값에 대한 PL/SQL버퍼 문제 보완(문자열 연결 전에 문자열 길이 체크)
   * ex)  
     SELECT TPB_GET_IF_RMK_FNC('CD') FROM DUAL ;  
*******************************************************************************/ 
 
-- ===== Arguments ======================================== 
(    
    in_n3pty_no  in TPB_OTS_GRP.N3PTY_NO%TYPE  -- billing type code 
)  
 
 
RETURN VARCHAR2 -- RETURN TYPE  
 
AUTHID CURRENT_USER 
 
IS  
 
-- ===== DECLARE ========================================== 
    v_if_rmk       TPB_OTS_DTL_RCVR_ACT.ACT_RMK%TYPE; 
    v_ots_dtl_seq  TPB_OTS_DTL_RCVR_ACT.OTS_DTL_SEQ%TYPE; 
    v_if_rmk_all   VARCHAR2(9000);  
    v_len          number(5) := 0;
-- ===== BEGIN, EXCEPTION  ====================================== 
BEGIN 
 
    --- Getting billing type name 
    FOR V_SEARCH_REMARK IN (    SELECT SUBSTR(a.ACT_RMK,14) if_rmk 
                                FROM TPB_OTS_DTL d, TPB_OTS_DTL_RCVR_ACT a  
                                WHERE d.N3PTY_NO = in_n3pty_no 
                                AND   a.OTS_DTL_SEQ = d.OTS_DTL_SEQ 
                                AND   a.ACT_RMK LIKE 'Confirmed. - %' 
                                AND   a.N3PTY_CLT_RMK_TP_CD='A' 
--                                AND   a.OTS_RCVR_ACT_SEQ = 2 
--                                ORDER BY a.OTS_DTL_SEQ   
                                GROUP BY SUBSTR(a.ACT_RMK,14),a.OTS_DTL_SEQ    
                           ) 
    LOOP 
        v_if_rmk := V_SEARCH_REMARK.if_rmk; 
        if nvl(lengthb(v_if_rmk_all),0) + nvl(lengthb(v_if_rmk), 0) + 1 > 3975 then
           v_if_rmk_all := v_if_rmk_all || CASE WHEN LENGTHB(v_if_rmk_all)>0 THEN chr(10) END || substrb(v_if_rmk, 1, (3975 - nvl(lengthb(v_if_rmk_all),0) - 1)) || '...';
           exit;
        else
           v_if_rmk_all := v_if_rmk_all || CASE WHEN LENGTHB(v_if_rmk_all)>0 THEN chr(10) END || v_if_rmk; 
        end if;
        
                
        --EXIT WHEN (v_ob_tro_flg = 'Y' OR v_ib_tro_flg = 'Y'); 
--        EXIT WHEN (LENGTH(v_if_rmk_all)>3975); 
    END LOOP;     
     
    ----2010.10.05 
--    if LENGTH(v_if_rmk_all)>3975 then 
--        select SUBSTR(v_if_rmk_all,1,3975)||'...' into v_if_rmk_all from dual;
--        
--    end if;
    
    --v_if_rmk_all := SUBSTR(v_if_rmk_all,1,3975)||CASE WHEN LENGTH(v_if_rmk_all)>0 THEN '...' END ; 
    --v_if_rmk_all := v_if_rmk_all||CASE WHEN LENGTH(v_if_rmk_all)>0 THEN '...' END ; 
     
 
    --- Returning Result  
    RETURN trim(v_if_rmk_all);  
 
END ;