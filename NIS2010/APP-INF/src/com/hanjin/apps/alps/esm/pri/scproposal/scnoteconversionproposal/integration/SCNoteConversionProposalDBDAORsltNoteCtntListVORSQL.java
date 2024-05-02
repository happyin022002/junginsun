/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAORsltNoteCtntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.06 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAORsltNoteCtntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPECIAL NOTE의 DETAIL정보를 조회한다.
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAORsltNoteCtntListVORSQL(){
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
		query.append("SELECT  A.PROP_NO" ).append("\n"); 
		query.append(", A.AMDT_SEQ" ).append("\n"); 
		query.append(", A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.NOTE_SEQ" ).append("\n"); 
		query.append(", A.NOTE_TP_CD" ).append("\n"); 
		query.append(", A.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(", A.CHG_CD" ).append("\n"); 
		query.append(", A.NOTE_CTNT" ).append("\n"); 
		query.append(", A.NOTE_CONV_FLG" ).append("\n"); 
		query.append(", A.DP_SEQ" ).append("\n"); 
		query.append(", A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", A.NOTE_CHG_TP_CD" ).append("\n"); 
		query.append(", A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append(", A.SRC_INFO_CD" ).append("\n"); 
		query.append(", B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append(", B.EFF_DT" ).append("\n"); 
		query.append(", B.EXP_DT" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_NOTE_CTNT A," ).append("\n"); 
		query.append("PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.NOTE_TP_CD = @[note_tp_cd]" ).append("\n"); 
		query.append("AND A.NOTE_SEQ = @[note_seq]" ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAORsltNoteCtntListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}