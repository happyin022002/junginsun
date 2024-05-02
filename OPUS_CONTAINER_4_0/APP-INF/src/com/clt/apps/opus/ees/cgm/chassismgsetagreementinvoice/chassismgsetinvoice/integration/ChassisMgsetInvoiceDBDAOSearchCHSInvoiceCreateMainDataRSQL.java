/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateMainDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
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

public class ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateMainDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSInvoiceCreateMainData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateMainDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSInvoiceCreateMainDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.COST_OFC_CD, " ).append("\n"); 
		query.append("    A.VNDR_SEQ, " ).append("\n"); 
		query.append("    A.INV_NO," ).append("\n"); 
		query.append("    TO_CHAR(SYSDATE,'YYYYMMDD') AS INV_CFM_DT," ).append("\n"); 
		query.append("    B.GEN_PAY_TERM_CD," ).append("\n"); 
		query.append("    A.CURR_CD," ).append("\n"); 
		query.append("    NVL(A.CHG_SMRY_AMT,0) AS CHG_SMRY_AMT," ).append("\n"); 
		query.append("	TO_CHAR(TO_DATE(@[inv_iss_dt], 'YYYYMMDD'),'YYYYMMDD') AS ACT_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    CGM_PAY_INV A," ).append("\n"); 
		query.append("    MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("    AND PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 

	}
}