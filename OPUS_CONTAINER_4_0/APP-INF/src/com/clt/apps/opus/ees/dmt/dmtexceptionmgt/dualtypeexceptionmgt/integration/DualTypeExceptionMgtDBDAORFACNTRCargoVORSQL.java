/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAORFACNTRCargoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAORFACNTRCargoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAP을 VO로 변경
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAORFACNTRCargoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration ").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAORFACNTRCargoVORSQL").append("\n"); 
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
		query.append("SELECT '' RFACNTR_CARGO_CODE" ).append("\n"); 
		query.append("	, '' RFACNTR_CARGO_DESC" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}