/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltAcceptListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.08.07 공백진
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

public class RFAProposalMainDBDAORsltAcceptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * accept data  조회
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltAcceptListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAORsltAcceptListRSQL").append("\n"); 
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
		query.append("FROM   (SELECT PROP_NO" ).append("\n"); 
		query.append("FROM   PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    ACPT_FLG = 'N'" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    ACPT_FLG = 'N'" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    ROWNUM = 1)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1" ).append("\n"); 

	}
}