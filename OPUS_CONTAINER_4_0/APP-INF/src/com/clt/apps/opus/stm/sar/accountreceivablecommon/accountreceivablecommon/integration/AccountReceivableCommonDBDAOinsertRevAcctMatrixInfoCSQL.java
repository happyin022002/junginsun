/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOinsertRevAcctMatrixInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOinsertRevAcctMatrixInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Account Matrix Insert
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOinsertRevAcctMatrixInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("legr_xch_diff_lss_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_acct_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_st_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_curr_xch_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amt_sgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_chg_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("legr_xch_diff_incm_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOinsertRevAcctMatrixInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_ACCT_MTX" ).append("\n"); 
		query.append("( ACCT_CTNT1" ).append("\n"); 
		query.append(" ,ACCT_CTNT2" ).append("\n"); 
		query.append(" ,ACCT_CTNT3" ).append("\n"); 
		query.append(" ,ACCT_CTNT4" ).append("\n"); 
		query.append(" ,ACCT_CTNT5" ).append("\n"); 
		query.append(" ,ACCT_CTNT6" ).append("\n"); 
		query.append(" ,ACCT_CTNT7" ).append("\n"); 
		query.append(" ,ACCT_CTNT8" ).append("\n"); 
		query.append(" ,ACCT_MTX_SEQ" ).append("\n"); 
		query.append(" ,ACCT_TP_CD" ).append("\n"); 
		query.append(" ,ACCT_TP_NM" ).append("\n"); 
		query.append(" ,AMT_SGN_CD" ).append("\n"); 
		query.append(" ,AR_ACCT_CD" ).append("\n"); 
		query.append(" ,BANK_CHG_ACCT_CD" ).append("\n"); 
		query.append(" ,CLR_ACCT_CD" ).append("\n"); 
		query.append(" ,LEGR_XCH_DIFF_INCM_ACCT_CD" ).append("\n"); 
		query.append(" ,LEGR_XCH_DIFF_LSS_ACCT_CD" ).append("\n"); 
		query.append(" ,PAY_ACCT_CD" ).append("\n"); 
		query.append(" ,PAY_CURR_XCH_ACCT_CD" ).append("\n"); 
		query.append(" ,REP_CHG_CD" ).append("\n"); 
		query.append(" ,REV_ACCT_DIV_CD" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,ACCT_ST_DT" ).append("\n"); 
		query.append(" ,ACCT_END_DT" ).append("\n"); 
		query.append(" ,DELT_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(  @[acct_ctnt1]" ).append("\n"); 
		query.append("  ,@[acct_ctnt2]" ).append("\n"); 
		query.append("  ,@[acct_ctnt3]" ).append("\n"); 
		query.append("  ,@[acct_ctnt4]" ).append("\n"); 
		query.append("  ,@[acct_ctnt5]" ).append("\n"); 
		query.append("  ,@[acct_ctnt6]" ).append("\n"); 
		query.append("  ,@[acct_ctnt7]" ).append("\n"); 
		query.append("  ,@[acct_ctnt8]" ).append("\n"); 
		query.append("  ,(SELECT NVL(MAX(ACCT_MTX_SEQ), 0) + 1 FROM SAR_ACCT_MTX)" ).append("\n"); 
		query.append("  ,@[acct_tp_cd]" ).append("\n"); 
		query.append("  ,@[acct_tp_nm]" ).append("\n"); 
		query.append("  ,@[amt_sgn_cd]" ).append("\n"); 
		query.append("  ,@[ar_acct_cd]" ).append("\n"); 
		query.append("  ,@[bank_chg_acct_cd]" ).append("\n"); 
		query.append("  ,@[clr_acct_cd]" ).append("\n"); 
		query.append("  ,@[legr_xch_diff_incm_acct_cd]" ).append("\n"); 
		query.append("  ,@[legr_xch_diff_lss_acct_cd]" ).append("\n"); 
		query.append("  ,@[pay_acct_cd]" ).append("\n"); 
		query.append("  ,@[pay_curr_xch_acct_cd]" ).append("\n"); 
		query.append("  ,@[rep_chg_cd]" ).append("\n"); 
		query.append("  ,@[rev_acct_div_cd]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[upd_usr_id]" ).append("\n"); 
		query.append("  ,@[acct_st_dt]" ).append("\n"); 
		query.append("  ,@[acct_end_dt]" ).append("\n"); 
		query.append("  ,'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}