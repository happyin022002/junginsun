/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.17 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  *  2012.08.29 전상화 [CHM-201219578-01] Control by HO / RHQ 화면에 Alloc Copy & Paste를 위한 삭제 
	  *  2012.11.28 김시몬 [CHM-201219578-01] 대상 MAS_MON_VVD를 가져올때 RLANE_CD를 조건에 추가
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2014.08.12 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청건
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("newVslVd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("newSkdDirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod2ndCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    ALOC_USR_ID         ," ).append("\n"); 
		query.append("    ALOC_GDT            ," ).append("\n"); 
		query.append("    CRE_USR_ID          ," ).append("\n"); 
		query.append("    CRE_DT              ," ).append("\n"); 
		query.append("    UPD_USR_ID          ," ).append("\n"); 
		query.append("    UPD_DT              ," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    CUST_CNT_CD         ," ).append("\n"); 
		query.append("    CUST_SEQ            ," ).append("\n"); 
		query.append("    CTRT_NO             ," ).append("\n"); 
		query.append("    USA_BKG_MOD_CD      ," ).append("\n"); 
		query.append("    DEST_LOC_CD " ).append("\n"); 
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
		query.append("    MAIN.ASGN_RD_QTY         ,    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    MAIN.ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    MAIN.MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    @[upd_usr_id]          ," ).append("\n"); 
		query.append("    CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS ALOC_GDT," ).append("\n"); 
		query.append("    @[upd_usr_id]          ," ).append("\n"); 
		query.append("    SYSDATE AS CRE_DT              ," ).append("\n"); 
		query.append("    @[upd_usr_id]          ," ).append("\n"); 
		query.append("    SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("    --20140812 추가" ).append("\n"); 
		query.append("    MAIN.CUST_CNT_CD      ," ).append("\n"); 
		query.append("    MAIN.CUST_SEQ         ," ).append("\n"); 
		query.append("    MAIN.CTRT_NO          ," ).append("\n"); 
		query.append("    MAIN.USA_BKG_MOD_CD   ," ).append("\n"); 
		query.append("    MAIN.DEST_LOC_CD     " ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append(" WITH BASE_KEY AS (" ).append("\n"); 
		query.append("    SELECT          " ).append("\n"); 
		query.append("           @[year]       AS YEAR      ," ).append("\n"); 
		query.append("           @[week]       AS WEEK      ," ).append("\n"); 
		query.append("           @[office]     AS RHQ_CD    ," ).append("\n"); 
		query.append("           @[lane]       AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]      AS DIR_CD    ," ).append("\n"); 
		query.append("           @[vsl_cd]      AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]  AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]  AS SKD_DIR_CD," ).append("\n"); 
		query.append("           @[fcast]      AS FCAST     ," ).append("\n"); 
		query.append("           L.CONTI_CD    AS OFC_CONTI ," ).append("\n"); 
		query.append("           O.OFC_CD      AS OFC_CD" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L," ).append("\n"); 
		query.append("           MDM_ORGANIZATION O" ).append("\n"); 
		query.append("     WHERE L.LOC_CD = O.LOC_CD" ).append("\n"); 
		query.append("       AND O.OFC_CD = @[office]" ).append("\n"); 
		query.append("), " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("BASE AS (" ).append("\n"); 
		query.append("    SELECT B.YEAR," ).append("\n"); 
		query.append("           B.WEEK," ).append("\n"); 
		query.append("           SUBSTR(T.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           SUBSTR(T.SLS_YRMON, 5)    AS MON    ," ).append("\n"); 
		query.append("           T.COST_WK   ," ).append("\n"); 
		query.append("           B.RHQ_CD    ," ).append("\n"); 
		query.append("           T.TRD_CD    ," ).append("\n"); 
		query.append("           B.RLANE_CD  ," ).append("\n"); 
		query.append("           B.DIR_CD    ," ).append("\n"); 
		query.append("           B.VSL_CD    ," ).append("\n"); 
		query.append("           B.SKD_VOY_NO," ).append("\n"); 
		query.append("           B.SKD_DIR_CD," ).append("\n"); 
		query.append("           B.FCAST     ," ).append("\n"); 
		query.append("           NVL((O.CTRL_PORT_FLG)   , 'N') AS POL_POD," ).append("\n"); 
		query.append("           NVL((O.CTRL_40FT_HC_FLG), 'N') AS HC40   ," ).append("\n"); 
		query.append("           NVL((O.CTRL_45FT_HC_FLG), 'N') AS HC45   ," ).append("\n"); 
		query.append("           NVL((O.CTRL_53FT_FLG)   , 'N') AS HC53   ," ).append("\n"); 
		query.append("           NVL((O.CTRL_RF_FLG)     , 'N') AS REEFER ," ).append("\n"); 
		query.append("           NVL((O.CTRL_WGT_FLG)    , 'N') AS WEIGHT ," ).append("\n"); 
		query.append("           NVL((O.CTRL_SPC_FLG)    , 'N') AS VOLUME ," ).append("\n"); 
		query.append("           B.OFC_CD   ," ).append("\n"); 
		query.append("           B.OFC_CONTI" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD       T," ).append("\n"); 
		query.append("           BASE_KEY          B," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT O" ).append("\n"); 
		query.append("     WHERE T.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("       AND T.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("       AND T.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND T.DIR_CD        = B.DIR_CD" ).append("\n"); 
		query.append("       AND O.RLANE_CD  (+) = B.RLANE_CD" ).append("\n"); 
		query.append("       AND O.DIR_CD    (+) = B.DIR_CD" ).append("\n"); 
		query.append("       AND O.VSL_CD    (+) = B.VSL_CD" ).append("\n"); 
		query.append("       AND O.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND O.SKD_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND T.TRD_CD        = SPC_GET_REP_TRD_FNC(B.RLANE_CD)" ).append("\n"); 
		query.append("       AND SUBSTR(T.SLS_YRMON, 1, 4)||T.COST_WK = B.YEAR||B.WEEK" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", REP_VVDS AS (" ).append("\n"); 
		query.append("    SELECT V.TRD_CD     AS REP_TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD," ).append("\n"); 
		query.append("           V.DIR_CD  ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_CD    ," ).append("\n"); 
		query.append("           V.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("           P.OFC_CD   ," ).append("\n"); 
		query.append("           P.OFC_CONTI," ).append("\n"); 
		query.append("           '1' AS STS" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD V," ).append("\n"); 
		query.append("           BASE_KEY    P" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = SPC_GET_REP_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND V.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N' OR EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                                                                 FROM MAS_MON_VVD N" ).append("\n"); 
		query.append("                                                                WHERE N.SLAN_CD    = SUBSTR(V.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                                                                  AND N.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                                                                  AND N.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                  AND N.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                                                  AND N.DELT_FLG   = 'N' ))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT V.VSL_CD       ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO   ," ).append("\n"); 
		query.append("           V.SKD_DIR_CD   ," ).append("\n"); 
		query.append("           VPS.VPS_PORT_CD," ).append("\n"); 
		query.append("           VPS.YD_CD      ," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ   ," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ AS PORT_SEQ," ).append("\n"); 
		query.append("           VPS.VPS_ETD_DT ," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MAX_SEQ" ).append("\n"); 
		query.append("      FROM MDM_LOCATION     L  ," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           REP_VVDS         V" ).append("\n"); 
		query.append("     WHERE L.LOC_CD       = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VPS.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           RHQ_CD    ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           COST_YR_WK," ).append("\n"); 
		query.append("           POL_CD    ," ).append("\n"); 
		query.append("           POD_CD    ," ).append("\n"); 
		query.append(" 			SPC_CONTI_CONV_PORT_FNC(POL_CONTI, POD_CONTI, RLANE_CD, SUBSTR(POL_CD, 1, 5), SUBSTR(POD_CD, 1, 5)) AS POL_CONTI," ).append("\n"); 
		query.append("		    POD_CONTI," ).append("\n"); 
		query.append("           IOC_CD   ," ).append("\n"); 
		query.append("           POL_PAST ," ).append("\n"); 
		query.append("           PAST     ," ).append("\n"); 
		query.append("           POL_POD  ," ).append("\n"); 
		query.append("           HC40     ," ).append("\n"); 
		query.append("           HC45     ," ).append("\n"); 
		query.append("           HC53     ," ).append("\n"); 
		query.append("           REEFER   ," ).append("\n"); 
		query.append("           WEIGHT   ," ).append("\n"); 
		query.append("           VOLUME   ," ).append("\n"); 
		query.append("           OFC_CD   ," ).append("\n"); 
		query.append("           OFC_CONTI" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT V.RLANE_CD  ," ).append("\n"); 
		query.append("                     V.DIR_CD    ," ).append("\n"); 
		query.append("                     V.RHQ_CD    ," ).append("\n"); 
		query.append("                     V.VSL_CD    ," ).append("\n"); 
		query.append("                     V.SKD_VOY_NO," ).append("\n"); 
		query.append("                     V.SKD_DIR_CD," ).append("\n"); 
		query.append("                     V.COST_YR||V.COST_WK          AS COST_YR_WK," ).append("\n"); 
		query.append("                     NVL(S1.YD_CD, S1.VPS_PORT_CD) AS POL_CD    ," ).append("\n"); 
		query.append("                     NVL(S2.YD_CD, S2.VPS_PORT_CD) AS POD_CD    ," ).append("\n"); 
		query.append("                     S1.CLPT_SEQ AS POL_SEQ," ).append("\n"); 
		query.append("                     S2.CLPT_SEQ AS POD_SEQ," ).append("\n"); 
		query.append("                     SPC_CONTI_CONV_FNC(L1.CONTI_CD, V.RLANE_CD,S1.SKD_DIR_CD)   AS POL_CONTI," ).append("\n"); 
		query.append("                     SPC_CONTI_CONV_FNC('',V.RLANE_CD,S2.SKD_DIR_CD,S2.VPS_PORT_CD) AS POD_CONTI," ).append("\n"); 
		query.append("                     SPC_GET_OCN_IPC_FNC(V.RLANE_CD, S1.VPS_PORT_CD, S2.VPS_PORT_CD) AS IOC_CD," ).append("\n"); 
		query.append("                     (CASE" ).append("\n"); 
		query.append("                            WHEN S1.VPS_ETD_DT < GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYS_EXTRACT_UTC(SYSTIMESTAMP), S1.VPS_PORT_CD ) THEN 'Y'" ).append("\n"); 
		query.append("                                                                                                                                     ELSE 'N'" ).append("\n"); 
		query.append("                      END) AS POL_PAST," ).append("\n"); 
		query.append("                     (DECODE(V.FCAST, '1', CASE" ).append("\n"); 
		query.append("                                                WHEN S1.VPS_ETD_DT < GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYS_EXTRACT_UTC(SYSTIMESTAMP), S1.VPS_PORT_CD ) THEN 'Y'" ).append("\n"); 
		query.append("                                                                                                                                                         ELSE 'N'" ).append("\n"); 
		query.append("                                            END, '2', 'N', '3', 'Y')" ).append("\n"); 
		query.append("                     ) AS PAST," ).append("\n"); 
		query.append("                     POL_POD ," ).append("\n"); 
		query.append("                     HC40    ," ).append("\n"); 
		query.append("                     HC45    ," ).append("\n"); 
		query.append("                     HC53    ," ).append("\n"); 
		query.append("                     REEFER  ," ).append("\n"); 
		query.append("                     WEIGHT  ," ).append("\n"); 
		query.append("                     VOLUME  ," ).append("\n"); 
		query.append("                     V.OFC_CD," ).append("\n"); 
		query.append("                     V.OFC_CONTI" ).append("\n"); 
		query.append("                FROM BASE         V ," ).append("\n"); 
		query.append("                     PORT_SKD     S1," ).append("\n"); 
		query.append("                     PORT_SKD     S2," ).append("\n"); 
		query.append("                     MDM_LOCATION L1" ).append("\n"); 
		query.append("               WHERE S1.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("                 AND S1.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND S1.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND S1.VSL_CD      = S2.VSL_CD" ).append("\n"); 
		query.append("                 AND S1.SKD_VOY_NO  = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND S1.SKD_DIR_CD  = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND (    S1.PORT_SEQ = S1.MAX_SEQ   -- ????? CALLING ????? DOUBLE CALLING ????? ??????? PORT ??????? ?????" ).append("\n"); 
		query.append("                       OR S2.PORT_SEQ < S1.MAX_SEQ ) -- DOUBLE CALLING PORT?? POD ?? LAST DOUBLE CALLING PORT ????? ????? ??????? FILTERING" ).append("\n"); 
		query.append("                 AND S1.VPS_PORT_CD = L1.LOC_CD" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT V.RLANE_CD  ," ).append("\n"); 
		query.append("                     V.DIR_CD    ," ).append("\n"); 
		query.append("                     V.RHQ_CD    ," ).append("\n"); 
		query.append("                     V.VSL_CD    ," ).append("\n"); 
		query.append("                     V.SKD_VOY_NO," ).append("\n"); 
		query.append("                     V.SKD_DIR_CD," ).append("\n"); 
		query.append("                     V.COST_YR||V.COST_WK AS COST_YR_WK," ).append("\n"); 
		query.append("                     '0000000' AS POL_CD   ," ).append("\n"); 
		query.append("                     '0000000' AS POD_CD   ," ).append("\n"); 
		query.append("                     0         AS POL_SEQ  ," ).append("\n"); 
		query.append("                     0         AS POD_SEQ  ," ).append("\n"); 
		query.append("                     ' '       AS POL_CONTI," ).append("\n"); 
		query.append("                     ''        AS POD_CONTI," ).append("\n"); 
		query.append("                     DECODE(SUBSTR(V.TRD_CD, 0, 1), 'I', 'I', 'O') AS IOC_CD," ).append("\n"); 
		query.append("                     ''        AS POL_PAST ," ).append("\n"); 
		query.append("                     DECODE(V.FCAST, '1', '', '2', 'N', '3', 'Y')  AS PAST  ," ).append("\n"); 
		query.append("                     POL_POD," ).append("\n"); 
		query.append("                     HC40   ," ).append("\n"); 
		query.append("                     HC45   ," ).append("\n"); 
		query.append("                     HC53    ," ).append("\n"); 
		query.append("                     REEFER ," ).append("\n"); 
		query.append("                     WEIGHT ," ).append("\n"); 
		query.append("                     VOLUME ," ).append("\n"); 
		query.append("                     OFC_CD ," ).append("\n"); 
		query.append("                     OFC_CONTI" ).append("\n"); 
		query.append("                FROM BASE V" ).append("\n"); 
		query.append("           ) Z" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT " ).append("\n"); 
		query.append("         D.RLANE_CD,     D.DIR_CD ,    D.VSL_CD,         D.SKD_VOY_NO,  D.SKD_DIR_CD ," ).append("\n"); 
		query.append("         D.SLS_OFC_CD ,  D.POL_YD_CD,  D.POD_YD_CD ,     D.TS_FLG,      D.MNL_FLG," ).append("\n"); 
		query.append("         --20140812 추가" ).append("\n"); 
		query.append("         D.CUST_CNT_CD,  D.CUST_SEQ, D.CTRT_NO, D.USA_BKG_MOD_CD, D.DEST_LOC_CD" ).append("\n"); 
		query.append("    FROM SPC_ALOC_POL_POD D," ).append("\n"); 
		query.append("         VSL_PORT_SKD     B" ).append("\n"); 
		query.append("   WHERE D.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("     AND D.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("     AND D.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("     AND D.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND SUBSTR(D.POL_YD_CD, 1, LENGTH(B.POL_CD)) = B.POL_CD" ).append("\n"); 
		query.append("     AND SUBSTR(D.POD_YD_CD, 1, LENGTH(B.POD_CD)) = B.POD_CD" ).append("\n"); 
		query.append("     AND (D.SLS_RHQ_CD = B.RHQ_CD OR B.OFC_CONTI = B.POL_CONTI)" ).append("\n"); 
		query.append("     AND D.TS_FLG     = 'N'" ).append("\n"); 
		query.append("     AND D.SLS_OFC_CD = D.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL  " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append("        D.RLANE_CD,     D.DIR_CD ,    D.VSL_CD,         D.SKD_VOY_NO,  D.SKD_DIR_CD ," ).append("\n"); 
		query.append("        D.SLS_OFC_CD ,  D.POL_YD_CD,  D.POD_YD_CD ,     D.TS_FLG,      D.MNL_FLG," ).append("\n"); 
		query.append("        --20140812 추가" ).append("\n"); 
		query.append("        D.CUST_CNT_CD,  D.CUST_SEQ, D.CTRT_NO, D.USA_BKG_MOD_CD, D.DEST_LOC_CD" ).append("\n"); 
		query.append("   FROM SPC_ALOC_POL_POD D," ).append("\n"); 
		query.append("        VSL_PORT_SKD     B" ).append("\n"); 
		query.append("  WHERE D.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND D.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("    AND D.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND D.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND SUBSTR(D.POL_YD_CD, 1, LENGTH(B.POL_CD)) = B.POL_CD" ).append("\n"); 
		query.append("    AND SUBSTR(D.POD_YD_CD, 1, LENGTH(B.POD_CD)) = B.POD_CD" ).append("\n"); 
		query.append("    AND B.POL_CONTI <> 'A'" ).append("\n"); 
		query.append("    AND D.TS_FLG     = 'Y'" ).append("\n"); 
		query.append("    AND D.SLS_OFC_CD = D.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    AND ((D.SLS_RHQ_CD = B.RHQ_CD OR B.OFC_CONTI = B.POL_CONTI )OR B.POL_CONTI = DECODE(B.RHQ_CD, 'NYCRA', 'M', 'E'))" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" select" ).append("\n"); 
		query.append("        D.RLANE_CD,     D.DIR_CD ,    D.VSL_CD,         D.SKD_VOY_NO,  D.SKD_DIR_CD ," ).append("\n"); 
		query.append("        D.SLS_OFC_CD ,  D.POL_YD_CD,  D.POD_YD_CD ,     D.TS_FLG,      D.MNL_FLG," ).append("\n"); 
		query.append("        --20140812 추가" ).append("\n"); 
		query.append("        D.CUST_CNT_CD,  D.CUST_SEQ, D.CTRT_NO, D.USA_BKG_MOD_CD, D.DEST_LOC_CD" ).append("\n"); 
		query.append("   FROM SPC_ALOC_POL_POD D  ," ).append("\n"); 
		query.append("        BASE_KEY         P  " ).append("\n"); 
		query.append("  WHERE D.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("    AND D.DIR_CD     = P.DIR_CD" ).append("\n"); 
		query.append("    AND D.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("    AND D.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND D.SKD_DIR_CD = P.SKD_DIR_CD         " ).append("\n"); 
		query.append("    AND P.RLANE_CD   = 'WAFIE' " ).append("\n"); 
		query.append("   #if (${office} == 'HAMRU')" ).append("\n"); 
		query.append("    AND D.SLS_OFC_CD in ('HAMRU', 'NYCRA')" ).append("\n"); 
		query.append("   #else " ).append("\n"); 
		query.append("    AND D.SLS_OFC_CD = @[office]" ).append("\n"); 
		query.append("   #end                  " ).append("\n"); 
		query.append("    )  INFO, SPC_ALOC_POL_POD MAIN" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append("       INFO.RLANE_CD    = MAIN.RLANE_CD    " ).append("\n"); 
		query.append("   AND INFO.DIR_CD      = MAIN.DIR_CD" ).append("\n"); 
		query.append("   AND INFO.VSL_CD      = MAIN.VSL_CD   " ).append("\n"); 
		query.append("   AND INFO.SKD_VOY_NO  = MAIN.SKD_VOY_NO " ).append("\n"); 
		query.append("   AND INFO.SKD_DIR_CD  = MAIN.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND INFO.SLS_OFC_CD  = MAIN.SLS_OFC_CD" ).append("\n"); 
		query.append("   AND INFO.POL_YD_CD   = MAIN.POL_YD_CD " ).append("\n"); 
		query.append("   AND INFO.POD_YD_CD   = MAIN.POD_YD_CD" ).append("\n"); 
		query.append("   AND INFO.TS_FLG      = MAIN.TS_FLG" ).append("\n"); 
		query.append("   AND INFO.MNL_FLG     = MAIN.MNL_FLG" ).append("\n"); 
		query.append("   --20140812 추가" ).append("\n"); 
		query.append("   AND INFO.CUST_CNT_CD    = MAIN.CUST_CNT_CD   " ).append("\n"); 
		query.append("   AND INFO.CUST_SEQ       = MAIN.CUST_SEQ " ).append("\n"); 
		query.append("   AND INFO.CTRT_NO        = MAIN.CTRT_NO" ).append("\n"); 
		query.append("   AND INFO.USA_BKG_MOD_CD = MAIN.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("   AND INFO.DEST_LOC_CD    = MAIN.DEST_LOC_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}
