CREATE OR REPLACE FUNCTION OPUSADM."COA_VSL_PORT_DAYS_FNC" 
/******************************************************************************
   Name         :   COA_VSL_PORT_DAYS_FNC
   Purpose      :   POL - POD 간의 소요날짜 구하기
   Source       :
   Target       :
   Example      :
   SELECT coa_vsl_port_days_fnc('HNBN', '0017', 'E', 'KRKAN', 'USLGB') nod_cd
      FROM DUAL
******************************************************************************/

-- ===== Arguments ========================================
(
   in_vsl_cd       IN   VARCHAR   --
  ,in_skd_voy_no   IN   VARCHAR   --
  ,in_skd_dir_cd   IN   VARCHAR   --
  ,in_pol          IN   VARCHAR
  ,in_pod          IN   VARCHAR
)
   RETURN NUMBER   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_rslt_days   NUMBER;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   BEGIN
      -- 중복 되는 경우가 POL 인경우는 SEQ MIN POD 인경우는 SEQ Max
      SELECT a2.vps_eta_dt - a1.vps_etd_dt
        INTO v_rslt_days
        FROM (
-- POL DT
              SELECT vsl_cd
                    ,skd_voy_no
                    ,skd_dir_cd
                    ,vps_port_cd
                    ,vps_etd_dt
                FROM vsk_vsl_port_skd
               WHERE vsl_cd = in_vsl_cd
                 AND skd_voy_no = in_skd_voy_no
                 AND skd_dir_cd = in_skd_dir_cd
                 AND vps_port_cd = in_pol
                 AND clpt_ind_seq = (SELECT MIN(clpt_ind_seq)
                                       FROM vsk_vsl_port_skd
                                      WHERE vsl_cd = in_vsl_cd
                                        AND skd_voy_no = in_skd_voy_no
                                        AND skd_dir_cd = in_skd_dir_cd
                                        AND vps_port_cd = in_pol)) a1
            ,(
-- POD DT
              SELECT vsl_cd
                    ,skd_voy_no
                    ,skd_dir_cd
                    ,vps_port_cd
                    ,vps_eta_dt
                FROM vsk_vsl_port_skd
               WHERE vsl_cd = in_vsl_cd
                 AND skd_voy_no = in_skd_voy_no
                 AND skd_dir_cd = in_skd_dir_cd
                 AND vps_port_cd = in_pod
                 AND clpt_ind_seq = (SELECT MAX(clpt_ind_seq)
                                       FROM vsk_vsl_port_skd
                                      WHERE vsl_cd = in_vsl_cd
                                        AND skd_voy_no = in_skd_voy_no
                                        AND skd_dir_cd = in_skd_dir_cd
                                        AND vps_port_cd = in_pod)) a2;
   EXCEPTION
      WHEN OTHERS
      THEN
--         enis_log_prc(SYSDATE, 'coa_vsl_port_days_fnc', SQLERRM);
--         enis_log_prc(SYSDATE, 'coa_vsl_port_days_fnc', 'in_vsl_cd: ' || in_vsl_cd);
--         enis_log_prc(SYSDATE, 'coa_vsl_port_days_fnc', 'in_skd_voy_no: ' || in_skd_voy_no);
--         enis_log_prc(SYSDATE, 'coa_vsl_port_days_fnc', 'in_skd_dir_cd: ' || in_skd_dir_cd);
--         enis_log_prc(SYSDATE, 'coa_vsl_port_days_fnc', 'in_pol: ' || in_pol);
--         enis_log_prc(SYSDATE, 'coa_vsl_port_days_fnc', 'in_pod: ' || in_pod);
         v_rslt_days := 0;
   END;

   RETURN v_rslt_days;
END;
-- ===== End of Function ==================================