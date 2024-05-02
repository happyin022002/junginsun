CREATE OR REPLACE FUNCTION SCE_IS_TML_DWL_STS_FNC(v_cntr_no IN VARCHAR)
/*******************************************************************************
   1. Object Name      : SCE_GET_LST_MVMT
   2. Version          : 1.0
   3. Create Date      : 2011.07.07
   4. Sub System       : SCE
   5. Author           : 조풍연
   6. Description      : 해당 CNTR의 마지막 Movement STS가 VD-IC인 MOVEMENT 정보를 리턴한다.
   7. Revision History : 2011.07.07 조풍연 최초 생성
*******************************************************************************/

RETURN VARCHAR2
authid current_user
IS
    v_return_flg  VARCHAR2(1);
    v_mvmt_sts    VARCHAR2(4);

BEGIN

    SELECT LEAD_MVMT_STS_CD||CUR_MVMT_STS_CD
    INTO v_mvmt_sts
    FROM
    (
        SELECT CNMV_YR, CNTR_NO, CNMV_ID_NO
        , LEAD(MVMT_STS_CD, 1) OVER (ORDER BY CNMV_YR DESC, CNTR_NO, CNMV_ID_NO DESC) LEAD_MVMT_STS_CD
        , MVMT_STS_CD CUR_MVMT_STS_CD
        FROM CTM_MOVEMENT I_CTM
        WHERE I_CTM.CNTR_NO = v_cntr_no
        ORDER BY CNMV_YR DESC, CNTR_NO, CNMV_ID_NO DESC
    ) O_CTM
    WHERE ROWNUM = 1;

    IF (v_mvmt_sts = 'VDIC') THEN v_return_flg := 'Y';
    ELSE v_return_flg := 'N';
    END IF;
  RETURN v_return_flg;
END SCE_IS_TML_DWL_STS_FNC;
/
