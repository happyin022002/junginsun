/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAORsltRequestCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.28 공백진
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

public class RFAProposalMainDBDAORsltRequestCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAO
	  * </pre>
	  */
	public RFAProposalMainDBDAORsltRequestCheckVORSQL(){
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
		query.append("FileName : RFAProposalMainDBDAORsltRequestCheckVORSQL").append("\n"); 
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
		query.append("SELECT SUM (CNT) CD" ).append("\n"); 
		query.append("FROM   (SELECT COUNT (1) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_DMDT" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    DMDT_FT_TP_CD = 'E'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT (1)" ).append("\n"); 
		query.append("FROM   PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    PROP_TERM_TP_CD = '08'" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT SIGN (SUM (CNT))" ).append("\n"); 
		query.append("FROM   (SELECT COUNT (1) CNT" ).append("\n"); 
		query.append("FROM   PRI_RP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    PROP_TERM_TP_CD = '01'" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT (1)" ).append("\n"); 
		query.append("FROM   PRI_RP_SCP_AMDT_SMRY" ).append("\n"); 
		query.append("WHERE  PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND    AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND    PROP_SCP_TERM_TP_CD = '11'" ).append("\n"); 
		query.append("AND    AMDT_FLG = 'Y'))" ).append("\n"); 

	}
}