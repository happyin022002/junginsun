/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOInsertShuttleCntrRepoPlanCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.24 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOInsertShuttleCntrRepoPlanCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 이송 실행 계획 조회/수정 Shuttle (EES_EQR_083) DB에 반영한다
	  * INSERT : - REF_ID 생성
	  * - EQR_ECC_INTER_EXE_PLN   입력
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOInsertShuttleCntrRepoPlanCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_repo_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmb_ref_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOInsertShuttleCntrRepoPlanCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_ECC_INTER_EXE_PLN (" ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append(",	PLN_YRWK" ).append("\n"); 
		query.append(",	REF_ID" ).append("\n"); 
		query.append(",	CO_CD" ).append("\n"); 
		query.append(",	TRSP_MOD_CD" ).append("\n"); 
		query.append(",	FM_YD_CD" ).append("\n"); 
		query.append(",	FM_ETD_DT" ).append("\n"); 
		query.append(",	TO_YD_CD" ).append("\n"); 
		query.append(",	TO_ETA_DT" ).append("\n"); 
		query.append(",	EQ_REPO_PURP_CD" ).append("\n"); 
		query.append(",	EXE_ISS_FLG" ).append("\n"); 
		query.append(",	CMB_REF_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[repo_pln_id]" ).append("\n"); 
		query.append(",	@[pln_yrwk]" ).append("\n"); 
		query.append(",	@[ref_id]" ).append("\n"); 
		query.append(",	@[co_cd]" ).append("\n"); 
		query.append(",	@[trsp_mod_cd]" ).append("\n"); 
		query.append(",	@[fm_yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[fm_etd_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[to_yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[to_eta_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[eq_repo_purp_cd]" ).append("\n"); 
		query.append(",	@[exe_iss_flg]" ).append("\n"); 
		query.append(",	@[cmb_ref_id]" ).append("\n"); 
		query.append(",	@[user_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[user_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}