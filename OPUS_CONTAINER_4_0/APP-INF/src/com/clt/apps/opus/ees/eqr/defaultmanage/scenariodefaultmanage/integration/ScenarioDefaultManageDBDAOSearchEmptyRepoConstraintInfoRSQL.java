/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchEmptyRepoConstraintInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.03.18 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchEmptyRepoConstraintInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI ID : EES_EQR_0124
	  * Title : Cabotage &  Rule
	  * Change History---------------------------------------------
	  * CSR No             Modifier     Modified Date   Comments
	  * R200806257580    장유정       2008.06-27        컨테이너의 종류를 화면에서 받아옵니다.
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchEmptyRepoConstraintInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchEmptyRepoConstraintInfoRSQL").append("\n"); 
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
		query.append("SELECT	 MAX(REPO_CNST_SEQ) AS REPO_CNST_SEQ" ).append("\n"); 
		query.append("		,MAX(CNST_RULE_ID) AS CNST_RULE_ID" ).append("\n"); 
		query.append("		,MAX(REPO_CNST_TP_CD) AS REPO_CNST_TP_CD" ).append("\n"); 
		query.append("		,CASE WHEN MAX(RULE_EXPT_FLG) = 'Y' THEN 'EXCEPTION'  ELSE MAX(CNST_RULE_ID) END AS CNST_RULE_ID_2" ).append("\n"); 
		query.append("		,MAX(REPO_CNST_DIR_CD) AS REPO_CNST_DIR_CD" ).append("\n"); 
		query.append("		,CASE WHEN MAX(FM_LOC_GRP_CD) = 'N' THEN ''  ELSE MAX(FM_LOC_GRP_CD) END AS FM_LOC_GRP_CD" ).append("\n"); 
		query.append("		,CASE WHEN MAX(FM_LOC_CD) = 'N/A' THEN ''  ELSE MAX(FM_LOC_CD) END AS FM_LOC_CD" ).append("\n"); 
		query.append("		,CASE WHEN MAX(TO_LOC_GRP_CD) = 'N' THEN ''  ELSE MAX(TO_LOC_GRP_CD) END AS TO_LOC_GRP_CD" ).append("\n"); 
		query.append("		,CASE WHEN MAX(TO_LOC_CD) = 'N/A' THEN ''  ELSE MAX(TO_LOC_CD) END AS TO_LOC_CD" ).append("\n"); 
		query.append("		,CASE WHEN MAX(RULE_EXPT_FLG) = 'Y' THEN '1'  ELSE '0' END AS RULE_EXPT_FLG" ).append("\n"); 
		query.append("		,MAX(EQ_TRSP_MOD_CD) AS EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("		,'' AS CNST_CNTR_TPSZ_CD_ALL" ).append("\n"); 
		query.append("		,MAX(UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("		,MAX(TO_CHAR(UPD_DT, 'YYYYMMDD')) AS UPD_DT" ).append("\n"); 
		query.append("	#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("		,MAX(NVL(DECODE(CNST_CNTR_TPSZ_CD,'$key','1'),'0')) CNST_CNTR_TPSZ_CD${key}" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	REPO_CNST_SEQ" ).append("\n"); 
		query.append("				,REPO_CNST_TP_CD" ).append("\n"); 
		query.append("				,CNST_RULE_ID" ).append("\n"); 
		query.append("				,REPO_CNST_DIR_CD" ).append("\n"); 
		query.append("				,FM_LOC_GRP_CD" ).append("\n"); 
		query.append("				,FM_LOC_CD" ).append("\n"); 
		query.append("				,TO_LOC_GRP_CD" ).append("\n"); 
		query.append("				,TO_LOC_CD" ).append("\n"); 
		query.append("				,RULE_EXPT_FLG" ).append("\n"); 
		query.append("				,EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("				,CNST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,UPD_USR_ID" ).append("\n"); 
		query.append("				,UPD_DT" ).append("\n"); 
		query.append("		FROM	EQR_REPO_CNST" ).append("\n"); 
		query.append("		ORDER BY REPO_CNST_TP_CD" ).append("\n"); 
		query.append("				,CNST_RULE_ID" ).append("\n"); 
		query.append("				,RULE_EXPT_FLG" ).append("\n"); 
		query.append("				,REPO_CNST_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cnsttype} != '') " ).append("\n"); 
		query.append("WHERE	REPO_CNST_TP_CD = '$cnsttype'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("GROUP BY REPO_CNST_TP_CD" ).append("\n"); 
		query.append("		,CNST_RULE_ID" ).append("\n"); 
		query.append("		,RULE_EXPT_FLG" ).append("\n"); 
		query.append("		,REPO_CNST_SEQ" ).append("\n"); 
		query.append("ORDER BY REPO_CNST_TP_CD" ).append("\n"); 
		query.append("		,CNST_RULE_ID" ).append("\n"); 
		query.append("		,RULE_EXPT_FLG" ).append("\n"); 
		query.append("		,REPO_CNST_SEQ" ).append("\n"); 

	}
}