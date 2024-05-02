/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOPriTriNoteConvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.12.08 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOPriTriNoteConvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 실질적인 VO 객체로 사용됨
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOPriTriNoteConvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOPriTriNoteConvListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' AMDT_SEQ" ).append("\n"); 
		query.append(",'' BKG_CMDT_DEF_CD" ).append("\n"); 
		query.append(",'' BKG_CMDT_TP_CD" ).append("\n"); 
		query.append(",'' BKG_DEL_DEF_CD" ).append("\n"); 
		query.append(",'' BKG_DEL_TP_CD" ).append("\n"); 
		query.append(",'' BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",'' BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append(",'' BKG_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",'' BKG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",'' BKG_MAX_CGO_WGT" ).append("\n"); 
		query.append(",'' BKG_MIN_CGO_WGT" ).append("\n"); 
		query.append(",'' BKG_POD_DEF_CD" ).append("\n"); 
		query.append(",'' BKG_POD_TP_CD" ).append("\n"); 
		query.append(",'' BKG_POL_DEF_CD" ).append("\n"); 
		query.append(",'' BKG_POL_TP_CD" ).append("\n"); 
		query.append(",'' BKG_POR_DEF_CD" ).append("\n"); 
		query.append(",'' BKG_POR_TP_CD" ).append("\n"); 
		query.append(",'' BKG_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",'' BKG_RAT_UT_CD" ).append("\n"); 
		query.append(",'' BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",'' BKG_SOC_FLG" ).append("\n"); 
		query.append(",'' BKG_TS_PORT_DEF_CD" ).append("\n"); 
		query.append(",'' BKG_TS_PORT_TP_CD" ).append("\n"); 
		query.append(",'' BKG_USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",'' CHG_RULE_TP_CD" ).append("\n"); 
		query.append(",'' CONV_PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",'' CONV_RAT_UT_CD" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' EFF_DT" ).append("\n"); 
		query.append(",'' EXP_DT" ).append("\n"); 
		query.append(",'' FRT_RT_AMT" ).append("\n"); 
		query.append(",'' NOTE_CONV_CHG_CD" ).append("\n"); 
		query.append(",'' NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",'' NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append(",'' NOTE_CONV_SEQ" ).append("\n"); 
		query.append(",'' NOTE_CONV_TP_CD" ).append("\n"); 
		query.append(",'' PAY_TERM_CD" ).append("\n"); 
		query.append(",'' RT_APPL_TP_CD" ).append("\n"); 
		query.append(",'' RT_OP_CD" ).append("\n"); 
		query.append(",'' RULE_APPL_CHG_TP_CD" ).append("\n"); 
		query.append(",'' TRF_NO" ).append("\n"); 
		query.append(",'' TRF_PFX_CD" ).append("\n"); 
		query.append(",'' TRI_PROP_NO" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' USR_ID" ).append("\n"); 
		query.append(",'' BKG_POR_CNT_CD" ).append("\n"); 
		query.append(",'' BKG_POL_CNT_CD" ).append("\n"); 
		query.append(",'' BKG_POD_CNT_CD" ).append("\n"); 
		query.append(",'' BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}