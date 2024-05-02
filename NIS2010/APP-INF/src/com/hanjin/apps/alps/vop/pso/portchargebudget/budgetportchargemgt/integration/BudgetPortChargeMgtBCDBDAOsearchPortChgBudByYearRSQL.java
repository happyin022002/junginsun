/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchPortChgBudByYearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.08.20 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOsearchPortChgBudByYearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 년도별 사업 계획을 조회한다.
	  * =====================================================================
	  * 2011.03.28 진마리아 [선처리(SRM-201114694)] 사업계획 항비 로직 수정 요청
	  * 2012.08.20 진마리아 CHM-201219078-01 사업계획 - 시나리오 연도 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchPortChgBudByYearRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtedate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchPortChgBudByYearRSQL").append("\n"); 
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
		query.append("/*PortChgBudByYear VO*/" ).append("\n"); 
		query.append("SELECT T.EXPN_YRMON," ).append("\n"); 
		query.append("  T.VSl_SLAN_CD," ).append("\n"); 
		query.append("  MAX(CASE WHEN XPR_DESC LIKE '%info%null%' OR XPR_DESC LIKE '%no-rate%' OR XPR_DESC IS NULL THEN 'Y'" ).append("\n"); 
		query.append("           ELSE 'N'" ).append("\n"); 
		query.append("      END) ERR,	" ).append("\n"); 
		query.append("  T.VSL_CD" ).append("\n"); 
		query.append("  ||T.SKD_VOY_NO" ).append("\n"); 
		query.append("  ||T.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("  SUM(INV_USD_AMT) AMT" ).append("\n"); 
		query.append("  ,'' txtsdate" ).append("\n"); 
		query.append("  ,'' txtedate" ).append("\n"); 
		query.append("  ,T.VSL_CLSS VSL_CLS" ).append("\n"); 
		query.append("  ,max(T.VSL_CD) vsl_cd" ).append("\n"); 
		query.append("  ,max(T.SKD_VOY_NO) skd_voy_no" ).append("\n"); 
		query.append("  ,max(T.SKD_DIR_CD) skd_dir_cd" ).append("\n"); 
		query.append("  ,decode(T.vsl_slan_cd, max((select x.vsl_slan_cd from vsk_bud_vsl_skd x where x.vsl_cd = T.vsl_cd " ).append("\n"); 
		query.append("                               and x.skd_voy_no = T.skd_voy_no and x.skd_dir_cd = T.skd_dir_cd)), null" ).append("\n"); 
		query.append("          ,max((select x.vsl_slan_cd from vsk_bud_vsl_skd x where x.vsl_cd = T.vsl_cd and x.skd_voy_no = T.skd_voy_no" ).append("\n"); 
		query.append("                and x.skd_dir_cd = T.skd_dir_cd))||' - Mismatched Lane Code with SKED') rmk" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("  ( SELECT DISTINCT T1.PSO_BZTP_CD," ).append("\n"); 
		query.append("    T1.EXPN_YRMON," ).append("\n"); 
		query.append("    T1.VSL_CD," ).append("\n"); 
		query.append("    T1.SKD_VOY_NO," ).append("\n"); 
		query.append("    T1.SKD_DIR_CD," ).append("\n"); 
		query.append("    T1.VSl_SLAN_CD," ).append("\n"); 
		query.append("    T2.YD_CD," ).append("\n"); 
		query.append("    C.LGS_COST_CD" ).append("\n"); 
		query.append("    --,T1.VSL_CNTR_CLSS_CAPA CLSS : ?????" ).append("\n"); 
		query.append("	,T1.CNTR_VSL_CLSS_CAPA VSL_CLSS" ).append("\n"); 
		query.append("    ,C.VNDR_SEQ" ).append("\n"); 
		query.append("    ,T1.BUD_SCNR_NO" ).append("\n"); 
		query.append("  FROM PSO_TGT_VVD T1," ).append("\n"); 
		query.append("    PSO_TGT_YD_SKD T2," ).append("\n"); 
		query.append("    PSO_YD_CHG C" ).append("\n"); 
		query.append("  WHERE T1.VSL_CD    = T2.VSL_CD" ).append("\n"); 
		query.append("  AND T1.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND T1.SKD_DIR_CD  = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND T1.PSO_BZTP_CD = T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("  AND T1.BUD_SCNR_NO = T2.BUD_SCNR_NO" ).append("\n"); 
		query.append("  AND T1.PSO_BZTP_CD = '1'--'5'" ).append("\n"); 
		query.append("  AND T2.YD_CD       = C.YD_CD" ).append("\n"); 
		query.append("  AND C.CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("  AND C.LST_FLG = 'Y'" ).append("\n"); 
		query.append("--  AND TO_DATE(T1.EXPN_YRMON, 'YYYYMM') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("  AND T1.EXPN_YRMON BETWEEN TO_CHAR(C.EFF_DT, 'YYYYMM') AND TO_CHAR(C.EXP_DT,'YYYYMM')  " ).append("\n"); 
		query.append("#if(${txtsdate}!='')" ).append("\n"); 
		query.append("  AND T1.EXPN_YRMON BETWEEN replace(@[txtsdate],'-','') AND replace(@[txtedate],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND TO_CHAR(T1.CRE_DT,'YYYYMM') = (SELECT MAX(TO_CHAR(CRE_DT,'YYYYMM')) FROM PSO_TGT_VVD WHERE PSO_BZTP_CD='1')--BUD_SCNR_NO 조건 없이 가장 최근 생성된 VVD만을 대상으로 함" ).append("\n"); 
		query.append("#if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("  AND T1.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${vsl_cd}!='')" ).append("\n"); 
		query.append("  AND T1.VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_voy_no}!='')" ).append("\n"); 
		query.append("  AND T1.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${skd_dir_cd}!='')" ).append("\n"); 
		query.append(" AND T1.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  ) T ," ).append("\n"); 
		query.append("  PSO_TGT_YD_EXPN E" ).append("\n"); 
		query.append("WHERE T.VSL_CD    = E.VSL_CD(+)" ).append("\n"); 
		query.append("AND T.SKD_VOY_NO  = E.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND T.SKD_DIR_CD  = E.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND T.PSO_BZTP_CD = E.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append("AND T.YD_CD       = E.YD_CD(+)" ).append("\n"); 
		query.append("AND T.LGS_COST_CD = E.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND T.VNDR_SEQ    = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND T.BUD_SCNR_NO = E.BUD_SCNR_NO(+)" ).append("\n"); 
		query.append("GROUP BY T.EXPN_YRMON," ).append("\n"); 
		query.append("  T.VSl_SLAN_CD," ).append("\n"); 
		query.append("  T.VSL_CLSS," ).append("\n"); 
		query.append("  --T.YD_CD," ).append("\n"); 
		query.append("  T.VSL_CD" ).append("\n"); 
		query.append("  ||T.SKD_VOY_NO" ).append("\n"); 
		query.append("  ||T.SKD_DIR_CD" ).append("\n"); 
		query.append("ORDER BY T.EXPN_YRMON,  T.VSl_SLAN_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD, T.VSL_CLSS--, T.YD_CD" ).append("\n"); 

	}
}