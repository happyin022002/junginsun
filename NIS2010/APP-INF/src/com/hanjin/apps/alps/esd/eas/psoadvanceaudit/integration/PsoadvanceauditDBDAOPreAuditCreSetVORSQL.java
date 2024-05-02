/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsoadvanceauditDBDAOPreAuditCreSetVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.11 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoadvanceauditDBDAOPreAuditCreSetVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre-Audit Criterion setting VO 생성쿼리 
	  * </pre>
	  */
	public PsoadvanceauditDBDAOPreAuditCreSetVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoadvanceauditDBDAOPreAuditCreSetVORSQL").append("\n"); 
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
		query.append("SELECT '' AS CHG_TP_NM" ).append("\n"); 
		query.append("      ,'' AS ACCT_CD" ).append("\n"); 
		query.append("      ,'' AS ACCT_NM" ).append("\n"); 
		query.append("      ,'' AS COST_CD" ).append("\n"); 
		query.append("      ,'' AS COST_NM" ).append("\n"); 
		query.append("      ,'' AS LGS_COST_AUD_FLG" ).append("\n"); 
		query.append("      ,'' AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("      ,'' AS EXPN_PRMT_RTO_RSN" ).append("\n"); 
		query.append("      ,'' AS S_CHG_TP_CD" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS AUD_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS S_AUD_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS S_AUTO_ACD" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}