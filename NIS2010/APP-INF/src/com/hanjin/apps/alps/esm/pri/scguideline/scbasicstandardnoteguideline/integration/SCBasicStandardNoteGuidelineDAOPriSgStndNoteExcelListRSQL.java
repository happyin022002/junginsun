/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.04.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNGMIN CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 엑셀다운로드 리스트
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteExcelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.integration ").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteExcelListRSQL").append("\n"); 
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
		query.append("SELECT B.SVC_SCP_CD" ).append("\n"); 
		query.append("     , B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("     , B.NOTE_SEQ" ).append("\n"); 
		query.append("     , B.NOTE_TIT_NM" ).append("\n"); 
		query.append("     , A.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("     , A.NOTE_CTNT" ).append("\n"); 
		query.append("     , A.NOTE_CONV_FLG" ).append("\n"); 
		query.append("  FROM PRI_SG_STND_NOTE_CTNT A" ).append("\n"); 
		query.append("     , PRI_SG_STND_NOTE B" ).append("\n"); 
		query.append(" WHERE A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND A.NOTE_HDR_SEQ = B.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("   AND A.NOTE_SEQ = B.NOTE_SEQ" ).append("\n"); 
		query.append("   AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND A.NOTE_HDR_SEQ = @[note_hdr_seq]" ).append("\n"); 
		query.append(" ORDER BY B.DP_SEQ, A.DP_SEQ" ).append("\n"); 

	}
}