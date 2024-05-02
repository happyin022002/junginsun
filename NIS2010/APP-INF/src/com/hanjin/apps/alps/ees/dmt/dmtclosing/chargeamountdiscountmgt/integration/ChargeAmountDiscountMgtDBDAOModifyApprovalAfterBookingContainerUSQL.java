/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyApprovalAfterBookingContainerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.30 
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

public class ChargeAmountDiscountMgtDBDAOModifyApprovalAfterBookingContainerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOModifyApprovalAfterBookingContainerUSQL
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyApprovalAfterBookingContainerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyApprovalAfterBookingContainerUSQL").append("\n"); 
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
		query.append("UPDATE DMT_AFT_BKG_CNTR T01" ).append("\n"); 
		query.append("        SET APRO_BIL_AMT = ( SELECT T12.BIL_AMT" ).append("\n"); 
		query.append("                               FROM DMT_CHG_CALC T12" ).append("\n"); 
		query.append("                              WHERE T01.CNTR_NO = T12.CNTR_NO" ).append("\n"); 
		query.append("                                AND T01.CNTR_CYC_NO = T12.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                AND T01.DMDT_TRF_CD = T12.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                AND T01.DMDT_CHG_LOC_DIV_CD = T12.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                                AND T01.CHG_SEQ = T12.CHG_SEQ" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("          , APRO_DC_AMT = ( SELECT CASE WHEN T11.EACH_CNTR_FLG = 'N' THEN NVL(NVL(ROUND((T13.BIL_AMT * T11.DC_RTO / 100),2),T11.DC_AMT),0)" ).append("\n"); 
		query.append("                                     ELSE NVL(NVL(ROUND((T13.BIL_AMT * T12.CNTR_CHG_DC_RTO / 100),2),T12.CNTR_CHG_DC_AMT),0)" ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                              FROM DMT_AFT_BKG_ADJ_RQST_DTL T11, DMT_AFT_BKG_CNTR T12, DMT_CHG_CALC T13" ).append("\n"); 
		query.append("                              WHERE T11.AFT_EXPT_DAR_NO = T01.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                              AND T11.AFT_EXPT_DAR_NO = T12.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                              AND T11.AFT_EXPT_ADJ_SEQ = T12.AFT_EXPT_ADJ_SEQ          " ).append("\n"); 
		query.append("                              AND T13.CNTR_NO = T12.CNTR_NO" ).append("\n"); 
		query.append("                              AND T13.CNTR_CYC_NO = T12.CNTR_CYC_NO" ).append("\n"); 
		query.append("                              AND T13.DMDT_TRF_CD = T12.DMDT_TRF_CD" ).append("\n"); 
		query.append("                              AND T13.DMDT_CHG_LOC_DIV_CD = T12.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                              AND T13.CHG_SEQ = T12.CHG_SEQ      " ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                              AND T01.CNTR_NO = T12.CNTR_NO" ).append("\n"); 
		query.append("                              AND T01.CNTR_CYC_NO = T12.CNTR_CYC_NO" ).append("\n"); 
		query.append("                              AND T01.DMDT_TRF_CD = T12.DMDT_TRF_CD" ).append("\n"); 
		query.append("                              AND T01.DMDT_CHG_LOC_DIV_CD = T12.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                              AND T01.CHG_SEQ = T12.CHG_SEQ" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("          , APRO_BIL_AFT_DC_AMT = ( SELECT CASE WHEN T11.EACH_CNTR_FLG = 'N' THEN T13.BIL_AMT - NVL(NVL(ROUND((T13.BIL_AMT * T11.DC_RTO / 100),2),T11.DC_AMT),0)" ).append("\n"); 
		query.append("                                         ELSE T13.BIL_AMT - NVL(NVL(ROUND((T13.BIL_AMT * T12.CNTR_CHG_DC_RTO / 100),2),T12.CNTR_CHG_DC_AMT),0)" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                                  FROM DMT_AFT_BKG_ADJ_RQST_DTL T11, DMT_AFT_BKG_CNTR T12, DMT_CHG_CALC T13" ).append("\n"); 
		query.append("                                  WHERE T11.AFT_EXPT_DAR_NO = T01.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                  AND T11.AFT_EXPT_DAR_NO = T12.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                  AND T11.AFT_EXPT_ADJ_SEQ = T12.AFT_EXPT_ADJ_SEQ          " ).append("\n"); 
		query.append("                                  AND T13.CNTR_NO = T12.CNTR_NO" ).append("\n"); 
		query.append("                                  AND T13.CNTR_CYC_NO = T12.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                  AND T13.DMDT_TRF_CD = T12.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                  AND T13.DMDT_CHG_LOC_DIV_CD = T12.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                                  AND T13.CHG_SEQ = T12.CHG_SEQ      " ).append("\n"); 
		query.append("                                  " ).append("\n"); 
		query.append("                                  AND T01.CNTR_NO = T12.CNTR_NO" ).append("\n"); 
		query.append("                                  AND T01.CNTR_CYC_NO = T12.CNTR_CYC_NO" ).append("\n"); 
		query.append("                                  AND T01.DMDT_TRF_CD = T12.DMDT_TRF_CD" ).append("\n"); 
		query.append("                                  AND T01.DMDT_CHG_LOC_DIV_CD = T12.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                                  AND T01.CHG_SEQ = T12.CHG_SEQ" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         WHERE AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 

	}
}