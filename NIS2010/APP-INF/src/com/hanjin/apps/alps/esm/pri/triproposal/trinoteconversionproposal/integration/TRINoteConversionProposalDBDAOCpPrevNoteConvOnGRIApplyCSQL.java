/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOCpPrevNoteConvOnGRIApplyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.28 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOCpPrevNoteConvOnGRIApplyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Apply시 NoteConversion카피
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOCpPrevNoteConvOnGRIApplyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOCpPrevNoteConvOnGRIApplyCSQL").append("\n"); 
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
		query.append("(NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",NOTE_CONV_SEQ" ).append("\n"); 
		query.append(",NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(",TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",TRI_PROP_NO" ).append("\n"); 
		query.append(",AMDT_SEQ" ).append("\n"); 
		query.append(",CHG_RULE_TP_CD" ).append("\n"); 
		query.append(",NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(",NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",EXP_DT" ).append("\n"); 
		query.append(",RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(",RT_APPL_TP_CD" ).append("\n"); 
		query.append(",RT_OP_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",FRT_RT_AMT" ).append("\n"); 
		query.append(",PAY_TERM_CD" ).append("\n"); 
		query.append(",BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(",BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(",BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",BKG_POR_TP_CD" ).append("\n"); 
		query.append(",BKG_POR_DEF_CD" ).append("\n"); 
		query.append(",BKG_POL_TP_CD" ).append("\n"); 
		query.append(",BKG_POL_DEF_CD" ).append("\n"); 
		query.append(",BKG_POD_TP_CD" ).append("\n"); 
		query.append(",BKG_POD_DEF_CD" ).append("\n"); 
		query.append(",BKG_DEL_TP_CD" ).append("\n"); 
		query.append(",BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(",BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append(",BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append(",BKG_SOC_FLG" ).append("\n"); 
		query.append(",BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(",BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(",BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(",BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",CONV_RAT_UT_CD" ).append("\n"); 
		query.append(",CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT C.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",A.NOTE_CONV_SEQ" ).append("\n"); 
		query.append(",A.NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(",A.TRF_PFX_CD" ).append("\n"); 
		query.append(",A.TRF_NO" ).append("\n"); 
		query.append(",A.TRI_PROP_NO" ).append("\n"); 
		query.append(",C.AMDT_SEQ" ).append("\n"); 
		query.append(",A.CHG_RULE_TP_CD" ).append("\n"); 
		query.append(",A.NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(",A.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("--        ,GREATEST(A.EFF_DT, C.EFF_DT)" ).append("\n"); 
		query.append("--        ,LEAST(A.EXP_DT, C.EXP_DT)" ).append("\n"); 
		query.append(",C.EFF_DT" ).append("\n"); 
		query.append(",C.EXP_DT" ).append("\n"); 
		query.append(",A.RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(",A.RT_APPL_TP_CD" ).append("\n"); 
		query.append(",A.RT_OP_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.FRT_RT_AMT" ).append("\n"); 
		query.append(",A.PAY_TERM_CD" ).append("\n"); 
		query.append(",A.BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",A.BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",A.BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",A.BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(",A.BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(",A.BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",A.BKG_POR_TP_CD" ).append("\n"); 
		query.append(",A.BKG_POR_DEF_CD" ).append("\n"); 
		query.append(",A.BKG_POL_TP_CD" ).append("\n"); 
		query.append(",A.BKG_POL_DEF_CD" ).append("\n"); 
		query.append(",A.BKG_POD_TP_CD" ).append("\n"); 
		query.append(",A.BKG_POD_DEF_CD" ).append("\n"); 
		query.append(",A.BKG_DEL_TP_CD" ).append("\n"); 
		query.append(",A.BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(",A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",A.BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append(",A.BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append(",A.BKG_SOC_FLG" ).append("\n"); 
		query.append(",A.BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(",A.BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(",A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(",A.BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",A.CONV_RAT_UT_CD" ).append("\n"); 
		query.append(",A.CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM PRI_TRI_NOTE_CONV A" ).append("\n"); 
		query.append(",PRI_TRI_RT B" ).append("\n"); 
		query.append(",(SELECT A.TRI_PROP_NO, A.AMDT_SEQ, A.NOTE_CONV_MAPG_ID, A.EFF_DT, A.EXP_DT" ).append("\n"); 
		query.append("FROM PRI_TRI_MN S, PRI_TRI_RT A" ).append("\n"); 
		query.append("WHERE S.TRI_PROP_NO = A.TRI_PROP_NO" ).append("\n"); 
		query.append("AND S.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND S.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND A.PROP_STS_CD = 'I'" ).append("\n"); 
		query.append("AND A.GRI_APPL_TP_CD = 'A') C" ).append("\n"); 
		query.append("WHERE A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("AND B.TRI_PROP_NO = C.TRI_PROP_NO" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = C.AMDT_SEQ - 1" ).append("\n"); 
		query.append("--     AND (A.EFF_DT BETWEEN C.EFF_DT AND C.EXP_DT OR A.EXP_DT BETWEEN C.EFF_DT AND B.EXP_DT OR" ).append("\n"); 
		query.append("--         (A.EFF_DT <= C.EFF_DT AND A.EXP_DT > C.EXP_DT))" ).append("\n"); 

	}
}