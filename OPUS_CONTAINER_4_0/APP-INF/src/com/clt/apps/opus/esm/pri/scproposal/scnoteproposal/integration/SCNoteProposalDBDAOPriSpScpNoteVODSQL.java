/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.28 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOPriSpScpNoteVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteVODSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("WHERE	PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND		AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND		SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${is_scope_delete} != 'Y')" ).append("\n"); 
		query.append("AND		NOTE_TP_CD 		= @[note_tp_cd]" ).append("\n"); 
		query.append("#if (${is_type_delete} != 'Y')" ).append("\n"); 
		query.append("AND		NOTE_SEQ 		= @[note_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}