/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualDataDBDAOSearchActualDataInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.21 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualDataDBDAOSearchActualDataInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select info
	  * </pre>
	  */
	public ActualDataDBDAOSearchActualDataInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration ").append("\n"); 
		query.append("FileName : ActualDataDBDAOSearchActualDataInfoRSQL").append("\n"); 
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
		query.append("select '' act_rcv_tp_nm," ).append("\n"); 
		query.append("'' act_rcv_tp_cd," ).append("\n"); 
		query.append("'' nod_cd," ).append("\n"); 
		query.append("'' sc_cd," ).append("\n"); 
		query.append("'' act_sts_mapg_cd," ).append("\n"); 
		query.append("'' act_cd," ).append("\n"); 
		query.append("'' act_dt1," ).append("\n"); 
		query.append("'' act_dt2," ).append("\n"); 
		query.append("'' cntr_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}