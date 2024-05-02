/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvUptCnoteVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.12.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvUptCnoteVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cnote
	  * 2012.08.21 전윤주 [CHM-201219729] S/C Amendment History Conversion Update 체크시 속도 개선
	  * 기존 쿼리에서 index를 사용하지 못하던 부분을 상수로 바인딩하여 인덱스로 처리할 수 있도록 변경
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvUptCnoteVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvUptCnoteVOCSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("       NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     , NOTE_CONV_SEQ" ).append("\n"); 
		query.append("     , NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , CHG_RULE_TP_CD" ).append("\n"); 
		query.append("     , NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     , NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , RT_APPL_TP_CD" ).append("\n"); 
		query.append("     , RT_OP_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , FRT_RT_AMT" ).append("\n"); 
		query.append("     , PAY_TERM_CD" ).append("\n"); 
		query.append("     , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     , BKG_RAT_UT_CD" ).append("\n"); 
		query.append("     , BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("     , BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , BKG_POR_TP_CD" ).append("\n"); 
		query.append("     , BKG_POR_DEF_CD" ).append("\n"); 
		query.append("     , BKG_POL_TP_CD" ).append("\n"); 
		query.append("     , BKG_POL_DEF_CD" ).append("\n"); 
		query.append("     , BKG_POD_TP_CD" ).append("\n"); 
		query.append("     , BKG_POD_DEF_CD" ).append("\n"); 
		query.append("     , BKG_DEL_TP_CD" ).append("\n"); 
		query.append("     , BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("     , BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("     , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , BKG_SLAN_CD" ).append("\n"); 
		query.append("     , BKG_VSL_CD" ).append("\n"); 
		query.append("     , BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("     , BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("     , BKG_SOC_FLG" ).append("\n"); 
		query.append("     , BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("     , BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("     , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     , BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("     , CONV_RAT_UT_CD" ).append("\n"); 
		query.append("     , CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("     , CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , NOTE_HDR_SEQ" ).append("\n"); 
		query.append("     , RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("     , BKG_IO_GA_CD" ).append("\n"); 
		query.append("     , BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("     , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("     , RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("     , RT_PATT_TP_CD" ).append("\n"); 
		query.append("     , IGN_TRF_FLG" ).append("\n"); 
		query.append("	 , BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,NOTE_CONV_SEQ" ).append("\n"); 
		query.append("      ,NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,PROP_NO" ).append("\n"); 
		query.append("      ,AMDT_SEQ " ).append("\n"); 
		query.append("      ,CHG_RULE_TP_CD" ).append("\n"); 
		query.append("     , NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("     , NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("     , EFF_DT" ).append("\n"); 
		query.append("     , EXP_DT" ).append("\n"); 
		query.append("     , RT_APPL_TP_CD" ).append("\n"); 
		query.append("     , RT_OP_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , FRT_RT_AMT" ).append("\n"); 
		query.append("     , PAY_TERM_CD" ).append("\n"); 
		query.append("     , GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("     , BKG_RAT_UT_CD" ).append("\n"); 
		query.append("     , BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("     , BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("     , BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("     , BKG_POR_TP_CD" ).append("\n"); 
		query.append("     , BKG_POR_DEF_CD" ).append("\n"); 
		query.append("     , BKG_POL_TP_CD" ).append("\n"); 
		query.append("     , BKG_POL_DEF_CD" ).append("\n"); 
		query.append("     , BKG_POD_TP_CD" ).append("\n"); 
		query.append("     , BKG_POD_DEF_CD" ).append("\n"); 
		query.append("     , BKG_DEL_TP_CD" ).append("\n"); 
		query.append("     , BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("     , BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("     , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("     , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , BKG_SLAN_CD" ).append("\n"); 
		query.append("     , BKG_VSL_CD" ).append("\n"); 
		query.append("     , BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("     , BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("     , BKG_SOC_FLG" ).append("\n"); 
		query.append("     , BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("     , BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("     , BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("     , BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("     , BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("     , CONV_RAT_UT_CD" ).append("\n"); 
		query.append("     , CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("     , CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("     , CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("     , CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("     , CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("     , CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT     " ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , NOTE_HDR_SEQ" ).append("\n"); 
		query.append("     , RULE_APPL_CHG_TP_CD    " ).append("\n"); 
		query.append("     , BKG_IO_GA_CD" ).append("\n"); 
		query.append("     , BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("     , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("     , RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("     , RT_PATT_TP_CD" ).append("\n"); 
		query.append("     , IGN_TRF_FLG" ).append("\n"); 
		query.append("	 , BKG_NO" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("           MN.N_MAP_ID NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("          ,CONV.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("          ,CONV.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("          ,CONV.SVC_SCP_CD" ).append("\n"); 
		query.append("          ,CONV.PROP_NO" ).append("\n"); 
		query.append("          ,CONV.AMDT_SEQ + 1 AMDT_SEQ" ).append("\n"); 
		query.append("          ,CONV.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("         , CONV.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("         , CONV.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("          ,CASE AMD_FLG WHEN 'N' THEN CONV.EFF_DT --어멘드 이전" ).append("\n"); 
		query.append("           ELSE DECODE(SIGN(CONV.EFF_DT - MN.N_SCP_EFF_DT), -1, MN.N_SCP_EFF_DT,CONV.EFF_DT)" ).append("\n"); 
		query.append("           END EFF_DT" ).append("\n"); 
		query.append("          ,CASE WHEN MN.ADD_EXP_DT_FLG = 'Y' THEN --EXP_DT가 증가했다" ).append("\n"); 
		query.append("              CASE WHEN CONV.EXP_DT = MN.EXP_DT THEN MN.N_EXP_DT " ).append("\n"); 
		query.append("              ELSE" ).append("\n"); 
		query.append("                  DECODE(SIGN(CONV.EXP_DT - MN.N_EXP_DT), -1,  CONV.EXP_DT, MN.N_EXP_DT)" ).append("\n"); 
		query.append("              END                    " ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("              DECODE(SIGN(MN.N_EXP_DT - CONV.EXP_DT), -1, MN.N_EXP_DT, CONV.EXP_DT)" ).append("\n"); 
		query.append("           END EXP_DT" ).append("\n"); 
		query.append("         , CONV.RT_APPL_TP_CD" ).append("\n"); 
		query.append("         , CONV.RT_OP_CD" ).append("\n"); 
		query.append("         , CONV.CURR_CD" ).append("\n"); 
		query.append("         , CONV.FRT_RT_AMT" ).append("\n"); 
		query.append("         , CONV.PAY_TERM_CD" ).append("\n"); 
		query.append("         , CONV.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("         , CONV.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("         , CONV.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("         , CONV.BKG_SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("         , CONV.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("         , CONV.BKG_POR_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("         , CONV.BKG_POL_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("         , CONV.BKG_POD_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("         , CONV.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("         , CONV.BKG_ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("         , CONV.BKG_DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("         , CONV.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("         , CONV.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("         , CONV.BKG_SLAN_CD" ).append("\n"); 
		query.append("         , CONV.BKG_VSL_CD" ).append("\n"); 
		query.append("         , CONV.BKG_SKD_VOY_NO" ).append("\n"); 
		query.append("         , CONV.BKG_SKD_DIR_CD" ).append("\n"); 
		query.append("         , CONV.BKG_SOC_FLG" ).append("\n"); 
		query.append("         , CONV.BKG_ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("         , CONV.BKG_ACT_CUST_SEQ" ).append("\n"); 
		query.append("         , CONV.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("         , CONV.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("         , CONV.BKG_MST_HBL_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("         , CONV.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_CMDT_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_CMDT_DEF_CD" ).append("\n"); 
		query.append("         , CONV.CONV_ORG_LOC_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_ORG_LOC_DEF_CD" ).append("\n"); 
		query.append("         , CONV.CONV_ORG_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_ORG_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("         , CONV.CONV_DEST_VIA_LOC_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_DEST_VIA_LOC_DEF_CD" ).append("\n"); 
		query.append("         , CONV.CONV_DEST_LOC_TP_CD" ).append("\n"); 
		query.append("         , CONV.CONV_DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("         , CONV.CONV_PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("         , CONV.CONV_PRC_DE_TERM_CD" ).append("\n"); 
		query.append("         , CONV.CRE_USR_ID" ).append("\n"); 
		query.append("         , CONV.CRE_DT" ).append("\n"); 
		query.append("         , CONV.UPD_USR_ID" ).append("\n"); 
		query.append("         , CONV.UPD_DT" ).append("\n"); 
		query.append("         , CONV.NOTE_HDR_SEQ" ).append("\n"); 
		query.append("         , CONV.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("         , CONV.BKG_IO_GA_CD" ).append("\n"); 
		query.append("         , CONV.BKG_CNL_TZ_CD" ).append("\n"); 
		query.append("         , CONV.BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("         , CONV.RULE_APPL_CHG_CD" ).append("\n"); 
		query.append("         , CONV.RT_PATT_TP_CD" ).append("\n"); 
		query.append("         , CONV.IGN_TRF_FLG" ).append("\n"); 
		query.append("		 , CONV.BKG_NO" ).append("\n"); 
		query.append("    FROM PRI_SC_NOTE_CONV CONV" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("        SELECT N_NOTE.NOTE_CONV_MAPG_ID N_MAP_ID" ).append("\n"); 
		query.append("              ,DECODE(N_NOTE.N1ST_CMNC_AMDT_SEQ,@[amdt_seq] + 1, 'Y', 'N') AMD_FLG" ).append("\n"); 
		query.append("              ,N_NOTE.N1ST_CMNC_AMDT_SEQ N_N1ST_SEQ" ).append("\n"); 
		query.append("              ,NOTE.NOTE_CONV_MAPG_ID MAP_ID" ).append("\n"); 
		query.append("              ,N_MN.CTRT_EFF_DT N_EFF_DT" ).append("\n"); 
		query.append("              ,N_MN.CTRT_EXP_DT N_EXP_DT" ).append("\n"); 
		query.append("              ,MN.CTRT_EFF_DT EFF_DT" ).append("\n"); 
		query.append("              ,MN.CTRT_EXP_DT EXP_DT" ).append("\n"); 
		query.append("              ,DECODE(SIGN(MN.CTRT_EXP_DT - N_MN.CTRT_EXP_DT), -1,'Y','N') ADD_EXP_DT_FLG" ).append("\n"); 
		query.append("              ,N_SCP.EFF_DT N_SCP_EFF_DT" ).append("\n"); 
		query.append("        FROM PRI_SP_SCP_RT_CNOTE NOTE" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_RT_CNOTE N_NOTE" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_DUR N_MN" ).append("\n"); 
		query.append("            ,PRI_SP_SCP_DUR MN    " ).append("\n"); 
		query.append("            ,PRI_SP_SCP_MN  N_SCP" ).append("\n"); 
		query.append("        WHERE N_MN.PROP_NO           = MN.PROP_NO" ).append("\n"); 
		query.append("--        AND N_MN.AMDT_SEQ            = MN.AMDT_SEQ + 1" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ              = @[amdt_seq]" ).append("\n"); 
		query.append("        AND N_MN.SVC_SCP_CD          = MN.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND N_MN.PROP_NO             = N_NOTE.PROP_NO" ).append("\n"); 
		query.append("        AND N_MN.AMDT_SEQ            = N_NOTE.AMDT_SEQ" ).append("\n"); 
		query.append("        AND N_MN.SVC_SCP_CD          = N_NOTE.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND N_NOTE.PROP_NO           = NOTE.PROP_NO" ).append("\n"); 
		query.append("--        AND N_NOTE.AMDT_SEQ          = NOTE.AMDT_SEQ + 1" ).append("\n"); 
		query.append("        AND NOTE.AMDT_SEQ            = @[amdt_seq]" ).append("\n"); 
		query.append("        AND N_NOTE.SVC_SCP_CD        = NOTE.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND N_NOTE.GEN_SPCL_RT_TP_CD = NOTE.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND N_NOTE.CMDT_HDR_SEQ      = NOTE.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND N_NOTE.CMDT_NOTE_SEQ     = NOTE.CMDT_NOTE_SEQ" ).append("\n"); 
		query.append("        AND N_MN.PROP_NO         = N_SCP.PROP_NO" ).append("\n"); 
		query.append("        AND N_MN.AMDT_SEQ        = N_SCP.AMDT_SEQ" ).append("\n"); 
		query.append("        AND N_MN.SVC_SCP_CD      = N_SCP.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND N_MN.PROP_NO             = @[prop_no]" ).append("\n"); 
		query.append("        AND N_MN.AMDT_SEQ            = @[amdt_seq] + 1" ).append("\n"); 
		query.append("    )MN" ).append("\n"); 
		query.append("    WHERE MN.MAP_ID = CONV.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE EFF_DT <= EXP_DT " ).append("\n"); 
		query.append("OR NOTE_CONV_RULE_CD = 'APP'" ).append("\n"); 

	}
}