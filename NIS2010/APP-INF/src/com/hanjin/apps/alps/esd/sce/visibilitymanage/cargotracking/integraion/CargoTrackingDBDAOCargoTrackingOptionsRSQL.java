/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoTrackingDBDAOCargoTrackingOptionsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.13 전병석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoTrackingDBDAOCargoTrackingOptionsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoTrackingDBDAO 조회 조건용
	  * </pre>
	  */
	public CargoTrackingDBDAOCargoTrackingOptionsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion").append("\n"); 
		query.append("FileName : CargoTrackingDBDAOCargoTrackingOptionsRSQL").append("\n"); 
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
		query.append("'' sc_no," ).append("\n"); 
		query.append("'' so_cre_dt," ).append("\n"); 
		query.append("'' por_cd," ).append("\n"); 
		query.append("'' pol_cd," ).append("\n"); 
		query.append("'' pod_cd," ).append("\n"); 
		query.append("'' del_cd," ).append("\n"); 
		query.append("'' fm_dt," ).append("\n"); 
		query.append("'' to_dt," ).append("\n"); 
		query.append("'' date_kind," ).append("\n"); 
		query.append("'' cust_cnt_seq," ).append("\n"); 
		query.append("'' cust_value1," ).append("\n"); 
		query.append("'' cust_value2," ).append("\n"); 
		query.append("'' i_page" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}