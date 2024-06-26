/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeMainDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeMainDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSCoPoolChargeMainData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeMainDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_mgst_inv_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeMainDataRSQL").append("\n"); 
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
		query.append("SELECT A.PAY_INV_SEQ," ).append("\n"); 
		query.append("	   A.INV_NO," ).append("\n"); 
		query.append("	   A.VNDR_SEQ," ).append("\n"); 
		query.append("		(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR " ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("	   A.COST_YRMON, " ).append("\n"); 
		query.append("	   A.COST_OFC_CD, " ).append("\n"); 
		query.append("	   A.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("	   A.AGMT_SEQ, " ).append("\n"); 
		query.append("	   A.CHSS_POOL_CD," ).append("\n"); 
		query.append("	   A.DIFF_RMK," ).append("\n"); 
		query.append("	   A.CHSS_MGST_INV_KND_CD," ).append("\n"); 
		query.append("	   A.CHSS_MGST_INV_STS_CD," ).append("\n"); 
		query.append("	   TO_CHAR(A.INV_DT,'YYYY-MM-DD') AS INV_DT" ).append("\n"); 
		query.append("FROM CGM_PAY_INV A" ).append("\n"); 
		query.append("WHERE A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("	  AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("	  AND A.CHSS_MGST_INV_KND_CD = @[chss_mgst_inv_knd_cd]" ).append("\n"); 

	}
}