/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselInformationMgtDBDAOSearchDraftWeightListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOSearchDraftWeightListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDraftWeightList
	  * </pre>
	  */
	public VesselInformationMgtDBDAOSearchDraftWeightListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOSearchDraftWeightListVORSQL").append("\n"); 
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
		query.append("SELECT MTX_SEQ" ).append("\n"); 
		query.append(" 	 , VSL_CD" ).append("\n"); 
		query.append("     , DWT_WGT" ).append("\n"); 
		query.append("     , DRFT_DPTH" ).append("\n"); 
		query.append("FROM VSK_HYDRST_MTX" ).append("\n"); 
		query.append("ORDER BY VSL_CD, MTX_SEQ" ).append("\n"); 

	}
}