/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOAddCrCustCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOAddCrCustCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Credit Customer Code를 생성한다
	  * </pre>
	  */
	public PartnerDBDAOAddCrCustCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cr_due_dt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzct_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_curr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dy_xch_aply_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cr_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_clt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_indiv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_dy3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("riss_inv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rlse_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ib_cr_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddCrCustCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CR_CUST(" ).append("\n"); 
		query.append("   CUST_CNT_CD" ).append("\n"); 
		query.append(",  CUST_SEQ" ).append("\n"); 
		query.append(",  CR_CLT_OFC_CD" ).append("\n"); 
		query.append(",  CR_CURR_CD" ).append("\n"); 
		query.append(",  OB_CR_TERM_DYS" ).append("\n"); 
		query.append(",  IB_CR_TERM_DYS" ).append("\n"); 
		query.append(",  CR_AMT" ).append("\n"); 
		query.append(",  RISS_INV_FLG" ).append("\n"); 
		query.append(",  CR_ST_DT" ).append("\n"); 
		query.append(",  CR_END_DT" ).append("\n"); 
		query.append(",  CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append(",  CR_FLG" ).append("\n"); 
		query.append(",  XCH_RT_DIV_CD" ).append("\n"); 
		query.append(",  CNG_INDIV_CD" ).append("\n"); 
		query.append(",  DY_XCH_APLY_ST_DT" ).append("\n"); 
		query.append(",  ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",  ACT_CUST_SEQ" ).append("\n"); 
		query.append(",  CNTC_PSON_NM" ).append("\n"); 
		query.append(",  INV_ISS_CURR_TP_CD" ).append("\n"); 
		query.append(",  PAY_DT_DY1" ).append("\n"); 
		query.append(",  PAY_DT_DY2" ).append("\n"); 
		query.append(",  PAY_DT_DY3" ).append("\n"); 
		query.append(",  PAY_DT_DY4" ).append("\n"); 
		query.append(",  PAY_DIV_CD" ).append("\n"); 
		query.append(",  BANK_ACCT_NO" ).append("\n"); 
		query.append(",  CR_CUST_RMK" ).append("\n"); 
		query.append(",  LOCL_NM" ).append("\n"); 
		query.append(",  LOCL_ZIP_CD" ).append("\n"); 
		query.append(",  LOCL_ADDR1" ).append("\n"); 
		query.append(",  LOCL_ADDR2" ).append("\n"); 
		query.append(",  LOCL_ADDR3" ).append("\n"); 
		query.append(",  LOCL_ADDR4" ).append("\n"); 
		query.append(",  OWNR_NM" ).append("\n"); 
		query.append(",  BZCT_NM" ).append("\n"); 
		query.append(",  BZTP_NM" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  OB_EML" ).append("\n"); 
		query.append(",  IB_EML" ).append("\n"); 
		query.append(",  OB_FAX_NO" ).append("\n"); 
		query.append(",  IB_FAX_NO" ).append("\n"); 
		query.append(",  CUST_CR_DUE_DT_DIV_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")VALUES (" ).append("\n"); 
		query.append("	@[cust_cnt_cd]" ).append("\n"); 
		query.append(",	@[cust_seq]" ).append("\n"); 
		query.append(",   @[cr_clt_ofc_cd]" ).append("\n"); 
		query.append(",   @[cr_curr_cd]" ).append("\n"); 
		query.append(",   @[ob_cr_term_dys]" ).append("\n"); 
		query.append(",   @[ib_cr_term_dys]" ).append("\n"); 
		query.append(",   @[cr_amt]" ).append("\n"); 
		query.append(",   @[riss_inv_flg]" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(@[cr_st_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(@[cr_end_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append(",   @[cust_rlse_ctrl_flg]" ).append("\n"); 
		query.append(",   @[cr_flg]" ).append("\n"); 
		query.append(",   @[xch_rt_div_cd]" ).append("\n"); 
		query.append(",   @[cng_indiv_cd]" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(@[dy_xch_aply_st_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append(",   @[act_cust_cnt_cd]" ).append("\n"); 
		query.append(",   @[act_cust_seq]" ).append("\n"); 
		query.append(",   @[cntc_pson_nm]" ).append("\n"); 
		query.append(",   @[inv_iss_curr_tp_cd]" ).append("\n"); 
		query.append(",   @[pay_dt_dy1]" ).append("\n"); 
		query.append(",   @[pay_dt_dy2]" ).append("\n"); 
		query.append(",   @[pay_dt_dy3]" ).append("\n"); 
		query.append(",   @[pay_dt_dy4]" ).append("\n"); 
		query.append(",   @[pay_div_cd]" ).append("\n"); 
		query.append(",   @[bank_acct_no]" ).append("\n"); 
		query.append(",   @[cr_cust_rmk]" ).append("\n"); 
		query.append(",   @[locl_nm]" ).append("\n"); 
		query.append(",   @[locl_zip_cd]" ).append("\n"); 
		query.append(",   @[locl_addr1]" ).append("\n"); 
		query.append(",   @[locl_addr2]" ).append("\n"); 
		query.append(",   @[locl_addr3]" ).append("\n"); 
		query.append(",   @[locl_addr4]" ).append("\n"); 
		query.append(",   @[ownr_nm]" ).append("\n"); 
		query.append(",   @[bzct_nm]" ).append("\n"); 
		query.append(",   @[bztp_nm]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[delt_flg]" ).append("\n"); 
		query.append(",	@[ob_eml]" ).append("\n"); 
		query.append(",	@[ib_eml]" ).append("\n"); 
		query.append(",	@[ob_fax_no]" ).append("\n"); 
		query.append(",	@[ib_fax_no]" ).append("\n"); 
		query.append(",	@[cust_cr_due_dt_div_cd]" ).append("\n"); 
		query.append(") " ).append("\n"); 

	}
}