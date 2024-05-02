/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOAddGlEstmIfErpByCreationCSQL.java
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

public class BudgetPortChargeMgtDBDAOAddGlEstmIfErpByCreationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_ESTM_IF_ERP 데이터를 저장한다.
	  * 
	  * * 2010.08.03
	  * 추정실적 산출시 진행항차에서 대하여 아래의 조건으로 Tariff Cost 산출
	  * 1) Carrier Code(Actual/MDM)가 HJS인 VVD만 생성
	  * 2) "PV"인 VVD만 진행 항차로 산출함
	  * 
	  * [CHM-201005568-01]
	  * 1. 운하 통항비(511911)- Actual invocie값이 입력되더라도
	  * Estimate 금액에 일치시키지 말고 Estimate 금액을 유지
	  * 2. 추정 시점으로 부터 4월앞의 발생된 Accural에 대하여 "0" 처리 요함
	  * (Mas 및 회계 data와 일치를 위함)
	  * 
	  * [CHM-201114431-01]
	  * 1. 511911 Actual Invoice amount 입력시 estmate로 사용하고 accural 0으로 처리함
	  * 2. 511911 Actual Invoice amount 미입력시 estimate는 Tariff Cost로 사용하고 accoural에 tariff Cost 비용을 입력함.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOAddGlEstmIfErpByCreationCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOAddGlEstmIfErpByCreationCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP (" ).append("\n"); 
		query.append("      EXE_YRMON," ).append("\n"); 
		query.append("      SYS_SRC_ID," ).append("\n"); 
		query.append("      REV_YRMON," ).append("\n"); 
		query.append("      ACCT_CD," ).append("\n"); 
		query.append("      ESTM_SEQ_NO," ).append("\n"); 
		query.append("      BIZ_UT_ID," ).append("\n"); 
		query.append("      LOC_CD," ).append("\n"); 
		query.append("      VSL_CD," ).append("\n"); 
		query.append("      SKD_VOY_NO," ).append("\n"); 
		query.append("      SKD_DIR_CD," ).append("\n"); 
		query.append("      REV_DIR_CD," ).append("\n"); 
		query.append("      ESTM_VVD_TP_CD, -- 'RV'" ).append("\n"); 
		query.append("      ESTM_IOC_DIV_CD, -- 'OO'" ).append("\n"); 
		query.append("      ESTM_BC_DIV_CD, -- 'C'" ).append("\n"); 
		query.append("      ESTM_VVD_HDR_ID, -- 106405" ).append("\n"); 
		query.append("      TTL_TRF_AMT," ).append("\n"); 
		query.append("      ESTM_AMT," ).append("\n"); 
		query.append("      ACT_AMT," ).append("\n"); 
		query.append("      ACCL_AMT," ).append("\n"); 
		query.append("      CRE_USR_ID," ).append("\n"); 
		query.append("      CRE_DT," ).append("\n"); 
		query.append("      UPD_USR_ID," ).append("\n"); 
		query.append("      UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("SELECT EXE_YRMON" ).append("\n"); 
		query.append("      ,'PSO' AS SYS_SRC_ID" ).append("\n"); 
		query.append("      ,REV_YRMON" ).append("\n"); 
		query.append("      ,ACCT_CD" ).append("\n"); 
		query.append("      ,ROWNUM AS ESTM_SEQ_NO" ).append("\n"); 
		query.append("      ,'CNTR' AS BIZ_UT_ID" ).append("\n"); 
		query.append("      ,LOC_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,REV_DIR_CD" ).append("\n"); 
		query.append("      ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("      ,ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("      ,ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("      ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("      ,TTL_TRF_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /**** OLD ****" ).append("\n"); 
		query.append("      ,ESTM_AMT" ).append("\n"); 
		query.append("      ,DECODE(ESTM_VVD_TP_CD, 'PV', 0, ACT_AMT)" ).append("\n"); 
		query.append("      ,DECODE(ESTM_VVD_TP_CD, 'PV', 0, ACCL_AMT)" ).append("\n"); 
		query.append("       **** OLD ****/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      /**** NEW ****/" ).append("\n"); 
		query.append("      ,ESTM_AMT     ESTM_AMT" ).append("\n"); 
		query.append("      ,DECODE(ESTM_VVD_TP_CD, 'PV', 0, ACT_AMT)  ACT_AMT" ).append("\n"); 
		query.append("      ,DECODE(ESTM_VVD_TP_CD, 'PV', 0, ESTM_AMT - ACT_AMT) ACCL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       CRE_DT" ).append("\n"); 
		query.append("      ,@[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT VVD.EXE_YRMON AS EXE_YRMON" ).append("\n"); 
		query.append("              ,VVD.REV_YRMON AS REV_YRMON" ).append("\n"); 
		query.append("              ,AMT.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("              ,SUBSTR(NVL(AMT.YD_CD, AMT.YD_CD), 1, 5) AS LOC_CD" ).append("\n"); 
		query.append("              ,VVD.VSL_CD" ).append("\n"); 
		query.append("              ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,VVD.REV_DIR_CD" ).append("\n"); 
		query.append("              ,VVD.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("              ,VVD.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("              ,VVD.ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("              ,VVD.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("              ,SUM(AMT.EST_AMT) AS TTL_TRF_AMT" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("              /**** OLD ****" ).append("\n"); 
		query.append("              ,SUM(DECODE(NVL(AMT.ACT_AMT, 0)," ).append("\n"); 
		query.append("                          0," ).append("\n"); 
		query.append("                          NVL(AMT.EST_AMT, 0)," ).append("\n"); 
		query.append("                          NVL(AMT.ACT_AMT, 0))) AS ESTM_AMT" ).append("\n"); 
		query.append("              ,SUM(NVL(AMT.ACT_AMT, 0)) AS ACT_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(NVL(AMT.ACT_AMT, 0)," ).append("\n"); 
		query.append("                          0," ).append("\n"); 
		query.append("                          NVL(AMT.EST_AMT, 0)," ).append("\n"); 
		query.append("                          NVL(AMT.ACT_AMT, 0))) - SUM(NVL(AMT.ACT_AMT, 0)) AS ACCL_AMT" ).append("\n"); 
		query.append("               **** OLD ****/" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("              /**** NEW ****/" ).append("\n"); 
		query.append("              ,(CASE " ).append("\n"); 
		query.append("		             WHEN MONTHS_BETWEEN(TO_DATE(EXE_YRMON, 'YYYYMM'), TO_DATE(REV_YRMON, 'YYYYMM')) >= 5 THEN" ).append("\n"); 
		query.append("		                  NVL(SUM(AMT.ACT_AMT), 0)        ----------- 수행월(EXE_YRMON) 5개월 이전 Accural에 대해서는 0 처리함.([CHM-201005568-01])" ).append("\n"); 
		query.append("--		             WHEN ACCT_CD = '511911' THEN " ).append("\n"); 
		query.append("--		         	      	(CASE" ).append("\n"); 
		query.append("--		                		-------- Accrual이 10만불 이하인 경우에는 Estimated Amount는 Actual Amount로 봄  [#Add 2010.09.07 by sj]" ).append("\n"); 
		query.append("--		                		WHEN NVL(SUM(AMT.EST_AMT), 0) - NVL(SUM(AMT.ACT_AMT), 0) <= 100000 THEN" ).append("\n"); 
		query.append("--		                			DECODE(NVL(SUM(AMT.ACT_AMT), 0), 0" ).append("\n"); 
		query.append("--		                             		, NVL(SUM(AMT.EST_AMT), 0)" ).append("\n"); 
		query.append("--		                             		, NVL(SUM(AMT.ACT_AMT), 0))" ).append("\n"); 
		query.append("--		                		-------- Accrual이 10만불 초과인 경우에는 Estimated Amount 유지  [#Add 2010.09.07 by sj]" ).append("\n"); 
		query.append("--		                		ELSE" ).append("\n"); 
		query.append("--		                		    NVL(SUM(AMT.EST_AMT), 0)        ----------- 운하통항비(511911)의 경우에는 Estimated Amount를 유지함.([CHM-201005568-01])" ).append("\n"); 
		query.append("--		                     END)" ).append("\n"); 
		query.append("		             ELSE " ).append("\n"); 
		query.append("		                   DECODE(NVL(SUM(AMT.ACT_AMT), 0), 0" ).append("\n"); 
		query.append("		                             , NVL(SUM(AMT.EST_AMT), 0)" ).append("\n"); 
		query.append("		                             , NVL(SUM(AMT.ACT_AMT), 0))" ).append("\n"); 
		query.append("		        END) ESTM_AMT                   " ).append("\n"); 
		query.append("              ,NVL(SUM(AMT.ACT_AMT), 0) ACT_AMT              " ).append("\n"); 
		query.append("             /* ,DECODE(NVL(SUM(AMT.ACT_AMT), 0), 0" ).append("\n"); 
		query.append("                                              , NVL(SUM(AMT.EST_AMT), 0)" ).append("\n"); 
		query.append("                                              , NVL(SUM(AMT.ACT_AMT), 0)) - NVL(SUM(AMT.ACT_AMT), 0) ACCL_AMT */" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        FROM   ----------------1.Target VVD" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                       ,EXE_YRMON" ).append("\n"); 
		query.append("                       ,REV_YRMON" ).append("\n"); 
		query.append("                       ,VSL_CD" ).append("\n"); 
		query.append("                       ,SKD_VOY_NO" ).append("\n"); 
		query.append("                       ,SKD_DIR_CD" ).append("\n"); 
		query.append("                       ,REV_DIR_CD" ).append("\n"); 
		query.append("                       ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                       ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                       ,ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("                       ,RLANE_CD" ).append("\n"); 
		query.append("                FROM   GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                WHERE  ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("                AND    EXE_YRMON = (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                    FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                    WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                #if(${rlane_cd} != '')" ).append("\n"); 
		query.append("				AND    RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                AND    ESTM_BC_DIV_CD IN ('C', 'M')" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                      ,EXE_YRMON" ).append("\n"); 
		query.append("                      ,REV_YRMON" ).append("\n"); 
		query.append("                      ,VSL_CD" ).append("\n"); 
		query.append("                      ,SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,REV_DIR_CD" ).append("\n"); 
		query.append("                      ,ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                      ,ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("                      ,ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("                      ,RLANE_CD" ).append("\n"); 
		query.append("                FROM   GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("                WHERE  ESTM_IOC_DIV_CD <> 'OO'" ).append("\n"); 
		query.append("                AND    (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD) NOT IN" ).append("\n"); 
		query.append("                       (SELECT VSL_CD" ).append("\n"); 
		query.append("                               ,SKD_VOY_NO" ).append("\n"); 
		query.append("                               ,SKD_DIR_CD" ).append("\n"); 
		query.append("                               ,REV_DIR_CD" ).append("\n"); 
		query.append("                         FROM   GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                         WHERE  ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("                         AND    EXE_YRMON =" ).append("\n"); 
		query.append("                                (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                  FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                  WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                         #if(${rlane_cd} != '')" ).append("\n"); 
		query.append("						 AND    RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("						 #end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                AND    EXE_YRMON = (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                    FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                    WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                AND    ESTM_BC_DIV_CD IN ('C', 'M')" ).append("\n"); 
		query.append("                #if(${rlane_cd} != '')" ).append("\n"); 
		query.append("				AND    RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("	            AND     ( ESTM_VVD_TP_CD  <> 'PV'  " ).append("\n"); 
		query.append("		            	 OR" ).append("\n"); 
		query.append("		            	 -- 진행항차의 경우에는 RLANE의 4번째 자리가 'I'인 경우에는 Internal만 있는 경우 포함, 그 외에는 제외 [#Mod 2010.09.07 by sj]" ).append("\n"); 
		query.append("		            	 (ESTM_VVD_TP_CD  = 'PV' AND 'I' = SUBSTR(RLANE_CD, 4, 1) ))" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ) VVD" ).append("\n"); 
		query.append("              ," ).append("\n"); 
		query.append("               ---------------- END ) 1. Target VVD " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                ----------------START) 2 Estimte Amount / Actual Amount" ).append("\n"); 
		query.append("                SELECT VSL_CD" ).append("\n"); 
		query.append("                       ,SKD_VOY_NO" ).append("\n"); 
		query.append("                       ,SKD_DIR_CD" ).append("\n"); 
		query.append("                       ,RLANE_CD" ).append("\n"); 
		query.append("                       ,YD_CD" ).append("\n"); 
		query.append("                       ,ACCT_CD" ).append("\n"); 
		query.append("                       ,SUM(EST_USD_AMT) AS EST_AMT" ).append("\n"); 
		query.append("                       ,SUM(ACT_AMT) AS ACT_AMT" ).append("\n"); 
		query.append("                FROM   (SELECT VSL_CD" ).append("\n"); 
		query.append("                                ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                ,RLANE_CD" ).append("\n"); 
		query.append("                                ,YD_CD" ).append("\n"); 
		query.append("                                ,ACCT_CD" ).append("\n"); 
		query.append("                                -- 운하통항비의 Estimated Amount는 생성된 전도금이 있으면 이를 사용하고," ).append("\n"); 
		query.append("                                -- 없으면 Tariff에 의해 계산된 Tariff Cost를 사용한다." ).append("\n"); 
		query.append("                                ,(CASE " ).append("\n"); 
		query.append("                                    WHEN ACCT_CD = '511911' THEN" ).append("\n"); 
		query.append("                                        NVL((SELECT ROUND(TTL_LOCL_AMT / XHG_RT, 2)" ).append("\n"); 
		query.append("                                               FROM PSO_CHARGE" ).append("\n"); 
		query.append("                                              WHERE INV_NO LIKE '%-'||VSL_CD||SKD_VOY_NO||SKD_DIR_CD||'%-ADV-%')," ).append("\n"); 
		query.append("                                             EST_USD_AMT)" ).append("\n"); 
		query.append("                                    ELSE EST_USD_AMT" ).append("\n"); 
		query.append("                                 END) EST_USD_AMT" ).append("\n"); 
		query.append("                                ,ACT_AMT" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            SELECT E.VSL_CD" ).append("\n"); 
		query.append("                                   ,E.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   ,E.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   ,E.RLANE_CD" ).append("\n"); 
		query.append("                                   ,E.YD_CD" ).append("\n"); 
		query.append("                                   ,CT.ACCT_CD" ).append("\n"); 
		query.append("                                   ,SUM(ROUND(E.INV_LOCL_AMT / X1.USD_LOCL_XCH_RT, 2)) AS EST_USD_AMT" ).append("\n"); 
		query.append("                                   ,MAX(X1.USD_LOCL_XCH_RT) XHG_RT" ).append("\n"); 
		query.append("                                   ,0 AS ACT_AMT" ).append("\n"); 
		query.append("                             FROM   PSO_TGT_VVD     T" ).append("\n"); 
		query.append("                                   ,PSO_TGT_YD_EXPN E" ).append("\n"); 
		query.append("                                   ,GL_MON_XCH_RT   X1" ).append("\n"); 
		query.append("                                   ,TES_LGS_COST    CT" ).append("\n"); 
		query.append("                             WHERE  T.PSO_BZTP_CD = '2'" ).append("\n"); 
		query.append("                             AND    T.PSO_BZTP_CD = E.PSO_BZTP_CD" ).append("\n"); 
		query.append("                             AND    T.VSL_CD = E.VSL_CD" ).append("\n"); 
		query.append("                             AND    T.SKD_VOY_NO = E.SKD_VOY_NO" ).append("\n"); 
		query.append("                             AND    T.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                             AND    E.LGS_COST_CD = CT.LGS_COST_CD" ).append("\n"); 
		query.append("                             AND    T.EXPN_YRMON =" ).append("\n"); 
		query.append("                                    (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                      FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                      WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                             AND    E.LOCL_CURR_CD = X1.CURR_CD" ).append("\n"); 
		query.append("                             AND    X1.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                             AND    X1.ACCT_XCH_RT_YRMON =" ).append("\n"); 
		query.append("                                    (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                      FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                      WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                             #if(${rlane_cd} != '')" ).append("\n"); 
		query.append("    						 AND    RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("    						 #end" ).append("\n"); 
		query.append("                             GROUP  BY E.VSL_CD" ).append("\n"); 
		query.append("                                      ,E.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,E.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,E.RLANE_CD" ).append("\n"); 
		query.append("                                      ,E.YD_CD" ).append("\n"); 
		query.append("                                      ,CT.ACCT_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                         SELECT VSL_CD" ).append("\n"); 
		query.append("                               ,SKD_VOY_NO" ).append("\n"); 
		query.append("                               ,SKD_DIR_CD" ).append("\n"); 
		query.append("                               ,RLANE_CD" ).append("\n"); 
		query.append("                               ,YD_CD" ).append("\n"); 
		query.append("                               ,ACCT_CD" ).append("\n"); 
		query.append("                               ,0 AS EST_USD_AMT" ).append("\n"); 
		query.append("                               ,SUM(ACT_AMT) ACT_AMT" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                                SELECT C2.VSL_CD" ).append("\n"); 
		query.append("                                        -- TURN / VIRTUAL 항차 구분 - 사용자가 IO 입력하지 않은 경우에는 시스템에서 자동으로 배분하므로," ).append("\n"); 
		query.append("                                        -- 사용자가 IO 입력하지 않은 경우에는 INVOICE의 데이터를 이용." ).append("\n"); 
		query.append("                                        -- 그 외에는 SKD의 TURN_VOY_NO 사용" ).append("\n"); 
		query.append("                                       ,(CASE " ).append("\n"); 
		query.append("                                            WHEN CNT = 0 OR C2.DP_IO_BND_CD IS NULL THEN" ).append("\n"); 
		query.append("                                                C2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            ELSE" ).append("\n"); 
		query.append("                                                NVL(V.TURN_SKD_VOY_NO, C2.SKD_VOY_NO)" ).append("\n"); 
		query.append("                                        END) SKD_VOY_NO" ).append("\n"); 
		query.append("                                       ,(CASE " ).append("\n"); 
		query.append("                                            WHEN CNT = 0 OR C2.DP_IO_BND_CD IS NULL THEN" ).append("\n"); 
		query.append("                                                C2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            ELSE" ).append("\n"); 
		query.append("                                                NVL(V.TURN_SKD_DIR_CD, C2.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                        END) SKD_DIR_CD" ).append("\n"); 
		query.append("                                        ,(CASE " ).append("\n"); 
		query.append("                                            WHEN CNT = 0 OR C2.DP_IO_BND_CD IS NULL THEN" ).append("\n"); 
		query.append("                                                C2.RLANE_CD" ).append("\n"); 
		query.append("                                            ELSE" ).append("\n"); 
		query.append("                                                NVL(PSO_GET_REV_LANE_FNC(V.VSL_CD, V.TURN_SKD_VOY_NO, V.TURN_SKD_DIR_CD, SUBSTR (C1.YD_CD, 1, 5)), C2.RLANE_CD)" ).append("\n"); 
		query.append("                                        END) RLANE_CD" ).append("\n"); 
		query.append("                                       ,C1.YD_CD" ).append("\n"); 
		query.append("                                       ,CT.ACCT_CD" ).append("\n"); 
		query.append("                                       ,0 AS EST_USD_AMT" ).append("\n"); 
		query.append("                                       ,ROUND((C2.LOCL_AMT / X1.USD_LOCL_XCH_RT) * 0.5, 2)  ACT_AMT" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("                                 FROM   PSO_CHARGE    C1" ).append("\n"); 
		query.append("                                       ,PSO_CHG_DTL   C2" ).append("\n"); 
		query.append("                                       ,GL_MON_XCH_RT X1" ).append("\n"); 
		query.append("                                       ,AP_PAY_INV    A1" ).append("\n"); 
		query.append("                                       ,AP_INV_HDR    A2							" ).append("\n"); 
		query.append("                                       ,TES_LGS_COST  CT" ).append("\n"); 
		query.append("                                       ,VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                       ,(SELECT CPY_NO CNT FROM COM_CPY_NO WHERE CPY_NO <= 1)" ).append("\n"); 
		query.append("                                 WHERE  C1.ISS_CTY_CD = C2.ISS_CTY_CD" ).append("\n"); 
		query.append("                                 AND    C1.SO_SEQ = C2.SO_SEQ" ).append("\n"); 
		query.append("                                 AND    C1.INV_NO NOT LIKE 'D-%-ADV-%'" ).append("\n"); 
		query.append("                                 AND    C1.INV_NO NOT LIKE 'B-%-ADV-%'" ).append("\n"); 
		query.append("                                 AND    C1.INV_RGST_NO = A1.INV_RGST_NO" ).append("\n"); 
		query.append("                                 AND    A1.INV_STS_CD IN ('P', 'D')" ).append("\n"); 
		query.append("                                 AND    A1.INV_SUB_SYS_CD = 'PSO'" ).append("\n"); 
		query.append("                                 AND    C1.CURR_CD = X1.CURR_CD" ).append("\n"); 
		query.append("                                 AND    X1.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                 AND    X1.ACCT_XCH_RT_YRMON =" ).append("\n"); 
		query.append("                                        (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                          FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                          WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                                 AND    C2.LGS_COST_CD = CT.LGS_COST_CD" ).append("\n"); 
		query.append("                                 AND    A1.CSR_NO = A2.CSR_NO" ).append("\n"); 
		query.append("                                 AND    NVL(A2.GL_DT, '1') <= (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                          						 FROM PSO_TGT_VVD" ).append("\n"); 
		query.append("                                          						WHERE PSO_BZTP_CD = '2')||'31'" ).append("\n"); 
		query.append("                                 AND    EXISTS" ).append("\n"); 
		query.append("                                              (SELECT 'X'" ).append("\n"); 
		query.append("                                                     FROM   GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                                                     WHERE  EXE_YRMON =" ).append("\n"); 
		query.append("                                                            (SELECT MAX(EXPN_YRMON)" ).append("\n"); 
		query.append("                                                             FROM   PSO_TGT_VVD" ).append("\n"); 
		query.append("                                                             WHERE  PSO_BZTP_CD = '2')" ).append("\n"); 
		query.append("                                                     #if(${rlane_cd} != '')" ).append("\n"); 
		query.append("                    								 AND    RLANE_CD = @[rlane_cd] " ).append("\n"); 
		query.append("                    								 #end" ).append("\n"); 
		query.append("                                                     AND    VSL_CD = C2.VSL_CD" ).append("\n"); 
		query.append("                                                     AND    SKD_VOY_NO = C2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     AND    SKD_DIR_CD = C2.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                AND C2.VSL_CD = V.VSL_CD(+) AND C2.SKD_VOY_NO = V.SKD_VOY_NO(+) AND C2.SKD_DIR_CD = V.SKD_DIR_CD(+) AND C1.YD_CD = NVL(V.YD_CD, C1.YD_CD)" ).append("\n"); 
		query.append("                                AND NVL(V.CLPT_SEQ, 1) = NVL((SELECT MIN(CLPT_SEQ) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                WHERE VSL_CD = V.VSL_CD AND SKD_VOY_NO = V.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                                AND SKD_DIR_CD = V.SKD_DIR_CD AND YD_CD = V.YD_CD" ).append("\n"); 
		query.append("                                                                AND 'S' <> NVL(SKD_CNG_STS_CD, ' ')), 1)" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         GROUP  BY VSL_CD" ).append("\n"); 
		query.append("                                   ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                   ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                   ,RLANE_CD" ).append("\n"); 
		query.append("                                   ,YD_CD" ).append("\n"); 
		query.append("                                   ,ACCT_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                GROUP  BY VSL_CD" ).append("\n"); 
		query.append("                          ,SKD_VOY_NO" ).append("\n"); 
		query.append("                          ,SKD_DIR_CD" ).append("\n"); 
		query.append("                          ,RLANE_CD" ).append("\n"); 
		query.append("                          ,YD_CD" ).append("\n"); 
		query.append("                          ,ACCT_CD" ).append("\n"); 
		query.append("                ----------------END) 2 Estimte Amount / Actual Amount END   " ).append("\n"); 
		query.append("                ) AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        WHERE  1 = 1" ).append("\n"); 
		query.append("        AND    VVD.VSL_CD = AMT.VSL_CD" ).append("\n"); 
		query.append("        AND    VVD.SKD_VOY_NO = AMT.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    VVD.SKD_DIR_CD = AMT.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    VVD.RLANE_CD = AMT.RLANE_CD" ).append("\n"); 
		query.append("        GROUP  BY VVD.EXE_YRMON" ).append("\n"); 
		query.append("                 ,VVD.REV_YRMON" ).append("\n"); 
		query.append("                 ,AMT.ACCT_CD" ).append("\n"); 
		query.append("                 ,SUBSTR(NVL(AMT.YD_CD, AMT.YD_CD), 1, 5)" ).append("\n"); 
		query.append("                 ,VVD.VSL_CD" ).append("\n"); 
		query.append("                 ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,VVD.REV_DIR_CD" ).append("\n"); 
		query.append("                 ,VVD.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                 ,VVD.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                 ,VVD.ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("                 ,VVD.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("        ORDER  BY LOC_CD" ).append("\n"); 
		query.append("                 ,ACCT_CD" ).append("\n"); 
		query.append("                 ,VSL_CD" ).append("\n"); 
		query.append("                 ,SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,REV_DIR_CD)" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND ACCT_CD       NOT IN (962111, 564611)" ).append("\n"); 
		query.append("AND ACCT_CD = DECODE(ACCT_CD, '511791', DECODE(ACT_AMT, 0, '', ACCT_CD),	/**ACCL_AMT가 0이 아니면 511791~5 Account를 제외함**/" ).append("\n"); 
		query.append("							  '511792', DECODE(ACT_AMT, 0, '', ACCT_CD),	" ).append("\n"); 
		query.append("							  '511793', DECODE(ACT_AMT, 0, '', ACCT_CD),	" ).append("\n"); 
		query.append("							  '511794', DECODE(ACT_AMT, 0, '', ACCT_CD),	" ).append("\n"); 
		query.append("							  '511795', DECODE(ACT_AMT, 0, '', ACCT_CD),	" ).append("\n"); 
		query.append("			  				  '511751', DECODE(SUBSTR(LOC_CD,1,2),'CN',DECODE(ACT_AMT, 0, '', ACCT_CD)," ).append("\n"); 
		query.append("                                                                  'IT',DECODE(ACT_AMT, 0, '', ACCT_CD)," ).append("\n"); 
		query.append("                                                                  'TW',DECODE(ACT_AMT, 0, '', ACCT_CD)," ).append("\n"); 
		query.append("                                                                  'JP',DECODE(ACT_AMT, 0, '', ACCT_CD),  " ).append("\n"); 
		query.append("                                                                  ACCT_CD)," ).append("\n"); 
		query.append("                                        ACCT_CD) /**중국 Tonnage 비용인 경우 ACT_AMT가 0이면 511791 Account를 제외함**/" ).append("\n"); 

	}
}