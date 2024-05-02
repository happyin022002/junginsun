/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOMergeTrunkVesselAndFeederCntrRepoPlanQtyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.04 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOMergeTrunkVesselAndFeederCntrRepoPlanQtyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_EXE_PLN_QTY
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOMergeTrunkVesselAndFeederCntrRepoPlanQtyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("lodg_port_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dchg_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dchg_port_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOMergeTrunkVesselAndFeederCntrRepoPlanQtyCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_VSL_EXE_PLN_QTY A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	 @[repo_pln_id]		REPO_PLN_ID" ).append("\n"); 
		query.append(",@[pln_yrwk]		PLN_YRWK" ).append("\n"); 
		query.append(",@[pln_seq]			PLN_SEQ" ).append("\n"); 
		query.append(",@[ref_id]			REF_ID" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.REPO_PLN_ID	= B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND	A.PLN_YRWK		= B.PLN_YRWK" ).append("\n"); 
		query.append("AND	A.PLN_SEQ		= B.PLN_SEQ" ).append("\n"); 
		query.append("AND	A.REF_ID		= B.REF_ID" ).append("\n"); 
		query.append("AND	A.CNTR_TPSZ_CD	= B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("CNTR_QTY			= @[cntr_qty]" ).append("\n"); 
		query.append(",LODG_DCHG_COST_AMT	= @[lodg_dchg_cost_amt]" ).append("\n"); 
		query.append(",UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append(",	PLN_YRWK" ).append("\n"); 
		query.append(",	PLN_SEQ" ).append("\n"); 
		query.append(",	REF_ID" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	CNTR_QTY" ).append("\n"); 
		query.append(",	LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append(",	PLN_UC_AMT" ).append("\n"); 
		query.append(",	LODG_PORT_UC_AMT" ).append("\n"); 
		query.append(",	DCHG_PORT_UC_AMT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[repo_pln_id]" ).append("\n"); 
		query.append(",	@[pln_yrwk]" ).append("\n"); 
		query.append(",	@[pln_seq]" ).append("\n"); 
		query.append(",	@[ref_id]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[cntr_qty]" ).append("\n"); 
		query.append(",	@[lodg_dchg_cost_amt]" ).append("\n"); 
		query.append(",	@[pln_uc_amt]" ).append("\n"); 
		query.append(",	@[lodg_port_uc_amt]" ).append("\n"); 
		query.append(",	@[dchg_port_uc_amt]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}