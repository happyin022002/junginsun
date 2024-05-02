/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOPriSpScpNoteHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert PRI_SP_SCP_NOTE_MIG_HIS
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_NOTE_MIG_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 PROP_NO" ).append("\n"); 
		query.append("	,AMDT_SEQ" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("	,NOTE_TP_CD" ).append("\n"); 
		query.append("	,NOTE_SEQ" ).append("\n"); 
		query.append("	,BKUP_DT" ).append("\n"); 
		query.append("	,NOTE_TIT_NM" ).append("\n"); 
		query.append("	,NOTE_CLSS_CD" ).append("\n"); 
		query.append("	,DP_SEQ" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       PROP_NO" ).append("\n"); 
		query.append("	, AMDT_SEQ" ).append("\n"); 
		query.append("	, SVC_SCP_CD" ).append("\n"); 
		query.append("	, NOTE_TP_CD" ).append("\n"); 
		query.append("	, NOTE_SEQ" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, NOTE_TIT_NM" ).append("\n"); 
		query.append("	, NOTE_CLSS_CD" ).append("\n"); 
		query.append("	, DP_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append(" WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND NOTE_TP_CD = @[note_tp_cd]" ).append("\n"); 
		query.append("   AND NOTE_SEQ = @[note_seq]" ).append("\n"); 
		query.append("   AND NOTE_CLSS_CD = @[note_clss_cd]" ).append("\n"); 

	}
}