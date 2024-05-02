/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.05.17 최성민
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

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation copy
	  *  2012.08.29 전상화 [CHM-201219578-01] Control by HO / RHQ 화면에 Alloc Copy & Paste를 위한 삭제 
	  *  2013.10.04 진마리아 Allocation Copy 시 Sub Office 없는 경우에 Sub Alloc 도 함께 copy되도록 로직 추가
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경
	  * 2014.08.12 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청건_FNC 우선제거
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("newVslVd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newSkdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aloc_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newSkdDirCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod1stCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_POL_POD (" ).append("\n"); 
		query.append("    RLANE_CD            ," ).append("\n"); 
		query.append("    DIR_CD              ," ).append("\n"); 
		query.append("    VSL_CD              ," ).append("\n"); 
		query.append("    SKD_VOY_NO          ," ).append("\n"); 
		query.append("    SKD_DIR_CD          ," ).append("\n"); 
		query.append("    SLS_OFC_CD          ," ).append("\n"); 
		query.append("    POL_YD_CD           ," ).append("\n"); 
		query.append("    POD_YD_CD           ," ).append("\n"); 
		query.append("    TS_FLG              ," ).append("\n"); 
		query.append("    MNL_FLG             ," ).append("\n"); 
		query.append("    REP_TRD_CD          ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("    TRD_CD              ," ).append("\n"); 
		query.append("    SUB_TRD_CD          ," ).append("\n"); 
		query.append("    IOC_CD              ," ).append("\n"); 
		query.append("    SLS_RHQ_CD          ," ).append("\n"); 
		query.append("    SLS_AQ_CD           ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD      ," ).append("\n"); 
		query.append("    ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("    ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("    ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("    ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_RF_QTY         ," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    ASGN_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("    ASGN_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("    ASGN_RD_QTY         ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("    BKG_AVAL_20FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_RD_QTY     ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("    MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    ALOC_USR_ID         ," ).append("\n"); 
		query.append("    ALOC_GDT            ," ).append("\n"); 
		query.append("    CRE_USR_ID          ," ).append("\n"); 
		query.append("    CRE_DT              ," ).append("\n"); 
		query.append("    UPD_USR_ID          ," ).append("\n"); 
		query.append("    UPD_DT              ," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    CUST_CNT_CD      ," ).append("\n"); 
		query.append("    CUST_SEQ         ," ).append("\n"); 
		query.append("    CTRT_NO          ," ).append("\n"); 
		query.append("    USA_BKG_MOD_CD   ," ).append("\n"); 
		query.append("    DEST_LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("(select   " ).append("\n"); 
		query.append("    MAIN.RLANE_CD, " ).append("\n"); 
		query.append("    MAIN.DIR_CD              ," ).append("\n"); 
		query.append("   @[newVslVd] VSL_CD              ," ).append("\n"); 
		query.append("   @[newSkdVoyNo] SKD_VOY_NO          ," ).append("\n"); 
		query.append("   @[newSkdDirCd] SKD_DIR_CD          ," ).append("\n"); 
		query.append("    MAIN.SLS_OFC_CD          ," ).append("\n"); 
		query.append("    MAIN.POL_YD_CD           ," ).append("\n"); 
		query.append("    MAIN.POD_YD_CD           ," ).append("\n"); 
		query.append("    MAIN.TS_FLG              ," ).append("\n"); 
		query.append("    MAIN.MNL_FLG             ," ).append("\n"); 
		query.append("    MAIN.REP_TRD_CD          ," ).append("\n"); 
		query.append("    MAIN.REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("    MAIN.TRD_CD              ," ).append("\n"); 
		query.append("    MAIN.SUB_TRD_CD          ," ).append("\n"); 
		query.append("    MAIN.IOC_CD              ," ).append("\n"); 
		query.append("    MAIN.SLS_RHQ_CD          ," ).append("\n"); 
		query.append("    MAIN.SLS_AQ_CD           ," ).append("\n"); 
		query.append("    MAIN.SLS_RGN_OFC_CD      ," ).append("\n"); 
		query.append("    MAIN.ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("    MAIN.ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("    MAIN.ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("    MAIN.ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("    MAIN.ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("    MAIN.ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("    MAIN.ASGN_RF_QTY         ," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    MAIN.ASGN_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("    MAIN.ASGN_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("    MAIN.ASGN_RD_QTY         ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    MAIN.ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_TTL_QTY, NULL)        ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_20FT_QTY, NULL)       ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_40FT_QTY, NULL)       ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_40FT_HC_QTY, NULL)    ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_45FT_HC_QTY, NULL)    ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_53FT_QTY, NULL)       ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_RF_QTY, NULL)         ," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_20FT_DRY_QTY, NULL)   ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_40FT_DRY_QTY, NULL)   ," ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_RD_QTY, NULL)         ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    DECODE(SUB_CNT, 0, MAIN.BKG_AVAL_TTL_WGT, NULL)        ," ).append("\n"); 
		query.append("    MAIN.MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    @[upd_usr_id]          ," ).append("\n"); 
		query.append("    CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS ALOC_GDT," ).append("\n"); 
		query.append("   @[upd_usr_id]          ," ).append("\n"); 
		query.append("   SYSDATE AS CRE_DT              ," ).append("\n"); 
		query.append("   @[upd_usr_id]          ," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    MAIN.CUST_CNT_CD      ," ).append("\n"); 
		query.append("    MAIN.CUST_SEQ         ," ).append("\n"); 
		query.append("    MAIN.CTRT_NO          ," ).append("\n"); 
		query.append("    MAIN.USA_BKG_MOD_CD   ," ).append("\n"); 
		query.append("    MAIN.DEST_LOC_CD " ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("  WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[year]             AS YEAR      ," ).append("\n"); 
		query.append("           @[week]              AS WEEK      ," ).append("\n"); 
		query.append("           o.ofc_cd             AS OFC_CD    ," ).append("\n"); 
		query.append("           @[lane]              AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]              AS DIR_CD    ," ).append("\n"); 
		query.append("           @[vsl_cd]  AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]  AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]    AS SKD_DIR_CD," ).append("\n"); 
		query.append("           l.conti_cd           AS OFC_CONTI ," ).append("\n"); 
		query.append("           '2'             AS STS" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("#if (${user_ofc} == 'SZPDC')" ).append("\n"); 
		query.append("       AND O.OFC_CD = @[user_ofc]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${office} == '')" ).append("\n"); 
		query.append("       AND O.OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("       AND O.OFC_CD = @[office]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(", REP_VVDS AS (" ).append("\n"); 
		query.append("    SELECT V.TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD," ).append("\n"); 
		query.append("           V.DIR_CD  ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
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
		query.append("              SELECT NVL(MAX(CO.CTRL_LVL_CD), 'L')" ).append("\n"); 
		query.append("                FROM SPC_ALOC_CTRL_OPT CO" ).append("\n"); 
		query.append("               WHERE CO.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                 AND CO.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND CO.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                 AND CO.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND CO.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("           ) AS CTRL_LVL" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           PARAMS      P" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND V.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N' OR EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                                 FROM MAS_MON_VVD N" ).append("\n"); 
		query.append("                                                                WHERE N.SLAN_CD    = SUBSTR(V.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                                                                  AND N.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                                                  AND N.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                  AND N.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                                                  AND N.DELT_FLG   = 'N'))" ).append("\n"); 
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
		query.append("           VPS.CALL_YD_IND_SEQ ," ).append("\n"); 
		query.append("           VPS.VPS_PORT_CD," ).append("\n"); 
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
		query.append("    SELECT REP_TRD_CD          ," ).append("\n"); 
		query.append("           REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("           RLANE_CD            ," ).append("\n"); 
		query.append("           DIR_CD              ," ).append("\n"); 
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
		query.append("           POL_PAST            ,     " ).append("\n"); 
		query.append("           POD_CD              ," ).append("\n"); 
		query.append("           POD_SEQ             ," ).append("\n"); 
		query.append("           POD_CONTI           ," ).append("\n"); 
		query.append("           POD_PAST            ," ).append("\n"); 
		query.append("           IOC_CD              ,          " ).append("\n"); 
		query.append("           OFC_CD              ," ).append("\n"); 
		query.append("           OFC_CONTI          " ).append("\n"); 
		query.append("           , POL_YD_SEQ" ).append("\n"); 
		query.append("           , POD_YD_SEQ" ).append("\n"); 
		query.append("           , PL_VPS_PORT_CD" ).append("\n"); 
		query.append("           , PD_VPS_PORT_CD" ).append("\n"); 
		query.append("           , PL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("           , PD_CLPT_IND_SEQ" ).append("\n"); 
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
		query.append("                     POL_CD              ," ).append("\n"); 
		query.append("                     POL_SEQ             ," ).append("\n"); 
		query.append("                     POL_CONTI           ," ).append("\n"); 
		query.append("                     POL_PAST            ,                " ).append("\n"); 
		query.append("                     POD_CD              ," ).append("\n"); 
		query.append("                     POD_SEQ             ," ).append("\n"); 
		query.append("                     POD_CONTI           ," ).append("\n"); 
		query.append("                     POD_PAST            ,             " ).append("\n"); 
		query.append("                     IOC_CD              ," ).append("\n"); 
		query.append("                     PAST                ,                  " ).append("\n"); 
		query.append("                     OFC_CD              ," ).append("\n"); 
		query.append("                     OFC_CONTI           ,                  " ).append("\n"); 
		query.append("                     PL_PORT_CNT         ," ).append("\n"); 
		query.append("                    PD_PORT_CNT         ," ).append("\n"); 
		query.append("                    PL_PD_PORT_CNT     , " ).append("\n"); 
		query.append("                    MAX(PL_PD_PORT_CNT) OVER (PARTITION BY POL_CD,POD_CD ORDER BY POL_CD,POD_CD) AS PL_PD_PORT_MAX" ).append("\n"); 
		query.append("                    , POL_YD_SEQ" ).append("\n"); 
		query.append("                    , POD_YD_SEQ" ).append("\n"); 
		query.append("                    , PL_VPS_PORT_CD" ).append("\n"); 
		query.append("                    , PD_VPS_PORT_CD" ).append("\n"); 
		query.append("                    , PL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    , PD_CLPT_IND_SEQ" ).append("\n"); 
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
		query.append("                                PD.PORT_CD         AS POD_CD    ," ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                               (CASE" ).append("\n"); 
		query.append("                                     WHEN MAX(PL.PORT_SEQ) < MAX(PD.MIN_SEQ) THEN MAX(PD.MIN_SEQ)" ).append("\n"); 
		query.append("                                     ELSE CASE" ).append("\n"); 
		query.append("                                               WHEN MAX(PL.PORT_SEQ) > MAX(PD.MIN_SEQ) THEN MAX(PD.MAX_SEQ)" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                                 END) AS POD_SEQ ,                            " ).append("\n"); 
		query.append("                               PD.CONTI_CD       AS POD_CONTI ," ).append("\n"); 
		query.append("                               MIN(PD.PORT_PAST) AS POD_PAST  ,                         " ).append("\n"); 
		query.append("                               DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')            AS IOC_CD," ).append("\n"); 
		query.append("                               DECODE(PL.STS, '1', PL.PORT_PAST, '2', 'N', '3', 'Y') AS PAST  ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                               PL.OFC_CD              ," ).append("\n"); 
		query.append("                               PL.OFC_CONTI           ," ).append("\n"); 
		query.append("                               PL.STS                 ,                            " ).append("\n"); 
		query.append("                               SUBSTR(( SELECT MAX(LTRIM(TO_CHAR(S1.PORT_SEQ,'FM000'))|| S1.PORT_CD)" ).append("\n"); 
		query.append("                                          FROM VSL_PORT_SKD S1" ).append("\n"); 
		query.append("                                         WHERE S1.SKIPPED <> 1), 4) AS LD_PORT," ).append("\n"); 
		query.append("                               PL.PORT_CNT AS PL_PORT_CNT," ).append("\n"); 
		query.append("                               PD.PORT_CNT AS PD_PORT_CNT," ).append("\n"); 
		query.append("                               ROW_NUMBER()OVER (PARTITION BY PL.PORT_CD,PD.PORT_CD ORDER BY PL.PORT_CD,PD.PORT_CD) AS PL_PD_PORT_CNT" ).append("\n"); 
		query.append("                              , PL.CALL_YD_IND_SEQ AS POL_YD_SEQ" ).append("\n"); 
		query.append("                              , PD.CALL_YD_IND_SEQ AS POD_YD_SEQ" ).append("\n"); 
		query.append("                              , PL.VPS_PORT_CD     AS PL_VPS_PORT_CD" ).append("\n"); 
		query.append("                              , PD.VPS_PORT_CD     AS PD_VPS_PORT_CD" ).append("\n"); 
		query.append("                              , PL.CLPT_IND_SEQ    AS PL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              , PD.CLPT_IND_SEQ    AS PD_CLPT_IND_SEQ" ).append("\n"); 
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
		query.append("                           AND (    PL.PORT_SEQ = DECODE(PD.CONTI_CD, PL.CONTI_CD, PL.MIN_SEQ, PL.MAX_SEQ)  --  단독 CALLING 또는 DOUBLE CALLING 인데 마지막 PORT 경우는 모두" ).append("\n"); 
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
		query.append("                               PD.CONTI_CD      ,                      " ).append("\n"); 
		query.append("                               DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')           ," ).append("\n"); 
		query.append("                               DECODE(PL.STS, '1', PL.PORT_PAST, '2', 'N', '3', 'Y')," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("                               PL.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                               PL.OFC_CD              ," ).append("\n"); 
		query.append("                               PL.OFC_CONTI           ," ).append("\n"); 
		query.append("                               PL.STS                 ," ).append("\n"); 
		query.append("                               PL.CLPT_IND_SEQ        ," ).append("\n"); 
		query.append("                               PL.PORT_CNT            ," ).append("\n"); 
		query.append("                               PD.PORT_CNT" ).append("\n"); 
		query.append("                              , PL.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("                              , PD.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("                              , PL.VPS_PORT_CD" ).append("\n"); 
		query.append("                              , PD.VPS_PORT_CD" ).append("\n"); 
		query.append("                              , PL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              , PD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("     WHERE A.PL_PD_PORT_CNT = PL_PD_PORT_MAX" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",  ALL_DATA AS (" ).append("\n"); 
		query.append("               --Allocation" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                     A.RLANE_CD,    " ).append("\n"); 
		query.append("                     A.DIR_CD ,     " ).append("\n"); 
		query.append("                     A.VSL_CD,   " ).append("\n"); 
		query.append("                     A.SKD_VOY_NO,   " ).append("\n"); 
		query.append("                     A.SKD_DIR_CD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${office} == '')" ).append("\n"); 
		query.append("                     DECODE(VPP.OFC_CD, A.SLS_RHQ_CD, A.SLS_RGN_OFC_CD, DECODE(A.SLS_RHQ_CD, 'SINRS', A.SLS_RGN_OFC_CD, DECODE(A.RLANE_CD, 'WAFIE', A.SLS_RGN_OFC_CD, DECODE(A.TS_FLG, 'Y', A.SLS_RHQ_CD, A.SLS_RGN_OFC_CD)))) AS SLS_OFC_CD ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     DECODE(VPP.OFC_CD, A.SLS_RHQ_CD, A.SLS_RGN_OFC_CD, DECODE(A.RLANE_CD, 'WAFIE', A.SLS_RGN_OFC_CD, DECODE(A.TS_FLG, 'Y', A.SLS_RHQ_CD, A.SLS_RGN_OFC_CD))) AS SLS_OFC_CD ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                     VPP.POL_CD POL_YD_CD,   " ).append("\n"); 
		query.append("                     VPP.POD_CD POD_YD_CD,  " ).append("\n"); 
		query.append("                     A.TS_FLG TS_FLG,   " ).append("\n"); 
		query.append("                     A.MNL_FLG  ," ).append("\n"); 
		query.append("                     --20140812 추가" ).append("\n"); 
		query.append("                     A.CUST_CNT_CD      ," ).append("\n"); 
		query.append("                     A.CUST_SEQ         ," ).append("\n"); 
		query.append("                     A.CTRT_NO          ," ).append("\n"); 
		query.append("                     A.USA_BKG_MOD_CD   ," ).append("\n"); 
		query.append("                     A.DEST_LOC_CD     " ).append("\n"); 
		query.append("                FROM SPC_ALOC_POL_POD A  ," ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     VVD_POL_POD      VPP" ).append("\n"); 
		query.append("               WHERE A.RLANE_CD   = VPP.RLANE_CD" ).append("\n"); 
		query.append("                 AND A.DIR_CD     = VPP.DIR_CD" ).append("\n"); 
		query.append("                 AND A.VSL_CD     = VPP.VSL_CD" ).append("\n"); 
		query.append("                 AND A.SKD_VOY_NO = VPP.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND A.SKD_DIR_CD = VPP.SKD_DIR_CD" ).append("\n"); 
		query.append("		 AND A.POL_YD_CD  = VPP.POL_CD" ).append("\n"); 
		query.append("		 AND A.POD_YD_CD  = VPP.POD_CD" ).append("\n"); 
		query.append("		 AND A.POL_YD_IND_SEQ = VPP.POL_YD_SEQ" ).append("\n"); 
		query.append("		 AND A.POD_YD_IND_SEQ = VPP.POD_YD_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND (   (     VPP.POL_CONTI = VPP.OFC_CONTI" ).append("\n"); 
		query.append("                           AND (   (     A.TS_FLG     = 'N'" ).append("\n"); 
		query.append("                                     AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                                 OR A.SLS_RGN_OFC_CD IS NULL )" ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("         			OR VPP.RLANE_CD = 'WAFIE' " ).append("\n"); 
		query.append("                      OR" ).append("\n"); 
		query.append("#if (${office} == '')" ).append("\n"); 
		query.append("                         (     A.SLS_RHQ_CD = VPP.OFC_CD" ).append("\n"); 
		query.append("                           AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                      OR (     A.SLS_RHQ_CD = 'SINRS'" ).append("\n"); 
		query.append("                           AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                         (     A.SLS_RHQ_CD = VPP.OFC_CD" ).append("\n"); 
		query.append("                           AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("   SELECT  " ).append("\n"); 
		query.append("             Z.RLANE_CD,    " ).append("\n"); 
		query.append("             Z.DIR_CD ,     " ).append("\n"); 
		query.append("             Z.VSL_CD,   " ).append("\n"); 
		query.append("             Z.SKD_VOY_NO,   " ).append("\n"); 
		query.append("             Z.SKD_DIR_CD ," ).append("\n"); 
		query.append("             Z.SLS_OFC_CD , " ).append("\n"); 
		query.append("             Z.POL_YD_CD,   " ).append("\n"); 
		query.append("             Z.POD_YD_CD,  " ).append("\n"); 
		query.append("             Z.TS_FLG,   " ).append("\n"); 
		query.append("             Z.MNL_FLG," ).append("\n"); 
		query.append("             (SELECT COUNT(1)" ).append("\n"); 
		query.append("                FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("               WHERE O.PRNT_OFC_CD = Z.SLS_OFC_CD" ).append("\n"); 
		query.append("                 AND O.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("             ) AS SUB_CNT," ).append("\n"); 
		query.append("             --20140812 추가" ).append("\n"); 
		query.append("             Z.CUST_CNT_CD      ," ).append("\n"); 
		query.append("             Z.CUST_SEQ         ," ).append("\n"); 
		query.append("             Z.CTRT_NO          ," ).append("\n"); 
		query.append("             Z.USA_BKG_MOD_CD   ," ).append("\n"); 
		query.append("             Z.DEST_LOC_CD                " ).append("\n"); 
		query.append("        FROM ALL_DATA Z " ).append("\n"); 
		query.append("#if (${office} == '')" ).append("\n"); 
		query.append("     UNION ALL " ).append("\n"); 
		query.append("        --Allocation" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             A.RLANE_CD,    " ).append("\n"); 
		query.append("             A.DIR_CD ,     " ).append("\n"); 
		query.append("             A.VSL_CD,   " ).append("\n"); 
		query.append("             A.SKD_VOY_NO,   " ).append("\n"); 
		query.append("             A.SKD_DIR_CD ," ).append("\n"); 
		query.append("             A.SLS_OFC_CD , " ).append("\n"); 
		query.append("             A.POL_YD_CD,   " ).append("\n"); 
		query.append("             A.POD_YD_CD,  " ).append("\n"); 
		query.append("             A.TS_FLG,   " ).append("\n"); 
		query.append("             A.MNL_FLG," ).append("\n"); 
		query.append("             1 AS SUB_CNT," ).append("\n"); 
		query.append("             --20140812 추가" ).append("\n"); 
		query.append("             A.CUST_CNT_CD      ," ).append("\n"); 
		query.append("             A.CUST_SEQ         ," ).append("\n"); 
		query.append("             A.CTRT_NO          ," ).append("\n"); 
		query.append("             A.USA_BKG_MOD_CD   ," ).append("\n"); 
		query.append("             A.DEST_LOC_CD                " ).append("\n"); 
		query.append("        FROM SPC_ALOC_POL_POD A  ," ).append("\n"); 
		query.append("             PARAMS      P           " ).append("\n"); 
		query.append("       WHERE A.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("         AND A.DIR_CD     = P.DIR_CD" ).append("\n"); 
		query.append("         AND A.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("         AND A.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND A.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND A.SLS_OFC_CD IN ('HAMRU', 'NYCRA')" ).append("\n"); 
		query.append("         AND P.RLANE_CD   = 'WAFIE'" ).append("\n"); 
		query.append("#end                 " ).append("\n"); 
		query.append("    )  INFO, SPC_ALOC_POL_POD MAIN" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("           INFO.RLANE_CD    = MAIN.RLANE_CD    " ).append("\n"); 
		query.append("        AND   INFO.DIR_CD      = MAIN.DIR_CD" ).append("\n"); 
		query.append("        AND   INFO.VSL_CD      = MAIN.VSL_CD   " ).append("\n"); 
		query.append("        AND   INFO.SKD_VOY_NO  = MAIN.SKD_VOY_NO " ).append("\n"); 
		query.append("        AND   INFO.SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND   INFO.SLS_OFC_CD  = MAIN.SLS_OFC_CD" ).append("\n"); 
		query.append("        AND    INFO.POL_YD_CD   = MAIN.POL_YD_CD " ).append("\n"); 
		query.append("        AND   INFO.POD_YD_CD   = MAIN.POD_YD_CD" ).append("\n"); 
		query.append("        AND   INFO.TS_FLG      = MAIN.TS_FLG" ).append("\n"); 
		query.append("        AND   INFO.MNL_FLG     = MAIN.MNL_FLG" ).append("\n"); 
		query.append("        --20140812 추가" ).append("\n"); 
		query.append("        AND   INFO.CUST_CNT_CD    = MAIN.CUST_CNT_CD   " ).append("\n"); 
		query.append("        AND   INFO.CUST_SEQ       = MAIN.CUST_SEQ" ).append("\n"); 
		query.append("        AND   INFO.CTRT_NO        = MAIN.CTRT_NO" ).append("\n"); 
		query.append("        AND   INFO.USA_BKG_MOD_CD = MAIN.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("        AND   INFO.DEST_LOC_CD    = MAIN.DEST_LOC_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}