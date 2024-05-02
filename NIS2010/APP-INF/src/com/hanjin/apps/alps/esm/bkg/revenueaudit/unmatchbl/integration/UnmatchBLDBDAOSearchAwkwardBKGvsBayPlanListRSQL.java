/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchAwkwardBKGvsBayPlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchAwkwardBKGvsBayPlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AK Application vs Bay Plan Discrepancy 조회
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchAwkwardBKGvsBayPlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchAwkwardBKGvsBayPlanListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("BK AS (" ).append("\n"); 
		query.append("SELECT ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE OFC_TP_CD = 'HQ' CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD START WITH OFC_CD = BK.BKG_OFC_CD ) BKG_RHQ_CD," ).append("\n"); 
		query.append("       BK.BKG_OFC_CD," ).append("\n"); 
		query.append("       BK.BKG_NO," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("      (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID ='CD01716'" ).append("\n"); 
		query.append("       AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD) BKG_CTRT_TP_CD  ," ).append("\n"); 
		query.append("       CASE WHEN BR.BKG_CTRT_TP_CD = 'R' THEN BK.RFA_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'S' THEN BK.SC_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'T' THEN BK.TAA_NO" ).append("\n"); 
		query.append("       END CTRT_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_RATE BR," ).append("\n"); 
		query.append(" #if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("     BKG_VVD BV, VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = 'SELHO'" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("     WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = NVL(@[bkg_rhq_cd],'SELHO')" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append(" #if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("  WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("  AND BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("  AND V.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("  AND V.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND V.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND V.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("  AND V.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND V.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append(" WHERE BR.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append(" WHERE BK.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD   = @[svc_scp_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${t_vvd} != '') " ).append("\n"); 
		query.append("AND BK.VSL_CD = SUBSTR(@[t_vvd], 1, 4)" ).append("\n"); 
		query.append("AND BK.SKD_VOY_NO = SUBSTR(@[t_vvd], 5, 4)" ).append("\n"); 
		query.append("AND BK.SKD_DIR_CD = SUBSTR(@[t_vvd], 9, 1)" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${bkg_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("AND     CASE" ).append("\n"); 
		query.append("             WHEN    BK.TAA_NO IS NOT NULL THEN  'T'" ).append("\n"); 
		query.append("             WHEN    BK.RFA_NO IS NOT NULL THEN  'R'" ).append("\n"); 
		query.append("             ELSE    'S'" ).append("\n"); 
		query.append("        END                     = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${ctrt_no} != '') " ).append("\n"); 
		query.append("AND     CASE" ).append("\n"); 
		query.append("             WHEN    BK.TAA_NO IS NOT NULL THEN  BK.TAA_NO" ).append("\n"); 
		query.append("             WHEN    BK.RFA_NO IS NOT NULL THEN  BK.RFA_NO" ).append("\n"); 
		query.append("             ELSE    BK.SC_NO" ).append("\n"); 
		query.append("        END                     LIKE @[ctrt_no] || '%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" #if (${por_cd} != '') " ).append("\n"); 
		query.append("AND BK.POR_CD   = @[por_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND BK.POL_CD   = @[pol_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND BK.POD_CD   = @[pod_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${del_cd} != '') " ).append("\n"); 
		query.append("AND BK.DEL_CD   = @[del_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("AND NVL(BK.BL_NO_TP, 'N') <> '9'" ).append("\n"); 
		query.append("AND NVL(BR.RT_BL_TP_CD, 'N') NOT IN ( 'C', 'B' )" ).append("\n"); 
		query.append("AND BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("AND OG.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("BC AS(" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       BK.BKG_NO, " ).append("\n"); 
		query.append("       BC.CNTR_NO," ).append("\n"); 
		query.append("       BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       (SELECT SUM(OVR_VOID_SLT_QTY) " ).append("\n"); 
		query.append("        FROM BKG_AWK_CGO " ).append("\n"); 
		query.append("        WHERE BKG_NO(+) = BC.BKG_NO " ).append("\n"); 
		query.append("        AND CNTR_TPSZ_CD(+) = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND CNTR_NO(+) = BC.CNTR_NO) VOID_SLT_QTY," ).append("\n"); 
		query.append("       BV.VSL_CD," ).append("\n"); 
		query.append("       BV.SKD_VOY_NO," ).append("\n"); 
		query.append("       BV.SKD_DIR_CD," ).append("\n"); 
		query.append("       BV.POL_CD," ).append("\n"); 
		query.append("       BV.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("       BV.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("       BV.VSL_SEQ" ).append("\n"); 
		query.append("FROM BK, BKG_CONTAINER BC, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BC.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND BC.CNTR_TPSZ_CD IN ( #foreach(${key} in ${cntr_tpsz_cd_list} ) #if($velocityCount != 1) , #end '$key' #end )  -- MULTI" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("BP AS(" ).append("\n"); 
		query.append("SELECT BKG_NO, VSL_CD, VOY_NO, DIR_CD, POL, POD, CNTR_NO, SZTP, POSITION," ).append("\n"); 
		query.append("       SUM (CASE WHEN ACT_SLOT <> '' THEN TO_NUMBER(ACT_SLOT)" ).append("\n"); 
		query.append("                 WHEN x * y * z > 0  THEN (x + 1) * (y + 1) * (z + 1) - s" ).append("\n"); 
		query.append("                 WHEN x * y > 0      THEN (x + 1) * (y + 1) * s - s" ).append("\n"); 
		query.append("                 WHEN x * z > 0      THEN (x + 1) * (z + 1) - 1 + x * (s - 1)" ).append("\n"); 
		query.append("                 WHEN y * z > 0      THEN (y + 1) * (z + 1) - 1 + y * (s - 1)" ).append("\n"); 
		query.append("                 WHEN x + y > 0      THEN (x + y + 1) * s - s" ).append("\n"); 
		query.append("                 WHEN z > 0          THEN z" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("             END / 2" ).append("\n"); 
		query.append("             ) AS VOID_VOL" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("        SELECT BC.BKG_NO," ).append("\n"); 
		query.append("               BP.VSL_CD," ).append("\n"); 
		query.append("               BP.VOY_NO," ).append("\n"); 
		query.append("               BP.DIR_CD," ).append("\n"); 
		query.append("               BP.POL_ISO AS POL, " ).append("\n"); 
		query.append("               BP.POD, " ).append("\n"); 
		query.append("               BP.ID CNTR_NO, " ).append("\n"); 
		query.append("               BP.SZTP," ).append("\n"); 
		query.append("               BP.BAY||'-'||BP.ROWW||'-'||BP.TIER POSITION," ).append("\n"); 
		query.append("               NVL (OVP_SLOT, 0) + NVL (OVS_SLOT, 0) AS X," ).append("\n"); 
		query.append("               NVL (OVH_SLOT, 0) AS Y," ).append("\n"); 
		query.append("               NVL (OVA_SLOT, 0) + NVL (OVF_SLOT, 0) AS Z," ).append("\n"); 
		query.append("               (2 - MOD (BAY, 2)) AS S," ).append("\n"); 
		query.append("               ACT_SLOT" ).append("\n"); 
		query.append("        FROM BAY_PLAN BP, BC" ).append("\n"); 
		query.append("        WHERE BC.VSL_CD = BP.VSL_CD" ).append("\n"); 
		query.append("        AND BC.SKD_VOY_NO = BP.VOY_NO" ).append("\n"); 
		query.append("        AND BC.SKD_DIR_CD = BP.DIR_CD" ).append("\n"); 
		query.append("        AND BC.POL_CD = BP.PORT_CD" ).append("\n"); 
		query.append("        AND BC.POL_CLPT_IND_SEQ = BP.CALL_IND" ).append("\n"); 
		query.append("        AND BP.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("        AND BC.POL_CD = BP.POL_ISO" ).append("\n"); 
		query.append("        AND BC.CNTR_NO = BP.ID" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY BKG_NO, VSL_CD, VOY_NO, DIR_CD, POL, POD, CNTR_NO, SZTP, POSITION" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("RDR AS(" ).append("\n"); 
		query.append("SELECT BKG_NO, VSL_CD, VOY_NO, DIR_CD, POL, POD, CNTR_NO, SZTP, POSITION," ).append("\n"); 
		query.append("       SUM (CASE WHEN ACT_SLOT <> '' THEN TO_NUMBER(ACT_SLOT)" ).append("\n"); 
		query.append("                 WHEN x * y * z > 0  THEN (x + 1) * (y + 1) * (z + 1) - s" ).append("\n"); 
		query.append("                 WHEN x * y > 0      THEN (x + 1) * (y + 1) * s - s" ).append("\n"); 
		query.append("                 WHEN x * z > 0      THEN (x + 1) * (z + 1) - 1 + x * (s - 1)" ).append("\n"); 
		query.append("                 WHEN y * z > 0      THEN (y + 1) * (z + 1) - 1 + y * (s - 1)" ).append("\n"); 
		query.append("                 WHEN x + y > 0      THEN (x + y + 1) * s - s" ).append("\n"); 
		query.append("                 WHEN z > 0          THEN z" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("             END / 2" ).append("\n"); 
		query.append("             ) AS VOID_VOL" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("        SELECT BC.BKG_NO," ).append("\n"); 
		query.append("               BP.VSL_CD," ).append("\n"); 
		query.append("               BP.VOY_NO," ).append("\n"); 
		query.append("               BP.DIR_CD," ).append("\n"); 
		query.append("               rdr.PORT_CD AS POL, " ).append("\n"); 
		query.append("               BP.POD, " ).append("\n"); 
		query.append("               BP.ID CNTR_NO, " ).append("\n"); 
		query.append("               BP.SZTP," ).append("\n"); 
		query.append("               BP.BAY||'-'||BP.ROWW||'-'||BP.TIER POSITION," ).append("\n"); 
		query.append("               NVL (OVP_SLOT, 0) + NVL (OVS_SLOT, 0) AS X," ).append("\n"); 
		query.append("               NVL (OVH_SLOT, 0) AS Y," ).append("\n"); 
		query.append("               NVL (OVA_SLOT, 0) + NVL (OVF_SLOT, 0) AS Z," ).append("\n"); 
		query.append("               (2 - MOD (BAY, 2)) AS S," ).append("\n"); 
		query.append("               ACT_SLOT" ).append("\n"); 
		query.append("        FROM BAY_PLAN BP, RDR_HEADER RDR, BC " ).append("\n"); 
		query.append("        WHERE BC.VSL_CD = BP.VSL_CD" ).append("\n"); 
		query.append("        AND BC.SKD_VOY_NO = BP.VOY_NO" ).append("\n"); 
		query.append("        AND BC.SKD_DIR_CD = BP.DIR_CD" ).append("\n"); 
		query.append("        AND rdr.PORT_CD = BP.PORT_CD" ).append("\n"); 
		query.append("        AND BP.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("        AND BC.POL_CD = BP.POL_ISO" ).append("\n"); 
		query.append("        AND BC.CNTR_NO = BP.ID" ).append("\n"); 
		query.append("        AND BC.VSL_CD = rdr.VSL_CD" ).append("\n"); 
		query.append("        AND BC.SKD_VOY_NO = rdr.VOY_NO" ).append("\n"); 
		query.append("        AND BC.SKD_DIR_CD = rdr.DIR_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY BKG_NO, VSL_CD, VOY_NO, DIR_CD, POL, POD, CNTR_NO, SZTP, POSITION" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BK.BKG_RHQ_CD, " ).append("\n"); 
		query.append("       BK.BKG_OFC_CD," ).append("\n"); 
		query.append("       BK.BKG_NO," ).append("\n"); 
		query.append("       BK.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       BK.CTRT_NO," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       BC.CNTR_NO," ).append("\n"); 
		query.append("       BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BC.VOID_SLT_QTY," ).append("\n"); 
		query.append("       BC.VSL_CD||BC.SKD_VOY_NO||BC.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       BP.POL, " ).append("\n"); 
		query.append("       BP.POD," ).append("\n"); 
		query.append("       BP.SZTP," ).append("\n"); 
		query.append("       BP.POSITION," ).append("\n"); 
		query.append("       BP.VOID_VOL," ).append("\n"); 
		query.append("       BC.VOID_SLT_QTY - BP.VOID_VOL VOID_DIFF," ).append("\n"); 
		query.append("-----------------------------------------------------" ).append("\n"); 
		query.append("       RDR.VSL_CD||RDR.VOY_NO||RDR.DIR_CD RDR_VVD," ).append("\n"); 
		query.append("       RDR.POL RDR_POL, " ).append("\n"); 
		query.append("       RDR.POD RDR_POD," ).append("\n"); 
		query.append("       RDR.SZTP RDR_SZTP," ).append("\n"); 
		query.append("       RDR.POSITION RDR_POSITION," ).append("\n"); 
		query.append("       RDR.VOID_VOL RDR_VOID_VOL," ).append("\n"); 
		query.append("       BC.VOID_SLT_QTY - RDR.VOID_VOL RDR_VOID_DIFF," ).append("\n"); 
		query.append("       '' SEARCH_DATE," ).append("\n"); 
		query.append("       '' FM_DT," ).append("\n"); 
		query.append("       '' TO_DT," ).append("\n"); 
		query.append("       '' SVC_SCP_CD," ).append("\n"); 
		query.append("       '' T_VVD," ).append("\n"); 
		query.append("       '' BDR_FLG," ).append("\n"); 
		query.append("       '' CHARGE_FLG" ).append("\n"); 
		query.append("FROM BK, BC, BP, RDR" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BP.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = BP.CNTR_NO" ).append("\n"); 
		query.append("AND BC.VSL_CD = BP.VSL_CD" ).append("\n"); 
		query.append("AND BC.SKD_VOY_NO = BP.VOY_NO" ).append("\n"); 
		query.append("AND BC.SKD_DIR_CD = BP.DIR_CD" ).append("\n"); 
		query.append("AND BP.BKG_NO= RDR.BKG_NO(+)" ).append("\n"); 
		query.append("AND BP.CNTR_NO = RDR.CNTR_NO(+)" ).append("\n"); 
		query.append("AND BP.VSL_CD = RDR.VSL_CD(+)" ).append("\n"); 
		query.append("AND BP.VOY_NO = RDR.VOY_NO(+)" ).append("\n"); 
		query.append("AND BP.DIR_CD = RDR.DIR_CD(+)" ).append("\n"); 
		query.append("ORDER BY BK.BKG_RHQ_CD, BK.BKG_OFC_CD, BK.BKG_NO, BC.CNTR_NO, BC.VSL_PRE_PST_CD, BC.VSL_SEQ" ).append("\n"); 

	}
}