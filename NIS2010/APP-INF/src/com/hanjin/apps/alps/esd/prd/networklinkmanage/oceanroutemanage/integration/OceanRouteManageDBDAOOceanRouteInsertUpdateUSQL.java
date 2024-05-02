/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OceanRouteManageDBDAOOceanRouteInsertUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.25 
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

public class OceanRouteManageDBDAOOceanRouteInsertUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OceanRouteInsertUpdate
	  * </pre>
	  */
	public OceanRouteManageDBDAOOceanRouteInsertUpdateUSQL(){
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
		params.put("s_dir4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_dir1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_dir2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_route_note",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_pod2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ts2_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ts3_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ts1_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ocn_rout_tmp_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_n3rd_stay_tm_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ocn_rout_tmp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_fdr_flg1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_upd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOOceanRouteInsertUpdateUSQL").append("\n"); 
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
		query.append("UPDATE prd_ocn_rout ocn  " ).append("\n"); 
		query.append("   SET ts_ind_cd = @[ts_ind_cd],  " ).append("\n"); 
		query.append("       lnk_knt = TO_NUMBER( @[s_lnk_cnt] ),   " ).append("\n"); 
		query.append("       ocn_rout_prio_cd = @[s_prior]," ).append("\n"); 
		query.append("       OCN_ROUT_PRIO_CNG_FLG = DECODE((SELECT 'Y' FROM COM_USER WHERE USR_ID = @[upd_usr_id])" ).append("\n"); 
		query.append("                                      , 'Y', CASE WHEN OCN_ROUT_PRIO_CNG_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                                                  WHEN ocn_rout_prio_cd <> @[s_prior] THEN 'Y'" ).append("\n"); 
		query.append("                                                  ELSE 'N' END" ).append("\n"); 
		query.append("                                      , 'N')," ).append("\n"); 
		query.append("       upd_ind_cd = @[s_route_flg],   	" ).append("\n"); 
		query.append(" N1ST_SKD_DIR_CD    = @[s_dir1], " ).append("\n"); 
		query.append(" N1ST_LANE_FDR_FLG  = @[s_fdr_flg1], " ).append("\n"); 
		query.append(" N2ND_SKD_DIR_CD    = @[s_dir2], " ).append("\n"); 
		query.append(" N2ND_LANE_FDR_FLG  = @[s_fdr_flg2], " ).append("\n"); 
		query.append(" N3RD_SKD_DIR_CD    = @[s_dir3], " ).append("\n"); 
		query.append(" N3RD_LANE_FDR_FLG  = @[s_fdr_flg3], " ).append("\n"); 
		query.append(" N4TH_LANE_CD       = @[s_ts3_lane], " ).append("\n"); 
		query.append(" N4TH_SKD_DIR_CD    = @[s_dir4], 			" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       tztm_hrs = NVL(@[s_n1st_tztm_hrs], 0)+NVL(@[s_n2nd_tztm_hrs], 0)+NVL(@[s_n3rd_tztm_hrs], 0)+NVL(@[s_n4th_tztm_hrs], 0),   " ).append("\n"); 
		query.append("       n1st_tztm_hrs = NVL(@[s_n1st_tztm_hrs], 0),   " ).append("\n"); 
		query.append("       n2nd_tztm_hrs = NVL(@[s_n2nd_tztm_hrs], 0),   " ).append("\n"); 
		query.append("       n3rd_tztm_hrs = NVL(@[s_n3rd_tztm_hrs], 0),   " ).append("\n"); 
		query.append("       n4th_tztm_hrs = NVL(@[s_n4th_tztm_hrs], 0),   " ).append("\n"); 
		query.append("       n1st_stay_tm_hrs = NVL(@[s_n1st_stay_tm_hrs], 0),   " ).append("\n"); 
		query.append("       n2nd_stay_tm_hrs = NVL(@[s_n2nd_stay_tm_hrs], 0),   " ).append("\n"); 
		query.append("       n3rd_stay_tm_hrs = NVL(@[s_n3rd_stay_tm_hrs], 0),  " ).append("\n"); 
		query.append("       pf_ind_cd = @[pf_ind_cd],   " ).append("\n"); 
		query.append("       fdr_usd_flg = @[s_f_u],   " ).append("\n"); 
		query.append("       OCN_ROUT_USR_RMK = REPLACE(REPLACE(REPLACE(@[s_route_rmk], CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' '),   " ).append("\n"); 
		query.append("       OCN_ROUT_RMK = @[menu],   " ).append("\n"); 
		query.append("       cre_ofc_cd = @[cre_ofc_cd],   " ).append("\n"); 
		query.append("       upd_ofc_cd = @[cre_ofc_cd],   " ).append("\n"); 
		query.append("       cre_usr_id = @[cre_usr_id],   " ).append("\n"); 
		query.append("       cre_dt = sysdate,   " ).append("\n"); 
		query.append("       upd_usr_id = @[upd_usr_id],   " ).append("\n"); 
		query.append("       ocn_rout_upd_dt = sysdate," ).append("\n"); 
		query.append("       N1ST_LNK_DIST = ( SELECT NVL(DECODE(@[s_fdr_flg1],'Y', (SELECT STND_DIST FROM VSK_PORT_DIST WHERE FM_LOC_CD = @[s_pol1] AND TO_LOC_CD = @[s_pod1])," ).append("\n"); 
		query.append("                        (SELECT LNK_DIST FROM PRD_PF_TZ_TM WHERE VSL_SLAN_CD = @[s_lane] AND FM_PORT_CD = @[s_pol1] AND TO_PORT_CD = @[s_pod1] )),0)" ).append("\n"); 
		query.append("                         FROM DUAL" ).append("\n"); 
		query.append("                        )," ).append("\n"); 
		query.append("       N2ND_LNK_DIST = ( SELECT NVL(DECODE(@[s_fdr_flg2], 'Y', (SELECT STND_DIST FROM VSK_PORT_DIST WHERE FM_LOC_CD = @[s_pol2] AND TO_LOC_CD = @[s_pod2])," ).append("\n"); 
		query.append("                        (SELECT LNK_DIST FROM PRD_PF_TZ_TM WHERE VSL_SLAN_CD = @[s_ts1_lane] AND FM_PORT_CD = @[s_pol2] AND TO_PORT_CD = @[s_pod2] )),0)" ).append("\n"); 
		query.append("                         FROM DUAL" ).append("\n"); 
		query.append("                       )," ).append("\n"); 
		query.append("       N3RD_LNK_DIST = ( SELECT NVL(DECODE(@[s_fdr_flg3], 'Y', (SELECT STND_DIST FROM VSK_PORT_DIST WHERE FM_LOC_CD = @[s_pol3] AND TO_LOC_CD = @[s_pod3])," ).append("\n"); 
		query.append("                        (SELECT LNK_DIST FROM PRD_PF_TZ_TM WHERE VSL_SLAN_CD = @[s_ts2_lane] AND FM_PORT_CD = @[s_pol3] AND TO_PORT_CD = @[s_pod3] )),0)" ).append("\n"); 
		query.append("						 FROM DUAL" ).append("\n"); 
		query.append("                        )," ).append("\n"); 
		query.append("       N4TH_LNK_DIST = ( SELECT NVL(DECODE(@[s_fdr_flg4], 'Y', (SELECT STND_DIST FROM VSK_PORT_DIST WHERE FM_LOC_CD = @[s_pol4] AND TO_LOC_CD = @[s_pod4])," ).append("\n"); 
		query.append("                        (SELECT LNK_DIST FROM PRD_PF_TZ_TM WHERE VSL_SLAN_CD = @[s_ts3_lane] AND FM_PORT_CD = @[s_pol4] AND TO_PORT_CD = @[s_pod4] )),0)" ).append("\n"); 
		query.append("						 FROM DUAL" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("	   , OCN_ROUT_TMP_FLG = @[s_ocn_rout_tmp_flg]" ).append("\n"); 
		query.append("	   , OCN_ROUT_TMP_EXP_DT = to_date(@[s_ocn_rout_tmp_exp_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("       , OCN_ROUT_TMP_RMK = REPLACE(REPLACE(REPLACE(  @[s_route_note] , CHR(34)),CHR(9),' '), CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("       , VAL_EXPT_FLG = DECODE( @[s_upd_ind_cd] , 'V', 'Y','N')" ).append("\n"); 
		query.append(" WHERE org_loc_cd = RTRIM (@[s_pol])  " ).append("\n"); 
		query.append("   AND dest_loc_cd = RTRIM (@[s_pod])  " ).append("\n"); 
		query.append("   AND n1st_lane_cd = RTRIM (@[s_lane])   " ).append("\n"); 
		query.append("   AND NVL(N1ST_SKD_DIR_CD, 'X') = RTRIM(@[s_dir1])    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND NVL (n2nd_pol_cd, 'X') = NVL (RTRIM (@[s_ts1_port]), 'X')   " ).append("\n"); 
		query.append("   AND NVL (n2nd_lane_cd, 'X') = NVL (RTRIM (@[s_ts1_lane]), 'X')   " ).append("\n"); 
		query.append("   AND NVL(N2ND_SKD_DIR_CD, 'X')    = NVL(RTRIM(@[s_dir2]), 'X')    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND NVL (n3rd_pol_cd, 'X') = NVL (RTRIM (@[s_ts2_port]), 'X')  " ).append("\n"); 
		query.append("   AND NVL (n3rd_lane_cd, 'X') = NVL (RTRIM (@[s_ts2_lane]), 'X')   " ).append("\n"); 
		query.append("   AND NVL (N3RD_SKD_DIR_CD,'X')    = NVL(RTRIM(@[s_dir3]), 'X')   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND NVL (n4th_pol_cd, 'X') = NVL (RTRIM (@[s_ts3_port]), 'X')   " ).append("\n"); 
		query.append("   AND NVL (n4th_lane_cd, 'X') = NVL (RTRIM (@[s_ts3_lane]), 'X')   " ).append("\n"); 
		query.append("   AND NVL(N4TH_SKD_DIR_CD,'X') = NVL(RTRIM(@[s_dir4]), 'X')" ).append("\n"); 

	}
}