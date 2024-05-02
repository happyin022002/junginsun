/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchIhcBKGListForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
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

public class UnmatchBLDBDAOSearchIhcBKGListForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 심사를 위한 IHC BKG 리스트를 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchIhcBKGListForAuditRSQL(){
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
		params.put("aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchIhcBKGListForAuditRSQL").append("\n"); 
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
		query.append("WITH BKG AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT R.BKG_NO," ).append("\n"); 
		query.append("       TO_CHAR(R.RT_APLY_DT, 'YYYYMMDD') RT_APLY_DT," ).append("\n"); 
		query.append("       R.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       CASE WHEN R.BKG_CTRT_TP_CD = 'R' THEN B.RFA_NO" ).append("\n"); 
		query.append("            WHEN R.BKG_CTRT_TP_CD = 'S' THEN B.SC_NO" ).append("\n"); 
		query.append("            WHEN R.BKG_CTRT_TP_CD = 'T' THEN B.TAA_NO" ).append("\n"); 
		query.append("       END CTRT_NO," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       B.RCV_TERM_CD," ).append("\n"); 
		query.append("       B.DE_TERM_CD," ).append("\n"); 
		query.append("       C.CNTR_NO," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       C.CNTR_WGT," ).append("\n"); 
		query.append("       (SELECT CURR_CD||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(CHG_UT_AMT, '999,999,999.00'))||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(RAT_AS_QTY, '999.00'))||' / '||" ).append("\n"); 
		query.append("               RAT_UT_CD||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(CHG_AMT, '999,999,999.00'))" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT OIH" ).append("\n"); 
		query.append("        WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND CHG_CD = 'OIH'" ).append("\n"); 
		query.append("        AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND (RAT_UT_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            OR RAT_UT_CD IN ('BX', 'BL')" ).append("\n"); 
		query.append("            OR (" ).append("\n"); 
		query.append("                RAT_UT_CD IN ('20', '40', 'HC', '45', '53')" ).append("\n"); 
		query.append("                AND ( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = OIH.RAT_UT_CD AND ROWNUM=1) = U.CNTR_SZ_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND ROWNUM = 1) OIH," ).append("\n"); 
		query.append("       (SELECT CURR_CD||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(CHG_UT_AMT, '999,999,999.00'))||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(RAT_AS_QTY, '999.00'))||' / '||" ).append("\n"); 
		query.append("               RAT_UT_CD||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(CHG_AMT, '999,999,999.00'))" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT DIH" ).append("\n"); 
		query.append("        WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND CHG_CD = 'DIH'" ).append("\n"); 
		query.append("        AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND (RAT_UT_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            OR RAT_UT_CD IN ('BX', 'BL')" ).append("\n"); 
		query.append("            OR (" ).append("\n"); 
		query.append("                RAT_UT_CD IN ('20', '40', 'HC', '45', '53')" ).append("\n"); 
		query.append("                AND ( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = DIH.RAT_UT_CD AND ROWNUM=1) = U.CNTR_SZ_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND ROWNUM = 1) DIH," ).append("\n"); 
		query.append("       (SELECT CURR_CD||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(CHG_UT_AMT, '999,999,999.00'))||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(RAT_AS_QTY, '999.00'))||' / '||" ).append("\n"); 
		query.append("               RAT_UT_CD||' / '||" ).append("\n"); 
		query.append("               TRIM(TO_CHAR(CHG_AMT, '999,999,999.00'))" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT CYR" ).append("\n"); 
		query.append("        WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND CHG_CD = 'CYR'" ).append("\n"); 
		query.append("        AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND (RAT_UT_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            OR RAT_UT_CD IN ('BX', 'BL')" ).append("\n"); 
		query.append("            OR (" ).append("\n"); 
		query.append("                RAT_UT_CD IN ('20', '40', 'HC', '45', '53')" ).append("\n"); 
		query.append("                AND ( SELECT A.CNTR_SZ_CD FROM PRI_RAT_UT A WHERE A.RAT_UT_CD = CYR.RAT_UT_CD AND ROWNUM=1) = U.CNTR_SZ_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND ROWNUM = 1) CYR," ).append("\n"); 
		query.append("        COUNT(DISTINCT R.BKG_NO) OVER (PARTITION BY 1) BKG_CNT," ).append("\n"); 
		query.append("        '' BKG_RHQ_CD," ).append("\n"); 
		query.append("        '' SVC_SCP_CD," ).append("\n"); 
		query.append("        '' FM_DT," ).append("\n"); 
		query.append("        '' TO_DT," ).append("\n"); 
		query.append("        NVL(DECODE(R.IDA_IHC_AUD_STS_CD,'E','U','Y','S',R.IDA_IHC_AUD_STS_CD),'N') AUD_STS_CD," ).append("\n"); 
		query.append("        TO_CHAR(R.IDA_AUD_BAT_DT, 'YYYYMMDD') REV_AUD_DT," ).append("\n"); 
		query.append("        B.INTER_RMK," ).append("\n"); 
		query.append("        B.XTER_RMK," ).append("\n"); 
		query.append("        (SELECT MAX(RDN_NO)" ).append("\n"); 
		query.append("          FROM BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("          WHERE BKG_NO = B.BKG_NO) AS RDN_NO" ).append("\n"); 
		query.append("FROM BKG_RATE R, BKG_BOOKING B, " ).append("\n"); 
		query.append("     BKG_CONTAINER C, PRI_RAT_UT U," ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD) O" ).append("\n"); 
		query.append("WHERE R.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#if (${so_bnd} == 'Outbound')" ).append("\n"); 
		query.append("AND B.POR_CD <> B.POL_CD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.POD_CD <> B.DEL_CD " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND R.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.CNTR_TPSZ_CD = U.RAT_UT_CD" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.POR_CD LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append("AND B.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("AND B.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("AND B.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("#if (${aud_sts_cd} != '')" ).append("\n"); 
		query.append("AND NVL(R.IDA_IHC_AUD_STS_CD,'N') = DECODE(@[aud_sts_cd],'S','Y','U','E','N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("       BKG.RT_APLY_DT," ).append("\n"); 
		query.append("       BKG.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       BKG.CTRT_NO," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       BKG.POD_CD," ).append("\n"); 
		query.append("       BKG.DEL_CD," ).append("\n"); 
		query.append("       BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("       BKG.DE_TERM_CD," ).append("\n"); 
		query.append("       BKG.CNTR_NO," ).append("\n"); 
		query.append("       BKG.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       BKG.CNTR_WGT," ).append("\n"); 
		query.append("       BKG.OIH," ).append("\n"); 
		query.append("       BKG.DIH," ).append("\n"); 
		query.append("       BKG.CYR," ).append("\n"); 
		query.append("       BKG.BKG_RHQ_CD," ).append("\n"); 
		query.append("       BKG.SVC_SCP_CD," ).append("\n"); 
		query.append("       BKG.FM_DT," ).append("\n"); 
		query.append("       BKG.TO_DT," ).append("\n"); 
		query.append("       BKG.BKG_CNT," ).append("\n"); 
		query.append("       SO.SO_NO," ).append("\n"); 
		query.append("       SO.FM_NOD_CD," ).append("\n"); 
		query.append("       SO.TO_NOD_CD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD03279'" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT = BKG.AUD_STS_CD) AUD_STS_CD," ).append("\n"); 
		query.append("       BKG.REV_AUD_DT," ).append("\n"); 
		query.append("       BKG.INTER_RMK," ).append("\n"); 
		query.append("       BKG.XTER_RMK," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD00594'" ).append("\n"); 
		query.append("          AND INTG_CD_VAL_CTNT = SO.TRSP_COST_DTL_MOD_CD) TRSP_COST_DTL_MOD," ).append("\n"); 
		query.append("       BKG.RDN_NO," ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG.BKG_NO) OVER (PARTITION BY 1) TTL_BKG_CNT" ).append("\n"); 
		query.append("   FROM BKG" ).append("\n"); 
		query.append("   ,(SELECT BKG_NO" ).append("\n"); 
		query.append("             ,EQ_NO" ).append("\n"); 
		query.append("             ,TRSP_SO_OFC_CTY_CD || TRSP_SO_SEQ AS SO_NO" ).append("\n"); 
		query.append("             ,FM_NOD_CD" ).append("\n"); 
		query.append("             ,TO_NOD_CD" ).append("\n"); 
		query.append("             ,SUBSTR(FM_NOD_CD,1,5) AS POR_CD " ).append("\n"); 
		query.append("             ,SUBSTR(TO_NOD_CD,1,5) AS POD_CD " ).append("\n"); 
		query.append("             ,TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("        FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("       WHERE TRSP_COST_DTL_MOD_CD IN ('CY','DR')" ).append("\n"); 
		query.append("         AND DELT_FLG = 'N') SO" ).append("\n"); 
		query.append("  WHERE BKG.BKG_NO = SO.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.CNTR_NO = SO.EQ_NO(+)" ).append("\n"); 
		query.append("#if (${so_bnd} == 'Outbound')" ).append("\n"); 
		query.append("AND BKG.POR_CD = SO.POR_CD(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND BKG.POD_CD = SO.POD_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}