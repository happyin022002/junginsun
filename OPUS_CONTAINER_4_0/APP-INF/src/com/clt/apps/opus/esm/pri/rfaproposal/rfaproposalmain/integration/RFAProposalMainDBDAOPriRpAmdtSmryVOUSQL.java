/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.11 공백진
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

public class RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL(){
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
		params.put("prop_term_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpAmdtSmryVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_AMDT_SMRY UPD" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("( AMDT_FLG  ,ACPT_FLG ) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("DECODE(count(SRC.AMDT_SEQ),0,'N','','N','Y')," ).append("\n"); 
		query.append("DECODE(MAX(SRC.PRC_PROG_STS_CD),'A','Y','N')" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("#if(${prop_term_tp_cd} == \"01\")" ).append("\n"); 
		query.append("PRI_RP_DUR SRC," ).append("\n"); 
		query.append("#elseif(${prop_term_tp_cd} == \"05\")" ).append("\n"); 
		query.append("PRI_RP_AFIL SRC," ).append("\n"); 
		query.append("#elseif(${prop_term_tp_cd} == \"08\")" ).append("\n"); 
		query.append("PRI_RP_DMDT SRC," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("PRI_RP_MN MN" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SRC.PROP_NO 		= UPD.PROP_NO" ).append("\n"); 
		query.append("AND SRC.AMDT_SEQ 		= UPD.AMDT_SEQ" ).append("\n"); 
		query.append("AND SRC.PROP_NO 		= MN.PROP_NO" ).append("\n"); 
		query.append("AND SRC.AMDT_SEQ 		= MN.AMDT_SEQ" ).append("\n"); 
		query.append("and src.N1ST_CMNC_AMDT_SEQ 	= mn.amdt_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ   = @[amdt_seq]" ).append("\n"); 
		query.append("AND PROP_TERM_TP_CD = @[prop_term_tp_cd]" ).append("\n"); 

	}
}