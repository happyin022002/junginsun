/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueArRoutRnkDBDAOModifyArRoutRnkDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.09.25 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArRoutRnkDBDAOModifyArRoutRnkDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ar_rout_rnk 테이블에서 삭제
	  * </pre>
	  */
	public ReceiveQueueArRoutRnkDBDAOModifyArRoutRnkDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueArRoutRnkDBDAOModifyArRoutRnkDSQL").append("\n"); 
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
		query.append("DELETE FROM	ar_rout_rnk" ).append("\n"); 
		query.append("WHERE 'Y' =	'Y'" ).append("\n"); 

	}
}