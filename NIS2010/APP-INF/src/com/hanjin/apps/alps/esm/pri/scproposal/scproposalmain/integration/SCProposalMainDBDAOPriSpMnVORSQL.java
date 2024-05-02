/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.05 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpMnVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT 'TPE' SVC_SCP_CD" ).append("\n"); 
		query.append(",'1' SCP" ).append("\n"); 
		query.append(",'1' ORG" ).append("\n"); 
		query.append(",'0' DEST" ).append("\n"); 
		query.append(",'1' GRP_LOC" ).append("\n"); 
		query.append(",'1' GRP_CMDT" ).append("\n"); 
		query.append(",'1' ORI_ARB" ).append("\n"); 
		query.append(",'1' DEST_ARB" ).append("\n"); 
		query.append(",'1' RATE" ).append("\n"); 
		query.append(",'0' STND_NOTE" ).append("\n"); 
		query.append(",'1' SPL_NOTE" ).append("\n"); 
		query.append(",'1' LD_AGENT" ).append("\n"); 
		query.append(",'1' IHC" ).append("\n"); 
		query.append(",'1' GOH" ).append("\n"); 
		query.append(",'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' BLPL" ).append("\n"); 
		query.append(",'' AFIL" ).append("\n"); 
		query.append(",'' NW_PROP_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'AEW' SVC_SCP_CD" ).append("\n"); 
		query.append(",'1' SCP" ).append("\n"); 
		query.append(",'1' ORG" ).append("\n"); 
		query.append(",'1' DEST" ).append("\n"); 
		query.append(",'1' GRP_LOC" ).append("\n"); 
		query.append(",'1' GRP_CMDT" ).append("\n"); 
		query.append(",'1' ORI_ARB" ).append("\n"); 
		query.append(",'1' DEST_ARB" ).append("\n"); 
		query.append(",'1' RATE" ).append("\n"); 
		query.append(",'1' STND_NOTE" ).append("\n"); 
		query.append(",'0' SPL_NOTE" ).append("\n"); 
		query.append(",'1' LD_AGENT" ).append("\n"); 
		query.append(",'0' IHC" ).append("\n"); 
		query.append(",'1' GOH" ).append("\n"); 
		query.append(",'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' BLPL" ).append("\n"); 
		query.append(",'' AFIL" ).append("\n"); 
		query.append(",'' NW_PROP_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpMnVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}