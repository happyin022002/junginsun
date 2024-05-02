/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingPathRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingPathRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingPathRole
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingPathRoleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingPathRoleRSQL").append("\n"); 
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
		query.append("SELECT  NVL((" ).append("\n"); 
		query.append("				SELECT  NVL(AFT_BKG_PATH_CD,'N')||'|'||" ).append("\n"); 
		query.append("							CASE AFT_BKG_PATH_CD " ).append("\n"); 
		query.append("								WHEN 'SSZMGR' THEN 'DMT50'" ).append("\n"); 
		query.append("                                WHEN 'BBOPIC' THEN 'DMT30'" ).append("\n"); 
		query.append("								WHEN 'OOMMGR' THEN 'DMT08'" ).append("\n"); 
		query.append("                                WHEN 'BBGMGR' THEN 'DMT03'" ).append("\n"); 
		query.append("                                WHEN 'RHQPIC' THEN 'DMT02'" ).append("\n"); 
		query.append("                                WHEN 'RHQMGR' THEN 'DMT20'" ).append("\n"); 
		query.append("                                WHEN 'HDOPIC' THEN 'DMT01'" ).append("\n"); 
		query.append("                                WHEN 'HDOMGR' THEN 'DMT10'" ).append("\n"); 
		query.append("                                ELSE DECODE(NVL(A.APRO_OFC_CD,'N'),'N','N','DMT02') " ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("							||'|'||" ).append("\n"); 
		query.append("							NVL(B.APRO_OFC_CD,NVL(A.APRO_OFC_CD,'N'))" ).append("\n"); 
		query.append("							||'|'||" ).append("\n"); 
		query.append("							CASE " ).append("\n"); 
		query.append("								WHEN AFT_BKG_PATH_LVL = " ).append("\n"); 
		query.append("									 ( " ).append("\n"); 
		query.append("										SELECT  MAX(AFT_BKG_PATH_LVL)" ).append("\n"); 
		query.append("                                          FROM  DMT_AFT_BKG_APRO_PATH AA" ).append("\n"); 
		query.append("                                         WHERE  AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                           AND  AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("									 ) OR ( A.APRO_OFC_CD IS NOT NULL AND A.APRO_DT IS NULL )" ).append("\n"); 
		query.append("									THEN 'Y'" ).append("\n"); 
		query.append("								ELSE 'N' " ).append("\n"); 
		query.append("							END ||'|'" ).append("\n"); 
		query.append("				  FROM  (" ).append("\n"); 
		query.append("							SELECT  AAA.* " ).append("\n"); 
		query.append("							  FROM  DMT_AFT_BKG_APRO_PATH	AAA" ).append("\n"); 
		query.append("							       ,DMT_AFT_BKG_ADJ_RQST 	BBB" ).append("\n"); 
		query.append("							 WHERE  " ).append("\n"); 
		query.append("									#if(${dar_no} != '')" ).append("\n"); 
		query.append("									BBB.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("									#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("									BBB.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("							   AND  AAA.AFT_EXPT_DAR_NO       = BBB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("							   AND  AAA.AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("							   AND  AAA.DMDT_EXPT_RQST_STS_CD IS NULL " ).append("\n"); 
		query.append("							   AND  AAA.AFT_BKG_PATH_LVL      = " ).append("\n"); 
		query.append("									( " ).append("\n"); 
		query.append("										SELECT  MIN(AFT_BKG_PATH_LVL) " ).append("\n"); 
		query.append("                                          FROM  DMT_AFT_BKG_APRO_PATH AA" ).append("\n"); 
		query.append("                                         WHERE  AA.AFT_EXPT_DAR_NO = AAA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                           AND  AA.DMDT_EXPT_RQST_STS_CD IS NULL" ).append("\n"); 
		query.append("                                           AND  AA.AFT_BKG_PATH_CPLS_FLG = 'Y' " ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("						) B" ).append("\n"); 
		query.append("					   ,DMT_AFT_BKG_ADJ_RQST A" ).append("\n"); 
		query.append("					   ,(" ).append("\n"); 
		query.append("							SELECT  OFC_N5TH_LVL_CD OFC_CD " ).append("\n"); 
		query.append("							  FROM  MAS_OFC_LVL" ).append("\n"); 
		query.append("							 WHERE  OFC_CD = " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  NVL((" ).append("\n"); 
		query.append("														SELECT  OFC_CD " ).append("\n"); 
		query.append("														  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("														 WHERE  (CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("																(" ).append("\n"); 
		query.append("																	SELECT  CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("																	  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("																	 WHERE  1 = 1" ).append("\n"); 
		query.append("																	   #if(${dar_no} != '') " ).append("\n"); 
		query.append("																	   AND  AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("																	   #elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("																	   AND  AFT_EXPT_DAR_NO = " ).append("\n"); 
		query.append("																			( " ).append("\n"); 
		query.append("																				SELECT  AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("																				  FROM  DMT_AFT_BKG_ADJ_RQST " ).append("\n"); 
		query.append("																				 WHERE  AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("																			)" ).append("\n"); 
		query.append("																	   #end" ).append("\n"); 
		query.append("																	   AND  ROWNUM = 1" ).append("\n"); 
		query.append("																)" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("												   ,(" ).append("\n"); 
		query.append("														SELECT  OFC_CD " ).append("\n"); 
		query.append("														  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("														 WHERE  (CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("																(" ).append("\n"); 
		query.append("																	SELECT  CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append("																	  FROM  DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("																	 WHERE  1 = 1" ).append("\n"); 
		query.append("																	   #if(${dar_no} != '') " ).append("\n"); 
		query.append("																	   AND  AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("																	   #elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("																	   AND  AFT_EXPT_DAR_NO = " ).append("\n"); 
		query.append("																			( " ).append("\n"); 
		query.append("																				SELECT  AFT_EXPT_DAR_NO " ).append("\n"); 
		query.append("																				  FROM  DMT_AFT_BKG_ADJ_RQST " ).append("\n"); 
		query.append("																				 WHERE  AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("																			)" ).append("\n"); 
		query.append("																	   #end" ).append("\n"); 
		query.append("																	   AND  ROWNUM = 1																	 " ).append("\n"); 
		query.append("																)" ).append("\n"); 
		query.append("														   AND  ROWNUM = 1" ).append("\n"); 
		query.append("												)) OFC_CD" ).append("\n"); 
		query.append("										  FROM  DUAL" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("							   AND  TO_CHAR(SYSDATE,'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("							   AND  ROWNUM = 1" ).append("\n"); 
		query.append("						) T0" ).append("\n"); 
		query.append("				 WHERE   " ).append("\n"); 
		query.append("						#if(${dar_no} != '')" ).append("\n"); 
		query.append("					    A.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("						#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("						A.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				   AND  B.AFT_EXPT_DAR_NO(+) = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("		),'N|N|N|N|')||" ).append("\n"); 
		query.append("		NVL((" ).append("\n"); 
		query.append("				SELECT  AFT_BKG_PATH_CD||'|'||" ).append("\n"); 
		query.append("							CASE AFT_BKG_PATH_CD " ).append("\n"); 
		query.append("								WHEN 'SSZMGR' THEN 'DMT50'" ).append("\n"); 
		query.append("                                WHEN 'BBOPIC' THEN 'DMT30'" ).append("\n"); 
		query.append("								WHEN 'OOMMGR' THEN 'DMT08'" ).append("\n"); 
		query.append("                                WHEN 'BBGMGR' THEN 'DMT03'" ).append("\n"); 
		query.append("                                WHEN 'RHQPIC' THEN 'DMT02'" ).append("\n"); 
		query.append("                                WHEN 'RHQMGR' THEN 'DMT20'" ).append("\n"); 
		query.append("                                WHEN 'HDOPIC' THEN 'DMT01'" ).append("\n"); 
		query.append("                                WHEN 'HDOMGR' THEN 'DMT10'" ).append("\n"); 
		query.append("                                ELSE DECODE(NVL(A.APRO_OFC_CD,'N'),'N',' ','DMT02') " ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("							||'|'||" ).append("\n"); 
		query.append("							NVL(B.APRO_OFC_CD,NVL(A.APRO_OFC_CD,' '))" ).append("\n"); 
		query.append("							||'|'||" ).append("\n"); 
		query.append("							CASE " ).append("\n"); 
		query.append("								WHEN AFT_BKG_PATH_LVL = " ).append("\n"); 
		query.append("									 ( " ).append("\n"); 
		query.append("										SELECT  MIN(AFT_BKG_PATH_LVL)" ).append("\n"); 
		query.append("                                          FROM  DMT_AFT_BKG_APRO_PATH AA" ).append("\n"); 
		query.append("                                         WHERE  AFT_EXPT_DAR_NO = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                           AND  AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("									 ) OR (A.APRO_OFC_CD IS NOT NULL AND A.APRO_DT IS NOT NULL)" ).append("\n"); 
		query.append("									THEN 'Y'" ).append("\n"); 
		query.append("								ELSE 'N' " ).append("\n"); 
		query.append("							END ||'|'" ).append("\n"); 
		query.append("				  FROM  (" ).append("\n"); 
		query.append("							SELECT  AAA.* " ).append("\n"); 
		query.append("							  FROM  DMT_AFT_BKG_APRO_PATH 	AAA" ).append("\n"); 
		query.append("							       ,DMT_AFT_BKG_ADJ_RQST 	BBB" ).append("\n"); 
		query.append("							 WHERE  " ).append("\n"); 
		query.append("									#if(${dar_no} != '')" ).append("\n"); 
		query.append("								    BBB.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("									#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("									BBB.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("							   AND  AAA.AFT_EXPT_DAR_NO = BBB.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("							   AND  AAA.AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("							   AND  AAA.AFT_BKG_PATH_LVL = " ).append("\n"); 
		query.append("									( " ).append("\n"); 
		query.append("										SELECT  MAX(AFT_BKG_PATH_LVL) " ).append("\n"); 
		query.append("                                          FROM  DMT_AFT_BKG_APRO_PATH AA" ).append("\n"); 
		query.append("										 WHERE  AA.AFT_EXPT_DAR_NO = AAA.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                           AND  AA.AFT_BKG_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("						) B" ).append("\n"); 
		query.append("					   ,DMT_AFT_BKG_ADJ_RQST A" ).append("\n"); 
		query.append("					   ,(" ).append("\n"); 
		query.append("							SELECT  NVL((" ).append("\n"); 
		query.append("											SELECT  OFC_CD " ).append("\n"); 
		query.append("											  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("											 WHERE  (SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("													(" ).append("\n"); 
		query.append("														SELECT  K.SYS_AREA_GRP_ID, K.CNTR_NO, K.CNTR_CYC_NO, K.DMDT_TRF_CD, K.DMDT_CHG_LOC_DIV_CD, K.CHG_SEQ " ).append("\n"); 
		query.append("														  FROM  DMT_AFT_BKG_CNTR 		K" ).append("\n"); 
		query.append("														       ,DMT_AFT_BKG_ADJ_RQST 	L" ).append("\n"); 
		query.append("														 WHERE   " ).append("\n"); 
		query.append("																#if(${dar_no} != '')" ).append("\n"); 
		query.append("															    L.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("																#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("															    L.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("																#end" ).append("\n"); 
		query.append("														   AND  K.AFT_EXPT_DAR_NO = L.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("														   AND  K.RQST_DC_AMT != 0" ).append("\n"); 
		query.append("														   AND  ROWNUM = 1" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("									   ,(" ).append("\n"); 
		query.append("											SELECT  OFC_CD " ).append("\n"); 
		query.append("											  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("											 WHERE  (CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) = " ).append("\n"); 
		query.append("													(" ).append("\n"); 
		query.append("														SELECT  K.CNTR_NO, K.CNTR_CYC_NO, K.DMDT_TRF_CD, K.DMDT_CHG_LOC_DIV_CD, K.CHG_SEQ " ).append("\n"); 
		query.append("														  FROM  DMT_AFT_BKG_CNTR 		K" ).append("\n"); 
		query.append("														       ,DMT_AFT_BKG_ADJ_RQST 	L" ).append("\n"); 
		query.append("														 WHERE   " ).append("\n"); 
		query.append("																#if(${dar_no} != '')" ).append("\n"); 
		query.append("															    L.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("																#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("																L.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("																#end" ).append("\n"); 
		query.append("														   AND  K.AFT_EXPT_DAR_NO = L.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("														   AND  K.RQST_DC_AMT != 0" ).append("\n"); 
		query.append("														   AND  ROWNUM = 1" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("											   AND  ROWNUM = 1" ).append("\n"); 
		query.append("									)) OFC_CD" ).append("\n"); 
		query.append("							  FROM  DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						) T0" ).append("\n"); 
		query.append("				 WHERE  " ).append("\n"); 
		query.append("						#if(${dar_no} != '')" ).append("\n"); 
		query.append("						A.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("						#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("						A.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				   AND  B.AFT_EXPT_DAR_NO(+) = A.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("		),'N|N|N|N|')" ).append("\n"); 
		query.append("  FROM  DUAL" ).append("\n"); 

	}
}