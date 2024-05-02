/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchKORIssuedChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.05.24 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchKORIssuedChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KOR Invoice main, KOR Invoice Charge 테이블에서 Select
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchKORIssuedChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchKORIssuedChargeListRSQL").append("\n"); 
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
		query.append("SELECT A.INV_NO," ).append("\n"); 
		query.append("  A.INV_SEQ," ).append("\n"); 
		query.append("  B.BL_SRC_NO," ).append("\n"); 
		query.append("  B.CHG_SEQ," ).append("\n"); 
		query.append("  B.CHG_CD," ).append("\n"); 
		query.append("  B.CURR_CD," ).append("\n"); 
		query.append("  B.INV_XCH_RT," ).append("\n"); 
		query.append("  B.CHG_AMT," ).append("\n"); 
		query.append("  B.CHG_AMT ISS_AMT," ).append("\n"); 
		query.append("  B.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("  B.TRF_RT_AMT," ).append("\n"); 
		query.append("  B.PER_TP_CD," ).append("\n"); 
		query.append("  C.AR_CURR_CD," ).append("\n"); 
		query.append("  D.DP_PRCS_KNT," ).append("\n"); 
		query.append("  B.CRE_USR_ID," ).append("\n"); 
		query.append("  B.CRE_DT," ).append("\n"); 
		query.append("  B.UPD_USR_ID," ).append("\n"); 
		query.append("  B.UPD_DT," ).append("\n"); 
		query.append("  A.AR_OFC_CD" ).append("\n"); 
		query.append("FROM INV_AR_KR_ISS A," ).append("\n"); 
		query.append("  INV_AR_KR_ISS_CHG B," ).append("\n"); 
		query.append("  MDM_ORGANIZATION C," ).append("\n"); 
		query.append("  MDM_CURRENCY D" ).append("\n"); 
		query.append("WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND A.INV_SEQ = B.INV_SEQ" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("  AND B.CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND A.INV_SEQ = (" ).append("\n"); 
		query.append("    SELECT MAX(INV_SEQ)" ).append("\n"); 
		query.append("    FROM INV_AR_KR_ISS" ).append("\n"); 
		query.append("    WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("      AND AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        --WHERE AR_HD_QTR_OFC_CD = 'SHAAS'" ).append("\n"); 
		query.append("          WHERE (LOC_CD LIKE 'KR%' OR LOC_CD LIKE 'HQ%')" ).append("\n"); 
		query.append("          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("          AND AR_OFC_CD IS NOT NULL))" ).append("\n"); 

	}
}