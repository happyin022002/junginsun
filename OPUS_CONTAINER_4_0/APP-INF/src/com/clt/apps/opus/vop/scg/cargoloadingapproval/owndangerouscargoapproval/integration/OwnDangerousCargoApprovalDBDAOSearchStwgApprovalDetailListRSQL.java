/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchStwgApprovalDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
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

public class OwnDangerousCargoApprovalDBDAOSearchStwgApprovalDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Stwg TAB 조회
	  * [2015.06.25] EML_SND_NO > SCG_VVD_APRO_RQST.INDIV_EML_SND_NO 
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchStwgApprovalDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("booking_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchStwgApprovalDetailListRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT" ).append("\n"); 
		query.append("	    DENSE_RANK() OVER(ORDER BY A.VSL_CD, A.SKD_VOY_NO ,A.SKD_DIR_CD, A.BKG_NO) AS RANK_SEQ," ).append("\n"); 
		query.append("        COUNT(*) OVER(PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.BKG_NO ) AS RANK_CNT," ).append("\n"); 
		query.append("		A.BKG_NO AS BOOKING_NO," ).append("\n"); 
		query.append("        A.BKG_NO," ).append("\n"); 
		query.append("        A.BKG_STS_CD," ).append("\n"); 
		query.append("        A.DG_CNTR_SEQ," ).append("\n"); 
		query.append("        A.CNTR_CGO_SEQ," ).append("\n"); 
		query.append("        ROUND(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE) - A.RQST_GDT,1) AS RQST_DAY," ).append("\n"); 
		query.append("        DECODE(NVL(A.SPCL_CGO_AUTH_CD,'R'),'R',DECODE(A.SPCL_RQST_FLG,'Y','S','')||'R'||A.SPCL_CGO_RQST_SEQ,A.SPCL_CGO_AUTH_CD) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("        SUBSTR(DECODE(NVL(A.SPCL_CGO_AUTH_CD,'R'),'R','R'||A.SPCL_CGO_RQST_SEQ, A.SPCL_CGO_AUTH_CD),1,1) AS SPCL_CGO_AUTH_CD_CHK," ).append("\n"); 
		query.append("		A.SPCL_CGO_AUTH_RJCT_CD," ).append("\n"); 
		query.append("        A.APRO_REF_NO," ).append("\n"); 
		query.append("        DECODE(A.MAPG_EDI_TRSM_STS_CD, 'S', 'Y', NVL(A.MAPG_EDI_TRSM_STS_CD, '')) AS EDI_SND_NO," ).append("\n"); 
		query.append("	    (SELECT DECODE(EML_PROC_STS_CD,'1','W'," ).append("\n"); 
		query.append("                                       '3','Y'," ).append("\n"); 
		query.append("                                       '4','F'," ).append("\n"); 
		query.append("                                       '')" ).append("\n"); 
		query.append("		FROM   COM_EML_SND_INFO" ).append("\n"); 
		query.append("        WHERE  EML_SND_NO = A.EML_SND_NO) AS EML_SND_NO," ).append("\n"); 
		query.append("        'N' AS EML_CHK," ).append("\n"); 
		query.append("        A.SLAN_CD," ).append("\n"); 
		query.append("        A.VSL_CD," ).append("\n"); 
		query.append("	    A.VSL_ENG_NM AS VSL_NM," ).append("\n"); 
		query.append("        A.SKD_VOY_NO," ).append("\n"); 
		query.append("        A.SKD_DIR_CD," ).append("\n"); 
		query.append("        A.PRP_SHP_NM," ).append("\n"); 
		query.append("        A.DIFF_RMK," ).append("\n"); 
		query.append("        DECODE(A.DCGO_STS_CD, 'L', 'Liquid', 'G', 'GAS', 'P', 'PASTE', 'S', 'SOLID','') DCGO_STS_CD," ).append("\n"); 
		query.append("        A.CRR_CD," ).append("\n"); 
		query.append("        '' CRR_CODE," ).append("\n"); 
		query.append("        A.POR_CD," ).append("\n"); 
		query.append("        A.POL_CD," ).append("\n"); 
		query.append("        'N' AS EDI_CHK ," ).append("\n"); 
		query.append("        A.MAPG_TRSM_BND_CD," ).append("\n"); 
		query.append("        A.MAPG_TRSM_DT," ).append("\n"); 
		query.append("        A.MAPG_TRSM_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("        A.MAPG_PRNR_SPCL_CGO_SEQ," ).append("\n"); 
		query.append("        A.MAPG_EDI_TRSM_STS_CD," ).append("\n"); 
		query.append("		TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT," ).append("\n"); 
		query.append("        A.POD_CD," ).append("\n"); 
		query.append("        A.DEL_CD," ).append("\n"); 
		query.append("        A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        'DD' AS DG_TP," ).append("\n"); 
		query.append("        A.IMDG_UN_NO," ).append("\n"); 
		query.append("        ( SELECT LISTAGG (X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM, ',') WITHIN GROUP (ORDER BY X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM)" ).append("\n"); 
		query.append("            FROM SCG_IMDG_SEGR_GRP X" ).append("\n"); 
		query.append("               , SCG_IMDG_SEGR_GRP_DTL Y" ).append("\n"); 
		query.append("           WHERE X.IMDG_SEGR_GRP_NO = Y.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("             AND Y.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("           GROUP BY Y.IMDG_UN_NO" ).append("\n"); 
		query.append("        ) IMDG_SEGR_GRP_NM," ).append("\n"); 
		query.append("        A.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("        A.IMDG_CLSS_CD," ).append("\n"); 
		query.append("        A.IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("        ||DECODE(A.IMDG_SUBS_RSK_LBL_CD2,NULL,NULL,'/')" ).append("\n"); 
		query.append("        ||A.IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("		||DECODE(A.IMDG_SUBS_RSK_LBL_CD3,NULL,NULL,'/')" ).append("\n"); 
		query.append("        ||A.IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("        ||DECODE(A.IMDG_SUBS_RSK_LBL_CD4,NULL,NULL, '/')" ).append("\n"); 
		query.append("        ||A.IMDG_SUBS_RSK_LBL_CD4 AS IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("        A.MRN_POLUT_FLG," ).append("\n"); 
		query.append("        DECODE(A.IMDG_PCK_GRP_CD,'N',NULL," ).append("\n"); 
		query.append("                                 '1','I'," ).append("\n"); 
		query.append("                                 '2','II'," ).append("\n"); 
		query.append("                                 '3','III') AS IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("        A.IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("        A.IMDG_EXPT_QTY_FLG," ).append("\n"); 
		query.append("        A.FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("        A.OP_CNTR_QTY ," ).append("\n"); 
		query.append("       (SELECT CASE WHEN (SELECT COUNT(BKG_NO) FROM BKG_QUANTITY WHERE BKG_NO = A.BKG_NO ) > 1 THEN (CASE WHEN A.OP_CNTR_QTY = COUNT(C.BKG_NO) THEN SUM(NVL2(C.WGT_UT_CD, TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(C.WGT_UT_CD, C.CNTR_WGT), 0))||''" ).append("\n"); 
		query.append("                                                                                                                   ELSE ''" ).append("\n"); 
		query.append("                                                                                                              END)       " ).append("\n"); 
		query.append("                    ELSE (CASE WHEN A.OP_CNTR_QTY = COUNT(C.BKG_NO) THEN SUM(NVL2(C.WGT_UT_CD, TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(C.WGT_UT_CD, C.CNTR_WGT), 0))||''" ).append("\n"); 
		query.append("                               ELSE MAX(NVL2(D.WGT_UT_CD, TRS_COMMON_PKG.GET_CONV_WGT_TO_KG_FNC(D.WGT_UT_CD, D.ACT_WGT), 0))||''" ).append("\n"); 
		query.append("                          END)" ).append("\n"); 
		query.append("               END GRS_WGT" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER C,  BKG_BL_DOC D" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND C.BKG_NO(+) = D.BKG_NO" ).append("\n"); 
		query.append("           AND C.CNTR_TPSZ_CD(+) = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         GROUP BY A.BKG_NO, A.CNTR_TPSZ_CD       " ).append("\n"); 
		query.append("        ) GRS_WGT," ).append("\n"); 
		query.append("        A.NET_WGT," ).append("\n"); 
		query.append("        A.PSA_NO," ).append("\n"); 
		query.append("        A.HCDG_FLG," ).append("\n"); 
		query.append("        A.BKG_NO," ).append("\n"); 
		query.append("        A.SPCL_CGO_APRO_RQST_SEQ," ).append("\n"); 
		query.append("        A.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("        A.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        A.VSL_SEQ," ).append("\n"); 
		query.append("        A.CNTR_NO," ).append("\n"); 
		query.append("        A.DCGO_QTY," ).append("\n"); 
		query.append("        A.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("        A.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("        A.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("        A.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        A.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        A.POL_YD_CD," ).append("\n"); 
		query.append("        A.POD_YD_CD," ).append("\n"); 
		query.append("        A.RGN_SHP_OPR_CD," ).append("\n"); 
		query.append("        A.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("        A.SPCL_CGO_AUTH_NO," ).append("\n"); 
		query.append("        A.AUTH_OFC_CD," ).append("\n"); 
		query.append("        A.SPCL_CGO_AUTH_SEQ," ).append("\n"); 
		query.append("        SCG_GET_MPA1_NET_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.POL_CD," ).append("\n"); 
		query.append("                             A.POD_CD,A.IMDG_CLSS_CD) AS NET_WGT_SUM," ).append("\n"); 
		query.append("        'SS' AS SCG_FLG," ).append("\n"); 
		query.append("        '' AS RQST_AUTH_CD," ).append("\n"); 
		query.append("        A.RQST_OFC_CD," ).append("\n"); 
		query.append("        TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT," ).append("\n"); 
		query.append("        TO_CHAR(A.RQST_GDT,'YYYY-MM-DD HH24:MI') AS RQST_GDT," ).append("\n"); 
		query.append("        A.RQST_USR_ID," ).append("\n"); 
		query.append("        TO_CHAR(A.AUTH_DT,'YYYY-MM-DD HH24:MI')AS AUTH_DT," ).append("\n"); 
		query.append("        TO_CHAR(A.AUTH_GDT,'YYYY-MM-DD HH24:MI')AS AUTH_GDT, " ).append("\n"); 
		query.append("        A.SPCL_CGO_AUTH_RMK," ).append("\n"); 
		query.append("        --A.SPCL_RQST_DESC," ).append("\n"); 
		query.append("		--A.AUTH_USR_ID," ).append("\n"); 
		query.append("        --A.IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("        --A.OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("        --A.INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("        --A.IMDG_SEGR_GRP_NO," ).append("\n"); 
		query.append("        NULL AS RSD_FLG," ).append("\n"); 
		query.append("        A.CFR_FLG," ).append("\n"); 
		query.append("        A.DCGO_FLG    ," ).append("\n"); 
		query.append("        A.RC_FLG      ," ).append("\n"); 
		query.append("        A.AWK_CGO_FLG ," ).append("\n"); 
		query.append("        A.BB_CGO_FLG  ," ).append("\n"); 
		query.append("		--A.STWG_FLG	  ," ).append("\n"); 
		query.append("		'Y' STWG_FLG	  ," ).append("\n"); 
		query.append("		A.STWG_CD     ," ).append("\n"); 
		query.append("        A.BKG_STWG_CD ," ).append("\n"); 
		query.append("        A.SCG_STWG_CD ," ).append("\n"); 
		query.append("		A.STWG_SEQ," ).append("\n"); 
		query.append("        --2016-08-18" ).append("\n"); 
		query.append("     	NVL( " ).append("\n"); 
		query.append("			(SELECT" ).append("\n"); 
		query.append("          	MF.CMDT_HS_CD||' : '||HM.HAMO_CD_DESC AS HS_CD_DESC                      " ).append("\n"); 
		query.append("            FROM BKG_CNTR_MF_DESC MF," ).append("\n"); 
		query.append("              	 BKG_HAMO_TRF HM ," ).append("\n"); 
		query.append("              	 BKG_CONTAINER BC" ).append("\n"); 
		query.append("         	WHERE MF.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("	          AND MF.CNTR_MF_SEQ = '1'" ).append("\n"); 
		query.append("    	      AND MF.CMDT_HS_CD = HM.HAMO_TRF_CD" ).append("\n"); 
		query.append("        	  AND HM.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       		  AND BC.CNTR_NO = MF.CNTR_NO" ).append("\n"); 
		query.append("          	  AND BC.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("              AND BC.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              --AND BC.CNTR_DP_SEQ = '1' " ).append("\n"); 
		query.append("              AND ROWNUM =1" ).append("\n"); 
		query.append("              ) , A.CMDT_NM " ).append("\n"); 
		query.append("		   ) AS CMDT_NM,     " ).append("\n"); 
		query.append("		--A.CMDT_NM," ).append("\n"); 
		query.append("        --2016-08-18" ).append("\n"); 
		query.append("        A.DCGO_SEQ," ).append("\n"); 
		query.append("        A.AWK_CGO_SEQ ," ).append("\n"); 
		query.append("        A.BB_CGO_SEQ  ," ).append("\n"); 
		query.append("        A.RC_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("         SELECT A.*" ).append("\n"); 
		query.append("                    ,G.SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append("                    ,G.SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("                    ,G.APRO_REF_NO" ).append("\n"); 
		query.append("                    ,G.SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append("                    ,G.AUTH_OFC_CD" ).append("\n"); 
		query.append("                    ,G.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("                    ,G.AUTH_DT" ).append("\n"); 
		query.append("                    ,G.AUTH_GDT" ).append("\n"); 
		query.append("                    ,G.AUTH_USR_ID" ).append("\n"); 
		query.append("                    ,G.SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("              	SELECT" ).append("\n"); 
		query.append("                            ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, C.VSL_SEQ ORDER BY A.BKG_NO) SEQ," ).append("\n"); 
		query.append("                            A.BKG_NO," ).append("\n"); 
		query.append("                            A.BKG_STS_CD," ).append("\n"); 
		query.append("                            C.SLAN_CD," ).append("\n"); 
		query.append("                            B.SPCL_CGO_APRO_RQST_SEQ," ).append("\n"); 
		query.append("                            B.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("                            B.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("                            B.DCGO_QTY," ).append("\n"); 
		query.append("                            B.POR_CD," ).append("\n"); 
		query.append("                            B.DEL_CD," ).append("\n"); 
		query.append("                            C.INDIV_EML_SND_NO AS EML_SND_NO," ).append("\n"); 
		query.append("                            B.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("                            B.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("                            B.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("                            B.RQST_OFC_CD," ).append("\n"); 
		query.append("                            B.RQST_DT," ).append("\n"); 
		query.append("                            B.RQST_GDT," ).append("\n"); 
		query.append("                            B.RQST_USR_ID," ).append("\n"); 
		query.append("                            C.MAPG_TRSM_BND_CD," ).append("\n"); 
		query.append("                            C.MAPG_TRSM_DT," ).append("\n"); 
		query.append("                            C.MAPG_TRSM_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("                            C.MAPG_PRNR_SPCL_CGO_SEQ," ).append("\n"); 
		query.append("                            C.MAPG_EDI_TRSM_STS_CD," ).append("\n"); 
		query.append("                            C.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                            C.VSL_SEQ," ).append("\n"); 
		query.append("                            C.VSL_CD," ).append("\n"); 
		query.append("                            D.VSL_ENG_NM," ).append("\n"); 
		query.append("                            C.SKD_VOY_NO," ).append("\n"); 
		query.append("                            C.SKD_DIR_CD," ).append("\n"); 
		query.append("                            C.POL_CD," ).append("\n"); 
		query.append("                            C.POD_CD," ).append("\n"); 
		query.append("                            C.POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                            C.POD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                            C.POL_YD_CD," ).append("\n"); 
		query.append("                            C.POD_YD_CD," ).append("\n"); 
		query.append("                            NVL(G.ACT_CRR_CD,D.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("                            E.RGN_SHP_OPR_CD," ).append("\n"); 
		query.append("                            1 AS DG_CNTR_SEQ," ).append("\n"); 
		query.append("                            NULL AS CNTR_CGO_SEQ," ).append("\n"); 
		query.append("                            NULL AS CNTR_NO," ).append("\n"); 
		query.append("                            Q.CNTR_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                            Q.OP_CNTR_QTY," ).append("\n"); 
		query.append("                            NULL AS IMDG_UN_NO," ).append("\n"); 
		query.append("                            NULL AS IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("                            NULL AS IMDG_CLSS_CD," ).append("\n"); 
		query.append("                            NULL AS IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                            NULL AS IMDG_SUBS_RSK_LBL_CD2," ).append("\n"); 
		query.append("                            NULL AS IMDG_SUBS_RSK_LBL_CD3," ).append("\n"); 
		query.append("                            NULL AS IMDG_SUBS_RSK_LBL_CD4," ).append("\n"); 
		query.append("                            NULL AS MRN_POLUT_FLG," ).append("\n"); 
		query.append("                            NULL AS IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("                            NULL AS IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("                            NULL AS IMDG_EXPT_QTY_FLG," ).append("\n"); 
		query.append("                            NULL AS FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("                            NULL AS GRS_WGT," ).append("\n"); 
		query.append("                            NULL AS NET_WGT," ).append("\n"); 
		query.append("                            NULL AS IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("                            NULL AS OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("                            NULL AS INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("                            NULL AS PSA_NO," ).append("\n"); 
		query.append("                            NULL AS HCDG_FLG," ).append("\n"); 
		query.append("                            NULL AS SPCL_RQST_FLG," ).append("\n"); 
		query.append("                            NULL AS SPCL_RQST_DESC," ).append("\n"); 
		query.append("                            NULL AS PRP_SHP_NM," ).append("\n"); 
		query.append("                            NULL AS DIFF_RMK," ).append("\n"); 
		query.append("                            NULL AS DCGO_STS_CD," ).append("\n"); 
		query.append("                            NULL AS IMDG_SEGR_GRP_NO," ).append("\n"); 
		query.append("                            NULL AS RSD_FLG," ).append("\n"); 
		query.append("                            NULL AS CFR_FLG," ).append("\n"); 
		query.append("                            (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = A.CMDT_CD) AS CMDT_NM," ).append("\n"); 
		query.append("                            V.VPS_ETA_DT," ).append("\n"); 
		query.append("                            A.DCGO_FLG,             --@@" ).append("\n"); 
		query.append("                            A.RC_FLG,               --@@" ).append("\n"); 
		query.append("                            A.AWK_CGO_FLG,         --@@" ).append("\n"); 
		query.append("                            A.BB_CGO_FLG,          --@@" ).append("\n"); 
		query.append("                            A.STWG_CD BKG_STWG_CD, --참조용@@" ).append("\n"); 
		query.append("                            S.STWG_CD SCG_STWG_CD, --참조용@@" ).append("\n"); 
		query.append("                            (SELECT        --@@" ).append("\n"); 
		query.append("                                        INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                                      --INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                               FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                             WHERE    INTG_CD_ID = 'CD02146'" ).append("\n"); 
		query.append("                                 AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                 AND      INTG_CD_VAL_CTNT(+) = S.STWG_CD" ).append("\n"); 
		query.append("                            ) STWG_CD," ).append("\n"); 
		query.append("                            S.STWG_SEQ," ).append("\n"); 
		query.append("                            S.SPCL_CGO_APRO_CD," ).append("\n"); 
		query.append("                            NULL DCGO_SEQ," ).append("\n"); 
		query.append("                            NULL AWK_CGO_SEQ," ).append("\n"); 
		query.append("                            NULL BB_CGO_SEQ," ).append("\n"); 
		query.append("                            NULL RC_SEQ" ).append("\n"); 
		query.append("                    FROM    SCG_APRO_RQST B," ).append("\n"); 
		query.append("                            SCG_VVD_APRO_RQST C," ).append("\n"); 
		query.append("                            SCG_RGN_SHP_OPR_PORT E," ).append("\n"); 
		query.append("                            MDM_VSL_CNTR D," ).append("\n"); 
		query.append("                            BKG_BOOKING A," ).append("\n"); 
		query.append("                            VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                            VSK_VSL_SKD G," ).append("\n"); 
		query.append("                            BKG_STWG_CGO S," ).append("\n"); 
		query.append("                            BKG_QUANTITY Q" ).append("\n"); 
		query.append("                    WHERE    1 = 1" ).append("\n"); 
		query.append("                    AND     B.SPCL_CGO_CATE_CD           = 'SS'    --@@" ).append("\n"); 
		query.append("                    AND     B.LST_RQST_DAT_FLG           = 'Y'" ).append("\n"); 
		query.append("                    AND     B.BKG_NO                     = C.BKG_NO" ).append("\n"); 
		query.append("                    AND     B.SPCL_CGO_APRO_RQST_SEQ     = C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                    AND     C.POL_CD                     = E.LOC_CD" ).append("\n"); 
		query.append("                    AND     C.VSL_CD                     = D.VSL_CD" ).append("\n"); 
		query.append("                    AND     D.DELT_FLG                   = 'N'" ).append("\n"); 
		query.append("                    AND     E.DELT_FLG                   = 'N'" ).append("\n"); 
		query.append("                    AND     B.BKG_NO                     = S.BKG_NO --@@@" ).append("\n"); 
		query.append("                    AND     S.SPCL_CGO_APRO_CD  IS NOT NULL    --@@" ).append("\n"); 
		query.append("                    AND     V.VSL_CD                     = C.VSL_CD" ).append("\n"); 
		query.append("                    AND     V.SKD_VOY_NO                 = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     V.SKD_DIR_CD                 = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     C.VSL_CD                     = G.VSL_CD" ).append("\n"); 
		query.append("                    AND     C.SKD_VOY_NO                 = G.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND     C.SKD_DIR_CD                 = G.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND     V.VPS_PORT_CD                = C.POL_CD" ).append("\n"); 
		query.append("                    AND     V.CLPT_IND_SEQ               = C.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    AND     B.BKG_NO                     = A.BKG_NO" ).append("\n"); 
		query.append("                    AND     Q.BKG_NO                     = A.BKG_NO" ).append("\n"); 
		query.append("					)A, SCG_AUTHORIZATION G" ).append("\n"); 
		query.append("				WHERE A.BKG_NO 					= G.BKG_NO (+)" ).append("\n"); 
		query.append("				AND   A.SPCL_CGO_APRO_RQST_SEQ 	= G.SPCL_CGO_APRO_RQST_SEQ (+)" ).append("\n"); 
		query.append("				AND   A.VSL_PRE_PST_CD 			= G.VSL_PRE_PST_CD (+)" ).append("\n"); 
		query.append("				AND   A.VSL_SEQ 				= G.VSL_SEQ (+)" ).append("\n"); 
		query.append("				AND   A.STWG_SEQ  				= G.STWG_CGO_SEQ(+)" ).append("\n"); 
		query.append("                AND   A.SEQ                     = G.SPCL_CGO_AUTH_SEQ(+)" ).append("\n"); 
		query.append("                #if (${auth_flg} == 'Y') " ).append("\n"); 
		query.append("               	AND SPCL_CGO_AUTH_CD    	= 'Y'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${auth_flg} == 'U') " ).append("\n"); 
		query.append("             	AND (SPCL_CGO_AUTH_CD IS NULL OR SPCL_CGO_AUTH_CD      !=  'Y')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${auth_flg} == 'N') " ).append("\n"); 
		query.append("             	AND SPCL_CGO_AUTH_CD		= 'N'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${auth_flg} == 'YN')" ).append("\n"); 
		query.append("              	AND SPCL_CGO_AUTH_CD		IN ('Y','N','R','P')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("        AND     A.BKG_STS_CD                 != 'X'" ).append("\n"); 
		query.append("        AND     A.SPCL_CGO_APRO_CD             NOT IN ('C','D')    --@@" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("        AND        A.RGN_SHP_OPR_CD     = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ($slan_cd.size() > 0)" ).append("\n"); 
		query.append("        AND     A.SLAN_CD IN (" ).append("\n"); 
		query.append("                #foreach($key IN ${slan_cd})" ).append("\n"); 
		query.append("                    #if($velocityCount < $slan_cd.size())" ).append("\n"); 
		query.append("                        '$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                        '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("        AND        A.VSL_CD             IN ( @[vsl_cd] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("        AND     A.IMDG_UN_NO         = @[imdg_un_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${imdg_un_no_seq} != '')" ).append("\n"); 
		query.append("         AND     A.IMDG_UN_NO_SEQ     = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${imdg_clss_cd} != '')" ).append("\n"); 
		query.append("        AND     A.IMDG_CLSS_CD         = @[imdg_clss_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        AND        A.SKD_VOY_NO         IN ( @[skd_voy_no] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("        AND     A.SKD_DIR_CD         IN ( @[skd_dir_cd] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("        AND     A.POL_CD             = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("        AND     A.POD_CD             = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${val_opr_tp_cd} == 'H')" ).append("\n"); 
		query.append("        AND     A.CRR_CD             = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${val_opr_tp_cd} == 'O')" ).append("\n"); 
		query.append("        AND        A.CRR_CD             != COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${booking_no} != '')" ).append("\n"); 
		query.append("        AND     A.BKG_NO             = @[booking_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${shpr_nm} != '')" ).append("\n"); 
		query.append("        AND     A.BKG_NO IN (" ).append("\n"); 
		query.append("                    SELECT     SH.BKG_NO" ).append("\n"); 
		query.append("                    FROM     BKG_CUSTOMER SH" ).append("\n"); 
		query.append("                    WHERE     SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                    AND     SH.CUST_NM LIKE '%'||@[shpr_nm]||'%'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${from_eta_dt} != '' && ${to_eta_dt} != '')" ).append("\n"); 
		query.append("        AND A.VPS_ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYYMMDD') AND TO_DATE(@[to_eta_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("    #elseif (${from_eta_dt} != '')" ).append("\n"); 
		query.append("        AND DECODE(A.VSL_PRE_PST_CD,'U',A.VPS_ETA_DT,A.RQST_DT)    <= (SELECT NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,BKG_COM_USER_LOC_FNC(@[usr_id])), SYSDATE) + TO_NUMBER(@[from_eta_dt]) FROM DUAL)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("         A.SLAN_CD," ).append("\n"); 
		query.append("         A.VSL_CD ," ).append("\n"); 
		query.append("         A.SKD_VOY_NO," ).append("\n"); 
		query.append("         A.SKD_DIR_CD," ).append("\n"); 
		query.append("         A.CRR_CD," ).append("\n"); 
		query.append("         A.POL_CD," ).append("\n"); 
		query.append("         A.POD_CD," ).append("\n"); 
		query.append("         A.BKG_NO," ).append("\n"); 
		query.append("         A.DG_CNTR_SEQ," ).append("\n"); 
		query.append("         A.CNTR_CGO_SEQ" ).append("\n"); 

	}
}