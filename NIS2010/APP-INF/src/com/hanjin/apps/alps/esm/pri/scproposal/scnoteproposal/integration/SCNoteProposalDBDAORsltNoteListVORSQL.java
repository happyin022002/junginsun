/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCNoteProposalDBDAORsltNoteListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteProposalDBDAORsltNoteListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.05.02 전윤주 [CHM-201324517] Amend Seq 0 일 때 contents가 NW 로 인식이 안되어 DP_SEQ가 저장되지 않는 현상 수정
	  * (CASE WHEN A.AMDT_SEQ >= 0 ) 로 등호 표시 추가
	  * 2013.12.12 전윤주 [CHM-201328120] standard note delete amend 기능 추가 - 신규 copy G/L이 동시에 존재하는 경우가 있어 고른 정렬을 위해 order by 절에 추가
	  * MASTER 색상처리: 순차적으로 진행
	  * 
	  * 1) WHEN SUM( CASE WHEN SRC_INFO_CD != 'AD' THEN 1 ELSE 0 END ) = 0 
	  *     THEN 'AD'
	  * : 줄긋고 빨간색, 수정불가
	  *             	 
	  * 2) WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  NOT IN ('NW','GC','GM','PC','PM') 
	  *     THEN 1 ELSE 0 END ) > 0 THEN 'AM'
	  * : 빨간색, 수정불가
	  * 
	  * 3) WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  IN ('NW','GC','GM','PC','PM') 
	  *     THEN 0 ELSE 1 END ) = 0 THEN 'NW'
	  * : 빨간색, 수정가능
	  * 
	  * 4) WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ != A.AMDT_SEQ
	  *     THEN 0 ELSE 1 END ) > 0 THEN 'AM'
	  * : 빨간색, 수정불가
	  * 
	  * 5) ELSE '' 
	  * : 검정색, 수정불가
	  * </pre>
	  */
	public SCNoteProposalDBDAORsltNoteListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAORsltNoteListVORSQL").append("\n"); 
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
		query.append("SELECT A.PROP_NO" ).append("\n"); 
		query.append("     , A.AMDT_SEQ" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.NOTE_TP_CD" ).append("\n"); 
		query.append("     , A.NOTE_SEQ" ).append("\n"); 
		query.append("     , A.NOTE_TIT_NM" ).append("\n"); 
		query.append("     , A.NOTE_CLSS_CD" ).append("\n"); 
		query.append("     , A.DP_SEQ" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            CASE WHEN SUM( CASE WHEN SRC_INFO_CD != 'AD' THEN 1 ELSE 0 END ) = 0 THEN 'AD'" ).append("\n"); 
		query.append("            	 WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  NOT IN ('NW','GC','GM','PC','PM') " ).append("\n"); 
		query.append("				 	  			THEN 1 ELSE 0 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("				 WHEN SUM( CASE WHEN A.AMDT_SEQ >= 0 AND N1ST_CMNC_AMDT_SEQ = A.AMDT_SEQ AND SRC_INFO_CD  IN ('NW','GC','GM','PC','PM') " ).append("\n"); 
		query.append("				 	  			THEN 0 ELSE 1 END ) = 0 THEN 'NW'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              	 WHEN SUM( CASE WHEN A.AMDT_SEQ > 0 AND N1ST_CMNC_AMDT_SEQ != A.AMDT_SEQ" ).append("\n"); 
		query.append("				 	  			THEN 0 ELSE 1 END ) > 0 THEN 'AM'" ).append("\n"); 
		query.append("            	 ELSE '' " ).append("\n"); 
		query.append("			END SRC_INFO_CD" ).append("\n"); 
		query.append("        FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("        WHERE PROP_NO 	= A.PROP_NO" ).append("\n"); 
		query.append("        AND AMDT_SEQ 	= A.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SVC_SCP_CD 	= A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND NOTE_SEQ	= A.NOTE_SEQ" ).append("\n"); 
		query.append("		AND NOTE_TP_CD 	= A.NOTE_TP_CD" ).append("\n"); 
		query.append("     ) SRC_INFO_CD" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT DECODE(COUNT(AMDT_SEQ), 0, 'N', 'Y')" ).append("\n"); 
		query.append("        FROM PRI_SP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("        WHERE PROP_NO 	= A.PROP_NO" ).append("\n"); 
		query.append("        AND AMDT_SEQ 	= A.AMDT_SEQ - 1" ).append("\n"); 
		query.append("        AND SVC_SCP_CD 	= A.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND NOTE_SEQ	= A.NOTE_SEQ" ).append("\n"); 
		query.append("		AND NOTE_TP_CD 	= A.NOTE_TP_CD" ).append("\n"); 
		query.append("     ) DP_FIX_FLG" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM PRI_SP_SCP_NOTE A" ).append("\n"); 
		query.append("     , PRI_SP_SCP_MN  B" ).append("\n"); 
		query.append(" WHERE A.PROP_NO     	= B.PROP_NO" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ      	= B.AMDT_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD    	= B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.PROP_NO 		= @[prop_no]" ).append("\n"); 
		query.append("   AND A.AMDT_SEQ 		= @[amdt_seq]" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD 	= @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.NOTE_TP_CD 	= @[note_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND EXISTS ( SELECT 'X' FROM PRI_SP_SCP_NOTE_CTNT DTL" ).append("\n"); 
		query.append("                 WHERE PROP_NO 		= A.PROP_NO " ).append("\n"); 
		query.append("				   AND AMDT_SEQ 	= A.AMDT_SEQ  " ).append("\n"); 
		query.append("				   AND SVC_SCP_CD 	= A.SVC_SCP_CD  " ).append("\n"); 
		query.append("				   AND NOTE_SEQ 	= A.NOTE_SEQ  " ).append("\n"); 
		query.append("				   AND NOTE_TP_CD 	= A.NOTE_TP_CD " ).append("\n"); 
		query.append("             	   AND (( SELECT LGCY_IF_FLG " ).append("\n"); 
		query.append("							FROM PRI_SP_MN " ).append("\n"); 
		query.append("						   WHERE PROP_NO = A.PROP_NO " ).append("\n"); 
		query.append("							 AND AMDT_SEQ = A.AMDT_SEQ ) = 'N' OR SRC_INFO_CD <> 'AD' ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.DP_SEQ, 9" ).append("\n"); 

	}
}