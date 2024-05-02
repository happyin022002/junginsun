/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoyagePerformanceMgtDBDAOSearchLanelListRSQL.java
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

public class VoyagePerformanceMgtDBDAOSearchLanelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane 리스트 조회
	  * </pre>
	  */
	public VoyagePerformanceMgtDBDAOSearchLanelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.integration").append("\n"); 
		query.append("FileName : VoyagePerformanceMgtDBDAOSearchLanelListRSQL").append("\n"); 
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
		query.append("SELECT  X.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM    MDM_VSL_SVC_LANE  X" ).append("\n"); 
		query.append("WHERE   X.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("AND     X.VSL_TP_CD       = 'C'" ).append("\n"); 

	}
}