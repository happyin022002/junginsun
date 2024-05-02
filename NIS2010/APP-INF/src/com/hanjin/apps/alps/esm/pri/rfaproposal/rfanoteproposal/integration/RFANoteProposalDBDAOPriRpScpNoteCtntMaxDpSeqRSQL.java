/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFANoteProposalDBDAOPriRpScpNoteCtntMaxDpSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAOPriRpScpNoteCtntMaxDpSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * amdt_seq - 1 에 해당하는 max dp_seq 를 조회한다.
	  * </pre>
	  */
	public RFANoteProposalDBDAOPriRpScpNoteCtntMaxDpSeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration ").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPriRpScpNoteCtntMaxDpSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(DP_SEQ),0) MAX_DP_SEQ" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append(" WHERE PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ 	= @[amdt_seq] - 1" ).append("\n"); 
		query.append("   AND SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND NOTE_SEQ		= @[note_seq]" ).append("\n"); 
		query.append("   AND NOTE_TP_CD 	= @[note_tp_cd]" ).append("\n"); 

	}
}