CREATE OR REPLACE FUNCTION NISADM.TPB_GET_TRD_FNC 

/*******************************************************************************
   1. Object Name      : TPB_GET_TRD_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.08.10
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : rlane_cd, pol_cd, pod_cd 로 trd_cd를 구하는 Function
   7. Revision History : 2009.08.10  Park Sung-Jin  1.0  Created
*******************************************************************************/

(
    v_rlane_cd IN VARCHAR2
    , v_pol_cd IN VARCHAR2
    , v_pod_cd IN VARCHAR2
)

RETURN VARCHAR2

AUTHID CURRENT_USER

IS

v_trd_cd VARCHAR2(3);

BEGIN

    SELECT trd_cd INTO v_trd_cd
    FROM   mdm_dtl_rev_lane
    WHERE  rlane_cd = v_rlane_cd
    AND    fm_conti_cd = tpb_get_conti_fnc(v_pol_cd, rlane_cd)
    AND    to_conti_cd = tpb_get_conti_fnc(v_pod_cd, rlane_cd)
    AND    ROWNUM = 1
    ;

    RETURN v_trd_cd;

END ;