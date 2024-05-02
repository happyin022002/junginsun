/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOCpPrevNoteConvOnAmendCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.01.15 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYEONGMI KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOCpPrevNoteConvOnAmendCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Amend시 NoteConversion카피
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOCpPrevNoteConvOnAmendCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOCpPrevNoteConvOnAmendCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_TRI_NOTE_CONV" ).append("\n"); 
		query.append("  (NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("  ,NOTE_CONV_SEQ" ).append("\n"); 
		query.append("  ,NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("  ,TRF_PFX_CD" ).append("\n"); 
		query.append("  ,TRF_NO" ).append("\n"); 
		query.append("  ,TRI_PROP_NO" ).append("\n"); 
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
		query.append("  ,BKG_RAT_UT_CD" ).append("\n"); 
		query.append("  ,BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("  ,BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("  ,BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("  ,BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("  ,BKG_POR_TP_CD" ).append("\n"); 
		query.append("  ,BKG_POR_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_POL_TP_CD" ).append("\n"); 
		query.append("  ,BKG_POL_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_POD_TP_CD" ).append("\n"); 
		query.append("  ,BKG_POD_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_DEL_TP_CD" ).append("\n"); 
		query.append("  ,BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("  ,BKG_DE_TERM_CD" ).append("\n"); 
		query.append("  ,BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("  ,BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("  ,BKG_SOC_FLG" ).append("\n"); 
		query.append("  ,BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("  ,BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("  ,BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("  ,BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("  ,CONV_RAT_UT_CD" ).append("\n"); 
		query.append("  ,CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,BKG_ESVC_TP_CD)" ).append("\n"); 
		query.append("  SELECT (SELECT NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("            FROM PRI_TRI_RT S" ).append("\n"); 
		query.append("           WHERE S.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("             AND S.AMDT_SEQ = B.AMDT_SEQ + 1)" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_SEQ" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append("        ,A.TRF_PFX_CD" ).append("\n"); 
		query.append("        ,A.TRF_NO" ).append("\n"); 
		query.append("        ,A.TRI_PROP_NO" ).append("\n"); 
		query.append("        ,A.AMDT_SEQ + 1" ).append("\n"); 
		query.append("        ,A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append("        ,A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("--        ,GREATEST(A.EFF_DT, TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("--        ,LEAST(A.EXP_DT, B.EXP_DT)" ).append("\n"); 
		query.append("        ,TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        ,B.EXP_DT" ).append("\n"); 
		query.append("        ,A.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append("        ,A.RT_APPL_TP_CD" ).append("\n"); 
		query.append("        ,A.RT_OP_CD" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.FRT_RT_AMT" ).append("\n"); 
		query.append("        ,A.PAY_TERM_CD" ).append("\n"); 
		query.append("        ,A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append("        ,A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("        ,A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append("        ,A.BKG_POR_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_POR_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_POL_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_POL_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_POD_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_POD_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("        ,A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("        ,A.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append("        ,A.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append("        ,A.BKG_SOC_FLG" ).append("\n"); 
		query.append("        ,A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append("        ,A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append("        ,A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("        ,A.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("        ,A.CONV_RAT_UT_CD" ).append("\n"); 
		query.append("        ,A.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("    FROM PRI_TRI_NOTE_CONV A, PRI_TRI_RT B" ).append("\n"); 
		query.append("   WHERE A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("     AND B.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("     AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("--     AND (A.EFF_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYY-MM-DD') AND B.EXP_DT" ).append("\n"); 
		query.append("--         OR A.EXP_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYY-MM-DD') AND B.EXP_DT OR" ).append("\n"); 
		query.append("--         (A.EFF_DT <= TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYY-MM-DD') AND A.EXP_DT > B.EXP_DT))" ).append("\n"); 

	}
}