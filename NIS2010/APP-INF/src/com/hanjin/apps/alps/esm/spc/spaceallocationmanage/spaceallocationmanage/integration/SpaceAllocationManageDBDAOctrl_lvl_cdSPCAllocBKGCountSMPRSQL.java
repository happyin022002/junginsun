/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOctrl_lvl_cdSPCAllocBKGCountSMPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.05.18 Arie
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

public class SpaceAllocationManageDBDAOctrl_lvl_cdSPCAllocBKGCountSMPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ALLOC HO 화면에서 ALOC물량 변경시 STANDBY BKG 물량 가져오기
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOctrl_lvl_cdSPCAllocBKGCountSMPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aloc_mdfy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOctrl_lvl_cdSPCAllocBKGCountSMPRSQL").append("\n"); 
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
		query.append("WITH " ).append("\n"); 
		query.append("BKG_LIST AS (" ).append("\n"); 
		query.append("     SELECT @[year]              AS YEAR      ," ).append("\n"); 
		query.append("           @[week]              AS WEEK      ," ).append("\n"); 
		query.append("           O.OFC_CD             AS OFC_CD    ," ).append("\n"); 
		query.append("           @[rlane_cd]              AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[dir_cd]             AS DIR_CD    ," ).append("\n"); 
		query.append("           @[trd_cd]   AS TRD_CD     ," ).append("\n"); 
		query.append("           @[sub_trd_cd]    AS SUB_TRD_CD ,           " ).append("\n"); 
		query.append("           @[vsl_cd] AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]    AS SKD_DIR_CD," ).append("\n"); 
		query.append("           L.CONTI_CD           AS OFC_CONTI ," ).append("\n"); 
		query.append("           @[cost_wk] AS COST_WK   ," ).append("\n"); 
		query.append("           @[pol_cd] AS POL_CD   ," ).append("\n"); 
		query.append("           @[pod_cd] AS POD_CD   ," ).append("\n"); 
		query.append("		   @[del_cd] AS DEL_CD   ," ).append("\n"); 
		query.append("		   @[ctrl_lvl_cd] AS CHECK_LVL," ).append("\n"); 
		query.append("           @[sls_ofc_cd] AS V_OFC_CD     ," ).append("\n"); 
		query.append("           SUBSTR(@[ioc_cd],1,1)     AS IOC_CD     ," ).append("\n"); 
		query.append("           @[us_mod]   AS IPI_CD     ," ).append("\n"); 
		query.append("           'Y'    AS SMP_FLG    ," ).append("\n"); 
		query.append("           @[asgn_ttl_qty]     AS ALOC_DIF   ," ).append("\n"); 
		query.append("           @[aloc_mdfy]    AS ALOC_ORG   ," ).append("\n"); 
		query.append("		   @[cust_ctrl_cd] AS CUST_CTRL_CD," ).append("\n"); 
		query.append("           '2'             AS STS" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("	       AND O.OFC_CD = 'SHARC'" ).append("\n"); 
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
		query.append("           bkg_list.ofc_cd AS OFC_CD              ," ).append("\n"); 
		query.append("           bkg_list.ofc_conti AS OFC_CONTI           ," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                DECODE(NVL(MAX(CO.CTRL_LVL_CD), 'L'), 'O', DECODE(NVL(MAX(CO.CTRL_ACCT_FLG), 'N'),'Y','A'," ).append("\n"); 
		query.append("                                              DECODE(NVL(MAX(CO.CTRL_USA_SVC_MOD_FLG), 'N'),'Y','U','O'))," ).append("\n"); 
		query.append("                                                 NVL(MAX(CO.CTRL_LVL_CD), 'L')) " ).append("\n"); 
		query.append("                FROM SPC_ALOC_CTRL_OPT CO" ).append("\n"); 
		query.append("               WHERE CO.RLANE_CD   = bkg_list.rlane_cd" ).append("\n"); 
		query.append("                 AND CO.DIR_CD     = bkg_list.SKD_dir_cd" ).append("\n"); 
		query.append("                 AND CO.VSL_CD     = bkg_list.vsl_cd" ).append("\n"); 
		query.append("                 AND CO.SKD_VOY_NO = bkg_list.skd_voy_no" ).append("\n"); 
		query.append("                 AND CO.SKD_DIR_CD = bkg_list.SKD_dir_cd" ).append("\n"); 
		query.append("           ) AS CTRL_LVL, " ).append("\n"); 
		query.append("           NVL(DECODE(A.CTRL_ECC_FLG,'Y','E',DECODE(A.CTRL_ECC_GRP_FLG, 'Y', 'G', 'N')),'N') AS CTRL_DEST, -- C = COUNTRY, L = LOCATION" ).append("\n"); 
		query.append("           NVL(A.CTRL_DEST_LVL_CD, 'N')     AS CTRL_DEST_LVL  ,                                     -- D = BKG_POD, T = BKG_DEL" ).append("\n"); 
		query.append("           NVL(A.CTRL_USA_SVC_MOD_FLG, 'N') AS CTRL_USA,                                            -- Y = LOCAL/IPI" ).append("\n"); 
		query.append("           NVL(A.CTRL_ACCT_FLG, 'N')        AS CTRL_ACCOUNT" ).append("\n"); 
		query.append("			  , CASE WHEN V.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("				  THEN CEIL(TO_NUMBER(SUBSTR(V.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("				  ELSE CEIL(TO_NUMBER(DECODE(V.COST_WK,'00','01','53','52',V.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("             END BSE_QTR_CD " ).append("\n"); 
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           BKG_LIST," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT A" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = bkg_list.rlane_cd" ).append("\n"); 
		query.append("       AND V.VSL_CD     = bkg_list.vsl_cd" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = bkg_list.skd_voy_no" ).append("\n"); 
		query.append("       AND V.DIR_CD     = bkg_list.SKD_dir_cd" ).append("\n"); 
		query.append("       AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N' OR EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                                 FROM MAS_MON_VVD N" ).append("\n"); 
		query.append("                                                                WHERE N.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("                                                                  AND N.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                                                  AND N.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                  AND N.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                                                  AND N.DELT_FLG   = 'N'))" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND A.RLANE_CD   = bkg_list.rlane_cd" ).append("\n"); 
		query.append("       AND A.DIR_CD     = bkg_list.SKD_dir_cd" ).append("\n"); 
		query.append("       AND A.VSL_CD     = bkg_list.vsl_cd" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = bkg_list.skd_voy_no" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = bkg_list.SKD_dir_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
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
		query.append("           NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           VPS.TURN_PORT_IND_CD AS PORT_IND," ).append("\n"); 
		query.append("           SPC_CONTI_CONV_FNC(L.CONTI_CD, V.RLANE_CD, V.DIR_CD) AS CONTI_CD," ).append("\n"); 
		query.append("           DECODE(SIGN(VPS.VPS_ETD_DT - GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYS_EXTRACT_UTC(SYSTIMESTAMP), VPS.VPS_PORT_CD)), -1, 'Y', 'N') AS PORT_PAST," ).append("\n"); 
		query.append("           VPS.VPS_ETA_DT AS ETA_DT," ).append("\n"); 
		query.append("           VPS.VPS_ETD_DT AS ETD_DT," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_CD      ," ).append("\n"); 
		query.append("           V.OFC_CD                ," ).append("\n"); 
		query.append("           V.OFC_CONTI             ," ).append("\n"); 
		query.append("		   V.BSE_QTR_CD ," ).append("\n"); 
		query.append("           DECODE(VPS.SKD_CNG_STS_CD, 'S', 1, 0) AS SKIPPED," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ," ).append("\n"); 
		query.append("           COUNT(*) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS PORT_CNT" ).append("\n"); 
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
		query.append("           POD_CD              ," ).append("\n"); 
		query.append("           POD_SEQ             ," ).append("\n"); 
		query.append("           POD_CONTI           ," ).append("\n"); 
		query.append("           IOC_CD              ," ).append("\n"); 
		query.append("           OFC_CD              ," ).append("\n"); 
		query.append("           OFC_CONTI           ," ).append("\n"); 
		query.append("           LD_PORT             ," ).append("\n"); 
		query.append("           PL_PORT_CNT         ," ).append("\n"); 
		query.append("           PD_PORT_CNT         ," ).append("\n"); 
		query.append("		   BSE_QTR_CD ," ).append("\n"); 
		query.append("           PL_PD_PORT_CNT" ).append("\n"); 
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
		query.append("                     POD_CD              ," ).append("\n"); 
		query.append("                     POD_SEQ             ," ).append("\n"); 
		query.append("                     POD_CONTI           ," ).append("\n"); 
		query.append("                     IOC_CD              ," ).append("\n"); 
		query.append("                     PAST                ," ).append("\n"); 
		query.append("                     OFC_CD              ," ).append("\n"); 
		query.append("                     OFC_CONTI           ," ).append("\n"); 
		query.append("                     LD_PORT             ," ).append("\n"); 
		query.append("                     PL_PORT_CNT         ," ).append("\n"); 
		query.append("                     PD_PORT_CNT         ," ).append("\n"); 
		query.append("                     PL_PD_PORT_CNT      , " ).append("\n"); 
		query.append("					 BSE_QTR_CD ," ).append("\n"); 
		query.append("                     MAX(PL_PD_PORT_CNT) OVER (PARTITION BY POL_CD,POD_CD ORDER BY POL_CD,POD_CD) AS PL_PD_PORT_MAX" ).append("\n"); 
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
		query.append("                               PD.PORT_CD         AS POD_CD    ," ).append("\n"); 
		query.append("                               (CASE" ).append("\n"); 
		query.append("                                     WHEN MAX(PL.PORT_SEQ) < MAX(PD.MIN_SEQ) THEN MAX(PD.MIN_SEQ)" ).append("\n"); 
		query.append("                                     ELSE CASE" ).append("\n"); 
		query.append("                                     	  	WHEN MAX(PL.PORT_SEQ) > MAX(PD.MIN_SEQ) THEN MAX(PD.MAX_SEQ)" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                 END) AS POD_SEQ ," ).append("\n"); 
		query.append("                               PD.CONTI_CD       AS POD_CONTI ," ).append("\n"); 
		query.append("                               DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')            AS IOC_CD," ).append("\n"); 
		query.append("                                '' AS PAST," ).append("\n"); 
		query.append("                               PL.OFC_CD              ," ).append("\n"); 
		query.append("                               PL.OFC_CONTI           ," ).append("\n"); 
		query.append("                               SUBSTR(( SELECT MAX(LTRIM(TO_CHAR(S1.PORT_SEQ,'FM000'))|| S1.PORT_CD)" ).append("\n"); 
		query.append("                                          FROM VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                                         WHERE S1.SKIPPED <> 1), 4) AS LD_PORT," ).append("\n"); 
		query.append("                               PL.PORT_CNT AS PL_PORT_CNT," ).append("\n"); 
		query.append("                               PD.PORT_CNT AS PD_PORT_CNT," ).append("\n"); 
		query.append("							   PL.BSE_QTR_CD ," ).append("\n"); 
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
		query.append("                           AND (    PL.PORT_SEQ = DECODE(PD.CONTI_CD, PL.CONTI_CD, PL.MIN_SEQ, PL.MAX_SEQ)" ).append("\n"); 
		query.append("                                 OR PD.PORT_SEQ < PL.MAX_SEQ )" ).append("\n"); 
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
		query.append("                               DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')           ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("                               PL.OFC_CD              ," ).append("\n"); 
		query.append("                               PL.OFC_CONTI           ," ).append("\n"); 
		query.append("                               PL.CLPT_IND_SEQ        ," ).append("\n"); 
		query.append("                               PL.PORT_CNT            ," ).append("\n"); 
		query.append("                               PD.PORT_CNT," ).append("\n"); 
		query.append("										 PL.BSE_QTR_CD" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("     WHERE A.PL_PD_PORT_CNT = PL_PD_PORT_MAX" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("           BKG_NO              ," ).append("\n"); 
		query.append("           CMPB_AMT            ," ).append("\n"); 
		query.append("           NVL(ALOC_STS_CD , 'F' )    AS ALOC_STS_CD ," ).append("\n"); 
		query.append("           (BKG_TTL_QTY)       AS BKG_TTL_QTY" ).append("\n"); 
		query.append("           , RN" ).append("\n"); 
		query.append("           , SUM(SUM(BKG_TTL_QTY)) OVER(ORDER BY RN ASC ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) CUML" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("		SELECT 	REP_TRD_CD          ," ).append("\n"); 
		query.append("				REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("				A.TRD_CD              ," ).append("\n"); 
		query.append("				A.SUB_TRD_CD          ," ).append("\n"); 
		query.append("				A.RLANE_CD		 	," ).append("\n"); 
		query.append("				BASE_RHQ_CD         ," ).append("\n"); 
		query.append("				SLS_OFC_CD          ," ).append("\n"); 
		query.append("                A.CUST_CTRL_CD        ," ).append("\n"); 
		query.append("                BKG_NO              ," ).append("\n"); 
		query.append("                CMPB_AMT            ," ).append("\n"); 
		query.append("				A.IOC_CD            ," ).append("\n"); 
		query.append("				US_MOD		 		," ).append("\n"); 
		query.append("				A.DEL_CD		 		," ).append("\n"); 
		query.append("				A.POL_CD              ," ).append("\n"); 
		query.append("				A.POD_CD              ," ).append("\n"); 
		query.append("                ALOC_STS_CD         , --2015.03.12" ).append("\n"); 
		query.append("				VAL AS BKG_TTL_QTY," ).append("\n"); 
		query.append("                RANK() OVER( ORDER BY CMPB_AMT) RN" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("				SELECT VPP.REP_TRD_CD    ," ).append("\n"); 
		query.append("					   VPP.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("					   VPP.TRD_CD        ," ).append("\n"); 
		query.append("					   VPP.SUB_TRD_CD    ," ).append("\n"); 
		query.append("					   VPP.RLANE_CD		 ," ).append("\n"); 
		query.append("					   VPP.OFC_CD   AS BASE_RHQ_CD," ).append("\n"); 
		query.append("                       O.N4TH_PRNT_OFC_CD AS SLS_OFC_CD ," ).append("\n"); 
		query.append("                       NVL(SMP.CUST_CTRL_CD, 'C') AS CUST_CTRL_CD," ).append("\n"); 
		query.append("                       B.BKG_NO," ).append("\n"); 
		query.append("                       CMPB_AMT," ).append("\n"); 
		query.append("					   DECODE(BV.VSL_PRE_PST_CD, 'T', VPP.IOC_CD, 'T') AS IOC_CD ," ).append("\n"); 
		query.append("					   CASE WHEN M.CTRL_USA = 'Y' AND (SUBSTR(B.POL_CD,1,2) IN ('US','CA') OR SUBSTR(B.POD_CD,1,2) IN ('US','CA')) THEN" ).append("\n"); 
		query.append("					   		NVL(SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POL_CD, B.POL_CD, B.POD_CD, B.DEL_CD),'OTHERS') " ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("							'OTHERS'" ).append("\n"); 
		query.append("					   END AS US_MOD," ).append("\n"); 
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
		query.append("                        B.ALOC_STS_CD           ," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY)" ).append("\n"); 
		query.append("                            FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                            WHERE B.BKG_NO      = Q.BKG_NO" ).append("\n"); 
		query.append("                            AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("                        ) AS VAL" ).append("\n"); 
		query.append("                          FROM SPC_OFC_LVL O  ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_BL_DOC  D," ).append("\n"); 
		query.append("                               REP_VVDS      M," ).append("\n"); 
		query.append("                               BKG_REV_COST REV," ).append("\n"); 
		query.append("                               BKG_CUSTOMER      BC ," ).append("\n"); 
		query.append("                               ( --SMP TABLE" ).append("\n"); 
		query.append("                                SELECT   S.SC_NO, S.RFA_NO, S.CUST_CTRL_CD, S.CUST_CNT_CD, S.CUST_SEQ" ).append("\n"); 
		query.append("                                FROM (" ).append("\n"); 
		query.append("                                            SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                MST.TRD_CD, MST.COST_YRWK, MST.VER_SEQ," ).append("\n"); 
		query.append("                                                MST.COST_YRWK||'-'||MST.VER_SEQ AS SEASON" ).append("\n"); 
		query.append("                                          FROM SPC_MDL_VER_MST MST," ).append("\n"); 
		query.append("                                               MAS_MON_VVD     COA" ).append("\n"); 
		query.append("                                          WHERE 1=1" ).append("\n"); 
		query.append("                                            AND COA.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                                            AND COA.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("                                            AND COA.IOC_CD = SUBSTR(@[ioc_cd],1,1)" ).append("\n"); 
		query.append("                                            AND COA.VSL_CD = @[vsl_cd] --bkg_list.vsl_cd" ).append("\n"); 
		query.append("                                            AND COA.SKD_VOY_NO = @[skd_voy_no]--bkg_list.skd_voy_no" ).append("\n"); 
		query.append("                                            AND COA.DIR_CD = @[skd_dir_cd]--bkg_list.SKD_dir_cd --'HJCN0021E'" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            AND COA.TRD_CD = MST.TRD_CD" ).append("\n"); 
		query.append("                                            AND SUBSTR(COA.SLS_YRMON, 1,4)||COA.COST_WK BETWEEN MST.VER_ST_YRWK AND MST.VER_END_YRWK" ).append("\n"); 
		query.append("                                            AND MST.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                                    ) VER, SPC_MDL_CUST_CTRL S" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                   AND VER.TRD_CD = S.TRD_CD  (+)   " ).append("\n"); 
		query.append("                                   AND VER.COST_YRWK = S.COST_YRWK (+)  " ).append("\n"); 
		query.append("                                   AND VER.VER_SEQ   = S.VER_SEQ    (+)  " ).append("\n"); 
		query.append("                            ) SMP" ).append("\n"); 
		query.append("                         WHERE O.OFC_TP_CD     IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           AND O.OFC_CD         = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("                           AND VPP.COST_YR || VPP.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD    IN ('W', 'F')" ).append("\n"); 
		query.append("                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("                           AND BV.VSL_CD        = VPP.VSL_CD" ).append("\n"); 
		query.append("                           AND BV.SKD_VOY_NO    = VPP.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND BV.SKD_DIR_CD    = VPP.DIR_CD" ).append("\n"); 
		query.append("                           AND (    (VPP.COST_YR||VPP.COST_WK  < '201023' AND BV.POL_CD    = SUBSTR(VPP.POL_CD, 1, 5))" ).append("\n"); 
		query.append("                                 OR (VPP.COST_YR||VPP.COST_WK >= '201023' AND BV.POL_YD_CD = VPP.POL_CD))" ).append("\n"); 
		query.append("                           AND (    (VPP.COST_YR||VPP.COST_WK  < '201023' AND BV.POD_CD    = SUBSTR(VPP.POD_CD, 1, 5))" ).append("\n"); 
		query.append("                                 OR (VPP.COST_YR||VPP.COST_WK >= '201023' AND BV.POD_YD_CD = VPP.POD_CD))" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("                           AND REV.BKG_NO (+)       = B.BKG_NO" ).append("\n"); 
		query.append("                           AND B.CTRT_CUST_CNT_CD = SMP.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                           AND B.CTRT_CUST_SEQ     = SMP.CUST_SEQ   (+)" ).append("\n"); 
		query.append("                           AND NVL(B.SC_NO, NVL(B.RFA_NO, 'X')) = NVL(SMP.SC_NO(+), NVL(SMP.RFA_NO(+), 'X'))" ).append("\n"); 
		query.append("                           AND B.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                           AND BC.BKG_CUST_TP_CD  = 'S'" ).append("\n"); 
		query.append("                           AND B.ALOC_STS_CD IN ('S','A')" ).append("\n"); 
		query.append("                     ) A , BKG_LIST" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                     AND US_MOD=BKG_LIST.IPI_CD" ).append("\n"); 
		query.append("                     AND A.CUST_CTRL_CD=BKG_LIST.CUST_CTRL_CD --NVL(BKG_LIST.SMP_FLG,CUST_CTRL_CD)" ).append("\n"); 
		query.append("                     AND SLS_OFC_CD=BKG_LIST.V_OFC_CD" ).append("\n"); 
		query.append("                     AND A.IOC_CD=BKG_LIST.IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     AND DECODE( BKG_LIST.CHECK_LVL , 'O' , 'O' , A.POL_CD) " ).append("\n"); 
		query.append("								= DECODE( BKG_LIST.CHECK_LVL , 'O' , 'O' , BKG_LIST.POL_CD) -- IF OFFICE LEVE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					 AND DECODE( BKG_LIST.CHECK_LVL , 'D' , A.POD_CD , 'T' , A.POD_CD , 'D' ) " ).append("\n"); 
		query.append("								= DECODE( BKG_LIST.CHECK_LVL , 'D' , BKG_LIST.POD_CD , 'T' , BKG_LIST.POD_CD , 'D') --IF POL LEVEL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					 AND DECODE( BKG_LIST.CHECK_LVL , 'T' , A.DEL_CD, 'T') = DECODE( BKG_LIST.CHECK_LVL , 'T' , BKG_LIST.DEL_CD , 'T')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ), BKG_LIST B" ).append("\n"); 
		query.append("           WHERE RN <= (TO_NUMBER(B.ALOC_DIF) - TO_NUMBER(B.ALOC_ORG))" ).append("\n"); 
		query.append("           GROUP BY BKG_NO, CMPB_AMT, RN, NVL(ALOC_STS_CD , 'F' ),BKG_TTL_QTY" ).append("\n"); 
		query.append("           ORDER BY CMPB_AMT, BKG_NO" ).append("\n"); 

	}
}