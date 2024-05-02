/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalDBDAOATEMPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.06 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCContractPartyProposalDBDAOATEMPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO  CREATE QUERY
	  * </pre>
	  */
	public SCContractPartyProposalDBDAOATEMPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration").append("\n"); 
		query.append("FileName : SCContractPartyProposalDBDAOATEMPRSQL").append("\n"); 
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
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append(", CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append(", CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append(", CTRT_PTY_NM" ).append("\n"); 
		query.append(", CTRT_PTY_ADDR" ).append("\n"); 
		query.append(", CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(", CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(", PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", SRC_INFO_CD" ).append("\n"); 
		query.append(", N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", ACPT_USR_ID" ).append("\n"); 
		query.append(", ACPT_OFC_CD" ).append("\n"); 
		query.append(", ACPT_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", '' OFC_CD" ).append("\n"); 
		query.append("FROM PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("CstPriSpCtrtPtyVO" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT      '' PROP_NO" ).append("\n"); 
		query.append(",    '' AMDT_SEQ" ).append("\n"); 
		query.append(",    '' PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append(",    '' CTRT_PTY_NM" ).append("\n"); 
		query.append(",    '' CTRT_PTY_ADDR" ).append("\n"); 
		query.append(",    '' CTRT_PTY_SGN_NM" ).append("\n"); 
		query.append(",    '' CTRT_PTY_SGN_TIT_NM" ).append("\n"); 
		query.append(",    '' PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",    '' SRC_INFO_CD" ).append("\n"); 
		query.append(",    '' N1ST_CMNC_DT" ).append("\n"); 
		query.append(",    '' CRE_USR_ID" ).append("\n"); 
		query.append(",    '' CRE_DT" ).append("\n"); 
		query.append(",    '' UPD_USR_ID" ).append("\n"); 
		query.append(",    '' UPD_DT" ).append("\n"); 
		query.append(",    '' OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("--PriSpCtrtPtyHVO" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}