/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VODAOGemSlpIfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VODAOGemSlpIfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RqstInfo VO생성
	  * </pre>
	  */
	public VODAOGemSlpIfVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo").append("\n"); 
		query.append("FileName : VODAOGemSlpIfVORSQL").append("\n"); 
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
		query.append("SELECT '' AS SLP_TJ_NO" ).append("\n"); 
		query.append("      ,'' AS SLP_SEQ_NO" ).append("\n"); 
		query.append("      ,'' AS SYS_CATE_NM" ).append("\n"); 
		query.append("      ,'' AS GL_EFF_DT" ).append("\n"); 
		query.append("      ,'' AS ACCT_CD" ).append("\n"); 
		query.append("      ,'' AS SLP_CURR_CD" ).append("\n"); 
		query.append("      ,'' AS SLP_AMT" ).append("\n"); 
		query.append("      ,'' AS SLP_CTR_CD" ).append("\n"); 
		query.append("      ,'' AS SLP_DESC" ).append("\n"); 
		query.append("      ,'' AS OFC_CD" ).append("\n"); 
		query.append("      ,'' AS SLP_VNDR_CD" ).append("\n"); 
		query.append("      ,'' AS PRPR_USR_ID" ).append("\n"); 
		query.append("      ,'' AS APRO_USR_ID" ).append("\n"); 
		query.append("      ,'' AS SLP_IF_FLG" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS CRE_DT" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_DT" ).append("\n"); 
		query.append("      ,'' AS SLP_SPLR_CD" ).append("\n"); 
		query.append("      ,'' AS SLP_SPLR_NM" ).append("\n"); 
		query.append("      ,'' AS CR_CRD_USR_NM" ).append("\n"); 
		query.append("	  ,'' AS CRD_SHOP_NM" ).append("\n"); 
		query.append("	  ,'' AS SLP_IF_ERR_RSN" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}