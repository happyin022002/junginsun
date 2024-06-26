/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.04.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge 정보 입력
	  * </pre>
	  */
	public InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_rf_mgst_usg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_fne_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("incur_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ovr_wgt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("inv_incur_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_axl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_grs_wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_hndl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tri_axl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_stop_loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insp_rf_pti_cstms_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_otr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("inv_rf_hndl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("inv_ovr_wgt_otr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_grs_wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("rf_mgst_usg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_prmt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_chss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_ovr_wgt_prmt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scl_stop_plc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wt_hrs",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SCG_DTL	(" ).append("\n"); 
		query.append(" TRSP_SO_OFC_CTY_CD		," ).append("\n"); 
		query.append(" TRSP_SO_SEQ			," ).append("\n"); 
		query.append(" LGS_COST_CD			," ).append("\n"); 
		query.append(" SCG_AMT			," ).append("\n"); 
		query.append(" DRY_RUN_RLBL_PTY_TP_CD		," ).append("\n"); 
		query.append(" FNE_CUZ_DESC			," ).append("\n"); 
		query.append(" FUMG_COST_TP_CD		," ).append("\n"); 
		query.append(" MGST_TPSZ_CD			," ).append("\n"); 
		query.append(" INSP_RF_PTI_CSTMS_TP_CD	," ).append("\n"); 
		query.append(" LFTG_KNT			," ).append("\n"); 
		query.append(" LFTG_CUZ_DESC			," ).append("\n"); 
		query.append(" STOP_LOC_NOD_CD		," ).append("\n"); 
		query.append(" GRS_WGT			," ).append("\n"); 
		query.append(" INCRT_DT			," ).append("\n"); 
		query.append(" SCL_STOP_PLC_NOD_CD		," ).append("\n"); 
		query.append(" STO_DYS			," ).append("\n"); 
		query.append(" OB_BKG_NO			," ).append("\n"); 
		query.append(" WT_HRS				," ).append("\n"); 
		query.append(" OTR_RMK			," ).append("\n"); 
		query.append(" INV_SCG_AMT			," ).append("\n"); 
		query.append(" INV_DRY_RUN_RLBL_PTY_TP_CD	," ).append("\n"); 
		query.append(" INV_FNE_CUZ_DESC		," ).append("\n"); 
		query.append(" INV_FUMG_COST_TP_CD		," ).append("\n"); 
		query.append(" INV_MGST_TPSZ_CD		," ).append("\n"); 
		query.append(" INV_INSP_RF_PTI_CSTMS_TP_CD	," ).append("\n"); 
		query.append(" INV_LFTG_KNT			," ).append("\n"); 
		query.append(" INV_LFTG_CUZ_DESC		," ).append("\n"); 
		query.append(" INV_STOP_LOC_NOD_CD		," ).append("\n"); 
		query.append(" INV_GRS_WGT			," ).append("\n"); 
		query.append(" INV_INCRT_DT			," ).append("\n"); 
		query.append(" INV_SCL_STOP_PLC_NOD_CD	," ).append("\n"); 
		query.append(" INV_STO_DYS			," ).append("\n"); 
		query.append(" INV_OB_BKG_NO			," ).append("\n"); 
		query.append(" INV_WT_HRS			," ).append("\n"); 
		query.append(" INV_OTR_RMK			," ).append("\n"); 
		query.append(" N3PTY_BIL_FLG			," ).append("\n"); 
		query.append(" CUST_CNT_CD			," ).append("\n"); 
		query.append(" CUST_SEQ			," ).append("\n"); 
		query.append(" N3PTY_VNDR_SEQ			," ).append("\n"); 
		query.append(" N3PTY_OFC_CD			," ).append("\n"); 
		query.append(" N3PTY_AMT			," ).append("\n"); 
		query.append(" N3PTY_DESC			," ).append("\n"); 
		query.append(" CRE_OFC_CD			," ).append("\n"); 
		query.append(" CRE_USR_ID			," ).append("\n"); 
		query.append(" CRE_DT				," ).append("\n"); 
		query.append(" UPD_USR_ID			," ).append("\n"); 
		query.append(" UPD_DT				," ).append("\n"); 
		query.append(" LOCL_CRE_DT			," ).append("\n"); 
		query.append(" LOCL_UPD_DT			," ).append("\n"); 
		query.append(" CHSS_NO			," ).append("\n"); 
		query.append(" INCUR_DT			," ).append("\n"); 
		query.append(" INV_CHSS_NO		," ).append("\n"); 
		query.append(" INV_INCUR_DT		," ).append("\n"); 
		query.append(" WO_GRS_WGT_MEAS_UT_CD	," ).append("\n"); 
		query.append(" INV_GRS_WGT_MEAS_UT_CD," ).append("\n"); 
		query.append(" RF_HNDL_FLG," ).append("\n"); 
		query.append(" RF_MGST_USG_FLG," ).append("\n"); 
		query.append(" TRI_AXL_FLG," ).append("\n"); 
		query.append(" OVR_WGT_PRMT_FLG," ).append("\n"); 
		query.append(" OVR_WGT_OTR_FLG," ).append("\n"); 
		query.append(" OVR_WGT_RMK," ).append("\n"); 
		query.append(" INV_RF_HNDL_FLG," ).append("\n"); 
		query.append(" INV_RF_MGST_USG_FLG," ).append("\n"); 
		query.append(" INV_TRI_AXL_FLG," ).append("\n"); 
		query.append(" INV_OVR_WGT_PRMT_FLG," ).append("\n"); 
		query.append(" INV_OVR_WGT_OTR_FLG," ).append("\n"); 
		query.append(" INV_OVR_WGT_RMK" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" VALUES	(" ).append("\n"); 
		query.append(" @[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append(" @[trsp_so_seq]," ).append("\n"); 
		query.append(" @[lgs_cost_cd]				," ).append("\n"); 
		query.append(" @[scg_amt]				," ).append("\n"); 
		query.append(" @[dry_run_rlbl_pty_tp_cd]		," ).append("\n"); 
		query.append(" @[fne_cuz_desc]			," ).append("\n"); 
		query.append(" @[fumg_cost_tp_cd]			," ).append("\n"); 
		query.append(" @[mgst_tpsz_cd]			," ).append("\n"); 
		query.append(" @[insp_rf_pti_cstms_tp_cd]		," ).append("\n"); 
		query.append(" @[lftg_knt]				," ).append("\n"); 
		query.append(" @[lftg_cuz_desc]			," ).append("\n"); 
		query.append(" @[stop_loc_nod_cd]			," ).append("\n"); 
		query.append(" @[grs_wgt]				," ).append("\n"); 
		query.append(" TO_DATE(SUBSTR(@[incrt_dt],1,8), 'YYYYMMDD')," ).append("\n"); 
		query.append(" @[scl_stop_plc_nod_cd]			," ).append("\n"); 
		query.append(" @[sto_dys]				," ).append("\n"); 
		query.append(" @[ob_bkg_no]				," ).append("\n"); 
		query.append(" @[wt_hrs]				," ).append("\n"); 
		query.append(" @[otr_rmk]				," ).append("\n"); 
		query.append(" @[inv_scg_amt]				," ).append("\n"); 
		query.append(" @[inv_dry_run_rlbl_pty_tp_cd]		," ).append("\n"); 
		query.append(" @[inv_fne_cuz_desc]			," ).append("\n"); 
		query.append(" @[inv_fumg_cost_tp_cd]			," ).append("\n"); 
		query.append(" @[inv_mgst_tpsz_cd]			," ).append("\n"); 
		query.append(" @[inv_insp_rf_pti_cstms_tp_cd]		," ).append("\n"); 
		query.append(" @[inv_lftg_knt]			," ).append("\n"); 
		query.append(" @[inv_lftg_cuz_desc]			," ).append("\n"); 
		query.append(" @[inv_stop_loc_nod_cd]			," ).append("\n"); 
		query.append(" @[inv_grs_wgt]				," ).append("\n"); 
		query.append(" TO_DATE(@[inv_incrt_dt], 'YYYYMMDD')	," ).append("\n"); 
		query.append(" @[inv_scl_stop_plc_nod_cd]		," ).append("\n"); 
		query.append(" @[inv_sto_dys]				," ).append("\n"); 
		query.append(" @[inv_ob_bkg_no]			," ).append("\n"); 
		query.append(" @[inv_wt_hrs]				," ).append("\n"); 
		query.append(" @[inv_otr_rmk]				," ).append("\n"); 
		query.append(" @[n3pty_bil_flg]			," ).append("\n"); 
		query.append(" @[cust_cnt_cd]				," ).append("\n"); 
		query.append(" @[cust_seq]				," ).append("\n"); 
		query.append(" @[n3pty_vndr_seq]			," ).append("\n"); 
		query.append(" @[n3pty_ofc_cd]			," ).append("\n"); 
		query.append(" @[n3pty_amt]				," ).append("\n"); 
		query.append(" @[n3pty_desc]				," ).append("\n"); 
		query.append(" @[FORM_USR_OFC_CD]			," ).append("\n"); 
		query.append(" @[FORM_CRE_USR_ID]			," ).append("\n"); 
		query.append(" SYSDATE				," ).append("\n"); 
		query.append(" @[FORM_CRE_USR_ID]			," ).append("\n"); 
		query.append(" SYSDATE				," ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])," ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])," ).append("\n"); 
		query.append(" @[chss_no]			," ).append("\n"); 
		query.append(" TO_DATE(@[incur_dt], 'YYYYMMDD')		," ).append("\n"); 
		query.append(" @[inv_chss_no]			," ).append("\n"); 
		query.append(" TO_DATE(@[inv_incur_dt], 'YYYYMMDD')," ).append("\n"); 
		query.append(" DECODE(@[grs_wgt], NULL, NULL, @[wo_grs_wgt_meas_ut_cd])," ).append("\n"); 
		query.append(" DECODE(@[inv_grs_wgt], NULL, NULL, @[inv_grs_wgt_meas_ut_cd])," ).append("\n"); 
		query.append(" @[rf_hndl_flg]," ).append("\n"); 
		query.append(" @[rf_mgst_usg_flg]," ).append("\n"); 
		query.append(" @[tri_axl_flg]," ).append("\n"); 
		query.append(" @[ovr_wgt_prmt_flg]," ).append("\n"); 
		query.append(" @[ovr_wgt_otr_flg]," ).append("\n"); 
		query.append(" @[ovr_wgt_rmk]," ).append("\n"); 
		query.append(" @[inv_rf_hndl_flg]," ).append("\n"); 
		query.append(" @[inv_rf_mgst_usg_flg]," ).append("\n"); 
		query.append(" @[inv_tri_axl_flg]," ).append("\n"); 
		query.append(" @[inv_ovr_wgt_prmt_flg]," ).append("\n"); 
		query.append(" @[inv_ovr_wgt_otr_flg]," ).append("\n"); 
		query.append(" @[inv_ovr_wgt_rmk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}