/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchASANOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
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

public class CSRIssueTransferSlipManageDBDAOSearchASANOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR ASA_NO LIST 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchASANOListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchASANOListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(ASA_NO, '|')), '|') asanostring" ).append("\n"); 
		query.append("  FROM (SELECT ASA_NO" ).append("\n"); 
		query.append("              ,ROWNUM ROW_ID" ).append("\n"); 
		query.append("          FROM SAR_ASA_MST" ).append("\n"); 
		query.append("         WHERE ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("           AND ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("           AND OFC_CD IN (SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                            FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                           WHERE (SUBSTR(LOC_CD, 1, 2) = 'CN' AND OFC_CD = @[OFC_CD])" ).append("\n"); 
		query.append("                              OR AR_OFC_CD = (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[OFC_CD])))" ).append("\n"); 
		query.append(" START WITH ROW_ID = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 

	}
}