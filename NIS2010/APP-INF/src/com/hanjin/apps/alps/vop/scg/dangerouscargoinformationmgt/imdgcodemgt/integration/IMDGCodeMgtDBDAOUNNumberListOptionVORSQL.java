/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOUNNumberListOptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOUNNumberListOptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UNNumberListOption 조회
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOUNNumberListOptionVORSQL(){
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
		params.put("imdg_tec_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_crr_rstr_expt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOUNNumberListOptionVORSQL").append("\n"); 
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
		query.append("SELECT	IMDG_UN_NO " ).append("\n"); 
		query.append("	, IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("	, PRP_SHP_NM" ).append("\n"); 
		query.append("	, IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append("	, IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append("	, IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("	, IMDG_LMT_QTY" ).append("\n"); 
		query.append("	, IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append("	, IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append("	, IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append("	, IMDG_EXPT_QTY_DESC" ).append("\n"); 
		query.append("	, IMDG_EMER_NO" ).append("\n"); 
		query.append("	, IMDG_STWG_CATE_CD" ).append("\n"); 
		query.append("	, FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("	, EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("	, EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("	, PSA_NO" ).append("\n"); 
		query.append("	, N1ST_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, N2ND_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, N3RD_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, N4TH_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, PKG_AUTH_NO" ).append("\n"); 
		query.append("	, LK_PORT_AUTH_NO" ).append("\n"); 
		query.append("	, IMDG_SBST_PPT_DESC" ).append("\n"); 
		query.append("	, CFR_RPT_QTY" ).append("\n"); 
		query.append("	, CFR_PSN_INH_ZN_CD" ).append("\n"); 
		query.append("	, CFR_TOXC_CD" ).append("\n"); 
		query.append("	, CFR_DG_WET_CD" ).append("\n"); 
		query.append("	, CFR_RSTR_PORT_NM" ).append("\n"); 
		query.append("	, CFR_RSTR_OPR_NM" ).append("\n"); 
		query.append("	, CFR_XTD_CLSS_CD" ).append("\n"); 
		query.append("	, HCDG_FLG" ).append("\n"); 
		query.append("	, HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append("	, HCDG_RMK " ).append("\n"); 
		query.append("    , N1ST_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("    , N2ND_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("    , N3RD_IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("    , N1ST_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("    , N2ND_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("    , N3RD_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("    , N4TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("    , N5TH_IMDG_PCK_PROVI_CD" ).append("\n"); 
		query.append("    , N1ST_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("    , N2ND_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("    , N3RD_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("    , N4TH_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("    , N5TH_IMDG_IBC_INSTR_CD" ).append("\n"); 
		query.append("    , N1ST_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("    , N2ND_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("    , N3RD_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("    , N4TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("    , N5TH_IMDG_IBC_PROVI_CD" ).append("\n"); 
		query.append("    , N1ST_IMDG_UN_TNK_INSTR_CD" ).append("\n"); 
		query.append("    , N2ND_IMDG_UN_TNK_INSTR_CD" ).append("\n"); 
		query.append("    , N1ST_IMDG_TNK_INSTR_PROVI_CD " ).append("\n"); 
		query.append("    , N2ND_IMDG_TNK_INSTR_PROVI_CD " ).append("\n"); 
		query.append("    , N3RD_IMDG_TNK_INSTR_PROVI_CD " ).append("\n"); 
		query.append("    , N4TH_IMDG_TNK_INSTR_PROVI_CD " ).append("\n"); 
		query.append("    , N5TH_IMDG_TNK_INSTR_PROVI_CD    " ).append("\n"); 
		query.append("    , N1ST_IMDG_PCK_INSTR_FILE" ).append("\n"); 
		query.append("    , N2ND_IMDG_PCK_INSTR_FILE" ).append("\n"); 
		query.append("    , N3RD_IMDG_PCK_INSTR_FILE" ).append("\n"); 
		query.append("    , N1ST_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , N2ND_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , N3RD_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , N4TH_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , N5TH_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , N1ST_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , N2ND_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , N3RD_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , N4TH_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , N5TH_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , N1ST_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , N2ND_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , N3RD_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , N4TH_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , N5TH_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , N1ST_IMDG_UN_TNK_INSTR_FILE" ).append("\n"); 
		query.append("    , N2ND_IMDG_UN_TNK_INSTR_FILE" ).append("\n"); 
		query.append("    , N1ST_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , N2ND_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , N3RD_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , N4TH_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , N5TH_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , N1ST_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("    , N2ND_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("    , N3RD_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("    , N1ST_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , N2ND_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , N3RD_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , N4TH_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , N5TH_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , N1ST_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , N2ND_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , N3RD_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , N4TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , N5TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , N1ST_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , N2ND_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , N3RD_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , N4TH_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , N5TH_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , N1ST_IMDG_UN_TNK_INSTR_SEQ    " ).append("\n"); 
		query.append("    , N2ND_IMDG_UN_TNK_INSTR_SEQ   " ).append("\n"); 
		query.append("    , N1ST_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , N2ND_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , N3RD_IMDG_TNK_INSTR_PROVI_SEQ " ).append("\n"); 
		query.append("    , N4TH_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , N5TH_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append("	, HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append("	, HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append("	, SEGR_DESC" ).append("\n"); 
		query.append("	, CLR_LIV_QTR_STWG_FLG" ).append("\n"); 
		query.append("	, IMDG_FD_STUF_STWG_CD" ).append("\n"); 
		query.append("	, IMDG_HT_SRC_STWG_CD" ).append("\n"); 
		query.append("	, SEGR_AS_FOR_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, SEGR_AS_FOR_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, AWAY_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, SPRT_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, SPRT_HLD_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, SPRT_LON_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, AWAY_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append("	, SPRT_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append("	, IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, IMDG_ORG_RACT_TP_CD" ).append("\n"); 
		query.append("	, IMDG_TEC_NM" ).append("\n"); 
		query.append("	, IMDG_CONC_RT_CTNT" ).append("\n"); 
		query.append("	, IMDG_PCK_MZD_CD" ).append("\n"); 
		query.append("	, IMDG_CTRL_TEMP" ).append("\n"); 
		query.append("	, IMDG_EMER_TEMP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   IMDG_CRR_RSTR_EXPT_CD" ).append("\n"); 
		query.append("	,   IMDG_CRR_RSTR_EXPT_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, AWAY_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, SPRT_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, SPRT_HLD_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, SPRT_LON_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- For VO" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO1" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO2" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO3" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO4" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO5" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO6" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO7" ).append("\n"); 
		query.append("	, IMDG_SPCL_PROVI_NO8" ).append("\n"); 
		query.append("	, AWAY_DP_SEQ" ).append("\n"); 
		query.append("	, SPRT_DP_SEQ" ).append("\n"); 
		query.append("	, HCDG_TNK_RSTR_DESC1" ).append("\n"); 
		query.append("	, HCDG_TNK_RSTR_DESC2" ).append("\n"); 
		query.append("	, HCDG_TNK_RSTR_DESC3" ).append("\n"); 
		query.append("	, HCDG_TNK_RSTR_DESC4" ).append("\n"); 
		query.append("    , PAGE_NO" ).append("\n"); 
		query.append("    , ROW_NUM" ).append("\n"); 
		query.append("    , TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	A.IMDG_UN_NO" ).append("\n"); 
		query.append("	, A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("	, A.PRP_SHP_NM" ).append("\n"); 
		query.append("	, A.IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, A.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("	, A.IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append("	, A.IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append("	, A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("	, A.IMDG_LMT_QTY" ).append("\n"); 
		query.append("	, A.IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append("	, A.IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append("	, A.IMDG_EXPT_QTY_CD" ).append("\n"); 
		query.append("	, A.IMDG_EXPT_QTY_DESC" ).append("\n"); 
		query.append("	, A.IMDG_EMER_NO" ).append("\n"); 
		query.append("	, A.IMDG_STWG_CATE_CD" ).append("\n"); 
		query.append("	, A.FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("	, A.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("	, A.EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("	, A.PSA_NO" ).append("\n"); 
		query.append("	, A.N1ST_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, A.N2ND_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, A.N3RD_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, A.N4TH_BOM_PORT_TRST_NO" ).append("\n"); 
		query.append("	, A.PKG_AUTH_NO" ).append("\n"); 
		query.append("	, A.LK_PORT_AUTH_NO" ).append("\n"); 
		query.append("	, A.IMDG_SBST_PPT_DESC" ).append("\n"); 
		query.append("	, A.CFR_RPT_QTY" ).append("\n"); 
		query.append("	, A.CFR_PSN_INH_ZN_CD" ).append("\n"); 
		query.append("	, A.CFR_TOXC_CD" ).append("\n"); 
		query.append("	, A.CFR_DG_WET_CD" ).append("\n"); 
		query.append("	, A.CFR_RSTR_PORT_NM" ).append("\n"); 
		query.append("	, A.CFR_RSTR_OPR_NM" ).append("\n"); 
		query.append("	, A.CFR_XTD_CLSS_CD" ).append("\n"); 
		query.append("	, A.HCDG_FLG" ).append("\n"); 
		query.append("	, A.HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append("	, A.HCDG_RMK " ).append("\n"); 
		query.append("    , A.N1ST_IMDG_PCK_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N1ST_IMDG_PCK_INSTR_CD AND ROWNUM=1) AS N1ST_IMDG_PCK_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_PCK_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N2ND_IMDG_PCK_INSTR_CD AND ROWNUM=1) AS N2ND_IMDG_PCK_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_PCK_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N3RD_IMDG_PCK_INSTR_CD AND ROWNUM=1) AS N3RD_IMDG_PCK_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_PCK_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N1ST_IMDG_PCK_PROVI_CD AND ROWNUM=1) AS N1ST_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_PCK_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N2ND_IMDG_PCK_PROVI_CD AND ROWNUM=1) AS N2ND_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_PCK_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N3RD_IMDG_PCK_PROVI_CD AND ROWNUM=1) AS N3RD_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_PCK_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N4TH_IMDG_PCK_PROVI_CD AND ROWNUM=1) AS N4TH_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_PCK_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N5TH_IMDG_PCK_PROVI_CD AND ROWNUM=1) AS N5TH_IMDG_PCK_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_IBC_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N1ST_IMDG_IBC_INSTR_CD AND ROWNUM=1) AS N1ST_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_IBC_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N2ND_IMDG_IBC_INSTR_CD AND ROWNUM=1) AS N2ND_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_IBC_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N3RD_IMDG_IBC_INSTR_CD AND ROWNUM=1) AS N3RD_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_IBC_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N4TH_IMDG_IBC_INSTR_CD AND ROWNUM=1) AS N4TH_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_IBC_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N5TH_IMDG_IBC_INSTR_CD AND ROWNUM=1) AS N5TH_IMDG_IBC_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_IBC_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N1ST_IMDG_IBC_PROVI_CD AND ROWNUM=1) AS N1ST_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_IBC_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N2ND_IMDG_IBC_PROVI_CD AND ROWNUM=1) AS N2ND_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_IBC_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N3RD_IMDG_IBC_PROVI_CD AND ROWNUM=1) AS N3RD_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_IBC_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N4TH_IMDG_IBC_PROVI_CD AND ROWNUM=1) AS N4TH_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_IBC_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N5TH_IMDG_IBC_PROVI_CD AND ROWNUM=1) AS N5TH_IMDG_IBC_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_UN_TNK_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N1ST_IMDG_UN_TNK_INSTR_CD AND ROWNUM=1) AS N1ST_IMDG_UN_TNK_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_UN_TNK_INSTR_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N2ND_IMDG_UN_TNK_INSTR_CD AND ROWNUM=1) AS N2ND_IMDG_UN_TNK_INSTR_FILE" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_TNK_INSTR_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N1ST_IMDG_TNK_INSTR_PROVI_CD AND ROWNUM=1) AS N1ST_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_TNK_INSTR_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N2ND_IMDG_TNK_INSTR_PROVI_CD AND ROWNUM=1) AS N2ND_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_TNK_INSTR_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N3RD_IMDG_TNK_INSTR_PROVI_CD AND ROWNUM=1) AS N3RD_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_TNK_INSTR_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N4TH_IMDG_TNK_INSTR_PROVI_CD AND ROWNUM=1) AS N4TH_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_TNK_INSTR_PROVI_CD, (SELECT /*+ INDEX_DESC(B XPKSCG_IMDG_PCK_INSTR) */ FILE_SAV_ID FROM SCG_IMDG_PCK_INSTR B WHERE IMDG_PCK_INSTR_CD = A.N5TH_IMDG_TNK_INSTR_PROVI_CD AND ROWNUM=1) AS N5TH_IMDG_TNK_INSTR_PROVI_FILE" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_PCK_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_IBC_INSTR_SEQ" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N4TH_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_IBC_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N1ST_IMDG_UN_TNK_INSTR_SEQ    " ).append("\n"); 
		query.append("    , A.N2ND_IMDG_UN_TNK_INSTR_SEQ   " ).append("\n"); 
		query.append("    , A.N1ST_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N2ND_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N3RD_IMDG_TNK_INSTR_PROVI_SEQ " ).append("\n"); 
		query.append("    , A.N4TH_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.N5TH_IMDG_TNK_INSTR_PROVI_SEQ" ).append("\n"); 
		query.append("    , A.HCDG_PCK_RSTR_DESC" ).append("\n"); 
		query.append("	, A.HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append("	, A.HCDG_TNK_RSTR_DESC" ).append("\n"); 
		query.append("	, A.SEGR_DESC" ).append("\n"); 
		query.append("	, A.CLR_LIV_QTR_STWG_FLG" ).append("\n"); 
		query.append("	, A.IMDG_FD_STUF_STWG_CD" ).append("\n"); 
		query.append("	, A.IMDG_HT_SRC_STWG_CD" ).append("\n"); 
		query.append("	, A.SEGR_AS_FOR_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, A.SEGR_AS_FOR_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, A.AWAY_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, A.SPRT_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, A.SPRT_HLD_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, A.SPRT_LON_FM_IMDG_CLSS_FLG" ).append("\n"); 
		query.append("	, A.AWAY_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append("	, A.SPRT_FM_IMDG_SEGR_GRP_FLG" ).append("\n"); 
		query.append("	, A.IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append("	, A.CRE_USR_ID" ).append("\n"); 
		query.append("	, A.CRE_DT" ).append("\n"); 
		query.append("	, A.UPD_USR_ID" ).append("\n"); 
		query.append("	, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',A.UPD_DT,'GMT'),'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, B.IMDG_ORG_RACT_TP_CD" ).append("\n"); 
		query.append("	, B.IMDG_TEC_NM" ).append("\n"); 
		query.append("	, B.IMDG_CONC_RT_CTNT" ).append("\n"); 
		query.append("	, B.IMDG_PCK_MZD_CD" ).append("\n"); 
		query.append("	, B.IMDG_CTRL_TEMP" ).append("\n"); 
		query.append("	, B.IMDG_EMER_TEMP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   C.IMDG_CRR_RSTR_EXPT_CD" ).append("\n"); 
		query.append("	,   C.IMDG_CRR_RSTR_EXPT_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, (	SELECT 	SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SUBS_RSK_LBL_CD) ORDER BY IMDG_SUBS_RSK_LBL_CD).EXTRACT('//text()'), 2) AS IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("		FROM SCG_IMDG_SUBS_RSK_LBL" ).append("\n"); 
		query.append("		WHERE 	IMDG_UN_NO  = A.IMDG_UN_NO" ).append("\n"); 
		query.append("		AND 	IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ ) AS IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	, (	SELECT 	SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SPCL_PROVI_NO) ORDER BY DP_SEQ).EXTRACT('//text()'), 2) AS IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append("		FROM SCG_IMDG_UN_NO_SPCL_PROVI" ).append("\n"); 
		query.append("		WHERE 	IMDG_UN_NO  = A.IMDG_UN_NO" ).append("\n"); 
		query.append("		AND 	IMDG_UN_NO_SEQ = A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ ) AS IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, '' AWAY_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, '' SPRT_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, '' SPRT_HLD_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, '' SPRT_LON_FM_IMDG_CLSS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- For VO" ).append("\n"); 
		query.append("	, '' IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("	, '' IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("	, '' IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("	, '' IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO1" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO2" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO3" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO4" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO5" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO6" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO7" ).append("\n"); 
		query.append("	, '' IMDG_SPCL_PROVI_NO8" ).append("\n"); 
		query.append("	, '' AWAY_DP_SEQ" ).append("\n"); 
		query.append("	, '' SPRT_DP_SEQ" ).append("\n"); 
		query.append("	, '' HCDG_TNK_RSTR_DESC1" ).append("\n"); 
		query.append("	, '' HCDG_TNK_RSTR_DESC2" ).append("\n"); 
		query.append("	, '' HCDG_TNK_RSTR_DESC3" ).append("\n"); 
		query.append("	, '' HCDG_TNK_RSTR_DESC4" ).append("\n"); 
		query.append("    , '' PAGE_NO" ).append("\n"); 
		query.append("    , ROW_NUMBER() OVER (ORDER BY A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ DESC) ROW_NUM" ).append("\n"); 
		query.append("	, COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 	SCG_IMDG_UN_NO A" ).append("\n"); 
		query.append("	, 	SCG_IMDG_UN_NO_ORG_RACT B" ).append("\n"); 
		query.append("	, 	(	SELECT 	IMDG_UN_NO" ).append("\n"); 
		query.append("				, 	IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("				,	SUBSTR(XMLAGG(XMLELEMENT(X, ', ' || IMDG_CRR_RSTR_EXPT_CD) ORDER BY IMDG_CRR_RSTR_EXPT_CD).EXTRACT('//text()'), 2) AS IMDG_CRR_RSTR_EXPT_CD" ).append("\n"); 
		query.append("				,	SUBSTR(XMLAGG(XMLELEMENT(X, ', ' || DECODE(IMDG_CRR_RSTR_EXPT_CD,	'P','Prohibited'," ).append("\n"); 
		query.append("																						'R','Restricted'," ).append("\n"); 
		query.append("																						'C','Excepted fm Class Prohibition'," ).append("\n"); 
		query.append("																						'T','T/S Prohibited'," ).append("\n"); 
		query.append("																						'L','Prohibited on '||SLAN_CD||' Lane') ) " ).append("\n"); 
		query.append("								  ORDER BY IMDG_CRR_RSTR_EXPT_CD).EXTRACT('//text()'), 2) AS IMDG_CRR_RSTR_EXPT_NM" ).append("\n"); 
		query.append("			FROM SCG_IMDG_CRR_RSTR " ).append("\n"); 
		query.append("			WHERE VSL_OPR_TP_CD = 'SML'" ).append("\n"); 
		query.append("			GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ) C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.IMDG_UN_NO = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND 	A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("AND		A.IMDG_UN_NO = C.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND 	A.IMDG_UN_NO_SEQ = C.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("	AND	A.IMDG_UN_NO LIKE @[imdg_un_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("	AND	A.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '')                                              " ).append("\n"); 
		query.append("	AND	A.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_comp_grp_cd} != '')                                              " ).append("\n"); 
		query.append("	AND	A.IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_crr_rstr_expt_cd} != '')" ).append("\n"); 
		query.append("	#if (${imdg_crr_rstr_expt_cd} == 'N')" ).append("\n"); 
		query.append("		AND	C.IMDG_CRR_RSTR_EXPT_CD is null" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	C.IMDG_CRR_RSTR_EXPT_CD LIKE '%'||@[imdg_crr_rstr_expt_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_tec_nm} != '')" ).append("\n"); 
		query.append("	AND	UPPER(A.PRP_SHP_NM) LIKE '%'||UPPER(@[imdg_tec_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("ORDER BY A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${start_page} != '')" ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}