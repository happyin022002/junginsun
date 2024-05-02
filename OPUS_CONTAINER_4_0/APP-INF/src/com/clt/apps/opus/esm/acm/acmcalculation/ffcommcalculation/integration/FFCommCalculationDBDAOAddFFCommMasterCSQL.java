/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FFCommCalculationDBDAOAddFFCommMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOAddFFCommMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOAddFFCommMasterCSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOAddFFCommMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_bx_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_chg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_teu_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_feu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_comm_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_bkg_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_rf_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_feu_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ff_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reference_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOAddFFCommMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_FF_CMPN" ).append("\n"); 
		query.append("(BKG_NO, BKG_FF_CNT_CD, BKG_FF_SEQ, FF_CMPN_SEQ, FF_CNT_CD, FF_SEQ, FF_AGMT_SEQ, FF_CHG_AMT, PPD_AMT, CRNT_AMT, IF_AMT, FF_CMPN_STS_CD, LOC_CD, AR_OFC_CD, AP_OFC_CD, COMM_STND_COST_CD, VSL_DEP_DT, FF_DIV_CD, FF_BKG_RT, BKG_BX_QTY, FF_BX_AMT, BKG_TEU_QTY, FF_TEU_AMT, BKG_FEU_QTY, FF_FEU_AMT, BKG_RF_QTY, FF_RF_AMT, FF_CHG_CTNT, FMC_NO, VNDR_CNT_CD, VNDR_SEQ" ).append("\n"); 
		query.append(", FF_OCCR_INFO_CD, FF_SLAN_CD, FF_RLANE_CD, FF_VSL_CD, FF_SKD_VOY_NO, FF_SKD_DIR_CD, FF_REV_DIR_CD, OFC_CHR_CD, FF_REF_NO, CSR_NO, APRO_USR_ID, APRO_DT, APRO_GDT, GL_DT, INV_TAX_RT, IF_USR_ID, IF_DT, IF_GDT, SC_NO, RFA_NO, SHPR_CNT_CD, SHPR_SEQ, CMDT_TP_CD, CMDT_CD, FF_CMPN_RMK, ACCL_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[bkg_ff_cnt_cd]    BKG_FF_CNT_CD" ).append("\n"); 
		query.append(", @[bkg_ff_seq] 	  BKG_FF_SEQ" ).append("\n"); 
		query.append(", @[ff_cmpn_seq]      FF_CMPN_SEQ" ).append("\n"); 
		query.append(", @[ff_cnt_cd]        FF_CNT_CD" ).append("\n"); 
		query.append(", @[ff_seq]		      FF_SEQ " ).append("\n"); 
		query.append(", @[ff_agmt_seq]      FF_AGMT_SEQ" ).append("\n"); 
		query.append(", @[ff_chg_amt]		  FF_CHG_AMT" ).append("\n"); 
		query.append(", (SELECT NVL(SUM (IF_AMT),0) PPD_AMT		" ).append("\n"); 
		query.append("  FROM ACM_FF_CMPN			" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]) PPD_AMT" ).append("\n"); 
		query.append(", @[act_comm_amt]      CRNT_AMT" ).append("\n"); 
		query.append(", TO_NUMBER(@[act_comm_amt]) -" ).append("\n"); 
		query.append("  (SELECT NVL(SUM (IF_AMT),0) PPD_AMT		" ).append("\n"); 
		query.append("  FROM ACM_FF_CMPN			" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]) IF_AMT" ).append("\n"); 
		query.append(", 'CS'               FF_CMPN_STS_CD" ).append("\n"); 
		query.append(", @[pol_cd]           LOC_CD" ).append("\n"); 
		query.append(", (SELECT A.AR_OFC_CD" ).append("\n"); 
		query.append("     FROM MDM_ORGANIZATION A, MDM_LOCATION B " ).append("\n"); 
		query.append("    WHERE B.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("	  AND B.FINC_CTRL_OFC_CD = A.OFC_CD )   AS AR_OFC_CD" ).append("\n"); 
		query.append("--, 'NYCHQ'        AP_OFC_CD" ).append("\n"); 
		query.append(", (SELECT A.AP_OFC_CD" ).append("\n"); 
		query.append("     FROM MDM_ORGANIZATION A, MDM_LOCATION B " ).append("\n"); 
		query.append("    WHERE B.LOC_CD = @[pol_cd]" ).append("\n"); 
		query.append("	  AND B.FINC_CTRL_OFC_CD = A.OFC_CD )  AS AP_OFC_CD" ).append("\n"); 
		query.append(", '512641' COMM_STND_COST_CD" ).append("\n"); 
		query.append(", TO_DATE (@[vps_etd_dt], 'yyyyMMddHH24miss') VSL_DEP_DT" ).append("\n"); 
		query.append(", @[ff_div_cd]        FF_DIV_CD" ).append("\n"); 
		query.append(", @[ff_bkg_rt]        FF_BKG_RT" ).append("\n"); 
		query.append(", @[bkg_bx_qty]       BKG_BX_QTY" ).append("\n"); 
		query.append(", @[ff_bx_amt]        FF_BX_AMT" ).append("\n"); 
		query.append(", @[bkg_teu_qty]      BKG_TEU_QTY" ).append("\n"); 
		query.append(", @[ff_teu_amt]       FF_TEU_AMT" ).append("\n"); 
		query.append(", @[bkg_feu_qty]      BKG_FEU_QTY" ).append("\n"); 
		query.append(", @[ff_feu_amt]       FF_FEU_AMT" ).append("\n"); 
		query.append(", @[bkg_rf_qty]       BKG_RF_QTY" ).append("\n"); 
		query.append(", @[ff_rf_amt]        FF_RF_AMT" ).append("\n"); 
		query.append(", @[ff_chg_ctnt]      FF_CHG_CTNT" ).append("\n"); 
		query.append(", @[fmc_no]           FMC_NO" ).append("\n"); 
		query.append(", @[vndr_cnt_cd]      VNDR_CNT_CD" ).append("\n"); 
		query.append(", @[vndr_seq]         VNDR_SEQ" ).append("\n"); 
		query.append(", @[por_cd]  FF_OCCR_INFO_CD" ).append("\n"); 
		query.append(", @[slan_cd]       FF_SLAN_CD" ).append("\n"); 
		query.append(", @[rlane_cd]      FF_RLANE_CD" ).append("\n"); 
		query.append(", @[vsl_cd]        FF_VSL_CD" ).append("\n"); 
		query.append(", @[skd_voy_no]    FF_SKD_VOY_NO" ).append("\n"); 
		query.append(", @[skd_dir_cd]    FF_SKD_DIR_CD" ).append("\n"); 
		query.append(", @[rlane_dir_cd]    FF_REV_DIR_CD" ).append("\n"); 
		query.append(", (SELECT OFC_CHR_CD FROM ACM_OFC_INFO WHERE AGN_CD = @[pol_cd] AND ROWNUM = 1) OFC_CHR_CD" ).append("\n"); 
		query.append(", @[reference_no]        FF_REF_NO" ).append("\n"); 
		query.append(", NULL CSR_NO" ).append("\n"); 
		query.append(", NULL APRO_USR_ID" ).append("\n"); 
		query.append(", NULL APRO_DT" ).append("\n"); 
		query.append(", NULL APRO_GDT" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SINHO',SYSDATE,'GMT'),'YYYYMMDD') AS GL_DT" ).append("\n"); 
		query.append(", @[inv_tax_rt]       INV_TAX_RT" ).append("\n"); 
		query.append(", NULL IF_USR_ID" ).append("\n"); 
		query.append(", NULL IF_DT" ).append("\n"); 
		query.append(", NULL IF_GDT" ).append("\n"); 
		query.append(", NULL SC_NO" ).append("\n"); 
		query.append(", @[rfa_no]           RFA_NO " ).append("\n"); 
		query.append(", @[shpr_cnt_cd]      SHPR_CNT_CD" ).append("\n"); 
		query.append(", @[shpr_cust_seq]         SHPR_SEQ" ).append("\n"); 
		query.append(", @[cmdt_tp_cd]       CMDT_TP_CD" ).append("\n"); 
		query.append(", @[cmdt_cd]          CMDT_CD" ).append("\n"); 
		query.append(", 'Calculation Success!' FF_CMPN_RMK" ).append("\n"); 
		query.append(", (SELECT ACCL_FLG " ).append("\n"); 
		query.append(" FROM ACM_FF_CMPN" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" AND FF_CMPN_SEQ = 1) ACCL_FLG" ).append("\n"); 
		query.append(", @[user_id]       CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE CRE_DT" ).append("\n"); 
		query.append(", @[user_id]       UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}