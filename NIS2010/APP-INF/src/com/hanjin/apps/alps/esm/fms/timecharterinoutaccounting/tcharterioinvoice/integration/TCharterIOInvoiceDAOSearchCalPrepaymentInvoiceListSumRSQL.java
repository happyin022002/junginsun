/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_inv_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_brog_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL").append("\n"); 
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
		query.append("#if(${flet_ctrt_tp_gb} == 'TI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CURR_CD," ).append("\n"); 
		query.append("	   INV_AMT," ).append("\n"); 
		query.append("	   CURR_CD2," ).append("\n"); 
		query.append("	   INV_AMT2" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			   CURR_CD," ).append("\n"); 
		query.append("               CASE WHEN CURR_CD = 'KRW' OR CURR_CD = 'JPY' OR CURR_CD = 'PAB' THEN" ).append("\n"); 
		query.append("						 TO_CHAR(ROUND(SUM(INV_AMT),2),'999,999,999,999,999,999')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("			   			 TO_CHAR(ROUND(SUM(INV_AMT),2),'999,999,999,999,999,999.00') " ).append("\n"); 
		query.append("                END INV_AMT, " ).append("\n"); 
		query.append("			   CURR_CD2," ).append("\n"); 
		query.append("			   CASE WHEN CURR_CD2 = 'KRW' OR CURR_CD2 = 'JPY' OR CURR_CD2 = 'PAB' THEN" ).append("\n"); 
		query.append("                         TO_CHAR(ROUND(SUM(INV_AMT2),2),'999,999,999,999,999,999')" ).append("\n"); 
		query.append("				    ELSE" ).append("\n"); 
		query.append("			   			 TO_CHAR(ROUND(SUM(INV_AMT2),2),'999,999,999,999,999,999.00') " ).append("\n"); 
		query.append("                END INV_AMT2," ).append("\n"); 
		query.append("			   MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("				SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("						ACCT_CD," ).append("\n"); 
		query.append("						CURR_CD," ).append("\n"); 
		query.append("						INV_AMT," ).append("\n"); 
		query.append("						CURR_CD2," ).append("\n"); 
		query.append("						INV_AMT2 " ).append("\n"); 
		query.append("				  FROM  ( " ).append("\n"); 
		query.append("						SELECT  ACCT_ITM_NM, " ).append("\n"); 
		query.append("								ACCT_CD, " ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("								'1' SORTKEY " ).append("\n"); 
		query.append("						  FROM ( " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											   '510911' ACCT_CD, " ).append("\n"); 
		query.append("											   HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("											   FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("											   'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("							    UNION ALL " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM, " ).append("\n"); 
		query.append("											   '510911' ACCT_CD, " ).append("\n"); 
		query.append("											   HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("											   FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											   'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							   ) " ).append("\n"); 
		query.append("						UNION ALL " ).append("\n"); 
		query.append("						SELECT	ACCT_ITM_NM, " ).append("\n"); 
		query.append("								ACCT_CD, " ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("								'3' SORTKEY " ).append("\n"); 
		query.append("						  FROM (" ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									   ROUND(HIR_RT_N1ST_AMT,2) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT  (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("												'510911' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("												- FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[acmm_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("												'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										   FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										  WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("											AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("											AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("								UNION ALL" ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									   ROUND(HIR_RT_N1ST_AMT,2) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT	(SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM, " ).append("\n"); 
		query.append("												'510911' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("												- FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[acmm_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("												'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										   FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										  WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("											AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no]) " ).append("\n"); 
		query.append("											AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							   ) WHERE @[acmm_flg] = 'Y' " ).append("\n"); 
		query.append("						UNION ALL " ).append("\n"); 
		query.append("						SELECT  ACCT_ITM_NM, " ).append("\n"); 
		query.append("								ACCT_CD, " ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("								'4' SORTKEY " ).append("\n"); 
		query.append("						  FROM ( " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT	(SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '512641'" ).append("\n"); 
		query.append("													AND ACCT_ITM_SEQ = 41" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("												'512641' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("												FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[flet_brog_rt_amt]/100) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("												'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM  FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no]) " ).append("\n"); 
		query.append("										   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("								UNION ALL " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT	(SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '512641'" ).append("\n"); 
		query.append("													AND ACCT_ITM_SEQ = 41" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("												'512641' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("												FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[flet_brog_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("												'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM  FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no]) " ).append("\n"); 
		query.append("										   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							   ) WHERE @[brog_flg] = 'Y' " ).append("\n"); 
		query.append("						UNION ALL " ).append("\n"); 
		query.append("						SELECT ACCT_ITM_NM," ).append("\n"); 
		query.append("							   ACCT_CD," ).append("\n"); 
		query.append("							   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("							   HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("							   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("							   HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("							   SORTKEY" ).append("\n"); 
		query.append("						  FROM ( " ).append("\n"); 
		query.append("								SELECT	ACCT_ITM_NM, " ).append("\n"); 
		query.append("										ACCT_CD, " ).append("\n"); 
		query.append("										MIN(HIR_CURR_N1ST_CD) HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("										FMS_OTRAMT_FNC(@[flet_ctrt_no], ACCT_CD, ACCT_ITM_SEQ, @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("										MIN(HIR_CURR_N2ND_CD) HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("										MIN(HIR_RT_N2ND_AMT) HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("										ACCT_ITM_SEQ," ).append("\n"); 
		query.append("										MIN(EFF_DT) EFF_DT," ).append("\n"); 
		query.append("										MAX(EXP_DT) EXP_DT," ).append("\n"); 
		query.append("										'2' SORTKEY " ).append("\n"); 
		query.append("								  FROM ( " ).append("\n"); 
		query.append("										SELECT	(SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM " ).append("\n"); 
		query.append("												  WHERE ACCT_CD = FO.ACCT_CD " ).append("\n"); 
		query.append("													AND ACCT_ITM_SEQ = FO.ACCT_ITM_SEQ " ).append("\n"); 
		query.append("													AND ROWNUM =1) ACCT_ITM_NM, " ).append("\n"); 
		query.append("												FO.ACCT_CD, " ).append("\n"); 
		query.append("												FO.CURR_CD HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("												FO.OTR_EXPN_AMT / TO_NUMBER(@[ori_inv_usd_dys]) * TO_NUMBER(@[inv_usd_dys]) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("												NULL HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("												0 HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("												FO.ACCT_ITM_SEQ," ).append("\n"); 
		query.append("												FO.EFF_DT," ).append("\n"); 
		query.append("												FO.EXP_DT" ).append("\n"); 
		query.append("										  FROM  FMS_CONTRACT FC, FMS_OTR_EXPN FO " ).append("\n"); 
		query.append("										 WHERE  FC.FLET_CTRT_NO = FO.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(SUBSTR(@[ori_eff_dt],1,8),'YYYYMMDD') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																					          FROM FMS_OTR_EXPN " ).append("\n"); 
		query.append("																					         WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') <= (SELECT CASE WHEN MAX(EXP_DT) >= TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') THEN" ).append("\n"); 
		query.append("                 																							       MAX(EXP_DT)" ).append("\n"); 
		query.append("            																						          ELSE" ).append("\n"); 
		query.append("                 																							       MAX(EXP_DT) + 1" ).append("\n"); 
		query.append("        																						          END EXP_DT " ).append("\n"); 
		query.append("																					          FROM FMS_OTR_EXPN " ).append("\n"); 
		query.append("																					         WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   ) " ).append("\n"); 
		query.append("								 GROUP BY ACCT_ITM_NM, ACCT_CD, ACCT_ITM_SEQ" ).append("\n"); 
		query.append("							 ) " ).append("\n"); 
		query.append("						) ORDER BY SORTKEY ASC, ACCT_CD ASC, CURR_CD ASC" ).append("\n"); 
		query.append("				) GROUP BY CURR_CD, CURR_CD2" ).append("\n"); 
		query.append("		) ORDER BY ACCT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CURR_CD," ).append("\n"); 
		query.append("	   INV_AMT," ).append("\n"); 
		query.append("	   CURR_CD2," ).append("\n"); 
		query.append("	   INV_AMT2" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			   CURR_CD, " ).append("\n"); 
		query.append("			   CASE WHEN CURR_CD = 'KRW' OR CURR_CD = 'JPY' OR CURR_CD = 'PAB' THEN" ).append("\n"); 
		query.append("						 TO_CHAR(ROUND(SUM(INV_AMT),2),'999,999,999,999,999,999')" ).append("\n"); 
		query.append("					ELSE" ).append("\n"); 
		query.append("			   		     TO_CHAR(ROUND(SUM(INV_AMT),2),'999,999,999,999,999,999.00') " ).append("\n"); 
		query.append("				END INV_AMT, " ).append("\n"); 
		query.append("			   CURR_CD2," ).append("\n"); 
		query.append("			   CASE WHEN CURR_CD2 = 'KRW' OR CURR_CD2 = 'JPY' OR CURR_CD2 = 'PAB' THEN" ).append("\n"); 
		query.append("						 TO_CHAR(ROUND(SUM(INV_AMT2),2),'999,999,999,999,999,999')" ).append("\n"); 
		query.append("					ELSE" ).append("\n"); 
		query.append("			   			 TO_CHAR(ROUND(SUM(INV_AMT2),2),'999,999,999,999,999,999.00') " ).append("\n"); 
		query.append("				END INV_AMT2," ).append("\n"); 
		query.append("			   MIN(ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("		  FROM (" ).append("\n"); 
		query.append("				SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("						ACCT_CD," ).append("\n"); 
		query.append("						CURR_CD," ).append("\n"); 
		query.append("						INV_AMT," ).append("\n"); 
		query.append("						CURR_CD2," ).append("\n"); 
		query.append("						INV_AMT2 " ).append("\n"); 
		query.append("				  FROM  ( " ).append("\n"); 
		query.append("						SELECT  ACCT_ITM_NM, " ).append("\n"); 
		query.append("								ACCT_CD, " ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("								'1' SORTKEY " ).append("\n"); 
		query.append("						  FROM ( " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											   '510911' ACCT_CD, " ).append("\n"); 
		query.append("											   HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("											   FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("											   'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("							    UNION ALL " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM, " ).append("\n"); 
		query.append("											   '510911' ACCT_CD, " ).append("\n"); 
		query.append("											   HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("											   FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											   'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							   ) " ).append("\n"); 
		query.append("						UNION ALL " ).append("\n"); 
		query.append("						SELECT	ACCT_ITM_NM, " ).append("\n"); 
		query.append("								ACCT_CD, " ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("								'3' SORTKEY " ).append("\n"); 
		query.append("						  FROM (" ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									   ROUND(HIR_RT_N1ST_AMT,2) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT  (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("												'510911' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("												- FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[acmm_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("												'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										   FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										  WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("											AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("											AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("								UNION ALL" ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									   ROUND(HIR_RT_N1ST_AMT,2) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT	(SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												  FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												 WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												   AND ROWNUM = 1) ACCT_ITM_NM, " ).append("\n"); 
		query.append("												'510911' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("												- FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[acmm_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("												'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										   FROM FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										  WHERE FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("											AND FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("											AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							   FROM FMS_HIRE " ).append("\n"); 
		query.append("																							  WHERE FLET_CTRT_NO = @[flet_ctrt_no]) " ).append("\n"); 
		query.append("											AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							   ) WHERE @[acmm_flg] = 'Y' " ).append("\n"); 
		query.append("						UNION ALL " ).append("\n"); 
		query.append("						SELECT  ACCT_ITM_NM, " ).append("\n"); 
		query.append("								ACCT_CD, " ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'F',HIR_RT_N1ST_AMT,NULL) INV_AMT," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("								DECODE(FLET_CURR_CHK_CD,'S',HIR_RT_N1ST_AMT,NULL) INV_AMT2," ).append("\n"); 
		query.append("								'4' SORTKEY " ).append("\n"); 
		query.append("						  FROM ( " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT	(SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '512641'" ).append("\n"); 
		query.append("													AND ACCT_ITM_SEQ = 41" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("												'512641' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("												FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[flet_brog_rt_amt]/100)* -1 HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("												'F' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM  FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no]) " ).append("\n"); 
		query.append("										   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("								UNION ALL " ).append("\n"); 
		query.append("								SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("									   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("									   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("								  FROM (SELECT	(SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '512641'" ).append("\n"); 
		query.append("													AND ACCT_ITM_SEQ = 41" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("												'512641' ACCT_CD, " ).append("\n"); 
		query.append("												HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("												FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[flet_brog_rt_amt]/100)* -1 HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("												'S' FLET_CURR_CHK_CD" ).append("\n"); 
		query.append("										  FROM  FMS_CONTRACT FC, FMS_HIRE FH " ).append("\n"); 
		query.append("										 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																							  FROM FMS_HIRE " ).append("\n"); 
		query.append("																							 WHERE FLET_CTRT_NO = @[flet_ctrt_no]) " ).append("\n"); 
		query.append("										   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("									   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("										 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							   ) WHERE @[brog_flg] = 'Y' " ).append("\n"); 
		query.append("						UNION ALL " ).append("\n"); 
		query.append("						SELECT ACCT_ITM_NM," ).append("\n"); 
		query.append("							   ACCT_CD," ).append("\n"); 
		query.append("							   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("							   HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("							   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("							   HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("							   SORTKEY" ).append("\n"); 
		query.append("						  FROM ( " ).append("\n"); 
		query.append("								SELECT	ACCT_ITM_NM, " ).append("\n"); 
		query.append("										ACCT_CD, " ).append("\n"); 
		query.append("										MIN(HIR_CURR_N1ST_CD) HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("										FMS_OTRAMT_FNC(@[flet_ctrt_no], ACCT_CD, ACCT_ITM_SEQ, @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("										MIN(HIR_CURR_N2ND_CD) HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("										MIN(HIR_RT_N2ND_AMT) HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("										ACCT_ITM_SEQ," ).append("\n"); 
		query.append("										MIN(EFF_DT) EFF_DT," ).append("\n"); 
		query.append("										MAX(EXP_DT) EXP_DT," ).append("\n"); 
		query.append("										'2' SORTKEY " ).append("\n"); 
		query.append("								  FROM ( " ).append("\n"); 
		query.append("										SELECT	(SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM " ).append("\n"); 
		query.append("												  WHERE ACCT_CD = FO.ACCT_CD " ).append("\n"); 
		query.append("													AND ACCT_ITM_SEQ = FO.ACCT_ITM_SEQ " ).append("\n"); 
		query.append("													AND ROWNUM =1) ACCT_ITM_NM, " ).append("\n"); 
		query.append("												FO.ACCT_CD, " ).append("\n"); 
		query.append("												FO.CURR_CD HIR_CURR_N1ST_CD, " ).append("\n"); 
		query.append("												FO.OTR_EXPN_AMT / TO_NUMBER(@[ori_inv_usd_dys]) * TO_NUMBER(@[inv_usd_dys]) HIR_RT_N1ST_AMT, " ).append("\n"); 
		query.append("												NULL HIR_CURR_N2ND_CD, " ).append("\n"); 
		query.append("												0 HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("												FO.ACCT_ITM_SEQ," ).append("\n"); 
		query.append("												FO.EFF_DT," ).append("\n"); 
		query.append("												FO.EXP_DT" ).append("\n"); 
		query.append("										  FROM  FMS_CONTRACT FC, FMS_OTR_EXPN FO " ).append("\n"); 
		query.append("										 WHERE  FC.FLET_CTRT_NO = FO.FLET_CTRT_NO " ).append("\n"); 
		query.append("										   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																					          FROM FMS_OTR_EXPN " ).append("\n"); 
		query.append("																					         WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("										   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT CASE WHEN MAX(EXP_DT) >= TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') THEN" ).append("\n"); 
		query.append("                 																							 MAX(EXP_DT)" ).append("\n"); 
		query.append("            																						    ELSE" ).append("\n"); 
		query.append("                 																							 MAX(EXP_DT) + 1" ).append("\n"); 
		query.append("        																						    END EXP_DT " ).append("\n"); 
		query.append("																					          FROM FMS_OTR_EXPN " ).append("\n"); 
		query.append("																					         WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   ) " ).append("\n"); 
		query.append("								 GROUP BY ACCT_ITM_NM, ACCT_CD, ACCT_ITM_SEQ" ).append("\n"); 
		query.append("							 ) " ).append("\n"); 
		query.append("						) ORDER BY SORTKEY ASC, ACCT_CD ASC, CURR_CD ASC" ).append("\n"); 
		query.append("				) GROUP BY CURR_CD, CURR_CD2" ).append("\n"); 
		query.append("		) ORDER BY ACCT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}