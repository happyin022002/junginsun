/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UtilDBDAOUtillVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UtilDBDAOUtillVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통으로 사용할 VO 생성
	  * </pre>
	  */
	public UtilDBDAOUtillVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.util.integration").append("\n"); 
		query.append("FileName : UtilDBDAOUtillVORSQL").append("\n"); 
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
		query.append("SELECT '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append(", '' AS S_SP_CATE_CD" ).append("\n"); 
		query.append(", '' AS EG_ID" ).append("\n"); 
		query.append(", '' AS EG_NM" ).append("\n"); 
		query.append(", '' AS EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS EG_OFC_CD" ).append("\n"); 
		query.append(", '' AS SP_CATE_CD" ).append("\n"); 
		query.append(", '' AS CTRT_OFC_CD" ).append("\n"); 
		query.append(", '' AS CODE_KEY" ).append("\n"); 
		query.append(", '' AS CODE_CD" ).append("\n"); 
		query.append(", '' AS CODE_NM" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS ISFLAG" ).append("\n"); 
		query.append(", '' AS S_REG_GP" ).append("\n"); 
		query.append(", '' AS S_CTRT_OFC_CD" ).append("\n"); 
		query.append(", '' AS F_CTRT_OFC_CD" ).append("\n"); 
		query.append(", '' AS SP_SEQ" ).append("\n"); 
		query.append(", '' AS VNDR_SEQ" ).append("\n"); 
		query.append(", '' AS VNDR_NM" ).append("\n"); 
		query.append(", '' AS USR_ID" ).append("\n"); 
		query.append(", '' AS USR_NM" ).append("\n"); 
		query.append(", '' AS OFC_CD" ).append("\n"); 
		query.append(", '' AS S_TML_CD" ).append("\n"); 
		query.append(", '' AS TML_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}