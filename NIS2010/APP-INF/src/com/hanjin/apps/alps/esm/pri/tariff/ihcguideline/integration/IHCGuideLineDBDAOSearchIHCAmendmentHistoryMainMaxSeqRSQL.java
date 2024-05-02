/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.06
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.11.06 서미진
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

public class IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve IHC Tariff Amendment History Maxseq
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainMaxSeqRSQL(){
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
		query.append("FileName : IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT IHC_TRF_NO" ).append("\n"); 
		query.append("     , NVL( (SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("               FROM PRI_TRF_IHC_MN" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("                AND ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("                AND IHC_TRF_NO   = @[ihc_trf_no] " ).append("\n"); 
		query.append("                AND FIC_PROP_STS_CD ='C'" ).append("\n"); 
		query.append("            ), '0' ) AMDT_SEQ           " ).append("\n"); 
		query.append("FROM PRI_TRF_IHC_MN " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("AND IHC_TRF_NO   = @[ihc_trf_no] " ).append("\n"); 

	}
}