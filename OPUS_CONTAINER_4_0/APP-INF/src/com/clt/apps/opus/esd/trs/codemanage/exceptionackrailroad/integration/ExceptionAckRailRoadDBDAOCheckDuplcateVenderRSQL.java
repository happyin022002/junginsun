/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExceptionAckRailRoadDBDAOCheckDuplcateVenderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionAckRailRoadDBDAOCheckDuplcateVenderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExceptionAckRailRoadDBDAOCheckDuplcateVender
	  * </pre>
	  */
	public ExceptionAckRailRoadDBDAOCheckDuplcateVenderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration ").append("\n"); 
		query.append("FileName : ExceptionAckRailRoadDBDAOCheckDuplcateVenderRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) " ).append("\n"); 
		query.append("FROM TRS_EXPT_ACK_RAIL_VNDR " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if($arr_vndr_seq.size() > 0)" ).append("\n"); 
		query.append("AND VNDR_SEQ IN  (" ).append("\n"); 
		query.append("#foreach($code IN ${arr_vndr_seq})" ).append("\n"); 
		query.append("	#if($velocityCount == 1)" ).append("\n"); 
		query.append("		 '$code'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		,'$code'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}