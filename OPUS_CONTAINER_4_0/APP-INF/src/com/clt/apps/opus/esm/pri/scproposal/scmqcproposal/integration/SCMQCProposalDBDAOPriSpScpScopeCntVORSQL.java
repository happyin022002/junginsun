/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCMQCProposalDBDAOPriSpScpScopeCntVORSQL.java
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

public class SCMQCProposalDBDAOPriSpScpScopeCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scope의 갯수를 조회한다.
	  * </pre>
	  */
	public SCMQCProposalDBDAOPriSpScpScopeCntVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOPriSpScpScopeCntVORSQL").append("\n"); 
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
		query.append("SELECT SVC_SCP_CD ETC1" ).append("\n"); 
		query.append("      ,( SELECT COUNT(*) FROM PRI_SP_SCP_MN" ).append("\n"); 
		query.append("         WHERE PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("         AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        ) ETC2" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}