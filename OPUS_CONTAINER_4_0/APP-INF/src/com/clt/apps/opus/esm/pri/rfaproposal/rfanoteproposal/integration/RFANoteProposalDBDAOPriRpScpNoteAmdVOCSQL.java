/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFANoteProposalDBDAOPriRpScpNoteAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.01.11 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAOPriRpScpNoteAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFANoteProposalDBDAOPriRpScpNoteAmdVOCSQL
	  * </pre>
	  */
	public RFANoteProposalDBDAOPriRpScpNoteAmdVOCSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPriRpScpNoteAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RP_SCP_NOTE(" ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    NOTE_TP_CD," ).append("\n"); 
		query.append("    NOTE_SEQ," ).append("\n"); 
		query.append("    NOTE_TIT_NM," ).append("\n"); 
		query.append("    DP_SEQ," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    PROP_NO         ," ).append("\n"); 
		query.append("    AMDT_SEQ+1      ," ).append("\n"); 
		query.append("    SVC_SCP_CD      ," ).append("\n"); 
		query.append("    NOTE_TP_CD      ," ).append("\n"); 
		query.append("    NOTE_SEQ        ," ).append("\n"); 
		query.append("    NOTE_TIT_NM     ," ).append("\n"); 
		query.append("    DP_SEQ          ," ).append("\n"); 
		query.append("    @[cre_usr_id]   ," ).append("\n"); 
		query.append("    SYSDATE         ," ).append("\n"); 
		query.append("    @[upd_usr_id]   ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    PRI_RP_SCP_NOTE NOTE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    PROP_NO     = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ    = @[amdt_seq]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'OK'" ).append("\n"); 
		query.append("    FROM PRI_RP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("    WHERE" ).append("\n"); 
		query.append("        PROP_NO         = NOTE.PROP_NO" ).append("\n"); 
		query.append("    AND AMDT_SEQ        = NOTE.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SVC_SCP_CD      = NOTE.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND NOTE_TP_CD      = NOTE.NOTE_TP_CD    " ).append("\n"); 
		query.append("    AND NOTE_SEQ        = NOTE.NOTE_SEQ" ).append("\n"); 
		query.append("	AND SRC_INFO_CD		<> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}