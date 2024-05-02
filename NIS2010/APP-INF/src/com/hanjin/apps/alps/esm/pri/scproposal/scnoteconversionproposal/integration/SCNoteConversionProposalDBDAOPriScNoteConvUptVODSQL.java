/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvUptVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.12.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvUptVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 다음 Seq Conversion 삭제
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvUptVODSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvUptVODSQL").append("\n"); 
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
		query.append("DELETE FROM     PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append("WHERE    NOTE_CONV_MAPG_ID IN" ).append("\n"); 
		query.append("(SELECT   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] + 1" ).append("\n"); 
		query.append("AND NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("AND NOT (N1ST_CMNC_AMDT_SEQ = @[amdt_seq] + 1 AND SRC_INFO_CD = 'NW')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] + 1" ).append("\n"); 
		query.append("AND NOT (N1ST_CMNC_AMDT_SEQ = @[amdt_seq] + 1 AND SRC_INFO_CD = 'NW')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("WHERE    PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND AMDT_SEQ = @[amdt_seq] + 1" ).append("\n"); 
		query.append("AND NOT (N1ST_CMNC_AMDT_SEQ = @[amdt_seq] + 1 AND SRC_INFO_CD = 'NW'))" ).append("\n"); 

	}
}