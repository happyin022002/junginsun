/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOCreateStorageInvoiceBasicInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOCreateStorageInvoiceBasicInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateStorageInvoiceBasicInfo
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOCreateStorageInvoiceBasicInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_rvs_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dbt_note_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_rjct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whld_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_calc_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_cgst_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_calc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rjct_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_igst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sgst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_ugst_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sto_dys_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOCreateStorageInvoiceBasicInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_HDR (" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_SO_SEQ" ).append("\n"); 
		query.append(", INV_OFC_CD" ).append("\n"); 
		query.append(", COST_OFC_CD" ).append("\n"); 
		query.append(", INV_NO" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", TTL_INV_AMT" ).append("\n"); 
		query.append(", VAT_AMT" ).append("\n"); 
		query.append(", TTL_CALC_AMT" ).append("\n"); 
		query.append(", FM_PRD_DT" ).append("\n"); 
		query.append(", HLD_FLG" ).append("\n"); 
		query.append(", HLD_RMK" ).append("\n"); 
		query.append(", TO_PRD_DT" ).append("\n"); 
		query.append(", TML_INV_TP_CD" ).append("\n"); 
		query.append(", TML_COST_GRP_CD" ).append("\n"); 
		query.append(", TML_CALC_IND_CD" ).append("\n"); 
		query.append(", STO_DYS_IND_CD" ).append("\n"); 
		query.append(", ISS_DT" ).append("\n"); 
		query.append(", RCV_DT" ).append("\n"); 
		query.append(", EFF_DT" ).append("\n"); 
		query.append(", PAY_DUE_DT" ).append("\n"); 
		query.append(", PAY_FLG" ).append("\n"); 
		query.append(", TML_INV_STS_CD" ).append("\n"); 
		query.append(", TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append(", INV_CFM_DT" ).append("\n"); 
		query.append(", INV_RJCT_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(", ERR_INV_NO" ).append("\n"); 
		query.append(", WHLD_TAX_AMT" ).append("\n"); 
		query.append(", AP_RVS_CNG_FLG" ).append("\n"); 
		query.append("--// India GST 컬럼 추가 (2017-07-19 )" ).append("\n"); 
		query.append(", DBT_NOTE_NO" ).append("\n"); 
		query.append(", IDA_CGST_AMT" ).append("\n"); 
		query.append(", IDA_SGST_AMT" ).append("\n"); 
		query.append(", IDA_IGST_AMT" ).append("\n"); 
		query.append(", IDA_UGST_AMT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append(" @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(",  (SELECT NVL(MAX(H2.TML_SO_SEQ),0)+1 FROM TES_TML_SO_HDR H2 WHERE H2.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd])" ).append("\n"); 
		query.append(",  @[inv_ofc_cd]" ).append("\n"); 
		query.append(",  @[cost_ofc_cd]" ).append("\n"); 
		query.append(",  @[inv_no]" ).append("\n"); 
		query.append(",  @[vndr_seq]" ).append("\n"); 
		query.append(",  @[yd_cd]" ).append("\n"); 
		query.append(",  @[curr_cd]" ).append("\n"); 
		query.append(",  @[ttl_inv_amt]" ).append("\n"); 
		query.append(",  @[vat_amt]" ).append("\n"); 
		query.append(",  @[ttl_calc_amt]" ).append("\n"); 
		query.append(",  SUBSTR(@[fm_prd_dt],0,8)" ).append("\n"); 
		query.append(",  @[hld_flg]" ).append("\n"); 
		query.append(",  @[hld_rmk]" ).append("\n"); 
		query.append(",  SUBSTR(@[to_prd_dt],0,8)" ).append("\n"); 
		query.append(",  @[tml_inv_tp_cd]" ).append("\n"); 
		query.append(",  @[tml_cost_grp_cd]" ).append("\n"); 
		query.append(",  @[tml_calc_ind_cd]" ).append("\n"); 
		query.append(",  @[sto_dys_ind_cd]" ).append("\n"); 
		query.append(",  TO_DATE(@[iss_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",  TO_DATE(@[rcv_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",  TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",  TO_DATE(@[pay_due_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",  @[pay_flg]" ).append("\n"); 
		query.append(",  'R'" ).append("\n"); 
		query.append(",  @[tml_inv_rjct_sts_cd]" ).append("\n"); 
		query.append(",  @[inv_cfm_dt]" ).append("\n"); 
		query.append(",  @[inv_rjct_rmk]" ).append("\n"); 
		query.append(",  @[cre_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  @[upd_usr_id]" ).append("\n"); 
		query.append(",  SYSDATE" ).append("\n"); 
		query.append(",  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append(",  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])" ).append("\n"); 
		query.append(",  @[err_inv_no]" ).append("\n"); 
		query.append(",  @[whld_tax_amt]" ).append("\n"); 
		query.append(",  @[ap_rvs_cng_flg]" ).append("\n"); 
		query.append(", @[dbt_note_no]" ).append("\n"); 
		query.append(", REPLACE(@[ida_cgst_amt],',')" ).append("\n"); 
		query.append(", REPLACE(@[ida_sgst_amt],',')" ).append("\n"); 
		query.append(", REPLACE(@[ida_igst_amt],',')" ).append("\n"); 
		query.append(", REPLACE(@[ida_ugst_amt],',')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}