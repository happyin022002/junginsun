/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.05.28 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOTrsPreAudCrteCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsPreAudCrteCond
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOTrsPreAudCrteCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOTrsPreAudCrteCondRSQL").append("\n"); 
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
		query.append(" '1' AS S_RHQ_OFC_CD" ).append("\n"); 
		query.append(",'1' AS S_OFC_CD" ).append("\n"); 
		query.append(",'1' AS S_CGO_TP_CD" ).append("\n"); 
		query.append(",'1' AS S_TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",'1' AS S_EXPN_AUD_CRTE_TP_CD" ).append("\n"); 
		query.append(",'1' AS S_EXPN_AUD_TGT_FLG" ).append("\n"); 
		query.append(",'1' AS I_OFC_CD" ).append("\n"); 
		query.append(",'1' AS I_EXPN_AUD_CRTE_TP_CD" ).append("\n"); 
		query.append(",'1' AS I_CGO_TP_CD" ).append("\n"); 
		query.append(",'1' AS I_TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}