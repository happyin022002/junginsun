/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTrade0156Tab03RSQL.java
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

public class MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTrade0156Tab03RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyQuotaAdjustmentSlsRHQ의 상단 TAB Lane의 데이타 모델에 해당되는 값을 불러온다.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTrade0156Tab03RSQL(){
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
		query.append("FileName : MonthlyQuotaAdjustmentSlsRHQDBDAOSearchMonthlyAdjustmentSlsRHQTabTrade0156Tab03RSQL").append("\n"); 
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
		query.append("     SELECT" ).append("\n"); 
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
		query.append("            @[bound] AS DIR_CD," ).append("\n"); 
		query.append("            @[trade] AS TRD_CD," ).append("\n"); 
		query.append("            @[slsFcastPubNo] AS SLS_FCAST_PUB_NO," ).append("\n"); 
		query.append("            @[mqtaMdlVerNo] AS MQTA_MDL_VER_NO," ).append("\n"); 
		query.append("            @[glineVerNo] AS GLINE_VER_NO," ).append("\n"); 
		query.append("            @[mQtaVerNo] AS MQTA_VER_NO," ).append("\n"); 
		query.append("            @[slsRhqCd] AS SLS_RHQ_CD" ).append("\n"); 
		query.append("     FROM   DUAL" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    MIN(UNI.KEY) AS KEY," ).append("\n"); 
		query.append("    UNI.SLEVEL," ).append("\n"); 
		query.append("    UNI.SUB_TRD_CD," ).append("\n"); 
		query.append("    DECODE(DIR.DIR_CD,'',UNI.RLANE_CD,UNI.RLANE_CD||' - '||DIR.DIR_CD) RLANE_CD," ).append("\n"); 
		query.append("    DIR.DIR_CD CONV_DIR_CD," ).append("\n"); 
		query.append("    CASE WHEN UNI.RLANE_CD = 'TOTAL' AND UNI.SLS_AQ_CD = 'TOTAL'" ).append("\n"); 
		query.append("        THEN ' ' ELSE UNI.SLS_AQ_CD END AS SLS_AQ_CD," ).append("\n"); 
		query.append("    CASE WHEN UNI.SLS_AQ_CD = 'TOTAL' AND UNI.SLS_RGN_OFC_CD = 'TOTAL'" ).append("\n"); 
		query.append("        THEN ' ' ELSE UNI.SLS_RGN_OFC_CD END AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    ITM.ROW_SEQ," ).append("\n"); 
		query.append("    REPLACE(ITM.TEXT,'(P)','') AS ITEM_TEXT,                                                        " ).append("\n"); 
		query.append("	DECODE( ITM.CODE,                                                             " ).append("\n"); 
		query.append("	        '05', REPLACE(ITM.TEXT,'(P)','')||'*', -- G.REV                                        " ).append("\n"); 
		query.append("	        '07', REPLACE(ITM.TEXT,'(P)','')||'*', -- CM                                           " ).append("\n"); 
		query.append("	        '08', REPLACE(ITM.TEXT,'(P)','')||'*', -- CM                                           " ).append("\n"); 
		query.append("	        '11', REPLACE(ITM.TEXT,'(P)','')||'*', -- OP                                           " ).append("\n"); 
		query.append("	        '12', REPLACE(ITM.TEXT,'(P)','')||'*', -- OP                                           " ).append("\n"); 
		query.append("	        REPLACE(ITM.TEXT,'(P)','') ) AS ITEM, " ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'PFMC_QTA' AND UNI.MON_SEQ = '0' THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS PFMC_QTA," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'PFMC_SMR' AND UNI.MON_SEQ = '0' THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS PFMC_SMR," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'MONTHLY' AND UNI.MON_SEQ = '0' THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS RECENT_MON," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            DECODE( ITM.CODE," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'FORECAST',UNI.TOT_LOD,0))," ).append("\n"); 
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
		query.append("    DECODE( ITM.CODE," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'MODEL',UNI.TOT_LOD,0))," ).append("\n"); 
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
		query.append("    DECODE( ITM.CODE," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'RHQ',UNI.TOT_LOD,0))," ).append("\n"); 
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
		query.append("    DECODE( ITM.CODE," ).append("\n"); 
		query.append("                '02', SUM( DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_VOY,0))," ).append("\n"); 
		query.append("                '03', SUM(DECODE(UNI.GUBUN , 'INITIAL',UNI.TOT_LOD,0))," ).append("\n"); 
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
		query.append("    ,MIN(CASE WHEN UNI.GUBUN = 'FORECAST' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', 0," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', 0," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS FCAST_$key," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'MODEL' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS MDL_RST_$key," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'RHQ' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS RHQ_$key," ).append("\n"); 
		query.append("    MIN(CASE WHEN UNI.GUBUN = 'INITIAL' AND UNI.MON_SEQ = $key THEN" ).append("\n"); 
		query.append("        DECODE( ITM.CODE," ).append("\n"); 
		query.append("                 '02', UNI.TOT_VOY," ).append("\n"); 
		query.append("                 '03', UNI.TOT_LOD," ).append("\n"); 
		query.append("                 '05', UNI.TOT_REV/1000," ).append("\n"); 
		query.append("                 '06', UNI.TOT_RPB," ).append("\n"); 
		query.append("                 '07', UNI.TOT_CM/1000," ).append("\n"); 
		query.append("                 '08', UNI.TOT_RA_CM/1000," ).append("\n"); 
		query.append("                 '09', UNI.TOT_CMB," ).append("\n"); 
		query.append("                 '10', UNI.TOT_RA_CMB," ).append("\n"); 
		query.append("                 '11', UNI.TOT_OP/1000," ).append("\n"); 
		query.append("                 '12', UNI.TOT_RA_OP/1000," ).append("\n"); 
		query.append("                 '13', UNI.TOT_OPB," ).append("\n"); 
		query.append("                 '14', UNI.TOT_RA_OPB )" ).append("\n"); 
		query.append("        END) AS INITIAL_$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  INTG_CD_VAL_CTNT AS CODE," ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_DESC AS TEXT," ).append("\n"); 
		query.append("            INTG_CD_VAL_DP_SEQ AS ROW_SEQ" ).append("\n"); 
		query.append("    FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD01388'" ).append("\n"); 
		query.append("    ) ITM, (" ).append("\n"); 
		query.append("    SELECT -- Performance Quota" ).append("\n"); 
		query.append("        QTA.GUBUN," ).append("\n"); 
		query.append("        QTA.KEY," ).append("\n"); 
		query.append("        QTA.SLEVEL," ).append("\n"); 
		query.append("        QTA.SUB_TRD_CD," ).append("\n"); 
		query.append("        QTA.RLANE_CD," ).append("\n"); 
		query.append("        QTA.SLS_AQ_CD," ).append("\n"); 
		query.append("        QTA.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        QTA.MON_SEQ," ).append("\n"); 
		query.append("        QTA.BSE_MON," ).append("\n"); 
		query.append("        QTA.TOT_VOY," ).append("\n"); 
		query.append("        QTA.TOT_LOD," ).append("\n"); 
		query.append("        QTA.TOT_REV ," ).append("\n"); 
		query.append("        QTA.TOT_RPB ," ).append("\n"); 
		query.append("        QTA.TOT_CM ," ).append("\n"); 
		query.append("        QTA.TOT_RA_CM ," ).append("\n"); 
		query.append("        QTA.TOT_CMB," ).append("\n"); 
		query.append("        QTA.TOT_RA_CMB ," ).append("\n"); 
		query.append("        QTA.TOT_OP ," ).append("\n"); 
		query.append("        QTA.TOT_RA_OP," ).append("\n"); 
		query.append("        QTA.TOT_OPB ," ).append("\n"); 
		query.append("        QTA.TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM TMP_INPUT_PARMAS    INP, (" ).append("\n"); 
		query.append("    SELECT -- Performance Quota" ).append("\n"); 
		query.append("        'PFMC_QTA' AS GUBUN," ).append("\n"); 
		query.append("        NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("        MIN(VVD.SUB_TRD_CD||DECODE(QTA.RLANE_CD,'RBCCO','ZZ',SUBSTR(QTA.RLANE_CD,-2))||QTA.RLANE_CD||QTA.AQ_CD||QTA.RGN_OFC_CD) AS KEY," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.RLANE_CD), 1, '1'," ).append("\n"); 
		query.append("            DECODE(GROUPING(QTA.AQ_CD), 1, '2'," ).append("\n"); 
		query.append("                DECODE(GROUPING(QTA.RGN_OFC_CD), 1, '3', '4')))" ).append("\n"); 
		query.append("            AS SLEVEL," ).append("\n"); 
		query.append("        VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.RLANE_CD), 1, 'TOTAL', QTA.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.AQ_CD), 1, 'TOTAL', QTA.AQ_CD) AS SLS_AQ_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.RGN_OFC_CD), 1, 'TOTAL', QTA.RGN_OFC_CD) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        '0' AS MON_SEQ," ).append("\n"); 
		query.append("        '00' AS BSE_MON," ).append("\n"); 
		query.append("        COUNT(DISTINCT QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(QTA.LOD_QTY         ) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("        SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY)/SUM(QTA.LOD_QTY) AS TOT_RPB ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS TOT_RA_CM ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY)/SUM(QTA.LOD_QTY) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY)" ).append("\n"); 
		query.append("            /SUM(QTA.LOD_QTY) AS TOT_RA_CMB ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY ) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    )" ).append("\n"); 
		query.append("            /SUM(QTA.LOD_QTY) AS TOT_OPB ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY )" ).append("\n"); 
		query.append("            /SUM(QTA.LOD_QTY) AS TOT_RA_OPB" ).append("\n"); 
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
		query.append("          TMP_INPUT_PARMAS    INP," ).append("\n"); 
		query.append("          SAQ_MON_DIR_CONV    DIR," ).append("\n"); 
		query.append("          SAQ_MON_CFM_QTA     QTA," ).append("\n"); 
		query.append("          SAQ_MON_CFM_TGT_VVD VVD" ).append("\n"); 
		query.append("    WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND   QTA.BSE_QTR_CD = RLS.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND   QTA.RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR||QTA.BSE_MON BETWEEN PFMC_FR_YR_MON AND PFMC_TO_YR_MON" ).append("\n"); 
		query.append("    AND   QTA.LOD_QTY > 0" ).append("\n"); 
		query.append("    AND   QTA.QTA_TGT_CD = 'T' -- Q : Sales Quota, T : Load Target" ).append("\n"); 
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
		query.append("    AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("    AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(NVL(DIR.CONV_DIR_CD, QTA.DIR_CD), QTA.RLANE_CD, QTA.AQ_CD, QTA.RGN_OFC_CD), VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("    ) QTA" ).append("\n"); 
		query.append("    WHERE QTA.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Performance PFMC" ).append("\n"); 
		query.append("        'PFMC_SMR' AS GUBUN," ).append("\n"); 
		query.append("        BPS.KEY," ).append("\n"); 
		query.append("        BPS.SLEVEL," ).append("\n"); 
		query.append("        BPS.SUB_TRD_CD," ).append("\n"); 
		query.append("        BPS.RLANE_CD," ).append("\n"); 
		query.append("        BPS.SLS_AQ_CD," ).append("\n"); 
		query.append("        BPS.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        '0' AS MON_SEQ," ).append("\n"); 
		query.append("        '00' AS BSE_MON," ).append("\n"); 
		query.append("        (VVD.TOT_VOY) AS TOT_VOY," ).append("\n"); 
		query.append("        (BPS.TOT_LOD) AS TOT_LOD," ).append("\n"); 
		query.append("        (BPS.TOT_REV) AS TOT_REV," ).append("\n"); 
		query.append("        (BPS.TOT_REV)/(BPS.TOT_LOD) AS TOT_RPB," ).append("\n"); 
		query.append("        (BPS.TOT_CM) AS TOT_CM," ).append("\n"); 
		query.append("        (BPS.TOT_RA_CM) AS TOT_RA_CM," ).append("\n"); 
		query.append("        (BPS.TOT_CM)/(BPS.TOT_LOD) AS TOT_CMB," ).append("\n"); 
		query.append("        (BPS.TOT_RA_CM)/(BPS.TOT_LOD) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        (BPS.TOT_OP) AS TOT_OP," ).append("\n"); 
		query.append("        (BPS.TOT_RA_OP) AS TOT_RA_OP," ).append("\n"); 
		query.append("        (BPS.TOT_OP)/(BPS.TOT_LOD) AS TOT_OPB," ).append("\n"); 
		query.append("        (BPS.TOT_RA_OP)/(BPS.TOT_LOD) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM TMP_INPUT_PARMAS INP, (" ).append("\n"); 
		query.append("        			SELECT -- Performance VOYAGE (양방향 Bound)" ).append("\n"); 
		query.append("            			NVL(DIR.CONV_DIR_CD, BPS.DIR_CD) AS DIR_CD," ).append("\n"); 
		query.append("            			MIN(BPS.SUB_TRD_CD||DECODE(BPS.RLANE_CD,'RBCCO','ZZ',SUBSTR(BPS.RLANE_CD,-2))||BPS.RLANE_CD||BPS.SLS_AQ_CD||BPS.SLS_RGN_OFC_CD) AS KEY," ).append("\n"); 
		query.append("            			DECODE(GROUPING(BPS.RLANE_CD), 1, '1'," ).append("\n"); 
		query.append("                			DECODE(GROUPING(BPS.SLS_AQ_CD), 1, '2'," ).append("\n"); 
		query.append("                    			DECODE(GROUPING(BPS.SLS_RGN_OFC_CD), 1, '3', '4')))" ).append("\n"); 
		query.append("                		AS SLEVEL," ).append("\n"); 
		query.append("            			BPS.SUB_TRD_CD," ).append("\n"); 
		query.append("            			DECODE(GROUPING(BPS.RLANE_CD), 1, 'TOTAL', BPS.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("            			DECODE(GROUPING(BPS.SLS_AQ_CD), 1, 'TOTAL', BPS.SLS_AQ_CD) AS SLS_AQ_CD," ).append("\n"); 
		query.append("            			DECODE(GROUPING(BPS.SLS_RGN_OFC_CD), 1, 'TOTAL', BPS.SLS_RGN_OFC_CD) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("            			SUM(BPS.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("            			SUM(BPS.GRS_RPB_REV*BPS.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("            			SUM((BPS.GRS_RPB_REV-BPS.CM_UC_AMT)*BPS.LOD_QTY) AS TOT_CM," ).append("\n"); 
		query.append("            			SUM((BPS.GRS_RPB_REV-BPS.RA_CM_UC_AMT)*BPS.LOD_QTY) AS TOT_RA_CM," ).append("\n"); 
		query.append("            			SUM((BPS.GRS_RPB_REV-BPS.OPFIT_UC_AMT)*BPS.LOD_QTY    ) AS TOT_OP," ).append("\n"); 
		query.append("            			SUM((BPS.GRS_RPB_REV-BPS.RA_OPFIT_UC_AMT)*BPS.LOD_QTY ) AS TOT_RA_OP" ).append("\n"); 
		query.append("        			FROM  SAQ_PERF_OFC_SMRY BPS," ).append("\n"); 
		query.append("              		  SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("              		( SELECT DISTINCT ADJ.TRD_CD, ADJ.DIR_CD, ADJ.RLANE_CD" ).append("\n"); 
		query.append("                		  FROM   SAQ_MON_TGT_VVD_ADJ ADJ, TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("                       WHERE  1=1" ).append("\n"); 
		query.append("                       AND    ADJ.GLINE_VER_NO = INP.GLINE_VER_NO   ) ADJ," ).append("\n"); 
		query.append("                       TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("        			WHERE BPS.BSE_YR||BPS.BSE_MON BETWEEN PFMC_FR_YR_MON AND PFMC_TO_YR_MON" ).append("\n"); 
		query.append("        			AND   BPS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("        			AND   BPS.SLS_RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("        			AND   BPS.LOD_QTY > 0" ).append("\n"); 
		query.append("        			AND   BPS.TRD_CD = ADJ.TRD_CD" ).append("\n"); 
		query.append("        			AND   BPS.DIR_CD = ADJ.DIR_CD" ).append("\n"); 
		query.append("        			AND   BPS.RLANE_CD = ADJ.RLANE_CD" ).append("\n"); 
		query.append("        			AND   BPS.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("        			AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("        			AND   BPS.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("        			AND   BPS.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("        			AND   BPS.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("        			GROUP BY ROLLUP(NVL(DIR.CONV_DIR_CD, BPS.DIR_CD), BPS.RLANE_CD, BPS.SLS_AQ_CD, BPS.SLS_RGN_OFC_CD), BPS.SUB_TRD_CD" ).append("\n"); 
		query.append("        ) BPS, (" ).append("\n"); 
		query.append("        SELECT -- PERFORMANCE VOYAGE" ).append("\n"); 
		query.append("            VVD.DIR_CD, VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("            DECODE(GROUPING(VVD.RLANE_CD), 1, 'TOTAL', VVD.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("            SUM(VVD.TOT_VOY) AS TOT_VOY" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                NVL(DIR.CONV_DIR_CD, BPS.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("                BPS.SUB_TRD_CD," ).append("\n"); 
		query.append("                BPS.RLANE_CD," ).append("\n"); 
		query.append("                MIN(PFT.VOY_KNT) AS TOT_VOY" ).append("\n"); 
		query.append("            FROM  SAQ_PERF_OFC_SMRY BPS," ).append("\n"); 
		query.append("                  SAQ_PERF_TGT_LANE PFT," ).append("\n"); 
		query.append("                   SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("                  TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("            WHERE BPS.BSE_YR||BPS.BSE_MON BETWEEN PFMC_FR_YR_MON AND PFMC_TO_YR_MON" ).append("\n"); 
		query.append("            AND   BPS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("            AND   PFT.BSE_YR = BPS.BSE_YR" ).append("\n"); 
		query.append("            AND   PFT.BSE_MON = BPS.BSE_MON" ).append("\n"); 
		query.append("            AND   PFT.TRD_CD = BPS.TRD_CD" ).append("\n"); 
		query.append("            AND   PFT.RLANE_CD = BPS.RLANE_CD" ).append("\n"); 
		query.append("            AND   PFT.DIR_CD = BPS.DIR_CD" ).append("\n"); 
		query.append("            AND   BPS.SLS_RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("            AND   BPS.LOD_QTY > 0" ).append("\n"); 
		query.append("            AND   BPS.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("            AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("            AND   BPS.TRD_CD = DIR.TRD_CD(+)" ).append("\n"); 
		query.append("            AND   BPS.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("            AND   BPS.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("            GROUP BY BPS.BSE_YR, BPS.BSE_MON, NVL(DIR.CONV_DIR_CD, BPS.DIR_CD), BPS.SUB_TRD_CD, BPS.RLANE_CD" ).append("\n"); 
		query.append("            ) VVD" ).append("\n"); 
		query.append("        GROUP BY ROLLUP(VVD.DIR_CD, VVD.SUB_TRD_CD, VVD.RLANE_CD)" ).append("\n"); 
		query.append("        ) VVD" ).append("\n"); 
		query.append("    WHERE BPS.SUB_TRD_CD = VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND   BPS.RLANE_CD = VVD.RLANE_CD" ).append("\n"); 
		query.append("    AND   BPS.DIR_CD = VVD.DIR_CD" ).append("\n"); 
		query.append("    AND   BPS.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- MONTHLY Quota (Recent)" ).append("\n"); 
		query.append("        QTA.GUBUN," ).append("\n"); 
		query.append("        QTA.KEY," ).append("\n"); 
		query.append("        QTA.SLEVEL," ).append("\n"); 
		query.append("        QTA.SUB_TRD_CD," ).append("\n"); 
		query.append("        QTA.RLANE_CD," ).append("\n"); 
		query.append("        QTA.SLS_AQ_CD," ).append("\n"); 
		query.append("        QTA.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        QTA.MON_SEQ," ).append("\n"); 
		query.append("        QTA.BSE_MON," ).append("\n"); 
		query.append("        QTA.TOT_VOY," ).append("\n"); 
		query.append("        QTA.TOT_LOD," ).append("\n"); 
		query.append("        QTA.TOT_REV ," ).append("\n"); 
		query.append("        QTA.TOT_RPB ," ).append("\n"); 
		query.append("        QTA.TOT_CM ," ).append("\n"); 
		query.append("        QTA.TOT_RA_CM ," ).append("\n"); 
		query.append("        QTA.TOT_CMB," ).append("\n"); 
		query.append("        QTA.TOT_RA_CMB ," ).append("\n"); 
		query.append("        QTA.TOT_OP ," ).append("\n"); 
		query.append("        QTA.TOT_RA_OP," ).append("\n"); 
		query.append("        QTA.TOT_OPB ," ).append("\n"); 
		query.append("        QTA.TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM   TMP_INPUT_PARMAS INP, (" ).append("\n"); 
		query.append("    SELECT -- MONTHLY Quota (Recent)" ).append("\n"); 
		query.append("        NVL(DIR.CONV_DIR_CD, QTA.DIR_CD) DIR_CD," ).append("\n"); 
		query.append("        'MONTHLY' AS GUBUN," ).append("\n"); 
		query.append("        MIN(VVD.SUB_TRD_CD||DECODE(QTA.RLANE_CD,'RBCCO','ZZ',SUBSTR(QTA.RLANE_CD,-2))||QTA.RLANE_CD||QTA.AQ_CD||QTA.RGN_OFC_CD) AS KEY," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.RLANE_CD), 1, '1'," ).append("\n"); 
		query.append("            DECODE(GROUPING(QTA.AQ_CD), 1, '2'," ).append("\n"); 
		query.append("                DECODE(GROUPING(QTA.RGN_OFC_CD), 1, '3', '4')))" ).append("\n"); 
		query.append("            AS SLEVEL," ).append("\n"); 
		query.append("        VVD.SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.RLANE_CD), 1, 'TOTAL', QTA.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.AQ_CD), 1, 'TOTAL', QTA.AQ_CD) AS SLS_AQ_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(QTA.RGN_OFC_CD), 1, 'TOTAL', QTA.RGN_OFC_CD) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        MIN(DECODE(QTA.BSE_YR||QTA.BSE_MON, INP.BEF_YR_MON, '0'," ).append("\n"); 
		query.append("            INP.ADD1_YR_MON, '2', ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("        QTA.BSE_MON," ).append("\n"); 
		query.append("        COUNT(DISTINCT QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(QTA.LOD_QTY         ) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("        SUM(QTA.GRS_RPB_REV*QTA.LOD_QTY)/SUM(QTA.LOD_QTY) AS TOT_RPB ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY) AS TOT_RA_CM ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.CM_UC_AMT)*QTA.LOD_QTY)/SUM(QTA.LOD_QTY) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_CM_UC_AMT)*QTA.LOD_QTY)" ).append("\n"); 
		query.append("            /SUM(QTA.LOD_QTY) AS TOT_RA_CMB ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY ) AS TOT_RA_OP," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.OPFIT_UC_AMT)*QTA.LOD_QTY    )" ).append("\n"); 
		query.append("            /SUM(QTA.LOD_QTY) AS TOT_OPB ," ).append("\n"); 
		query.append("        SUM((QTA.GRS_RPB_REV-QTA.RA_OPFIT_UC_AMT)*QTA.LOD_QTY )" ).append("\n"); 
		query.append("            /SUM(QTA.LOD_QTY) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM  ( -- 전쿼터의 마지막 월" ).append("\n"); 
		query.append("            SELECT DISTINCT" ).append("\n"); 
		query.append("                   RLS.MQTA_RLSE_VER_NO AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                   RLS.BSE_YR           AS BEF_YR," ).append("\n"); 
		query.append("                   RLS.BSE_QTR_CD       AS BEF_QTR_CD" ).append("\n"); 
		query.append("            FROM   SAQ_MON_QTA_RLSE RLS," ).append("\n"); 
		query.append("                   TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("            WHERE  RLS.BSE_YR||RLS.BSE_QTR_CD = INP.BEF_YR_QTR" ).append("\n"); 
		query.append("            AND    RLS.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("          ) RLS," ).append("\n"); 
		query.append("          SAQ_MON_DIR_CONV  DIR," ).append("\n"); 
		query.append("          SAQ_MON_CFM_QTA QTA," ).append("\n"); 
		query.append("          SAQ_MON_CFM_TGT_VVD VVD," ).append("\n"); 
		query.append("          TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("    WHERE QTA.MQTA_RLSE_VER_NO = RLS.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR = RLS.BEF_YR" ).append("\n"); 
		query.append("    AND   QTA.BSE_QTR_CD = RLS.BEF_QTR_CD" ).append("\n"); 
		query.append("    AND   QTA.BSE_MON = DECODE(RLS.BEF_QTR_CD, '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12')" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND   QTA.RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("    AND   QTA.QTA_TGT_CD = 'T' -- Q : Sales Quota, T : Load Target" ).append("\n"); 
		query.append("    AND   QTA.MQTA_RLSE_VER_NO    = VVD.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR              = VVD.BSE_YR" ).append("\n"); 
		query.append("    AND   QTA.BSE_QTR_CD          = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND   QTA.BSE_MON             = VVD.BSE_MON" ).append("\n"); 
		query.append("    AND   QTA.TRD_CD              = VVD.TRD_CD" ).append("\n"); 
		query.append("    AND   QTA.RLANE_CD            = VVD.RLANE_CD" ).append("\n"); 
		query.append("    AND   QTA.DIR_CD              = VVD.DIR_CD" ).append("\n"); 
		query.append("    AND   QTA.VSL_CD              = VVD.VSL_CD" ).append("\n"); 
		query.append("    AND   QTA.SKD_VOY_NO          = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   QTA.SKD_DIR_CD          = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND   QTA.LOD_QTY > 0" ).append("\n"); 
		query.append("    AND   QTA.BSE_YR = DIR.BSE_YR(+)" ).append("\n"); 
		query.append("    AND   DIR.BSE_QTR_CD(+) = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND   qta.trd_cd = dir.trd_cd(+)" ).append("\n"); 
		query.append("    AND   QTA.RLANE_CD = DIR.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND   QTA.DIR_CD = DIR.DIR_CD(+)" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(NVL(DIR.CONV_DIR_CD, QTA.DIR_CD), QTA.RLANE_CD, QTA.AQ_CD, QTA.RGN_OFC_CD), VVD.SUB_TRD_CD, QTA.BSE_MON" ).append("\n"); 
		query.append("    ) QTA" ).append("\n"); 
		query.append("    WHERE QTA.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Forecast" ).append("\n"); 
		query.append("        'FORECAST' AS GUBUN," ).append("\n"); 
		query.append("        MIN(FSM.SUB_TRD_CD||DECODE(FSM.RLANE_CD,'RBCCO','ZZ',SUBSTR(FSM.RLANE_CD,-2))||FSM.RLANE_CD||FSM.SLS_AQ_CD||FSM.SLS_RGN_OFC_CD) AS KEY," ).append("\n"); 
		query.append("        DECODE(GROUPING(FSM.RLANE_CD), 1, '1'," ).append("\n"); 
		query.append("            DECODE(GROUPING(FSM.SLS_AQ_CD), 1, '2'," ).append("\n"); 
		query.append("                DECODE(GROUPING(FSM.SLS_RGN_OFC_CD), 1, '3', '4')))" ).append("\n"); 
		query.append("            AS SLEVEL," ).append("\n"); 
		query.append("        FSM.SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(FSM.RLANE_CD), 1, 'TOTAL', FSM.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(FSM.SLS_AQ_CD), 1, 'TOTAL', FSM.SLS_AQ_CD) AS SLS_AQ_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(FSM.SLS_RGN_OFC_CD), 1, 'TOTAL', FSM.SLS_RGN_OFC_CD) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        MIN(DECODE(FSM.BSE_YR||FSM.BSE_MON, INP.ADD1_YR_MON, '2'," ).append("\n"); 
		query.append("               ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("        FSM.BSE_MON," ).append("\n"); 
		query.append("        COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(FSM.LOD_QTY         ) AS TOT_LOD ," ).append("\n"); 
		query.append("        SUM(FSM.GRS_RPB_REV*FSM.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("        SUM(FSM.GRS_RPB_REV*FSM.LOD_QTY)/SUM(FSM.LOD_QTY) AS TOT_RPB ," ).append("\n"); 
		query.append("        SUM((FSM.GRS_RPB_REV-FSM.CM_UC_AMT)*FSM.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("        0 AS TOT_RA_CM ," ).append("\n"); 
		query.append("        SUM((FSM.GRS_RPB_REV-FSM.CM_UC_AMT)*FSM.LOD_QTY)/SUM(FSM.LOD_QTY) AS TOT_CMB," ).append("\n"); 
		query.append("            0 AS TOT_RA_CMB ," ).append("\n"); 
		query.append("        SUM((FSM.GRS_RPB_REV-FSM.OPFIT_UC_AMT)*FSM.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("        0 AS TOT_RA_OP ," ).append("\n"); 
		query.append("        SUM((FSM.GRS_RPB_REV-FSM.OPFIT_UC_AMT)*FSM.LOD_QTY    )" ).append("\n"); 
		query.append("            /SUM(FSM.LOD_QTY) AS TOT_OPB ," ).append("\n"); 
		query.append("        0 AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM  SAQ_MON_FCAST_SLS_SMRY FSM," ).append("\n"); 
		query.append("          SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("          TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("    WHERE FSM.SLS_FCAST_PUB_NO = INP.SLS_FCAST_PUB_NO" ).append("\n"); 
		query.append("    AND   FSM.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND   FSM.SLS_RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("    AND   VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("    AND   VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND   VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("    AND   VVD.BSE_MON = FSM.BSE_MON" ).append("\n"); 
		query.append("    AND   VVD.RLANE_CD = FSM.RLANE_CD" ).append("\n"); 
		query.append("    AND   VVD.TRD_CD = FSM.TRD_CD" ).append("\n"); 
		query.append("    AND   VVD.DIR_CD = FSM.DIR_CD" ).append("\n"); 
		query.append("    AND   VVD.VSL_CD = FSM.VSL_CD" ).append("\n"); 
		query.append("    AND   VVD.SKD_VOY_NO = FSM.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   VVD.SKD_DIR_CD = FSM.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND   FSM.LOD_QTY > 0" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(FSM.RLANE_CD, FSM.SLS_AQ_CD, FSM.SLS_RGN_OFC_CD), FSM.SUB_TRD_CD, FSM.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- Model Result" ).append("\n"); 
		query.append("        'MODEL' AS GUBUN," ).append("\n"); 
		query.append("        MIN(MRS.SUB_TRD_CD||DECODE(MRS.RLANE_CD,'RBCCO','ZZ',SUBSTR(MRS.RLANE_CD,-2))||MRS.RLANE_CD||MRS.SLS_AQ_CD||MRS.SLS_RGN_OFC_CD) AS KEY," ).append("\n"); 
		query.append("        DECODE(GROUPING(MRS.RLANE_CD), 1, '1'," ).append("\n"); 
		query.append("            DECODE(GROUPING(MRS.SLS_AQ_CD), 1, '2'," ).append("\n"); 
		query.append("                DECODE(GROUPING(MRS.SLS_RGN_OFC_CD), 1, '3', '4')))" ).append("\n"); 
		query.append("            AS SLEVEL," ).append("\n"); 
		query.append("        MRS.SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(MRS.RLANE_CD), 1, 'TOTAL', MRS.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(MRS.SLS_AQ_CD), 1, 'TOTAL', MRS.SLS_AQ_CD) AS SLS_AQ_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(MRS.SLS_RGN_OFC_CD), 1, 'TOTAL', MRS.SLS_RGN_OFC_CD) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        MIN(DECODE(MRS.BSE_YR||MRS.BSE_MON, INP.ADD1_YR_MON, '2'," ).append("\n"); 
		query.append("               ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("        MRS.BSE_MON," ).append("\n"); 
		query.append("        COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(MRS.LOD_QTY         ) AS TOT_LOD ," ).append("\n"); 
		query.append("        SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY) AS TOT_REV ," ).append("\n"); 
		query.append("        SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS TOT_RPB ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.CM_UC_AMT)*MRS.LOD_QTY) AS TOT_CM ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.RA_CM_UC_AMT)*MRS.LOD_QTY) AS TOT_RA_CM ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.CM_UC_AMT)*MRS.LOD_QTY)/SUM(MRS.LOD_QTY) AS TOT_CMB," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.RA_CM_UC_AMT)*MRS.LOD_QTY)" ).append("\n"); 
		query.append("            /SUM(MRS.LOD_QTY) AS TOT_RA_CMB ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.OPFIT_UC_AMT)*MRS.LOD_QTY    ) AS TOT_OP ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.RA_OPFIT_UC_AMT)*MRS.LOD_QTY ) AS TOT_RA_OP ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.OPFIT_UC_AMT)*MRS.LOD_QTY    )" ).append("\n"); 
		query.append("            /SUM(MRS.LOD_QTY) AS TOT_OPB ," ).append("\n"); 
		query.append("        SUM((MRS.GRS_RPB_REV-MRS.RA_OPFIT_UC_AMT)*MRS.LOD_QTY )" ).append("\n"); 
		query.append("            /SUM(MRS.LOD_QTY) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM  SAQ_MON_MDL_SLS_SMRY MRS," ).append("\n"); 
		query.append("          SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("          TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("    WHERE MRS.MQTA_MDL_VER_NO = INP.MQTA_MDL_VER_NO" ).append("\n"); 
		query.append("    AND   MRS.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND   VVD.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("    AND   VVD.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND   VVD.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("    AND   VVD.BSE_MON = MRS.BSE_MON" ).append("\n"); 
		query.append("    AND   VVD.RLANE_CD = MRS.RLANE_CD" ).append("\n"); 
		query.append("    AND   VVD.TRD_CD = MRS.TRD_CD" ).append("\n"); 
		query.append("    AND   VVD.DIR_CD = MRS.DIR_CD" ).append("\n"); 
		query.append("    AND   VVD.VSL_CD = MRS.VSL_CD" ).append("\n"); 
		query.append("    AND   VVD.SKD_VOY_NO = MRS.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   VVD.SKD_DIR_CD = MRS.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND   MRS.SLS_RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("    AND   MRS.LOD_QTY > 0" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(MRS.RLANE_CD, MRS.SLS_AQ_CD, MRS.SLS_RGN_OFC_CD), MRS.SUB_TRD_CD, MRS.BSE_MON" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT -- RHQ, Initial" ).append("\n"); 
		query.append("        DECODE(RHQ.MQTA_STEP_CD, '08', 'RHQ', '11','INITIAL') AS GUBUN," ).append("\n"); 
		query.append("        MIN(RHQ.SUB_TRD_CD||DECODE(RHQ.RLANE_CD,'RBCCO','ZZ',SUBSTR(RHQ.RLANE_CD,-2))||RHQ.RLANE_CD||AQV.N3RD_PRNT_OFC_CD||RHQ.SLS_RGN_OFC_CD) AS KEY," ).append("\n"); 
		query.append("        DECODE(GROUPING(RHQ.RLANE_CD), 1, '1'," ).append("\n"); 
		query.append("            DECODE(GROUPING(AQV.N3RD_PRNT_OFC_CD), 1, '2'," ).append("\n"); 
		query.append("                DECODE(GROUPING(RHQ.SLS_RGN_OFC_CD), 1, '3', '4')))" ).append("\n"); 
		query.append("            AS SLEVEL," ).append("\n"); 
		query.append("        RHQ.SUB_TRD_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(RHQ.RLANE_CD), 1, 'TOTAL', RHQ.RLANE_CD) AS RLANE_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(AQV.N3RD_PRNT_OFC_CD), 1, 'TOTAL', AQV.N3RD_PRNT_OFC_CD) AS SLS_AQ_CD," ).append("\n"); 
		query.append("        DECODE(GROUPING(RHQ.SLS_RGN_OFC_CD), 1, 'TOTAL', RHQ.SLS_RGN_OFC_CD) AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("        MIN(DECODE(RHQ.BSE_YR||RHQ.BSE_MON, INP.ADD1_YR_MON, '2'," ).append("\n"); 
		query.append("               ADD2_YR_MON, '3', '1')) AS MON_SEQ," ).append("\n"); 
		query.append("        RHQ.BSE_MON AS BSE_MON," ).append("\n"); 
		query.append("        COUNT(DISTINCT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD) AS TOT_VOY," ).append("\n"); 
		query.append("        SUM(RHQ.LOD_QTY) AS TOT_LOD," ).append("\n"); 
		query.append("        SUM(RHQ.GRS_RPB_REV*RHQ.LOD_QTY) AS TOT_REV," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("            SUM(RHQ.GRS_RPB_REV*RHQ.LOD_QTY)/SUM(RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            ) AS TOT_RPB," ).append("\n"); 
		query.append("        SUM((RHQ.GRS_RPB_REV-RHQ.CM_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            AS TOT_CM," ).append("\n"); 
		query.append("        SUM((RHQ.GRS_RPB_REV-RHQ.RA_CM_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            AS TOT_RA_CM," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.CM_UC_AMT)*RHQ.LOD_QTY)/SUM(RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            ) AS TOT_CMB," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.RA_CM_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                /SUM(RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            ) AS TOT_RA_CMB," ).append("\n"); 
		query.append("        SUM((RHQ.GRS_RPB_REV-RHQ.OPFIT_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            AS TOT_OP," ).append("\n"); 
		query.append("        SUM((RHQ.GRS_RPB_REV-RHQ.RA_OPFIT_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            AS TOT_RA_OP," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.OPFIT_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                /SUM(RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            ) AS TOT_OPB," ).append("\n"); 
		query.append("        DECODE(SUM(RHQ.LOD_QTY), 0, 0," ).append("\n"); 
		query.append("            SUM((RHQ.GRS_RPB_REV-RHQ.RA_OPFIT_UC_AMT)*RHQ.LOD_QTY)" ).append("\n"); 
		query.append("                /SUM(RHQ.LOD_QTY)" ).append("\n"); 
		query.append("            ) AS TOT_RA_OPB" ).append("\n"); 
		query.append("    FROM   TMP_INPUT_PARMAS INP," ).append("\n"); 
		query.append("           SAQ_MON_TGT_VVD_ADJ VVD," ).append("\n"); 
		query.append("           SAQ_MON_QTA_STEP_VER VER," ).append("\n"); 
		query.append("           SAQ_MON_QTA_LOD_TGT RHQ," ).append("\n"); 
		query.append("           SAQ_ORGANIZATION_V AQV" ).append("\n"); 
		query.append("    WHERE  VER.MQTA_STEP_CD IN ('08', '11') -- RHQ, Initial" ).append("\n"); 
		query.append("    AND    VER.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("    AND    VER.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND    VER.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("    AND    VER.DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("    AND    VER.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("    AND    ((VER.MQTA_STEP_CD IN ('08','10') AND VER.MQTA_VER_NO = INP.MQTA_VER_NO" ).append("\n"); 
		query.append("                AND VER.TRD_CD = INP.TRD_CD AND VER.DIR_CD = INP.DIR_CD)" ).append("\n"); 
		query.append("            OR (VER.MQTA_STEP_CD IN ('08','10')" ).append("\n"); 
		query.append("                AND NOT(VER.TRD_CD = INP.TRD_CD AND VER.DIR_CD = INP.DIR_CD)" ).append("\n"); 
		query.append("                AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                       COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                  WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                                  AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                                  AND B.INTG_CD_VAL_CTNT = 'DC'" ).append("\n"); 
		query.append("                                  AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ))" ).append("\n"); 
		query.append("            OR (VER.MQTA_STEP_CD = '09' AND VER.SAQ_STS_CD IN (SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                  FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                       COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                                  WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                                  AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                                  AND B.INTG_CD_VAL_CTNT = 'DN'" ).append("\n"); 
		query.append("                                  AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ))" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("			          ( VER.MQTA_STEP_CD = '11' AND VER.SAQ_STS_CD IN  (" ).append("\n"); 
		query.append("			 		             SELECT A.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                               FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("                                     COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                              WHERE A.INTG_CD_ID = 'CD00926'" ).append("\n"); 
		query.append("                               AND B.INTG_CD_ID = A.INTG_CD_ID" ).append("\n"); 
		query.append("                               AND B.INTG_CD_VAL_CTNT = '00'" ).append("\n"); 
		query.append("                               AND A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ  )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("    AND    RHQ.MQTA_STEP_CD = VER.MQTA_STEP_CD" ).append("\n"); 
		query.append("    AND    RHQ.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("    AND    RHQ.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND    RHQ.TRD_CD = VER.TRD_CD" ).append("\n"); 
		query.append("    AND    RHQ.DIR_CD = VER.DIR_CD" ).append("\n"); 
		query.append("    AND    RHQ.MQTA_VER_NO = VER.MQTA_VER_NO" ).append("\n"); 
		query.append("    AND    RHQ.SLS_RHQ_CD = INP.SLS_RHQ_CD" ).append("\n"); 
		query.append("    AND    VVD.BSE_YR = VER.BSE_YR" ).append("\n"); 
		query.append("    AND    VVD.BSE_QTR_CD = VER.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND    VVD.GLINE_VER_NO = VER.GLINE_VER_NO" ).append("\n"); 
		query.append("    AND    VVD.BSE_MON = RHQ.BSE_MON" ).append("\n"); 
		query.append("    AND    VVD.TRD_CD = RHQ.TRD_CD" ).append("\n"); 
		query.append("    AND    VVD.DIR_CD = RHQ.DIR_CD" ).append("\n"); 
		query.append("    AND    VVD.SUB_TRD_CD = RHQ.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND    VVD.RLANE_CD = RHQ.RLANE_CD" ).append("\n"); 
		query.append("    AND    VVD.SPRT_GRP_CD = RHQ.SPRT_GRP_CD" ).append("\n"); 
		query.append("    AND    VVD.BSA_GRP_CD = RHQ.BSA_GRP_CD" ).append("\n"); 
		query.append("    AND    AQV.OFC_CD= RHQ.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    GROUP BY ROLLUP(RHQ.RLANE_CD, AQV.N3RD_PRNT_OFC_CD, RHQ.SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("             RHQ.SUB_TRD_CD, RHQ.BSE_MON, RHQ.MQTA_STEP_CD" ).append("\n"); 
		query.append("    ) UNI" ).append("\n"); 
		query.append("    ,     (" ).append("\n"); 
		query.append("          SELECT" ).append("\n"); 
		query.append("              DIR.RLANE_CD," ).append("\n"); 
		query.append("              DIR.DIR_CD" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("              SAQ_MON_DIR_CONV DIR," ).append("\n"); 
		query.append("              TMP_INPUT_PARMAS INP" ).append("\n"); 
		query.append("          WHERE" ).append("\n"); 
		query.append("                   DIR.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("             AND DIR.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("             AND DIR.TRD_CD = INP.TRD_CD" ).append("\n"); 
		query.append("             AND DIR.CONV_DIR_CD = INP.DIR_CD" ).append("\n"); 
		query.append("          ) DIR" ).append("\n"); 
		query.append("     WHERE" ).append("\n"); 
		query.append("             DIR.RLANE_CD(+) = UNI.RLANE_CD" ).append("\n"); 
		query.append("GROUP BY UNI.SLEVEL, UNI.SUB_TRD_CD, UNI.RLANE_CD, UNI.SLS_AQ_CD, UNI.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         ITM.CODE, ITM.TEXT, ITM.ROW_SEQ, DIR.DIR_CD" ).append("\n"); 
		query.append("ORDER BY KEY, SLEVEL, ROW_SEQ" ).append("\n"); 

	}
}