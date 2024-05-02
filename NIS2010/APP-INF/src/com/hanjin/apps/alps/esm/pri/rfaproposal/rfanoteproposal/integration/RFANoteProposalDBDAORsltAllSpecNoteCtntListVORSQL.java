/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFANoteProposalDBDAORsltAllSpecNoteCtntListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteProposalDBDAORsltAllSpecNoteCtntListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일괄 승인(Summary)에서 Special Note List 조회
	  * * History
	  *   2015.10.28 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선 Request by SELCMU/김현경
	  * </pre>
	  */
	public RFANoteProposalDBDAORsltAllSpecNoteCtntListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteproposal.integration").append("\n"); 
		query.append("FileName : RFANoteProposalDBDAORsltAllSpecNoteCtntListVORSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM   (SELECT	C.PROP_NO" ).append("\n"); 
		query.append("          , C.AMDT_SEQ" ).append("\n"); 
		query.append("          , C.SVC_SCP_CD" ).append("\n"); 
		query.append("          , CASE" ).append("\n"); 
		query.append("              WHEN (C.AMDT_SEQ != C.N1ST_CMNC_AMDT_SEQ AND C.AMDT_SEQ > 0 AND C.AMDT_SEQ != @[amdt_seq]-1) THEN 'N'" ).append("\n"); 
		query.append("              ELSE 'Y'" ).append("\n"); 
		query.append("            END AS DISPLAY_YN" ).append("\n"); 
		query.append("          , C.NOTE_SEQ" ).append("\n"); 
		query.append("          , C.NOTE_TP_CD" ).append("\n"); 
		query.append("          , C.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("          , C.NOTE_CTNT" ).append("\n"); 
		query.append("          , C.NOTE_CONV_FLG" ).append("\n"); 
		query.append("          , C.DP_SEQ" ).append("\n"); 
		query.append("          , C.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("          , C.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("          , C.SRC_INFO_CD" ).append("\n"); 
		query.append("          , C.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("          , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("               FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("              WHERE PROP_NO = C.PROP_NO " ).append("\n"); 
		query.append("                AND AMDT_SEQ = C.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("                AND SVC_SCP_CD = C.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("          , CASE WHEN C.AMDT_SEQ = @[amdt_seq] THEN TO_CHAR(B.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                 ELSE (    " ).append("\n"); 
		query.append("                       SELECT CASE WHEN B.EFF_DT <= N.EXP_DT THEN TO_CHAR(B.EFF_DT - 1,'YYYYMMDD')" ).append("\n"); 
		query.append("                                   ELSE TO_CHAR(N.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                              END AS EXP_DT" ).append("\n"); 
		query.append("                         FROM PRI_RP_SCP_MN N" ).append("\n"); 
		query.append("                        WHERE PROP_NO = B.PROP_NO AND AMDT_SEQ = B.AMDT_SEQ-1 AND SVC_SCP_CD = B.SVC_SCP_CD ) " ).append("\n"); 
		query.append("            END  EXP_DT" ).append("\n"); 
		query.append("          , (SELECT TO_CHAR(EFF_DT, 'YYYYMMDD') FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("              WHERE PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                AND AMDT_SEQ    = C.AMDT_SEQ - 1" ).append("\n"); 
		query.append("                AND SVC_SCP_CD  = C.SVC_SCP_CD ) BEF_EFF_DT" ).append("\n"); 
		query.append("          , (SELECT TO_CHAR(EXP_DT, 'YYYYMMDD') FROM PRI_RP_SCP_MN" ).append("\n"); 
		query.append("              WHERE PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("                AND AMDT_SEQ    = C.AMDT_SEQ - 1" ).append("\n"); 
		query.append("                AND SVC_SCP_CD  = C.SVC_SCP_CD ) BEF_EXP_DT" ).append("\n"); 
		query.append("       FROM PRI_RP_SCP_NOTE A," ).append("\n"); 
		query.append("            PRI_RP_SCP_MN B," ).append("\n"); 
		query.append("            PRI_RP_SCP_NOTE_CTNT C" ).append("\n"); 
		query.append("      WHERE A.PROP_NO     = B.PROP_NO" ).append("\n"); 
		query.append("        AND A.AMDT_SEQ      = B.AMDT_SEQ" ).append("\n"); 
		query.append("        AND A.SVC_SCP_CD    = B.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND B.PROP_NO       = C.PROP_NO" ).append("\n"); 
		query.append("        AND B.SVC_SCP_CD    = C.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND A.NOTE_TP_CD    = C.NOTE_TP_CD" ).append("\n"); 
		query.append("        AND A.NOTE_SEQ      = C.NOTE_SEQ" ).append("\n"); 
		query.append("        AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("    #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("        AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        AND A.NOTE_TP_CD = @[note_tp_cd]" ).append("\n"); 
		query.append("        AND C.AMDT_SEQ IN ( @[amdt_seq], @[amdt_seq] -1 )" ).append("\n"); 
		query.append("        AND ( C.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("            OR ( C.AMDT_SEQ = @[amdt_seq]-1" ).append("\n"); 
		query.append("                    AND  C.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                    AND  NOT EXISTS (  SELECT 'x' FROM PRI_RP_SCP_NOTE_CTNT AA" ).append("\n"); 
		query.append("                                        WHERE AA.PROP_NO			= C.PROP_NO " ).append("\n"); 
		query.append("                                          AND AA.AMDT_SEQ			= @[amdt_seq]" ).append("\n"); 
		query.append("                                          AND AA.SVC_SCP_CD			= C.SVC_SCP_CD " ).append("\n"); 
		query.append("                                          AND AA.NOTE_SEQ			= C.NOTE_SEQ" ).append("\n"); 
		query.append("                                          AND AA.NOTE_CTNT_SEQ		= C.NOTE_CTNT_SEQ " ).append("\n"); 
		query.append("                                          AND AA.NOTE_TP_CD			= C.NOTE_TP_CD" ).append("\n"); 
		query.append("                                          AND AA.N1ST_CMNC_AMDT_SEQ	= C.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("      ORDER BY FIRST_VALUE(C.DP_SEQ) OVER ( PARTITION BY C.NOTE_CTNT_SEQ ORDER BY C.AMDT_SEQ ), C.AMDT_SEQ" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE DISPLAY_YN = 'Y' -- 조회되는 데이터 중 승인이 필요한 초기 데이터나 amend 정보만을 조회하기 위한 플래그" ).append("\n"); 

	}
}