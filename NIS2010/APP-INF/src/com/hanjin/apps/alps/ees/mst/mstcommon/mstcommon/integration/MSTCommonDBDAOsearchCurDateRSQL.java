/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonDBDAOsearchCurDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.07.09 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MSTCommonDBDAOsearchCurDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT SYSDATE
	  * </pre>
	  */
	public MSTCommonDBDAOsearchCurDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration ").append("\n"); 
		query.append("FileName : MSTCommonDBDAOsearchCurDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') CUR_DATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}