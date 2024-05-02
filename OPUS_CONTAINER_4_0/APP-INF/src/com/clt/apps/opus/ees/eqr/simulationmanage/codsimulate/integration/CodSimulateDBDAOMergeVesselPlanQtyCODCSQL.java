/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOMergeVesselPlanQtyCODCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.02 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOMergeVesselPlanQtyCODCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD 대상인 데이터를 EQR_VSL_LODG_DCHG_PLN_QTY에 수정/입력
	  * </pre>
	  */
	public CodSimulateDBDAOMergeVesselPlanQtyCODCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_pln_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_sim_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_port_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lodg_port_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_pln_dchg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_dchg_pln_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOMergeVesselPlanQtyCODCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_VSL_LODG_DCHG_PLN_QTY A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("@[repo_pln_id] as  REPO_PLN_ID" ).append("\n"); 
		query.append(",@[pln_yrwk] as PLN_YRWK" ).append("\n"); 
		query.append(",@[pln_seq] as PLN_SEQ" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd] as CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",@[cntr_qty] as CNTR_QTY" ).append("\n"); 
		query.append(",@[lodg_dchg_cost_amt] as LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append(",@[pre_pln_cntr_qty] as PRE_PLN_CNTR_QTY" ).append("\n"); 
		query.append(",@[cod_sim_flg] as COD_SIM_FLG" ).append("\n"); 
		query.append(",@[cod_dchg_pln_flg] as COD_DCHG_PLN_FLG" ).append("\n"); 
		query.append(",@[pre_pln_dchg_loc_cd] as PRE_PLN_DCHG_LOC_CD" ).append("\n"); 
		query.append("FROM      DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON ( 	A.REPO_PLN_ID     = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.CNTR_QTY  = B.CNTR_QTY                     ," ).append("\n"); 
		query.append("A.COD_SIM_FLG = 'Y'                          ," ).append("\n"); 
		query.append("A.LODG_DCHG_COST_AMT = ROUND((A.LODG_PORT_COST_AMT / DECODE(A.CNTR_QTY, 0, 1 ,A.CNTR_QTY)) * @[cntr_qty] ) + ROUND((A.DCHG_PORT_COST_AMT / DECODE(A.CNTR_QTY, 0, 1 ,A.CNTR_QTY))) * @[cntr_qty]   ," ).append("\n"); 
		query.append("A.PLN_UC_AMT         = (A.LODG_PORT_COST_AMT / DECODE(A.CNTR_QTY, 0, 1 ,A.CNTR_QTY)) +  (A.DCHG_PORT_COST_AMT / DECODE(A.CNTR_QTY, 0, 1 ,A.CNTR_QTY))   ," ).append("\n"); 
		query.append("A.LODG_PORT_COST_AMT = (A.LODG_PORT_COST_AMT / DECODE(A.CNTR_QTY, 0, 1 ,A.CNTR_QTY)) * DECODE(@[cntr_qty], 0, 1 ,@[cntr_qty])    ," ).append("\n"); 
		query.append("A.DCHG_PORT_COST_AMT = (A.DCHG_PORT_COST_AMT / DECODE(A.CNTR_QTY, 0, 1 ,A.CNTR_QTY)) * DECODE(@[cntr_qty], 0, 1 ,@[cntr_qty])    ," ).append("\n"); 
		query.append("A.PRE_PLN_DCHG_LOC_CD = B.PRE_PLN_DCHG_LOC_CD," ).append("\n"); 
		query.append("A.PRE_PLN_CNTR_QTY = B.PRE_PLN_CNTR_QTY      ," ).append("\n"); 
		query.append("A.COD_DCHG_PLN_FLG = B.COD_DCHG_PLN_FLG      ," ).append("\n"); 
		query.append("A.UPD_USR_ID = @[upd_usr_id]                 ," ).append("\n"); 
		query.append("A.UPD_DT = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("( A.REPO_PLN_ID" ).append("\n"); 
		query.append(",A.PLN_YRWK" ).append("\n"); 
		query.append(",A.PLN_SEQ" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.CNTR_QTY" ).append("\n"); 
		query.append(",A.LODG_DCHG_COST_AMT" ).append("\n"); 
		query.append(",A.PRE_PLN_CNTR_QTY" ).append("\n"); 
		query.append(",A.PLN_UC_AMT" ).append("\n"); 
		query.append(",A.LODG_PORT_COST_AMT" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(",A.COD_SIM_FLG" ).append("\n"); 
		query.append(",A.COD_DCHG_PLN_FLG" ).append("\n"); 
		query.append(",A.PRE_PLN_DCHG_LOC_CD" ).append("\n"); 
		query.append(",A.DCHG_PORT_COST_AMT" ).append("\n"); 
		query.append(") VALUES" ).append("\n"); 
		query.append("(@[repo_pln_id] ," ).append("\n"); 
		query.append("@[pln_yrwk]," ).append("\n"); 
		query.append("@[pln_seq] ," ).append("\n"); 
		query.append("@[cntr_tpsz_cd] ," ).append("\n"); 
		query.append("@[cntr_qty] ," ).append("\n"); 
		query.append("@[lodg_dchg_cost_amt] ," ).append("\n"); 
		query.append("@[pre_pln_cntr_qty] ," ).append("\n"); 
		query.append("@[pln_uc_amt]," ).append("\n"); 
		query.append("@[lodg_port_cost_amt]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[cod_sim_flg]," ).append("\n"); 
		query.append("@[cod_dchg_pln_flg]," ).append("\n"); 
		query.append("@[pre_pln_dchg_loc_cd]," ).append("\n"); 
		query.append("@[dchg_port_cost_amt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}