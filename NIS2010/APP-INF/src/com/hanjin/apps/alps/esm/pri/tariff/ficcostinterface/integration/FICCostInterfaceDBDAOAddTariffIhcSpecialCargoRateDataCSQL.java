/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FICCostInterfaceDBDAOAddTariffIhcSpecialCargoRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOAddTariffIhcSpecialCargoRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRF_IHC_SPCL_CGO_RT
	  * 2013.03.20 전윤주 [CHM-201323682] AOC 에서 cargo weight IF 시 20'는 2.5, 40'는 4 ton을 빼고 IF 한다.
	  * 2013.07.26 전윤주 [CHM-201326002] Fixed AMT 소수점 아래 반올림하여 정수로 처리
	  * 2013.08.06 전윤주 [CHM-201326196] Overweight Fixed AMT 를 Local curr. 금액 그대로 IF 하는 컬럼 추가
	  * </pre>
	  */
	public FICCostInterfaceDBDAOAddTariffIhcSpecialCargoRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOAddTariffIhcSpecialCargoRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_IHC_SPCL_CGO_RT" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   ORG_DEST_TP_CD," ).append("\n"); 
		query.append("   IHC_TRF_NO," ).append("\n"); 
		query.append("   PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("   PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("   DG_RT_AMT," ).append("\n"); 
		query.append("   DG_RT_RTO," ).append("\n"); 
		query.append("   MIN_CGO_WGT," ).append("\n"); 
		query.append("   MAX_CGO_WGT," ).append("\n"); 
		query.append("   OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("   OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("   OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("   DCGO_SVC_FLG," ).append("\n"); 
		query.append("   OVR_WGT_CGO_SVC_FLG," ).append("\n"); 
		query.append("   LOCL_CURR_CD," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT," ).append("\n"); 
		query.append("   LOCL_OVR_WGT_RT_AMT)" ).append("\n"); 
		query.append("  SELECT T1.SVC_SCP_CD," ).append("\n"); 
		query.append("         T1.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("         T1.IHC_TRF_NO," ).append("\n"); 
		query.append("         T1.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("         T1.PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         T1.DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("         ROUND(TPB_GET_USD_AMT_FNC(T1.DG_RT_AMT, T1.CURR_CD, T1.ACCT_XCH_RT_YRMON), 0) DG_RT_AMT," ).append("\n"); 
		query.append("         T1.DG_RT_RTO," ).append("\n"); 
		query.append("         T1.MIN_CGO_WGT," ).append("\n"); 
		query.append("         T1.MAX_CGO_WGT," ).append("\n"); 
		query.append("         T1.OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("         ROUND(TPB_GET_USD_AMT_FNC(T1.OVR_WGT_RT_AMT, T1.CURR_CD, T1.ACCT_XCH_RT_YRMON), 0) OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("         T1.OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("         T1.DCGO_SVC_FLG," ).append("\n"); 
		query.append("         T1.OVWT_CGO_SVC_FLG,   " ).append("\n"); 
		query.append("         T1.CURR_CD," ).append("\n"); 
		query.append("         T1.CRE_USR_ID," ).append("\n"); 
		query.append("         T1.CRE_DT," ).append("\n"); 
		query.append("         T1.UPD_USR_ID," ).append("\n"); 
		query.append("         T1.UPD_DT," ).append("\n"); 
		query.append("         T1.OVR_WGT_RT_AMT" ).append("\n"); 
		query.append("    FROM (SELECT @[svc_scp_cd] SVC_SCP_CD," ).append("\n"); 
		query.append("                 @[org_dest_tp_cd] ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                 @[ihc_trf_no] IHC_TRF_NO,                " ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                   WHEN A.TRSP_CRR_MOD_CD IN ('WD', 'WR', 'RW') THEN 'B'" ).append("\n"); 
		query.append("                   WHEN A.TRSP_CRR_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("                   WHEN A.TRSP_CRR_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("                   WHEN A.TRSP_CRR_MOD_CD IN ('WT', 'TW') THEN 'U'" ).append("\n"); 
		query.append("                   WHEN A.TRSP_CRR_MOD_CD IN ('RT', 'TR') THEN 'A'" ).append("\n"); 
		query.append("                 END PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("                 A.CNTR_SZ_CD PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.DG_FX_RT, 0)) != 0 THEN 'F'" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.DG_FX_RTO, 0)) != 0 THEN 'P'" ).append("\n"); 
		query.append("                   ELSE 'F'" ).append("\n"); 
		query.append("                 END DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("                 A.DG_FX_RT DG_RT_AMT," ).append("\n"); 
		query.append("                 A.DG_FX_RTO DG_RT_RTO," ).append("\n"); 
		query.append("                 DECODE(A.CNTR_SZ_CD, '20', DECODE(A.MIN_CGO_WGT, 0, 0, A.MIN_CGO_WGT-2.5), '40', DECODE(A.MIN_CGO_WGT, 0, 0, A.MIN_CGO_WGT-4)) MIN_CGO_WGT," ).append("\n"); 
		query.append("                 DECODE(A.CNTR_SZ_CD, '20', DECODE(A.MAX_CGO_WGT, 0, 0, A.MAX_CGO_WGT-2.5), '40', DECODE(A.MAX_CGO_WGT, 0, 0, A.MAX_CGO_WGT-4)) MAX_CGO_WGT," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.OVR_WGT_FX_RT, 0)) != 0 THEN 'F'" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.OVR_WGT_FX_RTO, 0)) != 0 THEN 'P'" ).append("\n"); 
		query.append("                   ELSE 'F'" ).append("\n"); 
		query.append("                 END OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("                 A.OVR_WGT_FX_RT OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("                 A.OVR_WGT_FX_RTO OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("                 A.DCGO_SVC_FLG," ).append("\n"); 
		query.append("                 A.OVWT_CGO_SVC_FLG," ).append("\n"); 
		query.append("                 @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("                 SYSDATE CRE_DT," ).append("\n"); 
		query.append("                 @[upd_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("                 SYSDATE UPD_DT," ).append("\n"); 
		query.append("                 A.CURR_CD," ).append("\n"); 
		query.append("         		( SELECT TO_DATE(MAX(R.ACCT_XCH_RT_YRMON), 'YYYYMM') ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("            		FROM GL_MON_XCH_RT R" ).append("\n"); 
		query.append("           		   WHERE R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                 	 AND R.DELT_FLG = 'N'" ).append("\n"); 
		query.append("					 AND R.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("				) AS ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("            FROM #if(${rhq_cd} == 'NYCRA') AOC_USA_INLND_SPCL_TRF_DTL A #end" ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'HAMRU') AOC_EUR_INLND_SPCL_TRF_DTL A #end   " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SINRS') AOC_CHN_INLND_SPCL_TRF_DTL A #end" ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SHARC') AOC_CHN_INLND_SPCL_TRF_DTL A #end" ).append("\n"); 
		query.append("           WHERE A.COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("		) T1" ).append("\n"); 

	}
}