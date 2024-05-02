/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchSummaryOfMcsListBySumVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.10.15 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchSummaryOfMcsListBySumVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSummaryOfMcsListBySumVVD
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchSummaryOfMcsListBySumVVDRSQL(){
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
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchSummaryOfMcsListBySumVVDRSQL").append("\n"); 
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
		query.append("SELECT R_STL_LOCL_AMT," ).append("\n"); 
		query.append("  E_STL_LOCL_AMT," ).append("\n"); 
		query.append("  LOCL_CURR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("	#if (${usdamount_chk} != '')" ).append("\n"); 
		query.append("    	SUM(DECODE(A.RE_DIVR_CD,'R',   A.STL_LOCL_AMT / DECODE" ).append("\n"); 
		query.append("      (A.LOCL_CURR_CD, 'USD', 1, " ).append("\n"); 
		query.append("         (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) " ).append("\n"); 
		query.append("         FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("         WHERE  EX1.CURR_CD                         = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("         AND EX1.ACCT_XCH_RT_YRMON     = TO_CHAR(R.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("         AND EX1.ACCT_XCH_RT_LVL           = '1'" ).append("\n"); 
		query.append("       )  ) ) )  AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("	   , SUM(DECODE(A.RE_DIVR_CD,'E',A.STL_LOCL_AMT) / DECODE" ).append("\n"); 
		query.append("      (A.LOCL_CURR_CD, 'USD', 1, " ).append("\n"); 
		query.append("         (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) " ).append("\n"); 
		query.append("         FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("         WHERE  EX1.CURR_CD                         = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("         AND EX1.ACCT_XCH_RT_YRMON     = TO_CHAR(R.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("         AND EX1.ACCT_XCH_RT_LVL           = '1'" ).append("\n"); 
		query.append("       )  ) )   AS E_STL_LOCL_AMT," ).append("\n"); 
		query.append("	'USD' AS LOCL_CURR_CD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      	SUM(DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT))) AS R_STL_LOCL_AMT," ).append("\n"); 
		query.append("   		SUM(DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT))) AS E_STL_LOCL_AMT," ).append("\n"); 
		query.append("		A.LOCL_CURR_CD AS LOCL_CURR_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("       JOO_STL_DTL     B," ).append("\n"); 
		query.append("       JOO_CRR_AUTH    C," ).append("\n"); 
		query.append("       JOO_STL_CMB_DTL D," ).append("\n"); 
		query.append("       JOO_STL_CMB     E," ).append("\n"); 
		query.append("  	   JOO_CSR R" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+) " ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD   = C.JO_CRR_CD" ).append("\n"); 
		query.append("AND    A.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("AND    C.AUTH_OFC_CD = NVL(@[ofc_cd],C.AUTH_OFC_CD)" ).append("\n"); 
		query.append("AND    C.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("--2010.03.19 REVERSE, REJECT건 제외(박효숙 차장)" ).append("\n"); 
		query.append("--2015.10.15 REVERSE건은 보여준다(김영명 대리)" ).append("\n"); 
		query.append("--AND    E.RVS_CMB_FLG  = 'N'" ).append("\n"); 
		query.append("AND    E.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("--2010.03.08 COMBINED된 DATA가 아닌 CSR 완료된 것으로 (BY 박효숙 차장)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = D.STL_SEQ" ).append("\n"); 
		query.append("AND    E.ACCT_YRMON  = D.ACCT_YRMON" ).append("\n"); 
		query.append("AND    E.JO_CRR_CD   = D.JO_CRR_CD" ).append("\n"); 
		query.append("AND    E.STL_CMB_SEQ = D.STL_CMB_SEQ" ).append("\n"); 
		query.append("AND    E.RE_DIVR_CD  = D.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    E.SLP_SER_NO IS NOT NULL" ).append("\n"); 
		query.append("--AND    NVL(E.RVS_CMB_FLG ,'N') = 'N'" ).append("\n"); 
		query.append("AND    NVL(E.RJCT_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND    A.STL_LOCL_AMT <>0" ).append("\n"); 
		query.append("  AND E.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("  AND E.SLP_OFC_CD = R.SLP_OFC_CD" ).append("\n"); 
		query.append("  AND E.SLP_ISS_DT = R.SLP_ISS_DT" ).append("\n"); 
		query.append("  AND E.SLP_SER_NO = R.SLP_SER_NO" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("AND INSTR(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,@[vvd]) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '') " ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.LOCL_CURR_CD" ).append("\n"); 
		query.append(")Z" ).append("\n"); 

	}
}