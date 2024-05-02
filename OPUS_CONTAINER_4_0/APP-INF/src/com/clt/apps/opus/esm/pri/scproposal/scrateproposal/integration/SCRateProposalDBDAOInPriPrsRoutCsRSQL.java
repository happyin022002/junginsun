/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCRateProposalDBDAOInPriPrsRoutCsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.12 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateProposalDBDAOInPriPrsRoutCsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public SCRateProposalDBDAOInPriPrsRoutCsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration").append("\n"); 
		query.append("FileName : SCRateProposalDBDAOInPriPrsRoutCsRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'' AS ROUT_CS_NO" ).append("\n"); 
		query.append("	,'' AS ROUT_CS_SRC_DT" ).append("\n"); 
		query.append("	,'' AS PCTL_NO" ).append("\n"); 
		query.append("	,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("	,'' AS POR_CD" ).append("\n"); 
		query.append("	,'' AS POL_CD" ).append("\n"); 
		query.append("	,'' AS POD_CD" ).append("\n"); 
		query.append("	,'' AS DEL_CD" ).append("\n"); 
		query.append("	,'' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,'' AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	,'' AS BKG_OFC_CD" ).append("\n"); 
		query.append("	,'' AS CTRT_OFC_CD" ).append("\n"); 
		query.append("	,'' AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("	,'' AS RAT_UT_CD" ).append("\n"); 
		query.append("	,'' AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	,'' AS TEU_FRT_REV" ).append("\n"); 
		query.append("	,'' AS ROUT_CS_CLSS_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}