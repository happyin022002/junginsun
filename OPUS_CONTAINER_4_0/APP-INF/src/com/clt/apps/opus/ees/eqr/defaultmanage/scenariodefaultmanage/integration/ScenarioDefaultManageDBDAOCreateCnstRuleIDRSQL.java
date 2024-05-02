/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOCreateCnstRuleIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.03.17 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author chang Ho. chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOCreateCnstRuleIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_CNST  테이블에서 최대 rule id 추출
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOCreateCnstRuleIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nationcode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnsttypecode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOCreateCnstRuleIDRSQL").append("\n"); 
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
		query.append("	NVL(MAX(TO_NUMBER(SUBSTR(CNST_RULE_ID,3,4)))+1,1) AS CNST_RULE_ID" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	EQR_REPO_CNST" ).append("\n"); 
		query.append("WHERE	" ).append("\n"); 
		query.append("	SUBSTR(CNST_RULE_ID,0,2)	= @[nationcode]" ).append("\n"); 
		query.append("	AND	REPO_CNST_TP_CD			= @[cnsttypecode]" ).append("\n"); 

	}
}