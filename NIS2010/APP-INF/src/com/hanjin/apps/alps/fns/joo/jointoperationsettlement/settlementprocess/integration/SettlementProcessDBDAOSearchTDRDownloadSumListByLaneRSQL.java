/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOSearchTDRDownloadSumListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.12
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.08.12 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOSearchTDRDownloadSumListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * I-Strorage조회(Merge)
	  * </pre>
	  */
	public SettlementProcessDBDAOSearchTDRDownloadSumListByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("merge_crr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSearchTDRDownloadSumListByLaneRSQL").append("\n"); 
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
		query.append("WITH MERGE_DATA AS(" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT @[merge_crr] CRR_CD" ).append("\n"); 
		query.append("         , A.TRD_CD" ).append("\n"); 
		query.append("         , A.RLANE_CD" ).append("\n"); 
		query.append("         , A.REV_DIR_CD" ).append("\n"); 
		query.append("         , A.RE_DIVR_CD" ).append("\n"); 
		query.append("         , A.VSL_CD" ).append("\n"); 
		query.append("         , A.SKD_VOY_NO" ).append("\n"); 
		query.append("         , A.SKD_DIR_CD" ).append("\n"); 
		query.append("         , A.VPS_PORT_CD" ).append("\n"); 
		query.append("         , A.YD_CD" ).append("\n"); 
		query.append("         , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , SUBSTR(A.RLANE_CD,0,3) AS SLAN_CD" ).append("\n"); 
		query.append("         , A.VPS_ETD_DT" ).append("\n"); 
		query.append("         , SUM(A.TTL_SLT_KNT) AS TTL_SLT_KNT" ).append("\n"); 
		query.append("         , SUM(A.HC_20FT_FCNTR_KNT) AS HC_20FT_FCNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.HC_20FT_MCNTR_KNT) AS HC_20FT_MCNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.HC_40FT_FCNTR_KNT) AS HC_40FT_FCNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.HC_40FT_MCNTR_KNT) AS HC_40FT_MCNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.FCNTR_45FT_KNT) AS FCNTR_45FT_KNT" ).append("\n"); 
		query.append("         , SUM(A.MCNTR_45FT_KNT) AS MCNTR_45FT_KNT" ).append("\n"); 
		query.append("         , SUM(A.AWK_CNTR_KNT) AS AWK_CNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.AWK_VOID_CNTR_KNT) AS AWK_VOID_CNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.DG_20FT_CNTR_KNT) AS DG_20FT_CNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.DG_40FT_CNTR_KNT) AS DG_40FT_CNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.RF_20FT_CNTR_KNT) AS RF_20FT_CNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.RF_40FT_CNTR_KNT) AS RF_40FT_CNTR_KNT" ).append("\n"); 
		query.append("         , SUM(A.CNTR_TEU_QTY) AS CNTR_TEU_QTY" ).append("\n"); 
		query.append("         , SUM(A.FCNTR_20FT_KNT) AS FCNTR_20FT_KNT" ).append("\n"); 
		query.append("         , SUM(A.MCNTR_20FT_KNT) AS MCNTR_20FT_KNT" ).append("\n"); 
		query.append("         , SUM(A.FCNTR_40FT_KNT) AS FCNTR_40FT_KNT" ).append("\n"); 
		query.append("         , SUM(A.MCNTR_40FT_KNT) AS MCNTR_40FT_KNT" ).append("\n"); 
		query.append("         , SUM(A.CNTR_WGT) AS CNTR_WGT" ).append("\n"); 
		query.append("         , SUM(A.TTL_SLT_WGT) TTL_SLT_WGT" ).append("\n"); 
		query.append("         , 1 SUB_CHK" ).append("\n"); 
		query.append("         , 'IST'  AS SOURCE" ).append("\n"); 
		query.append("      FROM JOO_BAY_PLN A" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       AND A.RLANE_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("       #if (${vvd} != '')   " ).append("\n"); 
		query.append("       AND A.VSL_CD LIKE SUBSTR(@[vvd], 1, 4) || '%'" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO LIKE SUBSTR(@[vvd], 5, 4) || '%'" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD LIKE SUBSTR(@[vvd], 9, 1) || '%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("       AND A.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${opr_cd} != '')" ).append("\n"); 
		query.append("       AND A.CRR_CD IN (" ).append("\n"); 
		query.append("			#foreach($key IN ${opr_cd2})" ).append("\n"); 
		query.append("				#if($velocityCount < $opr_cd2.size())" ).append("\n"); 
		query.append("					'${key}'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'$key'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AND A.VPS_ETD_DT BETWEEN TO_DATE(REPLACE (@[pre_fr], '-', '') || '000000', 'YYYYMMDDHH24MISS') AND TO_DATE(REPLACE (@[pre_to], '-', '') || '235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     GROUP BY A.TRD_CD" ).append("\n"); 
		query.append("            , A.RLANE_CD" ).append("\n"); 
		query.append("            , A.REV_DIR_CD" ).append("\n"); 
		query.append("            , A.RE_DIVR_CD" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.VPS_PORT_CD" ).append("\n"); 
		query.append("            , A.YD_CD" ).append("\n"); 
		query.append("            , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.VPS_ETD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A.CRR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.RE_DIVR_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.VPS_PORT_CD" ).append("\n"); 
		query.append("     , A.YD_CD" ).append("\n"); 
		query.append("     , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , A.CLPT_SEQ" ).append("\n"); 
		query.append("     , A.PORT_SKD_STS" ).append("\n"); 
		query.append("     , A.RDR_FLG" ).append("\n"); 
		query.append("     , A.SLAN_CD" ).append("\n"); 
		query.append("     , A.VPS_ETD_DT" ).append("\n"); 
		query.append("     , A.GRAND_TTL_SLOT" ).append("\n"); 
		query.append("     , A.GRAND_TTL_WGT" ).append("\n"); 
		query.append("     , A.HC_LD_20" ).append("\n"); 
		query.append("     , A.HC_BSA_20" ).append("\n"); 
		query.append("     , A.HC_LD_40" ).append("\n"); 
		query.append("     , A.HC_BSA_40" ).append("\n"); 
		query.append("     , A.HC_LD_45" ).append("\n"); 
		query.append("     , A.HC_BSA_45" ).append("\n"); 
		query.append("     , A.AK_UNIT" ).append("\n"); 
		query.append("     , A.AK_VOID" ).append("\n"); 
		query.append("     , A.DG_20" ).append("\n"); 
		query.append("     , A.DG_40" ).append("\n"); 
		query.append("     , A.RF_20_QTY" ).append("\n"); 
		query.append("     , A.RF_40_QTY" ).append("\n"); 
		query.append("     , A.RF_RDR_QTY" ).append("\n"); 
		query.append("     , A.MT_TEU" ).append("\n"); 
		query.append("     , A.FULL_20" ).append("\n"); 
		query.append("     , A.MT_20" ).append("\n"); 
		query.append("     , A.FULL_40" ).append("\n"); 
		query.append("     , A.MT_40" ).append("\n"); 
		query.append("     , A.MT_WT" ).append("\n"); 
		query.append("     , A.JO_20FT_N1ST_RTO" ).append("\n"); 
		query.append("     , A.JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_40FT_N1ST_RTO" ).append("\n"); 
		query.append("     , A.JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_45FT_N1ST_RTO" ).append("\n"); 
		query.append("     , A.JO_45FT_N2ND_RTO" ).append("\n"); 
		query.append("     , A.JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , A.JO_RND_RULE_LVL" ).append("\n"); 
		query.append("     , A.TEU_QTY" ).append("\n"); 
		query.append("     , A.ALL_TEU" ).append("\n"); 
		query.append("     , A.ALL_WGT" ).append("\n"); 
		query.append("     , A.BSA_FLG" ).append("\n"); 
		query.append("     , TGT.REV_YRMON" ).append("\n"); 
		query.append("     , TGT.REV_YRMON_SEQ" ).append("\n"); 
		query.append("     , NVL(TGT.STL_TGT_FLG, 0) AS STL_TGT_FLG" ).append("\n"); 
		query.append("     , NVL(TGT.STL_TGT_FLG, 0) AS STL_TGT_FLG2" ).append("\n"); 
		query.append("     , NVL(TGT.STL_CLZ_FLG, 0) AS STL_CLZ_FLG" ).append("\n"); 
		query.append("     ,(" ).append("\n"); 
		query.append("         SELECT NVL(MAX(J3.ACCT_YRMON),'999912') AS ACCT_YRMON" ).append("\n"); 
		query.append("         FROM JOO_STL_TGT J2, JOO_SETTLEMENT J3" ).append("\n"); 
		query.append("         WHERE J2.REV_YRMON = TGT.REV_YRMON" ).append("\n"); 
		query.append("           AND J2.REV_YRMON_SEQ = TGT.REV_YRMON_SEQ" ).append("\n"); 
		query.append("           AND J2.ACCT_YRMON = J3.ACCT_YRMON(+)" ).append("\n"); 
		query.append("           AND J2.STL_VVD_SEQ = J3.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("           AND J2.STL_SEQ = J3.STL_SEQ(+)" ).append("\n"); 
		query.append("           AND J2.CRR_CD = J3.JO_CRR_CD(+)" ).append("\n"); 
		query.append("           AND J2.TRD_CD = J3.TRD_CD(+)" ).append("\n"); 
		query.append("           AND J2.RLANE_CD = J3.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND J2.CRR_CD = @[merge_crr]" ).append("\n"); 
		query.append("           AND J3.JO_CRR_CD (+)= @[merge_crr]" ).append("\n"); 
		query.append("       ) ACCT_YRMON	 " ).append("\n"); 
		query.append("     , TGT.JO_STL_RMK_CD AS RMK_FLG" ).append("\n"); 
		query.append("     , TGT.JO_STL_RMK AS RMK" ).append("\n"); 
		query.append("     , SUB_CHK" ).append("\n"); 
		query.append("     , SOURCE" ).append("\n"); 
		query.append("     , MIN(TO_CHAR(A.VPS_ETD_DT, 'YYYYMMDDHH24MISS')) OVER (PARTITION BY A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD) AS VVD_ETD_GROUP" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT @[merge_crr] CRR_CD" ).append("\n"); 
		query.append("         , A.TRD_CD" ).append("\n"); 
		query.append("         , A.RLANE_CD" ).append("\n"); 
		query.append("         , A.REV_DIR_CD" ).append("\n"); 
		query.append("         , A.RE_DIVR_CD" ).append("\n"); 
		query.append("         , A.VSL_CD" ).append("\n"); 
		query.append("         , A.SKD_VOY_NO" ).append("\n"); 
		query.append("         , A.SKD_DIR_CD" ).append("\n"); 
		query.append("         , A.VPS_PORT_CD" ).append("\n"); 
		query.append("         , A.YD_CD" ).append("\n"); 
		query.append("         , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , LPAD(MAX(VSK.CLPT_SEQ), 2, '0') || (" ).append("\n"); 
		query.append("           SELECT '/' || LPAD(MAX(CLPT_SEQ), 2, '0')" ).append("\n"); 
		query.append("             FROM VSK_VSL_PORT_SKD Q" ).append("\n"); 
		query.append("            WHERE VSK.VSL_CD = Q.VSL_CD" ).append("\n"); 
		query.append("              AND VSK.SKD_VOY_NO = Q.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND VSK.SKD_DIR_CD = Q.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND Q.TURN_PORT_IND_CD NOT IN ('D','V','F')       " ).append("\n"); 
		query.append("              AND NVL(Q.SKD_CNG_STS_CD, 'A') <>  'S'         " ).append("\n"); 
		query.append("         ) CLPT_SEQ" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("             SELECT DECODE(INTG_CD_VAL_DP_DESC, NULL, INTG_CD_VAL_DESC, INTG_CD_VAL_DP_DESC) AS CODE_DESC" ).append("\n"); 
		query.append("               FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("              WHERE INTG_CD_ID = 'CD01821'" ).append("\n"); 
		query.append("                AND INTG_CD_VAL_CTNT = VSK.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("         ) AS PORT_SKD_STS  " ).append("\n"); 
		query.append("         ,CASE WHEN JRDR.RDR_FLG = 'Y' THEN 'R'" ).append("\n"); 
		query.append("               WHEN JRDR.RDR_FLG = 'N' THEN ''" ).append("\n"); 
		query.append("          ELSE DECODE(A.VPS_PORT_CD,RDR.PORT_CD,'R','')" ).append("\n"); 
		query.append("          END AS RDR_FLG" ).append("\n"); 
		query.append("         , SUBSTR(A.RLANE_CD,0,3) AS SLAN_CD" ).append("\n"); 
		query.append("         , A.VPS_ETD_DT" ).append("\n"); 
		query.append("         , SUM(A.TTL_SLT_KNT) AS GRAND_TTL_SLOT" ).append("\n"); 
		query.append("         , DECODE(DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_OVR_TON_WGT), 0), NVL(MAX(PRT_BSA.JO_OVR_TON_WGT), 0)), 0, 0, SUM(A.TTL_SLT_WGT)) AS GRAND_TTL_WGT" ).append("\n"); 
		query.append("         , SUM(A.HC_20FT_FCNTR_KNT) AS HC_LD_20" ).append("\n"); 
		query.append("         , SUM(A.HC_20FT_MCNTR_KNT) AS HC_BSA_20" ).append("\n"); 
		query.append("         , SUM(A.HC_40FT_FCNTR_KNT) AS HC_LD_40" ).append("\n"); 
		query.append("         , SUM(A.HC_40FT_MCNTR_KNT) AS HC_BSA_40" ).append("\n"); 
		query.append("         , SUM(A.FCNTR_45FT_KNT) AS HC_LD_45" ).append("\n"); 
		query.append("         , SUM(A.MCNTR_45FT_KNT) AS HC_BSA_45" ).append("\n"); 
		query.append("         , SUM(A.AWK_CNTR_KNT) AS AK_UNIT" ).append("\n"); 
		query.append("         , SUM(A.AWK_VOID_CNTR_KNT) AS AK_VOID" ).append("\n"); 
		query.append("         , SUM(A.DG_20FT_CNTR_KNT) AS DG_20" ).append("\n"); 
		query.append("         , SUM(A.DG_40FT_CNTR_KNT) AS DG_40" ).append("\n"); 
		query.append("         , SUM(A.RF_20FT_CNTR_KNT) AS RF_20_QTY" ).append("\n"); 
		query.append("         , SUM(A.RF_40FT_CNTR_KNT) AS RF_40_QTY" ).append("\n"); 
		query.append("         ,(" ).append("\n"); 
		query.append("             SELECT COUNT(1)" ).append("\n"); 
		query.append("             FROM BAY_PLAN BB" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("             AND BB.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("             AND BB.VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND BB.DIR_CD     = A.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND BB.PORT_CD    = A.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND BB.CALL_IND   = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND BB.OPR_CD     IN (" ).append("\n"); 
		query.append("                 #foreach($key IN ${opr_cd2})" ).append("\n"); 
		query.append("                     #if($velocityCount < $opr_cd2.size())" ).append("\n"); 
		query.append("                         '${key}'," ).append("\n"); 
		query.append("                     #else" ).append("\n"); 
		query.append("                         '$key'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             AND (BB.CARGO_TYPE = 'RF' OR BB.TEMP IS NOT NULL)" ).append("\n"); 
		query.append("             AND BB.PLAN_TYPE = 'F'                       " ).append("\n"); 
		query.append("         ) RF_RDR_QTY" ).append("\n"); 
		query.append("         , SUM(A.CNTR_TEU_QTY) AS MT_TEU" ).append("\n"); 
		query.append("         , SUM(A.FCNTR_20FT_KNT) AS FULL_20" ).append("\n"); 
		query.append("         , SUM(A.MCNTR_20FT_KNT) AS MT_20" ).append("\n"); 
		query.append("         , SUM(A.FCNTR_40FT_KNT) AS FULL_40" ).append("\n"); 
		query.append("         , SUM(A.MCNTR_40FT_KNT) AS MT_40" ).append("\n"); 
		query.append("         , SUM(A.CNTR_WGT) AS MT_WT" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         -- JOO BSA AGMT 데이터 출력 DECODE(PORT_BSA, NULL, ALL_BSA, PORT_BSA) 1순위 : PORT별설정, 2순위 ALL설정, 3순위 NULL" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_20FT_OVR_RTO), 0),        NVL(MAX(PRT_BSA.JO_20FT_OVR_RTO), 0)) * 2 AS JO_20FT_N1ST_RTO" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_20FT_SUB_TEU_QTY), 0),    NVL(MAX(PRT_BSA.JO_20FT_SUB_TEU_QTY), 0)) AS JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_40FT_OVR_RTO), 0),        NVL(MAX(PRT_BSA.JO_40FT_OVR_RTO), 0)) * 2 AS JO_40FT_N1ST_RTO" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_40FT_SUB_TEU_QTY), 0),    NVL(MAX(PRT_BSA.JO_40FT_SUB_TEU_QTY), 0)) AS JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_45FT_UND_RTO), 0),        NVL(MAX(PRT_BSA.JO_45FT_UND_RTO), 0)) * 2 AS JO_45FT_N1ST_RTO" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_45FT_OVR_RTO), 0),        NVL(MAX(PRT_BSA.JO_45FT_OVR_RTO), 0)) * 2 AS JO_45FT_N2ND_RTO" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_45FT_SUB_TEU_QTY), 0),    NVL(MAX(PRT_BSA.JO_45FT_SUB_TEU_QTY), 0)) AS JO_45FT_SUB_TEU_QTY	" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_RND_RULE_LVL), 4),        NVL(MAX(PRT_BSA.JO_RND_RULE_LVL), 4))     AS JO_RND_RULE_LVL" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_TON_TEU_QTY), 0),         NVL(MAX(PRT_BSA.JO_TON_TEU_QTY), 0))      AS TEU_QTY  " ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_OVR_BSA_TEU_QTY), 0),     NVL(MAX(PRT_BSA.JO_OVR_BSA_TEU_QTY), 0))  AS ALL_TEU" ).append("\n"); 
		query.append("         , DECODE(MAX(PRT_BSA.TRD_CD),   NULL,   NVL(MAX(ALL_BSA.JO_OVR_TON_WGT), 0),         NVL(MAX(PRT_BSA.JO_OVR_TON_WGT), 0))      AS ALL_WGT" ).append("\n"); 
		query.append("         , CASE WHEN MAX(PRT_BSA.TRD_CD) IS NULL AND MAX(ALL_BSA.TRD_CD) IS NULL THEN ''" ).append("\n"); 
		query.append("                WHEN MAX(PRT_BSA.TRD_CD) IS NOT NULL THEN 'P'" ).append("\n"); 
		query.append("           ELSE 'A'" ).append("\n"); 
		query.append("           END BSA_FLG" ).append("\n"); 
		query.append("         , 1 SUB_CHK" ).append("\n"); 
		query.append("         , 'IST'  AS SOURCE" ).append("\n"); 
		query.append("      FROM MERGE_DATA A" ).append("\n"); 
		query.append("         , JOO_BSA_AGMT ALL_BSA " ).append("\n"); 
		query.append("         , JOO_BSA_AGMT PRT_BSA" ).append("\n"); 
		query.append("         , VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("         , RDR_HEADER RDR" ).append("\n"); 
		query.append("         , JOO_RDR_PORT JRDR" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       ----- BSA ALL DATA JOIN START ------------------" ).append("\n"); 
		query.append("       AND A.TRD_CD = ALL_BSA.TRD_CD(+)" ).append("\n"); 
		query.append("       AND A.RLANE_CD = ALL_BSA.RLANE_CD(+)" ).append("\n"); 
		query.append("       AND A.VSL_CD = ALL_BSA.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = ALL_BSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = ALL_BSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND A.CRR_CD = ALL_BSA.JO_CRR_CD(+)" ).append("\n"); 
		query.append("       AND A.RE_DIVR_CD = ALL_BSA.RE_DIVR_CD(+)" ).append("\n"); 
		query.append("       AND ALL_BSA.JO_CRR_CD(+) = @[merge_crr]" ).append("\n"); 
		query.append("       AND ALL_BSA.PORT_CD(+) = 'ALL'" ).append("\n"); 
		query.append("       AND ALL_BSA.DELT_FLG(+) = 'N'	" ).append("\n"); 
		query.append("       AND ALL_BSA.RE_DIVR_CD(+) = 'R'	" ).append("\n"); 
		query.append("       ----- BSA PORT ALL DATA JOIN END ---------------" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ----- BSA PORT 개별 DATA JOIN START ------------" ).append("\n"); 
		query.append("       AND A.TRD_CD = PRT_BSA.TRD_CD(+)" ).append("\n"); 
		query.append("       AND A.RLANE_CD = PRT_BSA.RLANE_CD(+)" ).append("\n"); 
		query.append("       AND A.VSL_CD = PRT_BSA.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = PRT_BSA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = PRT_BSA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND A.VPS_PORT_CD = PRT_BSA.PORT_CD(+)" ).append("\n"); 
		query.append("       AND A.CLPT_IND_SEQ = PRT_BSA.PORT_SEQ(+)" ).append("\n"); 
		query.append("       AND A.CRR_CD = PRT_BSA.JO_CRR_CD(+)" ).append("\n"); 
		query.append("       AND A.RE_DIVR_CD = PRT_BSA.RE_DIVR_CD(+)" ).append("\n"); 
		query.append("       AND PRT_BSA.JO_CRR_CD(+) = @[merge_crr]" ).append("\n"); 
		query.append("       AND PRT_BSA.DELT_FLG(+) = 'N'	" ).append("\n"); 
		query.append("       AND PRT_BSA.RE_DIVR_CD(+) = 'R'	" ).append("\n"); 
		query.append("       ----- BSA PORT 개별 DATA JOIN END --------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ----- VVD PORT SKD JOIN START ------------------" ).append("\n"); 
		query.append("       AND A.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.VPS_PORT_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND A.YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("       AND A.CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       AND A.SLAN_CD = VSK.SLAN_CD" ).append("\n"); 
		query.append("       ----- VVD SKD JOIN END -------------------------" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ------ RDR_HEADER JOIN START -------------------" ).append("\n"); 
		query.append("       AND A.VSL_CD 		= RDR.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO 	= RDR.VOY_NO(+) " ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD 	= RDR.DIR_CD(+)  " ).append("\n"); 
		query.append("       AND A.VPS_PORT_CD 	= RDR.PORT_CD(+)" ).append("\n"); 
		query.append("       ------ RDR_HEADER JOIN END ---------------------" ).append("\n"); 
		query.append("       ------ JOO RDR PORT JOIN START -----------------" ).append("\n"); 
		query.append("       AND A.VSL_CD       = JRDR.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO   = JRDR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD   = JRDR.SKD_DIR_CD(+)  " ).append("\n"); 
		query.append("       AND A.VPS_PORT_CD  = JRDR.VPS_PORT_CD(+)  " ).append("\n"); 
		query.append("       AND A.CLPT_IND_SEQ = JRDR.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("       AND A.SLAN_CD      = JRDR.SLAN_CD(+)" ).append("\n"); 
		query.append("       AND A.YD_CD        = JRDR.YD_CD(+)" ).append("\n"); 
		query.append("       ------ JOO RDR PORT JOIN END -------------------" ).append("\n"); 
		query.append("       AND A.RLANE_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("       #if (${vvd} != '')   " ).append("\n"); 
		query.append("       AND A.VSL_CD LIKE SUBSTR(@[vvd], 1, 4) || '%'" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO LIKE SUBSTR(@[vvd], 5, 4) || '%'" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD LIKE SUBSTR(@[vvd], 9, 1) || '%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("       AND A.VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if (${opr_cd} != '')" ).append("\n"); 
		query.append("       AND A.CRR_CD IN (" ).append("\n"); 
		query.append("			#foreach($key IN ${opr_cd2})" ).append("\n"); 
		query.append("				#if($velocityCount < $opr_cd2.size())" ).append("\n"); 
		query.append("					'${key}'," ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					'$key'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AND A.VPS_ETD_DT BETWEEN TO_DATE(REPLACE (@[pre_fr], '-', '') || '000000', 'YYYYMMDDHH24MISS') AND TO_DATE(REPLACE (@[pre_to], '-', '') || '235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     GROUP BY A.TRD_CD" ).append("\n"); 
		query.append("            , A.RLANE_CD" ).append("\n"); 
		query.append("            , A.REV_DIR_CD" ).append("\n"); 
		query.append("            , A.RE_DIVR_CD" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.VPS_PORT_CD" ).append("\n"); 
		query.append("            , A.YD_CD" ).append("\n"); 
		query.append("            , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.VPS_ETD_DT" ).append("\n"); 
		query.append("            , VSK.VSL_CD" ).append("\n"); 
		query.append("            , VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("            , VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("            , VSK.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("            , JRDR.RDR_FLG" ).append("\n"); 
		query.append("            , RDR.PORT_CD" ).append("\n"); 
		query.append("  ) A, JOO_LODG_TGT TGT" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   ------ JOO LODG TGT JOIN START -----------------" ).append("\n"); 
		query.append("   AND A.VSL_CD        = TGT.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = TGT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    = TGT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD   = TGT.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND A.YD_CD         = TGT.YD_CD(+)" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ  = TGT.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CRR_CD        = TGT.CRR_CD(+)" ).append("\n"); 
		query.append("   AND A.RLANE_CD      = TGT.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A.TRD_CD        = TGT.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A.RE_DIVR_CD    = TGT.RE_DIVR_CD(+)" ).append("\n"); 
		query.append("   AND TGT.CRR_CD(+)   = @[merge_crr]" ).append("\n"); 
		query.append("   ------ JOO LODG TGT JOIN END -------------------" ).append("\n"); 
		query.append("   #if (${opt_tgt} == 'T') " ).append("\n"); 
		query.append("   AND TGT.STL_TGT_FLG = '1'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_tgt} == 'N')" ).append("\n"); 
		query.append("   AND TGT.STL_TGT_FLG = '0' " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_clz} == 'C') " ).append("\n"); 
		query.append("   AND TGT.STL_CLZ_FLG = '1'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${opt_clz} == 'N')" ).append("\n"); 
		query.append("   AND TGT.STL_CLZ_FLG = '0' " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" ORDER BY VVD_ETD_GROUP, VSL_CD || SKD_VOY_NO || SKD_DIR_CD, VPS_ETD_DT, VPS_PORT_CD, CRR_CD" ).append("\n"); 

	}
}