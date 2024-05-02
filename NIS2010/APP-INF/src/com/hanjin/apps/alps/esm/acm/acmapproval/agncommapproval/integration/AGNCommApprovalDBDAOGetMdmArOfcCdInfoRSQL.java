/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOGetMdmArOfcCdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.17
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.17 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOGetMdmArOfcCdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMdmArOfcCdInfo
	  * </pre>
	  */
	public AGNCommApprovalDBDAOGetMdmArOfcCdInfoRSQL(){
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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOGetMdmArOfcCdInfoRSQL").append("\n"); 
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
		query.append("    CASE WHEN AGN_AR_OFC_CD <> 'X' THEN AGN_AR_OFC_CD ELSE OFC_AR_OFC_CD END AR_OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT NVL(MAX(AR_OFC_CD),'X') AGN_AR_OFC_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("     WHERE OFC_CD = @[agn_cd]" ).append("\n"); 
		query.append("       AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")A,(" ).append("\n"); 
		query.append("    SELECT NVL(MAX(AR_OFC_CD),'X') OFC_AR_OFC_CD" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("     WHERE OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("       AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(")B" ).append("\n"); 

	}
}