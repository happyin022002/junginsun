/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSInvoiceCreateDetailData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateDetailDataRSQL").append("\n"); 
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
		query.append("#if (${chss_mgst_inv_knd_cd} == 'LS')  " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("    	B.COST_CD," ).append("\n"); 
		query.append("    	B.ACCT_CD," ).append("\n"); 
		query.append("    	A.REV_VSL_CD," ).append("\n"); 
		query.append("    	A.REV_SKD_VOY_NO," ).append("\n"); 
		query.append("    	A.REV_SKD_DIR_CD," ).append("\n"); 
		query.append("    	A.REV_DIR_CD," ).append("\n"); 
		query.append("		(A.REV_VSL_CD || A.REV_SKD_VOY_NO || A.REV_SKD_DIR_CD || A.REV_DIR_CD) AS REV_VVD, " ).append("\n"); 
		query.append("    	NVL(SUM(B.PAY_LSE_CHG_AMT),0) + NVL(SUM(B.PAY_CR_AMT),0) + NVL(SUM(B.PAY_TAX_AMT),0) AS INV_AMT," ).append("\n"); 
		query.append("		CASE WHEN C.ACT_DT_NM = 'COST MONTH' THEN A.COST_YRMON||'01' ELSE '' END AS ACT_DT," ).append("\n"); 
		query.append("		CASE WHEN C.ACT_PLC_NM = 'COST OFFICE' THEN A.COST_OFC_CD ELSE '' END AS ACT_PLC" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("    	CGM_PAY_INV A," ).append("\n"); 
		query.append("    	CGM_LSE_CHG_DTL B," ).append("\n"); 
		query.append("        SCO_AP_COST_ACT_INFO C" ).append("\n"); 
		query.append("	WHERE" ).append("\n"); 
		query.append("    	A.PAY_INV_SEQ = B.PAY_INV_SEQ" ).append("\n"); 
		query.append("    	AND A.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("        AND B.COST_CD = C.ACT_COST_CD" ).append("\n"); 
		query.append("        AND B.ACCT_CD = C.CONV_ACCT_CD" ).append("\n"); 
		query.append("        AND C.SRC_MDL_CD = 'CHS'" ).append("\n"); 
		query.append("		AND B.PAY_LSE_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("	GROUP BY" ).append("\n"); 
		query.append("    	B.COST_CD," ).append("\n"); 
		query.append("    	B.ACCT_CD," ).append("\n"); 
		query.append("    	A.REV_VSL_CD, " ).append("\n"); 
		query.append("    	A.REV_SKD_VOY_NO," ).append("\n"); 
		query.append("    	A.REV_SKD_DIR_CD," ).append("\n"); 
		query.append("    	A.REV_DIR_CD," ).append("\n"); 
		query.append("   		A.COST_YRMON," ).append("\n"); 
		query.append("   		A.COST_OFC_CD," ).append("\n"); 
		query.append("		C.ACT_DT_NM," ).append("\n"); 
		query.append("        C.ACT_PLC_NM" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("    	B.COST_CD," ).append("\n"); 
		query.append("    	B.ACCT_CD," ).append("\n"); 
		query.append("    	A.REV_VSL_CD," ).append("\n"); 
		query.append("    	A.REV_SKD_VOY_NO," ).append("\n"); 
		query.append("    	A.REV_SKD_DIR_CD," ).append("\n"); 
		query.append("    	A.REV_DIR_CD," ).append("\n"); 
		query.append("		(A.REV_VSL_CD || A.REV_SKD_VOY_NO || A.REV_SKD_DIR_CD || A.REV_DIR_CD) AS REV_VVD, " ).append("\n"); 
		query.append("    	NVL(SUM(B.COST_AMT),0) AS INV_AMT," ).append("\n"); 
		query.append("		CASE WHEN C.ACT_DT_NM = 'COST MONTH' THEN A.COST_YRMON||'01' ELSE '' END AS ACT_DT," ).append("\n"); 
		query.append("		CASE WHEN C.ACT_PLC_NM = 'COST OFFICE' THEN A.COST_OFC_CD ELSE '' END AS ACT_PLC" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("    	CGM_PAY_INV A," ).append("\n"); 
		query.append("    	CGM_PAY_INV_POOL_DTL B," ).append("\n"); 
		query.append("        SCO_AP_COST_ACT_INFO C" ).append("\n"); 
		query.append("	WHERE" ).append("\n"); 
		query.append("    	A.PAY_INV_SEQ = B.PAY_INV_SEQ" ).append("\n"); 
		query.append("        AND B.COST_CD = C.ACT_COST_CD" ).append("\n"); 
		query.append("        AND B.ACCT_CD = C.CONV_ACCT_CD" ).append("\n"); 
		query.append("        AND C.SRC_MDL_CD = 'CHS'" ).append("\n"); 
		query.append("    	AND A.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 
		query.append("	GROUP BY" ).append("\n"); 
		query.append("    	B.COST_CD," ).append("\n"); 
		query.append("    	B.ACCT_CD," ).append("\n"); 
		query.append("    	A.REV_VSL_CD, " ).append("\n"); 
		query.append("    	A.REV_SKD_VOY_NO," ).append("\n"); 
		query.append("    	A.REV_SKD_DIR_CD," ).append("\n"); 
		query.append("    	A.REV_DIR_CD," ).append("\n"); 
		query.append("   		A.COST_YRMON," ).append("\n"); 
		query.append("   		A.COST_OFC_CD," ).append("\n"); 
		query.append("		C.ACT_DT_NM," ).append("\n"); 
		query.append("        C.ACT_PLC_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}