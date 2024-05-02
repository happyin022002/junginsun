/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taxable Amount Confirmation(Monthly) 조회
	  * </pre>
	  */
	public TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration").append("\n"); 
		query.append("FileName : TonnageTaxStandardProfitConclusionDBDAOTaxableAmountConfirmationVORSQL").append("\n"); 
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
		query.append("SELECT   D.SLAN_CD" ).append("\n"); 
		query.append("        , A.VSL_CD" ).append("\n"); 
		query.append("        , D.TRD_CD" ).append("\n"); 
		query.append("        , A.STL_YRMON      " ).append("\n"); 
		query.append("        , DECODE(SUBSTR(A.VSL_CD,1,2),'SP','SAMPLE'|| SUBSTR(A.VSL_CD,3,4), B.VSL_ENG_NM)  VSL_ENG_NM" ).append("\n"); 
		query.append("        , D.BSA_CAPA" ).append("\n"); 
		query.append("        , D.ACT_BSA_CAPA" ).append("\n"); 
		query.append("        , D.USG_RT" ).append("\n"); 
		query.append("        , D.LDB_CAPA_QTY" ).append("\n"); 
		query.append("        , D.CHTR_BSA_CAPA" ).append("\n"); 
		query.append("        , D.PER_TON_REV" ).append("\n"); 
		query.append("        , B.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("        , D.NRT_WGT                                   " ).append("\n"); 
		query.append("        , B.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("        , A.TONG_FLET_TP_CD" ).append("\n"); 
		query.append("        , DECODE(NVL(A.VSL_DZND_CAPA, 0), 0, 0, NVL(A.VSL_DZND_CAPA, 0) - NVL(D.LDB_CAPA_QTY, 0)) CAPA_DIFF" ).append("\n"); 
		query.append("        , TO_CHAR(B.VSL_DE_DT,'YYYYMMDD') AS VSL_DE_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.CTRT_ST_DT,'YYYYMMDD') AS CTRT_ST_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.CTRT_END_DT,'YYYYMMDD') AS CTRT_END_DT" ).append("\n"); 
		query.append("        , TRUNC((C.CTRT_END_DT - C.CTRT_ST_DT) / 365, 1)  CTRT_YEAR" ).append("\n"); 
		query.append("        , CASE WHEN D.TRD_CD IN ('YYY','ZZZ') THEN " ).append("\n"); 
		query.append("                    GREATEST(@[stl_yrmon]||'01', TO_CHAR(C.CTRT_ST_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    GREATEST(@[stl_yrmon]||'01', TO_CHAR(D.MIN_ETD_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("          END AS FM_VVD_STL_DT" ).append("\n"); 
		query.append("        , CASE WHEN D.TRD_CD IN ('YYY','ZZZ') THEN " ).append("\n"); 
		query.append("                    LEAST(TO_CHAR(LAST_DAY(TO_DATE(@[stl_yrmon],'YYYYMM')),'YYYYMMDD'), TO_CHAR(C.CTRT_END_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    LEAST(TO_CHAR(LAST_DAY(TO_DATE(@[stl_yrmon],'YYYYMM')),'YYYYMMDD'), TO_CHAR(D.MAX_ETD_DT,'YYYYMMDD'))" ).append("\n"); 
		query.append("          END AS TO_VVD_STL_DT" ).append("\n"); 
		query.append("        , D.VOY_DYS" ).append("\n"); 
		query.append("        , D.TONG_TAX_AMT" ).append("\n"); 
		query.append("        , DECODE(D.VSL_SVC_TP_CD, 'I', 'Independent Operation'," ).append("\n"); 
		query.append("                                  'J', 'Joint Operation'," ).append("\n"); 
		query.append("                                  'O', 'CCA Feeder'," ).append("\n"); 
		query.append("                                  'S', 'Space Charter') VSL_SVC_TP_NM" ).append("\n"); 
		query.append("   FROM TOT_VVD_STL_AMT A, " ).append("\n"); 
		query.append("        MDM_VSL_CNTR    B, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("                VSL_CD" ).append("\n"); 
		query.append("               ,MAX(CTRT_ST_DT)   CTRT_ST_DT" ).append("\n"); 
		query.append("               ,MAX(CTRT_END_DT)  CTRT_END_DT" ).append("\n"); 
		query.append("          FROM TOT_VESSEL B" ).append("\n"); 
		query.append("         WHERE B.STL_YR = SUBSTR(@[stl_yrmon], 1, 4)" ).append("\n"); 
		query.append("           AND @[stl_yrmon] BETWEEN TO_CHAR(B.CTRT_ST_DT,'YYYYMM') AND TO_CHAR(B.CTRT_END_DT,'YYYYMM')" ).append("\n"); 
		query.append("           AND B.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("           AND TONG_FLET_TP_CD <> 'E'" ).append("\n"); 
		query.append("           AND TONG_FLET_TP_CD = (" ).append("\n"); 
		query.append("                  SELECT MAX(TONG_FLET_TP_CD) " ).append("\n"); 
		query.append("                    FROM TOT_VESSEL T " ).append("\n"); 
		query.append("                   WHERE T.STL_YR = B.STL_YR " ).append("\n"); 
		query.append("                     AND T.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("                     AND @[stl_yrmon] BETWEEN TO_CHAR(T.CTRT_ST_DT,'YYYYMM') AND TO_CHAR(T.CTRT_END_DT,'YYYYMM')" ).append("\n"); 
		query.append("                     AND T.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                     AND T.TONG_FLET_TP_CD <> 'E' " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         GROUP BY VSL_CD " ).append("\n"); 
		query.append("        ) C, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               P.STL_YRMON," ).append("\n"); 
		query.append("               P.TONG_STL_BAT_JB_SEQ," ).append("\n"); 
		query.append("               P.TRD_CD," ).append("\n"); 
		query.append("               P.VSL_CD," ).append("\n"); 
		query.append("               P.SLAN_CD," ).append("\n"); 
		query.append("               MAX(P.BSA_CAPA) BSA_CAPA," ).append("\n"); 
		query.append("               SUM(P.ACT_BSA_CAPA) ACT_BSA_CAPA," ).append("\n"); 
		query.append("               MAX(P.LDB_CAPA_QTY) LDB_CAPA_QTY," ).append("\n"); 
		query.append("               NVL(MAX(P.CHTR_BSA_CAPA),0) CHTR_BSA_CAPA," ).append("\n"); 
		query.append("               MAX(P.PER_TON_REV) PER_TON_REV," ).append("\n"); 
		query.append("               MAX(P.USG_RT) USG_RT," ).append("\n"); 
		query.append("               MAX(P.NRT_WGT) NRT_WGT," ).append("\n"); 
		query.append("               MIN(P.ETD_DT) MIN_ETD_DT," ).append("\n"); 
		query.append("               MAX(P.ETD_DT) MAX_ETD_DT," ).append("\n"); 
		query.append("               SUM(P.VOY_DYS) VOY_DYS," ).append("\n"); 
		query.append("               SUM(TRUNC(P.TONG_TAX_AMT,0)) TONG_TAX_AMT," ).append("\n"); 
		query.append("               (SELECT M.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("                FROM MDM_VSL_SVC_LANE M" ).append("\n"); 
		query.append("                WHERE M.VSL_SLAN_CD = P.SLAN_CD" ).append("\n"); 
		query.append("               ) VSL_SVC_TP_CD" ).append("\n"); 
		query.append("          FROM TOT_PORT_STL_AMT P" ).append("\n"); 
		query.append("         WHERE P.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("         GROUP BY" ).append("\n"); 
		query.append("               P.STL_YRMON," ).append("\n"); 
		query.append("               P.TONG_STL_BAT_JB_SEQ," ).append("\n"); 
		query.append("               P.TRD_CD," ).append("\n"); 
		query.append("               P.VSL_CD," ).append("\n"); 
		query.append("               P.SLAN_CD" ).append("\n"); 
		query.append("        ) D" ).append("\n"); 
		query.append("WHERE  A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("  AND  NVL(A.TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("  AND  A.TONG_STL_BAT_JB_SEQ = (" ).append("\n"); 
		query.append("        SELECT MAX(TONG_STL_BAT_JB_SEQ) " ).append("\n"); 
		query.append("          FROM TOT_VVD_STL_AMT " ).append("\n"); 
		query.append("         WHERE STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("           AND NVL(TONG_FLET_TP_CD,'C') <> 'F'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("  AND  A.VSL_CD              =  B.VSL_CD(+)" ).append("\n"); 
		query.append("  AND  A.VSL_CD              =  C.VSL_CD(+)" ).append("\n"); 
		query.append("  AND  A.STL_YRMON           =  D.STL_YRMON" ).append("\n"); 
		query.append("  AND  A.VSL_CD              =  D.VSL_CD" ).append("\n"); 
		query.append("  AND  A.TONG_STL_BAT_JB_SEQ =  D.TONG_STL_BAT_JB_SEQ" ).append("\n"); 
		query.append("  AND  A.VSL_CD              =  D.VSL_CD" ).append("\n"); 
		query.append("  AND  NOT (D.ACT_BSA_CAPA = 0 AND D.VOY_DYS = 0)" ).append("\n"); 
		query.append("#if (${trd_cd} != 'ALL')" ).append("\n"); 
		query.append("  AND  D.TRD_CD =  @[trd_cd]" ).append("\n"); 
		query.append("#end                       " ).append("\n"); 
		query.append("ORDER BY D.MIN_ETD_DT" ).append("\n"); 

	}
}