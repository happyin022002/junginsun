/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOSearchTariffInquiryAddOnDgFlagRSQL.java
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

public class FeederChargeGuideLineDBDAOSearchTariffInquiryAddOnDgFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.07.30 [CHM-201326002] 전윤주 AOC의 해당 Route의 DG Service flag가 하나라도 Y 이면 Y로 search 한다.
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOSearchTariffInquiryAddOnDgFlagRSQL(){
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
		params.put("bse_port_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : FeederChargeGuideLineDBDAOSearchTariffInquiryAddOnDgFlagRSQL").append("\n"); 
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
		query.append("SELECT GREATEST(B.IMDG_N1ST_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N2ND_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N3RD_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N4TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N5TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N6TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N7TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N8TH_CLSS_SVC_FLG" ).append("\n"); 
		query.append("               ,B.IMDG_N9TH_CLSS_SVC_FLG) DCGO_SVC_FLG --하나라도 Y가 있으면 Y로 표시" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("#if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("    AOC_EUR_FDR_TRF_DTL A " ).append("\n"); 
		query.append("   ,AOC_EUR_FDR_DG_TRF_DTL B" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if(${rhq_cd} == 'SINRS' || ${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("   AOC_CHN_FDR_TRF_DTL A" ).append("\n"); 
		query.append("  ,AOC_CHN_FDR_DG_TRF_DTL B" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.PCTL_IO_BND_CD IN (DECODE(@[org_dest_tp_cd], 'D', 'I', 'O', 'O'), 'B')" ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("--------------------------   DG       " ).append("\n"); 
		query.append("  AND A.COST_TRF_NO = B.COST_TRF_NO" ).append("\n"); 
		query.append("  AND A.COST_TRF_ROUT_SEQ = B.COST_TRF_ROUT_SEQ" ).append("\n"); 
		query.append("------------------------------------------" ).append("\n"); 
		query.append("  AND A.COST_TRF_NO = (" ).append("\n"); 
		query.append("                        SELECT FDR_COST_TRF_NO" ).append("\n"); 
		query.append("                         FROM PRI_TRF_FDR_COST_VER_MAPG" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND FDR_TRF_NO = @[fdr_trf_no]" ).append("\n"); 
		query.append("                          AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                          AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                          AND RHQ_CD = @[rhq_cd] )" ).append("\n"); 
		query.append("  AND DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd], 'D', 'I', 'O', 'O'), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)), 'I', SUBSTR(A.TO_NOD_CD, 1, 5), SUBSTR(A.FM_NOD_CD, 1, 5)) = @[pnt_loc_cd]" ).append("\n"); 
		query.append("  AND DECODE(A.PCTL_IO_BND_CD, 'B', DECODE(DECODE(@[org_dest_tp_cd], 'D', 'I', 'O', 'O'), 'I', SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)), 'I', SUBSTR(A.FM_NOD_CD, 1, 5), SUBSTR(A.TO_NOD_CD, 1, 5)) = @[bse_port_loc_cd]" ).append("\n"); 

	}
}