/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.01.15 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAOPriRfaNoteConvAmdVOCSQL").append("\n"); 
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
		query.append("	BKG_MAX_CGO_WGT," ).append("\n"); 
		query.append("	BKG_MIN_CGO_WGT," ).append("\n"); 
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
		query.append("    BKG_CNL_TZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    MAPG_ID," ).append("\n"); 
		query.append("    NOTE_CONV_SEQ," ).append("\n"); 
		query.append("    NOTE_CONV_TP_CD," ).append("\n"); 
		query.append("    SVC_SCP_CD," ).append("\n"); 
		query.append("    PROP_NO," ).append("\n"); 
		query.append("    AMDT_SEQ+1," ).append("\n"); 
		query.append("    CHG_RULE_TP_CD," ).append("\n"); 
		query.append("    NOTE_CONV_CHG_CD," ).append("\n"); 
		query.append("    NOTE_CONV_RULE_CD," ).append("\n"); 
		query.append("    EFF_DT," ).append("\n"); 
		query.append("    EXP_DT, " ).append("\n"); 
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
		query.append("	BKG_MAX_CGO_WGT," ).append("\n"); 
		query.append("	BKG_MIN_CGO_WGT," ).append("\n"); 
		query.append("    BKG_SOC_FLG," ).append("\n"); 
		query.append("    BKG_TS_PORT_TP_CD," ).append("\n"); 
		query.append("    BKG_TS_PORT_DEF_CD," ).append("\n"); 
		query.append("    BKG_DIR_CALL_FLG," ).append("\n"); 
		query.append("    BKG_HNGR_BAR_TP_CD," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    BKG_YD_CD," ).append("\n"); 
		query.append("    BKG_ESVC_TP_CD," ).append("\n"); 
		query.append("    BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    PRI_RFA_NOTE_CONV CONV," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            NOTE_CONV_MAPG_ID PRE_MAPG_ID," ).append("\n"); 
		query.append("            (SELECT NOTE_CONV_MAPG_ID FROM PRI_RP_SCP_NOTE_CTNT" ).append("\n"); 
		query.append("            WHERE" ).append("\n"); 
		query.append("                PROP_NO         = CTNT.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ        = @[amdt_seq]+1" ).append("\n"); 
		query.append("            AND SVC_SCP_CD      = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND NOTE_TP_CD      = CTNT.NOTE_TP_CD" ).append("\n"); 
		query.append("            AND NOTE_SEQ        = CTNT.NOTE_SEQ" ).append("\n"); 
		query.append("            AND NOTE_CTNT_SEQ   = CTNT.NOTE_CTNT_SEQ" ).append("\n"); 
		query.append("            ) MAPG_ID" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_NOTE_CTNT CTNT" ).append("\n"); 
		query.append("        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("        AND NOTE_TP_CD = 'P'" ).append("\n"); 
		query.append("		AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            NOTE_CONV_MAPG_ID PRE_MAPG_ID," ).append("\n"); 
		query.append("            (SELECT NOTE_CONV_MAPG_ID FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("            WHERE" ).append("\n"); 
		query.append("                PROP_NO             = CTNT.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ            = @[amdt_seq]+1" ).append("\n"); 
		query.append("            AND SVC_SCP_CD          = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND CMDT_HDR_SEQ        = CTNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND ROUT_SEQ            = CTNT.ROUT_SEQ" ).append("\n"); 
		query.append("            AND ROUT_NOTE_SEQ       = CTNT.ROUT_NOTE_SEQ" ).append("\n"); 
		query.append("            ) MAPG_ID" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CMDT_RNOTE CTNT" ).append("\n"); 
		query.append("        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("    SELECT 'OK'" ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("        PRI_RP_SCP_RT" ).append("\n"); 
		query.append("    WHERE   " ).append("\n"); 
		query.append("        PROP_NO             = CTNT.PROP_NO" ).append("\n"); 
		query.append("    AND AMDT_SEQ            = CTNT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SVC_SCP_CD          = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND CMDT_HDR_SEQ        = CTNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("    AND ROUT_SEQ            = CTNT.ROUT_SEQ " ).append("\n"); 
		query.append("	AND SRC_INFO_CD			<> 'AD'   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            NOTE_CONV_MAPG_ID PRE_MAPG_ID," ).append("\n"); 
		query.append("            (SELECT NOTE_CONV_MAPG_ID FROM PRI_RP_SCP_RT_CNOTE" ).append("\n"); 
		query.append("            WHERE" ).append("\n"); 
		query.append("                PROP_NO             = CTNT.PROP_NO" ).append("\n"); 
		query.append("            AND AMDT_SEQ            = @[amdt_seq]+1" ).append("\n"); 
		query.append("            AND SVC_SCP_CD          = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("            AND CMDT_HDR_SEQ        = CTNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("            AND CMDT_NOTE_SEQ       = CTNT.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("            ) MAPG_ID" ).append("\n"); 
		query.append("        FROM PRI_RP_SCP_RT_CNOTE CTNT" ).append("\n"); 
		query.append("        WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("        AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("		AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND EXISTS ( " ).append("\n"); 
		query.append("    SELECT 'OK'" ).append("\n"); 
		query.append("    FROM    " ).append("\n"); 
		query.append("        PRI_RP_SCP_RT" ).append("\n"); 
		query.append("    WHERE   " ).append("\n"); 
		query.append("        PROP_NO             = CTNT.PROP_NO" ).append("\n"); 
		query.append("    AND AMDT_SEQ            = CTNT.AMDT_SEQ" ).append("\n"); 
		query.append("    AND SVC_SCP_CD          = CTNT.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND CMDT_HDR_SEQ        = CTNT.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	AND SRC_INFO_CD			<> 'AD'   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    ) MAP" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    CONV.NOTE_CONV_MAPG_ID = MAP.PRE_MAPG_ID" ).append("\n"); 

	}
}