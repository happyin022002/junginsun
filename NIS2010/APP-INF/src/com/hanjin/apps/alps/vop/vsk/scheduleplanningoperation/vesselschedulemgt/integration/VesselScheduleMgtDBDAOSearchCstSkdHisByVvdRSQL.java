/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCstSkdHisByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchCstSkdHisByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Coastal SKD 를 조회한다.
	  * -------------------------------------------------------------------------------------------
	  * 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경 : 페이징 처리
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCstSkdHisByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCstSkdHisByVvdRSQL").append("\n"); 
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
		query.append("SELECT  BFR_VSL_CD" ).append("\n"); 
		query.append("       ,BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,BFR_VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("       ,BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("       ,BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("       ,BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("       ,BFR_YD_CD" ).append("\n"); 
		query.append("       ,AFT_VSL_CD" ).append("\n"); 
		query.append("       ,AFT_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,AFT_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,AFT_VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,AFT_VPS_ETA_DT" ).append("\n"); 
		query.append("       ,AFT_VPS_ETB_DT" ).append("\n"); 
		query.append("       ,AFT_VPS_ETD_DT" ).append("\n"); 
		query.append("       ,AFT_VPS_PORT_CD" ).append("\n"); 
		query.append("       ,AFT_YD_CD" ).append("\n"); 
		query.append("       ,VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,DIFF_RMK" ).append("\n"); 
		query.append("	   ,SORT_DATE" ).append("\n"); 
		query.append("       ,TOTAL_CNT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT	(BFR_VSL_CD || BFR_SKD_VOY_NO || BFR_SKD_DIR_CD) AS BFR_VSL_CD" ).append("\n"); 
		query.append("                , BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("                , BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("                --, (BFR_VSL_CD || BFR_SKD_VOY_NO || BFR_SKD_DIR_CD) AS BFR_VVD" ).append("\n"); 
		query.append("                , BFR_VSL_SLAN_CD" ).append("\n"); 
		query.append("                , TO_CHAR(BFR_VPS_ETA_DT, 'YYYYMMDDHH24MI') AS BFR_VPS_ETA_DT" ).append("\n"); 
		query.append("                , TO_CHAR(BFR_VPS_ETB_DT, 'YYYYMMDDHH24MI') AS BFR_VPS_ETB_DT" ).append("\n"); 
		query.append("                , TO_CHAR(BFR_VPS_ETD_DT, 'YYYYMMDDHH24MI') AS BFR_VPS_ETD_DT" ).append("\n"); 
		query.append("                , BFR_VPS_PORT_CD" ).append("\n"); 
		query.append("                , DECODE(BFR_YD_CD, NULL, '', SUBSTR(BFR_YD_CD, 6, 2)) AS BFR_YD_CD" ).append("\n"); 
		query.append("                , (AFT_VSL_CD || AFT_SKD_VOY_NO || AFT_SKD_DIR_CD) AS AFT_VSL_CD" ).append("\n"); 
		query.append("                , AFT_SKD_VOY_NO" ).append("\n"); 
		query.append("                , AFT_SKD_DIR_CD" ).append("\n"); 
		query.append("                --, (AFT_VSL_CD || AFT_SKD_VOY_NO || AFT_SKD_DIR_CD) AS AFT_VVD" ).append("\n"); 
		query.append("                , AFT_VSL_SLAN_CD" ).append("\n"); 
		query.append("                , TO_CHAR(AFT_VPS_ETA_DT, 'YYYYMMDDHH24MI') AS AFT_VPS_ETA_DT" ).append("\n"); 
		query.append("                , TO_CHAR(AFT_VPS_ETB_DT, 'YYYYMMDDHH24MI') AS AFT_VPS_ETB_DT" ).append("\n"); 
		query.append("                , TO_CHAR(AFT_VPS_ETD_DT, 'YYYYMMDDHH24MI') AS AFT_VPS_ETD_DT" ).append("\n"); 
		query.append("                , AFT_VPS_PORT_CD" ).append("\n"); 
		query.append("                , DECODE(AFT_YD_CD, NULL, '', SUBSTR(AFT_YD_CD, 6, 2)) AS AFT_YD_CD" ).append("\n"); 
		query.append("                , VSKD_CNG_TP_CD" ).append("\n"); 
		query.append("                , TO_CHAR(CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , TO_CHAR(UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("                , DIFF_RMK" ).append("\n"); 
		query.append("        		, UPD_DT AS SORT_DATE" ).append("\n"); 
		query.append("        		, ROW_NUMBER() OVER(ORDER BY UPD_DT DESC) AS RNUM" ).append("\n"); 
		query.append("                , COUNT(1) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("        FROM	VSK_VSL_SKD_HIS" ).append("\n"); 
		query.append("        WHERE	BFR_VSL_CD	= @[vsl_cd]" ).append("\n"); 
		query.append("        AND 	VSKD_CNG_NO LIKE '0%'" ).append("\n"); 
		query.append("        AND		BFR_SKD_VOY_NO	LIKE NVL(@[skd_voy_no], '') || '%'" ).append("\n"); 
		query.append("        AND		BFR_SKD_DIR_CD	LIKE NVL(@[skd_dir_cd], '') || '%'" ).append("\n"); 
		query.append("        #if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("        AND		BFR_VSL_SLAN_CD	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("        AND		BFR_VPS_PORT_CD	= @[vps_port_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fm_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("        AND		CRE_DT		BETWEEN	TO_DATE(@[fm_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        					AND		TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("  AND   RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}