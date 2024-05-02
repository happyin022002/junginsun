/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchApPayInvDtlDivRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchApPayInvDtlDivRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE TONNAGE비용 배분을 위함.( CN, IT, JP만 해당. HKG제외 ) 
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchApPayInvDtlDivRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchApPayInvDtlDivRSQL").append("\n"); 
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
		query.append("(  SELECT T1.INV_RGST_NO" ).append("\n"); 
		query.append("        , T1.INV_RGST_SEQ" ).append("\n"); 
		query.append("        , T1.SO_ETT_TP_CD" ).append("\n"); 
		query.append("        , T1.LGS_COST_CD" ).append("\n"); 
		query.append("        , T1.ACCT_CD" ).append("\n"); 
		query.append("        , T1.VSL_CD" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN " ).append("\n"); 
		query.append("          --  IN BOUND, VIRTURE PORT" ).append("\n"); 
		query.append("                    T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               END                  AS SKD_VOY_NO" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("                    T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T1.SKD_DIR_CD" ).append("\n"); 
		query.append("               END                  AS SKD_DIR_CD" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  MAX(S.RLANE_DIR_CD)" ).append("\n"); 
		query.append("                    FROM    AR_MST_REV_VVD S" ).append("\n"); 
		query.append("                    WHERE   S.VSL_CD        = T1.VSL_CD" ).append("\n"); 
		query.append("                    AND     S.SKD_VOY_NO    = T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     S.SKD_DIR_CD    = T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     S.RLANE_CD      = NVL(PSO_GET_REV_LANE_FNC(T1.VSL_CD, T3.TURN_SKD_VOY_NO, T3.TURN_SKD_DIR_CD, SUBSTR (T1.YD_CD, 1, 5)), S.RLANE_CD)" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T1.REV_DIR_CD" ).append("\n"); 
		query.append("               END  AS REV_DIR_CD" ).append("\n"); 
		query.append("        , CASE WHEN T1.DP_IO_BND_CD||T3.TURN_PORT_FLG = 'IY' THEN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  S.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    FROM    VSK_VSL_SKD    S " ).append("\n"); 
		query.append("                    WHERE   S.VSL_CD         = T1.VSL_CD" ).append("\n"); 
		query.append("                    AND     S.SKD_VOY_NO   = T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     S.SKD_DIR_CD    = T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               ELSE" ).append("\n"); 
		query.append("                    T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("               END                  AS SLAN_CD" ).append("\n"); 
		query.append("        , T3.VPS_PORT_CD            AS PORT_CD" ).append("\n"); 
		query.append("        , T1.YD_CD" ).append("\n"); 
		query.append("        , T1.INV_AMT" ).append("\n"); 
		query.append("        , T1.SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        , T1.SO_SEQ" ).append("\n"); 
		query.append("        , T1.INV_DESC" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T1.INV_RGST_NO," ).append("\n"); 
		query.append("                SO_DTL_SEQ          AS INV_RGST_SEQ," ).append("\n"); 
		query.append("                '06'                AS SO_ETT_TP_CD," ).append("\n"); 
		query.append("                T2.LGS_COST_CD, DECODE(LENGTH(T2.LGS_COST_CD), 4, 110911, T3.ACCT_CD)  AS ACCT_CD," ).append("\n"); 
		query.append("                T2.VSL_CD,   T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.REV_DIR_CD," ).append("\n"); 
		query.append("                T1.YD_CD," ).append("\n"); 
		query.append("                LOCL_AMT            INV_AMT," ).append("\n"); 
		query.append("                T1.ISS_CTY_CD       SO_OFC_CTY_CD," ).append("\n"); 
		query.append("                T1.SO_SEQ," ).append("\n"); 
		query.append("                SUBSTR(T2.DIFF_RMK, 1, 200) AS INV_DESC," ).append("\n"); 
		query.append("                T2.DP_IO_BND_CD" ).append("\n"); 
		query.append("        FROM    PSO_CHARGE T1, PSO_CHG_DTL T2, TES_LGS_COST T3" ).append("\n"); 
		query.append("        WHERE   T1.ISS_CTY_CD   = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("        AND     T1.SO_SEQ       = T2.SO_SEQ" ).append("\n"); 
		query.append("        AND     T2.LGS_COST_CD  = T3.LGS_COST_CD" ).append("\n"); 
		query.append("      	AND     (T1.ISS_CTY_CD, T1.SO_SEQ) = (SELECT ISS_CTY_CD, SO_SEQ FROM PSO_CHARGE WHERE INV_NO = @[inv_no] AND VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("        ) T1, VSK_VSL_SKD T2, VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("WHERE   T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     T1.YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     T1.LGS_COST_CD <> 'PTDUTN'" ).append("\n"); 
		query.append("AND     T3.CLPT_IND_SEQ =   (  SELECT  MIN(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                 FROM  VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                                WHERE  S.VSL_CD      = T3.VSL_CD" ).append("\n"); 
		query.append("                                  AND  S.SKD_VOY_NO  = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND  S.SKD_DIR_CD  = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND  S.YD_CD       = T3.YD_CD" ).append("\n"); 
		query.append("                                  AND  NVL(S.SKD_CNG_STS_CD,' ') <> 'S' ) " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  T1.INV_RGST_NO," ).append("\n"); 
		query.append("        SO_DTL_SEQ          AS INV_RGST_SEQ," ).append("\n"); 
		query.append("        '06'                AS SO_ETT_TP_CD," ).append("\n"); 
		query.append("        T2.LGS_COST_CD, DECODE(LENGTH(T2.LGS_COST_CD), 4, 110911, T3.ACCT_CD)  AS ACCT_CD," ).append("\n"); 
		query.append("        T2.VSL_CD,   T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.REV_DIR_CD, SUBSTR(RLANE_CD, 1, 3) AS SLAN_CD," ).append("\n"); 
		query.append("        SUBSTR(T1.YD_CD,1,5) PORT_CD, T1.YD_CD," ).append("\n"); 
		query.append("        LOCL_AMT            INV_AMT," ).append("\n"); 
		query.append("        T1.ISS_CTY_CD       SO_OFC_CTY_CD," ).append("\n"); 
		query.append("        T1.SO_SEQ," ).append("\n"); 
		query.append("        SUBSTR(T2.DIFF_RMK, 1, 200) AS INV_DESC " ).append("\n"); 
		query.append("FROM    PSO_CHARGE T1, PSO_CHG_DTL T2, TES_LGS_COST T3" ).append("\n"); 
		query.append("WHERE   T1.ISS_CTY_CD   = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("AND     T1.SO_SEQ       = T2.SO_SEQ" ).append("\n"); 
		query.append("AND     T2.LGS_COST_CD  = T3.LGS_COST_CD" ).append("\n"); 
		query.append("AND     NOT EXISTS (SELECT 'A' FROM VSK_VSL_SKD WHERE VSL_CD = T2.VSL_CD AND SKD_VOY_NO = T2.SKD_VOY_NO AND SKD_DIR_CD = T2.SKD_DIR_CD)" ).append("\n"); 
		query.append("AND    (T1.ISS_CTY_CD, T1.SO_SEQ) = (SELECT ISS_CTY_CD, SO_SEQ FROM PSO_CHARGE WHERE INV_NO = @[inv_no]   AND VNDR_SEQ = @[vndr_seq] )  " ).append("\n"); 
		query.append("AND     T3.LGS_COST_CD <> 'PTDUTN'   )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  INV_RGST_NO,  INV_RGST_SEQ,SO_ETT_TP_CD ,LGS_COST_CD ,ACCT_CD ,VSL_CD ,SKD_VOY_NO ,SKD_DIR_CD ,REV_DIR_CD ,SLAN_CD,PORT_CD,YD_CD," ).append("\n"); 
		query.append("        CASE WHEN G_ROW = 1 THEN NVL(INV_AMT2,0) + PSO_DIV_SUM_FNC(G_COUNT, INV_AMT2,G_INV_AMT)" ).append("\n"); 
		query.append("             ELSE INV_AMT2" ).append("\n"); 
		query.append("        END AS INV_AMT" ).append("\n"); 
		query.append("       ,SO_OFC_CTY_CD,SO_SEQ, NULL AS INV_DESC  " ).append("\n"); 
		query.append(" FROM (  SELECT COUNT(INV_RGST_SEQ) OVER (PARTITION BY SODTLSEQ) G_COUNT," ).append("\n"); 
		query.append("                SUM(INV_AMT) OVER (PARTITION BY SODTLSEQ)  G_INV_AMT, " ).append("\n"); 
		query.append("                INV_RGST_NO,  INV_RGST_SEQ,SO_ETT_TP_CD ,LGS_COST_CD ,ACCT_CD ,VSL_CD ,SKD_VOY_NO ,SKD_DIR_CD ,REV_DIR_CD ,SLAN_CD,PORT_CD,YD_CD," ).append("\n"); 
		query.append("                CASE WHEN CURR_CD IN ('JPY','KRW') THEN " ).append("\n"); 
		query.append("                  ROUND(SUM(INV_AMT) OVER (PARTITION BY SODTLSEQ) /COUNT(INV_RGST_SEQ) OVER (PARTITION BY SODTLSEQ)) " ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                  ROUND(SUM(INV_AMT) OVER (PARTITION BY SODTLSEQ) /COUNT(INV_RGST_SEQ) OVER (PARTITION BY SODTLSEQ) ,2) " ).append("\n"); 
		query.append("                END  AS INV_AMT2,INV_AMT," ).append("\n"); 
		query.append("                SO_OFC_CTY_CD,SO_SEQ,'USERID' CRE_USR_ID ,SYSDATE CRE_DT,'USERID' UPD_USR_ID,SYSDATE UPD_DT,INV_DESC ,SODTLSEQ," ).append("\n"); 
		query.append("                RANK() OVER(PARTITION BY SODTLSEQ ORDER BY INV_RGST_SEQ ) G_ROW" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("               WITH VSK_VSL AS ( " ).append("\n"); 
		query.append("                   SELECT  Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD, Y.YD_CD  ,  SODTLSEQ" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("            SELECT  A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, MIN(A.CLPT_SEQ) CLPTSEQ  , MIN(C.ORG_SO_DTL_SEQ) SODTLSEQ" ).append("\n"); 
		query.append("              FROM  VSK_VSL_PORT_SKD A, PSO_CHARGE B, PSO_CHG_DTL C" ).append("\n"); 
		query.append("             WHERE  VPS_ETA_DT BETWEEN C.COST_CALC_EFF_FM_DT AND C.COST_CALC_EFF_TO_DT" ).append("\n"); 
		query.append("               AND  NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("               AND  TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("               AND  A.VSL_CD           = C.VSL_CD" ).append("\n"); 
		query.append("               AND  C.ISS_CTY_CD       = B.ISS_CTY_CD" ).append("\n"); 
		query.append("               AND  C.SO_SEQ           = B.SO_SEQ" ).append("\n"); 
		query.append("               AND  B.INV_NO           = @[inv_no]  " ).append("\n"); 
		query.append("               AND  B.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("               AND  C.LGS_COST_CD      = 'PTDUTN'" ).append("\n"); 
		query.append("               AND  C.N3PTY_BIL_IF_FLG IN ('N','Y')" ).append("\n"); 
		query.append("               AND  A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD <> C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND  VPS_ETA_DT >=  ( SELECT VPS_ETA_DT" ).append("\n"); 
		query.append("                                       FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                      WHERE VSL_CD        =C.VSL_CD" ).append("\n"); 
		query.append("                                        AND SKD_VOY_NO    =C.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND SKD_DIR_CD    =C.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND YD_CD         =B.YD_CD " ).append("\n"); 
		query.append("                                        AND CALL_YD_IND_SEQ = A.CALL_YD_IND_SEQ  )" ).append("\n"); 
		query.append("               AND SUBSTR(VPS_PORT_CD,1,2) = SUBSTR(B.YD_CD,1,2)   " ).append("\n"); 
		query.append("               AND VPS_PORT_CD <> 'CNHKG'  " ).append("\n"); 
		query.append("               AND SUBSTR(VPS_PORT_CD,1,2)  IN ('CN','IT','JP') " ).append("\n"); 
		query.append("            GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ) X, VSK_VSL_PORT_SKD Y " ).append("\n"); 
		query.append("      WHERE X.VSL_CD     = Y.VSL_CD " ).append("\n"); 
		query.append("        AND X.SKD_VOY_NO = Y.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND X.SKD_DIR_CD = Y.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND X.CLPTSEQ    = Y.CLPT_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT  NULL INV_RGST_NO" ).append("\n"); 
		query.append("        ,   (  SELECT NVL(MAX(SO_DTL_SEQ) ,0 ) FROM PSO_CHARGE A, PSO_CHG_DTL B" ).append("\n"); 
		query.append("               WHERE A.ISS_CTY_CD = B.ISS_CTY_CD" ).append("\n"); 
		query.append("                   AND A.SO_SEQ   = B.SO_SEQ" ).append("\n"); 
		query.append("                   AND A.INV_NO   =  @[inv_no]  AND  A.VNDR_SEQ = @[vndr_seq] ) + ROWNUM INV_RGST_SEQ" ).append("\n"); 
		query.append("        , '06'  SO_ETT_TP_CD" ).append("\n"); 
		query.append("        , 'PTDUTN'  LGS_COST_CD" ).append("\n"); 
		query.append("        , 511751  ACCT_CD" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , RLANE_DIR_CD  REV_DIR_CD" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , SUBSTR(@[yd_cd],1,5)     AS PORT_CD" ).append("\n"); 
		query.append("        ,@[yd_cd]  YD_CD" ).append("\n"); 
		query.append("        , 0 INV_AMT" ).append("\n"); 
		query.append("        , NULL SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        , NULL SO_SEQ" ).append("\n"); 
		query.append("        , NULL INV_DESC" ).append("\n"); 
		query.append("        , SODTLSEQ" ).append("\n"); 
		query.append("        , ( SELECT CURR_CD FROM PSO_CHARGE WHERE INV_NO = @[inv_no]  AND VNDR_SEQ = @[vndr_seq] )  CURR_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("   SELECT    V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , V.RLANE_DIR_CD" ).append("\n"); 
		query.append("             , OB_RTO" ).append("\n"); 
		query.append("             , IB_RTO" ).append("\n"); 
		query.append("             , V.RLANE_CD" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , V.SODTLSEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SELECT  " ).append("\n"); 
		query.append("               V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , V.RLANE_DIR_CD" ).append("\n"); 
		query.append("             , D.SLAN_CD EXPN_SLAN" ).append("\n"); 
		query.append("             , COUNT(V.SLAN_CD) OVER (PARTITION BY V.SLAN_CD) AS SLAN_CNT" ).append("\n"); 
		query.append("             , DECODE (V.TURN, 'Y', 50, DECODE(OB_RTO, NULL, 100, 0, 0, DECODE(TURN_CNT, 0, 100, OB_RTO)) ) OB_RTO" ).append("\n"); 
		query.append("             , DECODE (V.TURN, 'Y', 0, DECODE(IB_RTO, NULL, 0, 0, 0, DECODE(TURN_CNT, 0, 0, IB_RTO)) ) IB_RTO" ).append("\n"); 
		query.append("             , V.RLANE_CD" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , V.SODTLSEQ" ).append("\n"); 
		query.append("        FROM   PSO_PORT_EXPN_DIV D" ).append("\n"); 
		query.append("             , (SELECT V1.VSL_CD" ).append("\n"); 
		query.append("                     , V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V1.TURN_PORT_FLG TURN" ).append("\n"); 
		query.append("                     , (SELECT COUNT(*) FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("                         WHERE T1.VSL_CD     = V1.VSL_CD" ).append("\n"); 
		query.append("                           AND T1.SKD_VOY_NO = V1.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND T1.SKD_DIR_CD = V1.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND T1.TURN_PORT_IND_CD IN ('N', 'Y')" ).append("\n"); 
		query.append("                           AND T1.TURN_SKD_DIR_CD IS NOT NULL) TURN_CNT" ).append("\n"); 
		query.append("                     , V1.SLAN_CD" ).append("\n"); 
		query.append("                     , V1.VPS_PORT_CD" ).append("\n"); 
		query.append("                     , L.RLANE_DIR_CD" ).append("\n"); 
		query.append("                     , V1.TURN_PORT_FLG" ).append("\n"); 
		query.append("                     , L.RLANE_CD" ).append("\n"); 
		query.append("                     , L.REV_YRMON" ).append("\n"); 
		query.append("                     , VSK_VSL.SODTLSEQ" ).append("\n"); 
		query.append("                FROM   VSK_VSL_PORT_SKD V1" ).append("\n"); 
		query.append("                     , AR_MST_REV_VVD L" ).append("\n"); 
		query.append("                     , VSK_VSL " ).append("\n"); 
		query.append("                WHERE  V1.VSL_CD     = L.VSL_CD" ).append("\n"); 
		query.append("                  AND  V1.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND  V1.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND  V1.SLAN_CD    = L.SLAN_CD" ).append("\n"); 
		query.append("                  AND  L.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                  AND  V1.VSL_CD     = VSK_VSL.VSL_CD" ).append("\n"); 
		query.append("                  AND  V1.SKD_VOY_NO = VSK_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND  V1.SKD_DIR_CD = VSK_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND  V1.YD_CD      = VSK_VSL.YD_CD " ).append("\n"); 
		query.append("                  AND  NVL (V1.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                  AND  V1.TURN_PORT_IND_CD IN ('N', 'Y')) V " ).append("\n"); 
		query.append("        WHERE  D.SLAN_CD(+)    = V.SLAN_CD" ).append("\n"); 
		query.append("          AND  D.SKD_DIR_CD(+) = V.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND  D.LOC_CD(+)     = V.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND  D.RLANE_CD(+)   = V.RLANE_CD" ).append("\n"); 
		query.append("          AND  D.REV_DIR_CD(+) = V.RLANE_DIR_CD" ).append("\n"); 
		query.append("          ) V" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("SELECT V.VSL_CD" ).append("\n"); 
		query.append("             , V.SKD_VOY_NO" ).append("\n"); 
		query.append("             , V.SKD_DIR_CD" ).append("\n"); 
		query.append("             , V.TURN_PORT_IND_CD TURN" ).append("\n"); 
		query.append("             , V.SLAN_CD" ).append("\n"); 
		query.append("             , V.VPS_PORT_CD" ).append("\n"); 
		query.append("             , RLANE_DIR_CD" ).append("\n"); 
		query.append("             , 0 OB_RTO" ).append("\n"); 
		query.append("             , 50 IB_RTO" ).append("\n"); 
		query.append("             , L.RLANE_CD" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , VSK_VSL.SODTLSEQ" ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("             , AR_MST_REV_VVD L" ).append("\n"); 
		query.append("             , VSK_VSL" ).append("\n"); 
		query.append("        WHERE  V.VSL_CD     = L.VSL_CD" ).append("\n"); 
		query.append("        AND    V.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    V.SKD_DIR_CD = L.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    V.SLAN_CD    = L.SLAN_CD" ).append("\n"); 
		query.append("        AND    L.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("        AND    V.VSL_CD     = VSK_VSL.VSL_CD" ).append("\n"); 
		query.append("        AND    V.TURN_SKD_VOY_NO = VSK_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    V.TURN_SKD_DIR_CD = VSK_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    V.YD_CD           = VSK_VSL.YD_CD " ).append("\n"); 
		query.append("        AND    NVL (SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        AND    (L.RLANE_CD = NVL ( (SELECT RLANE_CD" ).append("\n"); 
		query.append("                                    FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                         , AR_FINC_DIR_CONV B" ).append("\n"); 
		query.append("                                         , MDM_LOCATION L" ).append("\n"); 
		query.append("                                    WHERE  V.VSL_CD = VSK_VSL.VSL_CD" ).append("\n"); 
		query.append("                                    AND    V.TURN_SKD_VOY_NO = VSK_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND    V.TURN_SKD_DIR_CD =  VSK_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    AND    V.YD_CD = VSK_VSL.YD_CD " ).append("\n"); 
		query.append("                                    AND    V.VPS_PORT_CD = L.LOC_CD" ).append("\n"); 
		query.append("                                    AND    V.SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("                                    AND    V.SKD_DIR_CD = B.SLAN_DIR_CD" ).append("\n"); 
		query.append("                                    AND    L.SCONTI_CD = B.SCONTI_CD" ).append("\n"); 
		query.append("                                    AND    ROWNUM <= 1), L.RLANE_CD))" ).append("\n"); 
		query.append("        AND    EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                        FROM   AR_MST_REV_VVD X" ).append("\n"); 
		query.append("                        WHERE  X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                        AND    X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND    X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND    X.DELT_FLG   = 'N' 	   )" ).append("\n"); 
		query.append("	     AND V.TURN_PORT_IND_CD in ('D', 'V', 'F')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append(" SELECT T1.INV_RGST_NO," ).append("\n"); 
		query.append("        SO_DTL_SEQ          AS INV_RGST_SEQ," ).append("\n"); 
		query.append("        '06'                AS SO_ETT_TP_CD," ).append("\n"); 
		query.append("        T2.LGS_COST_CD, DECODE(LENGTH(T2.LGS_COST_CD), 4, 110911, T3.ACCT_CD)  AS ACCT_CD," ).append("\n"); 
		query.append("        T2.VSL_CD,   T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.REV_DIR_CD, SUBSTR(RLANE_CD, 1, 3) AS SLAN_CD," ).append("\n"); 
		query.append("        SUBSTR(T1.YD_CD,1,5) PORT_CD, T1.YD_CD," ).append("\n"); 
		query.append("        LOCL_AMT            INV_AMT," ).append("\n"); 
		query.append("        T1.ISS_CTY_CD       SO_OFC_CTY_CD," ).append("\n"); 
		query.append("        T1.SO_SEQ," ).append("\n"); 
		query.append("        SUBSTR(T2.DIFF_RMK, 1, 200) AS INV_DESC , " ).append("\n"); 
		query.append("        T2.ORG_SO_DTL_SEQ," ).append("\n"); 
		query.append("        T1.CURR_CD" ).append("\n"); 
		query.append("   FROM PSO_CHARGE T1, PSO_CHG_DTL T2, TES_LGS_COST T3" ).append("\n"); 
		query.append("  WHERE T1.ISS_CTY_CD   = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("    AND T1.SO_SEQ       = T2.SO_SEQ" ).append("\n"); 
		query.append("    AND T2.LGS_COST_CD  = T3.LGS_COST_CD" ).append("\n"); 
		query.append("    AND (T1.ISS_CTY_CD, T1.SO_SEQ) = (SELECT ISS_CTY_CD, SO_SEQ FROM PSO_CHARGE WHERE INV_NO = @[inv_no]  AND VNDR_SEQ = @[vndr_seq] )" ).append("\n"); 
		query.append("    AND T2.LGS_COST_CD = 'PTDUTN'  ) X" ).append("\n"); 
		query.append("  ORDER BY SODTLSEQ ASC, INV_RGST_SEQ DESC ) Y    " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" ORDER BY INV_RGST_SEQ" ).append("\n"); 

	}
}