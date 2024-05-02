/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCReportDBDAORsltSearchMOTSSEFilingDailyLogWithBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchMOTSSEFilingDailyLogWithBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일별 대상 데이터 with Bkg No & Bkg Source Type Code 조회
	  * - 추적을 위한 참고 Data 조회
	  * * 2013.08.29 송호진 [CHM-201431591] MOT Filing 양식 변경 - O.EIC, O.SLF 추가
	  * * 2016.01.13 [CHM-201539514] SSE Agreement Filing 상 Surcharge 추가 요청 Requested By SELCMA / Kim GyungUk -- OBS, BCC, BLR, LBP, CTC, LSI 추가
	  * </pre>
	  */
	public SCReportDBDAORsltSearchMOTSSEFilingDailyLogWithBkgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_file_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchMOTSSEFilingDailyLogWithBkgListRSQL").append("\n"); 
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
		query.append("WITH DATA_SEARCH AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT" ).append("\n"); 
		query.append("            A.BAT_EXE_DT" ).append("\n"); 
		query.append("        ,   A.BKG_SRC_TP_CD" ).append("\n"); 
		query.append("        ,   A.BKG_NO" ).append("\n"); 
		query.append("        ,   A.CTRT_NO" ).append("\n"); 
		query.append("        ,   A.CTRT_HLD_NM" ).append("\n"); 
		query.append("        ,   C.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("        ,   A.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,   A.ACT_CUST_NM" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_PST_RLY_PORT_CD" ).append("\n"); 
		query.append("        ,   A.MQC_QTY AS MQC_QTY1" ).append("\n"); 
		query.append("        ,   '' AS MQC_QTY2" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("        ,   '' AS COMMISSION" ).append("\n"); 
		query.append("        ,   A.CTRT_EFF_DT" ).append("\n"); 
		query.append("        ,   A.CTRT_EXP_DT" ).append("\n"); 
		query.append("        ,   SUM ( " ).append("\n"); 
		query.append("            CASE WHEN D.SVC_SCP_CD = 'IAA' -- A.MOT_FILE_LANE_CD IN ( '02','04','05','06','13','14' ) -- IAA SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'BAF', B.MOT_FILE_CHG_AMT, 'FAF', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'AEW' -- A.MOT_FILE_LANE_CD IN ( '01','07','08' ) -- AEW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'BAF', B.MOT_FILE_CHG_AMT, 'FRC', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'TPE' -- A.MOT_FILE_LANE_CD IN ( '09','10' ) -- TPE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'BUC', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'BRW' -- A.MOT_FILE_LANE_CD = '11' -- BRW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'BAF', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'MXE' -- A.MOT_FILE_LANE_CD = '12' -- MXE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'BAF', B.MOT_FILE_CHG_AMT, 'BUC', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'SAE' -- A.MOT_FILE_LANE_CD = '12' -- SAE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'BAF', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 END  ) AS BAF_AMT" ).append("\n"); 
		query.append("        ,   SUM ( " ).append("\n"); 
		query.append("            CASE WHEN D.SVC_SCP_CD = 'IAA' -- A.MOT_FILE_LANE_CD IN ( '02','04','05','06','13','14' ) -- IAA SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'CAF', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'AEW' -- A.MOT_FILE_LANE_CD IN ( '01','07','08' ) -- AEW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'CAF', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'TPE' -- A.MOT_FILE_LANE_CD IN ( '09','10' ) -- TPE SCOPE" ).append("\n"); 
		query.append("                 THEN 0" ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'BRW' -- A.MOT_FILE_LANE_CD = '11'  -- BRW SCOPE" ).append("\n"); 
		query.append("                 THEN 0" ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'MXE' -- A.MOT_FILE_LANE_CD = '12' -- MXE SCOPE" ).append("\n"); 
		query.append("                 THEN 0" ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'SAE' -- A.MOT_FILE_LANE_CD = '12' -- SAE SCOPE" ).append("\n"); 
		query.append("                 THEN 0" ).append("\n"); 
		query.append("                 END  ) AS CAF_AMT" ).append("\n"); 
		query.append("        ,   SUM ( " ).append("\n"); 
		query.append("            CASE WHEN D.SVC_SCP_CD = 'IAA' -- A.MOT_FILE_LANE_CD IN ( '02','04','05','06','13','14' ) -- IAA SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'OTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'AEW' -- A.MOT_FILE_LANE_CD IN ( '01','07','08' ) -- AEW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'OTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'TPE' -- A.MOT_FILE_LANE_CD IN ( '09','10' ) -- TPE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'ORC', B.MOT_FILE_CHG_AMT, 'OTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'BRW' -- A.MOT_FILE_LANE_CD = '11'  -- BRW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'OTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'MXE' -- A.MOT_FILE_LANE_CD = '12' -- MXE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'OTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'SAE' -- A.MOT_FILE_LANE_CD = '12' -- SAE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'OTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 END  ) AS OTHC_AMT" ).append("\n"); 
		query.append("        ,   SUM ( " ).append("\n"); 
		query.append("            CASE WHEN D.SVC_SCP_CD = 'IAA' -- A.MOT_FILE_LANE_CD IN ( '02','04','05','06','13','14' ) -- IAA SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'DTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'AEW' -- A.MOT_FILE_LANE_CD IN ( '01','07','08' ) -- AEW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'DTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'TPE' -- A.MOT_FILE_LANE_CD IN ( '09','10' ) -- TPE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'DDC', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'BRW' -- A.MOT_FILE_LANE_CD = '11'  -- BRW SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'DTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'MXE' -- A.MOT_FILE_LANE_CD = '12' -- MXE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'DTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 WHEN D.SVC_SCP_CD = 'SAE' -- A.MOT_FILE_LANE_CD = '12' -- SAE SCOPE" ).append("\n"); 
		query.append("                 THEN DECODE ( B.CHG_CD , 'DTH', B.MOT_FILE_CHG_AMT, 0 ) " ).append("\n"); 
		query.append("                 END  ) AS DTHC_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'APR', B.MOT_FILE_CHG_AMT, 0 ) )  AS APS_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'CSR', B.MOT_FILE_CHG_AMT, 0 ) )  AS CSR_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'PSC', B.MOT_FILE_CHG_AMT, 0 ) )  AS PSC_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'PCC', B.MOT_FILE_CHG_AMT, 0 ) )  AS PCC_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'PCS', B.MOT_FILE_CHG_AMT, 0 ) )  AS PCS_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'STF', B.MOT_FILE_CHG_AMT, 0 ) )  AS STF_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'ACT', B.MOT_FILE_CHG_AMT, 0 ) )  AS DACT_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'DDC', B.MOT_FILE_CHG_AMT, 0 ) )  AS DDDC_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'DDF', B.MOT_FILE_CHG_AMT, 0 ) )  AS DDDF_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'NFC', B.MOT_FILE_CHG_AMT, 0 ) )  AS DNFC_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'ENS', B.MOT_FILE_CHG_AMT, 0 ) )  AS OENS_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'DHF', B.MOT_FILE_CHG_AMT, 0 ) )  AS OD_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'DIS', B.MOT_FILE_CHG_AMT, 0 ) )  AS TDIS_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'GOH', B.MOT_FILE_CHG_AMT, 0 ) )  AS TGOH_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'WSC', B.MOT_FILE_CHG_AMT, 0 ) )  AS TWSC_AMT   " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'EIC', B.MOT_FILE_CHG_AMT, 0 ) )  AS OEIC_AMT    " ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'SLF', B.MOT_FILE_CHG_AMT, 0 ) )  AS OSLF_AMT   " ).append("\n"); 
		query.append("        -- CHM-201539514 Surcharge 추가" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'OBS', B.MOT_FILE_CHG_AMT, 0 ) )  AS OBS_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'BCC', B.MOT_FILE_CHG_AMT, 0 ) )  AS BCC_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'BLR', B.MOT_FILE_CHG_AMT, 0 ) )  AS BLR_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'LBP', B.MOT_FILE_CHG_AMT, 0 ) )  AS LBP_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'CTC', B.MOT_FILE_CHG_AMT, 0 ) )  AS CTC_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'LSI', B.MOT_FILE_CHG_AMT, 0 ) )  AS LSI_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'CMS', B.MOT_FILE_CHG_AMT, 0 ) )  AS OCMS_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'OCP', B.MOT_FILE_CHG_AMT, 0 ) )  AS DOCP_AMT" ).append("\n"); 
		query.append("        ,   SUM ( DECODE ( B.CHG_CD, 'DCS', B.MOT_FILE_CHG_AMT, 0 ) )  AS DDCS_AMT" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_RMK AS REMARK" ).append("\n"); 
		query.append("    FROM    PRI_MOT_FILE_RT_LOG A" ).append("\n"); 
		query.append("        ,   PRI_MOT_FILE_RT_LOG_DTL B     " ).append("\n"); 
		query.append("        ,   MDM_CUSTOMER C" ).append("\n"); 
		query.append("        ,   PRI_MOT_FILE_LOC_PPT D" ).append("\n"); 
		query.append("    WHERE   A.BAT_EXE_DT BETWEEN TO_DATE ( @[fr_file_dt], 'YYYY-MM-DD' ) AND TO_DATE ( @[to_file_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("    AND     A.BAT_EXE_DT = B.BAT_EXE_DT(+)" ).append("\n"); 
		query.append("    AND     A.MOT_FILE_RT_LOG_SEQ = B.MOT_FILE_RT_LOG_SEQ(+)" ).append("\n"); 
		query.append("    AND     A.SHPR_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("    AND     A.SHPR_SEQ  = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("    AND     A.MOT_FILE_DEST_CD = D.MOT_FILE_LOC_CD" ).append("\n"); 
		query.append("    GROUP   BY " ).append("\n"); 
		query.append("            A.BAT_EXE_DT" ).append("\n"); 
		query.append("        ,   A.BKG_SRC_TP_CD" ).append("\n"); 
		query.append("        ,   A.BKG_NO" ).append("\n"); 
		query.append("        ,   A.CTRT_NO" ).append("\n"); 
		query.append("        ,   A.CTRT_HLD_NM" ).append("\n"); 
		query.append("        ,   C.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("        ,   A.SHPR_CNT_CD" ).append("\n"); 
		query.append("        ,   A.SHPR_SEQ" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,   A.ACT_CUST_NM" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_PST_RLY_PORT_CD" ).append("\n"); 
		query.append("        ,   A.MQC_QTY" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("        ,   A.CTRT_EFF_DT" ).append("\n"); 
		query.append("        ,   A.CTRT_EXP_DT" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_RMK " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER () OVER ( PARTITION BY BAT_EXE_DT ORDER BY BKG_SRC_TP_CD, BKG_NO ) AS SEQ" ).append("\n"); 
		query.append("    ,   TO_CHAR ( BAT_EXE_DT, 'YYYY-MM-DD' ) AS BAT_EXE_DT" ).append("\n"); 
		query.append("    ,   ( SELECT B.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL B WHERE B.INTG_CD_ID = 'CD03281' AND B.INTG_CD_VAL_CTNT = BKG_SRC_TP_CD ) AS BKG_SRC_TP_CD" ).append("\n"); 
		query.append("    ,   BKG_NO" ).append("\n"); 
		query.append("    ,   'SML' AS CARRIER" ).append("\n"); 
		query.append("    ,   CTRT_NO " ).append("\n"); 
		query.append("    ,   CTRT_HLD_NM " ).append("\n"); 
		query.append("    ,   CUST_LGL_ENG_NM AS SHPR_NM" ).append("\n"); 
		query.append("    ,   MOT_FILE_LANE_CD AS LANE" ).append("\n"); 
		query.append("    ,   MOT_FILE_ORG_CD AS POR_CD" ).append("\n"); 
		query.append("    ,   MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("    ,   MOT_FILE_DEST_CD AS DEL_CD" ).append("\n"); 
		query.append("    ,   MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("    ,   MOT_FILE_CNTR_TP_CD AS CNTR_TP" ).append("\n"); 
		query.append("    ,   MOT_FILE_CMDT_TP_CD AS CMDT_TP" ).append("\n"); 
		query.append("    ,   ACT_CUST_NM" ).append("\n"); 
		query.append("    ,   MOT_FILE_CNTR_SZ_CD AS CNTR_SZ" ).append("\n"); 
		query.append("    ,   MOT_FILE_PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,   MOT_FILE_PST_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,   MQC_QTY1 AS MQC1" ).append("\n"); 
		query.append("    ,   MQC_QTY2 AS MQC2" ).append("\n"); 
		query.append("    ,   MOT_FILE_RT_AMT AS OFT_RT" ).append("\n"); 
		query.append("    ,   COMMISSION AS BLNK1" ).append("\n"); 
		query.append("    ,   DECODE ( BAF_AMT,  0, NULL, BAF_AMT  ||'' ) AS BAF_AMT    " ).append("\n"); 
		query.append("    ,   DECODE ( CAF_AMT,  0, NULL, CAF_AMT  ||'' ) AS CAF_AMT    " ).append("\n"); 
		query.append("    ,   DECODE ( OTHC_AMT, 0, NULL, OTHC_AMT ||'' ) AS OTHC_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( DTHC_AMT, 0, NULL, DTHC_AMT ||'' ) AS DTHC_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( APS_AMT,  0, NULL, APS_AMT  ||'' ) AS APS_AMT  " ).append("\n"); 
		query.append("    ,   DECODE ( CSR_AMT,  0, NULL, CSR_AMT  ||'' ) AS CSR_AMT  " ).append("\n"); 
		query.append("    ,   DECODE ( PSC_AMT,  0, NULL, PSC_AMT  ||'' ) AS PSC_AMT  " ).append("\n"); 
		query.append("    ,   DECODE ( PCC_AMT,  0, NULL, PCC_AMT  ||'' ) AS PCC_AMT   " ).append("\n"); 
		query.append("    ,   DECODE ( PCS_AMT,  0, NULL, PCS_AMT  ||'' ) AS PCS_AMT   " ).append("\n"); 
		query.append("    ,   DECODE ( STF_AMT,  0, NULL, STF_AMT  ||'' ) AS STF_AMT   " ).append("\n"); 
		query.append("    ,   DECODE ( DACT_AMT, 0, NULL, DACT_AMT ||'' ) AS DACT_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( DDDC_AMT, 0, NULL, DDDC_AMT ||'' ) AS DDDC_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( DDDF_AMT, 0, NULL, DDDF_AMT ||'' ) AS DDDF_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( DNFC_AMT, 0, NULL, DNFC_AMT ||'' ) AS DNFC_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( OENS_AMT, 0, NULL, OENS_AMT ||'' ) AS OENS_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( OD_AMT,   0, NULL, OD_AMT   ||'' ) AS OD_AMT     " ).append("\n"); 
		query.append("    ,   DECODE ( TDIS_AMT, 0, NULL, TDIS_AMT ||'' ) AS TDIS_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( TGOH_AMT, 0, NULL, TGOH_AMT ||'' ) AS TGOH_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( TWSC_AMT, 0, NULL, TWSC_AMT ||'' ) AS TWSC_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( OEIC_AMT, 0, NULL, OEIC_AMT ||'' ) AS OEIC_AMT " ).append("\n"); 
		query.append("    ,   DECODE ( OSLF_AMT, 0, NULL, OSLF_AMT ||'' ) AS OSLF_AMT " ).append("\n"); 
		query.append("        -- CHM-201539514 Surcharge 추가" ).append("\n"); 
		query.append("    ,   DECODE ( OBS_AMT, 0, NULL, OBS_AMT ||'' )  AS OBS_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( BCC_AMT, 0, NULL, BCC_AMT ||'' )  AS BCC_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( BLR_AMT, 0, NULL, BLR_AMT ||'' )  AS BLR_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( LBP_AMT, 0, NULL, LBP_AMT ||'' )  AS LBP_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( CTC_AMT, 0, NULL, CTC_AMT ||'' )  AS CTC_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( LSI_AMT, 0, NULL, LSI_AMT ||'' )  AS LSI_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( OCMS_AMT, 0, NULL, OCMS_AMT ||'' )  AS OCMS_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( DOCP_AMT, 0, NULL, DOCP_AMT ||'' )  AS DOCP_AMT" ).append("\n"); 
		query.append("    ,   DECODE ( DDCS_AMT, 0, NULL, DDCS_AMT ||'' )  AS DDCS_AMT" ).append("\n"); 
		query.append("    ,   TO_CHAR ( CTRT_EFF_DT, 'YYYY-MM-DD' ) AS EFF_DT" ).append("\n"); 
		query.append("    ,   TO_CHAR ( CTRT_EXP_DT, 'YYYY-MM-DD' ) AS EXP_DT" ).append("\n"); 
		query.append("    ,   REMARK " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DATA_SEARCH" ).append("\n"); 
		query.append("ORDER	BY BAT_EXE_DT, BKG_SRC_TP_CD, BKG_NO" ).append("\n"); 

	}
}