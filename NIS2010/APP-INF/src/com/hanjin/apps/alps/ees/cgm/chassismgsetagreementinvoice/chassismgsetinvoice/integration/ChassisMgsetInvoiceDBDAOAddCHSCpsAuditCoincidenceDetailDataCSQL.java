/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddCHSCpsAuditCoincidenceDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
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

public class ChassisMgsetInvoiceDBDAOAddCHSCpsAuditCoincidenceDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddCHSCpsAuditCoincidenceDetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bkg_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_chg_aud_rslt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_fm_mvmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_chg_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tax_rt_Amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_lse_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_to_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_to_mvmt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_chg_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddCHSCpsAuditCoincidenceDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	INV_NO," ).append("\n"); 
		query.append("	AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("	AGMT_SEQ," ).append("\n"); 
		query.append("	AGMT_VER_NO," ).append("\n"); 
		query.append("	INV_REF_NO," ).append("\n"); 
		query.append("	INV_EQ_NO," ).append("\n"); 
		query.append("	EQ_NO," ).append("\n"); 
		query.append("	INV_CUST_EQ_NO," ).append("\n"); 
		query.append("	EQ_TPSZ_CD," ).append("\n"); 
		query.append("	CHG_CD," ).append("\n"); 
		query.append("	CHG_SEQ," ).append("\n"); 
		query.append("	INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("	INV_EQ_ONH_DT," ).append("\n"); 
		query.append("	INV_EQ_OFFH_DT," ).append("\n"); 
		query.append("	INV_BIL_ST_DT," ).append("\n"); 
		query.append("	INV_BIL_END_DT," ).append("\n"); 
		query.append("	INV_LSE_USE_DYS," ).append("\n"); 
		query.append("	INV_BIL_UT_DYS," ).append("\n"); 
		query.append("	INV_LSE_RT_AMT," ).append("\n"); 
		query.append("	INV_TAX_RT_AMT," ).append("\n"); 
		query.append("	INV_TAX_AMT," ).append("\n"); 
		query.append("	INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("	INV_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("	LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("	PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("	LSE_CHG_AUD_RSLT_RSN_CD," ).append("\n"); 
		query.append("	EQ_FM_MVMT_DT," ).append("\n"); 
		query.append("	EQ_FM_YD_CD," ).append("\n"); 
		query.append("	EQ_FM_MVMT_CD," ).append("\n"); 
		query.append("	EQ_TO_MVMT_DT," ).append("\n"); 
		query.append("	EQ_TO_YD_CD," ).append("\n"); 
		query.append("	EQ_TO_MVMT_CD," ).append("\n"); 
		query.append("	INV_SC_NO," ).append("\n"); 
		query.append("	INV_BKG_NO," ).append("\n"); 
		query.append("	INV_BKG_TERM_CD," ).append("\n"); 
		query.append("	COST_YRMON," ).append("\n"); 
		query.append("    COST_YRMON_SEQ, -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("	COST_CD," ).append("\n"); 
		query.append("	ACCT_CD," ).append("\n"); 
		query.append("	EQ_KND_CD," ).append("\n"); 
		query.append("	INV_CR_AMT," ).append("\n"); 
		query.append("	PAY_LSE_USE_DYS," ).append("\n"); 
		query.append("	PAY_BIL_UT_DYS," ).append("\n"); 
		query.append("	PAY_LSE_RT_AMT," ).append("\n"); 
		query.append("	PAY_TAX_RT_AMT," ).append("\n"); 
		query.append("	PAY_TAX_AMT," ).append("\n"); 
		query.append("	PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("	PAY_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("	PAY_CR_AMT," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	@[inv_no]," ).append("\n"); 
		query.append("	@[agmt_ofc_cty_cd]," ).append("\n"); 
		query.append("	@[agmt_seq]," ).append("\n"); 
		query.append("	@[agmt_ver_no]," ).append("\n"); 
		query.append("	@[inv_ref_no]," ).append("\n"); 
		query.append("	CASE WHEN @[chg_cd] = 'CRD' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'CRD' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('CRD' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'TAX' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'TAX' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('TAX' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'CMT' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'CMT' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('CMT' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'MCD' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'MCD' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('MCD' || '%'))" ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("			@[eq_no] " ).append("\n"); 
		query.append("	END," ).append("\n"); 
		query.append("	CASE WHEN @[chg_cd] = 'CRD' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'CRD' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('CRD' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'TAX' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'TAX' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('TAX' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'CMT' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'CMT' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('CMT' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'MCD' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'MCD' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("               AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("               AND EQ_NO LIKE ('MCD' || '%'))" ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("			@[eq_no] " ).append("\n"); 
		query.append("	END," ).append("\n"); 
		query.append("	@[inv_cust_eq_no]," ).append("\n"); 
		query.append("	@[eq_tpsz_cd]," ).append("\n"); 
		query.append("	@[chg_cd]," ).append("\n"); 
		query.append("	(SELECT NVL(MAX(CHG_SEQ),0)+1 FROM CGM_LSE_CHG_DTL " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("    AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("    AND AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("    AND COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND EQ_NO = (	CASE WHEN @[chg_cd] = 'CRD' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'CRD' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND EQ_NO LIKE ('CRD' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'TAX' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'TAX' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND EQ_NO LIKE ('TAX' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'PDM' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'PDM' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND EQ_NO LIKE ('PDM' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'ONT' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'ONT' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND EQ_NO LIKE ('ONT' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'CMT' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'CMT' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND EQ_NO LIKE ('CMT' || '%'))" ).append("\n"); 
		query.append("		 WHEN @[chg_cd] = 'MCD' THEN" ).append("\n"); 
		query.append("            (SELECT DECODE(MAX(EQ_NO),NULL,  " ).append("\n"); 
		query.append("                        		'MCD' || SUBSTR(@[cost_yrmon],3,6) || '001',  " ).append("\n"); 
		query.append("                        	    SUBSTR(MAX(EQ_NO),1,7) || LPAD( SUBSTR(MAX(EQ_NO),-3)+1,3,'0'))" ).append("\n"); 
		query.append("             FROM CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("             WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("                   AND EQ_NO LIKE ('MCD' || '%'))" ).append("\n"); 
		query.append("         ELSE " ).append("\n"); 
		query.append("			@[eq_no] " ).append("\n"); 
		query.append("	END)" ).append("\n"); 
		query.append("    AND CHG_CD = @[chg_cd])" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("	@[inv_eq_onh_loc_nm]," ).append("\n"); 
		query.append("	DECODE(@[inv_eq_onh_dt],'','',TO_DATE(@[inv_eq_onh_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	DECODE(@[inv_eq_offh_dt],'','',TO_DATE(@[inv_eq_offh_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	DECODE(@[inv_bil_st_dt],'','',TO_DATE(@[inv_bil_st_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	DECODE(@[inv_bil_end_dt],'','',TO_DATE(@[inv_bil_end_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	@[inv_lse_use_dys]," ).append("\n"); 
		query.append("	@[inv_bil_ut_dys]," ).append("\n"); 
		query.append("	@[inv_lse_rt_amt]," ).append("\n"); 
		query.append("	@[inv_tax_rt_Amt]," ).append("\n"); 
		query.append("	@[inv_tax_amt]," ).append("\n"); 
		query.append("	@[inv_lse_chg_amt]," ).append("\n"); 
		query.append("	@[inv_lse_chg_ttl_amt]," ).append("\n"); 
		query.append("	@[lse_chg_aud_sts_cd]," ).append("\n"); 
		query.append("	@[pay_lse_chg_sts_cd]," ).append("\n"); 
		query.append("	@[lse_chg_aud_rslt_rsn_cd]," ).append("\n"); 
		query.append("	DECODE(@[eq_fm_mvmt_dt],'','',TO_DATE(@[eq_fm_mvmt_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	@[eq_fm_yd_cd]," ).append("\n"); 
		query.append("	@[eq_fm_mvmt_cd]," ).append("\n"); 
		query.append("	DECODE(@[eq_to_mvmt_dt],'','',TO_DATE(@[eq_to_mvmt_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("	@[eq_to_yd_cd]," ).append("\n"); 
		query.append("	@[eq_to_mvmt_cd]," ).append("\n"); 
		query.append("	@[inv_sc_no]," ).append("\n"); 
		query.append("	@[inv_bkg_no]," ).append("\n"); 
		query.append("	@[inv_bkg_term_cd]," ).append("\n"); 
		query.append("	@[cost_yrmon]," ).append("\n"); 
		query.append("    @[cost_yrmon_seq], -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("	@[cost_cd]," ).append("\n"); 
		query.append("	@[acct_cd]," ).append("\n"); 
		query.append("	@[eq_knd_cd]," ).append("\n"); 
		query.append("	-1 * ABS(@[inv_cr_amt])," ).append("\n"); 
		query.append("	@[inv_lse_use_dys]," ).append("\n"); 
		query.append("	@[inv_bil_ut_dys]," ).append("\n"); 
		query.append("	@[inv_lse_rt_amt]," ).append("\n"); 
		query.append("	@[inv_tax_rt_Amt]," ).append("\n"); 
		query.append("	@[inv_tax_amt]," ).append("\n"); 
		query.append("	@[inv_lse_chg_amt]," ).append("\n"); 
		query.append("	@[inv_lse_chg_ttl_amt]," ).append("\n"); 
		query.append("	-1 * ABS(@[inv_cr_amt])," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	SYSDATE" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	DUAL" ).append("\n"); 

	}
}