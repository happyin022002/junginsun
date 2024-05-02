/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListCountRSQL
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListCountRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(COUNT(1), '000000') ROW_CNT   " ).append("\n"); 
		query.append("     , TO_CHAR(COUNT(DISTINCT D.INV_NO), '000000') INV_CNT" ).append("\n"); 
		query.append("     , TO_CHAR(SUM(ROUND(A.INV_TTL_LOCL_AMT, F.DP_PRCS_KNT)), '000000000000000.000') LOCL_TOT_SUM" ).append("\n"); 
		query.append("  FROM INV_AR_MN A" ).append("\n"); 
		query.append("     , INV_AR_CHG B" ).append("\n"); 
		query.append("     , INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("     , INV_AR_ISS D" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION E" ).append("\n"); 
		query.append("     , MDM_CURRENCY F" ).append("\n"); 
		query.append(" WHERE D.ISS_DT BETWEEN TO_CHAR(TO_DATE(@[iss_dt],'YYYYMMDD') - 6,'YYYYMMDD') AND @[iss_dt] " ).append("\n"); 
		query.append("   AND D.ISS_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                          WHERE AR_OFC_CD = @[ar_ofc_cd] )" ).append("\n"); 
		query.append("   AND D.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("   AND D.INV_SEQ = 1" ).append("\n"); 
		query.append("   AND C.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("   AND C.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 
		query.append("   AND B.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND A.EDI_SND_DT IS NULL" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = E.OFC_CD" ).append("\n"); 
		query.append("   AND F.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 

	}
}