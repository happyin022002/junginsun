/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOsearchEdiCancelRequestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOsearchEdiCancelRequestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG EDI CANCEL 대상 조회
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOsearchEdiCancelRequestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOsearchEdiCancelRequestListRSQL").append("\n"); 
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
		query.append("SELECT	ROW_NUMBER() OVER(" ).append("\n"); 
		query.append("			PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.BKG_NO " ).append("\n"); 
		query.append("				ORDER BY A.VSL_CD, A.SKD_VOY_NO ,A.SKD_DIR_CD, A.BKG_NO, A.DG_CNTR_SEQ, A.CNTR_CGO_SEQ ASC) AS NO, " ).append("\n"); 
		query.append("	    DENSE_RANK() OVER(ORDER BY A.VSL_CD, A.SKD_VOY_NO ,A.SKD_DIR_CD, A.BKG_NO) AS RANK_SEQ," ).append("\n"); 
		query.append("		A.BKG_NO AS BOOKING_NO," ).append("\n"); 
		query.append("        A.BKG_STS_CD,  " ).append("\n"); 
		query.append("        A.DG_CNTR_SEQ, " ).append("\n"); 
		query.append("        A.CNTR_CGO_SEQ, " ).append("\n"); 
		query.append("        ROUND(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE) - A.RQST_GDT,1) AS RQST_DAY, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',DECODE(A.SPCL_RQST_FLG,'Y','S','')||'R'||A.SPCL_CGO_RQST_SEQ,G.SPCL_CGO_AUTH_CD) AS SPCL_CGO_AUTH_CD, " ).append("\n"); 
		query.append("		G.SPCL_CGO_AUTH_RJCT_CD, " ).append("\n"); 
		query.append("        G.APRO_REF_NO," ).append("\n"); 
		query.append("        A.DCGO_REF_NO," ).append("\n"); 
		query.append("        DECODE(A.MAPG_EDI_TRSM_STS_CD , 'SX' , 'Y' , '') AS EDI_SND_NO," ).append("\n"); 
		query.append("        CASE WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                     FROM SCG_VVD_APRO_RQST RQ" ).append("\n"); 
		query.append("                    WHERE 1 = 1" ).append("\n"); 
		query.append("                      AND RQ.BKG_NO = BKG_NO" ).append("\n"); 
		query.append("                      AND RQ.VSL_PRE_PST_CD = VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                      AND RQ.VSL_SEQ = VSL_SEQ" ).append("\n"); 
		query.append("                      AND RQ.VSL_CD = VSL_CD" ).append("\n"); 
		query.append("                      AND RQ.SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND RQ.SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND RQ.MAPG_EDI_TRSM_STS_CD = 'S' ) > 0 THEN 'Y'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END EDI_SND_HIS_FLG , " ).append("\n"); 
		query.append("	    (SELECT DECODE(EML_PROC_STS_CD,'1','W', " ).append("\n"); 
		query.append("                                       '3','Y', " ).append("\n"); 
		query.append("                                       '4','F', " ).append("\n"); 
		query.append("                                       '')  " ).append("\n"); 
		query.append("		FROM   COM_EML_SND_INFO " ).append("\n"); 
		query.append("        WHERE  EML_SND_NO = A.EML_SND_NO) AS EML_SND_NO, " ).append("\n"); 
		query.append("        CASE WHEN LENGTH(NVL(TRIM(A.EML_SND_NO),0)) = 1 AND A.CRR_CD IN ('HLC', 'OOL', 'HMM', 'HSD')	/*'HAM'*/" ).append("\n"); 
		query.append("             	THEN 'Y'" ).append("\n"); 
		query.append("			 WHEN LENGTH(NVL(TRIM(A.EML_SND_NO),0)) > 1" ).append("\n"); 
		query.append("				THEN 'S'" ).append("\n"); 
		query.append("             ELSE 'N' " ).append("\n"); 
		query.append("         END EML_CHK,  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        A.SLAN_CD, " ).append("\n"); 
		query.append("        A.VSL_CD, " ).append("\n"); 
		query.append("	    A.VSL_ENG_NM AS VSL_NM," ).append("\n"); 
		query.append("        A.SKD_VOY_NO," ).append("\n"); 
		query.append("        A.SKD_DIR_CD," ).append("\n"); 
		query.append("        A.PRP_SHP_NM," ).append("\n"); 
		query.append("        A.DIFF_RMK," ).append("\n"); 
		query.append("        DECODE(A.DCGO_STS_CD, 'L', 'Liquid', 'G', 'GAS', 'P', 'PASTE', 'S', 'SOLID','') DCGO_STS_CD," ).append("\n"); 
		query.append("        A.CRR_CD," ).append("\n"); 
		query.append("        '' CRR_CODE," ).append("\n"); 
		query.append("        A.POR_CD, " ).append("\n"); 
		query.append("        A.POL_CD, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        CASE WHEN A.CRR_CD IN ('HLC', 'OOL', 'HMM', 'HSD') THEN " ).append("\n"); 
		query.append("	         (SELECT CASE WHEN A.CRR_CD = 'HLC' AND CONTI_CD IN ('A', 'E', 'M') THEN 'Y'" ).append("\n"); 
		query.append("                          WHEN A.CRR_CD IN ('OOL', 'HMM', 'HSD') AND CONTI_CD = 'E' THEN 'Y'" ).append("\n"); 
		query.append("                     ELSE 'N'" ).append("\n"); 
		query.append("                 END EDI_CHK" ).append("\n"); 
		query.append("                FROM MDM_LOCATION " ).append("\n"); 
		query.append("               WHERE LOC_CD = A.POL_CD" ).append("\n"); 
		query.append("                 AND NVL(DELT_FLG, 'N') <> 'Y'	" ).append("\n"); 
		query.append("		     )" ).append("\n"); 
		query.append("        END EDI_CHK ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        A.MAPG_TRSM_BND_CD," ).append("\n"); 
		query.append("        A.MAPG_TRSM_DT," ).append("\n"); 
		query.append("        A.MAPG_TRSM_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("        A.MAPG_PRNR_SPCL_CGO_SEQ," ).append("\n"); 
		query.append("        A.MAPG_EDI_TRSM_STS_CD," ).append("\n"); 
		query.append("		TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT," ).append("\n"); 
		query.append("        A.POD_CD, " ).append("\n"); 
		query.append("        A.DEL_CD, " ).append("\n"); 
		query.append("        A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("        'DD' AS DG_TP, " ).append("\n"); 
		query.append("        A.IMDG_UN_NO, " ).append("\n"); 
		query.append("        ( SELECT LISTAGG (X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM, ',') WITHIN GROUP (ORDER BY X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM)" ).append("\n"); 
		query.append("            FROM SCG_IMDG_SEGR_GRP X" ).append("\n"); 
		query.append("               , SCG_IMDG_SEGR_GRP_DTL Y" ).append("\n"); 
		query.append("           WHERE X.IMDG_SEGR_GRP_NO = Y.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("             AND Y.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("           GROUP BY Y.IMDG_UN_NO " ).append("\n"); 
		query.append("        ) IMDG_SEGR_GRP_NM, " ).append("\n"); 
		query.append("        A.IMDG_UN_NO_SEQ, " ).append("\n"); 
		query.append("        A.IMDG_CLSS_CD, " ).append("\n"); 
		query.append("        A.IMDG_SUBS_RSK_LBL_CD1 " ).append("\n"); 
		query.append("        ||DECODE(A.IMDG_SUBS_RSK_LBL_CD2,NULL,NULL,'/') " ).append("\n"); 
		query.append("        ||A.IMDG_SUBS_RSK_LBL_CD2 " ).append("\n"); 
		query.append("		||DECODE(A.IMDG_SUBS_RSK_LBL_CD3,NULL,NULL,'/') " ).append("\n"); 
		query.append("        ||A.IMDG_SUBS_RSK_LBL_CD3 " ).append("\n"); 
		query.append("        ||DECODE(A.IMDG_SUBS_RSK_LBL_CD4,NULL,NULL, '/') " ).append("\n"); 
		query.append("        ||A.IMDG_SUBS_RSK_LBL_CD4 AS IMDG_SUBS_RSK_LBL_CD, 		 " ).append("\n"); 
		query.append("        A.MRN_POLUT_FLG, " ).append("\n"); 
		query.append("        DECODE(A.IMDG_PCK_GRP_CD,'N',NULL, " ).append("\n"); 
		query.append("                                 '1','I', " ).append("\n"); 
		query.append("                                 '2','II', " ).append("\n"); 
		query.append("                                 '3','III') AS IMDG_PCK_GRP_CD, " ).append("\n"); 
		query.append("        A.IMDG_LMT_QTY_FLG, " ).append("\n"); 
		query.append("        A.IMDG_EXPT_QTY_FLG, " ).append("\n"); 
		query.append("        A.FLSH_PNT_CDO_TEMP, " ).append("\n"); 
		query.append("        A.GRS_WGT, " ).append("\n"); 
		query.append("        A.NET_WGT, " ).append("\n"); 
		query.append("        A.PSA_NO, " ).append("\n"); 
		query.append("        A.HCDG_FLG, " ).append("\n"); 
		query.append("        A.BKG_NO, " ).append("\n"); 
		query.append("        A.SPCL_CGO_APRO_RQST_SEQ, " ).append("\n"); 
		query.append("        A.SPCL_CGO_RQST_SEQ, " ).append("\n"); 
		query.append("        A.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("        A.VSL_SEQ, " ).append("\n"); 
		query.append("        A.CNTR_NO, " ).append("\n"); 
		query.append("        A.DCGO_SEQ, " ).append("\n"); 
		query.append("        A.DCGO_QTY, " ).append("\n"); 
		query.append("        A.LST_RQST_DAT_FLG, " ).append("\n"); 
		query.append("        A.BKG_RCV_TERM_CD, " ).append("\n"); 
		query.append("        A.BKG_DE_TERM_CD, " ).append("\n"); 
		query.append("        A.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("        A.POD_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("        A.POL_YD_CD, " ).append("\n"); 
		query.append("        A.POD_YD_CD, " ).append("\n"); 
		query.append("        A.RGN_SHP_OPR_CD, " ).append("\n"); 
		query.append("        A.SPCL_CGO_CATE_CD, " ).append("\n"); 
		query.append("        G.SPCL_CGO_AUTH_NO, " ).append("\n"); 
		query.append("        G.AUTH_OFC_CD, " ).append("\n"); 
		query.append("        G.SPCL_CGO_AUTH_SEQ, " ).append("\n"); 
		query.append("        SCG_GET_MPA1_NET_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.POL_CD, " ).append("\n"); 
		query.append("                             A.POD_CD,A.IMDG_CLSS_CD) AS NET_WGT_SUM, " ).append("\n"); 
		query.append("        '' AS SCG_FLG, " ).append("\n"); 
		query.append("        '' AS RQST_AUTH_CD, " ).append("\n"); 
		query.append("        A.RQST_OFC_CD, " ).append("\n"); 
		query.append("        TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT, " ).append("\n"); 
		query.append("        TO_CHAR(A.RQST_GDT,'YYYY-MM-DD HH24:MI') AS RQST_GDT, " ).append("\n"); 
		query.append("        A.RQST_USR_ID, " ).append("\n"); 
		query.append("        TO_CHAR(G.AUTH_DT,'YYYY-MM-DD HH24:MI')AS AUTH_DT, " ).append("\n"); 
		query.append("        TO_CHAR(G.AUTH_GDT,'YYYY-MM-DD HH24:MI')AS AUTH_GDT, " ).append("\n"); 
		query.append("        G.AUTH_USR_ID, " ).append("\n"); 
		query.append("        G.SPCL_CGO_AUTH_RMK, " ).append("\n"); 
		query.append("        A.SPCL_RQST_DESC, " ).append("\n"); 
		query.append("        A.IN_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("        A.OUT_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("        A.INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("        A.IMDG_SEGR_GRP_NO," ).append("\n"); 
		query.append("        A.RSD_FLG,		" ).append("\n"); 
		query.append("        A.CFR_FLG," ).append("\n"); 
		query.append("        A.FLT_FILE_REF_NO," ).append("\n"); 
		query.append("        'R' EDI_STATUS," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       '1'  EDI_CHK_TYPE" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	(	SELECT  /*+ ORDERED USE_NL(B C V E D F A) */" ).append("\n"); 
		query.append("               A.BKG_NO" ).append("\n"); 
		query.append("             , A.BKG_STS_CD" ).append("\n"); 
		query.append("             , C.SLAN_CD" ).append("\n"); 
		query.append("             , B.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("             , B.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("             , B.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("             , B.DCGO_QTY" ).append("\n"); 
		query.append("             , B.POR_CD" ).append("\n"); 
		query.append("             , B.DEL_CD" ).append("\n"); 
		query.append("             , B.EML_SND_NO" ).append("\n"); 
		query.append("             , B.LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("             , B.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("             , B.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("             , B.RQST_OFC_CD" ).append("\n"); 
		query.append("             , B.RQST_DT" ).append("\n"); 
		query.append("             , B.RQST_GDT" ).append("\n"); 
		query.append("             , B.RQST_USR_ID" ).append("\n"); 
		query.append("             , B.MAPG_TRSM_BND_CD" ).append("\n"); 
		query.append("             , C.MAPG_TRSM_DT" ).append("\n"); 
		query.append("             , C.MAPG_TRSM_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("             , C.MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("             , C.MAPG_EDI_TRSM_STS_CD" ).append("\n"); 
		query.append("             , C.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("             , C.VSL_SEQ" ).append("\n"); 
		query.append("             , C.VSL_CD" ).append("\n"); 
		query.append("             , D.VSL_ENG_NM" ).append("\n"); 
		query.append("             , C.SKD_VOY_NO" ).append("\n"); 
		query.append("             , C.SKD_DIR_CD" ).append("\n"); 
		query.append("             , C.POL_CD" ).append("\n"); 
		query.append("             , C.POD_CD" ).append("\n"); 
		query.append("             , C.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , C.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , C.POL_YD_CD" ).append("\n"); 
		query.append("             , C.POD_YD_CD" ).append("\n"); 
		query.append("             , NVL(G.ACT_CRR_CD,D.CRR_CD)       CRR_CD" ).append("\n"); 
		query.append("             , E.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("             , HDR.FLT_FILE_REF_NO              FLT_FILE_REF_NO" ).append("\n"); 
		query.append("             , HDR.EDI_MSG_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             --::2015-05-30:://, TO_NUMBER(SUBSTR(CGO.REF_NO,LENGTH(CGO.REF_NO)-2, LENGTH(CGO.REF_NO)))                 DCGO_SEQ" ).append("\n"); 
		query.append("             --::2015-06-09:://, TO_NUMBER(SUBSTR(CGO.DCGO_REF_NO,LENGTH(CGO.DCGO_REF_NO)-2, LENGTH(CGO.DCGO_REF_NO)))                 DCGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 ----, NVL(BDC.DCGO_SEQ,SDC.DCGO_SEQ)   DCGO_SEQ					--::2015-06-13::--" ).append("\n"); 
		query.append("             , CGO.DCGO_REF_NO" ).append("\n"); 
		query.append("             , CGO.CGO_SEQ                      DG_CNTR_SEQ" ).append("\n"); 
		query.append("			 , CGO.DCGO_SEQ" ).append("\n"); 
		query.append("             , CNTR.CNTR_SEQ                    CNTR_CGO_SEQ" ).append("\n"); 
		query.append("             , CGO.CNTR_REF_NO                  CNTR_NO" ).append("\n"); 
		query.append("             , CGO.CNTR_TPSZ_CD_CTNT            CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , CGO.IMDG_UN_NO_CTNT              IMDG_UN_NO" ).append("\n"); 
		query.append("             , CGO.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("             , CGO.IMDG_CLSS_CD_CTNT            IMDG_CLSS_CD                 " ).append("\n"); 
		query.append("             , ''                               IMDG_SUBS_RSK_LBL_CD1   " ).append("\n"); 
		query.append("             , ''                               IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("             , ''                               IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("             , ''                               IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("             , CGO.IMDG_MRN_POLUT_FLG           MRN_POLUT_FLG" ).append("\n"); 
		query.append("             , CGO.IMDG_PCK_GRP_CD_CTNT         IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("             , CGO.IMDG_LMT_QTY_FLG_CTNT        IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("             , CGO.IMDG_EXPT_QTY_FLG_CTNT       IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("             , CGO.FLSH_PNT_TEMP_CTNT           FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("             , CGO.GRS_WGT_CTNT                 GRS_WGT" ).append("\n"); 
		query.append("             , CGO.NET_WGT_CTNT                 NET_WGT" ).append("\n"); 
		query.append("             , CGO.INTMD_N1ST_IMDG_PCK_QTY_CTNT IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("             , CGO.OUT_N1ST_IMDG_PCK_QTY_CTNT   OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("             , CGO.IN_N1ST_IMDG_PCK_QTY_CTNT    INTMD_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("             , CGO.PSA_NO" ).append("\n"); 
		query.append("             , ''                               HCDG_FLG" ).append("\n"); 
		query.append("             , ''                               SPCL_RQST_FLG" ).append("\n"); 
		query.append("             , ''                               SPCL_RQST_DESC" ).append("\n"); 
		query.append("             , V.VPS_ETA_DT" ).append("\n"); 
		query.append("             , CGO.PRP_SHP_NM" ).append("\n"); 
		query.append("             , CGO.DIFF_RMK" ).append("\n"); 
		query.append("             , CGO.DCGO_STS_CD_CTNT             DCGO_STS_CD" ).append("\n"); 
		query.append("             , ''                               IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("			 , CGO.RSD_FLG_CTNT                 RSD_FLG" ).append("\n"); 
		query.append("			 , CGO.CFR_FLG" ).append("\n"); 
		query.append("		 FROM SCG_APRO_RQST 					B" ).append("\n"); 
		query.append("            , SCG_VVD_APRO_RQST 				C" ).append("\n"); 
		query.append("            , SCG_RGN_SHP_OPR_PORT 				E" ).append("\n"); 
		query.append("            , MDM_VSL_CNTR 						D" ).append("\n"); 
		query.append("			, BKG_BOOKING 						A" ).append("\n"); 
		query.append("			, VSK_VSL_PORT_SKD 					V" ).append("\n"); 
		query.append("            , VSK_VSL_SKD 						G" ).append("\n"); 
		query.append("            , SCG_PRNR_SPCL_CGO_TRSM_HDR 		HDR" ).append("\n"); 
		query.append("            , SCG_PRNR_SPCL_CGO_CNTR_LOG 		CNTR" ).append("\n"); 
		query.append("            , SCG_PRNR_SPCL_CGO_DTL_LOG  		CGO   " ).append("\n"); 
		query.append("		WHERE 1 = 1" ).append("\n"); 
		query.append("          AND HDR.TRSM_MZD_CD           = 'EDI'							--::EDI, EML::--" ).append("\n"); 
		query.append("		  AND B.SPCL_CGO_CATE_CD 		= 'DG'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  ----:2015-07-11:----AND B.LST_RQST_DAT_FLG 		= 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND B.BKG_NO 					= C.BKG_NO" ).append("\n"); 
		query.append("		  AND B.SPCL_CGO_APRO_RQST_SEQ 	= C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("		  AND C.POL_CD 					= E.LOC_CD" ).append("\n"); 
		query.append("		  AND C.VSL_CD 					= D.VSL_CD" ).append("\n"); 
		query.append("		  AND D.DELT_FLG 				= 'N'" ).append("\n"); 
		query.append("		  AND E.DELT_FLG 				= 'N'" ).append("\n"); 
		query.append("		  AND V.VSL_CD 					= C.VSL_CD" ).append("\n"); 
		query.append("          AND V.SKD_VOY_NO 				= C.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND V.SKD_DIR_CD 				= C.SKD_DIR_CD" ).append("\n"); 
		query.append("	      AND C.VSL_CD                  = G.VSL_CD" ).append("\n"); 
		query.append("          AND C.SKD_VOY_NO              = G.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND C.SKD_DIR_CD              = G.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND V.VPS_PORT_CD 			= C.POL_CD" ).append("\n"); 
		query.append("		  AND V.CLPT_IND_SEQ 			= C.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		  AND B.BKG_NO 					= A.BKG_NO" ).append("\n"); 
		query.append("          AND HDR.TRSM_BND_CD           = CNTR.TRSM_BND_CD" ).append("\n"); 
		query.append("          AND HDR.TRSM_DT               = CNTR.TRSM_DT" ).append("\n"); 
		query.append("          AND HDR.SPCL_CGO_CATE_CD      = CNTR.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("          AND HDR.PRNR_SPCL_CGO_SEQ     = CNTR.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          AND HDR.TRSM_BND_CD           = CGO.TRSM_BND_cD" ).append("\n"); 
		query.append("          AND HDR.TRSM_DT               = CGO.TRSM_DT" ).append("\n"); 
		query.append("          AND HDR.SPCL_CGO_CATE_CD      = CGO.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("          AND HDR.PRNR_SPCL_CGO_SEQ     = CGO.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          AND HDR.TRSM_BND_CD           = C.MAPG_TRSM_BND_CD         " ).append("\n"); 
		query.append("          AND HDR.TRSM_DT               = C.MAPG_TRSM_DT" ).append("\n"); 
		query.append("          AND HDR.SPCL_CGO_CATE_CD      = C.MAPG_TRSM_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("          AND HDR.PRNR_SPCL_CGO_SEQ     = C.MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          AND CNTR.CNTR_REF_NO          = CGO.CNTR_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND C.CXL_CGO_RQST_DT         BETWEEN TO_DATE(REPLACE(@[rqst_from_dt]||'', '-','')||'000000','YYYYMMDDHH24MISS') AND TO_DATE(REPLACE(@[rqst_to_dt],'-','')||'235959','YYYYMMDDHH24MISS')+1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  --================================================================================================" ).append("\n"); 
		query.append("		  AND C.MAPG_EDI_TRSM_STS_CD	IN ('S' ,'SX')	-- SUCCESS        AND SUCCESS+CANCEL EDI SUCCESS" ).append("\n"); 
		query.append("          AND C.CXL_CGO_KND_CD          IN ('BK','DG')	-- BOOKING CANCEL AND DG DELETE" ).append("\n"); 
		query.append("		  --================================================================================================" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${rgn_shp_opr_cd} != '') " ).append("\n"); 
		query.append("		AND		E.RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ($slan_cd.size() > 0) " ).append("\n"); 
		query.append("		AND 	C.SLAN_CD IN ( " ).append("\n"); 
		query.append("				#foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("					#if($velocityCount < $slan_cd.size()) " ).append("\n"); 
		query.append("						'$key', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$key' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("		AND		C.VSL_CD 			IN ( @[vsl_cd] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${from_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("	    AND V.VPS_ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYYMMDD') AND TO_DATE(@[to_eta_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#elseif (${from_eta_dt} != '') " ).append("\n"); 
		query.append("		AND DECODE(C.VSL_PRE_PST_CD,'U',V.VPS_ETA_DT,B.RQST_DT)	<= NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,BKG_COM_USER_LOC_FNC(@[usr_id])), SYSDATE) + TO_NUMBER(@[from_eta_dt])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("												   " ).append("\n"); 
		query.append("		) A, " ).append("\n"); 
		query.append("		SCG_AUTHORIZATION G" ).append("\n"); 
		query.append("WHERE	A.BKG_NO 					= G.BKG_NO 					----(+) " ).append("\n"); 
		query.append("AND 	A.SPCL_CGO_APRO_RQST_SEQ 	= G.SPCL_CGO_APRO_RQST_SEQ 	----(+) " ).append("\n"); 
		query.append("AND 	A.VSL_PRE_PST_CD 			= G.VSL_PRE_PST_CD 			----(+) " ).append("\n"); 
		query.append("AND 	A.VSL_SEQ 					= G.VSL_SEQ 				----(+) " ).append("\n"); 
		query.append("AND   	A.DCGO_SEQ           		= G.DCGO_SEQ 				----(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--::2015-06-13::--AND     NVL(G.SPCL_CGO_AUTH_CD,'R') IN ('P','Y')" ).append("\n"); 
		query.append("AND     G.SPCL_CGO_AUTH_CD			IN ('P','Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'), " ).append("\n"); 
		query.append("         A.SLAN_CD, " ).append("\n"); 
		query.append("         A.VSL_CD ," ).append("\n"); 
		query.append("         A.SKD_VOY_NO, " ).append("\n"); 
		query.append("         A.SKD_DIR_CD, " ).append("\n"); 
		query.append("         A.CRR_CD, " ).append("\n"); 
		query.append("         A.POL_CD, " ).append("\n"); 
		query.append("         A.POD_CD, " ).append("\n"); 
		query.append("         A.BKG_NO, " ).append("\n"); 
		query.append("         A.DG_CNTR_SEQ, " ).append("\n"); 
		query.append("         A.CNTR_CGO_SEQ" ).append("\n"); 

	}
}