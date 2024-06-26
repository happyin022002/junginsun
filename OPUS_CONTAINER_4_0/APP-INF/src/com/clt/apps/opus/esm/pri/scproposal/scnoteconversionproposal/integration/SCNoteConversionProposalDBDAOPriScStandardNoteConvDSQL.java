/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScStandardNoteConvDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.11.20 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScStandardNoteConvDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STANDARD NOTE에서 CTNT 삭제시 해당 CONVERSION 삭제
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScStandardNoteConvDSQL(){
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
		params.put("note_ctnt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScStandardNoteConvDSQL").append("\n"); 
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
		query.append("WHERE NOTE_CONV_MAPG_ID IN (" ).append("\n"); 
		query.append("SELECT B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("FROM PRI_SG_STND_NOTE_CTNT B" ).append("\n"); 
		query.append("WHERE B.SVC_SCP_CD			= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND B.NOTE_HDR_SEQ		= @[note_hdr_seq]" ).append("\n"); 
		query.append("#if (${note_seq} != '')" ).append("\n"); 
		query.append("AND B.NOTE_SEQ			= @[note_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${note_ctnt_seq} != '')" ).append("\n"); 
		query.append("AND B.NOTE_CTNT_SEQ      = @[note_ctnt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}