/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OceanRouteManageDBDAOHistoryOcnAddByLinkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOHistoryOcnAddByLinkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HistoryOcnAddByLink
	  * </pre>
	  */
	public OceanRouteManageDBDAOHistoryOcnAddByLinkCSQL(){
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
		params.put("org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rdLane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4thPol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2ndPol",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rdPol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOHistoryOcnAddByLinkCSQL").append("\n"); 
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
		query.append("      LNK_KNT, OCN_ROUT_PRIO_CD, UPD_IND_CD, N1ST_POL_CD,  " ).append("\n"); 
		query.append("      N1ST_POD_CD, N1ST_LANE_CD, N1ST_SKD_DIR_CD, N1ST_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N2ND_POL_CD, N2ND_POD_CD, N2ND_LANE_CD, N2ND_SKD_DIR_CD, N2ND_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N3RD_POL_CD, N3RD_POD_CD, N3RD_LANE_CD, N3RD_SKD_DIR_CD, N3RD_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N4TH_POL_CD, N4TH_POD_CD, N4TH_LANE_CD, N4TH_SKD_DIR_CD, N4TH_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      TZTM_HRS, N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS,  " ).append("\n"); 
		query.append("      N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS, PF_IND_CD,  " ).append("\n"); 
		query.append("      FDR_USD_FLG, OCN_ROUT_RMK, CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID, CRE_DT,  " ).append("\n"); 
		query.append("      UPD_USR_ID, UPD_DT, OCN_ROUT_DELT_RMK, OCN_ROUT_UPD_DT )  " ).append("\n"); 
		query.append("SELECT ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ, SYSDATE, TS_IND_CD,  " ).append("\n"); 
		query.append("      LNK_KNT, OCN_ROUT_PRIO_CD, UPD_IND_CD, N1ST_POL_CD,  " ).append("\n"); 
		query.append("      N1ST_POD_CD, N1ST_LANE_CD, N1ST_SKD_DIR_CD, N1ST_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N2ND_POL_CD, N2ND_POD_CD, N2ND_LANE_CD, N2ND_SKD_DIR_CD, N2ND_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N3RD_POL_CD, N3RD_POD_CD, N3RD_LANE_CD, N3RD_SKD_DIR_CD, N3RD_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      N4TH_POL_CD, N4TH_POD_CD, N4TH_LANE_CD, N4TH_SKD_DIR_CD, N4TH_LANE_FDR_FLG,  " ).append("\n"); 
		query.append("      TZTM_HRS, N1ST_TZTM_HRS, N2ND_TZTM_HRS, N3RD_TZTM_HRS, N4TH_TZTM_HRS,  " ).append("\n"); 
		query.append("      N1ST_STAY_TM_HRS, N2ND_STAY_TM_HRS, N3RD_STAY_TM_HRS, PF_IND_CD,  " ).append("\n"); 
		query.append("      FDR_USD_FLG, OCN_ROUT_RMK, CRE_OFC_CD, UPD_OFC_CD, CRE_USR_ID, CRE_DT,  " ).append("\n"); 
		query.append("      UPD_USR_ID, UPD_DT, OCN_ROUT_DELT_RMK, OCN_ROUT_UPD_DT  " ).append("\n"); 
		query.append("  FROM PRD_OCN_ROUT  " ).append("\n"); 
		query.append("  WHERE ORG_LOC_CD = @[org]  " ).append("\n"); 
		query.append("    AND DEST_LOC_CD = @[dest]  " ).append("\n"); 
		query.append("    AND N1ST_LANE_CD = @[n1stLane]  " ).append("\n"); 
		query.append("    AND NVL(N1ST_SKD_DIR_CD   ,'Z') = RTRIM(@[dir1])  " ).append("\n"); 
		query.append("    AND NVL(N2ND_POL_CD       ,'Z') = NVL(@[n2ndPol]       ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N2ND_LANE_CD      ,'Z') = NVL(@[n2ndLane]      ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N2ND_SKD_DIR_CD   ,'Z') = NVL(@[dir2]      ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N3RD_POL_CD       ,'Z') = NVL(@[n3rdPol]       ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N3RD_LANE_CD      ,'Z') = NVL(@[n3rdLane]      ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N3RD_SKD_DIR_CD,  'Z')  = NVL(@[dir3]      ,'Z')   " ).append("\n"); 
		query.append("    AND NVL(N4TH_POL_CD       ,'Z') = NVL(@[n4thPol]      ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N4TH_LANE_CD      ,'Z') = NVL(@[n4thLane]      ,'Z')  " ).append("\n"); 
		query.append("    AND NVL(N4TH_SKD_DIR_CD,   'Z') = NVL(@[dir4]      ,'Z')" ).append("\n"); 

	}
}