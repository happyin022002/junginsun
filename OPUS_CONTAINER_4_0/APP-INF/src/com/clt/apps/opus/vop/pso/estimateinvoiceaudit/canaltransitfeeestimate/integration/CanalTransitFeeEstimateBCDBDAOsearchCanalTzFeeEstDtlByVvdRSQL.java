/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD별 상세 운항통합비를 조회합니다.
	  * -------------------------------------------------------------------
	  * ** 변경이력 **
	  * -------------------------------------------------------------------
	  * [CHM-201005061-01]
	  * Due Date를 무조건 ETA-1 기준으로 조회
	  * (이후 로직에서 휴일연산함)
	  * -------------------------------------------------------------------
	  * </pre>
	  */
	public CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL(){
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
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeEstDtlByVvdRSQL").append("\n"); 
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
		query.append("SELECT   SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("           LOCL_XCH_RT," ).append("\n"); 
		query.append("           TR_VOL_VAL," ).append("\n"); 
		query.append("           SCG_RT_AMT," ).append("\n"); 
		query.append("           DUE_DT," ).append("\n"); 
		query.append("           VNDR_SEQ," ).append("\n"); 
		query.append("           PSO_BZTP_CD," ).append("\n"); 
		query.append("           VSL_CD," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           YD_CD," ).append("\n"); 
		query.append("           CALL_SEQ," ).append("\n"); 
		query.append("           LGS_COST_CD," ).append("\n"); 
		query.append("           LGS_COST_FULL_NM," ).append("\n"); 
		query.append("           RQST_AMT," ).append("\n"); 
		query.append("           DIFF_RMK," ).append("\n"); 
		query.append("           CALC_AMT," ).append("\n"); 
		query.append("           YD_CHG_NO," ).append("\n"); 
		query.append("           YD_CHG_VER_SEQ," ).append("\n"); 
		query.append("           DFLT_XPR_DESC," ).append("\n"); 
		query.append("           SYS_XPR_DESC," ).append("\n"); 
		query.append("           DFLT_SYS_XPR_DESC," ).append("\n"); 
		query.append("           INV_NO," ).append("\n"); 
		query.append("		   INV_RGST_NO," ).append("\n"); 
		query.append("           (SELECT   x.cntr_pnm_capa" ).append("\n"); 
		query.append("              FROM   mdm_vsl_cntr x" ).append("\n"); 
		query.append("             WHERE   x.vsl_cd = Z.vsl_cd)" ).append("\n"); 
		query.append("              cntr_pnm_capa," ).append("\n"); 
		query.append(" VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("    FROM   (select " ).append("\n"); 
		query.append(" max(SUZ_NET_TONG_WGT) SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append(",max(LOCL_XCH_RT) LOCL_XCH_RT" ).append("\n"); 
		query.append(",max(TR_VOL_VAL) TR_VOL_VAL    " ).append("\n"); 
		query.append(",max(SCG_RT_AMT) SCG_RT_AMT    " ).append("\n"); 
		query.append(",max(DUE_DT) DUE_DT" ).append("\n"); 
		query.append(",max(VNDR_SEQ) VNDR_SEQ    " ).append("\n"); 
		query.append(",max(PSO_BZTP_CD) PSO_BZTP_CD    " ).append("\n"); 
		query.append(",max(VSL_CD) VSL_CD    " ).append("\n"); 
		query.append(",max(SKD_VOY_NO)     SKD_VOY_NO" ).append("\n"); 
		query.append(",max(SKD_DIR_CD) SKD_DIR_CD    " ).append("\n"); 
		query.append(",max(YD_CD) YD_CD   " ).append("\n"); 
		query.append(",max(CALL_SEQ) CALL_SEQ    " ).append("\n"); 
		query.append(",LGS_COST_CD    " ).append("\n"); 
		query.append(",max(LGS_COST_FULL_NM) LGS_COST_FULL_NM    " ).append("\n"); 
		query.append(",max(RQST_AMT) RQST_AMT    " ).append("\n"); 
		query.append(",max(DIFF_RMK) DIFF_RMK    " ).append("\n"); 
		query.append(",max(CALC_AMT) CALC_AMT    " ).append("\n"); 
		query.append(",YD_CHG_NO    " ).append("\n"); 
		query.append(",YD_CHG_VER_SEQ    " ).append("\n"); 
		query.append(",max(DFLT_XPR_DESC) DFLT_XPR_DESC    " ).append("\n"); 
		query.append(",max(SYS_XPR_DESC) SYS_XPR_DESC    " ).append("\n"); 
		query.append(",max(DFLT_SYS_XPR_DESC) DFLT_SYS_XPR_DESC    " ).append("\n"); 
		query.append(",max(INV_NO) INV_NO " ).append("\n"); 
		query.append(",max(INV_RGST_NO) INV_RGST_NO" ).append("\n"); 
		query.append("from " ).append("\n"); 
		query.append("(select " ).append("\n"); 
		query.append("T5.SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("T5.LOCL_XCH_RT," ).append("\n"); 
		query.append("T5.TR_VOL_VAL," ).append("\n"); 
		query.append("T5.SCG_RT_AMT," ).append("\n"); 
		query.append("(SELECT   TO_CHAR(VPS_ETA_DT-1, 'YYYYMMDD')" ).append("\n"); 
		query.append("  FROM   vsk_vsl_port_skd" ).append("\n"); 
		query.append(" WHERE       VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("         AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("         AND SKD_DIR_CD= substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("         AND YD_CD = @[yd_cd]) DUE_DT," ).append("\n"); 
		query.append("T5.VNDR_SEQ," ).append("\n"); 
		query.append("T1.PSO_BZTP_CD,T1.VSL_CD,T1.SKD_VOY_NO,T1.SKD_DIR_CD,T1.YD_CD,T1.CALL_SEQ" ).append("\n"); 
		query.append(", nvl(T2.LGS_COST_CD, T1.LGS_COST_CD) lgs_cost_cd" ).append("\n"); 
		query.append(", (select x.LGS_COST_FULL_NM from TES_LGS_COST x where x.LGS_COST_CD = T1.LGS_COST_CD) LGS_COST_FULL_NM" ).append("\n"); 
		query.append(",T1.RQST_AMT" ).append("\n"); 
		query.append(",replace(replace(T1.DIFF_RMK, chr(13), to_char(00)), chr(10), to_char(1)) DIFF_RMK" ).append("\n"); 
		query.append(",null CALC_AMT" ).append("\n"); 
		query.append(",T2.yd_chg_no" ).append("\n"); 
		query.append(",T2.yd_chg_ver_seq" ).append("\n"); 
		query.append(",T4.DFLT_XPR_DESC" ).append("\n"); 
		query.append(",T4.SYS_XPR_DESC" ).append("\n"); 
		query.append(",T4.DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append(",'' INV_NO" ).append("\n"); 
		query.append(",'' INV_RGST_NO" ).append("\n"); 
		query.append("from pso_cnl_tz_fee T5, pso_cnl_tz_fee_dtl T1, (" ).append("\n"); 
		query.append("select lgs_cost_cd, max(yd_chg_no) yd_chg_no, max(yd_chg_ver_seq) yd_chg_ver_seq from pso_yd_chg" ).append("\n"); 
		query.append("where yd_cd = @[yd_cd]--'EGSCA10'" ).append("\n"); 
		query.append("and vndr_seq = @[vndr_seq]--100870" ).append("\n"); 
		query.append("and to_date(@[rev_yrmon], 'yyyymm') between eff_dt and exp_dt" ).append("\n"); 
		query.append("group by lgs_cost_cd ) T2  , pso_yd_chg_xpr T3, pso_chg_xpr T4" ).append("\n"); 
		query.append("where " ).append("\n"); 
		query.append("    T5.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("AND T5.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T5.SKD_DIR_CD= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T5.CALL_SEQ = T1.CALL_SEQ" ).append("\n"); 
		query.append("AND T5.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("and     T2.LGS_COST_CD  (+) like T1.LGS_COST_CD || '%'" ).append("\n"); 
		query.append("and   T2.yd_chg_no = T3.yd_chg_no   (+)" ).append("\n"); 
		query.append("and   T2.yd_chg_ver_seq = T3.yd_chg_ver_seq (+)" ).append("\n"); 
		query.append("and   T3.chg_xpr_no = T4.chg_xpr_no (+)" ).append("\n"); 
		query.append("and   T5.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("#if( ${call_seq} != '')" ).append("\n"); 
		query.append("AND   T5.CALL_SEQ = @[call_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   T5.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("AND T5.YD_CD = @[yd_cd]--'EGSCA10'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if( ${vvd} != '')" ).append("\n"); 
		query.append("AND T5.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND T5.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND T5.SKD_DIR_CD= substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND (@[sts] <> 10 and @[sts] <> 12)   -- ('12' <> 10 and '12' <> 12 )" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT   T5.SUZ_NET_TONG_WGT," ).append("\n"); 
		query.append("         T5.LOCL_XCH_RT," ).append("\n"); 
		query.append("         T5.TR_VOL_VAL," ).append("\n"); 
		query.append("         T5.SCG_RT_AMT," ).append("\n"); 
		query.append("		 (select TO_CHAR(NVL(p.ap_pay_dt,x.due_dt), 'YYYYMMDD') " ).append("\n"); 
		query.append("		    from pso_charge x, ap_pay_inv p" ).append("\n"); 
		query.append("			where x.ISS_CTY_CD = T6.ISS_CTY_CD " ).append("\n"); 
		query.append("			and x.SO_SEQ = T6.SO_SEQ" ).append("\n"); 
		query.append("			and x.inv_no = p.inv_no(+)" ).append("\n"); 
		query.append("			and p.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("			) DUE_DT," ).append("\n"); 
		query.append("         T5.VNDR_SEQ," ).append("\n"); 
		query.append("         T1.PSO_BZTP_CD," ).append("\n"); 
		query.append("         T1.VSL_CD," ).append("\n"); 
		query.append("         T1.SKD_VOY_NO," ).append("\n"); 
		query.append("         T1.SKD_DIR_CD," ).append("\n"); 
		query.append("         T1.YD_CD," ).append("\n"); 
		query.append("         T1.CALL_SEQ," ).append("\n"); 
		query.append("         T1.LGS_COST_CD," ).append("\n"); 
		query.append("         (SELECT   x.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("            FROM   TES_LGS_COST x" ).append("\n"); 
		query.append("           WHERE   x.LGS_COST_CD = T1.LGS_COST_CD)" ).append("\n"); 
		query.append("            LGS_COST_FULL_NM," ).append("\n"); 
		query.append("         T1.RQST_AMT," ).append("\n"); 
		query.append("         REPLACE (REPLACE (T1.DIFF_RMK, CHR (13), TO_CHAR (00))," ).append("\n"); 
		query.append("                  CHR (10)," ).append("\n"); 
		query.append("                  TO_CHAR (1))" ).append("\n"); 
		query.append("            DIFF_RMK," ).append("\n"); 
		query.append("         T1.CALC_AMT," ).append("\n"); 
		query.append("         T1.yd_chg_no," ).append("\n"); 
		query.append("         T1.yd_chg_ver_seq," ).append("\n"); 
		query.append("         T1.XPR_DESC," ).append("\n"); 
		query.append("		 T1.foml_DESC," ).append("\n"); 
		query.append("         '' DFLT_SYS_XPR_DESC," ).append("\n"); 
		query.append("         T6.INV_NO," ).append("\n"); 
		query.append("         T6.INV_RGST_NO /*2009.12.15 add*/" ).append("\n"); 
		query.append("  FROM   pso_cnl_tz_fee T5," ).append("\n"); 
		query.append("         pso_cnl_tz_fee_dtl T1," ).append("\n"); 
		query.append("         pso_charge T6" ).append("\n"); 
		query.append(" WHERE       T5.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("         AND T5.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND T5.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND T5.CALL_SEQ = T1.CALL_SEQ" ).append("\n"); 
		query.append("         AND T5.YD_CD = T1.YD_CD" ).append("\n"); 
		query.append("         AND T6.ISS_CTY_CD = T5.ISS_CTY_CD" ).append("\n"); 
		query.append("         AND T6.SO_SEQ = T5.SO_SEQ" ).append("\n"); 
		query.append("         AND T5.PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("         AND T5.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append("		 AND T5.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("#if( ${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   T5.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${yd_cd} != '' ) " ).append("\n"); 
		query.append("AND T5.YD_CD = @[yd_cd]--'EGSCA10'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if( ${vvd} != '')" ).append("\n"); 
		query.append("AND T5.VSL_CD = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND T5.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND T5.SKD_DIR_CD= substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ( @[sts] = 10 or @[sts] = 12 )  --('12' = 10 or 12 = 12 )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("group by lgs_cost_cd, yd_chg_no, yd_chg_ver_seq" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("ORDER BY   Z.lgs_cost_cd" ).append("\n"); 

	}
}