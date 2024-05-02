/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvAmdBasicVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAOPriRfaNoteConvAmdBasicVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master RFA에서 가져온 Note Conversion 데이터를 Basic Rate에 넣는다.
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPriRfaNoteConvAmdBasicVOCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvAmdBasicVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RFA_NOTE_CONV(" ).append("\n"); 
		query.append("    NOTE_CONV_MAPG_ID," ).append("\n"); 
		query.append("    NOTE_CONV_SEQ," ).append("\n"); 
		query.append("    NOTE_CONV_TP_CD," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ," ).append("\n"); 
		query.append("    CHG_RULE_TP_CD," ).append("\n"); 
		query.append("    NOTE_CONV_CHG_CD," ).append("\n"); 
		query.append("    NOTE_CONV_RULE_CD," ).append("\n"); 
		query.append("    EFF_DT," ).append("\n"); 
		query.append("    EXP_DT," ).append("\n"); 
		query.append("    RT_APPL_TP_CD," ).append("\n"); 
		query.append("    RT_OP_CD," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    FRT_RT_AMT," ).append("\n"); 
		query.append("    PAY_TERM_CD," ).append("\n"); 
		query.append("    BKG_RAT_UT_CD," ).append("\n"); 
		query.append("    BKG_PRC_CGO_TP_CD," ).append("\n"); 
		query.append("    BKG_IMDG_CLSS_CD," ).append("\n"); 
		query.append("    BKG_CMDT_TP_CD," ).append("\n"); 
		query.append("    BKG_CMDT_DEF_CD," ).append("\n"); 
		query.append("    BKG_POR_TP_CD," ).append("\n"); 
		query.append("    BKG_POR_DEF_CD," ).append("\n"); 
		query.append("    BKG_POL_TP_CD," ).append("\n"); 
		query.append("    BKG_POL_DEF_CD," ).append("\n"); 
		query.append("    BKG_POD_TP_CD," ).append("\n"); 
		query.append("    BKG_POD_DEF_CD," ).append("\n"); 
		query.append("    BKG_DEL_TP_CD," ).append("\n"); 
		query.append("    BKG_DEL_DEF_CD," ).append("\n"); 
		query.append("    BKG_SLAN_CD," ).append("\n"); 
		query.append("    BKG_VSL_CD," ).append("\n"); 
		query.append("    BKG_SKD_VOY_NO," ).append("\n"); 
		query.append("    BKG_SKD_DIR_CD," ).append("\n"); 
		query.append("    BKG_MAX_CGO_WGT," ).append("\n"); 
		query.append("    BKG_MIN_CGO_WGT," ).append("\n"); 
		query.append("    BKG_SOC_FLG," ).append("\n"); 
		query.append("    BKG_TS_PORT_TP_CD," ).append("\n"); 
		query.append("    BKG_TS_PORT_DEF_CD," ).append("\n"); 
		query.append("    BKG_DIR_CALL_FLG," ).append("\n"); 
		query.append("    BKG_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    BKG_YD_CD," ).append("\n"); 
		query.append("    BKG_ESVC_TP_CD," ).append("\n"); 
		query.append("    MST_RFA_ROUT_ID," ).append("\n"); 
		query.append("    PRC_PROG_STS_CD," ).append("\n"); 
		query.append("    SRC_INFO_CD," ).append("\n"); 
		query.append("    N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH MASTER_RFA_INFO AS (" ).append("\n"); 
		query.append("    SELECT MN.PROP_NO, MAX(MN.AMDT_SEQ) AS AMDT_SEQ, SVC_SCP_CD" ).append("\n"); 
		query.append("       FROM PRI_RP_MN MN, PRI_RP_SCP_RT_CMDT_ROUT ROUT" ).append("\n"); 
		query.append("      WHERE MN.PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = @[mst_rfa_no]) -- Mst RFA No" ).append("\n"); 
		query.append("        AND MN.PROP_NO = ROUT.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = ROUT.AMDT_SEQ" ).append("\n"); 
		query.append("        AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("      GROUP BY MN.PROP_NO, SVC_SCP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     MAPG_ID," ).append("\n"); 
		query.append("     CONV.NOTE_CONV_SEQ," ).append("\n"); 
		query.append("     CONV.NOTE_CONV_TP_CD," ).append("\n"); 
		query.append("     CONV.SVC_SCP_CD," ).append("\n"); 
		query.append("     @[prop_no] AS PROP_NO, --Basic no." ).append("\n"); 
		query.append("     @[amdt_seq]+1, -- basic amdt_seq" ).append("\n"); 
		query.append("     CONV.CHG_RULE_TP_CD," ).append("\n"); 
		query.append("     CONV.NOTE_CONV_CHG_CD," ).append("\n"); 
		query.append("     CONV.NOTE_CONV_RULE_CD," ).append("\n"); 
		query.append("     TO_DATE(@[eff_dt],'yyyy-MM-dd') EFF_DT," ).append("\n"); 
		query.append("     TO_DATE(@[exp_dt],'yyyy-MM-dd') EXP_DT," ).append("\n"); 
		query.append("     CONV.RT_APPL_TP_CD," ).append("\n"); 
		query.append("     CONV.RT_OP_CD," ).append("\n"); 
		query.append("     CONV.CURR_CD," ).append("\n"); 
		query.append("     CONV.FRT_RT_AMT," ).append("\n"); 
		query.append("     CONV.PAY_TERM_CD," ).append("\n"); 
		query.append("     CONV.BKG_RAT_UT_CD," ).append("\n"); 
		query.append("     CONV.BKG_PRC_CGO_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_IMDG_CLSS_CD," ).append("\n"); 
		query.append("     CONV.BKG_CMDT_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_CMDT_DEF_CD," ).append("\n"); 
		query.append("     CONV.BKG_POR_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_POR_DEF_CD," ).append("\n"); 
		query.append("     CONV.BKG_POL_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_POL_DEF_CD," ).append("\n"); 
		query.append("     CONV.BKG_POD_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_POD_DEF_CD," ).append("\n"); 
		query.append("     CONV.BKG_DEL_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_DEL_DEF_CD," ).append("\n"); 
		query.append("     CONV.BKG_SLAN_CD," ).append("\n"); 
		query.append("     CONV.BKG_VSL_CD," ).append("\n"); 
		query.append("     CONV.BKG_SKD_VOY_NO," ).append("\n"); 
		query.append("     CONV.BKG_SKD_DIR_CD," ).append("\n"); 
		query.append("     CONV.BKG_MAX_CGO_WGT," ).append("\n"); 
		query.append("     CONV.BKG_MIN_CGO_WGT," ).append("\n"); 
		query.append("     CONV.BKG_SOC_FLG," ).append("\n"); 
		query.append("     CONV.BKG_TS_PORT_TP_CD," ).append("\n"); 
		query.append("     CONV.BKG_TS_PORT_DEF_CD," ).append("\n"); 
		query.append("     CONV.BKG_DIR_CALL_FLG," ).append("\n"); 
		query.append("     CONV.BKG_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("     @[cre_usr_id]," ).append("\n"); 
		query.append("     SYSDATE," ).append("\n"); 
		query.append("     @[upd_usr_id]," ).append("\n"); 
		query.append("     SYSDATE," ).append("\n"); 
		query.append("     CONV.BKG_YD_CD," ).append("\n"); 
		query.append("     CONV.BKG_ESVC_TP_CD," ).append("\n"); 
		query.append("     @[mst_rfa_no] ||'_'|| LPAD(MST_INFO.AMDT_SEQ, 3, '0') ||'_'|| LPAD(MST_ROUT_SEQ, 3, '0') MST_RFA_ROUT_ID," ).append("\n"); 
		query.append("--     CONV.PRC_PROG_STS_CD," ).append("\n"); 
		query.append("     DECODE(CONV.SRC_INFO_CD, 'AM', 'I', 'AD', 'I', CONV.PRC_PROG_STS_CD) AS PRC_PROG_STS_CD," ).append("\n"); 
		query.append("     CONV.SRC_INFO_CD," ).append("\n"); 
		query.append("--     CONV.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("     CASE WHEN CONV.SRC_INFO_CD IN ('AM', 'AD') THEN TO_NUMBER(@[amdt_seq])+1" ).append("\n"); 
		query.append("          ELSE TO_NUMBER(@[amdt_seq])" ).append("\n"); 
		query.append("     END AS N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("FROM MASTER_RFA_INFO MST_INFO," ).append("\n"); 
		query.append("    PRI_RFA_NOTE_CONV CONV," ).append("\n"); 
		query.append("    -- Master에서 가져올 데이터의 note id와 입력할 basic의 mapping id" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            NOTE_CONV_MAPG_ID PRE_MAPG_ID," ).append("\n"); 
		query.append("            ROUT_SEQ AS MST_ROUT_SEQ," ).append("\n"); 
		query.append("            (SELECT NOTE_CONV_MAPG_ID FROM PRI_RP_SCP_RT_CMDT_RNOTE A, PRI_RP_SCP_RT_CMDT_ROUT B" ).append("\n"); 
		query.append("            WHERE" ).append("\n"); 
		query.append("                A.PROP_NO             = B.PROP_NO" ).append("\n"); 
		query.append("            AND A.AMDT_SEQ            = B.AMDT_SEQ" ).append("\n"); 
		query.append("            AND A.SVC_SCP_CD          = B.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND A.CMDT_HDR_SEQ        = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND A.ROUT_SEQ            = B.ROUT_SEQ" ).append("\n"); 
		query.append("            AND A.PROP_NO             = @[prop_no] -- Basic RFA" ).append("\n"); 
		query.append("            AND A.AMDT_SEQ            = @[amdt_seq]+1" ).append("\n"); 
		query.append("            AND A.SVC_SCP_CD          = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND A.CMDT_HDR_SEQ        = CTNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND B.MST_ROUT_ID         = CTNT.ROUT_SEQ" ).append("\n"); 
		query.append("            AND A.ROUT_NOTE_SEQ       = CTNT.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("            ) MAPG_ID -- Basic RFA's NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CMDT_RNOTE CTNT, MASTER_RFA_INFO MST_INFO" ).append("\n"); 
		query.append("        WHERE CTNT.PROP_NO = MST_INFO.PROP_NO" ).append("\n"); 
		query.append("        AND CTNT.AMDT_SEQ = MST_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("        -- exists in Basic RFA" ).append("\n"); 
		query.append("        AND EXISTS (" ).append("\n"); 
		query.append("            SELECT 'OK'" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("                PRI_RP_SCP_RT_CMDT_ROUT" ).append("\n"); 
		query.append("            WHERE" ).append("\n"); 
		query.append("                PROP_NO             = @[prop_no] -- Basic RFA" ).append("\n"); 
		query.append("            AND AMDT_SEQ            = @[amdt_seq]+1" ).append("\n"); 
		query.append("            AND SVC_SCP_CD          = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND CMDT_HDR_SEQ        = CTNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND MST_ROUT_ID         = CTNT.ROUT_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) MAP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CONV.NOTE_CONV_MAPG_ID = MAP.PRE_MAPG_ID" ).append("\n"); 
		query.append("   -- Master" ).append("\n"); 
		query.append("   AND CONV.PROP_NO = MST_INFO.PROP_NO" ).append("\n"); 
		query.append("   AND CONV.AMDT_SEQ = MST_INFO.AMDT_SEQ" ).append("\n"); 
		query.append("   AND CONV.SVC_SCP_CD = MST_INFO.SVC_SCP_CD" ).append("\n"); 
		query.append("   AND CONV.SRC_INFO_CD <> 'AD'" ).append("\n"); 

	}
}