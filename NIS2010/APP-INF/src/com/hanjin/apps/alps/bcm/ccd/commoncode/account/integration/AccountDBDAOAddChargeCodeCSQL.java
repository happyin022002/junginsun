/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AccountDBDAOAddChargeCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.18 
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

public class AccountDBDAOAddChargeCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 데이터 저장
	  * </pre>
	  */
	public AccountDBDAOAddChargeCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_svc_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cy_rd_term_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("na_rd_term_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tkl_tml_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfs_rd_term_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("use_co_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_aply_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdt_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_chg_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_rd_term_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOAddChargeCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CHARGE (" ).append("\n"); 
		query.append(" 		CHG_CD" ).append("\n"); 
		query.append("       ,CHG_NM" ).append("\n"); 
		query.append("       ,FRT_CHG_TP_CD" ).append("\n"); 
		query.append("       ,HJS_CHG_ACCT_CD" ).append("\n"); 
		query.append("       ,REP_CHG_CD" ).append("\n"); 
		query.append("       ,CHG_REV_TP_CD" ).append("\n"); 
		query.append("       ,CHG_APLY_TP_CD" ).append("\n"); 
		query.append("       ,CHG_APLY_AREA_CD" ).append("\n"); 
		query.append("       ,CY_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,CFS_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,DOR_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,NA_RD_TERM_FLG" ).append("\n"); 
		query.append("       ,TKL_TML_FLG" ).append("\n"); 
		query.append("       ,APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("       ,USE_CO_TP_CD" ).append("\n"); 
		query.append("       ,AUTO_RAT_FLG" ).append("\n"); 
		query.append("       ,CHG_EDI_CD" ).append("\n"); 
		query.append("       ,DP_SEQ" ).append("\n"); 
		query.append("       ,CHG_STS_CD" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,mdt_rat_flg" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("       @[chg_cd]" ).append("\n"); 
		query.append("       ,@[chg_nm]" ).append("\n"); 
		query.append("       ,@[frt_chg_tp_cd]" ).append("\n"); 
		query.append("       ,@[hjs_chg_acct_cd]" ).append("\n"); 
		query.append("       ,@[rep_chg_cd]" ).append("\n"); 
		query.append("       ,@[chg_rev_tp_cd]" ).append("\n"); 
		query.append("       ,@[chg_aply_tp_cd]" ).append("\n"); 
		query.append("       ,@[chg_aply_area_cd]" ).append("\n"); 
		query.append("       ,@[cy_rd_term_flg]" ).append("\n"); 
		query.append("       ,@[cfs_rd_term_flg]" ).append("\n"); 
		query.append("       ,@[dor_rd_term_flg]" ).append("\n"); 
		query.append("       ,@[na_rd_term_flg]" ).append("\n"); 
		query.append("       ,@[tkl_tml_flg]" ).append("\n"); 
		query.append("       ,@[aply_svc_mod_flg]" ).append("\n"); 
		query.append("       ,@[use_co_tp_cd]" ).append("\n"); 
		query.append("       ,@[auto_rat_flg]" ).append("\n"); 
		query.append("       ,@[chg_edi_cd]" ).append("\n"); 
		query.append("       ,@[dp_seq]" ).append("\n"); 
		query.append("       ,@[chg_sts_cd]" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[delt_flg]" ).append("\n"); 
		query.append("       ,@[mdt_rat_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}