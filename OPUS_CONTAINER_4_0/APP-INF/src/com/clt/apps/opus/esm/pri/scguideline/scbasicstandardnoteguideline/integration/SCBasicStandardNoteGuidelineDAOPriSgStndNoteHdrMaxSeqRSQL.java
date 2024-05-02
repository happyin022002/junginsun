/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrMaxSeqRSQL.java
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노트 헤더 시퀀스 최대값 조회
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrMaxSeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrMaxSeqRSQL").append("\n"); 
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
		query.append("select (NVL(Max(note_hdr_seq),0)+1) as note_hdr_seq" ).append("\n"); 
		query.append("from pri_sg_stnd_note_hdr" ).append("\n"); 
		query.append("where	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 

	}
}