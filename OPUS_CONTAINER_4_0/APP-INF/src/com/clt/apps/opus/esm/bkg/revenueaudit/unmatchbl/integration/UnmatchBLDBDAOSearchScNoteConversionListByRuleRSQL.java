/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchScNoteConversionListByRuleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOSearchScNoteConversionListByRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UnmatchBLDBDAOSearchScNoteConversionListByRuleRSQL
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchScNoteConversionListByRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchScNoteConversionListByRuleRSQL").append("\n"); 
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
		query.append("WITH SC_LIST AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT " ).append("\n"); 
		query.append("            H.SC_NO" ).append("\n"); 
		query.append("        ,   M.PROP_NO" ).append("\n"); 
		query.append("        ,   M.AMDT_SEQ " ).append("\n"); 
		query.append("        ,   P.CTRT_PTY_NM" ).append("\n"); 
		query.append("        ,   NC.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("        ,   NC.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("    FROM    PRI_SP_HDR H" ).append("\n"); 
		query.append("        ,   PRI_SP_MN M" ).append("\n"); 
		query.append("        ,   PRI_SP_CTRT_PTY P" ).append("\n"); 
		query.append("        ,   PRI_SC_NOTE_CONV NC" ).append("\n"); 
		query.append("    WHERE   M.PROP_NO = H.PROP_NO" ).append("\n"); 
		query.append("    AND     M.AMDT_SEQ = (  SELECT  MAX ( X.AMDT_SEQ ) " ).append("\n"); 
		query.append("                            FROM    PRI_SP_MN X " ).append("\n"); 
		query.append("                            WHERE   X.PROP_NO = M.PROP_NO " ).append("\n"); 
		query.append("                            AND     SYSDATE BETWEEN X.EFF_DT AND X.EXP_DT" ).append("\n"); 
		query.append("                            AND     X.PROP_STS_CD = 'F' )" ).append("\n"); 
		query.append("    AND     M.PROP_NO = P.PROP_NO" ).append("\n"); 
		query.append("    AND     M.AMDT_SEQ = P.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     P.PRC_CTRT_PTY_TP_CD = 'C'      " ).append("\n"); 
		query.append("    AND     M.PROP_NO = NC.PROP_NO" ).append("\n"); 
		query.append("    AND     M.AMDT_SEQ = NC.AMDT_SEQ" ).append("\n"); 
		query.append("    AND     NC.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- Effective Date (To)" ).append("\n"); 
		query.append("    AND     NC.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- Effective Date (From)" ).append("\n"); 
		query.append("    AND     H.SC_NO = NVL(@[sc_no], H.SC_NO)" ).append("\n"); 
		query.append("    AND     (NC.NOTE_CONV_RULE_CD = NVL(@[note_conv_rule_cd], NC.NOTE_CONV_RULE_CD) OR NC.NOTE_CONV_CHG_CD = NVL(@[note_conv_rule_cd], NC.NOTE_CONV_CHG_CD))" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT SC_NO" ).append("\n"); 
		query.append("    ,  PROP_NO" ).append("\n"); 
		query.append("    ,  AMDT_SEQ" ).append("\n"); 
		query.append("    ,  CTRT_PTY_NM" ).append("\n"); 
		query.append("    ,  SVC_SCP_CD" ).append("\n"); 
		query.append("    ,  GEN_SPCL_RT_TP_CD" ).append("\n"); 
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
		query.append("    ,  UPD_DT" ).append("\n"); 
		query.append("    ,  USR_NM" ).append("\n"); 
		query.append("    ,  COUNT(DISTINCT SC_NO) OVER (PARTITION BY 1) SC_CNT" ).append("\n"); 
		query.append("-------------------------------------" ).append("\n"); 
		query.append("    ,  '' NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("-------------------------------------" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  'Commodity' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("            ,   M.SC_NO" ).append("\n"); 
		query.append("            ,   M.PROP_NO" ).append("\n"); 
		query.append("            ,   M.AMDT_SEQ" ).append("\n"); 
		query.append("            ,   M.CTRT_PTY_NM" ).append("\n"); 
		query.append("            ,   CN.SVC_SCP_CD" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01705' AND C.INTG_CD_VAL_CTNT = CN.GEN_SPCL_RT_TP_CD ) GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(CH.BLET_DP_SEQ) DP_SEQ" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01711' AND C.INTG_CD_VAL_CTNT = CN.NOTE_CLSS_CD ) NOTE_CLSS_CD" ).append("\n"); 
		query.append("            ,   CN.CHG_CD" ).append("\n"); 
		query.append("            ,   CN.NOTE_CTNT" ).append("\n"); 
		query.append("            ,   NC.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("            ,   CASE WHEN NC.CHG_RULE_TP_CD = 'C' THEN NC.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("                     WHEN NC.CHG_RULE_TP_CD = 'R' THEN NC.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01723' AND C.INTG_CD_VAL_CTNT = NC.RT_APPL_TP_CD ) RT_APPL_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CURR_CD" ).append("\n"); 
		query.append("            ,   NC.RT_OP_CD" ).append("\n"); 
		query.append("            ,   NC.FRT_RT_AMT" ).append("\n"); 
		query.append("            ,   NC.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SLAN_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("            ,   NC.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_IO_GA_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_VSL_CD||NC.BKG_SKD_VOY_NO||NC.BKG_SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ACT_CUST_CNT_CD||LPAD(NC.BKG_ACT_CUST_SEQ,6,0) BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SOC_FLG" ).append("\n"); 
		query.append("            ,   NC.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("            ,   NC.PAY_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("            ,   NC.RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("            ,   NC.IGN_TRF_FLG" ).append("\n"); 
		query.append("            ,   NC.RT_PATT_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("            ,   C.USR_NM" ).append("\n"); 
		query.append("        FROM    SC_LIST M" ).append("\n"); 
		query.append("            ,   PRI_SC_NOTE_CONV NC" ).append("\n"); 
		query.append("            ,   PRI_SP_SCP_RT_CNOTE CN" ).append("\n"); 
		query.append("            ,   PRI_SP_SCP_RT_CMDT_HDR CH" ).append("\n"); 
		query.append("            ,   COM_USER C" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     NC.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_MAPG_ID = M.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = M.NOTE_CONV_TP_CD " ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = 'C' " ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_MAPG_ID = CN.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        AND     CN.PROP_NO = CH.PROP_NO" ).append("\n"); 
		query.append("        AND     CN.AMDT_SEQ = CH.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CN.SVC_SCP_CD = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CN.GEN_SPCL_RT_TP_CD = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND     CN.CMDT_HDR_SEQ = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     NC.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("        AND     CN.SVC_SCP_CD = NVL(@[svc_scp_cd], CN.SVC_SCP_CD)" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = NVL(@[note_conv_tp_cd], NC.NOTE_CONV_TP_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  'Route' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("            ,   M.SC_NO" ).append("\n"); 
		query.append("            ,   M.PROP_NO" ).append("\n"); 
		query.append("            ,   M.AMDT_SEQ" ).append("\n"); 
		query.append("            ,   M.CTRT_PTY_NM" ).append("\n"); 
		query.append("            ,   RN.SVC_SCP_CD" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01705' AND C.INTG_CD_VAL_CTNT = RN.GEN_SPCL_RT_TP_CD ) GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("            ,   CH.BLET_DP_SEQ||'.'||RN.ROUT_SEQ DP_SEQ" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01711' AND C.INTG_CD_VAL_CTNT = RN.NOTE_CLSS_CD ) NOTE_CLSS_CD" ).append("\n"); 
		query.append("            ,   RN.CHG_CD" ).append("\n"); 
		query.append("            ,   RN.NOTE_CTNT" ).append("\n"); 
		query.append("            ,   NC.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("            ,   CASE WHEN NC.CHG_RULE_TP_CD = 'C' THEN NC.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("                     WHEN NC.CHG_RULE_TP_CD = 'R' THEN NC.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01723' AND C.INTG_CD_VAL_CTNT = NC.RT_APPL_TP_CD ) RT_APPL_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CURR_CD" ).append("\n"); 
		query.append("            ,   NC.RT_OP_CD" ).append("\n"); 
		query.append("            ,   NC.FRT_RT_AMT" ).append("\n"); 
		query.append("            ,   NC.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SLAN_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("            ,   NC.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_IO_GA_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_VSL_CD||NC.BKG_SKD_VOY_NO||NC.BKG_SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ACT_CUST_CNT_CD||LPAD(NC.BKG_ACT_CUST_SEQ,6,0) BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SOC_FLG" ).append("\n"); 
		query.append("            ,   NC.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("            ,   NC.PAY_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("            ,   NC.RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("            ,   NC.IGN_TRF_FLG" ).append("\n"); 
		query.append("            ,   NC.RT_PATT_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("            ,   C.USR_NM" ).append("\n"); 
		query.append("        FROM    SC_LIST M" ).append("\n"); 
		query.append("            ,   PRI_SC_NOTE_CONV NC" ).append("\n"); 
		query.append("            ,   PRI_SP_SCP_RT_CMDT_RNOTE RN" ).append("\n"); 
		query.append("            ,   PRI_SP_SCP_RT_CMDT_HDR CH" ).append("\n"); 
		query.append("            ,   COM_USER C" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     NC.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_MAPG_ID = M.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = M.NOTE_CONV_TP_CD " ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = 'R' " ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_MAPG_ID = RN.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        AND     RN.PROP_NO = CH.PROP_NO" ).append("\n"); 
		query.append("        AND     RN.AMDT_SEQ = CH.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     RN.SVC_SCP_CD = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     RN.GEN_SPCL_RT_TP_CD = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND     RN.CMDT_HDR_SEQ = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     NC.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("        AND     RN.SVC_SCP_CD = NVL(@[svc_scp_cd], RN.SVC_SCP_CD)" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = NVL(@[note_conv_tp_cd], NC.NOTE_CONV_TP_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  'Special' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("            ,   M.SC_NO" ).append("\n"); 
		query.append("            ,   M.PROP_NO" ).append("\n"); 
		query.append("            ,   M.AMDT_SEQ" ).append("\n"); 
		query.append("            ,   M.CTRT_PTY_NM" ).append("\n"); 
		query.append("            ,   SD.SVC_SCP_CD" ).append("\n"); 
		query.append("            ,   '' CTRT_PTY_NM" ).append("\n"); 
		query.append("            ,   SH.DP_SEQ||'.'||SD.DP_SEQ  DP_SEQ" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01711' AND C.INTG_CD_VAL_CTNT = SH.NOTE_CLSS_CD ) NOTE_CLSS_CD" ).append("\n"); 
		query.append("            ,   SD.CHG_CD" ).append("\n"); 
		query.append("            ,   SD.NOTE_CTNT" ).append("\n"); 
		query.append("            ,   NC.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("            ,   CASE WHEN NC.CHG_RULE_TP_CD = 'C' THEN NC.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("                     WHEN NC.CHG_RULE_TP_CD = 'R' THEN NC.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("                END CHG_RULE_DEF_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("            ,   ( SELECT C.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL C WHERE C.INTG_CD_ID = 'CD01723' AND C.INTG_CD_VAL_CTNT = NC.RT_APPL_TP_CD )  RT_APPL_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CURR_CD" ).append("\n"); 
		query.append("            ,   NC.RT_OP_CD" ).append("\n"); 
		query.append("            ,   NC.FRT_RT_AMT" ).append("\n"); 
		query.append("            ,   NC.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SLAN_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("            ,   NC.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_IO_GA_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_VSL_CD||NC.BKG_SKD_VOY_NO||NC.BKG_SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ACT_CUST_CNT_CD||LPAD(NC.BKG_ACT_CUST_SEQ,6,0) BKG_ACT_CUST_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_SOC_FLG" ).append("\n"); 
		query.append("            ,   NC.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("            ,   NC.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("            ,   NC.PAY_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("            ,   NC.RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("            ,   NC.IGN_TRF_FLG" ).append("\n"); 
		query.append("            ,   NC.RT_PATT_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("            ,   NC.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("            ,   TO_CHAR(NC.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("            ,   C.USR_NM" ).append("\n"); 
		query.append("        FROM    SC_LIST M" ).append("\n"); 
		query.append("            ,   PRI_SC_NOTE_CONV NC" ).append("\n"); 
		query.append("            ,   PRI_SP_SCP_NOTE_CTNT SD" ).append("\n"); 
		query.append("            ,   PRI_SP_SCP_NOTE SH" ).append("\n"); 
		query.append("            ,   COM_USER C" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     NC.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("        AND     NC.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_MAPG_ID = M.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = M.NOTE_CONV_TP_CD " ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = 'P' " ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_MAPG_ID = SD.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        AND     SD.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("        AND     SD.AMDT_SEQ = SH.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SD.SVC_SCP_CD = SH.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     SD.NOTE_TP_CD = SH.NOTE_TP_CD" ).append("\n"); 
		query.append("        AND     SD.NOTE_SEQ = SH.NOTE_SEQ" ).append("\n"); 
		query.append("        AND     NC.UPD_USR_ID = C.USR_ID" ).append("\n"); 
		query.append("        AND     SD.SVC_SCP_CD = NVL(@[svc_scp_cd], SD.SVC_SCP_CD)" ).append("\n"); 
		query.append("        AND     NC.NOTE_CONV_TP_CD = NVL(@[note_conv_tp_cd], NC.NOTE_CONV_TP_CD)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("ORDER BY SC_NO, PROP_NO, AMDT_SEQ, CTRT_PTY_NM, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, NOTE_CONV_TP_CD, DP_SEQ" ).append("\n"); 

	}
}