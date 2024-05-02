/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAORsltPriSgStndNoteHdrCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.01 이승준
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

public class SCBasicStandardNoteGuidelineDAORsltPriSgStndNoteHdrCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltPriSgStndNoteHdrCopyVO 생성용 Dummy SQL
	  * </pre>
	  */
	public SCBasicStandardNoteGuidelineDAORsltPriSgStndNoteHdrCopyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration").append("\n"); 
		query.append("FileName : SCBasicStandardNoteGuidelineDAORsltPriSgStndNoteHdrCopyVORSQL").append("\n"); 
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
		query.append("'' AS UPD_DT," ).append("\n"); 
		query.append("'' AS NOTE_HDR_SEQ_COPY," ).append("\n"); 
		query.append("'' AS SVC_SCP_CD," ).append("\n"); 
		query.append("'' AS CRE_DT," ).append("\n"); 
		query.append("'' AS NOTE_NM," ).append("\n"); 
		query.append("'' AS CFM_FLG," ).append("\n"); 
		query.append("'' AS PRC_CUST_TP_CD_COPY," ).append("\n"); 
		query.append("'' AS EFF_DT," ).append("\n"); 
		query.append("'' AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS NOTE_HDR_SEQ," ).append("\n"); 
		query.append("'' AS SVC_SCP_CD_COPY," ).append("\n"); 
		query.append("'' AS CFM_USR_ID," ).append("\n"); 
		query.append("'' AS EXP_DT," ).append("\n"); 
		query.append("'' AS NOTE_REF_YR," ).append("\n"); 
		query.append("'' AS PRC_CUST_TP_CD," ).append("\n"); 
		query.append("'' AS UPD_USR_ID," ).append("\n"); 
		query.append("'' AS NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("'' AS NOTE_SEQ," ).append("\n"); 
		query.append("'' AS NOTE_CTNT_SEQ," ).append("\n"); 
		query.append("'' AS EFF_DT_HIDDEN," ).append("\n"); 
		query.append("'' AS EXP_DT_HIDDEN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}