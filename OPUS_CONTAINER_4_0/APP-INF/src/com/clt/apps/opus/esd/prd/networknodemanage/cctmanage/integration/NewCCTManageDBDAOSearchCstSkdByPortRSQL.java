/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCCTManageDBDAOSearchCstSkdByPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCCTManageDBDAOSearchCstSkdByPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NewCCTManageDBDAOSearchCstSkdByPort
	  * </pre>
	  */
	public NewCCTManageDBDAOSearchCstSkdByPortRSQL(){
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
		params.put("carrier_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCCTManageDBDAOSearchCstSkdByPortRSQL").append("\n"); 
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
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("      ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,T1.VSL_CD || T1.SKD_VOY_NO || T1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("      ,T5.VSL_ENG_NM AS VSL_ENG_NM" ).append("\n"); 
		query.append("	  ,T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,T2.CLPT_SEQ" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.CGO_CLZ_DT, 'YYYYMMDD') AS CGO_CLZ_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(T2.CGO_CLZ_DT, 'HH24MI') AS CGO_CLZ_DT_HHMI" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.DCGO_CLZ_DT, 'YYYYMMDD') AS DCGO_CLZ_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(T2.DCGO_CLZ_DT, 'HH24MI') AS DCGO_CLZ_DT_HHMI" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.RC_CLZ_DT, 'YYYYMMDD') AS RC_CLZ_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(T2.RC_CLZ_DT, 'HH24MI') AS RC_CLZ_DT_HHMI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.AWK_CGO_CLZ_DT, 'YYYYMMDD') 	AS AWK_CGO_CLZ_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(T2.AWK_CGO_CLZ_DT, 'HH24MI') 	AS AWK_CGO_CLZ_DT_HHMI" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.BB_CGO_CLZ_DT, 'YYYYMMDD') 	AS BB_CGO_CLZ_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(T2.BB_CGO_CLZ_DT, 'HH24MI') 		AS BB_CGO_CLZ_DT_HHMI" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,T2.YD_CD AS POL_YARD" ).append("\n"); 
		query.append("      ,T6.YD_NM AS POL_YARD_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS POL_ETA" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS POL_ETB" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS POL_ETD" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB" ).append("\n"); 
		query.append("      ,TO_CHAR(T2.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD" ).append("\n"); 
		query.append("      ,ROUND(DECODE(T2.PF_ETB_DT, NULL, 0, T2.VPS_ETB_DT - T2.PF_ETB_DT), 1) AS DELY_ETB_TM" ).append("\n"); 
		query.append("      ,ROUND(DECODE(T2.PF_ETD_DT, NULL, 0, T2.VPS_ETD_DT - T2.PF_ETD_DT), 1) AS DELY_ETD_TM" ).append("\n"); 
		query.append("      ,T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("      ,NVL(T1.ACT_CRR_CD, T3.CRR_CD) AS CARRIER_CD" ).append("\n"); 
		query.append("      ,DECODE(T4.VSL_SVC_TP_CD, NULL, 'O', 'O', 'O', 'T') AS VSL_SVC_TP_CD" ).append("\n"); 
		query.append("      ,'' AS TYPE_CD" ).append("\n"); 
		query.append("      ,'' AS FM_DT" ).append("\n"); 
		query.append("      ,'' AS TO_DT     " ).append("\n"); 
		query.append("      ,TO_CHAR(T2.VGM_CLZ_DT, 'YYYYMMDD') AS VGM_CLZ_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(T2.VGM_CLZ_DT, 'HH24MI') AS VGM_CLZ_DT_HHMI" ).append("\n"); 
		query.append("	  ,'0' vgm_his_pop" ).append("\n"); 
		query.append("	  ,'0' cct_his_pop" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD      T1" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     T3" ).append("\n"); 
		query.append("      ,MDM_VSL_SVC_LANE T4" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     T5" ).append("\n"); 
		query.append("      ,MDM_YARD         T6" ).append("\n"); 
		query.append(" WHERE T1.VSL_CD 		= T2.VSL_CD" ).append("\n"); 
		query.append("   AND T1.SKD_VOY_NO 	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND T1.SKD_DIR_CD 	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND T1.VSL_CD 		= T3.VSL_CD" ).append("\n"); 
		query.append("   AND T1.VSL_SLAN_CD 	= T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("   AND T2.VPS_PORT_CD 	= NVL(@[vps_port_cd], T2.VPS_PORT_CD)" ).append("\n"); 
		query.append("   AND T1.VSL_CD 		= NVL(@[vsl_cd], T1.VSL_CD)" ).append("\n"); 
		query.append("   AND T1.VSL_SLAN_CD 	LIKE NVL(@[vsl_slan_cd], T1.VSL_SLAN_CD) || '%'" ).append("\n"); 
		query.append("   AND NVL(@[carrier_cd], NVL(T1.ACT_CRR_CD, T3.CRR_CD)) = NVL(T1.ACT_CRR_CD, T3.CRR_CD)" ).append("\n"); 
		query.append("   AND T2.VPS_ETA_DT BETWEEN TO_DATE(REPLACE(@[fm_dt], '-', ''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt], '-', ''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   AND (T2.TURN_PORT_IND_CD IS NULL OR T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("   AND (T2.SKD_CNG_STS_CD IS NULL OR T2.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("   AND T4.VSL_TP_CD 	= 'C'" ).append("\n"); 
		query.append("   AND T1.VSL_CD 		= T5.VSL_CD	(+)" ).append("\n"); 
		query.append("   AND T2.YD_CD 		= T6.YD_CD	(+)" ).append("\n"); 
		query.append("   AND NVL(T2.VT_ADD_CALL_FLG,'N')	<> 'Y'" ).append("\n"); 
		query.append(" ORDER BY T1.VSL_CD" ).append("\n"); 
		query.append("         ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("         ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("         ,T2.CLPT_SEQ" ).append("\n"); 

	}
}