/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeInitDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
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

public class ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeInitDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSCoPoolChargeInitData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeInitDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeInitDataRSQL").append("\n"); 
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
		query.append("SELECT  A.INTG_CD_VAL_DP_DESC," ).append("\n"); 
		query.append("        A.INTG_CD_VAL_CTNT AS DTL_POOL_COST_ITM_CD,  " ).append("\n"); 
		query.append("        '' AS POOL_BSRT_AMT," ).append("\n"); 
		query.append("	    '' AS COST_BIL_DYS," ).append("\n"); 
		query.append("	    '0' AS COST_AMT" ).append("\n"); 
		query.append("FROM  COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("WHERE A.INTG_CD_ID = 'CD01934'" ).append("\n"); 
		query.append("	  AND A.INTG_CD_VAL_CTNT LIKE 'C%'" ).append("\n"); 
		query.append("ORDER BY A.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}