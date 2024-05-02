/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOaddOtherInvChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOaddOtherInvChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOaddOtherInvChargeCSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOaddOtherInvChargeCSQL(){
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
		params.put("if_src_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_coa_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trf_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOaddOtherInvChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_CHG (" ).append("\n"); 
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
		query.append(",TRF_NO" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("@[ar_if_no]" ).append("\n"); 
		query.append(",@[ar_if_ser_no]" ).append("\n"); 
		query.append(",@[chg_seq]" ).append("\n"); 
		query.append(",@[chg_cd] " ).append("\n"); 
		query.append(",SUBSTR(@[curr_cd], 1, 3)" ).append("\n"); 
		query.append(",@[per_tp_cd]" ).append("\n"); 
		query.append(",ABS(NVL(@[trf_rt_amt], 0))" ).append("\n"); 
		query.append(",NVL(@[rat_as_cntr_qty], 0)" ).append("\n"); 
		query.append(",NVL(CASE WHEN @[if_src_cd] = 'DEM' OR @[if_src_cd] = 'DET' THEN" ).append("\n"); 
		query.append("          (SELECT ROUND(@[chg_amt], B.DP_PRCS_KNT)" ).append("\n"); 
		query.append("             FROM (SELECT CURR_CD" ).append("\n"); 
		query.append("                         ,CURR_NM" ).append("\n"); 
		query.append("                         ,DP_PRCS_KNT" ).append("\n"); 
		query.append("                     FROM MDM_CURRENCY" ).append("\n"); 
		query.append("                    WHERE NVL(TO_EFF_DT,SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("                      AND DELT_FLG!='Y'" ).append("\n"); 
		query.append("                    ORDER BY CURR_CD) B  " ).append("\n"); 
		query.append("            WHERE SUBSTR(@[curr_cd], 1, 3) = B.CURR_CD)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("          (SELECT DECODE(SIGN(NVL(@[chg_amt],1)),0,1,SIGN(NVL(@[chg_amt],1))) * ROUND(ABS(NVL(@[trf_rt_amt],0)) * @[rat_as_cntr_qty], B.DP_PRCS_KNT)" ).append("\n"); 
		query.append("             FROM (SELECT CURR_CD" ).append("\n"); 
		query.append("                         ,CURR_NM" ).append("\n"); 
		query.append("                         ,DP_PRCS_KNT" ).append("\n"); 
		query.append("                     FROM MDM_CURRENCY" ).append("\n"); 
		query.append("                    WHERE NVL(TO_EFF_DT,SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("                      AND DELT_FLG!='Y'" ).append("\n"); 
		query.append("                    ORDER BY CURR_CD) B  " ).append("\n"); 
		query.append("            WHERE SUBSTR(@[curr_cd], 1, 3) = B.CURR_CD)" ).append("\n"); 
		query.append("END, 0)" ).append("\n"); 
		query.append(",NVL(@[inv_xch_rt], 0) -- 10" ).append("\n"); 
		query.append(",@[rep_chg_cd]" ).append("\n"); 
		query.append(",@[chg_full_nm]" ).append("\n"); 
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
		query.append(",DECODE(@[tva_flg],'Y',DECODE(@[chg_cd],(SELECT IASO.INV_VAT_CHG_CD " ).append("\n"); 
		query.append("                                           FROM MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("                                                INV_AR_STUP_OFC IASO" ).append("\n"); 
		query.append("                                          WHERE MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                            AND NVL(MO.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND MO.AR_OFC_CD = IASO.AR_OFC_CD),'N','Y'),'N')" ).append("\n"); 
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
		query.append(",@[trf_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}