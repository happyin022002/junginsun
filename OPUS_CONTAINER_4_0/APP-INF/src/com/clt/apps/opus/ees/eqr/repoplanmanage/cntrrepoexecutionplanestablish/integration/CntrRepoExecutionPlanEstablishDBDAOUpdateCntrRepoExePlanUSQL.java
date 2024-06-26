/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOUpdateCntrRepoExePlanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOUpdateCntrRepoExePlanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repo Exe Plan Update
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOUpdateCntrRepoExePlanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_repo_purp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("repo_pln_fb_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOUpdateCntrRepoExePlanUSQL").append("\n"); 
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
		query.append("UPDATE EQR_REPO_EXE_PLN SET " ).append("\n"); 
		query.append("    FM_ETD_DT    	   = TO_DATE(@[fm_etd_dt], 'YYYYMMDD'),        " ).append("\n"); 
		query.append("    TO_ETA_DT     	   = TO_DATE(@[to_eta_dt], 'YYYYMMDD'),        " ).append("\n"); 
		query.append("    EQ_REPO_PURP_CD    = @[eq_repo_purp_cd],                             " ).append("\n"); 
		query.append("    REPO_PLN_FB_RSN_CD = @[repo_pln_fb_rsn_cd],                             " ).append("\n"); 
		query.append("    REPO_PLN_FB_RMK    = @[repo_pln_fb_rmk],  " ).append("\n"); 
		query.append("	FM_YD_CD		    = @[fm_yd_cd], " ).append("\n"); 
		query.append("	TO_YD_CD		    = @[to_yd_cd],  " ).append("\n"); 
		query.append("	VSL_CD				= @[vsl_cd]," ).append("\n"); 
		query.append("	SKD_VOY_NO			= @[skd_voy_no]," ).append("\n"); 
		query.append("	SKD_DIR_CD			= @[skd_dir_cd],      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${soFlag} == 'Y')   -- so send 버튼 클릭시 작동" ).append("\n"); 
		query.append("--	    EXE_RQST_DT    = SYSDATE,  -- EQR_INLND_TRSP_EXE_PLN_QTY 테이블에 모든 CNTR_TPSZ_CD 에 대해서 업데이트 를 미리 실행함" ).append("\n"); 
		query.append("								   -- CntrRepoExecutionPlanEstablishDBDAOMergeInlandExecuteCSQL     참고 09.08.28 By ChungEunHo       " ).append("\n"); 
		query.append("	    EXE_ISS_FLG    = @[exe_iss_flg],                         " ).append("\n"); 
		query.append("--	    MTY FLG        =  ,                         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("	    UPD_USR_ID         = @[user_id] ,                             " ).append("\n"); 
		query.append("	    UPD_DT             = SYSDATE                        " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	REPO_PLN_ID 	= @[repo_pln_id]                                   " ).append("\n"); 
		query.append("	AND   PLN_YRWK  = @[pln_yrwk]                                  " ).append("\n"); 
		query.append("	AND   PLN_SEQ   = @[pln_seq]                                   " ).append("\n"); 
		query.append("	AND   REF_ID	= @[ref_id]" ).append("\n"); 

	}
}