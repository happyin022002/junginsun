/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VODAOVvdSkdCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.27 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VODAOVvdSkdCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VvdSkdCond VO생성
	  * </pre>
	  */
	public VODAOVvdSkdCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.vo").append("\n"); 
		query.append("FileName : VODAOVvdSkdCondRSQL").append("\n"); 
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
		query.append("    '' VSL_CD" ).append("\n"); 
		query.append("  , '' SKD_VOY_NO" ).append("\n"); 
		query.append("  , '' SKD_DIR_CD" ).append("\n"); 
		query.append("  , '' POL" ).append("\n"); 
		query.append("  , '' POD" ).append("\n"); 
		query.append("  , '' TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}