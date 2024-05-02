/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2010.03.18 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Invoice Surcharge Inquiry
	  * </pre>
	  */
	public InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.integration").append("\n"); 
		query.append("FileName : InvoiceSurchargeDBDAOsearchInvoiceSurchargeInquiryRSQL").append("\n"); 
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
		query.append("NVL(a.inv_scg_amt,'0') scg_amt," ).append("\n"); 
		query.append("DECODE(SUBSTR(a.lgs_cost_cd,3,LENGTH(lgs_cost_cd)-1)," ).append("\n"); 
		query.append("'ALAL', '', 	--Additional Labor" ).append("\n"); 
		query.append("'LWAL', '', 	--Barge low water surcharge" ).append("\n"); 
		query.append("'CHAL', '',--(select chss_tpsz_desc from chs_chss_tp_sz where chss_tpsz_cd = a.inv_chss_mgst_tpsz_cd), 	//CHZ Usage" ).append("\n"); 
		query.append("'DPAL', '', 	--Drop & Pull (Drop & Pickup)" ).append("\n"); 
		query.append("'DRAL', (select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00820' and intg_cd_val_ctnt = a.inv_dry_run_rlbl_pty_tp_cd), 	--Dry Run" ).append("\n"); 
		query.append("'FRAL', '', 	--Ferry Cost" ).append("\n"); 
		query.append("'FIAL', a.inv_fne_cuz_desc, 	--Fine" ).append("\n"); 
		query.append("'FGAL', (select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00821' and intg_cd_val_ctnt = a.inv_fumg_cost_tp_cd), 	--Fumigation" ).append("\n"); 
		query.append("'GNAL', '',--(select mgst_tp_nm from mgs_mgst_tp_sz where mgst_tp_cd = a.inv_mgst_tpsz_cd), 	//Gen-set" ).append("\n"); 
		query.append("'HZAL', '', 	--HAZMAT" ).append("\n"); 
		query.append("'INAL', (select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00822' and intg_cd_val_ctnt = a.inv_insp_rf_pti_cstms_tp_cd), --Inspection" ).append("\n"); 
		query.append("'LFAL', a.inv_lftg_knt || ',' || a.inv_lftg_cuz_desc, 	--Lifting Charge" ).append("\n"); 
		query.append("'MDAL', (select yd_nm from mdm_yard where yd_cd = a.inv_stop_loc_nod_cd), 	--Multistop Delivery" ).append("\n"); 
		query.append("'OSAL', '', 	--Over Size" ).append("\n"); 
		query.append("'OWAL', a.inv_grs_wgt, 	--Over Weight" ).append("\n"); 
		query.append("'PPAL', a.inv_incrt_dt, 	--Pre-Pull" ).append("\n"); 
		query.append("'RCAL', '', 	--Redirection Charge" ).append("\n"); 
		query.append("'SSAL', (select yd_nm from mdm_yard where yd_cd = a.inv_scl_stop_plc_nod_cd), 	--Scale Stop" ).append("\n"); 
		query.append("'SRAL', a.inv_sto_dys, 	--Storage" ).append("\n"); 
		query.append("'STAL', a.inv_ob_bkg_no, 	--Street Turn" ).append("\n"); 
		query.append("'SNAL', '', 	--Sunday Running" ).append("\n"); 
		query.append("'SFAL', '', 	--Swing/Flip" ).append("\n"); 
		query.append("'TDAL', '', 	--T-DOC Fee" ).append("\n"); 
		query.append("'TLAL', '', 	--Toll" ).append("\n"); 
		query.append("'WTAL', a.inv_wt_hrs, 	--Waiting Charge" ).append("\n"); 
		query.append("'OTAL', a.inv_otr_rmk, 	--Other Surcharge" ).append("\n"); 
		query.append("'FUWD', '', --Fuel Surcharge ? WD" ).append("\n"); 
		query.append("'FURD', '', --Fuel Surcharge ? RD" ).append("\n"); 
		query.append("'FUTD', '', --Fuel Surcharge ? TD" ).append("\n"); 
		query.append("'FUWR', '', --Fuel Surcharge ? WR" ).append("\n"); 
		query.append("'FURT', '', --Fuel Surcharge ? RT" ).append("\n"); 
		query.append("'CDAL',  a.INV_CHSS_NO || ',' || TO_CHAR(a.INV_INCUR_DT, 'YYYYMMDD') --Chassis Drayage" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") inv_scg_opt" ).append("\n"); 
		query.append("FROM trs_trsp_scg_dtl a" ).append("\n"); 
		query.append("WHERE a.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND a.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 

	}
}