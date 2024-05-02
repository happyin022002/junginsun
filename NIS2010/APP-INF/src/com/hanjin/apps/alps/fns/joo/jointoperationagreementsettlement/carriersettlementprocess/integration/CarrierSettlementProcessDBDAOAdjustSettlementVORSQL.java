/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAdjustSettlementVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.05.03 박희동
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

public class CarrierSettlementProcessDBDAOAdjustSettlementVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Adjustment 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAdjustSettlementVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAdjustSettlementVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      'I' AS IBFLAG, REPLACE(@[acct_yrmon],'-','') AS ACCT_YRMON, @[trd_cd] AS TRD_CD, @[jo_crr_cd] AS JO_CRR_CD, @[rlane_cd] AS RLANE_CD, @[re_divr_cd] AS RE_DIVR_CD," ).append("\n"); 
		query.append("      'S/H' AS JO_STL_ITM_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("      A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.JO_STL_JB_CD, A.JO_MNU_NM, @[locl_curr_cd] AS LOCL_CURR_CD, '0' AS STL_ADJ_IRR_FLG, A.STL_CMB_SEQ," ).append("\n"); 
		query.append("      A.COA_JO_MNU_NM, A.JOO_JO_MNU_NM, A.COA_STL_LOCL_AMT, A.JOO_STL_LOCL_AMT," ).append("\n"); 
		query.append("      A.BSA_QTY, A.BSA_SLT_PRC, A.BSA_QTY1, A.BSA_SLT_PRC1," ).append("\n"); 
		query.append("      A.BSA_QTY - A.BSA_QTY1 AS DTL_BSA_QTY," ).append("\n"); 
		query.append("      A.BSA_SLT_PRC - A.BSA_SLT_PRC1 AS DTL_BSA_SLT_PRC," ).append("\n"); 
		query.append("      -- 수량변경에 의한 ADJ 금액 = DIFF. QTY * COA PRICE" ).append("\n"); 
		query.append("      (A.BSA_QTY - A.BSA_QTY1) * A.BSA_SLT_PRC AS ADJ_BSA_QTY_LOCL_AMT," ).append("\n"); 
		query.append("      -- 단가변경에 의한 ADJ 금액 = JOO QTY * DIFF. PRICE" ).append("\n"); 
		query.append("      A.BSA_QTY1 * (A.BSA_SLT_PRC - A.BSA_SLT_PRC1) AS ADJ_BSA_SLT_PRC_LOCL_AMT," ).append("\n"); 
		query.append("      (A.BSA_QTY - A.BSA_QTY1) * A.BSA_SLT_PRC + A.BSA_QTY1 * (A.BSA_SLT_PRC - A.BSA_SLT_PRC1) AS STL_LOCL_AMT," ).append("\n"); 
		query.append("      A.ACCT_YRMON AS PRE_ACCT_YRMON, A.STL_VVD_SEQ AS PRE_STL_VVD_SEQ, A.STL_SEQ AS PRE_STL_SEQ" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("            NVL(COA.ACCT_YRMON, JOO.ACCT_YRMON) AS ACCT_YRMON," ).append("\n"); 
		query.append("            NVL(COA.STL_VVD_SEQ,JOO.STL_VVD_SEQ)AS STL_VVD_SEQ," ).append("\n"); 
		query.append("            JOO.STL_SEQ AS STL_SEQ," ).append("\n"); 
		query.append("            JOO.STL_CMB_SEQ AS STL_CMB_SEQ," ).append("\n"); 
		query.append("            NVL(COA.VSL_CD    , JOO.VSL_CD    ) AS VSL_CD," ).append("\n"); 
		query.append("            NVL(COA.SKD_VOY_NO, JOO.SKD_VOY_NO) AS SKD_VOY_NO," ).append("\n"); 
		query.append("            NVL(COA.SKD_DIR_CD, JOO.SKD_DIR_CD) AS SKD_DIR_CD," ).append("\n"); 
		query.append("            NVL(COA.REV_DIR_CD, JOO.REV_DIR_CD) AS REV_DIR_CD," ).append("\n"); 
		query.append("            NVL(COA.JO_STL_JB_CD, JOO.JO_STL_JB_CD) AS JO_STL_JB_CD," ).append("\n"); 
		query.append("            NVL(COA.JO_MNU_NM,'S/H') AS COA_JO_MNU_NM," ).append("\n"); 
		query.append("            NVL(JOO.JO_MNU_NM,'S/H') AS JOO_JO_MNU_NM," ).append("\n"); 
		query.append("            NVL(COA.JO_MNU_NM, JOO.JO_MNU_NM) AS JO_MNU_NM," ).append("\n"); 
		query.append("            NVL(COA.BSA_QTY,0) AS BSA_QTY," ).append("\n"); 
		query.append("            NVL(COA.BSA_SLT_PRC,0) AS BSA_SLT_PRC," ).append("\n"); 
		query.append("            NVL(COA.STL_LOCL_AMT,0) AS COA_STL_LOCL_AMT," ).append("\n"); 
		query.append("            --MAX(JOO.JO_MNU_NM) = 'M/S'란 뜻은 S/H가 없다는 말이므로 M/S는 -처리하고 S/H는 0으로 만들어서 COA값을 그대로 가져오기 위함이다." ).append("\n"); 
		query.append("            DECODE(JOO.MAX_JO_MNU_NM, 'M/S', DECODE(COA.JO_MNU_NM, 'S/H', 0, NVL(JOO.BSA_QTY    ,0)), NVL(JOO.BSA_QTY    ,0)) AS BSA_QTY1," ).append("\n"); 
		query.append("            DECODE(JOO.MAX_JO_MNU_NM, 'M/S', DECODE(COA.JO_MNU_NM, 'S/H', 0, NVL(JOO.BSA_SLT_PRC,0)), NVL(JOO.BSA_SLT_PRC,0)) AS BSA_SLT_PRC1," ).append("\n"); 
		query.append("            NVL(JOO.SUM_STL_LOCL_AMT,0) AS JOO_STL_LOCL_AMT," ).append("\n"); 
		query.append("            JOO.MAX_JO_MNU_NM" ).append("\n"); 
		query.append("      FROM  (" ).append("\n"); 
		query.append("            SELECT A.ACCT_YRMON, A.STL_VVD_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.JO_STL_JB_CD, B.JO_MNU_NM," ).append("\n"); 
		query.append("                   DECODE(B.JO_MNU_NM, 'S/H', A.BSA_QTY     , 0) AS BSA_QTY," ).append("\n"); 
		query.append("                   DECODE(B.JO_MNU_NM, 'S/H', A.BSA_SLT_PRC , 0) AS BSA_SLT_PRC," ).append("\n"); 
		query.append("                   SUM(DECODE(B.JO_MNU_NM, 'S/H', A.STL_LOCL_AMT, 0)) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.JO_STL_JB_CD) STL_LOCL_AMT" ).append("\n"); 
		query.append("            FROM   (" ).append("\n"); 
		query.append("                   SELECT SUBSTR(A.YRMON_VVD_SEQ,1,6) AS ACCT_YRMON, TO_NUMBER(SUBSTR(A.YRMON_VVD_SEQ,7)) AS STL_VVD_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("                          B.JO_STL_JB_CD, B.BSA_QTY, B.BSA_SLT_PRC, B.STL_LOCL_AMT" ).append("\n"); 
		query.append("                   FROM   (" ).append("\n"); 
		query.append("                          SELECT MAX(A.ACCT_YRMON||A.STL_VVD_SEQ) YRMON_VVD_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.RLANE_CD" ).append("\n"); 
		query.append("                          FROM   JOO_STL_VVD A" ).append("\n"); 
		query.append("                          WHERE  A.ACCT_YRMON>= REPLACE(@[fm_acct_yrmon],'-','')" ).append("\n"); 
		query.append("                          AND    A.ACCT_YRMON<= REPLACE(@[to_acct_yrmon],'-','')" ).append("\n"); 
		query.append("                          AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("                          AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("                          AND    A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                          AND    A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                          AND    A.JO_STL_ITM_CD = 'S/H'" ).append("\n"); 
		query.append("                          --2010.04.20 " ).append("\n"); 
		query.append("                          --AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("                          GROUP  BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.RLANE_CD" ).append("\n"); 
		query.append("                          ) A," ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                          SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, B.RLANE_CD," ).append("\n"); 
		query.append("                                 CASE WHEN B.BSA_OP_JB_CD IN ('000','001') THEN '101'" ).append("\n"); 
		query.append("                                      WHEN B.BSA_OP_JB_CD IN ('002','003') THEN '102'" ).append("\n"); 
		query.append("                                      WHEN B.BSA_OP_JB_CD IN ('004','005') THEN '103'" ).append("\n"); 
		query.append("                                 END AS JO_STL_JB_CD," ).append("\n"); 
		query.append("                                 CASE WHEN B.BSA_OP_JB_CD IN ('001','002','004') THEN 'R'" ).append("\n"); 
		query.append("                                      WHEN B.BSA_OP_JB_CD IN ('000','003','005') THEN 'E'" ).append("\n"); 
		query.append("                                 END AS RE_DIVR_CD," ).append("\n"); 
		query.append("                                 B.CRR_BSA_CAPA AS BSA_QTY, B.SLT_PRC_CAPA AS BSA_SLT_PRC, B.CRR_PERF_AMT AS STL_LOCL_AMT" ).append("\n"); 
		query.append("                          FROM   BSA_VVD_CRR_PERF B" ).append("\n"); 
		query.append("                          WHERE  B.CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("                          AND    B.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("                          AND    B.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                          AND    CASE WHEN B.BSA_OP_JB_CD IN ('001','002','004') THEN 'R'" ).append("\n"); 
		query.append("                                      WHEN B.BSA_OP_JB_CD IN ('000','003','005') THEN 'E' END = @[re_divr_cd]" ).append("\n"); 
		query.append("                          ) B" ).append("\n"); 
		query.append("                   WHERE  A.VSL_CD     = B.VSL_CD     (+)" ).append("\n"); 
		query.append("                   AND    A.SKD_VOY_NO = B.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                   AND    A.SKD_DIR_CD = B.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("                   AND    A.RLANE_CD   = B.RLANE_CD   (+)" ).append("\n"); 
		query.append("                   ) A, " ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                   SELECT 'S/H' AS JO_MNU_NM FROM DUAL " ).append("\n"); 
		query.append("                   UNION ALL " ).append("\n"); 
		query.append("                   SELECT 'M/S' AS JO_MNU_NM FROM DUAL" ).append("\n"); 
		query.append("                   ) B" ).append("\n"); 
		query.append("            ) COA FULL OUTER JOIN" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                    J.ACCT_YRMON, J.STL_VVD_SEQ, J.STL_SEQ, J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.JO_STL_JB_CD, J.JO_MNU_NM, J.STL_CMB_SEQ" ).append("\n"); 
		query.append("                    -- M/S이면서 ADJ한 거면...JOO_STL_DTL에서 TEU, PRICE를 읽어온다.(M/S의 Adj는 BSA_QTY, BSA_SLT_PRC가 0이므로)" ).append("\n"); 
		query.append("                   ,DECODE(J.JO_MNU_NM||J.STL_ADJ_FLG, 'M/SY',NVL((SELECT SUM(DECODE(X.STL_DTL_SEQ,1,X.BSA_QTY    ,0)) FROM JOO_STL_DTL X WHERE X.ACCT_YRMON = J.ACCT_YRMON AND X.STL_VVD_SEQ = J.STL_VVD_SEQ AND X.STL_SEQ = J.STL_SEQ),0), J.BSA_QTY    ) AS BSA_QTY" ).append("\n"); 
		query.append("                   ,DECODE(J.JO_MNU_NM||J.STL_ADJ_FLG, 'M/SY',NVL((SELECT SUM(DECODE(X.STL_DTL_SEQ,2,-1 * X.BSA_SLT_PRC,0)) FROM JOO_STL_DTL X WHERE X.ACCT_YRMON = J.ACCT_YRMON AND X.STL_VVD_SEQ = J.STL_VVD_SEQ AND X.STL_SEQ = J.STL_SEQ),0), J.BSA_SLT_PRC) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("                   ,SUM(J.STL_LOCL_AMT) OVER (PARTITION BY J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.JO_STL_JB_CD) SUM_STL_LOCL_AMT" ).append("\n"); 
		query.append("                   ,COUNT(1) OVER (PARTITION BY J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.JO_STL_JB_CD) CNT" ).append("\n"); 
		query.append("                   ,MAX(J.JO_MNU_NM) OVER (PARTITION BY J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.JO_STL_JB_CD) MAX_JO_MNU_NM" ).append("\n"); 
		query.append("                   ,ROW_NUMBER() OVER (PARTITION BY J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD, J.JO_STL_JB_CD ORDER BY J.JO_MNU_NM DESC) RNK" ).append("\n"); 
		query.append("            FROM   (" ).append("\n"); 
		query.append("                   SELECT J.ACCT_YRMON, J.STL_VVD_SEQ, J.STL_SEQ, J.VSL_CD, J.SKD_VOY_NO, J.SKD_DIR_CD, J.REV_DIR_CD," ).append("\n"); 
		query.append("                          J.JO_STL_JB_CD, J.STL_ADJ_FLG, J.JO_MNU_NM, D.STL_CMB_SEQ, J.BSA_QTY, J.BSA_SLT_PRC, J.STL_LOCL_AMT" ).append("\n"); 
		query.append("                   FROM   (" ).append("\n"); 
		query.append("                          SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.RLANE_CD" ).append("\n"); 
		query.append("                          FROM   JOO_STL_VVD A" ).append("\n"); 
		query.append("                          WHERE  A.ACCT_YRMON>= REPLACE(@[fm_acct_yrmon],'-','')" ).append("\n"); 
		query.append("                          AND    A.ACCT_YRMON<= REPLACE(@[to_acct_yrmon],'-','')" ).append("\n"); 
		query.append("                          AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("                          AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("                          AND    A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                          AND    A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                          AND    A.JO_STL_ITM_CD = 'S/H'" ).append("\n"); 
		query.append("                          --2010.04.20 " ).append("\n"); 
		query.append("                          --AND    A.JO_STL_CFM_CD = 'Y'" ).append("\n"); 
		query.append("                          GROUP  BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.RLANE_CD" ).append("\n"); 
		query.append("                          ) V," ).append("\n"); 
		query.append("                          JOO_SETTLEMENT  J," ).append("\n"); 
		query.append("                          JOO_STL_CMB_DTL D" ).append("\n"); 
		query.append("                   WHERE  V.VSL_CD        = J.VSL_CD" ).append("\n"); 
		query.append("                   AND    V.SKD_VOY_NO    = J.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND    V.SKD_DIR_CD    = J.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND    V.REV_DIR_CD    = J.REV_DIR_CD" ).append("\n"); 
		query.append("                   AND    J.ACCT_YRMON    = D.ACCT_YRMON (+)" ).append("\n"); 
		query.append("                   AND    J.STL_VVD_SEQ   = D.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("                   AND    J.STL_SEQ       = D.STL_SEQ    (+)" ).append("\n"); 
		query.append("                   AND    J.JO_STL_ITM_CD = 'S/H'" ).append("\n"); 
		query.append("                   AND    J.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("                   AND    J.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("                   AND    J.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND    J.RE_DIVR_CD    = @[re_divr_cd]" ).append("\n"); 
		query.append("                   AND    J.STL_LOCL_AMT <> 0" ).append("\n"); 
		query.append("                   ) J" ).append("\n"); 
		query.append("            ) JOO" ).append("\n"); 
		query.append("        ON  (COA.VSL_CD       = JOO.VSL_CD" ).append("\n"); 
		query.append("        AND  COA.SKD_VOY_NO   = JOO.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND  COA.SKD_DIR_CD   = JOO.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND  COA.REV_DIR_CD   = JOO.REV_DIR_CD" ).append("\n"); 
		query.append("        AND  COA.JO_STL_JB_CD = JOO.JO_STL_JB_CD" ).append("\n"); 
		query.append("        --M/S만 여러개인 경우 하나만 S/H만들어줘야함" ).append("\n"); 
		query.append("        AND  COA.JO_MNU_NM    = CASE WHEN JOO.MAX_JO_MNU_NM = 'M/S' AND JOO.RNK = 1 THEN COA.JO_MNU_NM ELSE JOO.JO_MNU_NM END" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.COA_STL_LOCL_AMT <> A.JOO_STL_LOCL_AMT" ).append("\n"); 
		query.append("AND   NOT (A.BSA_QTY = 0 AND A.BSA_SLT_PRC = 0 AND A.BSA_QTY1 = 0 AND A.BSA_SLT_PRC1 = 0)" ).append("\n"); 
		query.append("ORDER BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, JO_STL_JB_CD, JO_MNU_NM DESC" ).append("\n"); 

	}
}