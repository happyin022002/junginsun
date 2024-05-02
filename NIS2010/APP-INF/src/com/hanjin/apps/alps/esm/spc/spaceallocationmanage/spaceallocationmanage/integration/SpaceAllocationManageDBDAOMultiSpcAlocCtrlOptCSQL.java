/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다. (추가).
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2014.07.10 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  *                                                       INSERT 시 CTRL_FX_RT_FLG = 'Y'로 세팅
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrl_fcst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_spc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_CTRL_OPT(" ).append("\n"); 
		query.append("    RLANE_CD        ," ).append("\n"); 
		query.append("    DIR_CD          ," ).append("\n"); 
		query.append("    VSL_CD          ," ).append("\n"); 
		query.append("    SKD_VOY_NO      ," ).append("\n"); 
		query.append("    SKD_DIR_CD      ," ).append("\n"); 
		query.append("    REP_TRD_CD      ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD  ," ).append("\n"); 
		query.append("    CTRL_PORT_FLG   ," ).append("\n"); 
		query.append("    CTRL_WGT_FLG    ," ).append("\n"); 
		query.append("    CTRL_SPC_FLG    ," ).append("\n"); 
		query.append("    CTRL_40FT_HC_FLG," ).append("\n"); 
		query.append("    CTRL_45FT_HC_FLG," ).append("\n"); 
		query.append("    CTRL_53FT_FLG   ," ).append("\n"); 
		query.append("    CTRL_RF_FLG     ," ).append("\n"); 
		query.append("    CTRL_TS_FLG     ," ).append("\n"); 
		query.append("    CTRL_LVL_CD     ," ).append("\n"); 
		query.append("    CRE_USR_ID      ," ).append("\n"); 
		query.append("    CRE_DT          ," ).append("\n"); 
		query.append("    UPD_USR_ID      ," ).append("\n"); 
		query.append("    UPD_DT          ," ).append("\n"); 
		query.append("    CTRL_D2_FLG     ," ).append("\n"); 
		query.append("    CTRL_D4_FLG     ," ).append("\n"); 
		query.append("    CTRL_RD_FLG     ," ).append("\n"); 
		query.append("    CTRL_ECC_FLG    ," ).append("\n"); 
		query.append("    CTRL_LOC_FLG    ," ).append("\n"); 
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
		query.append("	CTRL_FX_RT_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[rlane_cd]  ," ).append("\n"); 
		query.append("    @[dir_cd]    ," ).append("\n"); 
		query.append("    @[vsl_cd]    ," ).append("\n"); 
		query.append("    @[skd_voy_no]," ).append("\n"); 
		query.append("    @[skd_dir_cd]," ).append("\n"); 
		query.append("    SPC_GET_REP_TRD_FNC(@[rlane_cd])    ," ).append("\n"); 
		query.append("    SPC_GET_REP_SUB_TRD_FNC(@[rlane_cd])," ).append("\n"); 
		query.append("    @[ctrl_port_flg]   ," ).append("\n"); 
		query.append("    @[ctrl_wgt_flg]    ," ).append("\n"); 
		query.append("    @[ctrl_spc_flg]    ," ).append("\n"); 
		query.append("    @[ctrl_40ft_hc_flg]," ).append("\n"); 
		query.append("    @[ctrl_45ft_hc_flg]," ).append("\n"); 
		query.append("    @[ctrl_53ft_flg]   ," ).append("\n"); 
		query.append("    @[ctrl_rf_flg]     ," ).append("\n"); 
		query.append("    'N'," ).append("\n"); 
		query.append("    @[ctrl_lvl_cd]," ).append("\n"); 
		query.append("    @[upd_usr_id] ," ).append("\n"); 
		query.append("    SYSDATE       ," ).append("\n"); 
		query.append("    @[upd_usr_id] ," ).append("\n"); 
		query.append("    SYSDATE       ," ).append("\n"); 
		query.append("    @[ctrl_d2_flg]," ).append("\n"); 
		query.append("    @[ctrl_d4_flg]," ).append("\n"); 
		query.append("    @[ctrl_rd_flg]," ).append("\n"); 
		query.append("    @[ctrl_ecc_flg]," ).append("\n"); 
		query.append("    @[ctrl_loc_flg]," ).append("\n"); 
		query.append("    @[ctrl_usa_svc_mod_flg]," ).append("\n"); 
		query.append("    @[ctrl_acct_flg]," ).append("\n"); 
		query.append("	@[ctrl_dest_lvl_cd]," ).append("\n"); 
		query.append("	@[bkg_ctrl_aloc_flg]," ).append("\n"); 
		query.append("    @[bkg_ctrl_acct_grp_flg]," ).append("\n"); 
		query.append("	@[bkg_ctrl_mst_flg],	" ).append("\n"); 
		query.append("	@[bkg_ctrl_aply_flg]," ).append("\n"); 
		query.append("    @[bkg_ctrl_fcst_flg]," ).append("\n"); 
		query.append("	@[bkg_ctrl_fcst_rto]," ).append("\n"); 
		query.append("	@[ctrl_ecc_grp_flg]," ).append("\n"); 
		query.append("	'Y' " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}