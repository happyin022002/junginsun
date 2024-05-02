/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FICCostInterfaceDBDAOCheckCopyServiceScopeInitialRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.05 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOCheckCopyServiceScopeInitialRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check exist IHC tariff's status
	  * </pre>
	  */
	public FICCostInterfaceDBDAOCheckCopyServiceScopeInitialRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOCheckCopyServiceScopeInitialRSQL").append("\n"); 
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
		query.append("SELECT C.CNT_NM" ).append("\n"); 
		query.append("     , HDR.SVC_SCP_CD " ).append("\n"); 
		query.append("     , HDR.IHC_TRF_NO " ).append("\n"); 
		query.append("     , HDR.COST_CNT_CD" ).append("\n"); 
		query.append("     , HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("     , MN.AMDT_SEQ" ).append("\n"); 
		query.append("     , MN.EFF_DT" ).append("\n"); 
		query.append("     , MN.FIC_PROP_STS_CD" ).append("\n"); 
		query.append("FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("   , (  " ).append("\n"); 
		query.append("        SELECT A.IHC_TRF_NO" ).append("\n"); 
		query.append("             , MN.SVC_SCP_CD" ).append("\n"); 
		query.append("             , A.COST_CNT_CD" ).append("\n"); 
		query.append("             , MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("             , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("          FROM PRI_TRF_IHC_MN MN" ).append("\n"); 
		query.append("             , (    SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("                         , COST_CNT_CD" ).append("\n"); 
		query.append("                         , ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                         , MAX(IHC_TRF_NO) IHC_TRF_NO" ).append("\n"); 
		query.append("                      FROM PRI_TRF_IHC_HDR" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("                       AND COST_CNT_CD IN ( #foreach(${key} in ${cost_cnt_cd})" ).append("\n"); 
		query.append("                                                #if($velocityCount < $cost_cnt_cd.size())" ).append("\n"); 
		query.append("                                                    '$key', " ).append("\n"); 
		query.append("                                                #else  " ).append("\n"); 
		query.append("                                                    '$key'" ).append("\n"); 
		query.append("                                                #end " ).append("\n"); 
		query.append("					                       #end )                          " ).append("\n"); 
		query.append("                       AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("                       GROUP BY SVC_SCP_CD, COST_CNT_CD, ORG_DEST_TP_CD" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND MN.IHC_TRF_NO = A.IHC_TRF_NO" ).append("\n"); 
		query.append("      GROUP BY A.IHC_TRF_NO, MN.SVC_SCP_CD, A.COST_CNT_CD, MN.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("      ) HDR" ).append("\n"); 
		query.append("    , MDM_COUNTRY C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND MN.SVC_SCP_CD  = HDR.SVC_SCP_CD" ).append("\n"); 
		query.append("  AND MN.ORG_DEST_TP_CD = HDR.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("  AND MN.IHC_TRF_NO = HDR.IHC_TRF_NO" ).append("\n"); 
		query.append("  AND HDR.COST_CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("  AND MN.FIC_PROP_STS_CD = 'I'" ).append("\n"); 

	}
}