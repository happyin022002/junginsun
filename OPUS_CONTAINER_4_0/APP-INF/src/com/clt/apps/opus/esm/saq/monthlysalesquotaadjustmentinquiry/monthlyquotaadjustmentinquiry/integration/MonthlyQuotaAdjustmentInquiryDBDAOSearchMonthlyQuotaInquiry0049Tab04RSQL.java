/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab04RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
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

public class MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab04RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane/Area Director/C.Office - Quota Total
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab04RSQL(){
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
		params.put("tgtOrzCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mstVersion",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentInquiryDBDAOSearchMonthlyQuotaInquiry0049Tab04RSQL").append("\n"); 
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
		query.append("		    (SELECT DISTINCT  " ).append("\n"); 
		query.append("		        @[datCreStepCd] AS DAT_CRE_STEP_CD,  " ).append("\n"); 
		query.append("		        @[tgtOrzCd] AS TGT_ORZ_CD,  " ).append("\n"); 
		query.append("		        '2' AS DAT_CRE_LVL_CD,  " ).append("\n"); 
		query.append("		        @[year] AS BSE_YR," ).append("\n"); 
		query.append("		        @[bse_quarter] AS BSE_QTR_CD," ).append("\n"); 
		query.append("		        @[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10') AS YRMON_01," ).append("\n"); 
		query.append("		        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), 1), 'YYYYMM') AS YRMON_02," ).append("\n"); 
		query.append("		        TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), 2), 'YYYYMM') AS YRMON_03,		" ).append("\n"); 
		query.append("		        @[targetGrp] AS SAQ_TGT_GRP_CD," ).append("\n"); 
		query.append("		        @[mstVersion] AS QTA_MST_VER_NO,	" ).append("\n"); 
		query.append("		        @[version] AS GLINE_VER_NO,		" ).append("\n"); 
		query.append("		        @[trade] AS TRD_CD," ).append("\n"); 
		query.append("		        @[dirCd] AS DIR_CD," ).append("\n"); 
		query.append("		        @[subTrade] AS SUB_TRD_CD, " ).append("\n"); 
		query.append("		        (SELECT N2ND_PRNT_OFC_CD  " ).append("\n"); 
		query.append("		         FROM   SAQ_ORGANIZATION_V  " ).append("\n"); 
		query.append("		         WHERE  OFC_CD = @[rhqCd]) AS RHQ_CD,  " ).append("\n"); 
		query.append("		        @[rhqCd] AS AQ_CD   		" ).append("\n"); 
		query.append("		     FROM   DUAL)  " ).append("\n"); 
		query.append("		    ,SAQ_MON_QTA_ADJ_SMRY_HDR_VIEW AS " ).append("\n"); 
		query.append("		    ( " ).append("\n"); 
		query.append("		       SELECT DISTINCT HDR.SAQ_TGT_GRP_CD,HDR.DAT_CRE_STEP_CD,HDR.TGT_ORZ_CD,HDR.BSE_YR,HDR.BSE_QTR_CD,HDR.GLINE_VER_NO,HDR.TRD_CD,HDR.DIR_CD  " ).append("\n"); 
		query.append("		        FROM SAQ_MON_QTA_ADJ_SMRY_HDR HDR  " ).append("\n"); 
		query.append("		           , TMP_INPUT_PARAMS INP   " ).append("\n"); 
		query.append("		        WHERE HDR.DAT_CRE_STEP_CD = INP.DAT_CRE_STEP_CD     " ).append("\n"); 
		query.append("		              AND HDR.TGT_ORZ_CD = INP.TGT_ORZ_CD   " ).append("\n"); 
		query.append("		              AND HDR.BSE_YR = INP.BSE_YR   " ).append("\n"); 
		query.append("		              AND HDR.BSE_QTR_CD = INP.BSE_QTR_CD   " ).append("\n"); 
		query.append("		              AND HDR.GLINE_VER_NO = INP.GLINE_VER_NO   " ).append("\n"); 
		query.append("		              AND HDR.SAQ_TGT_GRP_CD = INP.SAQ_TGT_GRP_CD   " ).append("\n"); 
		query.append("		              AND HDR.TRD_CD LIKE INP.TRD_CD||'%'   " ).append("\n"); 
		query.append("		              AND HDR.DIR_CD LIKE INP.DIR_CD||'%'     " ).append("\n"); 
		query.append("		    ) 			" ).append("\n"); 
		query.append("		    ,TEMP_SMR AS" ).append("\n"); 
		query.append("		    (SELECT " ).append("\n"); 
		query.append("		         DISTINCT" ).append("\n"); 
		query.append("		         SMR.VSL_CD," ).append("\n"); 
		query.append("		         SMR.SKD_VOY_NO," ).append("\n"); 
		query.append("		         SMR.SKD_DIR_CD,		" ).append("\n"); 
		query.append("		         SMR.TRD_CD,    " ).append("\n"); 
		query.append("		         SMR.DIR_CD, " ).append("\n"); 
		query.append("		         SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("		         SMR.RLANE_CD,  " ).append("\n"); 
		query.append("		         SMR.BSE_MON" ).append("\n"); 
		query.append("		    FROM SAQ_MON_QTA_ADJ_SMRY_HDR_VIEW HDR " ).append("\n"); 
		query.append("		         , SAQ_MON_QTA_ADJ_SMRY SMR  " ).append("\n"); 
		query.append("		         , TMP_INPUT_PARAMS INP   " ).append("\n"); 
		query.append("		    WHERE " ).append("\n"); 
		query.append("		        HDR.DAT_CRE_STEP_CD = INP.DAT_CRE_STEP_CD    " ).append("\n"); 
		query.append("		       AND HDR.TGT_ORZ_CD = INP.TGT_ORZ_CD  		" ).append("\n"); 
		query.append("		       AND SMR.DAT_CRE_LVL_CD >= INP.DAT_CRE_LVL_CD     	" ).append("\n"); 
		query.append("		       AND HDR.BSE_YR = INP.BSE_YR  " ).append("\n"); 
		query.append("		       AND HDR.BSE_QTR_CD = INP.BSE_QTR_CD  " ).append("\n"); 
		query.append("		       AND HDR.GLINE_VER_NO = INP.GLINE_VER_NO  " ).append("\n"); 
		query.append("		       AND HDR.TRD_CD LIKE INP.TRD_CD||'%'  " ).append("\n"); 
		query.append("		       AND HDR.DIR_CD LIKE INP.DIR_CD||'%'  " ).append("\n"); 
		query.append("		       AND SMR.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${isRhq} == 'false') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				AND     NVL(SMR.AQ_CD, '  ') LIKE INP.AQ_CD||'%'   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		       AND SMR.RHQ_CD LIKE INP.RHQ_CD||'%'   " ).append("\n"); 
		query.append("		       AND SMR.BSE_YR = HDR.BSE_YR " ).append("\n"); 
		query.append("		       AND SMR.BSE_QTR_CD = HDR.BSE_QTR_CD " ).append("\n"); 
		query.append("		       AND SMR.SAQ_TGT_GRP_CD = HDR.SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("		       AND SMR.GLINE_VER_NO = HDR.GLINE_VER_NO " ).append("\n"); 
		query.append("		       AND SMR.TRD_CD = HDR.TRD_CD " ).append("\n"); 
		query.append("		       AND SMR.DIR_CD = HDR.DIR_CD " ).append("\n"); 
		query.append("		       AND SMR.DAT_CRE_STEP_CD = '03' " ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		    ,VVD AS " ).append("\n"); 
		query.append("		    (SELECT " ).append("\n"); 
		query.append("		            VVD.VSL_CD," ).append("\n"); 
		query.append("		            VVD.SKD_VOY_NO," ).append("\n"); 
		query.append("		            VVD.SKD_DIR_CD,		" ).append("\n"); 
		query.append("		            VVD.TRD_CD, " ).append("\n"); 
		query.append("		            VVD.DIR_CD, " ).append("\n"); 
		query.append("		            VVD.SUB_TRD_CD, " ).append("\n"); 
		query.append("		            VVD.RLANE_CD, " ).append("\n"); 
		query.append("		            VVD.BSE_YR||VVD.BSE_MON AS YRMON, " ).append("\n"); 
		query.append("		            SUM(VVD.FNL_BSA_CAPA) AS BSA, " ).append("\n"); 
		query.append("		            COUNT(*) AS VOYAGE " ).append("\n"); 
		query.append("		     FROM   SAQ_MON_TGT_VVD_ADJ VVD" ).append("\n"); 
		query.append("		            JOIN " ).append("\n"); 
		query.append("		            TMP_INPUT_PARAMS INP" ).append("\n"); 
		query.append("		            ON" ).append("\n"); 
		query.append("		            ( " ).append("\n"); 
		query.append("		                VVD.BSE_YR = INP.BSE_YR AND  " ).append("\n"); 
		query.append("		                VVD.BSE_QTR_CD = INP.BSE_QTR_CD AND  " ).append("\n"); 
		query.append("		                VVD.GLINE_VER_NO = INP.GLINE_VER_NO AND  " ).append("\n"); 
		query.append("		                VVD.TRD_CD = INP.TRD_CD AND  " ).append("\n"); 
		query.append("		                VVD.DIR_CD = INP.DIR_CD AND " ).append("\n"); 
		query.append("		                VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%' " ).append("\n"); 
		query.append("		            )" ).append("\n"); 
		query.append("		            JOIN" ).append("\n"); 
		query.append("		            TEMP_SMR SMR" ).append("\n"); 
		query.append("		            ON" ).append("\n"); 
		query.append("		            (" ).append("\n"); 
		query.append("		               SMR.VSL_CD = VVD.VSL_CD AND" ).append("\n"); 
		query.append("		               SMR.SKD_VOY_NO = VVD.SKD_VOY_NO AND" ).append("\n"); 
		query.append("		               SMR.SKD_DIR_CD = VVD.SKD_DIR_CD AND		" ).append("\n"); 
		query.append("		               SMR.TRD_CD = VVD.TRD_CD AND" ).append("\n"); 
		query.append("		               SMR.DIR_CD = VVD.DIR_CD AND" ).append("\n"); 
		query.append("		               SMR.SUB_TRD_CD = VVD.SUB_TRD_CD AND" ).append("\n"); 
		query.append("		               SMR.RLANE_CD = VVD.RLANE_CD AND" ).append("\n"); 
		query.append("		               SMR.BSE_MON = VVD.BSE_MON" ).append("\n"); 
		query.append("		            )               " ).append("\n"); 
		query.append("		     GROUP BY VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD,VVD.TRD_CD, VVD.DIR_CD, VVD.SUB_TRD_CD, VVD.RLANE_CD, VVD.BSE_YR||VVD.BSE_MON) " ).append("\n"); 
		query.append("		SELECT  " ).append("\n"); 
		query.append("		    KEY,  " ).append("\n"); 
		query.append("		    SLEVEL," ).append("\n"); 
		query.append("		    SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("		    DECODE(DIR.CONV_DIR_CD,'',SMR.RLANE_CD,SMR.RLANE_CD||' - '||DIR.DIR_CD) RLANE_CD, " ).append("\n"); 
		query.append("		    DIR.DIR_CD CONV_DIR_CD, " ).append("\n"); 
		query.append("		    RHQ_CD,  " ).append("\n"); 
		query.append("		    AQ_CD,  " ).append("\n"); 
		query.append("		    OFC_CD_1, " ).append("\n"); 
		query.append("		    CASE" ).append("\n"); 
		query.append("		      WHEN SLEVEL = 5 THEN 'TOTAL'" ).append("\n"); 
		query.append("		      ELSE ''" ).append("\n"); 
		query.append("		    END OFC_CD_2, " ).append("\n"); 
		query.append("		    ROW_SEQ,  " ).append("\n"); 
		query.append("		    REPLACE(ITEM, '(P)', '') AS ITEM_TEXT, " ).append("\n"); 
		query.append("		    REPLACE(ITEM, '(P)', '') AS ITEM, " ).append("\n"); 
		query.append("		    VAL_00,   " ).append("\n"); 
		query.append("		    VAL_01,   " ).append("\n"); 
		query.append("		    VAL_02,   " ).append("\n"); 
		query.append("		    VAL_03" ).append("\n"); 
		query.append("		FROM  (  " ).append("\n"); 
		query.append("		    SELECT  " ).append("\n"); 
		query.append("		          MIN(KEY) AS KEY,  " ).append("\n"); 
		query.append("		          SLEVEL,  " ).append("\n"); 
		query.append("		          SMR.SUB_TRD_CD,  " ).append("\n"); 
		query.append("		          CASE SLEVEL" ).append("\n"); 
		query.append("		             WHEN 1 THEN 'TOTAL'" ).append("\n"); 
		query.append("		             ELSE SMR.RLANE_CD" ).append("\n"); 
		query.append("		          END RLANE_CD,             " ).append("\n"); 
		query.append("		          CASE SLEVEL" ).append("\n"); 
		query.append("		             WHEN 1 THEN ''" ).append("\n"); 
		query.append("		             WHEN 2 THEN 'TOTAL'" ).append("\n"); 
		query.append("		             ELSE SMR.RHQ_CD" ).append("\n"); 
		query.append("		          END RHQ_CD,            " ).append("\n"); 
		query.append("		          CASE SLEVEL" ).append("\n"); 
		query.append("		             WHEN 1 THEN ''" ).append("\n"); 
		query.append("		             WHEN 2 THEN ''" ).append("\n"); 
		query.append("		             WHEN 3 THEN 'TOTAL'" ).append("\n"); 
		query.append("		             ELSE SMR.AQ_CD" ).append("\n"); 
		query.append("		          END AQ_CD,  " ).append("\n"); 
		query.append("		          CASE SLEVEL" ).append("\n"); 
		query.append("		             WHEN 1 THEN ''" ).append("\n"); 
		query.append("		             WHEN 2 THEN ''" ).append("\n"); 
		query.append("		             WHEN 3 THEN ''" ).append("\n"); 
		query.append("		             WHEN 4 THEN 'TOTAL'" ).append("\n"); 
		query.append("		             ELSE SMR.OFC_CD" ).append("\n"); 
		query.append("		          END OFC_CD_1,                    " ).append("\n"); 
		query.append("		          ITM.ROW_SEQ,  " ).append("\n"); 
		query.append("		          ITM.TEXT,  " ).append("\n"); 
		query.append("		          CASE  " ).append("\n"); 
		query.append("		             WHEN ITM.CODE IN('05', '07', '08', '11', '12') THEN ITM.TEXT || '*'  " ).append("\n"); 
		query.append("		             ELSE ITM.TEXT  " ).append("\n"); 
		query.append("		          END ITEM,  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  NVL(DECODE( ITM.CODE,  '01', SUM(BSA),                     			" ).append("\n"); 
		query.append("			                 '02', SUM(VOYAGE),                           			" ).append("\n"); 
		query.append("			                 '03', SUM(SMR.LOD),                                 		" ).append("\n"); 
		query.append("			                 '04', DECODE(SUM(BSA), 0, 0, SUM(SMR.LOD)/SUM(BSA)*100),   " ).append("\n"); 
		query.append("			                 '05', SUM(SMR.REV),                                 		" ).append("\n"); 
		query.append("			                 '06', DECODE(SUM(LOD),0,0,SUM(REV)/SUM(LOD)*1000),                       " ).append("\n"); 
		query.append("			                 '07', SUM(SMR.CM),                                  		" ).append("\n"); 
		query.append("			                 '08', SUM(SMR.RA_CM),                               		" ).append("\n"); 
		query.append("			                 '09', DECODE(SUM(LOD),0,0,SUM(CM)*1000/SUM(LOD)),                        " ).append("\n"); 
		query.append("			                 '10', DECODE(SUM(LOD),0,0,SUM(RA_CM)*1000/SUM(LOD)),                     " ).append("\n"); 
		query.append("			                 '11', SUM(SMR.OP),                                  		" ).append("\n"); 
		query.append("			                 '12', SUM(SMR.RA_OP),                               		" ).append("\n"); 
		query.append("			                 '13', DECODE(SUM(LOD),0,0,SUM(OP)*1000/SUM(LOD)),                        " ).append("\n"); 
		query.append("			                 '14', DECODE(SUM(LOD),0,0,SUM(RA_OP)*1000/SUM(LOD) )), 0) AS VAL_00	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#foreach( $key in ${term}) " ).append("\n"); 
		query.append("			    ,NVL(SUM(DECODE(SMR.YRMON,    INP.YRMON_$key,              		" ).append("\n"); 
		query.append("			        DECODE( ITM.CODE,  '01', (BSA),                     			" ).append("\n"); 
		query.append("			                 '02', (VOYAGE),                           			" ).append("\n"); 
		query.append("			                 '03', (SMR.LOD),                               		" ).append("\n"); 
		query.append("			                 '04', DECODE(BSA, 0, 0, (SMR.LOD)/(BSA)*100),       " ).append("\n"); 
		query.append("			                 '05', (SMR.REV),                                 		" ).append("\n"); 
		query.append("			                 '06', DECODE(LOD,0,0,(REV)/(LOD)*1000),                       " ).append("\n"); 
		query.append("			                 '07', (SMR.CM),                                  		" ).append("\n"); 
		query.append("			                 '08', (SMR.RA_CM),                               		" ).append("\n"); 
		query.append("			                 '09', DECODE(LOD,0,0,(CM)*1000/(LOD)),                        " ).append("\n"); 
		query.append("			                 '10', DECODE(LOD,0,0,(RA_CM)*1000/(LOD)),                     " ).append("\n"); 
		query.append("			                 '11', (SMR.OP),                                  		" ).append("\n"); 
		query.append("			                 '12', (SMR.RA_OP),                               		" ).append("\n"); 
		query.append("			                 '13', DECODE(LOD,0,0,(OP)*1000/(LOD)),                        " ).append("\n"); 
		query.append("			                 '14', DECODE(LOD,0,0,(RA_OP)*1000/(LOD)) ))), 0) AS val_$key" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #end		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    FROM  (  " ).append("\n"); 
		query.append("		            SELECT" ).append("\n"); 
		query.append("		                  KEY," ).append("\n"); 
		query.append("		                  CASE G_FLAG" ).append("\n"); 
		query.append("		                     WHEN '01111' THEN 1" ).append("\n"); 
		query.append("		                     WHEN '00111' THEN 2" ).append("\n"); 
		query.append("		                     WHEN '00011' THEN 3" ).append("\n"); 
		query.append("		                     WHEN '00001' THEN 4" ).append("\n"); 
		query.append("		                     WHEN '00000' THEN 5" ).append("\n"); 
		query.append("		                  END SLEVEL,                    " ).append("\n"); 
		query.append("		                  SMR.SUB_TRD_CD," ).append("\n"); 
		query.append("		                  RLANE_CD," ).append("\n"); 
		query.append("		                  RHQ_CD," ).append("\n"); 
		query.append("		                  AQ_CD," ).append("\n"); 
		query.append("		                  OFC_CD," ).append("\n"); 
		query.append("		                  YRMON," ).append("\n"); 
		query.append("		                  0 AS BSA," ).append("\n"); 
		query.append("		                  VOYAGE," ).append("\n"); 
		query.append("		                  LOD," ).append("\n"); 
		query.append("		                  REV," ).append("\n"); 
		query.append("		                  CM," ).append("\n"); 
		query.append("		                  RA_CM," ).append("\n"); 
		query.append("		                  OP," ).append("\n"); 
		query.append("		                  RA_OP             " ).append("\n"); 
		query.append("		            FROM  (" ).append("\n"); 
		query.append("		                    SELECT" ).append("\n"); 
		query.append("		                          G_FLAG," ).append("\n"); 
		query.append("		                          KEY," ).append("\n"); 
		query.append("		                          SUB_TRD_CD," ).append("\n"); 
		query.append("		                          RLANE_CD," ).append("\n"); 
		query.append("		                          RHQ_CD," ).append("\n"); 
		query.append("		                          AQ_CD," ).append("\n"); 
		query.append("		                          OFC_CD," ).append("\n"); 
		query.append("		                          YRMON, " ).append("\n"); 
		query.append("		                          VOYAGE," ).append("\n"); 
		query.append("		                          LOD," ).append("\n"); 
		query.append("		                          REV," ).append("\n"); 
		query.append("		                          CM," ).append("\n"); 
		query.append("		                          RA_CM," ).append("\n"); 
		query.append("		                          OP," ).append("\n"); 
		query.append("		                          RA_OP                    " ).append("\n"); 
		query.append("		                    FROM  (" ).append("\n"); 
		query.append("		                            SELECT" ).append("\n"); 
		query.append("		                                 GROUPING(SUB_TRD_CD)||GROUPING(RLANE_CD)||GROUPING(RHQ_CD)||GROUPING(AQ_CD)||GROUPING(OFC_CD)AS G_FLAG," ).append("\n"); 
		query.append("		                                 MIN(SMR.SUB_TRD_CD||DECODE(SMR.RLANE_CD,'RBCCO','ZZ',SUBSTR(SMR.RLANE_CD,-2))||SMR.RLANE_CD||SMR.RHQ_CD||SMR.AQ_CD||SMR.OFC_CD) AS KEY," ).append("\n"); 
		query.append("		                                 SMR.SUB_TRD_CD,  " ).append("\n"); 
		query.append("		                                 SMR.RLANE_CD,  " ).append("\n"); 
		query.append("		                                 SMR.RHQ_CD,  " ).append("\n"); 
		query.append("		                                 SMR.AQ_CD," ).append("\n"); 
		query.append("		                                 SMR.OFC_CD,  " ).append("\n"); 
		query.append("		                                 SMR.YRMON,    " ).append("\n"); 
		query.append("		                                 COUNT(DISTINCT VVD_CD) VOYAGE,    " ).append("\n"); 
		query.append("		                                 SUM(LOD) AS LOD," ).append("\n"); 
		query.append("		                                 SUM(REV) AS REV," ).append("\n"); 
		query.append("		                                 SUM(CM) AS CM," ).append("\n"); 
		query.append("		                                 SUM(RA_CM) AS RA_CM," ).append("\n"); 
		query.append("		                                 SUM(OP) AS OP," ).append("\n"); 
		query.append("		                                 SUM(RA_OP) AS RA_OP" ).append("\n"); 
		query.append("		                            FROM     (    " ).append("\n"); 
		query.append("		                                        SELECT  " ).append("\n"); 
		query.append("		                                             SMR.SUB_TRD_CD, " ).append("\n"); 
		query.append("		                                             SMR.RLANE_CD, " ).append("\n"); 
		query.append("		                                             SMR.RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("		                                             NVL(SMR.AQ_CD, '  ') AS AQ_CD, " ).append("\n"); 
		query.append("		                                             SMR.RGN_OFC_CD AS OFC_CD, " ).append("\n"); 
		query.append("		                                             SMR.BSE_YR||SMR.BSE_MON AS YRMON," ).append("\n"); 
		query.append("		                                             VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD  VVD_CD,	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							SUM(SMR.LOD_QTY) AS LOD, " ).append("\n"); 
		query.append("							SUM(SMR.GRS_RPB_REV*SMR.LOD_QTY)/1000 AS REV,  " ).append("\n"); 
		query.append("							SUM((SMR.GRS_RPB_REV-SMR.CM_UC_AMT)*SMR.LOD_QTY)/1000 AS CM, " ).append("\n"); 
		query.append("							SUM((SMR.GRS_RPB_REV-SMR.RA_CM_UC_AMT)*SMR.LOD_QTY)/1000 AS RA_CM,  " ).append("\n"); 
		query.append("							SUM((SMR.GRS_RPB_REV-SMR.OPFIT_UC_AMT)*SMR.LOD_QTY)/1000 AS OP, " ).append("\n"); 
		query.append("							SUM((SMR.GRS_RPB_REV-SMR.RA_OPFIT_UC_AMT)*SMR.LOD_QTY )/1000 AS RA_OP 			" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		                                        FROM SAQ_MON_QTA_ADJ_SMRY_HDR_VIEW HDR " ).append("\n"); 
		query.append("		                                             , SAQ_MON_QTA_ADJ_SMRY SMR  " ).append("\n"); 
		query.append("		                                             , TMP_INPUT_PARAMS INP   " ).append("\n"); 
		query.append("		                                             , VVD    " ).append("\n"); 
		query.append("		                                        WHERE " ).append("\n"); 
		query.append("		                                            HDR.DAT_CRE_STEP_CD = INP.DAT_CRE_STEP_CD    " ).append("\n"); 
		query.append("		                                           AND HDR.TGT_ORZ_CD = INP.TGT_ORZ_CD  		" ).append("\n"); 
		query.append("		                                           AND SMR.DAT_CRE_LVL_CD >= INP.DAT_CRE_LVL_CD     	" ).append("\n"); 
		query.append("		                                           AND HDR.BSE_YR = INP.BSE_YR  " ).append("\n"); 
		query.append("		                                           AND HDR.BSE_QTR_CD = INP.BSE_QTR_CD  " ).append("\n"); 
		query.append("		                                           AND HDR.GLINE_VER_NO = INP.GLINE_VER_NO  " ).append("\n"); 
		query.append("		                                           AND HDR.TRD_CD LIKE INP.TRD_CD||'%'  " ).append("\n"); 
		query.append("		                                           AND HDR.DIR_CD LIKE INP.DIR_CD||'%'  " ).append("\n"); 
		query.append("		                                           AND SMR.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'  " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if (${isRhq} == 'false') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							AND     NVL(SMR.AQ_CD, '  ') LIKE INP.AQ_CD||'%'   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		                                           AND SMR.RHQ_CD LIKE INP.RHQ_CD||'%'   " ).append("\n"); 
		query.append("		                                           AND SMR.BSE_YR = HDR.BSE_YR " ).append("\n"); 
		query.append("		                                           AND SMR.BSE_QTR_CD = HDR.BSE_QTR_CD " ).append("\n"); 
		query.append("		                                           AND SMR.SAQ_TGT_GRP_CD = HDR.SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("		                                           AND SMR.GLINE_VER_NO = HDR.GLINE_VER_NO " ).append("\n"); 
		query.append("		                                           AND SMR.TRD_CD = HDR.TRD_CD " ).append("\n"); 
		query.append("		                                           AND SMR.DIR_CD = HDR.DIR_CD " ).append("\n"); 
		query.append("		                                           AND SMR.DAT_CRE_STEP_CD = '03'		" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		                                           AND SMR.TRD_CD = VVD.TRD_CD " ).append("\n"); 
		query.append("		                                           AND SMR.DIR_CD = VVD.DIR_CD " ).append("\n"); 
		query.append("		                                           AND SMR.RLANE_CD = VVD.RLANE_CD " ).append("\n"); 
		query.append("		              							  AND SMR.SUB_TRD_CD = VVD.SUB_TRD_CD   " ).append("\n"); 
		query.append("		              							  AND SMR.BSE_YR||SMR.BSE_MON = VVD.YRMON  " ).append("\n"); 
		query.append("		                                           AND SMR.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("		                                           AND SMR.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("		                                           AND SMR.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		                                        GROUP BY SMR.SUB_TRD_CD,SMR.RLANE_CD, SMR.RHQ_CD, NVL(SMR.AQ_CD, '  '), SMR.RGN_OFC_CD, SMR.BSE_YR||SMR.BSE_MON,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("		                                     ) SMR " ).append("\n"); 
		query.append("		                            GROUP BY GROUPING SETS((SMR.YRMON,SMR.SUB_TRD_CD),  " ).append("\n"); 
		query.append("		                                                    (SMR.YRMON,SMR.SUB_TRD_CD,SMR.RLANE_CD),  " ).append("\n"); 
		query.append("		                                                    (SMR.YRMON,SMR.SUB_TRD_CD,SMR.RLANE_CD, SMR.RHQ_CD),  " ).append("\n"); 
		query.append("		                                                    (SMR.YRMON,SMR.SUB_TRD_CD,SMR.RLANE_CD, SMR.RHQ_CD, SMR.AQ_CD)," ).append("\n"); 
		query.append("		                                                    (SMR.YRMON,SMR.SUB_TRD_CD,SMR.RLANE_CD, SMR.RHQ_CD, SMR.AQ_CD, SMR.OFC_CD))     " ).append("\n"); 
		query.append("		                          ) SMR     " ).append("\n"); 
		query.append("		                  ) SMR                                                                     " ).append("\n"); 
		query.append("		          ) SMR  " ).append("\n"); 
		query.append("		          JOIN  " ).append("\n"); 
		query.append("		          (  " ).append("\n"); 
		query.append("		            SELECT  INTG_CD_VAL_CTNT AS CODE,  " ).append("\n"); 
		query.append("		                    INTG_CD_VAL_DP_DESC AS TEXT,  " ).append("\n"); 
		query.append("		                    INTG_CD_VAL_DP_SEQ AS ROW_SEQ  " ).append("\n"); 
		query.append("		            FROM  COM_INTG_CD_DTL  " ).append("\n"); 
		query.append("		            WHERE INTG_CD_ID = 'CD01390'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			    AND ('ALL' = @[item]  OR (INTG_CD_VAL_DP_DESC IN (" ).append("\n"); 
		query.append("					  #foreach( $key in ${itemAr}) " ).append("\n"); 
		query.append("					      '$key'," ).append("\n"); 
		query.append("					  #end" ).append("\n"); 
		query.append("					  'X'" ).append("\n"); 
		query.append("			     )) ) ) itm " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		          ON 1 = 1   " ).append("\n"); 
		query.append("		          JOIN " ).append("\n"); 
		query.append("		          TMP_INPUT_PARAMS INP " ).append("\n"); 
		query.append("		          ON 1 = 1            " ).append("\n"); 
		query.append("		      GROUP BY SMR.SLEVEL, SMR.SUB_TRD_CD,SMR.RLANE_CD, SMR.RHQ_CD, SMR.AQ_CD, SMR.OFC_CD, ITM.ROW_SEQ, ITM.TEXT, ITM.CODE   " ).append("\n"); 
		query.append("		      ) SMR  " ).append("\n"); 
		query.append("		    ,     (                                                                                          " ).append("\n"); 
		query.append("		          SELECT                                                                                    " ).append("\n"); 
		query.append("		              DIR.RLANE_CD,                                                                                " ).append("\n"); 
		query.append("		              DIR.DIR_CD,							" ).append("\n"); 
		query.append("		              DIR.CONV_DIR_CD                                                                                " ).append("\n"); 
		query.append("		          FROM                                                                                    " ).append("\n"); 
		query.append("		              SAQ_MON_DIR_CONV DIR                                                                                " ).append("\n"); 
		query.append("		          WHERE                                                                                    " ).append("\n"); 
		query.append("		                   DIR.BSE_YR = @[year]                                                                         " ).append("\n"); 
		query.append("		             AND DIR.BSE_QTR_CD =  @[bse_quarter]                                                                              " ).append("\n"); 
		query.append("		             AND DIR.TRD_CD =  @[trade]                                         " ).append("\n"); 
		query.append("		             AND DIR.CONV_DIR_CD = @[dirCd]                                         " ).append("\n"); 
		query.append("		          ) DIR                                                                                 " ).append("\n"); 
		query.append("		     WHERE                                                                                 " ).append("\n"); 
		query.append("		             DIR.RLANE_CD(+) = SMR.RLANE_CD 					" ).append("\n"); 
		query.append("--		         AND    DIR.CONV_DIR_CD(+) = SMR.DIR_CD							" ).append("\n"); 
		query.append("		ORDER BY KEY, SLEVEL, ROW_SEQ" ).append("\n"); 

	}
}