/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalDBDAOCreateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.05 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCTransportationAdditionalChargeProposalDBDAOCreateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vo생성을 위한 임시 쿼리
	  * </pre>
	  */
	public SCTransportationAdditionalChargeProposalDBDAOCreateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : SCTransportationAdditionalChargeProposalDBDAOCreateVORSQL").append("\n"); 
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
		query.append("     '' PRC_PROG_STS_CD " ).append("\n"); 
		query.append("    ,'' ACPT_USR_ID  " ).append("\n"); 
		query.append("    ,'' ACPT_OFC_CD  " ).append("\n"); 
		query.append("    ,'' ACPT_DT      " ).append("\n"); 
		query.append("    ,'' UPD_USR_ID     " ).append("\n"); 
		query.append("    ,'' UPD_DT" ).append("\n"); 
		query.append("    ,'' PROP_NO" ).append("\n"); 
		query.append("    ,'' AMDT_SEQ_ACCEPT    " ).append("\n"); 
		query.append("    ,'' PROP_STS_CD      " ).append("\n"); 
		query.append("	,'' org_dest_tp_cd" ).append("\n"); 
		query.append("	,'' svc_scp_cd" ).append("\n"); 
		query.append("	,'' amdt_seq" ).append("\n"); 
		query.append("	,'' Fnl_Frt_Rt_Amt" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("--CstArbAcceptVO" ).append("\n"); 

	}
}