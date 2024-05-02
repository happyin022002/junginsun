/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.23 박재흥
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

public class OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOndockRailChargeContainerListInsert
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListInsertCSQL(){
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
		params.put("dscr_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_locl_ts_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_gate_in_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_gate_out_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_bil_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_out_td_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_gate_in_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stay_diff_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hndl_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_stay_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_in_td_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_stay_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_gate_out_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListInsertCSQL").append("\n"); 
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
		query.append("TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",TML_SO_SEQ" ).append("\n"); 
		query.append(",TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append(",VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append(",MODI_FLG" ).append("\n"); 
		query.append(",DSCR_IND_CD" ).append("\n"); 
		query.append(",DSCR_DTL_IND_CD" ).append("\n"); 
		query.append(",RVIS_IND_FLG" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",FINC_VSL_CD" ).append("\n"); 
		query.append(",FINC_SKD_VOY_NO" ).append("\n"); 
		query.append(",FINC_SKD_DIR_CD" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",IOC_CD" ).append("\n"); 
		query.append(",LANE_CD" ).append("\n"); 
		query.append(",ATB_DT" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CNTR_STY_CD" ).append("\n"); 
		query.append(",LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append(",RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append(",PRE_YD_CD" ).append("\n"); 
		query.append(",MVMT_GATE_IN_DT" ).append("\n"); 
		query.append(",INV_GATE_IN_DT" ).append("\n"); 
		query.append(",GATE_IN_TD_DYS" ).append("\n"); 
		query.append(",MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append(",INV_GATE_OUT_DT" ).append("\n"); 
		query.append(",GATE_OUT_TD_DYS" ).append("\n"); 
		query.append(",MVMT_STAY_DYS" ).append("\n"); 
		query.append(",INV_STAY_DYS" ).append("\n"); 
		query.append(",STAY_DIFF_DYS" ).append("\n"); 
		query.append(",DCGO_CLSS_CD" ).append("\n"); 
		query.append(",BB_CGO_FLG" ).append("\n"); 
		query.append(",AWK_CGO_FLG" ).append("\n"); 
		query.append(",RC_FLG" ).append("\n"); 
		query.append(",WRK_DT" ).append("\n"); 
		query.append(",CLM_DT" ).append("\n"); 
		query.append(",RAIL_BIL_DT" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append("--,BKG_NO_SPLIT" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append("--,BL_NO_TP" ).append("\n"); 
		query.append("--,BL_NO_CHK" ).append("\n"); 
		query.append(",DSCR_RSN" ).append("\n"); 
		query.append(",HNDL_RSLT_RMK" ).append("\n"); 
		query.append(",CNTR_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",LOCL_CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",LOCL_UPD_DT" ).append("\n"); 
		query.append(")VALUES(			      @[tml_so_ofc_cty_cd]  							-- tml_so_ofc_cty_cd" ).append("\n"); 
		query.append(", @[tml_so_seq] 									-- tml_so_seq" ).append("\n"); 
		query.append(", @[tml_so_cntr_list_seq]  							-- tml_so_cntr_list_seq" ).append("\n"); 
		query.append(", @[vrfy_rslt_ind_cd]  								-- vrfy_rslt_ind_cd" ).append("\n"); 
		query.append(", @[modi_flg]  										-- modi_flg" ).append("\n"); 
		query.append(", SUBSTR(@[dscr_ind_cd],0,2)						-- dscr_ind_cd" ).append("\n"); 
		query.append(", @[dscr_dtl_ind_cd]  								-- dscr_dtl_ind_cd" ).append("\n"); 
		query.append(", @[rvis_ind_flg]  									-- rvis_ind_flg" ).append("\n"); 
		query.append(", @[vsl_cd]  										-- vsl_cd" ).append("\n"); 
		query.append(", @[skd_voy_no]  									-- skd_voy_no" ).append("\n"); 
		query.append(", @[skd_dir_cd]  									-- skd_dir_cd" ).append("\n"); 
		query.append(", @[finc_vsl_cd]  									-- finc_vsl_cd" ).append("\n"); 
		query.append(", @[finc_skd_voy_no]  								-- finc_skd_voy_no" ).append("\n"); 
		query.append(", @[finc_skd_dir_cd]  								-- finc_skd_dir_cd" ).append("\n"); 
		query.append(", @[io_bnd_cd]  									-- io_bnd_cd" ).append("\n"); 
		query.append(", @[ioc_cd]  										-- ioc_cd" ).append("\n"); 
		query.append(", @[lane_cd]  										-- lane_cd" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-'),0,8),'YYYYMMDD')  	-- atb_dt" ).append("\n"); 
		query.append(", @[cntr_no]														-- cntr_no" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]													-- cntr_tpsz_cd" ).append("\n"); 
		query.append(", @[cntr_sty_cd]													-- cntr_sty_cd" ).append("\n"); 
		query.append(", @[locl_ts_ind_cd]													-- locl_ts_ind_cd" ).append("\n"); 
		query.append(", @[sam_locl_ts_ind_cd]												-- sam_locl_ts_ind_cd" ).append("\n"); 
		query.append(", REPLACE(@[rcvde_term_ind_cd],'/')									-- rcvde_term_ind_cd" ).append("\n"); 
		query.append(", @[pre_yd_cd]														-- pre_yd_cd" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[mvmt_gate_in_dt],'-'),0,8),'YYYYMMDD')  	-- mvmt_gate_in_dt" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[inv_gate_in_dt],'-'),0,8),'YYYYMMDD')  	-- inv_gate_in_dt" ).append("\n"); 
		query.append(", @[gate_in_td_dys]  												-- gate_in_td_dys" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[mvmt_gate_out_dt],'-'),0,8),'YYYYMMDD')  -- mvmt_gate_out_dt" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[inv_gate_out_dt],'-'),0,8),'YYYYMMDD')  	-- inv_gate_out_dt" ).append("\n"); 
		query.append(", @[gate_out_td_dys]												-- gate_out_td_dys" ).append("\n"); 
		query.append(", @[mvmt_stay_dys]													-- mvmt_stay_dys" ).append("\n"); 
		query.append(", @[inv_stay_dys]													-- inv_stay_dys" ).append("\n"); 
		query.append(", @[stay_diff_dys]													-- stay_diff_dys" ).append("\n"); 
		query.append(", @[dcgo_clss_cd]													-- dcgo_clss_cd" ).append("\n"); 
		query.append(", @[bb_cgo_flg]														-- bb_cgo_flg" ).append("\n"); 
		query.append(", @[awk_cgo_flg]													-- awk_cgo_flg" ).append("\n"); 
		query.append(", @[rc_flg]															-- rc_flg" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[wrk_dt],'-'),0,8),'YYYYMMDD')  			-- wrk_dt" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[clm_dt],'-'),0,8),'YYYYMMDD')  			-- clm_dt" ).append("\n"); 
		query.append(", TO_DATE(SUBSTR(REPLACE(@[rail_bil_dt],'-'),0,8),'YYYYMMDD')  		-- rail_bil_dt" ).append("\n"); 
		query.append(", @[bkg_no]  									-- bkg_no" ).append("\n"); 
		query.append("--, NVL(RTRIM([bkg_no_split],'  '),'  ')			-- bkg_no_split" ).append("\n"); 
		query.append(", @[bl_no]  									-- bl_no" ).append("\n"); 
		query.append("--, [bl_no_tp]  									-- bl_no_tp" ).append("\n"); 
		query.append("--, [bl_no_chk]  								-- bl_no_chk" ).append("\n"); 
		query.append(", @[dscr_rsn]  									-- dscr_rsn" ).append("\n"); 
		query.append(", @[hndl_rslt_rmk]  							-- hndl_rslt_rmk" ).append("\n"); 
		query.append(", @[cntr_rmk]  									-- cntr_rmk" ).append("\n"); 
		query.append(", @[cre_usr_id]  								-- cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE										-- cre_dt" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])	-- locl_cre_dt" ).append("\n"); 
		query.append(", @[cre_usr_id]  									-- cre_usr_id" ).append("\n"); 
		query.append(", SYSDATE											-- upd_dt" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])	-- locl_upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}