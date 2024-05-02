/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.29
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.01.29 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_LODG_DCHG_EXE_PLN  VOL 제외한 UPDATE QUERY
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_fb_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_fb_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_repo_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanUSQL").append("\n"); 
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
		query.append("-- EQR_VSL_LODG_DCHG_EXE_PLN  VOL 제외한 UPDATE QUERY -------------------------" ).append("\n"); 
		query.append("UPDATE	EQR_VSL_LODG_DCHG_EXE_PLN SET " ).append("\n"); 
		query.append("		EQ_REPO_PURP_CD		= @[eq_repo_purp_cd]" ).append("\n"); 
		query.append("	,	REPO_PLN_FB_RSN_CD	= @[repo_pln_fb_rsn_cd]" ).append("\n"); 
		query.append("	,	REPO_PLN_FB_RMK		= @[repo_pln_fb_rmk]" ).append("\n"); 
		query.append("	,	TO_YD_CD			= SUBSTR(@[to_yd_cd], -7)" ).append("\n"); 
		query.append("	,	TO_ETB_DT			= TO_DATE(@[to_etb_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("	,	UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	REPO_PLN_ID	= @[repo_pln_id]" ).append("\n"); 
		query.append("	AND	PLN_YRWK	= @[pln_yrwk]" ).append("\n"); 
		query.append("	AND	PLN_SEQ		= @[pln_seq]" ).append("\n"); 
		query.append("	AND	REF_ID		= @[ref_id]" ).append("\n"); 

	}
}