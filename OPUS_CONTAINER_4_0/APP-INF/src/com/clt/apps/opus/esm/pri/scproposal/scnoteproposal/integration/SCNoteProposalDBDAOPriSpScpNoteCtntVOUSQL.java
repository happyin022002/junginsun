/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.23 
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

public class SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_ctnt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteCtntVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_NOTE_CTNT SET" ).append("\n"); 
		query.append("	 NOTE_CTNT     			= NVL(@[note_ctnt], NOTE_CTNT)" ).append("\n"); 
		query.append("	,CHG_CD     			= NVL(@[chg_cd], CHG_CD)" ).append("\n"); 
		query.append("	,DP_SEQ     			= NVL(@[dp_seq], DP_SEQ)" ).append("\n"); 
		query.append("	,NOTE_CHG_TP_CD 		= NVL(@[note_chg_tp_cd], NOTE_CHG_TP_CD)" ).append("\n"); 
		query.append("	,N1ST_CMNC_AMDT_SEQ 	= NVL(@[n1st_cmnc_amdt_seq], N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append("	,PRC_PROG_STS_CD     	= NVL(@[prc_prog_sts_cd], PRC_PROG_STS_CD)" ).append("\n"); 
		query.append("	,SRC_INFO_CD     		= NVL(@[src_info_cd], SRC_INFO_CD)" ).append("\n"); 
		query.append("	,UPD_USR_ID     		= @[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT     			= SYSDATE" ).append("\n"); 
		query.append("WHERE	PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND		AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND		SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND		NOTE_TP_CD 		= @[note_tp_cd]" ).append("\n"); 
		query.append("AND		NOTE_SEQ 		= @[note_seq]" ).append("\n"); 
		query.append("#if (${is_master_delete} != 'Y')" ).append("\n"); 
		query.append("AND		NOTE_CTNT_SEQ	= @[note_ctnt_seq]" ).append("\n"); 
		query.append("#elseif (${is_master_delete} == 'Y') " ).append("\n"); 
		query.append("AND (	N1ST_CMNC_AMDT_SEQ  != @[amdt_seq] OR (N1ST_CMNC_AMDT_SEQ = @[amdt_seq] AND SRC_INFO_CD = 'AM' ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}