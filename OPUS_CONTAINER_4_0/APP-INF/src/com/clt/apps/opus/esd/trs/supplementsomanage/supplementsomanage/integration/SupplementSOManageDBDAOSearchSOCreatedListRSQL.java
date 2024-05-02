/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SupplementSOManageDBDAOSearchSOCreatedListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAOSearchSOCreatedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 생성된 SO 목록을 조회한다.
	  * </pre>
	  */
	public SupplementSOManageDBDAOSearchSOCreatedListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAOSearchSOCreatedListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    A.TRSP_SO_OFC_CTY_CD ," ).append("\n"); 
		query.append("    A.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("    A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    #if($sonumberArr.size() > 0) " ).append("\n"); 
		query.append("    	AND ( " ).append("\n"); 
		query.append("		#foreach( ${key} in ${sonumberArr}) 			" ).append("\n"); 
		query.append("			#if($velocityCount == 1)" ).append("\n"); 
		query.append(" 				( A.TRSP_SO_OFC_CTY_CD =  '${key.trspSoOfcCtyCd}'" ).append("\n"); 
		query.append("					#if(${key.trspSoSeq}!= '')" ).append("\n"); 
		query.append("						AND A.TRSP_SO_SEQ = ${key.trspSoSeq}" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		 	#else " ).append("\n"); 
		query.append(" 				OR ( A.TRSP_SO_OFC_CTY_CD =  '${key.trspSoOfcCtyCd}'" ).append("\n"); 
		query.append("						#if(${key.trspSoSeq} != '')" ).append("\n"); 
		query.append("							AND A.TRSP_SO_SEQ = ${key.trspSoSeq}" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	 	#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	#end " ).append("\n"); 

	}
}