/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab10RSQL.java
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

public class MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab10RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기별별 확정된 내용을 Week, Sub Trade, Lane, VVD Group, VVD 별로 Grouping 된 형태로 조회 한다. (주요 table saq_mon_cfm_qta, saq_mon_cfm_tgt_vvd)
	  * </pre>
	  */
	public MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab10RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("selType",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab10RSQL").append("\n"); 
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
		query.append("WITH PARAMS AS ( " ).append("\n"); 
		query.append(" 	SELECT @[ofcCd] OFC_CD, @[year] BSE_YR, @[quarter] BSE_QTR_CD , @[version] VER, @[targetGrp] SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		, TO_CHAR(ADD_MONTHS(TO_DATE(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		,'MM'),0),'MM') MON_0 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		, TO_CHAR(ADD_MONTHS(TO_DATE(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        ,'MM'),1),'MM') MON_1 		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 		, TO_CHAR(ADD_MONTHS(TO_DATE(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${month} < 10) " ).append("\n"); 
		query.append("		'0'||@[month]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		@[month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("		,'MM'),2),'MM') MON_2 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	FROM DUAL " ).append("\n"); 
		query.append(" )  , " ).append("\n"); 
		query.append("  VVD_VIEW AS (  " ).append("\n"); 
		query.append("    SELECT VVD.SKD_VOY_NO,VVD.VSL_CD,VVD.SKD_DIR_CD,QTA.RHQ_CD, NVL(QTA.AQ_CD,'000000') AQ_CD,QTA.RGN_OFC_CD, GRP_TRD.SAQ_TGT_GRP_CD ,VVD.BSE_MON  " ).append("\n"); 
		query.append("    FROM SAQ_MON_CFM_TGT_VVD VVD   " ).append("\n"); 
		query.append("      , SAQ_MON_CFM_QTA QTA  " ).append("\n"); 
		query.append("      , SAQ_TGT_GRP_TRD GRP_TRD  " ).append("\n"); 
		query.append("    WHERE QTA.MQTA_RLSE_VER_NO = VVD.MQTA_RLSE_VER_NO  " ).append("\n"); 
		query.append("      AND QTA.BSE_YR = VVD.BSE_YR  " ).append("\n"); 
		query.append("      AND QTA.BSE_QTR_CD = VVD.BSE_QTR_CD  " ).append("\n"); 
		query.append("      AND QTA.BSE_MON = VVD.BSE_MON  " ).append("\n"); 
		query.append("      AND QTA.TRD_CD = VVD.TRD_CD  " ).append("\n"); 
		query.append("      AND QTA.RLANE_CD = VVD.RLANE_CD  " ).append("\n"); 
		query.append("      AND QTA.DIR_CD = VVD.DIR_CD  " ).append("\n"); 
		query.append("      AND QTA.VSL_CD = VVD.VSL_CD  " ).append("\n"); 
		query.append("      AND QTA.SKD_VOY_NO = VVD.SKD_VOY_NO  " ).append("\n"); 
		query.append("      AND QTA.SKD_DIR_CD = VVD.SKD_DIR_CD  " ).append("\n"); 
		query.append("      AND QTA.QTA_TGT_CD = @[selType]  " ).append("\n"); 
		query.append("      AND QTA.TRD_CD = GRP_TRD.TRD_CD  " ).append("\n"); 
		query.append("      AND VVD.SUB_TRD_CD = GRP_TRD.SUB_TRD_CD  " ).append("\n"); 
		query.append("      AND QTA.DIR_CD = GRP_TRD.DIR_CD  " ).append("\n"); 
		query.append("      AND ( QTA.RGN_OFC_CD,QTA.BSE_YR,QTA.BSE_QTR_CD,QTA.MQTA_RLSE_VER_NO )   " ).append("\n"); 
		query.append("      = ( SELECT  OFC_CD , BSE_YR, BSE_QTR_CD,VER  FROM PARAMS )  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  ),  " ).append("\n"); 
		query.append("  ITEM_VIEW AS (  " ).append("\n"); 
		query.append("    SELECT  INTG_CD_VAL_CTNT AS CODE,   " ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_DESC AS TEXT,   " ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_SEQ AS ROW_SEQ ,  " ).append("\n"); 
		query.append("            0 AS GRP  " ).append("\n"); 
		query.append("          FROM  COM_INTG_CD_DTL   " ).append("\n"); 
		query.append("          WHERE INTG_CD_ID = 'CD01388' --  1탭: CD01388, 2탭 : CD01061" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT NOT IN ('12','14')  --CM/CMPB을 추가하기 위해서 07,09 을 제외하였음 " ).append("\n"); 
		query.append("  )  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("   SELECT VAL.BSE_YR,VAL.BSE_QTR_CD,VAL.AQ_CD,VAL.SAQ_TGT_GRP_CD,VAL.TRD_CD,VAL.DIR_CD" ).append("\n"); 
		query.append("          ,DECODE(ITM.TEXT,'G.REV','G.REV*','CM(P)','CM*','CMPB(P)','CMPB',ITM.TEXT) AS TEXT ,ITM.CODE  " ).append("\n"); 
		query.append("          ,GRP_CD, GRP_AQ_CD,GRP_SAQ_TGT_GRP_CD,GRP_TRD_CD,GRP_DIR_CD     " ).append("\n"); 
		query.append("    , NVL(DECODE(ITM.CODE,  " ).append("\n"); 
		query.append("       '02', SUM(DECODE(BSE_MON,P.MON_0, VAL.VOYAGE,0)),                                   " ).append("\n"); 
		query.append("       '03', SUM(DECODE(BSE_MON,P.MON_0,VAL.LOD,0)),                                         " ).append("\n"); 
		query.append("       '05', SUM(DECODE(BSE_MON,P.MON_0,VAL.REV,0))/1000,                                       " ).append("\n"); 
		query.append("       '06', DECODE(NVL(SUM(DECODE(BSE_MON,P.MON_0,VAL.LOD,0)),0), 0, 0, SUM(DECODE(BSE_MON,P.MON_0,VAL.REV,0))/SUM(DECODE(BSE_MON,P.MON_0,VAL.LOD,0))), --수정" ).append("\n"); 
		query.append("       '07', SUM(DECODE(BSE_MON,P.MON_0,VAL.CM,0))/1000,                                        " ).append("\n"); 
		query.append("       '09', SUM(DECODE(BSE_MON,P.MON_0,DECODE(NVL(VAL.LOD,0),0,0,VAL.CM/(VAL.LOD)),0))), 0)  AS CAL_VAL_01    --수정" ).append("\n"); 
		query.append("    , NVL(DECODE(ITM.CODE,  " ).append("\n"); 
		query.append("       '02', SUM(DECODE(BSE_MON,P.MON_1, VAL.VOYAGE,0)),                                   " ).append("\n"); 
		query.append("       '03', SUM(DECODE(BSE_MON,P.MON_1,VAL.LOD,0)),                                         " ).append("\n"); 
		query.append("       '05', SUM(DECODE(BSE_MON,P.MON_1,VAL.REV,0))/1000,                                       " ).append("\n"); 
		query.append("       '06', DECODE(NVL(SUM(DECODE(BSE_MON,P.MON_1,VAL.LOD,0)),0), 0, 0, SUM(DECODE(BSE_MON,P.MON_1,VAL.REV,0))/SUM(DECODE(BSE_MON,P.MON_1,VAL.LOD,0))), --수정" ).append("\n"); 
		query.append("       '07', SUM(DECODE(BSE_MON,P.MON_1,VAL.CM,0))/1000,                                        " ).append("\n"); 
		query.append("       '09', SUM(DECODE(BSE_MON,P.MON_1,DECODE(NVL(VAL.LOD,0),0,0,VAL.CM/(VAL.LOD)),0))), 0) AS CAL_VAL_02    --수정" ).append("\n"); 
		query.append("    , NVL(DECODE(ITM.CODE,  " ).append("\n"); 
		query.append("       '02', SUM(DECODE(BSE_MON,P.MON_2, VAL.VOYAGE,0)),                                   " ).append("\n"); 
		query.append("       '03', SUM(DECODE(BSE_MON,P.MON_2,VAL.LOD,0)),                                         " ).append("\n"); 
		query.append("       '05', SUM(DECODE(BSE_MON,P.MON_2,VAL.REV,0))/1000,                                       " ).append("\n"); 
		query.append("       '06', DECODE(NVL(SUM(DECODE(BSE_MON,P.MON_2,VAL.LOD,0)),0), 0, 0, SUM(DECODE(BSE_MON,P.MON_2,VAL.REV,0))/SUM(DECODE(BSE_MON,P.MON_2,VAL.LOD,0))), --수정" ).append("\n"); 
		query.append("       '07', SUM(DECODE(BSE_MON,P.MON_2,VAL.CM,0))/1000,                                        " ).append("\n"); 
		query.append("       '09', SUM(DECODE(BSE_MON,P.MON_2,DECODE(NVL(VAL.LOD,0),0,0,VAL.CM/(VAL.LOD)),0))), 0) AS CAL_VAL_03     --수정" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , NVL(DECODE(ITM.CODE,  " ).append("\n"); 
		query.append("       '02', SUM( VAL.VOYAGE),                                   " ).append("\n"); 
		query.append("       '03', SUM(VAL.LOD),                                         " ).append("\n"); 
		query.append("       '05', SUM(VAL.REV)/1000,                                       " ).append("\n"); 
		query.append("       '06', DECODE(NVL(SUM(VAL.LOD),0), 0, 0, SUM(VAL.REV)/SUM(VAL.LOD)), --수정" ).append("\n"); 
		query.append("       '07', SUM(VAL.CM)/1000,                                        " ).append("\n"); 
		query.append(" 	   '09', DECODE(NVL(SUM(VAL.LOD),0),0,0,SUM(VAL.CM)/SUM(VAL.LOD)),0),0) AS CAL_TOT --수정" ).append("\n"); 
		query.append("  FROM (  " ).append("\n"); 
		query.append("    SELECT BSE_YR,BSE_QTR_CD,BSE_MON,AQ_CD,SAQ_TGT_GRP_CD,TRD_CD,CONV_DIR_CD DIR_CD  " ).append("\n"); 
		query.append("      ,LOD  " ).append("\n"); 
		query.append("      ,REV  " ).append("\n"); 
		query.append("      ,CM  " ).append("\n"); 
		query.append("      ,RA_CM  " ).append("\n"); 
		query.append("      ,RA_OP  		" ).append("\n"); 
		query.append("      ,DECODE( GRP_CD  " ).append("\n"); 
		query.append("        , '0111'  -- TARGET GROUP TOTAL  " ).append("\n"); 
		query.append("        , (SELECT COUNT(DISTINCT VVD.SKD_VOY_NO||VVD.VSL_CD||VVD.SKD_DIR_CD)   " ).append("\n"); 
		query.append("          FROM VVD_VIEW VVD   " ).append("\n"); 
		query.append("          WHERE  VVD.RHQ_CD = VL.RHQ_CD  " ).append("\n"); 
		query.append("            AND VVD.AQ_CD = VL.AQ_CD  " ).append("\n"); 
		query.append("           AND VVD.RGN_OFC_CD = VL.RGN_OFC_CD " ).append("\n"); 
		query.append("           AND VVD.BSE_MON = VL.BSE_MON  " ).append("\n"); 
		query.append("          )   " ).append("\n"); 
		query.append("        , '0011'  -- TRADE TOTAL  " ).append("\n"); 
		query.append("        , (SELECT COUNT(DISTINCT VVD.SKD_VOY_NO||VVD.VSL_CD||VVD.SKD_DIR_CD)   " ).append("\n"); 
		query.append("          FROM VVD_VIEW VVD   " ).append("\n"); 
		query.append("          WHERE  VVD.SAQ_TGT_GRP_CD = VL.SAQ_TGT_GRP_CD  " ).append("\n"); 
		query.append("            AND VVD.RHQ_CD = VL.RHQ_CD  " ).append("\n"); 
		query.append("            AND VVD.AQ_CD = VL.AQ_CD  " ).append("\n"); 
		query.append("           AND VVD.RGN_OFC_CD = VL.RGN_OFC_CD  " ).append("\n"); 
		query.append("           AND VVD.BSE_MON = VL.BSE_MON  " ).append("\n"); 
		query.append("          )   " ).append("\n"); 
		query.append("        ,VOYAGE ) VOYAGE  " ).append("\n"); 
		query.append("      ,GRP_AQ_CD  " ).append("\n"); 
		query.append("      ,GRP_SAQ_TGT_GRP_CD  " ).append("\n"); 
		query.append("      ,GRP_TRD_CD  " ).append("\n"); 
		query.append("      ,GRP_DIR_CD,GRP_CD  " ).append("\n"); 
		query.append("    FROM (  " ).append("\n"); 
		query.append("      SELECT QTA.MQTA_RLSE_VER_NO,QTA.RHQ_CD,QTA.BSE_YR,QTA.BSE_QTR_CD BSE_QTR_CD,QTA.BSE_MON,NVL(QTA.AQ_CD,'000000') AQ_CD,GRP_TRD.SAQ_TGT_GRP_CD,QTA.TRD_CD,QTA.CONV_DIR_CD,QTA.RGN_OFC_CD " ).append("\n"); 
		query.append("        ,DECODE(SUM(QTA.LOD_QTY),0,0.0000000001,SUM(QTA.LOD_QTY)) AS LOD  " ).append("\n"); 
		query.append("        ,SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS REV  " ).append("\n"); 
		query.append("        ,SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS CM  " ).append("\n"); 
		query.append("        ,SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS RA_CM  " ).append("\n"); 
		query.append("        ,SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY) AS RA_OP  		" ).append("\n"); 
		query.append("        ,COUNT(DISTINCT VVD.SKD_VOY_NO||VVD.VSL_CD||VVD.SKD_DIR_CD) VOYAGE  " ).append("\n"); 
		query.append("        ,GROUPING(QTA.AQ_CD) GRP_AQ_CD  " ).append("\n"); 
		query.append("        ,GROUPING(GRP_TRD.SAQ_TGT_GRP_CD) GRP_SAQ_TGT_GRP_CD  " ).append("\n"); 
		query.append("        ,GROUPING(QTA.TRD_CD) GRP_TRD_CD  " ).append("\n"); 
		query.append("        ,GROUPING(QTA.CONV_DIR_CD) GRP_DIR_CD  " ).append("\n"); 
		query.append("        ,GROUPING(QTA.AQ_CD) || GROUPING(GRP_TRD.SAQ_TGT_GRP_CD) || GROUPING(QTA.TRD_CD) || GROUPING(QTA.CONV_DIR_CD) GRP_CD  " ).append("\n"); 
		query.append("      FROM SAQ_MON_CFM_QTA QTA  " ).append("\n"); 
		query.append("        , SAQ_MON_CFM_TGT_VVD VVD  " ).append("\n"); 
		query.append("        , SAQ_TGT_GRP_TRD GRP_TRD  " ).append("\n"); 
		query.append("      WHERE QTA.MQTA_RLSE_VER_NO = VVD.MQTA_RLSE_VER_NO  " ).append("\n"); 
		query.append("        AND QTA.BSE_YR = VVD.BSE_YR  " ).append("\n"); 
		query.append("        AND QTA.BSE_QTR_CD = VVD.BSE_QTR_CD  " ).append("\n"); 
		query.append("        AND QTA.BSE_MON = VVD.BSE_MON  " ).append("\n"); 
		query.append("        AND QTA.TRD_CD = VVD.TRD_CD  " ).append("\n"); 
		query.append("        AND QTA.RLANE_CD = VVD.RLANE_CD  " ).append("\n"); 
		query.append("        AND QTA.DIR_CD = VVD.DIR_CD  " ).append("\n"); 
		query.append("        AND QTA.VSL_CD = VVD.VSL_CD  " ).append("\n"); 
		query.append("        AND QTA.SKD_VOY_NO = VVD.SKD_VOY_NO  " ).append("\n"); 
		query.append("        AND QTA.SKD_DIR_CD = VVD.SKD_DIR_CD  " ).append("\n"); 
		query.append("        AND QTA.QTA_TGT_CD = @[selType]  		" ).append("\n"); 
		query.append("        AND QTA.TRD_CD = GRP_TRD.TRD_CD  " ).append("\n"); 
		query.append("        AND VVD.SUB_TRD_CD = GRP_TRD.SUB_TRD_CD  " ).append("\n"); 
		query.append("        AND QTA.DIR_CD = GRP_TRD.DIR_CD  " ).append("\n"); 
		query.append("        AND ( QTA.RGN_OFC_CD,QTA.BSE_YR,QTA.BSE_QTR_CD,QTA.MQTA_RLSE_VER_NO )   " ).append("\n"); 
		query.append("          = ( SELECT OFC_CD, BSE_YR, BSE_QTR_CD,VER  FROM PARAMS )  " ).append("\n"); 
		query.append("      GROUP BY GROUPING SETS(   " ).append("\n"); 
		query.append("        (QTA.MQTA_RLSE_VER_NO,QTA.RHQ_CD,QTA.BSE_YR,QTA.BSE_QTR_CD,QTA.BSE_MON,QTA.AQ_CD,QTA.RGN_OFC_CD)  " ).append("\n"); 
		query.append("        ,(QTA.MQTA_RLSE_VER_NO,QTA.RHQ_CD,QTA.BSE_YR,QTA.BSE_QTR_CD,QTA.BSE_MON,QTA.AQ_CD,QTA.RGN_OFC_CD,GRP_TRD.SAQ_TGT_GRP_CD)  " ).append("\n"); 
		query.append("        ,(QTA.MQTA_RLSE_VER_NO,QTA.RHQ_CD,QTA.BSE_YR,QTA.BSE_QTR_CD,QTA.BSE_MON,QTA.AQ_CD,QTA.RGN_OFC_CD,GRP_TRD.SAQ_TGT_GRP_CD,QTA.TRD_CD,QTA.CONV_DIR_CD)  " ).append("\n"); 
		query.append("      )  " ).append("\n"); 
		query.append("    ) VL  " ).append("\n"); 
		query.append("  ) VAL  " ).append("\n"); 
		query.append("  , ITEM_VIEW ITM  " ).append("\n"); 
		query.append("  , PARAMS P  " ).append("\n"); 
		query.append("  GROUP BY VAL.BSE_YR,VAL.BSE_QTR_CD,VAL.AQ_CD,VAL.SAQ_TGT_GRP_CD,VAL.TRD_CD,VAL.DIR_CD,ITM.CODE,ITM.TEXT,ITM.ROW_SEQ,GRP_AQ_CD,GRP_SAQ_TGT_GRP_CD,GRP_TRD_CD,GRP_DIR_CD , GRP_CD " ).append("\n"); 
		query.append("  ORDER BY VAL.GRP_AQ_CD DESC , VAL.AQ_CD, VAL.GRP_SAQ_TGT_GRP_CD DESC, VAL.SAQ_TGT_GRP_CD,VAL.GRP_TRD_CD DESC, VAL.TRD_CD,VAL.DIR_CD,ITM.ROW_SEQ" ).append("\n"); 

	}
}