/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateProposalDBDAOPriSpBlplTempRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.28 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateProposalDBDAOPriSpBlplTempRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vo create
	  * </pre>
	  */
	public SCBoilerPlateProposalDBDAOPriSpBlplTempRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scboilerplateproposal.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateProposalDBDAOPriSpBlplTempRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ" ).append("\n"); 
		query.append(", '' hdr_eff_dt" ).append("\n"); 
		query.append(", '' blpl_hdr_seq" ).append("\n"); 
		query.append("from dual" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ" ).append("\n"); 
		query.append(",'' EFF_DT" ).append("\n"); 
		query.append(",'' N1ST_CMNC_DT" ).append("\n"); 
		query.append(",'' BLPL_HDR_SEQ" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(", '' hdr_eff_dt" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",'' ACPT_USR_ID" ).append("\n"); 
		query.append(",'' ACPT_OFC_CD" ).append("\n"); 
		query.append(",'' ACPT_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ_ACCEPT" ).append("\n"); 
		query.append(",'' STS_CD" ).append("\n"); 
		query.append(",'' EFF_DT" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}