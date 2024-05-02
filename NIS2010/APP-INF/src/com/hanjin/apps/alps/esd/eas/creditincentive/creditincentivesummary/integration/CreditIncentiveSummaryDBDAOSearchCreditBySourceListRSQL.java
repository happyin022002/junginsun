/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveSummaryDBDAOSearchCreditBySourceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.05.11 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CreditIncentiveSummaryDBDAOSearchCreditBySourceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Credit & Incentive by Source system
	  * </pre>
	  */
	public CreditIncentiveSummaryDBDAOSearchCreditBySourceListRSQL(){
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
		query.append("FileName : CreditIncentiveSummaryDBDAOSearchCreditBySourceListRSQL").append("\n"); 
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
		query.append("SELECT X.CR_SRC" ).append("\n"); 
		query.append("       ,X.RHQ_CD" ).append("\n"); 
		query.append("       ,X.INV_OFC_CD OFC_CD" ).append("\n"); 
		query.append("       ,NVL(SUM(X.TTL_INCNT_AMT),0) ESTM_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(X.TTL_RCV_AMT),0)   RCV_AMT" ).append("\n"); 
		query.append("       ,NVL(SUM(X.TTL_RMN_AMT),0)   BAL_AMT" ).append("\n"); 
		query.append(" FROM  ( " ).append("\n"); 
		query.append("#if (${cr_src_cd} =='')" ).append("\n"); 
		query.append("		  SELECT A.RHQ_CD" ).append("\n"); 
		query.append("                ,A.INV_OFC_CD" ).append("\n"); 
		query.append("                ,'Transportation' CR_SRC" ).append("\n"); 
		query.append("                ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("                ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("                ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("          FROM EAS_TRSP_INCNT A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bse_yr} !='')" ).append("\n"); 
		query.append("           AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT A.RHQ_CD" ).append("\n"); 
		query.append("              ,A.INV_OFC_CD" ).append("\n"); 
		query.append("              ,'Terminal' CR_SRC" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("          FROM EAS_TML_INCNT A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bse_yr} !='')" ).append("\n"); 
		query.append("           AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT RHQ_CD" ).append("\n"); 
		query.append("              ,OFC_CD" ).append("\n"); 
		query.append("              ,'Vessel Operation' CR_SRC" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("          FROM EAS_VSL_YRY_CR A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bse_yr} !='')" ).append("\n"); 
		query.append("           AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_src_cd} =='TRS')" ).append("\n"); 
		query.append("		  SELECT A.RHQ_CD" ).append("\n"); 
		query.append("                ,A.INV_OFC_CD" ).append("\n"); 
		query.append("                ,'Transportation' CR_SRC" ).append("\n"); 
		query.append("                ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("                ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("                ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("          FROM EAS_TRSP_INCNT A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bse_yr} !='')" ).append("\n"); 
		query.append("           AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_src_cd} =='TES')" ).append("\n"); 
		query.append("        SELECT A.RHQ_CD" ).append("\n"); 
		query.append("              ,A.INV_OFC_CD" ).append("\n"); 
		query.append("              ,'Terminal' CR_SRC" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("          FROM EAS_TML_INCNT A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bse_yr} !='')" ).append("\n"); 
		query.append("           AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_src_cd} =='VSL')" ).append("\n"); 
		query.append("        SELECT RHQ_CD" ).append("\n"); 
		query.append("              ,OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("              ,'Vessel Operation' CR_SRC" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_INCNT_AMT,0)) TTL_INCNT_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RCV_AMT,0)) TTL_RCV_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.TTL_RMN_AMT,0)) TTL_RMN_AMT" ).append("\n"); 
		query.append("          FROM EAS_VSL_YRY_CR A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		#if (${rhq_ofc_cd} !='')" ).append("\n"); 
		query.append("           AND A.RHQ_CD = @[rhq_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bse_yr} !='')" ).append("\n"); 
		query.append("           AND A.BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append(" GROUP BY X.CR_SRC" ).append("\n"); 
		query.append("         ,X.RHQ_CD" ).append("\n"); 
		query.append("         ,X.INV_OFC_CD" ).append("\n"); 
		query.append("ORDER BY  X.CR_SRC" ).append("\n"); 
		query.append("         ,X.RHQ_CD" ).append("\n"); 
		query.append("         ,X.INV_OFC_CD" ).append("\n"); 

	}
}