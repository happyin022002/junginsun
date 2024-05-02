/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchAddOnTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.05.30 이은섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun-Sup Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOSearchAddOnTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR Add-On Guideline Creation & Amendment - Special Pop up
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchAddOnTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOSearchAddOnTariffListRSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD," ).append("\n"); 
		query.append("       FDR_TRF_NO," ).append("\n"); 
		query.append("       VER_MAPG_SEQ," ).append("\n"); 
		query.append("       PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       RF_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("       RF_RT_AMT," ).append("\n"); 
		query.append("       RF_RT_RTO," ).append("\n"); 
		query.append("       DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("       DG_RT_AMT," ).append("\n"); 
		query.append("       DG_RT_RTO," ).append("\n"); 
		query.append("       MIN_CGO_WGT," ).append("\n"); 
		query.append("       MAX_CGO_WGT," ).append("\n"); 
		query.append("       OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("       OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("       OVR_WGT_RT_RTO" ).append("\n"); 
		query.append("  FROM PRI_TRF_FDR_SPCL_CGO_RT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD       = @[svc_scp_cd]" ).append("\n"); 
		query.append("       AND FDR_TRF_NO   = @[fdr_trf_no]" ).append("\n"); 

	}
}