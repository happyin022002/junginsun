/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchRepairPFMCByRepairCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.16
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.06.16 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Justin(Jonghee) HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchRepairPFMCByRepairCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRepairPFMCByRepairCodeListData
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430738, TITLE ALPS MNR-General Performance에서 Local Currency-> USD로 변환하는 로직 수정 요청
	  *                   ADDED USD CONVERSION FUNCTION FOR  LBR_COST_AMT, MTRL_COST_AMT
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchRepairPFMCByRepairCodeListDataRSQL(){
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("division",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("component",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("damage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repair",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("currency",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchRepairPFMCByRepairCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT    MRRH.EQ_KND_CD" ).append("\n"); 
		query.append("		, MRRD.EQ_CMPO_CD" ).append("\n"); 
		query.append("		, (SELECT MCD.EQ_CMPO_NM" ).append("\n"); 
		query.append("       		FROM MNR_EQ_CMPO_CD MCD" ).append("\n"); 
		query.append("      		WHERE MCD.EQ_CMPO_GRP_TP_CD = '3'" ).append("\n"); 
		query.append("        	AND MCD.EQ_CMPO_CD = MRRD.EQ_CMPO_CD" ).append("\n"); 
		query.append("        	AND ROWNUM = 1) AS EQ_CMPO_NM" ).append("\n"); 
		query.append("		, MRRD.EQ_RPR_CD" ).append("\n"); 
		query.append("		, (SELECT MROD.EQ_CEDEX_OTR_CD_NM" ).append("\n"); 
		query.append("       		FROM MNR_CEDEX_OTR_CD MROD" ).append("\n"); 
		query.append("      		WHERE MROD.EQ_CEDEX_OTR_TP_CD = 'RPR'" ).append("\n"); 
		query.append("        	AND MROD.EQ_CEDEX_OTR_CD = MRRD.EQ_RPR_CD" ).append("\n"); 
		query.append("        	AND ROWNUM = 1) AS EQ_RPR_NM" ).append("\n"); 
		query.append("		, MRRD.TRF_DIV_CD" ).append("\n"); 
		query.append("		,MAX((SELECT MCR.MNR_RLT_CD_DESC" ).append("\n"); 
		query.append("              FROM MNR_CD_RLT MCR" ).append("\n"); 
		query.append("             WHERE MCR.EQ_CEDEX_RLT_TP_CD = 'CTV'" ).append("\n"); 
		query.append("               AND MCR.COST_GRP_CD LIKE SUBSTR(MRRD.COST_CD, 0, 3) || '%'" ).append("\n"); 
		query.append("               AND MCR.FM_RLT_CD = (MRRD.EQ_CMPO_CD || MRRD.EQ_RPR_CD)" ).append("\n"); 
		query.append("               AND MCR.TO_RLT_CD = MRRD.TRF_DIV_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1)) AS TRF_DIV_NM" ).append("\n"); 
		query.append("        #if (${qty} == 'N')" ).append("\n"); 
		query.append("		, MRRD.EQ_LOC_CD" ).append("\n"); 
		query.append("		, MRRD.EQ_DMG_CD" ).append("\n"); 
		query.append("		, (SELECT MROD.EQ_CEDEX_OTR_CD_NM" ).append("\n"); 
		query.append("       		FROM MNR_CEDEX_OTR_CD MROD" ).append("\n"); 
		query.append("      		WHERE MROD.EQ_CEDEX_OTR_TP_CD = 'DMG'" ).append("\n"); 
		query.append("        	AND MROD.EQ_CEDEX_OTR_CD = MRRD.EQ_DMG_CD" ).append("\n"); 
		query.append("        	AND ROWNUM = 1) AS EQ_DMG_NM" ).append("\n"); 
		query.append("		, MRRH.COST_OFC_CD" ).append("\n"); 
		query.append("		, MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MRRH.COST_OFC_CD) RHQ" ).append("\n"); 
		query.append("		, MRRH.VNDR_SEQ" ).append("\n"); 
		query.append("		, (SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE MV.VNDR_SEQ = MRRH.VNDR_SEQ AND ROWNUM =1) AS VNDR_SEQ_NM" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		#if (${currency} != 'Y') " ).append("\n"); 
		query.append("        	,MRRH.CURR_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("			,'USD' AS CURR_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        , COUNT(*) AS QTY" ).append("\n"); 
		query.append("        , SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MRRH.CRE_DT, 'YYYYMM'), MRRH.CURR_CD, DECODE(@[currency],'Y','USD',MRRH.CURR_CD),MRRD.LBR_COST_AMT)) AS LBR_COST_AMT" ).append("\n"); 
		query.append("        , SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MRRH.CRE_DT, 'YYYYMM'), MRRH.CURR_CD, DECODE(@[currency],'Y','USD',MRRH.CURR_CD),MRRD.MTRL_COST_AMT)) AS MTRL_COST_AMT" ).append("\n"); 
		query.append("		, SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MRRH.CRE_DT, 'YYYYMM'), MRRH.CURR_CD, DECODE(@[currency],'Y','USD',MRRH.CURR_CD),MRRD.MNR_WRK_AMT)) AS T_AMT" ).append("\n"); 
		query.append("        , ROUND(SUM(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MRRH.CRE_DT, 'YYYYMM'), MRRH.CURR_CD, DECODE(@[currency],'Y','USD',MRRH.CURR_CD), MRRD.MNR_WRK_AMT))/COUNT(*), 2) T_AVG" ).append("\n"); 
		query.append("#if (${report_period_type} == 'EI') " ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR MRRH, MNR_RPR_RQST_DTL MRRD" ).append("\n"); 
		query.append("WHERE MRRH.RQST_EQ_NO = MRRD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_SEQ = MRRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_VER_NO = MRRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_LST_VER_FLG = MRRD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   MRRH.RQST_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'WI') " ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR MRRH, MNR_RPR_RQST_DTL MRRD, MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("WHERE MOH.MNR_ORD_OFC_CTY_CD = MRRH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   MOH.CRE_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND   MOH.MNR_ORD_SEQ = MRRH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   MRRH.RQST_EQ_NO = MRRD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_SEQ = MRRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_VER_NO = MRRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_LST_VER_FLG = MRRD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${report_period_type} == 'II') " ).append("\n"); 
		query.append("FROM  MNR_PAY_INV_WRK MPIW, MNR_ORD_DTL MOD, MNR_RPR_RQST_HDR MRRH, MNR_RPR_RQST_DTL MRRD" ).append("\n"); 
		query.append("WHERE MPIW.ISS_DT BETWEEN  TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("AND   MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("AND   MPIW.PAY_INV_SEQ = MOD.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND   MOD.MNR_ORD_OFC_CTY_CD = MRRH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   MOD.MNR_ORD_SEQ = MRRH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   MRRH.RQST_EQ_NO = MRRD.RQST_EQ_NO" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_SEQ = MRRD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_VER_NO = MRRD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_LST_VER_FLG = MRRD.RPR_RQST_LST_VER_FLG" ).append("\n"); 
		query.append("AND   MRRH.RPR_RQST_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_type} != 'A' && ${eq_type} != 'A,U,Z,G')" ).append("\n"); 
		query.append("AND   MRRH.EQ_KND_CD IN (" ).append("\n"); 
		query.append("		#foreach ($user_eqTypes IN ${eqTypes})" ).append("\n"); 
		query.append("			#if($velocityCount < $eqTypes.size())" ).append("\n"); 
		query.append("				'$user_eqTypes'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_eqTypes'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != 'A') " ).append("\n"); 
		query.append("AND   MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MRRH.COST_OFC_CD)  = @[rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'A') " ).append("\n"); 
		query.append("AND   MRRH.COST_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND   MRRH.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${location_cd} != '') " ).append("\n"); 
		query.append("AND   MRRD.EQ_LOC_CD = @[location_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${component} != 'A') " ).append("\n"); 
		query.append("AND   MRRD.EQ_CMPO_CD = @[component]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${repair} != 'A') " ).append("\n"); 
		query.append("AND   MRRD.EQ_RPR_CD  = @[repair]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${division} != '') " ).append("\n"); 
		query.append("AND   MRRD.TRF_DIV_CD  = @[division]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${damage} != 'A') " ).append("\n"); 
		query.append("AND   MRRD.EQ_DMG_CD  = @[damage]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY MRRH.EQ_KND_CD,MRRD.EQ_CMPO_CD,MRRD.EQ_RPR_CD,MRRD.TRF_DIV_CD" ).append("\n"); 
		query.append("         #if (${qty} == 'N') " ).append("\n"); 
		query.append("         ,MRRD.EQ_LOC_CD" ).append("\n"); 
		query.append("		 ,MRRD.EQ_DMG_CD" ).append("\n"); 
		query.append("		 ,MRRH.COST_OFC_CD" ).append("\n"); 
		query.append("		 ,MRRH.VNDR_SEQ" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("		 #if (${currency} != 'Y') " ).append("\n"); 
		query.append("         ,MRRH.CURR_CD" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("#if (${qty} == 'Y') " ).append("\n"); 
		query.append("ORDER BY MRRH.EQ_KND_CD,MRRD.EQ_CMPO_CD,MRRD.EQ_RPR_CD,MRRD.TRF_DIV_CD,QTY DESC" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("ORDER BY MRRH.EQ_KND_CD,MRRD.EQ_CMPO_CD,MRRD.EQ_RPR_CD,MRRD.TRF_DIV_CD DESC	" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}