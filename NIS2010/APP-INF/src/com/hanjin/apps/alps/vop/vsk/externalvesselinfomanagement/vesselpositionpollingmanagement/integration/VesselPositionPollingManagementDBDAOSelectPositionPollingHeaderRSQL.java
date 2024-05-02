/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAOSelectPositionPollingHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselPositionPollingManagementDBDAOSelectPositionPollingHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectPositionPollingHeader
	  * </pre>
	  */
	public VesselPositionPollingManagementDBDAOSelectPositionPollingHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dly_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration").append("\n"); 
		query.append("FileName : VesselPositionPollingManagementDBDAOSelectPositionPollingHeaderRSQL").append("\n"); 
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
		query.append("SELECT    X.RCV_DT" ).append("\n"); 
		query.append("        , X.DLY_RCV_SEQ" ).append("\n"); 
		query.append("        , X.RCV_CTNT" ).append("\n"); 
		query.append("        , X.CRE_USR_ID" ).append("\n"); 
		query.append("        , X.CRE_DT" ).append("\n"); 
		query.append("        , X.UPD_USR_ID" ).append("\n"); 
		query.append("        , X.UPD_DT" ).append("\n"); 
		query.append("        , X.FILE_NM " ).append("\n"); 
		query.append("FROM    VSK_VSL_PSN_PLNG_HDR X" ).append("\n"); 
		query.append("WHERE	RCV_DT = @[rcv_dt]" ).append("\n"); 
		query.append("AND		DLY_RCV_SEQ = @[dly_rcv_seq]" ).append("\n"); 

	}
}