/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCNoteProposalDBDAORsltNoteHistoryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAORsltNoteHistoryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special Note Title History 정보 조회
	  * </pre>
	  */
	public SCNoteProposalDBDAORsltNoteHistoryListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAORsltNoteHistoryListVORSQL").append("\n"); 
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
		query.append("#if (${con_chk} == '1')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("	 , A.AMDT_SEQ" ).append("\n"); 
		query.append("	 , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	 , A.NOTE_TP_CD" ).append("\n"); 
		query.append("	 , A.NOTE_SEQ" ).append("\n"); 
		query.append("	 , A.NOTE_TIT_NM" ).append("\n"); 
		query.append("	 , A.NOTE_CLSS_CD" ).append("\n"); 
		query.append("	 , A.DP_SEQ" ).append("\n"); 
		query.append("	 , (" ).append("\n"); 
		query.append("        SELECT CASE WHEN SUM( CASE WHEN SRC_INFO_CD != 'AD' THEN 1 ELSE 0 END ) = 0 THEN 'AD'" ).append("\n"); 
		query.append("            	    WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  NOT IN ('NW','GC','GM','PC','PM') " ).append("\n"); 
		query.append("				 	  			   THEN 1 ELSE 0 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("				    WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  IN ('NW','GC','GM','PC','PM') " ).append("\n"); 
		query.append("				 	  			   THEN 0 ELSE 1 END ) = 0 THEN 'NW'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              	 	WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ != A.AMDT_SEQ" ).append("\n"); 
		query.append("				 	  			   THEN 0 ELSE 1 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            	    ELSE '' END SRC_INFO_CD" ).append("\n"); 
		query.append("          FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("         WHERE PROP_NO 		= A.PROP_NO" ).append("\n"); 
		query.append("           AND AMDT_SEQ 	= A.AMDT_SEQ" ).append("\n"); 
		query.append("           AND SVC_SCP_CD 	= A.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND NOTE_SEQ		= A.NOTE_SEQ" ).append("\n"); 
		query.append("		   AND NOTE_TP_CD 	= A.NOTE_TP_CD" ).append("\n"); 
		query.append("		   AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("        ) SRC_INFO_CD" ).append("\n"); 
		query.append("	 , A.UPD_USR_ID" ).append("\n"); 
		query.append("	 , A.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_NOTE A" ).append("\n"); 
		query.append("	 , PRI_SP_SCP_MN  B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO     	= B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ      	= B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD    	= B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.NOTE_TP_CD = @[note_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND EXISTS ( SELECT 'X' FROM PRI_SP_SCP_NOTE_CTNT DTL" ).append("\n"); 
		query.append("                 WHERE PROP_NO 		= A.PROP_NO " ).append("\n"); 
		query.append("				   AND AMDT_SEQ 	= A.AMDT_SEQ  " ).append("\n"); 
		query.append("				   AND SVC_SCP_CD 	= A.SVC_SCP_CD  " ).append("\n"); 
		query.append("				   AND NOTE_SEQ 	= A.NOTE_SEQ  " ).append("\n"); 
		query.append("				   AND NOTE_TP_CD 	= A.NOTE_TP_CD " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.DP_SEQ	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("	 , A.AMDT_SEQ" ).append("\n"); 
		query.append("	 , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	 , A.NOTE_TP_CD" ).append("\n"); 
		query.append("	 , A.NOTE_SEQ" ).append("\n"); 
		query.append("	 , A.NOTE_TIT_NM" ).append("\n"); 
		query.append("	 , A.NOTE_CLSS_CD" ).append("\n"); 
		query.append("	 , A.DP_SEQ" ).append("\n"); 
		query.append("	 , (" ).append("\n"); 
		query.append("		SELECT CASE WHEN SUM( CASE WHEN SRC_INFO_CD != 'AD' THEN 1 ELSE 0 END ) = 0 THEN 'AD'" ).append("\n"); 
		query.append("					WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  NOT IN ('NW','GC','GM','PC','PM')" ).append("\n"); 
		query.append("						THEN 1 ELSE 0 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("					WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  IN ('NW','GC','GM','PC','PM')" ).append("\n"); 
		query.append("						THEN 0 ELSE 1 END ) = 0 THEN 'NW'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              	 	WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ != A.AMDT_SEQ" ).append("\n"); 
		query.append("				 	  	THEN 0 ELSE 1 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					ELSE '' END SRC_INFO_CD" ).append("\n"); 
		query.append("		  FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("		 WHERE PROP_NO 		= A.PROP_NO" ).append("\n"); 
		query.append("		   AND AMDT_SEQ 	= A.AMDT_SEQ" ).append("\n"); 
		query.append("		   AND SVC_SCP_CD 	= A.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND NOTE_SEQ		= A.NOTE_SEQ" ).append("\n"); 
		query.append("		   AND NOTE_TP_CD 	= A.NOTE_TP_CD" ).append("\n"); 
		query.append("		   AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("	   ) SRC_INFO_CD" ).append("\n"); 
		query.append("	 , A.UPD_USR_ID" ).append("\n"); 
		query.append("	 , A.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_NOTE A" ).append("\n"); 
		query.append("	 , PRI_SP_SCP_MN  B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO		= B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ		= B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD		= B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.PROP_NO		= @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ		= @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD		= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.NOTE_TP_CD		= @[note_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND EXISTS ( SELECT 'X' FROM PRI_SP_SCP_NOTE_CTNT " ).append("\n"); 
		query.append("                 WHERE PROP_NO 		= A.PROP_NO " ).append("\n"); 
		query.append("				   AND AMDT_SEQ 	= A.AMDT_SEQ  " ).append("\n"); 
		query.append("				   AND SVC_SCP_CD 	= A.SVC_SCP_CD  " ).append("\n"); 
		query.append("				   AND NOTE_SEQ 	= A.NOTE_SEQ  " ).append("\n"); 
		query.append("				   AND NOTE_TP_CD 	= A.NOTE_TP_CD " ).append("\n"); 
		query.append("				   AND N1ST_CMNC_AMDT_SEQ = AMDT_SEQ " ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append(" ORDER BY A.DP_SEQ" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}