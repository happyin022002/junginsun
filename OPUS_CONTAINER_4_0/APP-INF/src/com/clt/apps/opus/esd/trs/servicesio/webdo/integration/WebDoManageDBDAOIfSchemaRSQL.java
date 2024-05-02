/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageDBDAOIfSchemaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.07
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.10.07 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.webdo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebDoManageDBDAOIfSchemaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CUP Web D/O I/F용 Schema
	  * </pre>
	  */
	public WebDoManageDBDAOIfSchemaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.webdo.integration ").append("\n"); 
		query.append("FileName : WebDoManageDBDAOIfSchemaRSQL").append("\n"); 
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
		query.append("'' BL_NO" ).append("\n"); 
		query.append(",'' IF_SYS_KND_CD" ).append("\n"); 
		query.append(",'' FCTRY_NM" ).append("\n"); 
		query.append(",'' ACT_CUST_N1ST_ADDR" ).append("\n"); 
		query.append(",'' ACT_CUST_CTY_NM" ).append("\n"); 
		query.append(",'' ACT_CUST_STE_NM" ).append("\n"); 
		query.append(",'' ACT_CUST_ZIP_CD" ).append("\n"); 
		query.append(",'' CNTC_PSON_NM" ).append("\n"); 
		query.append(",'' CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append(",'' CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",'' USR_EML" ).append("\n"); 
		query.append(",'' USR_PHN_NO" ).append("\n"); 
		query.append(",'' CRE_OFC_CD" ).append("\n"); 
		query.append(",'' EQ_NO" ).append("\n"); 
		query.append(",'' DO_RMK" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}