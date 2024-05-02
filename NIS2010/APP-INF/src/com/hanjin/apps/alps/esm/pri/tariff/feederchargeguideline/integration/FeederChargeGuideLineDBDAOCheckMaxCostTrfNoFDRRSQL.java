/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOCheckMaxCostTrfNoFDRRSQL.java
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

public class FeederChargeGuideLineDBDAOCheckMaxCostTrfNoFDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckMaxCostTrfNoFDR
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOCheckMaxCostTrfNoFDRRSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOCheckMaxCostTrfNoFDRRSQL").append("\n"); 
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
		query.append("SELECT HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("        , HDR.FDR_TRF_NO" ).append("\n"); 
		query.append("        , HDR.RHQ_CD" ).append("\n"); 
		query.append("        , MAPG.FDR_COST_TRF_NO" ).append("\n"); 
		query.append("        , (SELECT MAX(COST_TRF_NO)" ).append("\n"); 
		query.append("            FROM #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                     AOC_EUR_FDR_TRF_HDR" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                     AOC_CHN_FDR_TRF_HDR" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                     AOC_CHN_FDR_TRF_HDR" ).append("\n"); 
		query.append("                 #end   " ).append("\n"); 
		query.append("            WHERE RHQ_CD = @[rhq_cd] AND COST_TRF_STS_CD = 'C') MAX_COST_TRF_NO" ).append("\n"); 
		query.append("        , DECODE(FDR_COST_TRF_NO, " ).append("\n"); 
		query.append("          (SELECT MAX(COST_TRF_NO)" ).append("\n"); 
		query.append("            FROM #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                     AOC_EUR_FDR_TRF_HDR" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                     AOC_CHN_FDR_TRF_HDR" ).append("\n"); 
		query.append("                 #end " ).append("\n"); 
		query.append("                 #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                     AOC_CHN_FDR_TRF_HDR" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("            WHERE RHQ_CD = @[rhq_cd] AND COST_TRF_STS_CD = 'C'), 0, 1 ) CHECK_COST_TRF_NO " ).append("\n"); 
		query.append("     FROM PRI_TRF_FDR_HDR HDR" ).append("\n"); 
		query.append("        , PRI_TRF_FDR_COST_VER_MAPG MAPG " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND HDR.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("      AND HDR.FDR_TRF_NO  = @[fdr_trf_no]" ).append("\n"); 
		query.append("      AND HDR.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("      AND HDR.SVC_SCP_CD  = MAPG.SVC_SCP_CD" ).append("\n"); 
		query.append("      AND HDR.FDR_TRF_NO  = MAPG.FDR_TRF_NO" ).append("\n"); 
		query.append("      AND HDR.ORG_DEST_TP_CD  = MAPG.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("      ORDER BY CHECK_COST_TRF_NO DESC" ).append("\n"); 

	}
}