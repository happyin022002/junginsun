/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActSkdDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.09.02 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOActSkdDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActSkdDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration ").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActSkdDtlRSQL").append("\n"); 
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
		query.append("SELECT  '' AS VSL_SLAN_CD" ).append("\n"); 
		query.append(", '' AS SLS_OFC_CD" ).append("\n"); 
		query.append(", '' AS VPS_PORT_CD" ).append("\n"); 
		query.append(", '' AS YD_CD" ).append("\n"); 
		query.append(", '' AS TML_CD" ).append("\n"); 
		query.append(", '' AS VVD" ).append("\n"); 
		query.append(", '' AS VPS_ETA_DT" ).append("\n"); 
		query.append(", '' AS ACT_ARR_DT" ).append("\n"); 
		query.append(", '' AS RPT_ATA" ).append("\n"); 
		query.append(", '' AS ATA_OVER_DAYS" ).append("\n"); 
		query.append(", '' AS VPS_ETB_DT" ).append("\n"); 
		query.append(", '' AS ACT_BRTH_DT" ).append("\n"); 
		query.append(", '' AS RPT_ATB" ).append("\n"); 
		query.append(", '' AS ATB_OVER_DAYS" ).append("\n"); 
		query.append(", '' AS VPS_ETD_DT" ).append("\n"); 
		query.append(", '' AS ACT_DEP_DT" ).append("\n"); 
		query.append(", '' AS RPT_ATD" ).append("\n"); 
		query.append(", '' AS ATD_OVER_DAYS" ).append("\n"); 
		query.append(", '' AS OPT_HRS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}