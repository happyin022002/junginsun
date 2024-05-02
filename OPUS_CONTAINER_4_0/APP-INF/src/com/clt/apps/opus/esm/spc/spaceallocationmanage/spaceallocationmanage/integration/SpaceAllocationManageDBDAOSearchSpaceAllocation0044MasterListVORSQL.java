/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * 2016.07.12 로직수정
	  * 2016.07.19 #15529 AOC- JPN Issue cannot create BKG for T2 + Refeer
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL(){
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
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL").append("\n"); 
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
		query.append("WITH COA_MON_VVD_LV AS(" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           SUBSTR(M.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(M.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.DIR_CD                  AS SKD_DIR_CD," ).append("\n"); 
		query.append("           (SELECT N2ND_PRNT_OFC_CD FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND OFC_CD =@[office])   AS RHQ_CD," ).append("\n"); 
		query.append("           @[office]                 AS SLS_OFC_CD," ).append("\n"); 
		query.append("           S1.YD_CD                  AS POL_CD    ," ).append("\n"); 
		query.append("           S2.YD_CD                  AS POD_CD    ," ).append("\n"); 
		query.append("           S1.CLPT_IND_SEQ           AS PL_CLPT_IND_SEQ ," ).append("\n"); 
		query.append("           S2.CLPT_IND_SEQ           AS PD_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("      FROM COA_MON_VVD M ," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD S1," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("     WHERE (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("       AND (SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK) IN ( SELECT COST_YR||COST_WK" ).append("\n"); 
		query.append("                                                         FROM (  SELECT P.COST_YR," ).append("\n"); 
		query.append("                                                                        P.COST_WK" ).append("\n"); 
		query.append("                                                                   FROM COA_WK_PRD P" ).append("\n"); 
		query.append("                                                                  WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                                               ORDER BY P.COST_YR||P.COST_WK ) Z" ).append("\n"); 
		query.append("                                                        WHERE ROWNUM <= @[duration] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND M.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("       AND M.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND M.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${trade} != '')" ).append("\n"); 
		query.append("       AND M.TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${subtrade} != '')" ).append("\n"); 
		query.append("       AND M.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${lane} != '')" ).append("\n"); 
		query.append("       AND M.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${bound} != '')" ).append("\n"); 
		query.append("       AND M.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND S1.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append(" AND S1.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND S1.SKD_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append(" AND S1.VSL_CD     = S2.VSL_CD" ).append("\n"); 
		query.append(" AND S1.SKD_VOY_NO = S2.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND S1.SKD_DIR_CD = S2.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND S1.CLPT_SEQ   < S2.CLPT_SEQ" ).append("\n"); 
		query.append(" AND S1.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append(" AND S2.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           V.COST_YR   ," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.COST_MON  ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.SKD_DIR_CD," ).append("\n"); 
		query.append("           V.RHQ_CD    ," ).append("\n"); 
		query.append("           V.SLS_OFC_CD," ).append("\n"); 
		query.append("           NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("      FROM            " ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           COA_MON_VVD_LV   V" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND VPS.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND NVL(VPS.SKD_CNG_STS_CD,'1') <> 'S'" ).append("\n"); 
		query.append("       AND VPS.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VVD_POL_POD AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          SELECT " ).append("\n"); 
		query.append("                 PL.COST_YR       ," ).append("\n"); 
		query.append("                 PL.COST_WK       ," ).append("\n"); 
		query.append("                 PL.COST_MON      ," ).append("\n"); 
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.DIR_CD        ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.RHQ_CD        ," ).append("\n"); 
		query.append("                 PL.SLS_OFC_CD    ," ).append("\n"); 
		query.append("                 PL.PORT_CD         AS POL_CD    ," ).append("\n"); 
		query.append("                 MAX(PL.PORT_SEQ)   AS POL_SEQ   ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ    AS PL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                 PD.PORT_CD         AS POD_CD    ," ).append("\n"); 
		query.append("                 (CASE" ).append("\n"); 
		query.append("                       WHEN MAX(PL.PORT_SEQ) < MAX(PD.MIN_SEQ) THEN MAX(PD.MIN_SEQ)" ).append("\n"); 
		query.append("                                                               ELSE CASE" ).append("\n"); 
		query.append("                                                                         WHEN MAX(PL.PORT_SEQ) > MAX(PD.MIN_SEQ) THEN MAX(PD.MAX_SEQ)" ).append("\n"); 
		query.append("                                                                     END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                 ) AS POD_SEQ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ   AS PD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM    " ).append("\n"); 
		query.append("                 VSL_PORT_SKD     PD ," ).append("\n"); 
		query.append("                 VSL_PORT_SKD     PL" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND PD.TRD_CD       = PL.TRD_CD" ).append("\n"); 
		query.append("             AND PD.SUB_TRD_CD   = PL.SUB_TRD_CD" ).append("\n"); 
		query.append("             AND PD.RLANE_CD     = PL.RLANE_CD" ).append("\n"); 
		query.append("             AND PD.VSL_CD       = PL.VSL_CD" ).append("\n"); 
		query.append("             AND PD.SKD_VOY_NO   = PL.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND PD.SKD_DIR_CD   = PL.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND PD.PORT_CD      <> PL.PORT_CD" ).append("\n"); 
		query.append("             AND PD.PORT_SEQ      > PL.PORT_SEQ" ).append("\n"); 
		query.append("             AND (PL.PORT_SEQ = PL.MAX_SEQ  OR PD.PORT_SEQ < PL.MAX_SEQ )                     " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             GROUP BY " ).append("\n"); 
		query.append("                 PL.COST_YR       ," ).append("\n"); 
		query.append("                 PL.COST_WK       ," ).append("\n"); 
		query.append("                 PL.COST_MON      ," ).append("\n"); 
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.DIR_CD        ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PD.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.RHQ_CD        ," ).append("\n"); 
		query.append("                 PL.SLS_OFC_CD    ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ        " ).append("\n"); 
		query.append(" )  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  SELECT L.TRD_CD    ," ).append("\n"); 
		query.append("         L.SUB_TRD_CD," ).append("\n"); 
		query.append("         L.RLANE_CD  ," ).append("\n"); 
		query.append("         L.DIR_CD    ," ).append("\n"); 
		query.append("         L.COST_WK   ," ).append("\n"); 
		query.append("         L.COST_MON  ," ).append("\n"); 
		query.append("         L.VSL_CD    ," ).append("\n"); 
		query.append("         L.SKD_VOY_NO," ).append("\n"); 
		query.append("         L.SKD_DIR_CD," ).append("\n"); 
		query.append("         L.VVD       ," ).append("\n"); 
		query.append("         NVL(L.AD_VOL ,0) AD_VOL    ," ).append("\n"); 
		query.append("         ROUND(L.AD_WGT) AD_WGT   ," ).append("\n"); 
		query.append("         NVL(L.TS_VOL ,0) TS_VOL   ," ).append("\n"); 
		query.append("         ROUND(L.TS_WGT) TS_WGT   ," ).append("\n"); 
		query.append("         ROUND(L.QTA_VOL) QTA_VOL  ," ).append("\n"); 
		query.append("         ROUND(L.QTA_CMB) QTA_CMB ," ).append("\n"); 
		query.append("         NVL(L.FC_VOL ,0) FC_VOL  ," ).append("\n"); 
		query.append("         ROUND(L.FC_WGT)  FC_WGT  ," ).append("\n"); 
		query.append("         NVL(L.FC_TS_VOL ,0) FC_TS_VOL," ).append("\n"); 
		query.append("         ROUND(L.FC_TS_WGT) FC_TS_WGT," ).append("\n"); 
		query.append("         NVL(L.AP_VOL ,0)   AP_VOL," ).append("\n"); 
		query.append("         ROUND(L.AP_WGT)    AP_WGT," ).append("\n"); 
		query.append("         NVL(L.AP_TS_VOL ,0) AP_TS_VOL," ).append("\n"); 
		query.append("         ROUND(L.AP_TS_WGT) AP_TS_WGT," ).append("\n"); 
		query.append("         NVL(L.BKG_VOL ,0)  BKG_VOL," ).append("\n"); 
		query.append("         ROUND(L.BKG_WGT)   BKG_WGT," ).append("\n"); 
		query.append("         NVL(L.BKG_TS_VOL ,0) BKG_TS_VOL," ).append("\n"); 
		query.append("         ROUND(L.BKG_TS_WGT) BKG_TS_WGT, " ).append("\n"); 
		query.append("         NVL(C.CTRL_LVL_CD     , 'L') AS CTRL_PORT_FLG   ," ).append("\n"); 
		query.append("         NVL(C.CTRL_40FT_HC_FLG, 'N') AS CTRL_40FT_HC_FLG," ).append("\n"); 
		query.append("         NVL(C.CTRL_45FT_HC_FLG, 'N') AS CTRL_45FT_HC_FLG," ).append("\n"); 
		query.append("         NVL(C.CTRL_53FT_FLG   , 'N') AS CTRL_53FT_FLG   ," ).append("\n"); 
		query.append("         NVL(C.CTRL_RF_FLG     , 'N') AS CTRL_RF_FLG     ," ).append("\n"); 
		query.append("         NVL(C.CTRL_WGT_FLG    , 'N') AS CTRL_WGT_FLG    ," ).append("\n"); 
		query.append("         NVL(C.CTRL_SPC_FLG    , 'N') AS CTRL_SPC_FLG    ," ).append("\n"); 
		query.append("         DECODE(C.RLANE_CD, NULL, 'I', 'R') AS IBFLAG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR||COST_WK AS COST_WK," ).append("\n"); 
		query.append("                   COST_MON  ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                   SUM(AD_VOL)  AS AD_VOL ," ).append("\n"); 
		query.append("                   SUM(AD_WGT)  AS AD_WGT ," ).append("\n"); 
		query.append("                   SUM(TS_VOL)  AS TS_VOL ," ).append("\n"); 
		query.append("                   SUM(TS_WGT)  AS TS_WGT ," ).append("\n"); 
		query.append("                   SUM(QTA_VOL) AS QTA_VOL," ).append("\n"); 
		query.append("                   SUM(QTA_CMB) AS QTA_CMB," ).append("\n"); 
		query.append("                   SUM(FC_VOL)  AS FC_VOL ," ).append("\n"); 
		query.append("                   SUM(FC_WGT)  AS FC_WGT ," ).append("\n"); 
		query.append("                   SUM(FC_TS_VOL)  AS FC_TS_VOL ," ).append("\n"); 
		query.append("                   SUM(FC_TS_WGT)  AS FC_TS_WGT ,                    " ).append("\n"); 
		query.append("                   SUM(AP_VOL)  AS AP_VOL ," ).append("\n"); 
		query.append("                   SUM(AP_WGT)  AS AP_WGT ," ).append("\n"); 
		query.append("                   SUM(AP_TS_VOL)  AS AP_TS_VOL ," ).append("\n"); 
		query.append("                   SUM(AP_TS_WGT)  AS AP_TS_WGT ,                   " ).append("\n"); 
		query.append("                   SUM(BKG_VOL) AS BKG_VOL," ).append("\n"); 
		query.append("                   SUM(BKG_WGT) AS BKG_WGT," ).append("\n"); 
		query.append("                   SUM(BKG_TS_VOL) AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   SUM(BKG_TS_WGT) AS BKG_TS_WGT " ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      -- Forecast" ).append("\n"); 
		query.append("                      SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD," ).append("\n"); 
		query.append("                             NULL AS AD_VOL ," ).append("\n"); 
		query.append("                             NULL AS AD_WGT ," ).append("\n"); 
		query.append("                             NULL AS TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS QTA_VOL," ).append("\n"); 
		query.append("                             NULL AS QTA_CMB," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T', 0, NVL(DA.CFM_TTL_QTY, 0) + NVL(DA.CFM_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD ,B.RLANE_CD ,B.SKD_DIR_CD ,B.VSL_CD , B.SKD_VOY_NO, 'D5') + NVL(DA.CFM_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD ,B.RLANE_CD ,B.SKD_DIR_CD ,B.VSL_CD ,B.SKD_VOY_NO,'D7') + NVL(DA.CFM_53FT_QTY, 0) * 2) AS FC_VOL," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T', 0, NVL(DA.CFM_TTL_WGT, 0)) AS FC_WGT," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T', NVL(DA.CFM_TTL_QTY, 0) + NVL(DA.CFM_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD ,B.RLANE_CD ,B.SKD_DIR_CD ,B.VSL_CD , B.SKD_VOY_NO,'D5') + NVL(DA.CFM_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD ,B.RLANE_CD ,B.SKD_DIR_CD ,B.VSL_CD , B.SKD_VOY_NO,'D7') + NVL(DA.CFM_53FT_QTY, 0) * 2) AS FC_TS_VOL," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T', DA.CFM_TTL_WGT) AS FC_TS_WGT,                                 " ).append("\n"); 
		query.append("                             NULL AS AP_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_WGT ,                                 " ).append("\n"); 
		query.append("                             NULL AS BKG_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_WGT," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_WGT                             " ).append("\n"); 
		query.append("                        FROM VVD_POL_POD        B ," ).append("\n"); 
		query.append("                             SPC_DLY_FCAST_CUST DA" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND B.TRD_CD = DA.TRD_CD" ).append("\n"); 
		query.append("                         AND ((B.SUB_TRD_CD IS NULL AND DA.SUB_TRD_CD IS NULL) OR B.SUB_TRD_CD = DA.SUB_TRD_CD)" ).append("\n"); 
		query.append("                         AND B.RLANE_CD   = DA.RLANE_CD" ).append("\n"); 
		query.append("                         AND B.DIR_CD     = DA.DIR_CD" ).append("\n"); 
		query.append("                         AND B.VSL_CD     = DA.VSL_CD" ).append("\n"); 
		query.append("                         AND B.SKD_VOY_NO = DA.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND B.DIR_CD     = DA.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND B.SLS_OFC_CD = DA.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                         AND B.POL_CD     = DA.POL_YD_CD" ).append("\n"); 
		query.append("                         AND B.POD_CD     = DA.POD_YD_CD" ).append("\n"); 
		query.append("                         AND NVL(B.PL_CLPT_IND_SEQ,'1') = NVL(DA.POL_IND_SEQ,'1')" ).append("\n"); 
		query.append("                         AND NVL(B.PD_CLPT_IND_SEQ,'1') = NVL(DA.POD_IND_SEQ,'1')" ).append("\n"); 
		query.append("                         AND NVL(DA.CFM_TTL_QTY, 0) + NVL(DA.CFM_40FT_HC_QTY, 0) + NVL(DA.CFM_45FT_HC_QTY, 0) + NVL(DA.CFM_53FT_QTY, 0) + NVL(DA.CFM_TTL_WGT, 0) > 0 " ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      --Allocated/Allocation" ).append("\n"); 
		query.append("                      SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_QTY)) AS AD_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_WGT)) AS AD_WGT," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_QTY)) AS TS_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_WGT)) AS TS_WGT,                             " ).append("\n"); 
		query.append("                             NULL AS QTA_VOL," ).append("\n"); 
		query.append("                             NULL AS QTA_CMB," ).append("\n"); 
		query.append("                             NULL AS FC_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_WGT ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_WGT ,                             " ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_QTY)) AS AP_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_WGT)) AS AP_WGT," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_QTY)) AS AP_TS_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_WGT)) AS AP_TS_WGT,  " ).append("\n"); 
		query.append("                             NULL AS BKG_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_WGT," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_WGT  " ).append("\n"); 
		query.append("                        FROM VVD_POL_POD      B," ).append("\n"); 
		query.append("                             SPC_ALOC_POL_POD D" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                         AND B.TRD_CD = D.TRD_CD" ).append("\n"); 
		query.append("                         AND ((B.SUB_TRD_CD IS NULL AND D.SUB_TRD_CD IS NULL) OR B.SUB_TRD_CD = D.SUB_TRD_CD)" ).append("\n"); 
		query.append("                         AND B.RLANE_CD               = D.RLANE_CD" ).append("\n"); 
		query.append("                         AND B.DIR_CD                 = D.DIR_CD" ).append("\n"); 
		query.append("                         AND B.VSL_CD                 = D.VSL_CD" ).append("\n"); 
		query.append("                         AND B.SKD_VOY_NO             = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND B.DIR_CD                 = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND (B.SLS_OFC_CD            = D.SLS_OFC_CD OR B.SLS_OFC_CD = D.SLS_RGN_OFC_CD)" ).append("\n"); 
		query.append("                         AND B.POL_CD                 = D.POL_YD_CD" ).append("\n"); 
		query.append("                         AND B.POD_CD                 = D.POD_YD_CD" ).append("\n"); 
		query.append("                         AND NVL(B.PL_CLPT_IND_SEQ,'1') = NVL(D.POL_IND_SEQ,'1')" ).append("\n"); 
		query.append("                         AND NVL(B.PD_CLPT_IND_SEQ,'1') = NVL(D.POD_IND_SEQ,'1')" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      --Booking" ).append("\n"); 
		query.append("                      SELECT " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                       TRD_CD        ," ).append("\n"); 
		query.append("                       SUB_TRD_CD    ," ).append("\n"); 
		query.append("                       RLANE_CD      ," ).append("\n"); 
		query.append("                       DIR_CD        ," ).append("\n"); 
		query.append("                       COST_YR       ," ).append("\n"); 
		query.append("                       COST_MON      ," ).append("\n"); 
		query.append("                       COST_WK       ," ).append("\n"); 
		query.append("                       VSL_CD        ," ).append("\n"); 
		query.append("                       SKD_VOY_NO    ," ).append("\n"); 
		query.append("                       SKD_DIR_CD    ," ).append("\n"); 
		query.append("                       NULL AS AD_VOL ," ).append("\n"); 
		query.append("                       NULL AS AD_WGT ," ).append("\n"); 
		query.append("                       NULL AS TS_VOL ," ).append("\n"); 
		query.append("                       NULL AS TS_WGT ," ).append("\n"); 
		query.append("                       NULL AS QTA_VOL," ).append("\n"); 
		query.append("                       NULL AS QTA_CMB," ).append("\n"); 
		query.append("                       NULL AS FC_VOL ," ).append("\n"); 
		query.append("                       NULL AS FC_WGT ," ).append("\n"); 
		query.append("                       NULL AS FC_TS_VOL ," ).append("\n"); 
		query.append("                       NULL AS FC_TS_WGT ,                             " ).append("\n"); 
		query.append("                       NULL AS AP_VOL ," ).append("\n"); 
		query.append("                       NULL AS AP_WGT ," ).append("\n"); 
		query.append("                       NULL AS AP_TS_VOL ," ).append("\n"); 
		query.append("                       NULL AS AP_TS_WGT ," ).append("\n"); 
		query.append("                       DECODE(VSL_PRE_PST_CD, 'T', TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0))) AS BKG_VOL," ).append("\n"); 
		query.append("                       DECODE(VSL_PRE_PST_CD, 'T', TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))) AS BKG_WGT," ).append("\n"); 
		query.append("                       DECODE(VSL_PRE_PST_CD, 'T', 0, TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0))) AS BKG_TS_VOL," ).append("\n"); 
		query.append("                       DECODE(VSL_PRE_PST_CD, 'T', 0, TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))) AS BKG_TS_WGT   " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                   FROM (" ).append("\n"); 
		query.append("                        SELECT /*+ ORDERED USE_NL(VPP BV B D) USE_HASH(O) */" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                               VPP.TRD_CD        ," ).append("\n"); 
		query.append("                               VPP.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                               VPP.RLANE_CD      ," ).append("\n"); 
		query.append("                               VPP.DIR_CD        ," ).append("\n"); 
		query.append("                               VPP.COST_YR       ," ).append("\n"); 
		query.append("                               VPP.COST_MON      ," ).append("\n"); 
		query.append("                               VPP.COST_WK       ," ).append("\n"); 
		query.append("                               VPP.VSL_CD        ," ).append("\n"); 
		query.append("                               VPP.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                               VPP.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                               BV.VSL_PRE_PST_CD ," ).append("\n"); 
		query.append("                               (                        " ).append("\n"); 
		query.append("                                SELECT B.TRD_CD||B.SUB_TRD_CD||B.RLANE_CD " ).append("\n"); 
		query.append("                                FROM MDM_REV_LANE A," ).append("\n"); 
		query.append("                                  MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                WHERE B.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("                                  AND B.RLANE_CD LIKE BV.SLAN_CD||'%'" ).append("\n"); 
		query.append("                                  AND B.FM_CONTI_CD = (" ).append("\n"); 
		query.append("                                                        SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                        FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                        WHERE MLOC.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("                                  AND B.TO_CONTI_CD = (" ).append("\n"); 
		query.append("                                                        SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                        FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                        WHERE MLOC.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("                                  AND B.VSL_SLAN_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1  ) AS BKG_RLANE ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT" ).append("\n"); 
		query.append("                                            TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, '5', SPC_GET_HC_RT_BSA_FNC(VPP.TRD_CD ,VPP.RLANE_CD ,VPP.SKD_DIR_CD ,VPP.VSL_CD ,VPP.SKD_VOY_NO,'D5'), '7', SPC_GET_HC_RT_BSA_FNC(VPP.TRD_CD ,VPP.RLANE_CD ,VPP.SKD_DIR_CD ,VPP.VSL_CD ,VPP.SKD_VOY_NO,'D7'), 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'W', Q.OP_CNTR_QTY, 0) + DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'X', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0) + DECODE(SAQ_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'T', Q.RC_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))" ).append("\n"); 
		query.append("                                                                 + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                           FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                          WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                    FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                   WHERE B.BKG_NO      = Q.BKG_NO" ).append("\n"); 
		query.append("                                     AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("                               ) AS VAL" ).append("\n"); 
		query.append("                         FROM  VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               SPC_OFC_LVL O  ," ).append("\n"); 
		query.append("                               BKG_BL_DOC  D" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND O.OFC_TP_CD     IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           AND VPP.SLS_OFC_CD   = O.N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("                           AND O.OFC_CD         = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD    IN ('W', 'F')" ).append("\n"); 
		query.append("                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("                           AND BV.VSL_CD        = VPP.VSL_CD" ).append("\n"); 
		query.append("                           AND BV.SKD_VOY_NO    = VPP.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND BV.SKD_DIR_CD    = VPP.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND BV.POL_YD_CD     = VPP.POL_CD --2016.03.31 수정" ).append("\n"); 
		query.append("                           AND BV.POD_YD_CD     = VPP.POD_CD --2016.03.31 수정" ).append("\n"); 
		query.append("                          " ).append("\n"); 
		query.append("                           AND NVL(VPP.PL_CLPT_IND_SEQ,'1') = NVL(BV.POL_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("                           AND NVL(VPP.PD_CLPT_IND_SEQ,'1') = NVL(BV.POD_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("                           AND VPP.COST_YR || VPP.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                     AND TRD_CD     = SUBSTR(BKG_RLANE,1,3)" ).append("\n"); 
		query.append("                     AND SUB_TRD_CD = SUBSTR(BKG_RLANE,4,2)" ).append("\n"); 
		query.append("                     AND RLANE_CD   = SUBSTR(BKG_RLANE,6,5)" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                     UNION ALL                       " ).append("\n"); 
		query.append("                      -- Booking Quota / CMB" ).append("\n"); 
		query.append("                      SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD," ).append("\n"); 
		query.append("                             NULL AS AD_VOL," ).append("\n"); 
		query.append("                             NULL AS AD_WGT," ).append("\n"); 
		query.append("                             NULL AS TS_VOL," ).append("\n"); 
		query.append("                             NULL AS TS_WGT," ).append("\n"); 
		query.append("                             ROUND(SUM(MQ.LOD_QTY)) AS QTA_VOL," ).append("\n"); 
		query.append("                             DECODE(ROUND(SUM(MQ.LOD_QTY)), 0, 0, (SUM(MQ.GRS_RPB_REV * MQ.LOD_QTY) - SUM(MQ.CM_UC_AMT * MQ.LOD_QTY)) / ROUND(SUM(MQ.LOD_QTY))) AS QTA_CMB," ).append("\n"); 
		query.append("                             NULL AS FC_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_WGT ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS BKG_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_WGT," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_WGT  " ).append("\n"); 
		query.append("                        FROM COA_MON_VVD_LV   B  ," ).append("\n"); 
		query.append("                             SAQ_MON_CFM_QTA  MQ ," ).append("\n"); 
		query.append("                             SAQ_MON_QTA_RLSE MQR" ).append("\n"); 
		query.append("                       WHERE MQR.BSE_YR          = B.COST_YR" ).append("\n"); 
		query.append("                         AND MQR.BSE_QTR_CD      = CEIL(TO_NUMBER(B.COST_MON) / 3)||'Q'" ).append("\n"); 
		query.append("                         AND MQR.QTA_RLSE_STS_CD = 'R'" ).append("\n"); 
		query.append("                         AND MQ.MQTA_RLSE_VER_NO = MQR.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                         AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("                         AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("                         AND MQ.QTA_TGT_CD       = 'T'" ).append("\n"); 
		query.append("                         AND MQ.BSE_MON          = B.COST_MON" ).append("\n"); 
		query.append("                         AND MQ.TRD_CD           = B.TRD_CD" ).append("\n"); 
		query.append("                         AND MQ.RLANE_CD         = B.RLANE_CD" ).append("\n"); 
		query.append("                         AND MQ.DIR_CD           = B.DIR_CD" ).append("\n"); 
		query.append("                         AND MQ.VSL_CD           = B.VSL_CD" ).append("\n"); 
		query.append("                         AND MQ.SKD_VOY_NO       = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND MQ.SKD_DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND MQ.RGN_OFC_CD       = B.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND MQ.LOD_QTY          > 0" ).append("\n"); 
		query.append("                    GROUP BY B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD                   " ).append("\n"); 
		query.append("                   ) Z" ).append("\n"); 
		query.append("          GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_MON  ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD" ).append("\n"); 
		query.append("         ) L," ).append("\n"); 
		query.append("         SPC_ALOC_CTRL_OPT C" ).append("\n"); 
		query.append("   WHERE L.RLANE_CD   = C.RLANE_CD  (+)" ).append("\n"); 
		query.append("     AND L.DIR_CD     = C.DIR_CD    (+)" ).append("\n"); 
		query.append("     AND L.VSL_CD     = C.VSL_CD    (+)" ).append("\n"); 
		query.append("     AND L.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("     AND L.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("ORDER BY 1," ).append("\n"); 
		query.append("         2," ).append("\n"); 
		query.append("         3," ).append("\n"); 
		query.append("         4," ).append("\n"); 
		query.append("         5," ).append("\n"); 
		query.append("         6" ).append("\n"); 

	}
}