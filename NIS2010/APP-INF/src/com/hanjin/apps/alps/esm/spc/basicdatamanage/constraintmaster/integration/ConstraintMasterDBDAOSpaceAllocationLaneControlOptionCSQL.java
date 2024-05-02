/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOSpaceAllocationLaneControlOptionCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.10.05 Arie
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

public class ConstraintMasterDBDAOSpaceAllocationLaneControlOptionCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 Control Option 생성
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [CHM-201431081] 차상영 SPC Allocation Control Option 추가 보완
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * 2015.07.09 김성욱 [CHM-201536750] Revenue Management System 추가 보완 개발 요청 / F'cast L/F From wk 추가
	  * ConstraintMasterDBDAOSpaceAllocationLaneControlOptionCSQL.Query - 패키지 이동으로 신규 생성
	  * </pre>
	  */
	public ConstraintMasterDBDAOSpaceAllocationLaneControlOptionCSQL(){
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_aloc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_port_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_mst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_d4_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_grp_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_loc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrl_acct_grp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrl_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_fcst_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_fcst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ConstraintMasterDBDAOSpaceAllocationLaneControlOptionCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_LANE_CTRL_OPT(" ).append("\n"); 
		query.append("    APLY_FM_YRWK, " ).append("\n"); 
		query.append("    APLY_TO_YRWK, " ).append("\n"); 
		query.append("    TRD_CD, " ).append("\n"); 
		query.append("    SUB_TRD_CD, " ).append("\n"); 
		query.append("    RLANE_CD, " ).append("\n"); 
		query.append("    DIR_CD, " ).append("\n"); 
		query.append("    CTRL_PORT_FLG, " ).append("\n"); 
		query.append("    CTRL_WGT_FLG, " ).append("\n"); 
		query.append("    CTRL_40FT_HC_FLG, " ).append("\n"); 
		query.append("    CTRL_45FT_HC_FLG, " ).append("\n"); 
		query.append("    CTRL_53FT_FLG, " ).append("\n"); 
		query.append("    CTRL_RF_FLG, " ).append("\n"); 
		query.append("    CTRL_LVL_CD, " ).append("\n"); 
		query.append("    ACCT_GRP_CTRL_FLG, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    CTRL_D2_FLG," ).append("\n"); 
		query.append("    CTRL_D4_FLG," ).append("\n"); 
		query.append("    CTRL_RD_FLG," ).append("\n"); 
		query.append("    CTRL_ECC_FLG," ).append("\n"); 
		query.append("    CTRL_LOC_FLG," ).append("\n"); 
		query.append("    CTRL_USA_SVC_MOD_FLG," ).append("\n"); 
		query.append("    CTRL_ACCT_FLG," ).append("\n"); 
		query.append("	CTRL_DEST_LVL_CD," ).append("\n"); 
		query.append("	BKG_CTRL_ALOC_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_ACCT_GRP_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_MST_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_APLY_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_FCST_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_FCST_RTO," ).append("\n"); 
		query.append("	CTRL_ECC_GRP_FLG," ).append("\n"); 
		query.append("    CTRL_FX_RT_FLG," ).append("\n"); 
		query.append("    BKG_CTRL_FCAST_FM_YRWK" ).append("\n"); 
		query.append("   ,BKG_CTRL_ALOC_TP_CD " ).append("\n"); 
		query.append("   ,BKG_CTRL_ACCT_GRP_TP_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    DECODE(@[acct_grp_ctrl_flg], '1', @[aply_fm_yrwk], null)," ).append("\n"); 
		query.append("    DECODE(@[acct_grp_ctrl_flg], '1', @[aply_to_yrwk], null)," ).append("\n"); 
		query.append("    @[trd_cd]," ).append("\n"); 
		query.append("    @[sub_trd_cd]," ).append("\n"); 
		query.append("    @[rlane_cd]  ," ).append("\n"); 
		query.append("    @[dir_cd]    ," ).append("\n"); 
		query.append("    @[ctrl_port_flg]   ," ).append("\n"); 
		query.append("    DECODE(@[ctrl_wgt_flg]     , '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_40ft_hc_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_45ft_hc_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_53ft_flg]    , '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_rf_flg]      , '1', 'Y', 'N')," ).append("\n"); 
		query.append("    @[ctrl_lvl_cd]," ).append("\n"); 
		query.append("    DECODE(@[acct_grp_ctrl_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    @[upd_usr_id] ," ).append("\n"); 
		query.append("    SYSDATE       ," ).append("\n"); 
		query.append("    @[upd_usr_id] ," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    DECODE(@[ctrl_d2_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_d4_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_rd_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_ecc_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_loc_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_usa_svc_mod_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_acct_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("	@[ctrl_dest_lvl_cd]," ).append("\n"); 
		query.append("    DECODE(@[bkg_ctrl_aloc_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("    DECODE(@[bkg_ctrl_acct_grp_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("    DECODE(@[bkg_ctrl_mst_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("    DECODE(@[bkg_ctrl_aply_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("    DECODE(@[bkg_ctrl_fcst_flg],   '1', 'Y', 'N') ," ).append("\n"); 
		query.append("    @[bkg_ctrl_fcst_rto] ," ).append("\n"); 
		query.append("    DECODE(@[ctrl_ecc_grp_flg],   '1', 'Y', 'N')," ).append("\n"); 
		query.append("    DECODE(@[ctrl_fx_rt_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("    @[bkg_ctrl_fcast_fm_yrwk]" ).append("\n"); 
		query.append("	,@[bkg_ctrl_aloc_tp_cd]" ).append("\n"); 
		query.append("	,@[bkg_ctrl_acct_grp_tp_cd] " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}