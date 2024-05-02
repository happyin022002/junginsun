/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : SCProposalMainDAOPriSpInqRecSearchVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.01.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDAOPriSpInqRecSearchVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriSpInqSearchRecVO 조회 쿼리
	  * </pre>
	  */
	public SCProposalMainDAOPriSpInqRecSearchVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDAOPriSpInqRecSearchVORSQL").append("\n"); 
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
		query.append("SELECT '' SC_NO" ).append("\n"); 
		query.append("	  ,'' PROP_NO" ).append("\n"); 
		query.append("      ,'' AMDT_SEQ" ).append("\n"); 
		query.append("      ,'' CUST_NM" ).append("\n"); 
		query.append("      ,'' REAL_CUST_NM" ).append("\n"); 
		query.append("      ,'' CUST_TP_CD" ).append("\n"); 
		query.append("      ,'' STATUS" ).append("\n"); 
		query.append("      ,'' FILE_DT" ).append("\n"); 
		query.append("      ,'' LGIN_ID" ).append("\n"); 
		query.append("      ,'' USR_NM" ).append("\n"); 
		query.append("      ,'' LGIN_OFC" ).append("\n"); 
		query.append("      ,'' SREP_CD" ).append("\n"); 
		query.append("      ,'' IP_ADDR" ).append("\n"); 
		query.append("      ,'' DL_SCRN" ).append("\n"); 
		query.append("      ,'' OPEN_TIME" ).append("\n"); 
		query.append("      ,'' SCRN_DATE_FROM" ).append("\n"); 
		query.append("      ,'' SCRN_DATE_TO" ).append("\n"); 
		query.append("      ,'' EFF_DATE_FROM" ).append("\n"); 
		query.append("      ,'' EFF_DATE_TO" ).append("\n"); 
		query.append("      ,'' PROP_OFC_CD" ).append("\n"); 
		query.append("	  ,'' S_CUR_TP_CD" ).append("\n"); 
		query.append("      ,'' S_CUST_TP_CD" ).append("\n"); 
		query.append("      ,'' S_SCRN_PROG_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}