/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpScpMnStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.20 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpScpMnStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * terms가 모두 Accept 되었는지 확인한다.
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpScpMnStatusVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpScpMnStatusVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(MAX (DECODE (ORD, 3, CNT)), 1, 1, MAX (DECODE (ORD, 1, CNT)) - MAX (DECODE (ORD, 2, CNT)))" ).append("\n"); 
		query.append("FROM   (SELECT 1 ORD" ).append("\n"); 
		query.append(",COUNT (*) CNT" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2" ).append("\n"); 
		query.append(",COUNT (*)" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    ACPT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append("FROM   PRI_SP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    ACPT_FLG = 'N'" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'N'" ).append("\n"); 
		query.append("AND    SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}