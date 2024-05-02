/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAOSearchPositionPollingDetailPreRSQL.java
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

public class VesselPositionPollingManagementDBDAOSearchPositionPollingDetailPreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPositionPollingDetailPre
	  * </pre>
	  */
	public VesselPositionPollingManagementDBDAOSearchPositionPollingDetailPreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : VesselPositionPollingManagementDBDAOSearchPositionPollingDetailPreRSQL").append("\n"); 
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
		query.append("SELECT      XX.RCV_DT" ).append("\n"); 
		query.append("        ,   XX.DLY_RCV_SEQ" ).append("\n"); 
		query.append("        ,   XX.IF_RCV_SEQ" ).append("\n"); 
		query.append("        ,   XX.PLNG_GEN_GDT                     AS PRE_PLNG_GEN_GDT" ).append("\n"); 
		query.append("        ,   XX.PLNG_GEN_DIFF                    AS PLNG_GEN_DIFF_HRS" ).append("\n"); 
		query.append("        ,   XX.VSL_LAT                          AS VSL_PRE_LAT" ).append("\n"); 
		query.append("        ,   XX.VSL_LON                          AS VSL_PRE_LON" ).append("\n"); 
		query.append("        ,   XX.VSL_SPD                          AS VSL_PRE_SPD" ).append("\n"); 
		query.append("        ,   XX.VSL_PROG_DIR_CTNT                AS VSL_PRE_PROG_DIR_CTNT" ).append("\n"); 
		query.append("        ,   XX.CUR_VSL_LAT" ).append("\n"); 
		query.append("        ,   XX.CUR_VSL_LON" ).append("\n"); 
		query.append("        ,   XX.CUR_VSL_SPD" ).append("\n"); 
		query.append("        ,   XX.CUR_VSL_PROG_DIR_CTNT " ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            --==================================================" ).append("\n"); 
		query.append("            SELECT      ROUND((X.PLNG_GEN_GDT-D.PLNG_GEN_GDT)*24,4)   AS PLNG_GEN_DIFF" ).append("\n"); 
		query.append("                    ,   X.VSL_LAT                       AS CUR_VSL_LAT" ).append("\n"); 
		query.append("                    ,   X.VSL_LON                       AS CUR_VSL_LON" ).append("\n"); 
		query.append("                    ,   X.VSL_SPD                       AS CUR_VSL_SPD" ).append("\n"); 
		query.append("                    ,   X.VSL_PROG_DIR_CTNT             AS CUR_VSL_PROG_DIR_CTNT" ).append("\n"); 
		query.append("                    ,   D.*" ).append("\n"); 
		query.append("            FROM        VSK_VSL_PSN_PLNG_DTL    X" ).append("\n"); 
		query.append("                    ,   VSK_VSL_PSN_PLNG_DTL    D" ).append("\n"); 
		query.append("            WHERE       1 = 1" ).append("\n"); 
		query.append("            AND         X.RCV_DT                = @[rcv_dt]" ).append("\n"); 
		query.append("            AND         X.DLY_RCV_SEQ           = @[dly_rcv_seq]" ).append("\n"); 
		query.append("            AND         X.IF_RCV_SEQ            = @[if_rcv_seq]" ).append("\n"); 
		query.append("            AND         X.VSL_CD                = D.VSL_CD" ).append("\n"); 
		query.append("            AND         X.VSL_LAT               <> D.VSL_LAT" ).append("\n"); 
		query.append("            AND         X.VSL_LON               <> D.VSL_LON        " ).append("\n"); 
		query.append("            AND         X.PLNG_GEN_GDT          > D.PLNG_GEN_GDT" ).append("\n"); 
		query.append("            ORDER BY    D.PLNG_GEN_GDT          DESC" ).append("\n"); 
		query.append("            --==================================================" ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 
		query.append("WHERE       ROWNUM      = 1" ).append("\n"); 

	}
}