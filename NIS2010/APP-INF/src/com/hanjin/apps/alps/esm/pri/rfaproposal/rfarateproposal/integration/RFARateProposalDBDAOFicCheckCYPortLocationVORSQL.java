/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFARateProposalDBDAOFicCheckCYPortLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.06.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAOFicCheckCYPortLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY Port인지 확인 하는 화면을 위한 parameter VO
	  * </pre>
	  */
	public RFARateProposalDBDAOFicCheckCYPortLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAOFicCheckCYPortLocationVORSQL").append("\n"); 
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
		query.append("SELECT '' AS PROP_NO" ).append("\n"); 
		query.append("	, '' AS AMDT_SEQ" ).append("\n"); 
		query.append("	, '' AS SVC_SCP_CD" ).append("\n"); 
		query.append("	, '' AS LOC_CD" ).append("\n"); 
		query.append("	, '' AS LOC_TYPE_CD" ).append("\n"); 
		query.append("	, '' AS ORG_DEST_TP_CD " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}