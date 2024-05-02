/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtDBDAOVesselInformationMgtConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.26 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOVesselInformationMgtConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public VesselInformationMgtDBDAOVesselInformationMgtConditionVORSQL(){
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
		query.append("SELECT '' AS vsl_cd" ).append("\n"); 
		query.append(",      '' AS year" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOVesselInformationMgtConditionVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}