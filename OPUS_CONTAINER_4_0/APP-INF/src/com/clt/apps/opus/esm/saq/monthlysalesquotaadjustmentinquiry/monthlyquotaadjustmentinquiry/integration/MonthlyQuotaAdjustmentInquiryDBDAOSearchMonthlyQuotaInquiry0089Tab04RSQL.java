/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0089Tab04RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0089Tab04RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlySalesQuotaAdjustmentInquiry의 데이타 모델에 해당되는 값을 불러온다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0089Tab04RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_quarter",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlaneCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_wk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("item",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgtOrzCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("subTrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("datCreStepCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mstVersion",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0089Tab04RSQL").append("\n"); 
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
		query.append("WITH TMP_INPUT_PARAMS AS" ).append("\n"); 
		query.append("    (SELECT DISTINCT" ).append("\n"); 
		query.append("        @[datCreStepCd] AS DAT_CRE_STEP_CD," ).append("\n"); 
		query.append("        @[tgtOrzCd] AS TGT_ORZ_CD," ).append("\n"); 
		query.append("        '3' AS DAT_CRE_LVL_CD," ).append("\n"); 
		query.append("        @[year] AS BSE_YR," ).append("\n"); 
		query.append("        @[bse_quarter] AS BSE_QTR_CD," ).append("\n"); 
		query.append("        @[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10') AS YRMON_1," ).append("\n"); 
		query.append("        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), 1), 'YYYYMM') AS YRMON_2," ).append("\n"); 
		query.append("        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), 2), 'YYYYMM') AS YRMON_3," ).append("\n"); 
		query.append("        @[targetGrp] AS SAQ_TGT_GRP_CD," ).append("\n"); 
		query.append("        @[mstVersion] AS QTA_MST_VER_NO," ).append("\n"); 
		query.append("        @[version] AS GLINE_VER_NO," ).append("\n"); 
		query.append("        @[trade] AS TRD_CD," ).append("\n"); 
		query.append("        @[dirCd] AS DIR_CD," ).append("\n"); 
		query.append("        @[subTrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("        @[rlaneCd] AS RLANE_CD," ).append("\n"); 
		query.append("        @[ofcCd] AS OFC_CD," ).append("\n"); 
		query.append("        @[from_wk] AS FROM_WK," ).append("\n"); 
		query.append("        @[to_wk] AS TO_WK" ).append("\n"); 
		query.append("     FROM   DUAL)" ).append("\n"); 
		query.append("    ,SAQ_MON_QTA_ADJ_SMRY_HDR_VIEW AS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("       SELECT DISTINCT HDR.SAQ_TGT_GRP_CD,HDR.DAT_CRE_STEP_CD,HDR.TGT_ORZ_CD,HDR.BSE_YR,HDR.BSE_QTR_CD,HDR.GLINE_VER_NO,HDR.TRD_CD,HDR.DIR_CD" ).append("\n"); 
		query.append("        FROM SAQ_MON_QTA_ADJ_SMRY_HDR HDR" ).append("\n"); 
		query.append("           , TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append("        WHERE HDR.DAT_CRE_STEP_CD = INP.DAT_CRE_STEP_CD" ).append("\n"); 
		query.append("              AND HDR.TGT_ORZ_CD = INP.TGT_ORZ_CD" ).append("\n"); 
		query.append("              AND HDR.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("              AND HDR.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("              AND HDR.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("              AND HDR.SAQ_TGT_GRP_CD = INP.SAQ_TGT_GRP_CD" ).append("\n"); 
		query.append("              AND HDR.TRD_CD LIKE INP.TRD_CD||'%'" ).append("\n"); 
		query.append("              AND HDR.DIR_CD LIKE INP.DIR_CD||'%'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ,TEMP_SMR AS" ).append("\n"); 
		query.append("    (SELECT" ).append("\n"); 
		query.append("         DISTINCT" ).append("\n"); 
		query.append("         SMR.VSL_CD," ).append("\n"); 
		query.append("         SMR.SKD_VOY_NO," ).append("\n"); 
		query.append("         SMR.SKD_DIR_CD," ).append("\n"); 
		query.append("         SMR.TRD_CD," ).append("\n"); 
		query.append("         SMR.DIR_CD," ).append("\n"); 
		query.append("         SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("         SMR.RLANE_CD," ).append("\n"); 
		query.append("         SMR.BSE_MON" ).append("\n"); 
		query.append("    FROM SAQ_MON_QTA_ADJ_SMRY_HDR_VIEW HDR" ).append("\n"); 
		query.append("         , SAQ_MON_QTA_ADJ_SMRY SMR" ).append("\n"); 
		query.append("         , TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("        HDR.DAT_CRE_STEP_CD = INP.DAT_CRE_STEP_CD" ).append("\n"); 
		query.append("       AND HDR.TGT_ORZ_CD = INP.TGT_ORZ_CD" ).append("\n"); 
		query.append("       AND SMR.DAT_CRE_LVL_CD >= INP.DAT_CRE_LVL_CD" ).append("\n"); 
		query.append("       AND HDR.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("       AND HDR.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND HDR.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("       AND HDR.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("       AND HDR.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("       AND SMR.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("       AND SMR.RLANE_CD LIKE INP.RLANE_CD || '%'" ).append("\n"); 
		query.append("       AND SMR.RGN_OFC_CD = INP.OFC_CD" ).append("\n"); 
		query.append("       AND SMR.BSE_YR = HDR.BSE_YR" ).append("\n"); 
		query.append("       AND SMR.BSE_QTR_CD = HDR.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND SMR.SAQ_TGT_GRP_CD = HDR.SAQ_TGT_GRP_CD" ).append("\n"); 
		query.append("       AND SMR.GLINE_VER_NO = HDR.GLINE_VER_NO" ).append("\n"); 
		query.append("       AND SMR.TRD_CD = HDR.TRD_CD" ).append("\n"); 
		query.append("       AND SMR.DIR_CD = HDR.DIR_CD" ).append("\n"); 
		query.append("       AND SMR.DAT_CRE_STEP_CD = HDR.DAT_CRE_STEP_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ,VVD AS" ).append("\n"); 
		query.append("    (SELECT" ).append("\n"); 
		query.append("            VVD.VSL_CD," ).append("\n"); 
		query.append("            VVD.SKD_VOY_NO," ).append("\n"); 
		query.append("            VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("            VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD AS VVD_GRP_CD," ).append("\n"); 
		query.append("            VVD.TRD_CD," ).append("\n"); 
		query.append("            VVD.DIR_CD," ).append("\n"); 
		query.append("            VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("            VVD.RLANE_CD," ).append("\n"); 
		query.append("            VVD.BSE_YR," ).append("\n"); 
		query.append("            VVD.BSE_MON," ).append("\n"); 
		query.append("            VVD.BSE_WK," ).append("\n"); 
		query.append("            SUM(VVD.FNL_BSA_CAPA) AS BSA," ).append("\n"); 
		query.append("            COUNT(*) AS VOYAGE" ).append("\n"); 
		query.append("     FROM   SAQ_MON_TGT_VVD_ADJ VVD" ).append("\n"); 
		query.append("            JOIN" ).append("\n"); 
		query.append("            TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append("            ON" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                VVD.BSE_YR = INP.BSE_YR AND" ).append("\n"); 
		query.append("                VVD.BSE_QTR_CD = INP.BSE_QTR_CD AND" ).append("\n"); 
		query.append("                VVD.GLINE_VER_NO = INP.GLINE_VER_NO AND" ).append("\n"); 
		query.append("                VVD.TRD_CD = INP.TRD_CD AND" ).append("\n"); 
		query.append("                VVD.DIR_CD = INP.DIR_CD AND" ).append("\n"); 
		query.append("                VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD  || '%' AND" ).append("\n"); 
		query.append("                VVD.RLANE_CD LIKE INP.RLANE_CD    || '%'   AND" ).append("\n"); 
		query.append("                VVD.BSE_WK BETWEEN INP.FROM_WK AND INP.TO_WK" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            JOIN" ).append("\n"); 
		query.append("            TEMP_SMR SMR" ).append("\n"); 
		query.append("            ON" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("               SMR.VSL_CD = VVD.VSL_CD AND" ).append("\n"); 
		query.append("               SMR.SKD_VOY_NO = VVD.SKD_VOY_NO AND" ).append("\n"); 
		query.append("               SMR.SKD_DIR_CD = VVD.SKD_DIR_CD AND" ).append("\n"); 
		query.append("               SMR.TRD_CD = VVD.TRD_CD AND" ).append("\n"); 
		query.append("               SMR.DIR_CD = VVD.DIR_CD AND" ).append("\n"); 
		query.append("               SMR.SUB_TRD_CD = VVD.SUB_TRD_CD AND" ).append("\n"); 
		query.append("               SMR.RLANE_CD = VVD.RLANE_CD AND" ).append("\n"); 
		query.append("               SMR.BSE_MON = VVD.BSE_MON" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     GROUP BY VVD.BSE_WK,VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD, VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD, VVD.TRD_CD, VVD.DIR_CD, VVD.SUB_TRD_CD, VVD.RLANE_CD, VVD.BSE_YR,VVD.BSE_MON)" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("     KEY," ).append("\n"); 
		query.append("     SLEVEL," ).append("\n"); 
		query.append("     SMR.BSE_YR," ).append("\n"); 
		query.append("     SMR.BSE_WK," ).append("\n"); 
		query.append("     SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("     DECODE(DIR.CONV_DIR_CD,'',SMR.RLANE_CD,SMR.RLANE_CD||' - '||DIR.DIR_CD) RLANE_CD," ).append("\n"); 
		query.append("     DIR.DIR_CD CONV_DIR_CD," ).append("\n"); 
		query.append("     VVD_GRP_CD," ).append("\n"); 
		query.append("     VVD_CD," ).append("\n"); 
		query.append("     ROW_SEQ," ).append("\n"); 
		query.append("     TEXT AS ITEM_TEXT," ).append("\n"); 
		query.append("     ITEM," ).append("\n"); 
		query.append("     VAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM  (" ).append("\n"); 
		query.append("     SELECT" ).append("\n"); 
		query.append(" 	   MIN(KEY) AS KEY," ).append("\n"); 
		query.append(" 	  CASE SLEVEL" ).append("\n"); 
		query.append(" 	     WHEN 1 THEN 'TOTAL'" ).append("\n"); 
		query.append(" 	     ELSE SMR.SUB_TRD_CD" ).append("\n"); 
		query.append(" 	  END SUB_TRD_CD," ).append("\n"); 
		query.append(" 	  CASE SLEVEL" ).append("\n"); 
		query.append(" 	     WHEN 1 THEN ''" ).append("\n"); 
		query.append(" 	     WHEN 2 THEN 'TOTAL'" ).append("\n"); 
		query.append(" 	     ELSE SMR.RLANE_CD" ).append("\n"); 
		query.append(" 	  END RLANE_CD," ).append("\n"); 
		query.append(" 	  CASE SLEVEL" ).append("\n"); 
		query.append(" 	     WHEN 1 THEN ''" ).append("\n"); 
		query.append(" 	     WHEN 2 THEN ''" ).append("\n"); 
		query.append(" 	     WHEN 3 THEN 'TOTAL'" ).append("\n"); 
		query.append(" 	     ELSE SMR.VVD_GRP_CD" ).append("\n"); 
		query.append(" 	  END VVD_GRP_CD," ).append("\n"); 
		query.append(" 	  CASE SLEVEL" ).append("\n"); 
		query.append(" 	     WHEN 1 THEN ''" ).append("\n"); 
		query.append(" 	     WHEN 2 THEN ''" ).append("\n"); 
		query.append(" 	     WHEN 3 THEN ''" ).append("\n"); 
		query.append(" 	     WHEN 4 THEN 'TOTAL'" ).append("\n"); 
		query.append(" 	     ELSE SMR.VVD_CD" ).append("\n"); 
		query.append(" 	  END VVD_CD," ).append("\n"); 
		query.append(" 	  ITM.ROW_SEQ," ).append("\n"); 
		query.append(" 	  ITM.TEXT," ).append("\n"); 
		query.append(" 	  CASE" ).append("\n"); 
		query.append(" 	     WHEN ITM.CODE IN('05', '07', '08', '11', '12') THEN ITM.TEXT || '*'" ).append("\n"); 
		query.append(" 	     ELSE ITM.TEXT" ).append("\n"); 
		query.append(" 	  END ITEM," ).append("\n"); 
		query.append(" 	   SLEVEL," ).append("\n"); 
		query.append(" 	  SMR.BSE_YR," ).append("\n"); 
		query.append(" 	  SMR.BSE_WK," ).append("\n"); 
		query.append(" 	    NVL(SUM(" ).append("\n"); 
		query.append(" 		DECODE( ITM.CODE," ).append("\n"); 
		query.append(" 			 '02', (VOYAGE)," ).append("\n"); 
		query.append(" 			 '03', (SMR.LOD)," ).append("\n"); 
		query.append(" 			 '05', (SMR.REV)," ).append("\n"); 
		query.append(" 			 '06', DECODE(LOD, 0, 0, (REV)/(LOD)*1000)," ).append("\n"); 
		query.append(" 			 '07', (SMR.CM)," ).append("\n"); 
		query.append(" 			 '08', (SMR.RA_CM)," ).append("\n"); 
		query.append(" 			 '09', DECODE(LOD, 0, 0, (CM)*1000/(LOD))," ).append("\n"); 
		query.append(" 			 '10', DECODE(LOD, 0, 0, (RA_CM)*1000/(LOD))," ).append("\n"); 
		query.append(" 			 '11', (SMR.OP)," ).append("\n"); 
		query.append(" 			 '12', (SMR.RA_OP)," ).append("\n"); 
		query.append(" 			 '13', DECODE(LOD, 0, 0, (OP)*1000/(LOD))," ).append("\n"); 
		query.append(" 			 '14', DECODE(LOD, 0, 0, (RA_OP)*1000/(LOD)) )), 0) AS VAL" ).append("\n"); 
		query.append("     FROM  (" ).append("\n"); 
		query.append(" 	    SELECT" ).append("\n"); 
		query.append(" 		  G_FLAG," ).append("\n"); 
		query.append(" 		  CASE G_FLAG" ).append("\n"); 
		query.append(" 		     WHEN '01111' THEN 1" ).append("\n"); 
		query.append(" 		     WHEN '00111' THEN 2" ).append("\n"); 
		query.append(" 		     WHEN '00011' THEN 3" ).append("\n"); 
		query.append(" 		     WHEN '00001' THEN 4" ).append("\n"); 
		query.append(" 		     WHEN '00000' THEN 5" ).append("\n"); 
		query.append(" 		  END SLEVEL," ).append("\n"); 
		query.append(" 		  KEY," ).append("\n"); 
		query.append(" 		  SUB_TRD_CD," ).append("\n"); 
		query.append(" 		  RLANE_CD," ).append("\n"); 
		query.append(" 		  VVD_GRP_CD," ).append("\n"); 
		query.append(" 		  VVD_CD," ).append("\n"); 
		query.append(" 		  BSE_YR," ).append("\n"); 
		query.append(" 		  BSE_WK," ).append("\n"); 
		query.append(" 		  VOYAGE," ).append("\n"); 
		query.append(" 		  LOD," ).append("\n"); 
		query.append(" 		  REV," ).append("\n"); 
		query.append(" 		  CM," ).append("\n"); 
		query.append(" 		  RA_CM," ).append("\n"); 
		query.append(" 		  OP," ).append("\n"); 
		query.append(" 		  RA_OP" ).append("\n"); 
		query.append(" 	    FROM  (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                         GROUPING(BSE_WK)||GROUPING(SUB_TRD_CD)||GROUPING(RLANE_CD)||GROUPING(VVD_GRP_CD)||GROUPING(VVD_CD) AS G_FLAG," ).append("\n"); 
		query.append("                         MIN(SMR.BSE_YR||SMR.BSE_WK||SMR.SUB_TRD_CD||DECODE(SMR.RLANE_CD,'RBCCO','ZZ',SUBSTR(SMR.RLANE_CD,-2))||SMR.RLANE_CD||SMR.VVD_GRP_CD||VVD_CD) AS KEY," ).append("\n"); 
		query.append("                         SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("                         SMR.RLANE_CD," ).append("\n"); 
		query.append("                         SMR.VVD_GRP_CD," ).append("\n"); 
		query.append("		 	             SMR.BSE_YR," ).append("\n"); 
		query.append("		 	             SMR.BSE_WK," ).append("\n"); 
		query.append("			             VVD_CD," ).append("\n"); 
		query.append("                         COUNT(DISTINCT VVD_CD) VOYAGE," ).append("\n"); 
		query.append("                         SUM(LOD) AS LOD," ).append("\n"); 
		query.append("                         SUM(REV) AS REV," ).append("\n"); 
		query.append("                         SUM(CM) AS CM," ).append("\n"); 
		query.append("                         SUM(RA_CM) AS RA_CM," ).append("\n"); 
		query.append("                         SUM(OP) AS OP," ).append("\n"); 
		query.append("                         SUM(RA_OP) AS RA_OP" ).append("\n"); 
		query.append("                    FROM     (" ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                     SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("                                     SMR.RLANE_CD," ).append("\n"); 
		query.append("                                     VVD.VVD_GRP_CD," ).append("\n"); 
		query.append("			    	                 SMR.BSE_YR ," ).append("\n"); 
		query.append("			    	                 VVD.BSE_WK," ).append("\n"); 
		query.append("                                     VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD  VVD_CD," ).append("\n"); 
		query.append("                                     SUM(SMR.LOD_QTY) AS LOD," ).append("\n"); 
		query.append("                                     SUM(SMR.GRS_RPB_REV*SMR.LOD_QTY)/1000 AS REV," ).append("\n"); 
		query.append("                                     SUM((SMR.GRS_RPB_REV-SMR.CM_UC_AMT)*SMR.LOD_QTY)/1000 AS CM," ).append("\n"); 
		query.append("                                     SUM((SMR.GRS_RPB_REV-SMR.RA_CM_UC_AMT)*SMR.LOD_QTY)/1000 AS RA_CM, -- BKG CM" ).append("\n"); 
		query.append("                                     SUM((SMR.GRS_RPB_REV-SMR.OPFIT_UC_AMT)*SMR.LOD_QTY)/1000 AS OP," ).append("\n"); 
		query.append("                                     SUM((SMR.GRS_RPB_REV-SMR.RA_OPFIT_UC_AMT)*SMR.LOD_QTY )/1000 AS RA_OP -- BKG OP" ).append("\n"); 
		query.append("                                FROM SAQ_MON_QTA_ADJ_SMRY_HDR_VIEW HDR" ).append("\n"); 
		query.append("                                     , SAQ_MON_QTA_ADJ_SMRY SMR" ).append("\n"); 
		query.append("                                     , TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append("                                     , VVD" ).append("\n"); 
		query.append("                                WHERE" ).append("\n"); 
		query.append("                                    HDR.DAT_CRE_STEP_CD = INP.DAT_CRE_STEP_CD" ).append("\n"); 
		query.append("                                   AND HDR.TGT_ORZ_CD = INP.TGT_ORZ_CD" ).append("\n"); 
		query.append("                                   AND SMR.DAT_CRE_LVL_CD >= INP.DAT_CRE_LVL_CD" ).append("\n"); 
		query.append("                                   AND HDR.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("                                   AND HDR.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("                                   AND HDR.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("                                   AND HDR.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("                                   AND HDR.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("                                   AND SMR.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("                                   AND SMR.RLANE_CD LIKE INP.RLANE_CD || '%'" ).append("\n"); 
		query.append("                                   AND SMR.RGN_OFC_CD = INP.OFC_CD" ).append("\n"); 
		query.append("                                   AND SMR.BSE_YR = HDR.BSE_YR" ).append("\n"); 
		query.append("                                   AND SMR.BSE_QTR_CD = HDR.BSE_QTR_CD" ).append("\n"); 
		query.append("                                   AND SMR.SAQ_TGT_GRP_CD = HDR.SAQ_TGT_GRP_CD" ).append("\n"); 
		query.append("                                   AND SMR.GLINE_VER_NO = HDR.GLINE_VER_NO" ).append("\n"); 
		query.append("                                   AND SMR.TRD_CD = HDR.TRD_CD" ).append("\n"); 
		query.append("                                   AND SMR.DIR_CD = HDR.DIR_CD" ).append("\n"); 
		query.append("                                   AND SMR.DAT_CRE_STEP_CD = HDR.DAT_CRE_STEP_CD" ).append("\n"); 
		query.append("                                   AND SMR.TRD_CD = VVD.TRD_CD" ).append("\n"); 
		query.append("                                   AND SMR.DIR_CD = VVD.DIR_CD" ).append("\n"); 
		query.append("                                   AND SMR.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("      			                   AND SMR.SUB_TRD_CD = VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      			                   AND SMR.BSE_YR = VVD.BSE_YR" ).append("\n"); 
		query.append("      			                   AND SMR.BSE_MON = VVD.BSE_MON" ).append("\n"); 
		query.append("                                   AND SMR.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                   AND SMR.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SMR.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                GROUP BY SMR.SUB_TRD_CD,SMR.RLANE_CD,VVD.VVD_GRP_CD, SMR.BSE_YR,VVD.BSE_WK, VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                             ) SMR" ).append("\n"); 
		query.append("                    GROUP BY GROUPING SETS((SMR.BSE_YR,SMR.BSE_WK)," ).append("\n"); 
		query.append("                                            (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD)," ).append("\n"); 
		query.append("                                            (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD,SMR.RLANE_CD,SMR.VVD_GRP_CD,VVD_CD))" ).append("\n"); 
		query.append(" 		  ) SMR" ).append("\n"); 
		query.append(" 	  ) SMR" ).append("\n"); 
		query.append(" 	  JOIN" ).append("\n"); 
		query.append(" 	  (" ).append("\n"); 
		query.append(" 	    SELECT  INTG_CD_VAL_CTNT AS CODE," ).append("\n"); 
		query.append(" 		    INTG_CD_VAL_DP_DESC AS TEXT," ).append("\n"); 
		query.append(" 		    INTG_CD_VAL_DP_SEQ AS ROW_SEQ" ).append("\n"); 
		query.append(" 	    FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" 	    WHERE INTG_CD_ID = 'CD01391'" ).append("\n"); 
		query.append("		  AND ('ALL' = @[item]  OR (INTG_CD_VAL_DP_DESC IN (" ).append("\n"); 
		query.append("			  #foreach( $key in ${itemAr}) " ).append("\n"); 
		query.append("				      '$key'," ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("					  'X'" ).append("\n"); 
		query.append("			  )) )" ).append("\n"); 
		query.append(" 	  ) ITM" ).append("\n"); 
		query.append(" 	  ON 1 = 1" ).append("\n"); 
		query.append(" 	  JOIN" ).append("\n"); 
		query.append(" 	  TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append(" 	  ON 1 = 1" ).append("\n"); 
		query.append("       GROUP BY SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD,SMR.RLANE_CD,SMR.SLEVEL, SMR.VVD_GRP_CD,SMR.VVD_CD, ITM.ROW_SEQ, ITM.TEXT, ITM.CODE" ).append("\n"); 
		query.append("       ) SMR" ).append("\n"); 
		query.append("    ,     (" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("              DIR.RLANE_CD," ).append("\n"); 
		query.append("              DIR.DIR_CD," ).append("\n"); 
		query.append("              DIR.CONV_DIR_CD" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("              SAQ_MON_DIR_CONV DIR" ).append("\n"); 
		query.append("          WHERE" ).append("\n"); 
		query.append("                 DIR.BSE_YR = @[year]" ).append("\n"); 
		query.append("             AND DIR.BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("             AND DIR.TRD_CD = @[trade]" ).append("\n"); 
		query.append("             AND DIR.CONV_DIR_CD = @[dirCd]" ).append("\n"); 
		query.append("          ) DIR" ).append("\n"); 
		query.append("     WHERE" ).append("\n"); 
		query.append("             DIR.RLANE_CD(+) = SMR.RLANE_CD" ).append("\n"); 
		query.append(" ORDER BY KEY, SLEVEL, ROW_SEQ" ).append("\n"); 

	}
}