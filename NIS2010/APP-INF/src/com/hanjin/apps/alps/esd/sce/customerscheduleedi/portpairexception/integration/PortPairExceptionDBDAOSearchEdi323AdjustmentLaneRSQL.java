/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAOSearchEdi323AdjustmentLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOSearchEdi323AdjustmentLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sce_434_adj_lane 테이블을 초회함
	  * </pre>
	  */
	public PortPairExceptionDBDAOSearchEdi323AdjustmentLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOSearchEdi323AdjustmentLaneRSQL").append("\n"); 
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
		query.append("SELECT VSL_SLAN_CD SLAN_CD, VSL_SLAN_NM " ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE 1	=	1" ).append("\n"); 
		query.append("AND VSL_SLAN_CD IN (#foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("        							#if($velocityCount < $slan_cd.size())" ).append("\n"); 
		query.append("        								'$key'," ).append("\n"); 
		query.append("        							#else" ).append("\n"); 
		query.append("        								'$key'" ).append("\n"); 
		query.append("        							#end" ).append("\n"); 
		query.append("        						#end)" ).append("\n"); 

	}
}