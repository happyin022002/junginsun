/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOOndockRailChargeInvoiceCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.16 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOOndockRailChargeInvoiceCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OndockRailChargeInvoiceCommon
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOOndockRailChargeInvoiceCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOOndockRailChargeInvoiceCommonRSQL").append("\n"); 
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
		query.append("select 	'' vrfy_rslt_ind_cd, '' cost_calc_mode, '' min_wrk_dt" ).append("\n"); 
		query.append(",'' max_wrk_dt" ).append("\n"); 
		query.append(",'' org_curr_cd" ).append("\n"); 
		query.append(",'' flg_yn" ).append("\n"); 
		query.append(",'' del_if_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", ''	rvis_tml_so_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_so_dtl_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_so_rvis_list_seq" ).append("\n"); 
		query.append(", ''	rvis_tml_inv_tp_cd" ).append("\n"); 
		query.append(", ''	rvis_calc_cost_grp_cd" ).append("\n"); 
		query.append(", ''	rvis_tml_rvis_tp_cd" ).append("\n"); 
		query.append(", ''	rvis_lgs_cost_cd" ).append("\n"); 
		query.append(", ''	rvis_ind_flg" ).append("\n"); 
		query.append(", ''	rvis_gate_in_flg" ).append("\n"); 
		query.append(", ''	rvis_gate_out_flg" ).append("\n"); 
		query.append(", ''	rvis_inv_gate_in_dt" ).append("\n"); 
		query.append(", ''	rvis_inv_gate_out_dt" ).append("\n"); 
		query.append(", ''	rvis_cntr_no" ).append("\n"); 
		query.append(", ''	rvis_cntr_tpsz_cd" ).append("\n"); 
		query.append(", ''	rvis_cntr_sty_cd" ).append("\n"); 
		query.append(", ''	rvis_bkg_no" ).append("\n"); 
		query.append(", ''	rvis_vsl_cd" ).append("\n"); 
		query.append(", ''	rvis_skd_voy_no" ).append("\n"); 
		query.append(", ''	rvis_skd_dir_cd" ).append("\n"); 
		query.append(", ''	rvis_cuz_cntr_no" ).append("\n"); 
		query.append(", ''	rvis_rhnd_rsn_cd" ).append("\n"); 
		query.append(", ''	rvis_rmk" ).append("\n"); 
		query.append(", ''	rvis_cre_usr_id" ).append("\n"); 
		query.append(", ''	rvis_cre_dt" ).append("\n"); 
		query.append(", ''	rvis_upd_usr_id" ).append("\n"); 
		query.append(", ''	rvis_upd_dt" ).append("\n"); 
		query.append(", ''	rvis_locl_cre_dt" ).append("\n"); 
		query.append(", ''	rvis_locl_upd_dt" ).append("\n"); 
		query.append(", ''	rvis_tml_so_cntr_list_seq" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}