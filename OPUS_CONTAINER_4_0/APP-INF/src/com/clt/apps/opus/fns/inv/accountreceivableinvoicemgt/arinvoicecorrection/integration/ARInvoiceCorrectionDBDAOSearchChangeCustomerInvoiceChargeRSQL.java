/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceChargeRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("       RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("       SAR_GET_FMT_MASK_FNC(CURR_CD,TRF_RT_AMT) TRF_RT_AMT," ).append("\n"); 
		query.append("       PER_TP_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       SAR_GET_FMT_MASK_FNC(CURR_CD,CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("       INV_XCH_RT," ).append("\n"); 
		query.append("       SAR_GET_CUR_AMT_FNC(LOCL_CURR_CD,LOCL_AMT) LOCL_AMT," ).append("\n"); 
		query.append("       INV_TTL_LOCL_AMT," ).append("\n"); 
		query.append("       DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("  FROM (SELECT CHG.CHG_CD," ).append("\n"); 
		query.append("               ABS(SUM(CASE WHEN CHG.CHG_AMT > 0 THEN CHG.RAT_AS_CNTR_QTY ELSE CHG.RAT_AS_CNTR_QTY * (-1) END)) RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("               CHG.TRF_RT_AMT," ).append("\n"); 
		query.append("               CHG.PER_TP_CD," ).append("\n"); 
		query.append("               CHG.CURR_CD," ).append("\n"); 
		query.append("               SUM(CHG.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("               CHG.INV_XCH_RT," ).append("\n"); 
		query.append("               SUM(SAR_GET_CUR_AMT_FNC(MN.LOCL_CURR_CD,CHG.CHG_AMT*CHG.INV_XCH_RT)) LOCL_AMT," ).append("\n"); 
		query.append("               CUR.DP_PRCS_KNT DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("          FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("               INV_AR_CHG     CHG," ).append("\n"); 
		query.append("               INV_AR_MN      MN," ).append("\n"); 
		query.append("               MDM_CURRENCY   CUR" ).append("\n"); 
		query.append("         WHERE DTL.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("           AND DTL.CHG_SEQ      = CHG.CHG_SEQ" ).append("\n"); 
		query.append("           AND CHG.AR_IF_NO     = MN.AR_IF_NO" ).append("\n"); 
		query.append("           AND CUR.CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("           AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("           AND MN.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("           AND DTL.INV_NO         = @[inv_no]" ).append("\n"); 
		query.append("           AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("		   --AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('M','X') 2010-01-18 이상희 과장" ).append("\n"); 
		query.append("           --AND MN.REV_TP_CD <> 'M' 2009-12-02 김현화 수석" ).append("\n"); 
		query.append("         GROUP BY CHG.CHG_CD," ).append("\n"); 
		query.append("                  CHG.TRF_RT_AMT," ).append("\n"); 
		query.append("                  CHG.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("                  CHG.PER_TP_CD," ).append("\n"); 
		query.append("                  CHG.CURR_CD," ).append("\n"); 
		query.append("                  CHG.INV_XCH_RT," ).append("\n"); 
		query.append("                  CUR.DP_PRCS_KNT) A," ).append("\n"); 
		query.append("      (SELECT NVL(SUM(CURR_LOCL_AMT),0) INV_TTL_LOCL_AMT, MAX(LOCL_CURR_CD) LOCL_CURR_CD" ).append("\n"); 
		query.append("         FROM ( SELECT CHG.CURR_CD," ).append("\n"); 
		query.append("                       SUM(SAR_GET_CUR_AMT_FNC(MN.LOCL_CURR_CD,CHG.CHG_AMT*CHG.INV_XCH_RT)) CURR_LOCL_AMT," ).append("\n"); 
		query.append("                  	   MN.LOCL_CURR_CD	" ).append("\n"); 
		query.append("				 FROM INV_AR_ISS_DTL DTL," ).append("\n"); 
		query.append("                       INV_AR_CHG     CHG," ).append("\n"); 
		query.append("                       INV_AR_MN      MN," ).append("\n"); 
		query.append("                       MDM_CURRENCY   CUR" ).append("\n"); 
		query.append("                 WHERE DTL.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("                   AND DTL.CHG_SEQ      = CHG.CHG_SEQ" ).append("\n"); 
		query.append("                   AND CHG.AR_IF_NO     = MN.AR_IF_NO" ).append("\n"); 
		query.append("                   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("                   AND MN.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                   AND DTL.INV_NO         = @[inv_no]" ).append("\n"); 
		query.append("                   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND CUR.CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                 GROUP BY CHG.CURR_CD, CHG.INV_XCH_RT, CUR.DP_PRCS_KNT,MN.LOCL_CURR_CD)) B       " ).append("\n"); 
		query.append(" WHERE A.CHG_AMT <> 0 " ).append("\n"); 
		query.append(" ORDER BY CURR_CD, CHG_CD, PER_TP_CD , TRF_RT_AMT , RAT_AS_CNTR_QTY" ).append("\n"); 

	}
}