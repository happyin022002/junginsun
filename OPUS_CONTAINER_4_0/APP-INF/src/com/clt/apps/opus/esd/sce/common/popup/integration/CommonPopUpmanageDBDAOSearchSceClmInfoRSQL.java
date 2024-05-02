/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpmanageDBDAOSearchSceClmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.09 이중환
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

public class CommonPopUpmanageDBDAOSearchSceClmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selelct sce_clm
	  * </pre>
	  */
	public CommonPopUpmanageDBDAOSearchSceClmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.popup.integration ").append("\n"); 
		query.append("FileName : CommonPopUpmanageDBDAOSearchSceClmInfoRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' cntr_no," ).append("\n"); 
		query.append("'' cnmv_yr" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}