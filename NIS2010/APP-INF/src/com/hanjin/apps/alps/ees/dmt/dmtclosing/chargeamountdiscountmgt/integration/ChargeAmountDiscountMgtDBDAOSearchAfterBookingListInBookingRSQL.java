/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingListInBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingListInBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking Request 를 Charge Container 에서 찾지 못했을 경우 Booking 에서 찾기 위한 조회용 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingListInBookingRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingListInBookingRSQL").append("\n"); 
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
		query.append("		ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,	ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("    ,   ADJ_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,   ADJ_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("	,   ADJ_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("	,   CASE " ).append("\n"); 
		query.append("            WHEN ADJ_RQST_DTL.FT_ADJ_FLG = 'N' AND ADJ_RQST_DTL.DC_FLG = 'N' " ).append("\n"); 
		query.append("			THEN 'D' " ).append("\n"); 
		query.append("			ELSE 'S'" ).append("\n"); 
		query.append("        END CNTR_TP" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.FT_ADJ_FLG, 'Y', 1, 0) FT_ADJ_FLG       " ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.FT_ADD_DYS, 0, '', ADJ_RQST_DTL.FT_ADD_DYS) FT_ADD_DYS" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.FT_TTL_DYS, 0, '', ADJ_RQST_DTL.FT_TTL_DYS) FT_TTL_DYS" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.XCLD_SAT_FLG, 'Y', 1, 0) XCLD_SAT_FLG" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.XCLD_SUN_FLG, 'Y', 1, 0) XCLD_SUN_FLG" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.XCLD_HOL_FLG, 'Y', 1, 0) XCLD_HOL_FLG" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.DC_FLG, 'Y', 1, 0) DC_FLG" ).append("\n"); 
		query.append("	,   ADJ_RQST_DTL.CURR_CD" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.DC_AMT, 0, '', ADJ_RQST_DTL.DC_AMT) DC_AMT" ).append("\n"); 
		query.append("	,   DECODE(ADJ_RQST_DTL.DC_RTO, 0, '', ADJ_RQST_DTL.DC_RTO) DC_RTO" ).append("\n"); 
		query.append("	,   ADJ_RQST_DTL.EACH_CNTR_FLG" ).append("\n"); 
		query.append("	,   BOOKING.VSL_CD || BOOKING.SKD_VOY_NO || BOOKING.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append("	,   BOOKING.POR_CD" ).append("\n"); 
		query.append("	,   BOOKING.POL_CD" ).append("\n"); 
		query.append("	,   BOOKING.POD_CD" ).append("\n"); 
		query.append("	,   BOOKING.DEL_CD" ).append("\n"); 
		query.append("	,   BOOKING.RCV_TERM_CD || '/' || BOOKING.DE_TERM_CD RD" ).append("\n"); 
		query.append("	,   DECODE(BOOKING.DCGO_FLG, 'N', '', BOOKING.DCGO_FLG) DCGO_FLG" ).append("\n"); 
		query.append("	,   DECODE(BOOKING.RC_FLG, 'N', '', BOOKING.RC_FLG) RC_FLG" ).append("\n"); 
		query.append("	,   DECODE(BOOKING.AWK_CGO_FLG, 'N', '', BOOKING.AWK_CGO_FLG) AWK_CGO_FLG" ).append("\n"); 
		query.append("	,   DECODE(BOOKING.BB_CGO_FLG, 'N', '', BOOKING.BB_CGO_FLG) BB_CGO_FLG" ).append("\n"); 
		query.append("	,   DECODE(BOOKING.RD_CGO_FLG, 'N', '', BOOKING.RD_CGO_FLG) RD_CGO_FLG" ).append("\n"); 
		query.append("	,   DECODE(BOOKING.SOC_FLG, 'N', '', BOOKING.SOC_FLG) SOC_FLG" ).append("\n"); 
		query.append("	,   BOOKING.CMDT_CD" ).append("\n"); 
		query.append("	,   CMDT.CMDT_NM" ).append("\n"); 
		query.append("	,	ADJ_RQST.RQST_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	ADJ_RQST_DTL.AFT_BKG_CM_AMT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,   ( SELECT COUNT(*) FROM DMT_AFT_BKG_CNTR WHERE AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO AND AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ ) CNTR_QTY  " ).append("\n"); 
		query.append("	,   ( SELECT SUM(ROUND(RQST_BIL_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT,2)) " ).append("\n"); 
		query.append("	        FROM DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("	       WHERE AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("	         AND AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ ) BIL_TTL " ).append("\n"); 
		query.append("	,   ( SELECT SUM(ROUND(RQST_DC_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT,2)) " ).append("\n"); 
		query.append("	        FROM DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("	       WHERE AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("	         AND AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ ) DC_TTL" ).append("\n"); 
		query.append("	,   ( SELECT SUM(ROUND(RQST_BIL_AFT_DC_AMT/ADJ_RQST_DTL.AFT_BKG_XCH_RT,2)) " ).append("\n"); 
		query.append("	        FROM DMT_AFT_BKG_CNTR " ).append("\n"); 
		query.append("	       WHERE AFT_EXPT_DAR_NO = ADJ_RQST.AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("	         AND AFT_EXPT_ADJ_SEQ = ADJ_RQST_DTL.AFT_EXPT_ADJ_SEQ ) AFT_DC_TTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("	,   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append("	,   BKG_BOOKING BOOKING" ).append("\n"); 
		query.append("	,   MDM_COMMODITY CMDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("#if(${dar_no} != '')" ).append("\n"); 
		query.append("		ADJ_RQST.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("		ADJ_RQST.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	AND ADJ_RQST_DTL.BKG_NO = BOOKING.BKG_NO" ).append("\n"); 
		query.append("	AND BOOKING.CMDT_CD = CMDT.CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY AFT_EXPT_ADJ_SEQ" ).append("\n"); 

	}
}