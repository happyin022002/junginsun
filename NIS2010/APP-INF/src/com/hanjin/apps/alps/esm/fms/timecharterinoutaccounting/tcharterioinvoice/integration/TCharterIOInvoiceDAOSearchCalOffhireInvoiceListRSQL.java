/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07 
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

public class TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flet_brog_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flet_offh_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("		ACCT_CD," ).append("\n"); 
		query.append("		CURR_CD," ).append("\n"); 
		query.append("		INV_AMT," ).append("\n"); 
		query.append("		ORI_INV_AMT," ).append("\n"); 
		query.append("		CURR_CD2," ).append("\n"); 
		query.append("		INV_AMT2," ).append("\n"); 
		query.append("		ORI_INV_AMT2," ).append("\n"); 
		query.append("		SLP_TP_CD," ).append("\n"); 
		query.append("		INV_DESC," ).append("\n"); 
		query.append("		FLET_CTRT_NO," ).append("\n"); 
		query.append("		ROWNUM INV_DTL_SEQ," ).append("\n"); 
		query.append("		ACCT_ITM_SEQ," ).append("\n"); 
		query.append("		SORTKEY SORT_KEY" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("		SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("				ACCT_CD," ).append("\n"); 
		query.append("				CURR_CD," ).append("\n"); 
		query.append("				INV_AMT," ).append("\n"); 
		query.append("				ORI_INV_AMT," ).append("\n"); 
		query.append("				CURR_CD2," ).append("\n"); 
		query.append("				INV_AMT2," ).append("\n"); 
		query.append("				ORI_INV_AMT2," ).append("\n"); 
		query.append("				SLP_TP_CD," ).append("\n"); 
		query.append("				INV_DESC," ).append("\n"); 
		query.append("				FLET_CTRT_NO," ).append("\n"); 
		query.append("				ACCT_ITM_SEQ," ).append("\n"); 
		query.append("				SORTKEY" ).append("\n"); 
		query.append("		  FROM  (" ).append("\n"); 
		query.append("				SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("						ACCT_CD," ).append("\n"); 
		query.append("						DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("						DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT," ).append("\n"); 
		query.append("						DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT," ).append("\n"); 
		query.append("						DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("						DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT2," ).append("\n"); 
		query.append("						DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT2," ).append("\n"); 
		query.append("						'N' SLP_TP_CD," ).append("\n"); 
		query.append("						INV_DESC," ).append("\n"); 
		query.append("						FLET_CTRT_NO," ).append("\n"); 
		query.append("						ROWNUM INV_DTL_SEQ," ).append("\n"); 
		query.append("						ACCT_ITM_SEQ," ).append("\n"); 
		query.append("						'1' SORTKEY" ).append("\n"); 
		query.append("				  FROM (" ).append("\n"); 
		query.append("						SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("							   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("							   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("							   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("							   MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("							   MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("							   MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("							   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("							   MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("						  FROM (SELECT 	(SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("											   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("											  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("										'510911' ACCT_CD," ).append("\n"); 
		query.append("										HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("										FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("										'N' SLP_TP_CD," ).append("\n"); 
		query.append("										CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("												  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("											 ELSE" ).append("\n"); 
		query.append("												  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("										 END INV_DESC," ).append("\n"); 
		query.append("										(SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("											   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("											  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("												AND ROWNUM = 1) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("										'F' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("										FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("								  FROM  FMS_CONTRACT FC, FMS_HIRE FH" ).append("\n"); 
		query.append("								 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("								   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("								   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																					  FROM FMS_HIRE " ).append("\n"); 
		query.append("																					 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("								   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																					  FROM FMS_HIRE " ).append("\n"); 
		query.append("																					 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("								   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("							   ) WHERE  HIR_RT_N1ST_AMT != 0	" ).append("\n"); 
		query.append("								 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("							UNION ALL" ).append("\n"); 
		query.append("							SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("								   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("								   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("								   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("								   MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("								   MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("								   MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("								   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("								   MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM (SELECT	(SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											'510911' ACCT_CD," ).append("\n"); 
		query.append("											HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("											FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											'N' SLP_TP_CD," ).append("\n"); 
		query.append("											CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("											 END INV_DESC," ).append("\n"); 
		query.append("											(SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("											'S' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("											FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									  FROM  FMS_CONTRACT FC, FMS_HIRE FH" ).append("\n"); 
		query.append("									 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("								   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("									 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT	ACCT_ITM_NM," ).append("\n"); 
		query.append("							ACCT_CD," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT2," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT2," ).append("\n"); 
		query.append("							'N' SLP_TP_CD," ).append("\n"); 
		query.append("							INV_DESC," ).append("\n"); 
		query.append("							FLET_CTRT_NO," ).append("\n"); 
		query.append("							ROWNUM INV_DTL_SEQ," ).append("\n"); 
		query.append("							ACCT_ITM_SEQ," ).append("\n"); 
		query.append("							'3' SORTKEY" ).append("\n"); 
		query.append("					  FROM (" ).append("\n"); 
		query.append("							SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("								   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("								   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("								   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("								   MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("								   MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("								   MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("								   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("								   MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM (SELECT  (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											'510911' ACCT_CD," ).append("\n"); 
		query.append("											HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("											- FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[acmm_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											'N' SLP_TP_CD," ).append("\n"); 
		query.append("											CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("											 END INV_DESC," ).append("\n"); 
		query.append("											(SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("											'F' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("											FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									  FROM  FMS_CONTRACT FC, FMS_HIRE FH" ).append("\n"); 
		query.append("									 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("								   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("									 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("							UNION ALL" ).append("\n"); 
		query.append("							SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("								   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("								   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("								   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("								   MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("								   MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("								   MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("								   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("								   MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM (SELECT  (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											'510911' ACCT_CD," ).append("\n"); 
		query.append("											HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("											- FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[acmm_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											'N' SLP_TP_CD," ).append("\n"); 
		query.append("											CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("											 END INV_DESC," ).append("\n"); 
		query.append("											(SELECT ACCT_ITM_SEQ" ).append("\n"); 
		query.append("												   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("												  WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("													AND ROWNUM = 1) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("											'S' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("											FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									  FROM  FMS_CONTRACT FC, FMS_HIRE FH" ).append("\n"); 
		query.append("									 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("								   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("									 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("							) WHERE @[acmm_flg] = 'Y'" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("							ACCT_CD," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT2," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT2," ).append("\n"); 
		query.append("							'N' SLP_TP_CD," ).append("\n"); 
		query.append("							INV_DESC," ).append("\n"); 
		query.append("							FLET_CTRT_NO," ).append("\n"); 
		query.append("							ROWNUM INV_DTL_SEQ," ).append("\n"); 
		query.append("							ACCT_ITM_SEQ," ).append("\n"); 
		query.append("							'4' SORTKEY" ).append("\n"); 
		query.append("					FROM (" ).append("\n"); 
		query.append("							SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("								   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("								   HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("								   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("								   MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("								   MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("								   MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("								   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("								   MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM (SELECT  (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("													   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("													  WHERE ACCT_CD = '512641'" ).append("\n"); 
		query.append("														AND ACCT_ITM_SEQ = 41" ).append("\n"); 
		query.append("														AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											'512641' ACCT_CD," ).append("\n"); 
		query.append("											HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("											FMS_HIRCURAMT1_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[flet_brog_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											'N' SLP_TP_CD," ).append("\n"); 
		query.append("											CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("											 END INV_DESC," ).append("\n"); 
		query.append("											41 ACCT_ITM_SEQ," ).append("\n"); 
		query.append("											'F' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("											FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									  FROM  FMS_CONTRACT FC, FMS_HIRE FH" ).append("\n"); 
		query.append("									 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  HIR_CURR_N1ST_CD IS NOT NULL" ).append("\n"); 
		query.append("								   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("									 GROUP BY HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("							UNION ALL" ).append("\n"); 
		query.append("							SELECT MIN(ACCT_ITM_NM) ACCT_ITM_NM," ).append("\n"); 
		query.append("								   MIN(ACCT_CD) ACCT_CD," ).append("\n"); 
		query.append("								   HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("								   HIR_RT_N1ST_AMT HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("								   MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("								   MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("								   MIN(ACCT_ITM_SEQ) ACCT_ITM_SEQ," ).append("\n"); 
		query.append("								   MIN(FLET_CURR_CHK_CD) FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("								   MIN(FLET_CTRT_NO) FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM (SELECT  (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("													   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("													  WHERE ACCT_CD = '512641'" ).append("\n"); 
		query.append("														AND ACCT_ITM_SEQ = 41" ).append("\n"); 
		query.append("														AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											'512641' ACCT_CD," ).append("\n"); 
		query.append("											HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("											FMS_HIRCURAMT2_FNC(@[flet_ctrt_no], @[ori_eff_dt], @[ori_exp_dt]) * TO_NUMBER(@[flet_brog_rt_amt]/100) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											'N' SLP_TP_CD," ).append("\n"); 
		query.append("											CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("											 END INV_DESC," ).append("\n"); 
		query.append("											41 ACCT_ITM_SEQ," ).append("\n"); 
		query.append("											'S' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("											FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									  FROM  FMS_CONTRACT FC, FMS_HIRE FH" ).append("\n"); 
		query.append("									 WHERE  FC.FLET_CTRT_NO = FH.FLET_CTRT_NO" ).append("\n"); 
		query.append("									   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_HIRE " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  HIR_CURR_N2ND_CD IS NOT NULL" ).append("\n"); 
		query.append("								   ) WHERE  HIR_RT_N1ST_AMT != 0" ).append("\n"); 
		query.append("									 GROUP BY HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("						) WHERE @[brog_flg] = 'Y'" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("							ACCT_CD," ).append("\n"); 
		query.append("							HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("							HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("							HIR_RT_N1ST_AMT ORI_HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("							HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("							HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("							ORI_HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("							SLP_TP_CD," ).append("\n"); 
		query.append("							INV_DESC," ).append("\n"); 
		query.append("							FLET_CTRT_NO," ).append("\n"); 
		query.append("							INV_DTL_SEQ," ).append("\n"); 
		query.append("							ACCT_ITM_SEQ," ).append("\n"); 
		query.append("							SORTKEY" ).append("\n"); 
		query.append("					  FROM  (" ).append("\n"); 
		query.append("							SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("									ACCT_CD," ).append("\n"); 
		query.append("									MIN(HIR_CURR_N1ST_CD) HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									TO_CHAR(FMS_OTRAMT_FNC(@[flet_ctrt_no], ACCT_CD, ACCT_ITM_SEQ, @[ori_eff_dt], @[ori_exp_dt]),'999,999,999,999,999,990.00') HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									'' ORI_HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									MIN(HIR_CURR_N2ND_CD) HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									MIN(HIR_RT_N2ND_AMT) HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("									MIN(HIR_RT_N2ND_AMT) ORI_HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("									MIN(SLP_TP_CD) SLP_TP_CD," ).append("\n"); 
		query.append("									MIN(INV_DESC) INV_DESC," ).append("\n"); 
		query.append("									MIN(FLET_CTRT_NO) FLET_CTRT_NO," ).append("\n"); 
		query.append("									MIN(INV_DTL_SEQ) INV_DTL_SEQ," ).append("\n"); 
		query.append("									ACCT_ITM_SEQ," ).append("\n"); 
		query.append("									MIN(EFF_DT) EFF_DT," ).append("\n"); 
		query.append("									MAX(EXP_DT) EXP_DT," ).append("\n"); 
		query.append("									'2' SORTKEY" ).append("\n"); 
		query.append("							  FROM  (" ).append("\n"); 
		query.append("									SELECT  (SELECT ACCT_ITM_NM " ).append("\n"); 
		query.append("											   FROM FMS_ACCT_ITM " ).append("\n"); 
		query.append("											  WHERE ACCT_CD = FO.ACCT_CD " ).append("\n"); 
		query.append("												AND ACCT_ITM_SEQ = FO.ACCT_ITM_SEQ " ).append("\n"); 
		query.append("												AND ROWNUM =1) ACCT_ITM_NM," ).append("\n"); 
		query.append("											FO.ACCT_CD," ).append("\n"); 
		query.append("											FO.CURR_CD HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("											FO.OTR_EXPN_AMT * TO_NUMBER(@[inv_usd_dys]) HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("											NULL HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("											NULL HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("											'N' SLP_TP_CD," ).append("\n"); 
		query.append("											CASE WHEN SUBSTR(@[ori_exp_dt],9,4) = '0000' THEN" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || TO_CHAR(TO_DATE(SUBSTR(@[ori_exp_dt],1,8),'YYYYMMDD') -1,'YYYY-MM-DD') || ')'" ).append("\n"); 
		query.append("												 ELSE" ).append("\n"); 
		query.append("													  DECODE(@[flet_offh_rsn_cd],'D','Dry Dock','Off-hire') || ' ' || SUBSTR(@[bunker_vvd],1,9) || ' ' || '(' || @[eff_dt] || ' ~ ' || @[exp_dt] || ')'" ).append("\n"); 
		query.append("											 END INV_DESC," ).append("\n"); 
		query.append("											FO.FLET_CTRT_NO," ).append("\n"); 
		query.append("											ROWNUM INV_DTL_SEQ," ).append("\n"); 
		query.append("											FO.ACCT_ITM_SEQ," ).append("\n"); 
		query.append("											FO.EFF_DT," ).append("\n"); 
		query.append("											FO.EXP_DT" ).append("\n"); 
		query.append("									  FROM  FMS_CONTRACT FC, FMS_OTR_EXPN FO" ).append("\n"); 
		query.append("									 WHERE  FC.FLET_CTRT_NO = FO.FLET_CTRT_NO" ).append("\n"); 
		query.append("									   AND  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_OTR_EXPN " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																						  FROM FMS_OTR_EXPN " ).append("\n"); 
		query.append("																						 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("									GROUP BY ACCT_ITM_NM, ACCT_CD, ACCT_ITM_SEQ" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("				#if(${offh_seq} != '')" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT  ACCT_ITM_NM," ).append("\n"); 
		query.append("							ACCT_CD," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',HIR_CURR_N1ST_CD,NULL) CURR_CD," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'F',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',HIR_CURR_N1ST_CD,NULL) CURR_CD2," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) INV_AMT2," ).append("\n"); 
		query.append("							DECODE(FLET_CURR_CHK_CD,'S',TO_CHAR(HIR_RT_N1ST_AMT,'FM999,999,999,999,999,990.00'),NULL) ORI_INV_AMT2," ).append("\n"); 
		query.append("							'N' SLP_TP_CD," ).append("\n"); 
		query.append("							INV_DESC," ).append("\n"); 
		query.append("							FLET_CTRT_NO," ).append("\n"); 
		query.append("							ROWNUM INV_DTL_SEQ," ).append("\n"); 
		query.append("							ACCT_ITM_SEQ," ).append("\n"); 
		query.append("							'5' SORTKEY" ).append("\n"); 
		query.append("					  FROM  (" ).append("\n"); 
		query.append("							SELECT  (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("									   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("									  WHERE ACCT_CD = '511191'" ).append("\n"); 
		query.append("										AND ACCT_ITM_SEQ = 14" ).append("\n"); 
		query.append("										AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("									'511191' ACCT_CD," ).append("\n"); 
		query.append("									'USD' HIR_CURR_N1ST_CD," ).append("\n"); 
		query.append("									FOIL_QTY * FOIL_PRC HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									'N' SLP_TP_CD," ).append("\n"); 
		query.append("									'IFO ' || TO_CHAR(FOIL_QTY,'FM999,999,999,999.00') || ' * USD ' || TO_CHAR(FOIL_PRC,'FM999,999,999,999.00') INV_DESC," ).append("\n"); 
		query.append("									14 ACCT_ITM_SEQ," ).append("\n"); 
		query.append("									'F' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("									@[flet_ctrt_no] FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM  FMS_OFFH_EXPN" ).append("\n"); 
		query.append("							 WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("							   AND  OFFH_SEQ = @[offh_seq]" ).append("\n"); 
		query.append("							   AND  FOIL_QTY * FOIL_PRC > 0" ).append("\n"); 
		query.append("							   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																				  FROM FMS_HIRE " ).append("\n"); 
		query.append("																				 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("							   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																				  FROM FMS_HIRE " ).append("\n"); 
		query.append("																				 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("							UNION ALL" ).append("\n"); 
		query.append("							SELECT  (SELECT ACCT_ITM_NM" ).append("\n"); 
		query.append("									   FROM FMS_ACCT_ITM" ).append("\n"); 
		query.append("									  WHERE ACCT_CD = '511191'" ).append("\n"); 
		query.append("										AND ACCT_ITM_SEQ = 15" ).append("\n"); 
		query.append("										AND ROWNUM = 1) ACCT_ITM_NM," ).append("\n"); 
		query.append("									'511191' ACCT_CD," ).append("\n"); 
		query.append("									'USD' HIR_CURR_N2ND_CD," ).append("\n"); 
		query.append("									DOIL_QTY * DOIL_PRC HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("									'N' SLP_TP_CD," ).append("\n"); 
		query.append("									'MDO ' || TO_CHAR(DOIL_QTY,'FM999,999,999,999.00') || ' * USD ' || TO_CHAR(DOIL_PRC,'FM999,999,999,999.00')  INV_DESC," ).append("\n"); 
		query.append("									15 ACCT_ITM_SEQ," ).append("\n"); 
		query.append("									'F' FLET_CURR_CHK_CD," ).append("\n"); 
		query.append("									@[flet_ctrt_no] FLET_CTRT_NO" ).append("\n"); 
		query.append("							  FROM  FMS_OFFH_EXPN" ).append("\n"); 
		query.append("							 WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("							   AND  OFFH_SEQ = @[offh_seq]" ).append("\n"); 
		query.append("							   AND  DOIL_QTY * DOIL_PRC > 0" ).append("\n"); 
		query.append("							   AND  TO_DATE(@[ori_eff_dt],'YYYYMMDDHH24MI') >= (SELECT MIN(EFF_DT) " ).append("\n"); 
		query.append("																				  FROM FMS_HIRE " ).append("\n"); 
		query.append("																				 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("							   AND  TO_DATE(@[ori_exp_dt],'YYYYMMDDHH24MI') <= (SELECT MAX(EXP_DT) " ).append("\n"); 
		query.append("																				  FROM FMS_HIRE " ).append("\n"); 
		query.append("																				 WHERE FLET_CTRT_NO = @[flet_ctrt_no])" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) ORDER BY SORTKEY ASC, ACCT_CD ASC, CURR_CD ASC" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}