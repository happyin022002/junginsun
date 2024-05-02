/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteCtntChgTpVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.27 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAOPriSpScpNoteCtntChgTpVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * charge type code를 업데이트한다.
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteCtntChgTpVOUSQL(){
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
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteCtntChgTpVOUSQL").append("\n"); 
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
		query.append("#if (${note_conv_tp_cd} == 'P')" ).append("\n"); 
		query.append("UPDATE PRI_SP_SCP_NOTE_CTNT SET" ).append("\n"); 
		query.append("NOTE_CHG_TP_CD 	= @[note_chg_tp_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT			= sysdate" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${note_conv_tp_cd} == 'R')" ).append("\n"); 
		query.append("UPDATE PRI_SP_SCP_RT_CMDT_RNOTE SET" ).append("\n"); 
		query.append("NOTE_CHG_TP_CD 	= @[note_chg_tp_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT			= sysdate" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${note_conv_tp_cd} == 'C')" ).append("\n"); 
		query.append("UPDATE PRI_SP_SCP_RT_CNOTE SET" ).append("\n"); 
		query.append("NOTE_CHG_TP_CD 	= @[note_chg_tp_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT			= sysdate" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID = @[note_conv_mapg_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}