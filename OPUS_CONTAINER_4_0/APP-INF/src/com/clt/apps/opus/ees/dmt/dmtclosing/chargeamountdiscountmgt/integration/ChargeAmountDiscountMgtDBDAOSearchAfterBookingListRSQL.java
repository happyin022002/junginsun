/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking Request 조회를 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",   ADJ_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append(",   ADJ_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append(",   ADJ_RQST_DTL.BL_NO" ).append("\n"); 
		query.append(",   CASE WHEN ADJ_RQST_DTL.FT_ADJ_FLG = 'N' AND ADJ_RQST_DTL.DC_FLG = 'N' THEN 'D' ELSE 'S' END CNTR_TP" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.FT_ADJ_FLG, 'Y', 1, 0) FT_ADJ_FLG" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.FT_ADD_DYS, 0, '', ADJ_RQST_DTL.FT_ADD_DYS) FT_ADD_DYS" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.FT_TTL_DYS, 0, '', ADJ_RQST_DTL.FT_TTL_DYS) FT_TTL_DYS" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.XCLD_SAT_FLG, 'Y', 1, 0) XCLD_SAT_FLG" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.XCLD_SUN_FLG, 'Y', 1, 0) XCLD_SUN_FLG" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.XCLD_HOL_FLG, 'Y', 1, 0) XCLD_HOL_FLG" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.DC_FLG, 'Y', 1, 0) DC_FLG" ).append("\n"); 
		query.append(",   CASE WHEN ADJ_RQST_DTL.FT_ADJ_FLG = 'N' AND ADJ_RQST_DTL.DC_FLG = 'N' THEN '' ELSE ADJ_RQST_DTL.CURR_CD END CURR_CD" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.DC_AMT, 0, '', ADJ_RQST_DTL.DC_AMT) DC_AMT" ).append("\n"); 
		query.append(",   DECODE(ADJ_RQST_DTL.DC_RTO, 0, '', ADJ_RQST_DTL.DC_RTO) DC_RTO" ).append("\n"); 
		query.append(",   ADJ_RQST_DTL.EACH_CNTR_FLG" ).append("\n"); 
		query.append(",   BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append(",	BKG.POR_CD" ).append("\n"); 
		query.append(",	BKG.POL_CD" ).append("\n"); 
		query.append(",	BKG.POD_CD" ).append("\n"); 
		query.append(",	BKG.DEL_CD" ).append("\n"); 
		query.append(",	BKG.RCV_TERM_CD || '/' || BKG.DE_TERM_CD RD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUM(DECODE(DCGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(") DCGO_FLG" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUM(DECODE(RC_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(") RC_FLG" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUM(DECODE(AWK_CGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(") AWK_CGO_FLG" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUM(DECODE(BB_CGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(") BB_CGO_FLG" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUM(DECODE(RD_CGO_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(") RD_CGO_FLG" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT  CASE WHEN SUM(DECODE(SOC_FLG, 'Y', 1, 0)) >= 1 THEN 'Y' ELSE '' END" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("WHERE   SYS_AREA_GRP_ID = CHG_CNTR.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(") SOC_FLG" ).append("\n"); 
		query.append(",   BKG.CMDT_CD" ).append("\n"); 
		query.append(",   CMDT.CMDT_NM" ).append("\n"); 
		query.append(",	ADJ_RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append(",   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append(",   DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(",   BKG_BOOKING BKG" ).append("\n"); 
		query.append(",   MDM_COMMODITY CMDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if(${dar_no} != '')" ).append("\n"); 
		query.append("ADJ_RQST.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("ADJ_RQST.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("AND	CHG_CNTR.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POD_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POR_CD, 0, 2)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BKG.CMDT_CD = CMDT.CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY AFT_EXPT_ADJ_SEQ" ).append("\n"); 

	}
}