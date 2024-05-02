/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalDBDAOPropCpPriRpScpNoteCtntCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.29 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAOPropCpPriRpScpNoteCtntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Proposal Scope Copy PRI_RP_SCP_NOTE_CTNT
	  * </pre>
	  */
	public RFANoteProposalDBDAOPropCpPriRpScpNoteCtntCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPropCpPriRpScpNoteCtntCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_NOTE_CTNT (" ).append("\n"); 
		query.append("PROP_NO" ).append("\n"); 
		query.append(", AMDT_SEQ" ).append("\n"); 
		query.append(", SVC_SCP_CD" ).append("\n"); 
		query.append(", NOTE_TP_CD" ).append("\n"); 
		query.append(", NOTE_SEQ" ).append("\n"); 
		query.append(", NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(", NOTE_CTNT" ).append("\n"); 
		query.append(", NOTE_CONV_FLG" ).append("\n"); 
		query.append(", DP_SEQ" ).append("\n"); 
		query.append(", NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", SRC_INFO_CD" ).append("\n"); 
		query.append(", N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("SELECT @[new_prop_no] AS PROP_NO" ).append("\n"); 
		query.append(", 0 AS AMDT_SEQ" ).append("\n"); 
		query.append(", B.SVC_SCP_CD" ).append("\n"); 
		query.append(", B.NOTE_TP_CD" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD" ).append("\n"); 
		query.append("ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD, A.DP_SEQ, A.NOTE_SEQ) AS NOTE_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD, A.NOTE_SEQ" ).append("\n"); 
		query.append("ORDER BY A.PROP_NO, A.AMDT_SEQ, A.SVC_SCP_CD, A.NOTE_TP_CD, A.NOTE_SEQ, B.NOTE_CTNT_SEQ) AS NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(", B.NOTE_CTNT" ).append("\n"); 
		query.append(", B.NOTE_CONV_FLG" ).append("\n"); 
		query.append(", B.DP_SEQ" ).append("\n"); 
		query.append(", TO_SINGLE_BYTE(SYS_GUID()) AS NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", 'I' AS PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", 'PC' AS SRC_INFO_CD" ).append("\n"); 
		query.append(", 0 AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_NOTE A" ).append("\n"); 
		query.append(",PRI_RP_SCP_NOTE_CTNT B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   A.NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("AND   B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND   B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND   B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   B.NOTE_TP_CD = A.NOTE_TP_CD" ).append("\n"); 
		query.append("AND   B.NOTE_SEQ = A.NOTE_SEQ" ).append("\n"); 
		query.append("AND   B.SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}