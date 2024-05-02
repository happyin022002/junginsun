/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchBrogApPayInvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.14 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchBrogApPayInvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBrogApPayInvVO
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchBrogApPayInvVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration ").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchBrogApPayInvVORSQL").append("\n"); 
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
		query.append("'' INV_SUB_SYS_CD," ).append("\n"); 
		query.append("'' INV_OFC_CD," ).append("\n"); 
		query.append("'' COST_OFC_CD," ).append("\n"); 
		query.append("'' VNDR_SEQ," ).append("\n"); 
		query.append("'' INV_EFF_DT," ).append("\n"); 
		query.append("'' INV_CURR_CD," ).append("\n"); 
		query.append("'' INV_TTL_AMT," ).append("\n"); 
		query.append("'' INV_RMK," ).append("\n"); 
		query.append("'' CSR_NO," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT," ).append("\n"); 
		query.append("'' GL_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}