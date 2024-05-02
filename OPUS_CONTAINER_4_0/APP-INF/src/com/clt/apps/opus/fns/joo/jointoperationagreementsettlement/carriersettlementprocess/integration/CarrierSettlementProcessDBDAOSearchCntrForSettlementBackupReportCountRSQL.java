/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrForSettlementBackupReportCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchCntrForSettlementBackupReportCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrForSettlementBackupReportCount
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrForSettlementBackupReportCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrForSettlementBackupReportCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS TOTAL_COUNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("            SELECT VSL.VSL_SLAN_CD AS SLAN_CD " ).append("\n"); 
		query.append("                 , BAY.VSL_CD" ).append("\n"); 
		query.append("                 , BAY.VOY_NO" ).append("\n"); 
		query.append("                 , BAY.DIR_CD" ).append("\n"); 
		query.append("                 , BAY.PORT_CD" ).append("\n"); 
		query.append("                 , BAY.POL" ).append("\n"); 
		query.append("                 , BAY.POD" ).append("\n"); 
		query.append("                 , BAY.OPR_CD" ).append("\n"); 
		query.append("                 , BAY.ID" ).append("\n"); 
		query.append("                 , BAY.BAY||BAY.ROWW||BAY.TIER AS ORI_POSITION" ).append("\n"); 
		query.append("                 , BAY.SZTP" ).append("\n"); 
		query.append("                 , BAY.WEIGHT" ).append("\n"); 
		query.append("                 , BAY.FE" ).append("\n"); 
		query.append("                 , NULL AS TEUS" ).append("\n"); 
		query.append("                 , BAY.IMDG" ).append("\n"); 
		query.append("                 , BAY.IMDG2" ).append("\n"); 
		query.append("                 , BAY.IMDG3" ).append("\n"); 
		query.append("                 , BAY.IMDG4" ).append("\n"); 
		query.append("                 , BAY.TEMP" ).append("\n"); 
		query.append("                 , BAY.OVS" ).append("\n"); 
		query.append("                 , BAY.OVP" ).append("\n"); 
		query.append("                 , BAY.OVH" ).append("\n"); 
		query.append("                 , BAY.COD" ).append("\n"); 
		query.append("                 , DECODE(BAY.COD, NULL, NULL, 'COD') AS COD_TXT" ).append("\n"); 
		query.append("                 , DECODE(BAY.IMDG||BAY.IMDG2||BAY.IMDG3||BAY.IMDG4,NULL,NULL,'DG') AS IMDG_TXT" ).append("\n"); 
		query.append("                 , DECODE(BAY.TEMP, NULL, NULL,'TMP') AS TEMP_TXT" ).append("\n"); 
		query.append("                 , DECODE(BAY.OVS||BAY.OVP||BAY.OVH, NULL,NULL,'OOG') AS OOG_TXT" ).append("\n"); 
		query.append("                 , BAY.STATUS" ).append("\n"); 
		query.append("                 , VPS.VSL_CD||VPS.SKD_VOY_NO || VPS.SKD_DIR_CD ||'-'|| VPS.VPS_PORT_CD ||'-'|| VPS.CLPT_IND_SEQ ||'-'||VPS.CLPT_SEQ||'-'||TO_CHAR(VPS_ETD_DT ,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                 , BAY.VOY_NO||'_'||BAY.POL||BAY.DIR_CD AS LOAD_CALL" ).append("\n"); 
		query.append("                 , TO_CHAR(VPS.VPS_ETD_DT ,'YYYY-MM-DD HH24:MI') AS ACT_DEP_ATD_DT" ).append("\n"); 
		query.append("                 , (" ).append("\n"); 
		query.append("                        SELECT NVL(S1.TURN_SKD_VOY_NO,S1.SKD_VOY_NO) ||'_'||BAY.POD||NVL(S1.TURN_SKD_DIR_CD,S1.SKD_DIR_CD)" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                         WHERE S1.VSL_CD       = VPS.VSL_CD" ).append("\n"); 
		query.append("                           AND S1.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND S1.SKD_DIR_CD   = VPS.SKD_DIR_CD " ).append("\n"); 
		query.append("                           --AND (S1.TURN_PORT_IND_CD IS NULL OR S1.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                           AND (S1.SKD_CNG_STS_CD IS NULL OR S1.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                           AND S1.VPS_ETD_DT > VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                           AND S1.VPS_PORT_CD  = BAY.POD" ).append("\n"); 
		query.append("                           AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS DISCH_CALL" ).append("\n"); 
		query.append("                 , (" ).append("\n"); 
		query.append("                        SELECT MIN(TO_CHAR(VPS_ETD_DT ,'YYYY-MM-DD HH24:MI')) AS VPS_ETD_DT" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                         WHERE S1.VSL_CD       = VPS.VSL_CD" ).append("\n"); 
		query.append("                           AND S1.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND S1.SKD_DIR_CD   = VPS.SKD_DIR_CD " ).append("\n"); 
		query.append("                           --AND (S1.TURN_PORT_IND_CD IS NULL OR S1.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                           AND (S1.SKD_CNG_STS_CD IS NULL OR S1.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                           AND S1.VPS_ETD_DT > VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                           AND S1.VPS_PORT_CD  = BAY.POD" ).append("\n"); 
		query.append("                   ) AS DISCH_ATD_DT" ).append("\n"); 
		query.append("              FROM BAY_PLAN BAY" ).append("\n"); 
		query.append("                 , VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                 , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                 , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND BAY.PLAN_TYPE = 'F' " ).append("\n"); 
		query.append("               AND BAY.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("               AND BAY.VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND BAY.DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("               AND BAY.VSL_CD   = VPS.VSL_CD" ).append("\n"); 
		query.append("               AND BAY.VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND BAY.DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND BAY.PORT_CD  = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND BAY.PORT_CD  = BAY.POL" ).append("\n"); 
		query.append("               AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("               AND (VPS.SKD_CNG_STS_CD IS NULL OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("               AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("               --CARRIer" ).append("\n"); 
		query.append("			   #if (${slan_cd} != '') " ).append("\n"); 
		query.append("               AND BAY.OPR_CD = @[slan_cd]" ).append("\n"); 
		query.append("			   #end      " ).append("\n"); 
		query.append("         	   #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("               AND BAY.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("	           #if (${voy_no} != '') " ).append("\n"); 
		query.append("               AND BAY.VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (${dir_cd} != '') " ).append("\n"); 
		query.append("               AND BAY.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append(") P" ).append("\n"); 

	}
}