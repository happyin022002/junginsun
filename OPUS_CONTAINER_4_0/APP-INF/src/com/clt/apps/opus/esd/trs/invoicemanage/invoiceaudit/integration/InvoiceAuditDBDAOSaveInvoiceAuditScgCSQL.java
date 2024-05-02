/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSaveInvoiceAuditScgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.11.02 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
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
		params.put("inv_sto_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd	",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("incur_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insp_rf_pti_cstms_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("inv_otr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_mgst_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_scl_stop_plc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stop_loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_lftg_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("otr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("com_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scl_stop_plc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("fne_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ob_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_incur_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_scg_nod_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wt_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_stop_loc_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_chss_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_insp_rf_pti_cstms_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
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
		query.append(" SCG_DTL_SEQ			," ).append("\n"); 
		query.append(" SCG_AMT				," ).append("\n"); 
		query.append(" DRY_RUN_RLBL_PTY_TP_CD	," ).append("\n"); 
		query.append(" FNE_CUZ_DESC			," ).append("\n"); 
		query.append(" FUMG_COST_TP_CD		," ).append("\n"); 
		query.append(" MGST_TPSZ_CD			," ).append("\n"); 
		query.append(" INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append(" LFTG_KNT				," ).append("\n"); 
		query.append(" LFTG_CUZ_DESC			," ).append("\n"); 
		query.append(" STOP_LOC_NOD_CD		," ).append("\n"); 
		query.append(" GRS_WGT				," ).append("\n"); 
		query.append(" INCRT_DT				," ).append("\n"); 
		query.append(" SCL_STOP_PLC_NOD_CD	," ).append("\n"); 
		query.append(" STO_DYS				," ).append("\n"); 
		query.append(" OB_BKG_NO				," ).append("\n"); 
		query.append(" WT_HRS					," ).append("\n"); 
		query.append(" OTR_RMK				," ).append("\n"); 
		query.append(" INV_SCG_AMT			," ).append("\n"); 
		query.append(" INV_DRY_RUN_RLBL_PTY_TP_CD	," ).append("\n"); 
		query.append(" INV_FNE_CUZ_DESC		," ).append("\n"); 
		query.append(" INV_FUMG_COST_TP_CD	," ).append("\n"); 
		query.append(" INV_MGST_TPSZ_CD		," ).append("\n"); 
		query.append(" INV_INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append(" INV_LFTG_KNT			," ).append("\n"); 
		query.append(" INV_LFTG_CUZ_DESC		," ).append("\n"); 
		query.append(" INV_STOP_LOC_NOD_CD	," ).append("\n"); 
		query.append(" INV_GRS_WGT			," ).append("\n"); 
		query.append(" INV_INCRT_DT			," ).append("\n"); 
		query.append(" INV_SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append(" INV_STO_DYS			," ).append("\n"); 
		query.append(" INV_OB_BKG_NO			," ).append("\n"); 
		query.append(" INV_WT_HRS				," ).append("\n"); 
		query.append(" INV_OTR_RMK			," ).append("\n"); 
		query.append(" N3PTY_BIL_FLG			," ).append("\n"); 
		query.append(" CUST_CNT_CD			," ).append("\n"); 
		query.append(" CUST_SEQ				," ).append("\n"); 
		query.append(" N3PTY_VNDR_SEQ			," ).append("\n"); 
		query.append(" N3PTY_OFC_CD			," ).append("\n"); 
		query.append(" N3PTY_AMT				," ).append("\n"); 
		query.append(" N3PTY_DESC				," ).append("\n"); 
		query.append(" CRE_OFC_CD				," ).append("\n"); 
		query.append(" CRE_USR_ID				," ).append("\n"); 
		query.append(" CRE_DT					," ).append("\n"); 
		query.append(" UPD_USR_ID				," ).append("\n"); 
		query.append(" UPD_DT					," ).append("\n"); 
		query.append(" LOCL_CRE_DT			," ).append("\n"); 
		query.append(" LOCL_UPD_DT			," ).append("\n"); 
		query.append(" CHSS_NO				," ).append("\n"); 
		query.append(" INCUR_DT				," ).append("\n"); 
		query.append(" INV_CHSS_NO			," ).append("\n"); 
		query.append(" INV_INCUR_DT			," ).append("\n"); 
		query.append(" TRSP_AGMT_OFC_CTY_CD	," ).append("\n"); 
		query.append(" TRSP_AGMT_SEQ			," ).append("\n"); 
		query.append(" TRSP_AGMT_RT_TP_SER_NO	," ).append("\n"); 
		query.append(" TRSP_AGMT_SCG_NOD_SEQ	," ).append("\n"); 
		query.append(" TRSP_AGMT_SCG_RT_SEQ	," ).append("\n"); 
		query.append(" COM_SCG_KND_CD			," ).append("\n"); 
		query.append(" COM_SCG_SEQ			," ).append("\n"); 
		query.append(" CURR_CD				," ).append("\n"); 
		query.append(" ORG_SCG_AMT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append(" VALUES	(" ).append("\n"); 
		query.append(" @[trsp_so_ofc_cty_cd]		," ).append("\n"); 
		query.append(" @[trsp_so_seq]				," ).append("\n"); 
		query.append(" @[lgs_cost_cd]				," ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("	SELECT NVL(SUM(SCG_DTL_SEQ),1) SCG_DTL_SEQ " ).append("\n"); 
		query.append("	FROM (	SELECT MAX(SCG_DTL_SEQ)+1 AS SCG_DTL_SEQ" ).append("\n"); 
		query.append("	        FROM TRS_TRSP_SCG_DTL" ).append("\n"); 
		query.append("	        WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	          AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	          AND LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("	     )" ).append("\n"); 
		query.append(" )," ).append("\n"); 
		query.append(" @[scg_amt]					," ).append("\n"); 
		query.append(" @[dry_run_rlbl_pty_tp_cd]	," ).append("\n"); 
		query.append(" @[fne_cuz_desc]			," ).append("\n"); 
		query.append(" @[fumg_cost_tp_cd]			," ).append("\n"); 
		query.append(" @[mgst_tpsz_cd]			," ).append("\n"); 
		query.append(" @[insp_rf_pti_cstms_tp_cd]	," ).append("\n"); 
		query.append(" @[lftg_knt]				," ).append("\n"); 
		query.append(" @[lftg_cuz_desc]			," ).append("\n"); 
		query.append(" @[stop_loc_nod_cd]			," ).append("\n"); 
		query.append(" @[grs_wgt]					," ).append("\n"); 
		query.append(" TO_DATE(SUBSTR(@[incrt_dt],1,8), 'YYYYMMDD')," ).append("\n"); 
		query.append(" @[scl_stop_plc_nod_cd]		," ).append("\n"); 
		query.append(" @[sto_dys]					," ).append("\n"); 
		query.append(" @[ob_bkg_no]				," ).append("\n"); 
		query.append(" @[wt_hrs]					," ).append("\n"); 
		query.append(" @[otr_rmk]					," ).append("\n"); 
		query.append(" @[inv_scg_amt]				," ).append("\n"); 
		query.append(" @[inv_dry_run_rlbl_pty_tp_cd]		," ).append("\n"); 
		query.append(" @[inv_fne_cuz_desc]		," ).append("\n"); 
		query.append(" @[inv_fumg_cost_tp_cd]		," ).append("\n"); 
		query.append(" @[inv_mgst_tpsz_cd]		," ).append("\n"); 
		query.append(" @[inv_insp_rf_pti_cstms_tp_cd]	," ).append("\n"); 
		query.append(" @[inv_lftg_knt]			," ).append("\n"); 
		query.append(" @[inv_lftg_cuz_desc]		," ).append("\n"); 
		query.append(" @[inv_stop_loc_nod_cd]		," ).append("\n"); 
		query.append(" @[inv_grs_wgt]				," ).append("\n"); 
		query.append(" TO_DATE(@[inv_incrt_dt], 'YYYYMMDD')	," ).append("\n"); 
		query.append(" @[inv_scl_stop_plc_nod_cd]	," ).append("\n"); 
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
		query.append(" SYSDATE					," ).append("\n"); 
		query.append(" @[FORM_CRE_USR_ID]			," ).append("\n"); 
		query.append(" SYSDATE					," ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])," ).append("\n"); 
		query.append(" GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FORM_USR_OFC_CD])," ).append("\n"); 
		query.append(" @[chss_no]					," ).append("\n"); 
		query.append(" TO_DATE(@[incur_dt], 'YYYYMMDD')	," ).append("\n"); 
		query.append(" @[inv_chss_no]				," ).append("\n"); 
		query.append(" TO_DATE(@[inv_incur_dt], 'YYYYMMDD')	," ).append("\n"); 
		query.append(" @[trsp_agmt_ofc_cty_cd	]	," ).append("\n"); 
		query.append(" @[trsp_agmt_seq]			," ).append("\n"); 
		query.append(" @[trsp_agmt_rt_tp_ser_no]	," ).append("\n"); 
		query.append(" @[trsp_agmt_scg_nod_seq]	," ).append("\n"); 
		query.append(" @[trsp_agmt_scg_rt_seq]	," ).append("\n"); 
		query.append(" @[com_scg_knd_cd]			," ).append("\n"); 
		query.append(" @[com_scg_seq]				," ).append("\n"); 
		query.append(" @[curr_cd]					," ).append("\n"); 
		query.append(" @[org_scg_amt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}