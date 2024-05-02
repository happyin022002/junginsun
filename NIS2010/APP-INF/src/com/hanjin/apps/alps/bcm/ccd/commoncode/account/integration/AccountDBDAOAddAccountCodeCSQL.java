/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AccountDBDAOAddAccountCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOAddAccountCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.19 조인영 Account Code 정보를 저장한다.
	  * </pre>
	  */
	public AccountDBDAOAddAccountCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_curr_xch_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl_flg1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl_flg2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl_flg3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl_flg4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl_flg5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_lvl_flg6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_mng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("entr_expn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jnl_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bud_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnd_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bud_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOAddAccountCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_ACCOUNT (" ).append("\n"); 
		query.append("       ACCT_CD" ).append("\n"); 
		query.append("       ,ACCT_ENG_NM" ).append("\n"); 
		query.append("       ,ACCT_LOCL_NM" ).append("\n"); 
		query.append("       ,BUD_IF_FLG" ).append("\n"); 
		query.append("       ,BUD_USE_FLG" ).append("\n"); 
		query.append("       ,JNL_CRE_FLG" ).append("\n"); 
		query.append("       ,ACCTG_MNG_TP_CD" ).append("\n"); 
		query.append("       ,PND_TGT_FLG" ).append("\n"); 
		query.append("       ,ESTM_TGT_FLG" ).append("\n"); 
		query.append("       ,VVD_LVL_FLG1" ).append("\n"); 
		query.append("       ,VVD_LVL_FLG2" ).append("\n"); 
		query.append("       ,VVD_LVL_FLG3" ).append("\n"); 
		query.append("       ,VVD_LVL_FLG4" ).append("\n"); 
		query.append("       ,VVD_LVL_FLG5" ).append("\n"); 
		query.append("       ,VVD_LVL_FLG6" ).append("\n"); 
		query.append("       ,AUTO_CURR_XCH_RT_FLG" ).append("\n"); 
		query.append("       ,ENTR_EXPN_FLG" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,EAI_EVNT_DT" ).append("\n"); 
		query.append("       ,EAI_IF_ID" ).append("\n"); 
		query.append("       ,MODI_ACCT_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("       @[acct_cd]" ).append("\n"); 
		query.append("       ,@[acct_eng_nm]" ).append("\n"); 
		query.append("       ,@[acct_locl_nm]" ).append("\n"); 
		query.append("       ,@[bud_if_flg]" ).append("\n"); 
		query.append("       ,@[bud_use_flg]" ).append("\n"); 
		query.append("       ,@[jnl_cre_flg]" ).append("\n"); 
		query.append("       ,@[acctg_mng_tp_cd]" ).append("\n"); 
		query.append("       ,@[pnd_tgt_flg]" ).append("\n"); 
		query.append("       ,@[estm_tgt_flg]" ).append("\n"); 
		query.append("       ,@[vvd_lvl_flg1]" ).append("\n"); 
		query.append("       ,@[vvd_lvl_flg2]" ).append("\n"); 
		query.append("       ,@[vvd_lvl_flg3]" ).append("\n"); 
		query.append("       ,@[vvd_lvl_flg4]" ).append("\n"); 
		query.append("       ,@[vvd_lvl_flg5]" ).append("\n"); 
		query.append("       ,@[vvd_lvl_flg6]" ).append("\n"); 
		query.append("       ,@[auto_curr_xch_rt_flg]" ).append("\n"); 
		query.append("       ,@[entr_expn_flg]" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[delt_flg]" ).append("\n"); 
		query.append("       ,@[eai_evnt_dt]" ).append("\n"); 
		query.append("       ,@[eai_if_id]" ).append("\n"); 
		query.append("       ,@[modi_acct_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}