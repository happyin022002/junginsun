/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOCpPrevNoteCasCNoteCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.05.24 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNGMIN CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOCpPrevNoteCasCNoteCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amend Cancel시 이전 Seq Conversion을 Copy
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOCpPrevNoteCasCNoteCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_note_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOCpPrevNoteCasCNoteCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SC_NOTE_CONV" ).append("\n"); 
		query.append("  (NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("  ,NOTE_CONV_SEQ" ).append("\n"); 
		query.append("  ,NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("  ,SVC_SCP_CD" ).append("\n"); 
		query.append("  ,NOTE_HDR_SEQ" ).append("\n"); 
		query.append("  ,PROP_NO" ).append("\n"); 
		query.append("  ,AMDT_SEQ" ).append("\n"); 
		query.append("  ,CHG_RULE_TP_CD" ).append("\n"); 
		query.append("  ,NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("  ,NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("  ,EFF_DT" ).append("\n"); 
		query.append("  ,EXP_DT" ).append("\n"); 
		query.append("  ,RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("  ,RT_APPL_TP_CD" ).append("\n"); 
		query.append("  ,RT_OP_CD" ).append("\n"); 
		query.append("  ,CURR_CD" ).append("\n"); 
		query.append("  ,FRT_RT_AMT" ).append("\n"); 
		query.append("  ,PAY_TERM_CD" ).append("\n"); 
		query.append("  ,GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("  ,BKG_RAT_UT_CD" ).append("\n"); 
		query.append("  ,BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("  ,BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("  ,BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("  ,BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("  ,BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("  ,BKG_POR_TP_CD" ).append("\n"); 
		query.append("  ,BKG_POR_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_POL_TP_CD" ).append("\n"); 
		query.append("  ,BKG_POL_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_POD_TP_CD" ).append("\n"); 
		query.append("  ,BKG_POD_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_DEL_TP_CD" ).append("\n"); 
		query.append("  ,BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("  ,BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("  ,BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("  ,BKG_DE_TERM_CD" ).append("\n"); 
		query.append("  ,BKG_SLAN_CD" ).append("\n"); 
		query.append("  ,BKG_VSL_CD" ).append("\n"); 
		query.append("  ,BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("  ,BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("  ,BKG_SOC_FLG" ).append("\n"); 
		query.append("  ,BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("  ,BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("  ,BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("  ,BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("  ,BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("  ,CONV_RAT_UT_CD" ).append("\n"); 
		query.append("  ,CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("  ,CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("  ,CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("  ,CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("  ,CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("  ,CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("  ,CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("  ,CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("  ,CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("  ,CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("  ,CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("  ,CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("  ,CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,BKG_IO_GA_CD" ).append("\n"); 
		query.append("  ,BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("  ,BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT (SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CNOTE S" ).append("\n"); 
		query.append("           WHERE S.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("             AND S.AMDT_SEQ = B.AMDT_SEQ + 1" ).append("\n"); 
		query.append("             AND S.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("             AND S.GEN_SPCL_RT_TP_CD = B.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("             AND S.CMDT_HDR_SEQ = B.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("             AND S.CMDT_NOTE_SEQ = B.CMDT_NOTE_SEQ)" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("        ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("        ,A.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("        ,A.PROP_NO" ).append("\n"); 
		query.append("        ,A.AMDT_SEQ + 1" ).append("\n"); 
		query.append("        ,A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("        ,A.EFF_DT" ).append("\n"); 
		query.append("        ,DECODE(A.EXP_DT" ).append("\n"); 
		query.append("               ,C.EXP_DT" ).append("\n"); 
		query.append("               ,(SELECT S.EXP_DT" ).append("\n"); 
		query.append("                   FROM PRI_SP_SCP_MN S" ).append("\n"); 
		query.append("                  WHERE S.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                    AND S.AMDT_SEQ = B.AMDT_SEQ + 1" ).append("\n"); 
		query.append("                    AND S.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("                    AND ROWNUM = 1)" ).append("\n"); 
		query.append("               ,A.EXP_DT)" ).append("\n"); 
		query.append("        ,A.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("        ,A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("        ,A.RT_OP_CD" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.FRT_RT_AMT" ).append("\n"); 
		query.append("        ,A.PAY_TERM_CD" ).append("\n"); 
		query.append("        ,A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("        ,A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ,A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("        ,A.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("        ,A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,A.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("        ,A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("        ,A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("        ,A.BKG_SLAN_CD" ).append("\n"); 
		query.append("        ,A.BKG_VSL_CD" ).append("\n"); 
		query.append("        ,A.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.BKG_SOC_FLG" ).append("\n"); 
		query.append("        ,A.BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("        ,A.BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("        ,A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("        ,A.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("        ,A.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("        ,A.CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("        ,A.CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("        ,A.CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("        ,A.CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("        ,A.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("        ,A.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,A.CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,A.UPD_DT" ).append("\n"); 
		query.append("  		,A.BKG_IO_GA_CD" ).append("\n"); 
		query.append("  		,A.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("  		,A.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("    FROM PRI_SC_NOTE_CONV A, PRI_SP_SCP_RT_CNOTE B, PRI_SP_SCP_MN C" ).append("\n"); 
		query.append("   WHERE B.NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     AND B.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("     AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("     AND B.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND B.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("     AND B.AMDT_SEQ = @[amdt_seq] - 1" ).append("\n"); 
		query.append("     AND B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == '0') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '1') " ).append("\n"); 
		query.append("     AND B.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("     AND B.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("     AND B.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("     AND B.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("     AND B.CMDT_NOTE_SEQ = @[cmdt_note_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}