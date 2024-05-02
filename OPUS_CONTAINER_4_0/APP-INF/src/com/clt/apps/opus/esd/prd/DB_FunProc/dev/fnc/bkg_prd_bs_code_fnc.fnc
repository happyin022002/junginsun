CREATE OR REPLACE FUNCTION BKG_PRD_BS_CODE_FNC 

/*******************************************************************************
   1. Object Name      : BKG_PRD_BS_CODE_FNC
   2. Version          : 1.0
   3. Create Date      : 2009.11.06
   4. Sub System       : Booking/Doc
   5. Author           : 오명석
   6. Description      : CMDT, C/M 정보로 Block Stowage Code를 구하는 Function
   7. Revision History : 2009.11.06 오명석 최초 생성
*******************************************************************************/
(
	IN_POD IN VARCHAR2,
	IN_DEL IN VARCHAR2,
	IN_LANE IN VARCHAR2
)

 RETURN VARCHAR2
 authid current_user
 IS
	V_BS_CODE   VARCHAR2(10);

BEGIN
	SELECT B.BLCK_STWG_CD || B.VSL_SLAN_CD
	  INTO V_BS_CODE
	  FROM PRD_BLCK_STWG B, PRD_INLND_ROUT_MST R
	 WHERE B.PORT_CD = IN_POD ------ POD 조건
	   AND B.PORT_CD = SUBSTR(R.ROUT_ORG_NOD_CD, 1, 5)
	   AND SUBSTR(R.ROUT_DEST_NOD_CD, 1, 5) = IN_DEL ------ DEL 조건
	   AND B.VSL_SLAN_CD = IN_LANE ------ LANE조건 
	   AND R.PCTL_IO_BND_CD IN ('I', 'B')
	   AND NVL(R.DELT_FLG, 'N') <> 'Y'
	   AND NVL(R.INLND_ROUT_BKG_FLG, 'N') = 'Y'
	   AND B.HUB_LOC_CD = SUBSTR(R.HUB_NOD_CD, 1, 5)
	   AND ROWNUM = 1;
	
	RETURN(V_BS_CODE);
END;
/
