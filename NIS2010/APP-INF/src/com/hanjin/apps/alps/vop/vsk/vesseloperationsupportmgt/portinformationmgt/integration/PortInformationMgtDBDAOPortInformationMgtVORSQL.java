/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortInformationMgtDBDAOPortInformationMgtVORSQL.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.19 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOPortInformationMgtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PortInformationMgtDBDAOPortInformationMgtVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MY.YD_CD" ).append("\n"); 
		query.append(",   MY.YD_NM" ).append("\n"); 
		query.append(",	VPM.ALSD_CD" ).append("\n"); 
		query.append(",	VPM.CHNL_DPTH" ).append("\n"); 
		query.append(",	VPM.BRTH_DPTH" ).append("\n"); 
		query.append(",	VPM.AT_DRFT_DPTH" ).append("\n"); 
		query.append(",	VPM.MAX_DRFT_DPTH" ).append("\n"); 
		query.append(",	VPM.AD_LEN" ).append("\n"); 
		query.append(",	VPM.BRTH_LEN" ).append("\n"); 
		query.append(",	VPM.TURN_BSN_LEN" ).append("\n"); 
		query.append(",	VPM.PLT_MNVR_DIST" ).append("\n"); 
		query.append(",	VPM.PLT_MNVR_TM_HRS" ).append("\n"); 
		query.append(",	VPM.MNVR_RMK" ).append("\n"); 
		query.append(",	VPM.CRE_USR_ID" ).append("\n"); 
		query.append(",	VPM.CRE_DT" ).append("\n"); 
		query.append(",	VPM.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(VPM.UPD_DT,'yyyy-mm-dd hh24:mi') UPD_DT" ).append("\n"); 
		query.append(",   MY.YD_CD AS TEMP_YD_CD" ).append("\n"); 
		query.append("FROM VSK_PORT_MNVR VPM" ).append("\n"); 
		query.append(",    MDM_YARD MY" ).append("\n"); 
		query.append("WHERE VPM.YD_CD = MY.YD_CD" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND	  MY.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MY.YD_CD ASC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOPortInformationMgtVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}