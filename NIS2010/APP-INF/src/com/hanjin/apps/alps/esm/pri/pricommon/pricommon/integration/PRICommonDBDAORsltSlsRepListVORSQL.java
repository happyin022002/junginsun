/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltSlsRepListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.11.18 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Byeon Young Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSlsRepListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRICommonDBDAORsltSlsRepListVORSQL
	  * </pre>
	  */
	public PRICommonDBDAORsltSlsRepListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSlsRepListVORSQL").append("\n"); 
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
		query.append("srep_cd cd," ).append("\n"); 
		query.append("srep_nm nm" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("mdm_sls_rep" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("srep_sts_cd = 'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("srep_cd" ).append("\n"); 

	}
}