/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveSummaryDBDAOSearchCreditByRhqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.10 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveSummaryDBDAOSearchCreditByRhqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Credit & Incentive Summary by RHQ
	  * </pre>
	  */
	public CreditIncentiveSummaryDBDAOSearchCreditByRhqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.integration").append("\n"); 
		query.append("FileName : CreditIncentiveSummaryDBDAOSearchCreditByRhqListRSQL").append("\n"); 
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
		query.append("WITH SRC AS (" ).append("\n"); 
		query.append("				SELECT X.RHQ_CD" ).append("\n"); 
		query.append("					   ,X.INV_OFC_CD OFC_CD" ).append("\n"); 
		query.append("					   ,X.CR_SRC" ).append("\n"); 
		query.append("					   ,NVL(SUM(X.TTL_INCNT_AMT),0) ESTM_AMT" ).append("\n"); 
		query.append("					   ,NVL(SUM(X.TTL_RCV_AMT),0)   RCV_AMT" ).append("\n"); 
		query.append("					   ,NVL(SUM(X.TTL_RMN_AMT),0)   BAL_AMT" ).append("\n"); 
		query.append("				 FROM  (" ).append("\n"); 
		query.append("				#if (${cr_src_cd} =='')" ).append("\n"); 
		query.append("						SELECT A.RHQ_CD" ).append("\n"); 
		query.append("							  ,A.INV_OFC_CD" ).append("\n"); 
		query.append("							  ,'Transportation' CR_SRC" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("						  FROM EAS_TRSP_INCNT A" ).append("\n"); 
		query.append("						 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("						   AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bse_yr} !='')" ).append("\n"); 
		query.append("						   AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						 UNION ALL" ).append("\n"); 
		query.append("						SELECT A.RHQ_CD" ).append("\n"); 
		query.append("							  ,A.INV_OFC_CD" ).append("\n"); 
		query.append("							  ,'Terminal' CR_SRC" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("						  FROM EAS_TML_INCNT A" ).append("\n"); 
		query.append("						 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("						   AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bse_yr} !='')" ).append("\n"); 
		query.append("						   AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						 UNION ALL" ).append("\n"); 
		query.append("						SELECT RHQ_CD" ).append("\n"); 
		query.append("							  ,OFC_CD" ).append("\n"); 
		query.append("							  ,'Vessel Operation' CR_SRC" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("						  FROM EAS_VSL_YRY_CR A" ).append("\n"); 
		query.append("						 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("						   AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bse_yr} !='')" ).append("\n"); 
		query.append("						   AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${cr_src_cd} =='TES')" ).append("\n"); 
		query.append("						SELECT A.RHQ_CD" ).append("\n"); 
		query.append("							  ,A.INV_OFC_CD" ).append("\n"); 
		query.append("							  ,'Terminal' CR_SRC" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("						  FROM EAS_TML_INCNT A" ).append("\n"); 
		query.append("						 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("						   AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bse_yr} !='')" ).append("\n"); 
		query.append("						   AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${cr_src_cd} == 'TRS')" ).append("\n"); 
		query.append("						SELECT A.RHQ_CD" ).append("\n"); 
		query.append("							  ,A.INV_OFC_CD" ).append("\n"); 
		query.append("							  ,'Transportation' CR_SRC" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("						  FROM EAS_TRSP_INCNT A" ).append("\n"); 
		query.append("						 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("						   AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bse_yr} !='')" ).append("\n"); 
		query.append("						   AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${cr_src_cd} =='VSL')" ).append("\n"); 
		query.append("						SELECT RHQ_CD" ).append("\n"); 
		query.append("							  ,OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("							  ,'Vessel Operation' CR_SRC" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("							  ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("						  FROM EAS_VSL_YRY_CR A" ).append("\n"); 
		query.append("						 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("						#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("						   AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if (${bse_yr} !='')" ).append("\n"); 
		query.append("						   AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("						 ) X" ).append("\n"); 
		query.append("				 GROUP BY X.RHQ_CD" ).append("\n"); 
		query.append("						 ,X.INV_OFC_CD" ).append("\n"); 
		query.append("						 ,X.CR_SRC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT '1' ORDER_SEQ" ).append("\n"); 
		query.append("        ,A.RHQ_CD" ).append("\n"); 
		query.append("        ,A.OFC_CD" ).append("\n"); 
		query.append("        ,A.CR_SRC" ).append("\n"); 
		query.append("        ,A.ESTM_AMT" ).append("\n"); 
		query.append("        ,A.RCV_AMT" ).append("\n"); 
		query.append("        ,A.BAL_AMT" ).append("\n"); 
		query.append("    FROM SRC A" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("  SELECT '2' ORDER_SEQ" ).append("\n"); 
		query.append("        ,A.RHQ_CD" ).append("\n"); 
		query.append("        ,A.CR_SRC OFC_CD" ).append("\n"); 
		query.append("        ,'' CR_SRC" ).append("\n"); 
		query.append("        ,SUM(A.ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("        ,SUM(A.RCV_AMT) RCV_AMT" ).append("\n"); 
		query.append("        ,SUM(A.BAL_AMT) BAL_AMT" ).append("\n"); 
		query.append("    FROM SRC A  " ).append("\n"); 
		query.append("   GROUP BY A.RHQ_CD,A.CR_SRC" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("  SELECT '3' ORDER_SEQ" ).append("\n"); 
		query.append("        ,A.RHQ_CD" ).append("\n"); 
		query.append("        ,'Sub Total' OFC_CD" ).append("\n"); 
		query.append("        ,'' CR_SRC" ).append("\n"); 
		query.append("        ,SUM(A.ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("        ,SUM(A.RCV_AMT) RCV_AMT" ).append("\n"); 
		query.append("        ,SUM(A.BAL_AMT) BAL_AMT" ).append("\n"); 
		query.append("    FROM SRC A  " ).append("\n"); 
		query.append("   GROUP BY A.RHQ_CD" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT '4' ORDER_SEQ" ).append("\n"); 
		query.append("        ,'' RHQ_CD" ).append("\n"); 
		query.append("        ,'' OFC_CD" ).append("\n"); 
		query.append("        ,'' CR_SRC" ).append("\n"); 
		query.append("        ,SUM(A.ESTM_AMT) ESTM_AMT" ).append("\n"); 
		query.append("        ,SUM(A.RCV_AMT) RCV_AMT" ).append("\n"); 
		query.append("        ,SUM(A.BAL_AMT) BAL_AMT" ).append("\n"); 
		query.append("    FROM SRC A" ).append("\n"); 
		query.append("   ORDER BY RHQ_CD" ).append("\n"); 
		query.append("           ,ORDER_SEQ" ).append("\n"); 
		query.append("           ,OFC_CD" ).append("\n"); 
		query.append("           ,CR_SRC" ).append("\n"); 

	}
}