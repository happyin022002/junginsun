/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSQL.java
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

public class IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update PRI_TRF_IHC_RT's RF, DG, LOCAL RF, DG AMT
	  * * History
	  * 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
	  * </pre>
	  */
	public IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSQL(){
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
		query.append("FileName : IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_IHC_RT RTMN" ).append("\n"); 
		query.append("   SET ( GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_DG_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("       , GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_OVR_WGT_45FT_FRT_RT_AMT -- 45' Cost 추가" ).append("\n"); 
		query.append("       , DCGO_SVC_FLG" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   = (" ).append("\n"); 
		query.append("        SELECT DECODE(DCGO_SVC_FLG_20, 'Y' , SUB.GLINE_DG_20FT ,  null )" ).append("\n"); 
		query.append("             , DECODE(DCGO_SVC_FLG_40, 'Y' , SUB.GLINE_DG_40FT ,  null )" ).append("\n"); 
		query.append("             , DECODE(DCGO_SVC_FLG_45, 'Y' , SUB.GLINE_DG_40FT ,  null ) -- 45' Cost 추가" ).append("\n"); 
		query.append("             , DECODE(OVR_WGT_CGO_SVC_FLG_20, 'Y', SUB.GLINE_OV_20FT ,  null )" ).append("\n"); 
		query.append("             , DECODE(OVR_WGT_CGO_SVC_FLG_40, 'Y', SUB.GLINE_OV_40FT ,  null )" ).append("\n"); 
		query.append("             , DECODE(OVR_WGT_CGO_SVC_FLG_45, 'Y', SUB.GLINE_OV_45FT ,  null ) -- 45' Cost 추가" ).append("\n"); 
		query.append("             , DECODE(DCGO_SVC_FLG_20, 'N' , (DECODE(DCGO_SVC_FLG_40, 'N', (DECODE(DCGO_SVC_FLG_45, 'N', 'N', 'Y')), 'Y')), 'Y') AS DCGO_SVC_FLG" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT DECODE(CGO1.DG_FLT_PCT_TP_CD, 'F', RT.GLINE_20FT_FRT_RT_AMT + CGO1.DG_RT_AMT, 'P', RT.GLINE_20FT_FRT_RT_AMT + (RT.GLINE_20FT_FRT_RT_AMT * CGO1.DG_RT_RTO / 100)) GLINE_DG_20FT" ).append("\n"); 
		query.append("                     , DECODE(CGO2.DG_FLT_PCT_TP_CD, 'F', RT.GLINE_40FT_FRT_RT_AMT + CGO2.DG_RT_AMT, 'P', RT.GLINE_40FT_FRT_RT_AMT + (RT.GLINE_40FT_FRT_RT_AMT * CGO2.DG_RT_RTO / 100)) GLINE_DG_40FT" ).append("\n"); 
		query.append("                     , DECODE(CGO2.DG_FLT_PCT_TP_CD, 'F', RT.GLINE_45FT_FRT_RT_AMT + CGO2.DG_RT_AMT, 'P', RT.GLINE_45FT_FRT_RT_AMT + (RT.GLINE_45FT_FRT_RT_AMT * CGO2.DG_RT_RTO / 100)) GLINE_DG_45FT -- 45' Cost 추가" ).append("\n"); 
		query.append("                     , DECODE(CGO1.OVR_WGT_FLT_PCT_TP_CD, 'F', RT.GLINE_20FT_FRT_RT_AMT + CGO1.OVR_WGT_RT_AMT, 'P', RT.GLINE_20FT_FRT_RT_AMT + (RT.GLINE_20FT_FRT_RT_AMT * CGO1.OVR_WGT_RT_RTO / 100)) GLINE_OV_20FT" ).append("\n"); 
		query.append("                     , DECODE(CGO2.OVR_WGT_FLT_PCT_TP_CD, 'F', RT.GLINE_40FT_FRT_RT_AMT + CGO2.OVR_WGT_RT_AMT, 'P', RT.GLINE_40FT_FRT_RT_AMT + (RT.GLINE_40FT_FRT_RT_AMT * CGO2.OVR_WGT_RT_RTO / 100)) GLINE_OV_40FT" ).append("\n"); 
		query.append("                     , DECODE(CGO3.OVR_WGT_FLT_PCT_TP_CD, 'F', RT.GLINE_45FT_FRT_RT_AMT + CGO3.OVR_WGT_RT_AMT, 'P', RT.GLINE_45FT_FRT_RT_AMT + (RT.GLINE_45FT_FRT_RT_AMT * CGO3.OVR_WGT_RT_RTO / 100)) GLINE_OV_45FT -- 45' Cost 추가" ).append("\n"); 
		query.append("                     , RT.SVC_SCP_CD " ).append("\n"); 
		query.append("                     , RT.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                     , RT.IHC_TRF_NO" ).append("\n"); 
		query.append("                     , RT.AMDT_SEQ" ).append("\n"); 
		query.append("                     , RT.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("                     , RT.RT_SEQ" ).append("\n"); 
		query.append("                     , NVL(CGO1.DCGO_SVC_FLG,'N') AS DCGO_SVC_FLG_20" ).append("\n"); 
		query.append("                     , NVL(CGO2.DCGO_SVC_FLG,'N') AS DCGO_SVC_FLG_40" ).append("\n"); 
		query.append("                     , NVL(CGO3.DCGO_SVC_FLG,'N') AS DCGO_SVC_FLG_45 -- 45' Cost 추가" ).append("\n"); 
		query.append("                     , NVL(CGO1.OVR_WGT_CGO_SVC_FLG,'N') AS OVR_WGT_CGO_SVC_FLG_20" ).append("\n"); 
		query.append("                     , NVL(CGO2.OVR_WGT_CGO_SVC_FLG,'N') AS OVR_WGT_CGO_SVC_FLG_40" ).append("\n"); 
		query.append("                     , NVL(CGO3.OVR_WGT_CGO_SVC_FLG,'N') AS OVR_WGT_CGO_SVC_FLG_45 -- 45' Cost 추가" ).append("\n"); 
		query.append("                  FROM PRI_TRF_IHC_SPCL_CGO_RT CGO1" ).append("\n"); 
		query.append("                     , PRI_TRF_IHC_SPCL_CGO_RT CGO2" ).append("\n"); 
		query.append("                     , PRI_TRF_IHC_SPCL_CGO_RT CGO3 -- 45' Cost 추가" ).append("\n"); 
		query.append("                     , PRI_TRF_IHC_RT RT" ).append("\n"); 
		query.append("                 WHERE 1=1    " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   AND RT.SVC_SCP_CD = CGO1.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND RT.IHC_TRF_NO = CGO1.IHC_TRF_NO(+)" ).append("\n"); 
		query.append("                   AND RT.ORG_DEST_TP_CD  = CGO1.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append("                   AND RT.PRC_TRSP_MOD_CD = CGO1.PRC_TRSP_MOD_CD(+)" ).append("\n"); 
		query.append("                   AND RT.LOCL_CURR_CD = CGO1.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("                   AND CGO1.PRC_INLND_TRF_CNTR_TPSZ_CD(+) = '20'" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   AND RT.SVC_SCP_CD = CGO2.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND RT.IHC_TRF_NO = CGO2.IHC_TRF_NO(+)" ).append("\n"); 
		query.append("                   AND RT.ORG_DEST_TP_CD  = CGO2.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append("                   AND RT.PRC_TRSP_MOD_CD = CGO2.PRC_TRSP_MOD_CD(+)" ).append("\n"); 
		query.append("                   AND RT.LOCL_CURR_CD = CGO2.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("                   AND CGO2.PRC_INLND_TRF_CNTR_TPSZ_CD(+) = '40'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   AND RT.SVC_SCP_CD = CGO3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("                   AND RT.IHC_TRF_NO = CGO3.IHC_TRF_NO(+)" ).append("\n"); 
		query.append("                   AND RT.ORG_DEST_TP_CD  = CGO3.ORG_DEST_TP_CD(+)" ).append("\n"); 
		query.append("                   AND RT.PRC_TRSP_MOD_CD = CGO3.PRC_TRSP_MOD_CD(+)" ).append("\n"); 
		query.append("                   AND RT.LOCL_CURR_CD = CGO3.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("                   AND CGO3.PRC_INLND_TRF_CNTR_TPSZ_CD(+) = '45' -- 45' Cost 추가" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   AND RT.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                   AND RT.IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("                   AND RT.AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND RT.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                   AND RT.IHC_CGO_TP_CD = 'DR'" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("        )SUB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE 1 =1" ).append("\n"); 
		query.append("          AND SUB.SVC_SCP_CD     = RTMN.SVC_SCP_CD" ).append("\n"); 
		query.append("          AND SUB.ORG_DEST_TP_CD = RTMN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          AND SUB.IHC_TRF_NO     = RTMN.IHC_TRF_NO" ).append("\n"); 
		query.append("          AND SUB.AMDT_SEQ       = RTMN.AMDT_SEQ" ).append("\n"); 
		query.append("          AND SUB.IHC_CGO_TP_CD  = RTMN.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("          AND SUB.RT_SEQ         = RTMN.RT_SEQ" ).append("\n"); 
		query.append("          AND SUB.IHC_CGO_TP_CD  = RTMN.IHC_CGO_TP_CD" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND RTMN.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND RTMN.IHC_TRF_NO   = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND RTMN.AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("   AND RTMN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("   AND RTMN.IHC_CGO_TP_CD = 'DR'" ).append("\n"); 

	}
}