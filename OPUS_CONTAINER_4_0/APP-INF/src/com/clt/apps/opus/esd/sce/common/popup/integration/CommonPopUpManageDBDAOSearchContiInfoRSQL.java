/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageDBDAOSearchContiInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.15 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonPopUpManageDBDAOSearchContiInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select conti info
	  * </pre>
	  */
	public CommonPopUpManageDBDAOSearchContiInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.popup.integration ").append("\n"); 
		query.append("FileName : CommonPopUpManageDBDAOSearchContiInfoRSQL").append("\n"); 
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
		query.append("select '' conti_cd," ).append("\n"); 
		query.append("'' sub_conti_cd," ).append("\n"); 
		query.append("'' cnt_cd," ).append("\n"); 
		query.append("'' cnt_nm" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}