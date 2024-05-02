/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EASCommonDBDAOEasCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.01 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EASCommonDBDAOEasCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EasCommon
	  * </pre>
	  */
	public EASCommonDBDAOEasCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eascommon.integration").append("\n"); 
		query.append("FileName : EASCommonDBDAOEasCommonRSQL").append("\n"); 
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
		query.append("SELECT '1' AS CODE_ID" ).append("\n"); 
		query.append("     , '1' AS CODE_NAME" ).append("\n"); 
		query.append("     , '1' AS LOC_CD" ).append("\n"); 
		query.append("     , '1' AS NOD_CD" ).append("\n"); 
		query.append("     , '1' AS SLAN_CD" ).append("\n"); 
		query.append("     , '1' AS VPS_PORT_CD" ).append("\n"); 
		query.append("     , '1' AS VSL_CD" ).append("\n"); 
		query.append("     , '1' AS VSL_NM" ).append("\n"); 
		query.append("     , '1' AS CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 

	}
}