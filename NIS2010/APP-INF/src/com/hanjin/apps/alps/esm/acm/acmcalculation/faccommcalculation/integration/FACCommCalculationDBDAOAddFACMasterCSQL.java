/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOAddFACMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOAddFACMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOAddFACMasterCSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOAddFACMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dry_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dry_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_bkg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rf_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_spcl_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_dry_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_bx_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_spcl_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_bx_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_rt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_rt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rf_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_rf_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rf_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_dry_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd_chg_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fac_spcl_cntr_tp_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_spcl_cntr_tp_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fac_bkg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_spcl_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOAddFACMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FAC_COMM" ).append("\n"); 
		query.append("SELECT @[bkg_no], -- BKG_NO" ).append("\n"); 
		query.append("  CASE WHEN @[ppd_ofc_cd_chg_yn] = 'Y' THEN NVL(@[chg_ppd_ofc_cd], 'HAMSC')" ).append("\n"); 
		query.append("       ELSE NVL(@[ppd_ofc_cd], 'HAMSC')" ).append("\n"); 
		query.append("  END AS SLS_OFC_CD," ).append("\n"); 
		query.append("  @[fac_seq] FAC_SEQ," ).append("\n"); 
		query.append("  'CS' FAC_STS_CD," ).append("\n"); 
		query.append("  NVL((SELECT ROUND(NVL(CRNT_AMT, 0), 2)" ).append("\n"); 
		query.append("       FROM ACM_FAC_COMM" ).append("\n"); 
		query.append("       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	     AND FAC_SEQ = @[fac_seq] - 1" ).append("\n"); 
		query.append("      ), 0" ).append("\n"); 
		query.append("  ) AS PPD_AMT," ).append("\n"); 
		query.append("  @[crnt_amt] CRNT_AMT," ).append("\n"); 
		query.append("  (@[crnt_amt] - NVL((SELECT ROUND(NVL(CRNT_AMT, 0), 2)" ).append("\n"); 
		query.append("                      FROM ACM_FAC_COMM" ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	                    AND FAC_SEQ = @[fac_seq] - 1" ).append("\n"); 
		query.append("                     ), 0" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("  ) AS IF_AMT," ).append("\n"); 
		query.append("  TO_DATE(@[vps_etd_dt], 'yyyyMMddHH24miss') VSL_DEP_DT," ).append("\n"); 
		query.append("  @[loc_div_cd] LOC_DIV_CD," ).append("\n"); 
		query.append("  @[loc_cd] LOC_CD," ).append("\n"); 
		query.append("  CASE WHEN @[ppd_ofc_cd_chg_yn] = 'Y' THEN @[chg_ar_ofc_cd]" ).append("\n"); 
		query.append("       ELSE @[bkg_ar_ofc_cd]" ).append("\n"); 
		query.append("  END AS AR_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN @[ppd_ofc_cd_chg_yn] = 'Y' THEN @[chg_ap_ofc_cd]" ).append("\n"); 
		query.append("       ELSE @[ap_ofc_cd]" ).append("\n"); 
		query.append("  END AS AP_OFC_CD," ).append("\n"); 
		query.append("  @[ap_ctr_cd] AP_CTR_CD," ).append("\n"); 
		query.append("  '512641' COMM_STND_COST_CD," ).append("\n"); 
		query.append("  @[por_cd] FAC_OCCR_INFO_CD," ).append("\n"); 
		query.append("  @[slan_cd] FAC_SLAN_CD," ).append("\n"); 
		query.append("  @[rlane_cd] FAC_RLANE_CD," ).append("\n"); 
		query.append("  @[vsl_cd] FAC_VSL_CD," ).append("\n"); 
		query.append("  @[skd_voy_no] FAC_SKD_VOY_NO," ).append("\n"); 
		query.append("  @[skd_dir_cd] FAC_SKD_DIR_CD," ).append("\n"); 
		query.append("  @[rlane_dir_cd] FAC_REV_DIR_CD," ).append("\n"); 
		query.append("  @[bkg_ff_cnt_cd] BKG_FF_CNT_CD," ).append("\n"); 
		query.append("  @[bkg_ff_seq] BKG_FF_SEQ," ).append("\n"); 
		query.append("  @[vndr_cnt_cd] VNDR_CNT_CD," ).append("\n"); 
		query.append("  NVL(@[vndr_seq], 0) VNDR_SEQ," ).append("\n"); 
		query.append("  @[fac_div_cd] FAC_DIV_CD," ).append("\n"); 
		query.append("  @[fac_spcl_cntr_tp_ctnt1] FAC_SPCL_CNTR_TP_CTNT1," ).append("\n"); 
		query.append("  @[fac_spcl_cntr_rt1] FAC_SPCL_CNTR_RT1," ).append("\n"); 
		query.append("  @[fac_spcl_cntr_tp_ctnt2] FAC_SPCL_CNTR_TP_CTNT2," ).append("\n"); 
		query.append("  @[fac_spcl_cntr_rt2] FAC_SPCL_CNTR_RT2," ).append("\n"); 
		query.append("  @[fac_bkg_rt] FAC_BKG_RT," ).append("\n"); 
		query.append("  @[fac_bkg_amt] FAC_BKG_AMT," ).append("\n"); 
		query.append("  @[bkg_bx_qty] BKG_BX_QTY," ).append("\n"); 
		query.append("  @[fac_bx_amt] FAC_BX_AMT," ).append("\n"); 
		query.append("  @[bkg_dry_teu_qty] BKG_DRY_TEU_QTY," ).append("\n"); 
		query.append("  @[fac_dry_teu_amt] FAC_DRY_TEU_AMT," ).append("\n"); 
		query.append("  @[bkg_dry_feu_qty] BKG_DRY_FEU_QTY," ).append("\n"); 
		query.append("  @[fac_dry_feu_amt] FAC_DRY_FEU_AMT," ).append("\n"); 
		query.append("  @[bkg_rf_teu_qty] BKG_RF_TEU_QTY," ).append("\n"); 
		query.append("  @[fac_rf_teu_amt] FAC_RF_TEU_AMT," ).append("\n"); 
		query.append("  @[bkg_rf_feu_qty] BKG_RF_FEU_QTY," ).append("\n"); 
		query.append("  @[fac_rf_feu_amt] FAC_RF_FEU_AMT," ).append("\n"); 
		query.append("  @[bkg_spcl_teu_qty] BKG_SPCL_TEU_QTY," ).append("\n"); 
		query.append("  @[fac_spcl_teu_amt] FAC_SPCL_TEU_AMT," ).append("\n"); 
		query.append("  @[bkg_spcl_feu_qty] BKG_SPCL_FEU_QTY," ).append("\n"); 
		query.append("  @[fac_spcl_feu_amt] FAC_SPCL_FEU_AMT," ).append("\n"); 
		query.append("  @[fac_chg_ctnt] FAC_CHG_CTNT," ).append("\n"); 
		query.append("  @[curr_cd] CURR_CD," ).append("\n"); 
		query.append("  0 MON_XCH_RT," ).append("\n"); 
		query.append("  NVL((SELECT ROUND(NVL(CRNT_AMT, 0), 2)" ).append("\n"); 
		query.append("       FROM ACM_FAC_COMM" ).append("\n"); 
		query.append("       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	     AND FAC_SEQ = @[fac_seq] - 1" ).append("\n"); 
		query.append("      ), 0" ).append("\n"); 
		query.append("  ) AS PAY_PPD_AMT," ).append("\n"); 
		query.append("  @[crnt_amt] PAY_CRNT_AMT," ).append("\n"); 
		query.append("  (@[crnt_amt] - NVL((SELECT ROUND(NVL(CRNT_AMT, 0), 2)" ).append("\n"); 
		query.append("                      FROM ACM_FAC_COMM" ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	                    AND FAC_SEQ = @[fac_seq] - 1" ).append("\n"); 
		query.append("                     ), 0" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("  ) AS PAY_IF_AMT," ).append("\n"); 
		query.append("  @[cmdt_tp_cd] CMDT_TP_CD," ).append("\n"); 
		query.append("  @[cmdt_cd] CMDT_CD," ).append("\n"); 
		query.append("  (SELECT OFC_CHR_CD FROM ACM_OFC_INFO WHERE AGN_CD = @[fac_ofc_cd] AND ROWNUM = 1) AS OFC_CHR_CD," ).append("\n"); 
		query.append("  'Y' ACCL_FLG," ).append("\n"); 
		query.append("  @[inv_tax_rt] INV_TAX_RT," ).append("\n"); 
		query.append("  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', SYSDATE, 'GMT'), 'YYYYMMDD') AS GL_DT," ).append("\n"); 
		query.append("  @[csr_no] CSR_NO," ).append("\n"); 
		query.append("  @[apro_usr_id] APRO_USR_ID," ).append("\n"); 
		query.append("  TO_DATE(@[apro_dt], 'YYYYMMDDHH24MISS') APRO_DT," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', TO_DATE(@[apro_dt], 'YYYYMMDDHH24MISS'), 'GMT') APRO_GDT," ).append("\n"); 
		query.append("  @[if_usr_id] IF_USR_ID," ).append("\n"); 
		query.append("  TO_DATE(@[if_dt], 'YYYYMMDDHH24MISS') IF_DT," ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELHO', TO_DATE(@[if_dt], 'YYYYMMDDHH24MISS'), 'GMT') IF_GDT," ).append("\n"); 
		query.append("  @[fac_ofc_cd] FAC_OFC_CD," ).append("\n"); 
		query.append("  @[ff_cnt_cd] FF_CNT_CD," ).append("\n"); 
		query.append("  @[ff_cust_seq] FF_SEQ," ).append("\n"); 
		query.append("  @[fac_agmt_seq] FAC_AGMT_SEQ," ).append("\n"); 
		query.append("  'Calculation Success!' FAC_RMK," ).append("\n"); 
		query.append("  @[user_id] CRE_USR_ID," ).append("\n"); 
		query.append("  SYSDATE CRE_DT," ).append("\n"); 
		query.append("  @[user_id] UPD_USR_ID," ).append("\n"); 
		query.append("  SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}