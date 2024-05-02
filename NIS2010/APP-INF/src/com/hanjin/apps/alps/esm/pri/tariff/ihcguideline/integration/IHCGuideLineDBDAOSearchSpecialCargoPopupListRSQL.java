/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchSpecialCargoPopupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOSearchSpecialCargoPopupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IHC Special Cargo List
	  * 2013.08.06 전윤주 [CHM-201326196] Overweight Fixed AMT 를 Local curr. 금액 그대로 IF 하는 컬럼 추가
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchSpecialCargoPopupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchSpecialCargoPopupListRSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD," ).append("\n"); 
		query.append("       A.IHC_TRF_NO," ).append("\n"); 
		query.append("       A.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("       B.INTG_CD_VAL_DESC PRC_TRSP_MOD_CD_NM," ).append("\n"); 
		query.append("       A.PRC_INLND_TRF_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.DG_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("       A.DG_RT_AMT," ).append("\n"); 
		query.append("       A.DG_RT_RTO," ).append("\n"); 
		query.append("       A.MIN_CGO_WGT," ).append("\n"); 
		query.append("       A.MAX_CGO_WGT," ).append("\n"); 
		query.append("       A.OVR_WGT_FLT_PCT_TP_CD," ).append("\n"); 
		query.append("       A.OVR_WGT_RT_AMT," ).append("\n"); 
		query.append("       A.OVR_WGT_RT_RTO," ).append("\n"); 
		query.append("       A.DCGO_SVC_FLG," ).append("\n"); 
		query.append("       A.OVR_WGT_CGO_SVC_FLG," ).append("\n"); 
		query.append("       A.LOCL_CURR_CD," ).append("\n"); 
		query.append("       A.LOCL_OVR_WGT_RT_AMT" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_SPCL_CGO_RT A," ).append("\n"); 
		query.append("       COM_INTG_CD_DTL         B" ).append("\n"); 
		query.append(" WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND A.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND B.INTG_CD_ID(+) = 'CD01720'" ).append("\n"); 
		query.append("   AND A.PRC_TRSP_MOD_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append(" ORDER BY A.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("          A.PRC_INLND_TRF_CNTR_TPSZ_CD" ).append("\n"); 

	}
}