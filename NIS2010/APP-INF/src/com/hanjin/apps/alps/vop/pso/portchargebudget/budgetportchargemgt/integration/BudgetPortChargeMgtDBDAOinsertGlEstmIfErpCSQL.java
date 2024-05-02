/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.23 진마리아
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

public class BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추정 데이타를 GlEstmIfErp 테이블에  Insert 한다.
	  * 
	  * * 2010.08.04
	  * 추정실적 산출시 진행항차에서 대하여 아래의 조건으로 Tariff Cost 산출
	  * 1) Carrier Code(Actual/MDM)가 HJS인 VVD만 생성
	  * 2) "PV"인 VVD만 진행 항차로 산출함
	  * 
	  * [CHM-201005568-01]
	  * 운하 통항비(511911)- Actual invocie값이 입력되더라도
	  * Estimate 금액에 일치시키지 말고 Estimate 금액을 유지
	  * 
	  * [CHM-201114431-01]
	  * 1. 511911 Actual Invoice amount 입력시 estmate로 사용하고 accural 0으로 처리함
	  * 2. 511911 Actual Invoice amount 미입력시 estimate는 Tariff Cost로 사용하고 accoural에 tariff Cost 비용을 입력함.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : BudgetPortChargeMgtDBDAOinsertGlEstmIfErpCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("            ( EXE_YRMON, " ).append("\n"); 
		query.append("            SYS_SRC_ID, " ).append("\n"); 
		query.append("            REV_YRMON, " ).append("\n"); 
		query.append("            ACCT_CD," ).append("\n"); 
		query.append("            ESTM_SEQ_NO," ).append("\n"); 
		query.append("            BIZ_UT_ID," ).append("\n"); 
		query.append("            LOC_CD," ).append("\n"); 
		query.append("            VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD," ).append("\n"); 
		query.append("            ESTM_VVD_TP_CD,          -- 'RV'" ).append("\n"); 
		query.append("            ESTM_IOC_DIV_CD,         -- 'OO'" ).append("\n"); 
		query.append("            ESTM_BC_DIV_CD,          -- 'C'" ).append("\n"); 
		query.append("            ESTM_VVD_HDR_ID,         -- 106405" ).append("\n"); 
		query.append("            TTL_TRF_AMT," ).append("\n"); 
		query.append("            ESTM_AMT," ).append("\n"); 
		query.append("            ACT_AMT," ).append("\n"); 
		query.append("            ACCL_AMT," ).append("\n"); 
		query.append("            CRE_USR_ID ," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        EXE_YRMON " ).append("\n"); 
		query.append("        ,SYS_SRC_ID" ).append("\n"); 
		query.append("        ,REV_YRMON" ).append("\n"); 
		query.append("        --,T2.ACCT_CD" ).append("\n"); 
		query.append("        ,ACCT_CD" ).append("\n"); 
		query.append("        ,ROWNUM+(SELECT /*+INDEX_DESC(X XPKGL_ESTM_IF_ERP)*/ " ).append("\n"); 
		query.append("                   NVL(MAX(X.ESTM_SEQ_NO),0) " ).append("\n"); 
		query.append("                   FROM GL_ESTM_IF_ERP X " ).append("\n"); 
		query.append("                   WHERE X.EXE_YRMON = T1.EXE_YRMON " ).append("\n"); 
		query.append("                   AND X.SYS_SRC_ID = T1.SYS_SRC_ID" ).append("\n"); 
		query.append("                   AND X.REV_YRMON = T1.REV_YRMON" ).append("\n"); 
		query.append("                   AND X.ACCT_CD = T1.ACCT_CD" ).append("\n"); 
		query.append("                   AND X.ESTM_SEQ_NO >= 0" ).append("\n"); 
		query.append("                   AND ROWNUM <= 1  ) AS    ESTM_SEQ_NO" ).append("\n"); 
		query.append("        ,'CNTR'" ).append("\n"); 
		query.append("        ,LOC_CD" ).append("\n"); 
		query.append("        ,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD" ).append("\n"); 
		query.append("        ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        ,ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        ,ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("        ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("        ,EST_AMT AS TTL_TRF_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("		,NVL(EST_AMT, 0) AS ESTM_AMT" ).append("\n"); 
		query.append("        ,NVL(INV_AMT, 0) AS ACT_AMT" ).append("\n"); 
		query.append("        ,NVL(EST_AMT, 0) - NVL(INV_AMT,0) AS ACCL_AMT" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE            " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT  V.EXE_YRMON  AS EXE_YRMON" ).append("\n"); 
		query.append("            ,'PSO' AS SYS_SRC_ID" ).append("\n"); 
		query.append("            , V.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("            , V.REV_YRMON" ).append("\n"); 
		query.append("            , SUBSTR(NVL(E.YD_CD,C.YD_CD),1,5) AS LOC_CD" ).append("\n"); 
		query.append("            , V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD,V.REV_DIR_CD" ).append("\n"); 
		query.append("            , V.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("            ,V.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("            , V.ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("            ,T1.ACCT_CD" ).append("\n"); 
		query.append("            ,(CASE " ).append("\n"); 
		query.append("		             WHEN MONTHS_BETWEEN(TO_DATE(V.EXE_YRMON, 'YYYYMM'), TO_DATE(V.REV_YRMON, 'YYYYMM')) >= 5 THEN" ).append("\n"); 
		query.append("		                  NVL(SUM(INV_AMT), 0)        ----------- 수행월(EXE_YRMON) 5개월 이전 Accural에 대해서는 0 처리함.([CHM-201005568-01)]" ).append("\n"); 
		query.append("--		             WHEN ACCT_CD = '511911' THEN " ).append("\n"); 
		query.append("--		         	      	(CASE" ).append("\n"); 
		query.append("--		                		-------- Accrual이 10만불 이하인 경우에는 Estimated Amount는 Actual Amount로 봄  [#Add 2010.09.07 by sj]" ).append("\n"); 
		query.append("--		                		WHEN NVL(SUM(E.INV_USD_AMT), 0) - NVL(SUM(INV_AMT), 0) <= 100000 THEN" ).append("\n"); 
		query.append("--		                			DECODE(NVL(SUM(INV_AMT), 0), 0" ).append("\n"); 
		query.append("--        		                             , NVL(SUM(E.INV_USD_AMT), 0)" ).append("\n"); 
		query.append("--        		                             , NVL(SUM(INV_AMT), 0))" ).append("\n"); 
		query.append("--		                		-------- Accrual이 10만불 초과인 경우에는 Estimated Amount 유지  [#Add 2010.09.07 by sj]" ).append("\n"); 
		query.append("--		                		ELSE" ).append("\n"); 
		query.append("--									-- 전도금이 있으면, 해당 금액을 Estimated Amount로 보고," ).append("\n"); 
		query.append("--									-- 전도금이 없으면, Tariff Cost를 Estimated Amount로 본다." ).append("\n"); 
		query.append("--		                		    DECODE(NVL(MAX(ADV_AMT), 0), 0, NVL(SUM(E.INV_LOCL_AMT), 0), NVL(MAX(ADV_AMT), 0))        ----------- 운하통항비(511911)의 경우에는 Estimated Amount를 유지함.([CHM-201005568-01)]" ).append("\n"); 
		query.append("--		                     END)" ).append("\n"); 
		query.append("		             ELSE " ).append("\n"); 
		query.append("		                   DECODE(NVL(SUM(INV_AMT), 0), 0" ).append("\n"); 
		query.append("		                             , NVL(SUM(E.INV_USD_AMT), 0)" ).append("\n"); 
		query.append("		                             , NVL(SUM(INV_AMT), 0))" ).append("\n"); 
		query.append("		     END) EST_AMT " ).append("\n"); 
		query.append("			--SUM(E.INV_LOCL_AMT) AS EST_AMT" ).append("\n"); 
		query.append("            ,SUM(INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("            FROM    -- Target VVD" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT  ESTM_IOC_DIV_CD AS ESTM_IOC_DIV_CD, EXE_YRMON, REV_YRMON, VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD" ).append("\n"); 
		query.append("                    , ESTM_VVD_TP_CD, ESTM_VVD_HDR_ID, ESTM_BC_DIV_CD, RLANE_CD" ).append("\n"); 
		query.append("                    FROM    GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                    WHERE   ESTM_IOC_DIV_CD =   'OO'" ).append("\n"); 
		query.append("                    AND     EXE_YRMON  =   (SELECT MAX(X.EXPN_YRMON)" ).append("\n"); 
		query.append("							                FROM PSO_TGT_VVD X" ).append("\n"); 
		query.append("                							WHERE X.PSO_BZTP_CD = '2' )" ).append("\n"); 
		query.append("                    AND     ESTM_BC_DIV_CD  IN  ('C', 'M')" ).append("\n"); 
		query.append("                    UNION   ALL" ).append("\n"); 
		query.append("                    SELECT  ESTM_IOC_DIV_CD , EXE_YRMON" ).append("\n"); 
		query.append("                    , REV_YRMON, VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD" ).append("\n"); 
		query.append("                    , ESTM_VVD_TP_CD, ESTM_VVD_HDR_ID, ESTM_BC_DIV_CD, RLANE_CD" ).append("\n"); 
		query.append("                    FROM    GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                    WHERE   ESTM_IOC_DIV_CD <>  'OO'" ).append("\n"); 
		query.append("                    AND     ( VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD ) NOT IN" ).append("\n"); 
		query.append("                                            (   SELECT  VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD" ).append("\n"); 
		query.append("                                                FROM    GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                                                WHERE   ESTM_IOC_DIV_CD =   'OO'" ).append("\n"); 
		query.append("                                                AND     EXE_YRMON  =   (SELECT MAX(X.EXPN_YRMON)" ).append("\n"); 
		query.append("							                							FROM PSO_TGT_VVD X" ).append("\n"); 
		query.append("                														WHERE X.PSO_BZTP_CD = '2' )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                     AND     EXE_YRMON  =   (SELECT MAX(X.EXPN_YRMON)" ).append("\n"); 
		query.append("							                FROM PSO_TGT_VVD X" ).append("\n"); 
		query.append("                							WHERE X.PSO_BZTP_CD = '2' )" ).append("\n"); 
		query.append("                    AND      ESTM_BC_DIV_CD      IN  ('C', 'M')" ).append("\n"); 
		query.append("		            " ).append("\n"); 
		query.append("	           		AND     ( ESTM_VVD_TP_CD  <> 'PV'  " ).append("\n"); 
		query.append("		            	 	  OR" ).append("\n"); 
		query.append("		            	 	  -- 진행항차의 경우에는 RLANE의 4번째 자리가 'I'인 경우에는 Internal만 있는 경우 포함, 그 외에는 제외 [#Mod 2010.09.07 by sj]" ).append("\n"); 
		query.append("		            	 	  (ESTM_VVD_TP_CD  = 'PV' AND 'I' = SUBSTR(RLANE_CD, 4, 1) ))" ).append("\n"); 
		query.append("                    )  V   " ).append("\n"); 
		query.append("              ," ).append("\n"); 
		query.append("              PSO_TGT_YD_EXPN E" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("              SELECT VSL_CD" ).append("\n"); 
		query.append("                   ,SKD_VOY_NO" ).append("\n"); 
		query.append("                   ,SKD_DIR_CD" ).append("\n"); 
		query.append("                   ,RLANE_CD" ).append("\n"); 
		query.append("                   ,YD_CD" ).append("\n"); 
		query.append("                   ,LGS_COST_CD" ).append("\n"); 
		query.append("                   ,SUM(INV_AMT) INV_AMT" ).append("\n"); 
		query.append("                FROM ( " ).append("\n"); 
		query.append("                        SELECT C2.VSL_CD" ).append("\n"); 
		query.append("                                -- TURN / VIRTUAL 항차 구분 - 사용자가 IO 입력하지 않은 경우에는 시스템에서 자동으로 배분하므로," ).append("\n"); 
		query.append("                                -- 사용자가 IO 입력하지 않은 경우에는 INVOICE의 데이터를 이용." ).append("\n"); 
		query.append("                                -- 그 외에는 SKD의 TURN_VOY_NO 사용" ).append("\n"); 
		query.append("                               ,(CASE " ).append("\n"); 
		query.append("                                    WHEN CNT = 0 OR C2.DP_IO_BND_CD IS NULL THEN" ).append("\n"); 
		query.append("                                        C2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NVL(V.TURN_SKD_VOY_NO, C2.SKD_VOY_NO)" ).append("\n"); 
		query.append("                                END) SKD_VOY_NO" ).append("\n"); 
		query.append("                               ,(CASE " ).append("\n"); 
		query.append("                                    WHEN CNT = 0 OR C2.DP_IO_BND_CD IS NULL THEN" ).append("\n"); 
		query.append("                                        C2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NVL(V.TURN_SKD_DIR_CD, C2.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                END) SKD_DIR_CD" ).append("\n"); 
		query.append("                                ,(CASE " ).append("\n"); 
		query.append("                                    WHEN CNT = 0 OR C2.DP_IO_BND_CD IS NULL THEN" ).append("\n"); 
		query.append("                                        C2.RLANE_CD" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NVL(PSO_GET_REV_LANE_FNC(V.VSL_CD, V.TURN_SKD_VOY_NO, V.TURN_SKD_DIR_CD, SUBSTR (C1.YD_CD, 1, 5)), C2.RLANE_CD)" ).append("\n"); 
		query.append("                                END) RLANE_CD" ).append("\n"); 
		query.append("                                , C1.YD_CD, C2.LGS_COST_CD, ROUND( (C2.LOCL_AMT / X1.USD_LOCL_XCH_RT) * 0.5, 2) INV_AMT" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                       FROM  PSO_CHARGE C1, PSO_CHG_DTL C2, GL_MON_XCH_RT   X1" ).append("\n"); 
		query.append("                           ,VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                           ,(SELECT CPY_NO CNT FROM COM_CPY_NO WHERE CPY_NO <= 1)" ).append("\n"); 
		query.append("                       WHERE C1.ISS_CTY_CD   = C2.ISS_CTY_CD" ).append("\n"); 
		query.append("                       AND   C1.SO_SEQ        = C2.SO_SEQ " ).append("\n"); 
		query.append("                       AND   EXISTS (select 'X' FROM AP_PAY_INV I1" ).append("\n"); 
		query.append("                                                WHERE I1.INV_STS_CD IN ( 'P','D')" ).append("\n"); 
		query.append("                                                and I1.INV_SUB_SYS_CD = 'PSO'" ).append("\n"); 
		query.append("                                                and I1.INV_RGST_NO = C1.INV_RGST_NO" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                       AND   EXISTS ( SELECT 'X'  FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                                      WHERE     EXE_YRMON  =   (SELECT MAX(X.EXPN_YRMON)" ).append("\n"); 
		query.append("					                							FROM PSO_TGT_VVD X" ).append("\n"); 
		query.append("        														WHERE X.PSO_BZTP_CD = '2' )" ).append("\n"); 
		query.append("                                      AND     VSL_CD = C2.VSL_CD" ).append("\n"); 
		query.append("                                      AND     SKD_VOY_NO = C2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND     SKD_DIR_CD = C2.SKD_DIR_CD   " ).append("\n"); 
		query.append("                                     ) " ).append("\n"); 
		query.append("                       AND    C1.CURR_CD = X1.CURR_CD" ).append("\n"); 
		query.append("                       AND    X1.ACCT_XCH_RT_LVL = 3" ).append("\n"); 
		query.append("                       AND    X1.ACCT_XCH_RT_YRMON =	(SELECT  MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                          				   FROM  PSO_TGT_VVD" ).append("\n"); 
		query.append("                                          				  WHERE  PSO_BZTP_CD = '2') " ).append("\n"); 
		query.append("                                          				  " ).append("\n"); 
		query.append("                        AND C2.VSL_CD = V.VSL_CD(+) AND C2.SKD_VOY_NO = V.SKD_VOY_NO(+) AND C2.SKD_DIR_CD = V.SKD_DIR_CD(+) AND C1.YD_CD = NVL(V.YD_CD, C1.YD_CD)" ).append("\n"); 
		query.append("                        AND NVL(V.CLPT_SEQ, 1) = NVL((SELECT MIN(CLPT_SEQ) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                        WHERE VSL_CD = V.VSL_CD AND SKD_VOY_NO = V.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                        AND SKD_DIR_CD = V.SKD_DIR_CD AND YD_CD = V.YD_CD" ).append("\n"); 
		query.append("                                                        AND 'S' <> NVL(SKD_CNG_STS_CD, ' ')), 1)    " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("               GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RLANE_CD,YD_CD, LGS_COST_CD" ).append("\n"); 
		query.append("              )  C -- Actual Amount " ).append("\n"); 
		query.append("              , TES_LGS_COST T1 " ).append("\n"); 
		query.append("              , " ).append("\n"); 
		query.append("              (SELECT @[vsl_cd] VSL_CD, @[skd_voy_no] SKD_VOY_NO, @[skd_dir_cd] SKD_DIR_CD, " ).append("\n"); 
		query.append("                    ROUND(TTL_LOCL_AMT / USD_LOCL_XCH_RT, 2) ADV_AMT" ).append("\n"); 
		query.append("               FROM PSO_CHARGE A, GL_MON_XCH_RT   X1" ).append("\n"); 
		query.append("              WHERE INV_NO LIKE '%-'||@[vsl_cd]||@[skd_voy_no]||@[skd_dir_cd]||'%-ADV-%' " ).append("\n"); 
		query.append("               AND    A.CURR_CD = X1.CURR_CD" ).append("\n"); 
		query.append("               AND    X1.ACCT_XCH_RT_LVL = 3" ).append("\n"); 
		query.append("               AND    X1.ACCT_XCH_RT_YRMON =	(SELECT  MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                  				   FROM  PSO_TGT_VVD" ).append("\n"); 
		query.append("                                  				  WHERE  PSO_BZTP_CD = '2')   " ).append("\n"); 
		query.append("			   ) ADV -- 전도금 내역 조회" ).append("\n"); 
		query.append("            WHERE   PSO_BZTP_CD(+) = 2" ).append("\n"); 
		query.append("            AND     V.VSL_CD        = E.VSL_CD(+)" ).append("\n"); 
		query.append("            AND     V.SKD_VOY_NO    = E.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("            AND     V.SKD_DIR_CD    = E.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND     V.RLANE_CD    = E.RLANE_CD(+)" ).append("\n"); 
		query.append("            AND     V.VSL_CD        = C.VSL_CD(+)" ).append("\n"); 
		query.append("            AND     V.SKD_VOY_NO    = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("            AND     V.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND     V.RLANE_CD    = C.RLANE_CD(+)" ).append("\n"); 
		query.append("            AND     V.VSL_CD        = ADV.VSL_CD(+)" ).append("\n"); 
		query.append("            AND     V.SKD_VOY_NO    = ADV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("            AND     V.SKD_DIR_CD    = ADV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("            AND    NVL(C.LGS_COST_CD,E.LGS_COST_CD)  = T1.LGS_COST_CD" ).append("\n"); 
		query.append("            AND  ( E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD, E.YD_CD )" ).append("\n"); 
		query.append("                  IN ( select VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("                       from vsk_vsl_port_skd" ).append("\n"); 
		query.append("                       where VSL_CD = @[vsl_cd]--'HNBW'" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = @[skd_voy_no]--'0012' " ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = @[skd_dir_cd]--'W'" ).append("\n"); 
		query.append("                       AND VPS_PORT_CD = SUBSTR(@[yd_cd]/*'AUMELY1'*/, 1, 5)" ).append("\n"); 
		query.append("                      )    " ).append("\n"); 
		query.append("            GROUP BY V.ESTM_IOC_DIV_CD, V.EXE_YRMON, V.REV_YRMON, V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD,V.REV_DIR_CD,NVL(E.YD_CD,C.YD_CD), V.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("            ,V.ESTM_VVD_HDR_ID, V.ESTM_BC_DIV_CD, V.RLANE_CD, T1.ACCT_CD " ).append("\n"); 
		query.append("      ) T1" ).append("\n"); 

	}
}