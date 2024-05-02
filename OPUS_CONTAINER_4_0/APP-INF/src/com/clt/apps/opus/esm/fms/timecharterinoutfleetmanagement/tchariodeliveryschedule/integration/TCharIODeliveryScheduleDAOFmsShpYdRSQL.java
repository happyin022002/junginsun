/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleDAOFmsShpYdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharIODeliveryScheduleDAOFmsShpYdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ship Yard Select
	  * </pre>
	  */
	public TCharIODeliveryScheduleDAOFmsShpYdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration").append("\n"); 
		query.append("FileName : TCharIODeliveryScheduleDAOFmsShpYdRSQL").append("\n"); 
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
		query.append("SELECT FS.YD_SEQ," ).append("\n"); 
		query.append("FS.SHP_YD_NM," ).append("\n"); 
		query.append("NVL((SELECT 'Y' FROM DUAL" ).append("\n"); 
		query.append("WHERE NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("FROM FMS_NEW_BLD_SKD FN" ).append("\n"); 
		query.append("WHERE FN.YD_SEQ = FS.YD_SEQ)" ).append("\n"); 
		query.append("),'N') DELT_YN" ).append("\n"); 
		query.append("FROM FMS_SHP_YD FS" ).append("\n"); 
		query.append("ORDER BY FS.SHP_YD_NM" ).append("\n"); 

	}
}