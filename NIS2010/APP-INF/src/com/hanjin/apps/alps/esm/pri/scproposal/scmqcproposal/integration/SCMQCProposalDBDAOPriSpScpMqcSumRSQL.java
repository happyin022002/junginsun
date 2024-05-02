/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCMQCProposalDBDAOPriSpScpMqcSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.02.09 공백진
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

public class SCMQCProposalDBDAOPriSpScpMqcSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scope 별 mqc의 합
	  * </pre>
	  */
	public SCMQCProposalDBDAOPriSpScpMqcSumRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration").append("\n"); 
		query.append("FileName : SCMQCProposalDBDAOPriSpScpMqcSumRSQL").append("\n"); 
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
		query.append("SELECT   SUM(PROP_SCP_MQC_QTY) PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("FROM     (SELECT   SUM(DECODE(COFFR_MQC_QTY, 0, PROP_SCP_MQC_QTY, COFFR_MQC_QTY)) PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("          FROM     PRI_SP_SCP_MQC A" ).append("\n"); 
		query.append("          WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("               AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("               AND (SELECT   PROP_STS_CD" ).append("\n"); 
		query.append("                    FROM     PRI_SP_MN" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = A.AMDT_SEQ) IN ('R', 'Q')" ).append("\n"); 
		query.append("#if (${IS_ALL} != 'Y') " ).append("\n"); 
		query.append("AND SVC_SCP_CD <> @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT   SUM(PROP_SCP_MQC_QTY) PROP_SCP_MQC_QTY" ).append("\n"); 
		query.append("          FROM     PRI_SP_SCP_MQC A" ).append("\n"); 
		query.append("          WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("               AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("               AND (SELECT   PROP_STS_CD" ).append("\n"); 
		query.append("                    FROM     PRI_SP_MN" ).append("\n"); 
		query.append("                    WHERE    PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("                         AND AMDT_SEQ = A.AMDT_SEQ) = 'I'" ).append("\n"); 
		query.append("#if (${IS_ALL} != 'Y') " ).append("\n"); 
		query.append("AND SVC_SCP_CD <> @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}