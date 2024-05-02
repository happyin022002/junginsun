/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchSumRptByPeriodSoRSQL.java
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

public class BudgetPortChargeMgtDBDAOsearchSumRptByPeriodSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port별 Budget vs Actual을 조회한다.
	  * ==========================
	  * History
	  * 2012.08.20 진마리아 CHM-201219078-01 사업계획 - 시나리오 연도 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchSumRptByPeriodSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchSumRptByPeriodSoRSQL").append("\n"); 
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
		query.append("--By Port (By Choi)" ).append("\n"); 
		query.append("SELECT AMT.LANE_PORT VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,AMT.ACCT_CD LGS_COST_CD" ).append("\n"); 
		query.append("      ,SUM(BUDGET_AMOUNT) BUDGET_AMOUNT" ).append("\n"); 
		query.append("      ,SUM(BUDGET_CALL) BUDGET_CALL" ).append("\n"); 
		query.append("      ,SUM(ESTIMA_AMOUNT) ESTIMA_AMOUNT" ).append("\n"); 
		query.append("      ,SUM(ESTIMA_CALL) ESTIMA_CALL" ).append("\n"); 
		query.append("      ,SUM(ACTUAL_AMOUNT) ACTUAL_AMOUNT" ).append("\n"); 
		query.append("      ,SUM(ACTUAL_CALL) ACTUAL_CALL" ).append("\n"); 
		query.append("      ,NVL(SUM(BUDGET_AMOUNT), 0) - NVL(SUM(ACTUAL_AMOUNT), 0) BUDGET_VS_ACTUAL_AMOUNT" ).append("\n"); 
		query.append("      ,NVL(SUM(BUDGET_CALL), 0) - NVL(SUM(ACTUAL_CALL), 0) BUDGET_VS_ACTUAL_CALL" ).append("\n"); 
		query.append("      ,NVL(SUM(ESTIMA_AMOUNT), 0) - NVL(SUM(ACTUAL_AMOUNT), 0) ESTIMA_VS_ACTUAL_AMOUNT" ).append("\n"); 
		query.append("      ,NVL(SUM(ESTIMA_CALL), 0) - NVL(SUM(ACTUAL_CALL), 0) ESTIMA_VS_ACTUAL_CALL" ).append("\n"); 
		query.append("      ,NVL(SUM(BUDGET_AMOUNT), 0) - NVL(SUM(ESTIMA_AMOUNT), 0) BUDGET_VS_ESTIMA_AMOUNT" ).append("\n"); 
		query.append("      ,NVL(SUM(BUDGET_CALL), 0) - NVL(SUM(ESTIMA_CALL), 0) BUDGET_VS_ESTIMA_CALL" ).append("\n"); 
		query.append("FROM   (SELECT LANE_PORT" ).append("\n"); 
		query.append("              ,ACCT_CD" ).append("\n"); 
		query.append("              ,SUM(BUDGET_AMOUNT) BUDGET_AMOUNT" ).append("\n"); 
		query.append("              ,SUM(ESTIMA_AMOUNT) ESTIMA_AMOUNT" ).append("\n"); 
		query.append("              ,SUM(ACTUAL_AMOUNT) ACTUAL_AMOUNT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("                -- bud amt" ).append("\n"); 
		query.append("                SELECT SUBSTR(T22.YD_CD, 1, 5) AS LANE_PORT" ).append("\n"); 
		query.append("                       ,CST.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("                       ,SUM(NVL(INV_USD_AMT, 0)) AS BUDGET_AMOUNT" ).append("\n"); 
		query.append("                       ,NULL AS BUDGET_CALL" ).append("\n"); 
		query.append("                       ,NULL AS ESTIMA_AMOUNT" ).append("\n"); 
		query.append("                       ,NULL AS ESTIMA_CALL" ).append("\n"); 
		query.append("                       ,NULL AS ACTUAL_AMOUNT" ).append("\n"); 
		query.append("                       ,NULL AS ACTUAL_CALL" ).append("\n"); 
		query.append("                FROM   PSO_TGT_VVD     T21" ).append("\n"); 
		query.append("                       ,PSO_TGT_YD_EXPN T22" ).append("\n"); 
		query.append("                       ,TES_LGS_COST    CST" ).append("\n"); 
		query.append("                       ,MDM_VSL_CNTR    VSL" ).append("\n"); 
		query.append("                WHERE  T21.VSL_CD = T22.VSL_CD(+)" ).append("\n"); 
		query.append("                AND    T21.SKD_VOY_NO = T22.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND    T21.SKD_DIR_CD = T22.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND    T21.BUD_SCNR_NO = T22.BUD_SCNR_NO(+)" ).append("\n"); 
		query.append("                AND    T22.LGS_COST_CD = CST.LGS_COST_CD(+)" ).append("\n"); 
		query.append("                AND    T21.PSO_BZTP_CD = 1" ).append("\n"); 
		query.append("                AND    T21.PSO_BZTP_CD = T22.PSO_BZTP_CD" ).append("\n"); 
		query.append("                AND    T21.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                AND    T22.REV_YRMON BETWEEN @[cre_dt_fr] AND @[cre_dt_to]" ).append("\n"); 
		query.append("                AND    TO_CHAR(T21.CRE_DT,'YYYYMM') = (SELECT MAX(TO_CHAR(CRE_DT,'YYYYMM')) FROM PSO_TGT_VVD WHERE PSO_BZTP_CD='1')--BUD_SCNR_NO 조건 없이 가장 최근 생성된 VVD만을 대상으로 함" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("                AND    T21.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${port_cd}!='' && ${term_code}=='')" ).append("\n"); 
		query.append("				AND    T22.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                AND    T22.YD_CD IN (@[term_code])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${combo1}!='ALL' and ${combo1}!='')" ).append("\n"); 
		query.append("                AND    CST.ACCT_CD = @[combo1]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${combo2}!='ALL' and ${combo2}!='')" ).append("\n"); 
		query.append("                AND    VSL.CNTR_VSL_CLSS_CAPA = @[combo2]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                GROUP  BY T21.PSO_BZTP_CD" ).append("\n"); 
		query.append("                          ,SUBSTR(T22.YD_CD, 1, 5)" ).append("\n"); 
		query.append("                          ,CST.ACCT_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                -- Est amt" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                SELECT SUBSTR(T22.YD_CD, 1, 5) AS LANE_PORT" ).append("\n"); 
		query.append("                      ,CST.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("                      ,NULL AS BUDGET_AMOUNT" ).append("\n"); 
		query.append("                      ,NULL AS BUDGET_CALL" ).append("\n"); 
		query.append("                      ,SUM(NVL(INV_USD_AMT, 0)) AS ESTIMA_AMOUNT" ).append("\n"); 
		query.append("                      ,NULL AS ESTIMA_CALL" ).append("\n"); 
		query.append("                      ,NULL AS ACTUAL_AMOUNT" ).append("\n"); 
		query.append("                      ,NULL AS ACTUAL_CALL" ).append("\n"); 
		query.append("                FROM   PSO_TGT_VVD     T21" ).append("\n"); 
		query.append("                      ,PSO_TGT_YD_EXPN T22" ).append("\n"); 
		query.append("                      ,TES_LGS_COST    CST" ).append("\n"); 
		query.append("                      ,MDM_VSL_CNTR    VSL" ).append("\n"); 
		query.append("                WHERE  T21.VSL_CD = T22.VSL_CD(+)" ).append("\n"); 
		query.append("                AND    T21.SKD_VOY_NO = T22.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND    T21.SKD_DIR_CD = T22.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND    T22.LGS_COST_CD = CST.LGS_COST_CD(+)" ).append("\n"); 
		query.append("                AND    T21.PSO_BZTP_CD = 2" ).append("\n"); 
		query.append("                AND    T21.PSO_BZTP_CD = T22.PSO_BZTP_CD" ).append("\n"); 
		query.append("                AND    T21.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                AND    T22.REV_YRMON BETWEEN @[cre_dt_fr] AND @[cre_dt_to]" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("                AND    T21.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${port_cd}!='' && ${term_code}=='')" ).append("\n"); 
		query.append("				AND    T22.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                AND    T22.YD_CD IN (@[term_code])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${combo1}!='ALL' and ${combo1}!='')" ).append("\n"); 
		query.append("                AND    CST.ACCT_CD = @[combo1]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${combo2}!='ALL' and ${combo2}!='')" ).append("\n"); 
		query.append("                AND    VSL.CNTR_VSL_CLSS_CAPA = @[combo2]" ).append("\n"); 
		query.append("                #end   " ).append("\n"); 
		query.append("                           " ).append("\n"); 
		query.append("                GROUP  BY T21.PSO_BZTP_CD" ).append("\n"); 
		query.append("                         ,SUBSTR(T22.YD_CD, 1, 5)" ).append("\n"); 
		query.append("                         ,CST.ACCT_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                -- Actual amt" ).append("\n"); 
		query.append("                SELECT /*+ index(t10 XPKAR_MST_REV_VVD) */" ).append("\n"); 
		query.append("                 SUBSTR(SOH.YD_CD, 1, 5) AS LANE_PORT" ).append("\n"); 
		query.append("                ,CST.ACCT_CD AS ACCT_CD" ).append("\n"); 
		query.append("                ,NULL AS BUDGET_AMOUNT" ).append("\n"); 
		query.append("                ,NULL AS BUDGET_CALL" ).append("\n"); 
		query.append("                ,NULL AS ESTIMA_AMOUNT" ).append("\n"); 
		query.append("                ,NULL AS ESTIMA_CALLACTUAL_AMOUNT" ).append("\n"); 
		query.append("                ,SUM(USD_AMT) AS ACTUAL_AMOUNT" ).append("\n"); 
		query.append("                ,NULL AS ACTUAL_CALL" ).append("\n"); 
		query.append("                FROM   PSO_CHARGE     SOH" ).append("\n"); 
		query.append("                      ,PSO_CHG_DTL    SOD" ).append("\n"); 
		query.append("                      ,AR_MST_REV_VVD T10" ).append("\n"); 
		query.append("                      ,TES_LGS_COST   CST" ).append("\n"); 
		query.append("                      ,MDM_VSL_CNTR   VSL" ).append("\n"); 
		query.append("                WHERE  SOD.AR_YRMON BETWEEN @[cre_dt_fr] AND @[cre_dt_to]" ).append("\n"); 
		query.append("                AND    SOH.ISS_CTY_CD = SOD.ISS_CTY_CD" ).append("\n"); 
		query.append("                AND    SOH.SO_SEQ = SOD.SO_SEQ" ).append("\n"); 
		query.append("                AND    SOD.LGS_COST_CD = CST.LGS_COST_CD" ).append("\n"); 
		query.append("                AND    SOD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("                AND    SOD.VSL_CD = T10.VSL_CD" ).append("\n"); 
		query.append("                AND    SOD.SKD_VOY_NO = T10.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND    SOD.SKD_DIR_CD = T10.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND    SOD.REV_DIR_CD = T10.RLANE_DIR_CD" ).append("\n"); 
		query.append("                AND    SOD.RLANE_CD = T10.RLANE_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("                AND    T10.SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${port_cd}!='' && ${term_code}=='')" ).append("\n"); 
		query.append("				AND    SOH.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if(${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                AND    SOH.YD_CD IN (@[term_code])" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${combo1}!='ALL' and ${combo1}!='')" ).append("\n"); 
		query.append("                AND    CST.ACCT_CD = @[combo1]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ---adding options" ).append("\n"); 
		query.append("				#if(${combo2}!='ALL' and ${combo2}!='')" ).append("\n"); 
		query.append("                AND    VSL.CNTR_VSL_CLSS_CAPA = @[combo2]" ).append("\n"); 
		query.append("                #end                  " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                GROUP  BY SUBSTR(SOH.YD_CD, 1, 5)" ).append("\n"); 
		query.append("                         ,CST.ACCT_CD" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        GROUP  BY LANE_PORT" ).append("\n"); 
		query.append("                 ,ACCT_CD) AMT" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        -- Bud call" ).append("\n"); 
		query.append("        SELECT LANE_PORT" ).append("\n"); 
		query.append("               ,COUNT(*) AS BUDGET_CALL" ).append("\n"); 
		query.append("        FROM   (SELECT DISTINCT T12.VSL_CD" ).append("\n"); 
		query.append("                                ,T12.SKD_VOY_NO" ).append("\n"); 
		query.append("                                ,T12.SKD_DIR_CD" ).append("\n"); 
		query.append("                                ,SUBSTR(T12.YD_CD, 1, 5) AS LANE_PORT" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 FROM   PSO_TGT_VVD     T11" ).append("\n"); 
		query.append("                       ,PSO_TGT_YD_SKD  T12" ).append("\n"); 
		query.append("                       ,PSO_TGT_YD_EXPN T13" ).append("\n"); 
		query.append("                       ,MDM_VSL_CNTR    VSL" ).append("\n"); 
		query.append("                 WHERE  1 = 1" ).append("\n"); 
		query.append("                 AND    T11.PSO_BZTP_CD = 1" ).append("\n"); 
		query.append("                 AND    T11.PSO_BZTP_CD = T12.PSO_BZTP_CD" ).append("\n"); 
		query.append("                 AND    T11.VSL_CD = T12.VSL_CD" ).append("\n"); 
		query.append("                 AND    T11.SKD_VOY_NO = T12.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    T11.SKD_DIR_CD = T12.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    T11.BUD_SCNR_NO = T12.BUD_SCNR_NO" ).append("\n"); 
		query.append("                 AND    T12.PSO_BZTP_CD = T13.PSO_BZTP_CD" ).append("\n"); 
		query.append("                 AND    T12.VSL_CD = T13.VSL_CD" ).append("\n"); 
		query.append("                 AND    T12.SKD_VOY_NO = T13.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    T12.SKD_DIR_CD = T13.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    T12.YD_CD = T13.YD_CD" ).append("\n"); 
		query.append("                 AND    T12.BUD_SCNR_NO = T13.BUD_SCNR_NO" ).append("\n"); 
		query.append("                 AND    T12.CALL_YD_SEQ > 0" ).append("\n"); 
		query.append("                 AND    T11.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                 AND    T13.REV_YRMON BETWEEN @[cre_dt_fr] AND @[cre_dt_to]" ).append("\n"); 
		query.append("                 AND    TO_CHAR(T11.CRE_DT,'YYYYMM') = (SELECT MAX(TO_CHAR(CRE_DT,'YYYYMM')) FROM PSO_TGT_VVD WHERE PSO_BZTP_CD='1')--BUD_SCNR_NO 조건 없이 가장 최근 생성된 VVD만을 대상으로 함" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("                 AND    T11.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${port_cd}!='' && ${term_code}=='')" ).append("\n"); 
		query.append("				 AND    T12.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if(${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                 AND    T12.YD_CD IN (@[term_code])" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${combo2}!='ALL' and ${combo2}!='')" ).append("\n"); 
		query.append("                 AND    VSL.CNTR_VSL_CLSS_CAPA = @[combo2]" ).append("\n"); 
		query.append("                 #end                    " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("        GROUP  BY LANE_PORT) BC" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        -- Est call" ).append("\n"); 
		query.append("        SELECT LANE_PORT" ).append("\n"); 
		query.append("               ,COUNT(*) AS ESTIMA_CALL" ).append("\n"); 
		query.append("        FROM   (SELECT /*+ index(t10 XPKAR_MST_REV_VVD) */" ).append("\n"); 
		query.append("                 DISTINCT TGT.VSL_CD" ).append("\n"); 
		query.append("                         ,TGT.SKD_VOY_NO" ).append("\n"); 
		query.append("                         ,TGT.SKD_DIR_CD" ).append("\n"); 
		query.append("                         ,SUBSTR(TGT.YD_CD, 1, 5) AS LANE_PORT" ).append("\n"); 
		query.append("                 FROM   AR_MST_REV_VVD T10" ).append("\n"); 
		query.append("                       ,PSO_TGT_YD_SKD TGT" ).append("\n"); 
		query.append("                       ,MDM_VSL_CNTR   VSL" ).append("\n"); 
		query.append("                 WHERE  T10.REV_YRMON BETWEEN @[cre_dt_fr] AND @[cre_dt_to]" ).append("\n"); 
		query.append("                 AND    T10.RLANE_CD =" ).append("\n"); 
		query.append("                        PSO_GET_REV_LANE_FNC(TGT.VSL_CD," ).append("\n"); 
		query.append("                                              TGT.SKD_VOY_NO," ).append("\n"); 
		query.append("                                              TGT.SKD_DIR_CD," ).append("\n"); 
		query.append("                                              SUBSTR(TGT.YD_CD, 1, 5))" ).append("\n"); 
		query.append("                 AND    TGT.PSO_BZTP_CD = 2" ).append("\n"); 
		query.append("                 AND    T10.VSL_CD = TGT.VSL_CD" ).append("\n"); 
		query.append("                 AND    T10.SKD_VOY_NO = TGT.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    T10.SKD_DIR_CD = TGT.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    T10.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                 AND    TGT.CALL_YD_SEQ > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("                 AND    T10.SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${port_cd}!='' && ${term_code}=='')" ).append("\n"); 
		query.append("				 AND    TGT.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if(${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                 AND    TGT.YD_CD IN (@[term_code])" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${combo2}!='ALL' and ${combo2}!='')" ).append("\n"); 
		query.append("                 AND    VSL.CNTR_VSL_CLSS_CAPA = @[combo2]" ).append("\n"); 
		query.append("                 #end                     " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP  BY LANE_PORT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ) EC" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        -- Actual call" ).append("\n"); 
		query.append("        SELECT LANE_PORT" ).append("\n"); 
		query.append("               ,COUNT(*) AS ACTUAL_CALL" ).append("\n"); 
		query.append("        FROM   (SELECT /*+ index(t10 XPKAR_MST_REV_VVD) */" ).append("\n"); 
		query.append("                 DISTINCT VSK.VSL_CD" ).append("\n"); 
		query.append("                         ,VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                         ,VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                         ,VSK.VPS_PORT_CD AS LANE_PORT" ).append("\n"); 
		query.append("                         ,VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 FROM   AR_MST_REV_VVD   T10" ).append("\n"); 
		query.append("                       ,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                       ,MDM_VSL_CNTR     VSL" ).append("\n"); 
		query.append("                 WHERE  REV_YRMON BETWEEN @[cre_dt_fr] AND @[cre_dt_to]" ).append("\n"); 
		query.append("                 AND    T10.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("                 AND    T10.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    T10.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    T10.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                 AND    T10.RLANE_CD =" ).append("\n"); 
		query.append("                        PSO_GET_REV_LANE_FNC(VSK.VSL_CD," ).append("\n"); 
		query.append("                                              VSK.SKD_VOY_NO," ).append("\n"); 
		query.append("                                              VSK.SKD_DIR_CD," ).append("\n"); 
		query.append("                                              VSK.VPS_PORT_CD)" ).append("\n"); 
		query.append("                 AND    VSK.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("                 AND    T10.SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${port_cd}!='' && ${term_code}=='')" ).append("\n"); 
		query.append("				 AND    VSK.YD_CD LIKE @[port_cd] || '%'" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("				 #if(${port_cd}!='' && ${term_code}!='')" ).append("\n"); 
		query.append("                 AND    VSK.YD_CD IN (@[term_code])" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ---adding options" ).append("\n"); 
		query.append("				 #if(${combo2}!='ALL' and ${combo2}!='')" ).append("\n"); 
		query.append("                 AND    VSL.CNTR_VSL_CLSS_CAPA = @[combo2]" ).append("\n"); 
		query.append("                 #end         " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP  BY LANE_PORT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ) AC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    AMT.LANE_PORT = BC.LANE_PORT(+)" ).append("\n"); 
		query.append("AND    AMT.LANE_PORT = EC.LANE_PORT(+)" ).append("\n"); 
		query.append("AND    AMT.LANE_PORT = AC.LANE_PORT(+)" ).append("\n"); 
		query.append("GROUP  BY AMT.LANE_PORT" ).append("\n"); 
		query.append("         ,ACCT_CD" ).append("\n"); 
		query.append("ORDER  BY AMT.LANE_PORT" ).append("\n"); 
		query.append("         ,ACCT_CD" ).append("\n"); 

	}
}