CREATE OR REPLACE FUNCTION TRS_GET_RLANE_FNC (v_slane_cd IN VARCHAR2, v_pol_cd IN VARCHAR2, v_pod_cd IN VARCHAR2, v_dir_cd IN VARCHAR2 := NULL)
RETURN VARCHAR2 
AUTHID CURRENT_USER
IS
/******************************************************************************
   NAME:       TRS_GET_RLANE_CD
   PURPOSE:

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        2009.08.06          1. Created this function.

   History      :   2009.08.06 - SAQ_GET_RLANE_FNC을 TRS_GET_RLANE_FNC으로 변경

******************************************************************************/

v_rlane_cd VARCHAR2(5);

BEGIN

   SELECT b.rlane_cd
   INTO   v_rlane_cd
   FROM   mdm_rev_lane a, mdm_dtl_rev_lane b
   WHERE  b.rlane_cd = a.rlane_cd
   AND    a.vsl_slan_cd = v_slane_cd
   AND    b.fm_conti_cd = saq_get_conti_fnc(v_pol_cd, b.rlane_cd)
   AND    b.to_conti_cd = saq_get_conti_fnc(v_pod_cd, b.rlane_cd)
   AND    b.vsl_slan_dir_cd = NVL(v_dir_cd, b.vsl_slan_dir_cd)
   AND    b.delt_flg = 'N'
   AND    ROWNUM = 1;

   RETURN v_rlane_cd;

   EXCEPTION
     WHEN NO_DATA_FOUND THEN
	   RETURN NULL;
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
     RAISE;
END TRS_GET_RLANE_FNC;