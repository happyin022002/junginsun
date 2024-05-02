/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageDBDAOSearchScenarioIDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.12.24 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioManageDBDAOSearchScenarioIDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquire Scenario ID List
	  *  - EQR_SCNR_MST 조회
	  * </pre>
	  */
	public ScenarioManageDBDAOSearchScenarioIDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrsyrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnreyrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration").append("\n"); 
		query.append("FileName : ScenarioManageDBDAOSearchScenarioIDListRSQL").append("\n"); 
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
		query.append("SELECT	 SUBSTR(A.SCNR_ID,5,4)||'-'||SUBSTR(A.SCNR_ID,9,2) WEEK" ).append("\n"); 
		query.append(",A.SCNR_ID" ).append("\n"); 
		query.append(",A.SCNR_RMK" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT,'YYYY-MM-DD')||' '||TO_CHAR(A.UPD_DT,'HH24:MI')UPD_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT,'YYYY-MM-DD')||' '||TO_CHAR(A.CRE_DT,'HH24:MI')CRE_DT" ).append("\n"); 
		query.append(",DECODE (A.REPO_PLN_DTRB_FLG, 'Y', 0, 1) REPO_PLN_DTRB_FLG" ).append("\n"); 
		query.append(",DECODE (A.REPO_PLN_CRE_FLG, 'Y', 0, 1) REPO" ).append("\n"); 
		query.append(",DECODE (A.SCNR_AUTO_GEN_FLG, 'Y', 0, 1) AUTO" ).append("\n"); 
		query.append(",DECODE (A.SCNR_AUTO_GEN_FLG, 'N', 0, 1) MANUAL" ).append("\n"); 
		query.append("FROM	EQR_SCNR_MST A" ).append("\n"); 
		query.append("WHERE	A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${scnrsyrwk} != '')" ).append("\n"); 
		query.append("AND SUBSTR (A.SCNR_ID, 5, 6) BETWEEN @[scnrsyrwk] AND @[scnreyrwk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} == 'D')" ).append("\n"); 
		query.append("AND A.REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'R')" ).append("\n"); 
		query.append("AND A.REPO_PLN_CRE_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'A')" ).append("\n"); 
		query.append("AND A.SCNR_AUTO_GEN_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${status} == 'M')" ).append("\n"); 
		query.append("AND A.SCNR_AUTO_GEN_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scnrweek} != '')" ).append("\n"); 
		query.append("AND A.SCNR_ID =  '${scnrweek}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND A.UPD_USR_ID =  '${cre_usr_id}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY WEEK" ).append("\n"); 
		query.append(",A.SCNR_ID" ).append("\n"); 

	}
}