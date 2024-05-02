/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2009.11.04 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Carrier 정보 조회시 사용하는 VO
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOCarrierRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOCarrierRSQL").append("\n"); 
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
		query.append("SELECT	'' AS CRR_CD" ).append("\n"); 
		query.append(", '' AS CRR_FULL_NM" ).append("\n"); 
		query.append(", '' AS EXT_FLG" ).append("\n"); 
		query.append(", '' AS DELT_FLG" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}