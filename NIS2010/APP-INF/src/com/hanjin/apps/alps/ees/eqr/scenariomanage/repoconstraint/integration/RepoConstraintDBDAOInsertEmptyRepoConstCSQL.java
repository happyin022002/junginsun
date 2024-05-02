/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintDBDAOInsertEmptyRepoConstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.17 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoConstraintDBDAOInsertEmptyRepoConstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_repo_cnst 테이블 데이터 입력
	  * </pre>
	  */
	public RepoConstraintDBDAOInsertEmptyRepoConstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnstSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_cnst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tokens",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_cnst_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ruleCode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rule_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration ").append("\n"); 
		query.append("FileName : RepoConstraintDBDAOInsertEmptyRepoConstCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_SCNR_REPO_CNST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SCNR_ID       	   ," ).append("\n"); 
		query.append("CNST_RULE_ID       ," ).append("\n"); 
		query.append("REPO_CNST_TP_CD    ," ).append("\n"); 
		query.append("FM_LOC_GRP_CD      ," ).append("\n"); 
		query.append("FM_LOC_CD          ," ).append("\n"); 
		query.append("TO_LOC_GRP_CD      ," ).append("\n"); 
		query.append("TO_LOC_CD          ," ).append("\n"); 
		query.append("EQ_TRSP_MOD_CD     ," ).append("\n"); 
		query.append("CNST_CNTR_TPSZ_CD  ," ).append("\n"); 
		query.append("REPO_CNST_SEQ      ," ).append("\n"); 
		query.append("REPO_CNST_DIR_CD   ," ).append("\n"); 
		query.append("RULE_EXPT_FLG      ," ).append("\n"); 
		query.append("CRE_USR_ID         ," ).append("\n"); 
		query.append("CRE_DT             ," ).append("\n"); 
		query.append("UPD_USR_ID         ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[scnr_id]" ).append("\n"); 
		query.append(", @[ruleCode]" ).append("\n"); 
		query.append(", @[repo_cnst_tp_cd]" ).append("\n"); 
		query.append(", @[fm_loc_grp_cd]" ).append("\n"); 
		query.append(", @[fm_loc_cd]" ).append("\n"); 
		query.append(", @[to_loc_grp_cd]" ).append("\n"); 
		query.append(", @[to_loc_cd]" ).append("\n"); 
		query.append(", @[eq_trsp_mod_cd]" ).append("\n"); 
		query.append(", @[tokens]" ).append("\n"); 
		query.append(", @[cnstSeq]" ).append("\n"); 
		query.append(", @[repo_cnst_dir_cd]" ).append("\n"); 
		query.append(", @[rule_expt_flg]" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[user_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}