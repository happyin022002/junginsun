/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab03RSQL.java
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

public class MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기별별 확정된 내용을 Bound, Sub Trade, Lane 별로 Grouping 된 형태로 조회 한다. (주요 table saq_mon_cfm_qta, saq_mon_cfm_tgt_vvd)
	  * </pre>
	  */
	public MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab03RSQL(){
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
		params.put("month",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dirCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("items0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaInquiryDBDAOSearchMonthlyQuotaInquiry0128Tab03RSQL").append("\n"); 
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
		query.append("WITH TMP_INPUT_PARAMS AS " ).append("\n"); 
		query.append("       (SELECT DISTINCT @[year] AS BSE_YR " ).append("\n"); 
		query.append("            , @[quarter] AS BSE_QTR_CD " ).append("\n"); 
		query.append("            , @[year]|| #if (${month} < 10) '0'||@[month] #else @[month] #end AS YRMON_1 " ).append("\n"); 
		query.append("            , TO_CHAR(ADD_MONTHS(TO_DATE(@[year]|| #if (${month} < 10) '0'||@[month] #else @[month] #end , 'YYYYMM'), 1), 'YYYYMM') AS YRMON_2 " ).append("\n"); 
		query.append("            , TO_CHAR(ADD_MONTHS(TO_DATE(@[year]|| #if (${month} < 10) '0'||@[month] #else @[month] #end , 'YYYYMM'), 2), 'YYYYMM') AS YRMON_3 " ).append("\n"); 
		query.append("            , @[targetGrp] AS SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("            , @[version] AS RLSE_VER_NO " ).append("\n"); 
		query.append("            , @[trade] AS TRD_CD " ).append("\n"); 
		query.append("            , @[dirCd] AS DIR_CD " ).append("\n"); 
		query.append("            , @[subTrade] AS SUB_TRD_CD " ).append("\n"); 
		query.append("            , @[rlaneCd] AS RLANE_CD " ).append("\n"); 
		query.append("            , @[ofcCd] AS OFC_CD " ).append("\n"); 
		query.append("            , @[from_wk] AS FROM_WK " ).append("\n"); 
		query.append("            , @[to_wk] AS TO_WK " ).append("\n"); 
		query.append("         FROM DUAL " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("     ,TEMP_SMR AS " ).append("\n"); 
		query.append("       (SELECT DISTINCT SMR.VSL_CD " ).append("\n"); 
		query.append("            , SMR.SKD_VOY_NO " ).append("\n"); 
		query.append("            , SMR.SKD_DIR_CD " ).append("\n"); 
		query.append("            , SMR.TRD_CD " ).append("\n"); 
		query.append("            , SMR.DIR_CD " ).append("\n"); 
		query.append("            , VVD.SUB_TRD_CD " ).append("\n"); 
		query.append("            , SMR.RLANE_CD " ).append("\n"); 
		query.append("            , SMR.BSE_QTR_CD " ).append("\n"); 
		query.append("            , VVD.BSE_WK " ).append("\n"); 
		query.append("         FROM SAQ_MON_CFM_QTA SMR " ).append("\n"); 
		query.append("          JOIN TMP_INPUT_PARAMS INP " ).append("\n"); 
		query.append("              ON ( " ).append("\n"); 
		query.append("                  SMR.BSE_YR = INP.BSE_YR " ).append("\n"); 
		query.append("                  AND SMR.BSE_QTR_CD = INP.BSE_QTR_CD " ).append("\n"); 
		query.append("                  AND SMR.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO " ).append("\n"); 
		query.append("                  AND SMR.TRD_CD = INP.TRD_CD " ).append("\n"); 
		query.append("                  AND SMR.CONV_DIR_CD = INP.DIR_CD " ).append("\n"); 
		query.append("                  AND #if (${rlaneCd} != '') SMR.RLANE_CD = INP.RLANE_CD " ).append("\n"); 
		query.append("                  AND #end SMR.RGN_OFC_CD = INP.OFC_CD " ).append("\n"); 
		query.append("                  AND SMR.QTA_TGT_CD = @[selType] " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("          JOIN SAQ_MON_CFM_TGT_VVD VVD " ).append("\n"); 
		query.append("              ON ( " ).append("\n"); 
		query.append("                  VVD.MQTA_RLSE_VER_NO = SMR.MQTA_RLSE_VER_NO " ).append("\n"); 
		query.append("                  AND VVD.BSE_YR = SMR.BSE_YR " ).append("\n"); 
		query.append("                  AND VVD.BSE_QTR_CD = SMR.BSE_QTR_CD " ).append("\n"); 
		query.append("                  AND VVD.BSE_MON = SMR.BSE_MON " ).append("\n"); 
		query.append("                  AND VVD.TRD_CD = SMR.TRD_CD " ).append("\n"); 
		query.append("                  AND VVD.RLANE_CD = SMR.RLANE_CD " ).append("\n"); 
		query.append("                  AND VVD.DIR_CD = SMR.DIR_CD " ).append("\n"); 
		query.append("                  AND VVD.VSL_CD = SMR.VSL_CD " ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO = SMR.SKD_VOY_NO " ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD = SMR.SKD_DIR_CD " ).append("\n"); 
		query.append("                  AND VVD.BSE_WK BETWEEN INP.FROM_WK AND INP.TO_WK " ).append("\n"); 
		query.append("                  AND VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%' " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("     ,VVD AS " ).append("\n"); 
		query.append("       (SELECT VVD.VSL_CD " ).append("\n"); 
		query.append("            , VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("            , VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("            , VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD AS VVD_GRP_CD " ).append("\n"); 
		query.append("            , VVD.TRD_CD " ).append("\n"); 
		query.append("            , VVD.CONV_DIR_CD " ).append("\n"); 
		query.append("            , VVD.SUB_TRD_CD " ).append("\n"); 
		query.append("            , VVD.RLANE_CD " ).append("\n"); 
		query.append("            , VVD.BSE_YR " ).append("\n"); 
		query.append("            , VVD.BSE_WK " ).append("\n"); 
		query.append("            , SUM(VVD.FNL_BSA_CAPA) AS BSA " ).append("\n"); 
		query.append("            , COUNT(*) AS VOYAGE " ).append("\n"); 
		query.append("         FROM SAQ_MON_CFM_TGT_VVD VVD " ).append("\n"); 
		query.append("          JOIN TMP_INPUT_PARAMS INP " ).append("\n"); 
		query.append("              ON ( " ).append("\n"); 
		query.append("                  VVD.BSE_YR = INP.BSE_YR " ).append("\n"); 
		query.append("                  AND VVD.BSE_QTR_CD = INP.BSE_QTR_CD " ).append("\n"); 
		query.append("                  AND VVD.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO " ).append("\n"); 
		query.append("                  AND VVD.TRD_CD = INP.TRD_CD " ).append("\n"); 
		query.append("                  AND VVD.CONV_DIR_CD = INP.DIR_CD " ).append("\n"); 
		query.append("                  AND VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%' " ).append("\n"); 
		query.append("                  AND VVD.BSE_WK BETWEEN INP.FROM_WK AND INP.TO_WK #if (${rlaneCd} != '') " ).append("\n"); 
		query.append("                  AND VVD.RLANE_CD = INP.RLANE_CD #end " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("          JOIN TEMP_SMR SMR " ).append("\n"); 
		query.append("              ON ( " ).append("\n"); 
		query.append("                  SMR.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("                  AND SMR.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("                  AND SMR.SKD_DIR_CD = VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("                  AND SMR.TRD_CD = VVD.TRD_CD " ).append("\n"); 
		query.append("                  AND SMR.DIR_CD = VVD.DIR_CD " ).append("\n"); 
		query.append("                  AND SMR.SUB_TRD_CD = VVD.SUB_TRD_CD " ).append("\n"); 
		query.append("                  AND SMR.RLANE_CD = VVD.RLANE_CD " ).append("\n"); 
		query.append("                  AND SMR.BSE_QTR_CD = VVD.BSE_QTR_CD " ).append("\n"); 
		query.append("                  AND SMR.BSE_WK = VVD.BSE_WK " ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("        GROUP BY VVD.BSE_WK " ).append("\n"); 
		query.append("            , VVD.VSL_CD " ).append("\n"); 
		query.append("            , VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("            , VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("            , VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD " ).append("\n"); 
		query.append("            , VVD.TRD_CD " ).append("\n"); 
		query.append("            , VVD.CONV_DIR_CD " ).append("\n"); 
		query.append("            , VVD.SUB_TRD_CD " ).append("\n"); 
		query.append("            , VVD.RLANE_CD " ).append("\n"); 
		query.append("            , VVD.BSE_YR " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("SELECT KEY " ).append("\n"); 
		query.append("     , SLEVEL " ).append("\n"); 
		query.append("     , SMR.BSE_YR " ).append("\n"); 
		query.append("     , SMR.BSE_WK " ).append("\n"); 
		query.append("     , SMR.SUB_TRD_CD " ).append("\n"); 
		query.append("     , DECODE(DIR.CONV_DIR_CD,'',SMR.RLANE_CD,SMR.RLANE_CD||' - '||DIR.DIR_CD) RLANE_CD " ).append("\n"); 
		query.append("     , DIR.DIR_CD CONV_DIR_CD " ).append("\n"); 
		query.append("     , VVD_GRP_CD " ).append("\n"); 
		query.append("     , VVD_CD " ).append("\n"); 
		query.append("  -- , RHQ_CD " ).append("\n"); 
		query.append("  -- , AQ_CD " ).append("\n"); 
		query.append("  -- , SMR.OFC_CD " ).append("\n"); 
		query.append("     , ROW_SEQ " ).append("\n"); 
		query.append("     , TEXT AS ITEM_TEXT " ).append("\n"); 
		query.append("     , DECODE(TEXT,'G.REV','G.REV*','CM','CM*',TEXT) AS ITEM  " ).append("\n"); 
		query.append("     , VAL " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT MIN(KEY) AS KEY " ).append("\n"); 
		query.append("            , CASE SLEVEL WHEN 1 THEN 'TOTAL' ELSE SMR.SUB_TRD_CD END SUB_TRD_CD " ).append("\n"); 
		query.append("            , CASE SLEVEL WHEN 1 THEN '' WHEN 2 THEN 'TOTAL' ELSE SMR.RLANE_CD END RLANE_CD " ).append("\n"); 
		query.append("            , CASE SLEVEL WHEN 1 THEN '' WHEN 2 THEN '' WHEN 3 THEN 'TOTAL' ELSE SMR.VVD_GRP_CD END VVD_GRP_CD " ).append("\n"); 
		query.append("            , CASE SLEVEL WHEN 1 THEN '' WHEN 2 THEN '' WHEN 3 THEN '' WHEN 4 THEN 'TOTAL' ELSE SMR.VVD_CD END VVD_CD " ).append("\n"); 
		query.append("         -- , CASE SLEVEL WHEN 1 THEN '' WHEN 2 THEN '' WHEN 3 THEN '' WHEN 4 THEN '' ELSE SMR.RHQ_CD END RHQ_CD " ).append("\n"); 
		query.append("         -- , CASE SLEVEL WHEN 1 THEN '' WHEN 2 THEN '' WHEN 3 THEN '' WHEN 4 THEN '' WHEN 5 THEN 'TOTAL' ELSE SMR.AQ_CD END AQ_CD " ).append("\n"); 
		query.append("         -- , CASE SLEVEL WHEN 1 THEN '' WHEN 2 THEN '' WHEN 3 THEN '' WHEN 4 THEN '' WHEN 5 THEN '' WHEN 6 THEN 'TOTAL' ELSE SMR.OFC_CD END OFC_CD " ).append("\n"); 
		query.append("            , ITM.ROW_SEQ " ).append("\n"); 
		query.append("            , ITM.TEXT " ).append("\n"); 
		query.append("            --, CASE WHEN ITM.CODE IN('05', '07', '08', '11', '12') THEN ITM.TEXT || '*' ELSE ITM.TEXT END ITEM " ).append("\n"); 
		query.append("            , SLEVEL " ).append("\n"); 
		query.append("            , SMR.BSE_YR " ).append("\n"); 
		query.append("            , SMR.BSE_WK " ).append("\n"); 
		query.append("            , SUM(LOD) LOD " ).append("\n"); 
		query.append("            , SUM(REV) REV " ).append("\n"); 
		query.append("            , SUM(CM) CM " ).append("\n"); 
		query.append("            , SUM(RA_CM) RA_CM " ).append("\n"); 
		query.append("            , SUM(OP) OP " ).append("\n"); 
		query.append("            , SUM(RA_OP) RA_OP " ).append("\n"); 
		query.append("            , NVL(SUM( DECODE( ITM.CODE, '02', (VOYAGE), '03', (SMR.LOD), '05', (SMR.REV), '06', DECODE(LOD, 0, 0, (REV)/(LOD)*1000), '08', (SMR.CM),  '10', DECODE(LOD, 0, 0, (CM)*1000/(LOD)) )), 0) AS VAL " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT G_FLAG " ).append("\n"); 
		query.append("                   , CASE G_FLAG WHEN '01111' THEN 1 WHEN '00111' THEN 2 WHEN '00011' THEN 3 WHEN '00001' THEN 4 WHEN '00000' THEN 5 END SLEVEL " ).append("\n"); 
		query.append("                     --  WHEN '00000011' THEN 5 " ).append("\n"); 
		query.append("                     --  WHEN '00000001' THEN 6 " ).append("\n"); 
		query.append("                     --  WHEN '00000000' THEN 7 END SLEVEL " ).append("\n"); 
		query.append("                   , KEY " ).append("\n"); 
		query.append("                   , SUB_TRD_CD " ).append("\n"); 
		query.append("                   , RLANE_CD " ).append("\n"); 
		query.append("                   , VVD_GRP_CD " ).append("\n"); 
		query.append("                   , VVD_CD " ).append("\n"); 
		query.append("                -- , RHQ_CD " ).append("\n"); 
		query.append("                -- , AQ_CD " ).append("\n"); 
		query.append("                -- , OFC_CD " ).append("\n"); 
		query.append("                   , BSE_YR " ).append("\n"); 
		query.append("                   , BSE_WK " ).append("\n"); 
		query.append("                   , VOYAGE " ).append("\n"); 
		query.append("                   , LOD " ).append("\n"); 
		query.append("                   , REV " ).append("\n"); 
		query.append("                   , CM " ).append("\n"); 
		query.append("                   , RA_CM " ).append("\n"); 
		query.append("                   , OP " ).append("\n"); 
		query.append("                   , RA_OP " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                     (SELECT GROUPING(BSE_WK)||GROUPING(SUB_TRD_CD)||GROUPING(RLANE_CD)||GROUPING(VVD_GRP_CD)||GROUPING(VVD_CD)AS G_FLAG " ).append("\n"); 
		query.append("                          -- GROUPING(BSE_WK)||GROUPING(SUB_TRD_CD)||GROUPING(RLANE_CD)||GROUPING(VVD_GRP_CD)||GROUPING(VVD_CD)||GROUPING(RHQ_CD)||GROUPING(AQ_CD)||GROUPING(OFC_CD)AS G_FLAG                             " ).append("\n"); 
		query.append("                          --, MIN(SMR.BSE_YR||SMR.BSE_WK||SMR.SUB_TRD_CD||SMR.RLANE_CD||SMR.VVD_GRP_CD||VVD_CD||SMR.RHQ_CD||SMR.AQ_CD||SMR.OFC_CD) AS KEY " ).append("\n"); 
		query.append("                          , MIN(SMR.BSE_YR||SMR.BSE_WK||SMR.SUB_TRD_CD||SMR.RLANE_CD||SMR.VVD_GRP_CD||VVD_CD) AS KEY" ).append("\n"); 
		query.append("                          , SMR.SUB_TRD_CD " ).append("\n"); 
		query.append("                          , SMR.RLANE_CD " ).append("\n"); 
		query.append("                          , SMR.VVD_GRP_CD " ).append("\n"); 
		query.append("                     --   , SMR.RHQ_CD " ).append("\n"); 
		query.append("                     --   , SMR.AQ_CD " ).append("\n"); 
		query.append("                     --   , SMR.OFC_CD " ).append("\n"); 
		query.append("                          , SMR.BSE_YR " ).append("\n"); 
		query.append("                          , SMR.BSE_WK " ).append("\n"); 
		query.append("                          , VVD_CD " ).append("\n"); 
		query.append("                          , COUNT(DISTINCT VVD_CD) VOYAGE " ).append("\n"); 
		query.append("                          , SUM(LOD) AS LOD " ).append("\n"); 
		query.append("                          , SUM(REV) AS REV " ).append("\n"); 
		query.append("                          , SUM(CM) AS CM " ).append("\n"); 
		query.append("                          , SUM(RA_CM) AS RA_CM " ).append("\n"); 
		query.append("                          , SUM(OP) AS OP " ).append("\n"); 
		query.append("                          , SUM(RA_OP) AS RA_OP " ).append("\n"); 
		query.append("                       FROM " ).append("\n"); 
		query.append("                            (SELECT VVD.SUB_TRD_CD " ).append("\n"); 
		query.append("                                 , SMR.RLANE_CD " ).append("\n"); 
		query.append("                                 , VVD.VVD_GRP_CD " ).append("\n"); 
		query.append("                            --   , SMR.RHQ_CD AS RHQ_CD " ).append("\n"); 
		query.append("                            --   , NVL(SMR.AQ_CD, '  ') AS AQ_CD " ).append("\n"); 
		query.append("                            --   , SMR.RGN_OFC_CD AS OFC_CD " ).append("\n"); 
		query.append("                                 , SMR.BSE_YR " ).append("\n"); 
		query.append("                                 , VVD.BSE_WK " ).append("\n"); 
		query.append("                                 , VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD VVD_CD " ).append("\n"); 
		query.append("                                 , SUM(SMR.LOD_QTY) AS LOD " ).append("\n"); 
		query.append("                                 , SUM(SMR.GRS_RPB_REV*SMR.LOD_QTY)/1000 AS REV " ).append("\n"); 
		query.append("                                 , SUM((SMR.GRS_RPB_REV-SMR.CM_UC_AMT)*SMR.LOD_QTY)/1000 AS CM " ).append("\n"); 
		query.append("                                 , SUM((SMR.GRS_RPB_REV-SMR.RA_CM_UC_AMT)*SMR.LOD_QTY)/1000 AS RA_CM " ).append("\n"); 
		query.append("                                 , SUM((SMR.GRS_RPB_REV-SMR.OPFIT_UC_AMT)*SMR.LOD_QTY)/1000 AS OP " ).append("\n"); 
		query.append("                              -- BKG CM " ).append("\n"); 
		query.append("                                 , SUM((SMR.GRS_RPB_REV-SMR.RA_OPFIT_UC_AMT)*SMR.LOD_QTY )/1000 AS RA_OP " ).append("\n"); 
		query.append("                              -- BKG OP " ).append("\n"); 
		query.append("                              FROM SAQ_MON_CFM_QTA SMR " ).append("\n"); 
		query.append("                               JOIN TMP_INPUT_PARAMS INP " ).append("\n"); 
		query.append("                                   ON ( " ).append("\n"); 
		query.append("                                       SMR.BSE_YR = INP.BSE_YR " ).append("\n"); 
		query.append("                                       AND SMR.BSE_QTR_CD = INP.BSE_QTR_CD " ).append("\n"); 
		query.append("                                       AND SMR.MQTA_RLSE_VER_NO = INP.RLSE_VER_NO " ).append("\n"); 
		query.append("                                       AND SMR.TRD_CD = INP.TRD_CD " ).append("\n"); 
		query.append("                                       AND SMR.CONV_DIR_CD = INP.DIR_CD " ).append("\n"); 
		query.append("                                       AND #if (${rlaneCd} != '') SMR.RLANE_CD = INP.RLANE_CD " ).append("\n"); 
		query.append("                                       AND #end SMR.RGN_OFC_CD = INP.OFC_CD " ).append("\n"); 
		query.append("                                       AND SMR.QTA_TGT_CD = @[selType] " ).append("\n"); 
		query.append("                                   ) " ).append("\n"); 
		query.append("                               JOIN VVD " ).append("\n"); 
		query.append("                                   ON ( " ).append("\n"); 
		query.append("                                       SMR.TRD_CD = VVD.TRD_CD " ).append("\n"); 
		query.append("                                       AND SMR.CONV_DIR_CD = VVD.CONV_DIR_CD " ).append("\n"); 
		query.append("                                       AND SMR.RLANE_CD = VVD.RLANE_CD " ).append("\n"); 
		query.append("                                       AND SMR.BSE_YR = VVD.BSE_YR " ).append("\n"); 
		query.append("                                       AND SMR.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("                                       AND SMR.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("                                       AND SMR.SKD_DIR_CD = VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("                                       AND VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%' " ).append("\n"); 
		query.append("                                       AND VVD.BSE_WK BETWEEN INP.FROM_WK AND INP.TO_WK " ).append("\n"); 
		query.append("                                   ) " ).append("\n"); 
		query.append("                             GROUP BY VVD.SUB_TRD_CD " ).append("\n"); 
		query.append("                                 ,SMR.RLANE_CD " ).append("\n"); 
		query.append("                                 ,VVD.VVD_GRP_CD " ).append("\n"); 
		query.append("                            --   , SMR.RHQ_CD " ).append("\n"); 
		query.append("                            --   , NVL(SMR.AQ_CD, '  ') " ).append("\n"); 
		query.append("                            --   , SMR.RGN_OFC_CD " ).append("\n"); 
		query.append("                                 , SMR.BSE_YR " ).append("\n"); 
		query.append("                                 ,VVD.BSE_WK " ).append("\n"); 
		query.append("                                 ,VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("                            ) SMR " ).append("\n"); 
		query.append("                      GROUP BY GROUPING SETS((SMR.BSE_YR,SMR.BSE_WK), (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD), (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD,SMR.RLANE_CD,SMR.VVD_GRP_CD,VVD_CD)) --GROUPING SETS((SMR.BSE_YR,SMR.BSE_WK), (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD), (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD,SMR.RLANE_CD,SMR.VVD_GRP_CD,VVD_CD, SMR.RHQ_CD), (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD,SMR.RLANE_CD,SMR.VVD_GRP_CD,VVD_CD, SMR.RHQ_CD, SMR.AQ_CD), (SMR.BSE_YR,SMR.BSE_WK,SMR.SUB_TRD_CD,SMR.RLANE_CD,SMR.VVD_GRP_CD,VVD_CD, SMR.RHQ_CD, SMR.AQ_CD, SMR.OFC_CD)) " ).append("\n"); 
		query.append("                     ) SMR " ).append("\n"); 
		query.append("              ) SMR " ).append("\n"); 
		query.append("          JOIN " ).append("\n"); 
		query.append("              (SELECT INTG_CD_VAL_CTNT AS CODE " ).append("\n"); 
		query.append("                   , INTG_CD_VAL_DP_DESC AS TEXT " ).append("\n"); 
		query.append("                   , INTG_CD_VAL_DP_SEQ AS ROW_SEQ " ).append("\n"); 
		query.append("                FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("               WHERE INTG_CD_ID = 'CD01391' #if($ilist.size() > 0) " ).append("\n"); 
		query.append("                     AND " ).append("\n"); 
		query.append("                     ( " ).append("\n"); 
		query.append("                         'ALL' = @[items0] " ).append("\n"); 
		query.append("                         OR " ).append("\n"); 
		query.append("                         ( " ).append("\n"); 
		query.append("                             INTG_CD_VAL_DP_DESC IN ( #foreach ($key IN ${ilist}) #if($velocityCount < $ilist.size()) '$key', #else '$key' #end #end ) " ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                     #end " ).append("\n"); 
		query.append("              ) ITM " ).append("\n"); 
		query.append("              ON 1 = 1 " ).append("\n"); 
		query.append("          JOIN TMP_INPUT_PARAMS INP " ).append("\n"); 
		query.append("              ON 1 = 1 " ).append("\n"); 
		query.append("        GROUP BY SMR.BSE_YR " ).append("\n"); 
		query.append("            , SMR.BSE_WK " ).append("\n"); 
		query.append("            , SMR.SUB_TRD_CD " ).append("\n"); 
		query.append("            , SMR.RLANE_CD " ).append("\n"); 
		query.append("            , SMR.SLEVEL " ).append("\n"); 
		query.append("            , SMR.VVD_GRP_CD " ).append("\n"); 
		query.append("            , SMR.VVD_CD " ).append("\n"); 
		query.append("         -- , SMR.RHQ_CD " ).append("\n"); 
		query.append("         -- , SMR.AQ_CD " ).append("\n"); 
		query.append("         -- , SMR.OFC_CD " ).append("\n"); 
		query.append("            , ITM.ROW_SEQ " ).append("\n"); 
		query.append("            , ITM.TEXT " ).append("\n"); 
		query.append("            , ITM.CODE " ).append("\n"); 
		query.append("       ) SMR " ).append("\n"); 
		query.append("     , " ).append("\n"); 
		query.append("       (SELECT DIR.RLANE_CD " ).append("\n"); 
		query.append("            , DIR.DIR_CD " ).append("\n"); 
		query.append("            , DIR.CONV_DIR_CD " ).append("\n"); 
		query.append("         FROM SAQ_MON_DIR_CONV DIR " ).append("\n"); 
		query.append("        WHERE DIR.BSE_YR = @[year] " ).append("\n"); 
		query.append("              AND DIR.BSE_QTR_CD = @[quarter] " ).append("\n"); 
		query.append("              AND DIR.TRD_CD = @[trade] " ).append("\n"); 
		query.append("              AND DIR.CONV_DIR_CD = @[dirCd] " ).append("\n"); 
		query.append("       ) DIR " ).append("\n"); 
		query.append(" WHERE DIR.RLANE_CD(+) = SMR.RLANE_CD " ).append("\n"); 
		query.append("ORDER BY KEY " ).append("\n"); 
		query.append("     , SLEVEL " ).append("\n"); 
		query.append("     , ROW_SEQ" ).append("\n"); 

	}
}