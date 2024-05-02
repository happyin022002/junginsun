/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SCNoteProposalDBDAOPriSpScpNoteGlineCpVOCSQL.java
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

public class SCNoteProposalDBDAOPriSpScpNoteGlineCpVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * guide line copy
	  * 2013.12.12 전윤주 [CHM-201328120] standard note delete amend 기능 추가 - GL copy 시 max seq.를 더해서 key 중복이 발생하지 않도록 로직 추가
	  * </pre>
	  */
	public SCNoteProposalDBDAOPriSpScpNoteGlineCpVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.integration").append("\n"); 
		query.append("FileName : SCNoteProposalDBDAOPriSpScpNoteGlineCpVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SP_SCP_NOTE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	  PROP_NO" ).append("\n"); 
		query.append("	, AMDT_SEQ" ).append("\n"); 
		query.append("	, SVC_SCP_CD" ).append("\n"); 
		query.append("	, NOTE_TP_CD" ).append("\n"); 
		query.append("	, NOTE_SEQ" ).append("\n"); 
		query.append("	, NOTE_TIT_NM" ).append("\n"); 
		query.append("	, NOTE_CLSS_CD" ).append("\n"); 
		query.append("	, DP_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT @[prop_no]		AS PROP_NO     " ).append("\n"); 
		query.append("	 , @[amdt_seq]		AS AMDT_SEQ    " ).append("\n"); 
		query.append("	 , @[svc_scp_cd]	AS SVC_SCP_CD  " ).append("\n"); 
		query.append("	 , 'T'				AS NOTE_TP_CD  " ).append("\n"); 
		query.append("	 , T.NOTE_SEQ		AS NOTE_SEQ    " ).append("\n"); 
		query.append("	 , T.NOTE_TIT_NM	AS NOTE_TIT_NM " ).append("\n"); 
		query.append("	 , 'O'				AS NOTE_CLSS_CD" ).append("\n"); 
		query.append("	 , T.DP_SEQ			AS DP_SEQ      " ).append("\n"); 
		query.append("	 , @[cre_usr_id]	AS CRE_USR_ID  " ).append("\n"); 
		query.append("	 , SYSDATE			AS CRE_DT      " ).append("\n"); 
		query.append("	 , @[upd_usr_id]	AS UPD_USR_ID  " ).append("\n"); 
		query.append("	 , SYSDATE			AS UPD_DT      " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("		 , A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("		 , DENSE_RANK() OVER (PARTITION BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("							  ORDER BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.DP_SEQ, A.NOTE_SEQ)" ).append("\n"); 
		query.append("          + NVL((SELECT  MAX(NOTE_SEQ)" ).append("\n"); 
		query.append("               FROM PRI_SP_SCP_NOTE " ).append("\n"); 
		query.append("              WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                AND NOTE_TP_CD = 'T' --Note 를 Delete Amend 하고 GL을 다시 Copy 하는 경우를 대비하여 AMX Seq+1로 해서 Seq.를 다시 땀" ).append("\n"); 
		query.append("                AND SVC_SCP_CD = @[svc_scp_cd]), 0)  AS NOTE_SEQ " ).append("\n"); 
		query.append("		 , DENSE_RANK() OVER (PARTITION BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.NOTE_SEQ" ).append("\n"); 
		query.append("							  ORDER BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.NOTE_SEQ, B.NOTE_CTNT_SEQ) AS SEQ" ).append("\n"); 
		query.append("		 , A.NOTE_TIT_NM" ).append("\n"); 
		query.append("		 , DENSE_RANK() OVER (PARTITION BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("							  ORDER BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.DP_SEQ, A.NOTE_SEQ) AS DP_SEQ" ).append("\n"); 
		query.append("	  FROM PRI_SG_STND_NOTE A" ).append("\n"); 
		query.append("		 , PRI_SG_STND_NOTE_CTNT B" ).append("\n"); 
		query.append("		 , ( SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("				  , NOTE_HDR_SEQ" ).append("\n"); 
		query.append("				  , EFF_DT" ).append("\n"); 
		query.append("				  , EXP_DT" ).append("\n"); 
		query.append("			   FROM (" ).append("\n"); 
		query.append("				SELECT SVC_SCP_CD" ).append("\n"); 
		query.append("					 , NOTE_HDR_SEQ" ).append("\n"); 
		query.append("					 , EFF_DT" ).append("\n"); 
		query.append("					 , EXP_DT" ).append("\n"); 
		query.append("					 , ROW_NUMBER() OVER (ORDER BY EFF_DT DESC, PRC_CUST_TP_CD ASC) CHECK_VALUE" ).append("\n"); 
		query.append("				  FROM PRI_SG_STND_NOTE_HDR" ).append("\n"); 
		query.append("				 WHERE SVC_SCP_CD	= @[svc_scp_cd]" ).append("\n"); 
		query.append("				   AND (PRC_CUST_TP_CD = @[prc_cust_tp_cd] OR PRC_CUST_TP_CD IS NULL)" ).append("\n"); 
		query.append("				   AND CFM_FLG 		= 'Y'" ).append("\n"); 
		query.append("				   AND TO_DATE(@[eff_dt],'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("				  )" ).append("\n"); 
		query.append("			  WHERE CHECK_VALUE = 1 ) C" ).append("\n"); 
		query.append("	 WHERE B.SVC_SCP_CD 		= A.SVC_SCP_CD" ).append("\n"); 
		query.append("	   AND B.NOTE_HDR_SEQ 		= A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("	   AND B.NOTE_SEQ 			= A.NOTE_SEQ" ).append("\n"); 
		query.append("	   AND B.SVC_SCP_CD 		= C.SVC_SCP_CD" ).append("\n"); 
		query.append("	   AND B.NOTE_HDR_SEQ 		= C.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("	   AND B.SVC_SCP_CD 		= @[svc_scp_cd]" ).append("\n"); 
		query.append("	 ) T" ).append("\n"); 
		query.append(" WHERE T.SEQ = 1" ).append("\n"); 

	}
}