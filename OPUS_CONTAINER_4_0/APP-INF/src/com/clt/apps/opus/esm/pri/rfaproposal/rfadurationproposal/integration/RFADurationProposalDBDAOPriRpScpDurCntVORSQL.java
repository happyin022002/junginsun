/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFADurationProposalDBDAOPriRpScpDurCntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.11 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFADurationProposalDBDAOPriRpScpDurCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scope Duration에서 Main Duration의 exp_dt와 같은 Scope을 조회한다.
	  * </pre>
	  */
	public RFADurationProposalDBDAOPriRpScpDurCntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.integration").append("\n"); 
		query.append("FileName : RFADurationProposalDBDAOPriRpScpDurCntVORSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD CD" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_DUR" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append("AND TO_CHAR(CTRT_EXP_DT, 'yyyy-MM-dd') = " ).append("\n"); 
		query.append("	(SELECT TO_CHAR(CTRT_EXP_DT, 'yyyy-MM-dd') " ).append("\n"); 
		query.append("	 FROM PRI_RP_DUR" ).append("\n"); 
		query.append("	 WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	 AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("	 )" ).append("\n"); 

	}
}