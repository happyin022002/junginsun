/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateCsrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateCsrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR 번호를 채번
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateCsrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COST_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_TYPE",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateCsrNoRSQL").append("\n"); 
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
		query.append("SELECT '12' || @[CSR_TYPE] " ).append("\n"); 
		query.append("            || (SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[COST_OFC_CD])" ).append("\n"); 
		query.append("			|| (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[COST_OFC_CD]), 'YYMM') FROM DUAL)" ).append("\n"); 
		query.append("			|| (SELECT LPAD(NVL(MAX(SUBSTR(CSR_NO, 13, 4)), 0) + 1, 4, '0')" ).append("\n"); 
		query.append("					FROM AP_CSR_NO" ).append("\n"); 
		query.append("				 WHERE SUBSTR(CSR_NO, 1, 12) = '12' || @[CSR_TYPE] || (SELECT AP_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[COST_OFC_CD]) ||" ).append("\n"); 
		query.append("							 (SELECT TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[COST_OFC_CD]), 'YYMM') FROM DUAL)) NEW_CSR_NO" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 

	}
}