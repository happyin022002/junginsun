/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchOtherVesselVvdListVORSQL.java
*@FileTitle : Vessel Code & Particular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.28 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchOtherVesselVvdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박 항차 정보를 조회한다(Other)
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchOtherVesselVvdListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration ").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchOtherVesselVvdListVORSQL").append("\n"); 
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
		query.append("select 1 a from dual" ).append("\n"); 

	}
}