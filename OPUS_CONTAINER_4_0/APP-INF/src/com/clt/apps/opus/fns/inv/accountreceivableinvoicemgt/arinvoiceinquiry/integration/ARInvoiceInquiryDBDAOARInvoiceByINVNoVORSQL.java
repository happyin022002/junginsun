/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceByINVNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOARInvoiceByINVNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceByINVNoVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceByINVNoVORSQL").append("\n"); 
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
		query.append("       (SELECT ISS_DT FROM INV_AR_ISS E WHERE E.INV_NO = A.INV_NO AND INV_SEQ = 1)  ISS_DT," ).append("\n"); 
		query.append("       B.AR_OFC_CD," ).append("\n"); 
		query.append("       B.BL_SRC_NO," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       B.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(B.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("       C.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       C.CUST_RGST_NO," ).append("\n"); 
		query.append("       B.INV_CUST_CNT_CD," ).append("\n"); 
		query.append("       LPAD(B.INV_CUST_SEQ, 6, '0') INV_CUST_SEQ," ).append("\n"); 
		query.append("       D.CR_CURR_CD," ).append("\n"); 
		query.append("       D.CR_AMT," ).append("\n"); 
		query.append("       D.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("       D.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("       D.CR_CLT_OFC_CD," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       B.SVC_SCP_CD," ).append("\n"); 
		query.append("       CASE WHEN B.IO_BND_CD = 'I' THEN 'I/B' ELSE 'O/B' END IO_BND_CD," ).append("\n"); 
		query.append("       B.SAIL_ARR_DT," ).append("\n"); 
		query.append("       B.TRNK_VSL_CD||B.TRNK_SKD_VOY_NO||B.TRNK_SKD_DIR_CD TRUNK_VVD," ).append("\n"); 
		query.append("       B.SLAN_CD," ).append("\n"); 
		query.append("       B.INV_CURR_CD LOCL_CURR_CD," ).append("\n"); 
		query.append("       B.DUE_DT," ).append("\n"); 
		query.append("       B.INV_RMK" ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("     INV_AR_MN B," ).append("\n"); 
		query.append("     MDM_CUSTOMER C," ).append("\n"); 
		query.append("     MDM_CR_CUST D" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("  AND B.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND B.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("  AND B.ACT_CUST_CNT_CD = D.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND B.ACT_CUST_SEQ = D.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND NVL(B.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("  AND B.AR_OFC_CD = @[ofc]" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}