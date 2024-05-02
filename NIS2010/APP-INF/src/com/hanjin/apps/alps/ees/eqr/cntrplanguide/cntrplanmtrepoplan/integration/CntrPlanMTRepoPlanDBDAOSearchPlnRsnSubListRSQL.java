/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrPlanMTRepoPlanDBDAOSearchPlnRsnSubListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrPlanMTRepoPlanDBDAOSearchPlnRsnSubListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PlnRsnSub 조회
	  * </pre>
	  */
	public CntrPlanMTRepoPlanDBDAOSearchPlnRsnSubListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plnRsnHdrCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.integration").append("\n"); 
		query.append("FileName : CntrPlanMTRepoPlanDBDAOSearchPlnRsnSubListRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_SUB_CODE,'|')),'|')||'$$'||LTRIM(MAX(SYS_CONNECT_BY_PATH(PLN_RSN_SUB_TEXT,'|')),'|') PLN_RSN_SUB_CODE_N_TEXT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    ROWNUM ROW_ID, H.PLN_RSN_HDR_NM||'@@'||S.PLN_RSN_SUB_NM PLN_RSN_SUB_TEXT, S.PLN_RSN_HDR_CD||S.PLN_RSN_SUB_CD PLN_RSN_SUB_CODE" ).append("\n"); 
		query.append("    FROM EQR_CTRL_PLN_RSN_HDR H, EQR_CTRL_PLN_RSN_SUB S" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND H.PLN_RSN_HDR_CD = S.PLN_RSN_HDR_CD" ).append("\n"); 
		query.append("	#if (${plnRsnHdrCd} != '') " ).append("\n"); 
		query.append("	AND S.PLN_RSN_HDR_CD = @[plnRsnHdrCd]" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    ORDER BY S.DP_SEQ" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("START WITH ROW_ID = 1 " ).append("\n"); 

	}
}