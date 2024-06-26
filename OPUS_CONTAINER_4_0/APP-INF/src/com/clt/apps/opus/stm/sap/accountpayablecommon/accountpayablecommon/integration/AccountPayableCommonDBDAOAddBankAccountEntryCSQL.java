/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOAddBankAccountEntryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOAddBankAccountEntryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableCommonDBDAOAddBankAccountEntryCSQL
	  * </pre>
	  */
	public AccountPayableCommonDBDAOAddBankAccountEntryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_tit_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dps_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_acct_altn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_tp_mn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inact_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_curr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_tp_sub_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gain_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_brnc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lss_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOAddBankAccountEntryCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_BANK_ACCT(" ).append("\n"); 
		query.append("    BANK_ACCT_SEQ," ).append("\n"); 
		query.append("    BANK_ACCT_NM," ).append("\n"); 
		query.append("    BANK_ACCT_NO," ).append("\n"); 
		query.append("    BANK_BRNC_SEQ," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    CNTC_NM," ).append("\n"); 
		query.append("    CNTC_TIT_NM," ).append("\n"); 
		query.append("    CNTC_AREA_CD," ).append("\n"); 
		query.append("    CNTC_PHN_NO," ).append("\n"); 
		query.append("    INACT_DT," ).append("\n"); 
		query.append("    BANK_ACCT_TP_NM," ).append("\n"); 
		query.append("    MLT_CURR_FLG," ).append("\n"); 
		query.append("    ACCT_TP_CD," ).append("\n"); 
		query.append("    ATTR_CTNT1," ).append("\n"); 
		query.append("    ATTR_CTNT2," ).append("\n"); 
		query.append("    BANK_ACCT_ALTN_NM," ).append("\n"); 
		query.append("    BANK_ACCT_TP_MN_CD," ).append("\n"); 
		query.append("    BANK_ACCT_TP_SUB_CD," ).append("\n"); 
		query.append("    ASET_CD_CMB_SEQ," ).append("\n"); 
		query.append("    CHG_CD_CMB_SEQ," ).append("\n"); 
		query.append("    GAIN_CD_CMB_SEQ," ).append("\n"); 
		query.append("    LSS_CD_CMB_SEQ," ).append("\n"); 
		query.append("    BANK_ACCT_DESC," ).append("\n"); 
		query.append("    BANK_ACCT_ST_DT," ).append("\n"); 
		query.append("    OPN_OFC_CD," ).append("\n"); 
		query.append("    AP_CTRL_OFC_CD," ).append("\n"); 
		query.append("    AR_OFC_CD," ).append("\n"); 
		query.append("    DPS_DIV_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("    @[bank_acct_seq]," ).append("\n"); 
		query.append("    @[bank_acct_nm]," ).append("\n"); 
		query.append("    @[bank_acct_no]," ).append("\n"); 
		query.append("    @[bank_brnc_seq]," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    @[cntc_nm]," ).append("\n"); 
		query.append("    @[cntc_tit_nm]," ).append("\n"); 
		query.append("    @[cntc_area_cd]," ).append("\n"); 
		query.append("    @[cntc_phn_no]," ).append("\n"); 
		query.append("    TO_DATE( REPLACE(@[inact_dt],'-',''), 'YYYYMMDD') ," ).append("\n"); 
		query.append("    @[bank_acct_tp_nm]," ).append("\n"); 
		query.append("    @[mlt_curr_flg]," ).append("\n"); 
		query.append("    @[acct_tp_cd]," ).append("\n"); 
		query.append("    DECODE(@[attr_ctnt1],'Y','OFF',NULL)," ).append("\n"); 
		query.append("    @[attr_ctnt2]," ).append("\n"); 
		query.append("    @[bank_acct_altn_nm]," ).append("\n"); 
		query.append("    @[bank_acct_tp_mn_cd]," ).append("\n"); 
		query.append("    @[bank_acct_tp_sub_cd]," ).append("\n"); 
		query.append("    @[aset_cd_cmb_seq]," ).append("\n"); 
		query.append("    @[chg_cd_cmb_seq]," ).append("\n"); 
		query.append("    @[gain_cd_cmb_seq]," ).append("\n"); 
		query.append("    @[lss_cd_cmb_seq]," ).append("\n"); 
		query.append("    @[bank_acct_desc]," ).append("\n"); 
		query.append("    TO_DATE( REPLACE(@[bank_acct_st_dt],'-',''), 'YYYYMMDD') ," ).append("\n"); 
		query.append("    @[opn_ofc_cd]," ).append("\n"); 
		query.append("    @[ap_ctrl_ofc_cd]," ).append("\n"); 
		query.append("    @[ar_ofc_cd]," ).append("\n"); 
		query.append("    @[dps_div_cd]," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}