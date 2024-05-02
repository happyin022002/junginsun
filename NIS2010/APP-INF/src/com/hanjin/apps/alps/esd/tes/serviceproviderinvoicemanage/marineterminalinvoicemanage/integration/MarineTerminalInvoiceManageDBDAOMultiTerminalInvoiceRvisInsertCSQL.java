/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTerminalInvoiceRvisInsert
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plug_term",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_rvis_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plug_out",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cuz_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_rvis_list_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plug_in",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhnd_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceRvisInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_RVIS_LIST" ).append("\n"); 
		query.append("(   tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", tml_so_seq" ).append("\n"); 
		query.append(", tml_so_dtl_seq" ).append("\n"); 
		query.append(", tml_so_rvis_list_seq" ).append("\n"); 
		query.append(", tml_inv_tp_cd" ).append("\n"); 
		query.append(", calc_cost_grp_cd" ).append("\n"); 
		query.append(", tml_rvis_tp_cd" ).append("\n"); 
		query.append(", lgs_cost_cd" ).append("\n"); 
		query.append(", cntr_no" ).append("\n"); 
		query.append(", cntr_tpsz_cd" ).append("\n"); 
		query.append(", cntr_sty_cd" ).append("\n"); 
		query.append(", bkg_no" ).append("\n"); 
		query.append("--, bkg_no_split" ).append("\n"); 
		query.append(", plg_in_dt" ).append("\n"); 
		query.append(", plg_out_dt" ).append("\n"); 
		query.append(", plg_term_dys" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", cuz_cntr_no" ).append("\n"); 
		query.append(", rhnd_rsn_cd" ).append("\n"); 
		query.append(", rvis_rmk" ).append("\n"); 
		query.append(", rvis_ind_flg" ).append("\n"); 
		query.append(", cre_usr_id" ).append("\n"); 
		query.append(", cre_dt" ).append("\n"); 
		query.append(", locl_cre_dt" ).append("\n"); 
		query.append(", upd_usr_id" ).append("\n"); 
		query.append(", upd_dt" ).append("\n"); 
		query.append(", locl_upd_dt" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(	  @[tml_so_ofc_cty_cd]						--	tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", @[tml_so_seq]								--	tml_so_seq" ).append("\n"); 
		query.append(", @[tml_so_dtl_seq]							--	tml_so_dtl_seq" ).append("\n"); 
		query.append(", @[tml_so_rvis_list_seq]										--	tml_so_rvis_list_seq" ).append("\n"); 
		query.append(", 'TM'										--	tml_inv_tp_cd" ).append("\n"); 
		query.append(", @[calc_cost_grp_cd]										--	calc_cost_grp_cd" ).append("\n"); 
		query.append(", @[tml_rvis_tp_cd]										--	tml_rvis_tp_cd" ).append("\n"); 
		query.append(", @[lgs_cost_cd]										--	lgs_cost_cd" ).append("\n"); 
		query.append(", @[cntr_no]										--	cntr_no" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]										--	cntr_tpsz_cd" ).append("\n"); 
		query.append(", @[cntr_sty_cd]										--	cntr_sty_cd" ).append("\n"); 
		query.append(", @[bkg_no]										--	bkg_no" ).append("\n"); 
		query.append("--, NVL(RTRIM([bkg_no_split],'  '),'  ')					--	bkg_no_split" ).append("\n"); 
		query.append(", TO_DATE(@[plug_in], 'YYYYMMDD HH24MI') 									-- plg_in_dt" ).append("\n"); 
		query.append(", TO_DATE(@[plug_out], 'YYYYMMDD HH24MI') 									-- plg_out_dt" ).append("\n"); 
		query.append(", @[plug_term]									-- plg_term_dys" ).append("\n"); 
		query.append(", @[vsl_cd]										--	vsl_cd" ).append("\n"); 
		query.append(", @[skd_voy_no]										--	skd_voy_no" ).append("\n"); 
		query.append(", @[skd_dir_cd]										--	skd_dir_cd" ).append("\n"); 
		query.append(", @[cuz_cntr_no]										--	cuz_cntr_no" ).append("\n"); 
		query.append(", @[rhnd_rsn_cd]										--	rhnd_rsn_cd" ).append("\n"); 
		query.append(", @[rvis_rmk]										--	rvis_rmk" ).append("\n"); 
		query.append(", DECODE(@[rvis_ind_flg],'1','Y','N')					--	rvis_ind_flg" ).append("\n"); 
		query.append(", @[cre_usr_id]										--	cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE											--  cre_dt" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])		--	locl_cre_dt" ).append("\n"); 
		query.append(", @[upd_usr_id]										--  upd_usr_id" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])		--" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}