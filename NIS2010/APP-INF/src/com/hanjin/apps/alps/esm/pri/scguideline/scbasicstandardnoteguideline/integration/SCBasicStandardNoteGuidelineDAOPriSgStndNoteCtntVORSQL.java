/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.11.20 이승준
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

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVORSQL(){
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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.SVC_SCP_CD," ).append("\n"); 
		query.append("A.NOTE_HDR_SEQ," ).append("\n"); 
		query.append("A.NOTE_SEQ," ).append("\n"); 
		query.append("A.NOTE_CTNT_SEQ," ).append("\n"); 
		query.append("A.NOTE_CTNT," ).append("\n"); 
		query.append("A.NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("A.DP_SEQ," ).append("\n"); 
		query.append("A.NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("--A.CRE_USR_ID," ).append("\n"); 
		query.append("(SELECT USR_NM||' / '||OFC_CD FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("(SELECT DECODE(COUNT(NOTE_CONV_MAPG_ID),0,0,1)" ).append("\n"); 
		query.append("FROM PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID ) NOTE_CONV_FLG" ).append("\n"); 
		query.append("FROM PRI_SG_STND_NOTE_CTNT A" ).append("\n"); 
		query.append("WHERE	A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	    A.NOTE_HDR_SEQ = @[note_hdr_seq]" ).append("\n"); 
		query.append("AND	    A.NOTE_SEQ = @[note_seq]" ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ" ).append("\n"); 

	}
}