/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvGrpVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvGrpVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * master, detail삭제시 conversion삭제
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvGrpVODSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvGrpVODSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append(" WHERE NOTE_CONV_MAPG_ID IN (" ).append("\n"); 
		query.append("        SELECT B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_NOTE_CTNT B" ).append("\n"); 
		query.append("         WHERE B.SVC_SCP_CD			= @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND B.PROP_NO			= @[prop_no]" ).append("\n"); 
		query.append("           AND B.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("        #if (${is_scope_delete} != 'Y')" ).append("\n"); 
		query.append("        	#if (${is_master_delete} == 'Y') " ).append("\n"); 
		query.append("           	AND B.NOTE_TP_CD 		= @[note_tp_cd]" ).append("\n"); 
		query.append("           	AND B.NOTE_SEQ 			= @[note_seq]" ).append("\n"); 
		query.append("			AND B.N1ST_CMNC_AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("        	#elseif (${is_master_delete} != 'Y') " ).append("\n"); 
		query.append("        	AND B.NOTE_TP_CD 		= @[note_tp_cd]" ).append("\n"); 
		query.append("           	AND B.NOTE_SEQ 			= @[note_seq]" ).append("\n"); 
		query.append("           	AND B.NOTE_CTNT_SEQ 	= @[note_ctnt_seq]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}