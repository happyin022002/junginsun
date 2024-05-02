/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvVODSQL").append("\n"); 
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
		query.append("  FROM PRI_RFA_NOTE_CONV" ).append("\n"); 
		query.append(" WHERE NOTE_CONV_MAPG_ID IN (" ).append("\n"); 
		query.append("        SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("         WHERE SVC_SCP_CD			= @[svc_scp_cd]" ).append("\n"); 
		query.append("           AND PROP_NO				= @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ				= @[amdt_seq]" ).append("\n"); 
		query.append("        #if (${is_scope_delete} != 'Y')" ).append("\n"); 
		query.append("        	#if (${is_master_delete} == 'Y') " ).append("\n"); 
		query.append("           	AND NOTE_TP_CD 			= @[note_tp_cd]" ).append("\n"); 
		query.append("           	AND NOTE_SEQ 			= @[note_seq]" ).append("\n"); 
		query.append("			AND N1ST_CMNC_AMDT_SEQ	= @[amdt_seq]" ).append("\n"); 
		query.append("        	#elseif (${is_master_delete} != 'Y') " ).append("\n"); 
		query.append("        	AND NOTE_TP_CD 			= @[note_tp_cd]" ).append("\n"); 
		query.append("           	AND NOTE_SEQ 			= @[note_seq]" ).append("\n"); 
		query.append("           	AND NOTE_CTNT_SEQ 		= @[note_ctnt_seq]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}