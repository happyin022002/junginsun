/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpCntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.08.10 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpScpCntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scope삭제시 Terms의 데이터가 있는지 확인한다.
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpScpCntVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpScpCntVORSQL").append("\n"); 
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
		query.append("SELECT SUM(CNT) FROM (" ).append("\n"); 
		query.append("SELECT COUNT (*) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_RT_CMDT_HDR" ).append("\n"); 
		query.append("WHERE  PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT (*) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_GRP_LOC" ).append("\n"); 
		query.append("WHERE  PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT (*) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_GRP_CMDT" ).append("\n"); 
		query.append("WHERE  PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT (*) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_NOTE" ).append("\n"); 
		query.append("WHERE  PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT (*) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_TRSP_ADD_CHG" ).append("\n"); 
		query.append("WHERE  PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}