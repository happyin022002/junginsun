/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.11.19 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 본문을 복사하여 등록
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq_copy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd_copy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SG_STND_NOTE_CTNT (" ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("NOTE_HDR_SEQ," ).append("\n"); 
		query.append("NOTE_SEQ," ).append("\n"); 
		query.append("NOTE_CTNT_SEQ," ).append("\n"); 
		query.append("NOTE_CTNT," ).append("\n"); 
		query.append("NOTE_CONV_FLG," ).append("\n"); 
		query.append("DP_SEQ," ).append("\n"); 
		query.append("NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[svc_scp_cd]" ).append("\n"); 
		query.append(",	@[note_hdr_seq]" ).append("\n"); 
		query.append("--,	NOTE_SEQ" ).append("\n"); 
		query.append("--,	NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("ORDER BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.NOTE_SEQ) AS NOTE_SEQ" ).append("\n"); 
		query.append(", DENSE_RANK() OVER (PARTITION BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.NOTE_SEQ" ).append("\n"); 
		query.append("ORDER BY A.SVC_SCP_CD, A.NOTE_HDR_SEQ, A.NOTE_SEQ, B.NOTE_CTNT_SEQ) AS NOTE_CTNT_SEQ" ).append("\n"); 
		query.append(",	B.NOTE_CTNT" ).append("\n"); 
		query.append(",	B.NOTE_CONV_FLG" ).append("\n"); 
		query.append(",	B.DP_SEQ" ).append("\n"); 
		query.append(",	SYS_GUID()" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("FROM  PRI_SG_STND_NOTE A" ).append("\n"); 
		query.append(",PRI_SG_STND_NOTE_CTNT B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd_copy]" ).append("\n"); 
		query.append("AND   A.NOTE_HDR_SEQ = @[note_hdr_seq_copy]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("AND   A.NOTE_HDR_SEQ = B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("AND   A.NOTE_SEQ = B.NOTE_SEQ" ).append("\n"); 

	}
}