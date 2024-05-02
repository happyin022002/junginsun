/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtDBDAOPortInformationConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.08 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOPortInformationConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy PortInformationMgt
	  * </pre>
	  */
	public PortInformationMgtDBDAOPortInformationConditionVORSQL(){
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' loc_cd" ).append("\n"); 
		query.append(",   '' rhq" ).append("\n"); 
		query.append(",   '' cel_year" ).append("\n"); 
		query.append(",   '' trsp_mod_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOPortInformationConditionVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}