/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchInvoiceWordingByCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.02.19 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchInvoiceWordingByCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchInvoiceWordingByCustomerRSQL(){
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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchInvoiceWordingByCustomerRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.CUST_CNT_CD," ).append("\n"); 
		query.append("  LPAD(A.CUST_SEQ, 6, '0') CUST_SEQ," ).append("\n"); 
		query.append("  CUST_LGL_ENG_NM CUST_NM," ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT INV_ISS_CTNT" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S1" ).append("\n"); 
		query.append("    WHERE S1.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S1.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S1.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S1.TXT_NO = 1) SUBJECT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT INV_ISS_CTNT" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S2" ).append("\n"); 
		query.append("    WHERE S2.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S2.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S2.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S2.TXT_NO = 2) TEXT1," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT FONT_BOLD_FLG" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S2" ).append("\n"); 
		query.append("    WHERE S2.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S2.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S2.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S2.TXT_NO = 2) HIGH_LIGHT1," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT INV_ISS_CTNT" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S3" ).append("\n"); 
		query.append("    WHERE S3.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S3.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S3.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S3.TXT_NO = 3) TEXT2," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT FONT_BOLD_FLG" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S3" ).append("\n"); 
		query.append("    WHERE S3.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S3.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S3.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S3.TXT_NO = 3) HIGH_LIGHT2," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT INV_ISS_CTNT" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S4" ).append("\n"); 
		query.append("    WHERE S4.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S4.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S4.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S4.TXT_NO = 4) TEXT3," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT FONT_BOLD_FLG" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S4" ).append("\n"); 
		query.append("    WHERE S4.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S4.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S4.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S4.TXT_NO = 4) HIGH_LIGHT3," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT INV_ISS_CTNT" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S5" ).append("\n"); 
		query.append("    WHERE S5.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S5.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S5.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S5.TXT_NO = 5) TEXT4," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT FONT_BOLD_FLG" ).append("\n"); 
		query.append("    FROM INV_ISS_CUST_ATCH S5" ).append("\n"); 
		query.append("    WHERE S5.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("      AND S5.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("      AND S5.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("      AND S5.TXT_NO = 5) HIGH_LIGHT4" ).append("\n"); 
		query.append("FROM INV_ISS_CUST_ATCH A," ).append("\n"); 
		query.append("  MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 

	}
}