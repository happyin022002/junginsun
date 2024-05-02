/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOModifyOndockRailChargeBasicInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOModifyOndockRailChargeBasicInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyOndockRailChargeBasicInfo
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOModifyOndockRailChargeBasicInfoUSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtro_tml_inv_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOModifyOndockRailChargeBasicInfoUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_HDR" ).append("\n"); 
		query.append(" SET 	  inv_ofc_cd			     = @[inv_ofc_cd]" ).append("\n"); 
		query.append("			 ,cost_ofc_cd            = @[cost_ofc_cd]" ).append("\n"); 
		query.append("			 ,inv_no                 = @[inv_no]" ).append("\n"); 
		query.append("			 ,vndr_seq               = @[vndr_seq]" ).append("\n"); 
		query.append("			 ,yd_cd                  = @[yd_cd]" ).append("\n"); 
		query.append("			 ,curr_cd                = @[curr_cd]" ).append("\n"); 
		query.append("			 ,ttl_inv_amt            = REPLACE(@[ttl_inv_amt],',')" ).append("\n"); 
		query.append("			 ,vat_amt                = REPLACE(@[vat_amt],',')" ).append("\n"); 
		query.append("			 ,whld_tax_amt           = REPLACE(@[whld_tax_amt],',')" ).append("\n"); 
		query.append("			 ,ttl_calc_amt           = REPLACE(@[ttl_calc_amt],',')" ).append("\n"); 
		query.append("			 ,fm_prd_dt              = SUBSTR(REPLACE(@[fm_prd_dt],'-'),0,8)" ).append("\n"); 
		query.append("			 ,hld_flg                = @[hld_flg]" ).append("\n"); 
		query.append("			 ,hld_rmk                = @[hld_rmk]" ).append("\n"); 
		query.append("			 ,to_prd_dt              = SUBSTR(REPLACE(@[to_prd_dt],'-'),0,8)" ).append("\n"); 
		query.append("			 ,tml_cost_grp_cd        = @[tml_cost_grp_cd]" ).append("\n"); 
		query.append("			 ,tml_calc_ind_cd        = @[tml_calc_ind_cd]" ).append("\n"); 
		query.append("			 ,sto_dys_ind_cd         = @[sto_dys_ind_cd]" ).append("\n"); 
		query.append("			 ,iss_dt                 = TO_DATE(SUBSTR(REPLACE(@[iss_dt],'-'),0,8),'YYYYMMDD')" ).append("\n"); 
		query.append("			 ,rcv_dt                 = TO_DATE(SUBSTR(REPLACE(@[rcv_dt],'-'),0,8),'YYYYMMDD')" ).append("\n"); 
		query.append("			 ,eff_dt                 = TO_DATE(SUBSTR(REPLACE(@[eff_dt],'-'),0,8),'YYYYMMDD')" ).append("\n"); 
		query.append("			 ,pay_due_dt             = TO_DATE(SUBSTR(REPLACE(@[pay_due_dt],'-'),0,8),'YYYYMMDD')" ).append("\n"); 
		query.append("			 ,pay_flg                = @[pay_flg]" ).append("\n"); 
		query.append("			 ,tml_inv_sts_cd         = @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("			 ,tml_inv_rjct_sts_cd    = @[tml_inv_rjct_sts_cd]" ).append("\n"); 
		query.append("			 ,rtro_tml_inv_flg		 = @[rtro_tml_inv_flg]" ).append("\n"); 
		query.append("			 ,ap_rvs_cng_flg		 = @[ap_rvs_cng_flg]	" ).append("\n"); 
		query.append("			 ,dbt_note_no			 = @[dbt_note_no]" ).append("\n"); 
		query.append("			 ,ida_cgst_amt			 = REPLACE(@[ida_cgst_amt],',')" ).append("\n"); 
		query.append("			 ,ida_sgst_amt			 = REPLACE(@[ida_sgst_amt],',')" ).append("\n"); 
		query.append("			 ,ida_igst_amt			 = REPLACE(@[ida_igst_amt],',')" ).append("\n"); 
		query.append("			 ,ida_ugst_amt			 = REPLACE(@[ida_ugst_amt],',')" ).append("\n"); 
		query.append("#if (${tml_inv_sts_cd} == 'C') " ).append("\n"); 
		query.append("			 ,inv_cfm_dt             = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_inv_rjct_sts_cd} == 'RJ') " ).append("\n"); 
		query.append("			 ,inv_rjct_dt            = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			 ,inv_rjct_rmk           = @[inv_rjct_rmk]" ).append("\n"); 
		query.append("			 ,upd_usr_id             = @[upd_usr_id]" ).append("\n"); 
		query.append("			 ,upd_dt				 = SYSDATE" ).append("\n"); 
		query.append("			 ,locl_upd_dt            = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("  WHERE	 TML_SO_OFC_CTY_CD			= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("  AND	 TML_SO_SEQ					= @[tml_so_seq]" ).append("\n"); 

	}
}