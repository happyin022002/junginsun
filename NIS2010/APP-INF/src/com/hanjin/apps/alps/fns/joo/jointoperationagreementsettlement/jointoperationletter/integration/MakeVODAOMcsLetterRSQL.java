/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MakeVODAOMcsLetterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.09 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOMcsLetterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVODAOMcsLetterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : MakeVODAOMcsLetterRSQL").append("\n"); 
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
		query.append("SELECT      ''JOINT_OPERATION_LETTER_TEMPLAT ," ).append("\n"); 
		query.append("''OFC_CD                         ," ).append("\n"); 
		query.append("''JO_TMPLT_NO                    ," ).append("\n"); 
		query.append("''JO_LTR_TP_CD                   ," ).append("\n"); 
		query.append("''OFC_ADDR                       ," ).append("\n"); 
		query.append("''N1ST_STMT_CTNT                 ," ).append("\n"); 
		query.append("''N2ND_STMT_CTNT                 ," ).append("\n"); 
		query.append("''N3RD_STMT_CTNT                 ," ).append("\n"); 
		query.append("''SIG_STMT_CTNT                  ," ).append("\n"); 
		query.append("''CRE_DT                         ," ).append("\n"); 
		query.append("''CRE_USR_ID                     ," ).append("\n"); 
		query.append("''UPD_DT                         ," ).append("\n"); 
		query.append("''UPD_USR_ID                     ," ).append("\n"); 
		query.append("''CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("''BANK_STMT_CTNT" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}