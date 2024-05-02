/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiChgInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiChgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiChgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{BL_CHARGE_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_CD:' || B.CHG_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_DESC:' ||B.CHG_FULL_NM|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_TP_NM:' || (SELECT REP_CHG_NM FROM MDM_CHARGE MC, MDM_REP_CHG MR WHERE MC.CHG_CD = B.CHG_CD AND MC.REP_CHG_CD = MR.REP_CHG_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_CURR:' ||B.CURR_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_AMT:' ||B.CHG_AMT ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_CHARGE_AMT_USD:' || ROUND(B.CHG_AMT * SAR_GET_GL_XCH_RT_FNC('1', A.SAIL_DT, B.CURR_CD, 'USD'), 2) ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_CURR:' || NVL(A.INV_CURR_CD, A.LOCL_CURR_CD) || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_CURR_AMT:' || ROUND(B.CHG_AMT * NVL(B.ISS_XCH_RT, B.INV_XCH_RT), NVL(D.DP_PRCS_KNT, C.DP_PRCS_KNT)) ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_TAX:' ||'0.00'|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_CURR_TTL_AMT:' || ROUND(B.CHG_AMT * NVL(B.ISS_XCH_RT, B.INV_XCH_RT), NVL(D.DP_PRCS_KNT, C.DP_PRCS_KNT)) ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_CURR:' ||A.LOCL_CURR_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_CURR_AMT:' || ROUND(B.CHG_AMT * B.INV_XCH_RT, C.DP_PRCS_KNT) ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_TAX:' ||'0.00'|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_LOCAL_CURR_TTL_AMT:' || ROUND(B.CHG_AMT * B.INV_XCH_RT, C.DP_PRCS_KNT) ||CHR(10) " ).append("\n"); 
		query.append("       || 'BL_FRT_IND:' ||DECODE(A.IO_BND_CD, 'O', 'P', 'C') || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_RATED_AS:' ||B.RAT_AS_CNTR_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_RATE:' ||B.TRF_RT_AMT || CHR(10) " ).append("\n"); 
		query.append("       || 'BL_INV_EX_RATE:' ||B.INV_XCH_RT|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_TAX_RATE:' ||'0.00'|| CHR(10) " ).append("\n"); 
		query.append("       || 'BL_PERTYPE:' || B.PER_TP_CD ||CHR(10)" ).append("\n"); 
		query.append("       || 'BL_TARIFF:' || NVL(A.SC_NO, A.RFA_NO)|| CHR(10) " ).append("\n"); 
		query.append("       || '}BL_CHARGE_INFO' || CHR(10) " ).append("\n"); 
		query.append("  FROM INV_AR_MN A," ).append("\n"); 
		query.append("       INV_AR_CHG B," ).append("\n"); 
		query.append("       MDM_CURRENCY C," ).append("\n"); 
		query.append("       MDM_CURRENCY D" ).append("\n"); 
		query.append("  WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("  AND A.LOCL_CURR_CD = C.CURR_CD(+)" ).append("\n"); 
		query.append("  AND A.INV_CURR_CD = D.CURR_CD(+)" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("  AND B.PER_TP_CD IN ('BL','PC')" ).append("\n"); 

	}
}