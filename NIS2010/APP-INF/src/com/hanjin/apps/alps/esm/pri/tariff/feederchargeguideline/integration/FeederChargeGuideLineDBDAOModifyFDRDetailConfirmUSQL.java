/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOModifyFDRDetailConfirmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.04 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOModifyFDRDetailConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update PRI_TRF_FDR_RT
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOModifyFDRDetailConfirmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOModifyFDRDetailConfirmUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_FDR_RT RTMN" ).append("\n"); 
		query.append("   SET ( GLINE_RF_20FT_FRT_RT_AMT " ).append("\n"); 
		query.append("       , GLINE_RF_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       , GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   = (" ).append("\n"); 
		query.append("        SELECT SUB.GLINE_RF_20FT" ).append("\n"); 
		query.append("             , SUB.GLINE_RF_40FT" ).append("\n"); 
		query.append("             , SUB.GLINE_DG_20FT" ).append("\n"); 
		query.append("             , SUB.GLINE_DG_40FT" ).append("\n"); 
		query.append("             , SUB.GLINE_OV_20FT" ).append("\n"); 
		query.append("             , SUB.GLINE_OV_40FT" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT DECODE(CGO1.RF_FLT_PCT_TP_CD, 'F', RT.GLINE_20FT_FRT_RT_AMT + CGO1.RF_RT_AMT, 'P', RT.GLINE_20FT_FRT_RT_AMT + (RT.GLINE_20FT_FRT_RT_AMT * CGO1.RF_RT_RTO / 100)) GLINE_RF_20FT" ).append("\n"); 
		query.append("                     , DECODE(CGO2.RF_FLT_PCT_TP_CD, 'F', RT.GLINE_40FT_FRT_RT_AMT + CGO2.RF_RT_AMT, 'P', RT.GLINE_40FT_FRT_RT_AMT + (RT.GLINE_40FT_FRT_RT_AMT * CGO2.RF_RT_RTO / 100)) GLINE_RF_40FT" ).append("\n"); 
		query.append("                     , DECODE(CGO1.DG_FLT_PCT_TP_CD, 'F', RT.GLINE_20FT_FRT_RT_AMT + CGO1.DG_RT_AMT, 'P', RT.GLINE_20FT_FRT_RT_AMT + (RT.GLINE_20FT_FRT_RT_AMT * CGO1.DG_RT_RTO / 100)) GLINE_DG_20FT" ).append("\n"); 
		query.append("                     , DECODE(CGO2.DG_FLT_PCT_TP_CD, 'F', RT.GLINE_40FT_FRT_RT_AMT + CGO2.DG_RT_AMT, 'P', RT.GLINE_40FT_FRT_RT_AMT + (RT.GLINE_40FT_FRT_RT_AMT * CGO2.DG_RT_RTO / 100)) GLINE_DG_40FT " ).append("\n"); 
		query.append("                     , DECODE(CGO1.OVR_WGT_FLT_PCT_TP_CD, 'F', RT.GLINE_20FT_FRT_RT_AMT + CGO1.OVR_WGT_RT_AMT, 'P', RT.GLINE_20FT_FRT_RT_AMT + (RT.GLINE_20FT_FRT_RT_AMT * CGO1.OVR_WGT_RT_RTO / 100)) GLINE_OV_20FT" ).append("\n"); 
		query.append("                     , DECODE(CGO2.OVR_WGT_FLT_PCT_TP_CD, 'F', RT.GLINE_40FT_FRT_RT_AMT + CGO2.OVR_WGT_RT_AMT, 'P', RT.GLINE_40FT_FRT_RT_AMT + (RT.GLINE_40FT_FRT_RT_AMT * CGO2.OVR_WGT_RT_RTO / 100)) GLINE_OV_40FT  " ).append("\n"); 
		query.append("                     , RT.FDR_TRF_NO" ).append("\n"); 
		query.append("                     , RT.AMDT_SEQ" ).append("\n"); 
		query.append("                     , RT.RT_SEQ" ).append("\n"); 
		query.append("                  FROM PRI_TRF_FDR_SPCL_CGO_RT CGO1" ).append("\n"); 
		query.append("                     , PRI_TRF_FDR_SPCL_CGO_RT CGO2" ).append("\n"); 
		query.append("                     , PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append("                     , PRI_TRF_FDR_RT RT" ).append("\n"); 
		query.append("                 WHERE 1=1    " ).append("\n"); 
		query.append("                   AND MN.FDR_TRF_NO = RT.FDR_TRF_NO" ).append("\n"); 
		query.append("                   AND RT.FDR_TRF_NO = CGO1.FDR_TRF_NO(+)" ).append("\n"); 
		query.append("                   AND CGO1.PRC_INLND_TRF_CNTR_TPSZ_CD(+) = '20'" ).append("\n"); 
		query.append("                   AND RT.FDR_TRF_NO = CGO2.FDR_TRF_NO(+)" ).append("\n"); 
		query.append("                   AND CGO2.PRC_INLND_TRF_CNTR_TPSZ_CD(+) = '40'" ).append("\n"); 
		query.append("                   AND RT.FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("                   AND RT.AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("                   AND MN.AMDT_SEQ   = RT.AMDT_SEQ" ).append("\n"); 
		query.append("        )SUB" ).append("\n"); 
		query.append("        WHERE 1 =1" ).append("\n"); 
		query.append("          AND SUB.FDR_TRF_NO = RTMN.FDR_TRF_NO" ).append("\n"); 
		query.append("          AND SUB.AMDT_SEQ   = RTMN.AMDT_SEQ" ).append("\n"); 
		query.append("          AND SUB.RT_SEQ     = RTMN.RT_SEQ" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND RTMN.FDR_TRF_NO   = @[fdr_trf_no]" ).append("\n"); 
		query.append("   AND RTMN.AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 

	}
}