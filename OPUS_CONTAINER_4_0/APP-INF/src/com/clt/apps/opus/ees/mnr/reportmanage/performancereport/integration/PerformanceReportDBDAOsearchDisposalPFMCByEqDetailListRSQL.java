/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장비별 매각실적 상세목록을 조회합니다.
	  * 2011.11.30 남궁진호 [CHM-201007327-01]   Disposal Performance를 장비별 Detail 내역 조회
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_disp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchDisposalPFMCByEqDetailListRSQL").append("\n"); 
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
		query.append("SELECT  A.RHQ_CD, A.RQST_OFC_CD, A.APRO_OFC_CD," ).append("\n"); 
		query.append("        A.EQ_KND_CD, A.EQ_NO, A.EQ_TPSZ_CD, " ).append("\n"); 
		query.append("        A.LESSOR_NM,A.LSTM_CD," ).append("\n"); 
		query.append("        A.RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("        A.RSTR_USG_LBL_VAL, " ).append("\n"); 
		query.append("	    A.ASET_KND," ).append("\n"); 
		query.append("	    A.DISP_STS_CD, A.INV_NO, A.UPD_USR_ID, TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT," ).append("\n"); 
		query.append("	    A.MANU_DT," ).append("\n"); 
		query.append("        A.DISP_NO," ).append("\n"); 
		query.append("        A.DISP_SOLD_DT, A.CUST_CD, A.CUST_NM," ).append("\n"); 
		query.append("        B.RCC_CD, B.LCC_CD, B.SCC_CD, B.LOC_CD, A.DISP_YD_CD," ).append("\n"); 
		query.append("       (SELECT  MNR_CD_DP_DESC   FROM  MNR_GEN_CD   WHERE  PRNT_CD_ID = 'CD00038'" ).append("\n"); 
		query.append("        AND     MNR_CD_ID = A.DISP_RSN_CD) AS DISP_RSN_CD, " ).append("\n"); 
		query.append("		A.CURR_CD, A.PART_AMT, A.CAL_PART_AMT," ).append("\n"); 
		query.append("        A.DISP_UT_PRC, A.DISP_TRF_UT_PRC, A.DISP_VRFY_TP_CD," ).append("\n"); 
		query.append("       (SELECT  MNR_CD_DP_DESC   FROM  MNR_GEN_CD   WHERE  PRNT_CD_ID = 'CD00080'" ).append("\n"); 
		query.append("        AND     MNR_CD_ID = A.DISP_VRFY_TP_CD) AS DISP_VRFY_TP_NM," ).append("\n"); 
		query.append("        CASE WHEN A.DISP_RSN_CD != 'C' THEN A.RPR_COST_AMT END RPR_COST_AMT" ).append("\n"); 
		query.append("FROM   (SELECT  A.DISP_NO, B.DISP_SOLD_DT, A.EQ_KND_CD, A.RQST_OFC_CD, A.CURR_CD," ).append("\n"); 
		query.append("                MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.RQST_OFC_CD) AS RHQ_CD," ).append("\n"); 
		query.append("                A.APRO_OFC_CD, B.DISP_DTL_SEQ, B.EQ_TPSZ_CD, D.ASET_KND,B.DISP_QTY, B.PART_AMT, B.DISP_YD_CD," ).append("\n"); 
		query.append("                MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(B.DISP_SOLD_DT, 'YYYYMM')," ).append("\n"); 
		query.append("                    A.CURR_CD, 'USD', B.PART_AMT) AS CAL_PART_AMT, D.MANU_DT," ).append("\n"); 
		query.append("                D.LESSOR_NM,D.LSTM_CD," ).append("\n"); 
		query.append("				#if(${p_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("                MST_COMMON_PKG.MST_RU_TP_GET_FNC(E.CNTR_NO) AS RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("                MST_COMMON_PKG.MST_RU_VAL_GET_FNC(E.CNTR_NO) AS RSTR_USG_LBL_VAL," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				'' AS RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("                '' AS RSTR_USG_LBL_VAL," ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("	            A.DISP_STS_CD, B.INV_NO, B.UPD_USR_ID, B.UPD_DT," ).append("\n"); 
		query.append("                CASE WHEN B.MNR_PRNR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                     THEN MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(B.MNR_PRNR_SEQ, B.MNR_PRNR_CNT_CD)" ).append("\n"); 
		query.append("                     ELSE 'ZZ999999' END CUST_CD," ).append("\n"); 
		query.append("                CASE WHEN B.MNR_PRNR_SEQ IS NOT NULL THEN C.MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("                     ELSE 'Anonymous Buyer' END CUST_NM," ).append("\n"); 
		query.append("                B.EQ_NO, B.DISP_RSN_CD, B.DISP_UT_PRC, B.DISP_TRF_UT_PRC, D.RPR_COST_AMT," ).append("\n"); 
		query.append("                CASE WHEN B.DISP_VRFY_TP_CD IS NOT NULL THEN B.DISP_VRFY_TP_CD" ).append("\n"); 
		query.append("                     WHEN B.DISP_RSN_CD != 'C' THEN 'DA'" ).append("\n"); 
		query.append("                     WHEN B.DISP_TRF_UT_PRC IS NULL THEN 'NT'" ).append("\n"); 
		query.append("                     WHEN B.DISP_UT_PRC >= B.DISP_TRF_UT_PRC THEN 'SS'" ).append("\n"); 
		query.append("                     WHEN B.DISP_UT_PRC < B.DISP_TRF_UT_PRC  THEN 'UP'" ).append("\n"); 
		query.append("                END DISP_VRFY_TP_CD" ).append("\n"); 
		query.append("        FROM    MNR_DISP_HDR A," ).append("\n"); 
		query.append("                MNR_DISP_DTL B," ).append("\n"); 
		query.append("                MNR_PARTNER C," ).append("\n"); 
		query.append("                MNR_EQ_STS_V D" ).append("\n"); 
		query.append("				#if(${p_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("				,MST_CONTAINER E" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("        WHERE   A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("        AND     A.EQ_KND_CD = D.EQ_TYPE" ).append("\n"); 
		query.append("        AND     B.EQ_NO = D.EQ_NO" ).append("\n"); 
		query.append("		#if(${p_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("		AND     B.EQ_NO = E.CNTR_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        AND     B.EQ_TPSZ_CD = D.EQ_TPSZ_CD" ).append("\n"); 
		query.append("        AND     B.MNR_PRNR_CNT_CD = C.MNR_PRNR_CNT_CD(+)" ).append("\n"); 
		query.append("        AND     B.MNR_PRNR_SEQ    = C.MNR_PRNR_SEQ(+)" ).append("\n"); 
		query.append("        AND     B.DISP_SOLD_DT IS NOT NULL" ).append("\n"); 
		query.append("		#if(${p_eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("			#if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("				AND	" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM1 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM2 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM3 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM4 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM5 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM6 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM7 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM8 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM9 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM10 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				E.RSTR_USG_TP_LBL_NM11 IN (" ).append("\n"); 
		query.append("						#foreach ($key IN ${labelvalue_list})" ).append("\n"); 
		query.append("		                	#if($velocityCount < $labelvalue_list.size())" ).append("\n"); 
		query.append("		                    	'$key'," ).append("\n"); 
		query.append("		                    #else" ).append("\n"); 
		query.append("		                        '$key'" ).append("\n"); 
		query.append("		                    #end" ).append("\n"); 
		query.append("		                #end			  " ).append("\n"); 
		query.append("		           )" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("       (SELECT  A.LOC_CD, A.RGN_CD, A.SCC_CD, A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("                C.LCC_CD, C.ECC_CD, C.RCC_CD" ).append("\n"); 
		query.append("        FROM    MDM_LOCATION A," ).append("\n"); 
		query.append("                MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("        WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("WHERE   SUBSTR(A.DISP_YD_CD,1,5) = B.LOC_CD" ).append("\n"); 
		query.append("AND     A.DISP_SOLD_DT BETWEEN TO_DATE(@[p_str_evnt_dt],'YYYY-MM-DD') AND TO_DATE(@[p_end_evnt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '' )" ).append("\n"); 
		query.append("AND     A.EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_disp_rsn_cd} != '' )" ).append("\n"); 
		query.append("AND     A.DISP_RSN_CD = @[p_disp_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aset_knd} != '' )" ).append("\n"); 
		query.append("AND     A.ASET_KND = @[aset_knd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_cust_cd} != '')" ).append("\n"); 
		query.append("AND     A.CUST_CD = @[p_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '')" ).append("\n"); 
		query.append("	#if (${p_loc_tp} == 'RCC')" ).append("\n"); 
		query.append("AND    	B.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("	#elseif (${p_loc_tp} == 'LCC')" ).append("\n"); 
		query.append("AND    	B.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("AND    	B.SCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.DISP_NO, A.DISP_DTL_SEQ, A.DISP_SOLD_DT, A.EQ_TPSZ_CD, A.EQ_NO" ).append("\n"); 

	}
}