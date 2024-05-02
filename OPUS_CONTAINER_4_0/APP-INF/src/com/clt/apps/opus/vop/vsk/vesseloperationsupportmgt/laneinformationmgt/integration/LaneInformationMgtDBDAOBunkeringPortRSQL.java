/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneInformationMgtDBDAOBunkeringPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOBunkeringPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bunkering Port Hearder
	  * </pre>
	  */
	public LaneInformationMgtDBDAOBunkeringPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOBunkeringPortRSQL").append("\n"); 
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
		query.append("SELECT 	LOC_CD	AS	VAL" ).append("\n"); 
		query.append("		, LOC_CD	AS	NAME" ).append("\n"); 
		query.append("FROM	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE 	DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND   	VOP_BNK_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("AND   	ROWNUM < 31" ).append("\n"); 
		query.append("ORDER BY NAME" ).append("\n"); 

	}
}