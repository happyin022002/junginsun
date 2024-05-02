CREATE OR REPLACE VIEW NISADM.SPC_ORGANIZATION_V
(
    OFC_TP_CD,
    OFC_CD,
    OFC_ENG_NM,
    OFC_KRN_NM,
    PRNT_OFC_CD,
    OFC_KND_CD,
    DELT_FLG,
    OFC_SLS_DELT_FLG,
    LVL,
    N1ST_PRNT_OFC_CD,
    N2ND_PRNT_OFC_CD,
    N3RD_PRNT_OFC_CD,
    N4TH_PRNT_OFC_CD,
    N5TH_PRNT_OFC_CD,
    N6TH_PRNT_OFC_CD,
    N7TH_PRNT_OFC_CD,
    SAQ_RGN_OFC_CD,
    SPC_SLS_OFC_CD
)
AS
SELECT DECODE(z.ofc_cd, 'NYCWP' , 'BB' , 'NYCRAS', 'BB' , z.ofc_tp_cd ) AS ofc_tp_cd,
  z.ofc_cd ,
  z.ofc_eng_nm ,
  z.ofc_krn_nm ,
  z.prnt_ofc_cd ,
  z.ofc_knd_cd ,
  z.delt_flg ,
  z.ofc_sls_delt_flg,
  DECODE(z.ofc_cd, 'NYCWP' , '4' , 'NYCRAS', '4' , DECODE(z.ofc_tp_cd, 'QT', 3, 'SQ', 3, LENGTH(z.ofc) / 6) ) AS lvl,
  DECODE(z.ofc_tp_cd, 'QT', 'SELHO', 'SQ', 'SELHO', TRIM(SUBSTR(z.ofc, 1, 6))) AS n1st_prnt_ofc_cd,
  DECODE(z.ofc_tp_cd, 'QT', z.prnt_ofc_cd, 'SQ', z.prnt_ofc_cd, TRIM(SUBSTR(z.ofc, 7, 6))) AS n2nd_prnt_ofc_cd,
  DECODE(z.ofc_cd, 'NYCWP' , '' , 'NYCRAS', '' , DECODE(z.ofc_tp_cd, 'QT', z.ofc_cd, TRIM(SUBSTR(z.ofc, 13, 6))) ) AS n3rd_prnt_ofc_cd,
  DECODE(z.ofc_cd, 'NYCWP' , 'NYCWP' , 'NYCRAS', 'NYCRAS' , TRIM(SUBSTR(z.ofc, 19, 6)) ) AS n4th_prnt_ofc_cd,
  TRIM(SUBSTR(z.ofc, 25, 6)) AS n5th_prnt_ofc_cd,
  TRIM(SUBSTR(z.ofc, 31, 6)) AS n6th_prnt_ofc_cd,
  TRIM(SUBSTR(z.ofc, 37, 6)) AS n7th_prnt_ofc_cd,
  NVL((
        SELECT c.conv_rgn_ofc_cd
        FROM spc_rgn_ofc_conv c
        WHERE c.sls_rgn_ofc_cd = z.ofc_cd), z.ofc_cd ) AS saq_rgn_ofc_cd ,
  (
          CASE
            WHEN LENGTH(z.ofc) / 6 >= 5 THEN TRIM(SUBSTR(z.ofc, 25, 6))
            ELSE z.ofc_cd
          END ) AS spc_sls_ofc_cd
FROM (
    SELECT m.ofc_tp_cd , m.ofc_cd , m.ofc_eng_nm , m.ofc_krn_nm , m.prnt_ofc_cd , m.ofc_knd_cd , m.delt_flg , m.ofc_sls_delt_flg, (
        SELECT (
                          CASE
                            WHEN ( COUNT(1) = 1
                  AND MAX(DECODE(o.ofc_tp_cd, 'HO', 'Y')) = 'Y')
                OR MAX(DECODE(o.ofc_tp_cd, 'HO', 'Y', 'N')) || MAX(DECODE(o.ofc_tp_cd, 'HQ', 'Y', 'N')) = 'YY' THEN DECODE(MAX(DECODE(o.ofc_tp_cd, 'AQ', 'Y', 'N')) , 'Y', RPAD(MAX(DECODE(ROWNUM, 9, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 8, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 7, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 6, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 5, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 4, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 3, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 2, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 1, o.ofc_cd)), 6, ' ') , RPAD(MAX(DECODE(ROWNUM, 9, o.ofc_cd)), 6, ' ') || RPAD(MAX(DECODE(ROWNUM, 8, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 9, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 7, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 8, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 6, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 7, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 5, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 6, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 4, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 5, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 3, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 4, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 2, o.ofc_cd)), 6, ' ') || DECODE(COUNT(1), 3, '      ', '') || RPAD(MAX(DECODE(ROWNUM, 1, o.ofc_cd)), 6, ' ') )
                            ELSE ''
                          END ) AS ofc_cd
        FROM mdm_organization o
        WHERE o.ofc_tp_cd IN ('HO', 'HQ', 'AQ', 'BB', 'BA', 'BS', 'AF') -- NYCRA의 LAXDD, CHIND를 AREA처럼 취급하기위해 추가
          AND NOT EXISTS (
            SELECT 1
            FROM spc_rgn_ofc_conv c
            WHERE c.sls_rgn_ofc_cd = o.ofc_cd 
            AND  NVL(c.SPC_CTRL_ALOC_RMK_FLG ,'N') = 'N' ) CONNECT BY NOCYCLE PRIOR o.prnt_ofc_cd = o.ofc_cd START WITH o.ofc_cd = m.ofc_cd
          AND o.ofc_tp_cd IN ('HO', 'HQ', 'AQ', 'BB', 'BA', 'BS', 'AF') -- NYCRA의 LAXDD, CHIND를 AREA처럼 취급하기위해 추가
          AND NOT EXISTS (
            SELECT 1
            FROM spc_rgn_ofc_conv c
            WHERE c.sls_rgn_ofc_cd = o.ofc_cd 
            AND  NVL(c.SPC_CTRL_ALOC_RMK_FLG ,'N') = 'N')

--ORDER BY LEVEL DESC
          ) AS ofc
    FROM mdm_organization m ) z
WHERE z.ofc_cd NOT IN ('SHADPI');

GRANT SELECT ON NISADM.SPC_ORGANIZATION_V TO NISDEV;
