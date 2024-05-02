/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOInsertStorageInvoiceContainerListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.15 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOInsertStorageInvoiceContainerListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertStorageInvoiceContainerList
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOInsertStorageInvoiceContainerListCSQL(){
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
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vrfy_rslt_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mvmt_stay_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_gate_out_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOInsertStorageInvoiceContainerListCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_CNTR_LIST (" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD          ," ).append("\n"); 
		query.append("TML_SO_SEQ                 ," ).append("\n"); 
		query.append("TML_SO_CNTR_LIST_SEQ       ," ).append("\n"); 
		query.append("VRFY_RSLT_IND_CD           ," ).append("\n"); 
		query.append("DSCR_IND_CD                ," ).append("\n"); 
		query.append("VSL_CD                     ," ).append("\n"); 
		query.append("SKD_VOY_NO                 ," ).append("\n"); 
		query.append("SKD_DIR_CD                 ," ).append("\n"); 
		query.append("IO_BND_CD                  ," ).append("\n"); 
		query.append("CNTR_NO                    ," ).append("\n"); 
		query.append("CNTR_TPSZ_CD               ," ).append("\n"); 
		query.append("CNTR_STY_CD                ," ).append("\n"); 
		query.append("LOCL_TS_IND_CD             ," ).append("\n"); 
		query.append("MVMT_GATE_IN_DT            ," ).append("\n"); 
		query.append("INV_GATE_IN_DT             ," ).append("\n"); 
		query.append("GATE_IN_TD_DYS             ," ).append("\n"); 
		query.append("MVMT_GATE_OUT_DT           ," ).append("\n"); 
		query.append("INV_GATE_OUT_DT            ," ).append("\n"); 
		query.append("GATE_OUT_TD_DYS            ," ).append("\n"); 
		query.append("MVMT_STAY_DYS              ," ).append("\n"); 
		query.append("INV_STAY_DYS               ," ).append("\n"); 
		query.append("STAY_DIFF_DYS              ," ).append("\n"); 
		query.append("DCGO_CLSS_CD               ," ).append("\n"); 
		query.append("BB_CGO_FLG                 ," ).append("\n"); 
		query.append("BKG_NO                     ," ).append("\n"); 
		query.append("BL_NO                      ," ).append("\n"); 
		query.append("AWK_CGO_FLG                ," ).append("\n"); 
		query.append("RC_FLG                     ," ).append("\n"); 
		query.append("CNTR_RMK                   ," ).append("\n"); 
		query.append("CRE_USR_ID                 ," ).append("\n"); 
		query.append("CRE_DT                     ," ).append("\n"); 
		query.append("UPD_USR_ID                 ," ).append("\n"); 
		query.append("UPD_DT                     ," ).append("\n"); 
		query.append("LOCL_CRE_DT                 ," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(", @[tml_so_seq]" ).append("\n"); 
		query.append(", @[tml_so_cntr_list_seq]" ).append("\n"); 
		query.append(", @[vrfy_rslt_ind_cd]" ).append("\n"); 
		query.append(", @[dscr_ind_cd]" ).append("\n"); 
		query.append(", @[vsl_cd]" ).append("\n"); 
		query.append(", @[skd_voy_no]" ).append("\n"); 
		query.append(", @[skd_dir_cd]" ).append("\n"); 
		query.append(", @[io_bnd_cd]" ).append("\n"); 
		query.append(", @[cntr_no]" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(", @[cntr_sty_cd]" ).append("\n"); 
		query.append(", @[locl_ts_ind_cd]" ).append("\n"); 
		query.append(", TO_DATE(@[mvmt_gate_in_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(", TO_DATE(@[inv_gate_in_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(", @[gate_in_td_dys]" ).append("\n"); 
		query.append(", TO_DATE(@[mvmt_gate_out_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(", TO_DATE(@[inv_gate_out_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(", @[gate_out_td_dys]" ).append("\n"); 
		query.append(", @[mvmt_stay_dys]" ).append("\n"); 
		query.append(", @[inv_stay_dys]" ).append("\n"); 
		query.append(", @[stay_diff_dys]" ).append("\n"); 
		query.append(", @[dcgo_clss_cd]" ).append("\n"); 
		query.append(", @[bb_cgo_flg]" ).append("\n"); 
		query.append(", @[bkg_no]" ).append("\n"); 
		query.append(", @[bl_no]" ).append("\n"); 
		query.append(", @[awk_cgo_flg]" ).append("\n"); 
		query.append(", @[rc_flg]" ).append("\n"); 
		query.append(", @[cntr_rmk]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}