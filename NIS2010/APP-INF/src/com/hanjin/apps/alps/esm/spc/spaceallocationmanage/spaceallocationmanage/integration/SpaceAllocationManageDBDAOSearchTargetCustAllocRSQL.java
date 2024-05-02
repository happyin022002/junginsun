/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchTargetCustAllocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.11
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.02.11 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchTargetCustAllocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Season 내 first version의 적용 시작 주차 이후에 기입력되어 있는 Alloc을 조회합니다.
	  * 
	  * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchTargetCustAllocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ver_st_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchTargetCustAllocRSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,SLS_OFC_CD" ).append("\n"); 
		query.append("      ,POL_YD_CD" ).append("\n"); 
		query.append("      ,POD_YD_CD" ).append("\n"); 
		query.append("      ,TS_FLG" ).append("\n"); 
		query.append("      ,MNL_FLG" ).append("\n"); 
		query.append("      ,CUST_CNT_CD" ).append("\n"); 
		query.append("      ,CUST_SEQ" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("          SELECT /*+INDEX (G XPKSPC_MDL_CUST_CTRL_GRP) */" ).append("\n"); 
		query.append("                  CUST_CTRL_CD" ).append("\n"); 
		query.append("             FROM SPC_MDL_CUST_CTRL_GRP G" ).append("\n"); 
		query.append("            WHERE TRD_CD = A.TRD_CD" ).append("\n"); 
		query.append("              AND COST_YRWK = (SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                      M.COST_YRWK" ).append("\n"); 
		query.append("                                 FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                WHERE @[ver_st_yrwk] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                  AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                  AND M.TRD_CD  = G.TRD_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM    = 1" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("              AND CUST_CTRL_CD LIKE A.CUST_CTRL_CD||'%'" ).append("\n"); 
		query.append("              AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS CUST_CTRL_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,REP_TRD_CD" ).append("\n"); 
		query.append("      ,REP_SUB_TRD_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SLS_RHQ_CD" ).append("\n"); 
		query.append("      ,SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("      ,ASGN_TTL_QTY" ).append("\n"); 
		query.append("      ,ASGN_20FT_QTY" ).append("\n"); 
		query.append("      ,ASGN_40FT_QTY" ).append("\n"); 
		query.append("      ,ASGN_40FT_HC_QTY" ).append("\n"); 
		query.append("      ,ASGN_45FT_HC_QTY" ).append("\n"); 
		query.append("      ,ASGN_53FT_QTY" ).append("\n"); 
		query.append("      ,ASGN_RF_QTY" ).append("\n"); 
		query.append("      ,ASGN_TTL_WGT" ).append("\n"); 
		query.append("      ,BKG_AVAL_TTL_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_20FT_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_40FT_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_40FT_HC_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_45FT_HC_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_53FT_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_RF_QTY" ).append("\n"); 
		query.append("      ,BKG_AVAL_TTL_WGT" ).append("\n"); 
		query.append("      ,MNL_ALOC_RMK" ).append("\n"); 
		query.append("      ,ALOC_USR_ID" ).append("\n"); 
		query.append("      ,ALOC_GDT" ).append("\n"); 
		query.append("      ,SLS_AQ_CD" ).append("\n"); 
		query.append("      ,FCAST_TTL_QTY" ).append("\n"); 
		query.append("      ,FCAST_40FT_HC_QTY" ).append("\n"); 
		query.append("      ,FCAST_45FT_HC_QTY" ).append("\n"); 
		query.append("      ,FCAST_53FT_QTY" ).append("\n"); 
		query.append("      ,FCAST_RF_QTY" ).append("\n"); 
		query.append("      ,FCAST_TTL_WGT" ).append("\n"); 
		query.append("      ,USD_BKG_TTL_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_20FT_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_40FT_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_40FT_HC_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_45FT_HC_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_53FT_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_RF_QTY" ).append("\n"); 
		query.append("      ,USD_BKG_TTL_WGT" ).append("\n"); 
		query.append("      ,SPC_CTRL_ALOC_RMK" ).append("\n"); 
		query.append("      ,SPC_CTRL_ALOC_POL_RMK" ).append("\n"); 
		query.append("      ,SPC_CTRL_ALOC_POD_RMK" ).append("\n"); 
		query.append("      ,POL_IND_SEQ" ).append("\n"); 
		query.append("      ,POD_IND_SEQ" ).append("\n"); 
		query.append("      ,POL_YD_IND_SEQ" ).append("\n"); 
		query.append("      ,POD_YD_IND_SEQ" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.DIR_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD_DIR_CD" ).append("\n"); 
		query.append("                ,SLS_OFC_CD" ).append("\n"); 
		query.append("                ,POL_YD_CD" ).append("\n"); 
		query.append("                ,POD_YD_CD" ).append("\n"); 
		query.append("                ,TS_FLG" ).append("\n"); 
		query.append("                ,MNL_FLG" ).append("\n"); 
		query.append("                ,CUST_CNT_CD" ).append("\n"); 
		query.append("                ,CUST_SEQ" ).append("\n"); 
		query.append("                ,SUBSTR(CUST_CTRL_CD,1,1) AS CUST_CTRL_CD" ).append("\n"); 
		query.append("                ,A.IOC_CD" ).append("\n"); 
		query.append("                ,MAX(A.REP_TRD_CD)         AS REP_TRD_CD" ).append("\n"); 
		query.append("                ,MAX(A.REP_SUB_TRD_CD)     AS REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                ,MAX(A.TRD_CD)             AS TRD_CD" ).append("\n"); 
		query.append("                ,MAX(A.SUB_TRD_CD)         AS SUB_TRD_CD" ).append("\n"); 
		query.append("                ,MAX(SLS_RHQ_CD)           AS SLS_RHQ_CD" ).append("\n"); 
		query.append("                ,MAX(SLS_RGN_OFC_CD)       AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                ,SUM(ASGN_TTL_QTY)         AS ASGN_TTL_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_20FT_QTY)        AS ASGN_20FT_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_40FT_QTY)        AS ASGN_40FT_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_40FT_HC_QTY)     AS ASGN_40FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_45FT_HC_QTY)     AS ASGN_45FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_53FT_QTY)        AS ASGN_53FT_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_RF_QTY)          AS ASGN_RF_QTY" ).append("\n"); 
		query.append("                ,SUM(ASGN_TTL_WGT)         AS ASGN_TTL_WGT" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_TTL_QTY)     AS BKG_AVAL_TTL_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_20FT_QTY)    AS BKG_AVAL_20FT_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_40FT_QTY)    AS BKG_AVAL_40FT_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_40FT_HC_QTY) AS BKG_AVAL_40FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_45FT_HC_QTY) AS BKG_AVAL_45FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_53FT_QTY)    AS BKG_AVAL_53FT_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_RF_QTY)      AS BKG_AVAL_RF_QTY" ).append("\n"); 
		query.append("                ,SUM(BKG_AVAL_TTL_WGT)     AS BKG_AVAL_TTL_WGT" ).append("\n"); 
		query.append("                ,MAX(MNL_ALOC_RMK)         AS MNL_ALOC_RMK" ).append("\n"); 
		query.append("                ,MAX(ALOC_USR_ID)          AS ALOC_USR_ID" ).append("\n"); 
		query.append("                ,MAX(TO_CHAR(ALOC_GDT,'YYYYMMDDHH24MI')) AS ALOC_GDT" ).append("\n"); 
		query.append("                ,MAX(SLS_AQ_CD)            AS SLS_AQ_CD" ).append("\n"); 
		query.append("                ,SUM(FCAST_TTL_QTY)        AS FCAST_TTL_QTY" ).append("\n"); 
		query.append("                ,SUM(FCAST_40FT_HC_QTY)    AS FCAST_40FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(FCAST_45FT_HC_QTY)    AS FCAST_45FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(FCAST_53FT_QTY)       AS FCAST_53FT_QTY" ).append("\n"); 
		query.append("                ,SUM(FCAST_RF_QTY)         AS FCAST_RF_QTY" ).append("\n"); 
		query.append("                ,SUM(FCAST_TTL_WGT)        AS FCAST_TTL_WGT" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_TTL_QTY)      AS USD_BKG_TTL_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_20FT_QTY)     AS USD_BKG_20FT_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_40FT_QTY)     AS USD_BKG_40FT_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_40FT_HC_QTY)  AS USD_BKG_40FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_45FT_HC_QTY)  AS USD_BKG_45FT_HC_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_53FT_QTY)     AS USD_BKG_53FT_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_RF_QTY)       AS USD_BKG_RF_QTY" ).append("\n"); 
		query.append("                ,SUM(USD_BKG_TTL_WGT)      AS USD_BKG_TTL_WGT" ).append("\n"); 
		query.append("                ,MAX(SPC_CTRL_ALOC_RMK)    AS SPC_CTRL_ALOC_RMK" ).append("\n"); 
		query.append("                ,MAX(SPC_CTRL_ALOC_POL_RMK)AS SPC_CTRL_ALOC_POL_RMK" ).append("\n"); 
		query.append("                ,MAX(SPC_CTRL_ALOC_POD_RMK)AS SPC_CTRL_ALOC_POD_RMK" ).append("\n"); 
		query.append("                ,MAX(POL_IND_SEQ)          AS POL_IND_SEQ" ).append("\n"); 
		query.append("                ,MAX(POD_IND_SEQ)          AS POD_IND_SEQ" ).append("\n"); 
		query.append("                ,MAX(POL_YD_IND_SEQ)       AS POL_YD_IND_SEQ" ).append("\n"); 
		query.append("                ,MAX(POD_YD_IND_SEQ)       AS POD_YD_IND_SEQ" ).append("\n"); 
		query.append("                ,MAX(A.CRE_USR_ID)         AS CRE_USR_ID" ).append("\n"); 
		query.append("                ,MAX(TO_CHAR(A.CRE_DT,'YYYYMMDDHH24MI')) AS CRE_DT" ).append("\n"); 
		query.append("                ,MAX(A.UPD_USR_ID)         AS UPD_USR_ID" ).append("\n"); 
		query.append("                ,MAX(TO_CHAR(A.UPD_DT,'YYYYMMDDHH24MI')) AS UPD_DT" ).append("\n"); 
		query.append("            FROM SPC_ALOC_CUST_POL_POD A, MAS_MON_VVD C" ).append("\n"); 
		query.append("           WHERE A.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("             AND A.DIR_CD     = C.DIR_CD" ).append("\n"); 
		query.append("             AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND A.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("             AND A.IOC_CD     = C.IOC_CD" ).append("\n"); 
		query.append("             AND A.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("             AND A.REP_TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("             AND SUBSTR(C.SLS_YRMON,1,4)||C.COST_WK >= @[ver_st_yrwk]" ).append("\n"); 
		query.append("             AND NVL(A.CUST_CTRL_CD,' ') <> 'C'" ).append("\n"); 
		query.append("        --   AND A.IOC_TS_CD  = 'O'" ).append("\n"); 
		query.append("        GROUP BY A.RLANE_CD" ).append("\n"); 
		query.append("                ,A.DIR_CD" ).append("\n"); 
		query.append("                ,A.VSL_CD" ).append("\n"); 
		query.append("                ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,SKD_DIR_CD" ).append("\n"); 
		query.append("                ,SLS_OFC_CD" ).append("\n"); 
		query.append("                ,POL_YD_CD" ).append("\n"); 
		query.append("                ,POD_YD_CD" ).append("\n"); 
		query.append("                ,TS_FLG" ).append("\n"); 
		query.append("                ,MNL_FLG" ).append("\n"); 
		query.append("                ,CUST_CNT_CD" ).append("\n"); 
		query.append("                ,CUST_SEQ" ).append("\n"); 
		query.append("                ,SUBSTR(CUST_CTRL_CD,1,1)" ).append("\n"); 
		query.append("                ,A.IOC_CD" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 

	}
}
