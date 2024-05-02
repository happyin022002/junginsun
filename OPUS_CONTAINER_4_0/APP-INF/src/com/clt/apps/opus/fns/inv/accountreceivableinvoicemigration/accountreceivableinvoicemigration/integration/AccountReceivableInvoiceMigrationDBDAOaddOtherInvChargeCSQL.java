/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOaddOtherInvChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOaddOtherInvChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountReceivableInvoiceMigrationDBDAOaddOtherInvChargeCSQL
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOaddOtherInvChargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rat_as_cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tva_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_clr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_rev_tp_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tj_src_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("per_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_coa_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOaddOtherInvChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO OPUSADM_TMP.INV_AR_CHG (" ).append("\n"); 
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(",AR_IF_SER_NO" ).append("\n"); 
		query.append(",CHG_SEQ" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",PER_TP_CD" ).append("\n"); 
		query.append(",TRF_RT_AMT" ).append("\n"); 
		query.append(",RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(",CHG_AMT" ).append("\n"); 
		query.append(",INV_XCH_RT -- 10" ).append("\n"); 
		query.append(",REP_CHG_CD" ).append("\n"); 
		query.append(",CHG_FULL_NM" ).append("\n"); 
		query.append(",INV_ISS_FLG" ).append("\n"); 
		query.append(",INV_CLR_FLG" ).append("\n"); 
		query.append(",SOB_ID" ).append("\n"); 
		query.append(",INV_REV_TP_SRC_CD" ).append("\n"); 
		query.append(",REV_COA_CO_CD" ).append("\n"); 
		query.append(",REV_COA_RGN_CD" ).append("\n"); 
		query.append(",REV_COA_CTR_CD" ).append("\n"); 
		query.append(",REV_COA_ACCT_CD -- 20" ).append("\n"); 
		query.append(",REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",REV_COA_VSL_CD" ).append("\n"); 
		query.append(",REV_COA_VOY_NO" ).append("\n"); 
		query.append(",REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_COA_DIR_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",TVA_FLG" ).append("\n"); 
		query.append(",CHG_RMK" ).append("\n"); 
		query.append(",MNL_FLG" ).append("\n"); 
		query.append(",MF_DIV_CD -- 30" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",INV_XCH_RT_DT" ).append("\n"); 
		query.append(",TJ_SRC_NM" ).append("\n"); 
		query.append(",AR_IF_CHG_SEQ" ).append("\n"); 
		query.append(",USD_XCH_RT" ).append("\n"); 
		query.append(",ISS_XCH_RT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(",@[ar_if_ser_no]" ).append("\n"); 
		query.append(",@[chg_seq]" ).append("\n"); 
		query.append(",(SELECT DECODE(@[chg_cd], 'VAT', (SELECT NVL(MAX(CHG_CD), 'TVA') FROM MDM_CHARGE WHERE TAX_FLG = 'Y' AND TAX_CNT_CD = B.CNT_CD), @[chg_cd])" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("       MDM_LOCATION B" ).append("\n"); 
		query.append("  WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("  AND A.OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",@[per_tp_cd]" ).append("\n"); 
		query.append(",NVL(@[trf_rt_amt], 0)" ).append("\n"); 
		query.append(",NVL(@[rat_as_cntr_qty], 0)" ).append("\n"); 
		query.append(",NVL((SELECT ROUND(NVL(@[chg_amt],0),DP_PRCS_KNT) FROM MDM_CURRENCY WHERE CURR_CD = SUBSTR(@[curr_cd], 1, 3)), 0)" ).append("\n"); 
		query.append(",NVL(@[inv_xch_rt], 0) -- 10" ).append("\n"); 
		query.append(",(SELECT REP_CHG_CD FROM MDM_CHARGE WHERE CHG_CD = @[chg_cd])" ).append("\n"); 
		query.append(",(SELECT CHG_NM FROM MDM_CHARGE WHERE CHG_CD = @[chg_cd])" ).append("\n"); 
		query.append(",NVL(@[inv_iss_flg],'N')" ).append("\n"); 
		query.append(",NVL(@[inv_clr_flg],'N')" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(",@[inv_rev_tp_src_cd]" ).append("\n"); 
		query.append(",'01'" ).append("\n"); 
		query.append(",(SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append(",(SELECT AR_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append(",@[rev_coa_acct_cd] -- 20" ).append("\n"); 
		query.append(",@[rev_coa_inter_co_cd]" ).append("\n"); 
		query.append(",(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_vsl_cd], '7', @[rev_coa_vsl_cd], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_vsl_cd], '0000'))))" ).append("\n"); 
		query.append(",(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_voy_no], '7', @[rev_coa_voy_no], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_voy_no], '0000'))))" ).append("\n"); 
		query.append(",(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_skd_dir_cd], '7', @[rev_coa_skd_dir_cd], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_skd_dir_cd], '0'))))" ).append("\n"); 
		query.append(",(DECODE(@[rev_coa_acct_cd], null, '', DECODE(SUBSTR(@[rev_coa_acct_cd],1,1), '4', @[rev_coa_dir_cd], '7', @[rev_coa_dir_cd], DECODE(SUBSTR(@[rev_coa_acct_cd],1,2), '51', @[rev_coa_dir_cd], '0'))))" ).append("\n"); 
		query.append(",@[acct_cd]" ).append("\n"); 
		query.append(",@[tva_flg]" ).append("\n"); 
		query.append(",@[chg_rmk]" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",'N' -- 30" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[inv_xch_rt_dt]" ).append("\n"); 
		query.append(",@[tj_src_nm]" ).append("\n"); 
		query.append(",@[ar_if_chg_seq]" ).append("\n"); 
		query.append(",NVL(@[usd_xch_rt], 0)" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}