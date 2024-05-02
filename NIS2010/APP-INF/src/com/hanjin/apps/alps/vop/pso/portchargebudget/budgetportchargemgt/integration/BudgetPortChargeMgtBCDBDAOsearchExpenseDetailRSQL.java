/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택한 VVD 별 Expense Detail 정보를 표시한다.
	  * =======================================
	  * History
	  * 2012.08.20 진마리아 CHM-201219078-01 사업계획 - 시나리오 연도 추가
	  * 2012.10.11 진마리아 CHM-201220567-01 BUD용 SKD 바라보도록 수정
	  * 2014.03.28  SKY       CHM-201429463  Budget & R/Forecast Adjustment 조회시 Compulsory 체크 로직 삽입
	  * 2015.03.18  CHM-201534913 DISPLAY항목 추가 및 조회 조건에 테이블 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_bztp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOsearchExpenseDetailRSQL").append("\n"); 
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
		query.append("-- ExpnDtl VO" ).append("\n"); 
		query.append("SELECT @[rev_yrmon] EXPN_YRMON," ).append("\n"); 
		query.append("       T.VSl_SLAN_CD ," ).append("\n"); 
		query.append("       T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       T.YD_CD ," ).append("\n"); 
		query.append("       T.ACCT_CD," ).append("\n"); 
		query.append("       T.LGS_COST_CD," ).append("\n"); 
		query.append("       decode(IO_BND_CD, 'I', 'IN', 'O', 'OUT', 'IN/OUT') IO_BND_CD, /*2009.11.18 modified*/" ).append("\n"); 
		query.append("       INV_USD_AMT," ).append("\n"); 
		query.append("       T.VSL_CD ," ).append("\n"); 
		query.append("       T.SKD_VOY_NO," ).append("\n"); 
		query.append("       T.SKD_DIR_CD," ).append("\n"); 
		query.append("       '' sdt," ).append("\n"); 
		query.append("       '' edt," ).append("\n"); 
		query.append("       '' match_flag," ).append("\n"); 
		query.append("       '' rev_yrmon," ).append("\n"); 
		query.append("       LOCL_CURR_CD," ).append("\n"); 
		query.append("       INV_LOCL_AMT," ).append("\n"); 
		query.append("       '' pso_bztp_cd," ).append("\n"); 
		query.append("       DECODE(Z.SKD_CNG_STS_CD, 'S', 'Skip', NULL) SKD_CNG_STS_CD," ).append("\n"); 
		query.append("       E.XPR_DESC," ).append("\n"); 
		query.append("       E.FOML_DESC," ).append("\n"); 
		query.append("       T.VNDR_SEQ," ).append("\n"); 
		query.append("       V.VNDR_LGL_ENG_NM VNDR_NM," ).append("\n"); 
		query.append("       T.CPLS_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("  ( " ).append("\n"); 
		query.append("    SELECT DISTINCT T1.PSO_BZTP_CD," ).append("\n"); 
		query.append("    T1.EXPN_YRMON," ).append("\n"); 
		query.append("    T1.VSL_CD," ).append("\n"); 
		query.append("    T1.SKD_VOY_NO," ).append("\n"); 
		query.append("    T1.SKD_DIR_CD," ).append("\n"); 
		query.append("    T1.VSl_SLAN_CD," ).append("\n"); 
		query.append("    C.YD_CD," ).append("\n"); 
		query.append("    A.ACCT_CD," ).append("\n"); 
		query.append("    C.LGS_COST_CD, --,T1.VSL_CNTR_CLSS_CAPA CLSS : 추가 예정임" ).append("\n"); 
		query.append("    C.VNDR_SEQ," ).append("\n"); 
		query.append("    T1.BUD_SCNR_NO," ).append("\n"); 
		query.append("    C.CPLS_FLG" ).append("\n"); 
		query.append("  FROM PSO_TGT_VVD T1," ).append("\n"); 
		query.append("    PSO_YD_CHG C," ).append("\n"); 
		query.append("    TES_LGS_COST A," ).append("\n"); 
		query.append("    PSO_TGT_YD_EXPN T2" ).append("\n"); 
		query.append("  WHERE T1.PSO_BZTP_CD = decode(@[pso_bztp_cd], '1', '1', '2', '2') --2009.12.07 fix " ).append("\n"); 
		query.append("    AND C.LGS_COST_CD  = A.LGS_COST_CD" ).append("\n"); 
		query.append("    AND T1.EXPN_YRMON BETWEEN TO_CHAR(C.EFF_DT, 'YYYYMM') AND TO_CHAR(C.EXP_DT,'YYYYMM')" ).append("\n"); 
		query.append("  #if(${pso_bztp_cd} == '1')" ).append("\n"); 
		query.append("  AND TO_CHAR(T1.CRE_DT,'YYYYMM') = (SELECT MAX(TO_CHAR(CRE_DT,'YYYYMM')) FROM PSO_TGT_VVD WHERE PSO_BZTP_CD='1')--BUD_SCNR_NO 조건 없이 가장 최근 생성된 VVD만을 대상으로 함" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND C.LST_FLG    = 'Y'" ).append("\n"); 
		query.append("  AND T1.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("  AND T1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND T1.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if(${pso_bztp_cd} == '2')" ).append("\n"); 
		query.append("  AND C.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND T1.PSO_BZTP_CD = T2.PSO_BZTP_CD" ).append("\n"); 
		query.append("  AND T2.LGS_COST_CD = A.LGS_COST_CD" ).append("\n"); 
		query.append("  AND T1.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("  AND T1.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND T1.SKD_DIR_CD  = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND C.YD_CD        = T2.YD_CD" ).append("\n"); 
		query.append("  ) T " ).append("\n"); 
		query.append("      ,PSO_TGT_YD_EXPN  E" ).append("\n"); 
		query.append("      ,MDM_VENDOR       V" ).append("\n"); 
		query.append("#if(${pso_bztp_cd} == '1')" ).append("\n"); 
		query.append("      ,VSK_BUD_VSL_PORT_SKD Z" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD Z" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE T.VSL_CD    = E.VSL_CD(+)" ).append("\n"); 
		query.append("AND T.SKD_VOY_NO  = E.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND T.SKD_DIR_CD  = E.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND T.PSO_BZTP_CD = E.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append("AND T.YD_CD       = E.YD_CD(+)" ).append("\n"); 
		query.append("AND T.LGS_COST_CD = E.LGS_COST_CD(+)" ).append("\n"); 
		query.append("AND T.BUD_SCNR_NO = E.BUD_SCNR_NO(+)" ).append("\n"); 
		query.append("AND E.REV_YRMON(+) = @[rev_yrmon]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    T.VSL_CD = Z.VSL_CD" ).append("\n"); 
		query.append("AND    T.SKD_VOY_NO = Z.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    T.SKD_DIR_CD = Z.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    T.YD_CD = Z.YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    T.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("AND    T.VNDR_SEQ = E.VNDR_SEQ(+) -- 과거 데이타에는 Vendor 가 0 으로 되어 있어서 해당 데이타 조회를 위해 Outer 조인함" ).append("\n"); 
		query.append("#if(${match_flag} == 'unmatch')" ).append("\n"); 
		query.append("  AND     NVL(INV_USD_AMT,0)  = 0           -- Mismatch" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${match_flag} == 'match')" ).append("\n"); 
		query.append("  AND     NVL(INV_USD_AMT,0)  > 0           -- Match" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY T.EXPN_YRMON," ).append("\n"); 
		query.append("  T.VSl_SLAN_CD ," ).append("\n"); 
		query.append("  T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD ," ).append("\n"); 
		query.append("  Z.CLPT_SEQ ," ).append("\n"); 
		query.append("  T.YD_CD ," ).append("\n"); 
		query.append("  T.ACCT_CD," ).append("\n"); 
		query.append("  T.LGS_COST_CD," ).append("\n"); 
		query.append("  IO_BND_CD desc" ).append("\n"); 

	}
}