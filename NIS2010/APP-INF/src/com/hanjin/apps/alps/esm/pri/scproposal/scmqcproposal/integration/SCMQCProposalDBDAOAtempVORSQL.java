/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCMQCProposalDBDAOAtempVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.15 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCMQCProposalDBDAOAtempVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCMQCProposalDBDAO vo생성용
	  * </pre>
	  */
	public SCMQCProposalDBDAOAtempVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOAtempVORSQL").append("\n"); 
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
		query.append("FROM PRI_SP_SCP_MQC" ).append("\n"); 
		query.append("/*CstAcceptMqcVO*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("		  '' upd_dt					" ).append("\n"); 
		query.append("		,'' acpt_dt					" ).append("\n"); 
		query.append("		,'' acpt_ofc_cd			" ).append("\n"); 
		query.append("		,'' fnl_mqc_qty			" ).append("\n"); 
		query.append("		,'' amdt_seq				" ).append("\n"); 
		query.append("		,'' svc_scp_cd			" ).append("\n"); 
		query.append("		,'' acpt_usr_id			" ).append("\n"); 
		query.append("		,'' src_info_cd			" ).append("\n"); 
		query.append("		,'' cre_dt					" ).append("\n"); 
		query.append("		,'' prop_mqc_qty		" ).append("\n"); 
		query.append("		,'' cntr_lod_ut_cd	" ).append("\n"); 
		query.append("		,'' prop_scp_mqc_qty" ).append("\n"); 
		query.append("		,'' prc_prog_sts_cd	" ).append("\n"); 
		query.append("		,'' cre_usr_id" ).append("\n"); 
		query.append("		,'' prop_no					" ).append("\n"); 
		query.append("		,'' coffr_mqc_qty		" ).append("\n"); 
		query.append("		,'' upd_usr_id   		" ).append("\n"); 
		query.append("		,'' n1st_cmnc_dt		" ).append("\n"); 
		query.append("		,'' N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("		from dual" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}