/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03HRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03HRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기별별 확정된 내용을 Bound, RHQ, Area Director,C.Office, Sub Trade, Lane 별로 Grouping 된 형태로 조회 한다. (주요 table saq_mon_cfm_qta, saq_mon_cfm_tgt_vvd)
	  * </pre>
	  */
	public MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03HRRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhqCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("items0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0126Tab03HRRSQL").append("\n"); 
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
		query.append("WITH TMP_INPUT_PARAMS AS  " ).append("\n"); 
		query.append("    (SELECT DISTINCT" ).append("\n"); 
		query.append("        @[year] AS BSE_YR, " ).append("\n"); 
		query.append("        @[quarter] AS BSE_QTR_CD, " ).append("\n"); 
		query.append("        @[year]||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("		AS YRMON_1," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	, 'YYYYMM'), 1), 'YYYYMM') AS YRMON_2, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, 'YYYYMM'), 2), 'YYYYMM') AS YRMON_3, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        @[targetGrp] AS SAQ_TGT_GRP_CD, " ).append("\n"); 
		query.append("        @[version] AS RLSE_VER_NO, 		" ).append("\n"); 
		query.append("        @[trade] AS TRD_CD, " ).append("\n"); 
		query.append("		decode(@[dirCd],'ALL',null,@[dirCd]) AS DIR_CD, " ).append("\n"); 
		query.append("        @[rhqCd] AS RHQ_CD  			" ).append("\n"); 
		query.append("     FROM   DUAL)  " ).append("\n"); 
		query.append("    ,MAP AS" ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("         DISTINCT" ).append("\n"); 
		query.append("         SMR.TRD_CD,    " ).append("\n"); 
		query.append("         SMR.DIR_CD, " ).append("\n"); 
		query.append("         SMR.RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("         NVL(SMR.AQ_CD, '  ') AS AQ_CD," ).append("\n"); 
		query.append("         SMR.RGN_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("         VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("         SMR.RLANE_CD,  " ).append("\n"); 
		query.append("         SMR.BSE_YR||SMR.BSE_MON AS YRMON" ).append("\n"); 
		query.append("    FROM SAQ_MON_CFM_QTA SMR " ).append("\n"); 
		query.append("         JOIN  " ).append("\n"); 
		query.append("         TMP_INPUT_PARAMS INP  " ).append("\n"); 
		query.append("         ON  " ).append("\n"); 
		query.append("         (  " ).append("\n"); 
		query.append("            SMR.BSE_YR = INP.BSE_YR AND  " ).append("\n"); 
		query.append("            SMR.BSE_QTR_CD = INP.BSE_QTR_CD AND  " ).append("\n"); 
		query.append("            SMR.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO AND  " ).append("\n"); 
		query.append("            SMR.TRD_CD = INP.TRD_CD AND  " ).append("\n"); 
		query.append("            SMR.CONV_DIR_CD LIKE INP.DIR_CD||'%' AND  " ).append("\n"); 
		query.append("            SMR.RHQ_CD LIKE INP.RHQ_CD||'%' AND " ).append("\n"); 
		query.append("            SMR.QTA_TGT_CD = @[selType]												" ).append("\n"); 
		query.append("         )     " ).append("\n"); 
		query.append("         JOIN										 		" ).append("\n"); 
		query.append("       	   SAQ_MON_CFM_TGT_VVD VVD								 	" ).append("\n"); 
		query.append("         ON										 		" ).append("\n"); 
		query.append("         (										 		" ).append("\n"); 
		query.append("            VVD.MQTA_RLSE_VER_NO = SMR.MQTA_RLSE_VER_NO AND				 		" ).append("\n"); 
		query.append("            VVD.BSE_YR = SMR.BSE_YR AND							 		" ).append("\n"); 
		query.append("            VVD.BSE_QTR_CD = SMR.BSE_QTR_CD AND						 		" ).append("\n"); 
		query.append("            VVD.BSE_MON = SMR.BSE_MON AND						 		" ).append("\n"); 
		query.append("            VVD.TRD_CD = SMR.TRD_CD AND							 		" ).append("\n"); 
		query.append("            VVD.RLANE_CD = SMR.RLANE_CD AND						 		" ).append("\n"); 
		query.append("            VVD.DIR_CD = SMR.DIR_CD AND							 		" ).append("\n"); 
		query.append("            VVD.VSL_CD = SMR.VSL_CD AND							 		" ).append("\n"); 
		query.append("            VVD.SKD_VOY_NO = SMR.SKD_VOY_NO AND						 		" ).append("\n"); 
		query.append("            VVD.SKD_DIR_CD = SMR.SKD_DIR_CD						 		" ).append("\n"); 
		query.append("         )												" ).append("\n"); 
		query.append("         )     		" ).append("\n"); 
		query.append("    ,TEMP_SMR AS" ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("         DISTINCT" ).append("\n"); 
		query.append("         SMR.TRD_CD,    " ).append("\n"); 
		query.append("         SMR.DIR_CD, " ).append("\n"); 
		query.append("         VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("         SMR.RLANE_CD,  " ).append("\n"); 
		query.append("         SMR.BSE_MON" ).append("\n"); 
		query.append("    FROM SAQ_MON_CFM_QTA SMR " ).append("\n"); 
		query.append("         JOIN  " ).append("\n"); 
		query.append("         TMP_INPUT_PARAMS INP  " ).append("\n"); 
		query.append("         ON  " ).append("\n"); 
		query.append("         (  " ).append("\n"); 
		query.append("            SMR.BSE_YR = INP.BSE_YR AND  " ).append("\n"); 
		query.append("            SMR.BSE_QTR_CD = INP.BSE_QTR_CD AND  " ).append("\n"); 
		query.append("            SMR.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO AND  " ).append("\n"); 
		query.append("            SMR.TRD_CD = INP.TRD_CD AND  " ).append("\n"); 
		query.append("            SMR.CONV_DIR_CD LIKE INP.DIR_CD||'%' AND  " ).append("\n"); 
		query.append("            SMR.RHQ_CD LIKE INP.RHQ_CD||'%' AND " ).append("\n"); 
		query.append("            SMR.QTA_TGT_CD = @[selType]										" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         JOIN										 		" ).append("\n"); 
		query.append("       	   SAQ_MON_CFM_TGT_VVD VVD								 	" ).append("\n"); 
		query.append("         ON										 		" ).append("\n"); 
		query.append("         (										 		" ).append("\n"); 
		query.append("            VVD.MQTA_RLSE_VER_NO = SMR.MQTA_RLSE_VER_NO AND				 		" ).append("\n"); 
		query.append("            VVD.BSE_YR = SMR.BSE_YR AND							 		" ).append("\n"); 
		query.append("            VVD.BSE_QTR_CD = SMR.BSE_QTR_CD AND						 		" ).append("\n"); 
		query.append("            VVD.BSE_MON = SMR.BSE_MON AND						 		" ).append("\n"); 
		query.append("            VVD.TRD_CD = SMR.TRD_CD AND							 		" ).append("\n"); 
		query.append("            VVD.RLANE_CD = SMR.RLANE_CD AND						 		" ).append("\n"); 
		query.append("            VVD.DIR_CD = SMR.DIR_CD AND							 		" ).append("\n"); 
		query.append("            VVD.VSL_CD = SMR.VSL_CD AND							 		" ).append("\n"); 
		query.append("            VVD.SKD_VOY_NO = SMR.SKD_VOY_NO AND						 		" ).append("\n"); 
		query.append("            VVD.SKD_DIR_CD = SMR.SKD_DIR_CD						 		" ).append("\n"); 
		query.append("         )												" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    ,VVD AS " ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("            VVD.TRD_CD, " ).append("\n"); 
		query.append("            VVD.CONV_DIR_CD, " ).append("\n"); 
		query.append("            VVD.SUB_TRD_CD, " ).append("\n"); 
		query.append("            VVD.RLANE_CD, " ).append("\n"); 
		query.append("            VVD.BSE_YR||VVD.BSE_MON AS YRMON, " ).append("\n"); 
		query.append("            SUM(VVD.FNL_BSA_CAPA) AS BSA, " ).append("\n"); 
		query.append("            COUNT(*) AS VOYAGE " ).append("\n"); 
		query.append("     FROM   SAQ_MON_CFM_TGT_VVD VVD" ).append("\n"); 
		query.append("            JOIN " ).append("\n"); 
		query.append("            TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append("            ON" ).append("\n"); 
		query.append("            ( " ).append("\n"); 
		query.append("               VVD.BSE_YR = INP.BSE_YR AND" ).append("\n"); 
		query.append("               VVD.BSE_QTR_CD = INP.BSE_QTR_CD AND" ).append("\n"); 
		query.append("               VVD.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO AND" ).append("\n"); 
		query.append("               VVD.TRD_CD LIKE INP.TRD_CD||'%' AND" ).append("\n"); 
		query.append("               VVD.CONV_DIR_CD LIKE INP.DIR_CD||'%'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            JOIN" ).append("\n"); 
		query.append("            TEMP_SMR SMR" ).append("\n"); 
		query.append("            ON" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("               SMR.TRD_CD = VVD.TRD_CD AND" ).append("\n"); 
		query.append("               SMR.DIR_CD = VVD.DIR_CD AND" ).append("\n"); 
		query.append("               SMR.SUB_TRD_CD = VVD.SUB_TRD_CD AND" ).append("\n"); 
		query.append("               SMR.RLANE_CD = VVD.RLANE_CD AND" ).append("\n"); 
		query.append("               SMR.BSE_MON = VVD.BSE_MON            " ).append("\n"); 
		query.append("            )               " ).append("\n"); 
		query.append("     GROUP BY VVD.TRD_CD, VVD.CONV_DIR_CD, VVD.SUB_TRD_CD, VVD.RLANE_CD, VVD.BSE_YR||VVD.BSE_MON)      " ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    KEY,  " ).append("\n"); 
		query.append("    SLEVEL,   " ).append("\n"); 
		query.append("    DIR_CD,  " ).append("\n"); 
		query.append("    RHQ_CD,  " ).append("\n"); 
		query.append("    AQ_CD,  " ).append("\n"); 
		query.append("    OFC_CD," ).append("\n"); 
		query.append("    '' SUB_TRD_CD,  " ).append("\n"); 
		query.append("    '' RLANE_CD, " ).append("\n"); 
		query.append("    '' AS CONV_DIR_CD,  " ).append("\n"); 
		query.append("    ROW_SEQ,  " ).append("\n"); 
		query.append("    REPLACE(TEXT, '(P)', '') AS ITEM_TEXT, " ).append("\n"); 
		query.append("    REPLACE(ITEM, '(P)', '') AS ITEM,	" ).append("\n"); 
		query.append("    VAL_00,   " ).append("\n"); 
		query.append("    VAL_01,   " ).append("\n"); 
		query.append("    VAL_02,   " ).append("\n"); 
		query.append("    VAL_03" ).append("\n"); 
		query.append("FROM  (  " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("          MIN(KEY) AS KEY, " ).append("\n"); 
		query.append("          SLEVEL, " ).append("\n"); 
		query.append("          CASE SLEVEL" ).append("\n"); 
		query.append("             WHEN 1 THEN 'TOTAL'" ).append("\n"); 
		query.append("             ELSE SMR.DIR_CD" ).append("\n"); 
		query.append("          END DIR_CD, " ).append("\n"); 
		query.append("          CASE SLEVEL" ).append("\n"); 
		query.append("             WHEN 1 THEN ''" ).append("\n"); 
		query.append("             WHEN 2 THEN 'TOTAL'" ).append("\n"); 
		query.append("             ELSE SMR.RHQ_CD" ).append("\n"); 
		query.append("          END RHQ_CD,             " ).append("\n"); 
		query.append("          CASE SLEVEL" ).append("\n"); 
		query.append("             WHEN 1 THEN ''" ).append("\n"); 
		query.append("             WHEN 2 THEN ''" ).append("\n"); 
		query.append("             WHEN 3 THEN 'TOTAL'" ).append("\n"); 
		query.append("             ELSE SMR.AQ_CD" ).append("\n"); 
		query.append("          END AQ_CD," ).append("\n"); 
		query.append("          CASE SLEVEL" ).append("\n"); 
		query.append("             WHEN 1 THEN ''" ).append("\n"); 
		query.append("             WHEN 2 THEN ''" ).append("\n"); 
		query.append("             WHEN 3 THEN ''" ).append("\n"); 
		query.append("             WHEN 4 THEN 'TOTAL'" ).append("\n"); 
		query.append("             ELSE SMR.OFC_CD" ).append("\n"); 
		query.append("          END OFC_CD,  " ).append("\n"); 
		query.append("          ITM.ROW_SEQ,  " ).append("\n"); 
		query.append("          ITM.TEXT,  " ).append("\n"); 
		query.append("          CASE  " ).append("\n"); 
		query.append("             WHEN ITM.CODE IN('05', '07', '08', '11', '12') THEN ITM.TEXT || '*'  " ).append("\n"); 
		query.append("             ELSE ITM.TEXT  " ).append("\n"); 
		query.append("          END ITEM,  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(DECODE( ITM.CODE,  '01', SUM(BSA),                     			" ).append("\n"); 
		query.append("	                 '02', SUM(VOYAGE),                           			" ).append("\n"); 
		query.append("	                 '03', SUM(SMR.LOD),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(SUM(BSA), 0, 0, SUM(SMR.LOD)/SUM(BSA)*100), 	" ).append("\n"); 
		query.append("	                 '05', SUM(SMR.REV),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(SUM(LOD), 0, 0, SUM(REV)/SUM(LOD)*1000),       " ).append("\n"); 
		query.append("	                 '07', SUM(SMR.CM),                                  		" ).append("\n"); 
		query.append("	                 '08', SUM(SMR.RA_CM),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(SUM(LOD), 0, 0, SUM(CM)*1000/SUM(LOD)),        " ).append("\n"); 
		query.append("	                 '10', DECODE(SUM(LOD), 0, 0, SUM(RA_CM)*1000/SUM(LOD)),     " ).append("\n"); 
		query.append("	                 '11', SUM(SMR.OP),                                  		" ).append("\n"); 
		query.append("	                 '12', SUM(SMR.RA_OP),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(SUM(LOD), 0, 0, SUM(OP)*1000/SUM(LOD)),        " ).append("\n"); 
		query.append("	                 '14', DECODE(SUM(LOD), 0, 0, SUM(RA_OP)*1000/SUM(LOD)) ), 0) AS VAL_00," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(SMR.YRMON, INP.YRMON_1,	" ).append("\n"); 
		query.append("	        DECODE( ITM.CODE,  '01', (BSA),                     			" ).append("\n"); 
		query.append("	                 '02', (VOYAGE),                           			" ).append("\n"); 
		query.append("	                 '03', (SMR.LOD),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(BSA, 0, 0, (SMR.LOD)/(BSA)*100),  			" ).append("\n"); 
		query.append("	                 '05', (SMR.REV),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(LOD, 0, 0, (REV)/(LOD)*1000),              " ).append("\n"); 
		query.append("	                 '07', (SMR.CM),                                  		" ).append("\n"); 
		query.append("	                 '08', (SMR.RA_CM),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(LOD, 0, 0, (CM)*1000/(LOD)),               " ).append("\n"); 
		query.append("	                 '10', DECODE(LOD, 0, 0, (RA_CM)*1000/(LOD)),            " ).append("\n"); 
		query.append("	                 '11', (SMR.OP),                                  		" ).append("\n"); 
		query.append("	                 '12', (SMR.RA_OP),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(LOD, 0, 0, (OP)*1000/(LOD)),               " ).append("\n"); 
		query.append("	                 '14', DECODE(LOD, 0, 0, (RA_OP)*1000/(LOD)) ))), 0) AS VAL_01," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(SMR.YRMON, INP.YRMON_2,                     		" ).append("\n"); 
		query.append("	        DECODE( ITM.CODE,  '01', (BSA),                     			" ).append("\n"); 
		query.append("	                 '02', (VOYAGE),                           			" ).append("\n"); 
		query.append("	                 '03', (SMR.LOD),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(BSA, 0, 0, (SMR.LOD)/(BSA)*100),  			" ).append("\n"); 
		query.append("	                 '05', (SMR.REV),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(LOD, 0, 0, (REV)/(LOD)*1000),              " ).append("\n"); 
		query.append("	                 '07', (SMR.CM),                                  		" ).append("\n"); 
		query.append("	                 '08', (SMR.RA_CM),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(LOD, 0, 0, (CM)*1000/(LOD)),               " ).append("\n"); 
		query.append("	                 '10', DECODE(LOD, 0, 0, (RA_CM)*1000/(LOD)),            " ).append("\n"); 
		query.append("	                 '11', (SMR.OP),                                  		" ).append("\n"); 
		query.append("	                 '12', (SMR.RA_OP),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(LOD, 0, 0, (OP)*1000/(LOD)),               " ).append("\n"); 
		query.append("	                 '14', DECODE(LOD, 0, 0, (RA_OP)*1000/(LOD)) ))), 0) AS VAL_02," ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    NVL(SUM(DECODE(SMR.YRMON, INP.YRMON_3,                     		" ).append("\n"); 
		query.append("	        DECODE( ITM.CODE,  '01', (BSA),                     			" ).append("\n"); 
		query.append("	                 '02', (VOYAGE),                           			" ).append("\n"); 
		query.append("	                 '03', (SMR.LOD),                                 		" ).append("\n"); 
		query.append("	                 '04', DECODE(BSA, 0, 0, (SMR.LOD)/(BSA)*100),  			" ).append("\n"); 
		query.append("	                 '05', (SMR.REV),                                 		" ).append("\n"); 
		query.append("	                 '06', DECODE(LOD, 0, 0, (REV)/(LOD)*1000),              " ).append("\n"); 
		query.append("	                 '07', (SMR.CM),                                  		" ).append("\n"); 
		query.append("	                 '08', (SMR.RA_CM),                               		" ).append("\n"); 
		query.append("	                 '09', DECODE(LOD, 0, 0, (CM)*1000/(LOD)),               " ).append("\n"); 
		query.append("	                 '10', DECODE(LOD, 0, 0, (RA_CM)*1000/(LOD)),            " ).append("\n"); 
		query.append("	                 '11', (SMR.OP),                                  		" ).append("\n"); 
		query.append("	                 '12', (SMR.RA_OP),                               		" ).append("\n"); 
		query.append("	                 '13', DECODE(LOD, 0, 0, (OP)*1000/(LOD)),               " ).append("\n"); 
		query.append("	                 '14', DECODE(LOD, 0, 0, (RA_OP)*1000/(LOD)) ))), 0) AS VAL_03	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("    FROM  (  " ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                  KEY," ).append("\n"); 
		query.append("                  CASE G_FLAG" ).append("\n"); 
		query.append("                     WHEN '1111' THEN 1" ).append("\n"); 
		query.append("                     WHEN '0111' THEN 2" ).append("\n"); 
		query.append("                     WHEN '0011' THEN 3" ).append("\n"); 
		query.append("                     WHEN '0001' THEN 4" ).append("\n"); 
		query.append("                     WHEN '0000' THEN 5" ).append("\n"); 
		query.append("                  END SLEVEL,                  " ).append("\n"); 
		query.append("                  DIR_CD," ).append("\n"); 
		query.append("                  RHQ_CD," ).append("\n"); 
		query.append("                  AQ_CD," ).append("\n"); 
		query.append("                  OFC_CD," ).append("\n"); 
		query.append("                  YRMON," ).append("\n"); 
		query.append("                  0 AS BSA," ).append("\n"); 
		query.append("                  CASE G_FLAG" ).append("\n"); 
		query.append("                     WHEN '1111' THEN VOYAGE_LVL_1" ).append("\n"); 
		query.append("                     WHEN '0111' THEN VOYAGE_LVL_2" ).append("\n"); 
		query.append("                     WHEN '0011' THEN VOYAGE_LVL_2" ).append("\n"); 
		query.append("                     WHEN '0001' THEN VOYAGE_LVL_2" ).append("\n"); 
		query.append("                     WHEN '0000' THEN VOYAGE_LVL_5" ).append("\n"); 
		query.append("                  END VOYAGE," ).append("\n"); 
		query.append("                  LOD," ).append("\n"); 
		query.append("                  REV," ).append("\n"); 
		query.append("                  CM," ).append("\n"); 
		query.append("                  RA_CM," ).append("\n"); 
		query.append("                  OP," ).append("\n"); 
		query.append("                  RA_OP            " ).append("\n"); 
		query.append("            FROM  (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                          G_FLAG," ).append("\n"); 
		query.append("                          KEY," ).append("\n"); 
		query.append("                          CONV_DIR_CD DIR_CD," ).append("\n"); 
		query.append("                          RHQ_CD," ).append("\n"); 
		query.append("                          AQ_CD," ).append("\n"); 
		query.append("                          OFC_CD," ).append("\n"); 
		query.append("                          YRMON, " ).append("\n"); 
		query.append("                          (SELECT SUM(VOYAGE) " ).append("\n"); 
		query.append("                           FROM  VVD " ).append("\n"); 
		query.append("                           WHERE 1 = 1 " ).append("\n"); 
		query.append("                           AND   YRMON = SMR.YRMON) AS VOYAGE_LVL_1," ).append("\n"); 
		query.append("                          (SELECT SUM(VOYAGE) " ).append("\n"); 
		query.append("                           FROM  VVD " ).append("\n"); 
		query.append("                           WHERE 1 = 1 " ).append("\n"); 
		query.append("                           AND   YRMON = SMR.YRMON" ).append("\n"); 
		query.append("                           AND   CONV_DIR_CD = SMR.CONV_DIR_CD) AS VOYAGE_LVL_2,                          " ).append("\n"); 
		query.append("                          (SELECT SUM(VOYAGE) " ).append("\n"); 
		query.append("                           FROM  VVD " ).append("\n"); 
		query.append("                           WHERE 1 = 1 " ).append("\n"); 
		query.append("                           AND   YRMON = SMR.YRMON" ).append("\n"); 
		query.append("                           AND   CONV_DIR_CD = SMR.CONV_DIR_CD " ).append("\n"); 
		query.append("                           AND   SUB_TRD_CD||RLANE_CD IN(SELECT SUB_TRD_CD||RLANE_CD " ).append("\n"); 
		query.append("                                                         FROM   MAP " ).append("\n"); 
		query.append("                                                         WHERE  1 = 1 " ).append("\n"); 
		query.append("                                                         AND    YRMON = SMR.YRMON" ).append("\n"); 
		query.append("                                                         AND    CONV_DIR_CD = SMR.CONV_DIR_CD " ).append("\n"); 
		query.append("                                                         AND    RHQ_CD = SMR.RHQ_CD " ).append("\n"); 
		query.append("                                                         AND    AQ_CD = SMR.AQ_CD" ).append("\n"); 
		query.append("                                                         AND    OFC_CD = SMR.OFC_CD)) AS VOYAGE_LVL_5," ).append("\n"); 
		query.append("                          (SELECT SUM(VOYAGE) " ).append("\n"); 
		query.append("                           FROM  VVD " ).append("\n"); 
		query.append("                           WHERE 1 = 1 " ).append("\n"); 
		query.append("                           AND   YRMON = SMR.YRMON" ).append("\n"); 
		query.append("                           AND   CONV_DIR_CD = SMR.CONV_DIR_CD " ).append("\n"); 
		query.append("                           AND   RLANE_CD IN(SELECT RLANE_CD " ).append("\n"); 
		query.append("                                             FROM   MAP " ).append("\n"); 
		query.append("                                             WHERE  1 = 1 " ).append("\n"); 
		query.append("                                             AND    YRMON = SMR.YRMON" ).append("\n"); 
		query.append("                                             AND    CONV_DIR_CD = SMR.CONV_DIR_CD " ).append("\n"); 
		query.append("                                             AND    RHQ_CD = SMR.RHQ_CD " ).append("\n"); 
		query.append("                                             AND    AQ_CD = SMR.AQ_CD" ).append("\n"); 
		query.append("                                             AND    OFC_CD = SMR.OFC_CD)) AS VOYAGE_LVL_6,                                                        " ).append("\n"); 
		query.append("                          LOD," ).append("\n"); 
		query.append("                          REV," ).append("\n"); 
		query.append("                          CM," ).append("\n"); 
		query.append("                          RA_CM," ).append("\n"); 
		query.append("                          OP," ).append("\n"); 
		query.append("                          RA_OP            " ).append("\n"); 
		query.append("                    FROM  (    " ).append("\n"); 
		query.append("                            SELECT   " ).append("\n"); 
		query.append("                                 GROUPING(CONV_DIR_CD)||GROUPING(RHQ_CD)||GROUPING(AQ_CD)||GROUPING(OFC_CD)AS G_FLAG," ).append("\n"); 
		query.append("                                 MIN(SMR.CONV_DIR_CD||SMR.RHQ_CD) AS KEY," ).append("\n"); 
		query.append("                                 SMR.CONV_DIR_CD,  " ).append("\n"); 
		query.append("                                 SMR.RHQ_CD," ).append("\n"); 
		query.append("                                 SMR.AQ_CD," ).append("\n"); 
		query.append("                                 SMR.OFC_CD,  " ).append("\n"); 
		query.append("                                 SMR.YRMON,                                      " ).append("\n"); 
		query.append("                                 SUM(LOD) AS LOD," ).append("\n"); 
		query.append("                                 SUM(REV) AS REV," ).append("\n"); 
		query.append("                                 SUM(CM) AS CM," ).append("\n"); 
		query.append("                                 SUM(RA_CM) AS RA_CM," ).append("\n"); 
		query.append("                                 SUM(OP) AS OP," ).append("\n"); 
		query.append("                                 SUM(RA_OP) AS RA_OP" ).append("\n"); 
		query.append("                            FROM (    " ).append("\n"); 
		query.append("                                    SELECT  " ).append("\n"); 
		query.append("                                         MIN(SMR.TRD_CD) AS TRD_CD,  " ).append("\n"); 
		query.append("                                         SMR.DIR_CD,  " ).append("\n"); 
		query.append("                                         SMR.CONV_DIR_CD,  " ).append("\n"); 
		query.append("                                         SMR.RHQ_CD AS RHQ_CD, " ).append("\n"); 
		query.append("                                         NVL(SMR.AQ_CD, '  ') AS AQ_CD," ).append("\n"); 
		query.append("                                         SMR.RGN_OFC_CD AS OFC_CD, " ).append("\n"); 
		query.append("                                         SMR.BSE_YR||SMR.BSE_MON AS YRMON," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         SUM(SMR.LOD_QTY) AS LOD, " ).append("\n"); 
		query.append("                         SUM(SMR.GRS_RPB_REV*SMR.LOD_QTY)/1000 AS REV,  " ).append("\n"); 
		query.append("                         SUM((SMR.GRS_RPB_REV-SMR.CM_UC_AMT)*SMR.LOD_QTY)/1000 AS CM, " ).append("\n"); 
		query.append("                         SUM((SMR.GRS_RPB_REV-SMR.RA_CM_UC_AMT)*SMR.LOD_QTY)/1000 AS RA_CM,  " ).append("\n"); 
		query.append("                         SUM((SMR.GRS_RPB_REV-SMR.OPFIT_UC_AMT)*SMR.LOD_QTY)/1000 AS OP, " ).append("\n"); 
		query.append("                         SUM((SMR.GRS_RPB_REV-SMR.RA_OPFIT_UC_AMT)*SMR.LOD_QTY )/1000 AS RA_OP " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("                                    FROM SAQ_MON_CFM_QTA SMR  " ).append("\n"); 
		query.append("                                         JOIN  " ).append("\n"); 
		query.append("                                         TMP_INPUT_PARAMS INP  " ).append("\n"); 
		query.append("                                         ON  " ).append("\n"); 
		query.append("                                         (  " ).append("\n"); 
		query.append("                                            SMR.BSE_YR = INP.BSE_YR AND  " ).append("\n"); 
		query.append("                                            SMR.BSE_QTR_CD = INP.BSE_QTR_CD AND  " ).append("\n"); 
		query.append("                                            SMR.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO AND  " ).append("\n"); 
		query.append("                                            SMR.TRD_CD = INP.TRD_CD AND  " ).append("\n"); 
		query.append("                                            SMR.CONV_DIR_CD LIKE INP.DIR_CD||'%' AND  " ).append("\n"); 
		query.append("                                            SMR.RHQ_CD LIKE INP.RHQ_CD||'%' AND " ).append("\n"); 
		query.append("           								   SMR.QTA_TGT_CD = @[selType]												" ).append("\n"); 
		query.append("                                         )  " ).append("\n"); 
		query.append("										 JOIN										 " ).append("\n"); 
		query.append("                                       	   SAQ_MON_CFM_TGT_VVD VVD								 " ).append("\n"); 
		query.append("										 ON										 " ).append("\n"); 
		query.append("                                         (										 " ).append("\n"); 
		query.append("                                            VVD.MQTA_RLSE_VER_NO = SMR.MQTA_RLSE_VER_NO AND				 " ).append("\n"); 
		query.append("                                            VVD.BSE_YR = SMR.BSE_YR AND							 " ).append("\n"); 
		query.append("                                            VVD.BSE_QTR_CD = SMR.BSE_QTR_CD AND						 " ).append("\n"); 
		query.append("                                            VVD.BSE_MON = SMR.BSE_MON AND						 " ).append("\n"); 
		query.append("                                            VVD.TRD_CD = SMR.TRD_CD AND							 " ).append("\n"); 
		query.append("                                            VVD.RLANE_CD = SMR.RLANE_CD AND						 " ).append("\n"); 
		query.append("                                            VVD.DIR_CD = SMR.DIR_CD AND							 " ).append("\n"); 
		query.append("                                            VVD.VSL_CD = SMR.VSL_CD AND							 " ).append("\n"); 
		query.append("                                            VVD.SKD_VOY_NO = SMR.SKD_VOY_NO AND						 " ).append("\n"); 
		query.append("                                            VVD.SKD_DIR_CD = SMR.SKD_DIR_CD						 " ).append("\n"); 
		query.append("                                         )     										" ).append("\n"); 
		query.append("                                    GROUP BY SMR.DIR_CD, SMR.CONV_DIR_CD, SMR.RHQ_CD, NVL(SMR.AQ_CD, '  '), SMR.RGN_OFC_CD, SMR.BSE_YR||SMR.BSE_MON" ).append("\n"); 
		query.append("                                  ) SMR  " ).append("\n"); 
		query.append("                            GROUP BY GROUPING SETS((SMR.YRMON),  " ).append("\n"); 
		query.append("                                                    (SMR.CONV_DIR_CD, SMR.YRMON), " ).append("\n"); 
		query.append("                                                    (SMR.CONV_DIR_CD, SMR.RHQ_CD, SMR.YRMON), " ).append("\n"); 
		query.append("                                                    (SMR.CONV_DIR_CD, SMR.RHQ_CD, SMR.AQ_CD, SMR.YRMON), " ).append("\n"); 
		query.append("                                                    (SMR.CONV_DIR_CD, SMR.RHQ_CD, SMR.AQ_CD, SMR.OFC_CD, SMR.YRMON))     " ).append("\n"); 
		query.append("                          ) SMR                              " ).append("\n"); 
		query.append("                  ) SMR                                                                                    " ).append("\n"); 
		query.append("          ) SMR  " ).append("\n"); 
		query.append("          JOIN  " ).append("\n"); 
		query.append("          (  " ).append("\n"); 
		query.append("            SELECT  INTG_CD_VAL_CTNT AS CODE,  " ).append("\n"); 
		query.append("                    INTG_CD_VAL_DP_DESC AS TEXT,  " ).append("\n"); 
		query.append("                    INTG_CD_VAL_DP_SEQ AS ROW_SEQ  " ).append("\n"); 
		query.append("            FROM  COM_INTG_CD_DTL  " ).append("\n"); 
		query.append("            WHERE INTG_CD_ID = 'CD01390'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if($ilist.size() > 0)" ).append("\n"); 
		query.append("            AND   ('ALL' = @[items0] OR (INTG_CD_VAL_DP_DESC IN (" ).append("\n"); 
		query.append("                #foreach ($key in ${ilist})" ).append("\n"); 
		query.append("                    #if($velocityCount < $ilist.size())" ).append("\n"); 
		query.append("                    '$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                    '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                   )) )  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ) ITM  " ).append("\n"); 
		query.append("          ON 1 = 1   " ).append("\n"); 
		query.append("          JOIN " ).append("\n"); 
		query.append("          TMP_INPUT_PARAMS INP " ).append("\n"); 
		query.append("          ON 1 = 1           " ).append("\n"); 
		query.append("      GROUP BY SMR.SLEVEL, SMR.DIR_CD, SMR.RHQ_CD, SMR.AQ_CD, SMR.OFC_CD, ITM.ROW_SEQ, ITM.TEXT, ITM.CODE  " ).append("\n"); 
		query.append("      ) SMR  " ).append("\n"); 
		query.append("ORDER BY  KEY, SLEVEL, AQ_CD DESC, OFC_CD,ROW_SEQ" ).append("\n"); 

	}
}