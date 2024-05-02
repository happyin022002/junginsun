/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCDurationProposalDBDAOCstAcceptDurVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.15 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCDurationProposalDBDAOCstAcceptDurVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accept all, cancel all 시 사용하는 vo  생성
	  * </pre>
	  */
	public SCDurationProposalDBDAOCstAcceptDurVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration ").append("\n"); 
		query.append("FileName : SCDurationProposalDBDAOCstAcceptDurVORSQL").append("\n"); 
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
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("      ,AMDT_SEQ" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("      ,N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("      ,ACPT_USR_ID" ).append("\n"); 
		query.append("      ,ACPT_OFC_CD" ).append("\n"); 
		query.append("      ,ACPT_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,'' STS_CD" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_DUR" ).append("\n"); 

	}
}