/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaACECustomsTransmissionDBDAOsearchH01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.01.18 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACECustomsTransmissionDBDAOsearchH01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaACECustomsTransmissionDBDAOsearchH01RSQL
	  * </pre>
	  */
	public UsaACECustomsTransmissionDBDAOsearchH01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_a",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_ams_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACECustomsTransmissionDBDAOsearchH01RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN @[pol_loc] IS NULL OR LENGTH(@[pol_loc]) != 5 THEN" ).append("\n"); 
		query.append("RPAD('H01'||'4'||'              '||substr(@[vps_eta_dt_a],1,6)||RPAD(@[pod_ams_port_cd],4,' ')||'    '||substr(@[vps_eta_dt_a],7,6),80,' ')||CHR(10)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("RPAD('H01'||'9'||'              '||substr(@[vps_etd_dt],1,6)||'        '||substr(@[vps_etd_dt],7,4),80,' ')||CHR(10)" ).append("\n"); 
		query.append("END H01," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	RPAD('H02                                          '||NVL(LOC_AMS_PORT_CD,' '),80,' ')||CHR(10)" ).append("\n"); 
		query.append("FROM MDM_LOCATION" ).append("\n"); 
		query.append("WHERE LOC_CD = @[pol_loc]" ).append("\n"); 
		query.append(") H02" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}