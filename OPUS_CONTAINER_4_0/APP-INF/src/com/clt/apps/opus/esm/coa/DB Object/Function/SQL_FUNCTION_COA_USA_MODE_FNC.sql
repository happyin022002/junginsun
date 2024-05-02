CREATE OR REPLACE FUNCTION OPUSADM."COA_USA_MODE_FNC" 
/******************************************************************************
   Name         :   COA_RGST_BKG
   Purpose      :   Booking의 테이블로부터 COA_RGST_BKG
   Source       :   COA_BOOKING_V
   Target       :   COA_RGST_BKG
  
   Revision History    
    BKG에서 POR, POL, POD, DEL, RCV TERM, DE TERM을 가져온다.
    COA_USA_SCV_MOD 테이블의 데이터는 시스템 개발당시 현업에서 정의해서 넣었음
    
    1.1 POL이 'US'나 'CA'인 경우
    1.1.1 POR과 POL이 같으면
    1.1.1.1 RCV TERM 이 'D', 'H' 이면 'LOCAL'
    1.1.1.2 RCV TERM 이 'D', 'H' 아니면 'PORT'
    1.1.2 POR과 POL이 같지 않으면
    1.1.2.1 MDM LOCATION에서 POR, POL 의 RGN CODE 추출 해서 COA_USA_SCV_MOD 테이블에서
            ORIGIN = POl RGN, DEST = POR RGN 인 데이터의 SVC MODE를 가져옴
    1.1.2.2 위 테이블에 데이터가 없으면 'OTH'

    2.1.POD가 'US'나 'CA'인 경우
    2.1.1 POD와 DEL이 같으면
    2.1.1.1 DE TERM 이 'D', 'H' 이면 'LOCAL'
    2.1.1.2 DE TERM 이 'D', 'H' 아니면 'PORT'
    2.1.2 POR과 POL이 같지 않으면
    2.1.2.1 MDM LOCATION에서 POR, POL 의 RGN CODE 추출 해서 COA_USA_SCV_MOD 테이블에서
            ORIGIN = POl RGN, DEST = POR RGN 인 데이터의 SVC MODE를 가져옴
    2.1.2.2 위 테이블에 데이터가 없으면 'OTH'
 
******************************************************************************/

-- ===== Arguments ========================================
(
   in_rvd_term     IN   VARCHAR
 , in_dlv_term     IN   VARCHAR
 , in_bkg_por_cd   IN   VARCHAR
 , in_bkg_pol_cd   IN   VARCHAR
 , in_bkg_pod_cd   IN   VARCHAR
 , in_bkg_del_cd   IN   VARCHAR
)
   RETURN VARCHAR   -- RETURN TYPE
   Authid current_user
IS
-- ===== DECLARE ==========================================
   v_svc_mode_cd   VARCHAR2 (10);
   v_por_rgn       mdm_location.loc_cd%TYPE;
   v_pol_rgn       mdm_location.loc_cd%TYPE;
   v_pod_rgn       mdm_location.loc_cd%TYPE;
   v_del_rgn       mdm_location.loc_cd%TYPE;
-- ===== BEGIN, EXCEPTION  ======================================
BEGIN
   ------USA Modee 정보 찾기 ORIGIN 가져오기 -------------------------
   IF (   SUBSTR (in_bkg_pol_cd, 1, 2) = 'US'
       OR SUBSTR (in_bkg_pol_cd, 1, 2) = 'CA')
   THEN
      IF (in_bkg_por_cd = in_bkg_pol_cd)
      THEN
         IF (   in_rvd_term = 'D'
             OR in_rvd_term = 'H')
         THEN
            v_svc_mode_cd := 'LOCAL';
         ELSE
            v_svc_mode_cd := 'PORT';
         END IF;
      ELSE
         BEGIN
            SELECT NVL (rgn_cd, ' ')
              INTO v_por_rgn
              FROM mdm_location
             WHERE loc_cd = in_bkg_por_cd;
         EXCEPTION
            WHEN NO_DATA_FOUND
            THEN
               v_por_rgn := ' ';
         END;

         BEGIN
            SELECT NVL (rgn_cd, ' ')
              INTO v_pol_rgn
              FROM mdm_location
             WHERE loc_cd = in_bkg_pol_cd;
         EXCEPTION
            WHEN NO_DATA_FOUND
            THEN
               v_pol_rgn := ' ';
         END;

         BEGIN
--            SELECT DECODE (SUBSTR (svc_mod_cd, 2, 3), 'LOC', 'LOCAL', SUBSTR (svc_mod_cd, 2, 3))
            SELECT DECODE (svc_mod_cd, 'LOC', 'LOCAL', svc_mod_cd)
              INTO v_svc_mode_cd
              FROM coa_usa_svc_mod
             WHERE org_rgn_cd = v_pol_rgn
               AND dest_rgn_cd = v_por_rgn;
         EXCEPTION
            WHEN NO_DATA_FOUND
            THEN
               v_svc_mode_cd := 'OTH';
         END;
      END IF;
   ELSIF (   SUBSTR (in_bkg_pod_cd, 1, 2) = 'US'
          OR SUBSTR (in_bkg_pod_cd, 1, 2) = 'CA')
   THEN
--      IF (in_bkg_por_cd = in_bkg_pol_cd)
--      THEN
         IF (in_bkg_pod_cd = in_bkg_del_cd)
         THEN
            IF (   in_dlv_term = 'D'
                OR in_dlv_term = 'H')
            THEN
               v_svc_mode_cd := 'LOCAL';
            ELSE
               v_svc_mode_cd := 'PORT';
            END IF;
         ELSE
            BEGIN
               SELECT NVL (rgn_cd, ' ')
                 INTO v_pod_rgn
                 FROM mdm_location
                WHERE loc_cd = in_bkg_pod_cd;
            EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                  v_pod_rgn := ' ';
            END;

            BEGIN
               SELECT NVL (rgn_cd, ' ')
                 INTO v_del_rgn
                 FROM mdm_location
                WHERE loc_cd = in_bkg_del_cd;
            EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                  v_del_rgn := ' ';
            END;

            BEGIN
--               SELECT DECODE (SUBSTR (svc_mod_cd, 2, 3), 'LOC', 'LOCAL', SUBSTR (svc_mod_cd, 2, 3))
               SELECT DECODE (svc_mod_cd, 'LOC', 'LOCAL', svc_mod_cd)
                 INTO v_svc_mode_cd
                 FROM coa_usa_svc_mod
                WHERE org_rgn_cd = v_pod_rgn
                  AND dest_rgn_cd = v_del_rgn;
            EXCEPTION
               WHEN NO_DATA_FOUND
               THEN
                  v_svc_mode_cd := 'OTH';
            END;
         END IF;
--      END IF;
   END IF;

   RETURN v_svc_mode_cd;
END;
-- ===== End of Function ==================================