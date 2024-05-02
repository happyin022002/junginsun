/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabTargetGroup0075Tab02List01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabTargetGroup0075Tab02List01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentRHQ 상단 Sub Trade TAB 의 데이타 모델에 해당되는 값을 불러온다.      
	  * 2011.02.15 김종준 [T-선사] YEARLY QTA 부분 삭제
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabTargetGroup0075Tab02List01RSQL(){
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
		params.put("pfmc_to_yr_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfmc_to_yr_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfmc_fr_yr_qtr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pfmc_fr_yr_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade_group",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOSearchMonthlyAdjustmentRHQTabTargetGroup0075Tab02List01RSQL").append("\n"); 
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
		query.append("    (SELECT DISTINCT" ).append("\n"); 
		query.append("            @[year] AS BSE_YR," ).append("\n"); 
		query.append("            @[bse_quarter] AS BSE_QTR_CD," ).append("\n"); 
		query.append("            @[quarter] AS BEF_YR_QTR," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), -1), 'YYYYMM') AS BEF_YR_MON," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), 1), 'YYYYMM') AS ADD1_YR_MON," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(@[year]||DECODE(@[bse_quarter],'1Q','01','2Q','04','3Q','07','4Q','10'), 'YYYYMM'), 2), 'YYYYMM') AS ADD2_YR_MON," ).append("\n"); 
		query.append("            @[pfmc_fr_yr_mon] AS PFMC_FR_YR_MON," ).append("\n"); 
		query.append("            @[pfmc_to_yr_mon] AS PFMC_TO_YR_MON," ).append("\n"); 
		query.append("            @[pfmc_fr_yr_qtr] AS PFMC_FR_YR_QTR," ).append("\n"); 
		query.append("            @[pfmc_to_yr_qtr] AS PFMC_TO_YR_QTR," ).append("\n"); 
		query.append("            @[bound] AS DIR_CD," ).append("\n"); 
		query.append("            SAQ_TGT_GRP_CD," ).append("\n"); 
		query.append("            TRD_CD AS TRD_CD," ).append("\n"); 
		query.append("            @[slsFcastPubNo] AS SLS_FCAST_PUB_NO," ).append("\n"); 
		query.append("            @[mqta_mdl_ver_no] AS MQTA_MDL_VER_NO," ).append("\n"); 
		query.append("            @[glineVerNo] AS GLINE_VER_NO," ).append("\n"); 
		query.append("            @[mQtaVerNo] AS MQTA_VER_NO," ).append("\n"); 
		query.append("            @[trade] AS SEL_TRD_CD," ).append("\n"); 
		query.append("            @[ctrt_rhq_cd] AS CTRT_RHQ_CD," ).append("\n"); 
		query.append("            @[ctrt_rgn_ofc_cd] AS CTRT_RGN_OFC_CD," ).append("\n"); 
		query.append("            DECODE(@[ctrt_rgn_ofc_cd], '', '04', '05') AS FIRST_STEP," ).append("\n"); 
		query.append("            DECODE(@[ctrt_rgn_ofc_cd], '', '05', '04') AS SECOND_STEP," ).append("\n"); 
		query.append("            DECODE(@[ctrt_rgn_ofc_cd], '', 'FC', 'FN') AS FINAL_STATUS" ).append("\n"); 
		query.append("     FROM   SAQ_TGT_GRP_TRD" ).append("\n"); 
		query.append("     WHERE  SAQ_TGT_GRP_CD = @[trade_group]" ).append("\n"); 
		query.append("     AND    TRD_CD = @[trade] )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    DECODE(UNI.DIR_CD, 'TOTAL', 1, 2)  AS SLEVEL," ).append("\n"); 
		query.append("    UNI.SUB_TRD_CD AS SUB_TRD_CD," ).append("\n"); 
		query.append("    UNI.DIR_CD AS DIR_CD," ).append("\n"); 
		query.append("    ITM.ROW_SEQ," ).append("\n"); 
		query.append("    REPLACE(ITM.TEXT,'(P)','') AS ITEM_TEXT," ).append("\n"); 
		query.append("    DECODE( ITM.CODE," ).append("\n"); 
		query.append("             '05', REPLACE(ITM.TEXT,'(P)','')||'*', -- G.REV" ).append("\n"); 
		query.append("             '07', REPLACE(ITM.TEXT,'(P)','')||'*', -- CM" ).append("\n"); 
		query.append("             '08', REPLACE(ITM.TEXT,'(P)','')||'*', -- CM" ).append("\n"); 
		query.append("             '11', REPLACE(ITM.TEXT,'(P)','')||'*', -- OP" ).append("\n"); 
		query.append("             '12', REPLACE(ITM.TEXT,'(P)','')||'*', -- OP" ).append("\n"); 
		query.append("             REPLACE(ITM.TEXT,'(P)','') ) AS ITEM," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'PFMC_QTA' AND UNI.MON_SEQ = '0' THEN" ).append("\n"); 
		query.append("           DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("                    '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                    '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                    '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("                    '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                    '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                    '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                    '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                    '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                    '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                    '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                    '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                    '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                    '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("           END) AS PFMC_QTA," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'PFMC_SMR' AND UNI.MON_SEQ = '0' THEN" ).append("\n"); 
		query.append("           DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("                    '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                    '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                    '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("                    '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                    '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                    '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                    '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                    '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                    '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                    '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                    '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                    '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                    '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("           END) AS PFMC_SMR," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'MONTHLY' AND UNI.MON_SEQ = '0' THEN" ).append("\n"); 
		query.append("           DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("                    '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                    '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                    '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("                    '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                    '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                    '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                    '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                    '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                    '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                    '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                    '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                    '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                    '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS RECENT_MON," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    DECODE( ITM.CODE,  '01', SUM( DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_BSA,0))," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0))," ).append("\n"); 
		query.append("                '04', DECODE(SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_BSA,0)), 0, '', ROUND((SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0))/SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_BSA,0)))*100, 1))," ).append("\n"); 
		query.append("                '05', SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_REV,0))/1000," ).append("\n"); 
		query.append("                '06', DECODE(SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_REV,0))/SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '07', SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_CM,0))/1000," ).append("\n"); 
		query.append("                '08', 0," ).append("\n"); 
		query.append("                '09', DECODE(SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_CM,0))/SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '10', 0," ).append("\n"); 
		query.append("                '11', SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_OP,0))/1000," ).append("\n"); 
		query.append("                '12', SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_RA_OP,0))/1000," ).append("\n"); 
		query.append("                '13', DECODE(SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_OP,0))/SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '14', DECODE(SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_RA_OP,0))/SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0)))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AS FORECAST_TOT," ).append("\n"); 
		query.append("    DECODE( ITM.CODE,  '01', SUM( DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_BSA,0))," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0))," ).append("\n"); 
		query.append("                '04', DECODE(SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_BSA,0)), 0, '', ROUND((SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0))/SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_BSA,0)))*100, 1))," ).append("\n"); 
		query.append("                '05', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_REV,0))/1000," ).append("\n"); 
		query.append("                '06', DECODE(SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_REV,0))/SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '07', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_CM,0))/1000," ).append("\n"); 
		query.append("                '08', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_RA_CM,0))/1000," ).append("\n"); 
		query.append("                '09', DECODE(SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_CM,0))/SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '10', DECODE(SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_RA_CM,0))/SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '11', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_OP,0))/1000," ).append("\n"); 
		query.append("                '12', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_RA_OP,0))/1000," ).append("\n"); 
		query.append("                '13', DECODE(SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_OP,0))/SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '14', DECODE(SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_RA_OP,0))/SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0)))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AS MODEL_TOT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    DECODE( ITM.CODE,  '01', SUM( DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_BSA,0))," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0))," ).append("\n"); 
		query.append("                '04', DECODE(SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_BSA,0)), 0, '', ROUND((SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0))/SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_BSA,0)))*100, 1))," ).append("\n"); 
		query.append("                '05', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_REV,0))/1000," ).append("\n"); 
		query.append("                '06', DECODE(SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_REV,0))/SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '07', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_CM,0))/1000," ).append("\n"); 
		query.append("                '08', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_RA_CM,0))/1000," ).append("\n"); 
		query.append("                '09', DECODE(SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_CM,0))/SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '10', DECODE(SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_RA_CM,0))/SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '11', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_OP,0))/1000," ).append("\n"); 
		query.append("                '12', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_RA_OP,0))/1000," ).append("\n"); 
		query.append("                '13', DECODE(SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_OP,0))/SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '14', DECODE(SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_RA_OP,0))/SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0)))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AS INITIAL_TOT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    DECODE( ITM.CODE,  '01', SUM( DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_BSA,0))," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0))," ).append("\n"); 
		query.append("                '04', DECODE(SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_BSA,0)), 0, '', ROUND((SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0))/SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_BSA,0)))*100, 1))," ).append("\n"); 
		query.append("                '05', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_REV,0))/1000," ).append("\n"); 
		query.append("                '06', DECODE(SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_REV,0))/SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '07', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_CM,0))/1000," ).append("\n"); 
		query.append("                '08', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_RA_CM,0))/1000," ).append("\n"); 
		query.append("                '09', DECODE(SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_CM,0))/SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '10', DECODE(SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_RA_CM,0))/SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '11', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_OP,0))/1000," ).append("\n"); 
		query.append("                '12', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_RA_OP,0))/1000," ).append("\n"); 
		query.append("                '13', DECODE(SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_OP,0))/SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)))," ).append("\n"); 
		query.append("                '14', DECODE(SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)),0,0,  SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_RA_OP,0))/SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0)))" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AS FINAL_TOT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 1번째 월 부터 3번째 월까지 반복  " ).append("\n"); 
		query.append("#foreach( $key in ${monthseq})" ).append("\n"); 
		query.append("	,MIN(CASE WHEN UNI.GUBUN = 'FORECAST' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("	       DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("	                '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("	                '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("	                '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("	                '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("	                '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("	                '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("	                '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("	                '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("	                '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("	                '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("	                '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("	                '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("	                '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("	       END) AS FCAST_$key," ).append("\n"); 
		query.append("	MIN(CASE WHEN UNI.GUBUN = 'MODEL' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("	       DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("	                '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("	                '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("	                '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("	                '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("	                '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("	                '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("	                '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("	                '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("	                '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("	                '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("	                '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("	                '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("	                '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("	       END) AS MDL_RST_$key," ).append("\n"); 
		query.append("	MIN(CASE WHEN UNI.GUBUN = 'RHQ' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("	       DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("	                '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("	                '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("	                '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("	                '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("	                '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("	                '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("	                '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("	                '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("	                '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("	                '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("	                '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("	                '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("	                '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("	       END) AS FINAL_$key," ).append("\n"); 
		query.append("	MIN(CASE WHEN UNI.GUBUN = 'INITIAL' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("	       DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("	                '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("	                '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("	                '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("	                '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("	                '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("	                '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("	                '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("	                '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("	                '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("	                '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("	                '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("	                '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("	                '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("	       END) AS INITIAL_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  INTG_CD_VAL_CTNT AS CODE," ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_DESC AS TEXT," ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_SEQ AS ROW_SEQ" ).append("\n"); 
		query.append("    FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ctrt_rgn_ofc_cd} != '') " ).append("\n"); 
		query.append("	WHERE INTG_CD_ID = 'CD01391'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	WHERE INTG_CD_ID = 'CD01388'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) ITM, (" ).append("\n"); 
		query.append("    SELECT -- Performance Quota Monthly" ).append("\n"); 
		query.append("        'PFMC_QTA' AS GUBUN," ).append("\n"); 
		query.append("        '0' AS MON_SEQ," ).append("\n"); 
		query.append("        '00' AS BSE_MON," ).append("\n"); 
		query.append("        DECODE(QTA.SUB_TRD_CD, '', 'TOTAL', QTA.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(QTA.DIR_CD, '', 'TOTAL', QTA.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("        SUM(QTA.TOT_BSA) AS TOT_BSA," ).append("\n"); 
		query.append("        SUM(QTA.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(QTA.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(QTA.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        SUM(QTA.TOT_REV)/SUM(QTA.TOT_LOD) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        SUM(QTA.TOT_CM)/SUM(QTA.TOT_LOD) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_CM)/SUM(QTA.TOT_LOD) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM(QTA.TOT_OP)/SUM(QTA.TOT_LOD) AS TOT_OPB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_OP)/SUM(QTA.TOT_LOD) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT -- MONTHLY Quota Monthly" ).append("\n"); 
		query.append("            MIN(DECODE(QTA.BSE_YR||QTA.BSE_MON, INP.BEF_YR_MON, '0'," ).append("\n"); 
		query.append("                INP.ADD1_YR_MON, '2', INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("            QTA.BSE_MON," ).append("\n"); 
		query.append("            VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("            NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(QTA.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("    FROM  (" ).append("\n"); 
		query.append("            SELECT DISTINCT" ).append("\n"); 
		query.append("                   RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                   RLS.BSE_QTR_CD AS BSE_QTR_CD" ).append("\n"); 
		query.append("            FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                   TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD BETWEEN (SELECT DISTINCT PFMC_FR_YR_QTR FROM TMP_INPUT_PARMAS )" ).append("\n"); 
		query.append("                                                  AND    (SELECT DISTINCT  INP.PFMC_TO_YR_QTR FROM TMP_INPUT_PARMAS )" ).append("\n"); 
		query.append("            AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("          ) RLS," ).append("\n"); 
		query.append("          TMP_INPUT_PARMAS 		INP," ).append("\n"); 
		query.append("          SAQ_MON_DIR_CONV  		DIR," ).append("\n"); 
		query.append("          SAQ_MON_CFM_QTA 		QTA," ).append("\n"); 
		query.append("          SAQ_MON_CFM_TGT_VVD 	VVD" ).append("\n"); 
		query.append("    WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND   QTA.BSE_QTR_CD = RLS.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND   QTA.RHQ_CD LIKE INP.CTRT_RHQ_CD||'%'" ).append("\n"); 
		query.append("    AND   QTA.RGN_OFC_CD LIKE INP.CTRT_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR||QTA.BSE_MON BETWEEN PFMC_FR_YR_MON AND PFMC_TO_YR_MON" ).append("\n"); 
		query.append("    AND   QTA.LOD_QTY > 0" ).append("\n"); 
		query.append("    AND   QTA.QTA_TGT_CD = 'Q' -- Q : Sales Quota, T : Load Target" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR = VVD.BSE_YR" ).append("\n"); 
		query.append("    AND   QTA.BSE_MON = VVD.BSE_MON" ).append("\n"); 
		query.append("    AND   QTA.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD = VVD.TRD_CD" ).append("\n"); 
		query.append("    AND   QTA.DIR_CD = VVD.DIR_CD" ).append("\n"); 
		query.append("    AND   QTA.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("    AND   QTA.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("    AND   QTA.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   QTA.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND   QTA.MQTA_RLSE_VER_NO = VVD.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("    AND   DIR.BSE_QTR_CD(+) = @[bse_quarter]" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("    AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("    GROUP BY QTA.BSE_YR, QTA.BSE_MON, VVD.SUB_TRD_CD, QTA.RLANE_CD, NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) ," ).append("\n"); 
		query.append("             VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) QTA" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(QTA.SUB_TRD_CD, QTA.DIR_CD)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Performance Est. PFMC" ).append("\n"); 
		query.append("        'PFMC_SMR' AS GUBUN," ).append("\n"); 
		query.append("        '0' AS MON_SEQ," ).append("\n"); 
		query.append("        '00' AS BSE_MON," ).append("\n"); 
		query.append("        DECODE(BPS.SUB_TRD_CD, '', 'TOTAL', BPS.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(BPS.DIR_CD, '', 'TOTAL', BPS.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("        SUM(BPS.TOT_BSA) AS TOT_BSA," ).append("\n"); 
		query.append("        SUM(BPS.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(BPS.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(BPS.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        SUM(BPS.TOT_REV)/SUM(BPS.TOT_LOD) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM(BPS.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        SUM(BPS.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        SUM(BPS.TOT_CM)/SUM(BPS.TOT_LOD) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM(BPS.TOT_RA_CM)/SUM(BPS.TOT_LOD) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM(BPS.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        SUM(BPS.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM(BPS.TOT_OP)/SUM(BPS.TOT_LOD) AS TOT_OPB," ).append("\n"); 
		query.append("        SUM(BPS.TOT_RA_OP)/SUM(BPS.TOT_LOD) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT -- Performance Est. PFMC" ).append("\n"); 
		query.append("            MIN(DECODE(BPS.BSE_YR||BPS.BSE_MON, INP.BEF_YR_MON, '0'," ).append("\n"); 
		query.append("                INP.ADD1_YR_MON, '2', INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("            BPS.BSE_MON," ).append("\n"); 
		query.append("            BPS.SUB_TRD_CD," ).append("\n"); 
		query.append("            NVL(DIR.CONV_DIR_CD, BPS.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            MIN(VVD.VOY_KNT) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(BPS.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            SUM(BPS.GRS_RPB_REV*BPS.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            SUM((BPS.GRS_RPB_REV-BPS.CM_UC_AMT)*BPS.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            SUM((BPS.GRS_RPB_REV-BPS.RA_CM_UC_AMT)*BPS.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            SUM((BPS.GRS_RPB_REV-BPS.OPFIT_UC_AMT)*BPS.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            SUM((BPS.GRS_RPB_REV-BPS.RA_OPFIT_UC_AMT)*BPS.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("        FROM  SAQ_PERF_OFC_SMRY BPS," ).append("\n"); 
		query.append("              SAQ_PERF_TGT_LANE VVD," ).append("\n"); 
		query.append("              SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("              ( SELECT DISTINCT ADJ.TRD_CD, ADJ.DIR_CD, ADJ.RLANE_CD" ).append("\n"); 
		query.append("                FROM   SAQ_MON_TGT_VVD_ADJ ADJ, TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                WHERE  1=1" ).append("\n"); 
		query.append("                AND    ADJ.GLINE_VER_NO = INP.GLINE_VER_NO   ) ADJ," ).append("\n"); 
		query.append("              TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("        WHERE BPS.BSE_YR||BPS.BSE_MON BETWEEN PFMC_FR_YR_MON AND PFMC_TO_YR_MON" ).append("\n"); 
		query.append("        AND   BPS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        AND   BPS.CTRT_RHQ_CD LIKE INP.CTRT_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND   BPS.CTRT_RGN_OFC_CD LIKE INP.CTRT_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("        AND   VVD.BSE_YR = BPS.BSE_YR" ).append("\n"); 
		query.append("        AND   VVD.BSE_MON = BPS.BSE_MON" ).append("\n"); 
		query.append("        AND   VVD.RLANE_CD = BPS.RLANE_CD" ).append("\n"); 
		query.append("        AND   VVD.TRD_CD = BPS.TRD_CD" ).append("\n"); 
		query.append("        AND   VVD.DIR_CD = BPS.DIR_CD" ).append("\n"); 
		query.append("        AND   BPS.LOD_QTY > 0" ).append("\n"); 
		query.append("        AND   BPS.TRD_CD = ADJ.TRD_CD" ).append("\n"); 
		query.append("        AND   BPS.DIR_CD = ADJ.DIR_CD" ).append("\n"); 
		query.append("        AND   BPS.RLANE_CD = ADJ.RLANE_CD" ).append("\n"); 
		query.append("        AND   BPS.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("        AND   DIR.BSE_QTR_CD(+) = @[bse_quarter]" ).append("\n"); 
		query.append("        AND   BPS.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        AND   BPS.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND   BPS.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("        GROUP BY BPS.BSE_YR, BPS.BSE_MON, BPS.SUB_TRD_CD, BPS.RLANE_CD, NVL(DIR.CONV_DIR_CD, BPS.DIR_CD)" ).append("\n"); 
		query.append("        ) BPS" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(BPS.SUB_TRD_CD, BPS.DIR_CD)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- MONTHLY Quota (Recent)" ).append("\n"); 
		query.append("        'MONTHLY' AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        QTA.BSE_MON," ).append("\n"); 
		query.append("        DECODE(QTA.SUB_TRD_CD, '', 'TOTAL', QTA.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(QTA.DIR_CD, '', 'TOTAL', QTA.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("        SUM(QTA.TOT_BSA) AS TOT_BSA," ).append("\n"); 
		query.append("        SUM(QTA.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(QTA.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(QTA.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        SUM(QTA.TOT_REV)/SUM(QTA.TOT_LOD) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        SUM(QTA.TOT_CM)/SUM(QTA.TOT_LOD) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_CM)/SUM(QTA.TOT_LOD) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM(QTA.TOT_OP)/SUM(QTA.TOT_LOD) AS TOT_OPB," ).append("\n"); 
		query.append("        SUM(QTA.TOT_RA_OP)/SUM(QTA.TOT_LOD) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT -- MONTHLY Quota (Recent)" ).append("\n"); 
		query.append("            MIN(DECODE(QTA.BSE_YR||QTA.BSE_MON, INP.BEF_YR_MON, '0'," ).append("\n"); 
		query.append("                INP.ADD1_YR_MON, '2', INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("            QTA.BSE_MON," ).append("\n"); 
		query.append("            VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("            NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(QTA.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("        FROM  (" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                       RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                       RLS.BSE_YR AS BEF_YR," ).append("\n"); 
		query.append("                       RLS.BSE_QTR_CD AS BEF_QTR_CD" ).append("\n"); 
		query.append("                FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                       TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD = INP.BEF_YR_QTR" ).append("\n"); 
		query.append("                AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("              ) RLS," ).append("\n"); 
		query.append("              SAQ_MON_DIR_CONV    DIR," ).append("\n"); 
		query.append("              SAQ_MON_CFM_QTA     QTA," ).append("\n"); 
		query.append("              SAQ_MON_CFM_TGT_VVD VVD," ).append("\n"); 
		query.append("              TMP_INPUT_PARMAS    INP" ).append("\n"); 
		query.append("        WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        AND   QTA.BSE_MON = DECODE(RLS.BEF_QTR_CD, '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12')" ).append("\n"); 
		query.append("        AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        AND   QTA.QTA_TGT_CD = 'Q'" ).append("\n"); 
		query.append("        AND   QTA.RHQ_CD LIKE INP.CTRT_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND   QTA.RGN_OFC_CD LIKE INP.CTRT_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("        AND   VVD.MQTA_RLSE_VER_NO = QTA.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        AND   VVD.BSE_YR = QTA.BSE_YR" ).append("\n"); 
		query.append("        AND   VVD.BSE_QTR_CD = QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND   VVD.BSE_MON = QTA.BSE_MON" ).append("\n"); 
		query.append("        AND   VVD.RLANE_CD = QTA.RLANE_CD" ).append("\n"); 
		query.append("        AND   VVD.TRD_CD = QTA.TRD_CD" ).append("\n"); 
		query.append("        AND   VVD.DIR_CD = QTA.DIR_CD" ).append("\n"); 
		query.append("        AND   VVD.VSL_CD = QTA.VSL_CD" ).append("\n"); 
		query.append("        AND   VVD.SKD_VOY_NO = QTA.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND   VVD.SKD_DIR_CD = QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND   QTA.LOD_QTY > 0" ).append("\n"); 
		query.append("        AND   QTA.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("        AND   DIR.BSE_QTR_CD(+) = @[bse_quarter]" ).append("\n"); 
		query.append("        AND   QTA.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("        GROUP BY QTA.BSE_YR, QTA.BSE_MON, VVD.SUB_TRD_CD, QTA.RLANE_CD, NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) ," ).append("\n"); 
		query.append("                 VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) QTA" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(QTA.SUB_TRD_CD, QTA.DIR_CD), QTA.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Model Result" ).append("\n"); 
		query.append("        'MODEL' AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        MRS.BSE_MON," ).append("\n"); 
		query.append("        DECODE(MRS.SUB_TRD_CD, '', 'TOTAL', MRS.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(MRS.DIR_CD, '', 'TOTAL', MRS.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("        SUM(MRS.TOT_BSA) AS TOT_BSA," ).append("\n"); 
		query.append("        SUM(MRS.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(MRS.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(MRS.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        SUM(MRS.TOT_REV)/SUM(MRS.TOT_LOD) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM(MRS.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        SUM(MRS.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        SUM(MRS.TOT_CM)/SUM(MRS.TOT_LOD) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM(MRS.TOT_RA_CM)/SUM(MRS.TOT_LOD) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM(MRS.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        SUM(MRS.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM(MRS.TOT_OP)/SUM(MRS.TOT_LOD) AS TOT_OPB," ).append("\n"); 
		query.append("        SUM(MRS.TOT_RA_OP)/SUM(MRS.TOT_LOD) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT -- Model Result" ).append("\n"); 
		query.append("            MIN(DECODE(MRS.BSE_YR||MRS.BSE_MON, INP.BEF_YR_MON, '0'," ).append("\n"); 
		query.append("                INP.ADD1_YR_MON, '2', INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("            MRS.BSE_MON," ).append("\n"); 
		query.append("            MRS.SUB_TRD_CD," ).append("\n"); 
		query.append("            MRS.DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(MRS.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.CM_UC_AMT)*MRS.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.RA_CM_UC_AMT)*MRS.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.OPFIT_UC_AMT)*MRS.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.RA_OPFIT_UC_AMT)*MRS.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("	       FROM  SAQ_MON_MDL_CTRT_SMRY MRS," ).append("\n"); 
		query.append("	             SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("	             TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("	       WHERE MRS.MQTA_MDL_VER_NO = INP.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("	       AND   MRS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("	       AND   MRS.CTRT_RHQ_CD LIKE INP.CTRT_RHQ_CD||'%'" ).append("\n"); 
		query.append("	       AND   MRS.CTRT_RGN_OFC_CD LIKE INP.CTRT_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("	       AND   VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("	       AND   VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("	       AND   VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("	       AND   VVD.BSE_MON = MRS.BSE_MON" ).append("\n"); 
		query.append("	       AND   VVD.RLANE_CD = MRS.RLANE_CD" ).append("\n"); 
		query.append("	       AND   VVD.TRD_CD = MRS.TRD_CD" ).append("\n"); 
		query.append("	       AND   VVD.DIR_CD = MRS.DIR_CD" ).append("\n"); 
		query.append("	       AND   VVD.VSL_CD = MRS.VSL_CD" ).append("\n"); 
		query.append("	       AND   VVD.SKD_VOY_NO = MRS.SKD_VOY_NO" ).append("\n"); 
		query.append("	       AND   VVD.SKD_DIR_CD = MRS.SKD_DIR_CD" ).append("\n"); 
		query.append("	       AND   MRS.LOD_QTY > 0" ).append("\n"); 
		query.append("        GROUP BY MRS.BSE_YR, MRS.BSE_MON, MRS.SUB_TRD_CD, MRS.RLANE_CD, MRS.DIR_CD," ).append("\n"); 
		query.append("        		 VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) MRS" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(MRS.SUB_TRD_CD, MRS.DIR_CD), MRS.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- RHQ, RGN, Final" ).append("\n"); 
		query.append("        DECODE(RHQ.MQTA_STEP_CD, '04','RHQ', '05','RGN', '06','FINAL','07','INITIAL') AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        RHQ.BSE_MON," ).append("\n"); 
		query.append("        DECODE(RHQ.SUB_TRD_CD, '', 'TOTAL', RHQ.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(RHQ.DIR_CD, '', 'TOTAL', RHQ.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_BSA*RHQ.TOT_VOY) AS TOT_BSA," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.TOT_LOD), 0, 0," ).append("\n"); 
		query.append("            SUM(RHQ.TOT_REV)/SUM(RHQ.TOT_LOD)) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.TOT_LOD), 0, 0," ).append("\n"); 
		query.append("            SUM(RHQ.TOT_CM)/SUM(RHQ.TOT_LOD)) AS TOT_CMB," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.TOT_LOD), 0, 0," ).append("\n"); 
		query.append("            SUM(RHQ.TOT_RA_CM)/SUM(RHQ.TOT_LOD)) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        SUM(RHQ.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.TOT_LOD), 0, 0," ).append("\n"); 
		query.append("            SUM(RHQ.TOT_OP)/SUM(RHQ.TOT_LOD)) AS TOT_OPB," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.TOT_LOD), 0, 0," ).append("\n"); 
		query.append("            SUM(RHQ.TOT_RA_OP)/SUM(RHQ.TOT_LOD)) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT -- RHQ, RGN, Final" ).append("\n"); 
		query.append("            RHQ.MQTA_STEP_CD," ).append("\n"); 
		query.append("            MIN(DECODE(RHQ.BSE_YR||RHQ.BSE_MON, INP.ADD1_YR_MON, '2'," ).append("\n"); 
		query.append("                INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("            RHQ.BSE_MON AS BSE_MON," ).append("\n"); 
		query.append("            RHQ.SUB_TRD_CD AS SUB_TRD_CD," ).append("\n"); 
		query.append("            RHQ.DIR_CD AS DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(RHQ.LOD_QTY         ) AS TOT_LOD ," ).append("\n"); 
		query.append("            SUM(RHQ.GRS_RPB_REV*RHQ.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.CM_UC_AMT)*RHQ.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.RA_CM_UC_AMT)*RHQ.LOD_QTY) AS TOT_RA_CM ," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.OPFIT_UC_AMT)*RHQ.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.RA_OPFIT_UC_AMT)*RHQ.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("        FROM   SAQ_MON_QTA_STEP_VER VER," ).append("\n"); 
		query.append("               SAQ_MON_QTA_RHQ RHQ," ).append("\n"); 
		query.append("               SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("               TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("        WHERE  VER.MQTA_STEP_CD IN ('04', '05', '06','07') -- RHQ, RGN, Final" ).append("\n"); 
		query.append("        AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("        AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        AND    VER.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("        AND    ((VER.MQTA_STEP_CD = INP.FIRST_STEP AND VER.MQTA_VER_NO = INP.MQTA_VER_NO" ).append("\n"); 
		query.append("                    AND VER.TRD_CD = INP.SEL_TRD_CD AND VER.DIR_CD = INP.DIR_CD)" ).append("\n"); 
		query.append("                OR (VER.MQTA_STEP_CD = INP.FIRST_STEP" ).append("\n"); 
		query.append("                    AND NOT(VER.TRD_CD = INP.SEL_TRD_CD AND VER.DIR_CD = INP.DIR_CD)" ).append("\n"); 
		query.append("                    AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                      FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                           COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                      WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                                      AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                                      AND B.INTG_CD_VAL_CTNT = 'DC'" ).append("\n"); 
		query.append("                                      AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ))" ).append("\n"); 
		query.append("                OR (VER.MQTA_STEP_CD = INP.SECOND_STEP AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                      FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                           COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                      WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                                      AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                                      AND B.INTG_CD_VAL_CTNT = 'DN'" ).append("\n"); 
		query.append("                                      AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ))" ).append("\n"); 
		query.append(" 		       OR" ).append("\n"); 
		query.append(" 		          (" ).append("\n"); 
		query.append(" 			        (" ).append("\n"); 
		query.append(" 				       VER.MQTA_STEP_CD = '06'" ).append("\n"); 
		query.append(" 				       AND INP.FIRST_STEP = '04' AND VER.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append(" 				       AND VER.TRD_CD = INP.SEL_TRD_CD AND VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append(" 			        )" ).append("\n"); 
		query.append(" 			        OR" ).append("\n"); 
		query.append("                     (VER.MQTA_STEP_CD = '06' AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                      FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                           COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                      WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                                      AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                                      AND B.INTG_CD_VAL_CTNT = INP.FINAL_STATUS" ).append("\n"); 
		query.append("                                      AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ)))" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("			          ( VER.MQTA_STEP_CD = '07' AND VER.SAQ_STS_CD IN  (" ).append("\n"); 
		query.append("			 		             SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                               FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                     COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                              WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                               AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                               AND B.INTG_CD_VAL_CTNT = '00'" ).append("\n"); 
		query.append("                               AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ  )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        AND    RHQ.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("        AND    RHQ.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("        AND    RHQ.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND    RHQ.TRD_CD = VER.TRD_CD" ).append("\n"); 
		query.append("        AND    RHQ.DIR_CD = VER.DIR_CD" ).append("\n"); 
		query.append("        AND    RHQ.MQTA_VER_NO = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("        AND    RHQ.CTRT_RHQ_CD LIKE INP.CTRT_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND    RHQ.CTRT_RGN_OFC_CD LIKE INP.CTRT_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("        AND    VVD.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("        AND    VVD.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND    VVD.GLINE_VER_NO = VER.GLINE_VER_NO" ).append("\n"); 
		query.append("        AND    VVD.BSE_MON = RHQ.BSE_MON" ).append("\n"); 
		query.append("        AND    VVD.TRD_CD = RHQ.TRD_CD" ).append("\n"); 
		query.append("        AND    VVD.DIR_CD = RHQ.DIR_CD" ).append("\n"); 
		query.append("        AND    VVD.SUB_TRD_CD = RHQ.SUB_TRD_CD" ).append("\n"); 
		query.append("        AND    VVD.RLANE_CD = RHQ.RLANE_CD" ).append("\n"); 
		query.append("        AND    VVD.SPRT_GRP_CD = RHQ.SPRT_GRP_CD" ).append("\n"); 
		query.append("        AND    VVD.BSA_GRP_CD = RHQ.BSA_GRP_CD" ).append("\n"); 
		query.append("        GROUP BY RHQ.MQTA_STEP_CD,RHQ.BSE_YR,RHQ.BSE_MON,RHQ.SUB_TRD_CD,RHQ.RLANE_CD,RHQ.DIR_CD," ).append("\n"); 
		query.append("                 RHQ.SPRT_GRP_CD,RHQ.BSA_GRP_CD" ).append("\n"); 
		query.append("        ) RHQ" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(RHQ.SUB_TRD_CD, RHQ.DIR_CD), RHQ.MQTA_STEP_CD, RHQ.BSE_MON" ).append("\n"); 
		query.append("    ) UNI" ).append("\n"); 
		query.append("WHERE UNI.SUB_TRD_CD <> 'TOTAL'" ).append("\n"); 
		query.append("GROUP BY UNI.SUB_TRD_CD, UNI.DIR_CD, ITM.CODE, ITM.TEXT, ITM.ROW_SEQ" ).append("\n"); 
		query.append("ORDER BY UNI.SUB_TRD_CD," ).append("\n"); 
		query.append("         DECODE(UNI.DIR_CD, 'TOTAL', '1', UNI.DIR_CD), ITM.ROW_SEQ" ).append("\n"); 

	}
}