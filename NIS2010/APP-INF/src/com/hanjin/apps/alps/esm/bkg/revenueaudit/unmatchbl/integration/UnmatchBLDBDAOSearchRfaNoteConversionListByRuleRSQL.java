/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchRfaNoteConversionListByRuleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.25 
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

public class UnmatchBLDBDAOSearchRfaNoteConversionListByRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 RFA Note를 조회
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchRfaNoteConversionListByRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_rule_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchRfaNoteConversionListByRuleRSQL").append("\n"); 
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
		query.append("#if (${note_conv_rule_cd} != 'NOR')" ).append("\n"); 
		query.append("WITH RFA_LIST AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT " ).append("\n"); 
		query.append("            H.RFA_NO" ).append("\n"); 
		query.append("        ,   M.PROP_NO" ).append("\n"); 
		query.append("        ,   M.AMDT_SEQ " ).append("\n"); 
		query.append("        ,   M.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,   M.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("        ,   NC.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("        ,   NC.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM    PRI_RP_HDR H" ).append("\n"); 
		query.append("        ,   PRI_RP_MN M" ).append("\n"); 
		query.append("        ,   PRI_RFA_NOTE_CONV NC" ).append("\n"); 
		query.append("    WHERE   M.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("    AND     M.AMDT_SEQ = (  SELECT  MAX ( X.AMDT_SEQ ) " ).append("\n"); 
		query.append("                            FROM    PRI_RP_MN X " ).append("\n"); 
		query.append("                            WHERE   X.PROP_NO = M.PROP_NO " ).append("\n"); 
		query.append("                            AND     SYSDATE BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                            AND     X.PROP_STS_CD  = 'A'  ) " ).append("\n"); 
		query.append("    AND     M.PROP_NO = NC.PROP_NO" ).append("\n"); 
		query.append("    AND     M.AMDT_SEQ = NC.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     H.RFA_NO = H.RFA_NO" ).append("\n"); 
		query.append("    AND     H.CRE_DT >= TO_DATE('20170101', 'YYYYMMDD')        -- For Ignore Hanjin Shipping Contract" ).append("\n"); 
		query.append("#if (${ctrt_no} != '')" ).append("\n"); 
		query.append("    AND     H.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${note_conv_rule_cd} != '')" ).append("\n"); 
		query.append("AND     (NC.NOTE_CONV_RULE_CD = NVL(@[note_conv_rule_cd], NC.NOTE_CONV_RULE_CD) OR NC.NOTE_CONV_CHG_CD = NVL(@[note_conv_rule_cd], NC.NOTE_CONV_CHG_CD))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND     NC.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- Effective Date (To)" ).append("\n"); 
		query.append("    AND     NC.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- Effective Date (From)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CTRT_NO" ).append("\n"); 
		query.append("    ,  BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("    ,  PROP_NO" ).append("\n"); 
		query.append("    ,  AMDT_SEQ" ).append("\n"); 
		query.append("    ,  CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,  SVC_SCP_CD" ).append("\n"); 
		query.append("    ,  RT_TP" ).append("\n"); 
		query.append("    ,  NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("    ,  DP_SEQ" ).append("\n"); 
		query.append("    ,  NOTE_CLSS_CD" ).append("\n"); 
		query.append("    ,  CHG_CD" ).append("\n"); 
		query.append("    ,  NOTE_CTNT" ).append("\n"); 
		query.append("    ,  NOTE_CONV_SEQ" ).append("\n"); 
		query.append("    ,  CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("    ,  EFF_DT" ).append("\n"); 
		query.append("    ,  EXP_DT" ).append("\n"); 
		query.append("    ,  RT_APPL_TP_CD" ).append("\n"); 
		query.append("    ,  CURR_CD" ).append("\n"); 
		query.append("    ,  RT_OP_CD" ).append("\n"); 
		query.append("    ,  FRT_RT_AMT" ).append("\n"); 
		query.append("    ,  BKG_RAT_UT_CD" ).append("\n"); 
		query.append("    ,  BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("    ,  BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("    ,  BKG_POR_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_POL_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_POD_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("    ,  BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,  BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,  BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("    ,  BKG_DE_TERM_CD" ).append("\n"); 
		query.append("    ,  BKG_SLAN_CD" ).append("\n"); 
		query.append("    ,  BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("    ,  BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_IO_GA_CD" ).append("\n"); 
		query.append("    ,  BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("    ,  BKG_VVD_CD" ).append("\n"); 
		query.append("    ,  BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("    ,  BKG_SOC_FLG" ).append("\n"); 
		query.append("    ,  BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("    ,  BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("    ,  BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("    ,  PAY_TERM_CD" ).append("\n"); 
		query.append("    ,  RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("    ,  RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("    ,  IGN_TRF_FLG" ).append("\n"); 
		query.append("    ,  RT_PATT_TP_CD" ).append("\n"); 
		query.append("    ,  CONV_RAT_UT_CD" ).append("\n"); 
		query.append("    ,  CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("    ,  CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("    ,  CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("    ,  CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("    ,  CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("    ,  CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("    ,  CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("    ,  CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("    ,  BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("    ,  BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("    ,  BKG_YD_CD" ).append("\n"); 
		query.append("    ,  BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("    ,  UPD_DT" ).append("\n"); 
		query.append("    ,  USR_NM" ).append("\n"); 
		query.append("    ,  CTRT_CNT" ).append("\n"); 
		query.append("-------------------------------------" ).append("\n"); 
		query.append("    ,  '' NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("-------------------------------------" ).append("\n"); 
		query.append("    , TOTAL_CNT" ).append("\n"); 
		query.append("    , @[curr_page] + 80000 AS CURR_PAGE" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT RFA.*" ).append("\n"); 
		query.append("              ,COUNT(DISTINCT CTRT_NO) OVER (PARTITION BY 1) CTRT_CNT" ).append("\n"); 
		query.append("              ,COUNT(*) OVER (PARTITION BY 1) TOTAL_CNT" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER (ORDER BY CTRT_NO, PROP_NO, AMDT_SEQ, CTRT_PTY_NM, SVC_SCP_CD, RT_TP, NOTE_CONV_TP_CD, DP_SEQ ) RNUM" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT  'Commodity' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("                    ,   M.RFA_NO CTRT_NO" ).append("\n"); 
		query.append("                    ,   'R' AS BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                    ,   M.PROP_NO" ).append("\n"); 
		query.append("                    ,   M.AMDT_SEQ" ).append("\n"); 
		query.append("                    ,   (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE M.CTRT_CUST_CNT_CD = CUST_CNT_CD AND M.CTRT_CUST_SEQ = CUST_SEQ and DELT_FLG = 'N' ) CTRT_PTY_NM" ).append("\n"); 
		query.append("                    ,   CN.SVC_SCP_CD" ).append("\n"); 
		query.append("                    ,   DECODE(CH.FIC_RT_TP_CD,'G','Rate of Port (CY) only','Rate of Including IHC') AS RT_TP" ).append("\n"); 
		query.append("                    ,   TO_CHAR(CH.BLET_DP_SEQ) DP_SEQ" ).append("\n"); 
		query.append("                    ,   DECODE(NC.CHG_RULE_TP_CD,'C','Surcharge','Others') AS NOTE_CLSS_CD" ).append("\n"); 
		query.append("                    ,   NC.NOTE_CONV_CHG_CD AS CHG_CD" ).append("\n"); 
		query.append("                    ,   CN.NOTE_CTNT" ).append("\n"); 
		query.append("                    ,   NC.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("                    ,   CASE WHEN NC.CHG_RULE_TP_CD = 'C' THEN NC.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("                             WHEN NC.CHG_RULE_TP_CD = 'R' THEN NC.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                        END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("                    ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01723' AND C.INTG_CD_VAL_CTNT = NC.RT_APPL_TP_CD ) RT_APPL_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.CURR_CD" ).append("\n"); 
		query.append("                    ,   NC.RT_OP_CD" ).append("\n"); 
		query.append("                    ,   NC.FRT_RT_AMT" ).append("\n"); 
		query.append("                    ,   NC.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_SLAN_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("                    ,   NC.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_IO_GA_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_VSL_CD||NC.BKG_SKD_VOY_NO||NC.BKG_SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_SOC_FLG" ).append("\n"); 
		query.append("                    ,   '' AS BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.PAY_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("                    ,   '' AS IGN_TRF_FLG" ).append("\n"); 
		query.append("                    ,   '' AS RT_PATT_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_RAT_UT_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("                    ,   NC.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("                    ,   NC.BKG_YD_CD" ).append("\n"); 
		query.append("                    ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01708' AND C.INTG_CD_VAL_CTNT = NC.BKG_HNGR_BAR_TP_CD ) BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                    ,   C.USR_NM" ).append("\n"); 
		query.append("                FROM    RFA_LIST M" ).append("\n"); 
		query.append("                    ,   PRI_RFA_NOTE_CONV NC" ).append("\n"); 
		query.append("                    ,   PRI_RP_SCP_RT_CNOTE CN" ).append("\n"); 
		query.append("                    ,   PRI_RP_SCP_RT_CMDT_HDR CH" ).append("\n"); 
		query.append("                    ,   COM_USER C" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     NC.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("                AND     NC.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_MAPG_ID = M.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = M.NOTE_CONV_TP_CD " ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = 'C' " ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_MAPG_ID = CN.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND     CN.PROP_NO = CH.PROP_NO" ).append("\n"); 
		query.append("                AND     CN.AMDT_SEQ = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     CN.SVC_SCP_CD = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     CN.CMDT_HDR_SEQ = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     CN.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                AND     NC.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("                AND     CN.SVC_SCP_CD = NVL(@[svc_scp_cd], CN.SVC_SCP_CD)" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = NVL(@[note_conv_tp_cd], NC.NOTE_CONV_TP_CD)" ).append("\n"); 
		query.append("            #if (${note_conv_rule_cd} != '')" ).append("\n"); 
		query.append("                AND    @[note_conv_rule_cd] in (NC.NOTE_CONV_RULE_CD,NC.NOTE_CONV_CHG_CD) " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT  'Route' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("                    ,   M.RFA_NO CTRT_NO" ).append("\n"); 
		query.append("                    ,   'R' AS BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                    ,   M.PROP_NO" ).append("\n"); 
		query.append("                    ,   M.AMDT_SEQ" ).append("\n"); 
		query.append("                    ,   (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE M.CTRT_CUST_CNT_CD = CUST_CNT_CD AND M.CTRT_CUST_SEQ = CUST_SEQ and DELT_FLG = 'N' ) CTRT_PTY_NM" ).append("\n"); 
		query.append("                    ,   RN.SVC_SCP_CD" ).append("\n"); 
		query.append("                    ,   DECODE(CH.FIC_RT_TP_CD,'G','Rate of Port (CY) only','Rate of Including IHC') AS RT_TP" ).append("\n"); 
		query.append("                    ,   CH.BLET_DP_SEQ || '.' || RN.ROUT_SEQ DP_SEQ" ).append("\n"); 
		query.append("                    ,   DECODE(NC.CHG_RULE_TP_CD,'C','Surcharge','Others') AS NOTE_CLSS_CD" ).append("\n"); 
		query.append("                    ,   NC.NOTE_CONV_CHG_CD AS CHG_CD" ).append("\n"); 
		query.append("                    ,   RN.NOTE_CTNT" ).append("\n"); 
		query.append("                    ,   NC.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("                    ,   CASE WHEN NC.CHG_RULE_TP_CD = 'C' THEN NC.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("                             WHEN NC.CHG_RULE_TP_CD = 'R' THEN NC.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                        END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("                    ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01723' AND C.INTG_CD_VAL_CTNT = NC.RT_APPL_TP_CD ) RT_APPL_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.CURR_CD" ).append("\n"); 
		query.append("                    ,   NC.RT_OP_CD" ).append("\n"); 
		query.append("                    ,   NC.FRT_RT_AMT" ).append("\n"); 
		query.append("                    ,   NC.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_SLAN_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("                    ,   NC.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_IO_GA_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_VSL_CD||NC.BKG_SKD_VOY_NO||NC.BKG_SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_SOC_FLG" ).append("\n"); 
		query.append("                    ,   '' AS BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.PAY_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("                    ,   '' AS IGN_TRF_FLG" ).append("\n"); 
		query.append("                    ,   '' AS RT_PATT_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_RAT_UT_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("                    ,   NC.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("                    ,   NC.BKG_YD_CD" ).append("\n"); 
		query.append("                    ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01708' AND C.INTG_CD_VAL_CTNT = NC.BKG_HNGR_BAR_TP_CD ) BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                    ,   C.USR_NM" ).append("\n"); 
		query.append("                FROM    RFA_LIST M" ).append("\n"); 
		query.append("                    ,   PRI_RFA_NOTE_CONV NC" ).append("\n"); 
		query.append("                    ,   PRI_RP_SCP_RT_CMDT_RNOTE RN" ).append("\n"); 
		query.append("                    ,   PRI_RP_SCP_RT_CMDT_HDR CH" ).append("\n"); 
		query.append("                    ,   COM_USER C" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     NC.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("                AND     NC.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_MAPG_ID = M.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = M.NOTE_CONV_TP_CD " ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = 'R' " ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_MAPG_ID = RN.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND     RN.PROP_NO = CH.PROP_NO" ).append("\n"); 
		query.append("                AND     RN.AMDT_SEQ = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     RN.SVC_SCP_CD = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     RN.CMDT_HDR_SEQ = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     RN.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                AND     NC.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("                AND     RN.SVC_SCP_CD = NVL(@[svc_scp_cd], RN.SVC_SCP_CD)" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = NVL(@[note_conv_tp_cd], NC.NOTE_CONV_TP_CD)" ).append("\n"); 
		query.append("            #if (${note_conv_rule_cd} != '')" ).append("\n"); 
		query.append("                AND    @[note_conv_rule_cd] in (NC.NOTE_CONV_RULE_CD,NC.NOTE_CONV_CHG_CD) " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT  'Special' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("                    ,   M.RFA_NO CTRT_NO" ).append("\n"); 
		query.append("                    ,   'R' AS BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                    ,   M.PROP_NO" ).append("\n"); 
		query.append("                    ,   M.AMDT_SEQ" ).append("\n"); 
		query.append("                    ,   (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE M.CTRT_CUST_CNT_CD = CUST_CNT_CD AND M.CTRT_CUST_SEQ = CUST_SEQ and DELT_FLG = 'N' ) CTRT_PTY_NM" ).append("\n"); 
		query.append("                    ,   SD.SVC_SCP_CD" ).append("\n"); 
		query.append("                    ,   '' AS RT_TP" ).append("\n"); 
		query.append("                    ,   SH.DP_SEQ||'.'||SD.DP_SEQ  DP_SEQ" ).append("\n"); 
		query.append("                    ,   DECODE(NC.CHG_RULE_TP_CD,'C','Surcharge','Others') AS NOTE_CLSS_CD" ).append("\n"); 
		query.append("                    ,   NC.NOTE_CONV_CHG_CD AS CHG_CD" ).append("\n"); 
		query.append("                    ,   SD.NOTE_CTNT" ).append("\n"); 
		query.append("                    ,   NC.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("                    ,   CASE WHEN NC.CHG_RULE_TP_CD = 'C' THEN NC.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("                             WHEN NC.CHG_RULE_TP_CD = 'R' THEN NC.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                        END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("                    ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01723' AND C.INTG_CD_VAL_CTNT = NC.RT_APPL_TP_CD )  RT_APPL_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.CURR_CD" ).append("\n"); 
		query.append("                    ,   NC.RT_OP_CD" ).append("\n"); 
		query.append("                    ,   NC.FRT_RT_AMT" ).append("\n"); 
		query.append("                    ,   NC.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_SLAN_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("                    ,   NC.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_IO_GA_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_VSL_CD||NC.BKG_SKD_VOY_NO||NC.BKG_SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_SOC_FLG" ).append("\n"); 
		query.append("                    ,   '' AS BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("                    ,   NC.PAY_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("                    ,   '' AS IGN_TRF_FLG" ).append("\n"); 
		query.append("                    ,   '' AS RT_PATT_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_RAT_UT_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("                    ,   '' AS CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("                    ,   NC.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("                    ,   NC.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("                    ,   NC.BKG_YD_CD" ).append("\n"); 
		query.append("                    ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01708' AND C.INTG_CD_VAL_CTNT = NC.BKG_HNGR_BAR_TP_CD ) BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("                    ,   TO_CHAR(NC.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("                    ,   C.USR_NM" ).append("\n"); 
		query.append("                FROM    RFA_LIST M" ).append("\n"); 
		query.append("                    ,   PRI_RFA_NOTE_CONV NC" ).append("\n"); 
		query.append("                    ,   PRI_RP_SCP_NOTE_CTNT SD" ).append("\n"); 
		query.append("                    ,   PRI_RP_SCP_NOTE SH" ).append("\n"); 
		query.append("                    ,   COM_USER C" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     NC.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("                AND     NC.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_MAPG_ID = M.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = M.NOTE_CONV_TP_CD " ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = 'P' " ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_MAPG_ID = SD.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND     SD.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("                AND     SD.AMDT_SEQ = SH.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     SD.SVC_SCP_CD = SH.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     SD.NOTE_TP_CD = SH.NOTE_TP_CD" ).append("\n"); 
		query.append("                AND     SD.NOTE_SEQ = SH.NOTE_SEQ" ).append("\n"); 
		query.append("                AND     SD.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("                AND     NC.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("                AND     SD.SVC_SCP_CD = NVL(@[svc_scp_cd], SD.SVC_SCP_CD)" ).append("\n"); 
		query.append("                AND     NC.NOTE_CONV_TP_CD = NVL(@[note_conv_tp_cd], NC.NOTE_CONV_TP_CD)" ).append("\n"); 
		query.append("            #if (${note_conv_rule_cd} != '')" ).append("\n"); 
		query.append("                AND    @[note_conv_rule_cd] in (NC.NOTE_CONV_RULE_CD,NC.NOTE_CONV_CHG_CD) " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("             ) RFA" ).append("\n"); 
		query.append("             ORDER BY CTRT_NO, PROP_NO, AMDT_SEQ, CTRT_PTY_NM, SVC_SCP_CD, RT_TP, NOTE_CONV_TP_CD, DP_SEQ" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN @[curr_page] + 1" ).append("\n"); 
		query.append("           AND     @[curr_page] + 80000" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  SELECT  RFA_NO AS CTRT_NO" ).append("\n"); 
		query.append("        , 'R' AS BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("        , AMDT_SEQ" ).append("\n"); 
		query.append("        , (SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("             FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("            WHERE CUST_CNT_CD = RFA.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("              AND CUST_SEQ = RFA.CTRT_CUST_SEQ " ).append("\n"); 
		query.append("              AND DELT_FLG = 'N' ) AS CTRT_PTY_NM" ).append("\n"); 
		query.append("        , SVC_SCP_CD" ).append("\n"); 
		query.append("        , DP_SEQ" ).append("\n"); 
		query.append("        , RT_TP" ).append("\n"); 
		query.append("        , NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("        , NOTE_CTNT" ).append("\n"); 
		query.append("        , TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("        , TO_CHAR(EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("        , TO_CHAR(UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("        , (SELECT USR_NM " ).append("\n"); 
		query.append("             FROM COM_USER " ).append("\n"); 
		query.append("            WHERE USR_ID = RFA.UPD_USR_ID " ).append("\n"); 
		query.append("               AND USE_FLG = 'Y' ) AS USR_NM" ).append("\n"); 
		query.append("        ,  COUNT(DISTINCT RFA_NO) OVER (PARTITION BY 1) CTRT_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  H.RFA_NO" ).append("\n"); 
		query.append("              , M.AMDT_SEQ" ).append("\n"); 
		query.append("              , M.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              , M.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("              , S.SVC_SCP_CD" ).append("\n"); 
		query.append("              , NT.DP_SEQ||'.'||CT.DP_SEQ  DP_SEQ" ).append("\n"); 
		query.append("              ,'' AS RT_TP" ).append("\n"); 
		query.append("              , 'Special' AS NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("              , CT.NOTE_CTNT" ).append("\n"); 
		query.append("              ,   (SELECT EFF_DT" ).append("\n"); 
		query.append("                     FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("                    WHERE PROP_NO = CT.PROP_NO " ).append("\n"); 
		query.append("                      AND AMDT_SEQ = CT.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SVC_SCP_CD = CT.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("             , S.EXP_DT" ).append("\n"); 
		query.append("             , CT.UPD_DT" ).append("\n"); 
		query.append("             , CT.UPD_USR_ID" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR H" ).append("\n"); 
		query.append("            ,   PRI_RP_MN M" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_MN S" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_NOTE_CTNT CT" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_NOTE NT        " ).append("\n"); 
		query.append("        WHERE   M.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("        AND     M.AMDT_SEQ = (  SELECT  MAX ( X.AMDT_SEQ ) " ).append("\n"); 
		query.append("                                  FROM  PRI_RP_MN X " ).append("\n"); 
		query.append("                                 WHERE  X.PROP_NO = M.PROP_NO " ).append("\n"); 
		query.append("                                   AND  SYSDATE BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                                   AND  X.PROP_STS_CD  = 'A'  ) " ).append("\n"); 
		query.append("        AND     M.PROP_NO = S.PROP_NO" ).append("\n"); 
		query.append("        AND     M.AMDT_SEQ = S.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND     S.PROP_NO = CT.PROP_NO" ).append("\n"); 
		query.append("        AND     S.AMDT_SEQ = CT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     S.SVC_SCP_CD = CT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CT.NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("        AND     CT.PROP_NO = NT.PROP_NO" ).append("\n"); 
		query.append("        AND     CT.AMDT_SEQ = NT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CT.SVC_SCP_CD = NT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CT.NOTE_TP_CD = NT.NOTE_TP_CD" ).append("\n"); 
		query.append("        AND     CT.NOTE_SEQ = NT.NOTE_SEQ" ).append("\n"); 
		query.append("        AND     CT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        AND     H.CRE_DT >= TO_DATE('20170101', 'YYYYMMDD')       -- Ignore Hanjin Shipping Contract" ).append("\n"); 
		query.append("        AND     M.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- RFA MAIN에 대한 EFFECTIVE DATE (TO)" ).append("\n"); 
		query.append("        AND     M.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- RFA MAIN에 대한 EFFECTIVE DATE (FROM)" ).append("\n"); 
		query.append("        AND     NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                              FROM PRI_RFA_NOTE_CONV" ).append("\n"); 
		query.append("                             WHERE NOTE_CONV_MAPG_ID = CT.NOTE_CONV_MAPG_ID)" ).append("\n"); 
		query.append("    #if (${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     H.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${note_conv_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     'P' = @[note_conv_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("        SELECT  H.RFA_NO" ).append("\n"); 
		query.append("              , M.AMDT_SEQ" ).append("\n"); 
		query.append("              , M.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              , M.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("              , S.SVC_SCP_CD" ).append("\n"); 
		query.append("              , TO_CHAR(NT.BLET_DP_SEQ)  DP_SEQ" ).append("\n"); 
		query.append("              , DECODE(NT.FIC_RT_TP_CD,'G','Rate of Port (CY) only','Rate of Including IHC') AS RT_TP" ).append("\n"); 
		query.append("              , 'Commodity' AS NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("              , CT.NOTE_CTNT" ).append("\n"); 
		query.append("              ,   (SELECT EFF_DT" ).append("\n"); 
		query.append("                     FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("                    WHERE PROP_NO = CT.PROP_NO " ).append("\n"); 
		query.append("                      AND AMDT_SEQ = CT.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SVC_SCP_CD = CT.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("             , S.EXP_DT" ).append("\n"); 
		query.append("             , CT.UPD_DT" ).append("\n"); 
		query.append("             , CT.UPD_USR_ID" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR H" ).append("\n"); 
		query.append("            ,   PRI_RP_MN M" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_MN S" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_RT_CNOTE CT" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_RT_CMDT_HDR NT        " ).append("\n"); 
		query.append("        WHERE   M.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("        AND     M.AMDT_SEQ = (  SELECT  MAX ( X.AMDT_SEQ ) " ).append("\n"); 
		query.append("                                  FROM  PRI_RP_MN X " ).append("\n"); 
		query.append("                                 WHERE  X.PROP_NO = M.PROP_NO " ).append("\n"); 
		query.append("                                   AND  SYSDATE BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                                   AND  X.PROP_STS_CD  = 'A'  ) " ).append("\n"); 
		query.append("        AND     M.PROP_NO = S.PROP_NO" ).append("\n"); 
		query.append("        AND     M.AMDT_SEQ = S.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND     S.PROP_NO = CT.PROP_NO" ).append("\n"); 
		query.append("        AND     S.AMDT_SEQ = CT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     S.SVC_SCP_CD = CT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CT.PROP_NO = NT.PROP_NO" ).append("\n"); 
		query.append("        AND     CT.AMDT_SEQ = NT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CT.SVC_SCP_CD = NT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CT.CMDT_HDR_SEQ = NT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     CT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        AND     H.CRE_DT >= TO_DATE('20170101', 'YYYYMMDD')       -- Ignore Hanjin Shipping Contract" ).append("\n"); 
		query.append("        AND     M.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- RFA MAIN에 대한 EFFECTIVE DATE (TO)" ).append("\n"); 
		query.append("        AND     M.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- RFA MAIN에 대한 EFFECTIVE DATE (FROM)" ).append("\n"); 
		query.append("        AND     NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                              FROM PRI_RFA_NOTE_CONV" ).append("\n"); 
		query.append("                             WHERE NOTE_CONV_MAPG_ID = CT.NOTE_CONV_MAPG_ID)" ).append("\n"); 
		query.append("    #if (${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     H.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${note_conv_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     'C' = @[note_conv_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("        SELECT  H.RFA_NO" ).append("\n"); 
		query.append("              , M.AMDT_SEQ" ).append("\n"); 
		query.append("              , M.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              , M.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("              , S.SVC_SCP_CD" ).append("\n"); 
		query.append("              , NT.BLET_DP_SEQ || '.' || CT.ROUT_SEQ  DP_SEQ" ).append("\n"); 
		query.append("              , DECODE(NT.FIC_RT_TP_CD,'G','Rate of Port (CY) only','Rate of Including IHC') AS RT_TP" ).append("\n"); 
		query.append("              , 'Route' AS NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("              , CT.NOTE_CTNT" ).append("\n"); 
		query.append("              ,   (SELECT EFF_DT" ).append("\n"); 
		query.append("                     FROM PRI_RP_SCP_MN " ).append("\n"); 
		query.append("                    WHERE PROP_NO = CT.PROP_NO " ).append("\n"); 
		query.append("                      AND AMDT_SEQ = CT.N1ST_CMNC_AMDT_SEQ " ).append("\n"); 
		query.append("                      AND SVC_SCP_CD = CT.SVC_SCP_CD) EFF_DT" ).append("\n"); 
		query.append("             , S.EXP_DT" ).append("\n"); 
		query.append("             , CT.UPD_DT" ).append("\n"); 
		query.append("             , CT.UPD_USR_ID" ).append("\n"); 
		query.append("        FROM    PRI_RP_HDR H" ).append("\n"); 
		query.append("            ,   PRI_RP_MN M" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_MN S" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_RT_CMDT_RNOTE CT" ).append("\n"); 
		query.append("            ,   PRI_RP_SCP_RT_CMDT_HDR NT        " ).append("\n"); 
		query.append("        WHERE   M.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("        AND     M.AMDT_SEQ = (  SELECT  MAX ( X.AMDT_SEQ ) " ).append("\n"); 
		query.append("                                  FROM  PRI_RP_MN X " ).append("\n"); 
		query.append("                                 WHERE  X.PROP_NO = M.PROP_NO " ).append("\n"); 
		query.append("                                   AND  SYSDATE BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                                   AND  X.PROP_STS_CD  = 'A'  ) " ).append("\n"); 
		query.append("        AND     M.PROP_NO = S.PROP_NO" ).append("\n"); 
		query.append("        AND     M.AMDT_SEQ = S.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     S.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        AND     S.PROP_NO = CT.PROP_NO" ).append("\n"); 
		query.append("        AND     S.AMDT_SEQ = CT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     S.SVC_SCP_CD = CT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CT.PROP_NO = NT.PROP_NO" ).append("\n"); 
		query.append("        AND     CT.AMDT_SEQ = NT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CT.SVC_SCP_CD = NT.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CT.CMDT_HDR_SEQ = NT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     CT.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        AND     H.CRE_DT >= TO_DATE('20170101', 'YYYYMMDD')       -- Ignore Hanjin Shipping Contract" ).append("\n"); 
		query.append("        AND     M.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- RFA MAIN에 대한 EFFECTIVE DATE (TO)" ).append("\n"); 
		query.append("        AND     M.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- RFA MAIN에 대한 EFFECTIVE DATE (FROM)" ).append("\n"); 
		query.append("        AND     NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                              FROM PRI_RFA_NOTE_CONV" ).append("\n"); 
		query.append("                             WHERE NOTE_CONV_MAPG_ID = CT.NOTE_CONV_MAPG_ID)" ).append("\n"); 
		query.append("    #if (${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     H.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${note_conv_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     'R' = @[note_conv_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("    ) RFA" ).append("\n"); 
		query.append("WHERE EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- NOTE DESC에 대한 EFFECTIVE DATE (TO)" ).append("\n"); 
		query.append("  AND EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- NOTE DESC에 대한 EFFECTIVE DATE (FROM)" ).append("\n"); 
		query.append("ORDER BY RFA_NO, AMDT_SEQ, CTRT_PTY_NM, SVC_SCP_CD, RT_TP, NOTE_CONV_TP_CD, DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}