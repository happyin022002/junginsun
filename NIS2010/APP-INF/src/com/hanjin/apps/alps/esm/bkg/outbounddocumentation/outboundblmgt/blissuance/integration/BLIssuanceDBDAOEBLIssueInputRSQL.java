/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOEBLIssueInputRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.08 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOEBLIssueInputRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOEBLIssueInputRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOEBLIssueInputRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    '' SR_RQST_TP_CD," ).append("\n"); 
		query.append("    '' SR_STS_CD," ).append("\n"); 
		query.append("    '' SR_RQST_NO," ).append("\n"); 
		query.append("    '' BKG_NO," ).append("\n"); 
		query.append("    '' SR_RQST_DT," ).append("\n"); 
		query.append("	'' SR_RQST_ST_DT," ).append("\n"); 
		query.append("	'' SR_RQST_END_DT," ).append("\n"); 
		query.append("	'' CUST_TP_CD," ).append("\n"); 
		query.append("    '' CUST_CD," ).append("\n"); 
		query.append("    '' CUST_NM," ).append("\n"); 
		query.append("	'' VVD," ).append("\n"); 
		query.append("	'' SLAN_CD," ).append("\n"); 
		query.append("	'' POR_CD," ).append("\n"); 
		query.append("	'' POL_CD," ).append("\n"); 
		query.append("	'' POD_CD," ).append("\n"); 
		query.append("	'' DEL_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}