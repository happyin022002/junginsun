/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtDBDAOSHATideInformationMgtConditionRSQL.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.06 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SHATideInformationMgtDBDAOSHATideInformationMgtConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public SHATideInformationMgtDBDAOSHATideInformationMgtConditionRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' AS loc_cd" ).append("\n"); 
		query.append(",      '' AS tide_yr" ).append("\n"); 
		query.append(",      '' AS tide_mon" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.integration").append("\n"); 
		query.append("FileName : SHATideInformationMgtDBDAOSHATideInformationMgtConditionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}