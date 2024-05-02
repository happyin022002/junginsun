/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentSlsRHQ 상단 TargetGroup/Trade TAB 의 데이타 모델에 해당되는 값을 불러온다.
	  * 2011.02.17  UNION 절 제거(예외처리 제거)
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pfmc_to_yr_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add1_yr_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slsRhqCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slsRgnOfcCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bef_yr_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qtaMstVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add2_yr_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mQtaVerNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01RSQL").append("\n"); 
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
		query.append("    (" ).append("\n"); 
		query.append("     SELECT DISTINCT" ).append("\n"); 
		query.append("            @[year] AS BSE_YR," ).append("\n"); 
		query.append("            @[bse_qtr_cd] AS BSE_QTR_CD," ).append("\n"); 
		query.append("            @[bef_yr_qtr] AS BEF_YR_QTR," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(@[bef_yr_mon], 'YYYYMM'), -1), 'YYYYMM') AS BEF_YR_MON," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(@[add1_yr_mon], 'YYYYMM'), 1), 'YYYYMM') AS ADD1_YR_MON," ).append("\n"); 
		query.append("            TO_CHAR(ADD_MONTHS(TO_DATE(@[add2_yr_mon], 'YYYYMM'), 2), 'YYYYMM') AS ADD2_YR_MON," ).append("\n"); 
		query.append("            @[pfmc_fr_yr_qtr] AS PFMC_FR_YR_QTR," ).append("\n"); 
		query.append("            @[pfmc_to_yr_qtr] AS PFMC_TO_YR_QTR," ).append("\n"); 
		query.append("            @[pfmc_fr_yr_mon] AS PFMC_FR_YR_MON," ).append("\n"); 
		query.append("            @[pfmc_to_yr_mon] AS PFMC_TO_YR_MON," ).append("\n"); 
		query.append("            @[trade] AS SEL_TRD_CD," ).append("\n"); 
		query.append("            @[bound] AS SEL_DIR_CD," ).append("\n"); 
		query.append("            A.DIR_CD AS DIR_CD," ).append("\n"); 
		query.append("            A.SAQ_TGT_GRP_CD," ).append("\n"); 
		query.append("            A.TRD_CD AS TRD_CD," ).append("\n"); 
		query.append("            @[slsFcastPubNo] AS SLS_FCAST_PUB_NO," ).append("\n"); 
		query.append("            @[qtaMstVerNo] AS QTA_MST_VER_NO," ).append("\n"); 
		query.append("            @[mqtaMdlVerNo] AS MQTA_MDL_VER_NO," ).append("\n"); 
		query.append("            @[glineVerNo] AS GLINE_VER_NO," ).append("\n"); 
		query.append("            @[mQtaVerNo] AS MQTA_VER_NO," ).append("\n"); 
		query.append("            @[slsRhqCd] AS SLS_RHQ_CD," ).append("\n"); 
		query.append("            @[slsRgnOfcCd] AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("            DECODE(@[slsRgnOfcCd], '', '08', '09') AS FIRST_STEP," ).append("\n"); 
		query.append("            DECODE(@[slsRgnOfcCd], '', '09', '08') AS SECOND_STEP," ).append("\n"); 
		query.append("            DECODE(@[slsRgnOfcCd], '', 'FC', 'FN') AS FINAL_STATUS" ).append("\n"); 
		query.append("     FROM   SAQ_TGT_GRP_TRD A	, SAQ_MON_LOD_TGT_OFC B" ).append("\n"); 
		query.append("     WHERE  1=1" ).append("\n"); 
		query.append("     AND    B.BSE_YR     = @[year]" ).append("\n"); 
		query.append("     AND    B.BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("     AND    A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("     AND    A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("     AND    B.SLS_RHQ_CD = (SELECT DISTINCT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                        FROM   SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append("                        WHERE  OFC_CD IN ( @[slsRhqCd]	, @[slsRgnOfcCd] )		)" ).append("\n"); 
		query.append("                        									)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    DECODE(UNI.TRD_CD, 'TOTAL', 1, DECODE(UNI.DIR_CD, 'TOTAL', 2, 3)) AS SLEVEL," ).append("\n"); 
		query.append("    UNI.TRD_CD AS TRD_CD," ).append("\n"); 
		query.append("    DECODE(UNI.TRD_CD, 'TOTAL', ' ', UNI.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("    ITM.ROW_SEQ," ).append("\n"); 
		query.append("    REPLACE(ITM.TEXT,'(P)','') AS ITEM_TEXT,                                                        " ).append("\n"); 
		query.append("	DECODE( ITM.CODE,                                                             " ).append("\n"); 
		query.append("	        '05', REPLACE(ITM.TEXT,'(P)','')||'*', -- G.REV                                        " ).append("\n"); 
		query.append("	        '07', REPLACE(ITM.TEXT,'(P)','')||'*', -- CM                                           " ).append("\n"); 
		query.append("	        '08', REPLACE(ITM.TEXT,'(P)','')||'*', -- CM                                           " ).append("\n"); 
		query.append("	        '11', REPLACE(ITM.TEXT,'(P)','')||'*', -- OP                                           " ).append("\n"); 
		query.append("	        '12', REPLACE(ITM.TEXT,'(P)','')||'*', -- OP                                           " ).append("\n"); 
		query.append("	        REPLACE(ITM.TEXT,'(P)','') ) AS ITEM,  " ).append("\n"); 
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
		query.append("    AS FCAST_TOT," ).append("\n"); 
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
		query.append("    AS MDL_RSLT_TOT," ).append("\n"); 
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
		query.append("    AS RHQ_TOT," ).append("\n"); 
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
		query.append("    AS INITIAL_TOT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#foreach( $key in ${monthseq})" ).append("\n"); 
		query.append("    ,MIN(CASE WHEN UNI.GUBUN = 'FORECAST' AND UNI.MON_SEQ = '$key' THEN" ).append("\n"); 
		query.append("           DECODE( ITM.CODE,  '01', UNI.TOT_BSA," ).append("\n"); 
		query.append("                    '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                    '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                    '04', DECODE(UNI.TOT_BSA, 0, '', ROUND((UNI.TOT_LOD/UNI.TOT_BSA)*100, 1))," ).append("\n"); 
		query.append("                    '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                    '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                    '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                    '08', 0," ).append("\n"); 
		query.append("                    '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                    '10', 0," ).append("\n"); 
		query.append("                    '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                    '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                    '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                    '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("           END) AS FCAST_$key," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'MODEL' AND UNI.MON_SEQ = '$key' THEN" ).append("\n"); 
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
		query.append("           END) AS MDL_RST_$key," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'RHQ' AND UNI.MON_SEQ = '$key' THEN" ).append("\n"); 
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
		query.append("           END) AS RHQ_$key," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'INITIAL' AND UNI.MON_SEQ = '$key' THEN" ).append("\n"); 
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
		query.append("           END) AS INITIAL_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  INTG_CD_VAL_CTNT AS CODE," ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_DESC AS TEXT," ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_SEQ AS ROW_SEQ" ).append("\n"); 
		query.append("    FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slsRgnOfcCd} != '') " ).append("\n"); 
		query.append("	WHERE INTG_CD_ID = 'CD01391'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	WHERE INTG_CD_ID = 'CD01389'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) ITM, (" ).append("\n"); 
		query.append("    SELECT -- Performance Quota Monthly" ).append("\n"); 
		query.append("        'PFMC_QTA' AS GUBUN," ).append("\n"); 
		query.append("        '0' AS MON_SEQ," ).append("\n"); 
		query.append("        '00' AS BSE_MON," ).append("\n"); 
		query.append("        DECODE(QTA.TRD_CD, '', 'TOTAL', QTA.TRD_CD) AS TRD_CD," ).append("\n"); 
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
		query.append("            QTA.TRD_CD," ).append("\n"); 
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
		query.append("                       RLS.BSE_QTR_CD AS BSE_QTR_CD" ).append("\n"); 
		query.append("                FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                       TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD BETWEEN INP.PFMC_FR_YR_QTR" ).append("\n"); 
		query.append("                                                  AND     INP.PFMC_TO_YR_QTR" ).append("\n"); 
		query.append("                AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("              ) RLS," ).append("\n"); 
		query.append("              SAQ_MON_DIR_CONV    DIR," ).append("\n"); 
		query.append("              SAQ_MON_CFM_QTA     QTA," ).append("\n"); 
		query.append("              SAQ_MON_CFM_TGT_VVD VVD," ).append("\n"); 
		query.append("              TMP_INPUT_PARMAS    INP" ).append("\n"); 
		query.append("        WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        AND   QTA.BSE_QTR_CD = RLS.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND   QTA.BSE_YR||QTA.BSE_MON BETWEEN INP.PFMC_FR_YR_MON AND INP.PFMC_TO_YR_MON" ).append("\n"); 
		query.append("        AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        AND   QTA.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("        AND   QTA.RHQ_CD LIKE INP.SLS_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND   QTA.RGN_OFC_CD LIKE INP.SLS_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("        AND   QTA.QTA_TGT_CD = 'T' -- Q : Sales Quota, T : Load Target" ).append("\n"); 
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
		query.append("        AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("        AND   QTA.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("        GROUP BY QTA.BSE_YR, QTA.BSE_MON, QTA.TRD_CD, QTA.RLANE_CD, NVL(DIR.CONV_DIR_CD, QTA.DIR_CD)," ).append("\n"); 
		query.append("                 VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) QTA" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(QTA.TRD_CD, QTA.DIR_CD)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Performance Est. PFMC" ).append("\n"); 
		query.append("        'PFMC_SMR' AS GUBUN," ).append("\n"); 
		query.append("        '0' AS MON_SEQ," ).append("\n"); 
		query.append("        '00' AS BSE_MON," ).append("\n"); 
		query.append("        DECODE(BPS.TRD_CD, '', 'TOTAL', BPS.TRD_CD) AS TRD_CD," ).append("\n"); 
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
		query.append("            BPS.TRD_CD," ).append("\n"); 
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
		query.append("        WHERE BPS.BSE_YR||BPS.BSE_MON BETWEEN INP.PFMC_FR_YR_MON AND INP.PFMC_TO_YR_MON" ).append("\n"); 
		query.append("        AND   BPS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        AND   BPS.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("        AND   BPS.SLS_RHQ_CD LIKE INP.SLS_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND   BPS.SLS_RGN_OFC_CD LIKE INP.SLS_RGN_OFC_CD||'%'" ).append("\n"); 
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
		query.append("        AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("        AND   BPS.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        AND   BPS.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND   BPS.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("        GROUP BY BPS.BSE_YR, BPS.BSE_MON, BPS.TRD_CD, BPS.RLANE_CD, NVL(DIR.CONV_DIR_CD, BPS.DIR_CD)" ).append("\n"); 
		query.append("        ) BPS" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(BPS.TRD_CD, BPS.DIR_CD)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- MONTHLY Quota (Recent)" ).append("\n"); 
		query.append("        'MONTHLY' AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        QTA.BSE_MON," ).append("\n"); 
		query.append("        DECODE(QTA.TRD_CD, '', 'TOTAL', QTA.TRD_CD) AS TRD_CD," ).append("\n"); 
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
		query.append("            QTA.TRD_CD," ).append("\n"); 
		query.append("            NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(QTA.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("        FROM  ( -- 전쿼터의 마지막 월" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                       RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                       RLS.BSE_YR           AS BEF_YR," ).append("\n"); 
		query.append("                       RLS.BSE_QTR_CD       AS BEF_QTR_CD" ).append("\n"); 
		query.append("                FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                       TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD = INP.BEF_YR_QTR" ).append("\n"); 
		query.append("                AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("              ) RLS," ).append("\n"); 
		query.append("              SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("              SAQ_MON_CFM_QTA QTA," ).append("\n"); 
		query.append("              SAQ_MON_CFM_TGT_VVD VVD," ).append("\n"); 
		query.append("              TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("        WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("        AND   QTA.BSE_YR = RLS.BEF_YR" ).append("\n"); 
		query.append("        AND   QTA.BSE_QTR_CD = RLS.BEF_QTR_CD" ).append("\n"); 
		query.append("        AND   QTA.BSE_MON = DECODE(RLS.BEF_QTR_CD, '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12')" ).append("\n"); 
		query.append("        AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        AND   QTA.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("        AND   QTA.RHQ_CD LIKE INP.SLS_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND   QTA.RGN_OFC_CD LIKE INP.SLS_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("        AND   QTA.QTA_TGT_CD = 'T' -- Q : Sales Quota, T : Load Target" ).append("\n"); 
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
		query.append("        AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("        AND   QTA.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("        GROUP BY QTA.BSE_YR, QTA.BSE_MON, QTA.TRD_CD, QTA.RLANE_CD, NVL(DIR.CONV_DIR_CD, QTA.DIR_CD)," ).append("\n"); 
		query.append("                 VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) QTA" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(QTA.TRD_CD, QTA.DIR_CD), QTA.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Forecast" ).append("\n"); 
		query.append("        'FORECAST' AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        FSM.BSE_MON," ).append("\n"); 
		query.append("        DECODE(FSM.TRD_CD, '', 'TOTAL', FSM.TRD_CD) AS TRD_CD," ).append("\n"); 
		query.append("        DECODE(FSM.DIR_CD, '', 'TOTAL', FSM.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("        SUM(FSM.TOT_BSA) AS TOT_BSA," ).append("\n"); 
		query.append("        SUM(FSM.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(FSM.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(FSM.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        SUM(FSM.TOT_REV)/SUM(FSM.TOT_LOD) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM(FSM.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        SUM(FSM.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        SUM(FSM.TOT_CM)/SUM(FSM.TOT_LOD) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM(FSM.TOT_RA_CM)/SUM(FSM.TOT_LOD) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM(FSM.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        SUM(FSM.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM(FSM.TOT_OP)/SUM(FSM.TOT_LOD) AS TOT_OPB," ).append("\n"); 
		query.append("        SUM(FSM.TOT_RA_OP)/SUM(FSM.TOT_LOD) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT -- Forecast" ).append("\n"); 
		query.append("               MIN(DECODE(FSM.BSE_YR||FSM.BSE_MON, INP.BEF_YR_MON, '0'," ).append("\n"); 
		query.append("                          INP.ADD1_YR_MON, '2', INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("               FSM.BSE_MON," ).append("\n"); 
		query.append("               FSM.TRD_CD," ).append("\n"); 
		query.append("               FSM.DIR_CD," ).append("\n"); 
		query.append("               MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("               COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("               SUM(FSM.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("               SUM(FSM.GRS_RPB_REV*FSM.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("               SUM((FSM.GRS_RPB_REV-FSM.CM_UC_AMT)*FSM.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("               0 AS TOT_RA_CM," ).append("\n"); 
		query.append("               SUM((FSM.GRS_RPB_REV-FSM.OPFIT_UC_AMT)*FSM.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("               0 AS TOT_RA_OP" ).append("\n"); 
		query.append("	    FROM  SAQ_MON_FCAST_SLS_SMRY FSM," ).append("\n"); 
		query.append("	          SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("	          (SELECT DISTINCT VER.MQTA_STEP_CD, VER.BSE_YR        , VER.BSE_QTR_CD  ," ).append("\n"); 
		query.append("	                           VER.TRD_CD      , VER.DIR_CD        , VER.GLINE_VER_NO," ).append("\n"); 
		query.append("	                           INP.SLS_RHQ_CD  , INP.SLS_RGN_OFC_CD, INP.SLS_FCAST_PUB_NO," ).append("\n"); 
		query.append("	                           INP.BEF_YR_MON  , INP.ADD1_YR_MON   , INP.ADD2_YR_MON" ).append("\n"); 
		query.append("	          FROM   SAQ_MON_QTA_STEP_VER VER, TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("	          WHERE  1=1" ).append("\n"); 
		query.append("	          AND    VER.MQTA_STEP_CD = INP.FIRST_STEP" ).append("\n"); 
		query.append("	          AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("	          AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("	          AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("	          AND    VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("	          AND    VER.QTA_MST_VER_NO = INP.QTA_MST_VER_NO					) INP" ).append("\n"); 
		query.append("	    WHERE FSM.SLS_FCAST_PUB_NO = INP.SLS_FCAST_PUB_NO" ).append("\n"); 
		query.append("	    AND   FSM.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("	    AND   FSM.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("	    AND   FSM.SLS_RHQ_CD LIKE INP.SLS_RHQ_CD||'%'" ).append("\n"); 
		query.append("	    AND   FSM.SLS_RGN_OFC_CD LIKE INP.SLS_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("	    AND   VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("	    AND   VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("	    AND   VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("	    AND   VVD.BSE_MON = FSM.BSE_MON" ).append("\n"); 
		query.append("	    AND   VVD.RLANE_CD = FSM.RLANE_CD" ).append("\n"); 
		query.append("	    AND   VVD.TRD_CD = FSM.TRD_CD" ).append("\n"); 
		query.append("	    AND   VVD.DIR_CD = FSM.DIR_CD" ).append("\n"); 
		query.append("	    AND   VVD.VSL_CD = FSM.VSL_CD" ).append("\n"); 
		query.append("	    AND   VVD.SKD_VOY_NO = FSM.SKD_VOY_NO" ).append("\n"); 
		query.append("	    AND   VVD.SKD_DIR_CD = FSM.SKD_DIR_CD" ).append("\n"); 
		query.append("	    AND   FSM.LOD_QTY > 0" ).append("\n"); 
		query.append("        GROUP BY FSM.BSE_YR, FSM.BSE_MON, FSM.TRD_CD, FSM.RLANE_CD, FSM.DIR_CD," ).append("\n"); 
		query.append("        		 VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) FSM" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(FSM.TRD_CD, FSM.DIR_CD), FSM.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Model Result" ).append("\n"); 
		query.append("        'MODEL' AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        MRS.BSE_MON," ).append("\n"); 
		query.append("        DECODE(MRS.TRD_CD, '', 'TOTAL', MRS.TRD_CD) AS TRD_CD," ).append("\n"); 
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
		query.append("            MRS.TRD_CD," ).append("\n"); 
		query.append("            MRS.DIR_CD," ).append("\n"); 
		query.append("            MIN(VVD.FNL_BSA_CAPA) AS TOT_BSA," ).append("\n"); 
		query.append("            COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("            SUM(MRS.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.CM_UC_AMT)*MRS.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.RA_CM_UC_AMT)*MRS.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.OPFIT_UC_AMT)*MRS.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            SUM((MRS.GRS_RPB_REV-MRS.RA_OPFIT_UC_AMT)*MRS.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("	    FROM  SAQ_MON_MDL_SLS_SMRY MRS," ).append("\n"); 
		query.append("	          SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("	          (SELECT DISTINCT VER.MQTA_STEP_CD, VER.BSE_YR        , VER.BSE_QTR_CD  ," ).append("\n"); 
		query.append("	                           VER.TRD_CD      , VER.DIR_CD        , VER.GLINE_VER_NO," ).append("\n"); 
		query.append("	                           INP.SLS_RHQ_CD  , INP.SLS_RGN_OFC_CD, INP.MQTA_MDL_VER_NO," ).append("\n"); 
		query.append("	                           INP.BEF_YR_MON  , INP.ADD1_YR_MON   , INP.ADD2_YR_MON" ).append("\n"); 
		query.append("	          FROM   SAQ_MON_QTA_STEP_VER VER, TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("	          WHERE  1=1" ).append("\n"); 
		query.append("	          AND    VER.MQTA_STEP_CD = INP.FIRST_STEP" ).append("\n"); 
		query.append("	          AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("	          AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("	          AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("	          AND    VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("	          AND    VER.QTA_MST_VER_NO = INP.QTA_MST_VER_NO					) INP" ).append("\n"); 
		query.append("	    WHERE MRS.MQTA_MDL_VER_NO = INP.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("	    AND   MRS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("	    AND   MRS.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("	    AND   MRS.SLS_RHQ_CD LIKE INP.SLS_RHQ_CD||'%'" ).append("\n"); 
		query.append("	    AND   MRS.SLS_RGN_OFC_CD LIKE INP.SLS_RGN_OFC_CD||'%'" ).append("\n"); 
		query.append("	    AND   VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("	    AND   VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("	    AND   VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("	    AND   VVD.BSE_MON = MRS.BSE_MON" ).append("\n"); 
		query.append("	    AND   VVD.RLANE_CD = MRS.RLANE_CD" ).append("\n"); 
		query.append("	    AND   VVD.TRD_CD = MRS.TRD_CD" ).append("\n"); 
		query.append("	    AND   VVD.DIR_CD = MRS.DIR_CD" ).append("\n"); 
		query.append("	    AND   VVD.VSL_CD = MRS.VSL_CD" ).append("\n"); 
		query.append("	    AND   VVD.SKD_VOY_NO = MRS.SKD_VOY_NO" ).append("\n"); 
		query.append("	    AND   VVD.SKD_DIR_CD = MRS.SKD_DIR_CD" ).append("\n"); 
		query.append("	    AND   MRS.LOD_QTY > 0" ).append("\n"); 
		query.append("        GROUP BY MRS.BSE_YR, MRS.BSE_MON, MRS.TRD_CD, MRS.RLANE_CD, MRS.DIR_CD," ).append("\n"); 
		query.append("        		 VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        ) MRS" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(MRS.TRD_CD, MRS.DIR_CD), MRS.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- RHQ, Initial" ).append("\n"); 
		query.append("        DECODE(RHQ.MQTA_STEP_CD, MIN(RHQ.FIRST_STEP),'RHQ', '11','INITIAL') AS GUBUN," ).append("\n"); 
		query.append("        MIN(MON_SEQ) AS MON_SEQ," ).append("\n"); 
		query.append("        RHQ.BSE_MON," ).append("\n"); 
		query.append("        DECODE(RHQ.TRD_CD, '', 'TOTAL', RHQ.TRD_CD) AS TRD_CD," ).append("\n"); 
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
		query.append("        SELECT -- RHQ, Initial" ).append("\n"); 
		query.append("            INP.FIRST_STEP," ).append("\n"); 
		query.append("            RHQ.MQTA_STEP_CD," ).append("\n"); 
		query.append("            MIN(DECODE(RHQ.BSE_YR||RHQ.BSE_MON, INP.ADD1_YR_MON, '2'," ).append("\n"); 
		query.append("                INP.ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("            RHQ.BSE_MON AS BSE_MON," ).append("\n"); 
		query.append("            RHQ.TRD_CD AS TRD_CD," ).append("\n"); 
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
		query.append("               SAQ_MON_QTA_LOD_TGT RHQ," ).append("\n"); 
		query.append("               SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("               TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("         WHERE  VER.MQTA_STEP_CD IN (INP.FIRST_STEP, '11') -- RHQ, Initial" ).append("\n"); 
		query.append("         AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("         AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("         AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("         AND    VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("         AND    VER.QTA_MST_VER_NO = INP.QTA_MST_VER_NO" ).append("\n"); 
		query.append("         AND    (  (" ).append("\n"); 
		query.append(" 			(" ).append("\n"); 
		query.append(" 				VER.MQTA_STEP_CD = INP.FIRST_STEP AND VER.MQTA_VER_NO = INP.MQTA_VER_NO" ).append("\n"); 
		query.append(" 				AND VER.TRD_CD = INP.SEL_TRD_CD AND VER.DIR_CD = INP.SEL_DIR_CD" ).append("\n"); 
		query.append(" 			)" ).append("\n"); 
		query.append(" 			OR" ).append("\n"); 
		query.append(" 			(" ).append("\n"); 
		query.append(" 				VER.MQTA_STEP_CD = INP.FIRST_STEP" ).append("\n"); 
		query.append(" 				AND NOT(VER.TRD_CD = INP.SEL_TRD_CD AND VER.DIR_CD = INP.SEL_DIR_CD)" ).append("\n"); 
		query.append(" 				AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(" 						      FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append(" 							   COM_INTG_CD_DTL B" ).append("\n"); 
		query.append(" 						      WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append(" 						      AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append(" 						      AND B.INTG_CD_VAL_CTNT = 'FC'" ).append("\n"); 
		query.append(" 						      AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append(" 			)" ).append("\n"); 
		query.append(" 		   )" ).append("\n"); 
		query.append(" 		   OR" ).append("\n"); 
		query.append("			          ( VER.MQTA_STEP_CD = '11' AND VER.SAQ_STS_CD IN  (" ).append("\n"); 
		query.append("			 		             SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                               FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                     COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                              WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                               AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                               AND B.INTG_CD_VAL_CTNT = '00'" ).append("\n"); 
		query.append("                               AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ  )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        AND    RHQ.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("        AND    RHQ.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("        AND    RHQ.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND    RHQ.TRD_CD = VER.TRD_CD" ).append("\n"); 
		query.append("        AND    RHQ.DIR_CD = VER.DIR_CD" ).append("\n"); 
		query.append("        AND    RHQ.MQTA_VER_NO = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("        AND    RHQ.SLS_RHQ_CD LIKE INP.SLS_RHQ_CD||'%'" ).append("\n"); 
		query.append("        AND    RHQ.SLS_RGN_OFC_CD LIKE INP.SLS_RGN_OFC_CD||'%'" ).append("\n"); 
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
		query.append("        GROUP BY INP.FIRST_STEP, RHQ.MQTA_STEP_CD,RHQ.BSE_YR,RHQ.BSE_MON,RHQ.TRD_CD,RHQ.RLANE_CD,RHQ.DIR_CD," ).append("\n"); 
		query.append("                 RHQ.SPRT_GRP_CD,RHQ.BSA_GRP_CD" ).append("\n"); 
		query.append("        ) RHQ" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(RHQ.TRD_CD, RHQ.DIR_CD), RHQ.MQTA_STEP_CD, RHQ.BSE_MON" ).append("\n"); 
		query.append("    ) UNI" ).append("\n"); 
		query.append("GROUP BY UNI.TRD_CD, UNI.DIR_CD, ITM.CODE, ITM.TEXT, ITM.ROW_SEQ" ).append("\n"); 
		query.append("ORDER BY DECODE(UNI.TRD_CD, 'TOTAL', '1', @[trade], '2', UNI.TRD_CD)," ).append("\n"); 
		query.append("         DECODE(UNI.DIR_CD, 'TOTAL', '1', UNI.DIR_CD), ITM.ROW_SEQ" ).append("\n"); 

	}
}