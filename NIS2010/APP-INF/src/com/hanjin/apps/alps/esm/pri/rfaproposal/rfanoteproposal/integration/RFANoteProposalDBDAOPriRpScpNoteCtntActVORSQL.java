/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalDBDAOPriRpScpNoteCtntActVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.04 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAOPriRpScpNoteCtntActVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ALL ACCEPT시 ACCEPT할 데이터가 존재하는지 조회한다.
	  * </pre>
	  */
	public RFANoteProposalDBDAOPriRpScpNoteCtntActVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration ").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPriRpScpNoteCtntActVORSQL").append("\n"); 
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
		query.append("SELECT NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("WHERE PROP_NO 			= @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("AND SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("AND NOTE_TP_CD 		= @[note_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prc_prog_sts_cd} == 'A')" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD != 'A'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND PRC_PROG_STS_CD = 'A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}