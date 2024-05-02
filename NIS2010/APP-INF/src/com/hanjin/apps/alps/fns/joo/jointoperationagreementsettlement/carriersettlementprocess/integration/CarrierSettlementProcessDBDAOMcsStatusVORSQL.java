/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOMcsStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOMcsStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOMcsStatusVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOMcsStatusVORSQL").append("\n"); 
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
		query.append("SELECT  TRD_CD, RLANE_CD, ACCT_YRMON, STL_CMB_SEQ, JO_CRR_CD, JO_REV, JO_EXP, JO_BALANCE, BENEFIT_LINE, FROM_DT, TO_DT, VVD, LOCL_CURR_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("        CASE WHEN GUBUN = '00110' THEN " ).append("\n"); 
		query.append("                'SubSum:' || JO_CRR_CD" ).append("\n"); 
		query.append("             WHEN GUBUN = '11110' THEN " ).append("\n"); 
		query.append("                 'TOTAL'" ).append("\n"); 
		query.append("             ELSE ACCT_YRMON" ).append("\n"); 
		query.append("        END AS ACCT_YRMON" ).append("\n"); 
		query.append("        , ACCT_YRMON AS ACCT_YRMON2" ).append("\n"); 
		query.append("        , CASE WHEN GUBUN = '00110' THEN " ).append("\n"); 
		query.append("                'Sub-Total'" ).append("\n"); 
		query.append("             ELSE JO_CRR_CD" ).append("\n"); 
		query.append("        END AS JO_CRR_CD" ).append("\n"); 
		query.append("        , JO_CRR_CD AS JO_CRR_CD2" ).append("\n"); 
		query.append("        , TRD_CD, RLANE_CD, LOCL_CURR_CD, STL_CMB_SEQ, JO_REV, JO_EXP, JO_BALANCE" ).append("\n"); 
		query.append("        , DECODE(GUBUN, '00000', BENEFIT_LINE, NULL) AS BENEFIT_LINE" ).append("\n"); 
		query.append("        , FROM_DT, TO_DT, VVD" ).append("\n"); 
		query.append("        ,  GUBUN" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ACCT_YRMON, JO_CRR_CD, TRD_CD, RLANE_CD, LOCL_CURR_CD, MAX(STL_CMB_SEQ) AS STL_CMB_SEQ, SUM(JO_REV) AS JO_REV" ).append("\n"); 
		query.append("        , SUM(JO_EXP) AS JO_EXP, SUM(JO_BALANCE) AS JO_BALANCE, MAX(BENEFIT_LINE) AS BENEFIT_LINE, MAX(FROM_DT) AS FROM_DT, MAX(TO_DT) AS TO_DT" ).append("\n"); 
		query.append("       , MAX(VVD) AS VVD" ).append("\n"); 
		query.append("       , GROUPING(ACCT_YRMON)|| GROUPING(JO_CRR_CD) || GROUPING(TRD_CD) || GROUPING(RLANE_CD) || GROUPING(LOCL_CURR_CD) AS GUBUN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  TRD_CD, " ).append("\n"); 
		query.append("        RLANE_CD, " ).append("\n"); 
		query.append("        ACCT_YRMON, " ).append("\n"); 
		query.append("        STL_CMB_SEQ, " ).append("\n"); 
		query.append("        JO_CRR_CD, " ).append("\n"); 
		query.append("        NVL(JO_REV,0) JO_REV, " ).append("\n"); 
		query.append("        NVL(JO_EXP,0) JO_EXP, " ).append("\n"); 
		query.append("        NVL(JO_REV,0) - NVL(JO_EXP,0) JO_BALANCE, " ).append("\n"); 
		query.append("        DECODE(SIGN(NVL(JO_REV,0) - NVL(JO_EXP,0)), -1, JO_CRR_CD, 1, 'SML', 0, 'SML') BENEFIT_LINE," ).append("\n"); 
		query.append("		'' FROM_DT," ).append("\n"); 
		query.append("	    '' TO_DT," ).append("\n"); 
		query.append("		'' VVD," ).append("\n"); 
		query.append("		'' vvd_chk," ).append("\n"); 
		query.append("		'' combined_chk," ).append("\n"); 
		query.append("       ''JO_STL_ITM_CD," ).append("\n"); 
		query.append("       LOCL_CURR_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT A.TRD_CD," ).append("\n"); 
		query.append("      A.RLANE_CD," ).append("\n"); 
		query.append("      A.ACCT_YRMON," ).append("\n"); 
		query.append("      LPAD(B.STL_CMB_SEQ, 3, '0') STL_CMB_SEQ," ).append("\n"); 
		query.append("      A.JO_CRR_CD" ).append("\n"); 
		query.append(" 		#if (${usdamount_chk} != '')" ).append("\n"); 
		query.append("			 ,'USD' AS LOCL_CURR_CD" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.RE_DIVR_CD, 'R', A.STL_LOCL_AMT / DECODE (A.LOCL_CURR_CD, 'USD', 1, (" ).append("\n"); 
		query.append("                  SELECT NVL(EX1.USD_LOCL_XCH_RT, 1)" ).append("\n"); 
		query.append("                  FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                    WHERE EX1.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                    AND EX1.ACCT_XCH_RT_YRMON = TO_CHAR(R.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                    AND EX1.ACCT_XCH_RT_LVL = '1' ) ) ) ) AS JO_REV" ).append("\n"); 
		query.append("             ,SUM(DECODE(A.RE_DIVR_CD, 'E', A.STL_LOCL_AMT) / DECODE (A.LOCL_CURR_CD, 'USD', 1, (" ).append("\n"); 
		query.append("                   SELECT NVL(EX1.USD_LOCL_XCH_RT, 1)" ).append("\n"); 
		query.append("                   FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                     WHERE EX1.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                     AND EX1.ACCT_XCH_RT_YRMON = TO_CHAR(R.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                     AND EX1.ACCT_XCH_RT_LVL = '1' ) ) ) AS JO_EXP" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("				  ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                  ,SUM(DECODE(A.RE_DIVR_CD, 'R', A.STL_LOCL_AMT)) JO_REV" ).append("\n"); 
		query.append("                  ,SUM(DECODE(A.RE_DIVR_CD, 'E', A.STL_LOCL_AMT)) JO_EXP" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    FROM JOO_SETTLEMENT A, JOO_STL_CMB_DTL B, JOO_STL_CMB D, JOO_CSR R" ).append("\n"); 
		query.append("    WHERE A.ACCT_YRMON BETWEEN @[from_dt] AND @[to_dt]" ).append("\n"); 
		query.append("      AND A.ACCT_YRMON = B.ACCT_YRMON" ).append("\n"); 
		query.append("      AND A.STL_VVD_SEQ = B.STL_VVD_SEQ" ).append("\n"); 
		query.append("      AND A.STL_SEQ = B.STL_SEQ" ).append("\n"); 
		query.append("      AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("      AND A.RE_DIVR_CD = B.RE_DIVR_CD" ).append("\n"); 
		query.append("--2010.03.19 REVERSE, REJECT건 제외(박효숙 차장)" ).append("\n"); 
		query.append("      AND D.RVS_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("      AND D.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("--2010.03.08 COMBINED된 DATA가 아닌 CSR 완료된 것으로 (BY 박효숙 차장)" ).append("\n"); 
		query.append("      AND B.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("      AND B.JO_CRR_CD   = D.JO_CRR_CD" ).append("\n"); 
		query.append("      AND B.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("      AND B.RE_DIVR_CD  = D.RE_DIVR_CD" ).append("\n"); 
		query.append("      AND D.SLP_SER_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("	AND A.TRD_CD LIKE @[trd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("	AND A.RLANE_CD LIKE @[rlane_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("	AND A.JO_CRR_CD LIKE @[jo_crr_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND A.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("    AND A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("	AND  D.SLP_TP_CD = R.SLP_TP_CD" ).append("\n"); 
		query.append("	AND  D.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("	AND  D.SLP_OFC_CD = R.SLP_OFC_CD" ).append("\n"); 
		query.append("	AND  D.SLP_ISS_DT = R.SLP_ISS_DT" ).append("\n"); 
		query.append("	AND  D.SLP_SER_NO = R.SLP_SER_NO" ).append("\n"); 
		query.append("  #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("    AND R.SLP_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("    GROUP BY A.TRD_CD, A.RLANE_CD, A.ACCT_YRMON, B.STL_CMB_SEQ, A.JO_CRR_CD, A.LOCL_CURR_CD" ).append("\n"); 
		query.append("    ORDER BY A.ACCT_YRMON, A.TRD_CD, A.RLANE_CD,A.JO_CRR_CD,  B.STL_CMB_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("GROUP BY CUBE (ACCT_YRMON, JO_CRR_CD,LOCL_CURR_CD,  TRD_CD, RLANE_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     GUBUN IN ('00000', '00110', '11110', '11111')" ).append("\n"); 
		query.append("ORDER BY ACCT_YRMON2, JO_CRR_CD2, NVL2(TRD_CD, 0, 1), LOCL_CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}