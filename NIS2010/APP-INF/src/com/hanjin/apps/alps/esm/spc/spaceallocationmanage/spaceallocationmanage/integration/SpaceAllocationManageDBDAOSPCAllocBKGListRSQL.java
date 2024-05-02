/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSPCAllocBKGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.05.19 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSPCAllocBKGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Aloc 물량 변경 시 BKG적용 후 List 조회 - SMP아님
	  * 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSPCAllocBKGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_wt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bs_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_mdfy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSPCAllocBKGListRSQL").append("\n"); 
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
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[year]        AS YEAR      ," ).append("\n"); 
		query.append("           @[week]        AS WEEK      ," ).append("\n"); 
		query.append("           O.OFC_CD       AS OFC_CD    ," ).append("\n"); 
		query.append("           @[rlane_cd]    AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[dir_cd]      AS DIR_CD    ," ).append("\n"); 
		query.append("           @[trd_cd]      AS TRD_CD     ," ).append("\n"); 
		query.append("           @[sub_trd_cd]  AS SUB_TRD_CD ,           " ).append("\n"); 
		query.append("           @[vsl_cd]      AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]  AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]  AS SKD_DIR_CD," ).append("\n"); 
		query.append("           L.CONTI_CD     AS OFC_CONTI ," ).append("\n"); 
		query.append("           @[cost_wk]     AS COST_WK   ," ).append("\n"); 
		query.append("           @[pol_cd]      AS POL_CD   ," ).append("\n"); 
		query.append("           @[pol_yd_cd]      AS POL_YD_CD   ," ).append("\n"); 
		query.append("           @[pod_cd]      AS POD_CD   ," ).append("\n"); 
		query.append("		   @[del_cd] AS DEL_CD   ," ).append("\n"); 
		query.append("           @[sls_ofc_cd]      AS V_OFC_CD     ," ).append("\n"); 
		query.append("           SUBSTR(@[ioc_cd],1,1)      AS IOC_CD     ," ).append("\n"); 
		query.append("           @[ctrl_lvl] AS CHECK_LVL," ).append("\n"); 
		query.append("           @[us_mod]      AS IPI_CD     ," ).append("\n"); 
		query.append("           'N'            AS SMP_FLG    ," ).append("\n"); 
		query.append("           @[asgn_ttl_qty] AS ALOC_ORG   ," ).append("\n"); 
		query.append("           @[asgn_ttl_wgt] AS ALOC_ORG_WGT   ," ).append("\n"); 
		query.append("           @[aloc_mdfy]   AS ALOC_DIF   ," ).append("\n"); 
		query.append("		   @[usd_bkg_ttl_qty] AS USD_BKG_QTY," ).append("\n"); 
		query.append("		   @[usd_bkg_ttl_wgt] AS USD_BKG_WGT," ).append("\n"); 
		query.append("		   @[bs_teu] AS BS_TEU," ).append("\n"); 
		query.append("		   @[bs_wgt] AS BS_WGT," ).append("\n"); 
		query.append("		   @[ctrl_wt] AS CTRL_WGT," ).append("\n"); 
		query.append("           '2'            AS STS," ).append("\n"); 
		query.append("           'N'            AS ALL_POL" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("        AND O.OFC_CD = 'SHARC'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", REP_VVDS AS (" ).append("\n"); 
		query.append("    SELECT V.TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD," ).append("\n"); 
		query.append("           V.DIR_CD  ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("           V.SLS_YRMON," ).append("\n"); 
		query.append("           V.COST_WK             ," ).append("\n"); 
		query.append("           V.VSL_CD              ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO          ," ).append("\n"); 
		query.append("           V.DIR_CD SKD_DIR_CD   ," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("           P.OFC_CD              ," ).append("\n"); 
		query.append("           P.OFC_CONTI           ," ).append("\n"); 
		query.append("           P.STS                 ," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                      DECODE(NVL(MAX(CO.CTRL_LVL_CD), 'L'), 'O', DECODE(NVL(MAX(CO.CTRL_ACCT_FLG), 'N'),'Y','A'," ).append("\n"); 
		query.append("                                              DECODE(NVL(MAX(CO.CTRL_USA_SVC_MOD_FLG), 'N'),'Y','U','O'))," ).append("\n"); 
		query.append("                                                 NVL(MAX(CO.CTRL_LVL_CD), 'L')) " ).append("\n"); 
		query.append("                FROM SPC_ALOC_CTRL_OPT CO" ).append("\n"); 
		query.append("               WHERE CO.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                 AND V.IOC_CD = 'I'" ).append("\n"); 
		query.append("                 AND CO.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND CO.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                 AND CO.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND CO.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("           ) AS CTRL_LVL, " ).append("\n"); 
		query.append("		   DECODE(NVL(A.CTRL_LVL_CD, 'N') ,'T', NVL(DECODE(A.CTRL_ECC_FLG,'Y','E',DECODE(A.CTRL_ECC_GRP_FLG,'Y','G','N')),'N'), 'N' )AS CTRL_DEST, -- C = COUNTRY, L = LOCATION" ).append("\n"); 
		query.append("           NVL(A.CTRL_DEST_LVL_CD, 'N')     AS CTRL_DEST_LVL  ,                                     -- D = BKG_POD, T = BKG_DEL" ).append("\n"); 
		query.append("           NVL(A.CTRL_USA_SVC_MOD_FLG, 'N') AS CTRL_USA,                                            -- Y = LOCAL/IPI" ).append("\n"); 
		query.append("           NVL(A.CTRL_ACCT_FLG, 'N')        AS CTRL_ACCOUNT," ).append("\n"); 
		query.append("           NVL(A.CTRL_FX_RT_FLG, 'N')       AS CTRL_FX_RT_FLG," ).append("\n"); 
		query.append("           CASE WHEN V.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                THEN CEIL(TO_NUMBER(SUBSTR(V.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                ELSE CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("           END BSE_QTR_CD," ).append("\n"); 
		query.append("           V.N1ST_LODG_PORT_ETD_DT AS FL_ETD_DT  " ).append("\n"); 
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT A" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND V.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N' OR EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                                 FROM MAS_MON_VVD N" ).append("\n"); 
		query.append("                                                                WHERE N.RLANE_CD   = V.RLANE_CD -- 2012.12.07 SLANE_CD를 RLANE_CD로 변경" ).append("\n"); 
		query.append("                                                                  AND N.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                                                  AND N.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                  AND N.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                                                  AND N.DELT_FLG   = 'N'))" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND A.RLANE_CD  (+) = P.RLANE_CD" ).append("\n"); 
		query.append("       AND A.DIR_CD    (+) = P.DIR_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD    (+) = P.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO(+) = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD(+) = P.SKD_DIR_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CTRT_OPT_DTL AS (" ).append("\n"); 
		query.append("-- SPC_ALOC_LANE_CTRL_OPT_DTL 테이블의 계약 정보를 가지고 온다." ).append("\n"); 
		query.append("SELECT DISTINCT  " ).append("\n"); 
		query.append("       A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A2.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,A2.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("      ,A1.FL_ETD_DT" ).append("\n"); 
		query.append("  FROM REP_VVDS A1" ).append("\n"); 
		query.append("      ,SPC_ALOC_LANE_CTRL_OPT_DTL A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.REP_TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.REP_SUB_TRD_CD   = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD         = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD           = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.CTRL_ACCOUNT     = 'Y'" ).append("\n"); 
		query.append("   AND A1.CTRL_FX_RT_FLG   = 'Y'" ).append("\n"); 
		query.append("   AND A2.CTRL_FX_RT_FLG   = 'Y'" ).append("\n"); 
		query.append("   AND A2.ALOC_CTRL_TP_CD  = 'F'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CTRT_DTL_INFO AS (" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("           A5.TRD_CD" ).append("\n"); 
		query.append("          ,A5.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A5.RLANE_CD" ).append("\n"); 
		query.append("          ,A5.DIR_CD" ).append("\n"); 
		query.append("          ,A5.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("          ,A5.CTRL_LOC_ACCT_CD " ).append("\n"); 
		query.append("          ,A1.PROP_NO" ).append("\n"); 
		query.append("          ,A2.AMDT_SEQ" ).append("\n"); 
		query.append("          ,A3.SVC_SCP_CD" ).append("\n"); 
		query.append("          ,A4.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("          ,A4.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("          ,A2.REAL_CUST_CNT_CD || LPAD(A2.REAL_CUST_SEQ,'6','0') CUST_CD" ).append("\n"); 
		query.append("          ,A4.FX_RT_FLG" ).append("\n"); 
		query.append("          ,A2.EFF_DT" ).append("\n"); 
		query.append("          ,A2.EXP_DT" ).append("\n"); 
		query.append("          ,A2.PROP_STS_CD" ).append("\n"); 
		query.append("      FROM CTRT_OPT_DTL A5" ).append("\n"); 
		query.append("          ,PRI_SP_HDR A1" ).append("\n"); 
		query.append("          ,PRI_SP_MN  A2" ).append("\n"); 
		query.append("          ,PRI_SP_SCP_MN A3" ).append("\n"); 
		query.append("          ,PRI_SP_SCP_RT_CMDT_HDR A4 " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A1.SC_NO             = A5.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("       AND A1.PROP_NO           = A2.PROP_NO" ).append("\n"); 
		query.append("       AND A2.PROP_STS_CD       = 'F' -- A, F, Q" ).append("\n"); 
		query.append("       AND TRUNC(A5.FL_ETD_DT) BETWEEN A2.EFF_DT AND A2.EXP_DT" ).append("\n"); 
		query.append("       AND A2.PROP_NO           = A3.PROP_NO" ).append("\n"); 
		query.append("       AND A2.AMDT_SEQ          = A3.AMDT_SEQ" ).append("\n"); 
		query.append("       AND A3.PROP_NO           = A4.PROP_NO" ).append("\n"); 
		query.append("       AND A3.AMDT_SEQ          = A4.AMDT_SEQ" ).append("\n"); 
		query.append("       AND A3.SVC_SCP_CD        = A4.SVC_SCP_CD" ).append("\n"); 
		query.append("       AND NVL(A4.FX_RT_FLG,'N')= 'Y'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(", ALOC_LANE_CTRL_OPT_DTL AS (" ).append("\n"); 
		query.append("SELECT DISTINCT B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.DIR_CD" ).append("\n"); 
		query.append("--      ,B1.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("--      ,B3.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,NVL(B3.ALOC_CTRL_TP_CD, B1.ALOC_CTRL_TP_CD) AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("      ,B1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("      ,B1.SC_NO" ).append("\n"); 
		query.append("      ,B1.RFA_NO" ).append("\n"); 
		query.append("      ,NVL(B3.ALOC_CTRL_DTL_CD, B1.ALOC_CTRL_DTL_CD) AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       SPC_ALOC_LANE_CTRL_OPT_DTL B1" ).append("\n"); 
		query.append("      ,REP_VVDS B2" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        -- Actual Account 정보 추출" ).append("\n"); 
		query.append("        SELECT distinct" ).append("\n"); 
		query.append("               A1.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.DIR_CD" ).append("\n"); 
		query.append("              ,'B' AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("              ,A1.ALOC_CTRL_TP_CD AS ORG_ALOC_CTRL_TP_CD-- B : A/Acct, C : Commodity, F : Fixed" ).append("\n"); 
		query.append("              ,A1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              ,A1.PROP_NO" ).append("\n"); 
		query.append("              ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,A2.CUST_CNT_CD || LPAD(A2.CUST_SEQ,'6','0') AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("          FROM CTRT_DTL_INFO A1" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT_ACT_CUST A2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.PROP_NO           = A2.PROP_NO" ).append("\n"); 
		query.append("           AND A1.AMDT_SEQ          = A2.AMDT_SEQ" ).append("\n"); 
		query.append("           AND A1.SVC_SCP_CD        = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.GEN_SPCL_RT_TP_CD = A2.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("           AND A1.CMDT_HDR_SEQ      = A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- CMDT 정보 추출" ).append("\n"); 
		query.append("        SELECT distinct" ).append("\n"); 
		query.append("               A1.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.DIR_CD" ).append("\n"); 
		query.append("              ,'C' AS ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("              ,A1.ALOC_CTRL_TP_CD AS ORG_ALOC_CTRL_TP_CD -- B : A/Acct, C : Commodity, F : Fixed" ).append("\n"); 
		query.append("              ,A1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              ,A1.PROP_NO" ).append("\n"); 
		query.append("              ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,DECODE(A2.PRC_CMDT_TP_CD,'C', A2.PRC_CMDT_DEF_CD, 'G', A4.PRC_CMDT_DEF_CD) AS ALOC_CTRL_DTL_CD" ).append("\n"); 
		query.append("          FROM CTRT_DTL_INFO A1" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_RT_CMDT     A2" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_GRP_CMDT    A3" ).append("\n"); 
		query.append("              ,PRI_SP_SCP_GRP_CMDT_DTL A4  " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.PROP_NO           = A2.PROP_NO" ).append("\n"); 
		query.append("           AND A1.AMDT_SEQ          = A2.AMDT_SEQ" ).append("\n"); 
		query.append("           AND A1.SVC_SCP_CD        = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND A1.GEN_SPCL_RT_TP_CD = A2.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("           AND A1.CMDT_HDR_SEQ      = A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("           AND A2.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A2.PROP_NO           = A3.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A2.AMDT_SEQ          = A3.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A2.SVC_SCP_CD        = A3.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A2.PRC_CMDT_DEF_CD   = A3.PRC_GRP_CMDT_CD(+)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND A3.PROP_NO           = A4.PROP_NO(+)" ).append("\n"); 
		query.append("           AND A3.AMDT_SEQ          = A4.AMDT_SEQ(+)" ).append("\n"); 
		query.append("           AND A3.SVC_SCP_CD        = A4.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("           AND A3.GRP_CMDT_SEQ      = A4.GRP_CMDT_SEQ(+)   " ).append("\n"); 
		query.append("           AND A4.SRC_INFO_CD(+)    <> 'AD'" ).append("\n"); 
		query.append("         GROUP BY A1.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.DIR_CD" ).append("\n"); 
		query.append("              ,A1.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("              ,A1.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("              ,A1.PROP_NO" ).append("\n"); 
		query.append("              ,A1.AMDT_SEQ" ).append("\n"); 
		query.append("              ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,DECODE(A2.PRC_CMDT_TP_CD,'C', A2.PRC_CMDT_DEF_CD, 'G', A4.PRC_CMDT_DEF_CD)       " ).append("\n"); 
		query.append("       ) B3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B2.REP_TRD_CD       = B1.TRD_CD" ).append("\n"); 
		query.append("   AND B2.REP_SUB_TRD_CD   = B1.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND B2.RLANE_CD         = B1.RLANE_CD" ).append("\n"); 
		query.append("   AND B2.DIR_CD           = B1.DIR_CD" ).append("\n"); 
		query.append("   AND B1.TRD_CD           = B3.TRD_CD(+)" ).append("\n"); 
		query.append("   AND B1.SUB_TRD_CD       = B3.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("   AND B1.RLANE_CD         = B3.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND B1.DIR_CD           = B3.DIR_CD(+)" ).append("\n"); 
		query.append("   AND B1.ALOC_CTRL_TP_CD  = B3.ORG_ALOC_CTRL_TP_CD(+)" ).append("\n"); 
		query.append("   AND B1.CTRL_LOC_ACCT_CD = B3.CTRL_LOC_ACCT_CD(+)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT V.REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD      ," ).append("\n"); 
		query.append("           V.DIR_CD        ," ).append("\n"); 
		query.append("           V.COST_YR       ," ).append("\n"); 
		query.append("           V.COST_MON      ," ).append("\n"); 
		query.append("           V.COST_WK       ," ).append("\n"); 
		query.append("           V.VSL_CD        ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           V.SKD_DIR_CD    ," ).append("\n"); 
		query.append("           VPS.VPS_PORT_CD ," ).append("\n"); 
		query.append("           VPS.YD_CD AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           VPS.TURN_PORT_IND_CD AS PORT_IND," ).append("\n"); 
		query.append("           SPC_CONTI_CONV_FNC(L.CONTI_CD, V.RLANE_CD, V.DIR_CD) AS CONTI_CD," ).append("\n"); 
		query.append("           DECODE(SIGN(VPS.VPS_ETD_DT - GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYS_EXTRACT_UTC(SYSTIMESTAMP), VPS.VPS_PORT_CD)), -1, 'Y', 'N') AS PORT_PAST," ).append("\n"); 
		query.append("           VPS.VPS_ETA_DT AS ETA_DT," ).append("\n"); 
		query.append("           VPS.VPS_ETD_DT AS ETD_DT," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_CD      ," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_ETD_DT  ," ).append("\n"); 
		query.append("           V.OFC_CD                ," ).append("\n"); 
		query.append("           V.OFC_CONTI             ," ).append("\n"); 
		query.append("           V.STS                   ," ).append("\n"); 
		query.append("			  V.BSE_QTR_CD ," ).append("\n"); 
		query.append("           DECODE(VPS.SKD_CNG_STS_CD, 'S', 1, 0) AS SKIPPED," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ," ).append("\n"); 
		query.append("           COUNT(*) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS PORT_CNT," ).append("\n"); 
		query.append("           VPS.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L  ," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           REP_VVDS         V" ).append("\n"); 
		query.append("     WHERE L.LOC_CD       = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VPS.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVD_POL_POD AS (" ).append("\n"); 
		query.append("    SELECT A.REP_TRD_CD          ," ).append("\n"); 
		query.append("           A.REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("           A.RLANE_CD            ," ).append("\n"); 
		query.append("           A.DIR_CD              ," ).append("\n"); 
		query.append("           TRD_CD              ," ).append("\n"); 
		query.append("           SUB_TRD_CD          ," ).append("\n"); 
		query.append("           COST_YR             ," ).append("\n"); 
		query.append("           COST_MON            ," ).append("\n"); 
		query.append("           COST_WK             ," ).append("\n"); 
		query.append("           VSL_CD              ," ).append("\n"); 
		query.append("           SKD_VOY_NO          ," ).append("\n"); 
		query.append("           SKD_DIR_CD          ," ).append("\n"); 
		query.append("           POL_CD              ," ).append("\n"); 
		query.append("           POL_SEQ             ," ).append("\n"); 
		query.append("           POL_CONTI           ," ).append("\n"); 
		query.append("           POL_PAST            ," ).append("\n"); 
		query.append("           POL_ETA_DT          ," ).append("\n"); 
		query.append("           POL_ETD_DT          ," ).append("\n"); 
		query.append("           POD_CD              ," ).append("\n"); 
		query.append("           POD_SEQ             ," ).append("\n"); 
		query.append("           POD_CONTI           ," ).append("\n"); 
		query.append("           POD_PAST            ," ).append("\n"); 
		query.append("           POD_ETA_DT          ," ).append("\n"); 
		query.append("           POD_ETD_DT          ," ).append("\n"); 
		query.append("           IOC_CD              ," ).append("\n"); 
		query.append("           PAST                ," ).append("\n"); 
		query.append("           LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("           LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("           OFC_CD              ," ).append("\n"); 
		query.append("           OFC_CONTI           ," ).append("\n"); 
		query.append("           STS                 ," ).append("\n"); 
		query.append("           POL_SKIP            ," ).append("\n"); 
		query.append("           POD_SKIP            ," ).append("\n"); 
		query.append("           LD_PORT             ," ).append("\n"); 
		query.append("           PL_PORT_CNT         ," ).append("\n"); 
		query.append("           PD_PORT_CNT         ," ).append("\n"); 
		query.append("		   BSE_QTR_CD          ," ).append("\n"); 
		query.append("           PL_VPS_PORT_CD      , " ).append("\n"); 
		query.append("           PD_VPS_PORT_CD      ,                " ).append("\n"); 
		query.append("           PL_CLPT_IND_SEQ     ,        " ).append("\n"); 
		query.append("           PD_CLPT_IND_SEQ     ," ).append("\n"); 
		query.append("           PL_PD_PORT_CNT" ).append("\n"); 
		query.append("		  , PL_SKD_CNG_STS_CD" ).append("\n"); 
		query.append("          , MAX(PL_PORT_CNT) OVER (PARTITION BY POL_CD) AS MAX_POL_PORT_SEQ" ).append("\n"); 
		query.append("          , MAX(PD_PORT_CNT) OVER (PARTITION BY POD_CD) AS MAX_POD_PORT_SEQ" ).append("\n"); 
		query.append("          , POL_YD_SEQ" ).append("\n"); 
		query.append("          , POD_YD_SEQ" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT REP_TRD_CD          ," ).append("\n"); 
		query.append("                     REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("                     RLANE_CD            ," ).append("\n"); 
		query.append("                     DIR_CD              ," ).append("\n"); 
		query.append("                     TRD_CD              ," ).append("\n"); 
		query.append("                     SUB_TRD_CD          ," ).append("\n"); 
		query.append("                     COST_YR             ," ).append("\n"); 
		query.append("                     COST_MON            ," ).append("\n"); 
		query.append("                     COST_WK             ," ).append("\n"); 
		query.append("                     VSL_CD              ," ).append("\n"); 
		query.append("                     SKD_VOY_NO          ," ).append("\n"); 
		query.append("                     SKD_DIR_CD          ," ).append("\n"); 
		query.append("                     POL_CD,POL_SEQ      ," ).append("\n"); 
		query.append("                     POL_CONTI           ," ).append("\n"); 
		query.append("                     POL_PAST            ," ).append("\n"); 
		query.append("                     POL_ETA_DT          ," ).append("\n"); 
		query.append("                     POL_ETD_DT          ," ).append("\n"); 
		query.append("                     POD_CD              ," ).append("\n"); 
		query.append("                     POD_SEQ             ," ).append("\n"); 
		query.append("                     POD_CONTI           ," ).append("\n"); 
		query.append("                     POD_PAST            ," ).append("\n"); 
		query.append("                     POD_ETA_DT          ," ).append("\n"); 
		query.append("                     POD_ETD_DT          ," ).append("\n"); 
		query.append("                     IOC_CD              ," ).append("\n"); 
		query.append("                     PAST                ," ).append("\n"); 
		query.append("                     LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("                     LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                     OFC_CD              ," ).append("\n"); 
		query.append("                     OFC_CONTI           ," ).append("\n"); 
		query.append("                     STS                 ," ).append("\n"); 
		query.append("                     POL_SKIP            ," ).append("\n"); 
		query.append("                     POD_SKIP            ," ).append("\n"); 
		query.append("                     LD_PORT             ," ).append("\n"); 
		query.append("                     PL_PORT_CNT         ," ).append("\n"); 
		query.append("                     PD_PORT_CNT         ," ).append("\n"); 
		query.append("                     PL_PD_PORT_CNT      , " ).append("\n"); 
		query.append("					 BSE_QTR_CD          , " ).append("\n"); 
		query.append("                     PL_VPS_PORT_CD      , " ).append("\n"); 
		query.append("                     PD_VPS_PORT_CD      ,                " ).append("\n"); 
		query.append("                     PL_CLPT_IND_SEQ     ,        " ).append("\n"); 
		query.append("                     PD_CLPT_IND_SEQ     ,       " ).append("\n"); 
		query.append("                     PL_SKD_CNG_STS_CD   ," ).append("\n"); 
		query.append("                     POL_YD_SEQ," ).append("\n"); 
		query.append("                     POD_YD_SEQ," ).append("\n"); 
		query.append("                     MAX(PL_PD_PORT_CNT) OVER (PARTITION BY PL_VPS_PORT_CD,PL_CLPT_IND_SEQ,PD_VPS_PORT_CD,PD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                                                   ORDER BY PL_VPS_PORT_CD,PL_CLPT_IND_SEQ,PD_VPS_PORT_CD,PD_CLPT_IND_SEQ ) AS PL_PD_PORT_MAX" ).append("\n"); 
		query.append("                     --MAX(PL_PD_PORT_CNT) OVER (PARTITION BY POL_CD,POD_CD ORDER BY POL_CD,POD_CD) AS PL_PD_PORT_MAX" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT PL.REP_TRD_CD    ," ).append("\n"); 
		query.append("                               PL.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                               PL.RLANE_CD      ," ).append("\n"); 
		query.append("                               PL.DIR_CD        ," ).append("\n"); 
		query.append("                               DRL.TRD_CD       ," ).append("\n"); 
		query.append("                               DRL.SUB_TRD_CD   ," ).append("\n"); 
		query.append("                               PL.COST_YR       ," ).append("\n"); 
		query.append("                               PL.COST_MON      ," ).append("\n"); 
		query.append("                               PL.COST_WK       ," ).append("\n"); 
		query.append("                               PL.VSL_CD        ," ).append("\n"); 
		query.append("                               PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                               PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                               PL.PORT_CD         AS POL_CD    ," ).append("\n"); 
		query.append("                               MAX(PL.PORT_SEQ)   AS POL_SEQ   ," ).append("\n"); 
		query.append("                               PL.CONTI_CD        AS POL_CONTI ," ).append("\n"); 
		query.append("                               MIN(PL.PORT_PAST)  AS POL_PAST  ," ).append("\n"); 
		query.append("                               PL.ETA_DT          AS POL_ETA_DT," ).append("\n"); 
		query.append("                               PL.ETD_DT          AS POL_ETD_DT," ).append("\n"); 
		query.append("                               PD.PORT_CD         AS POD_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                               PL.VPS_PORT_CD     AS PL_VPS_PORT_CD , " ).append("\n"); 
		query.append("                               PD.VPS_PORT_CD     AS PD_VPS_PORT_CD , " ).append("\n"); 
		query.append("                               PL.CLPT_IND_SEQ    AS PL_CLPT_IND_SEQ , " ).append("\n"); 
		query.append("                               PD.CLPT_IND_SEQ    AS PD_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("                               PL.SKD_CNG_STS_CD  AS PL_SKD_CNG_STS_CD, " ).append("\n"); 
		query.append("                               PL.CALL_YD_IND_SEQ AS POL_YD_SEQ," ).append("\n"); 
		query.append("                               PD.CALL_YD_IND_SEQ AS POD_YD_SEQ," ).append("\n"); 
		query.append("                               --MIN(PD.PORT_SEQ) AS POD_SEQ   ," ).append("\n"); 
		query.append("                               (CASE" ).append("\n"); 
		query.append("                                     WHEN MAX(PL.PORT_SEQ) < MAX(PD.MIN_SEQ) THEN MAX(PD.MIN_SEQ)" ).append("\n"); 
		query.append("                                     ELSE CASE" ).append("\n"); 
		query.append("                                     	  	WHEN MAX(PL.PORT_SEQ) > MAX(PD.MIN_SEQ) THEN MAX(PD.MAX_SEQ)" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                 END) AS POD_SEQ ," ).append("\n"); 
		query.append("                               --MAX(PL.MAX_SEQ) ," ).append("\n"); 
		query.append("                               --MAX(PL.PORT_CNT)," ).append("\n"); 
		query.append("                               PD.CONTI_CD       AS POD_CONTI ," ).append("\n"); 
		query.append("                               MIN(PD.PORT_PAST) AS POD_PAST  ," ).append("\n"); 
		query.append("                               PD.ETA_DT         AS POD_ETA_DT," ).append("\n"); 
		query.append("                               PD.ETD_DT         AS POD_ETD_DT," ).append("\n"); 
		query.append("                               DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')            AS IOC_CD," ).append("\n"); 
		query.append("                               DECODE(PL.STS, '1', PL.PORT_PAST, '2', 'N', '3', 'Y') AS PAST  ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                               PL.OFC_CD              ," ).append("\n"); 
		query.append("                               PL.OFC_CONTI           ," ).append("\n"); 
		query.append("                               PL.STS                 ," ).append("\n"); 
		query.append("                               PL.SKIPPED  AS POL_SKIP," ).append("\n"); 
		query.append("                               PD.SKIPPED  AS POD_SKIP," ).append("\n"); 
		query.append("                               SUBSTR(( SELECT MAX(LTRIM(TO_CHAR(S1.PORT_SEQ,'FM000'))|| S1.PORT_CD)" ).append("\n"); 
		query.append("                                          FROM VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                                         WHERE S1.SKIPPED <> 1), 4) AS LD_PORT," ).append("\n"); 
		query.append("                               PL.PORT_CNT AS PL_PORT_CNT," ).append("\n"); 
		query.append("                               PD.PORT_CNT AS PD_PORT_CNT," ).append("\n"); 
		query.append("										 PL.BSE_QTR_CD ," ).append("\n"); 
		query.append("                               ROW_NUMBER()OVER (PARTITION BY PL.PORT_CD,PD.PORT_CD ORDER BY PL.PORT_CD,PD.PORT_CD) AS PL_PD_PORT_CNT" ).append("\n"); 
		query.append("                          FROM MDM_DTL_REV_LANE DRL," ).append("\n"); 
		query.append("                               VSL_PORT_SKD     PD ," ).append("\n"); 
		query.append("                               VSL_PORT_SKD     PL" ).append("\n"); 
		query.append("                         WHERE DRL.RLANE_CD        = PL.RLANE_CD" ).append("\n"); 
		query.append("                           AND DRL.VSL_SLAN_DIR_CD = PL.DIR_CD" ).append("\n"); 
		query.append("                           AND DRL.FM_CONTI_CD     = PL.CONTI_CD" ).append("\n"); 
		query.append("                           AND DRL.TO_CONTI_CD     = PD.CONTI_CD" ).append("\n"); 
		query.append("                           AND PD.REP_TRD_CD       = PL.REP_TRD_CD" ).append("\n"); 
		query.append("                           AND PD.REP_SUB_TRD_CD   = PL.REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                           AND PD.RLANE_CD         = PL.RLANE_CD" ).append("\n"); 
		query.append("                           AND PD.VSL_CD           = PL.VSL_CD " ).append("\n"); 
		query.append("                           AND PD.SKD_VOY_NO       = PL.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND PD.SKD_DIR_CD       = PL.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND PD.PORT_CD         <> PL.PORT_CD" ).append("\n"); 
		query.append("                           AND PD.PORT_SEQ         > PL.PORT_SEQ" ).append("\n"); 
		query.append("                           AND (    PL.PORT_SEQ = DECODE(PL.CONTI_CD, PD.CONTI_CD, PL.MIN_SEQ, PL.MAX_SEQ)  --  단독 CALLING 또는 DOUBLE CALLING 인데 마지막 PORT 경우는 모두" ).append("\n"); 
		query.append("                                 OR PD.PORT_SEQ < PL.MAX_SEQ ) -- DOUBLE CALLING PORT중 POD 가 LAST DOUBLE CALLING PORT 보다 앞인 경우만 FILTERING" ).append("\n"); 
		query.append("                      GROUP BY " ).append("\n"); 
		query.append("                               PL.REP_TRD_CD    ," ).append("\n"); 
		query.append("                               PL.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                               PL.RLANE_CD      ," ).append("\n"); 
		query.append("                               PL.DIR_CD        ," ).append("\n"); 
		query.append("                               DRL.TRD_CD       ," ).append("\n"); 
		query.append("                               DRL.SUB_TRD_CD   ," ).append("\n"); 
		query.append("                               PL.COST_YR       ," ).append("\n"); 
		query.append("                               PL.COST_MON      ," ).append("\n"); 
		query.append("                               PL.COST_WK       ," ).append("\n"); 
		query.append("                               PL.VSL_CD        ," ).append("\n"); 
		query.append("                               PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                               PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                               PL.PORT_CD       ," ).append("\n"); 
		query.append("                               PL.CONTI_CD      ," ).append("\n"); 
		query.append("                               PD.PORT_CD       ," ).append("\n"); 
		query.append("                               PD.CONTI_CD      ," ).append("\n"); 
		query.append("                               PL.SKIPPED       ," ).append("\n"); 
		query.append("                               PD.SKIPPED       ," ).append("\n"); 
		query.append("                               PL.ETA_DT        ," ).append("\n"); 
		query.append("                               PL.ETD_DT        ," ).append("\n"); 
		query.append("                               PD.ETA_DT        ," ).append("\n"); 
		query.append("                               PD.ETD_DT        ," ).append("\n"); 
		query.append("                               DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')           ," ).append("\n"); 
		query.append("                               DECODE(PL.STS, '1', PL.PORT_PAST, '2', 'N', '3', 'Y')," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                               PL.OFC_CD              ," ).append("\n"); 
		query.append("                               PL.OFC_CONTI           ," ).append("\n"); 
		query.append("                               PL.STS                 ," ).append("\n"); 
		query.append("                               PL.VPS_PORT_CD  , " ).append("\n"); 
		query.append("                               PD.VPS_PORT_CD  , " ).append("\n"); 
		query.append("                               PL.CLPT_IND_SEQ        , " ).append("\n"); 
		query.append("                               PD.CLPT_IND_SEQ , " ).append("\n"); 
		query.append("                               PL.SKD_CNG_STS_CD," ).append("\n"); 
		query.append("                               PL.PORT_CNT            ," ).append("\n"); 
		query.append("                               PD.PORT_CNT," ).append("\n"); 
		query.append("							   PL.BSE_QTR_CD," ).append("\n"); 
		query.append("                               PL.CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("                               PD.CALL_YD_IND_SEQ                     )" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("     WHERE A.PL_PD_PORT_CNT = PL_PD_PORT_MAX" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUM( BKG_TTL_QTY ) BKG_TTL_QTY" ).append("\n"); 
		query.append("           , SUM( BKG_S_TTL_QTY ) BKG_SB_QTY" ).append("\n"); 
		query.append("		   , SUM( BKG_TTL_WGT ) BKG_TTL_WGT" ).append("\n"); 
		query.append("           , SUM( BKG_S_TTL_WGT ) BKG_SB_WGT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT 	BASE_RHQ_CD," ).append("\n"); 
		query.append("            SLS_OFC_CD," ).append("\n"); 
		query.append("            BKG_NO," ).append("\n"); 
		query.append("--            ALOC_STS_CD         , --2015.03.12" ).append("\n"); 
		query.append("            DECODE( ALOC_STS_CD , 'F' , TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) , 0 ) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("            DECODE( ALOC_STS_CD , 'S' , TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) ,'A' , TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) , 0 ) AS BKG_S_TTL_QTY ," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)) AS BKG_D2FT_QTY   ," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)) AS BKG_D4FT_QTY   ," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("--            TO_NUMBER(NVL(SUBSTR(VAL, 113, 14), 0)) AS BKG_RF_QTY     ," ).append("\n"); 
		query.append("--             TO_NUMBER(NVL(SUBSTR(VAL, 127, 14), 0)) AS BKG_RD_QTY     ," ).append("\n"); 
		query.append("            DECODE( ALOC_STS_CD , 'F' , TO_NUMBER(NVL(SUBSTR(VAL, 141, 14), 0)) , 0 ) AS BKG_TTL_WGT ," ).append("\n"); 
		query.append("            DECODE( ALOC_STS_CD , 'S' , TO_NUMBER(NVL(SUBSTR(VAL,  141, 14), 0)) ,'A' , TO_NUMBER(NVL(SUBSTR(VAL,  141, 14), 0)) , 0 ) AS BKG_S_TTL_WGT" ).append("\n"); 
		query.append("		    FROM (" ).append("\n"); 
		query.append("				SELECT" ).append("\n"); 
		query.append("					   VPP.OFC_CD   AS BASE_RHQ_CD," ).append("\n"); 
		query.append("                       O.N4TH_PRNT_OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("					   B.BKG_NO ," ).append("\n"); 
		query.append("--					   VPP.COST_YR       ," ).append("\n"); 
		query.append("--					   VPP.COST_WK       ," ).append("\n"); 
		query.append("					   DECODE(BV.VSL_PRE_PST_CD, 'T', VPP.IOC_CD, 'T') AS IOC_CD     ," ).append("\n"); 
		query.append("                       CASE WHEN M.CTRL_USA = 'Y' AND (SUBSTR(B.POL_CD,1,2) IN ('US','CA') OR SUBSTR(B.POD_CD,1,2) IN ('US','CA')) THEN" ).append("\n"); 
		query.append("					   		NVL(SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POL_CD, B.POL_CD, B.POD_CD, B.DEL_CD),'OTHERS') " ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("							'OTHERS'" ).append("\n"); 
		query.append("					   END AS US_MOD," ).append("\n"); 
		query.append("					   CASE WHEN M.CTRL_ACCOUNT = 'Y' THEN" ).append("\n"); 
		query.append("							NVL((" ).append("\n"); 
		query.append("                               -- A : Individul B: Actual C: Commodity" ).append("\n"); 
		query.append("									SELECT DISTINCT(D.CTRL_LOC_ACCT_CD)" ).append("\n"); 
		query.append("									  FROM ALOC_LANE_CTRL_OPT_DTL D" ).append("\n"); 
		query.append("									 WHERE D.RLANE_CD           = M.RLANE_CD " ).append("\n"); 
		query.append("									   AND D.TRD_CD             = SPC_GET_REP_TRD_FNC(M.RLANE_CD)" ).append("\n"); 
		query.append("									   AND D.SUB_TRD_CD         = SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD)" ).append("\n"); 
		query.append("									   AND D.DIR_CD             = M.SKD_DIR_CD" ).append("\n"); 
		query.append("									   AND D.ALOC_CTRL_TP_CD    IN ('A','B','C') " ).append("\n"); 
		query.append("                                       AND (( SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) IN " ).append("\n"); 
		query.append("                                          (SELECT OFC.OFC_CD" ).append("\n"); 
		query.append("                                             FROM SPC_ALOC_LANE_CTRL_OFC OFC" ).append("\n"); 
		query.append("                                            WHERE D.RLANE_CD           = OFC.RLANE_CD" ).append("\n"); 
		query.append("                                              AND D.TRD_CD             = OFC.TRD_CD" ).append("\n"); 
		query.append("                                              AND D.SUB_TRD_CD         = OFC.SUB_TRD_CD" ).append("\n"); 
		query.append("                                              AND D.DIR_CD             = OFC.DIR_CD " ).append("\n"); 
		query.append("                                              AND D.ALOC_CTRL_TP_CD    = OFC.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("                                              AND D.CTRL_LOC_ACCT_CD   = OFC.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                                        ))" ).append("\n"); 
		query.append("                                        OR ( NOT EXISTS " ).append("\n"); 
		query.append("                                         ( SELECT 1" ).append("\n"); 
		query.append("                                             FROM SPC_ALOC_LANE_CTRL_OFC OFC_ALL" ).append("\n"); 
		query.append("                                            WHERE D.RLANE_CD           = OFC_ALL.RLANE_CD" ).append("\n"); 
		query.append("                                              AND D.TRD_CD             = OFC_ALL.TRD_CD" ).append("\n"); 
		query.append("                                              AND D.SUB_TRD_CD         = OFC_ALL.SUB_TRD_CD" ).append("\n"); 
		query.append("                                              AND D.DIR_CD             = OFC_ALL.DIR_CD " ).append("\n"); 
		query.append("                                              AND D.ALOC_CTRL_TP_CD    = OFC_ALL.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("                                              AND D.CTRL_LOC_ACCT_CD   = OFC_ALL.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                       )) " ).append("\n"); 
		query.append("									   -- 2015.02.16 add end" ).append("\n"); 
		query.append("									   AND (D.CTRL_LOC_ACCT_CD = B.SC_NO OR D.CTRL_LOC_ACCT_CD = B.RFA_NO)" ).append("\n"); 
		query.append("									   AND D.ALOC_CTRL_DTL_CD  = DECODE(D.ALOC_CTRL_TP_CD, 'A', B.CTRT_CUST_CNT_CD ||LPAD(B.CTRT_CUST_SEQ,6,'0')," ).append("\n"); 
		query.append("                                                                                       	   'B', B.AGMT_ACT_CNT_CD ||LPAD(B.AGMT_ACT_CUST_SEQ,6,'0')," ).append("\n"); 
		query.append("                                                                                           'C', B.CMDT_CD)                                     " ).append("\n"); 
		query.append("                               ),'OTHERS')" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                                'OTHERS'" ).append("\n"); 
		query.append("                        END AS ACCOUNT_CD," ).append("\n"); 
		query.append("                        CASE WHEN M.CTRL_DEST <> 'N' THEN	                                                      " ).append("\n"); 
		query.append("                            NVL((" ).append("\n"); 
		query.append("                                SELECT DISTINCT(D.CTRL_LOC_ACCT_CD)" ).append("\n"); 
		query.append("                                  FROM SPC_ALOC_LANE_CTRL_OPT_DTL D" ).append("\n"); 
		query.append("                                 WHERE D.RLANE_CD			= M.RLANE_CD" ).append("\n"); 
		query.append("                                   AND D.TRD_CD				= SPC_GET_REP_TRD_FNC(M.RLANE_CD)" ).append("\n"); 
		query.append("                                   AND D.SUB_TRD_CD			= SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD)" ).append("\n"); 
		query.append("                                   AND D.DIR_CD 			= M.SKD_DIR_CD       " ).append("\n"); 
		query.append("                                   AND D.ALOC_CTRL_TP_CD	= M.CTRL_DEST" ).append("\n"); 
		query.append("                                   AND (( SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) IN " ).append("\n"); 
		query.append("                                          (SELECT OFC.OFC_CD" ).append("\n"); 
		query.append("                                             FROM SPC_ALOC_LANE_CTRL_OFC OFC" ).append("\n"); 
		query.append("                                            WHERE D.RLANE_CD           = OFC.RLANE_CD" ).append("\n"); 
		query.append("                                              AND D.TRD_CD             = OFC.TRD_CD" ).append("\n"); 
		query.append("                                              AND D.SUB_TRD_CD         = OFC.SUB_TRD_CD" ).append("\n"); 
		query.append("                                              AND D.DIR_CD             = OFC.DIR_CD " ).append("\n"); 
		query.append("                                              AND D.ALOC_CTRL_TP_CD    = OFC.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("                                              AND D.CTRL_LOC_ACCT_CD   = OFC.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                                        ))" ).append("\n"); 
		query.append("                                        OR ( NOT EXISTS " ).append("\n"); 
		query.append("                                         ( SELECT 1" ).append("\n"); 
		query.append("                                             FROM SPC_ALOC_LANE_CTRL_OFC OFC_ALL" ).append("\n"); 
		query.append("                                            WHERE D.RLANE_CD           = OFC_ALL.RLANE_CD" ).append("\n"); 
		query.append("                                              AND D.TRD_CD             = OFC_ALL.TRD_CD" ).append("\n"); 
		query.append("                                              AND D.SUB_TRD_CD         = OFC_ALL.SUB_TRD_CD" ).append("\n"); 
		query.append("                                              AND D.DIR_CD             = OFC_ALL.DIR_CD " ).append("\n"); 
		query.append("                                              AND D.ALOC_CTRL_TP_CD    = OFC_ALL.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("                                              AND D.CTRL_LOC_ACCT_CD   = OFC_ALL.CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        )) " ).append("\n"); 
		query.append("                                   AND DECODE(M.CTRL_DEST, 'E', D.CTRL_LOC_ACCT_CD, 'G', D.ALOC_CTRL_DTL_CD) = (SELECT DECODE(M.CTRL_DEST, 'E', A.ECC_CD, C.LOC_CD)" ).append("\n"); 
		query.append("                                                                                                                  FROM MDM_EQ_ORZ_CHT A," ).append("\n"); 
		query.append("                                                                                                                       MDM_LOCATION C " ).append("\n"); 
		query.append("                                                                                                                 WHERE C.LOC_CD = DECODE(M.CTRL_DEST_LVL,'T', B.DEL_CD, B.POD_CD)" ).append("\n"); 
		query.append("                                                                                                                   AND A.SCC_CD = C.SCC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ),'OTHERS')" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                            'OTHERS'" ).append("\n"); 
		query.append("                        END AS DEL_CD," ).append("\n"); 
		query.append("                        VPP.POL_CD              ," ).append("\n"); 
		query.append("                        VPP.POD_CD              ," ).append("\n"); 
		query.append("                        B.BKG_STS_CD            ," ).append("\n"); 
		query.append("                        B.ALOC_STS_CD           ,--2015.03.12" ).append("\n"); 
		query.append("                        REV.CMPB_AMT ," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                              SELECT" ).append("\n"); 
		query.append("                                        TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     --2014.07.28" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD,1,2), 'D2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') -- 20에 포함되어 있음" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD,1,2), 'D4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'W', Q.OP_CNTR_QTY, 0) + DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'X', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     --2014.07.28" ).append("\n"); 
		query.append("                                     || TO_CHAR(SUM(CASE WHEN Q.CNTR_TPSZ_CD LIKE 'R%' AND Q.EQ_SUBST_CNTR_TPSZ_CD LIKE 'D%' THEN Q.EQ_SUBST_CGO_QTY ELSE 0 END), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                     || TO_CHAR((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))" ).append("\n"); 
		query.append("                                                             + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                       FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                      WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                               WHERE B.BKG_NO      = Q.BKG_NO" ).append("\n"); 
		query.append("                                 AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("                           ) AS VAL" ).append("\n"); 
		query.append("                        , B.CRE_DT" ).append("\n"); 
		query.append("                      FROM SPC_OFC_LVL O  ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_BL_DOC  D," ).append("\n"); 
		query.append("                               BKG_REV_COST REV," ).append("\n"); 
		query.append("                               SPC_SB_BKG_DTL DTL," ).append("\n"); 
		query.append("                               REP_VVDS      M" ).append("\n"); 
		query.append("                      WHERE O.OFC_TP_CD     IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           AND O.OFC_CD         = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("                           AND VPP.COST_YR || VPP.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD    IN ('W', 'F')" ).append("\n"); 
		query.append("                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("						   AND B.ALOC_STS_CD IN ('S','A','F')" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("                           AND BV.VSL_CD        = VPP.VSL_CD" ).append("\n"); 
		query.append("                           AND BV.SKD_VOY_NO    = VPP.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND BV.SKD_DIR_CD    = VPP.SKD_DIR_CD" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                           AND ((BV.POL_CD = VPP.PL_VPS_PORT_CD AND BV.POL_CLPT_IND_SEQ = VPP.PL_CLPT_IND_SEQ) OR (BV.POL_YD_CD = VPP.POL_CD AND BV.POL_CLPT_IND_SEQ > 1 AND VPP.MAX_POL_PORT_SEQ = 1))" ).append("\n"); 
		query.append("                           AND ((BV.POD_CD = VPP.PD_VPS_PORT_CD AND BV.POD_CLPT_IND_SEQ = VPP.PD_CLPT_IND_SEQ) OR (BV.POD_YD_CD = VPP.POD_CD AND BV.POD_CLPT_IND_SEQ > 1 AND VPP.MAX_POD_PORT_SEQ = 1)) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("                           AND REV.BKG_NO (+)   = B.BKG_NO" ).append("\n"); 
		query.append("                           AND DTL.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                           AND NVL(DTL.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND DTL.BKG_CTRL_TP_CD    = 'S'" ).append("\n"); 
		query.append("                     ) A , PARAMS P" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                         AND A.SLS_OFC_CD = P.V_OFC_CD --PARAM" ).append("\n"); 
		query.append("--                         AND A.US_MOD = P.IPI_CD" ).append("\n"); 
		query.append("                         AND A.IOC_CD = P.IOC_CD" ).append("\n"); 
		query.append("                         AND DECODE( P.CHECK_LVL , 'O' , 'O' , A.POL_CD) " ).append("\n"); 
		query.append("								= DECODE( P.CHECK_LVL , 'O' , 'O' , P.POL_CD) -- IF OFFICE LEVE" ).append("\n"); 
		query.append("                        AND DECODE( P.CHECK_LVL , 'D' , A.POD_CD , 'T' , A.POD_CD , 'D' ) " ).append("\n"); 
		query.append("                                = DECODE( P.CHECK_LVL , 'D' , P.POD_CD , 'T' , P.POD_CD , 'D') --IF POL LEVEL" ).append("\n"); 
		query.append("                        AND DECODE( P.CHECK_LVL , 'T' , A.DEL_CD, 'T') = DECODE( P.CHECK_LVL , 'T' , P.DEL_CD , 'T')" ).append("\n"); 
		query.append("			GROUP BY BASE_RHQ_CD," ).append("\n"); 
		query.append("            		SLS_OFC_CD," ).append("\n"); 
		query.append("		            BKG_NO," ).append("\n"); 
		query.append("		            DECODE( ALOC_STS_CD , 'F' , TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) , 0 ) ," ).append("\n"); 
		query.append("        		    DECODE( ALOC_STS_CD , 'S' , TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) ,'A' , TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) , 0 ) ," ).append("\n"); 
		query.append("		            DECODE( ALOC_STS_CD , 'F' , TO_NUMBER(NVL(SUBSTR(VAL, 141, 14), 0)) , 0 )  ," ).append("\n"); 
		query.append("        		    DECODE( ALOC_STS_CD , 'S' , TO_NUMBER(NVL(SUBSTR(VAL,  141, 14), 0)) ,'A' , TO_NUMBER(NVL(SUBSTR(VAL,  141, 14), 0)) , 0 ) " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}