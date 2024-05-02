/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrRepoExeSoIfByOffHireReturnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.12.31 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOSearchEqrRepoExeSoIfByOffHireReturnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS OFF Hire 직반납시 EQR_REPO_EXE_SO_IF 조회
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOSearchEqrRepoExeSoIfByOffHireReturnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOSearchEqrRepoExeSoIfByOffHireReturnRSQL").append("\n"); 
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
		query.append("PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	REPO_PLN_ID" ).append("\n"); 
		query.append(",	PLN_YRWK" ).append("\n"); 
		query.append(",	PLN_SEQ" ).append("\n"); 
		query.append(",	REF_ID" ).append("\n"); 
		query.append(",	REF_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CO_CD" ).append("\n"); 
		query.append(",	SO_IF_DIV_CD" ).append("\n"); 
		query.append(",	TRSP_MOD_CD" ).append("\n"); 
		query.append(",	FM_YD_CD" ).append("\n"); 
		query.append(",	FM_DT" ).append("\n"); 
		query.append(",	TO_YD_CD" ).append("\n"); 
		query.append(",	TO_DT" ).append("\n"); 
		query.append(",	VSL_LANE_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REPO_PURP_RMK" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	WO_EXE_FLG" ).append("\n"); 
		query.append(",	WO_EXE_DT" ).append("\n"); 
		query.append(",	REPO_COST_AMT" ).append("\n"); 
		query.append(",	EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",	SO_RQST_DT" ).append("\n"); 
		query.append(",	WO_RQST_FLG" ).append("\n"); 
		query.append(",	WO_EXE_ERR_RMK" ).append("\n"); 
		query.append(",	TRSP_SO_STS_CD" ).append("\n"); 
		query.append(",	TRNS_RQST_OFC_CD" ).append("\n"); 
		query.append(",	TRNS_RQST_USR_ID" ).append("\n"); 
		query.append(",	TRNS_RQST_RSN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_REPO_EXE_SO_IF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND	PLN_YRWK = @[pln_yrwk]" ).append("\n"); 
		query.append("AND	REF_ID = @[ref_id]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND REF_SEQ IN (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${key} in ${oldRefSeqList})" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#if($velocityCount < $oldRefSeqList.size())" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("REF_SEQ DESC" ).append("\n"); 

	}
}