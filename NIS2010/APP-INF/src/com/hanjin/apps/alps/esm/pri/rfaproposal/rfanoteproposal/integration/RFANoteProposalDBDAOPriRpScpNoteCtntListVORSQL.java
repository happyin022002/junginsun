/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteProposalDBDAOPriRpScpNoteCtntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.27 최성민
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

public class RFANoteProposalDBDAOPriRpScpNoteCtntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vo 객체 생성시 사용
	  * </pre>
	  */
	public RFANoteProposalDBDAOPriRpScpNoteCtntListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration ").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPriRpScpNoteCtntListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' DP_SEQ" ).append("\n"); 
		query.append(", '' NOTE_CHG_TP_CD" ).append("\n"); 
		query.append(", '' AMDT_SEQ" ).append("\n"); 
		query.append(", '' ACTION_MODE" ).append("\n"); 
		query.append(", '' SVC_SCP_CD" ).append("\n"); 
		query.append(", '' CRE_DT" ).append("\n"); 
		query.append(", '' NOTE_TIT_NM" ).append("\n"); 
		query.append(", '' NOTE_CTNT" ).append("\n"); 
		query.append(", '' CHG_CD" ).append("\n"); 
		query.append(", '' PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", '' EFF_DT" ).append("\n"); 
		query.append(", '' NOTE_CLSS_CD" ).append("\n"); 
		query.append(", '' NOTE_TP_CD" ).append("\n"); 
		query.append(", '' EXP_DT" ).append("\n"); 
		query.append(", '' PRC_CUST_TP_CD" ).append("\n"); 
		query.append(", '' UPD_USR_ID" ).append("\n"); 
		query.append(", '' UPD_DT" ).append("\n"); 
		query.append(", '' ACPT_OFC_CD" ).append("\n"); 
		query.append(", '' ACPT_DT" ).append("\n"); 
		query.append(", '' SRC_INFO_CD" ).append("\n"); 
		query.append(", '' ACPT_USR_ID" ).append("\n"); 
		query.append(", '' NOTE_SEQ" ).append("\n"); 
		query.append(", '' NOTE_CONV_FLG" ).append("\n"); 
		query.append(", '' NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(", '' NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", '' PREV_NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", '' CRE_USR_ID" ).append("\n"); 
		query.append(", '' AMEND_YN" ).append("\n"); 
		query.append(", '' N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(", '' PROP_NO" ).append("\n"); 
		query.append(", '' CON_CHK" ).append("\n"); 
		query.append(", '' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}