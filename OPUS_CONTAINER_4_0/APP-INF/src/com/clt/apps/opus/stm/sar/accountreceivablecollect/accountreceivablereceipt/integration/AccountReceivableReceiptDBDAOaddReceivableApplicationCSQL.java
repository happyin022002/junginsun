/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOaddReceivableApplicationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOaddReceivableApplicationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Application 정보 생성
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOaddReceivableApplicationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_appl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_aply_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_to_acct_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wrtf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_fm_rcv_appl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_cxl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dps_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_to_rct_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_term_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_fm_acct_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvs_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("legr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_appl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_appl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_fm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_appl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_xch_rt_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOaddReceivableApplicationCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_RCV_APPL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	RCV_APPL_SEQ" ).append("\n"); 
		query.append("	, APLY_AMT" ).append("\n"); 
		query.append("	, APLY_FM_AMT" ).append("\n"); 
		query.append("	, OTS_TO_RCT_XCH_RT" ).append("\n"); 
		query.append("	, GL_DT" ).append("\n"); 
		query.append("	, RCV_CD_CMB_SEQ" ).append("\n"); 
		query.append("	, LEGR_SEQ" ).append("\n"); 
		query.append("	, DP_FLG" ).append("\n"); 
		query.append("	, RCT_DT" ).append("\n"); 
		query.append("	, RCV_APPL_TP_CD" ).append("\n"); 
		query.append("	, RCV_APPL_STS_CD" ).append("\n"); 
		query.append("	, RCT_SEQ" ).append("\n"); 
		query.append("	, WRTF_TP_CD" ).append("\n"); 
		query.append("	, GL_TRNS_SEQ" ).append("\n"); 
		query.append("	, GL_TRNS_DT" ).append("\n"); 
		query.append("	, APLY_FM_ACCT_AMT" ).append("\n"); 
		query.append("	, APLY_TO_ACCT_AMT" ).append("\n"); 
		query.append("	, ORZ_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, OTS_HIS_SEQ" ).append("\n"); 
		query.append("	, CHG_TP_CD" ).append("\n"); 
		query.append("	, RCT_DPS_DT" ).append("\n"); 
		query.append("	, RCT_APLY_DTL_SEQ" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("	, ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("	, CONV_XCH_RT" ).append("\n"); 
		query.append("	, RCT_CXL_DT" ).append("\n"); 
		query.append("	, APLY_FM_RCV_APPL_SEQ" ).append("\n"); 
		query.append("	, RCT_TERM_DYS" ).append("\n"); 
		query.append("	, RVS_GL_DT" ).append("\n"); 
		query.append("	, RCV_APPL_RMK" ).append("\n"); 
		query.append("	, AP_RMK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[rcv_appl_seq]" ).append("\n"); 
		query.append("	, @[aply_amt]" ).append("\n"); 
		query.append("	, @[aply_fm_amt]" ).append("\n"); 
		query.append("	, @[ots_to_rct_xch_rt]" ).append("\n"); 
		query.append("	, @[gl_dt]" ).append("\n"); 
		query.append("	, @[rcv_cd_cmb_seq]" ).append("\n"); 
		query.append("	, @[legr_seq]" ).append("\n"); 
		query.append("	, @[dp_flg]" ).append("\n"); 
		query.append("	, @[rct_dt]" ).append("\n"); 
		query.append("	, @[rcv_appl_tp_cd]" ).append("\n"); 
		query.append("	, @[rcv_appl_sts_cd]" ).append("\n"); 
		query.append("	, @[rct_seq]" ).append("\n"); 
		query.append("	, @[wrtf_tp_cd]" ).append("\n"); 
		query.append("	, @[gl_trns_seq]" ).append("\n"); 
		query.append("	, @[gl_trns_dt]" ).append("\n"); 
		query.append("	, @[aply_fm_acct_amt]" ).append("\n"); 
		query.append("	, @[aply_to_acct_amt]" ).append("\n"); 
		query.append("	, @[orz_seq]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[ots_his_seq]" ).append("\n"); 
		query.append("	, @[chg_tp_cd]" ).append("\n"); 
		query.append("	, @[rct_dps_dt]" ).append("\n"); 
		query.append("	, @[rct_aply_dtl_seq]" ).append("\n"); 
		query.append("	, @[acct_xch_rt_lvl]" ).append("\n"); 
		query.append("	, @[acct_xch_rt_dt]" ).append("\n"); 
		query.append("	, @[conv_xch_rt]" ).append("\n"); 
		query.append("	, @[rct_cxl_dt]" ).append("\n"); 
		query.append("	, @[aply_fm_rcv_appl_seq]" ).append("\n"); 
		query.append("	, @[rct_term_dys]" ).append("\n"); 
		query.append("	, @[rvs_gl_dt]" ).append("\n"); 
		query.append("	, @[rcv_appl_rmk]" ).append("\n"); 
		query.append("	, @[ap_rmk]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}