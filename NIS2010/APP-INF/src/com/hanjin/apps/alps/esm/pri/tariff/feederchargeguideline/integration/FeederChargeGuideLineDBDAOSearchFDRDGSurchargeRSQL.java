/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchFDRDGSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOSearchFDRDGSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FDR DG Surcharge inquiry
	  * 2013.02.19 [CHM-201323107] 전윤주 AOC Feeder DG Tab 변경에 따른 Add-on Tariff 변경요청
	  * 2013.03.04 [CHM-201323352] 전윤주 AOC 테이블의 delt_flg 확인 로직 추가
	  * 2014.12.09 [CHM-201433491] ADD ON TARIFF / DG 요율 관련 (CUR_CD 추가)
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchFDRDGSurchargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOSearchFDRDGSurchargeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)) PNT_LOC_CD" ).append("\n"); 
		query.append("     , (SELECT LOC_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION " ).append("\n"); 
		query.append("         WHERE LOC_CD = DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') AS PNT_LOC_NM   " ).append("\n"); 
		query.append("     , DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I', SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)), 'I', SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)) BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("     , DECODE(DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'I',  DECODE(A.WTR_DE_TERM_CD, 'V', 'Y','T','Y', A.WTR_DE_TERM_CD), 'O', DECODE(A.WTR_RCV_TERM_CD, 'V', 'Y', 'T','Y',A.WTR_RCV_TERM_CD))RCV_DE_TERM_CD" ).append("\n"); 
		query.append("     , D.IMDG_N1ST_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N1ST_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N1ST_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N2ND_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N2ND_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N2ND_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N3RD_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N3RD_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N3RD_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append("     , D.IMDG_N4TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N4TH_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N4TH_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N5TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N5TH_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N5TH_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N6TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N6TH_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N6TH_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N7TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N7TH_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N7TH_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N8TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N8TH_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N8TH_CLSS_40FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N9TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("     , D.IMDG_N9TH_CLSS_20FT_SCG_AMT " ).append("\n"); 
		query.append("     , D.IMDG_N9TH_CLSS_40FT_SCG_AMT" ).append("\n"); 
		query.append("     , '' AS FDR_TRF_NO" ).append("\n"); 
		query.append("     , '' AS SVC_SCP_CD" ).append("\n"); 
		query.append("     , '' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , '' AS RHQ_CD" ).append("\n"); 
		query.append("	 , A.CURR_CD  " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("         #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("             AOC_EUR_FDR_TRF_DTL A,  " ).append("\n"); 
		query.append("             AOC_EUR_FDR_TRF_HDR B," ).append("\n"); 
		query.append("             AOC_EUR_FDR_DG_TRF_DTL D" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("             AOC_CHN_FDR_TRF_DTL A," ).append("\n"); 
		query.append("             AOC_CHN_FDR_TRF_HDR B, " ).append("\n"); 
		query.append("             AOC_CHN_FDR_DG_TRF_DTL D" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("             AOC_CHN_FDR_TRF_DTL A," ).append("\n"); 
		query.append("             AOC_CHN_FDR_TRF_HDR B, " ).append("\n"); 
		query.append("             AOC_CHN_FDR_DG_TRF_DTL D" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("   AND A.PCTL_IO_BND_CD IN (DECODE(@[org_dest_tp_cd],'D','I','O','O'), 'B')" ).append("\n"); 
		query.append("   AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   --------------------------   DG       " ).append("\n"); 
		query.append("   AND A.COST_TRF_NO        = D.COST_TRF_NO (+)" ).append("\n"); 
		query.append("   AND A.COST_TRF_ROUT_SEQ  = D.COST_TRF_ROUT_SEQ (+)    " ).append("\n"); 
		query.append("   ------------------------------------------" ).append("\n"); 
		query.append("   AND A.COST_TRF_NO  = (  SELECT FDR_COST_TRF_NO" ).append("\n"); 
		query.append("                             FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                              AND FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("                              AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                              AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                              AND RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("                         )" ).append("\n"); 

	}
}