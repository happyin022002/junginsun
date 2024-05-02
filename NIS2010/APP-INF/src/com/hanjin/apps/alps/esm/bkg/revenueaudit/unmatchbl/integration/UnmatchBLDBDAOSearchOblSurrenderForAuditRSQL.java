/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchOblSurrenderForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.25 
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

public class UnmatchBLDBDAOSearchOblSurrenderForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 심사를 위한 O B/L Surrender 목록을 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchOblSurrenderForAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchOblSurrenderForAuditRSQL").append("\n"); 
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
		query.append("WITH BK AS(" ).append("\n"); 
		query.append("SELECT TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD')	AS RT_APLY_DT," ).append("\n"); 
		query.append("       BK.BKG_NO," ).append("\n"); 
		query.append("       BK.BL_NO||BK.BL_NO_TP||BK.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("       BK.SVC_SCP_CD," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID ='CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD) BKG_CTRT_TP_CD ," ).append("\n"); 
		query.append("       CASE WHEN BR.BKG_CTRT_TP_CD = 'R' THEN BK.RFA_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'S' THEN BK.SC_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'T' THEN BK.TAA_NO" ).append("\n"); 
		query.append("       END CTRT_NO," ).append("\n"); 
		query.append("       BI.OBL_RDEM_OFC_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("     BKG_RATE BR," ).append("\n"); 
		query.append("     BKG_BL_ISS BI," ).append("\n"); 
		query.append("     BKG_BL_DOC BD," ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("     WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append("#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("    ,(SELECT DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("      FROM BKG_BOOKING B, BKG_VVD BV, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("      WHERE B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND B.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("      AND V.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("      AND V.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND V.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND V.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("      AND V.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      AND V.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("      ) V" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("#elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("WHERE BR.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE BK.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD	<> 'X'" ).append("\n"); 
		query.append("AND	BK.BKG_CGO_TP_CD	<> 'P'" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BR.BKG_NO" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BI.BKG_NO" ).append("\n"); 
		query.append("AND	BI.OBL_SRND_FLG	= 'Y'	" ).append("\n"); 
		query.append("AND BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_OFC_CD = OG.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("AND BK.POR_CD   LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND BK.POL_CD   LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND BK.POD_CD   LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${del_cd} != '') " ).append("\n"); 
		query.append("AND BK.DEL_CD   LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#if (${bdr_flg} != '') " ).append("\n"); 
		query.append("AND BD.BDR_FLG   = @[bdr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("RT AS (" ).append("\n"); 
		query.append("SELECT BK.BKG_NO," ).append("\n"); 
		query.append("       BK.RT_APLY_DT," ).append("\n"); 
		query.append("       BK.BL_NO, " ).append("\n"); 
		query.append("       BK.SVC_SCP_CD," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       BK.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       BK.CTRT_NO," ).append("\n"); 
		query.append("       BK.OBL_RDEM_OFC_CD," ).append("\n"); 
		query.append("       BC.CURR_CD," ).append("\n"); 
		query.append("       BC.CHG_UT_AMT," ).append("\n"); 
		query.append("       BC.RAT_AS_QTY," ).append("\n"); 
		query.append("       BC.RAT_UT_CD," ).append("\n"); 
		query.append("       BC.CHG_AMT," ).append("\n"); 
		query.append("       BC.FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("  FROM BK LEFT OUTER JOIN BKG_CHG_RT BC" ).append("\n"); 
		query.append("    ON BK.BKG_NO = BC.BKG_NO " ).append("\n"); 
		query.append("   AND BC.CHG_CD = 'OBS'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",EX AS (" ).append("\n"); 
		query.append("SELECT RT.BKG_NO," ).append("\n"); 
		query.append("       RT.RT_APLY_DT," ).append("\n"); 
		query.append("       RT.BL_NO," ).append("\n"); 
		query.append("       RT.SVC_SCP_CD," ).append("\n"); 
		query.append("       RT.POR_CD," ).append("\n"); 
		query.append("       RT.POL_CD," ).append("\n"); 
		query.append("       RT.POD_CD," ).append("\n"); 
		query.append("       RT.DEL_CD," ).append("\n"); 
		query.append("       RT.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       RT.CTRT_NO," ).append("\n"); 
		query.append("       RT.OBL_RDEM_OFC_CD," ).append("\n"); 
		query.append("       RT.CURR_CD," ).append("\n"); 
		query.append("       RT.CHG_UT_AMT," ).append("\n"); 
		query.append("       RT.RAT_AS_QTY," ).append("\n"); 
		query.append("       RT.RAT_UT_CD," ).append("\n"); 
		query.append("       RT.CHG_AMT, " ).append("\n"); 
		query.append("       RT.FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       NVL2(AUTH.CHG_AMD_RQST_STS_CD,DECODE(AUTH.CHG_AMD_RQST_STS_CD,'A','Y','N'),'') AS APRO_FLG," ).append("\n"); 
		query.append("       DECODE(AUTH.CHG_AMD_RQST_STS_CD,'A',AUTH.APRO_OFC_CD,'') AS APRO_OFC_CD," ).append("\n"); 
		query.append("       DECODE(AUTH.CHG_AMD_RQST_STS_CD,'A',AUTH.APRO_DT,'') AS APRO_DT," ).append("\n"); 
		query.append("       DECODE(AUTH.CHG_AMD_RQST_STS_CD,'A',AUTH.APRO_USR_ID,'') AS APRO_USR_ID," ).append("\n"); 
		query.append("      (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03364'" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT =  AUTH.CHG_AMD_RSN_CD) AS CHG_AMD_RSN," ).append("\n"); 
		query.append("       AUTH.CHG_AMD_RMK," ).append("\n"); 
		query.append("       DTL.CHG_RT_SEQ " ).append("\n"); 
		query.append("  FROM RT LEFT OUTER JOIN BKG_CHG_AMD_AUTH_DTL DTL" ).append("\n"); 
		query.append("    ON DTL.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("   AND DTL.CHG_CD = 'OBS'" ).append("\n"); 
		query.append("  LEFT OUTER JOIN BKG_CHG_AMD_AUTH AUTH" ).append("\n"); 
		query.append("    ON DTL.BKG_NO = AUTH.BKG_NO" ).append("\n"); 
		query.append("   AND DTL.CHG_AMD_SEQ = AUTH.CHG_AMD_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT EX.BKG_NO," ).append("\n"); 
		query.append("       EX.RT_APLY_DT," ).append("\n"); 
		query.append("       EX.BL_NO," ).append("\n"); 
		query.append("       EX.SVC_SCP_CD," ).append("\n"); 
		query.append("       EX.POR_CD," ).append("\n"); 
		query.append("       EX.POL_CD," ).append("\n"); 
		query.append("       EX.POD_CD," ).append("\n"); 
		query.append("       EX.DEL_CD," ).append("\n"); 
		query.append("       EX.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       EX.CTRT_NO," ).append("\n"); 
		query.append("       EX.OBL_RDEM_OFC_CD," ).append("\n"); 
		query.append("       EX.CURR_CD," ).append("\n"); 
		query.append("       EX.CHG_UT_AMT," ).append("\n"); 
		query.append("       EX.RAT_AS_QTY," ).append("\n"); 
		query.append("       EX.RAT_UT_CD," ).append("\n"); 
		query.append("       EX.CHG_AMT, " ).append("\n"); 
		query.append("       EX.FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       IC.CURR_CD  AS INV_CURR_CD," ).append("\n"); 
		query.append("       SUM(IC.CHG_AMT) AS INV_CHG_AMT," ).append("\n"); 
		query.append("       COUNT(DISTINCT EX.BKG_NO) OVER () AS  BL_CNT," ).append("\n"); 
		query.append("       '' BKG_RHQ_CD," ).append("\n"); 
		query.append("       '' BKG_OFC_CD," ).append("\n"); 
		query.append("       '' SEARCH_DATE," ).append("\n"); 
		query.append("       '' FM_DT," ).append("\n"); 
		query.append("       '' TO_DT, " ).append("\n"); 
		query.append("       '' T_VVD," ).append("\n"); 
		query.append("       '' BDR_FLG," ).append("\n"); 
		query.append("       EX.APRO_FLG," ).append("\n"); 
		query.append("       EX.APRO_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR(EX.APRO_DT,'YYYY-MM-DD') AS APRO_DT," ).append("\n"); 
		query.append("       (SELECT USR_NM " ).append("\n"); 
		query.append("          FROM COM_USER " ).append("\n"); 
		query.append("         WHERE USR_ID = EX.APRO_USR_ID) AS APRO_USR_NM," ).append("\n"); 
		query.append("       EX.CHG_AMD_RSN," ).append("\n"); 
		query.append("       EX.CHG_AMD_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM EX LEFT OUTER JOIN INV_AR_MN IM" ).append("\n"); 
		query.append("  ON IM.BL_SRC_NO = EX.BKG_NO" ).append("\n"); 
		query.append(" AND IM.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append(" AND IM.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("     LEFT OUTER JOIN INV_AR_CHG IC" ).append("\n"); 
		query.append("  ON IM.AR_IF_NO = IC.AR_IF_NO" ).append("\n"); 
		query.append(" AND IC.CHG_CD = 'OBS'" ).append("\n"); 
		query.append(" AND IC.INV_REV_TP_SRC_CD  IN ('MIV','MIC')" ).append("\n"); 
		query.append(" GROUP BY EX.BKG_NO," ).append("\n"); 
		query.append("       EX.RT_APLY_DT," ).append("\n"); 
		query.append("       EX.BL_NO," ).append("\n"); 
		query.append("       EX.SVC_SCP_CD," ).append("\n"); 
		query.append("       EX.POR_CD," ).append("\n"); 
		query.append("       EX.POL_CD," ).append("\n"); 
		query.append("       EX.POD_CD," ).append("\n"); 
		query.append("       EX.DEL_CD," ).append("\n"); 
		query.append("       EX.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       EX.CTRT_NO," ).append("\n"); 
		query.append("       EX.OBL_RDEM_OFC_CD," ).append("\n"); 
		query.append("       EX.CURR_CD," ).append("\n"); 
		query.append("       EX.CHG_UT_AMT," ).append("\n"); 
		query.append("       EX.RAT_AS_QTY," ).append("\n"); 
		query.append("       EX.RAT_UT_CD," ).append("\n"); 
		query.append("       EX.CHG_AMT, " ).append("\n"); 
		query.append("       EX.FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("       IC.CURR_CD,       " ).append("\n"); 
		query.append("       EX.APRO_FLG," ).append("\n"); 
		query.append("       EX.APRO_OFC_CD," ).append("\n"); 
		query.append("       EX.APRO_DT," ).append("\n"); 
		query.append("       EX.APRO_USR_ID," ).append("\n"); 
		query.append("       EX.CHG_AMD_RSN," ).append("\n"); 
		query.append("       EX.CHG_AMD_RMK" ).append("\n"); 

	}
}