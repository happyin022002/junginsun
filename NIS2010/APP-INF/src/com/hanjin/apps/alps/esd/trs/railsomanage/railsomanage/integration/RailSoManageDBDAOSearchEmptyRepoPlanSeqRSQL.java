/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RailSoManageDBDAOSearchEmptyRepoPlanSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchEmptyRepoPlanSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repo Plan Seq 채번
	  * </pre>
	  */
	public RailSoManageDBDAOSearchEmptyRepoPlanSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchEmptyRepoPlanSeqRSQL").append("\n"); 
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
		query.append("SELECT 'REPO'||PLN_YR||PLN_WK||'W001' REPO_PLN_ID" ).append("\n"); 
		query.append("       ,PLN_YR||PLN_WK PLN_YRWK" ).append("\n"); 
		query.append("  FROM EQR_WK_PRD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 

	}
}