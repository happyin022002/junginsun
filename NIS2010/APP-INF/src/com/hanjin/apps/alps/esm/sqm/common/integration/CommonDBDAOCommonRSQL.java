/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.08.11 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SQM 공통으로 사용 하는 조건 VO.
	  * </pre>
	  */
	public CommonDBDAOCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCommonRSQL").append("\n"); 
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
		query.append("SELECT '' CODE_NAME" ).append("\n"); 
		query.append("	, '' CODE_PARAM" ).append("\n"); 
		query.append("    , '' ALL_FLAG" ).append("\n"); 
		query.append("	, '' F_BAT_ID" ).append("\n"); 
		query.append("	, '' F_BAT_STS_CD" ).append("\n"); 
		query.append("	, '' F_BAT_RMK" ).append("\n"); 
		query.append("	, '' F_BSE_TP_CD" ).append("\n"); 
		query.append("	, '' F_BSE_YR" ).append("\n"); 
		query.append("	, '' F_BSE_QTR_CD" ).append("\n"); 
		query.append("	, '' F_OFC_VW_CD" ).append("\n"); 
		query.append("	, '' F_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}