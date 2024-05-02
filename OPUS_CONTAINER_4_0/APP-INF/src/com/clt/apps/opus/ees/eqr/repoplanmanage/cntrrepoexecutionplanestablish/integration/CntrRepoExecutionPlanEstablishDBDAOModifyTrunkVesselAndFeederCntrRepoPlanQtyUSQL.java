/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanQtyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.31 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanQtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_EXE_PLN_QTY 수정
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanQtyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_port_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_dchg_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOModifyTrunkVesselAndFeederCntrRepoPlanQtyUSQL").append("\n"); 
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
		query.append("UPDATE EQR_VSL_EXE_PLN_QTY SET" ).append("\n"); 
		query.append("CNTR_QTY			= @[cntr_qty]" ).append("\n"); 
		query.append(",	LODG_DCHG_COST_AMT	= @[lodg_dchg_cost_amt]" ).append("\n"); 
		query.append(",	PLN_UC_AMT			= @[pln_uc_amt]" ).append("\n"); 
		query.append(",	LODG_PORT_UC_AMT	= @[lodg_port_uc_amt]" ).append("\n"); 
		query.append(",	DCHG_PORT_UC_AMT	= @[dchg_port_uc_amt]" ).append("\n"); 
		query.append(",	UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	REPO_PLN_ID		= @[repo_pln_id]" ).append("\n"); 
		query.append("AND	PLN_YRWK		= @[pln_yrwk]" ).append("\n"); 
		query.append("AND	PLN_SEQ			= @[pln_seq]" ).append("\n"); 
		query.append("AND	REF_ID			= @[ref_id]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD	= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}