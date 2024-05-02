/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpScpMnAmdDurVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.02 공백진
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

public class RFAProposalMainDBDAOPriRpScpMnAmdDurVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amend 시 duration을 같이 변경할 경우
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpScpMnAmdDurVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpScpMnAmdDurVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_MN SET" ).append("\n"); 
		query.append("EXP_DT = TO_DATE(@[exp_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append(",PROP_SCP_STS_CD = 'I'" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO         = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ        = @[amdt_seq] + 1" ).append("\n"); 
		query.append("AND (TO_CHAR(EXP_DT,'YYYYMMDD') >= ( SELECT TO_CHAR(EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("FROM PRI_RP_MN" ).append("\n"); 
		query.append("WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq])" ).append("\n"); 
		query.append("OR TRUNC(EXP_DT) > TO_DATE(@[exp_dt],'yyyy-MM-dd'))" ).append("\n"); 

	}
}