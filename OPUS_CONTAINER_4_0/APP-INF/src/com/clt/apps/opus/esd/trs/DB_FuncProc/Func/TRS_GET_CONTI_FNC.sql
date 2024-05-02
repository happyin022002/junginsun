CREATE OR REPLACE FUNCTION TRS_GET_CONTI_FNC (v_loc_cd IN VARCHAR2, v_rlane_cd IN VARCHAR2 := NULL)
RETURN VARCHAR2
AUTHID CURRENT_USER
IS
/******************************************************************************
   Name         :   TRS_GET_CONTI_FNC
   Purpose      :   location code 의 conti code 를 구하는 Function
   Table        :   mdm_location
   Ver          :   1.0
   Date         :   2009.08.06
   System       :   e-NIS > TRS
   Author       :   최종혁
   History      :   2009.02.11 최윤성 - 'RESIA' Lane에 대한 처리
                    2009.08.06 최종혁 - SAQ_GET_CONTI_FNC 에서 TRS_GET_CONTI_FNC 로 변경
******************************************************************************/

  v_conti_cd VARCHAR2(1);

BEGIN

	SELECT conti_cd
	INTO   v_conti_cd
	FROM   mdm_location
	WHERE  loc_cd = v_loc_cd
	;
    IF v_rlane_cd IS NOT NULL THEN
        IF v_conti_cd = 'F' THEN
            CASE v_rlane_cd
            WHEN 'INXTP' THEN
                v_conti_cd := 'A';
            WHEN 'RESIA' THEN
                v_conti_cd := 'A';
            ELSE
                v_conti_cd := 'E';
            END CASE;
        END IF;
    END IF;
    RETURN v_conti_cd;

END ;