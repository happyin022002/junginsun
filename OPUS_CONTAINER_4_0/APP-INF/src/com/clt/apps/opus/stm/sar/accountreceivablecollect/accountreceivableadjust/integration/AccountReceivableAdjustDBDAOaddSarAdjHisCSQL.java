/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOaddSarAdjHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOaddSarAdjHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert SAR_ADJ_HIS table
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOaddSarAdjHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_crs_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_crs_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_crs_ex_rate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_evnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_crs_curr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_trns_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_aply_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_crs_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_key_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_mtx_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orz_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_acct_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOaddSarAdjHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_ADJ_HIS ( " ).append("\n"); 
		query.append("                  ADJ_HIS_SEQ" ).append("\n"); 
		query.append("                , ADJ_NO" ).append("\n"); 
		query.append("                , ADJ_STS_CD" ).append("\n"); 
		query.append("                , ADJ_AMT" ).append("\n"); 
		query.append("                , ADJ_APLY_DT" ).append("\n"); 
		query.append("                , ADJ_GL_DT" ).append("\n"); 
		query.append("                , ADJ_CD_CMB_SEQ" ).append("\n"); 
		query.append("                , CHG_TP_CD" ).append("\n"); 
		query.append("                , ADJ_TP_CD" ).append("\n"); 
		query.append("                , ADJ_RMK" ).append("\n"); 
		query.append("                , GL_TRNS_SEQ" ).append("\n"); 
		query.append("                , GL_TRNS_DT" ).append("\n"); 
		query.append("                , ADJ_ACCT_AMT" ).append("\n"); 
		query.append("                , ORZ_SEQ" ).append("\n"); 
		query.append("                , ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , CRE_DT" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("                , OTS_HIS_SEQ" ).append("\n"); 
		query.append("                , ACCT_MTX_SEQ" ).append("\n"); 
		query.append("                , ADJ_KEY_NO" ).append("\n"); 
		query.append("				, AP_RMK" ).append("\n"); 
		query.append("                , ADJ_OFC_CD" ).append("\n"); 
		query.append("			    , ADJ_CRS_CURR_AMT" ).append("\n"); 
		query.append("			    , ADJ_CRS_CURR_CD" ).append("\n"); 
		query.append(" 				, GL_CRS_CURR_AMT" ).append("\n"); 
		query.append("			    , GL_CRS_CURR_CD" ).append("\n"); 
		query.append("				, GL_CRS_EX_RATE " ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("                  @[adj_his_seq]" ).append("\n"); 
		query.append("                , @[adj_no]" ).append("\n"); 
		query.append("                , @[adj_sts_cd]" ).append("\n"); 
		query.append("                , @[adj_amt]" ).append("\n"); 
		query.append("                , @[adj_aply_dt]" ).append("\n"); 
		query.append("                , @[adj_gl_dt]" ).append("\n"); 
		query.append("                , @[adj_cd_cmb_seq]" ).append("\n"); 
		query.append("                , @[chg_tp_cd]" ).append("\n"); 
		query.append("                , @[adj_tp_cd]" ).append("\n"); 
		query.append("                , @[adj_rmk]" ).append("\n"); 
		query.append("                , @[gl_trns_seq]" ).append("\n"); 
		query.append("                , @[gl_trns_dt]" ).append("\n"); 
		query.append("                , @[adj_acct_amt]" ).append("\n"); 
		query.append("                , @[orz_seq]" ).append("\n"); 
		query.append("                , @[acctg_evnt_seq]" ).append("\n"); 
		query.append("                , @[cre_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[upd_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[ots_his_seq]" ).append("\n"); 
		query.append("                , @[acct_mtx_seq]" ).append("\n"); 
		query.append("                , @[adj_key_no]" ).append("\n"); 
		query.append("				, @[ap_rmk]" ).append("\n"); 
		query.append("                , @[adj_ofc_cd]" ).append("\n"); 
		query.append("				, @[adj_crs_curr_amt]" ).append("\n"); 
		query.append("				, @[adj_crs_curr_cd]" ).append("\n"); 
		query.append("				, (SELECT ROUND(@[gl_crs_curr_amt],DP_PRCS_KNT) * -1 FROM MDM_CURRENCY WHERE CURR_CD = @[gl_crs_curr_cd])" ).append("\n"); 
		query.append("				, @[gl_crs_curr_cd]" ).append("\n"); 
		query.append("				, @[gl_crs_ex_rate] " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}