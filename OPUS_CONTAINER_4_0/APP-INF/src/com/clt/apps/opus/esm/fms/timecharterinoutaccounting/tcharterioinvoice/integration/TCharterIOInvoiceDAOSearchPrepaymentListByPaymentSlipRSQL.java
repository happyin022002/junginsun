/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL").append("\n"); 
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
		query.append("SELECT FI.PPAY_HIR_NO IMS_PPAY_HIR_NO" ).append("\n"); 
		query.append("     , FI.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("          FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("         WHERE ACCT_CD = FD.ACCT_CD" ).append("\n"); 
		query.append("           AND ACCT_ITM_SEQ = FD.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1) ACCT_NM" ).append("\n"); 
		query.append("     , FD.ACCT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(FD.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(FD.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("     , FD.CURR_CD" ).append("\n"); 
		query.append("     , TO_CHAR(FD.INV_AMT,'FM999,999,999,999,999,990.00') INV_AMT" ).append("\n"); 
		query.append("     , FD.INV_DESC" ).append("\n"); 
		query.append("     , (SELECT AP_CTR_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) CTR_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) SLP_LOC_CD" ).append("\n"); 
		query.append("     , FD.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("     , FD.INV_SEQ" ).append("\n"); 
		query.append("     , FD.INV_DTL_SEQ" ).append("\n"); 
		query.append("     , '01' AS FLET_SRC_TP_CD" ).append("\n"); 
		query.append("     , FD.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , SUBSTR(FD.INV_DESC,1, INSTR(FD.INV_DESC,'(')) || TO_CHAR(FI.EFF_DT,'YYYY-MM-DD HH24:MI') ||'~'|| TO_CHAR(FI.EXP_DT,'YYYY-MM-DD HH24:MI') ||')' AS ORI_INV_DESC" ).append("\n"); 
		query.append("  FROM FMS_INVOICE FI" ).append("\n"); 
		query.append("     , FMS_INV_DTL FD" ).append("\n"); 
		query.append(" WHERE FI.FLET_CTRT_NO = FD.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND FI.FLET_ISS_TP_CD = FD.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("   AND FI.INV_SEQ = FD.INV_SEQ" ).append("\n"); 
		query.append("   AND FD.SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("   AND FD.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("   AND FD.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND FD.CURR_CD = @[csr_curr_cd]" ).append("\n"); 
		query.append("   AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM FMS_ACCT_ITM AI" ).append("\n"); 
		query.append("                         , FMS_ACCT_CATE AC" ).append("\n"); 
		query.append("                     WHERE AI.ACCT_CD = AC.ACCT_CD" ).append("\n"); 
		query.append("                       AND AI.ACCT_ITM_SEQ = AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                       AND AC.FLET_ACCT_CATE_CD = 'BR' /*Brokerage*/" ).append("\n"); 
		query.append("                       AND AI.ACCT_CD = FD.ACCT_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 )" ).append("\n"); 
		query.append(" ORDER BY FI.PPAY_HIR_NO, FD.ACCT_CD" ).append("\n"); 

	}
}