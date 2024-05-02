/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOsearchAllEQRRefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOsearchAllEQRRefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAllEQRRef
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOsearchAllEQRRefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_item",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOsearchAllEQRRefRSQL").append("\n"); 
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
		query.append("SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("    MTY_BKG_NO," ).append("\n"); 
		query.append("    REF_ID," ).append("\n"); 
		query.append("    VVD," ).append("\n"); 
		query.append("    PLN_YRWK," ).append("\n"); 
		query.append("    EQ_TYPE," ).append("\n"); 
		query.append("    ITEM," ).append("\n"); 
		query.append("    FM_YD," ).append("\n"); 
		query.append("    FM_DT," ).append("\n"); 
		query.append("    TO_YD," ).append("\n"); 
		query.append("    TO_DT" ).append("\n"); 
		query.append("FROM (SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("        MTY_BKG_NO," ).append("\n"); 
		query.append("        REF_ID," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("        PLN_YRWK," ).append("\n"); 
		query.append("        'T.VVD' AS EQ_TYPE," ).append("\n"); 
		query.append("        DECODE(TRSP_MOD_CD, 'V', 'T.VVD', 'T', 'Truck', 'R', 'Rail', 'Water') AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        FM_ETD_DT AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        TO_ETB_DT AS TO_DT" ).append("\n"); 
		query.append("    FROM EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("        MTY_BKG_NO," ).append("\n"); 
		query.append("        REF_ID," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("        PLN_YRWK," ).append("\n"); 
		query.append("        'T/R/W' AS EQ_TYPE," ).append("\n"); 
		query.append("        DECODE(TRSP_MOD_CD, 'V', 'T.VVD', 'T', 'Truck', 'R', 'Rail', 'Water') AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        FM_ETD_DT AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        TO_ETA_DT AS TO_DT" ).append("\n"); 
		query.append("    FROM EQR_INLND_TRSP_EXE_PLN" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("        '' AS MTY_BKG_NO," ).append("\n"); 
		query.append("        REF_ID," ).append("\n"); 
		query.append("        '' AS VVD," ).append("\n"); 
		query.append("        PLN_YRWK," ).append("\n"); 
		query.append("        'LCC Int.' AS EQ_TYPE," ).append("\n"); 
		query.append("        DECODE(TRSP_MOD_CD, 'V', 'T.VVD', 'T', 'Truck', 'R', 'Rail', 'Water') AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        FM_ETD_DT AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        TO_ETA_DT AS TO_DT" ).append("\n"); 
		query.append("    FROM EQR_ECC_INTER_EXE_PLN" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("        '' AS MTY_BKG_NO," ).append("\n"); 
		query.append("        REF_ID," ).append("\n"); 
		query.append("        '' AS VVD," ).append("\n"); 
		query.append("        PLN_YRWK," ).append("\n"); 
		query.append("        'ON/OFH' AS EQ_TYPE," ).append("\n"); 
		query.append("        '' AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        TO_DATE(FM_LOC_DT, 'YYYY/MM/DD HH24:MI:SS') AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        TO_DATE(TO_LOC_DT, 'YYYY/MM/DD HH24:MI:SS') AS TO_DT" ).append("\n"); 
		query.append("    FROM EQR_ONF_HIR_EXE_PLN)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${etd_eta} == 'D')" ).append("\n"); 
		query.append("AND TO_CHAR(FM_DT, 'YYYYMMDD') BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND TO_CHAR(TO_DT, 'YYYYMMDD') BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_ecc_cd} != '')" ).append("\n"); 
		query.append("AND FM_YD IN (SELECT L.LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT E" ).append("\n"); 
		query.append("                WHERE L.SCC_CD = E.SCC_CD" ).append("\n"); 
		query.append("                AND E.ECC_CD = @[fm_ecc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_ecc_cd} != '')" ).append("\n"); 
		query.append("AND TO_YD IN (SELECT L.LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT E" ).append("\n"); 
		query.append("                WHERE L.SCC_CD = E.SCC_CD" ).append("\n"); 
		query.append("                AND E.ECC_CD = @[to_ecc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_loc_cd} != '')" ).append("\n"); 
		query.append("AND FM_YD = @[fm_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_loc_cd} != '')" ).append("\n"); 
		query.append("AND TO_YD = @[to_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_eq_type} != '')" ).append("\n"); 
		query.append("AND EQ_TYPE = @[p_eq_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_item} != '' && ${p_item} != 'B')" ).append("\n"); 
		query.append("AND ITEM = @[p_item]" ).append("\n"); 
		query.append("#elseif (${p_item} == 'B')" ).append("\n"); 
		query.append("AND ITEM IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${etd_eta} == 'D')" ).append("\n"); 
		query.append("ORDER BY FM_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY TO_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}