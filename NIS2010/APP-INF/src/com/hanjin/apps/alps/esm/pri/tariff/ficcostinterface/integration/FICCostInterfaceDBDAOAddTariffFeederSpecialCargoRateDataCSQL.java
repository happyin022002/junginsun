/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FICCostInterfaceDBDAOAddTariffFeederSpecialCargoRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.06.08 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOAddTariffFeederSpecialCargoRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert - pri_trf_fdr_spcl_cgo_rt
	  * </pre>
	  */
	public FICCostInterfaceDBDAOAddTariffFeederSpecialCargoRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOAddTariffFeederSpecialCargoRateDataCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRF_FDR_SPCL_CGO_RT" ).append("\n"); 
		query.append("  (SVC_SCP_CD," ).append("\n"); 
		query.append("   FDR_TRF_NO," ).append("\n"); 
		query.append("   VER_MAPG_SEQ," ).append("\n"); 
		query.append("   PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("   RF_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("   RF_RT_AMT," ).append("\n"); 
		query.append("   RF_RT_RTO," ).append("\n"); 
		query.append("   DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("   DG_RT_AMT," ).append("\n"); 
		query.append("   DG_RT_RTO," ).append("\n"); 
		query.append("   MIN_CGO_WGT," ).append("\n"); 
		query.append("   MAX_CGO_WGT," ).append("\n"); 
		query.append("   OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("   OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("   OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT)" ).append("\n"); 
		query.append("  SELECT T1.SVC_SCP_CD," ).append("\n"); 
		query.append("         T1.FDR_TRF_NO," ).append("\n"); 
		query.append("         T1.VER_MAPG_SEQ," ).append("\n"); 
		query.append("         T1.PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         T1.RF_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("         TPB_GET_USD_AMT_FNC(T1.RF_RT_AMT, T1.CURR_CD, F.ACCT_XCH_RT_YRMON) RF_RT_AMT," ).append("\n"); 
		query.append("         T1.RF_RT_RTO," ).append("\n"); 
		query.append("         T1.DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("         TPB_GET_USD_AMT_FNC(T1.DG_RT_AMT, T1.CURR_CD, F.ACCT_XCH_RT_YRMON) DG_RT_AMT," ).append("\n"); 
		query.append("         T1.DG_RT_RTO," ).append("\n"); 
		query.append("         T1.MIN_CGO_WGT," ).append("\n"); 
		query.append("         T1.MAX_CGO_WGT," ).append("\n"); 
		query.append("         T1.OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("         TPB_GET_USD_AMT_FNC(T1.OVR_WGT_RT_AMT, T1.CURR_CD, F.ACCT_XCH_RT_YRMON) OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("         T1.OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("         T1.CRE_USR_ID," ).append("\n"); 
		query.append("         T1.CRE_DT," ).append("\n"); 
		query.append("         T1.UPD_USR_ID," ).append("\n"); 
		query.append("         T1.UPD_DT" ).append("\n"); 
		query.append("    FROM (SELECT @[svc_scp_cd] SVC_SCP_CD," ).append("\n"); 
		query.append("                 @[fdr_trf_no] FDR_TRF_NO," ).append("\n"); 
		query.append("                 @[ver_mapg_seq] VER_MAPG_SEQ," ).append("\n"); 
		query.append("                 A.CNTR_SZ_CD PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.RF_FX_RT, 0)) != 0 THEN 'F'" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.RF_FX_RTO, 0)) != 0 THEN 'P'" ).append("\n"); 
		query.append("                 END RF_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("                 A.RF_FX_RT RF_RT_AMT," ).append("\n"); 
		query.append("                 A.RF_FX_RTO RF_RT_RTO," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.DG_FX_RT, 0)) != 0 THEN 'F'" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.DG_FX_RTO, 0)) != 0 THEN 'P'" ).append("\n"); 
		query.append("                 END DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("                 A.DG_FX_RT DG_RT_AMT," ).append("\n"); 
		query.append("                 A.DG_FX_RTO DG_RT_RTO," ).append("\n"); 
		query.append("                 A.MIN_CGO_WGT MIN_CGO_WGT," ).append("\n"); 
		query.append("                 A.MAX_CGO_WGT MAX_CGO_WGT," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.OVR_WGT_FX_RT, 0)) != 0 THEN 'F'" ).append("\n"); 
		query.append("                   WHEN TO_NUMBER(NVL(A.OVR_WGT_FX_RTO, 0)) != 0 THEN 'P'" ).append("\n"); 
		query.append("                 END OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("                 A.OVR_WGT_FX_RT OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("                 A.OVR_WGT_FX_RTO OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("                 @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("                 SYSDATE CRE_DT," ).append("\n"); 
		query.append("                 @[upd_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("                 SYSDATE UPD_DT," ).append("\n"); 
		query.append("                 B.CURR_CD" ).append("\n"); 
		query.append("            FROM TRS_FDR_SPCL_CGO     A," ).append("\n"); 
		query.append("                 TRS_FDR_COST_TRF_HDR B" ).append("\n"); 
		query.append("           WHERE B.COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("                 AND B.COST_TRF_NO = A.COST_TRF_NO) T1," ).append("\n"); 
		query.append("         (SELECT @[svc_scp_cd] SVC_SCP_CD," ).append("\n"); 
		query.append("                 TO_DATE(MAX(R.ACCT_XCH_RT_YRMON), 'YYYYMM') ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("            FROM GL_MON_XCH_RT R" ).append("\n"); 
		query.append("           WHERE R.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                 AND DELT_FLG = 'N') F" ).append("\n"); 
		query.append("   WHERE T1.SVC_SCP_CD = F.SVC_SCP_CD" ).append("\n"); 

	}
}