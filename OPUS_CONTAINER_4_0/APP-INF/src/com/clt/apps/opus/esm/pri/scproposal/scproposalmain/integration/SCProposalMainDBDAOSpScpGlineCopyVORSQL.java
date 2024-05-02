/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOSpScpGlineCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.04
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.07.04 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOSpScpGlineCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vo creating query
	  * </pre>
	  */
	public SCProposalMainDBDAOSpScpGlineCopyVORSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS PROP_NO" ).append("\n"); 
		query.append(", '' AS AMDT_SEQ" ).append("\n"); 
		query.append(", '' AS SVC_SCP_CD" ).append("\n"); 
		query.append(", '' AS SVC_SCP_NM" ).append("\n"); 
		query.append(", '' AS GLINE_SEQ" ).append("\n"); 
		query.append(", '' AS PRC_CUST_TP_CD" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", 0 AS MQC_QTY" ).append("\n"); 
		query.append(", 0 AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append(", '' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", 0 AS NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", 0 AS GRP_CMDT_SEQ" ).append("\n"); 
		query.append(", 0 AS GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append(", '' AS EFF_DT" ).append("\n"); 
		query.append(", '' AS EXP_DT" ).append("\n"); 
		query.append(", '' AS SC_NO" ).append("\n"); 
		query.append(", '' AS SVC_SCP_MN" ).append("\n"); 
		query.append(", '' AS CMDT_TPW_MST" ).append("\n"); 
		query.append(", '' AS CMDT_TPW_DTL" ).append("\n"); 
		query.append(", '' AS LOC_CHK" ).append("\n"); 
		query.append(", '' AS CMDT_CHK" ).append("\n"); 
		query.append(", '' AS CMDT_TPW_CHK" ).append("\n"); 
		query.append(", '' AS ARB_ORG_CHK" ).append("\n"); 
		query.append(", '' AS ARB_DES_CHK" ).append("\n"); 
		query.append(", '' AS GOH_CHK" ).append("\n"); 
		query.append(", '' AS RATE_CHK" ).append("\n"); 
		query.append(", '' AS NOTE_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOSpScpGlineCopyVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}