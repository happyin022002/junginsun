/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCMQCProposalDBDAOSchPriSpScpMqcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.22 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCMQCProposalDBDAOSchPriSpScpMqcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search vo 를 만들기 위해 임시로 생성
	  * </pre>
	  */
	public SCMQCProposalDBDAOSchPriSpScpMqcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOSchPriSpScpMqcVORSQL").append("\n"); 
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
		query.append("	PROP_NO" ).append("\n"); 
		query.append(",	AMDT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	CNTR_LOD_UT_CD" ).append("\n"); 
		query.append(",	PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append(",	0 PROP_MQC_QTY" ).append("\n"); 
		query.append(",	COFFR_MQC_QTY" ).append("\n"); 
		query.append(",	FNL_MQC_QTY" ).append("\n"); 
		query.append(",	PRC_PROG_STS_CD" ).append("\n"); 
		query.append(",	SRC_INFO_CD" ).append("\n"); 
		query.append(",	N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(",	ACPT_USR_ID" ).append("\n"); 
		query.append(",	ACPT_OFC_CD" ).append("\n"); 
		query.append(",	ACPT_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",'' PROP_STS_CD" ).append("\n"); 
		query.append(",'' SAVE_GBN" ).append("\n"); 
		query.append(",'' SAVE_SCP" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MQC" ).append("\n"); 

	}
}