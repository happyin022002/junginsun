/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteProposalDBDAOConversionNoteCtntUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.29 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOConversionNoteCtntUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Converison Update시 note_chg_tp_cd수정
	  * </pre>
	  */
	public SCNoteProposalDBDAOConversionNoteCtntUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOConversionNoteCtntUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SP_SCP_NOTE_CTNT P" ).append("\n"); 
		query.append("SET NOTE_CHG_TP_CD = (SELECT NOTE_CHG_TP_CD FROM PRI_SP_SCP_NOTE_CTNT N " ).append("\n"); 
		query.append("                      WHERE PROP_NO 		  = @[prop_no] " ).append("\n"); 
		query.append("                      AND AMDT_SEQ 			  = @[amdt_seq]" ).append("\n"); 
		query.append("                      AND N.SVC_SCP_CD 		  = P.SVC_SCP_CD" ).append("\n"); 
		query.append("                      AND N.NOTE_TP_CD 		  = P.NOTE_TP_CD" ).append("\n"); 
		query.append("                      AND N.NOTE_SEQ 		  = P.NOTE_SEQ" ).append("\n"); 
		query.append("                      AND N.NOTE_CTNT_SEQ 	  = P.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("WHERE PROP_NO    = @[prop_no]" ).append("\n"); 
		query.append("AND   AMDT_SEQ   = @[amdt_seq] + 1       " ).append("\n"); 
		query.append("AND   NOTE_TP_CD = 'P'" ).append("\n"); 

	}
}