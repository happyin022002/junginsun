/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtVesselCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtVesselCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0052 최적화된 REPO InOut 계획 수량 조회/수정>
	  * EQR_VSL_LODG_DCHG_PLN 테이블에 VOL, AMOUNT 정보 수정 혹은 입력
	  * 
	  * <Change History>
	  * 1	2009.08.27	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtVesselCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldis_ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtVesselCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_VSL_LODG_DCHG_PLN I" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[repo_pln_id] AS REPO_PLN_ID" ).append("\n"); 
		query.append(",@[pln_yrwk] AS PLN_YRWK" ).append("\n"); 
		query.append(",@[pln_seq] AS PLN_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.REPO_PLN_ID   	= M.REPO_PLN_ID" ).append("\n"); 
		query.append("AND I.PLN_YRWK      = M.PLN_YRWK" ).append("\n"); 
		query.append("AND I.PLN_SEQ       = M.PLN_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("I.REPO_PLN_ID" ).append("\n"); 
		query.append(",I.PLN_YRWK" ).append("\n"); 
		query.append(",I.PLN_SEQ" ).append("\n"); 
		query.append(",I.VSL_LANE_CD" ).append("\n"); 
		query.append(",I.VSL_CD" ).append("\n"); 
		query.append(",I.SKD_VOY_NO" ).append("\n"); 
		query.append(",I.SKD_DIR_CD" ).append("\n"); 
		query.append(",I.FM_ECC_CD" ).append("\n"); 
		query.append(",I.FM_ETD_DT" ).append("\n"); 
		query.append(",I.TO_ECC_CD" ).append("\n"); 
		query.append(",I.TO_ETB_DT" ).append("\n"); 
		query.append(",I.TRSP_MOD_CD" ).append("\n"); 
		query.append(",I.CRE_USR_ID" ).append("\n"); 
		query.append(",I.CRE_DT" ).append("\n"); 
		query.append(",I.UPD_USR_ID" ).append("\n"); 
		query.append(",I.UPD_DT" ).append("\n"); 
		query.append(",I.LDIS_TS_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[repo_pln_id]" ).append("\n"); 
		query.append(", @[pln_yrwk]" ).append("\n"); 
		query.append(", @[pln_seq]" ).append("\n"); 
		query.append(", @[vsl_lane_cd]" ).append("\n"); 
		query.append(", @[vsl_cd]" ).append("\n"); 
		query.append(", @[skd_voy_no]" ).append("\n"); 
		query.append(", @[skd_dir_cd]" ).append("\n"); 
		query.append(", @[fm_ecc_cd]" ).append("\n"); 
		query.append(", TO_DATE(@[fm_etd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(", @[to_ecc_cd]" ).append("\n"); 
		query.append(", TO_DATE(@[to_etb_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(", @[trsp_mod_cd]" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[ldis_ts_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}