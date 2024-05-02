/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOTriPropParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOTriPropParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO생성용
	  * </pre>
	  */
	public TRIProposalDBDAOTriPropParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOTriPropParamVORSQL").append("\n"); 
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
		query.append("SELECT '' AS SRCH_TRI_PROP_NO" ).append("\n"); 
		query.append("      ,'' AS SRCH_TRF_PFX_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_TRF_NO" ).append("\n"); 
		query.append("      ,'' AS SRCH_TRI_NO" ).append("\n"); 
		query.append("      ,'' AS SRCH_CMDT_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_ORG_ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("      ,'' AS SRCH_ORG_ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("      ,'' AS SRCH_DEST_ROUT_VIA_PORT_NM" ).append("\n"); 
		query.append("      ,'' AS SRCH_DEST_ROUT_PNT_LOC_NM" ).append("\n"); 
		query.append("      ,'' AS SRCH_PROP_STS_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_TRI_RQST_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_TRI_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_IS_GRI_APPL" ).append("\n"); 
		query.append("      ,'' AS SRCH_RAT_UT_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_CURR_CD" ).append("\n"); 
		query.append("      ,'' AS SRCH_EFF_DT" ).append("\n"); 
		query.append("      ,'' AS SRCH_EXP_DT" ).append("\n"); 
		query.append("      ,'' AS SRCH_ACS_DT" ).append("\n"); 
		query.append("      ,'' AS SRCH_TAA_NO" ).append("\n"); 
		query.append("      ,'' AS SRCH_ACTION" ).append("\n"); 
		query.append("      ,'' AS SRCH_GRI_EFF_DT" ).append("\n"); 
		query.append("      ,'' AS SRCH_ACC_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}