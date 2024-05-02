/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOReportForReverseChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.05.24 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOReportForReverseChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOReportForReverseChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOReportForReverseChargeListRSQL").append("\n"); 
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
		query.append("SELECT M.AR_OFC_CD" ).append("\n"); 
		query.append("      ,M.GL_EFF_DT" ).append("\n"); 
		query.append("      ,M.ACT_CUST_CNT_CD||LPAD(M.ACT_CUST_SEQ,6,'0') CUST_CD" ).append("\n"); 
		query.append("      ,C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,L.CNT_CD" ).append("\n"); 
		query.append("      ,C.CUST_RGST_NO" ).append("\n"); 
		query.append("      ,SUM(M.INV_TTL_LOCL_AMT) INV_AMT" ).append("\n"); 
		query.append("      ,M.INV_NO" ).append("\n"); 
		query.append("      ,M.BL_SRC_NO" ).append("\n"); 
		query.append("	  ,M.POR_CD" ).append("\n"); 
		query.append("	  ,M.POL_CD" ).append("\n"); 
		query.append("      ,M.POD_CD" ).append("\n"); 
		query.append("	  ,M.DEL_CD" ).append("\n"); 
		query.append("  FROM INV_AR_MN M" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER C" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION O" ).append("\n"); 
		query.append("      ,MDM_LOCATION L" ).append("\n"); 
		query.append(" WHERE M.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND M.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("   AND M.AR_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("   AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("   AND M.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND M.GL_EFF_DT BETWEEN REPLACE(@[fm_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("   AND M.RVS_CHG_FLG = 'Y'" ).append("\n"); 
		query.append("   AND NVL(M.INV_CLR_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" GROUP BY M.AR_OFC_CD" ).append("\n"); 
		query.append("      ,M.GL_EFF_DT" ).append("\n"); 
		query.append("      ,M.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,M.ACT_CUST_SEQ" ).append("\n"); 
		query.append("      ,C.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,L.CNT_CD" ).append("\n"); 
		query.append("      ,C.CUST_RGST_NO" ).append("\n"); 
		query.append("      ,M.INV_NO" ).append("\n"); 
		query.append("      ,M.BL_SRC_NO" ).append("\n"); 
		query.append("	  ,M.POR_CD" ).append("\n"); 
		query.append("	  ,M.POL_CD" ).append("\n"); 
		query.append("      ,M.POD_CD" ).append("\n"); 
		query.append("	  ,M.DEL_CD" ).append("\n"); 
		query.append(" ORDER BY M.AR_OFC_CD ,M.BL_SRC_NO ,M.INV_NO" ).append("\n"); 

	}
}