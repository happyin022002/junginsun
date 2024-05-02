/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchAwkwardBKGListForAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.17 
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

public class UnmatchBLDBDAOSearchAwkwardBKGListForAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AK BKG List For Audit
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchAwkwardBKGListForAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchAwkwardBKGListForAuditRSQL").append("\n"); 
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
		query.append("       TO_CHAR(BK.BKG_CRE_DT, 'YYYY-MM-DD') BKG_CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT," ).append("\n"); 
		query.append("       (SELECT TO_CHAR(MIN(V.VPS_ETD_DT),'YYYY-MM-DD') " ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD V, BKG_VVD BV" ).append("\n"); 
		query.append("        WHERE BV.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("        AND BK.POL_CD = BV.POL_CD" ).append("\n"); 
		query.append("        AND V.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("        AND V.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND V.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND V.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("        AND V.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ) POL_ETD," ).append("\n"); 
		query.append("       BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID ='CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD) BKG_CTRT_TP_CD  ," ).append("\n"); 
		query.append("       CASE WHEN BR.BKG_CTRT_TP_CD = 'R' THEN BK.RFA_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'S' THEN BK.SC_NO" ).append("\n"); 
		query.append("            WHEN BR.BKG_CTRT_TP_CD = 'T' THEN BK.TAA_NO" ).append("\n"); 
		query.append("       END CTRT_NO," ).append("\n"); 
		query.append("       BK.CMDT_CD," ).append("\n"); 
		query.append("       (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BK.CMDT_CD) CMDT_NM," ).append("\n"); 
		query.append("       BK.SVC_SCP_CD," ).append("\n"); 
		query.append("       BK.POR_CD," ).append("\n"); 
		query.append("       BK.POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD," ).append("\n"); 
		query.append("       BK.DEL_CD," ).append("\n"); 
		query.append("       BK.RCV_TERM_CD," ).append("\n"); 
		query.append("       BK.DE_TERM_CD," ).append("\n"); 
		query.append("       (SELECT M.CUST_LGL_ENG_NM FROM MDM_CUSTOMER M, BKG_CUSTOMER SH WHERE SH.BKG_NO = BK.BKG_NO AND SH.BKG_CUST_TP_CD = 'S' AND M.CUST_CNT_CD = SH.CUST_CNT_CD AND M.CUST_SEQ = SH.CUST_SEQ) SHPR_NM," ).append("\n"); 
		query.append("       (SELECT M.CUST_LGL_ENG_NM FROM MDM_CUSTOMER M, BKG_CUSTOMER CN WHERE CN.BKG_NO = BK.BKG_NO AND CN.BKG_CUST_TP_CD = 'C' AND M.CUST_CNT_CD = CN.CUST_CNT_CD AND M.CUST_SEQ = CN.CUST_SEQ) CNEE_NM," ).append("\n"); 
		query.append("       (SELECT M.CUST_LGL_ENG_NM FROM MDM_CUSTOMER M, BKG_CUSTOMER FF WHERE FF.BKG_NO = BK.BKG_NO AND FF.BKG_CUST_TP_CD = 'F' AND M.CUST_CNT_CD = FF.CUST_CNT_CD AND M.CUST_SEQ = FF.CUST_SEQ) FWDR_NM," ).append("\n"); 
		query.append("       (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BK.CTRT_CUST_CNT_CD AND CUST_SEQ = BK.CTRT_CUST_SEQ) CTRT_CUST_NM," ).append("\n"); 
		query.append("       (SELECT DECODE(BL.BDR_FLG, 'Y', 'Yes', 'No') FROM BKG_BL_DOC BL WHERE BK.BKG_NO=BL.BKG_NO)  BDR_FLG ," ).append("\n"); 
		query.append("       DECODE(BK.SPLIT_FLG, 'Y', 'Split', 'Non-Split') SPLIT_FLG," ).append("\n"); 
		query.append("       NVL(( SELECT 'Charged' FROM BKG_CHG_RT RT WHERE BK.BKG_NO=BK.BKG_NO AND ROWNUM=1 ),'Non-Charged') CHARGE_FLG," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01639'AND INTG_CD_VAL_CTNT = BR.RT_BL_TP_CD) RT_BL_TP_CD," ).append("\n"); 
		query.append("       NVL((SELECT  MAX(RDN_NO) RDN_NO" ).append("\n"); 
		query.append("            FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("            WHERE   BKG_NO = BK.BKG_NO), ' ') AS RDN_NO ," ).append("\n"); 
		query.append("       NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL, BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("	         WHERE 1=1" ).append("\n"); 
		query.append("	           AND INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("	           AND INTG_CD_VAL_CTNT = A.RDN_STS_CD" ).append("\n"); 
		query.append("	           AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("	           AND (A.RDN_NO, RVIS_SEQ ) IN  (SELECT RDN_NO, RVIS_SEQ FROM BKG_REV_DR_NOTE K" ).append("\n"); 
		query.append("                                               WHERE K.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                 AND K.CRE_DT = (SELECT MAX(CRE_DT) FROM BKG_REV_DR_NOTE P" ).append("\n"); 
		query.append("                                                                  WHERE 1=1" ).append("\n"); 
		query.append("                                                                    AND P.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("                                                                    AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                ),' ') RDN_STS_NM" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_RATE BR," ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = 'SELHO'" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    (SELECT	OFC_CD " ).append("\n"); 
		query.append("     FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("     WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("     START WITH	A.OFC_CD = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("     CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("     ) OG" ).append("\n"); 
		query.append(" #if (${search_date} == 'ETD')" ).append("\n"); 
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
		query.append(" #elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("WHERE BR.RT_APLY_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("WHERE BK.BKG_CRE_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("AND NVL(BK.BL_NO_TP, 'N') <> '9'" ).append("\n"); 
		query.append("AND NVL(BR.RT_BL_TP_CD, 'N') NOT IN ( 'C', 'B' )" ).append("\n"); 
		query.append("AND BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("AND OG.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("BQ AS(" ).append("\n"); 
		query.append("SELECT BK.BKG_NO, " ).append("\n"); 
		query.append("       BQ.CNTR_TPSZ_CD,  " ).append("\n"); 
		query.append("       CASE WHEN QD.CNTR_TPSZ_CD LIKE 'R%' AND QD.DRY_CGO_FLG = 'Y' THEN QD.CNTR_TPSZ_CD   -- RD 인 경우만 예외처리  " ).append("\n"); 
		query.append("            ELSE NVL(QD.EQ_SUBST_CNTR_TPSZ_CD, QD.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("       END CTRT_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       QD.CNTR_TPSZ_CD AK_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       SUM(BQ.OP_CNTR_QTY) OP_CNTR_QTY, " ).append("\n"); 
		query.append("       SUM(QD.OP_CNTR_QTY) AK_CNTR_QTY," ).append("\n"); 
		query.append("       (SELECT SUM(OVR_VOID_SLT_QTY) FROM BKG_AWK_CGO WHERE BKG_NO = BK.BKG_NO AND CNTR_TPSZ_CD = BQ.CNTR_TPSZ_CD) VOID_SLT_QTY" ).append("\n"); 
		query.append("FROM BK, BKG_QUANTITY BQ, BKG_QTY_DTL QD" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("AND BQ.BKG_NO = QD.BKG_NO" ).append("\n"); 
		query.append("AND BQ.CNTR_TPSZ_CD = QD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND QD.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND BQ.CNTR_TPSZ_CD IN ( #foreach(${key} in ${cntr_tpsz_cd_list} ) #if($velocityCount != 1) , #end '$key' #end )  -- MULTI" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY BK.BKG_NO, BQ.CNTR_TPSZ_CD, QD.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CASE WHEN QD.CNTR_TPSZ_CD LIKE 'R%' AND QD.DRY_CGO_FLG = 'Y' THEN QD.CNTR_TPSZ_CD   -- RD 인 경우만 예외처리  " ).append("\n"); 
		query.append("            ELSE NVL(QD.EQ_SUBST_CNTR_TPSZ_CD, QD.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("BR AS(" ).append("\n"); 
		query.append("SELECT RT.BKG_NO, RT.CHG_CD, RT.CURR_CD, RT.RAT_UT_CD, RT.CHG_UT_AMT, RT.RAT_AS_QTY, RT.CHG_AMT, RT.FRT_TERM_CD, RT.AUTO_RAT_CD" ).append("\n"); 
		query.append("FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("WHERE RT.BKG_NO IN (SELECT BKG_NO FROM BK)" ).append("\n"); 
		query.append("AND RT.CHG_CD = 'OFT'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DISTINCT BK.BKG_RHQ_CD, BK.BKG_OFC_CD, BK.BKG_NO, BK.BKG_CRE_DT, BK.RT_APLY_DT, BK.POL_ETD, BK.T_VVD, " ).append("\n"); 
		query.append("       BK.BKG_CTRT_TP_CD, BK.CTRT_NO, BK.CMDT_CD, BK.CMDT_NM, " ).append("\n"); 
		query.append("       BK.SVC_SCP_CD, BK.POR_CD, BK.POL_CD, BK.POD_CD, BK.DEL_CD," ).append("\n"); 
		query.append("       BK.RCV_TERM_CD, BK.DE_TERM_CD,BK.SHPR_NM, BK.CNEE_NM, BK.FWDR_NM, BK.CTRT_CUST_NM, " ).append("\n"); 
		query.append("       BK.BDR_FLG, BK.SPLIT_FLG, BK.CHARGE_FLG, BK.RT_BL_TP_CD, BK.RDN_NO, BK.RDN_STS_NM," ).append("\n"); 
		query.append("       BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY,BQ.AK_CNTR_TPSZ_CD, BQ.AK_CNTR_QTY, BQ.VOID_SLT_QTY," ).append("\n"); 
		query.append("       BR.CHG_CD, BR.CURR_CD, BR.CHG_UT_AMT, BR.RAT_UT_CD, BR.RAT_AS_QTY, BR.CHG_AMT, BR.FRT_TERM_CD, BR.AUTO_RAT_CD," ).append("\n"); 
		query.append("       COUNT(DISTINCT BK.BKG_NO) OVER () AS  BL_CNT" ).append("\n"); 
		query.append("FROM BK, BQ, BR" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("AND BQ.BKG_NO = BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND BQ.CTRT_CNTR_TPSZ_CD = BR.RAT_UT_CD(+)" ).append("\n"); 
		query.append("#if (${bdr_flg} != '') " ).append("\n"); 
		query.append("AND BK.BDR_FLG   = @[bdr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${charge_flg} == 'C')" ).append("\n"); 
		query.append("AND CHARGE_FLG='Charged'" ).append("\n"); 
		query.append("#elseif(${charge_flg} == 'N')" ).append("\n"); 
		query.append("AND CHARGE_FLG='Non-Charged'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_RHQ_CD, BKG_OFC_CD, BK.BKG_NO, BQ.CNTR_TPSZ_CD" ).append("\n"); 

	}
}