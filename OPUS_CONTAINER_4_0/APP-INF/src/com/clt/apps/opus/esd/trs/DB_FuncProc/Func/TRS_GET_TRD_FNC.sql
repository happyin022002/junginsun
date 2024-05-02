CREATE OR REPLACE FUNCTION TRS_GET_TRD_FNC (v_rlane_cd IN VARCHAR2, v_pol_cd IN VARCHAR2, v_pod_cd IN VARCHAR2)

RETURN VARCHAR2
AUTHID CURRENT_USER
IS
/******************************************************************************
   Name         :   TRS_GET_TRD_FNC
   Purpose      :   rlane_cd, pol_cd, pod_cd 로 trd_cd를 구하는 Function
   Table        :   mdm_dtl_rev_lane
   Ver          :   1.0
   Date         :   2009.08.17
   System       :   e-NIS > YMS > SAQ
   Author       :   최종혁
   History      :   SAQ_GET_TRD_FNC --> TRS_GET_TRD_FNC 로 변경
******************************************************************************/
  v_trd_cd VARCHAR2(3);

BEGIN

	SELECT trd_cd INTO v_trd_cd
	FROM   mdm_dtl_rev_lane
	WHERE  rlane_cd = v_rlane_cd
	AND    fm_conti_cd = trs_get_conti_fnc(v_pol_cd, rlane_cd)
	AND    to_conti_cd = trs_get_conti_fnc(v_pod_cd, rlane_cd)
	AND    ROWNUM = 1
	;

	RETURN v_trd_cd;
END ;
