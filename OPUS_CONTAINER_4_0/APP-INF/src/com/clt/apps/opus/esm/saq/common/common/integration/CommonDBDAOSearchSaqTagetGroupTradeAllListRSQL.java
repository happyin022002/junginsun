/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonDBDAOSearchSaqTagetGroupTradeAllListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqTagetGroupTradeAllListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade Code search in Target Group
	  * </pre>
	  */
	public CommonDBDAOSearchSaqTagetGroupTradeAllListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqTagetGroupTradeAllListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT         " ).append("\n"); 
		query.append("        TRD_CD AS CODE,  " ).append("\n"); 
		query.append("        TRD_CD AS TEXT   " ).append("\n"); 
		query.append("FROM  SAQ_TGT_GRP_TRD    " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 

	}
}