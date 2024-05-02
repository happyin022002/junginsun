/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOaddCHSCpsLeaseInvoiceDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOaddCHSCpsLeaseInvoiceDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.06.26 조경완 [CHM-201324911-01] ALPS-CHSS-COPS 기능 Trouble Shooting을 위한 CSR
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOaddCHSCpsLeaseInvoiceDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_ut_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_offh_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vrfy_scs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_chg_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_smry_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_mod_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_lse_use_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_gate_act_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_eq_tpsz_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_onh_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOaddCHSCpsLeaseInvoiceDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_LSE_INV_TMP (" ).append("\n"); 
		query.append("	INV_NO" ).append("\n"); 
		query.append("	,INV_REF_NO" ).append("\n"); 
		query.append("	,INV_EQ_NO" ).append("\n"); 
		query.append("	,INV_CUST_EQ_NO" ).append("\n"); 
		query.append("	,INV_EQ_ONH_DT" ).append("\n"); 
		query.append("	,INV_EQ_ONH_LOC_NM" ).append("\n"); 
		query.append("	,INV_EQ_OFFH_DT" ).append("\n"); 
		query.append("	,INV_EQ_OFFH_LOC_NM" ).append("\n"); 
		query.append("	,INV_BIL_ST_DT" ).append("\n"); 
		query.append("	,INV_BIL_END_DT" ).append("\n"); 
		query.append("	,INV_LSE_USE_DYS" ).append("\n"); 
		query.append("	,INV_LSE_RT_AMT" ).append("\n"); 
		query.append("	,INV_LSE_CHG_AMT" ).append("\n"); 
		query.append("	,INV_TAX_AMT" ).append("\n"); 
		query.append("	,INV_CR_AMT" ).append("\n"); 
		query.append("	,CHG_CD" ).append("\n"); 
		query.append("	,VRFY_SCS_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,COST_YRMON" ).append("\n"); 
		query.append("	,EQ_KND_CD" ).append("\n"); 
		query.append("	,CHG_CRE_SEQ" ).append("\n"); 
		query.append("    ,INV_CHG_TP_NM" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("	,INV_BKG_NO" ).append("\n"); 
		query.append("	,INV_BIL_UT_DYS" ).append("\n"); 
		query.append("	,INV_CUST_EQ_TPSZ_NM" ).append("\n"); 
		query.append("    ,INV_YD_CD" ).append("\n"); 
		query.append("	,TAX_SMRY_AMT" ).append("\n"); 
		query.append("	,INV_SMRY_AMT" ).append("\n"); 
		query.append("	,VRFY_RSLT_DESC" ).append("\n"); 
		query.append("	,INV_GATE_ACT_ID" ).append("\n"); 
		query.append("	,INV_BIL_MOD_RMK" ).append("\n"); 
		query.append("	,EQ_NO" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("     @[inv_no]               " ).append("\n"); 
		query.append("    ,@[inv_ref_no]           " ).append("\n"); 
		query.append("    ,@[inv_eq_no]            " ).append("\n"); 
		query.append("	,CASE WHEN @[inv_cust_eq_no] IS NULL THEN (SELECT MAX(B.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("                                        FROM  CGM_CHSS_MVMT_HIS B" ).append("\n"); 
		query.append("                                        WHERE  @[inv_eq_no] = B.CHSS_NO" ).append("\n"); 
		query.append("                                        AND  TRUNC(B.MVMT_DT)= TO_DATE(SUBSTR(TRIM(@[inv_eq_onh_dt]),1,8),'YYYYMMDD')" ).append("\n"); 
		query.append("                                        AND  UPPER(@[inv_chg_tp_nm]) = 'PER DIEM'" ).append("\n"); 
		query.append("                                        AND  B.GATE_IO_CD ='O'" ).append("\n"); 
		query.append("                                        AND  B.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("                                        AND  B.MVMT_STS_CD IN('CD','CE','CP','EN','ID','OP','TN')" ).append("\n"); 
		query.append("                                        HAVING COUNT(*) = 1)" ).append("\n"); 
		query.append("			ELSE MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[inv_cust_eq_no]) END " ).append("\n"); 
		query.append("    ,TO_DATE(SUBSTR(TRIM(@[inv_eq_onh_dt]),1,8),'YYYYMMDD')        " ).append("\n"); 
		query.append("    ,@[inv_eq_onh_loc_nm]    " ).append("\n"); 
		query.append("    ,TO_DATE(SUBSTR(TRIM(@[inv_eq_offh_dt]),1,8),'YYYYMMDD')          " ).append("\n"); 
		query.append("    ,@[inv_eq_offh_loc_nm]   " ).append("\n"); 
		query.append("    ,TO_DATE(SUBSTR(TRIM(@[inv_bil_st_dt]),1,8),'YYYYMMDD')           " ).append("\n"); 
		query.append("    ,TO_DATE(SUBSTR(TRIM(@[inv_bil_end_dt]),1,8),'YYYYMMDD')          " ).append("\n"); 
		query.append("    ,@[inv_lse_use_dys]" ).append("\n"); 
		query.append("    ,NVL(@[inv_lse_rt_amt] , 0)" ).append("\n"); 
		query.append("    ,NVL(@[inv_lse_chg_amt], 0)" ).append("\n"); 
		query.append("    ,NVL(@[inv_tax_amt], 0)*100" ).append("\n"); 
		query.append("    ,NVL(@[inv_cr_amt], 0)" ).append("\n"); 
		query.append("    ,DECODE(UPPER(@[inv_chg_tp_nm]),'PER DIEM','PDM','ON TERMINAL','ONT', 'ON STREET', 'PDM')" ).append("\n"); 
		query.append("    ,@[vrfy_scs_flg]" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,@[cost_yrmon]" ).append("\n"); 
		query.append("    ,@[eq_knd_cd]" ).append("\n"); 
		query.append("    ,@[chg_cre_seq]" ).append("\n"); 
		query.append("    ,@[inv_chg_tp_nm]" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("    ,sysdate" ).append("\n"); 
		query.append("	,@[inv_bkg_no]" ).append("\n"); 
		query.append("	,NVL(@[inv_bil_ut_dys], 0)" ).append("\n"); 
		query.append("	,SUBSTR(TRIM(@[inv_cust_eq_tpsz_nm]), 1, 2)" ).append("\n"); 
		query.append("	,NVL((SELECT  MAX(A.YD_CD)" ).append("\n"); 
		query.append("            FROM  CGM_AGMT_CPS_COND A" ).append("\n"); 
		query.append("            WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("            AND   A.AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("            AND   A.AGMT_VER_NO     = @[agmt_ver_no]" ).append("\n"); 
		query.append("            AND   A.LR_LOC_NM       = @[inv_eq_onh_loc_nm]" ).append("\n"); 
		query.append("			HAVING COUNT(*) = 1 " ).append("\n"); 
		query.append("					),(SELECT MAX(A.YD_CD) --수정" ).append("\n"); 
		query.append("                            FROM  CGM_AGMT_CPS_COND A" ).append("\n"); 
		query.append("                            WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("                            AND   A.AGMT_SEQ        = @[agmt_seq]" ).append("\n"); 
		query.append("                            AND   A.AGMT_VER_NO     = @[agmt_ver_no]" ).append("\n"); 
		query.append("                            AND   A.LR_LOC_NM LIKE '%'||@[inv_eq_onh_loc_nm]||'%'" ).append("\n"); 
		query.append("                            AND   INSTRB(A.LR_LOC_NM,',') > 0" ).append("\n"); 
		query.append("                            AND   LENGTH(A.LR_LOC_NM)> 30" ).append("\n"); 
		query.append("                            HAVING COUNT(*) = 1 " ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("	,NVL(@[tax_smry_amt], 0)" ).append("\n"); 
		query.append("	,NVL(@[inv_lse_chg_amt], 0) + NVL(@[tax_smry_amt], 0)" ).append("\n"); 
		query.append("	,(SELECT B.BKG_NO||RPAD(NVL(B.SC_NO,' '),9,' ')||NVL(B.CTRT_CUST_CNT_CD, '  ')||RPAD(LTRIM(TO_CHAR(NVL(B.CTRT_CUST_SEQ,0),'000000')),6,' ')" ).append("\n"); 
		query.append("                        FROM  BKG_BOOKING B,BKG_CONTAINER C" ).append("\n"); 
		query.append("                        WHERE B.BKG_NO =  @[inv_bkg_no]" ).append("\n"); 
		query.append("                        AND   C.BKG_NO =  @[inv_bkg_no]" ).append("\n"); 
		query.append("                        AND   C.CNTR_NO = MST_COMMON_PKG.MST_CNTR_CHK_DGT_FNC(@[inv_cust_eq_no]))" ).append("\n"); 
		query.append("	,@[inv_gate_act_id]" ).append("\n"); 
		query.append("	,@[inv_bil_mod_rmk]" ).append("\n"); 
		query.append("	,@[inv_cust_eq_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}