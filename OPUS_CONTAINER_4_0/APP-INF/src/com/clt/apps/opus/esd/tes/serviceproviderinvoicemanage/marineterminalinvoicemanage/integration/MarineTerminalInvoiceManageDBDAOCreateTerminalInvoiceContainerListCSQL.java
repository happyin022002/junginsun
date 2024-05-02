/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceContainerListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceContainerListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTerminalInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceContainerListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_ts_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dscr_dtl_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_cntr_list_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vrfy_rslt_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvde_term_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dscr_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOCreateTerminalInvoiceContainerListCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_CNTR_LIST(" ).append("\n"); 
		query.append("						 tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("						,tml_so_seq" ).append("\n"); 
		query.append("						,tml_so_cntr_list_seq" ).append("\n"); 
		query.append("						,vrfy_rslt_ind_cd" ).append("\n"); 
		query.append("						,dscr_ind_cd" ).append("\n"); 
		query.append("						,dscr_dtl_ind_cd" ).append("\n"); 
		query.append("						,vsl_cd" ).append("\n"); 
		query.append("						,skd_voy_no" ).append("\n"); 
		query.append("						,skd_dir_cd" ).append("\n"); 
		query.append("						,io_bnd_cd" ).append("\n"); 
		query.append("						,ioc_cd" ).append("\n"); 
		query.append("						,lane_cd" ).append("\n"); 
		query.append("					    ,sub_trd_cd" ).append("\n"); 
		query.append("						,atb_dt" ).append("\n"); 
		query.append("						,cntr_no" ).append("\n"); 
		query.append("						,cntr_tpsz_cd" ).append("\n"); 
		query.append("						,cntr_sty_cd" ).append("\n"); 
		query.append("						,locl_ts_ind_cd" ).append("\n"); 
		query.append("						,rcvde_term_ind_cd" ).append("\n"); 
		query.append("						,dcgo_clss_cd" ).append("\n"); 
		query.append("						,bb_cgo_flg" ).append("\n"); 
		query.append("						,awk_cgo_flg" ).append("\n"); 
		query.append("						,rc_flg" ).append("\n"); 
		query.append("						,wrk_dt" ).append("\n"); 
		query.append("						,bkg_no" ).append("\n"); 
		query.append("						--,bkg_no_split" ).append("\n"); 
		query.append("						,bl_no" ).append("\n"); 
		query.append("						--,bl_no_tp" ).append("\n"); 
		query.append("						--,bl_no_chk" ).append("\n"); 
		query.append("						,cntr_rmk" ).append("\n"); 
		query.append("						,tml_trns_mod_cd" ).append("\n"); 
		query.append("						,cre_usr_id" ).append("\n"); 
		query.append("						,cre_dt" ).append("\n"); 
		query.append("						,locl_cre_dt" ).append("\n"); 
		query.append("						,upd_usr_id" ).append("\n"); 
		query.append("						,upd_dt" ).append("\n"); 
		query.append("						,locl_upd_dt" ).append("\n"); 
		query.append(")VALUES(				  @[tml_so_ofc_cty_cd]  									-- tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("						, @[tml_so_seq] 											-- tml_so_seq" ).append("\n"); 
		query.append("						, @[tml_so_cntr_list_seq]  									-- tml_so_cntr_list_s" ).append("\n"); 
		query.append("						, @[vrfy_rslt_ind_cd]  										-- vrfy_rslt_ind_cd" ).append("\n"); 
		query.append("						, SUBSTR(@[dscr_ind_cd],0,2)								-- dscr_ind_cd" ).append("\n"); 
		query.append("						, @[dscr_dtl_ind_cd]  										-- dscr_dtl_ind_cd" ).append("\n"); 
		query.append("						, @[vsl_cd]  												-- vsl_cd" ).append("\n"); 
		query.append("						, @[skd_voy_no]  											-- skd_voy_no" ).append("\n"); 
		query.append("						, @[skd_dir_cd]  											-- skd_dir_cd" ).append("\n"); 
		query.append("						, @[io_bnd_cd]  											-- io_bnd_cd" ).append("\n"); 
		query.append("						, @[ioc_cd]  												-- ioc_cd" ).append("\n"); 
		query.append("						, @[lane_cd]  												-- lane_cd" ).append("\n"); 
		query.append("						, DECODE(@[sub_trd_cd],'','','OTH','O',@[sub_trd_cd])		-- sub_trd_cd" ).append("\n"); 
		query.append("						, TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-',''),0,8),'YYYYMMDD')  -- a" ).append("\n"); 
		query.append("						, @[cntr_no]  											-- cntr_no" ).append("\n"); 
		query.append("						, @[cntr_tpsz_cd]  										-- cntr_tpsz_cd" ).append("\n"); 
		query.append("						, @[cntr_sty_cd]  										-- cntr_sty_cd" ).append("\n"); 
		query.append("						, @[locl_ts_ind_cd]  									-- locl_ts_ind_cd" ).append("\n"); 
		query.append("						, REPLACE(@[rcvde_term_ind_cd],'/')						-- rcvde_term_ind_c" ).append("\n"); 
		query.append("						, @[dcgo_clss_cd]  										-- dcgo_clss_cd" ).append("\n"); 
		query.append("						, @[bb_cgo_flg]  										-- bb_cgo_flg" ).append("\n"); 
		query.append("						, @[awk_cgo_flg]  										-- awk_cgo_flg" ).append("\n"); 
		query.append("						, @[rc_flg]  											-- rc_flg" ).append("\n"); 
		query.append("						, TO_DATE(SUBSTR(REPLACE(@[wrk_dt],'-'),0,8),'YYYYMMDD')  -- wrk_" ).append("\n"); 
		query.append("						, @[bkg_no]												-- bkg_no" ).append("\n"); 
		query.append("						--, NVL(RTRIM([bkg_no_split],'  '),'  ')					-- bkg_no_split" ).append("\n"); 
		query.append("						, @[bl_no]  											-- bl_no" ).append("\n"); 
		query.append("						--,[bl_no_tp]  											-- bl_no_tp" ).append("\n"); 
		query.append("						--,[bl_no_chk]  										-- bl_no_chk" ).append("\n"); 
		query.append("						, @[cntr_rmk]  											-- cntr_rmk" ).append("\n"); 
		query.append("						, @[tml_trns_mod_cd]  									-- tml_trns_mod_cd" ).append("\n"); 
		query.append("						, @[cre_usr_id]  										-- cre_usr_id" ).append("\n"); 
		query.append("						, sysdate												-- cre_dt" ).append("\n"); 
		query.append("						, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])			--locl_cre_dt 실제론 ofc_cd가 들어감" ).append("\n"); 
		query.append("						, @[upd_usr_id]" ).append("\n"); 
		query.append("						, sysdate												    --upd_dt" ).append("\n"); 
		query.append("						, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])			--loc_upd_dt 실제론 ofc_cd가 들어감" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}