/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchMSExptVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchMSExptVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Microsoft(TMC)용 315 EDI 'SD' 코드 추가에 따른 Dwell 건 조회 VO
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchMSExptVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchMSExptVORSQL").append("\n"); 
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
		query.append("'' AS pod_cd_," ).append("\n"); 
		query.append("'' AS del_cd_," ).append("\n"); 
		query.append("'' AS vvd_," ).append("\n"); 
		query.append("'' AS bl_no_," ).append("\n"); 
		query.append("'' AS cntr_no_," ).append("\n"); 
		query.append("'' AS snt_flg_," ).append("\n"); 
		query.append("'' AS cs_grp_id" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}