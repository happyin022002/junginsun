/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOMergeCodTempCSQL.java
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

public class CodSimulateDBDAOMergeCodTempCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_VSL_LDIS_PLN_COD_TMP 테이블의 특정 REPO PLAN ID 데이터가 존재하면  update, 존재하지 않으면 insert
	  * </pre>
	  */
	public CodSimulateDBDAOMergeCodTempCSQL(){
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
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_seq1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOMergeCodTempCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_VSL_LDIS_PLN_COD_TMP A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("@[repo_pln_id]  AS REPO_PLN_ID," ).append("\n"); 
		query.append("@[pln_yrwk]  AS PLN_YRWK," ).append("\n"); 
		query.append("@[pln_seq]  AS PLN_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON  (" ).append("\n"); 
		query.append("A.REPO_PLN_ID  = B.REPO_PLN_ID" ).append("\n"); 
		query.append("AND  A.PLN_YRWK     = B.PLN_YRWK" ).append("\n"); 
		query.append("AND  A.PLN_SEQ      = B.PLN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET  A.UPD_USR_ID  = @[upd_usr_id] ," ).append("\n"); 
		query.append("A.UPD_DT      = sysdate" ).append("\n"); 
		query.append("--CSRNO : R200806027055의거변경" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append(",TRSP_MOD_CD" ).append("\n"); 
		query.append(",VSL_LANE_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",FM_ECC_CD" ).append("\n"); 
		query.append(",FM_ETD_DT" ).append("\n"); 
		query.append(",FM_YD_CD" ).append("\n"); 
		query.append(",TO_ECC_CD" ).append("\n"); 
		query.append(",TO_ETB_DT" ).append("\n"); 
		query.append(",TO_YD_CD" ).append("\n"); 
		query.append(",PAST_REPO_PLN_FLG" ).append("\n"); 
		query.append(",PRE_PLN_TS_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(@[repo_pln_id]" ).append("\n"); 
		query.append(",@[pln_yrwk]" ).append("\n"); 
		query.append(",@[pln_seq1]" ).append("\n"); 
		query.append(",'V'" ).append("\n"); 
		query.append(",@[vsl_lane_cd]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[fm_ecc_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[fm_etd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[fm_yard]" ).append("\n"); 
		query.append(",@[to_ecc_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[to_eta_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[to_yard]" ).append("\n"); 
		query.append(",@[past_repo_pln_flg]" ).append("\n"); 
		query.append(",@[pre_pln_ts_flg]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}