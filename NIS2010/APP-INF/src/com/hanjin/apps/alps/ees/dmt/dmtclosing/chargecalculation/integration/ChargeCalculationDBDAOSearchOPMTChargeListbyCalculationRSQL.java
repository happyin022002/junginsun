/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchOPMTChargeListbyCalculationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchOPMTChargeListbyCalculationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OP-MT detention으로 생성된 데이터를 조회한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchOPMTChargeListbyCalculationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchOPMTChargeListbyCalculationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT C.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append("    ,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("		SELECT  CASE " ).append("\n"); 
		query.append("					WHEN NVL(MAX(DD.DMDT_DELT_RQST_STS_CD), 'N') IN ('C', 'N') THEN 'N'" ).append("\n"); 
		query.append("					WHEN 0 < MAX((	" ).append("\n"); 
		query.append("								SELECT  COUNT(1)" ).append("\n"); 
		query.append("								  FROM  DMT_CHG_DELT_PATH " ).append("\n"); 
		query.append("								 WHERE  SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("								   AND  CNTR_NO             = DD.CNTR_NO" ).append("\n"); 
		query.append("								   AND  CNTR_CYC_NO         = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("								   AND  DMDT_TRF_CD         = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("								   AND  DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("								   AND  CHG_SEQ             = DD.CHG_SEQ" ).append("\n"); 
		query.append("								   AND  CHG_OFC_CD          = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("								   AND  DELT_SEQ            = DD.DELT_SEQ" ).append("\n"); 
		query.append("								   AND  CHG_DELT_PATH_LVL  >=" ).append("\n"); 
		query.append("										(" ).append("\n"); 
		query.append("											SELECT  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("											  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("											 WHERE  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("											   AND  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("											   AND  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("											   AND  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("											   AND  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("											   AND  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("											   AND  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("											   AND  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("											   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("								   and  CHG_DELT_STS_CD = 'A'" ).append("\n"); 
		query.append("							 )) THEN 'X'		--// Charge Deletion 요청 불가, Charge Deletion Cancel 불가" ).append("\n"); 
		query.append("					ELSE MAX(DD.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("		  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("		 WHERE  DD.SYS_AREA_GRP_ID     = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("		   AND	DD.CNTR_NO		       = C.CNTR_NO" ).append("\n"); 
		query.append("		   AND	DD.CNTR_CYC_NO		   = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("		   AND	DD.DMDT_TRF_CD		   = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("		   AND	DD.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("		   AND	DD.CHG_SEQ			   = C.CHG_SEQ" ).append("\n"); 
		query.append("		   AND  DD.CHG_OFC_CD          = C.OFC_CD" ).append("\n"); 
		query.append("		   AND  DD.DELT_SEQ            = " ).append("\n"); 
		query.append("				( " ).append("\n"); 
		query.append("					SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("					  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("					 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("					   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("					   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("					   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("					   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("					   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD  " ).append("\n"); 
		query.append("					   AND  DS.DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("				)  " ).append("\n"); 
		query.append("	 ) AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("    ,C.CNTR_NO    " ).append("\n"); 
		query.append("    ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,C.FT_DYS" ).append("\n"); 
		query.append("    ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("    ,C.ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FM_MVMT_DT, 'yyyymmdd') FM_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.TO_MVMT_DT, 'yyyymmdd') TO_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_CMNC_DT, 'yyyymmdd') FT_CMNC_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_END_DT, 'yyyymmdd') FT_END_DT" ).append("\n"); 
		query.append("    ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("    ,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("    ,C.SC_RFA_EXPT_AMT    " ).append("\n"); 
		query.append("    ,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("    ,C.BIL_AMT" ).append("\n"); 
		query.append("    ,B.BKG_NO" ).append("\n"); 
		query.append("    ,B.BL_NO" ).append("\n"); 
		query.append("    ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD_CD    " ).append("\n"); 
		query.append("    ,( SELECT	V.VSL_SLAN_CD LANE   " ).append("\n"); 
		query.append("       FROM		VSK_VSL_SKD V" ).append("\n"); 
		query.append("       WHERE	B.VSL_CD		=	V.VSL_CD" ).append("\n"); 
		query.append("       AND		B.SKD_VOY_NO	=	V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND		B.SKD_DIR_CD	=	V.SKD_DIR_CD" ).append("\n"); 
		query.append("    ) AS LANE" ).append("\n"); 
		query.append("    ,B.POR_CD" ).append("\n"); 
		query.append("    ,B.POL_CD" ).append("\n"); 
		query.append("    ,B.POD_CD" ).append("\n"); 
		query.append("    ,B.DEL_CD" ).append("\n"); 
		query.append("    ,B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("    ,B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    ,B.SC_NO" ).append("\n"); 
		query.append("    ,B.RFA_NO" ).append("\n"); 
		query.append("    ,DECODE( BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')),'000000', NULL" ).append("\n"); 
		query.append("        	,BK.AGMT_ACT_CNT_CD||TRIM(TO_CHAR(BK.AGMT_ACT_CUST_SEQ, '000000')) ) AS ACUST	" ).append("\n"); 
		query.append("    ,DECODE(C.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append("	,C.CHG_SEQ" ).append("\n"); 
		query.append("	,NVL(B.SOC_FLG, 'N') AS SOC_FLG" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD='ID' THEN 'L'" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD NOT IN ('ID','CS','DR') THEN 'I'" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD<>'POL' THEN 'L'" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD='POL' THEN 'I'" ).append("\n"); 
		query.append("     END AS LI" ).append("\n"); 
		query.append("	,(	SELECT NVL(HLG_TP_CD, 'N')" ).append("\n"); 
		query.append("		FROM	BKG_EUR_TRO" ).append("\n"); 
		query.append("		WHERE	BKG_NO				= B.BKG_NO" ).append("\n"); 
		query.append("			AND	IO_BND_CD			= SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			AND	NVL(CXL_FLG, 'N')	= 'N'" ).append("\n"); 
		query.append("			AND	CNTR_NO	= C.CNTR_NO" ).append("\n"); 
		query.append("			AND ROWNUM = 1 ) AS CH" ).append("\n"); 
		query.append("	,(	SELECT 'Y'" ).append("\n"); 
		query.append("    	FROM DUAL      " ).append("\n"); 
		query.append("    	WHERE EXISTS (" ).append("\n"); 
		query.append("    		SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("    		FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("            		BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    		WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("   			AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("    			AND   BDD.RLSE_STS_CD IN ('R', 'I')) ) AS D_O" ).append("\n"); 
		query.append("	,(	SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("    	FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("        	    BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    	WHERE	BDO.BKG_NO	= BDD.BKG_NO   " ).append("\n"); 
		query.append("    		AND BDO.BKG_NO	= B.BKG_NO   " ).append("\n"); 
		query.append("    		AND BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("			AND	ROWNUM=1 ) AS RLSE_OFC" ).append("\n"); 
		query.append("	,BR.CLT_OFC_CD" ).append("\n"); 
		query.append("	,NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("	,(	SELECT 'C'" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("    	WHERE EXISTS (" ).append("\n"); 
		query.append("    		SELECT 1" ).append("\n"); 
		query.append("    		FROM	BKG_ROLL_OVR R" ).append("\n"); 
		query.append("    		WHERE	R.BKG_NO = B.BKG_NO    			" ).append("\n"); 
		query.append("    			AND R.ROLL_OVR_RSN_CD IN ( 'C','H' )) ) AS ROLL_OVR	" ).append("\n"); 
		query.append("    ,C.WEB_IND_FLG" ).append("\n"); 
		query.append("    ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("    ,C.DMDT_CHG_LOC_DIV_CD	" ).append("\n"); 
		query.append("	,C.OFC_CD" ).append("\n"); 
		query.append("	,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("	,DECODE( DECODE(C.ACT_CNT_CD,'00','',C.ACT_CNT_CD) || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("			,'000000' , NULL, DECODE(C.ACT_CNT_CD,'00','',C.ACT_CNT_CD) || TO_CHAR(C.ACT_CUST_SEQ, 'FM000000')) PAYER_CD" ).append("\n"); 
		query.append("	,CASE	" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD='DTIC' " ).append("\n"); 
		query.append("		##AND B.BKG_DE_TERM_CD='Y'" ).append("\n"); 
		query.append("		AND INSTR(NVL(B.POD_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("		(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	   		FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   		WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD='DTOC' " ).append("\n"); 
		query.append("		##AND B.BKG_RCV_TERM_CD='Y'" ).append("\n"); 
		query.append("		AND INSTR(NVL(B.POL_CD,'  '),'US')=1 THEN" ).append("\n"); 
		query.append("		(	SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   		WHERE MV.VNDR_SEQ = C.VNDR_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD IN ('DMIF','CTIC') OR (C.DMDT_TRF_CD='DTIC' AND INSTR(NVL(B.POD_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("		(	SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("			WHERE MC.CUST_CNT_CD = C.ACT_CNT_CD" ).append("\n"); 
		query.append("			AND MC.CUST_SEQ = C.ACT_CUST_SEQ	)" ).append("\n"); 
		query.append("	WHEN C.DMDT_TRF_CD IN ('DMOF','CTOC') OR (C.DMDT_TRF_CD='DTOC' AND INSTR(NVL(B.POL_CD,'  '),'US')<>1) THEN" ).append("\n"); 
		query.append("			REPLACE(BS.CUST_NM, CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("	END AS PAYER_NM" ).append("\n"); 
		query.append("    ,BS.CUST_CNT_CD || TRIM(TO_CHAR(BS.CUST_SEQ, '000000')) SHIPPER_CD " ).append("\n"); 
		query.append("    ,REPLACE(BS.CUST_NM, CHR(13) || CHR(10), ' ') SHIPPER_NM   " ).append("\n"); 
		query.append("    ,DECODE(BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000')), '000000', NULL, BC.CUST_CNT_CD || TRIM(TO_CHAR(BC.CUST_SEQ, '000000'))) CNEE_CD" ).append("\n"); 
		query.append("    ,REPLACE(BC.CUST_NM, CHR(13) || CHR(10), ' ') CNEE_NM" ).append("\n"); 
		query.append("    ,DECODE(BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000')), '000000', NULL, BN.CUST_CNT_CD || TRIM(TO_CHAR(BN.CUST_SEQ, '000000'))) NTFY_CD" ).append("\n"); 
		query.append("    ,NVL(RTRIM(REPLACE(REPLACE(BN.CUST_NM, CHR(34), ''), CHR(13)||CHR(10), ' ')), '-') NTFY_NM" ).append("\n"); 
		query.append("	,(	SELECT  I.ACT_CUST_CNT_CD || TRIM(TO_CHAR(ACT_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("    	FROM    INV_AR_MN I" ).append("\n"); 
		query.append("    	WHERE   I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    	AND     I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("		AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("		AND     ROWNUM  = 1" ).append("\n"); 
		query.append("	) AS AR_ACT_CD" ).append("\n"); 
		query.append("	,(	SELECT	MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		FROM 	MDM_CUSTOMER MC, INV_AR_MN I" ).append("\n"); 
		query.append("		WHERE	MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		AND		MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("		AND		I.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		AND		I.IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("		AND		AR_IF_NO	= (" ).append("\n"); 
		query.append("                    SELECT	MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                    FROM	INV_AR_MN" ).append("\n"); 
		query.append("                    WHERE	BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND		IO_BND_CD = SUBSTR(C.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("    	            )" ).append("\n"); 
		query.append("		AND		ROWNUM  = 1" ).append("\n"); 
		query.append("	) AS AR_ACT_NM" ).append("\n"); 
		query.append("	,DECODE(TRIM(TO_CHAR(C.VNDR_SEQ, '000000')), '000000', NULL, TRIM(TO_CHAR(C.VNDR_SEQ, '000000'))) AS SVC_PROVDR_CD" ).append("\n"); 
		query.append("	,(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	   FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("	   WHERE MV.VNDR_SEQ = C.VNDR_SEQ)   AS SVC_PROVDR_NM" ).append("\n"); 
		query.append("	,M.AR_CURR_CD" ).append("\n"); 
		query.append("FROM  DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("     ,DMT_CHG_CALC     C" ).append("\n"); 
		query.append("     ,BKG_BOOKING      BK" ).append("\n"); 
		query.append("     ,BKG_RATE         BR" ).append("\n"); 
		query.append("     ,MDM_ORGANIZATION M" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER     BS" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER     BC" ).append("\n"); 
		query.append("     ,BKG_CUSTOMER     BN" ).append("\n"); 
		query.append("WHERE  B.SYS_AREA_GRP_ID =  C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND    B.CNTR_NO         =   C.CNTR_NO" ).append("\n"); 
		query.append("AND    B.CNTR_CYC_NO     =   C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO          =   BK.BKG_NO" ).append("\n"); 
		query.append("AND    B.BKG_NO			 =	BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND    C.OFC_CD          =   M.OFC_CD" ).append("\n"); 
		query.append("AND    C.DMDT_TRF_CD IN ( 'CTOC','DTOC' )" ).append("\n"); 
		query.append("AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND    B.BKG_NO				=	BS.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BS.BKG_CUST_TP_CD(+) =   'S'" ).append("\n"); 
		query.append("AND    B.BKG_NO             =   BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("AND    B.BKG_NO            	=   BN.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("AND    C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("AND    C.FM_MVMT_STS_CD ='OP'" ).append("\n"); 
		query.append("AND    C.TO_MVMT_STS_CD ='MT'" ).append("\n"); 
		query.append("#if (${cond_type} == 'bkg')" ).append("\n"); 
		query.append("AND B.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'ofc')" ).append("\n"); 
		query.append("AND  C.OFC_CD  IN (" ).append("\n"); 
		query.append("	#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'loc')" ).append("\n"); 
		query.append("#if ($yd_cd.length() == 5)" ).append("\n"); 
		query.append("AND SUBSTR(C.TO_MVMT_YD_CD,1, 5) = @[yd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.TO_MVMT_YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'cntr')" ).append("\n"); 
		query.append("AND C.CNTR_NO IN (" ).append("\n"); 
		query.append("	#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cond_type} != 'bkg')" ).append("\n"); 
		query.append("AND (1=0" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if($chg_sts_cd_list1.size() > 0)" ).append("\n"); 
		query.append("			OR (" ).append("\n"); 
		query.append("				C.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("					#foreach( $chg_sts_cd in ${chg_sts_cd_list1} )" ).append("\n"); 
		query.append("						#if($velocityCount < $chg_sts_cd_list1.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND ( C.TO_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("		            				   AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999 )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if($chg_sts_cd_list2.size() > 0)" ).append("\n"); 
		query.append("			OR (" ).append("\n"); 
		query.append("				C.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("					#foreach( $chg_sts_cd in ${chg_sts_cd_list2} )" ).append("\n"); 
		query.append("						#if($velocityCount < $chg_sts_cd_list2.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND ( C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("		            				   AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999 )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if($chg_sts_cd_list3.size() > 0)" ).append("\n"); 
		query.append("			OR (" ).append("\n"); 
		query.append("				C.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("					#foreach( $chg_sts_cd in ${chg_sts_cd_list3} )" ).append("\n"); 
		query.append("						#if($velocityCount < $chg_sts_cd_list3.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND (( C.FM_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("		            				   AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999 )" ).append("\n"); 
		query.append("                     OR (C.TO_MVMT_DT BETWEEN TO_DATE(@[fm_mvmt_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("		            				   AND TO_DATE(@[to_mvmt_dt], 'YYYYMMDD') + 0.99999 ))" ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.CNTR_NO" ).append("\n"); 

	}
}