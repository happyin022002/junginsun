/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAOSearchVesselListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoyagePerformanceMgtDBDAOSearchVesselListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel 리스트 조회
	  * </pre>
	  */
	public VoyagePerformanceMgtDBDAOSearchVesselListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration").append("\n"); 
		query.append("FileName : VoyagePerformanceMgtDBDAOSearchVesselListRSQL").append("\n"); 
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
		query.append("SELECT    X.VSL_CD" ).append("\n"); 
		query.append("        , X.VSL_ENG_NM" ).append("\n"); 
		query.append("FROM      MDM_VSL_CNTR     X" ).append("\n"); 
		query.append("WHERE     X.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("AND       X.CALL_SGN_NO    NOT LIKE '%T.B.N.%'" ).append("\n"); 
		query.append("--WHERE VSL_CD LIKE '%AA%'" ).append("\n"); 
		query.append("ORDER BY  X.VSL_CD" ).append("\n"); 

	}
}