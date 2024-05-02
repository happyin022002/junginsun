/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OceanRouteManageDBDAOHistoryOcnAddByLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOHistoryOcnAddByLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HistoryOcnAddByLane
	  * </pre>
	  */
	public OceanRouteManageDBDAOHistoryOcnAddByLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2ndLane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4thLane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1stLane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rdLane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOHistoryOcnAddByLaneCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_OCN_ROUT_HIS  " ).append("\n"); 
		query.append("    ( ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ, HIS_CRE_DT, TS_IND_CD,  " ).append("\n"); 
		query.append("      LNK_KNT, OCN_ROUT_PRIO_CD, OCN_ROUT_PRIO_CNG_FLG, UPD_IND_CD, N1ST_POL_CD,  " ).append("\n"); 
		query.append("      N1ST_POD_CD, N1ST_LANE_CD, N1ST_SKD_DIR_CD, N1ST_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N2ND_POL_CD, N2ND_POD_CD, N2ND_LANE_CD, N2ND_SKD_DIR_CD, N2ND_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N3RD_POL_CD, N3RD_POD_CD, N3RD_LANE_CD, N3RD_SKD_DIR_CD, N3RD_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N4TH_POL_CD, N4TH_POD_CD, N4TH_LANE_CD, N4TH_SKD_DIR_CD, N4TH_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      TZTM_HRS, N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS,  " ).append("\n"); 
		query.append("      N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS, PF_IND_CD,  " ).append("\n"); 
		query.append("      FDR_USD_FLG, OCN_ROUT_RMK, CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID, CRE_DT,  " ).append("\n"); 
		query.append("      UPD_USR_ID, UPD_DT, OCN_ROUT_DELT_RMK, OCN_ROUT_UPD_DT,OCN_ROUT_TMP_FLG,OCN_ROUT_TMP_EXP_DT )  " ).append("\n"); 
		query.append("SELECT ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ, SYSDATE, TS_IND_CD,  " ).append("\n"); 
		query.append("      LNK_KNT, OCN_ROUT_PRIO_CD, OCN_ROUT_PRIO_CNG_FLG, UPD_IND_CD, N1ST_POL_CD,  " ).append("\n"); 
		query.append("      N1ST_POD_CD, N1ST_LANE_CD, N1ST_SKD_DIR_CD, N1ST_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N2ND_POL_CD, N2ND_POD_CD, N2ND_LANE_CD, N2ND_SKD_DIR_CD, N2ND_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N3RD_POL_CD, N3RD_POD_CD, N3RD_LANE_CD, N3RD_SKD_DIR_CD, N3RD_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N4TH_POL_CD, N4TH_POD_CD, N4TH_LANE_CD, N4TH_SKD_DIR_CD, N4TH_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      TZTM_HRS, N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS,  " ).append("\n"); 
		query.append("      N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS, PF_IND_CD,  " ).append("\n"); 
		query.append("      FDR_USD_FLG, OCN_ROUT_RMK, CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID, CRE_DT,  " ).append("\n"); 
		query.append("      UPD_USR_ID, UPD_DT, OCN_ROUT_DELT_RMK, OCN_ROUT_UPD_DT ,OCN_ROUT_TMP_FLG,OCN_ROUT_TMP_EXP_DT " ).append("\n"); 
		query.append("  FROM PRD_OCN_ROUT  " ).append("\n"); 
		query.append("  WHERE ( N1ST_LANE_CD = @[n1stLane] OR  " ).append("\n"); 
		query.append("          N2ND_LANE_CD = @[n2ndLane] OR  " ).append("\n"); 
		query.append("          N3RD_LANE_CD = @[n3rdLane] OR  " ).append("\n"); 
		query.append("          N4TH_LANE_CD = @[n4thLane] )  " ).append("\n"); 
		query.append("    AND CRE_USR_ID <> 'PC_MIG'  " ).append("\n"); 
		query.append("    AND UPD_IND_CD = 'D'" ).append("\n"); 

	}
}