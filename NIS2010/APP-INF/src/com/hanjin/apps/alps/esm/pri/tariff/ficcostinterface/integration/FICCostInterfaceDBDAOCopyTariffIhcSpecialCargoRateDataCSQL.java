/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FICCostInterfaceDBDAOCopyTariffIhcSpecialCargoRateDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.12 
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

public class FICCostInterfaceDBDAOCopyTariffIhcSpecialCargoRateDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyTariffIhcSpecialCargoRateData
	  * 2013.08.06 전윤주 [CHM-201326196] Overweight Fixed AMT 를 Local curr. 금액 그대로 IF 하는 컬럼 추가
	  * </pre>
	  */
	public FICCostInterfaceDBDAOCopyTariffIhcSpecialCargoRateDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ori_ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ori_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : FICCostInterfaceDBDAOCopyTariffIhcSpecialCargoRateDataCSQL").append("\n"); 
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
		query.append("   LOCL_OVR_WGT_RT_AMT )" ).append("\n"); 
		query.append("  SELECT  @[svc_scp_cd]" ).append("\n"); 
		query.append("        , @[org_dest_tp_cd]" ).append("\n"); 
		query.append("        , @[ihc_trf_no] " ).append("\n"); 
		query.append("        , PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("        , PRC_INLND_TRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , DG_FLT_PCT_TP_CD" ).append("\n"); 
		query.append("        , DG_RT_AMT" ).append("\n"); 
		query.append("        , DG_RT_RTO" ).append("\n"); 
		query.append("        , MIN_CGO_WGT" ).append("\n"); 
		query.append("        , MAX_CGO_WGT" ).append("\n"); 
		query.append("        , OVR_WGT_FLT_PCT_TP_CD" ).append("\n"); 
		query.append("        , OVR_WGT_RT_AMT" ).append("\n"); 
		query.append("        , OVR_WGT_RT_RTO" ).append("\n"); 
		query.append("        , DCGO_SVC_FLG" ).append("\n"); 
		query.append("        , OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append("        , LOCL_CURR_CD" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE " ).append("\n"); 
		query.append("        , LOCL_OVR_WGT_RT_AMT" ).append("\n"); 
		query.append("   FROM PRI_TRF_IHC_SPCL_CGO_RT" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND SVC_SCP_CD       = @[ori_svc_scp_cd] " ).append("\n"); 
		query.append("    AND ORG_DEST_TP_CD   = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("    AND IHC_TRF_NO       = @[ori_ihc_trf_no]" ).append("\n"); 

	}
}