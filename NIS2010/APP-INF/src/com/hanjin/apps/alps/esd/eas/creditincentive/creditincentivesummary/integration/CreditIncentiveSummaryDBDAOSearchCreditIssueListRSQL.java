/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveSummaryDBDAOSearchCreditIssueListRSQL.java
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

public class CreditIncentiveSummaryDBDAOSearchCreditIssueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search M&R, Mileage Incentive
	  * </pre>
	  */
	public CreditIncentiveSummaryDBDAOSearchCreditIssueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.integration").append("\n"); 
		query.append("FileName : CreditIncentiveSummaryDBDAOSearchCreditIssueListRSQL").append("\n"); 
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
		query.append("SELECT CR_SRC" ).append("\n"); 
		query.append("      ,TEAM_NM TEAM_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,VNDR_NM" ).append("\n"); 
		query.append("      ,NVL(ISS_AMT,0) ISS_AMT" ).append("\n"); 
		query.append("      ,NVL(USD_AMT,0) USED_AMT" ).append("\n"); 
		query.append("      ,NVL(BAL_AMT,0) BAL_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("#if (${cr_src_cd} =='')" ).append("\n"); 
		query.append("		SELECT 'Mileage' CR_SRC" ).append("\n"); 
		query.append("              ,A.TEAM_NM" ).append("\n"); 
		query.append("              ,A.BSE_YR" ).append("\n"); 
		query.append("              ,'WR' VNDR_SEQ" ).append("\n"); 
		query.append("              ,A.BANK_NM VNDR_NM" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('KRW',NVL(SUM(A.MLG_PNT_AMT),0)) ISS_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('KRW',NVL(SUM(A.CSH_BAK_AMT),0)) USD_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('KRW',NVL(SUM(A.MLG_PNT_AMT),0) - NVL(SUM(A.CSH_BAK_AMT),0)) BAL_AMT" ).append("\n"); 
		query.append("          FROM EAS_BNF_MLG A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        #if (${iss_fm_dt} !='' && ${iss_fm_dt} !='')" ).append("\n"); 
		query.append("           AND A.MLG_ISS_DT BETWEEN TO_DATE(@[iss_fm_dt],'YYYYMMDD') AND TO_DATE(@[iss_to_dt],'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("         GROUP BY A.TEAM_NM" ).append("\n"); 
		query.append("                 ,A.BSE_YR  " ).append("\n"); 
		query.append("                 ,A.BANK_NM " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Refrigerator' CR_SRC" ).append("\n"); 
		query.append("              ,X.TEAM_CD TEAM_NM" ).append("\n"); 
		query.append("              ,X.BSE_YR" ).append("\n"); 
		query.append("              ,X.MKR_CD VNDR_SEQ" ).append("\n"); 
		query.append("              ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL A WHERE A.INTG_CD_ID ='CD03516' AND A.INTG_CD_VAL_CTNT = X.MKR_CD)  VNDR_NM" ).append("\n"); 
		query.append("              ,NVL(SUM(X.CR_ISS_TTL_AMT),0) ISS_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(X.CR_USD_AMT),0) USD_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(X.CR_ISS_TTL_AMT),0) - NVL(SUM(X.CR_USD_AMT),0) BAL_AMT" ).append("\n"); 
		query.append("          FROM ( " ).append("\n"); 
		query.append("                SELECT A.CR_ISS_NO" ).append("\n"); 
		query.append("                      ,A.TEAM_CD" ).append("\n"); 
		query.append("				      ,TO_CHAR(A.CR_ISS_DT,'YYYY') BSE_YR" ).append("\n"); 
		query.append("                      ,A.MKR_CD " ).append("\n"); 
		query.append("                      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.CR_ISS_TTL_AMT,0)) CR_ISS_TTL_AMT" ).append("\n"); 
		query.append("                      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(SUM(B.CR_USD_AMT),0)) CR_USD_AMT" ).append("\n"); 
		query.append("                 FROM EAS_MNR_CR_ISS A" ).append("\n"); 
		query.append("                     ,EAS_MNR_CR_USD B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.CR_ISS_NO = B.CR_ISS_NO(+)" ).append("\n"); 
		query.append("                  AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND 'N' = B.DELT_FLG(+)" ).append("\n"); 
		query.append("        #if (${iss_fm_dt} !='' && ${iss_fm_dt} !='')" ).append("\n"); 
		query.append("           		  AND A.CR_ISS_DT BETWEEN TO_DATE(@[iss_fm_dt],'YYYYMMDD') AND TO_DATE(@[iss_to_dt],'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                GROUP BY A.CR_ISS_NO" ).append("\n"); 
		query.append("                        ,A.TEAM_CD" ).append("\n"); 
		query.append("					    ,TO_CHAR(A.CR_ISS_DT,'YYYY')" ).append("\n"); 
		query.append("                        ,A.MKR_CD" ).append("\n"); 
		query.append("                        ,A.CURR_CD" ).append("\n"); 
		query.append("                        ,A.CR_ISS_TTL_AMT" ).append("\n"); 
		query.append("              ) X" ).append("\n"); 
		query.append("           GROUP BY X.TEAM_CD" ).append("\n"); 
		query.append("				   ,X.BSE_YR" ).append("\n"); 
		query.append("                   ,X.MKR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_src_cd} =='MGR')" ).append("\n"); 
		query.append("		SELECT 'Mileage' CR_SRC" ).append("\n"); 
		query.append("              ,A.TEAM_NM" ).append("\n"); 
		query.append("			  ,A.BSE_YR" ).append("\n"); 
		query.append("              ,'WR' VNDR_SEQ" ).append("\n"); 
		query.append("              ,A.BANK_NM VNDR_NM" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('KRW',NVL(SUM(A.MLG_PNT_AMT),0)) ISS_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('KRW',NVL(SUM(A.CSH_BAK_AMT),0)) USD_AMT" ).append("\n"); 
		query.append("              ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC('KRW',NVL(SUM(A.MLG_PNT_AMT),0) - NVL(SUM(A.CSH_BAK_AMT),0)) BAL_AMT" ).append("\n"); 
		query.append("          FROM EAS_BNF_MLG A" ).append("\n"); 
		query.append("         WHERE A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        #if (${iss_fm_dt} !='' && ${iss_fm_dt} !='')" ).append("\n"); 
		query.append("           AND A.MLG_ISS_DT BETWEEN TO_DATE(@[iss_fm_dt],'YYYYMMDD') AND TO_DATE(@[iss_to_dt],'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("         GROUP BY A.TEAM_NM" ).append("\n"); 
		query.append("				 ,A.BSE_YR" ).append("\n"); 
		query.append("                 ,A.BANK_NM " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cr_src_cd} =='MNR')" ).append("\n"); 
		query.append("        SELECT 'Refrigerator' CR_SRC" ).append("\n"); 
		query.append("              ,X.TEAM_CD TEAM_NM" ).append("\n"); 
		query.append("              ,X.BSE_YR" ).append("\n"); 
		query.append("              ,X.MKR_CD VNDR_SEQ" ).append("\n"); 
		query.append("              ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL A WHERE A.INTG_CD_ID ='CD03516' AND A.INTG_CD_VAL_CTNT = X.MKR_CD)  VNDR_NM" ).append("\n"); 
		query.append("              ,NVL(SUM(X.CR_ISS_TTL_AMT),0) ISS_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(X.CR_USD_AMT),0) USD_AMT" ).append("\n"); 
		query.append("              ,NVL(SUM(X.CR_ISS_TTL_AMT),0) - NVL(SUM(X.CR_USD_AMT),0) BAL_AMT" ).append("\n"); 
		query.append("          FROM ( " ).append("\n"); 
		query.append("                SELECT A.CR_ISS_NO" ).append("\n"); 
		query.append("                      ,A.TEAM_CD" ).append("\n"); 
		query.append("					  ,TO_CHAR(A.CR_ISS_DT,'YYYY') BSE_YR" ).append("\n"); 
		query.append("                      ,A.MKR_CD " ).append("\n"); 
		query.append("                      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(A.CR_ISS_TTL_AMT,0)) CR_ISS_TTL_AMT" ).append("\n"); 
		query.append("                      ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD,NVL(SUM(B.CR_USD_AMT),0)) CR_USD_AMT" ).append("\n"); 
		query.append("                 FROM EAS_MNR_CR_ISS A" ).append("\n"); 
		query.append("                     ,EAS_MNR_CR_USD B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.CR_ISS_NO = B.CR_ISS_NO(+)" ).append("\n"); 
		query.append("                  AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                  AND 'N' = B.DELT_FLG(+)" ).append("\n"); 
		query.append("        #if (${iss_fm_dt} !='' && ${iss_fm_dt} !='')" ).append("\n"); 
		query.append("           		  AND A.CR_ISS_DT BETWEEN TO_DATE(@[iss_fm_dt],'YYYYMMDD') AND TO_DATE(@[iss_to_dt],'YYYYMMDD')+0.9999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                GROUP BY A.CR_ISS_NO " ).append("\n"); 
		query.append("                        ,A.TEAM_CD" ).append("\n"); 
		query.append("			            ,TO_CHAR(A.CR_ISS_DT,'YYYY')" ).append("\n"); 
		query.append("                        ,A.MKR_CD" ).append("\n"); 
		query.append("                        ,A.CURR_CD" ).append("\n"); 
		query.append("                        ,A.CR_ISS_TTL_AMT" ).append("\n"); 
		query.append("              ) X" ).append("\n"); 
		query.append("           GROUP BY X.TEAM_CD" ).append("\n"); 
		query.append("				   ,X.BSE_YR" ).append("\n"); 
		query.append("                   ,X.MKR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ORDER BY CR_SRC" ).append("\n"); 
		query.append("        ,TEAM_NM" ).append("\n"); 
		query.append("		,BSE_YR" ).append("\n"); 
		query.append("        ,VNDR_NM" ).append("\n"); 

	}
}