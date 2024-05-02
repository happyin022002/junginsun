/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IMDGJMSQueueEAIDAOScgImdgUnNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.15
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.07.15 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Won, Jong-Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGJMSQueueEAIDAOScgImdgUnNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_IMDG_PCK_CD 조회
	  * </pre>
	  */
	public IMDGJMSQueueEAIDAOScgImdgUnNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGJMSQueueEAIDAOScgImdgUnNoVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("IMDG_UN_NO, IMDG_UN_NO_SEQ, PRP_SHP_NM, " ).append("\n"); 
		query.append("   IMDG_CLSS_CD, IMDG_COMP_GRP_CD, IMDG_SUBS_RSK_LBL_RMK, " ).append("\n"); 
		query.append("   IMDG_MRN_POLUT_CD, IMDG_PCK_GRP_CD, IMDG_LMT_QTY, " ).append("\n"); 
		query.append("   IMDG_LMT_QTY_DESC, IMDG_LMT_QTY_MEAS_UT_CD, IMDG_EXPT_QTY_CD, " ).append("\n"); 
		query.append("   IMDG_EXPT_QTY_DESC, IMDG_EMER_NO, IMDG_STWG_CATE_CD, " ).append("\n"); 
		query.append("   FLSH_PNT_TEMP_CTNT, EMER_RSPN_GID_NO, EMER_RSPN_GID_CHR_NO, " ).append("\n"); 
		query.append("   PSA_NO, N1ST_BOM_PORT_TRST_NO, N2ND_BOM_PORT_TRST_NO, " ).append("\n"); 
		query.append("   N3RD_BOM_PORT_TRST_NO, N4TH_BOM_PORT_TRST_NO, PKG_AUTH_NO, " ).append("\n"); 
		query.append("   LK_PORT_AUTH_NO, IMDG_SBST_PPT_DESC, CFR_RPT_QTY, " ).append("\n"); 
		query.append("   CFR_PSN_INH_ZN_CD, CFR_TOXC_CD, CFR_DG_WET_CD, " ).append("\n"); 
		query.append("   CFR_RSTR_PORT_NM, CFR_RSTR_OPR_NM, CFR_XTD_CLSS_CD, " ).append("\n"); 
		query.append("   HCDG_FLG, HCDG_DPND_QTY_FLG, HCDG_RMK, " ).append("\n"); 
		query.append("   N1ST_IMDG_PCK_INSTR_CD, N2ND_IMDG_PCK_INSTR_CD, N3RD_IMDG_PCK_INSTR_CD, " ).append("\n"); 
		query.append("   N1ST_IMDG_PCK_PROVI_CD, N2ND_IMDG_PCK_PROVI_CD, N3RD_IMDG_PCK_PROVI_CD, " ).append("\n"); 
		query.append("   N4TH_IMDG_PCK_PROVI_CD, N5TH_IMDG_PCK_PROVI_CD, N1ST_IMDG_IBC_INSTR_CD, " ).append("\n"); 
		query.append("   N2ND_IMDG_IBC_INSTR_CD, N3RD_IMDG_IBC_INSTR_CD, N4TH_IMDG_IBC_INSTR_CD, " ).append("\n"); 
		query.append("   N5TH_IMDG_IBC_INSTR_CD, N1ST_IMDG_IBC_PROVI_CD, N2ND_IMDG_IBC_PROVI_CD, " ).append("\n"); 
		query.append("   N3RD_IMDG_IBC_PROVI_CD, N4TH_IMDG_IBC_PROVI_CD, N5TH_IMDG_IBC_PROVI_CD, " ).append("\n"); 
		query.append("   N1ST_IMDG_UN_TNK_INSTR_CD, N2ND_IMDG_UN_TNK_INSTR_CD, N1ST_IMDG_TNK_INSTR_PROVI_CD, " ).append("\n"); 
		query.append("   N2ND_IMDG_TNK_INSTR_PROVI_CD, N3RD_IMDG_TNK_INSTR_PROVI_CD, N4TH_IMDG_TNK_INSTR_PROVI_CD, " ).append("\n"); 
		query.append("   N5TH_IMDG_TNK_INSTR_PROVI_CD, HCDG_PCK_RSTR_DESC, HCDG_INTMD_BC_RSTR_DESC, " ).append("\n"); 
		query.append("   HCDG_TNK_RSTR_DESC, SEGR_DESC, CLR_LIV_QTR_STWG_FLG, " ).append("\n"); 
		query.append("   IMDG_FD_STUF_STWG_CD, IMDG_HT_SRC_STWG_CD, SEGR_AS_FOR_IMDG_CLSS_FLG, " ).append("\n"); 
		query.append("   SEGR_AS_FOR_IMDG_CLSS_CD, AWAY_FM_IMDG_CLSS_FLG, SPRT_FM_IMDG_CLSS_FLG, " ).append("\n"); 
		query.append("   SPRT_HLD_FM_IMDG_CLSS_FLG, SPRT_LON_FM_IMDG_CLSS_FLG, AWAY_FM_IMDG_SEGR_GRP_FLG, " ).append("\n"); 
		query.append("   SPRT_FM_IMDG_SEGR_GRP_FLG, IMDG_TBL_NO, IMDG_UN_NO_HLD_FLG, " ).append("\n"); 
		query.append("   CRE_USR_ID, CRE_DT, UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT, N1ST_IMDG_PCK_INSTR_SEQ, N2ND_IMDG_PCK_INSTR_SEQ, " ).append("\n"); 
		query.append("   N3RD_IMDG_PCK_INSTR_SEQ, N1ST_IMDG_PCK_PROVI_SEQ, N2ND_IMDG_PCK_PROVI_SEQ, " ).append("\n"); 
		query.append("   N3RD_IMDG_PCK_PROVI_SEQ, N4TH_IMDG_PCK_PROVI_SEQ, N5TH_IMDG_PCK_PROVI_SEQ, " ).append("\n"); 
		query.append("   N1ST_IMDG_IBC_INSTR_SEQ, N2ND_IMDG_IBC_INSTR_SEQ, N3RD_IMDG_IBC_INSTR_SEQ, " ).append("\n"); 
		query.append("   N4TH_IMDG_IBC_INSTR_SEQ, N5TH_IMDG_IBC_INSTR_SEQ, N1ST_IMDG_IBC_PROVI_SEQ, " ).append("\n"); 
		query.append("   N2ND_IMDG_IBC_PROVI_SEQ, N3RD_IMDG_IBC_PROVI_SEQ, N4TH_IMDG_IBC_PROVI_SEQ, " ).append("\n"); 
		query.append("   N5TH_IMDG_IBC_PROVI_SEQ, N1ST_IMDG_UN_TNK_INSTR_SEQ, N2ND_IMDG_UN_TNK_INSTR_SEQ, " ).append("\n"); 
		query.append("   N1ST_IMDG_TNK_INSTR_PROVI_SEQ, N2ND_IMDG_TNK_INSTR_PROVI_SEQ, N3RD_IMDG_TNK_INSTR_PROVI_SEQ, " ).append("\n"); 
		query.append("   N4TH_IMDG_TNK_INSTR_PROVI_SEQ, N5TH_IMDG_TNK_INSTR_PROVI_SEQ, EAI_IF_FLG, " ).append("\n"); 
		query.append("   EAI_EVNT_DT, EAI_IF_ID" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ibflag} == 'D') " ).append("\n"); 
		query.append("	AND	IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("	AND	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND EAI_IF_FLG is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}