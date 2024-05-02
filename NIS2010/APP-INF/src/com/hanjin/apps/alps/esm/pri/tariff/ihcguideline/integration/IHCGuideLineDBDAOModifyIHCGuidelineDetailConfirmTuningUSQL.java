/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmTuningUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
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

public class IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmTuningUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * special cargo guideline tuning
	  * * History
	  * 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmTuningUSQL(){
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmTuningUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_IHC_RT" ).append("\n"); 
		query.append("SET GLINE_DG_20FT_FRT_RT_AMT =   CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_20FT_FRT_RT_AMT)),-1)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_20FT_FRT_RT_AMT)),-1)) < 5" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_DG_20FT_FRT_RT_AMT/10)*10 + 5" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_20FT_FRT_RT_AMT)),-1)) > 5 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_20FT_FRT_RT_AMT)),-1)) <= 9" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_DG_20FT_FRT_RT_AMT/10)*10 + 10" ).append("\n"); 
		query.append("                                        ELSE TRUNC(GLINE_DG_20FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("    ,GLINE_DG_40FT_FRT_RT_AMT =   CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_40FT_FRT_RT_AMT)),-1)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_40FT_FRT_RT_AMT)),-1)) < 5" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_DG_40FT_FRT_RT_AMT/10)*10 + 5" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_40FT_FRT_RT_AMT)),-1)) > 5 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_40FT_FRT_RT_AMT)),-1)) <= 9" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_DG_40FT_FRT_RT_AMT/10)*10 + 10" ).append("\n"); 
		query.append("                                        ELSE TRUNC(GLINE_DG_40FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("     -- 45' Cost 추가" ).append("\n"); 
		query.append("    ,GLINE_DG_45FT_FRT_RT_AMT =   CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_45FT_FRT_RT_AMT)),-1)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_45FT_FRT_RT_AMT)),-1)) < 5" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_DG_45FT_FRT_RT_AMT/10)*10 + 5" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_45FT_FRT_RT_AMT)),-1)) > 5 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_DG_45FT_FRT_RT_AMT)),-1)) <= 9" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_DG_45FT_FRT_RT_AMT/10)*10 + 10" ).append("\n"); 
		query.append("                                        ELSE TRUNC(GLINE_DG_45FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("    ,GLINE_OVR_WGT_20FT_FRT_RT_AMT =   CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT)),-1)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT)),-1)) < 5" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT/10)*10 + 5" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT)),-1)) > 5 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT)),-1)) <= 9" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT/10)*10 + 10" ).append("\n"); 
		query.append("                                        ELSE TRUNC(GLINE_OVR_WGT_20FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("    ,GLINE_OVR_WGT_40FT_FRT_RT_AMT =   CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT)),-1)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT)),-1)) < 5" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT/10)*10 + 5" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT)),-1)) > 5 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT)),-1)) <= 9" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT/10)*10 + 10" ).append("\n"); 
		query.append("                                        ELSE TRUNC(GLINE_OVR_WGT_40FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("     -- 45' Cost 추가" ).append("\n"); 
		query.append("    ,GLINE_OVR_WGT_45FT_FRT_RT_AMT =   CASE WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT)),-1)) > 0 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT)),-1)) < 5" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT/10)*10 + 5" ).append("\n"); 
		query.append("                                        WHEN TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT)),-1)) > 5 AND TO_NUMBER(SUBSTR(TO_CHAR(TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT)),-1)) <= 9" ).append("\n"); 
		query.append("                                        THEN TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT/10)*10 + 10" ).append("\n"); 
		query.append("                                        ELSE TRUNC(GLINE_OVR_WGT_45FT_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                  END" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]   " ).append("\n"); 
		query.append("  AND IHC_TRF_NO = @[ihc_trf_no]  " ).append("\n"); 
		query.append("  AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("  AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("  AND IHC_CGO_TP_CD = 'DR'" ).append("\n"); 

	}
}