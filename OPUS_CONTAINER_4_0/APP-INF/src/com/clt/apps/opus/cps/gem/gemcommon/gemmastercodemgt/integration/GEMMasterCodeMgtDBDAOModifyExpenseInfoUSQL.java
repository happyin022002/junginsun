/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOModifyExpenseInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.08 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtDBDAOModifyExpenseInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반관리비 비용코드 기준 정보 수정
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOModifyExpenseInfoUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_sls_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("krn_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("krn_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eng_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_acct_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_agre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_grp_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("saly_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update gem_expense set" ).append("\n"); 
		query.append("gen_expn_cd = @[gen_expn_cd]," ).append("\n"); 
		query.append("gen_expn_agre_flg = @[gen_expn_agre_flg]," ).append("\n"); 
		query.append("eng_abbr_nm = @[eng_abbr_nm]," ).append("\n"); 
		query.append("eng_full_nm = @[eng_full_nm]," ).append("\n"); 
		query.append("krn_abbr_nm = @[krn_abbr_nm]," ).append("\n"); 
		query.append("krn_full_nm = @[krn_full_nm]," ).append("\n"); 
		query.append("gen_expn_acct_expt_flg = @[gen_expn_acct_expt_flg]," ).append("\n"); 
		query.append("saly_flg = @[saly_flg]," ).append("\n"); 
		query.append("gen_expn_sls_div_cd = @[gen_expn_sls_div_cd]," ).append("\n"); 
		query.append("gen_expn_grp_lvl = @[gen_expn_grp_lvl]," ).append("\n"); 
		query.append("prnt_gen_expn_cd = @[prnt_gen_expn_cd]," ).append("\n"); 
		query.append("tic_cd = @[tic_cd]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("delt_flg = @[delt_flg]," ).append("\n"); 
		query.append("upd_dt = sysdate" ).append("\n"); 
		query.append("where	gen_expn_cd = @[gen_expn_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOModifyExpenseInfoUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}