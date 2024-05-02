/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFANoteProposalDBDAOPriRpScpSpecNoteCtntInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAOPriRpScpSpecNoteCtntInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry 조회
	  * </pre>
	  */
	public RFANoteProposalDBDAOPriRpScpSpecNoteCtntInquiryListVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.integration").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAOPriRpScpSpecNoteCtntInquiryListVORSQL").append("\n"); 
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
		query.append("SELECT  A.PROP_NO" ).append("\n"); 
		query.append("	  , A.AMDT_SEQ" ).append("\n"); 
		query.append("	  , A.SVC_SCP_CD" ).append("\n"); 
		query.append("	  , A.NOTE_SEQ" ).append("\n"); 
		query.append("	  , A.NOTE_TP_CD" ).append("\n"); 
		query.append("	  , A.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("	  , A.NOTE_CTNT" ).append("\n"); 
		query.append("	  , A.NOTE_CONV_FLG" ).append("\n"); 
		query.append("	  , A.DP_SEQ" ).append("\n"); 
		query.append("	  , A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("	  , A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	  , A.SRC_INFO_CD" ).append("\n"); 
		query.append("	  , A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	  , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("		   FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("		  WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("		    AND AMDT_SEQ = A.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("		    AND SVC_SCP_CD = A.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("	  , CASE WHEN A.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        	 ELSE (    " ).append("\n"); 
		query.append("        		   SELECT CASE WHEN B.EFF_DT <= N.EXP_DT THEN TO_CHAR(B.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("               				   ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("               			  END AS EXP_DT" ).append("\n"); 
		query.append("        			 FROM PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("        			WHERE PROP_NO = B.PROP_NO AND AMDT_SEQ = B.AMDT_SEQ-1 AND SVC_SCP_CD = B.SVC_SCP_CD ) " ).append("\n"); 
		query.append(" 		END  EXP_DT" ).append("\n"); 
		query.append(" 	 , A.ACPT_OFC_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(A.ACPT_DT, 'YYYYMMDD') ACPT_DT" ).append("\n"); 
		query.append("	 , (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.ACPT_USR_ID)||' / '||A.ACPT_OFC_CD ACPT_USR_NM" ).append("\n"); 
		query.append("   FROM PRI_RP_SCP_NOTE_CTNT A," ).append("\n"); 
		query.append("        PRI_RP_SCP_MN B" ).append("\n"); 
		query.append("  WHERE B.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("    AND B.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND B.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("    AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("    AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    AND A.NOTE_TP_CD = @[note_tp_cd]" ).append("\n"); 
		query.append("    AND A.NOTE_SEQ = @[note_seq] " ).append("\n"); 
		query.append("	AND A.SRC_INFO_CD <> 'AD'  " ).append("\n"); 
		query.append("  ORDER BY A.DP_SEQ" ).append("\n"); 

	}
}