/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSpaceAllocationControlOptionUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
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

public class SpaceAllocationManageDBDAOSpaceAllocationControlOptionUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 등록된 Control Option 을 항차별 Control Option으로 매핑
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [CHM-201431081] 차상영 SPC Allocation Control Option 추가 보완
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSpaceAllocationControlOptionUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSpaceAllocationControlOptionUSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_CTRL_OPT O" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("	SELECT DISTINCT" ).append("\n"); 
		query.append("		M.TRD_CD          ," ).append("\n"); 
		query.append("		M.SUB_TRD_CD      ," ).append("\n"); 
		query.append("		M.RLANE_CD        ," ).append("\n"); 
		query.append("		M.VSL_CD          ," ).append("\n"); 
		query.append("		M.SKD_VOY_NO      ," ).append("\n"); 
		query.append("		M.DIR_CD          ," ).append("\n"); 
		query.append("		A.CTRL_PORT_FLG   ," ).append("\n"); 
		query.append("		A.CTRL_WGT_FLG    ," ).append("\n"); 
		query.append("		A.CTRL_40FT_HC_FLG," ).append("\n"); 
		query.append("		A.CTRL_45FT_HC_FLG," ).append("\n"); 
		query.append("		A.CTRL_53FT_FLG   ," ).append("\n"); 
		query.append("		A.CTRL_RF_FLG     ," ).append("\n"); 
		query.append("		A.CTRL_LVL_CD     ," ).append("\n"); 
		query.append("		NVL((SELECT O.ACCT_GRP_CTRL_FLG" ).append("\n"); 
		query.append("                      FROM SPC_ALOC_LANE_CTRL_OPT O" ).append("\n"); 
		query.append("                     WHERE SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK BETWEEN O.APLY_FM_YRWK AND O.APLY_TO_YRWK" ).append("\n"); 
		query.append("                       AND M.TRD_CD     = O.TRD_CD" ).append("\n"); 
		query.append("                       AND M.SUB_TRD_CD = O.SUB_TRD_CD" ).append("\n"); 
		query.append("                       AND M.RLANE_CD   = O.RLANE_CD" ).append("\n"); 
		query.append("                       AND M.DIR_CD     = O.DIR_CD" ).append("\n"); 
		query.append("                       AND M.DELT_FLG   = 'N'), 'N') AS ACCT_GRP_CTRL_FLG," ).append("\n"); 
		query.append("		A.CTRL_D2_FLG," ).append("\n"); 
		query.append("		A.CTRL_D4_FLG," ).append("\n"); 
		query.append("		A.CTRL_RD_FLG," ).append("\n"); 
		query.append("		A.CTRL_ECC_FLG," ).append("\n"); 
		query.append("		A.CTRL_LOC_FLG," ).append("\n"); 
		query.append("		A.CTRL_USA_SVC_MOD_FLG," ).append("\n"); 
		query.append("		A.CTRL_ACCT_FLG," ).append("\n"); 
		query.append("		A.CTRL_DEST_LVL_CD," ).append("\n"); 
		query.append("		-- OPTION 컬럼 ADD 2015.02.16" ).append("\n"); 
		query.append("		A.BKG_CTRL_ALOC_FLG, " ).append("\n"); 
		query.append("		A.BKG_CTRL_ACCT_GRP_FLG," ).append("\n"); 
		query.append("		A.BKG_CTRL_MST_FLG," ).append("\n"); 
		query.append("		A.BKG_CTRL_APLY_FLG," ).append("\n"); 
		query.append("		A.BKG_CTRL_FCST_FLG," ).append("\n"); 
		query.append("		A.BKG_CTRL_FCST_RTO," ).append("\n"); 
		query.append("		A.CTRL_ECC_GRP_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_ACCT_GRP_APLY_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_ACCT_GRP_FCAST_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_ACCT_GRP_RTO" ).append("\n"); 
		query.append("		, A.BKG_CTRL_MST_TBL_APLY_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_MST_TBL_FCAST_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_MST_TBL_FCAST_RTO" ).append("\n"); 
		query.append("		, A.BKG_CTRL_ALOC_APLY_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_ALOC_FCAST_FLG" ).append("\n"); 
		query.append("		, A.BKG_CTRL_ALOC_FCAST_RTO " ).append("\n"); 
		query.append("        , A.CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("	FROM 	SPC_ALOC_LANE_CTRL_OPT A," ).append("\n"); 
		query.append("            MAS_MON_VVD            M" ).append("\n"); 
		query.append("	WHERE 	SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK >= TO_CHAR(SYSDATE, 'YYYYWW')" ).append("\n"); 
		query.append("	AND 	M.TRD_CD     = A.TRD_CD" ).append("\n"); 
		query.append("	AND 	M.SUB_TRD_CD = A.SUB_TRD_CD" ).append("\n"); 
		query.append("	AND 	M.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("	AND 	M.DIR_CD     = A.DIR_CD" ).append("\n"); 
		query.append("	AND 	M.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("	AND 	M.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("	AND 	M.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	AND 	M.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("	AND 	M.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("      ) L" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("		O.RLANE_CD   = L.RLANE_CD" ).append("\n"); 
		query.append("	AND 	O.DIR_CD     = L.DIR_CD" ).append("\n"); 
		query.append("	AND 	O.VSL_CD     = L.VSL_cD" ).append("\n"); 
		query.append("	AND 	O.SKD_VOY_NO = L.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND 	O.SKD_DIR_CD = L.DIR_CD" ).append("\n"); 
		query.append("        -- 2014.08.19 변경 " ).append("\n"); 
		query.append("        -- AND NVL(O.MNL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET  " ).append("\n"); 
		query.append("	O.CTRL_PORT_FLG     	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_PORT_FLG, L.CTRL_PORT_FLG)   ," ).append("\n"); 
		query.append("	O.CTRL_WGT_FLG      	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_WGT_FLG, L.CTRL_WGT_FLG)     ," ).append("\n"); 
		query.append("	O.CTRL_40FT_HC_FLG  	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_40FT_HC_FLG, L.CTRL_40FT_HC_FLG) ," ).append("\n"); 
		query.append("	O.CTRL_45FT_HC_FLG  	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_45FT_HC_FLG, L.CTRL_45FT_HC_FLG) ," ).append("\n"); 
		query.append("	O.CTRL_53FT_FLG     	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_53FT_FLG, L.CTRL_53FT_FLG)   ," ).append("\n"); 
		query.append("	O.CTRL_RF_FLG       	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_RF_FLG, L.CTRL_RF_FLG)     ," ).append("\n"); 
		query.append("	O.CTRL_LVL_CD       	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_LVL_CD, L.CTRL_LVL_CD)     ," ).append("\n"); 
		query.append("	O.ACCT_GRP_CTRL_FLG 	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.ACCT_GRP_CTRL_FLG, L.ACCT_GRP_CTRL_FLG)," ).append("\n"); 
		query.append("	O.CTRL_D2_FLG       	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_D2_FLG, L.CTRL_D2_FLG)," ).append("\n"); 
		query.append("	O.CTRL_D4_FLG       	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_D4_FLG, L.CTRL_D4_FLG)," ).append("\n"); 
		query.append("	O.CTRL_RD_FLG       	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_RD_FLG, L.CTRL_RD_FLG)," ).append("\n"); 
		query.append("	O.CTRL_ECC_FLG      	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_ECC_FLG, L.CTRL_ECC_FLG)," ).append("\n"); 
		query.append("	O.CTRL_LOC_FLG      	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_LOC_FLG, L.CTRL_LOC_FLG)," ).append("\n"); 
		query.append("	O.CTRL_USA_SVC_MOD_FLG  = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_USA_SVC_MOD_FLG, L.CTRL_USA_SVC_MOD_FLG)," ).append("\n"); 
		query.append("	O.CTRL_ACCT_FLG     	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_ACCT_FLG , L.CTRL_ACCT_FLG)," ).append("\n"); 
		query.append("	O.CTRL_DEST_LVL_CD  	= DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_DEST_LVL_CD, L.CTRL_DEST_LVL_CD)," ).append("\n"); 
		query.append("	O.UPD_USR_ID        	= 'SPC_SYSTEM'," ).append("\n"); 
		query.append("	O.UPD_DT            	= SYSDATE," ).append("\n"); 
		query.append("	-- OPTION 컬럼 ADD 2015.02.16" ).append("\n"); 
		query.append("	O.BKG_CTRL_ALOC_FLG             = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ALOC_FLG, L.BKG_CTRL_ALOC_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_ACCT_GRP_FLG         = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ACCT_GRP_FLG, L.BKG_CTRL_ACCT_GRP_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_MST_FLG              = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_MST_FLG,  L.BKG_CTRL_MST_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_APLY_FLG             = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_APLY_FLG, L.BKG_CTRL_APLY_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_FCST_FLG             = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_FCST_FLG, L.BKG_CTRL_FCST_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_FCST_RTO             = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_FCST_RTO, L.BKG_CTRL_FCST_RTO)," ).append("\n"); 
		query.append("	O.CTRL_ECC_GRP_FLG              = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_ECC_GRP_FLG, L.CTRL_ECC_GRP_FLG)," ).append("\n"); 
		query.append("	O.RAPLY_CFM_FLG                 = @[rd_flg],  --2015.04.01 김성욱, Control Option의 BKG Control의 byAlloc, bySMP, byMaster 의 조건이 완화 된 경우 세팅" ).append("\n"); 
		query.append("	O.BKG_CTRL_ACCT_GRP_APLY_FLG    = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ACCT_GRP_APLY_FLG, L.BKG_CTRL_ACCT_GRP_APLY_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_ACCT_GRP_FCAST_FLG   = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ACCT_GRP_FCAST_FLG, L.BKG_CTRL_ACCT_GRP_FCAST_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_ACCT_GRP_RTO         = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ACCT_GRP_RTO, L.BKG_CTRL_ACCT_GRP_RTO)," ).append("\n"); 
		query.append("	O.BKG_CTRL_MST_TBL_APLY_FLG     = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_MST_TBL_APLY_FLG, L.BKG_CTRL_MST_TBL_APLY_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_MST_TBL_FCAST_FLG    = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_MST_TBL_FCAST_FLG, L.BKG_CTRL_MST_TBL_FCAST_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_MST_TBL_FCAST_RTO    = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_MST_TBL_FCAST_RTO, L.BKG_CTRL_MST_TBL_FCAST_RTO)," ).append("\n"); 
		query.append("	O.BKG_CTRL_ALOC_APLY_FLG        = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ALOC_APLY_FLG, L.BKG_CTRL_ALOC_APLY_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_ALOC_FCAST_FLG       = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ALOC_FCAST_FLG, L.BKG_CTRL_ALOC_FCAST_FLG)," ).append("\n"); 
		query.append("	O.BKG_CTRL_ALOC_FCAST_RTO       = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.BKG_CTRL_ALOC_FCAST_RTO, L.BKG_CTRL_ALOC_FCAST_RTO)," ).append("\n"); 
		query.append(" 	O.CTRL_FX_RT_FLG                = DECODE(NVL(O.MNL_FLG,'N'), 'Y', O.CTRL_FX_RT_FLG, L.CTRL_FX_RT_FLG)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("	RLANE_CD         ," ).append("\n"); 
		query.append("	DIR_CD           ," ).append("\n"); 
		query.append("	VSL_CD           ," ).append("\n"); 
		query.append("	SKD_VOY_NO       ," ).append("\n"); 
		query.append("	SKD_DIR_CD       ," ).append("\n"); 
		query.append("	REP_TRD_CD       ," ).append("\n"); 
		query.append("	REP_SUB_TRD_CD   ," ).append("\n"); 
		query.append("	CTRL_PORT_FLG    ," ).append("\n"); 
		query.append("	CTRL_WGT_FLG     ," ).append("\n"); 
		query.append("	CTRL_SPC_FLG     ," ).append("\n"); 
		query.append("	CTRL_40FT_HC_FLG ," ).append("\n"); 
		query.append("	CTRL_45FT_HC_FLG ," ).append("\n"); 
		query.append("	CTRL_53FT_FLG    ," ).append("\n"); 
		query.append("	ACCT_GRP_CTRL_FLG," ).append("\n"); 
		query.append("	CTRL_RF_FLG      ," ).append("\n"); 
		query.append("	CTRL_TS_FLG      ," ).append("\n"); 
		query.append("	CTRL_LVL_CD      ," ).append("\n"); 
		query.append("	CRE_USR_ID       ," ).append("\n"); 
		query.append("	CRE_DT           ," ).append("\n"); 
		query.append("	UPD_USR_ID       ," ).append("\n"); 
		query.append("	UPD_DT           ," ).append("\n"); 
		query.append("	CTRL_D2_FLG      ," ).append("\n"); 
		query.append("	CTRL_D4_FLG      ," ).append("\n"); 
		query.append("	CTRL_RD_FLG      ," ).append("\n"); 
		query.append("	CTRL_ECC_FLG     ," ).append("\n"); 
		query.append("	CTRL_LOC_FLG     ," ).append("\n"); 
		query.append("	CTRL_USA_SVC_MOD_FLG," ).append("\n"); 
		query.append("	CTRL_ACCT_FLG	 ," ).append("\n"); 
		query.append("	CTRL_DEST_LVL_CD ," ).append("\n"); 
		query.append("	-- OPTION 컬럼 ADD 2015.02.16" ).append("\n"); 
		query.append("	BKG_CTRL_ALOC_FLG, " ).append("\n"); 
		query.append("	BKG_CTRL_ACCT_GRP_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_MST_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_APLY_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_FCST_FLG," ).append("\n"); 
		query.append("	BKG_CTRL_FCST_RTO," ).append("\n"); 
		query.append("	CTRL_ECC_GRP_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , BKG_CTRL_ACCT_GRP_APLY_FLG" ).append("\n"); 
		query.append("     , BKG_CTRL_ACCT_GRP_FCAST_FLG" ).append("\n"); 
		query.append("     , BKG_CTRL_ACCT_GRP_RTO" ).append("\n"); 
		query.append("     , BKG_CTRL_MST_TBL_APLY_FLG" ).append("\n"); 
		query.append("     , BKG_CTRL_MST_TBL_FCAST_FLG" ).append("\n"); 
		query.append("     , BKG_CTRL_MST_TBL_FCAST_RTO" ).append("\n"); 
		query.append("     , BKG_CTRL_ALOC_APLY_FLG" ).append("\n"); 
		query.append("     , BKG_CTRL_ALOC_FCAST_FLG" ).append("\n"); 
		query.append("     , BKG_CTRL_ALOC_FCAST_RTO  " ).append("\n"); 
		query.append("     , CTRL_FX_RT_FLG   " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("	L.RLANE_CD     ," ).append("\n"); 
		query.append("	L.DIR_CD       ," ).append("\n"); 
		query.append("	L.VSL_CD       ," ).append("\n"); 
		query.append("	L.SKD_VOY_NO   ," ).append("\n"); 
		query.append("	L.DIR_CD       ," ).append("\n"); 
		query.append("	L.TRD_CD       ," ).append("\n"); 
		query.append("	L.SUB_TRD_CD   ," ).append("\n"); 
		query.append("	L.CTRL_PORT_FLG," ).append("\n"); 
		query.append("	L.CTRL_WGT_FLG ," ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("	L.CTRL_40FT_HC_FLG ," ).append("\n"); 
		query.append("	L.CTRL_45FT_HC_FLG ," ).append("\n"); 
		query.append("	L.CTRL_53FT_FLG    ," ).append("\n"); 
		query.append("	L.ACCT_GRP_CTRL_FLG," ).append("\n"); 
		query.append("	L.CTRL_RF_FLG      ," ).append("\n"); 
		query.append("	'N'," ).append("\n"); 
		query.append("	L.CTRL_LVL_CD," ).append("\n"); 
		query.append("	'SPC_SYSTEM' ," ).append("\n"); 
		query.append("	SYSDATE      ," ).append("\n"); 
		query.append("	'SPC_SYSTEM' ," ).append("\n"); 
		query.append("	SYSDATE      ," ).append("\n"); 
		query.append("	L.CTRL_D2_FLG      ," ).append("\n"); 
		query.append("	L.CTRL_D4_FLG      ," ).append("\n"); 
		query.append("	L.CTRL_RD_FLG      ," ).append("\n"); 
		query.append("	L.CTRL_ECC_FLG     ," ).append("\n"); 
		query.append("	L.CTRL_LOC_FLG     ," ).append("\n"); 
		query.append("	L.CTRL_USA_SVC_MOD_FLG," ).append("\n"); 
		query.append("	L.CTRL_ACCT_FLG	   ," ).append("\n"); 
		query.append("	L.CTRL_DEST_LVL_CD ," ).append("\n"); 
		query.append("	-- OPTION 컬럼 ADD 2015.02.16" ).append("\n"); 
		query.append("	L.BKG_CTRL_ALOC_FLG, " ).append("\n"); 
		query.append("	L.BKG_CTRL_ACCT_GRP_FLG," ).append("\n"); 
		query.append("	L.BKG_CTRL_MST_FLG," ).append("\n"); 
		query.append("	L.BKG_CTRL_APLY_FLG," ).append("\n"); 
		query.append("	L.BKG_CTRL_FCST_FLG," ).append("\n"); 
		query.append("	L.BKG_CTRL_FCST_RTO," ).append("\n"); 
		query.append("	L.CTRL_ECC_GRP_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , L.BKG_CTRL_ACCT_GRP_APLY_FLG" ).append("\n"); 
		query.append("     , L.BKG_CTRL_ACCT_GRP_FCAST_FLG" ).append("\n"); 
		query.append("     , L.BKG_CTRL_ACCT_GRP_RTO" ).append("\n"); 
		query.append("     , L.BKG_CTRL_MST_TBL_APLY_FLG" ).append("\n"); 
		query.append("     , L.BKG_CTRL_MST_TBL_FCAST_FLG" ).append("\n"); 
		query.append("     , L.BKG_CTRL_MST_TBL_FCAST_RTO" ).append("\n"); 
		query.append("     , L.BKG_CTRL_ALOC_APLY_FLG" ).append("\n"); 
		query.append("     , L.BKG_CTRL_ALOC_FCAST_FLG" ).append("\n"); 
		query.append("     , L.BKG_CTRL_ALOC_FCAST_RTO " ).append("\n"); 
		query.append("     , L.CTRL_FX_RT_FLG " ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}