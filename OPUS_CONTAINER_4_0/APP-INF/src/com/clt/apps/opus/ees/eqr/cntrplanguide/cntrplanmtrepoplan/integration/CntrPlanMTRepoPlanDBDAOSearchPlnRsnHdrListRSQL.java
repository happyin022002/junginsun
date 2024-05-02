/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanMTRepoPlanDBDAOSearchPlnRsnHdrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanMTRepoPlanDBDAOSearchPlnRsnHdrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CntrPlanMTRepoPlanDBDAOSearchPlnRsnHdrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration").append("\n"); 
		query.append("FileName : CntrPlanMTRepoPlanDBDAOSearchPlnRsnHdrListRSQL").append("\n"); 
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
		query.append("--SELECT H.PLN_RSN_HDR_CD, H.PLN_RSN_HDR_NM" ).append("\n"); 
		query.append("--FROM  EQR_CTRL_PLN_RSN_HDR H" ).append("\n"); 
		query.append("--ORDER BY H.DP_SEQ" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_HDR_CD,'|')),'|')||'$$'||LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_HDR_NM,'|')),'|') PLN_RSN_HDR_CODE_N_TEXT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM ROW_ID, H.PLN_RSN_HDR_CD, H.PLN_RSN_HDR_NM" ).append("\n"); 
		query.append("FROM  EQR_CTRL_PLN_RSN_HDR H" ).append("\n"); 
		query.append("ORDER BY H.DP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 

	}
}