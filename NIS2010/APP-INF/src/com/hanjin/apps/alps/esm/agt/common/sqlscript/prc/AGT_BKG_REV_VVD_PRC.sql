CREATE OR REPLACE PROCEDURE NISDEV.AGT_BKG_REV_VVD_PRC(
   in_bkg_no            IN       VARCHAR2
)
IS
/*******************************************************************************
   1. Object Name      : AGT_BKG_REV_VVD_PRC
   2. Version          : 1.1
   3. Create Date      : 2007.04.03
   4. Sub System       : AGT
   5. Author           : 김회영
   6. Description      : 항로우선순위/Reveneu conversion  작업 처리
   7. Revision History : 2007.04.03  김회영         1.0  Created
                         2009.11.11  Chu Kyung-won  1.1  ALPS Migration
*******************************************************************************/

BEGIN


   -------------------------------[ 항로우선순위/Reveneu conversion  작업 처리         ]----------------------- 
    UPDATE agt_comm_bkg_info
       SET
         ( estm_ioc_div_cd,
           rlane_cd,
           rev_vvd_cd
         )
         =
         (     SELECT
                 CASE rnk
                 WHEN 1
                 THEN n1st_conti
                 WHEN 2
                 THEN n2nd_conti
                 WHEN 3
                 THEN n3rd_conti
                 WHEN 4
                 THEN n4th_conti
                 ELSE ''
                  END                 AS estm_ioc_div_cd,
                 CASE
                    ( CASE rnk
                      WHEN 1
                      THEN n1st_rlane_cd
                      WHEN 2
                      THEN n2nd_rlane_cd
                      WHEN 3
                      THEN n3rd_rlane_cd
                      ELSE n4th_rlane_cd
                      END
                    )
                 WHEN 'RBCCO'
                 THEN 'CFDR'
                   || TO_CHAR (SYSDATE, 'YYMM')
                   || 'EE'
                 ELSE
                    (
                      CASE rnk
                      WHEN 1
                      THEN n1st_rlane_cd
                      WHEN 2
                      THEN n2nd_rlane_cd
                      WHEN 3
                      THEN n3rd_rlane_cd
                      ELSE n4th_rlane_cd
                      END
                    )
                  END                 AS rlane_cd,
                 CASE
                 WHEN 'RBC' = SUBSTR (CASE rnk WHEN 1 THEN n1st_rlane_cd WHEN 2 THEN n2nd_rlane_cd WHEN 3 THEN n3rd_rlane_cd ELSE n4th_rlane_cd END,1,3)
                 THEN
                    (
                 CASE
                 WHEN 'FD'  = SUBSTR (n1st_vvd_cd, 1, 2)
                 THEN 'CFDR'
                   ||
                    (
                      CASE SUBSTR (n1st_vvd_cd, 3, 4)
                      WHEN '9999'
                      THEN TO_CHAR (SYSDATE, 'YYMM')||'EE'
                      ELSE SUBSTR (n1st_vvd_cd, 3, 4)
                      END
                    )
                 ELSE n1st_vvd_cd
                  END
                    )
                 ELSE
                    (
                      CASE rnk
                      WHEN 1
                      THEN n1st_vvd_cd
                      WHEN 2
                      THEN n2nd_vvd_cd
                      WHEN 3
                      THEN n3rd_vvd_cd
                      ELSE n4th_vvd_cd
                       END
                    )
                  END                 AS rev_vvd_cd
                 FROM
                    (     SELECT
                                 COA_RANK_INFO_FNC (--n1st_rlane_cd,n2nd_rlane_cd,n3rd_rlane_cd,n4th_rlane_cd,n1st_conti,n2nd_conti,n3rd_conti,n4th_conti) AS RNK,
                                 NVL (SAQ_GET_RLANE_FNC(first_lane_cd,first_pol_cd,first_pod_cd), 'RBCCO') ,--AS n1st_rlane_cd,
                            CASE
                            WHEN second_lane_cd IS NULL
                            THEN ''
                            ELSE SAQ_GET_RLANE_FNC (second_lane_cd,second_pol_cd,second_pod_cd)
                             END                                                                           ,--AS n2nd_rlane_cd,
                            CASE
                            WHEN third_lane_cd IS NULL
                            THEN ''
                            ELSE SAQ_GET_RLANE_FNC (third_lane_cd,third_pol_cd,third_pod_cd)
                             END                                                                           ,--AS n3rd_rlane_cd,
                            CASE
                            WHEN fourth_lane_cd IS NULL
                            THEN ''
                            ELSE SAQ_GET_RLANE_FNC (fourth_lane_cd,fourth_pol_cd,fourth_pod_cd)
                             END                                                                           ,--AS n4th_rlane_cd,
                            CASE
                            WHEN X_1_POL_CONTI = X_1_POD_CONTI
                            THEN 'I'||X_1_POD_CONTI
                            ELSE 'OO'
                             END                                                                           ,--AS n1st_conti,
                            CASE
                            WHEN X_2_POL_CONTI = X_2_POD_CONTI
                            THEN 'I'||X_2_POD_CONTI
                            ELSE 'OO'
                             END                                                                           ,--AS n2nd_conti,
                            CASE
                            WHEN X_3_POL_CONTI = X_3_POD_CONTI
                            THEN 'I'||X_3_POD_CONTI
                            ELSE 'OO'
                             END                                                                           ,--AS n3rd_conti,
                            CASE
                            WHEN X_4_POL_CONTI = X_4_POD_CONTI
                            THEN 'I'||X_4_POD_CONTI
                            ELSE 'OO'
                             END                                                                           )--AS n4th_conti
                              AS rnk,
                                 NVL (SAQ_GET_RLANE_FNC (first_lane_cd,first_pol_cd,first_pod_cd), 'RBCCO') AS n1st_rlane_cd,
                            CASE
                            WHEN second_lane_cd IS NULL
                            THEN ''
                            ELSE SAQ_GET_RLANE_FNC (second_lane_cd,second_pol_cd,second_pod_cd)
                             END                                                                           AS n2nd_rlane_cd,
                            CASE
                            WHEN third_lane_cd IS NULL
                            THEN ''
                            ELSE SAQ_GET_RLANE_FNC (third_lane_cd,third_pol_cd,third_pod_cd)
                             END                                                                           AS n3rd_rlane_cd,
                            CASE
                            WHEN fourth_lane_cd IS NULL
                            THEN ''
                            ELSE SAQ_GET_RLANE_FNC (fourth_lane_cd,fourth_pol_cd,fourth_pod_cd)
                             END                                                                           AS n4th_rlane_cd,
                                 x_first_vvd
                              || NVL (COA_REV_DIR_CONV_FNC (first_lane_cd, first_pol_cd, SUBSTR (x_first_vvd,9,1)), SUBSTR (x_first_vvd,9,1))
                                                                                                           AS n1st_vvd_cd,
                                 x_second_vvd
                              ||
                            CASE second_lane_cd
                            WHEN NULL
                            THEN SUBSTR (x_second_vvd,9,1)
                            ELSE NVL (COA_REV_DIR_CONV_FNC (second_lane_cd, second_pol_cd, SUBSTR (x_second_vvd,9,1)), SUBSTR (x_second_vvd,9,1))
                             END                                                                           AS n2nd_vvd_cd,
                                 x_third_vvd
                              ||
                            CASE third_lane_cd
                            WHEN NULL
                            THEN SUBSTR (x_third_vvd,9,1)
                            ELSE NVL (COA_REV_DIR_CONV_FNC (third_lane_cd, third_pol_cd, SUBSTR (x_third_vvd,9,1)), SUBSTR (x_third_vvd,9,1))
                             END                                                                           AS n3rd_vvd_cd,
                                 x_fourth_vvd
                              ||
                            CASE fourth_lane_cd
                            WHEN NULL
                            THEN SUBSTR (x_fourth_vvd,9,1)
                            ELSE NVL (COA_REV_DIR_CONV_FNC (fourth_lane_cd, fourth_pol_cd, SUBSTR (x_fourth_vvd,9,1)), SUBSTR (x_fourth_vvd,9,1))
                             END                                                                           AS n4th_vvd_cd,
                            CASE
                            WHEN X_1_POL_CONTI = X_1_POD_CONTI
                            THEN 'I'||X_1_POD_CONTI
                            ELSE 'OO'
                             END                                                                           AS n1st_conti,
                            CASE
                            WHEN X_2_POL_CONTI = X_2_POD_CONTI
                            THEN 'I'||X_2_POD_CONTI
                            ELSE 'OO'
                             END                                                                           AS n2nd_conti,
                            CASE
                            WHEN X_3_POL_CONTI = X_3_POD_CONTI
                            THEN 'I'||X_3_POD_CONTI
                            ELSE 'OO'
                             END                                                                           AS n3rd_conti,
                            CASE
                            WHEN X_4_POL_CONTI = X_4_POD_CONTI
                            THEN 'I'||X_4_POD_CONTI
                            ELSE 'OO'
                             END                                                                           AS n4th_conti
                           FROM AGT_BOOKING_V
                           WHERE key_bkg_no = in_bkg_no
                             AND ROWNUM < 2
                    )
         )
     WHERE bkg_no = in_bkg_no
;
END AGT_BKG_REV_VVD_PRC;