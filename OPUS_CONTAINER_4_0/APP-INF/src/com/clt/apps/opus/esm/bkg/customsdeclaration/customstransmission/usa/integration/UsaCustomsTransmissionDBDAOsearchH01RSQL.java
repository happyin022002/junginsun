/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchH01RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchH01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchH01RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchH01RSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN @[pol_loc] IS NULL OR LENGTH(@[pol_loc]) != 5 " ).append("\n"); 
		query.append("            THEN RPAD('H01'||'4'|| RPAD(' ', 14, ' ') ||substr(@[vps_eta_dt_a],1,6)||RPAD(@[pod_ams_port_cd],4,' ')|| COM_ConstantMgr_PKG.COM_getScacCode_FNC() || substr(@[vps_eta_dt_a],7,6),80,' ')||CHR(10)" ).append("\n"); 
		query.append("            ELSE RPAD('H01'||'9'|| RPAD(' ', 14, ' ') ||substr(@[vps_etd_dt],1,6)  || '0000' || COM_ConstantMgr_PKG.COM_getScacCode_FNC() || substr(@[vps_etd_dt],7,4) || '00' , 80, ' ')||CHR(10) " ).append("\n"); 
		query.append("        END H01" ).append("\n"); 
		query.append("      ,(SELECT RPAD('H02' || RPAD(' ', 18, ' ') || RPAD(' ', 23, ' ') || ' ' || NVL(LOC_AMS_PORT_CD,' '), 80, ' ')||CHR(10)" ).append("\n"); 
		query.append("          FROM MDM_LOCATION" ).append("\n"); 
		query.append("         WHERE LOC_CD = @[pol_loc]" ).append("\n"); 
		query.append("       ) H02" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}