/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCNoteProposalDBDAORsltNoteCtntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
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

public class SCNoteProposalDBDAORsltNoteCtntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteProposalDBDAORsltNoteCtntListVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAORsltNoteCtntListVORSQL").append("\n"); 
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
		query.append("SELECT	A.PROP_NO" ).append("\n"); 
		query.append("	  , A.AMDT_SEQ" ).append("\n"); 
		query.append("	  , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	  , A.NOTE_SEQ" ).append("\n"); 
		query.append("	  , A.NOTE_TP_CD" ).append("\n"); 
		query.append("	  , A.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("	  , A.CHG_CD" ).append("\n"); 
		query.append("	  , A.NOTE_CTNT" ).append("\n"); 
		query.append("	  , CASE WHEN (SELECT COUNT(NOTE_CONV_MAPG_ID) " ).append("\n"); 
		query.append("					 FROM PRI_SC_NOTE_CONV " ).append("\n"); 
		query.append("					WHERE NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID) > 0 THEN '1' ELSE '0' " ).append("\n"); 
		query.append("			  END NOTE_CONV_FLG" ).append("\n"); 
		query.append("	  , A.DP_SEQ" ).append("\n"); 
		query.append("	  , A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	  , (SELECT CASE WHEN (@[amdt_seq] - 1) > -1 THEN NOTE_CONV_MAPG_ID " ).append("\n"); 
		query.append("				ELSE '' END" ).append("\n"); 
		query.append("       	   FROM PRI_SP_SCP_NOTE_CTNT " ).append("\n"); 
		query.append("       	  WHERE PROP_NO		= @[prop_no]" ).append("\n"); 
		query.append("            AND SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("            AND AMDT_SEQ 	= @[amdt_seq] - 1" ).append("\n"); 
		query.append("            AND NOTE_SEQ 	= @[note_seq] " ).append("\n"); 
		query.append("			AND NOTE_TP_CD 	= @[note_tp_cd]" ).append("\n"); 
		query.append("            AND NOTE_CTNT_SEQ = A.NOTE_CTNT_SEQ) PREV_NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	  , A.NOTE_CHG_TP_CD" ).append("\n"); 
		query.append("	  , A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	  , A.SRC_INFO_CD" ).append("\n"); 
		query.append("	  , A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("	  , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("		   FROM PRI_SP_SCP_MN " ).append("\n"); 
		query.append("		  WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("		    AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("		    AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("	  , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        	 ELSE (    " ).append("\n"); 
		query.append("        		   SELECT CASE WHEN B.EFF_DT <= N.EXP_DT THEN TO_CHAR(B.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               				   ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD') END AS EXP_DT" ).append("\n"); 
		query.append("        			 FROM PRI_SP_SCP_MN N" ).append("\n"); 
		query.append("        			WHERE PROP_NO 		= B.PROP_NO " ).append("\n"); 
		query.append("					  AND AMDT_SEQ 		= B.AMDT_SEQ-1 " ).append("\n"); 
		query.append("					  AND SVC_SCP_CD	= B.SVC_SCP_CD ) END EXP_DT" ).append("\n"); 
		query.append("  	  , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_SP_SCP_MN" ).append("\n"); 
		query.append("          WHERE PROP_NO 	= A.PROP_NO" ).append("\n"); 
		query.append("        	AND AMDT_SEQ    = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("        	AND SVC_SCP_CD  = A.SVC_SCP_CD ) BEF_EFF_DT" ).append("\n"); 
		query.append("   	  , (SELECT TO_CHAR(EXP_DT, 'YYYYMMDD') FROM PRI_SP_SCP_MN" ).append("\n"); 
		query.append("      	  WHERE PROP_NO 	= A.PROP_NO" ).append("\n"); 
		query.append("        	AND AMDT_SEQ    = A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("        	AND SVC_SCP_CD  = A.SVC_SCP_CD ) BEF_EXP_DT" ).append("\n"); 
		query.append("   FROM PRI_SP_SCP_NOTE_CTNT A" ).append("\n"); 
		query.append("	  , PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("  WHERE B.PROP_NO 		= A.PROP_NO" ).append("\n"); 
		query.append("    AND B.SVC_SCP_CD 	= A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND B.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("    AND B.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("    AND B.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND A.NOTE_TP_CD 	= @[note_tp_cd]" ).append("\n"); 
		query.append("    AND A.NOTE_SEQ 		= @[note_seq] " ).append("\n"); 
		query.append("	AND A.AMDT_SEQ IN ( @[amdt_seq], @[amdt_seq]-1)" ).append("\n"); 
		query.append("	AND (( A.AMDT_SEQ = @[amdt_seq] AND A.SRC_INFO_CD <> 'ZZ')" ).append("\n"); 
		query.append("		OR ( A.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("				AND  A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("				AND  NOT EXISTS (  SELECT 'x' FROM PRI_SP_SCP_NOTE_CTNT AA" ).append("\n"); 
		query.append("									WHERE AA.PROP_NO			= A.PROP_NO " ).append("\n"); 
		query.append("                					  AND AA.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("                					  AND AA.SVC_SCP_CD			= A.SVC_SCP_CD " ).append("\n"); 
		query.append("                					  AND AA.NOTE_SEQ			= A.NOTE_SEQ" ).append("\n"); 
		query.append("									  AND AA.NOTE_CTNT_SEQ		= A.NOTE_CTNT_SEQ " ).append("\n"); 
		query.append("                					  AND AA.N1ST_CMNC_AMDT_SEQ	= A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("									  AND AA.NOTE_TP_CD			= A.NOTE_TP_CD" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  ORDER BY FIRST_VALUE(A.DP_SEQ) OVER ( PARTITION BY A.NOTE_CTNT_SEQ ORDER BY A.AMDT_SEQ ), A.AMDT_SEQ" ).append("\n"); 

	}
}