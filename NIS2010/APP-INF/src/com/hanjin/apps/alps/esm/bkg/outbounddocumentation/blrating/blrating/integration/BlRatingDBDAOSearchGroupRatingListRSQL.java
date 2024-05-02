/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchGroupRatingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchGroupRatingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group & Multi B/L Rating을 위한  목록 조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchGroupRatingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_note",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_rat_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grp_rat_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchGroupRatingListRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("       CTRT_NO," ).append("\n"); 
		query.append("       CASE WHEN BKG_CTRT_TP_CD = 'S' " ).append("\n"); 
		query.append("                 THEN (SELECT CTRT_PTY_NM" ).append("\n"); 
		query.append("                       FROM PRI_SP_CTRT_PTY SC, PRI_SP_MN SM, PRI_SP_HDR SH" ).append("\n"); 
		query.append("                       WHERE SH.SC_NO = A.CTRT_NO" ).append("\n"); 
		query.append("                       AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                       AND A.RT_APLY_DT BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("                       AND SC.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                       AND SC.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                       AND SC.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("            WHEN BKG_CTRT_TP_CD = 'R' " ).append("\n"); 
		query.append("                 THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                       FROM MDM_CUSTOMER MC, PRI_RP_HDR RH, PRI_RP_MN RM" ).append("\n"); 
		query.append("                       WHERE RH.RFA_NO = A.CTRT_NO" ).append("\n"); 
		query.append("                       AND RH.PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("                       AND A.RT_APLY_DT BETWEEN RM.EFF_DT AND RM.EXP_DT" ).append("\n"); 
		query.append("                       AND RM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND RM.CTRT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("            ELSE (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                       FROM MDM_CUSTOMER MC, PRI_TAA_HDR TH, PRI_TAA_MN TM" ).append("\n"); 
		query.append("                       WHERE TH.TAA_NO = A.CTRT_NO" ).append("\n"); 
		query.append("                       AND TH.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("                       AND A.RT_APLY_DT BETWEEN TM.EFF_DT AND TM.EXP_DT" ).append("\n"); 
		query.append("                       AND TM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND TM.CTRT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("       END CTRT_PTY_NM," ).append("\n"); 
		query.append("       SHPR_CD," ).append("\n"); 
		query.append("       SHPR_NM," ).append("\n"); 
		query.append("       CNEE_CD," ).append("\n"); 
		query.append("       CNEE_NM," ).append("\n"); 
		query.append("       ACT_CUST_CD," ).append("\n"); 
		query.append("       ACT_CUST_NM," ).append("\n"); 
		query.append("       T_VVD," ).append("\n"); 
		query.append("       BKG_CZ_DESC," ).append("\n"); 
		query.append("       CNTR_PRT_FLG," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       DE_TERM_CD," ).append("\n"); 
		query.append("       DCGO_FLG," ).append("\n"); 
		query.append("       RC_FLG," ).append("\n"); 
		query.append("       AWK_CGO_FLG," ).append("\n"); 
		query.append("       BB_CGO_FLG," ).append("\n"); 
		query.append("       RD_CGO_FLG," ).append("\n"); 
		query.append("       HNGR_FLG," ).append("\n"); 
		query.append("       POL_ETD_DT," ).append("\n"); 
		query.append("       TO_CHAR(RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT," ).append("\n"); 
		query.append("       SVC_SCP_CD," ).append("\n"); 
		query.append("       FRT_TERM_CD," ).append("\n"); 
		query.append("       RAT_FLG," ).append("\n"); 
		query.append("       CNTR_CFM_STS_CD," ).append("\n"); 
		query.append("       AUD_STS_CD," ).append("\n"); 
		query.append("       GRP_RAT_RSLT_CD," ).append("\n"); 
		query.append("       GRP_RAT_FAIL_RSN_CD," ).append("\n"); 
		query.append("       XTER_RMK," ).append("\n"); 
		query.append("       CASE WHEN BKG_CTRT_TP_CD <> 'S' THEN NULL" ).append("\n"); 
		query.append("            WHEN GEN_SPCL_RT_TP_CD IS NULL THEN NULL" ).append("\n"); 
		query.append("            ELSE SC_NOTE" ).append("\n"); 
		query.append("       END SC_NOTE," ).append("\n"); 
		query.append("       CASE WHEN BKG_CTRT_TP_CD <> 'S' THEN NULL" ).append("\n"); 
		query.append("            WHEN GEN_SPCL_RT_TP_CD IS NULL THEN NULL" ).append("\n"); 
		query.append("            ELSE CONV_CFM_FLG" ).append("\n"); 
		query.append("       END CONV_CFM_FLG," ).append("\n"); 
		query.append("       GRP_RAT_CHK_FLG," ).append("\n"); 
		query.append("       CMDT_CD," ).append("\n"); 
		query.append("       BDR_FLG," ).append("\n"); 
		query.append("       TRF_ITM_NO," ).append("\n"); 
		query.append("       NOTE_RT_SEQ," ).append("\n"); 
		query.append("       PROP_NO," ).append("\n"); 
		query.append("       AMDT_SEQ," ).append("\n"); 
		query.append("       GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("       CMDT_HDR_SEQ," ).append("\n"); 
		query.append("       ROUT_SEQ," ).append("\n"); 
		query.append("       NVL((SELECT 'Y' " ).append("\n"); 
		query.append("            FROM BKG_CUSTOMER BC" ).append("\n"); 
		query.append("            WHERE BC.BKG_NO =A.BKG_NO" ).append("\n"); 
		query.append("            AND BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n"); 
		query.append("            AND CUST_CNT_CD||CUST_SEQ IN(   SELECT PTY.CUST_CNT_CD||PTY.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("                                            WHERE 1=1" ).append("\n"); 
		query.append("                                            AND HD.SC_NO = A.CTRT_NO " ).append("\n"); 
		query.append("                                            AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                            AND MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("                                            AND A.RT_APLY_DT BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("                                            AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("                                            AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("                                            AND PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("                                            UNION ALL" ).append("\n"); 
		query.append("                                            SELECT AF.CUST_CNT_CD||AF.CUST_SEQ FROM PRI_SP_HDR HD, PRI_SP_MN MN, PRI_SP_AFIL AF" ).append("\n"); 
		query.append("                                            WHERE 1=1" ).append("\n"); 
		query.append("                                            AND HD.SC_NO = A.CTRT_NO" ).append("\n"); 
		query.append("                                            AND HD.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("                                            AND MN.PROP_STS_CD ='F' " ).append("\n"); 
		query.append("                                            AND A.RT_APLY_DT BETWEEN MN.EFF_DT AND MN.EXP_DT " ).append("\n"); 
		query.append("                                            AND MN.PROP_NO = AF.PROP_NO" ).append("\n"); 
		query.append("                                            AND MN.AMDT_SEQ = AF.AMDT_SEQ" ).append("\n"); 
		query.append("                                            AND AF.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("            AND ROWNUM = 1),'N') SC_VAL_FLG," ).append("\n"); 
		query.append("        ------    VO 추가용     ------" ).append("\n"); 
		query.append("       '' SEARCH_TYPE," ).append("\n"); 
		query.append("       '' FM_DT," ).append("\n"); 
		query.append("       '' TO_DT," ).append("\n"); 
		query.append("       '' BKG_OFC_CD," ).append("\n"); 
		query.append("       '' BKG_CUST_TP_CD," ).append("\n"); 
		query.append("       '' CUST_CNT_CD," ).append("\n"); 
		query.append("       '' CUST_SEQ," ).append("\n"); 
		query.append("       '' DOC_USR_ID," ).append("\n"); 
		query.append("       '' CTRT_OFC_CD," ).append("\n"); 
		query.append("       '' CTRT_OFC_CD_SUB," ).append("\n"); 
		query.append("       '' CTRT_SREP_CD," ).append("\n"); 
		query.append("       '' OB_SLS_OFC_CD," ).append("\n"); 
		query.append("       '' OB_SLS_OFC_CD_SUB," ).append("\n"); 
		query.append("       '' OB_SREP_CD," ).append("\n"); 
		query.append("       '' USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("         SELECT BK.BKG_NO, " ).append("\n"); 
		query.append("               BK.BL_NO, " ).append("\n"); 
		query.append("               BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("               CASE WHEN BR.BKG_CTRT_TP_CD = 'S' THEN BK.SC_NO" ).append("\n"); 
		query.append("                    WHEN BR.BKG_CTRT_TP_CD = 'R' THEN BK.RFA_NO" ).append("\n"); 
		query.append("                    ELSE BK.TAA_NO" ).append("\n"); 
		query.append("               END CTRT_NO," ).append("\n"); 
		query.append("               BK.SVC_SCP_CD," ).append("\n"); 
		query.append("               BR.FRT_TERM_CD," ).append("\n"); 
		query.append("               BS.CUST_CNT_CD||LPAD(BS.CUST_SEQ,6,0) SHPR_CD," ).append("\n"); 
		query.append("               BS.CUST_NM SHPR_NM," ).append("\n"); 
		query.append("               BC.CUST_CNT_CD||LPAD(BC.CUST_SEQ,6,0) CNEE_CD," ).append("\n"); 
		query.append("               BC.CUST_NM CNEE_NM," ).append("\n"); 
		query.append("               BK.AGMT_ACT_CNT_CD||LPAD(BK.AGMT_ACT_CUST_SEQ,6,0) ACT_CUST_CD, " ).append("\n"); 
		query.append("               '' ACT_CUST_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("               BQ.BKG_CZ_DESC," ).append("\n"); 
		query.append("               (SELECT CNTR_PRT_FLG" ).append("\n"); 
		query.append("                FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                WHERE BC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("                AND ROWNUM = 1) CNTR_PRT_FLG," ).append("\n"); 
		query.append("               BK.POR_CD, " ).append("\n"); 
		query.append("               BK.POL_CD," ).append("\n"); 
		query.append("               BK.POD_CD," ).append("\n"); 
		query.append("               BK.DEL_CD," ).append("\n"); 
		query.append("               BK.RCV_TERM_CD," ).append("\n"); 
		query.append("               BK.DE_TERM_CD," ).append("\n"); 
		query.append("               BK.XTER_RMK," ).append("\n"); 
		query.append("               DECODE(BK.DCGO_FLG, 'Y', 'Y', NULL) DCGO_FLG," ).append("\n"); 
		query.append("               DECODE(BK.RC_FLG, 'Y', 'Y', NULL) RC_FLG," ).append("\n"); 
		query.append("               DECODE(BK.AWK_CGO_FLG, 'Y', 'Y', NULL) AWK_CGO_FLG," ).append("\n"); 
		query.append("               DECODE(BK.BB_CGO_FLG, 'Y', 'Y', NULL) BB_CGO_FLG," ).append("\n"); 
		query.append("               DECODE(BK.RD_CGO_FLG, 'Y', 'Y', 'N', NULL) RD_CGO_FLG," ).append("\n"); 
		query.append("               DECODE(BK.HNGR_FLG, 'Y', 'Y', 'N', NULL) HNGR_FLG," ).append("\n"); 
		query.append("               (SELECT TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO     = VVD.BKG_NO" ).append("\n"); 
		query.append("                AND BK.POL_CD       = VVD.POL_CD" ).append("\n"); 
		query.append("                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                AND VVD.VSL_CD       = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("                AND VVD.SKD_VOY_NO   = SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND VVD.SKD_DIR_CD   = SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND VVD.POL_CD       = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                AND ROWNUM = 1) POL_ETD_DT," ).append("\n"); 
		query.append("               BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(BK.BKG_NO, 'N') RT_APLY_DT," ).append("\n"); 
		query.append("               NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_CHG_RT T" ).append("\n"); 
		query.append("                    WHERE T.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    AND T.AUTO_RAT_CD <> 'I'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                    ),'N') RAT_FLG," ).append("\n"); 
		query.append("               NVL((SELECT 'C'" ).append("\n"); 
		query.append("                    FROM BKG_DOC_PROC_SKD T" ).append("\n"); 
		query.append("                    WHERE T.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                    AND T.BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("                    AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                    ),'N') CNTR_CFM_STS_CD," ).append("\n"); 
		query.append("               BR.AUD_STS_CD," ).append("\n"); 
		query.append("               BR.GRP_RAT_RSLT_CD, -- RESULT," ).append("\n"); 
		query.append("               BR.GRP_RAT_FAIL_RSN_CD,-- REASON," ).append("\n"); 
		query.append("               DECODE(" ).append("\n"); 
		query.append("               NVL(" ).append("\n"); 
		query.append("                (SELECT 1" ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_NOTE_CTNT A" ).append("\n"); 
		query.append("                WHERE A.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("                AND A.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("                AND A.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND A.NOTE_TP_CD ='P'" ).append("\n"); 
		query.append("                AND ROWNUM = 1),0)" ).append("\n"); 
		query.append("                +" ).append("\n"); 
		query.append("                NVL(" ).append("\n"); 
		query.append("                (SELECT 1" ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_RT_CMDT_RNOTE B" ).append("\n"); 
		query.append("                WHERE B.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("                AND B.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("                AND B.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND B.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND B.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND B.ROUT_SEQ = NVL(RT.ROUT_SEQ, B.ROUT_SEQ)" ).append("\n"); 
		query.append("                AND B.GEN_SPCL_RT_TP_CD ='S'" ).append("\n"); 
		query.append("                AND ROWNUM = 1),0)" ).append("\n"); 
		query.append("                +" ).append("\n"); 
		query.append("                NVL(" ).append("\n"); 
		query.append("                (SELECT 1" ).append("\n"); 
		query.append("                FROM PRI_SP_SCP_RT_CNOTE C" ).append("\n"); 
		query.append("                WHERE C.PROP_NO = RT.PROP_NO" ).append("\n"); 
		query.append("                AND C.AMDT_SEQ = RT.AMDT_SEQ" ).append("\n"); 
		query.append("                AND C.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND C.GEN_SPCL_RT_TP_CD ='S'" ).append("\n"); 
		query.append("                AND C.GEN_SPCL_RT_TP_CD = RT.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND C.CMDT_HDR_SEQ = RT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND ROWNUM = 1),0)," ).append("\n"); 
		query.append("               0,'N','Y') SC_NOTE," ).append("\n"); 
		query.append("               (SELECT NVL(CONV_CFM_FLG, 'N')" ).append("\n"); 
		query.append("                FROM BKG_CHG_RT RT, PRI_SP_MN SM" ).append("\n"); 
		query.append("                WHERE RT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND RT.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                AND RT.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) CONV_CFM_FLG," ).append("\n"); 
		query.append("               DECODE(GRP_RAT_RSLT_CD,'S',NVL(BR.GRP_RAT_CHK_FLG, 'N')) GRP_RAT_CHK_FLG," ).append("\n"); 
		query.append("               BK.CMDT_CD," ).append("\n"); 
		query.append("               BD.BDR_FLG," ).append("\n"); 
		query.append("               RT.TRF_ITM_NO," ).append("\n"); 
		query.append("               RT.NOTE_RT_SEQ," ).append("\n"); 
		query.append("               RT.PROP_NO," ).append("\n"); 
		query.append("               RT.AMDT_SEQ," ).append("\n"); 
		query.append("               RT.GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("               RT.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("               RT.ROUT_SEQ" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("             BKG_BOOKING BK, " ).append("\n"); 
		query.append("             BKG_RATE BR, " ).append("\n"); 
		query.append("             BKG_BL_DOC BD, " ).append("\n"); 
		query.append("             BKG_CUSTOMER BS, " ).append("\n"); 
		query.append("             BKG_CUSTOMER BF," ).append("\n"); 
		query.append("             BKG_CUSTOMER BC," ).append("\n"); 
		query.append("             BKG_CNTR_CZ BQ," ).append("\n"); 
		query.append("             BKG_CHG_RT RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("        WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${search_type} == 'ETD')" ).append("\n"); 
		query.append("             ," ).append("\n"); 
		query.append("             (SELECT BKG_NO" ).append("\n"); 
		query.append("              FROM VSK_VSL_PORT_SKD VSK, BKG_VVD VVD" ).append("\n"); 
		query.append("              WHERE VSK.VPS_ETD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("              AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("              AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("              AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("              AND EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                    FROM  (SELECT  BKG_NO, MIN(VSL_PRE_PST_CD||VSL_SEQ) OVER (PARTITION BY BKG_NO) AS MIN_FLAG FROM BKG_VVD ) C" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND VVD.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                    AND VVD.VSL_PRE_PST_CD =  SUBSTR(C.MIN_FLAG,1,1)" ).append("\n"); 
		query.append("                    AND VVD.VSL_SEQ =  SUBSTR(C.MIN_FLAG,2,1)" ).append("\n"); 
		query.append("                    AND ROWNUM=1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("--              AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) " ).append("\n"); 
		query.append("--                                                FROM BKG_VVD VVD2 " ).append("\n"); 
		query.append("--                                                WHERE VVD2.BKG_NO = VVD.BKG_NO)" ).append("\n"); 
		query.append("              ) BKG" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${search_type} == 'CRD')" ).append("\n"); 
		query.append("             , " ).append("\n"); 
		query.append("             (SELECT DISTINCT A.BKG_NO" ).append("\n"); 
		query.append("              FROM (SELECT BKG_NO,MAX(CGO_RCV_DT) OVER (PARTITION BY BKG_NO) AS MAX_CGO_RCV_DT " ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                    WHERE CGO_RCV_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.99999 ) A  " ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("              AND NOT EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                              FROM BKG_CONTAINER B " ).append("\n"); 
		query.append("                              WHERE A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                              AND  B.CGO_RCV_DT > A.MAX_CGO_RCV_DT)) BKG     " ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${search_type} == 'VVD')" ).append("\n"); 
		query.append("        WHERE BK.VSL_CD = SUBSTR(@[t_vvd], 1, 4)" ).append("\n"); 
		query.append("        AND BK.SKD_VOY_NO = SUBSTR(@[t_vvd], 5, 4)" ).append("\n"); 
		query.append("        AND BK.SKD_DIR_CD = SUBSTR(@[t_vvd], 9, 1)  " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        AND BK.BKG_STS_CD IN ( 'F', 'W' )  " ).append("\n"); 
		query.append("        AND BK.NON_RT_STS_CD = 'F' " ).append("\n"); 
		query.append("        AND BR.OFT_MSS_FLG = 'N'   " ).append("\n"); 
		query.append("        AND BR.RT_BL_TP_CD NOT IN ( 'B', 'C' ) " ).append("\n"); 
		query.append("        AND BK.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("        AND BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("        AND BK.BKG_NO = BS.BKG_NO" ).append("\n"); 
		query.append("        AND BS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("        AND BK.BKG_NO = BF.BKG_NO" ).append("\n"); 
		query.append("        AND BF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("        AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        AND BC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("        AND BK.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("        AND BQ.BKG_CZ_STS_CD = 'CQ'" ).append("\n"); 
		query.append("        AND BK.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("        AND RT.CHG_CD(+) = 'OFT'" ).append("\n"); 
		query.append("        AND RT.RT_SEQ(+) = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} == 'S' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND BK.SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'R' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND BK.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'T' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND BK.TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${doc_usr_id} != '')" ).append("\n"); 
		query.append("        AND BK.DOC_USR_ID = @[doc_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ctrt_ofc_cd_sub} != 'Y')" ).append("\n"); 
		query.append(" #if(${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND BK.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" #if(${ctrt_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND BK.CTRT_OFC_CD IN (SELECT OFC_CD " ).append("\n"); 
		query.append("                               FROM   BKG_OFC_LVL_V" ).append("\n"); 
		query.append("                               WHERE @[ctrt_ofc_cd] IN (OFC_CD ,OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD,OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD) )" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ctrt_srep_cd} != '')" ).append("\n"); 
		query.append("        AND BK.CTRT_SREP_CD = @[ctrt_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ob_sls_ofc_cd_sub} != 'Y')" ).append("\n"); 
		query.append("#if(${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND BK.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" #if(${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND BK.OB_SLS_OFC_CD IN (SELECT OFC_CD " ).append("\n"); 
		query.append("                                 FROM   BKG_OFC_LVL_V" ).append("\n"); 
		query.append("                                 WHERE @[ob_sls_ofc_cd] IN (OFC_CD ,OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD,OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD) )" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ob_srep_cd} != '')" ).append("\n"); 
		query.append("        AND BK.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${por_cd} != '')" ).append("\n"); 
		query.append("        AND BK.POR_CD LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pol_cd} != '')" ).append("\n"); 
		query.append("        AND BK.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${pod_cd} != '')" ).append("\n"); 
		query.append("        AND BK.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${del_cd} != '')" ).append("\n"); 
		query.append("        AND BK.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${grp_rat_rslt_cd} != '')" ).append("\n"); 
		query.append("        AND BR.GRP_RAT_RSLT_CD = @[grp_rat_rslt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${grp_rat_chk_flg} != '')" ).append("\n"); 
		query.append("        AND NVL(BR.GRP_RAT_CHK_FLG,'N') = @[grp_rat_chk_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     BS.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     BS.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     BF.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     BF.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     BC.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     BC.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${rat_flg} != '')" ).append("\n"); 
		query.append("AND RAT_FLG = @[rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_cfm_sts_cd} != '')" ).append("\n"); 
		query.append("AND CNTR_CFM_STS_CD = @[cntr_cfm_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_note} != '')" ).append("\n"); 
		query.append("AND SC_NOTE = @[sc_note]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}