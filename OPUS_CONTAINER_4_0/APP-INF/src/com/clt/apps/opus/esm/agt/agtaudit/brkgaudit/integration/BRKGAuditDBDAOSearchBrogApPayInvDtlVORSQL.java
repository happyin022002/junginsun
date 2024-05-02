/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchBrogApPayInvDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.14 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchBrogApPayInvDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBrogApPayInvDtlVO
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchBrogApPayInvDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchBrogApPayInvDtlVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("'' ACCT_CD," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_CD," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' REV_DIR_CD," ).append("\n"); 
		query.append("'' ACT_VVD_CD," ).append("\n"); 
		query.append("'' YD_CD," ).append("\n"); 
		query.append("'' CNTR_TPSZ_CD," ).append("\n"); 
		query.append("'' INV_AMT," ).append("\n"); 
		query.append("'' SO_20FT_QTY," ).append("\n"); 
		query.append("'' SO_40FT_QTY,    " ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT," ).append("\n"); 
		query.append("'' INV_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}