/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SupplementSOManageDBDAOInsertSurchargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.03.12 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAOInsertSurchargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * surcharge 정보 인서트
	  * </pre>
	  */
	public SupplementSOManageDBDAOInsertSurchargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_fne_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("INV_INCUR_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_CHSS_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ob_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_mgst_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INCUR_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lftg_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stop_loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sto_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_wt_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_incrt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_stop_loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insp_rf_pti_cstms_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_fumg_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dry_run_rlbl_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sto_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_insp_rf_pti_cstms_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lftg_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CHSS_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_scl_stop_plc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fne_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lftg_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("otr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("incrt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lftg_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_otr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dry_run_rlbl_pty_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scl_stop_plc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wt_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAOInsertSurchargeCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO TRS_TRSP_SCG_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("SCG_AMT," ).append("\n"); 
		query.append("DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("FNE_CUZ_DESC," ).append("\n"); 
		query.append("FUMG_COST_TP_CD," ).append("\n"); 
		query.append("MGST_TPSZ_CD," ).append("\n"); 
		query.append("INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("LFTG_KNT," ).append("\n"); 
		query.append("LFTG_CUZ_DESC," ).append("\n"); 
		query.append("STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("GRS_WGT," ).append("\n"); 
		query.append("INCRT_DT," ).append("\n"); 
		query.append("SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("STO_DYS," ).append("\n"); 
		query.append("OB_BKG_NO," ).append("\n"); 
		query.append("WT_HRS," ).append("\n"); 
		query.append("OTR_RMK," ).append("\n"); 
		query.append("INV_SCG_AMT," ).append("\n"); 
		query.append("INV_DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("INV_FNE_CUZ_DESC," ).append("\n"); 
		query.append("INV_FUMG_COST_TP_CD," ).append("\n"); 
		query.append("INV_MGST_TPSZ_CD," ).append("\n"); 
		query.append("INV_INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("INV_LFTG_KNT," ).append("\n"); 
		query.append("INV_LFTG_CUZ_DESC," ).append("\n"); 
		query.append("INV_STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("INV_GRS_WGT," ).append("\n"); 
		query.append("INV_INCRT_DT," ).append("\n"); 
		query.append("INV_SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("INV_STO_DYS," ).append("\n"); 
		query.append("INV_OB_BKG_NO," ).append("\n"); 
		query.append("INV_WT_HRS," ).append("\n"); 
		query.append("INV_OTR_RMK," ).append("\n"); 
		query.append("N3PTY_BIL_FLG," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("N3PTY_OFC_CD," ).append("\n"); 
		query.append("N3PTY_AMT," ).append("\n"); 
		query.append("N3PTY_DESC," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT," ).append("\n"); 
		query.append("INCUR_DT," ).append("\n"); 
		query.append("CHSS_NO," ).append("\n"); 
		query.append("INV_INCUR_DT," ).append("\n"); 
		query.append("INV_CHSS_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_so_seq]," ).append("\n"); 
		query.append("@[lgs_cost_cd]," ).append("\n"); 
		query.append("@[scg_amt]," ).append("\n"); 
		query.append("@[dry_run_rlbl_pty_tp_cd]," ).append("\n"); 
		query.append("@[fne_cuz_desc]," ).append("\n"); 
		query.append("@[fumg_cost_tp_cd]," ).append("\n"); 
		query.append("@[mgst_tpsz_cd]," ).append("\n"); 
		query.append("@[insp_rf_pti_cstms_tp_cd]," ).append("\n"); 
		query.append("@[lftg_knt]," ).append("\n"); 
		query.append("@[lftg_cuz_desc]," ).append("\n"); 
		query.append("@[stop_loc_nod_cd]," ).append("\n"); 
		query.append("@[grs_wgt]," ).append("\n"); 
		query.append("TO_DATE(@[incrt_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("@[scl_stop_plc_nod_cd]," ).append("\n"); 
		query.append("@[sto_dys]," ).append("\n"); 
		query.append("@[ob_bkg_no]," ).append("\n"); 
		query.append("@[wt_hrs]," ).append("\n"); 
		query.append("@[otr_rmk]," ).append("\n"); 
		query.append("@[inv_scg_amt]," ).append("\n"); 
		query.append("@[inv_dry_run_rlbl_pty_tp_cd]," ).append("\n"); 
		query.append("@[inv_fne_cuz_desc]," ).append("\n"); 
		query.append("@[inv_fumg_cost_tp_cd]," ).append("\n"); 
		query.append("@[inv_mgst_tpsz_cd]," ).append("\n"); 
		query.append("@[inv_insp_rf_pti_cstms_tp_cd]," ).append("\n"); 
		query.append("@[inv_lftg_knt]," ).append("\n"); 
		query.append("@[inv_lftg_cuz_desc]," ).append("\n"); 
		query.append("@[inv_stop_loc_nod_cd]," ).append("\n"); 
		query.append("@[inv_grs_wgt]," ).append("\n"); 
		query.append("TO_DATE(@[inv_incrt_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append("@[inv_scl_stop_plc_nod_cd]," ).append("\n"); 
		query.append("@[inv_sto_dys]," ).append("\n"); 
		query.append("@[inv_ob_bkg_no]," ).append("\n"); 
		query.append("@[inv_wt_hrs]," ).append("\n"); 
		query.append("@[inv_otr_rmk]," ).append("\n"); 
		query.append("@[n3pty_bil_flg]," ).append("\n"); 
		query.append("@[cust_cnt_cd]," ).append("\n"); 
		query.append("@[cust_seq]," ).append("\n"); 
		query.append("@[n3pty_vndr_seq]," ).append("\n"); 
		query.append("@[n3pty_ofc_cd]," ).append("\n"); 
		query.append("@[n3pty_amt]," ).append("\n"); 
		query.append("@[n3pty_desc]," ).append("\n"); 
		query.append("@[cre_ofc_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("TO_DATE(@[INCUR_DT], 'YYYYMMDD')			," ).append("\n"); 
		query.append("@[CHSS_NO]," ).append("\n"); 
		query.append("TO_DATE(@[INV_INCUR_DT], 'YYYYMMDD')			," ).append("\n"); 
		query.append("@[INV_CHSS_NO]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}