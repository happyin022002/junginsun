/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddScgPrnrSpclCgoTrsmHdr
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO                        " ).append("\n"); 
		query.append("	   SCG_PRNR_SPCL_CGO_TRSM_DTL" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          TRSM_BND_CD" ).append("\n"); 
		query.append("        , TRSM_DT" ).append("\n"); 
		query.append("        , SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("        , PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("        , PRNR_SPCL_CGO_SUB_SEQ" ).append("\n"); 
		query.append("        , CNTR_REF_NO" ).append("\n"); 
		query.append("        , CNTR_DMY_REF_NO" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD_CTNT" ).append("\n"); 
		query.append("        , ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  ---------------------------------------------------" ).append("\n"); 
		query.append("        , CNTR_SEQ" ).append("\n"); 
		query.append("        , EDI_ITM_SEQ    -- :2015-07-25: --" ).append("\n"); 
		query.append("        , CGO_SEQ" ).append("\n"); 
		query.append(" 		, DCGO_SEQ" ).append("\n"); 
		query.append("		  ---------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , DCGO_STS_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, DCGO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , MVMT_SPCL_TP_CD" ).append("\n"); 
		query.append("        , OUT_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("        , OUT_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("        , OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("        , INTMD_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("        , INTMD_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("        , INTMD_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("        , IN_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("        , IN_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("        , IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("        , HZD_DESC" ).append("\n"); 
		query.append("        , PRP_SHP_NM" ).append("\n"); 
		query.append("        , IMDG_TEC_NM" ).append("\n"); 
		query.append("        , IMDG_CLSS_CD_CTNT" ).append("\n"); 
		query.append("        , IMDG_PPR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, IMDG_AMDT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , IMDG_UN_NO_CTNT" ).append("\n"); 
		query.append("        , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("        , CFR_FLG" ).append("\n"); 
		query.append("        , CFR_NO" ).append("\n"); 
		query.append("        , FLSH_PNT_UT_CD_CTNT" ).append("\n"); 
		query.append("        , FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("        , IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("        , EMS_NO" ).append("\n"); 
		query.append("        , MFAG_NO" ).append("\n"); 
		query.append("        , ESP_NO" ).append("\n"); 
		query.append("        , IMDG_MRN_POLUT_FLG" ).append("\n"); 
		query.append("        , IMDG_MRN_POLUT_CD_CTNT" ).append("\n"); 
		query.append("        , IMDG_LMT_QTY_FLG_CTNT" ).append("\n"); 
		query.append("        , IMDG_EXPT_QTY_FLG_CTNT" ).append("\n"); 
		query.append("        , GRS_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("        , GRS_WGT_CTNT" ).append("\n"); 
		query.append("        , NET_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("        , NET_WGT_CTNT" ).append("\n"); 
		query.append("        , NET_EXPLO_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("        , NET_EXPLO_WGT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , PCK_TP_CD_CTNT" ).append("\n"); 
		query.append("        , PCK_QTY_CTNT" ).append("\n"); 
		query.append("        , DIFF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("        , EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("        , PSA_NO" ).append("\n"); 
		query.append("        , SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("        , RSD_FLG_CTNT" ).append("\n"); 
		query.append("        , CGO_UPD_STS_CD" ).append("\n"); 
		query.append("        , AUTO_UPD_RSLT_CD" ).append("\n"); 
		query.append("        , EDI_ELEM_CNG_CTNT" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, IMDG_COMP_GRP_CD		" ).append("\n"); 
		query.append("		, N1ST_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N2ND_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N3RD_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N4TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N5TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N6TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N7TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("		, N8TH_IMDG_SUBS_RSK_LBL_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, EDI_CGO_UNMAP_DTL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--::2015-10-22::--" ).append("\n"); 
		query.append("		, DCGO_DTL_STS_CD" ).append("\n"); 
		query.append("		, IMDG_ADD_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, IMDG_N1ST_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, IMDG_N2ND_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, IMDG_N3RD_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, IMDG_N4TH_SEGR_GRP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT C.TRSM_BND_CD" ).append("\n"); 
		query.append("     , C.TRSM_DT" ).append("\n"); 
		query.append("     , C.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("     , C.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --:2015-07-25:--, C.PRNR_SPCL_CGO_SUB_SEQ" ).append("\n"); 
		query.append("	 , MP.CGO_MAPG_SEQ		AS NEW_PRNR_SPCL_CGO_SUB_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     --:2015-09-02:--, C.CNTR_REF_NO" ).append("\n"); 
		query.append("	 , MP.CNTR_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , '' CNTR_DMY_REF_NO" ).append("\n"); 
		query.append("     , B.CNTR_TPSZ_CD_CTNT" ).append("\n"); 
		query.append("     , B.ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 --------------------------------------------------" ).append("\n"); 
		query.append("     --::2015-05-30::--, B.CNTR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , MP.CNTR_SEQ" ).append("\n"); 
		query.append("     , C.EDI_ITM_SEQ        AS EDI_ITM_SEQ      -- TO-BE >> C.EDI_ITM_SEQ :2015-07-25: --    " ).append("\n"); 
		query.append("     , MP.CGO_SEQ      " ).append("\n"); 
		query.append("     --::2015-05-30::--, C.CGO_SEQ" ).append("\n"); 
		query.append("	 , MP.CGO_MAPG_SEQ		AS DCGO_SEQ" ).append("\n"); 
		query.append("     --------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.DCGO_STS_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , C.DCGO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.MVMT_SPCL_TP_CD" ).append("\n"); 
		query.append("     , C.OUT_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("     , C.OUT_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("     , C.OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("     , C.INTMD_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("     , C.INTMD_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("     , C.INTMD_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("     , C.IN_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("     , C.IN_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("     , C.IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("     , C.HZD_DESC" ).append("\n"); 
		query.append("     , C.PRP_SHP_NM" ).append("\n"); 
		query.append("     , C.IMDG_TEC_NM" ).append("\n"); 
		query.append("     , C.IMDG_CLSS_CD_CTNT" ).append("\n"); 
		query.append("     , C.IMDG_PPR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , C.IMDG_AMDT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.IMDG_UN_NO_CTNT" ).append("\n"); 
		query.append("     , C.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("     , C.CFR_FLG" ).append("\n"); 
		query.append("     , C.CFR_NO" ).append("\n"); 
		query.append("     , C.FLSH_PNT_UT_CD_CTNT" ).append("\n"); 
		query.append("     , C.FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("     , C.IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("     , C.EMS_NO" ).append("\n"); 
		query.append("     , C.MFAG_NO" ).append("\n"); 
		query.append("     , C.ESP_NO" ).append("\n"); 
		query.append("     , C.IMDG_MRN_POLUT_FLG" ).append("\n"); 
		query.append("     , C.IMDG_MRN_POLUT_CD_CTNT" ).append("\n"); 
		query.append("     , C.IMDG_LMT_QTY_FLG_CTNT" ).append("\n"); 
		query.append("     , C.IMDG_EXPT_QTY_FLG_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.GRS_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("     , C.GRS_WGT_CTNT/(SELECT   COUNT(1) " ).append("\n"); 
		query.append("                       FROM     SCG_PRNR_SPCL_CGO_SEQ_MAPG MPP " ).append("\n"); 
		query.append("                       WHERE    MPP.PRNR_SPCL_CGO_SEQ      = MP.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                       AND      MPP.EDI_ITM_SEQ            = MP.EDI_ITM_SEQ" ).append("\n"); 
		query.append("                       )        AS GRS_WGT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.NET_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("     , C.NET_WGT_CTNT/(SELECT   COUNT(1) " ).append("\n"); 
		query.append("                       FROM     SCG_PRNR_SPCL_CGO_SEQ_MAPG MPP " ).append("\n"); 
		query.append("                       WHERE    MPP.PRNR_SPCL_CGO_SEQ      = MP.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                       AND      MPP.EDI_ITM_SEQ            = MP.EDI_ITM_SEQ" ).append("\n"); 
		query.append("                       )        AS NET_WGT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.NET_EXPLO_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("     , C.NET_EXPLO_WGT_CTNT/(SELECT   COUNT(1) " ).append("\n"); 
		query.append("                       		 FROM     SCG_PRNR_SPCL_CGO_SEQ_MAPG MPP " ).append("\n"); 
		query.append("                       		 WHERE    MPP.PRNR_SPCL_CGO_SEQ      = MP.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                       		 AND      MPP.EDI_ITM_SEQ            = MP.EDI_ITM_SEQ" ).append("\n"); 
		query.append("                       		 )        AS NET_EXPLO_WGT_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.PCK_TP_CD_CTNT" ).append("\n"); 
		query.append("     , C.PCK_QTY_CTNT" ).append("\n"); 
		query.append("     , C.DIFF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("     , C.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("     , C.PSA_NO" ).append("\n"); 
		query.append("     , C.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , C.RSD_FLG_CTNT" ).append("\n"); 
		query.append("     , '' CGO_UPD_STS_CD" ).append("\n"); 
		query.append("     , '' AUTO_UPD_RSLT_CD" ).append("\n"); 
		query.append("     , '' EDI_ELEM_CNG_CTNT" ).append("\n"); 
		query.append("     , C.CRE_USR_ID" ).append("\n"); 
		query.append("     , C.CRE_DT" ).append("\n"); 
		query.append("     , C.UPD_USR_ID" ).append("\n"); 
		query.append("     , C.UPD_DT" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("	,	C.IMDG_COMP_GRP_CD		" ).append("\n"); 
		query.append("	,	C.N1ST_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N2ND_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N3RD_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N4TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N5TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N6TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N7TH_IMDG_SUBS_RSK_LBL_CD    " ).append("\n"); 
		query.append("	,	C.N8TH_IMDG_SUBS_RSK_LBL_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   C.EDI_CGO_UNMAP_DTL_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-10-22::-- " ).append("\n"); 
		query.append("	,	C.DCGO_DTL_STS_CD_CTNT" ).append("\n"); 
		query.append("	,	(SELECT X.IMDG_SEGR_GRP_NO FROM SCG_IMDG_SEGR_GRP X WHERE UPPER(X.IMDG_SEGR_GRP_NM) = TRIM(UPPER(C.IMDG_ADD_SEGR_GRP_NO_CTNT)))" ).append("\n"); 
		query.append("	,	SUBSTR(C.IMDG_SEGR_GRP_NO_CTNT,1,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,1)-1) 																					AS IMDG_N1ST_SEGR_GRP_NO  " ).append("\n"); 
		query.append("     ,  SUBSTR(C.IMDG_SEGR_GRP_NO_CTNT,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,1)+1,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,2)-INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,1)-1) 	AS IMDG_N2ND_SEGR_GRP_NO" ).append("\n"); 
		query.append("     ,  SUBSTR(C.IMDG_SEGR_GRP_NO_CTNT,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,2)+1,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,3)-INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,2)-1) 	AS IMDG_N3RD_SEGR_GRP_NO" ).append("\n"); 
		query.append("     ,  SUBSTR(C.IMDG_SEGR_GRP_NO_CTNT,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,3)+1,INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,4)-INSTR(C.IMDG_SEGR_GRP_NO_CTNT,'*',1,3)-1) 	AS IMDG_N4TH_SEGR_GRP_NO" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	,	C.CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM SCG_PRNR_SPCL_CGO_TRSM_HDR 	A" ).append("\n"); 
		query.append("    , SCG_PRNR_SPCL_CGO_CNTR_LOG 	B" ).append("\n"); 
		query.append("    , SCG_PRNR_SPCL_CGO_DTL_LOG  	C" ).append("\n"); 
		query.append("	, SCG_PRNR_SPCL_CGO_SEQ_MAPG 	MP" ).append("\n"); 
		query.append("WHERE A.TRSM_BND_CD       			= @[trsm_bnd_cd]" ).append("\n"); 
		query.append("  AND A.TRSM_DT           			= TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("  AND A.SPCL_CGO_CATE_CD  			= @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("  AND A.PRNR_SPCL_CGO_SEQ 			= @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("  AND A.TRSM_BND_CD       			= B.TRSM_BND_CD" ).append("\n"); 
		query.append("  AND A.TRSM_DT           			= B.TRSM_DT" ).append("\n"); 
		query.append("  AND A.SPCL_CGO_CATE_CD  			= B.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("  AND A.PRNR_SPCL_CGO_SEQ 			= B.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("  AND A.TRSM_BND_CD       			= C.TRSM_BND_CD" ).append("\n"); 
		query.append("  AND A.TRSM_DT           			= C.TRSM_DT" ).append("\n"); 
		query.append("  AND A.SPCL_CGO_CATE_CD  			= C.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("  AND A.PRNR_SPCL_CGO_SEQ 			= C.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ----------------------------------------------------------------" ).append("\n"); 
		query.append("  AND A.PRNR_SPCL_CGO_SEQ 			= MP.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("  AND B.CNTR_SEQ          			= MP.CNTR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND C.EDI_ITM_SEQ       			= MP.EDI_ITM_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  /* 2015-07-28 AND C.CGO_SEQ       = MP.EDI_ITM_SEQ */" ).append("\n"); 
		query.append("  ----------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                    FROM SCG_PRNR_SPCL_CGO_TRSM_ERR ERR" ).append("\n"); 
		query.append("                   WHERE A.TRSM_BND_CD       = ERR.TRSM_BND_CD" ).append("\n"); 
		query.append("                     AND A.TRSM_DT           = ERR.TRSM_DT" ).append("\n"); 
		query.append("                     AND A.SPCL_CGO_CATE_CD  = ERR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                     AND A.PRNR_SPCL_CGO_SEQ = ERR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                    FROM SCG_PRNR_SPCL_CGO_DTL_ERR ERR" ).append("\n"); 
		query.append("                   WHERE C.TRSM_BND_CD           = ERR.TRSM_BND_CD" ).append("\n"); 
		query.append("                     AND C.TRSM_DT               = ERR.TRSM_DT" ).append("\n"); 
		query.append("                     AND C.SPCL_CGO_CATE_CD      = ERR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                     AND C.PRNR_SPCL_CGO_SEQ     = ERR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                     AND C.PRNR_SPCL_CGO_SUB_SEQ = ERR.PRNR_SPCL_CGO_SUB_SEQ				" ).append("\n"); 
		query.append("                 )" ).append("\n"); 

	}
}