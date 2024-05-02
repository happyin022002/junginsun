/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAODAOsearchLocNmEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.21 우지석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ji Seok Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAODAOsearchLocNmEtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocNmEtc조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAODAOsearchLocNmEtcRSQL(){
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
		query.append("SELECT VSK.YD_CD, LOC.LOC_NM, YD.YD_NM, VSK.VPS_ETA_DT ETA, VSK.SLAN_CD, LANE.VSL_SLAN_NM" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD VSK, MDM_YARD YD, MDM_LOCATION LOC, MDM_VSL_SVC_LANE LANE" ).append("\n"); 
		query.append("WHERE  VSK.VSL_CD      = 'HJPO'" ).append("\n"); 
		query.append("AND    VSK.SKD_VOY_NO  = '0021'" ).append("\n"); 
		query.append("AND    VSK.SKD_DIR_CD  = 'W'" ).append("\n"); 
		query.append("AND    VSK.YD_CD       = 'KRPUSYG'" ).append("\n"); 
		query.append("AND    VSK.YD_CD       = YD.YD_CD" ).append("\n"); 
		query.append("AND    VSK.VPS_PORT_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("AND    VSK.SLAN_CD     = LANE.VSL_SLAN_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAODAOsearchLocNmEtcRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}