/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrder Surcharge 조회
	  * </pre>
	  */
	public InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration").append("\n"); 
		query.append("FileName : InvoiceSurchargeDBDAOsearchWorkOrderSurchargeInquiryRSQL").append("\n"); 
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
		query.append("SELECT a.lgs_cost_cd," ).append("\n"); 
		query.append("(select lgs_cost_full_nm from tes_lgs_cost where lgs_cost_cd = a.lgs_cost_cd) lgs_cost_nm," ).append("\n"); 
		query.append("NVL(a.scg_amt,'0') scg_amt," ).append("\n"); 
		query.append("DECODE(SUBSTR(a.lgs_cost_cd,3,LENGTH(lgs_cost_cd)-1)," ).append("\n"); 
		query.append("'ALAL', '', 	--Additional Labor" ).append("\n"); 
		query.append("'LWAL', '', 	--Barge low water surcharge" ).append("\n"); 
		query.append("'CHAL', '',--(select chss_tpsz_desc from chs_chss_tp_sz where chss_tpsz_cd = a.chss_mgst_tpsz_cd), 	--CHZ Usage" ).append("\n"); 
		query.append("'DPAL', '', 	--Drop & Pull (Drop & Pickup)" ).append("\n"); 
		query.append("'DRAL', (select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00820' and intg_cd_val_ctnt = a.dry_run_rlbl_pty_tp_cd), 	--Dry Run" ).append("\n"); 
		query.append("'FRAL', '', 	--Ferry Cost" ).append("\n"); 
		query.append("'FIAL', a.fne_cuz_desc, 	--Fine" ).append("\n"); 
		query.append("'FGAL', (select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00821' and intg_cd_val_ctnt = a.fumg_cost_tp_cd), 	--Fumigation" ).append("\n"); 
		query.append("'GNAL', '', --(select mgst_tp_nm from mgs_mgst_tp_sz where mgst_tp_cd = a.mgst_tpsz_cd), 	--Gen-set" ).append("\n"); 
		query.append("'HZAL', '', 	--HAZMAT" ).append("\n"); 
		query.append("'INAL', (select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00822' and intg_cd_val_ctnt = a.insp_rf_pti_cstms_tp_cd), 	--Inspection" ).append("\n"); 
		query.append("'LFAL', a.lftg_knt || ',' || a.lftg_cuz_desc, 	--Lifting Charge" ).append("\n"); 
		query.append("'MDAL', (select yd_nm from mdm_yard where yd_cd = a.stop_loc_nod_cd), 	--Multistop Delivery" ).append("\n"); 
		query.append("'OSAL', '', 	--Over Size" ).append("\n"); 
		query.append("'OWAL', a.grs_wgt, 	--Over Weight" ).append("\n"); 
		query.append("'PPAL', a.incrt_dt, 	--Pre-Pull" ).append("\n"); 
		query.append("'RCAL', '', 	--Redirection Charge" ).append("\n"); 
		query.append("'SSAL', (select yd_nm from mdm_yard where yd_cd = a.scl_stop_plc_nod_cd), 	--Scale Stop" ).append("\n"); 
		query.append("'SRAL', a.sto_dys, 	--Storage" ).append("\n"); 
		query.append("'STAL', a.ob_bkg_no, 	--Street Turn" ).append("\n"); 
		query.append("'SNAL', '', 	--Sunday Running" ).append("\n"); 
		query.append("'SFAL', '', 	--Swing/Flip" ).append("\n"); 
		query.append("'TDAL', '', 	--T-DOC Fee" ).append("\n"); 
		query.append("'TLAL', '', 	--Toll" ).append("\n"); 
		query.append("'WTAL', a.wt_hrs, 	--Waiting Charge" ).append("\n"); 
		query.append("'OTAL', a.otr_rmk, 	--Other Surcharge" ).append("\n"); 
		query.append("'FUWD', ''," ).append("\n"); 
		query.append("'FURD', ''," ).append("\n"); 
		query.append("'FUTD', ''," ).append("\n"); 
		query.append("'FUWR', ''," ).append("\n"); 
		query.append("'FURT', ''," ).append("\n"); 
		query.append("'CDAL', a.CHSS_NO || ',' || TO_CHAR(a.INCUR_DT, 'YYYYMMDD') 	--Chassis Drayage" ).append("\n"); 
		query.append(") scg_opt" ).append("\n"); 
		query.append("FROM trs_trsp_scg_dtl a" ).append("\n"); 
		query.append("WHERE a.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND a.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 

	}
}