/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendDBDAOSearchEdi324CurrnetDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.02.17 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi324send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOSearchEdi324CurrnetDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi_snd_id을 만들기 위해서 현재 날짜를 가져온다.
	  * </pre>
	  */
	public Edi324SendDBDAOSearchEdi324CurrnetDayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi324send.integration ").append("\n"); 
		query.append("FileName : Edi324SendDBDAOSearchEdi324CurrnetDayRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') from DUAL" ).append("\n"); 

	}
}