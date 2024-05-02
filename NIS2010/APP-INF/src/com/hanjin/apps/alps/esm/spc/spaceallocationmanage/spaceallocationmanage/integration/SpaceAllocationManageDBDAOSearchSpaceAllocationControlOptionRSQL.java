/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionRSQL.java
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

public class SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 노선별 Control Option 조회
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2014.07.10 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
	  * 2015.07.03 이혜민 [CHM-201536633] Control Option management 보완요청 (Fixed Rate관련)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationControlOptionRSQL").append("\n"); 
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
		query.append("SELECT O.APLY_FM_YRWK," ).append("\n"); 
		query.append("       O.APLY_TO_YRWK," ).append("\n"); 
		query.append("       L.TRD_CD      ," ).append("\n"); 
		query.append("       L.SUB_TRD_CD  ," ).append("\n"); 
		query.append("       L.RLANE_CD    ," ).append("\n"); 
		query.append("       L.DIR_CD      ," ).append("\n"); 
		query.append("       NVL(O.CTRL_PORT_FLG    , 'N') AS CTRL_PORT_FLG    ," ).append("\n"); 
		query.append("       NVL(O.CTRL_WGT_FLG     , 'N') AS CTRL_WGT_FLG     , --Weight" ).append("\n"); 
		query.append("       NVL(O.CTRL_D2_FLG      , 'N') AS CTRL_D2_FLG      , --D2" ).append("\n"); 
		query.append("       NVL(O.CTRL_D4_FLG      , 'N') AS CTRL_D4_FLG , --D4" ).append("\n"); 
		query.append("       NVL(O.CTRL_40FT_HC_FLG , 'N') AS CTRL_40FT_HC_FLG , --HC" ).append("\n"); 
		query.append("       NVL(O.CTRL_45FT_HC_FLG , 'N') AS CTRL_45FT_HC_FLG , --45" ).append("\n"); 
		query.append("       NVL(O.CTRL_53FT_FLG    , 'N') AS CTRL_53FT_FLG    , --53" ).append("\n"); 
		query.append("       NVL(O.CTRL_RF_FLG      , 'N') AS CTRL_RF_FLG      , --RF" ).append("\n"); 
		query.append("       NVL(O.CTRL_RD_FLG      , 'N') AS CTRL_RD_FLG      , --RD" ).append("\n"); 
		query.append("       NVL(O.CTRL_LVL_CD      , 'L') AS CTRL_LVL_CD      , --POL/POD" ).append("\n"); 
		query.append("       NVL(O.CTRL_ECC_FLG     , 'N') AS CTRL_ECC_FLG      , --ECC" ).append("\n"); 
		query.append("       NVL(O.CTRL_LOC_FLG     , 'N') AS CTRL_LOC_FLG      , --LOC" ).append("\n"); 
		query.append("       NVL(O.CTRL_USA_SVC_MOD_FLG 	, 'N') AS CTRL_USA_SVC_MOD_FLG      , --US MOD" ).append("\n"); 
		query.append("       NVL(O.CTRL_ACCT_FLG    		, 'N') AS CTRL_ACCT_FLG     , --Account" ).append("\n"); 
		query.append("       O.CTRL_DEST_LVL_CD , --POD/DEL		" ).append("\n"); 
		query.append("       NVL(O.ACCT_GRP_CTRL_FLG, 'N') AS ACCT_GRP_CTRL_FLG, --Yield Group" ).append("\n"); 
		query.append("       O.APLY_FM_YRWK AS TMP_FM_YRWK, " ).append("\n"); 
		query.append("       O.APLY_TO_YRWK AS TMP_TO_YRWK," ).append("\n"); 
		query.append("       O.ACCT_GRP_CTRL_FLG    AS TMP_ACCT_FLG," ).append("\n"); 
		query.append("       DECODE(Q.DIR_CD, NULL, 'N', 'Y') AS HH_FLG," ).append("\n"); 
		query.append("	   NVL(O.BKG_CTRL_ALOC_FLG 		, 'N') AS BKG_CTRL_ALOC_FLG, " ).append("\n"); 
		query.append("       NVL(O.BKG_CTRL_ACCT_GRP_FLG	, 'N') AS BKG_CTRL_ACCT_GRP_FLG, " ).append("\n"); 
		query.append("       NVL(O.BKG_CTRL_MST_FLG		, 'N') AS BKG_CTRL_MST_FLG," ).append("\n"); 
		query.append("	   NVL(O.BKG_CTRL_APLY_FLG 		, 'N') AS BKG_CTRL_APLY_FLG, " ).append("\n"); 
		query.append("       NVL(O.BKG_CTRL_FCST_FLG		, 'N') AS BKG_CTRL_FCST_FLG, " ).append("\n"); 
		query.append("       O.BKG_CTRL_FCST_RTO				   AS BKG_CTRL_FCST_RTO, " ).append("\n"); 
		query.append("       NVL(O.CTRL_ECC_GRP_FLG		, 'N') AS CTRL_ECC_GRP_FLG" ).append("\n"); 
		query.append("-------추가" ).append("\n"); 
		query.append("     , NVL(O.BKG_CTRL_ACCT_GRP_APLY_FLG		, 'N') BKG_CTRL_ACCT_GRP_APLY_FLG	" ).append("\n"); 
		query.append("     , NVL(O.BKG_CTRL_ACCT_GRP_FCAST_FLG    , 'N') BKG_CTRL_ACCT_GRP_FCAST_FLG" ).append("\n"); 
		query.append("     , O.BKG_CTRL_ACCT_GRP_RTO    " ).append("\n"); 
		query.append("     , NVL(O.BKG_CTRL_MST_TBL_APLY_FLG      , 'N') BKG_CTRL_MST_TBL_APLY_FLG  " ).append("\n"); 
		query.append("     , NVL(O.BKG_CTRL_MST_TBL_FCAST_FLG     , 'N') BKG_CTRL_MST_TBL_FCAST_FLG " ).append("\n"); 
		query.append("     , O.BKG_CTRL_MST_TBL_FCAST_RTO " ).append("\n"); 
		query.append("     , NVL(O.BKG_CTRL_ALOC_APLY_FLG         , 'N') BKG_CTRL_ALOC_APLY_FLG     " ).append("\n"); 
		query.append("     , NVL(O.BKG_CTRL_ALOC_FCAST_FLG        , 'N') BKG_CTRL_ALOC_FCAST_FLG    " ).append("\n"); 
		query.append("     , O.BKG_CTRL_ALOC_FCAST_RTO" ).append("\n"); 
		query.append("     , DECODE(O.CTRL_FX_RT_FLG, 'Y', 1, 0) AS CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("  FROM MAS_LANE_RGST          L," ).append("\n"); 
		query.append("       SPC_ALOC_LANE_CTRL_OPT O," ).append("\n"); 
		query.append("       SPC_HD_HUL_MST         Q" ).append("\n"); 
		query.append(" WHERE L.TRD_CD     = O.TRD_CD    (+)" ).append("\n"); 
		query.append("   AND L.SUB_TRD_CD = O.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("   AND L.RLANE_CD   = O.RLANE_CD  (+)" ).append("\n"); 
		query.append("   AND L.DIR_CD     = O.DIR_CD    (+)" ).append("\n"); 
		query.append("   AND L.TRD_CD     = Q.TRD_CD    (+)" ).append("\n"); 
		query.append("   AND L.RLANE_CD   = Q.RLANE_CD  (+)" ).append("\n"); 
		query.append("   AND L.DIR_CD     = Q.DIR_CD    (+)" ).append("\n"); 
		query.append("   AND L.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND NVL(L.TRNK_IPT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("   AND L.RLANE_CD   <> 'RBCCO'" ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("   AND SPC_GET_REP_TRD_FNC(L.RLANE_CD) = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("   AND SPC_GET_REP_SUB_TRD_FNC(L.RLANE_CD) = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("   AND L.RLANE_CD= @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("   AND L.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY L.TRD_CD, L.SUB_TRD_CD, L.RLANE_CD, L.DIR_CD, APLY_FM_YRWK, APLY_TO_YRWK" ).append("\n"); 

	}
}