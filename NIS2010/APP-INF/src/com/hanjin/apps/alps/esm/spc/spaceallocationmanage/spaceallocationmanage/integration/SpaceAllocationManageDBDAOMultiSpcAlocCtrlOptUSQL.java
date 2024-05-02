/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.23 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다. (수정).
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2014.07.10 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완 
	  * 2015.03.24 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * 2015.07.09 김성욱 [CHM-201536750] Revenue Management System 추가 보완 개발 요청 / F'cast L/F From wk 추가
	  * 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ctrl_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_45ft_hc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_fx_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocCtrlOptUSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_CTRL_OPT X" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("              A1.TRD_CD" ).append("\n"); 
		query.append("             ,A1.RLANE_CD" ).append("\n"); 
		query.append("             ,A1.DIR_CD" ).append("\n"); 
		query.append("             ,A1.CTRL_PORT_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_WGT_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_40FT_HC_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_45FT_HC_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_53FT_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_RF_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_D2_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_D4_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_RD_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_ECC_FLG" ).append("\n"); 
		query.append("             --,A1.CTRL_LOC_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_USA_SVC_MOD_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_ACCT_FLG" ).append("\n"); 
		query.append("             ,A1.CTRL_DEST_LVL_CD" ).append("\n"); 
		query.append("             ,A1.CTRL_LVL_CD" ).append("\n"); 
		query.append("             ,CASE WHEN A2.YRWK BETWEEN A1.APLY_FM_YRWK AND A1.APLY_TO_YRWK" ).append("\n"); 
		query.append("                   THEN A1.ACCT_GRP_CTRL_FLG" ).append("\n"); 
		query.append("                   ELSE 'N'" ).append("\n"); 
		query.append("              END AS ACCT_GRP_CTRL_FLG" ).append("\n"); 
		query.append("			, A1.CTRL_ECC_GRP_FLG" ).append("\n"); 
		query.append("			, A1.CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("			--Booking Control 관련 추가" ).append("\n"); 
		query.append("			--, A1.BKG_CTRL_ALOC_FLG			" ).append("\n"); 
		query.append("			--, A1.BKG_CTRL_ACCT_GRP_FLG      " ).append("\n"); 
		query.append("			--, A1.BKG_CTRL_MST_FLG           " ).append("\n"); 
		query.append("			--, A1.BKG_CTRL_APLY_FLG          " ).append("\n"); 
		query.append("			--, A1.BKG_CTRL_FCST_FLG          " ).append("\n"); 
		query.append("			--, A1.BKG_CTRL_FCST_RTO                   " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_ACCT_GRP_APLY_FLG " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_ACCT_GRP_FCAST_FLG" ).append("\n"); 
		query.append("			, A1.BKG_CTRL_ACCT_GRP_RTO      " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_MST_TBL_APLY_FLG  " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_MST_TBL_FCAST_FLG " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_MST_TBL_FCAST_RTO " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_ALOC_APLY_FLG     " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_ALOC_FCAST_FLG    " ).append("\n"); 
		query.append("			, A1.BKG_CTRL_ALOC_FCAST_RTO" ).append("\n"); 
		query.append("            , A1.BKG_CTRL_FCAST_FM_YRWK" ).append("\n"); 
		query.append("         FROM SPC_ALOC_LANE_CTRL_OPT A1" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("               SELECT TRD_CD, RLANE_CD, DIR_CD, SUBSTR(SLS_YRMON,1,4)||COST_WK AS YRWK" ).append("\n"); 
		query.append("                 FROM MAS_MON_VVD" ).append("\n"); 
		query.append("                WHERE RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                  AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("              ) A2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A1.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("          AND A1.DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("          AND A1.TRD_CD   = A2.TRD_CD" ).append("\n"); 
		query.append("          AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("          AND A1.DIR_CD   = A2.DIR_CD" ).append("\n"); 
		query.append("      ) Y" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("         X.RLANE_CD   = Y.RLANE_CD" ).append("\n"); 
		query.append("     AND X.DIR_CD     = Y.DIR_CD" ).append("\n"); 
		query.append("     AND X.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("     AND X.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("     AND X.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET" ).append("\n"); 
		query.append("			X.CTRL_SPC_FLG          = DECODE(@[mnl_flg], 'N', X.CTRL_SPC_FLG        , 'Y',@[ctrl_spc_flg]) -- 화면의  chkVolume 항목인데 보여지지 않고 있음 사용안되는것으로 보여짐" ).append("\n"); 
		query.append("			,X.CTRL_PORT_FLG        = DECODE(@[mnl_flg], 'N', Y.CTRL_PORT_FLG       , 'Y',@[ctrl_port_flg])" ).append("\n"); 
		query.append("			-- 화면에 존재하는 값은  mnl_flg에 따라 처리" ).append("\n"); 
		query.append("			,X.CTRL_WGT_FLG         = DECODE(@[mnl_flg], 'N', Y.CTRL_WGT_FLG        , 'Y',@[ctrl_wgt_flg])" ).append("\n"); 
		query.append("			,X.CTRL_40FT_HC_FLG     = DECODE(@[mnl_flg], 'N', Y.CTRL_40FT_HC_FLG    , 'Y',@[ctrl_40ft_hc_flg])" ).append("\n"); 
		query.append("			,X.CTRL_45FT_HC_FLG     = DECODE(@[mnl_flg], 'N', Y.CTRL_45FT_HC_FLG    , 'Y',@[ctrl_45ft_hc_flg])" ).append("\n"); 
		query.append("			,X.CTRL_53FT_FLG        = DECODE(@[mnl_flg], 'N', Y.CTRL_53FT_FLG       , 'Y',@[ctrl_53ft_flg])" ).append("\n"); 
		query.append("			,X.CTRL_RF_FLG          = DECODE(@[mnl_flg], 'N', Y.CTRL_RF_FLG         , 'Y',@[ctrl_rf_flg])" ).append("\n"); 
		query.append("			,X.CTRL_LVL_CD          = DECODE(@[mnl_flg], 'N', Y.CTRL_LVL_CD         , 'Y',@[ctrl_lvl_cd])" ).append("\n"); 
		query.append("			,X.CTRL_D2_FLG          = DECODE(@[mnl_flg], 'N', Y.CTRL_D2_FLG         , 'Y',@[ctrl_d2_flg])" ).append("\n"); 
		query.append("			,X.CTRL_D4_FLG          = DECODE(@[mnl_flg], 'N', Y.CTRL_D4_FLG         , 'Y',@[ctrl_d4_flg])" ).append("\n"); 
		query.append("			,X.CTRL_RD_FLG          = DECODE(@[mnl_flg], 'N', Y.CTRL_RD_FLG         , 'Y',@[ctrl_rd_flg])" ).append("\n"); 
		query.append("			,X.CTRL_USA_SVC_MOD_FLG = DECODE(@[mnl_flg], 'N', Y.CTRL_USA_SVC_MOD_FLG, 'Y',@[ctrl_usa_svc_mod_flg])" ).append("\n"); 
		query.append("			,X.CTRL_ACCT_FLG        = DECODE(@[mnl_flg], 'N', Y.CTRL_ACCT_FLG       , 'Y',@[ctrl_acct_flg])" ).append("\n"); 
		query.append("			,X.ACCT_GRP_CTRL_FLG    = DECODE(@[mnl_flg], 'N', Y.ACCT_GRP_CTRL_FLG   , 'Y',@[acct_grp_ctrl_flg])" ).append("\n"); 
		query.append("			,X.CTRL_FX_RT_FLG    	= DECODE(@[mnl_flg], 'N', Y.CTRL_FX_RT_FLG      , 'Y',@[ctrl_fx_rt_flg])" ).append("\n"); 
		query.append("			-- 화면에 존재하지 않는 값은 LANE Option을 따름" ).append("\n"); 
		query.append("			,X.CTRL_ECC_FLG         = Y.CTRL_ECC_FLG" ).append("\n"); 
		query.append("			,X.CTRL_ECC_GRP_FLG     = Y.CTRL_ECC_GRP_FLG" ).append("\n"); 
		query.append("			--,X.CTRL_LOC_FLG         = Y.CTRL_LOC_FLG" ).append("\n"); 
		query.append("			,X.CTRL_DEST_LVL_CD     = Y.CTRL_DEST_LVL_CD" ).append("\n"); 
		query.append("            -- BKG Control 관련 추가 항상 LANE Option을 따름" ).append("\n"); 
		query.append("			, X.BKG_CTRL_ACCT_GRP_APLY_FLG   = Y.BKG_CTRL_ACCT_GRP_APLY_FLG  " ).append("\n"); 
		query.append("			, X.BKG_CTRL_ACCT_GRP_FCAST_FLG  = Y.BKG_CTRL_ACCT_GRP_FCAST_FLG " ).append("\n"); 
		query.append("			, X.BKG_CTRL_ACCT_GRP_RTO        = Y.BKG_CTRL_ACCT_GRP_RTO       " ).append("\n"); 
		query.append("			, X.BKG_CTRL_MST_TBL_APLY_FLG    = Y.BKG_CTRL_MST_TBL_APLY_FLG   " ).append("\n"); 
		query.append("			, X.BKG_CTRL_MST_TBL_FCAST_FLG   = Y.BKG_CTRL_MST_TBL_FCAST_FLG  " ).append("\n"); 
		query.append("			, X.BKG_CTRL_MST_TBL_FCAST_RTO   = Y.BKG_CTRL_MST_TBL_FCAST_RTO  " ).append("\n"); 
		query.append("			, X.BKG_CTRL_ALOC_APLY_FLG       = Y.BKG_CTRL_ALOC_APLY_FLG      " ).append("\n"); 
		query.append("			, X.BKG_CTRL_ALOC_FCAST_FLG      = Y.BKG_CTRL_ALOC_FCAST_FLG     " ).append("\n"); 
		query.append("			, X.BKG_CTRL_ALOC_FCAST_RTO      = Y.BKG_CTRL_ALOC_FCAST_RTO" ).append("\n"); 
		query.append("			, X.BKG_CTRL_FCAST_FM_YRWK		 = Y.BKG_CTRL_FCAST_FM_YRWK            " ).append("\n"); 
		query.append("			,X.MNL_FLG              = @[mnl_flg]" ).append("\n"); 
		query.append("			,X.UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append("			,X.UPD_DT               = SYSDATE" ).append("\n"); 

	}
}