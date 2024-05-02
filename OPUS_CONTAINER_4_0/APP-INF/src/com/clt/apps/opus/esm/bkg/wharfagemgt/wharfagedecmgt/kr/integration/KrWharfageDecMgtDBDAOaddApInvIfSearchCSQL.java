/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOaddApInvIfSearchCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.26 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOaddApInvIfSearchCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * i
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOaddApInvIfSearchCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOaddApInvIfSearchCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_INV_IF (" ).append("\n"); 
		query.append("AP_PGM_NO" ).append("\n"); 
		query.append(", INV_SEQ" ).append("\n"); 
		query.append(", TTL_ROW_KNT" ).append("\n"); 
		query.append(", ROW_KNT" ).append("\n"); 
		query.append(", HDR_CSR_NO" ).append("\n"); 
		query.append(", HDR_CSR_TP_CD" ).append("\n"); 
		query.append(", HDR_INV_DT" ).append("\n"); 
		query.append(", HDR_INV_TERM_DT" ).append("\n"); 
		query.append(", HDR_GL_DT" ).append("\n"); 
		query.append(", HDR_VNDR_NO" ).append("\n"); 
		query.append(", HDR_CSR_AMT" ).append("\n"); 
		query.append(", HDR_PAY_AMT" ).append("\n"); 
		query.append(", HDR_PAY_DT" ).append("\n"); 
		query.append(", HDR_CSR_CURR_CD" ).append("\n"); 
		query.append(", HDR_VNDR_TERM_NM" ).append("\n"); 
		query.append(", HDR_INV_DESC" ).append("\n"); 
		query.append(", HDR_ATTR_CATE_NM" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT1" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT2" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT3" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT4" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT5" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT6" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT7" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT8" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT9" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT10" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT11" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT12" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT13" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT14" ).append("\n"); 
		query.append(", HDR_ATTR_CTNT15" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(", HDR_GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(", HDR_SRC_CTNT" ).append("\n"); 
		query.append(", HDR_PAY_MZD_LU_CD" ).append("\n"); 
		query.append(", HDR_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(", HDR_COA_CO_CD" ).append("\n"); 
		query.append(", HDR_COA_RGN_CD" ).append("\n"); 
		query.append(", HDR_COA_CTR_CD" ).append("\n"); 
		query.append(", HDR_COA_ACCT_CD" ).append("\n"); 
		query.append(", HDR_COA_VVD_CD" ).append("\n"); 
		query.append(", HDR_COA_INTER_CO_CD" ).append("\n"); 
		query.append(", HDR_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(", HDR_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(", HDR_PPD_NO" ).append("\n"); 
		query.append(", HDR_PPD_DTRB_NO" ).append("\n"); 
		query.append(", HDR_PPD_APLY_AMT" ).append("\n"); 
		query.append(", HDR_PPD_GL_DT" ).append("\n"); 
		query.append(", HDR_APRO_FLG" ).append("\n"); 
		query.append(", HDR_TAX_DECL_FLG" ).append("\n"); 
		query.append(", HDR_ERR_CSR_NO" ).append("\n"); 
		query.append(", HDR_IF_FLG" ).append("\n"); 
		query.append(", HDR_IF_DT" ).append("\n"); 
		query.append(", HDR_IF_ERR_RSN" ).append("\n"); 
		query.append(", HDR_PPAY_APLY_FLG" ).append("\n"); 
		query.append(", HDR_TJ_OFC_CD" ).append("\n"); 
		query.append(", HDR_ACT_XCH_RT" ).append("\n"); 
		query.append(", HDR_IMP_ERR_FLG" ).append("\n"); 
		query.append(", HDR_RCV_ERR_FLG" ).append("\n"); 
		query.append(", HDR_TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append(", HDR_USR_EML" ).append("\n"); 
		query.append(", HDR_IMP_ERR_RSN" ).append("\n"); 
		query.append(", HDR_RCV_ERR_RSN" ).append("\n"); 
		query.append(", HDR_FTU_USE_CTNT1" ).append("\n"); 
		query.append(", HDR_FTU_USE_CTNT2" ).append("\n"); 
		query.append(", HDR_FTU_USE_CTNT3" ).append("\n"); 
		query.append(", HDR_FTU_USE_CTNT4" ).append("\n"); 
		query.append(", HDR_FTU_USE_CTNT5" ).append("\n"); 
		query.append(", CSR_NO" ).append("\n"); 
		query.append(", LINE_SEQ" ).append("\n"); 
		query.append(", LINE_NO" ).append("\n"); 
		query.append(", LINE_TP_LU_CD" ).append("\n"); 
		query.append(", INV_AMT" ).append("\n"); 
		query.append(", INV_DESC" ).append("\n"); 
		query.append(", INV_TAX_CD" ).append("\n"); 
		query.append(", DTRB_COA_CO_CD" ).append("\n"); 
		query.append(", DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(", DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(", DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(", DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(", DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(", DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(", DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(", ATTR_CATE_NM" ).append("\n"); 
		query.append(", ATTR_CTNT1" ).append("\n"); 
		query.append(", ATTR_CTNT2" ).append("\n"); 
		query.append(", ATTR_CTNT3" ).append("\n"); 
		query.append(", ATTR_CTNT4" ).append("\n"); 
		query.append(", ATTR_CTNT5" ).append("\n"); 
		query.append(", ATTR_CTNT6" ).append("\n"); 
		query.append(", ATTR_CTNT7" ).append("\n"); 
		query.append(", ATTR_CTNT8" ).append("\n"); 
		query.append(", ATTR_CTNT9" ).append("\n"); 
		query.append(", ATTR_CTNT10" ).append("\n"); 
		query.append(", ATTR_CTNT11" ).append("\n"); 
		query.append(", ATTR_CTNT12" ).append("\n"); 
		query.append(", ATTR_CTNT13" ).append("\n"); 
		query.append(", ATTR_CTNT14" ).append("\n"); 
		query.append(", ATTR_CTNT15" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", ACT_VVD_CD" ).append("\n"); 
		query.append(", PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(", SO_CRR_CD" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", FTU_USE_CTNT1" ).append("\n"); 
		query.append(", FTU_USE_CTNT2" ).append("\n"); 
		query.append(", FTU_USE_CTNT3" ).append("\n"); 
		query.append(", FTU_USE_CTNT4" ).append("\n"); 
		query.append(", FTU_USE_CTNT5" ).append("\n"); 
		query.append(", SND_FLG" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append("--       , EAI_EVNT_DT" ).append("\n"); 
		query.append("--       , ESTM_ERR_RSN" ).append("\n"); 
		query.append("--       , TRSP_SO_TP_CD" ).append("\n"); 
		query.append("--       , SO_OFC_CTY_CD" ).append("\n"); 
		query.append("--       , SO_SEQ" ).append("\n"); 
		query.append("--       , CGO_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   CC.AP_PGM_NO AS AP_PGM_NO" ).append("\n"); 
		query.append(", ROWNUM + (SELECT NVL(MAX(INV_SEQ),0) FROM AP_INV_IF WHERE AP_PGM_NO = CC.AP_PGM_NO) AS INV_SEQ" ).append("\n"); 
		query.append(", DD.TTL_ROW_KNT AS TTL_ROW_KNT" ).append("\n"); 
		query.append(", ROWNUM AS ROW_KNT" ).append("\n"); 
		query.append("-- 이하 AP_INV_HDR에서 가져옴" ).append("\n"); 
		query.append(", AA.CSR_NO AS HDR_CSR_NO" ).append("\n"); 
		query.append(", AA.CSR_TP_CD AS HDR_CSR_TP_CD" ).append("\n"); 
		query.append(", AA.INV_DT AS HDR_INV_DT" ).append("\n"); 
		query.append(", AA.INV_TERM_DT AS HDR_INV_TERM_DT" ).append("\n"); 
		query.append(", AA.GL_DT AS HDR_GL_DT" ).append("\n"); 
		query.append(", AA.VNDR_NO AS HDR_VNDR_NO" ).append("\n"); 
		query.append(", AA.CSR_AMT AS HDR_CSR_AMT" ).append("\n"); 
		query.append(", AA.PAY_AMT AS HDR_PAY_AMT" ).append("\n"); 
		query.append(", AA.PAY_DT AS HDR_PAY_DT" ).append("\n"); 
		query.append(", AA.CSR_CURR_CD AS HDR_CSR_CURR_CD" ).append("\n"); 
		query.append(", AA.VNDR_TERM_NM AS HDR_VNDR_TERM_NM" ).append("\n"); 
		query.append(", AA.INV_DESC AS HDR_INV_DESC" ).append("\n"); 
		query.append(", AA.ATTR_CATE_NM AS HDR_ATTR_CATE_NM" ).append("\n"); 
		query.append(", AA.ATTR_CTNT1 AS HDR_ATTR_CTNT1" ).append("\n"); 
		query.append(", AA.ATTR_CTNT2 AS HDR_ATTR_CTNT2" ).append("\n"); 
		query.append(", AA.ATTR_CTNT3 AS HDR_ATTR_CTNT3" ).append("\n"); 
		query.append(", AA.ATTR_CTNT4 AS HDR_ATTR_CTNT4" ).append("\n"); 
		query.append(", AA.ATTR_CTNT5 AS HDR_ATTR_CTNT5" ).append("\n"); 
		query.append(", AA.ATTR_CTNT6 AS HDR_ATTR_CTNT6" ).append("\n"); 
		query.append(", AA.ATTR_CTNT7 AS HDR_ATTR_CTNT7" ).append("\n"); 
		query.append(", AA.ATTR_CTNT8 AS HDR_ATTR_CTNT8" ).append("\n"); 
		query.append(", AA.ATTR_CTNT9 AS HDR_ATTR_CTNT9" ).append("\n"); 
		query.append(", AA.ATTR_CTNT10 AS HDR_ATTR_CTNT10" ).append("\n"); 
		query.append(", AA.ATTR_CTNT11 AS HDR_ATTR_CTNT11" ).append("\n"); 
		query.append(", AA.ATTR_CTNT12 AS HDR_ATTR_CTNT12" ).append("\n"); 
		query.append(", AA.ATTR_CTNT13 AS HDR_ATTR_CTNT13" ).append("\n"); 
		query.append(", AA.ATTR_CTNT14 AS HDR_ATTR_CTNT14" ).append("\n"); 
		query.append(", AA.ATTR_CTNT15 AS HDR_ATTR_CTNT15" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT1 AS HDR_GLO_ATTR_CTNT1" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT2 AS HDR_GLO_ATTR_CTNT2" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT3 AS HDR_GLO_ATTR_CTNT3" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT4 AS HDR_GLO_ATTR_CTNT4" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT5 AS HDR_GLO_ATTR_CTNT5" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT6 AS HDR_GLO_ATTR_CTNT6" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT7 AS HDR_GLO_ATTR_CTNT7" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT8 AS HDR_GLO_ATTR_CTNT8" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT9 AS HDR_GLO_ATTR_CTNT9" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT10 AS HDR_GLO_ATTR_CTNT10" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT11 AS HDR_GLO_ATTR_CTNT11" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT12 AS HDR_GLO_ATTR_CTNT12" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT13 AS HDR_GLO_ATTR_CTNT13" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT14 AS HDR_GLO_ATTR_CTNT14" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT15 AS HDR_GLO_ATTR_CTNT15" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT16 AS HDR_GLO_ATTR_CTNT16" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT17 AS HDR_GLO_ATTR_CTNT17" ).append("\n"); 
		query.append(", AA.GLO_ATTR_CTNT18 AS HDR_GLO_ATTR_CTNT18" ).append("\n"); 
		query.append(", AA.SRC_CTNT AS HDR_SRC_CTNT" ).append("\n"); 
		query.append(", AA.PAY_MZD_LU_CD AS HDR_PAY_MZD_LU_CD" ).append("\n"); 
		query.append(", AA.PAY_GRP_LU_CD AS HDR_PAY_GRP_LU_CD" ).append("\n"); 
		query.append(", AA.COA_CO_CD AS HDR_COA_CO_CD" ).append("\n"); 
		query.append(", AA.COA_RGN_CD AS HDR_COA_RGN_CD" ).append("\n"); 
		query.append(", AA.COA_CTR_CD AS HDR_COA_CTR_CD" ).append("\n"); 
		query.append(", AA.COA_ACCT_CD AS HDR_COA_ACCT_CD" ).append("\n"); 
		query.append(", AA.COA_VVD_CD AS HDR_COA_VVD_CD" ).append("\n"); 
		query.append(", AA.COA_INTER_CO_CD AS HDR_COA_INTER_CO_CD" ).append("\n"); 
		query.append(", AA.COA_FTU_N1ST_CD AS HDR_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(", AA.COA_FTU_N2ND_CD AS HDR_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(", AA.PPD_NO AS HDR_PPD_NO" ).append("\n"); 
		query.append(", AA.PPD_DTRB_NO AS HDR_PPD_DTRB_NO" ).append("\n"); 
		query.append(", AA.PPD_APLY_AMT AS HDR_PPD_APLY_AMT" ).append("\n"); 
		query.append(", AA.PPD_GL_DT AS HDR_PPD_GL_DT" ).append("\n"); 
		query.append(", AA.APRO_FLG AS HDR_APRO_FLG" ).append("\n"); 
		query.append(", AA.TAX_DECL_FLG AS HDR_TAX_DECL_FLG" ).append("\n"); 
		query.append(", AA.ERR_CSR_NO AS HDR_ERR_CSR_NO" ).append("\n"); 
		query.append(", AA.IF_FLG AS HDR_IF_FLG" ).append("\n"); 
		query.append(", AA.IF_DT AS HDR_IF_DT" ).append("\n"); 
		query.append(", AA.IF_ERR_RSN AS HDR_IF_ERR_RSN" ).append("\n"); 
		query.append(", AA.PPAY_APLY_FLG AS HDR_PPAY_APLY_FLG" ).append("\n"); 
		query.append(", AA.TJ_OFC_CD AS HDR_TJ_OFC_CD" ).append("\n"); 
		query.append(", AA.ACT_XCH_RT AS HDR_ACT_XCH_RT" ).append("\n"); 
		query.append(", AA.IMP_ERR_FLG AS HDR_IMP_ERR_FLG" ).append("\n"); 
		query.append(", AA.RCV_ERR_FLG AS HDR_RCV_ERR_FLG" ).append("\n"); 
		query.append(", AA.TAX_CURR_XCH_FLG AS HDR_TAX_CURR_XCH_FLG" ).append("\n"); 
		query.append(", AA.USR_EML AS HDR_USR_EML" ).append("\n"); 
		query.append(", AA.IMP_ERR_RSN AS HDR_IMP_ERR_RSN" ).append("\n"); 
		query.append(", AA.RCV_ERR_RSN AS HDR_RCV_ERR_RSN" ).append("\n"); 
		query.append(", AA.FTU_USE_CTNT1 AS HDR_FTU_USE_CTNT1" ).append("\n"); 
		query.append(", AA.FTU_USE_CTNT2 AS HDR_FTU_USE_CTNT2" ).append("\n"); 
		query.append(", AA.FTU_USE_CTNT3 AS HDR_FTU_USE_CTNT3" ).append("\n"); 
		query.append(", AA.FTU_USE_CTNT4 AS HDR_FTU_USE_CTNT4" ).append("\n"); 
		query.append(", AA.FTU_USE_CTNT5 AS HDR_FTU_USE_CTNT5" ).append("\n"); 
		query.append("-- 이하 AP_INV_DTRB에서 가져옴" ).append("\n"); 
		query.append(", BB.CSR_NO AS CSR_NO" ).append("\n"); 
		query.append(", BB.LINE_SEQ AS LINE_SEQ" ).append("\n"); 
		query.append(", BB.LINE_NO AS LINE_NO" ).append("\n"); 
		query.append(", BB.LINE_TP_LU_CD AS LINE_TP_LU_CD" ).append("\n"); 
		query.append(", BB.INV_AMT AS INV_AMT" ).append("\n"); 
		query.append(", BB.INV_DESC AS INV_DESC" ).append("\n"); 
		query.append(", BB.INV_TAX_CD AS INV_TAX_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_CO_CD AS DTRB_COA_CO_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_RGN_CD AS DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_CTR_CD AS DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_ACCT_CD AS DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_VVD_CD AS DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_INTER_CO_CD AS DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_FTU_N1ST_CD AS DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(", BB.DTRB_COA_FTU_N2ND_CD AS DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(", BB.ATTR_CATE_NM AS ATTR_CATE_NM" ).append("\n"); 
		query.append(", BB.ATTR_CTNT1 AS ATTR_CTNT1" ).append("\n"); 
		query.append(", BB.ATTR_CTNT2 AS ATTR_CTNT2" ).append("\n"); 
		query.append(", BB.ATTR_CTNT3 AS ATTR_CTNT3" ).append("\n"); 
		query.append(", BB.ATTR_CTNT4 AS ATTR_CTNT4" ).append("\n"); 
		query.append(", BB.ATTR_CTNT5 AS ATTR_CTNT5" ).append("\n"); 
		query.append(", BB.ATTR_CTNT6 AS ATTR_CTNT6" ).append("\n"); 
		query.append(", BB.ATTR_CTNT7 AS ATTR_CTNT7" ).append("\n"); 
		query.append(", BB.ATTR_CTNT8 AS ATTR_CTNT8" ).append("\n"); 
		query.append(", BB.ATTR_CTNT9 AS ATTR_CTNT9" ).append("\n"); 
		query.append(", BB.ATTR_CTNT10 AS ATTR_CTNT10" ).append("\n"); 
		query.append(", BB.ATTR_CTNT11 AS ATTR_CTNT11" ).append("\n"); 
		query.append(", BB.ATTR_CTNT12 AS ATTR_CTNT12" ).append("\n"); 
		query.append(", BB.ATTR_CTNT13 AS ATTR_CTNT13" ).append("\n"); 
		query.append(", BB.ATTR_CTNT14 AS ATTR_CTNT14" ).append("\n"); 
		query.append(", BB.ATTR_CTNT15 AS ATTR_CTNT15" ).append("\n"); 
		query.append(", BB.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append(", BB.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", BB.ACT_VVD_CD AS ACT_VVD_CD" ).append("\n"); 
		query.append(", BB.PLN_SCTR_DIV_CD AS PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(", BB.SO_CRR_CD AS SO_CRR_CD" ).append("\n"); 
		query.append(", BB.YD_CD AS YD_CD" ).append("\n"); 
		query.append(", BB.FTU_USE_CTNT1 AS FTU_USE_CTNT1" ).append("\n"); 
		query.append(", BB.FTU_USE_CTNT2 AS FTU_USE_CTNT2" ).append("\n"); 
		query.append(", BB.FTU_USE_CTNT3 AS FTU_USE_CTNT3" ).append("\n"); 
		query.append(", BB.FTU_USE_CTNT4 AS FTU_USE_CTNT4" ).append("\n"); 
		query.append(", BB.FTU_USE_CTNT5 AS FTU_USE_CTNT5" ).append("\n"); 
		query.append(", 'Y' AS SND_FLG" ).append("\n"); 
		query.append(", SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(", @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("FROM AP_INV_HDR AA, AP_INV_DTRB BB," ).append("\n"); 
		query.append("(SELECT 'ESMBKGXXX'||TO_CHAR(SYSDATE, 'YYYYMMDD') AS AP_PGM_NO" ).append("\n"); 
		query.append("FROM DUAL) CC," ).append("\n"); 
		query.append("(SELECT COUNT(CSR_NO) TTL_ROW_KNT FROM AP_INV_DTRB WHERE CSR_NO = @[csr_no]) DD" ).append("\n"); 
		query.append("WHERE AA.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND BB.CSR_NO = AA.CSR_NO" ).append("\n"); 

	}
}