/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchAllBKGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.20 
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

public class ContainerMovementFinderDBDAOSearchAllBKGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAllBKG
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchAllBKGRSQL(){
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
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ContainerMovementFinderDBDAOSearchAllBKGRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    B.BKG_NO," ).append("\n"); 
		query.append("    B.BL_NO," ).append("\n"); 
		query.append("    E.REPO_PLN_ID," ).append("\n"); 
		query.append("    B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("    B.POL_CD," ).append("\n"); 
		query.append("    NVL(B.POL_ETD_DT, E.FM_ETD_DT) AS ETD_DT," ).append("\n"); 
		query.append("    B.POD_CD," ).append("\n"); 
		query.append("    NVL(B.POD_ETA_DT, E.TO_DT) AS ETA_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, (SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("                            MTY_BKG_NO," ).append("\n"); 
		query.append("                            FM_ETD_DT," ).append("\n"); 
		query.append("                            TO_ETB_DT AS TO_DT" ).append("\n"); 
		query.append("                     FROM EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append("                     UNION" ).append("\n"); 
		query.append("                     SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("                            MTY_BKG_NO," ).append("\n"); 
		query.append("                            FM_ETD_DT," ).append("\n"); 
		query.append("                            TO_ETA_DT AS TO_DT" ).append("\n"); 
		query.append("                     FROM EQR_INLND_TRSP_EXE_PLN) E" ).append("\n"); 
		query.append("WHERE B.BKG_NO = E.MTY_BKG_NO(+)" ).append("\n"); 
		query.append("#if (${etd_eta} == 'D')" ).append("\n"); 
		query.append("AND TO_CHAR(NVL(B.POL_ETD_DT, E.FM_ETD_DT), 'YYYYMMDD') BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND TO_CHAR(NVL(B.POD_ETA_DT, E.TO_DT), 'YYYYMMDD') BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_ecc_cd} != '')" ).append("\n"); 
		query.append("AND POL_CD IN (SELECT L.LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT E" ).append("\n"); 
		query.append("                WHERE L.SCC_CD = E.SCC_CD" ).append("\n"); 
		query.append("                AND E.ECC_CD = @[fm_ecc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_ecc_cd} != '')" ).append("\n"); 
		query.append("AND POD_CD IN (SELECT L.LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT E" ).append("\n"); 
		query.append("                WHERE L.SCC_CD = E.SCC_CD" ).append("\n"); 
		query.append("                AND E.ECC_CD = @[to_ecc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_loc_cd} != '')" ).append("\n"); 
		query.append("AND POL_CD = @[fm_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_loc_cd} != '')" ).append("\n"); 
		query.append("AND POD_CD = @[to_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_tp_cd} != 'A')" ).append("\n"); 
		query.append("AND BKG_CGO_TP_CD = @[cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${etd_eta} == 'D')" ).append("\n"); 
		query.append("ORDER BY NVL(B.POL_ETD_DT, E.FM_ETD_DT)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY NVL(B.POD_ETA_DT, E.TO_DT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}