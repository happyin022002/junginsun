/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyQuotaAdjustmentTradeRhq0085List01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyQuotaAdjustmentTradeRhq0085List01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentTradeRHQ 조정을 위한 조회
	  * History : 2011.02.15 김종준 [T-선사] YEARLY QTA 부분 삭제
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyQuotaAdjustmentTradeRhq0085List01RSQL(){
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
		params.put("glineVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slsFcastPubNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetMonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaStepCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bef_yr_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaMdlVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentTradeRHQDBDAOSearchMonthlyQuotaAdjustmentTradeRhq0085List01RSQL").append("\n"); 
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
		query.append("WITH TMP_INPUT_PARMAS AS" ).append("\n"); 
		query.append("   (SELECT" ).append("\n"); 
		query.append("            MQTA_STEP_CD," ).append("\n"); 
		query.append("            BSE_YR," ).append("\n"); 
		query.append("            BSE_QTR_CD," ).append("\n"); 
		query.append("            TRD_CD," ).append("\n"); 
		query.append("            DIR_CD," ).append("\n"); 
		query.append("            MQTA_VER_NO," ).append("\n"); 
		query.append("            SAQ_STS_CD," ).append("\n"); 
		query.append("            GLINE_VER_NO," ).append("\n"); 
		query.append("            CRE_OFC_CD AS RHQ_CD," ).append("\n"); 
		query.append("            INCL_PORT_FLG," ).append("\n"); 
		query.append("            @[targetMonth] TGT_YR_MON," ).append("\n"); 
		query.append("            @[bef_yr_qtr] AS BEF_YR_QTR," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(BSE_YR||DECODE(BSE_QTR_CD,'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("         		AS BEF_YR_MON," ).append("\n"); 
		query.append("            @[slsFcastPubNo] AS SLS_FCAST_PUB_NO," ).append("\n"); 
		query.append("            @[mqtaMdlVerNo] AS MQTA_MDL_VER_NO," ).append("\n"); 
		query.append("            @[subTrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("            @[search_rlane_cd] AS RLANE_CD," ).append("\n"); 
		query.append("            ( SELECT RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("              FROM   SAQ_MON_QTA_RLSE RLS" ).append("\n"); 
		query.append("              WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD =" ).append("\n"); 
		query.append("                      DECODE(@[bse_quarter],'1Q',@[year]-1,@[year]) || DECODE(@[bse_quarter],'1Q','4Q','2Q','1Q','3Q','2Q','4Q','3Q')" ).append("\n"); 
		query.append("              AND    rls.qta_rlse_sts_cd = 'R'" ).append("\n"); 
		query.append("            ) MQTA_RLSE_VER_NO -- monthly rels" ).append("\n"); 
		query.append("    FROM   SAQ_MON_QTA_STEP_VER" ).append("\n"); 
		query.append("    WHERE  MQTA_STEP_CD = @[mQtaStepCd]" ).append("\n"); 
		query.append("    AND    GLINE_VER_NO = @[glineVerNo]" ).append("\n"); 
		query.append("    AND    MQTA_VER_NO = @[mQtaVerNo]" ).append("\n"); 
		query.append("    AND    BSE_YR = @[year]" ).append("\n"); 
		query.append("    AND    BSE_QTR_CD = @[bse_quarter]" ).append("\n"); 
		query.append("    AND    TRD_CD = @[trade]" ).append("\n"); 
		query.append("    AND    DIR_CD = @[bound] )," ).append("\n"); 
		query.append("TMP_MON_TGT_VVD_ADJ AS (" ).append("\n"); 
		query.append("    SELECT -- saq_mon_tgt_vvd_adj BSA, Voyage" ).append("\n"); 
		query.append("        VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("        VVD.RLANE_CD," ).append("\n"); 
		query.append("        VVD.SPRT_GRP_CD," ).append("\n"); 
		query.append("        VVD.BSA_GRP_CD," ).append("\n"); 
		query.append("        (VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD) AS LANE_GRP," ).append("\n"); 
		query.append("        SUM(DISTINCT VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("        COUNT(*) AS TOT_VOY" ).append("\n"); 
		query.append("    FROM   SAQ_MON_TGT_VVD_ADJ VVD, TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("    WHERE  VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("    AND    VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND    VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("    AND    VVD.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND    VVD.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("    AND    VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("    AND    VVD.RLANE_CD LIKE INP.RLANE_CD    || '%'" ).append("\n"); 
		query.append("    AND    VVD.BSE_YR||VVD.BSE_MON = INP.TGT_YR_MON" ).append("\n"); 
		query.append("    GROUP BY VVD.SUB_TRD_CD,VVD.RLANE_CD,VVD.SPRT_GRP_CD,VVD.BSA_GRP_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("     MIN(TRD.SUB_TRD_CD||DECODE(TRD.RLANE_CD,'RBCCO','ZZ',SUBSTR(TRD.RLANE_CD,-2))||TRD.RLANE_CD||TRD.SPRT_GRP_CD) KEY, -- hidden" ).append("\n"); 
		query.append("     TRD.SUB_TRD_CD," ).append("\n"); 
		query.append("     TRD.LANE_GRP," ).append("\n"); 
		query.append("     DECODE(DIR.DIR_CD,'',TRD.LANE_GRP,SUBSTR(TRD.LANE_GRP, 0,6)||DIR.DIR_CD||SUBSTR(TRD.LANE_GRP, 6,9)) CONV_LANE_GRP," ).append("\n"); 
		query.append("     MIN(TRD.RLANE_CD) AS RLANE_CD,  --hidden" ).append("\n"); 
		query.append("     MIN(TRD.SPRT_GRP_CD) AS SPRT_GRP_CD,  --hidden" ).append("\n"); 
		query.append("     MIN(TRD.BSA_GRP_CD) AS BSA_GRP_CD,  --hidden" ).append("\n"); 
		query.append("     TRD.RHQ_CD," ).append("\n"); 
		query.append("     ITM.ROW_SEQ,  --hidden" ).append("\n"); 
		query.append("     TO_NUMBER(ITM.CODE) AS ITEM_CODE,  --hidden" ).append("\n"); 
		query.append("     REPLACE(ITM.TEXT, '(P)', '') AS ITEM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     MIN(CASE WHEN UNI.GUBUN = 'MONTHLY' AND UNI.BSE_MON = SUBSTR(BEF_YR_MON,5,2) THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE," ).append("\n"); 
		query.append("                      '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                      '05', UNI.TOT_REV," ).append("\n"); 
		query.append("                      '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                      '07', UNI.TOT_CM," ).append("\n"); 
		query.append("                      '08', UNI.TOT_RA_CM," ).append("\n"); 
		query.append("                      '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                      '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                      '11', UNI.TOT_OP," ).append("\n"); 
		query.append("                      '12', UNI.TOT_RA_OP," ).append("\n"); 
		query.append("                      '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                      '14', UNI.TOT_RA_OPB ), 13)" ).append("\n"); 
		query.append("         END) AS RECENT_MONTHLY," ).append("\n"); 
		query.append("     MIN(CASE WHEN UNI.GUBUN = 'FORECAST' THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE, --'01', uni.tot_bsa," ).append("\n"); 
		query.append("                      '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '03', UNI.TOT_LOD/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '05', UNI.TOT_REV/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '06', (UNI.TOT_REV/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '07', UNI.TOT_CM/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '08', UNI.TOT_RA_CM/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '09', (UNI.TOT_CM/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '10', (UNI.TOT_RA_CM/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '11', UNI.TOT_OP/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '12', UNI.TOT_RA_OP/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '13', (UNI.TOT_OP/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '14', (UNI.TOT_RA_OP/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY) ), 13)" ).append("\n"); 
		query.append("         END) AS FCAST_01," ).append("\n"); 
		query.append("     MIN(CASE WHEN UNI.GUBUN = 'MODEL' THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE, -- '01', uni.tot_bsa," ).append("\n"); 
		query.append("                      '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '03', UNI.TOT_LOD/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '05', UNI.TOT_REV/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '06', (UNI.TOT_REV/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '07', UNI.TOT_CM/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '08', UNI.TOT_RA_CM/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '09', (UNI.TOT_CM/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '10', (UNI.TOT_RA_CM/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '11', UNI.TOT_OP/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '12', UNI.TOT_RA_OP/UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '13', (UNI.TOT_OP/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY)," ).append("\n"); 
		query.append("                      '14', (UNI.TOT_RA_OP/UNI.TOT_VOY)/(UNI.TOT_LOD/UNI.TOT_VOY) ), 13)" ).append("\n"); 
		query.append("         END) AS MODEL_01," ).append("\n"); 
		query.append("     MIN(CASE WHEN TRD.GUBUN = 'TRADE' THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE," ).append("\n"); 
		query.append("                      '02', TRD.TOT_VOY," ).append("\n"); 
		query.append("                      '03', TRD.TOT_LOD," ).append("\n"); 
		query.append("                      '05', TRD.TOT_REV," ).append("\n"); 
		query.append("                      '06', TRD.TOT_RPB," ).append("\n"); 
		query.append("                      '07', TRD.TOT_CM," ).append("\n"); 
		query.append("                      '08', TRD.TOT_RA_CM," ).append("\n"); 
		query.append("                      '09', TRD.TOT_CMB," ).append("\n"); 
		query.append("                      '10', TRD.TOT_RA_CMB," ).append("\n"); 
		query.append("                      '11', TRD.TOT_OP," ).append("\n"); 
		query.append("                      '12', TRD.TOT_RA_OP," ).append("\n"); 
		query.append("                      '13', TRD.TOT_OPB," ).append("\n"); 
		query.append("                      '14', TRD.TOT_RA_OPB ), 13)" ).append("\n"); 
		query.append("         END) AS TRADE_01," ).append("\n"); 
		query.append("     MIN(CASE WHEN TRD.GUBUN = 'RHQ' THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE," ).append("\n"); 
		query.append("                      '02', TRD.TOT_VOY," ).append("\n"); 
		query.append("                      '03', TRD.TOT_LOD," ).append("\n"); 
		query.append("                      '05', TRD.TOT_REV," ).append("\n"); 
		query.append("                      '06', TRD.TOT_RPB," ).append("\n"); 
		query.append("                      '07', TRD.TOT_CM," ).append("\n"); 
		query.append("                      '08', TRD.TOT_RA_CM," ).append("\n"); 
		query.append("                      '09', TRD.TOT_CMB," ).append("\n"); 
		query.append("                      '10', TRD.TOT_RA_CMB," ).append("\n"); 
		query.append("                      '11', TRD.TOT_OP," ).append("\n"); 
		query.append("                      '12', TRD.TOT_RA_OP," ).append("\n"); 
		query.append("                      '13', TRD.TOT_OPB," ).append("\n"); 
		query.append("                      '14', TRD.TOT_RA_OPB ), 13)" ).append("\n"); 
		query.append("         END) AS RHQ_01," ).append("\n"); 
		query.append("     MIN(CASE WHEN TRD.GUBUN = 'FINAL' THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE," ).append("\n"); 
		query.append("                      '02', TRD.TOT_VOY," ).append("\n"); 
		query.append("                      '03', TRD.TOT_LOD," ).append("\n"); 
		query.append("                      '05', TRD.TOT_REV," ).append("\n"); 
		query.append("                      '06', TRD.TOT_RPB," ).append("\n"); 
		query.append("                      '07', TRD.TOT_CM," ).append("\n"); 
		query.append("                      '08', TRD.TOT_RA_CM," ).append("\n"); 
		query.append("                      '09', TRD.TOT_CMB," ).append("\n"); 
		query.append("                      '10', TRD.TOT_RA_CMB," ).append("\n"); 
		query.append("                      '11', TRD.TOT_OP," ).append("\n"); 
		query.append("                      '12', TRD.TOT_RA_OP," ).append("\n"); 
		query.append("                      '13', TRD.TOT_OPB," ).append("\n"); 
		query.append("                      '14', TRD.TOT_RA_OPB ), 13)" ).append("\n"); 
		query.append("         END) AS FINAL_01," ).append("\n"); 
		query.append("     MIN(CASE WHEN UNI.GUBUN = 'ADJUSTED' THEN" ).append("\n"); 
		query.append("             ROUND(DECODE( ITM.CODE," ).append("\n"); 
		query.append("                      '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                      '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                      '05', UNI.TOT_REV," ).append("\n"); 
		query.append("                      '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                      '07', UNI.TOT_CM," ).append("\n"); 
		query.append("                      '08', UNI.TOT_RA_CM," ).append("\n"); 
		query.append("                      '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                      '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                      '11', UNI.TOT_OP," ).append("\n"); 
		query.append("                      '12', UNI.TOT_RA_OP," ).append("\n"); 
		query.append("                      '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                      '14', UNI.TOT_RA_OPB ), 13)" ).append("\n"); 
		query.append("         END) AS ADJUSTED_01," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.TOT_LOD)) AS TOT_LOD," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.TOT_RPB)) AS TOT_RPB," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.CM_UC_AMT)) AS CM_UC_AMT," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.OPFIT_UC_AMT)) AS OPFIT_UC_AMT," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.RA_CM_UC_AMT)) AS RA_CM_UC_AMT," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.RA_OPFIT_UC_AMT)) AS RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.TOT_BSA)) AS TOT_BSA," ).append("\n"); 
		query.append("     MIN(DECODE(TRD.GUBUN, 'RHQ', TRD.LOW_QTY)) AS LOW_QTY" ).append("\n"); 
		query.append(" FROM TMP_INPUT_PARMAS INP," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("     SELECT  INTG_CD_VAL_CTNT AS CODE," ).append("\n"); 
		query.append("             INTG_CD_VAL_DP_DESC AS TEXT," ).append("\n"); 
		query.append("             INTG_CD_VAL_DP_SEQ AS ROW_SEQ" ).append("\n"); 
		query.append("     FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("     WHERE INTG_CD_ID = 'CD01388'" ).append("\n"); 
		query.append("     ) ITM, (" ).append("\n"); 
		query.append("     SELECT -- Trade Group, RHQ, Final" ).append("\n"); 
		query.append("         DECODE(TRD.MQTA_STEP_CD, '01','TRADE', '02','RHQ', '03','FINAL') AS GUBUN," ).append("\n"); 
		query.append("         TRD.BSE_MON AS BSE_MON," ).append("\n"); 
		query.append("         TRD.SUB_TRD_CD," ).append("\n"); 
		query.append("         (TRD.RLANE_CD||'-'||TRD.SPRT_GRP_CD||TRD.BSA_GRP_CD) AS LANE_GRP," ).append("\n"); 
		query.append("         TRD.RLANE_CD," ).append("\n"); 
		query.append("         TRD.SPRT_GRP_CD," ).append("\n"); 
		query.append("         TRD.BSA_GRP_CD," ).append("\n"); 
		query.append("         TRD.CTRT_RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("         VVD.TOT_BSA ," ).append("\n"); 
		query.append("         VVD.TOT_VOY ," ).append("\n"); 
		query.append("         TRD.LOD_QTY AS TOT_LOD ," ).append("\n"); 
		query.append("         TRD.GRS_RPB_REV*TRD.LOD_QTY AS TOT_REV," ).append("\n"); 
		query.append("         TRD.GRS_RPB_REV AS TOT_RPB," ).append("\n"); 
		query.append("         (TRD.GRS_RPB_REV-TRD.CM_UC_AMT)*TRD.LOD_QTY AS TOT_CM," ).append("\n"); 
		query.append("         (TRD.GRS_RPB_REV-TRD.RA_CM_UC_AMT)*TRD.LOD_QTY AS TOT_RA_CM," ).append("\n"); 
		query.append("         DECODE(TRD.LOD_QTY, 0, 0, (TRD.GRS_RPB_REV-TRD.CM_UC_AMT)) AS TOT_CMB," ).append("\n"); 
		query.append("         DECODE(TRD.LOD_QTY, 0, 0, (TRD.GRS_RPB_REV-TRD.RA_CM_UC_AMT)) AS TOT_RA_CMB," ).append("\n"); 
		query.append("         (TRD.GRS_RPB_REV-TRD.OPFIT_UC_AMT)*TRD.LOD_QTY AS TOT_OP," ).append("\n"); 
		query.append("         (TRD.GRS_RPB_REV-TRD.RA_OPFIT_UC_AMT)*TRD.LOD_QTY AS TOT_RA_OP," ).append("\n"); 
		query.append("         DECODE(TRD.LOD_QTY, 0, 0, (TRD.GRS_RPB_REV-TRD.OPFIT_UC_AMT)) AS TOT_OPB," ).append("\n"); 
		query.append("         DECODE(TRD.LOD_QTY, 0, 0, (TRD.GRS_RPB_REV-TRD.RA_OPFIT_UC_AMT)) AS TOT_RA_OPB," ).append("\n"); 
		query.append("         TRD.CM_UC_AMT AS CM_UC_AMT," ).append("\n"); 
		query.append("         TRD.OPFIT_UC_AMT AS OPFIT_UC_AMT," ).append("\n"); 
		query.append("         TRD.RA_CM_UC_AMT AS RA_CM_UC_AMT," ).append("\n"); 
		query.append("         TRD.RA_OPFIT_UC_AMT AS RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("         NVL(LOD.LOW_QTY, 0) AS LOW_QTY" ).append("\n"); 
		query.append("     FROM   (" ).append("\n"); 
		query.append("             SELECT QTY.SUB_TRD_CD,QTY.RLANE_CD,QTY.CTRT_RHQ_CD," ).append("\n"); 
		query.append("                    SUM(SPC_GNTE_QTY) AS LOW_QTY" ).append("\n"); 
		query.append("             FROM   SAQ_MON_QTA_SPC_GNTE QTY," ).append("\n"); 
		query.append("                    TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("             WHERE  QTY.MQTA_MDL_VER_NO = INP.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("             AND    QTY.BSE_YR = SUBSTR(INP.TGT_YR_MON, 1,4)" ).append("\n"); 
		query.append("             AND    QTY.BSE_MON = SUBSTR(INP.TGT_YR_MON, 5,6)" ).append("\n"); 
		query.append("             AND    QTY.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("             AND    QTY.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("             AND    QTY.CTRT_RHQ_CD = INP.RHQ_CD" ).append("\n"); 
		query.append("             GROUP BY QTY.SUB_TRD_CD,QTY.RLANE_CD,QTY.CTRT_RHQ_CD" ).append("\n"); 
		query.append("             ) LOD," ).append("\n"); 
		query.append("            TMP_INPUT_PARMAS INP," ).append("\n"); 
		query.append("            SAQ_MON_QTA_STEP_VER VER," ).append("\n"); 
		query.append("            SAQ_MON_QTA_TRD TRD," ).append("\n"); 
		query.append("            TMP_MON_TGT_VVD_ADJ VVD" ).append("\n"); 
		query.append("     WHERE  VER.MQTA_STEP_CD IN ('01', '02', '03') -- Trade Group, RHQ, Final" ).append("\n"); 
		query.append("     AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("     AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("     AND    VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("     AND    VER.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("     AND    ((VER.MQTA_STEP_CD = '02' AND VER.MQTA_VER_NO = INP.MQTA_VER_NO)" ).append("\n"); 
		query.append("             OR (VER.MQTA_STEP_CD = '03' AND VER.SAQ_STS_CD IN ('FN', 'QN', 'QF'))" ).append("\n"); 
		query.append("             OR (VER.MQTA_STEP_CD = '01' AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                   FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                        COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                   WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                                   AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                                   AND B.INTG_CD_VAL_CTNT = 'DN'" ).append("\n"); 
		query.append("                                   AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ)))" ).append("\n"); 
		query.append("     AND    TRD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("     AND    TRD.RLANE_CD LIKE INP.RLANE_CD || '%'" ).append("\n"); 
		query.append("     AND    TRD.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("     AND    TRD.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("     AND    TRD.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND    TRD.BSE_MON = SUBSTR(INP.TGT_YR_MON, 5,2)" ).append("\n"); 
		query.append("     AND    TRD.TRD_CD = VER.TRD_CD" ).append("\n"); 
		query.append("     AND    TRD.DIR_CD = VER.DIR_CD" ).append("\n"); 
		query.append("     AND    TRD.MQTA_VER_NO = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("     AND    TRD.SUB_TRD_CD = VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND    TRD.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("     AND    TRD.SPRT_GRP_CD = VVD.SPRT_GRP_CD" ).append("\n"); 
		query.append("     AND    TRD.BSA_GRP_CD = VVD.BSA_GRP_CD" ).append("\n"); 
		query.append("     AND    TRD.CTRT_RHQ_CD = INP.RHQ_CD" ).append("\n"); 
		query.append("     AND    LOD.SUB_TRD_CD(+) = TRD.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND    LOD.RLANE_CD(+) = TRD.RLANE_CD" ).append("\n"); 
		query.append("     AND    LOD.CTRT_RHQ_CD(+) = TRD.CTRT_RHQ_CD" ).append("\n"); 
		query.append("     ) TRD, (" ).append("\n"); 
		query.append("     SELECT -- Recent Quota Monthly" ).append("\n"); 
		query.append("            'MONTHLY' AS GUBUN," ).append("\n"); 
		query.append("            QTA.BSE_MON," ).append("\n"); 
		query.append("            QTA.SUB_TRD_CD," ).append("\n"); 
		query.append("            ADJ.LANE_GRP," ).append("\n"); 
		query.append("            QTA.RHQ_CD  AS RHQ_CD," ).append("\n"); 
		query.append("            (VVD.TOT_BSA/VVD.TOT_VOY) AS TOT_BSA," ).append("\n"); 
		query.append("            VVD.TOT_VOY AS TOT_VOY," ).append("\n"); 
		query.append("            (QTA.TOT_LOD/VVD.TOT_VOY) AS TOT_LOD," ).append("\n"); 
		query.append("            (QTA.TOT_REV/VVD.TOT_VOY) AS TOT_REV," ).append("\n"); 
		query.append("            (QTA.TOT_REV/VVD.TOT_VOY)/(QTA.TOT_LOD/VVD.TOT_VOY) AS TOT_RPB," ).append("\n"); 
		query.append("            (QTA.TOT_CM/VVD.TOT_VOY) AS TOT_CM," ).append("\n"); 
		query.append("            (QTA.TOT_RA_CM/VVD.TOT_VOY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            (QTA.TOT_CM/VVD.TOT_VOY)/(QTA.TOT_LOD/VVD.TOT_VOY) AS TOT_CMB," ).append("\n"); 
		query.append("            (QTA.TOT_RA_CM/VVD.TOT_VOY)/(QTA.TOT_LOD/VVD.TOT_VOY) AS TOT_RA_CMB," ).append("\n"); 
		query.append("            (QTA.TOT_OP/VVD.TOT_VOY) AS TOT_OP," ).append("\n"); 
		query.append("            (QTA.TOT_RA_OP/VVD.TOT_VOY) AS TOT_RA_OP," ).append("\n"); 
		query.append("            (QTA.TOT_OP/VVD.TOT_VOY)/(QTA.TOT_LOD/VVD.TOT_VOY) AS TOT_OPB," ).append("\n"); 
		query.append("            (QTA.TOT_RA_OP/VVD.TOT_VOY)/(QTA.TOT_LOD/VVD.TOT_VOY) AS TOT_RA_OPB" ).append("\n"); 
		query.append("     FROM   TMP_MON_TGT_VVD_ADJ ADJ," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT -- Recent Quota Monthly" ).append("\n"); 
		query.append("             	  QTA.GUBUN," ).append("\n"); 
		query.append("             	  QTA.BSE_MON," ).append("\n"); 
		query.append("             	  QTA.SUB_TRD_CD," ).append("\n"); 
		query.append("             	  QTA.RLANE_CD," ).append("\n"); 
		query.append("             	  QTA.RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("             	  QTA.TOT_LOD," ).append("\n"); 
		query.append("             	  QTA.TOT_REV ," ).append("\n"); 
		query.append("             	  QTA.TOT_RPB ," ).append("\n"); 
		query.append("             	  QTA.TOT_CM ," ).append("\n"); 
		query.append("             	  QTA.TOT_RA_CM ," ).append("\n"); 
		query.append("             	  QTA.TOT_CMB," ).append("\n"); 
		query.append("             	  QTA.TOT_RA_CMB ," ).append("\n"); 
		query.append("             	  QTA.TOT_OP ," ).append("\n"); 
		query.append("             	  QTA.TOT_RA_OP," ).append("\n"); 
		query.append("             	  QTA.TOT_OPB ," ).append("\n"); 
		query.append("             	  QTA.TOT_RA_OPB" ).append("\n"); 
		query.append("        	   FROM   TMP_INPUT_PARMAS INP, (" ).append("\n"); 
		query.append("                   SELECT -- Recent Quota Monthly" ).append("\n"); 
		query.append("             	         NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("             	         'MONTHLY' AS GUBUN," ).append("\n"); 
		query.append("             	         QTA.BSE_MON," ).append("\n"); 
		query.append("             	         VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("             	         QTA.RLANE_CD," ).append("\n"); 
		query.append("             	         QTA.RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("             	         SUM(QTA.LOD_QTY         ) AS TOT_LOD," ).append("\n"); 
		query.append("             	         SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("             	         SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY)/SUM(QTA.LOD_QTY) AS TOT_RPB ," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS TOT_RA_CM ," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY)/SUM(QTA.LOD_QTY) AS TOT_CMB," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY)" ).append("\n"); 
		query.append("                 	         /SUM(QTA.LOD_QTY) AS TOT_RA_CMB ," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY ) AS TOT_RA_OP," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    )" ).append("\n"); 
		query.append("                 	         /SUM(QTA.LOD_QTY) AS TOT_OPB ," ).append("\n"); 
		query.append("             	         SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY )" ).append("\n"); 
		query.append("                 	         /SUM(QTA.LOD_QTY) AS TOT_RA_OPB" ).append("\n"); 
		query.append("        	          FROM  (" ).append("\n"); 
		query.append("                		     SELECT DISTINCT" ).append("\n"); 
		query.append("                       	        RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                       	        RLS.BSE_YR AS BEF_YR," ).append("\n"); 
		query.append("                       	        RLS.BSE_QTR_CD AS BEF_QTR_CD" ).append("\n"); 
		query.append("                		     FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                                 TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                		     WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD = INP.BEF_YR_QTR" ).append("\n"); 
		query.append("                		     AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("              	         ) RLS," ).append("\n"); 
		query.append("              	         SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("              	         SAQ_MON_CFM_QTA     QTA," ).append("\n"); 
		query.append("              	         SAQ_MON_CFM_TGT_VVD VVD," ).append("\n"); 
		query.append("              	         TMP_INPUT_PARMAS    INP" ).append("\n"); 
		query.append("                   WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                   AND   QTA.BSE_MON = DECODE(RLS.BEF_QTR_CD, '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12')" ).append("\n"); 
		query.append("                   AND   QTA.QTA_TGT_CD = 'Q'" ).append("\n"); 
		query.append("                   AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("                   AND   QTA.RHQ_CD = INP.RHQ_CD" ).append("\n"); 
		query.append("                   AND   VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("                   AND   QTA.RLANE_CD LIKE INP.RLANE_CD || '%'" ).append("\n"); 
		query.append("                   AND   VVD.MQTA_RLSE_VER_NO = QTA.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                   AND   VVD.BSE_YR = QTA.BSE_YR" ).append("\n"); 
		query.append("                   AND   VVD.BSE_QTR_CD = QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND   VVD.BSE_MON = QTA.BSE_MON" ).append("\n"); 
		query.append("                   AND   VVD.RLANE_CD = QTA.RLANE_CD" ).append("\n"); 
		query.append("                   AND   VVD.TRD_CD = QTA.TRD_CD" ).append("\n"); 
		query.append("                   AND   VVD.DIR_CD = QTA.DIR_CD" ).append("\n"); 
		query.append("                   AND   VVD.VSL_CD = QTA.VSL_CD" ).append("\n"); 
		query.append("                   AND   VVD.SKD_VOY_NO = QTA.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND   VVD.SKD_DIR_CD = QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND   QTA.LOD_QTY > 0" ).append("\n"); 
		query.append("                   AND   QTA.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("                   AND   DIR.BSE_QTR_CD(+) = @[bse_quarter]" ).append("\n"); 
		query.append("                   AND   QTA.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("                   AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("                   AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("                   GROUP BY NVL(DIR.CONV_DIR_CD, QTA.DIR_CD), QTA.BSE_MON, VVD.SUB_TRD_CD,QTA.RLANE_CD,QTA.RHQ_CD" ).append("\n"); 
		query.append("              ) QTA" ).append("\n"); 
		query.append("              WHERE NVL(QTA.DIR_CD, INP.DIR_CD) = INP.DIR_CD" ).append("\n"); 
		query.append("           ) QTA, (" ).append("\n"); 
		query.append("            SELECT -- BSA, VOYAGE" ).append("\n"); 
		query.append("             	  VVD.BSE_MON," ).append("\n"); 
		query.append("             	  VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("             	  VVD.RLANE_CD," ).append("\n"); 
		query.append("             	  VVD.TOT_BSA," ).append("\n"); 
		query.append("             	  VVD.TOT_VOY" ).append("\n"); 
		query.append("            FROM   TMP_INPUT_PARMAS INP, (" ).append("\n"); 
		query.append("                   SELECT -- BSA, VOYAGE" ).append("\n"); 
		query.append("            		         NVL(DIR.CONV_DIR_CD, VVD.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("             	         VVD.BSE_MON," ).append("\n"); 
		query.append("             	         VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("             	         VVD.RLANE_CD," ).append("\n"); 
		query.append("             	         SUM(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("             	         COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY" ).append("\n"); 
		query.append("                   FROM   (" ).append("\n"); 
		query.append("                 	       SELECT DISTINCT" ).append("\n"); 
		query.append("                                   RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                        	          RLS.BSE_YR AS BEF_YR," ).append("\n"); 
		query.append("                        	          RLS.BSE_QTR_CD AS BEF_QTR_CD" ).append("\n"); 
		query.append("                 	       FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                        	          TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                 	       WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD = INP.BEF_YR_QTR" ).append("\n"); 
		query.append("                 	       AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("                	         ) RLS," ).append("\n"); 
		query.append("              	         SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("                	         SAQ_MON_CFM_TGT_VVD VVD," ).append("\n"); 
		query.append("                	         TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                   WHERE  VVD.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                   AND    VVD.BSE_MON = DECODE(RLS.BEF_QTR_CD, '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12')" ).append("\n"); 
		query.append("                   AND    VVD.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("                   AND    VVD.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("                   AND    VVD.RLANE_CD LIKE INP.RLANE_CD || '%'" ).append("\n"); 
		query.append("        	          AND    VVD.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("        	          AND    DIR.BSE_QTR_CD(+) = @[bse_quarter]" ).append("\n"); 
		query.append("        	          AND    VVD.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        	          AND    VVD.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        	          AND    VVD.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("                   GROUP BY NVL(DIR.CONV_DIR_CD, VVD.DIR_CD), VVD.BSE_MON, VVD.SUB_TRD_CD, VVD.RLANE_CD" ).append("\n"); 
		query.append("             ) VVD" ).append("\n"); 
		query.append("             WHERE NVL(VVD.DIR_CD, INP.DIR_CD) = INP.DIR_CD" ).append("\n"); 
		query.append("       ) VVD" ).append("\n"); 
		query.append("     WHERE QTA.BSE_MON = VVD.BSE_MON" ).append("\n"); 
		query.append("     AND   QTA.SUB_TRD_CD = VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND   QTA.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("     AND   ADJ.SUB_TRD_CD = QTA.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND   ADJ.RLANE_CD = QTA.RLANE_CD" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT -- Model Result" ).append("\n"); 
		query.append("         'MODEL' AS GUBUN," ).append("\n"); 
		query.append("         MIN(MRS.BSE_MON) AS BSE_MON," ).append("\n"); 
		query.append("         MRS.SUB_TRD_CD," ).append("\n"); 
		query.append("         (VVD.RLANE_CD||'-'||VVD.SPRT_GRP_CD||VVD.BSA_GRP_CD) AS LANE_GRP," ).append("\n"); 
		query.append("         MRS.CTRT_RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("         SUM(DISTINCT VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("         COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("         SUM(MRS.LOD_QTY         ) AS TOT_LOD ," ).append("\n"); 
		query.append("         SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("         SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS TOT_RPB ," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.CM_UC_AMT)*MRS.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.RA_CM_UC_AMT)*MRS.LOD_QTY) AS TOT_RA_CM ," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.CM_UC_AMT)*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS TOT_CMB," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.RA_CM_UC_AMT)*MRS.LOD_QTY)" ).append("\n"); 
		query.append("             /SUM(MRS.LOD_QTY) AS TOT_RA_CMB ," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.OPFIT_UC_AMT)*MRS.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.RA_OPFIT_UC_AMT)*MRS.LOD_QTY ) AS TOT_RA_OP," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.OPFIT_UC_AMT)*MRS.LOD_QTY    )" ).append("\n"); 
		query.append("             /SUM(MRS.LOD_QTY) AS TOT_OPB ," ).append("\n"); 
		query.append("         SUM((MRS.GRS_RPB_REV-MRS.RA_OPFIT_UC_AMT)*MRS.LOD_QTY )" ).append("\n"); 
		query.append("             /SUM(MRS.LOD_QTY) AS TOT_RA_OPB" ).append("\n"); 
		query.append("     FROM   SAQ_MON_MDL_CTRT_SMRY MRS," ).append("\n"); 
		query.append("            SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("            TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("     WHERE  MRS.MQTA_MDL_VER_NO = INP.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("     AND    MRS.BSE_YR||MRS.BSE_MON = INP.TGT_YR_MON" ).append("\n"); 
		query.append("     AND    MRS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("     AND    MRS.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("     AND    MRS.CTRT_RHQ_CD = INP.RHQ_CD" ).append("\n"); 
		query.append("     AND    MRS.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("     AND    MRS.RLANE_CD LIKE INP.RLANE_CD || '%'" ).append("\n"); 
		query.append("     AND    VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("     AND    VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND    VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("     AND    VVD.BSE_MON = MRS.BSE_MON" ).append("\n"); 
		query.append("     AND    VVD.RLANE_CD = MRS.RLANE_CD" ).append("\n"); 
		query.append("     AND    VVD.TRD_CD = MRS.TRD_CD" ).append("\n"); 
		query.append("     AND    VVD.DIR_CD = MRS.DIR_CD" ).append("\n"); 
		query.append("     AND    VVD.VSL_CD = MRS.VSL_CD" ).append("\n"); 
		query.append("     AND    VVD.SKD_VOY_NO = MRS.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND    VVD.SKD_DIR_CD = MRS.SKD_DIR_CD" ).append("\n"); 
		query.append("     GROUP BY MRS.SUB_TRD_CD, VVD.RLANE_CD, VVD.SPRT_GRP_CD, VVD.BSA_GRP_CD, MRS.CTRT_RHQ_CD" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT -- Final Adjusted" ).append("\n"); 
		query.append("         'ADJUSTED' AS GUBUN," ).append("\n"); 
		query.append("         MIN(RHQ.BSE_MON) AS BSE_MON," ).append("\n"); 
		query.append("         RHQ.SUB_TRD_CD," ).append("\n"); 
		query.append("         (RHQ.RLANE_CD||'-'||RHQ.SPRT_GRP_CD||RHQ.BSA_GRP_CD) AS LANE_GRP," ).append("\n"); 
		query.append("         (RHQ.CTRT_RHQ_CD) AS RHQ_CD," ).append("\n"); 
		query.append("         0 AS TOT_BSA ," ).append("\n"); 
		query.append("         MIN(VVD.TOT_VOY) AS TOT_VOY ," ).append("\n"); 
		query.append("         SUM(RHQ.LOD_QTY) AS TOT_LOD ," ).append("\n"); 
		query.append("         SUM(RHQ.GRS_RPB_REV*RHQ.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("         DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("             SUM(RHQ.GRS_RPB_REV*RHQ.LOD_QTY)/SUM(RHQ.LOD_QTY)) AS TOT_RPB," ).append("\n"); 
		query.append("         SUM((RHQ.GRS_RPB_REV-RHQ.CM_UC_AMT)*RHQ.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("         SUM((RHQ.GRS_RPB_REV-RHQ.RA_CM_UC_AMT)*RHQ.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("         DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("             SUM((RHQ.GRS_RPB_REV-RHQ.CM_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                 /SUM(RHQ.LOD_QTY)) AS TOT_CMB," ).append("\n"); 
		query.append("         DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("             SUM((RHQ.GRS_RPB_REV-RHQ.RA_CM_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                 /SUM(RHQ.LOD_QTY)) AS TOT_RA_CMB," ).append("\n"); 
		query.append("         SUM((RHQ.GRS_RPB_REV-RHQ.OPFIT_UC_AMT)*RHQ.LOD_QTY) AS TOT_OP," ).append("\n"); 
		query.append("         SUM((RHQ.GRS_RPB_REV-RHQ.RA_OPFIT_UC_AMT)*RHQ.LOD_QTY) AS TOT_RA_OP," ).append("\n"); 
		query.append("         DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("             SUM((RHQ.GRS_RPB_REV-RHQ.OPFIT_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                 /SUM(RHQ.LOD_QTY)) AS TOT_OPB," ).append("\n"); 
		query.append("         DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("             SUM((RHQ.GRS_RPB_REV-RHQ.RA_OPFIT_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                 /SUM(RHQ.LOD_QTY)) AS TOT_RA_OPB" ).append("\n"); 
		query.append("     FROM   SAQ_MON_QTA_STEP_VER VER," ).append("\n"); 
		query.append("            SAQ_MON_QTA_RHQ RHQ," ).append("\n"); 
		query.append("            TMP_INPUT_PARMAS INP," ).append("\n"); 
		query.append("            TMP_MON_TGT_VVD_ADJ VVD" ).append("\n"); 
		query.append("     WHERE  VER.MQTA_STEP_CD = '04' -- Final Adjusted" ).append("\n"); 
		query.append("     AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("     AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("     AND    VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("     AND    VER.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("     AND    VER.SAQ_STS_CD IN ('QN', 'QF')" ).append("\n"); 
		query.append("     AND    RHQ.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("     AND    RHQ.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("     AND    RHQ.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND    RHQ.BSE_MON = SUBSTR(INP.TGT_YR_MON, 5,2)" ).append("\n"); 
		query.append("     AND    RHQ.TRD_CD = VER.TRD_CD" ).append("\n"); 
		query.append("     AND    RHQ.DIR_CD = VER.DIR_CD" ).append("\n"); 
		query.append("     AND    RHQ.MQTA_VER_NO = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("     AND    RHQ.CTRT_RHQ_CD = INP.RHQ_CD" ).append("\n"); 
		query.append("     AND    RHQ.SUB_TRD_CD LIKE INP.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("     AND    RHQ.RLANE_CD LIKE INP.RLANE_CD  || '%'" ).append("\n"); 
		query.append("     AND    RHQ.SUB_TRD_CD = VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND    RHQ.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("     AND    RHQ.SPRT_GRP_CD = VVD.SPRT_GRP_CD" ).append("\n"); 
		query.append("     AND    RHQ.BSA_GRP_CD = VVD.BSA_GRP_CD" ).append("\n"); 
		query.append("     GROUP BY RHQ.SUB_TRD_CD,RHQ.RLANE_CD,RHQ.SPRT_GRP_CD,RHQ.BSA_GRP_CD, RHQ.CTRT_RHQ_CD" ).append("\n"); 
		query.append("     ) UNI" ).append("\n"); 
		query.append("        ,     (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    DIR.RLANE_CD," ).append("\n"); 
		query.append("                    DIR.DIR_CD" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    SAQ_MON_DIR_CONV DIR," ).append("\n"); 
		query.append("                    TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                WHERE" ).append("\n"); 
		query.append("                         DIR.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("                   AND DIR.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND DIR.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("                   AND DIR.CONV_DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("                ) DIR" ).append("\n"); 
		query.append(" WHERE  UNI.SUB_TRD_CD(+) = TRD.SUB_TRD_CD" ).append("\n"); 
		query.append(" AND    UNI.LANE_GRP(+) = TRD.LANE_GRP" ).append("\n"); 
		query.append(" AND    UNI.RHQ_CD(+) = TRD.RHQ_CD" ).append("\n"); 
		query.append(" AND    DIR.RLANE_CD(+) = TRD.RLANE_CD" ).append("\n"); 
		query.append(" GROUP BY TRD.SUB_TRD_CD, TRD.LANE_GRP, TRD.RHQ_CD, ITM.CODE, ITM.TEXT, ITM.ROW_SEQ, DIR.DIR_CD" ).append("\n"); 
		query.append(" ORDER BY KEY, LANE_GRP, RHQ_CD, ITM.ROW_SEQ" ).append("\n"); 

	}
}