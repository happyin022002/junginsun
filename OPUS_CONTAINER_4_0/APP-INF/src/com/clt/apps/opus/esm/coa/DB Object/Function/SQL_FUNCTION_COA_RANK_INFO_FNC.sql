CREATE OR REPLACE FUNCTION OPUSADM."COA_RANK_INFO_FNC" 
/******************************************************************************
   Name         :   COA_RANK_INFO_FNC
   Purpose      :   Booking의 테이블로부터 COA_RGST_BKG
   Source       :   COA_BOOKING_V
   Target       :   COA_RGST_BKG
   Ver          :   1.0
   Date         :   2006.11.18
   Author       :   오명석 (6465)
   변경내역     :  
                         
******************************************************************************/

-- ===== Arguments ========================================
(
   v_n1st_rlane_cd   IN   VARCHAR
  ,v_n2nd_rlane_cd   IN   VARCHAR
  ,v_n3rd_rlane_cd   IN   VARCHAR
  ,v_n4th_rlane_cd   IN   VARCHAR
  ,v_n1st_ioc_cd     IN   VARCHAR
  ,v_n2nd_ioc_cd     IN   VARCHAR
  ,v_n3rd_ioc_cd     IN   VARCHAR
  ,v_n4th_ioc_cd     IN   VARCHAR
)
   RETURN NUMBER   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_rank               NUMBER (4);
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
     
    BEGIN
       --- Initiate varibles
       v_rank := 0;       
            
      SELECT DECODE (rlane_cd || SUBSTR(rtrim(ltrim(zn_ioc_cd)), 1,2)
                    , v_n1st_rlane_cd || substr(v_n1st_ioc_cd,1,2), 1
                    , v_n2nd_rlane_cd || substr(v_n2nd_ioc_cd,1,2), 2
                    , v_n3rd_rlane_cd || substr(v_n3rd_ioc_cd,1,2), 3
                    , v_n4th_rlane_cd || substr(v_n4th_ioc_cd,1,2), 4
                    ,1000
                    )
        INTO v_rank
        FROM ar_rout_rnk
       WHERE rnk_seq =
                (SELECT MIN (rnk_seq)
                   FROM (SELECT rnk_seq
                           FROM ar_rout_rnk
                          WHERE rlane_cd = v_n1st_rlane_cd
                            AND SUBSTR (zn_ioc_cd, 1, 2) = substr(v_n1st_ioc_cd,1,2)
                            AND delt_flg='N'
                         UNION ALL
                         SELECT rnk_seq
                           FROM ar_rout_rnk
                          WHERE rlane_cd = v_n2nd_rlane_cd
                            AND SUBSTR (zn_ioc_cd, 1, 2) = substr(v_n2nd_ioc_cd,1,2)
                            AND delt_flg='N'
                         UNION ALL
                         SELECT rnk_seq
                           FROM ar_rout_rnk
                          WHERE rlane_cd = v_n3rd_rlane_cd
                            AND SUBSTR (zn_ioc_cd, 1,2) = substr(v_n3rd_ioc_cd,1,2)
                            AND delt_flg='N'
                         UNION ALL
                         SELECT rnk_seq
                           FROM ar_rout_rnk
                          WHERE rlane_cd = v_n4th_rlane_cd
                            AND SUBSTR (zn_ioc_cd, 1, 2) = substr(v_n4th_ioc_cd,1,2)
                            AND delt_flg='N'));
                            
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc',SQLERRM);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n1st_rlane_cd: ' || v_n1st_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n2nd_rlane_cd: ' || v_n2nd_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n3rd_rlane_cd: ' || v_n3rd_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n4th_rlane_cd: ' || v_n4th_rlane_cd);
   EXCEPTION
      WHEN OTHERS
      THEN
--          enis_log_prc (SYSDATE, 'coa_rank_info_fnc',SQLERRM);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n1st_rlane_cd: ' || v_n1st_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n2nd_rlane_cd: ' || v_n2nd_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n3rd_rlane_cd: ' || v_n3rd_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n4th_rlane_cd: ' || v_n4th_rlane_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n1st_ioc_cd: ' || v_n1st_ioc_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n2nd_ioc_cd: ' || v_n2nd_ioc_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n3rd_ioc_cd: ' || v_n3rd_ioc_cd);
--         enis_log_prc (SYSDATE, 'coa_rank_info_fnc','v_n4th_ioc_cd: ' || v_n4th_ioc_cd);
          v_rank := 1;
            RETURN v_rank;
   END;
--            enis_log_prc (SYSDATE, 'coa_rank_info_fnc',v_rank);
   RETURN v_rank;
END
-- ===== End of Function ==================================
;