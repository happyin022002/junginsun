/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOPriSpScpNoteAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCNoteProposalDBDAOPriSpScpNoteAmdVOCSQL
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteAmdVOCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteAmdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO pri_sp_scp_note(" ).append("\n"); 
		query.append("PROP_NO," ).append("\n"); 
		query.append("AMDT_SEQ," ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("NOTE_TP_CD," ).append("\n"); 
		query.append("NOTE_SEQ," ).append("\n"); 
		query.append("NOTE_TIT_NM," ).append("\n"); 
		query.append("NOTE_CLSS_CD," ).append("\n"); 
		query.append("DP_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("prop_no         ," ).append("\n"); 
		query.append("amdt_seq+1      ," ).append("\n"); 
		query.append("svc_scp_cd      ," ).append("\n"); 
		query.append("note_tp_cd      ," ).append("\n"); 
		query.append("note_seq        ," ).append("\n"); 
		query.append("note_tit_nm     ," ).append("\n"); 
		query.append("note_clss_cd    ," ).append("\n"); 
		query.append("dp_seq          ," ).append("\n"); 
		query.append("@[cre_usr_id]   ," ).append("\n"); 
		query.append("SYSDATE         ," ).append("\n"); 
		query.append("@[upd_usr_id]   ," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_scp_note note" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no     = @[prop_no]" ).append("\n"); 
		query.append("AND amdt_seq    = @[amdt_seq]" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'OK'" ).append("\n"); 
		query.append("FROM pri_sp_scp_note_ctnt" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no 		= note.prop_no" ).append("\n"); 
		query.append("AND amdt_seq 		= note.amdt_seq" ).append("\n"); 
		query.append("AND svc_scp_cd  	= note.svc_scp_cd" ).append("\n"); 
		query.append("AND note_tp_cd		= note.note_tp_cd" ).append("\n"); 
		query.append("AND note_seq		= note.note_seq" ).append("\n"); 
		query.append("AND src_info_cd <> 'AD'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}