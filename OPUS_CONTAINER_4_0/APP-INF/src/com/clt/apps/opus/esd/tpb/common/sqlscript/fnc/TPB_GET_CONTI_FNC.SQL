CREATE OR REPLACE FUNCTION OPUSADM."TPB_GET_CONTI_FNC" 

/*******************************************************************************
   1. Object Name      : TPB_GET_CONTI_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.08.10
   4. Sub System       : Third Party Billing
   5. Author           : Sun, Choi
   6. Description      : location code 의 conti code 를 구함.
   7. Revision History : 2009.08.10  Park Sung-Jin  1.0  SAQ_GET_CONTI_FNC, TES_GET_CONTI_FNC를 그대로 가져와 사용
*******************************************************************************/

(
    v_loc_cd IN VARCHAR2, v_rlane_cd IN VARCHAR2 := NULL
)

RETURN VARCHAR2

AUTHID CURRENT_USER

IS

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

GRANT EXECUTE ON OPUSADM.TPB_GET_CONTI_FNC TO OPUSDEV;
GRANT EXECUTE ON OPUSADM.TPB_GET_CONTI_FNC TO OPUS_ROLE;