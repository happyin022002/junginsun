/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteCtntAmdDelCancelVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOPriSpScpNoteCtntAmdDelCancelVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Standard Note - Delete Cancel 버튼
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteCtntAmdDelCancelVOCSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration ").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteCtntAmdDelCancelVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_NOTE_CTNT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 PROP_NO        " ).append("\n"); 
		query.append("	,AMDT_SEQ       " ).append("\n"); 
		query.append("	,SVC_SCP_CD     " ).append("\n"); 
		query.append("	,NOTE_TP_CD     " ).append("\n"); 
		query.append("	,NOTE_SEQ       " ).append("\n"); 
		query.append("	,NOTE_CTNT_SEQ  " ).append("\n"); 
		query.append("	,CHG_CD         " ).append("\n"); 
		query.append("	,NOTE_CTNT      " ).append("\n"); 
		query.append("	,NOTE_CONV_FLG  " ).append("\n"); 
		query.append("	,DP_SEQ         " ).append("\n"); 
		query.append("	,NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	,NOTE_CHG_TP_CD " ).append("\n"); 
		query.append("	,PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	,SRC_INFO_CD    " ).append("\n"); 
		query.append("	,N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("	,ACPT_USR_ID    " ).append("\n"); 
		query.append("	,ACPT_OFC_CD    " ).append("\n"); 
		query.append("	,ACPT_DT        " ).append("\n"); 
		query.append("	,CRE_USR_ID     " ).append("\n"); 
		query.append("	,CRE_DT         " ).append("\n"); 
		query.append("	,UPD_USR_ID     " ).append("\n"); 
		query.append("	,UPD_DT         " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT PROP_NO        " ).append("\n"); 
		query.append("	 , @[amdt_seq]       " ).append("\n"); 
		query.append("	 , SVC_SCP_CD     " ).append("\n"); 
		query.append("	 , NOTE_TP_CD     " ).append("\n"); 
		query.append("	 , NOTE_SEQ       " ).append("\n"); 
		query.append("	 , NOTE_CTNT_SEQ  " ).append("\n"); 
		query.append("	 , CHG_CD         " ).append("\n"); 
		query.append("	 , NOTE_CTNT      " ).append("\n"); 
		query.append("	 , NOTE_CONV_FLG  " ).append("\n"); 
		query.append("	 , DP_SEQ         " ).append("\n"); 
		query.append("	 , NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	 , NOTE_CHG_TP_CD " ).append("\n"); 
		query.append("	 , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	 , SRC_INFO_CD    " ).append("\n"); 
		query.append("	 , N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("	 , ACPT_USR_ID    " ).append("\n"); 
		query.append("	 , ACPT_OFC_CD    " ).append("\n"); 
		query.append("	 , ACPT_DT        " ).append("\n"); 
		query.append("	 , CRE_USR_ID     " ).append("\n"); 
		query.append("	 , CRE_DT         " ).append("\n"); 
		query.append("	 , @[upd_usr_id]  " ).append("\n"); 
		query.append("	 , SYSDATE" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append(" WHERE PROP_NO		= @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ		= @[amdt_seq] - 1" ).append("\n"); 
		query.append("   AND SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND NOTE_TP_CD	= @[note_tp_cd]" ).append("\n"); 

	}
}