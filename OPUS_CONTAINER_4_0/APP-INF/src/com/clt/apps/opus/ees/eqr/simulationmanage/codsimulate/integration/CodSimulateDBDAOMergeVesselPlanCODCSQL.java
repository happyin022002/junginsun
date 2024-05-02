/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOMergeVesselPlanCODCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.11.09 채창호
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

public class CodSimulateDBDAOMergeVesselPlanCODCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD 대상인 데이터를 EQR_VSL_LODG_DCHG_PLN에 수정/입력
	  * </pre>
	  */
	public CodSimulateDBDAOMergeVesselPlanCODCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_pln_ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("past_repo_pln_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOMergeVesselPlanCODCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_VSL_LODG_DCHG_PLN A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("@[repo_pln_id] as REPO_PLN_ID" ).append("\n"); 
		query.append(",@[pln_yrwk] as PLN_YRWK" ).append("\n"); 
		query.append(",@[pln_seq] as PLN_SEQ" ).append("\n"); 
		query.append(",@[trsp_mod_cd] as TRSP_MOD_CD" ).append("\n"); 
		query.append(",@[vsl_lane_cd] as VSL_LANE_CD" ).append("\n"); 
		query.append(",@[vsl_cd] as VSL_CD" ).append("\n"); 
		query.append(",@[skd_voy_no] as SKD_VOY_NO" ).append("\n"); 
		query.append(",@[skd_dir_cd] as SKD_DIR_CD" ).append("\n"); 
		query.append(",@[fm_ecc_cd] as FM_ECC_CD" ).append("\n"); 
		query.append(",to_date (@[fm_etd_dt],'YYYY-MM-DD HH24:MI:SS') as FM_ETD_DT" ).append("\n"); 
		query.append(",@[to_ecc_cd] as TO_ECC_CD" ).append("\n"); 
		query.append(",to_date (@[to_etb_dt],'YYYY-MM-DD HH24:MI:SS') as TO_ETB_DT" ).append("\n"); 
		query.append(",@[past_repo_pln_flg] as PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append("--CSRNO : R200806027055의 변경" ).append("\n"); 
		query.append(",@[pre_pln_ts_flg] as PRE_PLN_TS_FLG" ).append("\n"); 
		query.append(",@[to_yard] as TO_YD_CD" ).append("\n"); 
		query.append(",@[fm_yard] as FM_YD_CD" ).append("\n"); 
		query.append("FROM      DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON ( A.REPO_PLN_ID     = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND A.PLN_YRWK    = B.PLN_YRWK" ).append("\n"); 
		query.append("AND A.PLN_SEQ     = B.PLN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.UPD_USR_ID = @[upd_usr_id]                  ," ).append("\n"); 
		query.append("A.UPD_DT = sysdate                           ," ).append("\n"); 
		query.append("--CSRNO : R200806027055 의겨 변경" ).append("\n"); 
		query.append("A.LDIS_TS_FLG = B.PRE_PLN_TS_FLG" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(A.REPO_PLN_ID" ).append("\n"); 
		query.append(",A.PLN_YRWK" ).append("\n"); 
		query.append(",A.PLN_SEQ" ).append("\n"); 
		query.append(",A.TRSP_MOD_CD" ).append("\n"); 
		query.append(",A.VSL_LANE_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.FM_ECC_CD" ).append("\n"); 
		query.append(",A.FM_ETD_DT" ).append("\n"); 
		query.append(",A.FM_YD_CD" ).append("\n"); 
		query.append(",A.TO_ECC_CD" ).append("\n"); 
		query.append(",A.TO_ETB_DT" ).append("\n"); 
		query.append(",A.TO_YD_CD" ).append("\n"); 
		query.append(",A.LDIS_TS_FLG" ).append("\n"); 
		query.append(",A.PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[repo_pln_id] ," ).append("\n"); 
		query.append("@[pln_yrwk]    ," ).append("\n"); 
		query.append("@[pln_seq]     ," ).append("\n"); 
		query.append("@[trsp_mod_cd] ," ).append("\n"); 
		query.append("@[vsl_lane_cd] ," ).append("\n"); 
		query.append("@[vsl_cd]      ," ).append("\n"); 
		query.append("@[skd_voy_no]  ," ).append("\n"); 
		query.append("@[skd_dir_cd]  ," ).append("\n"); 
		query.append("@[fm_ecc_cd]   ," ).append("\n"); 
		query.append("TO_DATE (@[fm_etd_dt],'YYYY-MM-DD HH24:MI:SS') ," ).append("\n"); 
		query.append("@[fm_yard]," ).append("\n"); 
		query.append("@[to_ecc_cd] ," ).append("\n"); 
		query.append("TO_DATE (@[to_etb_dt],'YYYY-MM-DD HH24:MI:SS') ," ).append("\n"); 
		query.append("@[to_yard]," ).append("\n"); 
		query.append("@[pre_pln_ts_flg] ," ).append("\n"); 
		query.append("@[past_repo_pln_flg] ," ).append("\n"); 
		query.append("@[cre_usr_id] ," ).append("\n"); 
		query.append("sysdate ," ).append("\n"); 
		query.append("@[upd_usr_id] ," ).append("\n"); 
		query.append("sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}