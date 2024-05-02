/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * amend시 conversion 날짜가 amend날짜에 포함되어 있지 않은 경우는 삭제
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriSpScpNoteConvAmendDSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append("#if (${is_master_delete} == 'N') " ).append("\n"); 
		query.append(" WHERE NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${action_mode} == '11')" ).append("\n"); 
		query.append("   AND NOTE_CONV_RULE_CD != 'APP'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${action_mode} == '11' || ${action_mode} == '8')" ).append("\n"); 
		query.append("   AND (EFF_DT > TO_DATE(@[exp_dt], 'YYYYMMDD') OR EXP_DT < TO_DATE(@[eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${is_master_delete} == 'Y') " ).append("\n"); 
		query.append(" WHERE NOTE_CONV_MAPG_ID IN (" ).append("\n"); 
		query.append("		SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("		  FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("		 WHERE PROP_NO 				= @[prop_no]" ).append("\n"); 
		query.append("		   AND AMDT_SEQ 			= @[amdt_seq]" ).append("\n"); 
		query.append("		   AND SVC_SCP_CD 			= @[svc_scp_cd]" ).append("\n"); 
		query.append("		   AND NOTE_TP_CD 			= @[note_tp_cd]" ).append("\n"); 
		query.append("		   AND NOTE_SEQ 			= @[note_seq]" ).append("\n"); 
		query.append("		   AND N1ST_CMNC_AMDT_SEQ	= @[amdt_seq]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}