/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBooking2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBooking2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Container 정보를 DMT_CHG_CALC 에서 조회한다.
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBooking2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tariff",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBooking2RSQL").append("\n"); 
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
		query.append("SELECT	'I' IBFLAG" ).append("\n"); 
		query.append("	,	CHG_CALC.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,	CHG_CNTR.CNTR_NO" ).append("\n"); 
		query.append("	,	CHG_CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,	CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("	,	CHG_CNTR.BL_NO" ).append("\n"); 
		query.append("	,   CHG_CNTR.POR_CD" ).append("\n"); 
		query.append("	,   CHG_CNTR.POL_CD" ).append("\n"); 
		query.append("	,   CHG_CNTR.POD_CD" ).append("\n"); 
		query.append("	,   CHG_CNTR.DEL_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.FT_DYS" ).append("\n"); 
		query.append("	,	CHG_CALC.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,	CHG_CALC.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.BIL_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.BIL_AMT ORG_BIL_AMT" ).append("\n"); 
		query.append("	,	DECODE(CHG_CALC.CHG_SEQ, 1, 'G', 'B') CHG_SEQ_DESC" ).append("\n"); 
		query.append("	,	DECODE(INV_MN.DMDT_AR_IF_CD, 'H', '', INV_MN.DMDT_AR_IF_CD) DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	,	CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("	,	CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.CHG_SEQ" ).append("\n"); 
		query.append("	,	CHG_CALC.OFC_CD" ).append("\n"); 
		query.append("	,(	" ).append("\n"); 
		query.append("		SELECT	DECODE(PRNT_OFC_CD, 'TPEBA', 'TPESC', PRNT_OFC_CD) PRNT_OFC_CD" ).append("\n"); 
		query.append("		FROM	MDM_ORGANIZATION" ).append("\n"); 
		query.append("		WHERE	OFC_CD = CHG_CALC.OFC_CD" ).append("\n"); 
		query.append("	) AS PRNT_OFC_CD" ).append("\n"); 
		query.append("	,	'' AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	'' AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	,	'' AFT_EXPT_CNTR_SEQ" ).append("\n"); 
		query.append("	,	0 FT_ADJ_FLG" ).append("\n"); 
		query.append("	,	'' FT_ADD_DYS" ).append("\n"); 
		query.append("	,	'' FT_TTL_DYS" ).append("\n"); 
		query.append("	,	0 XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,	0 XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,	0 XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,	0 CNTR_CHG_DC_FLG" ).append("\n"); 
		query.append("	,	'' CURR_CD" ).append("\n"); 
		query.append("	,	'' CNTR_CHG_DC_AMT" ).append("\n"); 
		query.append("	,	'' CNTR_CHG_DC_RTO" ).append("\n"); 
		query.append("	,	'' CNTR_CHG_DC_RTO2" ).append("\n"); 
		query.append("    ,   DECODE(CHG_CALC.AFT_EXPT_DC_AMT, 0, CHG_CALC.BIL_AMT, (CHG_CALC.BIL_AMT- CHG_CALC.AFT_EXPT_DC_AMT)) AS BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.OFC_RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   CHG_CALC.BZC_TRF_CURR_CD AS RQST_CURR_CD" ).append("\n"); 
		query.append("	,   CHG_CALC.BIL_AMT AS RQST_BIL_AMT" ).append("\n"); 
		query.append("	,   0 AS RQST_DC_AMT" ).append("\n"); 
		query.append("	,   0 AS RQST_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,   CHG_CALC.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,   CHG_CALC.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.FM_MVMT_DT, 'YYYYMMDD')    AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.FM_MVMT_DT, 'HH24MI')      AS FM_MVMT_DT_TIME" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.TO_MVMT_DT, 'YYYYMMDD')    AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.TO_MVMT_DT, 'HH24MI')       AS TO_MVMT_DT_TIME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR 	CHG_CNTR" ).append("\n"); 
		query.append("	,	DMT_CHG_CALC 		CHG_CALC" ).append("\n"); 
		query.append("	,	DMT_INV_MN 			INV_MN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	CHG_CNTR.BKG_NO 			= @[bkg_no]" ).append("\n"); 
		query.append("	AND CHG_CNTR.SYS_AREA_GRP_ID 	= CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND	CHG_CNTR.CNTR_NO 			= CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("	AND CHG_CNTR.CNTR_CYC_NO 		= CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_TRF_CD 		= @[tariff]" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_STS_CD 	 NOT IN ('P', 'T', 'E')" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_INV_NO 		= INV_MN.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("    AND NOT (CHG_CALC.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(CHG_CALC.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("ORDER BY AFT_EXPT_ADJ_SEQ, CNTR_NO, CHG_SEQ" ).append("\n"); 

	}
}