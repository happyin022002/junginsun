/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2010.03.08 김진주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim JinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzFeeInvDtlByVvd
	  * </pre>
	  */
	public CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeInvoiceBCDBDAOsearchCanalTzFeeInvDtlByVvdRSQL").append("\n"); 
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
		query.append("SELECT   CREDITS," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("PSO_BZTP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("CALL_SEQ," ).append("\n"); 
		query.append("decode(flg, 2, null, DSP_COST_CD ) LGS_COST_CD," ).append("\n"); 
		query.append("decode(flg, 2, 'TTL Amount:', LGS_COST_FULL_NM) LGS_COST_FULL_NM," ).append("\n"); 
		query.append("LAST_INV," ).append("\n"); 
		query.append("RQST_AMT," ).append("\n"); 
		query.append("BALANCE," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("CALC_AMT," ).append("\n"); 
		query.append("T2.YD_CHG_NO," ).append("\n"); 
		query.append("T2.YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("DFLT_XPR_DESC," ).append("\n"); 
		query.append("SYS_XPR_DESC," ).append("\n"); 
		query.append("DFLT_SYS_XPR_DESC," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("INV_RGST_NO," ).append("\n"); 
		query.append("SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("LOCL_XCH_RT," ).append("\n"); 
		query.append("TR_VOL_VAL," ).append("\n"); 
		query.append("SCG_RT_AMT," ).append("\n"); 
		query.append("FLG," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM   (SELECT   CREDITS," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("PSO_BZTP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("CALL_SEQ," ).append("\n"); 
		query.append("DECODE (grp2," ).append("\n"); 
		query.append("1, DECODE (grp, 1, 'ZZZZZZTTL', acct_cd)," ).append("\n"); 
		query.append("lgs_cost_cd)" ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("(SELECT   x.lgs_cost_full_nm" ).append("\n"); 
		query.append("FROM   TES_LGS_COST x" ).append("\n"); 
		query.append("WHERE   x.lgs_cost_cd =" ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("grp2," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("DECODE (grp, 1, 'ZZZZZZTTL', z.acct_cd)," ).append("\n"); 
		query.append("z.lgs_cost_cd" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("LGS_COST_FULL_NM," ).append("\n"); 
		query.append("DECODE (grp2," ).append("\n"); 
		query.append("1, DECODE (grp, 1, 'TTL', acct_cd)," ).append("\n"); 
		query.append("lgs_cost_cd)" ).append("\n"); 
		query.append("dsp_cost_cd," ).append("\n"); 
		query.append("(SELECT   SUM (Y.RQST_AMT)" ).append("\n"); 
		query.append("FROM   PSO_CNL_TZ_FEE X, PSO_CNL_TZ_FEE_DTL Y" ).append("\n"); 
		query.append("WHERE   X.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("AND X.CNL_TZ_PROC_STS_CD = 'C'" ).append("\n"); 
		query.append("AND X.REV_YRMON BETWEEN TO_CHAR (" ).append("\n"); 
		query.append("ADD_MONTHS (" ).append("\n"); 
		query.append("TO_DATE (@[rev_yrmon]," ).append("\n"); 
		query.append("'yyyymm')," ).append("\n"); 
		query.append("-6" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  TO_CHAR (" ).append("\n"); 
		query.append("ADD_MONTHS (" ).append("\n"); 
		query.append("TO_DATE (" ).append("\n"); 
		query.append("@[rev_yrmon]," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("-1" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND X.PSO_BZTP_CD = z.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND z.VSL_CD = X.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND z.CALL_SEQ = X.CALL_SEQ" ).append("\n"); 
		query.append("AND z.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND Y.PSO_BZTP_CD = X.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND Y.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND Y.SKD_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND Y.CALL_SEQ = X.CALL_SEQ" ).append("\n"); 
		query.append("AND Y.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND Y.LGS_COST_CD =" ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("grp2," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("DECODE (grp, 1, 'ZZZZZZTTL', acct_cd)," ).append("\n"); 
		query.append("lgs_cost_cd" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("LAST_INV," ).append("\n"); 
		query.append("debits RQST_AMT," ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("grp2," ).append("\n"); 
		query.append("1, nvl(debits,0) - nvl(credits,0), debits-credits) BALANCE," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("CALC_AMT," ).append("\n"); 
		query.append("YD_CHG_NO," ).append("\n"); 
		query.append("YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("DECODE (grp + grp2, 0, foml_desc) DFLT_XPR_DESC," ).append("\n"); 
		query.append("DECODE (grp + grp2, 0, xpr_desc) SYS_XPR_DESC," ).append("\n"); 
		query.append("DECODE (grp + grp2, 0, xpr_desc) DFLT_SYS_XPR_DESC," ).append("\n"); 
		query.append("(SELECT   x.inv_no" ).append("\n"); 
		query.append("FROM   pso_charge x" ).append("\n"); 
		query.append("WHERE   x.ISS_CTY_CD = z.ISS_CTY_CD" ).append("\n"); 
		query.append("AND x.SO_SEQ = z.SO_SEQ)" ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("(SELECT   x.inv_rgst_no" ).append("\n"); 
		query.append("FROM   pso_charge x" ).append("\n"); 
		query.append("WHERE   x.ISS_CTY_CD = z.ISS_CTY_CD" ).append("\n"); 
		query.append("AND x.SO_SEQ = z.SO_SEQ)" ).append("\n"); 
		query.append("INV_RGST_NO," ).append("\n"); 
		query.append("SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("LOCL_XCH_RT," ).append("\n"); 
		query.append("TR_VOL_VAL," ).append("\n"); 
		query.append("SCG_RT_AMT," ).append("\n"); 
		query.append("grp + grp2 flg" ).append("\n"); 
		query.append("--, z.*" ).append("\n"); 
		query.append("FROM   (  SELECT   MAX (LGS_COST_CD) LGS_COST_CD," ).append("\n"); 
		query.append("SUBSTR (LGS_COST_CD, 1, 4) acct_cd," ).append("\n"); 
		query.append("SUM (CALC_AMT) calc_amt," ).append("\n"); 
		query.append("SUM (debits) debits," ).append("\n"); 
		query.append("SUM (credits) credits," ).append("\n"); 
		query.append("GROUPING (SUBSTR (LGS_COST_CD, 1, 4)) grp," ).append("\n"); 
		query.append("GROUPING (LGS_COST_CD) grp2," ).append("\n"); 
		query.append("MAX (LGS_COST_FULL_NM) LGS_COST_FULL_NM," ).append("\n"); 
		query.append("MAX (DIFF_RMK) DIFF_RMK," ).append("\n"); 
		query.append("--         max(CALC_AMT) CALC_AMT," ).append("\n"); 
		query.append("MAX (foml_desc) foml_desc," ).append("\n"); 
		query.append("MAX (xpr_desc) xpr_desc," ).append("\n"); 
		query.append("MAX (VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("MAX (PSO_BZTP_CD) PSO_BZTP_CD," ).append("\n"); 
		query.append("MAX (VSL_CD) VSL_CD," ).append("\n"); 
		query.append("MAX (SKD_VOY_NO) SKD_VOY_NO," ).append("\n"); 
		query.append("MAX (SKD_DIR_CD) SKD_DIR_CD," ).append("\n"); 
		query.append("MAX (YD_CD) YD_CD," ).append("\n"); 
		query.append("MAX (CALL_SEQ) CALL_SEQ," ).append("\n"); 
		query.append("MAX (YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("MAX (YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("MAX (ISS_CTY_CD) ISS_CTY_CD," ).append("\n"); 
		query.append("MAX (SO_SEQ) SO_SEQ," ).append("\n"); 
		query.append("MAX (SUZ_NET_TONG_WGT) SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("MAX (LOCL_XCH_RT) LOCL_XCH_RT," ).append("\n"); 
		query.append("MAX (TR_VOL_VAL) TR_VOL_VAL," ).append("\n"); 
		query.append("MAX (SCG_RT_AMT) SCG_RT_AMT" ).append("\n"); 
		query.append("FROM   (SELECT   cnl_tz_bztp_cd," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("c1.lgs_cost_cd," ).append("\n"); 
		query.append("'E'," ).append("\n"); 
		query.append("c1.lgs_cost_cd || '  ')" ).append("\n"); 
		query.append("lgs_cost_cd," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'E', rqst_amt)" ).append("\n"); 
		query.append("debits," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'I', rqst_amt)" ).append("\n"); 
		query.append("credits," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'I', calc_amt)" ).append("\n"); 
		query.append("calc_amt," ).append("\n"); 
		query.append("C1.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T2.DIFF_RMK)" ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T2.foml_desc)" ).append("\n"); 
		query.append("foml_desc," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T2.xpr_desc)" ).append("\n"); 
		query.append("xpr_desc," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.VNDR_SEQ)" ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.PSO_BZTP_CD)" ).append("\n"); 
		query.append("PSO_BZTP_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.VSL_CD)" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.SKD_VOY_NO)" ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.SKD_DIR_CD)" ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'I', T1.YD_CD)" ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.CALL_SEQ)" ).append("\n"); 
		query.append("CALL_SEQ," ).append("\n"); 
		query.append("T2.YD_CHG_NO," ).append("\n"); 
		query.append("T2.YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T2.YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T2.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("decode(cnl_tz_bztp_cd, 'I',T1.ISS_CTY_CD) ISS_CTY_CD," ).append("\n"); 
		query.append("decode(cnl_tz_bztp_cd, 'I',T1.SO_SEQ) SO_SEQ," ).append("\n"); 
		query.append("--T1.ISS_CTY_CD," ).append("\n"); 
		query.append("--T1.SO_SEQ," ).append("\n"); 
		query.append("T1.SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("T1.LOCL_XCH_RT," ).append("\n"); 
		query.append("T1.TR_VOL_VAL," ).append("\n"); 
		query.append("T1.SCG_RT_AMT" ).append("\n"); 
		query.append("--decode(cnl_tz_bztp_cd, 'I',T1.ISS_CTY_CD) ISS_CTY_CD," ).append("\n"); 
		query.append("--decode(cnl_tz_bztp_cd, 'I',T1.SO_SEQ) SO_SEQ," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.SUZ_NET_TONG_WGT) SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.LOCL_XCH_RT) LOCL_XCH_RT," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.TR_VOL_VAL) TR_VOL_VAL," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.SCG_RT_AMT) SCG_RT_AMT" ).append("\n"); 
		query.append("FROM   PSO_CNL_TZ_FEE T1," ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE_DTL T2," ).append("\n"); 
		query.append("TES_LGS_COST C1" ).append("\n"); 
		query.append("WHERE       T1.PSO_BZTP_CD = T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.YD_CD = T2.YD_CD" ).append("\n"); 
		query.append("AND T1.CALL_SEQ = T2.CALL_SEQ" ).append("\n"); 
		query.append("AND T2.LGS_COST_CD = C1.LGS_COST_CD" ).append("\n"); 
		query.append("AND T1.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("AND T1.YD_CD =  @[yd_cd]" ).append("\n"); 
		query.append("AND T1.CNL_TZ_BZTP_CD IN ('I', 'E')" ).append("\n"); 
		query.append("AND T1.NTC_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND T1.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = substr(@[vvd], 9))" ).append("\n"); 
		query.append("GROUP BY   ROLLUP (SUBSTR (LGS_COST_CD, 1, 4)," ).append("\n"); 
		query.append("LGS_COST_CD)) z" ).append("\n"); 
		query.append("WHERE   NOT (    z.calc_amt IS NULL" ).append("\n"); 
		query.append("AND z.grp2 = 0" ).append("\n"); 
		query.append("AND z.credits IS NULL)) T1," ).append("\n"); 
		query.append("(  SELECT   LGS_COST_CD," ).append("\n"); 
		query.append("MAX (YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("MAX (YD_CHG_VER_SEQ) YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG" ).append("\n"); 
		query.append("WHERE       YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND TO_DATE (@[rev_yrmon], 'yyyymm') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("GROUP BY   LGS_COST_CD) T2" ).append("\n"); 
		query.append("WHERE   T1.LGS_COST_CD = T2.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND @[sts] <> 10" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   CREDITS," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("PSO_BZTP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("CALL_SEQ," ).append("\n"); 
		query.append("decode(flg, 2, null, DSP_COST_CD ) LGS_COST_CD," ).append("\n"); 
		query.append("decode(flg, 2, 'TTL Amount:', LGS_COST_FULL_NM) LGS_COST_FULL_NM," ).append("\n"); 
		query.append("LAST_INV," ).append("\n"); 
		query.append("RQST_AMT," ).append("\n"); 
		query.append("BALANCE," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("CALC_AMT," ).append("\n"); 
		query.append("YD_CHG_NO," ).append("\n"); 
		query.append("YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("DFLT_XPR_DESC," ).append("\n"); 
		query.append("SYS_XPR_DESC," ).append("\n"); 
		query.append("DFLT_SYS_XPR_DESC," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("INV_RGST_NO," ).append("\n"); 
		query.append("SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("LOCL_XCH_RT," ).append("\n"); 
		query.append("TR_VOL_VAL," ).append("\n"); 
		query.append("SCG_RT_AMT," ).append("\n"); 
		query.append("FLG," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM   (SELECT   CREDITS," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("PSO_BZTP_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("CALL_SEQ," ).append("\n"); 
		query.append("DECODE (grp2," ).append("\n"); 
		query.append("1, DECODE (grp, 1, 'ZZZZZZTTL', acct_cd)," ).append("\n"); 
		query.append("lgs_cost_cd)" ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("(SELECT   x.lgs_cost_full_nm" ).append("\n"); 
		query.append("FROM   TES_LGS_COST x" ).append("\n"); 
		query.append("WHERE   x.lgs_cost_cd =" ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("grp2," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("DECODE (grp, 1, 'ZZZZZZTTL', z.acct_cd)," ).append("\n"); 
		query.append("z.lgs_cost_cd" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("LGS_COST_FULL_NM," ).append("\n"); 
		query.append("DECODE (grp2," ).append("\n"); 
		query.append("1, DECODE (grp, 1, 'TTL', acct_cd)," ).append("\n"); 
		query.append("lgs_cost_cd)" ).append("\n"); 
		query.append("dsp_cost_cd," ).append("\n"); 
		query.append("(SELECT   SUM (Y.RQST_AMT)" ).append("\n"); 
		query.append("FROM   PSO_CNL_TZ_FEE X, PSO_CNL_TZ_FEE_DTL Y" ).append("\n"); 
		query.append("WHERE   X.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("AND X.CNL_TZ_PROC_STS_CD = 'C'" ).append("\n"); 
		query.append("AND X.REV_YRMON BETWEEN TO_CHAR (" ).append("\n"); 
		query.append("ADD_MONTHS (" ).append("\n"); 
		query.append("TO_DATE (@[rev_yrmon]," ).append("\n"); 
		query.append("'yyyymm')," ).append("\n"); 
		query.append("-6" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  TO_CHAR (" ).append("\n"); 
		query.append("ADD_MONTHS (" ).append("\n"); 
		query.append("TO_DATE (" ).append("\n"); 
		query.append("@[rev_yrmon]," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("-1" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND X.PSO_BZTP_CD = z.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND z.VSL_CD = X.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND z.CALL_SEQ = X.CALL_SEQ" ).append("\n"); 
		query.append("AND z.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND Y.PSO_BZTP_CD = X.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND Y.SKD_VOY_NO = X.SKD_VOY_NO" ).append("\n"); 
		query.append("AND Y.SKD_DIR_CD = X.SKD_DIR_CD" ).append("\n"); 
		query.append("AND Y.CALL_SEQ = X.CALL_SEQ" ).append("\n"); 
		query.append("AND Y.YD_CD = X.YD_CD" ).append("\n"); 
		query.append("AND Y.LGS_COST_CD =" ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("grp2," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("DECODE (grp, 1, 'ZZZZZZTTL', acct_cd)," ).append("\n"); 
		query.append("lgs_cost_cd" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("LAST_INV," ).append("\n"); 
		query.append("debits RQST_AMT," ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("grp2," ).append("\n"); 
		query.append("1, nvl(debits,0) - nvl(credits,0), debits-credits) BALANCE," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("CALC_AMT," ).append("\n"); 
		query.append("YD_CHG_NO," ).append("\n"); 
		query.append("YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("DECODE (grp + grp2, 0, foml_desc) DFLT_XPR_DESC," ).append("\n"); 
		query.append("DECODE (grp + grp2, 0, xpr_desc) SYS_XPR_DESC," ).append("\n"); 
		query.append("DECODE (grp + grp2, 0, xpr_desc) DFLT_SYS_XPR_DESC," ).append("\n"); 
		query.append("(SELECT   x.inv_no" ).append("\n"); 
		query.append("FROM   pso_charge x" ).append("\n"); 
		query.append("WHERE   x.ISS_CTY_CD = z.ISS_CTY_CD" ).append("\n"); 
		query.append("AND x.SO_SEQ = z.SO_SEQ)" ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("(SELECT   x.inv_rgst_no" ).append("\n"); 
		query.append("FROM   pso_charge x" ).append("\n"); 
		query.append("WHERE   x.ISS_CTY_CD = z.ISS_CTY_CD" ).append("\n"); 
		query.append("AND x.SO_SEQ = z.SO_SEQ)" ).append("\n"); 
		query.append("INV_RGST_NO," ).append("\n"); 
		query.append("SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("LOCL_XCH_RT," ).append("\n"); 
		query.append("TR_VOL_VAL," ).append("\n"); 
		query.append("SCG_RT_AMT," ).append("\n"); 
		query.append("grp + grp2 flg" ).append("\n"); 
		query.append("--, z.*" ).append("\n"); 
		query.append("FROM   (  SELECT   MAX (LGS_COST_CD) LGS_COST_CD," ).append("\n"); 
		query.append("SUBSTR (LGS_COST_CD, 1, 4) acct_cd," ).append("\n"); 
		query.append("SUM (CALC_AMT) calc_amt," ).append("\n"); 
		query.append("SUM (debits) debits," ).append("\n"); 
		query.append("SUM (credits) credits," ).append("\n"); 
		query.append("GROUPING (SUBSTR (LGS_COST_CD, 1, 4)) grp," ).append("\n"); 
		query.append("GROUPING (LGS_COST_CD) grp2," ).append("\n"); 
		query.append("MAX (LGS_COST_FULL_NM) LGS_COST_FULL_NM," ).append("\n"); 
		query.append("MAX (DIFF_RMK) DIFF_RMK," ).append("\n"); 
		query.append("--         max(CALC_AMT) CALC_AMT," ).append("\n"); 
		query.append("MAX (foml_desc) foml_desc," ).append("\n"); 
		query.append("MAX (xpr_desc) xpr_desc," ).append("\n"); 
		query.append("MAX (VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("MAX (PSO_BZTP_CD) PSO_BZTP_CD," ).append("\n"); 
		query.append("MAX (VSL_CD) VSL_CD," ).append("\n"); 
		query.append("MAX (SKD_VOY_NO) SKD_VOY_NO," ).append("\n"); 
		query.append("MAX (SKD_DIR_CD) SKD_DIR_CD," ).append("\n"); 
		query.append("MAX (YD_CD) YD_CD," ).append("\n"); 
		query.append("MAX (CALL_SEQ) CALL_SEQ," ).append("\n"); 
		query.append("MAX (YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("MAX (YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("MAX (ISS_CTY_CD) ISS_CTY_CD," ).append("\n"); 
		query.append("MAX (SO_SEQ) SO_SEQ," ).append("\n"); 
		query.append("MAX (SUZ_NET_TONG_WGT) SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("MAX (LOCL_XCH_RT) LOCL_XCH_RT," ).append("\n"); 
		query.append("MAX (TR_VOL_VAL) TR_VOL_VAL," ).append("\n"); 
		query.append("MAX (SCG_RT_AMT) SCG_RT_AMT" ).append("\n"); 
		query.append("FROM   (SELECT   cnl_tz_bztp_cd," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("c1.lgs_cost_cd," ).append("\n"); 
		query.append("'E'," ).append("\n"); 
		query.append("c1.lgs_cost_cd || '  ')" ).append("\n"); 
		query.append("lgs_cost_cd," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'E', rqst_amt)" ).append("\n"); 
		query.append("debits," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'I', rqst_amt)" ).append("\n"); 
		query.append("credits," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'I', calc_amt)" ).append("\n"); 
		query.append("calc_amt," ).append("\n"); 
		query.append("C1.LGS_COST_FULL_NM," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T2.DIFF_RMK)" ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T2.foml_desc)" ).append("\n"); 
		query.append("foml_desc," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T2.xpr_desc)" ).append("\n"); 
		query.append("xpr_desc," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.VNDR_SEQ)" ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.PSO_BZTP_CD)" ).append("\n"); 
		query.append("PSO_BZTP_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.VSL_CD)" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.SKD_VOY_NO)" ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd," ).append("\n"); 
		query.append("'I'," ).append("\n"); 
		query.append("T1.SKD_DIR_CD)" ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE (cnl_tz_bztp_cd, 'I', T1.YD_CD)" ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("T1.CALL_SEQ," ).append("\n"); 
		query.append("T2.YD_CHG_NO," ).append("\n"); 
		query.append("T2.YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T2.YD_CHG_NO) YD_CHG_NO," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T2.YD_CHG_VER_SEQ) YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("T1.ISS_CTY_CD," ).append("\n"); 
		query.append("T1.SO_SEQ," ).append("\n"); 
		query.append("T1.SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("T1.LOCL_XCH_RT," ).append("\n"); 
		query.append("T1.TR_VOL_VAL," ).append("\n"); 
		query.append("T1.SCG_RT_AMT" ).append("\n"); 
		query.append("--decode(cnl_tz_bztp_cd, 'I',T1.ISS_CTY_CD) ISS_CTY_CD," ).append("\n"); 
		query.append("--decode(cnl_tz_bztp_cd, 'I',T1.SO_SEQ) SO_SEQ," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.SUZ_NET_TONG_WGT) SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.LOCL_XCH_RT) LOCL_XCH_RT," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.TR_VOL_VAL) TR_VOL_VAL," ).append("\n"); 
		query.append("--                 decode(cnl_tz_bztp_cd, 'I',T1.SCG_RT_AMT) SCG_RT_AMT" ).append("\n"); 
		query.append("FROM   PSO_CNL_TZ_FEE T1," ).append("\n"); 
		query.append("PSO_CNL_TZ_FEE_DTL T2," ).append("\n"); 
		query.append("TES_LGS_COST C1" ).append("\n"); 
		query.append("WHERE       T1.PSO_BZTP_CD = T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.YD_CD = T2.YD_CD" ).append("\n"); 
		query.append("AND T1.CALL_SEQ = T2.CALL_SEQ" ).append("\n"); 
		query.append("AND T2.LGS_COST_CD = C1.LGS_COST_CD" ).append("\n"); 
		query.append("AND T1.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("AND T1.YD_CD =  @[yd_cd]" ).append("\n"); 
		query.append("AND T1.CNL_TZ_BZTP_CD IN ('I', 'E')" ).append("\n"); 
		query.append("AND T1.NTC_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND T1.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = substr(@[vvd], 9))" ).append("\n"); 
		query.append("GROUP BY   ROLLUP (SUBSTR (LGS_COST_CD, 1, 4)," ).append("\n"); 
		query.append("LGS_COST_CD)) z" ).append("\n"); 
		query.append("WHERE   NOT (    z.calc_amt IS NULL" ).append("\n"); 
		query.append("AND z.grp2 = 0" ).append("\n"); 
		query.append("AND z.credits IS NULL)) T1" ).append("\n"); 
		query.append("WHERE   @[sts] = 10" ).append("\n"); 
		query.append("ORDER BY   lgs_cost_cd, flg DESC" ).append("\n"); 

	}
}