/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanRouteManageDBDAOInsertOceanRouteCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
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

public class OceanRouteManageDBDAOInsertOceanRouteCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertOceanRoute
	  * </pre>
	  */
	public OceanRouteManageDBDAOInsertOceanRouteCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3rd_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n2nd_stay_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n1st_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_prior",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n4th_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lnk_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n1st_stay_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("menu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n2nd_tztm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fdr_flg3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fdr_flg2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts1_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fdr_flg4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts2_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3rd_stay_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_route_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_f_u",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ts3_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fdr_flg1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOInsertOceanRouteCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_OCN_ROUT (" ).append("\n"); 
		query.append("   ORG_LOC_CD" ).append("\n"); 
		query.append("  ,DEST_LOC_CD" ).append("\n"); 
		query.append("  ,ROUT_SEQ" ).append("\n"); 
		query.append("  ,TS_IND_CD" ).append("\n"); 
		query.append("  ,LNK_KNT" ).append("\n"); 
		query.append("  ,OCN_ROUT_PRIO_CD" ).append("\n"); 
		query.append("  ,UPD_IND_CD" ).append("\n"); 
		query.append("  ,N1ST_POL_CD" ).append("\n"); 
		query.append("  ,N1ST_POD_CD" ).append("\n"); 
		query.append("  ,N1ST_LANE_CD" ).append("\n"); 
		query.append("  ,N1ST_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,N1ST_LANE_FDR_FLG" ).append("\n"); 
		query.append("  ,N2ND_POL_CD" ).append("\n"); 
		query.append("  ,N2ND_POD_CD" ).append("\n"); 
		query.append("  ,N2ND_LANE_CD" ).append("\n"); 
		query.append("  ,N2ND_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,N2ND_LANE_FDR_FLG" ).append("\n"); 
		query.append("  ,N3RD_POL_CD" ).append("\n"); 
		query.append("  ,N3RD_POD_CD" ).append("\n"); 
		query.append("  ,N3RD_LANE_CD" ).append("\n"); 
		query.append("  ,N3RD_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,N3RD_LANE_FDR_FLG" ).append("\n"); 
		query.append("  ,N4TH_POL_CD" ).append("\n"); 
		query.append("  ,N4TH_POD_CD" ).append("\n"); 
		query.append("  ,N4TH_LANE_CD" ).append("\n"); 
		query.append("  ,N4TH_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,N4TH_LANE_FDR_FLG" ).append("\n"); 
		query.append("  ,TZTM_HRS" ).append("\n"); 
		query.append("  ,N1ST_TZTM_HRS" ).append("\n"); 
		query.append("  ,N2ND_TZTM_HRS" ).append("\n"); 
		query.append("  ,N3RD_TZTM_HRS" ).append("\n"); 
		query.append("  ,N4TH_TZTM_HRS" ).append("\n"); 
		query.append("  ,N1ST_STAY_TM_HRS" ).append("\n"); 
		query.append("  ,N2ND_STAY_TM_HRS" ).append("\n"); 
		query.append("  ,N3RD_STAY_TM_HRS" ).append("\n"); 
		query.append("  ,PF_IND_CD" ).append("\n"); 
		query.append("  ,FDR_USD_FLG" ).append("\n"); 
		query.append("  ,OCN_ROUT_USR_RMK" ).append("\n"); 
		query.append("  ,OCN_ROUT_RMK" ).append("\n"); 
		query.append("  ,CRE_OFC_CD" ).append("\n"); 
		query.append("  ,UPD_OFC_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,OCN_ROUT_UPD_DT" ).append("\n"); 
		query.append("  ,N1ST_LNK_DIST" ).append("\n"); 
		query.append("  ,N2ND_LNK_DIST" ).append("\n"); 
		query.append("  ,N3RD_LNK_DIST" ).append("\n"); 
		query.append("  ,N4TH_LNK_DIST" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   RTRIM(@[s_pol])" ).append("\n"); 
		query.append("  ,RTRIM(@[s_pod])" ).append("\n"); 
		query.append("  ,TO_NUMBER(@[max_seq]) + 1" ).append("\n"); 
		query.append("  ,@[ts_ind_cd]" ).append("\n"); 
		query.append("  ,TO_NUMBER(@[s_lnk_cnt])" ).append("\n"); 
		query.append("  ,NVL(@[s_prior], '0')" ).append("\n"); 
		query.append("  ,@[s_route_flg]" ).append("\n"); 
		query.append("  ,@[s_pol1]" ).append("\n"); 
		query.append("  ,@[s_pod1]" ).append("\n"); 
		query.append("  ,@[s_lane]" ).append("\n"); 
		query.append("  ,@[s_dir1]" ).append("\n"); 
		query.append("  ,@[s_fdr_flg1]" ).append("\n"); 
		query.append("  ,@[s_pol2]" ).append("\n"); 
		query.append("  ,@[s_pod2]" ).append("\n"); 
		query.append("  ,@[s_ts1_lane]" ).append("\n"); 
		query.append("  ,@[s_dir2]" ).append("\n"); 
		query.append("  ,@[s_fdr_flg2]" ).append("\n"); 
		query.append("  ,@[s_pol3]" ).append("\n"); 
		query.append("  ,@[s_pod3]" ).append("\n"); 
		query.append("  ,@[s_ts2_lane]" ).append("\n"); 
		query.append("  ,@[s_dir3]" ).append("\n"); 
		query.append("  ,@[s_fdr_flg3]" ).append("\n"); 
		query.append("  ,@[s_pol4]" ).append("\n"); 
		query.append("  ,@[s_pod4]" ).append("\n"); 
		query.append("  ,@[s_ts3_lane]" ).append("\n"); 
		query.append("  ,@[s_dir4]" ).append("\n"); 
		query.append("  ,@[s_fdr_flg4]" ).append("\n"); 
		query.append("  ,NVL(@[s_n1st_tztm_hrs], 0) + NVL(@[s_n2nd_tztm_hrs], 0) + NVL(@[s_n3rd_tztm_hrs], 0) +" ).append("\n"); 
		query.append("   NVL(@[s_n4th_tztm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n1st_tztm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n2nd_tztm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n3rd_tztm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n4th_tztm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n1st_stay_tm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n2nd_stay_tm_hrs], 0)" ).append("\n"); 
		query.append("  ,NVL(@[s_n3rd_stay_tm_hrs], 0)" ).append("\n"); 
		query.append("  ,'N'" ).append("\n"); 
		query.append("  ,@[s_f_u]" ).append("\n"); 
		query.append("  ,REPLACE(REPLACE(REPLACE(@[s_route_rmk], CHR(34)), CHR(9), ' '), CHR(13) || CHR(10), ' ')" ).append("\n"); 
		query.append("  ,@[menu]" ).append("\n"); 
		query.append("  ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("  ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[upd_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,(SELECT NVL(DECODE(@[s_fdr_flg1]" ).append("\n"); 
		query.append("                    ,'Y'" ).append("\n"); 
		query.append("                    ,(SELECT STND_DIST" ).append("\n"); 
		query.append("                       FROM VSK_PORT_DIST" ).append("\n"); 
		query.append("                      WHERE FM_LOC_CD = @[s_pol1]" ).append("\n"); 
		query.append("                        AND TO_LOC_CD = @[s_pod1])" ).append("\n"); 
		query.append("                    ,(SELECT LNK_DIST" ).append("\n"); 
		query.append("                       FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                      WHERE VSL_SLAN_CD = @[s_lane]" ).append("\n"); 
		query.append("                        AND FM_PORT_CD = @[s_pol1]" ).append("\n"); 
		query.append("                        AND TO_PORT_CD = @[s_pod1]" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = @[s_dir1])" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("             ,0)" ).append("\n"); 
		query.append("     FROM DUAL)" ).append("\n"); 
		query.append("  ,(SELECT NVL(DECODE(@[s_fdr_flg2]" ).append("\n"); 
		query.append("                    ,'Y'" ).append("\n"); 
		query.append("                    ,(SELECT STND_DIST" ).append("\n"); 
		query.append("                       FROM VSK_PORT_DIST" ).append("\n"); 
		query.append("                      WHERE FM_LOC_CD = @[s_pol2]" ).append("\n"); 
		query.append("                        AND TO_LOC_CD = @[s_pod2])" ).append("\n"); 
		query.append("                    ,(SELECT LNK_DIST" ).append("\n"); 
		query.append("                       FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                      WHERE VSL_SLAN_CD = @[s_ts1_lane]" ).append("\n"); 
		query.append("                        AND FM_PORT_CD = @[s_pol2]" ).append("\n"); 
		query.append("                        AND TO_PORT_CD = @[s_pod2]" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = @[s_dir2])" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("             ,0)" ).append("\n"); 
		query.append("     FROM DUAL)" ).append("\n"); 
		query.append("  ,(SELECT NVL(DECODE(@[s_fdr_flg3]" ).append("\n"); 
		query.append("                    ,'Y'" ).append("\n"); 
		query.append("                    ,(SELECT STND_DIST" ).append("\n"); 
		query.append("                       FROM VSK_PORT_DIST" ).append("\n"); 
		query.append("                      WHERE FM_LOC_CD = @[s_pol3]" ).append("\n"); 
		query.append("                        AND TO_LOC_CD = @[s_pod3])" ).append("\n"); 
		query.append("                    ,(SELECT LNK_DIST" ).append("\n"); 
		query.append("                       FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                      WHERE VSL_SLAN_CD = @[s_ts2_lane]" ).append("\n"); 
		query.append("                        AND FM_PORT_CD = @[s_pol3]" ).append("\n"); 
		query.append("                        AND TO_PORT_CD = @[s_pod3]" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = @[s_dir3])" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("             ,0)" ).append("\n"); 
		query.append("     FROM DUAL)" ).append("\n"); 
		query.append("  ,(SELECT NVL(DECODE(@[s_fdr_flg4]" ).append("\n"); 
		query.append("                    ,'Y'" ).append("\n"); 
		query.append("                    ,(SELECT STND_DIST" ).append("\n"); 
		query.append("                       FROM VSK_PORT_DIST" ).append("\n"); 
		query.append("                      WHERE FM_LOC_CD = @[s_pol4]" ).append("\n"); 
		query.append("                        AND TO_LOC_CD = @[s_pod4])" ).append("\n"); 
		query.append("                    ,(SELECT LNK_DIST" ).append("\n"); 
		query.append("                       FROM PRD_PF_TZ_TM" ).append("\n"); 
		query.append("                      WHERE VSL_SLAN_CD = @[s_ts3_lane]" ).append("\n"); 
		query.append("                        AND FM_PORT_CD = @[s_pol4]" ).append("\n"); 
		query.append("                        AND TO_PORT_CD = @[s_pod4]" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = @[s_dir4])" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("             ,0)" ).append("\n"); 
		query.append("     FROM DUAL)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}