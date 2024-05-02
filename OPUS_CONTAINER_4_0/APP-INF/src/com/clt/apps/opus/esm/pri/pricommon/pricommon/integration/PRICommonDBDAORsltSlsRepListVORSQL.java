/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDBDAORsltSlsRepListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.02.21 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
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
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    srep_cd cd," ).append("\n"); 
		query.append("    srep_nm nm" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    mdm_sls_rep" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("    srep_cd" ).append("\n"); 

	}
}