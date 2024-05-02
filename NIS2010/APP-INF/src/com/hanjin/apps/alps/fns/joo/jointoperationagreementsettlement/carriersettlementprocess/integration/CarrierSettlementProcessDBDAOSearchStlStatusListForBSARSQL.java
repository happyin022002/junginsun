/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.28 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchStlStatusListForBSARSQL").append("\n"); 
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
		query.append("/*2010.03.24 GL_ESTM_REV_VVD 기준으로 변경*/" ).append("\n"); 
		query.append("/*권한은 필요없음*/" ).append("\n"); 
		query.append("WITH AR_MST AS (" ).append("\n"); 
		query.append("     SELECT DISTINCT" ).append("\n"); 
		query.append("            A.REV_YRMON, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.RLANE_CD" ).append("\n"); 
		query.append("     FROM   GL_ESTM_REV_VVD A" ).append("\n"); 
		query.append("     WHERE  A.REV_YRMON   >= REPLACE(@[acct_yrmon_fr],'-','')" ).append("\n"); 
		query.append("     AND    A.REV_YRMON   <= REPLACE(@[acct_yrmon_to],'-','')" ).append("\n"); 
		query.append("     AND    A.SKD_DIR_CD IN ('N','E','W','S')" ).append("\n"); 
		query.append("     AND    A.ESTM_IOC_DIV_CD = DECODE(SUBSTR(A.RLANE_CD, -2), 'IA', 'IA', 'IE', 'IE', 'IM', 'IM', 'TA','OO', 'TP','OO', 'AE','OO')" ).append("\n"); 
		query.append("     AND    A.RLANE_CD LIKE '%'||SUBSTR(@[trd_cd],1,2)" ).append("\n"); 
		query.append("#if(${rlane_cd} != '')" ).append("\n"); 
		query.append("     AND    A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("--       B.ACCT_YRMON," ).append("\n"); 
		query.append("       A.REV_YRMON AS COST_YRMON, " ).append("\n"); 
		query.append("       B.JO_CRR_CD," ).append("\n"); 
		query.append("       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("       B.TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       B.BSA_R_AMT," ).append("\n"); 
		query.append("       B.JOO_R_AMT," ).append("\n"); 
		query.append("       B.DIFF_R_YN," ).append("\n"); 
		query.append("       B.BSA_E_AMT," ).append("\n"); 
		query.append("       B.JOO_E_AMT," ).append("\n"); 
		query.append("       B.DIFF_E_YN" ).append("\n"); 
		query.append("FROM   AR_MST A, " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("       --       JOO.ACCT_YRMON," ).append("\n"); 
		query.append("              NVL(JOO.REV_YRMON, COA.REV_YRMON) AS COST_YRMON," ).append("\n"); 
		query.append("              NVL(JOO.JO_CRR_CD, COA.JO_CRR_CD) AS JO_CRR_CD," ).append("\n"); 
		query.append("              NVL(JOO.VSL_CD    ,COA.VSL_CD    ) AS VSL_CD," ).append("\n"); 
		query.append("              NVL(JOO.SKD_VOY_NO,COA.SKD_VOY_NO) AS SKD_VOY_NO," ).append("\n"); 
		query.append("              NVL(JOO.SKD_DIR_CD,COA.SKD_DIR_CD) AS SKD_DIR_CD," ).append("\n"); 
		query.append("              NVL(JOO.REV_DIR_CD,COA.REV_DIR_CD) AS REV_DIR_CD," ).append("\n"); 
		query.append("       --       NVL(JOO.VSL_CD||JOO.SKD_VOY_NO||JOO.SKD_DIR_CD||JOO.REV_DIR_CD, COA.VSL_CD||COA.SKD_VOY_NO||COA.SKD_DIR_CD||COA.REV_DIR_CD) AS VVD," ).append("\n"); 
		query.append("              NVL(JOO.TRD_CD, COA.TRD_CD) AS TRD_CD," ).append("\n"); 
		query.append("              NVL(JOO.RLANE_CD, COA.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("              NVL(SUM(COA.BSA_R_AMT),0) AS BSA_R_AMT," ).append("\n"); 
		query.append("              NVL(SUM(JOO.JOO_R_AMT),0) AS JOO_R_AMT," ).append("\n"); 
		query.append("              CASE WHEN NVL(SUM(COA.BSA_R_AMT),0) <> NVL(SUM(JOO.JOO_R_AMT),0) THEN 'Y' ELSE 'N' END DIFF_R_YN," ).append("\n"); 
		query.append("              NVL(SUM(COA.BSA_E_AMT),0) AS BSA_E_AMT," ).append("\n"); 
		query.append("              NVL(SUM(JOO.JOO_E_AMT),0) AS JOO_E_AMT," ).append("\n"); 
		query.append("              CASE WHEN NVL(SUM(COA.BSA_E_AMT),0) <> NVL(SUM(JOO.JOO_E_AMT),0) THEN 'Y' ELSE 'N' END DIFF_E_YN" ).append("\n"); 
		query.append("       FROM   (" ).append("\n"); 
		query.append("              SELECT" ).append("\n"); 
		query.append("                     A.REV_YRMON, B.CRR_CD AS JO_CRR_CD, B.TRD_CD, A.RLANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("                     SUM(CASE WHEN B.BSA_OP_JB_CD IN ('001','002','0004') THEN B.CRR_PERF_AMT ELSE 0 END) AS BSA_R_AMT," ).append("\n"); 
		query.append("                     SUM(CASE WHEN B.BSA_OP_JB_CD IN ('000','003','0005') THEN B.CRR_PERF_AMT ELSE 0 END) AS BSA_E_AMT" ).append("\n"); 
		query.append("              FROM   AR_MST A," ).append("\n"); 
		query.append("                     BSA_VVD_CRR_PERF B," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                     SELECT JO_CRR_CD, RLANE_CD" ).append("\n"); 
		query.append("                     FROM   JOO_CRR_AUTH" ).append("\n"); 
		query.append("                     WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND    AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end                   " ).append("\n"); 
		query.append("                     GROUP  BY JO_CRR_CD, RLANE_CD " ).append("\n"); 
		query.append("                    ) C" ).append("\n"); 
		query.append("              WHERE  A.VSL_CD     = B.VSL_CD     " ).append("\n"); 
		query.append("              AND    A.SKD_VOY_NO = B.SKD_VOY_NO " ).append("\n"); 
		query.append("              AND    A.SKD_DIR_CD = B.SKD_DIR_CD " ).append("\n"); 
		query.append("              AND    A.RLANE_CD   = B.RLANE_CD   " ).append("\n"); 
		query.append("              AND    B.CRR_CD     = C.JO_CRR_CD" ).append("\n"); 
		query.append("              AND    B.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("              AND    B.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("              AND    B.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("              AND    B.CRR_PERF_AMT <> 0" ).append("\n"); 
		query.append("              GROUP  BY" ).append("\n"); 
		query.append("                     A.REV_YRMON, B.CRR_CD, B.TRD_CD, A.RLANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD" ).append("\n"); 
		query.append("              ) COA FULL OUTER JOIN" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT A.REV_YRMON, J.JO_CRR_CD, J.TRD_CD, A.RLANE_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, " ).append("\n"); 
		query.append("                     J.JOO_R_AMT, J.JOO_E_AMT" ).append("\n"); 
		query.append("              FROM   AR_MST A," ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("                     SELECT" ).append("\n"); 
		query.append("                            J.JO_CRR_CD, J.TRD_CD, J.RLANE_CD, J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD," ).append("\n"); 
		query.append("                            SUM(DECODE(J.RE_DIVR_CD,'R',J.STL_LOCL_AMT,0)) AS JOO_R_AMT," ).append("\n"); 
		query.append("                            SUM(DECODE(J.RE_DIVR_CD,'E',J.STL_LOCL_AMT,0)) AS JOO_E_AMT" ).append("\n"); 
		query.append("                     FROM   JOO_SETTLEMENT  J," ).append("\n"); 
		query.append("                            JOO_STL_CMB_DTL D," ).append("\n"); 
		query.append("                            JOO_STL_CMB     C" ).append("\n"); 
		query.append("                     WHERE  J.ACCT_YRMON    = D.ACCT_YRMON" ).append("\n"); 
		query.append("                     AND    J.STL_VVD_SEQ   = D.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     AND    J.STL_SEQ       = D.STL_SEQ" ).append("\n"); 
		query.append("                     AND    D.ACCT_YRMON    = C.ACCT_YRMON" ).append("\n"); 
		query.append("                     AND    D.JO_CRR_CD     = C.JO_CRR_CD" ).append("\n"); 
		query.append("                     AND    D.STL_CMB_SEQ   = C.STL_CMB_SEQ" ).append("\n"); 
		query.append("                     AND    D.RE_DIVR_CD    = C.RE_DIVR_CD" ).append("\n"); 
		query.append("                     AND    J.CMB_CFM_FLG   = 'Y'" ).append("\n"); 
		query.append("                     AND    C.SLP_SER_NO    IS NOT NULL" ).append("\n"); 
		query.append("                     AND    J.JO_STL_ITM_CD = 'S/H'" ).append("\n"); 
		query.append("                     AND    J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                     AND    J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("#end              " ).append("\n"); 
		query.append("                     AND    NVL(C.RVS_CMB_FLG ,'N') = 'N'" ).append("\n"); 
		query.append("                     AND    NVL(C.RJCT_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                     AND    J.STL_LOCL_AMT <> 0" ).append("\n"); 
		query.append("                     GROUP  BY" ).append("\n"); 
		query.append("                            J.JO_CRR_CD, J.TRD_CD, J.RLANE_CD, J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD              " ).append("\n"); 
		query.append("                     ) J," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                     SELECT JO_CRR_CD, RLANE_CD" ).append("\n"); 
		query.append("                     FROM   JOO_CRR_AUTH" ).append("\n"); 
		query.append("                     WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND    AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end                   " ).append("\n"); 
		query.append("                     GROUP  BY JO_CRR_CD, RLANE_CD " ).append("\n"); 
		query.append("                    ) C" ).append("\n"); 
		query.append("              WHERE  A.VSL_CD     = J.VSL_CD    " ).append("\n"); 
		query.append("              AND    A.SKD_VOY_NO = J.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND    A.SKD_DIR_CD = J.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND    A.REV_DIR_CD = J.REV_DIR_CD" ).append("\n"); 
		query.append("              AND    J.JO_CRR_CD  = C.JO_CRR_CD" ).append("\n"); 
		query.append("              AND    J.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("              ) JOO" ).append("\n"); 
		query.append("              ON  (COA.VSL_CD     = JOO.VSL_CD" ).append("\n"); 
		query.append("              AND  COA.SKD_VOY_NO = JOO.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND  COA.SKD_DIR_CD = JOO.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND  COA.REV_DIR_CD = JOO.REV_DIR_CD" ).append("\n"); 
		query.append("              AND  COA.JO_CRR_CD  = JOO.JO_CRR_CD" ).append("\n"); 
		query.append("              AND  COA.TRD_CD     = JOO.TRD_CD" ).append("\n"); 
		query.append("              AND  COA.RLANE_CD   = JOO.RLANE_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       GROUP  BY" ).append("\n"); 
		query.append("              NVL(JOO.REV_YRMON, COA.REV_YRMON), NVL(JOO.JO_CRR_CD, COA.JO_CRR_CD)," ).append("\n"); 
		query.append("              NVL(JOO.VSL_CD, COA.VSL_CD), NVL(JOO.SKD_VOY_NO, COA.SKD_VOY_NO), NVL(JOO.SKD_DIR_CD, COA.SKD_DIR_CD), NVL(JOO.REV_DIR_CD, COA.REV_DIR_CD)," ).append("\n"); 
		query.append("              NVL(JOO.TRD_CD, COA.TRD_CD), NVL(JOO.RLANE_CD, COA.RLANE_CD)" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD     = B.VSL_CD    (+) " ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("AND    A.REV_DIR_CD = B.REV_DIR_CD(+) " ).append("\n"); 
		query.append("AND    A.RLANE_CD   = B.RLANE_CD  (+) " ).append("\n"); 
		query.append("ORDER  BY 4" ).append("\n"); 

	}
}