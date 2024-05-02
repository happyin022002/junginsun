/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalDBDAOPriRpScpNoteCtntActVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.18 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAOPriRpScpNoteCtntActVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * accept
	  * </pre>
	  */
	public RFANoteProposalDBDAOPriRpScpNoteCtntActVOUSQL(){
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
		params.put("acpt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acpt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_prog_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPriRpScpNoteCtntActVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_RP_SCP_NOTE_CTNT SET" ).append("\n"); 
		query.append("PRC_PROG_STS_CD     	= NVL(@[prc_prog_sts_cd], PRC_PROG_STS_CD)" ).append("\n"); 
		query.append(",ACPT_USR_ID 			= @[acpt_usr_id]" ).append("\n"); 
		query.append(",ACPT_OFC_CD 			= @[acpt_ofc_cd]" ).append("\n"); 
		query.append(",ACPT_DT 				= DECODE(@[acpt_dt], '1', SYSDATE, NULL)" ).append("\n"); 
		query.append(",UPD_USR_ID     		= @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT     			= SYSDATE" ).append("\n"); 
		query.append("WHERE	PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("AND		AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND		SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND		NOTE_TP_CD 		= @[note_tp_cd]" ).append("\n"); 
		query.append("AND		N1ST_CMNC_AMDT_SEQ 	= @[amdt_seq]" ).append("\n"); 
		query.append("#if (${is_all_accept} != 'Y')" ).append("\n"); 
		query.append("AND		NOTE_SEQ 		= @[note_seq]" ).append("\n"); 
		query.append("AND		NOTE_CTNT_SEQ	= @[note_ctnt_seq]" ).append("\n"); 
		query.append("#elseif (${is_all_accept} == 'Y')" ).append("\n"); 
		query.append("AND 	PRC_PROG_STS_CD 	<> 	@[prc_prog_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}