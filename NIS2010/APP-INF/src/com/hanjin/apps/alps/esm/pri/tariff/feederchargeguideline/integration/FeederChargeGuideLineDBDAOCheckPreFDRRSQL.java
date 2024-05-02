/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FeederChargeGuideLineDBDAOCheckPreFDRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.28
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.28 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FeederChargeGuideLineDBDAOCheckPreFDRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckPreFDR
	  * </pre>
	  */
	public FeederChargeGuideLineDBDAOCheckPreFDRRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration").append("\n"); 
		query.append("FileName : FeederChargeGuideLineDBDAOCheckPreFDRRSQL").append("\n"); 
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
		query.append("WITH MAX_TRF AS (" ).append("\n"); 
		query.append("        SELECT @[svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append("             , @[org_dest_tp_cd] AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             , TRF.FDR_TRF_NO" ).append("\n"); 
		query.append("             , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("          FROM PRI_TRF_FDR_MN MN" ).append("\n"); 
		query.append("             , (    SELECT MAX(MN.FDR_TRF_NO) FDR_TRF_NO" ).append("\n"); 
		query.append("                      FROM PRI_TRF_FDR_MN MN " ).append("\n"); 
		query.append("                         , PRI_TRF_FDR_HDR HDR" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND MN.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("                       AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                       AND MN.FDR_TRF_NO = HDR.FDR_TRF_NO" ).append("\n"); 
		query.append("                       AND MN.SVC_SCP_CD    = @[svc_scp_cd]" ).append("\n"); 
		query.append("                       AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]                     " ).append("\n"); 
		query.append("                       AND MN.FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("                       AND HDR.RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("               ) TRF" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND MN.FDR_TRF_NO = TRF.FDR_TRF_NO" ).append("\n"); 
		query.append("      GROUP BY TRF.FDR_TRF_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("SELECT TO_CHAR(DUR.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("FROM PRI_TRF_FDR_DUR DUR" ).append("\n"); 
		query.append("   , MAX_TRF SUB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DUR.SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("  AND DUR.ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("  AND DUR.FDR_TRF_NO = SUB.FDR_TRF_NO" ).append("\n"); 
		query.append("  AND DUR.AMDT_SEQ   = SUB.AMDT_SEQ" ).append("\n"); 

	}
}