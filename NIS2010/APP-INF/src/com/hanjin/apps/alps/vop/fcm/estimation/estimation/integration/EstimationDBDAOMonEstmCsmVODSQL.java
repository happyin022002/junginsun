/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EstimationDBDAOMonEstmCsmVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.06.14 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MIJIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationDBDAOMonEstmCsmVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Remove the monthly estimation consumption of a specific month.
	  * </pre>
	  */
	public EstimationDBDAOMonEstmCsmVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.estimation.estimation.integration ").append("\n"); 
		query.append("FileName : EstimationDBDAOMonEstmCsmVODSQL").append("\n"); 
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
		query.append("DELETE FCM_ESTM_MON_CSM" ).append("\n"); 
		query.append("WHERE  EXE_YRMON = @[exe_yrmon]" ).append("\n"); 

	}
}