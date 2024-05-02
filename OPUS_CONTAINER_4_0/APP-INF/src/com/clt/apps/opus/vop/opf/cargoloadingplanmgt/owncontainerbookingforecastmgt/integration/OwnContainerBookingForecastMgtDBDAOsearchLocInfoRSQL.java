/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOsearchLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.08 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOsearchLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLocInfo 조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOsearchLocInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOsearchLocInfoRSQL").append("\n"); 
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
		query.append("SELECT VSK.YD_CD," ).append("\n"); 
		query.append("LOC.LOC_NM," ).append("\n"); 
		query.append("YD.YD_NM," ).append("\n"); 
		query.append("TO_CHAR(VSK.VPS_ETA_DT,'YYYY-MM-DD HH:MM') ETA" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VSK," ).append("\n"); 
		query.append("MDM_YARD         YD," ).append("\n"); 
		query.append("MDM_LOCATION     LOC" ).append("\n"); 
		query.append("WHERE VSK.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("AND VSK.SKD_VOY_NO              = @[skd_voy_no]" ).append("\n"); 
		query.append("AND VSK.SKD_DIR_CD              = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VSK.YD_CD||VSK.CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("AND VSK.YD_CD	                 = YD.YD_CD" ).append("\n"); 
		query.append("AND VSK.VPS_PORT_CD             = LOC.LOC_CD" ).append("\n"); 

	}
}