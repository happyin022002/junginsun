/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOCheckPreIHCGuidelineRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.05 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOCheckPreIHCGuidelineRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Pre IHC Guideline eff_dt
	  * </pre>
	  */
	public IHCGuideLineDBDAOCheckPreIHCGuidelineRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : IHCGuideLineDBDAOCheckPreIHCGuidelineRSQL").append("\n"); 
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
		query.append("             , TRF.IHC_TRF_NO" ).append("\n"); 
		query.append("             , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("             , @[org_dest_tp_cd] AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("             , (    SELECT MAX(MN.IHC_TRF_NO) IHC_TRF_NO" ).append("\n"); 
		query.append("                      FROM PRI_TRF_IHC_HDR HDR" ).append("\n"); 
		query.append("                         , PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND MN.SVC_SCP_CD     = @[svc_scp_cd]" ).append("\n"); 
		query.append("                       AND HDR.COST_CNT_CD   = @[cost_cnt_cd]" ).append("\n"); 
		query.append("                       AND MN.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                       AND MN.FIC_PROP_STS_CD = 'C'" ).append("\n"); 
		query.append("                       AND MN.SVC_SCP_CD = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("                       AND MN.IHC_TRF_NO = HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("                       AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               ) TRF" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND MN.IHC_TRF_NO = TRF.IHC_TRF_NO" ).append("\n"); 
		query.append("      GROUP BY TRF.IHC_TRF_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("SELECT TO_CHAR(DUR.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("FROM PRI_TRF_IHC_DUR DUR" ).append("\n"); 
		query.append("   , MAX_TRF SUB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DUR.SVC_SCP_CD = SUB.SVC_SCP_CD" ).append("\n"); 
		query.append("  AND DUR.IHC_TRF_NO = SUB.IHC_TRF_NO" ).append("\n"); 
		query.append("  AND DUR.AMDT_SEQ   = SUB.AMDT_SEQ" ).append("\n"); 
		query.append("  AND DUR.ORG_DEST_TP_CD = SUB.ORG_DEST_TP_CD" ).append("\n"); 

	}
}