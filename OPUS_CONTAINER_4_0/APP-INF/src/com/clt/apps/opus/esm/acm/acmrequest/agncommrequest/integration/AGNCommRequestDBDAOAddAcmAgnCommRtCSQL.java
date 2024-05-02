/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOAddAcmAgnCommRtCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.25 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOAddAcmAgnCommRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * AddAcmAgnCommRt
	  * </pre>
	  */
	public AGNCommRequestDBDAOAddAcmAgnCommRtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_fx_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ap_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clt_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_trs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_chg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddct_spcl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ppd_ofrt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_div_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_info_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ppd_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_pay_crnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_crnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_ofrt_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n");
		query.append("FileName : AGNCommRequestDBDAOAddAcmAgnCommRtCSQL").append("\n");
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
		query.append("INSERT INTO ACM_AGN_COMM(BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD,AC_SEQ,BDR_FLG,AC_STS_CD,PPD_AMT,CRNT_AMT,IF_AMT,CRNT_REV_AMT,DDCT_CHG_AMT,DDCT_TRSP_AMT,DDCT_SPCL_CMPN_AMT,COMM_FX_AMT,REV_DIV_CD,COMM_RT,AGN_AGMT_NO,AGN_AGMT_SEQ,LOC_DIV_CD,LOC_CD,AR_OFC_CD,AP_OFC_CD,AP_CTR_CD,COMM_STND_COST_CD,SAIL_ARR_DT,AC_OCCR_INFO_CD,AC_SLAN_CD,AC_RLANE_CD,AC_VSL_CD,AC_SKD_VOY_NO,AC_SKD_DIR_CD,AC_REV_DIR_CD,CURR_CD,XCH_RT_APLY_LVL,PAY_XCH_RT,PAY_PPD_AMT,PAY_CRNT_AMT,PAY_IF_AMT,OFC_CHR_CD,VNDR_CNT_CD,VNDR_SEQ,ACCL_FLG,RQST_USR_ID,RQST_DT,RQST_GDT,AUD_NO,AUD_USR_ID,AUD_DT,AUD_GDT,CSR_NO,APRO_USR_ID,APRO_DT,APRO_GDT,GL_DT,ASA_NO,INV_TAX_RT,IF_USR_ID,IF_DT,IF_GDT,AC_PROC_DESC,PPD_OFRT_AMT,PPD_CHG_AMT,CLT_OFRT_AMT,CLT_CHG_AMT,AGN_INFO_SEQ,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n");
		query.append("SELECT " ).append("\n");
		query.append("  @[bkg_no]    AS BKG_NO" ).append("\n");
		query.append(", @[agn_cd]    AS AGN_CD" ).append("\n");
		query.append(", @[io_bnd_cd] AS IO_BND_CD" ).append("\n");
		query.append(", @[ac_tp_cd]  AS AC_TP_CD" ).append("\n");
		query.append(", @[max_ac_seq] AS AC_SEQ" ).append("\n");
		query.append(", @[bdr_flg]   AS BDR_FLG" ).append("\n");
		query.append(", (CASE WHEN ROUND( @[comm_amt],2) - @[ppd_crnt_amt] < 0 AND @[max_ac_seq] = 1 THEN 'CN'  " ).append("\n");
		query.append("        WHEN ROUND( @[comm_amt],2) - @[ppd_crnt_amt] = 0 THEN 'CZ'" ).append("\n");
		query.append("        WHEN ROUND( @[comm_amt],2) <= 0 AND @[ppd_crnt_amt] = 0 AND @[max_ac_seq] > 2  THEN 'CZ' -- SEQ 2 로 이미 상계 처리 된 경우 최종 커미션 CRNT 금액이 0 이하이고, IF 금액이 0 일 때 CZ 로 만들어 주기 위한 로직 " ).append("\n");
		query.append("        ELSE 'CS'" ).append("\n");
		query.append("   END) AS AC_STS_CD" ).append("\n");
		query.append(", NVL(@[ppd_crnt_amt],0) AS PPD_AMT" ).append("\n");
		query.append(", CASE WHEN @[max_ac_seq] > 1  AND ROUND( @[comm_amt],2) < 0 THEN 0" ).append("\n");
		query.append("       ELSE ROUND( @[comm_amt],2) " ).append("\n");
		query.append("  END                                        AS CRNT_AMT" ).append("\n");
		query.append(", CASE WHEN @[max_ac_seq] > 1  AND ROUND( @[comm_amt],2) < 0 THEN 0 - @[ppd_crnt_amt]" ).append("\n");
		query.append("       ELSE ROUND( @[comm_amt],2) - @[ppd_crnt_amt]    " ).append("\n");
		query.append("  END                                        AS IF_AMT" ).append("\n");
		query.append(", ROUND( @[ttl_rev_amt] ,2)                  AS CRNT_REV_AMT" ).append("\n");
		query.append(", ROUND( @[ddct_chg],2)                      AS DDCT_CHG_AMT" ).append("\n");
		query.append(", ROUND( @[ddct_trs],2)                      AS DDCT_TRSP_AMT" ).append("\n");
		query.append(", ROUND( @[ddct_spcl],2)                     AS DDCT_SPCL_CMPN_AMT" ).append("\n");
		query.append(", @[comm_fx_amt]  AS COMM_FX_AMT" ).append("\n");
		query.append(", @[rev_div_cd]   AS REV_DIV_CD" ).append("\n");
		query.append(", @[comm_rt]      AS COMM_RT" ).append("\n");
		query.append(", @[agn_agmt_no]  AS AGN_AGMT_NO" ).append("\n");
		query.append(", @[agn_agmt_seq] AS AGN_AGMT_SEQ" ).append("\n");
		query.append(", NULL AS LOC_DIV_CD" ).append("\n");
		query.append(", NULL AS LOC_CD" ).append("\n");
		query.append(", @[ar_ofc_cd] AS AR_OFC_CD" ).append("\n");
		query.append(", @[ap_ofc_cd] AS AP_OFC_CD" ).append("\n");
		query.append(", @[ap_ctr_cd] AS AP_CTR_CD" ).append("\n");
		query.append(", (SELECT COMM_STND_COST_CD FROM ACM_COMM_TP_CD_MAPG WHERE COMM_TP_CD = 'C' AND IO_BND_CD = @[io_bnd_cd] AND AC_TP_CD = @[ac_tp_cd])  AS COMM_STND_COST_CD" ).append("\n");
		query.append(", @[sa_dt]      AS SAIL_ARR_DT" ).append("\n");
		query.append(", @[port]       AS AC_OCCR_INFO_CD" ).append("\n");
		query.append(", @[slan_cd]    AS AC_SLAN_CD" ).append("\n");
		query.append(", @[rlane_cd]   AS AC_RLANE_CD" ).append("\n");
		query.append(", @[vsl_cd]     AS AC_VSL_CD" ).append("\n");
		query.append(", @[skd_voy_no] AS AC_SKD_VOY_NO" ).append("\n");
		query.append(", @[skd_dir_cd] AS AC_SKD_DIR_CD" ).append("\n");
		query.append(", @[rev_dir_cd] AS AC_REV_DIR_CD" ).append("\n");
		query.append(", @[ofc_curr_cd]" ).append("\n");
		query.append(", @[xch_rt_div_lvl] AS XCH_RT_APLY_LVL" ).append("\n");
		query.append(", @[pay_xch_rt]     AS PAY_XCH_RT" ).append("\n");
		query.append(", @[ppd_pay_crnt_amt]                                                            AS PAY_PPD_AMT" ).append("\n");
		query.append(", CASE WHEN  @[pay_xch_rt] = 0 THEN 0" ).append("\n");
		query.append("       WHEN  @[max_ac_seq] > 1  AND ROUND(@[comm_amt],2) < 0 THEN 0" ).append("\n");
		query.append("       ELSE  ROUND( @[pay_xch_rt] * ROUND(@[comm_amt],2),2) " ).append("\n");
		query.append("  END                                                                            AS PAY_CRNT_AMT                   " ).append("\n");
		query.append(", CASE WHEN @[pay_xch_rt] = 0 THEN 0" ).append("\n");
		query.append("       WHEN @[max_ac_seq] > 1  AND ROUND( @[comm_amt],2) < 0 THEN 0 - @[ppd_pay_crnt_amt]" ).append("\n");
		query.append("       ELSE  ROUND( @[pay_xch_rt] * ROUND(@[comm_amt],2),2) - @[ppd_pay_crnt_amt]" ).append("\n");
		query.append("  END                                                                            AS PAY_IF_AMT" ).append("\n");
		query.append(", @[ofc_chr_cd]  AS OFC_CHR_CD" ).append("\n");
		query.append(", @[vndr_cnt_cd] AS VNDR_CNT_CD" ).append("\n");
		query.append(", @[vndr_seq]    AS VNDR_SEQ" ).append("\n");
		query.append(", 'N'  AS ACCL_FLG" ).append("\n");
		query.append(", NULL AS RQST_USR_ID" ).append("\n");
		query.append(", NULL AS RQST_DT" ).append("\n");
		query.append(", NULL AS RQST_GDT" ).append("\n");
		query.append(", NULL AS AUD_NO" ).append("\n");
		query.append(", NULL AS AUD_USR_ID" ).append("\n");
		query.append(", NULL AS AUD_DT" ).append("\n");
		query.append(", NULL AS AUD_GDT" ).append("\n");
		query.append(", NULL AS CSR_NO" ).append("\n");
		query.append(", NULL AS APRO_USR_ID" ).append("\n");
		query.append(", NULL AS APRO_DT" ).append("\n");
		query.append(", NULL AS APRO_GDT" ).append("\n");
		query.append(", NULL AS GL_DT" ).append("\n");
		query.append(", NULL AS ASA_NO" ).append("\n");
		query.append(", NULL AS INV_TAX_RT" ).append("\n");
		query.append(", NULL AS IF_USR_ID" ).append("\n");
		query.append(", NULL AS IF_DT" ).append("\n");
		query.append(", NULL AS IF_GDT" ).append("\n");
		query.append(", (CASE WHEN @[comm_amt] > 0 THEN 'Calculation-Success'  " ).append("\n");
		query.append("        WHEN @[comm_amt] = 0 THEN 'Calculation-ZeroAMT'  " ).append("\n");
		query.append("        ELSE 'Calculation-NegativeAMT' END) AS AC_PROC_DESC" ).append("\n");
		query.append(", @[ppd_ofrt_amt] AS PPD_OFRT_AMT" ).append("\n");
		query.append(", @[ppd_chg_amt]  AS PPD_CHG_AMT" ).append("\n");
		query.append(", @[clt_ofrt_amt] AS CLT_OFRT_AMT" ).append("\n");
		query.append(", @[clt_chg_amt]  AS CLT_CHG_AMT" ).append("\n");
		query.append(", @[agn_info_seq] AS AGN_INFO_SEQ" ).append("\n");
		query.append(", @[usr_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append(", @[usr_id]" ).append("\n");
		query.append(", SYSDATE" ).append("\n");
		query.append("FROM DUAL D" ).append("\n");

	}
}