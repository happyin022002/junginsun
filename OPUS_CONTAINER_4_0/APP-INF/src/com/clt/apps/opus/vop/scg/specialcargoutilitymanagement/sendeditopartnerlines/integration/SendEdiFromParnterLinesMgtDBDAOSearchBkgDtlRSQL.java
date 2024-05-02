/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOSearchBkgDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOSearchBkgDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flatFile  detail정보 조회 
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOSearchBkgDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOSearchBkgDtlRSQL").append("\n"); 
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
		query.append("SELECT	  X.BKG_NO" ).append("\n"); 
		query.append("		, X.DCGO_SEQ" ).append("\n"); 
		query.append("		, X.DG_CNTR_SEQ" ).append("\n"); 
		query.append("		, X.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, X.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--------------------------------------------------------------------------------" ).append("\n"); 
		query.append("    	, 	(" ).append("\n"); 
		query.append("      		SELECT   	MAX(LL.CNTR_DMY_REF_NO)" ).append("\n"); 
		query.append("      		FROM     	SCG_APRO_RQST                  XX" ).append("\n"); 
		query.append("            		,  	SCG_VVD_APRO_RQST              YY" ).append("\n"); 
		query.append("            		,  	SCG_PRNR_SPCL_CGO_DTL_LOG      LL" ).append("\n"); 
		query.append("      		WHERE    	1 = 1" ).append("\n"); 
		query.append("      		AND      	XX.BKG_NO                      = YY.BKG_NO" ).append("\n"); 
		query.append("      		AND      	XX.SPCL_CGO_APRO_RQST_SEQ      = YY.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("      		AND      	YY.MAPG_TRSM_BND_CD            = LL.TRSM_BND_CD            --(+)" ).append("\n"); 
		query.append("      		AND      	YY.MAPG_TRSM_DT                = LL.TRSM_DT                --(+)" ).append("\n"); 
		query.append("      		AND      	YY.MAPG_TRSM_SPCL_CGO_CATE_CD  = LL.SPCL_CGO_CATE_CD       --(+)  FIXED 'DG'" ).append("\n"); 
		query.append("      		AND      	YY.MAPG_PRNR_SPCL_CGO_SEQ      = LL.PRNR_SPCL_CGO_SEQ      --(+)" ).append("\n"); 
		query.append("      		AND      	YY.MAPG_EDI_TRSM_STS_CD        = 'S'       " ).append("\n"); 
		query.append("      		AND      	LL.PRNR_SPCL_CGO_SEQ           = (	SELECT   MAX(L.PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("                                                 			FROM     SCG_PRNR_SPCL_CGO_DTL_LOG L" ).append("\n"); 
		query.append("                                                 			WHERE    L.TRSM_BND_CD             = LL.TRSM_BND_CD" ).append("\n"); 
		query.append("                                                 			AND      L.TRSM_DT                 = LL.TRSM_DT" ).append("\n"); 
		query.append("                                                 			AND      L.SPCL_CGO_CATE_CD        = LL.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                                                 		 )                " ).append("\n"); 
		query.append("      		AND      	LL.DCGO_SEQ                    = X.DCGO_SEQ            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      		AND      	XX.BKG_NO                      = X.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      		----AND      	YY.VSL_PRE_PST_CD          = [vsl_pre_pst_cd]" ).append("\n"); 
		query.append("      		----AND      	YY.VSL_SEQ                 = [vsl_seq]    " ).append("\n"); 
		query.append("      		) 			AS CNTR_DMY_REF_NO" ).append("\n"); 
		query.append("		--------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, X.CNTR_VOL_QTY" ).append("\n"); 
		query.append("		, X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, (	SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("	     	FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("	    	WHERE A.CNTR_TPSZ_CD = X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	      	AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("  		, 	CASE 	WHEN X.CFR_FLG IS NULL THEN NULL" ).append("\n"); 
		query.append("         			WHEN X.IMDG_AMDT_NO IS NOT NULL THEN X.IMDG_AMDT_NO" ).append("\n"); 
		query.append("         			ELSE (	SELECT  MAX(UN.IMDG_AMDT_NO)" ).append("\n"); 
		query.append("               				FROM    SCG_IMDG_UN_NO    UN" ).append("\n"); 
		query.append("               				WHERE   UN.IMDG_UN_NO     = X.IMDG_UN_NO" ).append("\n"); 
		query.append("               				AND     UN.IMDG_UN_NO_SEQ = X.IMDG_UN_NO_SEQ)" ).append("\n"); 
		query.append("    		END  IMDG_AMDT_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("		, X.IMDG_UN_NO" ).append("\n"); 
		query.append("		, X.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("		, X.IMDG_CLSS_CD" ).append("\n"); 
		query.append("		, X.IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("		, X.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("		, X.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("		, X.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("		, X.IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--, X.IMDG_SUBS_RSK_LBL_CD5" ).append("\n"); 
		query.append("		--, X.IMDG_SUBS_RSK_LBL_CD6" ).append("\n"); 
		query.append("		--, X.IMDG_SUBS_RSK_LBL_CD7" ).append("\n"); 
		query.append("		--, X.IMDG_SUBS_RSK_LBL_CD8" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, X.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("		, X.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("		, X.NET_WGT" ).append("\n"); 
		query.append("		, X.GRS_WGT" ).append("\n"); 
		query.append("		, DECODE(NVL(X.WGT_UT_CD, 'KGS'),'KGS','KGM') WGT_UT_CD " ).append("\n"); 
		query.append("		, X.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("		, X.PRP_SHP_NM" ).append("\n"); 
		query.append("		, X.HZD_DESC" ).append("\n"); 
		query.append("		, X.MEAS_QTY" ).append("\n"); 
		query.append("		, X.MEAS_UT_CD" ).append("\n"); 
		query.append("		, X.CLOD_FLG" ).append("\n"); 
		query.append("		, X.SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("		, X.DCGO_STS_CD" ).append("\n"); 
		query.append("		, X.CGO_LCL_FLG" ).append("\n"); 
		query.append("		, X.EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("		, X.EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("		, X.EMER_CNTC_PHN_NO_CTNT" ).append("\n"); 
		query.append("		, X.EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("		, X.EMER_TEMP_CTNT" ).append("\n"); 
		query.append("		, X.CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--:2016-05-03:--, X.EMS_NO" ).append("\n"); 
		query.append("		, REPLACE(REPLACE(X.EMS_NO,'-',''),',','/')		AS EMS_NO" ).append("\n"); 
		query.append("		, X.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("		, X.MRN_POLUT_FLG" ).append("\n"); 
		query.append("		, X.PSA_NO" ).append("\n"); 
		query.append("		, X.CERTI_NO" ).append("\n"); 
		query.append("		, X.IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("		, X.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("		, (	SELECT IMDG_PCK_DESC " ).append("\n"); 
		query.append("	     	FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("	    	WHERE IMDG_PCK_CD = X.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("	      	AND IMDG_PCK_TP_CD = 'I'" ).append("\n"); 
		query.append("	      	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		) IN_IMDG_PCK_DESC1" ).append("\n"); 
		query.append("		, IN_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("		, IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append("		, (	SELECT IMDG_PCK_DESC " ).append("\n"); 
		query.append("	     	FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("	    	WHERE IMDG_PCK_CD = X.IN_IMDG_PCK_CD2" ).append("\n"); 
		query.append("	      	AND IMDG_PCK_TP_CD = 'I'" ).append("\n"); 
		query.append("	      	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		) IN_IMDG_PCK_DESC2" ).append("\n"); 
		query.append("		, INTMD_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("		, INTMD_IMDG_PCK_CD1" ).append("\n"); 
		query.append("		, (	SELECT IMDG_PCK_DESC " ).append("\n"); 
		query.append("	     	FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("	    	WHERE IMDG_PCK_CD = X.INTMD_IMDG_PCK_CD1" ).append("\n"); 
		query.append("	      	AND IMDG_PCK_TP_CD = 'M'" ).append("\n"); 
		query.append("	      	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		) INTMD_IMDG_PCK_DESC1" ).append("\n"); 
		query.append("		, INTMD_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("		, INTMD_IMDG_PCK_CD2" ).append("\n"); 
		query.append("		, (	SELECT IMDG_PCK_DESC " ).append("\n"); 
		query.append("	     	FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("	    	WHERE IMDG_PCK_CD = INTMD_IMDG_PCK_CD2" ).append("\n"); 
		query.append("	      	AND IMDG_PCK_TP_CD = 'M'" ).append("\n"); 
		query.append("	      	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		) INTMD_IMDG_PCK_DESC2" ).append("\n"); 
		query.append("		, OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("		, OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("		, (	SELECT IMDG_PCK_DESC " ).append("\n"); 
		query.append("	     	FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("	    	WHERE IMDG_PCK_CD = X.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("	      	AND IMDG_PCK_TP_CD = 'O'" ).append("\n"); 
		query.append("	      	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		) OUT_IMDG_PCK_DESC1" ).append("\n"); 
		query.append("		, OUT_IMDG_PCK_QTY2" ).append("\n"); 
		query.append("		, OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append("		, (	SELECT IMDG_PCK_DESC " ).append("\n"); 
		query.append("	     	FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("	    	WHERE IMDG_PCK_CD = X.OUT_IMDG_PCK_CD2" ).append("\n"); 
		query.append("	      	AND IMDG_PCK_TP_CD = 'O'" ).append("\n"); 
		query.append("	      	AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  		) OUT_IMDG_PCK_DESC2" ).append("\n"); 
		query.append("		, X.MAX_IN_PCK_QTY" ).append("\n"); 
		query.append("		, X.MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append("		, X.CNEE_DTL_DESC" ).append("\n"); 
		query.append("		, X.NET_EXPLO_WGT" ).append("\n"); 
		query.append("		, X.RADA_SKD_NO" ).append("\n"); 
		query.append("		, X.RADA_AMT" ).append("\n"); 
		query.append("		, X.RADA_UT_CD" ).append("\n"); 
		query.append("		, X.RC_FLG" ).append("\n"); 
		query.append("		, X.AWK_CGO_FLG" ).append("\n"); 
		query.append("		, X.BB_CGO_FLG" ).append("\n"); 
		query.append("		, X.RC_SEQ" ).append("\n"); 
		query.append("		, X.AWK_CGO_SEQ" ).append("\n"); 
		query.append("		, X.BB_CGO_SEQ" ).append("\n"); 
		query.append("		, X.HCDG_FLG" ).append("\n"); 
		query.append("  		, X.HCDG_DPND_QTY_FLG" ).append("\n"); 
		query.append("  		, X.RQST_DT" ).append("\n"); 
		query.append("  		, X.RQST_GDT" ).append("\n"); 
		query.append("  		, X.RQST_USR_ID" ).append("\n"); 
		query.append("  		, X.APLY_NO" ).append("\n"); 
		query.append("  		, X.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("  		, X.SPCL_RQST_FLG" ).append("\n"); 
		query.append("  		, X.SPCL_RQST_DESC" ).append("\n"); 
		query.append("  		, REPLACE(REPLACE(X.DIFF_RMK,CHR(13),''),CHR(10),' ') DIFF_RMK" ).append("\n"); 
		query.append("  		, X.CRE_USR_ID" ).append("\n"); 
		query.append("  		, X.CRE_DT" ).append("\n"); 
		query.append("  		, X.UPD_USR_ID" ).append("\n"); 
		query.append("  		, X.UPD_DT" ).append("\n"); 
		query.append("  		, X.RADA_TRSP_NO" ).append("\n"); 
		query.append("  		, X.HZD_CTNT" ).append("\n"); 
		query.append("  		, X.STWG_TEMP_CTNT" ).append("\n"); 
		query.append("  		, X.GRS_CAPA_QTY" ).append("\n"); 
		query.append("  		, X.DCGO_RQST_GRP_EML1" ).append("\n"); 
		query.append("  		, X.DCGO_RQST_GRP_EML2" ).append("\n"); 
		query.append("  		, X.CFR_FLG" ).append("\n"); 
		query.append("  		, X.RSD_FLG" ).append("\n"); 
		query.append("  		, X.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, (SELECT SG.IMDG_SEGR_GRP_NM FROM SCG_IMDG_SEGR_GRP SG WHERE SG.IMDG_SEGR_GRP_NO = X.IMDG_SEGR_GRP_NO)						AS IMDG_SEGR_GRP_NM" ).append("\n"); 
		query.append("     	, X.DCGO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		--::2015-10-22::--" ).append("\n"); 
		query.append("  		, (SELECT MAX(DECODE(ROWNUM, 1, D.IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL D WHERE D.IMDG_UN_NO = X.IMDG_UN_NO) 	AS IMDG_N1ST_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, (SELECT MAX(DECODE(ROWNUM, 2, D.IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL D WHERE D.IMDG_UN_NO = X.IMDG_UN_NO) 	AS IMDG_N2ND_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, (SELECT MAX(DECODE(ROWNUM, 3, D.IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL D WHERE D.IMDG_UN_NO = X.IMDG_UN_NO) 	AS IMDG_N3RD_SEGR_GRP_NO" ).append("\n"); 
		query.append("		, (SELECT MAX(DECODE(ROWNUM, 4, D.IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL D WHERE D.IMDG_UN_NO = X.IMDG_UN_NO) 	AS IMDG_N4TH_SEGR_GRP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	--,	(	SELECT	MAX(T1.DG_CNTR_SEQ)" ).append("\n"); 
		query.append("        --  		FROM    BKG_DG_CGO   		T1" ).append("\n"); 
		query.append("        --  		WHERE	T1.BKG_NO    		= X.BKG_NO" ).append("\n"); 
		query.append("        --  	)	AS 		TTL_CNTR_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, X.CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("FROM	  BKG_DG_CGO 						X" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.BKG_NO 							= @[bkg_no]" ).append("\n"); 
		query.append("AND 	  X.SPCL_CGO_APRO_CD 				NOT IN ('C','D','N')" ).append("\n"); 
		query.append("--AND 	  X.SPCL_CGO_APRO_CD 				IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY  X.DG_CNTR_SEQ        ASC" ).append("\n"); 
		query.append("      ,   X.CNTR_CGO_SEQ       ASC" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("--ORDER BY  X.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--        , X.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("--        , X.DG_CNTR_SEQ" ).append("\n"); 

	}
}