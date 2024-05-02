/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAOCreatePositionPollingHeaderCSQL.java
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

public class VesselPositionPollingManagementDBDAOCreatePositionPollingHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreatePositionPollingHeader
	  * </pre>
	  */
	public VesselPositionPollingManagementDBDAOCreatePositionPollingHeaderCSQL(){
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
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration").append("\n"); 
		query.append("FileName : VesselPositionPollingManagementDBDAOCreatePositionPollingHeaderCSQL").append("\n"); 
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
		query.append("INSERT  INTO    VSK_VSL_PSN_PLNG_HDR X" ).append("\n"); 
		query.append("        (   X.RCV_DT" ).append("\n"); 
		query.append("          , X.DLY_RCV_SEQ" ).append("\n"); 
		query.append("          , X.FILE_NM" ).append("\n"); 
		query.append("		  , X.RCV_CTNT" ).append("\n"); 
		query.append("          , X.CRE_USR_ID " ).append("\n"); 
		query.append("          , X.CRE_DT" ).append("\n"); 
		query.append("          , X.UPD_USR_ID" ).append("\n"); 
		query.append("          , X.UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("VALUES  ( " ).append("\n"); 
		query.append("			@[rcv_dt] " ).append("\n"); 
		query.append("		  ,	@[dly_rcv_seq]" ).append("\n"); 
		query.append("		  , @[file_nm]" ).append("\n"); 
		query.append("          , CASE WHEN ( SELECT COUNT(Y.FILE_NM)" ).append("\n"); 
		query.append("                        FROM   VSK_VSL_PSN_PLNG_HDR Y" ).append("\n"); 
		query.append("                        WHERE  Y.FILE_NM = @[file_nm]) < 1 THEN NULL" ).append("\n"); 
		query.append("                 WHEN ( SELECT COUNT(Y.FILE_NM)" ).append("\n"); 
		query.append("                        FROM   VSK_VSL_PSN_PLNG_HDR Y" ).append("\n"); 
		query.append("                        WHERE  Y.FILE_NM = @[file_nm]) >= 1 THEN 'DUPLICATED'" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("          , 'EDI_POLPSN_USER_ID'" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , 'EDI_POLPSN_USER_ID'" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}