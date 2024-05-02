/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.10 공백진
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

public class RFAProposalMainDBDAOPriRpScpStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAOPriRpScpStsUSQL
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpScpStsUSQL(){
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
		query.append("FileName : RFAProposalMainDBDAOPriRpScpStsUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_MN MN" ).append("\n"); 
		query.append("SET PROP_SCP_STS_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CASE AMDT_SEQ" ).append("\n"); 
		query.append("WHEN 0 THEN" ).append("\n"); 
		query.append("CASE WHEN SUM(DECODE(AMDT_FLG, 'Y', 1, 0)) =" ).append("\n"); 
		query.append("DECODE(SUM(DECODE(ACPT_FLG, 'Y', 1, 0)), 0, -1, SUM(DECODE(ACPT_FLG, 'Y', 1, 0)))" ).append("\n"); 
		query.append("THEN 'A' ELSE 'I' END" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN SUM(DECODE(AMDT_FLG, 'Y', 1, 0)) = 0 THEN 'A'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN SUM(DECODE(AMDT_FLG, 'Y', 1, 0)) =" ).append("\n"); 
		query.append("DECODE(SUM(DECODE(ACPT_FLG, 'Y', 1, 0)), 0, -1, SUM(DECODE(ACPT_FLG, 'Y', 1, 0)))" ).append("\n"); 
		query.append("THEN 'A' ELSE 'I' END" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END PROP_STS_CD" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE PROP_NO   = MN.PROP_NO" ).append("\n"); 
		query.append("AND AMDT_SEQ    = MN.AMDT_SEQ" ).append("\n"); 
		query.append("AND SVC_SCP_CD  = MN.SVC_SCP_CD" ).append("\n"); 
		query.append("GROUP BY AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 

	}
}