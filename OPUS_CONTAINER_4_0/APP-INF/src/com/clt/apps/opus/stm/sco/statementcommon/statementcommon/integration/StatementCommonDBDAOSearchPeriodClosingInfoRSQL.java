/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchPeriodClosingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchPeriodClosingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPeriodClosingInfo
	  * </pre>
	  */
	public StatementCommonDBDAOSearchPeriodClosingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prd_appl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchPeriodClosingInfoRSQL").append("\n"); 
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
		query.append("SELECT SCP.PRD_APPL_CD" ).append("\n"); 
		query.append("     , SCP.EFF_YRMON" ).append("\n"); 
		query.append("     , SCP.PRD_STS_CD" ).append("\n"); 
		query.append("	 , SCP.CRE_USR_ID" ).append("\n"); 
		query.append("	 , SCP.CRE_DT" ).append("\n"); 
		query.append("	 , SCP.UPD_USR_ID" ).append("\n"); 
		query.append("	 , SCP.UPD_DT" ).append("\n"); 
		query.append("  FROM SCO_PERIOD SCP" ).append("\n"); 
		query.append(" WHERE SCP.PRD_APPL_CD = NVL(@[prd_appl_cd], SCP.PRD_APPL_CD)" ).append("\n"); 
		query.append("   AND SCP.EFF_YRMON = NVL(REPLACE(@[eff_yrmon],'-',''), SCP.EFF_YRMON)" ).append("\n"); 
		query.append(" ORDER BY SCP.PRD_APPL_CD, SCP.EFF_YRMON DESC" ).append("\n"); 

	}
}