/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSpaceAllocationLaneControlOptionUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.01
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.10.01 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSpaceAllocationLaneControlOptionUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 Control Option 수정
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [CHM-201431081] 차상영 SPC Allocation Control Option 추가 보완
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * 2015.07.09 김성욱 [CHM-201536750] Revenue Management System 추가 보완 개발 요청 / F'cast L/F From wk 추가
	  * ConstraintMasterDBDAOSpaceAllocationLaneControlOptionUSQL.Query- 패키지 이동으로 신규 생성
	  * 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
	  * 2015.07.30 Arie MasterTable 조건 삭제(control option 저장화면에서)
	  * 2015.08.17 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(7.30내용 포함)
	  * </pre>
	  */
	public ConstraintMasterDBDAOSpaceAllocationLaneControlOptionUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_dest_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_wgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_aloc_fcast_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_53ft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_acct_grp_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_aloc_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_d2_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ecc_grp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_d4_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_grp_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_acct_grp_fcast_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_45ft_hc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_fx_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_usa_svc_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_acct_grp_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_rd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_aloc_fcast_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_40ft_hc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_acct_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_fcast_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ecc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSpaceAllocationLaneControlOptionUSQL").append("\n"); 
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
		query.append("UPDATE SPC_ALOC_LANE_CTRL_OPT" ).append("\n"); 
		query.append("   SET CTRL_PORT_FLG        = @[ctrl_port_flg]    ," ).append("\n"); 
		query.append("       CTRL_WGT_FLG         = DECODE(@[ctrl_wgt_flg]    , '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_40FT_HC_FLG     = DECODE(@[ctrl_40ft_hc_flg], '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_45FT_HC_FLG     = DECODE(@[ctrl_45ft_hc_flg], '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_53FT_FLG        = DECODE(@[ctrl_53ft_flg]   , '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_RF_FLG          = DECODE(@[ctrl_rf_flg]     , '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_LVL_CD          = @[ctrl_lvl_cd]      ," ).append("\n"); 
		query.append("       ACCT_GRP_CTRL_FLG    = DECODE(@[acct_grp_ctrl_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("       APLY_FM_YRWK         = DECODE(@[acct_grp_ctrl_flg], '1', @[aply_fm_yrwk], null)," ).append("\n"); 
		query.append("       APLY_TO_YRWK         = DECODE(@[acct_grp_ctrl_flg], '1', @[aply_to_yrwk], null)," ).append("\n"); 
		query.append("       UPD_USR_ID           = @[upd_usr_id]       ," ).append("\n"); 
		query.append("       UPD_DT               = SYSDATE," ).append("\n"); 
		query.append("       CTRL_D2_FLG          = DECODE(@[ctrl_d2_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_D4_FLG          = DECODE(@[ctrl_d4_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_RD_FLG          = DECODE(@[ctrl_rd_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_ECC_FLG         = DECODE(@[ctrl_ecc_flg],  '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_ECC_GRP_FLG 	= DECODE(@[ctrl_ecc_grp_flg],   '1', 'Y', 'N')," ).append("\n"); 
		query.append("       --CTRL_LOC_FLG         = DECODE([ctrl_loc_flg],  '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_USA_SVC_MOD_FLG = DECODE(@[ctrl_usa_svc_mod_flg], '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       CTRL_ACCT_FLG        = DECODE(@[ctrl_acct_flg], '1', 'Y', 'N') ," ).append("\n"); 
		query.append("	   CTRL_DEST_LVL_CD 	= DECODE(@[ctrl_dest_lvl_cd], 'POD', 'D', 'DEL', 'T', @[ctrl_dest_lvl_cd]), " ).append("\n"); 
		query.append("       CTRL_FX_RT_FLG 				= DECODE(@[ctrl_fx_rt_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("	   -- BKG Control 관련" ).append("\n"); 
		query.append("	   BKG_CTRL_ACCT_GRP_APLY_FLG	= DECODE(@[bkg_ctrl_acct_grp_aply_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       BKG_CTRL_ACCT_GRP_FCAST_FLG 	= DECODE(@[bkg_ctrl_acct_grp_fcast_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       BKG_CTRL_ACCT_GRP_RTO		= TO_NUMBER(@[bkg_ctrl_acct_grp_rto])," ).append("\n"); 
		query.append("	   BKG_CTRL_ALOC_APLY_FLG		= DECODE(@[bkg_ctrl_aloc_aply_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       BKG_CTRL_ALOC_FCAST_FLG		= DECODE(@[bkg_ctrl_aloc_fcast_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("       BKG_CTRL_ALOC_FCAST_RTO		= TO_NUMBER(@[bkg_ctrl_aloc_fcast_rto])," ).append("\n"); 
		query.append("       BKG_CTRL_FCAST_FM_YRWK       = @[bkg_ctrl_fcast_fm_yrwk]" ).append("\n"); 
		query.append("       ,BKG_CTRL_ALOC_TP_CD         = @[bkg_ctrl_aloc_tp_cd]" ).append("\n"); 
		query.append("       ,BKG_CTRL_ACCT_GRP_TP_CD     = @[bkg_ctrl_acct_grp_tp_cd]" ).append("\n"); 
		query.append(" WHERE TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD   = @[sub_trd_cd] " ).append("\n"); 
		query.append("   AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD       = @[dir_cd] " ).append("\n"); 

	}
}