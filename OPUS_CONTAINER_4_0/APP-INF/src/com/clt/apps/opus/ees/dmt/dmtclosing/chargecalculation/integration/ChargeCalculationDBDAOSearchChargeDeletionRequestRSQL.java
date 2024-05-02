/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request 된 Charge Deletion 정보를 수정한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionRequestRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	 C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("    ,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("    ,C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("    ,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,B.BKG_NO" ).append("\n"); 
		query.append("	,C.OFC_CD" ).append("\n"); 
		query.append("    ,C.CHG_SEQ" ).append("\n"); 
		query.append("	,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("    ,C.CNTR_NO" ).append("\n"); 
		query.append("    ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,DD.RQST_USR_ID" ).append("\n"); 
		query.append("	,DD.RQST_OFC_CD" ).append("\n"); 
		query.append("	,DD.RQST_DT" ).append("\n"); 
		query.append("	,DD.DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("    ,( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD01965'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = DD.DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("      ) DELT_RSN_DESC" ).append("\n"); 
		query.append("    ,DD.DELT_SEQ" ).append("\n"); 
		query.append("	,DD.DELT_RMK AS CORR_RMK" ).append("\n"); 
		query.append("    ,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("    ,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,C.TO_MVMT_STS_CD	" ).append("\n"); 
		query.append("    ,C.FT_DYS" ).append("\n"); 
		query.append("    ,C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT	" ).append("\n"); 
		query.append("    ,C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("    ,C.ORG_CHG_AMT" ).append("\n"); 
		query.append("    ,C.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("    ,C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("    ,C.BIL_AMT	" ).append("\n"); 
		query.append("	,DECODE(C.CHG_SEQ, 1, 'G', 'B' 	) AS GEN_BAL" ).append("\n"); 
		query.append("	,NVL(B.SOC_FLG, 'N') AS SOC_FLG" ).append("\n"); 
		query.append("    ,CASE" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD='ID' THEN 'L'" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD NOT IN ('ID','CS','DR') THEN 'I'" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD<>'POL' THEN 'L'" ).append("\n"); 
		query.append("        WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD='POL' THEN 'I'" ).append("\n"); 
		query.append("	END AS LI" ).append("\n"); 
		query.append("    ,(	SELECT NVL(HLG_TP_CD, 'N')      /* 'C'ARRIER, 'M'ERCHANT, 'N'ULL */" ).append("\n"); 
		query.append("    	FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("    	WHERE BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("    	AND  IO_BND_CD	= SUBSTR(C.DMDT_TRF_CD, 3, 1)    /* IN/OUT BOUND */" ).append("\n"); 
		query.append("    	AND  NVL(CXL_FLG, 'N')    = 'N'" ).append("\n"); 
		query.append("    	AND  CNTR_NO	= C.CNTR_NO" ).append("\n"); 
		query.append("		AND	 ROWNUM = 1" ).append("\n"); 
		query.append("    ) AS CH" ).append("\n"); 
		query.append("    ,(	SELECT 'Y' 	FROM DUAL" ).append("\n"); 
		query.append("    	WHERE EXISTS (SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("    	              FROM    BKG_DO BDO," ).append("\n"); 
		query.append("            		          BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    		          WHERE BDO.BKG_NO = BDD.BKG_NO" ).append("\n"); 
		query.append("    	              AND   BDO.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    		          AND   BDD.RLSE_STS_CD IN ('R', 'I')) " ).append("\n"); 
		query.append("	) AS D_O" ).append("\n"); 
		query.append("    ,(	SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("    	FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("            	BKG_DO_DTL BDD" ).append("\n"); 
		query.append("    	WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("   		AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("    	AND   BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("    	AND ROWNUM = 1 " ).append("\n"); 
		query.append("	) AS RLSE_OFC" ).append("\n"); 
		query.append("	, (select BR.CLT_OFC_CD FROM BKG_RATE BR where BR.BKG_NO = B.BKG_NO ) as CLT_OFC_CD	" ).append("\n"); 
		query.append("	,NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append("    ,(	SELECT 'S' FROM DUAL" ).append("\n"); 
		query.append("    	WHERE EXISTS (SELECT 1" ).append("\n"); 
		query.append("    		          FROM  BKG_ROLL_OVR R" ).append("\n"); 
		query.append("    		          WHERE R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    		          AND   R.ROLL_OVR_RSN_CD = 'S' )" ).append("\n"); 
		query.append("	) AS ROLL_OVR" ).append("\n"); 
		query.append("    ,C.DMDT_INV_NO" ).append("\n"); 
		query.append("    ,(SELECT  TO_CHAR(IM.CRE_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("      FROM DMT_INV_MN IM, DMT_INV_DTL ID" ).append("\n"); 
		query.append("      WHERE IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("      AND   IM.DMDT_INV_NO = ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	  AND   IM.CRE_OFC_CD  = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	  AND   IM.DMDT_INV_STS_CD = 'I'   " ).append("\n"); 
		query.append("      AND   ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("      AND   ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("      AND   ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("      AND   ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("      AND   ID.CHG_SEQ = DD.CHG_SEQ      ) AS ISS_DT" ).append("\n"); 
		query.append("	,(SELECT IM.INV_CURR_CD    " ).append("\n"); 
		query.append("      FROM DMT_INV_MN IM, DMT_INV_DTL ID" ).append("\n"); 
		query.append("      WHERE IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("      AND   IM.DMDT_INV_NO(+)= ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	  AND   IM.CRE_OFC_CD(+) = ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	  AND   IM.DMDT_INV_STS_CD = 'I' " ).append("\n"); 
		query.append("      AND   ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("      AND   ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("      AND   ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("      AND   ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("      AND   ID.CHG_SEQ = DD.CHG_SEQ   ) AS INV_CURR_CD" ).append("\n"); 
		query.append("	,(SELECT ID.CNTR_INV_AMT " ).append("\n"); 
		query.append("      FROM  DMT_INV_MN IM, DMT_INV_DTL ID" ).append("\n"); 
		query.append("      WHERE IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("      AND   IM.DMDT_INV_NO(+)	= ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	  AND   IM.CRE_OFC_CD(+)		= ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	  AND   IM.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("      AND   ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("      AND   ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("      AND   ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("      AND   ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("      AND   ID.CHG_SEQ = DD.CHG_SEQ    ) AS CNTR_INV_AMT" ).append("\n"); 
		query.append("	,(SELECT IM.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("      FROM  DMT_INV_MN IM, DMT_INV_DTL ID" ).append("\n"); 
		query.append("      WHERE IM.BKG_NO	= B.BKG_NO " ).append("\n"); 
		query.append("      AND   IM.DMDT_INV_NO(+)	= ID.DMDT_INV_NO" ).append("\n"); 
		query.append("	  AND   IM.CRE_OFC_CD(+)		= ID.CRE_OFC_CD" ).append("\n"); 
		query.append("	  AND   IM.DMDT_INV_STS_CD = 'I'" ).append("\n"); 
		query.append("      AND   ID.CNTR_NO  = DD.CNTR_NO" ).append("\n"); 
		query.append("      AND   ID.CNTR_CYC_NO = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("      AND   ID.DMDT_TRF_CD = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("      AND   ID.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("      AND   ID.CHG_SEQ = DD.CHG_SEQ    )AS DMDT_AR_IF_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("    ,DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("    ,DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE DD.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND   DD.CNTR_NO         = C.CNTR_NO" ).append("\n"); 
		query.append("AND   DD.CNTR_CYC_NO     = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND   DD.DMDT_TRF_CD      =   C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND   DD.DMDT_CHG_LOC_DIV_CD = C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND   DD.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("AND   B.SYS_AREA_GRP_ID	= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND   B.CNTR_NO         = C.CNTR_NO" ).append("\n"); 
		query.append("AND   B.CNTR_CYC_NO     = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND   C.DMDT_CHG_LOC_DIV_CD <> 'SZP'" ).append("\n"); 
		query.append("AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND   DD.DMDT_DELT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("AND   DD.CHG_OFC_CD IN (" ).append("\n"); 
		query.append("  #foreach( $chg_ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("	#if($velocityCount < $ofc_cd_list.size()) '$chg_ofc_cd', #else '$chg_ofc_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   DD.RQST_DT  BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''), 'yyyymmdd') AND TO_DATE(REPLACE(@[to_dt],'-',''), 'yyyymmdd') + 0.99999" ).append("\n"); 
		query.append("#if (${bkg_no} != '')	" ).append("\n"); 
		query.append("AND B.BKG_NO IN (" ).append("\n"); 
		query.append("  #foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("    #if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  DD.APRO_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 

	}
}