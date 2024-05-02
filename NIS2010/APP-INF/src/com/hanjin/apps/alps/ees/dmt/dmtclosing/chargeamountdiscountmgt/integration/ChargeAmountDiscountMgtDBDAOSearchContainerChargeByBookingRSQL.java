/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30 
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

public class ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너별 지불금액정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchContainerChargeByBookingRSQL").append("\n"); 
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
		query.append("SELECT	'R' IBFLAG" ).append("\n"); 
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
		query.append("	,	DECODE(CHG_CALC.CHG_SEQ, 1, 'G', 'B') CHG_SEQ_DESC" ).append("\n"); 
		query.append("	,	CHG_CALC.FT_DYS" ).append("\n"); 
		query.append("	,	CHG_CALC.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,	CHG_CALC.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("    ,  ((CHG_CALC.BIL_AMT + NVL(CHG_CALC.AFT_EXPT_DC_AMT,0)) - NVL(AFT_CNTR.BIL_AFT_DC_AMT, (CHG_CALC.BIL_AMT + NVL(CHG_CALC.AFT_EXPT_DC_AMT,0)))) AS AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,  (CHG_CALC.BIL_AMT + NVL(CHG_CALC.AFT_EXPT_DC_AMT,0)) AS BIL_AMT " ).append("\n"); 
		query.append("	,  (CHG_CALC.BIL_AMT + NVL(CHG_CALC.AFT_EXPT_DC_AMT,0)) ORG_BIL_AMT" ).append("\n"); 
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
		query.append("	,	AFT_CNTR.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	AFT_CNTR.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	,	AFT_CNTR.AFT_EXPT_CNTR_SEQ" ).append("\n"); 
		query.append("	,	DECODE(AFT_CNTR.FT_ADJ_FLG, 'Y', 1, 0) FT_ADJ_FLG" ).append("\n"); 
		query.append("	,	AFT_CNTR.FT_ADD_DYS" ).append("\n"); 
		query.append("	,	AFT_CNTR.FT_TTL_DYS" ).append("\n"); 
		query.append("	,	DECODE(AFT_CNTR.XCLD_SAT_FLG, 'Y', 1, 0) XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,	DECODE(AFT_CNTR.XCLD_SUN_FLG, 'Y', 1, 0) XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,	DECODE(AFT_CNTR.XCLD_HOL_FLG, 'Y', 1, 0) XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,	CASE " ).append("\n"); 
		query.append("			WHEN NVL(AFT_CNTR.CNTR_CHG_DC_AMT, 0) = 0 AND NVL(AFT_CNTR.CNTR_CHG_DC_RTO, 0) = 0 " ).append("\n"); 
		query.append("				THEN 0 " ).append("\n"); 
		query.append("				ELSE 1 " ).append("\n"); 
		query.append("		END CNTR_CHG_DC_FLG" ).append("\n"); 
		query.append("	,	CASE " ).append("\n"); 
		query.append("			WHEN NVL(AFT_CNTR.CNTR_CHG_DC_AMT, 0) = 0 AND NVL(AFT_CNTR.CNTR_CHG_DC_RTO, 0) = 0 " ).append("\n"); 
		query.append("				THEN '' " ).append("\n"); 
		query.append("				ELSE ADJ_RQST_DTL.CURR_CD " ).append("\n"); 
		query.append("		END CURR_CD" ).append("\n"); 
		query.append("	,	AFT_CNTR.CNTR_CHG_DC_AMT" ).append("\n"); 
		query.append("	,	AFT_CNTR.CNTR_CHG_DC_RTO" ).append("\n"); 
		query.append("    ,   NVL(AFT_CNTR.BIL_AFT_DC_AMT, (CHG_CALC.BIL_AMT + NVL(CHG_CALC.AFT_EXPT_DC_AMT,0)))  AS BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.OFC_RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,   AFT_CNTR.AFT_BKG_CURR_CD AS RQST_CURR_CD" ).append("\n"); 
		query.append("	,	AFT_CNTR.RQST_BIL_AMT" ).append("\n"); 
		query.append("	,	AFT_CNTR.RQST_DC_AMT" ).append("\n"); 
		query.append("	,	AFT_CNTR.RQST_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,   AFT_CNTR.AFT_BKG_CURR_CD AS APRO_CURR_CD" ).append("\n"); 
		query.append("	,	AFT_CNTR.APRO_BIL_AMT" ).append("\n"); 
		query.append("	,	AFT_CNTR.APRO_DC_AMT" ).append("\n"); 
		query.append("	,	AFT_CNTR.APRO_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    ,   CHG_CALC.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,   CHG_CALC.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.FM_MVMT_DT, 'YYYYMMDD')    AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.FM_MVMT_DT, 'HH24MI')      AS FM_MVMT_DT_TIME" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.TO_MVMT_DT, 'YYYYMMDD')    AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.TO_MVMT_DT, 'HH24MI')       AS TO_MVMT_DT_TIME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR 			CHG_CNTR" ).append("\n"); 
		query.append("	,	DMT_CHG_CALC 				CHG_CALC" ).append("\n"); 
		query.append("	,	DMT_INV_MN 					INV_MN" ).append("\n"); 
		query.append("	,	DMT_AFT_BKG_CNTR 			AFT_CNTR" ).append("\n"); 
		query.append("	,	DMT_AFT_BKG_ADJ_RQST_DTL 	ADJ_RQST_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	CHG_CNTR.BKG_NO 				= @[bkg_no]" ).append("\n"); 
		query.append("	AND CHG_CNTR.SYS_AREA_GRP_ID 		= CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND	CHG_CNTR.CNTR_NO 				= CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("	AND CHG_CNTR.CNTR_CYC_NO 			= CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_TRF_CD 			= @[tariff]" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_STS_CD 	 NOT IN ('P', 'T')" ).append("\n"); 
		query.append("	AND	CHG_CALC.SYS_AREA_GRP_ID 		= AFT_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND CHG_CALC.CNTR_NO 				= AFT_CNTR.CNTR_NO" ).append("\n"); 
		query.append("	AND CHG_CALC.CNTR_CYC_NO 			= AFT_CNTR.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_TRF_CD 			= AFT_CNTR.DMDT_TRF_CD" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_LOC_DIV_CD 	= AFT_CNTR.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	AND CHG_CALC.CHG_SEQ 				= AFT_CNTR.CHG_SEQ" ).append("\n"); 
		query.append("#if(${aft_expt_dar_no} != '')" ).append("\n"); 
		query.append("	AND AFT_CNTR.AFT_EXPT_DAR_NO 		= @[aft_expt_dar_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND AFT_CNTR.AFT_EXPT_ADJ_SEQ 		= @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("	AND AFT_CNTR.AFT_EXPT_DAR_NO 		= ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	AND AFT_CNTR.AFT_EXPT_ADJ_SEQ 		= ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_INV_NO 			= INV_MN.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("	--AND CHG_CALC.CHG_SEQ 				= 1" ).append("\n"); 
		query.append("#if(${is_aft_bkg_cntr} == 'Y')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("	,	DECODE(CHG_CALC.CHG_SEQ, 1, 'G', 'B') CHG_SEQ_DESC" ).append("\n"); 
		query.append("	,	CHG_CALC.FT_DYS" ).append("\n"); 
		query.append("	,	CHG_CALC.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("	,	CHG_CALC.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	,	CHG_CALC.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.BIL_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.BIL_AMT ORG_BIL_AMT" ).append("\n"); 
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
		query.append("	,	@[aft_expt_dar_no] AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	TO_NUMBER(@[aft_expt_adj_seq]) AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	,	null AFT_EXPT_CNTR_SEQ" ).append("\n"); 
		query.append("	,	null FT_ADJ_FLG" ).append("\n"); 
		query.append("	,	null FT_ADD_DYS" ).append("\n"); 
		query.append("	,	null FT_TTL_DYS" ).append("\n"); 
		query.append("	,	null XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,	null XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,	null XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,	null CNTR_CHG_DC_FLG" ).append("\n"); 
		query.append("	,	null CURR_CD" ).append("\n"); 
		query.append("	,	null CNTR_CHG_DC_AMT" ).append("\n"); 
		query.append("	,	null CNTR_CHG_DC_RTO" ).append("\n"); 
		query.append("    ,   DECODE(CHG_CALC.AFT_EXPT_DC_AMT, 0, CHG_CALC.BIL_AMT, (CHG_CALC.BIL_AMT- CHG_CALC.AFT_EXPT_DC_AMT)) AS BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("	,	CHG_CALC.OFC_RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,   '' AS RQST_CURR_CD" ).append("\n"); 
		query.append("	,	0 AS RQST_BIL_AMT" ).append("\n"); 
		query.append("	,	0 AS RQST_DC_AMT" ).append("\n"); 
		query.append("	,	0 AS RQST_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,   '' AS APRO_CURR_CD" ).append("\n"); 
		query.append("	,	0 AS APRO_BIL_AMT" ).append("\n"); 
		query.append("	,	0 AS APRO_DC_AMT" ).append("\n"); 
		query.append("	,	0 AS APRO_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("    ,   CHG_CALC.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,   CHG_CALC.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.FM_MVMT_DT, 'YYYYMMDD')    AS FM_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.FM_MVMT_DT, 'HH24MI')      AS FM_MVMT_DT_TIME" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.TO_MVMT_DT, 'YYYYMMDD')    AS TO_MVMT_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR(CHG_CALC.TO_MVMT_DT, 'HH24MI')       AS TO_MVMT_DT_TIME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR		CHG_CNTR" ).append("\n"); 
		query.append("	,	DMT_CHG_CALC			CHG_CALC" ).append("\n"); 
		query.append("	,	DMT_INV_MN 				INV_MN" ).append("\n"); 
		query.append("WHERE	CHG_CNTR.BKG_NO 				= @[bkg_no]" ).append("\n"); 
		query.append("	AND CHG_CNTR.SYS_AREA_GRP_ID 		= CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	AND	CHG_CNTR.CNTR_NO 				= CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("	AND CHG_CNTR.CNTR_CYC_NO 			= CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_TRF_CD 			= @[tariff]" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_CHG_STS_CD 	 NOT IN ('P', 'T', 'E', 'N')" ).append("\n"); 
		query.append("	AND	(CHG_CNTR.SYS_AREA_GRP_ID, CHG_CALC.CNTR_NO, CHG_CALC.CNTR_CYC_NO, CHG_CALC.DMDT_TRF_CD, CHG_CALC.DMDT_CHG_LOC_DIV_CD, CHG_CALC.CHG_SEQ) NOT IN " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ" ).append("\n"); 
		query.append("			FROM	DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("			WHERE	AFT_EXPT_DAR_NO 	= @[aft_expt_dar_no]" ).append("\n"); 
		query.append("				AND AFT_EXPT_ADJ_SEQ 	= @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	AND CHG_CALC.DMDT_INV_NO 			= INV_MN.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY AFT_EXPT_ADJ_SEQ, CNTR_NO, CHG_SEQ" ).append("\n"); 

	}
}