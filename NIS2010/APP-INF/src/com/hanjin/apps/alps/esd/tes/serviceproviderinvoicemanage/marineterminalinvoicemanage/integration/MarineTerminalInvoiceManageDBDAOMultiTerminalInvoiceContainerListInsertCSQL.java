/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
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

public class MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTerminalInvoiceContainerListInsert
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListInsertCSQL(){
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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd_df",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no_split",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no_chk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceContainerListInsertCSQL").append("\n"); 
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
		query.append("						 TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						,TML_SO_SEQ" ).append("\n"); 
		query.append("						,TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("						,VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("						,MODI_FLG" ).append("\n"); 
		query.append("						,DSCR_IND_CD" ).append("\n"); 
		query.append("						,DSCR_DTL_IND_CD" ).append("\n"); 
		query.append("						,VSL_CD" ).append("\n"); 
		query.append("						,SKD_VOY_NO" ).append("\n"); 
		query.append("						,SKD_DIR_CD" ).append("\n"); 
		query.append("						,IO_BND_CD" ).append("\n"); 
		query.append("						,IOC_CD" ).append("\n"); 
		query.append("						,LANE_CD" ).append("\n"); 
		query.append("						,ATB_DT" ).append("\n"); 
		query.append("						,CNTR_NO" ).append("\n"); 
		query.append("						,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("						,CNTR_STY_CD" ).append("\n"); 
		query.append("						,LOCL_TS_IND_CD" ).append("\n"); 
		query.append("						,RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("						,DCGO_CLSS_CD" ).append("\n"); 
		query.append("						,BB_CGO_FLG" ).append("\n"); 
		query.append("						,AWK_CGO_FLG" ).append("\n"); 
		query.append("						,RC_FLG" ).append("\n"); 
		query.append("						,WRK_DT" ).append("\n"); 
		query.append("						,CLM_DT" ).append("\n"); 
		query.append("						,RAIL_BIL_DT" ).append("\n"); 
		query.append("						,BKG_NO" ).append("\n"); 
		query.append("						,BKG_NO_SPLIT" ).append("\n"); 
		query.append("						,BL_NO" ).append("\n"); 
		query.append("						,BL_NO_TP" ).append("\n"); 
		query.append("						,BL_NO_CHK" ).append("\n"); 
		query.append("						,DSCR_RSN" ).append("\n"); 
		query.append("						,HNDL_RSLT_RMK" ).append("\n"); 
		query.append("						,CNTR_RMK" ).append("\n"); 
		query.append("						,TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("						,CRE_USR_ID" ).append("\n"); 
		query.append("						,CRE_DT" ).append("\n"); 
		query.append("						,LOCL_CRE_DT" ).append("\n"); 
		query.append("						,UPD_USR_ID" ).append("\n"); 
		query.append("						,UPD_DT" ).append("\n"); 
		query.append("						,LOCL_UPD_DT" ).append("\n"); 
		query.append("						,CLPT_IND_SEQ" ).append("\n"); 
		query.append("						,CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(")VALUES(			      @[tml_so_ofc_cty_cd]											-- tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("						, @[tml_so_seq]													-- tml_so_seq" ).append("\n"); 
		query.append("						, @[tml_so_cntr_list_seq]										-- tml_so_cntr_list_seq" ).append("\n"); 
		query.append("						, @[vrfy_rslt_ind_cd]											-- vrfy_rslt_ind_cd" ).append("\n"); 
		query.append("						, @[modi_flg]													-- modi_flg" ).append("\n"); 
		query.append("						, SUBSTR(@[dscr_ind_cd],0,2)									-- dscr_ind_cd" ).append("\n"); 
		query.append("						, @[dscr_dtl_ind_cd]											-- dscr_dtl_ind_cd" ).append("\n"); 
		query.append("						, @[vsl_cd]														-- vsl_cd" ).append("\n"); 
		query.append("						, @[skd_voy_no]													-- skd_voy_no" ).append("\n"); 
		query.append("						, @[skd_dir_cd]													-- skd_dir_cd" ).append("\n"); 
		query.append("						, NVL(@[io_bnd_cd],LOWER(@[io_bnd_cd_df]))							-- io_bnd_cd" ).append("\n"); 
		query.append("						, @[ioc_cd]														-- ioc_cd" ).append("\n"); 
		query.append("						, @[lane_cd]													-- lane_cd" ).append("\n"); 
		query.append("						, TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-',''),0,8),'YYYYMMDD')		-- atb_dt" ).append("\n"); 
		query.append("						, @[cntr_no]													-- cntr_no" ).append("\n"); 
		query.append("						, @[cntr_tpsz_cd]													-- cntr_tpsz_cd" ).append("\n"); 
		query.append("						, @[cntr_sty_cd]													-- cntr_sty_cd" ).append("\n"); 
		query.append("						, @[locl_ts_ind_cd]													-- locl_ts_ind_cd" ).append("\n"); 
		query.append("						, REPLACE(@[rcvde_term_ind_cd],'/')									-- rcvde_term_ind_cd" ).append("\n"); 
		query.append("						, @[dcgo_clss_cd]													-- dcgo_clss_cd" ).append("\n"); 
		query.append("						, @[bb_cgo_flg]														-- bb_cgo_flg" ).append("\n"); 
		query.append("						, @[awk_cgo_flg]													-- awk_cgo_flg" ).append("\n"); 
		query.append("						, @[rc_flg]														-- rc_flg" ).append("\n"); 
		query.append("						, TO_DATE(SUBSTR(REPLACE(@[wrk_dt],'-'),0,8),'YYYYMMDD')		-- wrk_dt" ).append("\n"); 
		query.append("						, TO_DATE(SUBSTR(REPLACE(@[clm_dt],'-'),0,8),'YYYYMMDD')		-- clm_dt" ).append("\n"); 
		query.append("						, TO_DATE(SUBSTR(REPLACE(@[rail_bil_dt],'-'),0,8),'YYYYMMDD')	-- rail_bil_dt" ).append("\n"); 
		query.append("						, @[bkg_no]														-- bkg_no" ).append("\n"); 
		query.append("						, NVL(RTRIM(@[bkg_no_split],'  '),'  ')							-- bkg_no_split" ).append("\n"); 
		query.append("						, @[bl_no]														-- bl_no" ).append("\n"); 
		query.append("						, @[bl_no_tp]													-- bl_no_tp" ).append("\n"); 
		query.append("						, @[bl_no_chk]													-- bl_no_chk" ).append("\n"); 
		query.append("						, @[dscr_rsn]													-- dscr_rsn" ).append("\n"); 
		query.append("						, @[hndl_rslt_rmk]												-- hndl_rslt_rmk" ).append("\n"); 
		query.append("						, @[cntr_rmk]													-- cntr_rmk" ).append("\n"); 
		query.append("						, @[tml_trns_mod_cd]											-- tml_trns_mod_cd" ).append("\n"); 
		query.append("						, @[cre_usr_id]													-- cre_usr_id" ).append("\n"); 
		query.append("						, SYSDATE														-- cre_dt" ).append("\n"); 
		query.append("						, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])				-- locl_cre_dt" ).append("\n"); 
		query.append("						, @[upd_usr_id]													-- upd_usr_id" ).append("\n"); 
		query.append("						, SYSDATE														-- upd_dt" ).append("\n"); 
		query.append("						, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])				-- locl_upd_dt" ).append("\n"); 
		query.append("						, @[clpt_ind_seq]												-- clpt_ind_seq" ).append("\n"); 
		query.append("						, @[call_yd_ind_seq]											-- call_yd_ind_seq" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}