/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBudEstDtlByMonCost
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cls",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchBudEstDtlByMonCostRSQL").append("\n"); 
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
		query.append("SELECT MM YYYY_MM" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , LOC" ).append("\n"); 
		query.append("     , LANE" ).append("\n"); 
		query.append("     --, DECODE([gubun], 0, LOC, 1, LANE) LANE" ).append("\n"); 
		query.append("     , ACCT ACCOUNT_CODE" ).append("\n"); 
		query.append("     , BUG_AMT BUDGET" ).append("\n"); 
		query.append("     , EST_AMT ESTIMATE" ).append("\n"); 
		query.append("     , ACT_AMT ACTUAL" ).append("\n"); 
		query.append("  FROM (SELECT MM" ).append("\n"); 
		query.append("             , VVD" ).append("\n"); 
		query.append("             , LANE" ).append("\n"); 
		query.append("             , LOC" ).append("\n"); 
		query.append("             , ACCT" ).append("\n"); 
		query.append("             , SUM(DECODE(TP,'1',AMT,0)) BUG_AMT" ).append("\n"); 
		query.append("             , SUM(DECODE(TP,'2',AMT,0)) EST_AMT" ).append("\n"); 
		query.append("             , SUM(DECODE(TP,'3',AMT,0)) ACT_AMT" ).append("\n"); 
		query.append("          FROM (SELECT '1' TP" ).append("\n"); 
		query.append("                     , T11.REV_YRMON MM" ).append("\n"); 
		query.append("                     , T10.VSL_CD||T10.SKD_VOY_NO||T10.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                     , T10.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                     , CST.ACCT_CD ACCT" ).append("\n"); 
		query.append("                     , SUBSTR(T11.YD_CD,1,5) LOC" ).append("\n"); 
		query.append("                     , SUM(INV_USD_AMT) AMT" ).append("\n"); 
		query.append("                  FROM PSO_TGT_VVD T10" ).append("\n"); 
		query.append("                     , PSO_TGT_YD_EXPN T11" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("                     , TES_LGS_COST CST" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND T10.VSL_CD = T11.VSL_CD" ).append("\n"); 
		query.append("                   AND T10.SKD_VOY_NO = T11.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND T10.SKD_DIR_CD = T11.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND T10.PSO_BZTP_CD = '1'" ).append("\n"); 
		query.append("                   AND T10.PSO_BZTP_CD = T11.PSO_BZTP_CD" ).append("\n"); 
		query.append("                   AND T11.REV_YRMON BETWEEN REPLACE(@[cre_dt_fr],'-','') AND REPLACE(@[cre_dt_to],'-','')" ).append("\n"); 
		query.append("                   AND T10.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                   AND T11.LGS_COST_CD = CST.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND CST.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("                   #if(${vsl_cls}!='')" ).append("\n"); 
		query.append("                    AND VSL.CNTR_VSL_CLSS_CAPA  = @[vsl_cls]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${lane_cd}!='')" ).append("\n"); 
		query.append("                    AND T10.VSL_SLAN_CD = @[lane_cd]  " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${loc_cd}!='' && ${term_cd}=='')" ).append("\n"); 
		query.append("                    AND SUBSTR(T11.YD_CD,1,5) = @[loc_cd] " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("				   #if(${loc_cd}!='' && ${term_cd}!='')	" ).append("\n"); 
		query.append("						AND T11.YD_CD IN (" ).append("\n"); 
		query.append("				             #foreach($key IN ${term_cd_list})" ).append("\n"); 
		query.append("             					#if($velocityCount < $term_cd_list.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("				             #end" ).append("\n"); 
		query.append("         				)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                 GROUP BY T11.REV_YRMON , T10.VSL_CD, T10.SKD_VOY_NO, T10.SKD_DIR_CD, T10.VSL_SLAN_CD,CST.ACCT_CD,SUBSTR(T11.YD_CD,1,5)" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT /*+ INDEX(T10 XPKAR_MST_REV_VVD) */" ).append("\n"); 
		query.append("                  '3' TP" ).append("\n"); 
		query.append("                     , SOD.AR_YRMON AS MM" ).append("\n"); 
		query.append("                     , SOD.VSL_CD||SOD.SKD_VOY_NO||SOD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                     , T10.SLAN_CD LANE" ).append("\n"); 
		query.append("                     , CST.ACCT_CD ACCT" ).append("\n"); 
		query.append("                     , SUBSTR(SOH.YD_CD, 1, 5) AS LOC" ).append("\n"); 
		query.append("                     , SUM(SOD.USD_AMT) AS AMT" ).append("\n"); 
		query.append("                  FROM PSO_CHARGE SOH" ).append("\n"); 
		query.append("                     ,PSO_CHG_DTL SOD" ).append("\n"); 
		query.append("                     ,AR_MST_REV_VVD T10" ).append("\n"); 
		query.append("                     ,TES_LGS_COST CST" ).append("\n"); 
		query.append("                     ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("                 WHERE SOD.AR_YRMON BETWEEN REPLACE(@[cre_dt_fr],'-','') AND REPLACE(@[cre_dt_to],'-','')" ).append("\n"); 
		query.append("                   AND SOH.ISS_CTY_CD = SOD.ISS_CTY_CD" ).append("\n"); 
		query.append("                   AND SOH.SO_SEQ = SOD.SO_SEQ" ).append("\n"); 
		query.append("                   AND SOD.LGS_COST_CD = CST.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND SOD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND SOD.VSL_CD = T10.VSL_CD" ).append("\n"); 
		query.append("                   AND SOD.SKD_VOY_NO = LPAD(T10.SKD_VOY_NO,4,'0')" ).append("\n"); 
		query.append("                   AND SOD.SKD_DIR_CD = T10.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND SOD.REV_DIR_CD = T10.RLANE_DIR_CD" ).append("\n"); 
		query.append("                   AND SOD.RLANE_CD = T10.RLANE_CD" ).append("\n"); 
		query.append("                   AND T10.DELT_FLG = 'N' /*2015.09.11 Add*/" ).append("\n"); 
		query.append("                   AND CST.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("                   #if(${vsl_cls}!='')" ).append("\n"); 
		query.append("                    AND VSL.CNTR_VSL_CLSS_CAPA  = @[vsl_cls]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${lane_cd}!='')" ).append("\n"); 
		query.append("                    AND T10.SLAN_CD = @[lane_cd]  " ).append("\n"); 
		query.append("                   #end " ).append("\n"); 
		query.append("                   #if(${loc_cd}!='' && ${term_cd}=='')" ).append("\n"); 
		query.append("                   AND SUBSTR(SOH.YD_CD,1,5) = @[loc_cd] " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("				   #if(${loc_cd}!='' && ${term_cd}!='')	" ).append("\n"); 
		query.append("						AND SOH.YD_CD IN (" ).append("\n"); 
		query.append("				             #foreach($key IN ${term_cd_list})" ).append("\n"); 
		query.append("             					#if($velocityCount < $term_cd_list.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("				             #end" ).append("\n"); 
		query.append("         				)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                 GROUP BY SOD.AR_YRMON , SOD.VSL_CD, SOD.SKD_VOY_NO, SOD.SKD_DIR_CD, T10.SLAN_CD,CST.ACCT_CD,SUBSTR(SOH.YD_CD,1,5)" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("				SELECT '2' TP" ).append("\n"); 
		query.append("                     , T22.REV_YRMON AS MM" ).append("\n"); 
		query.append("                     , T22.VSL_CD||T22.SKD_VOY_NO||T22.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("                     , T21.VSL_SLAN_CD LANE" ).append("\n"); 
		query.append("                     , CST.ACCT_CD AS ACCT" ).append("\n"); 
		query.append("                     , SUBSTR(T22.YD_CD, 1, 5) AS LOC" ).append("\n"); 
		query.append("                     , SUM(NVL(INV_USD_AMT, 0)) AS AMT" ).append("\n"); 
		query.append("                  FROM PSO_TGT_VVD T21" ).append("\n"); 
		query.append("                      ,PSO_TGT_YD_EXPN T22" ).append("\n"); 
		query.append("                      ,TES_LGS_COST CST" ).append("\n"); 
		query.append("                      ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("                 WHERE T21.VSL_CD = T22.VSL_CD" ).append("\n"); 
		query.append("                   AND T21.SKD_VOY_NO = T22.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND T21.SKD_DIR_CD = T22.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND T22.LGS_COST_CD = CST.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND T21.PSO_BZTP_CD = 2" ).append("\n"); 
		query.append("                   AND T21.PSO_BZTP_CD = T22.PSO_BZTP_CD" ).append("\n"); 
		query.append("                   AND T21.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                   AND T22.REV_YRMON BETWEEN REPLACE(@[cre_dt_fr],'-','') AND REPLACE(@[cre_dt_to],'-','')" ).append("\n"); 
		query.append("                   AND CST.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("                   #if(${vsl_cls}!='')" ).append("\n"); 
		query.append("                    AND VSL.CNTR_VSL_CLSS_CAPA  = @[vsl_cls]" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   #if(${lane_cd}!='')" ).append("\n"); 
		query.append("                    AND T21.VSL_SLAN_CD = @[lane_cd]  " ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                   #if(${loc_cd}!='' && ${term_cd}=='')" ).append("\n"); 
		query.append("                   AND SUBSTR(T22.YD_CD,1,5) = @[loc_cd] " ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   #if(${loc_cd}!='' && ${term_cd}!='')	" ).append("\n"); 
		query.append("						AND T22.YD_CD IN (" ).append("\n"); 
		query.append("				             #foreach($key IN ${term_cd_list})" ).append("\n"); 
		query.append("             					#if($velocityCount < $term_cd_list.size()) '$key', #else '$key' #end" ).append("\n"); 
		query.append("				             #end" ).append("\n"); 
		query.append("         				)" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                 GROUP BY T22.REV_YRMON, T22.VSL_CD, T22.SKD_VOY_NO, T22.SKD_DIR_CD, T21.VSL_SLAN_CD,CST.ACCT_CD , SUBSTR(T22.YD_CD, 1, 5)" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         GROUP BY MM, VVD, LANE, LOC, ACCT )" ).append("\n"); 
		query.append(" ORDER BY MM, LANE, VVD, ACCT, LOC" ).append("\n"); 

	}
}