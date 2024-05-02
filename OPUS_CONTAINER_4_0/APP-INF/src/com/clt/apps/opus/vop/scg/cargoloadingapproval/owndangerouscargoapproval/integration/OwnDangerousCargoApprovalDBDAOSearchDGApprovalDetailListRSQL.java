/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchDGApprovalDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.06 
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

public class OwnDangerousCargoApprovalDBDAOSearchDGApprovalDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG-Part1, DG-Part2조회
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchDGApprovalDetailListRSQL(){
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
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_req_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_req_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchDGApprovalDetailListRSQL").append("\n"); 
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
		query.append("SELECT    SLAN_CD" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , VSL_NM" ).append("\n"); 
		query.append("         , SKD_VOY_NO" ).append("\n"); 
		query.append("         , SKD_DIR_CD" ).append("\n"); 
		query.append("         , POR_CD" ).append("\n"); 
		query.append("         , POL_CD" ).append("\n"); 
		query.append("         , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , POD_CD" ).append("\n"); 
		query.append("         , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , DEL_CD" ).append("\n"); 
		query.append("         , CRR_CD" ).append("\n"); 
		query.append("         , CGO_OPR_CD" ).append("\n"); 
		query.append("         , BKG_NO" ).append("\n"); 
		query.append("         , DCGO_REF_NO" ).append("\n"); 
		query.append("         , EML_SND_HIS_FLG" ).append("\n"); 
		query.append("         , BKG_STS_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_CD AS AUTH_STS_CD " ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_CD     " ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_CD_CHK" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("         , APRO_REF_NO" ).append("\n"); 
		query.append("         , SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("         , SPCL_CGO_SEQ" ).append("\n"); 
		query.append("         , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , DG_TP" ).append("\n"); 
		query.append("         , IMDG_UN_NO" ).append("\n"); 
		query.append("         , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("         , IMDG_CLSS_CD     " ).append("\n"); 
		query.append("         , PRP_SHP_NM" ).append("\n"); 
		query.append("         , IMDG_SUBS_RSK_LBL_CD     " ).append("\n"); 
		query.append("         , MRN_POLUT_FLG" ).append("\n"); 
		query.append("         , IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("         , IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("         , IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("         , RSD_FLG     " ).append("\n"); 
		query.append("         , FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("         , GRS_WGT" ).append("\n"); 
		query.append("         , NET_WGT     " ).append("\n"); 
		query.append("         , PSA_NO     " ).append("\n"); 
		query.append("         , RQST_DT     " ).append("\n"); 
		query.append("         , AUTH_DT" ).append("\n"); 
		query.append("         , VPS_ETA_DT" ).append("\n"); 
		query.append("         , DIFF_RMK" ).append("\n"); 
		query.append("         , IMDG_SEGR_GRP_NM     " ).append("\n"); 
		query.append("         , DCGO_STS_CD" ).append("\n"); 
		query.append("         , NET_WGT_SUM     " ).append("\n"); 
		query.append("         , SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("         , VSL_PRE_PST_CD" ).append("\n"); 
		query.append("         , VSL_SEQ" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("         , SPCL_CGO_CATE_CD     " ).append("\n"); 
		query.append("         , DCGO_SEQ" ).append("\n"); 
		query.append("         , RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("         , POL_YD_CD" ).append("\n"); 
		query.append("         , POD_YD_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("         , CFR_FLG" ).append("\n"); 
		query.append("         , BKG_REF_NO" ).append("\n"); 
		query.append("         , PRNR_CGO_RQST_SEQ " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT ORD_SEQ" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , VSL_NM" ).append("\n"); 
		query.append("         , SKD_VOY_NO" ).append("\n"); 
		query.append("         , SKD_DIR_CD" ).append("\n"); 
		query.append("         , POR_CD" ).append("\n"); 
		query.append("         , POL_CD" ).append("\n"); 
		query.append("         , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , POD_CD" ).append("\n"); 
		query.append("         , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , DEL_CD" ).append("\n"); 
		query.append("         , CRR_CD" ).append("\n"); 
		query.append("         , '' CGO_OPR_CD" ).append("\n"); 
		query.append("         , BKG_NO" ).append("\n"); 
		query.append("         , DCGO_REF_NO" ).append("\n"); 
		query.append("         ,(SELECT  MAX(CASE WHEN EM.EML_PROC_STS_CD IS NOT NULL AND  EM2.EML_PROC_STS_CD IS NULL THEN DECODE(EM.EML_PROC_STS_CD, '1','W','3','Y','4','F','')" ).append("\n"); 
		query.append("                            WHEN EM.EML_PROC_STS_CD IS NULL AND  EM2.EML_PROC_STS_CD IS NOT NULL THEN DECODE(EM2.EML_PROC_STS_CD,'1','W','3','Y','4','F','')" ).append("\n"); 
		query.append("                            WHEN EM.EML_PROC_STS_CD = EM2.EML_PROC_STS_CD                        THEN DECODE(EM.EML_PROC_STS_CD, '1','W','3','Y','4','F','')" ).append("\n"); 
		query.append("                            WHEN EM.EML_PROC_STS_CD <> EM2.EML_PROC_STS_CD                       THEN 'W'" ).append("\n"); 
		query.append("                            ELSE ''" ).append("\n"); 
		query.append("                       END) " ).append("\n"); 
		query.append("              FROM SCG_VVD_APRO_RQST RQ ," ).append("\n"); 
		query.append("                   COM_EML_SND_INFO EM ," ).append("\n"); 
		query.append("                   COM_EML_SND_INFO EM2" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND RQ.INDIV_EML_SND_NO = EM.EML_SND_NO(+)" ).append("\n"); 
		query.append("               AND RQ.OALL_EML_SND_NO  = EM2.EML_SND_NO(+)" ).append("\n"); 
		query.append("               AND RQ.BKG_NO           = A.BOOKING_NO   " ).append("\n"); 
		query.append("               AND RQ.VSL_PRE_PST_CD   = A.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("               AND RQ.VSL_SEQ          = A.VSL_SEQ" ).append("\n"); 
		query.append("               AND RQ.VSL_CD           = A.VSL_CD" ).append("\n"); 
		query.append("               AND RQ.SKD_VOY_NO       = A.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND RQ.SKD_DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("          ) EML_SND_HIS_FLG" ).append("\n"); 
		query.append("         , BKG_STS_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_CD     " ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_CD_CHK" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("         , APRO_REF_NO" ).append("\n"); 
		query.append("         , DG_CNTR_SEQ  AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("         , CNTR_CGO_SEQ  AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append("         , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , DG_TP" ).append("\n"); 
		query.append("         , IMDG_UN_NO" ).append("\n"); 
		query.append("         , DECODE(IMDG_UN_NO_SEQ,'0','',IMDG_UN_NO_SEQ) IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("         , IMDG_CLSS_CD     " ).append("\n"); 
		query.append("         , PRP_SHP_NM" ).append("\n"); 
		query.append("         , IMDG_SUBS_RSK_LBL_CD     " ).append("\n"); 
		query.append("         , MRN_POLUT_FLG" ).append("\n"); 
		query.append("         , IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("         , IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("         , IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("         , NVL(RSD_FLG, 'N') RSD_FLG     " ).append("\n"); 
		query.append("         , FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("         , GRS_WGT" ).append("\n"); 
		query.append("         , NET_WGT     " ).append("\n"); 
		query.append("         , PSA_NO     " ).append("\n"); 
		query.append("         , RQST_DT     " ).append("\n"); 
		query.append("         , AUTH_DT" ).append("\n"); 
		query.append("         , VPS_ETA_DT" ).append("\n"); 
		query.append("         , DIFF_RMK" ).append("\n"); 
		query.append("         , IMDG_SEGR_GRP_NM     " ).append("\n"); 
		query.append("         , DCGO_STS_CD" ).append("\n"); 
		query.append("         , NET_WGT_SUM     " ).append("\n"); 
		query.append("         , SPCL_CGO_APRO_RQST_SEQ||'' SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("         , VSL_PRE_PST_CD" ).append("\n"); 
		query.append("         , VSL_SEQ||'' VSL_SEQ" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_SEQ||'' SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("         , SPCL_CGO_CATE_CD     " ).append("\n"); 
		query.append("         , DCGO_SEQ||'' DCGO_SEQ" ).append("\n"); 
		query.append("         , RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("         , POL_YD_CD" ).append("\n"); 
		query.append("         , POD_YD_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("         , CFR_FLG" ).append("\n"); 
		query.append("         , BKG_NO AS BKG_REF_NO" ).append("\n"); 
		query.append("         , PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("    SELECT	1 AS ORD_SEQ," ).append("\n"); 
		query.append("            A.BKG_NO AS BOOKING_NO," ).append("\n"); 
		query.append("            A.BKG_STS_CD," ).append("\n"); 
		query.append("            A.DG_CNTR_SEQ," ).append("\n"); 
		query.append("            A.CNTR_CGO_SEQ, " ).append("\n"); 
		query.append("            ROUND(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE) - A.RQST_GDT,1) AS RQST_DAY, " ).append("\n"); 
		query.append("            DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',DECODE(A.SPCL_RQST_FLG,'Y','S','')||'R'||A.SPCL_CGO_RQST_SEQ,G.SPCL_CGO_AUTH_CD) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("            SUBSTR(DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',DECODE(A.SPCL_RQST_FLG,'Y','','')||'R'||A.SPCL_CGO_RQST_SEQ,G.SPCL_CGO_AUTH_CD),1,1) AS SPCL_CGO_AUTH_CD_CHK, " ).append("\n"); 
		query.append("            G.SPCL_CGO_AUTH_RJCT_CD, " ).append("\n"); 
		query.append("            G.APRO_REF_NO," ).append("\n"); 
		query.append("            A.SLAN_CD, " ).append("\n"); 
		query.append("            A.VSL_CD, " ).append("\n"); 
		query.append("            A.VSL_ENG_NM AS VSL_NM," ).append("\n"); 
		query.append("            A.SKD_VOY_NO," ).append("\n"); 
		query.append("            A.SKD_DIR_CD," ).append("\n"); 
		query.append("            A.PRP_SHP_NM," ).append("\n"); 
		query.append("            A.DIFF_RMK," ).append("\n"); 
		query.append("            DECODE(A.DCGO_STS_CD, 'L', 'Liquid', 'G', 'GAS', 'P', 'PASTE', 'S', 'SOLID','') DCGO_STS_CD," ).append("\n"); 
		query.append("            A.CRR_CD," ).append("\n"); 
		query.append("            '' CRR_CODE," ).append("\n"); 
		query.append("            A.POR_CD, " ).append("\n"); 
		query.append("            A.POL_CD, " ).append("\n"); 
		query.append("            TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT," ).append("\n"); 
		query.append("            A.POD_CD, " ).append("\n"); 
		query.append("            A.DEL_CD, " ).append("\n"); 
		query.append("            A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("            'DD' AS DG_TP, " ).append("\n"); 
		query.append("            A.IMDG_UN_NO, " ).append("\n"); 
		query.append("            ( SELECT LISTAGG (X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM, ',') WITHIN GROUP (ORDER BY X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM)" ).append("\n"); 
		query.append("                FROM SCG_IMDG_SEGR_GRP X" ).append("\n"); 
		query.append("                   , SCG_IMDG_SEGR_GRP_DTL Y" ).append("\n"); 
		query.append("               WHERE X.IMDG_SEGR_GRP_NO = Y.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("                 AND Y.IMDG_UN_NO = A.IMDG_UN_NO" ).append("\n"); 
		query.append("               GROUP BY Y.IMDG_UN_NO " ).append("\n"); 
		query.append("            ) IMDG_SEGR_GRP_NM, " ).append("\n"); 
		query.append("            A.IMDG_UN_NO_SEQ, " ).append("\n"); 
		query.append("            A.IMDG_CLSS_CD, " ).append("\n"); 
		query.append("            A.IMDG_SUBS_RSK_LBL_CD1 " ).append("\n"); 
		query.append("            ||DECODE(A.IMDG_SUBS_RSK_LBL_CD2,NULL,NULL,'/') " ).append("\n"); 
		query.append("            ||A.IMDG_SUBS_RSK_LBL_CD2 " ).append("\n"); 
		query.append("            ||DECODE(A.IMDG_SUBS_RSK_LBL_CD3,NULL,NULL,'/') " ).append("\n"); 
		query.append("            ||A.IMDG_SUBS_RSK_LBL_CD3 " ).append("\n"); 
		query.append("            ||DECODE(A.IMDG_SUBS_RSK_LBL_CD4,NULL,NULL, '/') " ).append("\n"); 
		query.append("            ||A.IMDG_SUBS_RSK_LBL_CD4 AS IMDG_SUBS_RSK_LBL_CD, 		 " ).append("\n"); 
		query.append("            A.MRN_POLUT_FLG, " ).append("\n"); 
		query.append("            DECODE(A.IMDG_PCK_GRP_CD,'N',NULL, " ).append("\n"); 
		query.append("                                     '1','I', " ).append("\n"); 
		query.append("                                     '2','II', " ).append("\n"); 
		query.append("                                     '3','III') AS IMDG_PCK_GRP_CD, " ).append("\n"); 
		query.append("            A.IMDG_LMT_QTY_FLG, " ).append("\n"); 
		query.append("            A.IMDG_EXPT_QTY_FLG, " ).append("\n"); 
		query.append("            A.FLSH_PNT_CDO_TEMP, " ).append("\n"); 
		query.append("            A.GRS_WGT, " ).append("\n"); 
		query.append("            A.NET_WGT, " ).append("\n"); 
		query.append("            A.PSA_NO, " ).append("\n"); 
		query.append("            A.BKG_NO, " ).append("\n"); 
		query.append("            A.SPCL_CGO_APRO_RQST_SEQ, " ).append("\n"); 
		query.append("            A.SPCL_CGO_RQST_SEQ, " ).append("\n"); 
		query.append("            A.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("            A.VSL_SEQ, " ).append("\n"); 
		query.append("            A.CNTR_NO, " ).append("\n"); 
		query.append("            A.DCGO_REF_NO," ).append("\n"); 
		query.append("            A.DCGO_SEQ, " ).append("\n"); 
		query.append("            A.DCGO_QTY, " ).append("\n"); 
		query.append("            A.LST_RQST_DAT_FLG, " ).append("\n"); 
		query.append("            A.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("            A.POD_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("            A.POL_YD_CD, " ).append("\n"); 
		query.append("            A.POD_YD_CD, " ).append("\n"); 
		query.append("            A.RGN_SHP_OPR_CD, " ).append("\n"); 
		query.append("            A.SPCL_CGO_CATE_CD, " ).append("\n"); 
		query.append("            G.SPCL_CGO_AUTH_NO, " ).append("\n"); 
		query.append("            G.AUTH_OFC_CD, " ).append("\n"); 
		query.append("            G.SPCL_CGO_AUTH_SEQ, " ).append("\n"); 
		query.append("            SCG_GET_MPA1_NET_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.POL_CD, " ).append("\n"); 
		query.append("                                 A.POD_CD,A.IMDG_CLSS_CD) AS NET_WGT_SUM, " ).append("\n"); 
		query.append("            TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT, " ).append("\n"); 
		query.append("            TO_CHAR(A.RQST_GDT,'YYYY-MM-DD HH24:MI') AS RQST_GDT, " ).append("\n"); 
		query.append("            A.RQST_USR_ID, " ).append("\n"); 
		query.append("            TO_CHAR(G.AUTH_DT,'YYYY-MM-DD HH24:MI')AS AUTH_DT, " ).append("\n"); 
		query.append("            G.SPCL_CGO_AUTH_RMK, " ).append("\n"); 
		query.append("            A.IMDG_SEGR_GRP_NO," ).append("\n"); 
		query.append("            A.RSD_FLG," ).append("\n"); 
		query.append("            A.CFR_FLG," ).append("\n"); 
		query.append("            '' PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("			--2016-04-14 Duplicated data 조회 방지." ).append("\n"); 
		query.append("			,	ROW_NUMBER() OVER (PARTITION BY NVL(G.BKG_NO, A.BKG_NO), NVL(G.SPCL_CGO_APRO_RQST_SEQ, A.SPCL_CGO_APRO_RQST_SEQ), NVL(G.DCGO_SEQ, A.DCGO_SEQ), NVL(G.VSL_PRE_PST_CD, A.VSL_PRE_PST_CD), NVL(G.VSL_SEQ, A.VSL_SEQ)" ).append("\n"); 
		query.append("            	ORDER BY DECODE(G.APRO_REF_NO,NULL,9,1), G.UPD_DT DESC) AS CORR_AUTH_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM	" ).append("\n"); 
		query.append("        (	SELECT 	" ).append("\n"); 
		query.append("                    A.BKG_NO, " ).append("\n"); 
		query.append("                    A.BKG_STS_CD, " ).append("\n"); 
		query.append("                    C.SLAN_CD, " ).append("\n"); 
		query.append("                    B.SPCL_CGO_APRO_RQST_SEQ, " ).append("\n"); 
		query.append("                    B.SPCL_CGO_RQST_SEQ, " ).append("\n"); 
		query.append("                    B.SPCL_CGO_CATE_CD, " ).append("\n"); 
		query.append("                    B.DCGO_QTY, " ).append("\n"); 
		query.append("                    B.POR_CD, " ).append("\n"); 
		query.append("                    B.DEL_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    C.INDIV_EML_SND_NO," ).append("\n"); 
		query.append("                    C.OALL_EML_SND_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    B.LST_RQST_DAT_FLG, " ).append("\n"); 
		query.append("                    B.RQST_DT, " ).append("\n"); 
		query.append("                    B.RQST_GDT, " ).append("\n"); 
		query.append("                    B.RQST_USR_ID, " ).append("\n"); 
		query.append("                    C.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("                    C.VSL_SEQ, " ).append("\n"); 
		query.append("                    C.VSL_CD, " ).append("\n"); 
		query.append("                    D.VSL_ENG_NM, " ).append("\n"); 
		query.append("                    C.SKD_VOY_NO, " ).append("\n"); 
		query.append("                    C.SKD_DIR_CD, " ).append("\n"); 
		query.append("                    C.POL_CD, " ).append("\n"); 
		query.append("                    C.POD_CD, " ).append("\n"); 
		query.append("                    C.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("                    C.POD_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("                    C.POL_YD_CD, " ).append("\n"); 
		query.append("                    C.POD_YD_CD, " ).append("\n"); 
		query.append("                    NVL(G.ACT_CRR_CD,D.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("                    E.RGN_SHP_OPR_CD, " ).append("\n"); 
		query.append("                    F.DCGO_REF_NO," ).append("\n"); 
		query.append("                    F.DCGO_SEQ, " ).append("\n"); 
		query.append("                    F.DG_CNTR_SEQ, " ).append("\n"); 
		query.append("                    F.CNTR_CGO_SEQ, " ).append("\n"); 
		query.append("                    F.CNTR_NO, " ).append("\n"); 
		query.append("                    F.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                    F.IMDG_UN_NO, " ).append("\n"); 
		query.append("                    F.IMDG_UN_NO_SEQ, " ).append("\n"); 
		query.append("                    F.IMDG_CLSS_CD, " ).append("\n"); 
		query.append("                    F.IMDG_SUBS_RSK_LBL_CD1," ).append("\n"); 
		query.append("                    F.IMDG_SUBS_RSK_LBL_CD2," ).append("\n"); 
		query.append("                    F.IMDG_SUBS_RSK_LBL_CD3," ).append("\n"); 
		query.append("                    F.IMDG_SUBS_RSK_LBL_CD4," ).append("\n"); 
		query.append("                    F.MRN_POLUT_FLG, " ).append("\n"); 
		query.append("                    F.IMDG_PCK_GRP_CD, " ).append("\n"); 
		query.append("                    F.IMDG_LMT_QTY_FLG, " ).append("\n"); 
		query.append("                    F.IMDG_EXPT_QTY_FLG, " ).append("\n"); 
		query.append("                    F.FLSH_PNT_CDO_TEMP, " ).append("\n"); 
		query.append("                    F.GRS_WGT, " ).append("\n"); 
		query.append("                    F.NET_WGT, " ).append("\n"); 
		query.append("                    F.PSA_NO, " ).append("\n"); 
		query.append("                    F.SPCL_RQST_FLG, " ).append("\n"); 
		query.append("                    V.VPS_ETA_DT," ).append("\n"); 
		query.append("                    F.PRP_SHP_NM," ).append("\n"); 
		query.append("                    F.DIFF_RMK," ).append("\n"); 
		query.append("                    F.DCGO_STS_CD," ).append("\n"); 
		query.append("                    F.IMDG_SEGR_GRP_NO," ).append("\n"); 
		query.append("                    F.RSD_FLG," ).append("\n"); 
		query.append("                    F.CFR_FLG" ).append("\n"); 
		query.append("            FROM	SCG_APRO_RQST 			B" ).append("\n"); 
		query.append("                ,	SCG_VVD_APRO_RQST 		C" ).append("\n"); 
		query.append("                ,	SCG_RGN_SHP_OPR_PORT 	E" ).append("\n"); 
		query.append("                ,	MDM_VSL_CNTR 			D" ).append("\n"); 
		query.append("                ,	BKG_DG_CGO F " ).append("\n"); 
		query.append("                ,	BKG_BOOKING 			A" ).append("\n"); 
		query.append("                ,	VSK_VSL_PORT_SKD 		V" ).append("\n"); 
		query.append("                ,	VSK_VSL_SKD 			G" ).append("\n"); 
		query.append("            WHERE	B.SPCL_CGO_CATE_CD 			= 'DG'" ).append("\n"); 
		query.append("            AND		B.LST_RQST_DAT_FLG 			= 'Y'" ).append("\n"); 
		query.append("            AND 	B.BKG_NO 					= C.BKG_NO" ).append("\n"); 
		query.append("            AND 	B.SPCL_CGO_APRO_RQST_SEQ 	= C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("            AND 	C.POL_CD 					= E.LOC_CD" ).append("\n"); 
		query.append("            AND 	C.VSL_CD 					= D.VSL_CD" ).append("\n"); 
		query.append("            AND 	D.DELT_FLG 					= 'N'" ).append("\n"); 
		query.append("            AND 	E.DELT_FLG 					= 'N'" ).append("\n"); 
		query.append("            AND 	B.BKG_NO 					= F.BKG_NO" ).append("\n"); 
		query.append("            AND 	F.SPCL_CGO_APRO_CD 			IS NOT NULL" ).append("\n"); 
		query.append("            AND 	V.VSL_CD 					= C.VSL_CD" ).append("\n"); 
		query.append("            AND 	V.SKD_VOY_NO 				= C.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND 	V.SKD_DIR_CD 				= C.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND     C.VSL_CD                    = G.VSL_CD" ).append("\n"); 
		query.append("            AND     C.SKD_VOY_NO                = G.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND     C.SKD_DIR_CD                = G.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND 	V.VPS_PORT_CD 				= C.POL_CD" ).append("\n"); 
		query.append("            AND 	V.CLPT_IND_SEQ 				= C.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            AND 	B.BKG_NO 					= A.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${prp_shp_nm} != '') " ).append("\n"); 
		query.append("            AND 	UPPER(F.PRP_SHP_NM) 				LIKE '%'||UPPER(@[prp_shp_nm])||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND 	A.BKG_STS_CD 				!= 'X'" ).append("\n"); 
		query.append("            AND 	F.SPCL_CGO_APRO_CD 			NOT IN ('C','D')" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rgn_shp_opr_cd} != '') " ).append("\n"); 
		query.append("            AND		E.RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if ($slan_cd.size() > 0) " ).append("\n"); 
		query.append("            AND 	C.SLAN_CD IN ( " ).append("\n"); 
		query.append("                    #foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("                        #if($velocityCount < $slan_cd.size()) " ).append("\n"); 
		query.append("                            '$key', " ).append("\n"); 
		query.append("                        #else " ).append("\n"); 
		query.append("                            '$key' " ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("            AND		C.VSL_CD 			IN ( @[vsl_cd] )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("            AND 	F.IMDG_UN_NO 		= @[imdg_un_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${imdg_un_no_seq} != '') " ).append("\n"); 
		query.append("            AND 	F.IMDG_UN_NO_SEQ 	= @[imdg_un_no_seq]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("            AND 	F.IMDG_CLSS_CD 		= @[imdg_clss_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("            AND		C.SKD_VOY_NO 		IN ( @[skd_voy_no] )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("            AND 	C.SKD_DIR_CD 		IN ( @[skd_dir_cd] )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${pol_cd} != '') " ).append("\n"); 
		query.append("            AND 	C.POL_CD 			= @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${pod_cd} != '') " ).append("\n"); 
		query.append("            AND 	C.POD_CD 			= @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${val_opr_tp_cd} == 'H')" ).append("\n"); 
		query.append("            AND 	D.CRR_CD 			= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${val_opr_tp_cd} == 'O')" ).append("\n"); 
		query.append("            AND		D.CRR_CD 			!= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("        #end  	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${booking_no} != '') " ).append("\n"); 
		query.append("            AND 	A.BKG_NO 			= @[booking_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${dcgo_ref_no} != '') " ).append("\n"); 
		query.append("            AND 	F.DCGO_REF_NO 		= @[dcgo_ref_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${shpr_nm} != '') " ).append("\n"); 
		query.append("            AND 	A.BKG_NO IN (" ).append("\n"); 
		query.append("                        SELECT 	SH.BKG_NO" ).append("\n"); 
		query.append("                        FROM 	BKG_CUSTOMER SH" ).append("\n"); 
		query.append("                        WHERE 	SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                        AND 	SH.CUST_NM LIKE '%'||@[shpr_nm]||'%'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${from_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("            AND V.VPS_ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYYMMDD') AND TO_DATE(@[to_eta_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("        #elseif (${from_eta_dt} != '') " ).append("\n"); 
		query.append("            AND DECODE(C.VSL_PRE_PST_CD,'U',V.VPS_ETA_DT,B.RQST_DT)	<= NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,BKG_COM_USER_LOC_FNC(@[usr_id])), SYSDATE) + TO_NUMBER(@[from_eta_dt])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("            ) A, " ).append("\n"); 
		query.append("            SCG_AUTHORIZATION G" ).append("\n"); 
		query.append("    WHERE	A.BKG_NO 					= G.BKG_NO (+) " ).append("\n"); 
		query.append("    AND 	A.SPCL_CGO_APRO_RQST_SEQ 	= G.SPCL_CGO_APRO_RQST_SEQ (+) " ).append("\n"); 
		query.append("    AND 	A.VSL_PRE_PST_CD 			= G.VSL_PRE_PST_CD (+) " ).append("\n"); 
		query.append("    AND 	A.VSL_SEQ 					= G.VSL_SEQ (+) " ).append("\n"); 
		query.append("    AND 	A.DCGO_SEQ 					= G.DCGO_SEQ (+) " ).append("\n"); 
		query.append("    #if (${apro_ref_no} != '') " ).append("\n"); 
		query.append("    AND     G.APRO_REF_NO 				= @[apro_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )A" ).append("\n"); 
		query.append("    WHERE 	1 = 1" ).append("\n"); 
		query.append("	AND  	A.CORR_AUTH_SEQ 			= 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'Y') " ).append("\n"); 
		query.append("        AND SPCL_CGO_AUTH_CD_CHK    	= 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'U') " ).append("\n"); 
		query.append("        AND SPCL_CGO_AUTH_CD_CHK 	    = 'R'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'N') " ).append("\n"); 
		query.append("        AND SPCL_CGO_AUTH_CD_CHK		= 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'YN')" ).append("\n"); 
		query.append("        AND SPCL_CGO_AUTH_CD_CHK		IN ('Y','N','R','P')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${scg_all_flg} != 'Y')" ).append("\n"); 
		query.append("        AND ORD_SEQ IS NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT		2 AS ORD_SEQ" ).append("\n"); 
		query.append("            ,   XX.SLAN_CD" ).append("\n"); 
		query.append("            ,	XX.VSL_CD" ).append("\n"); 
		query.append("            ,	XX.VSL_NM" ).append("\n"); 
		query.append("            ,	XX.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,	XX.SKD_DIR_CD" ).append("\n"); 
		query.append("            ,   '' POR_CD" ).append("\n"); 
		query.append("            ,	XX.POL_CD" ).append("\n"); 
		query.append("            ,	XX.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,	XX.POD_CD" ).append("\n"); 
		query.append("            ,	XX.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,   '' DEL_CD " ).append("\n"); 
		query.append("            ,	XX.CRR_CD" ).append("\n"); 
		query.append("            ,	XX.CGO_OPR_CD" ).append("\n"); 
		query.append("            ,	XX.BOOKING_NO " ).append("\n"); 
		query.append("            ,  	XX.DCGO_REF_NO" ).append("\n"); 
		query.append("            ,  	XX.EML_SND_HIS_FLG        " ).append("\n"); 
		query.append("            ,   '' BKG_STS_CD" ).append("\n"); 
		query.append("            ,	XX.AUTH_STS_CD AS SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append("            ,   '' SPCL_CGO_AUTH_CD_CHK" ).append("\n"); 
		query.append("            ,	XX.SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("            ,	XX.APRO_REF_NO" ).append("\n"); 
		query.append("            ,	XX.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("            ,	XX.SPCL_CGO_SEQ        " ).append("\n"); 
		query.append("            ,	XX.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,   '' DG_TP" ).append("\n"); 
		query.append("            ,	XX.IMDG_UN_NO" ).append("\n"); 
		query.append("            ,	XX.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("            ,	XX.IMDG_CLSS_CD        " ).append("\n"); 
		query.append("            ,	XX.PRP_SHP_NM" ).append("\n"); 
		query.append("            ,	XX.IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("            ,	XX.MRN_POLUT_FLG" ).append("\n"); 
		query.append("            ,	XX.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("            ,	XX.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("            ,	XX.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("            ,	XX.RSD_FLG" ).append("\n"); 
		query.append("            ,	XX.FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("            ,	XX.GRS_WGT" ).append("\n"); 
		query.append("            ,	XX.NET_WGT" ).append("\n"); 
		query.append("            ,	XX.PSA_NO        " ).append("\n"); 
		query.append("            ,	XX.CGO_RQST_DT AS RQST_DT" ).append("\n"); 
		query.append("            ,	XX.AUTH_DT" ).append("\n"); 
		query.append("            ,   '' AS VPS_ETA_DT " ).append("\n"); 
		query.append("            ,	XX.DIFF_RMK" ).append("\n"); 
		query.append("            ,	XX.IMDG_SEGR_GRP_NM" ).append("\n"); 
		query.append("            ,	XX.DCGO_STS_CD" ).append("\n"); 
		query.append("            ,  	XX.NET_WGT_SUM        " ).append("\n"); 
		query.append("            ,   '' SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("            ,   '' VSL_PRE_PST_CD" ).append("\n"); 
		query.append("            ,   '' VSL_SEQ" ).append("\n"); 
		query.append("            ,   '' SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("            ,   XX.SPCL_CGO_CATE_CD     " ).append("\n"); 
		query.append("            ,   '' DCGO_SEQ" ).append("\n"); 
		query.append("            ,	XX.RGN_SHP_OPR_CD        " ).append("\n"); 
		query.append("            ,   '' SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append("            ,	XX.SPCL_CGO_AUTH_RMK       " ).append("\n"); 
		query.append("            ,   '' POL_YD_CD" ).append("\n"); 
		query.append("            ,   '' POD_YD_CD" ).append("\n"); 
		query.append("            ,   XX.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("            ,   '' CFR_FLG" ).append("\n"); 
		query.append("            ,	XX.BKG_REF_NO" ).append("\n"); 
		query.append("            ,   XX.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("    FROM   (" ).append("\n"); 
		query.append("         --=============================================================================" ).append("\n"); 
		query.append("    SELECT 		" ).append("\n"); 
		query.append("        RQS.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("    ,   RQS.SRC_TP_CD" ).append("\n"); 
		query.append("    ,   RQS.VSL_CD" ).append("\n"); 
		query.append("    ,   MDM.VSL_ENG_NM VSL_NM" ).append("\n"); 
		query.append("    ,   RQS.SKD_VOY_NO" ).append("\n"); 
		query.append("    ,	RQS.SKD_DIR_CD" ).append("\n"); 
		query.append("    ,	RQS.SLAN_CD" ).append("\n"); 
		query.append("    ,   RQS.CRR_CD" ).append("\n"); 
		query.append("    ,	CGO.CGO_OPR_CD" ).append("\n"); 
		query.append("    ,	RQS.POL_CD" ).append("\n"); 
		query.append("    ,   NVL(RQS.POL_CLPT_IND_SEQ, '1')  POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,	TO_CHAR(RQS.ETA_DT, 'YYYY-MM-DD HH24:MI') ETA_DT" ).append("\n"); 
		query.append("    ,	RQS.POD_CD" ).append("\n"); 
		query.append("    ,   NVL(RQS.POD_CLPT_IND_SEQ, '1') POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    ,	RQS.BKG_REF_NO" ).append("\n"); 
		query.append("    ,	RQS.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("    ,	CGO.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("    ,	CGO.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("    #if (${scg_flg} == 'AWK' || ${scg_flg} == 'SCG_AWK' || ${scg_flg} == 'SCG_45') " ).append("\n"); 
		query.append("    ,   CGO.AUTH_STS_CD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    ,   DECODE(CGO.AUTH_STS_CD,'R',DECODE(CGO.SPCL_RQST_FLG,'Y','S','')||'R'||CGO.SPCL_CGO_RQST_SEQ, CGO.AUTH_STS_CD) AS AUTH_STS_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ,	DECODE(CGO.APRO_REF_NO,'0','',CGO.APRO_REF_NO) APRO_REF_NO" ).append("\n"); 
		query.append("    ,   CGO.SPCL_CGO_AUTH_RJCT_CD                      AS SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("    ,   CGO.SPCL_CGO_AUTH_RMK                          AS SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("    ,	CGO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,	DECODE(CGO.IMDG_UN_NO,'0','',CGO.IMDG_UN_NO) IMDG_UN_NO" ).append("\n"); 
		query.append("    ,   ( SELECT LISTAGG (X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM, ',') WITHIN GROUP (ORDER BY X.IMDG_SEGR_GRP_NO||'|'||X.IMDG_SEGR_GRP_NM)" ).append("\n"); 
		query.append("            FROM SCG_IMDG_SEGR_GRP X" ).append("\n"); 
		query.append("               , SCG_IMDG_SEGR_GRP_DTL Y" ).append("\n"); 
		query.append("           WHERE X.IMDG_SEGR_GRP_NO = Y.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("             AND Y.IMDG_UN_NO       = CGO.IMDG_UN_NO" ).append("\n"); 
		query.append("           GROUP BY Y.IMDG_UN_NO " ).append("\n"); 
		query.append("        ) IMDG_SEGR_GRP_NM " ).append("\n"); 
		query.append("    ,   CGO.IMDG_SEGR_GRP_NO AS IMDG_SEGR_GRP_NO " ).append("\n"); 
		query.append("    ,	DECODE(CGO.IMDG_UN_NO_SEQ,'0','',CGO.IMDG_UN_NO_SEQ) IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("    ,	CGO.IMDG_CLSS_CD" ).append("\n"); 
		query.append("    ,	(DECODE(CGO.N1ST_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N1ST_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("       ||DECODE(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N2ND_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("       ||DECODE(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N3RD_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("       ||DECODE(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N4TH_IMDG_SUBS_RSK_LBL_CD)) IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("    ,	CGO.MRN_POLUT_FLG" ).append("\n"); 
		query.append("    ,   DECODE(CGO.IMDG_PCK_GRP_CD,'1','I','2','II','3','III','') IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("    ,	CGO.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("    ,	CGO.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("    ,   NVL(CGO.RSD_FLG, 'N') AS RSD_FLG" ).append("\n"); 
		query.append("    ,   CGO.FLSH_PNT_CDO_TEMP FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,	CGO.GRS_WGT" ).append("\n"); 
		query.append("    ,	CGO.NET_WGT" ).append("\n"); 
		query.append("    ,   DECODE(CGO.PSA_NO,'0','',CGO.PSA_NO) PSA_NO" ).append("\n"); 
		query.append("    ,   TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC( GLOBALDATE_PKG.GET_LOCCD_FNC(RQS.RQST_OFC_CD), CGO_RQST_DT,'GMT'), CGO_RQST_DT),'YYYY-MM-DD HH24:MI') CGO_RQST_DT" ).append("\n"); 
		query.append("    ,	DECODE(CGO.AUTH_STS_CD,'R','',TO_CHAR(CGO.AUTH_DT,'YYYY-MM-DD')) AUTH_DT" ).append("\n"); 
		query.append("    ,	RQS.UPD_DT" ).append("\n"); 
		query.append("    ,   CGO.AUTH_STS_CD AUTH_FLG" ).append("\n"); 
		query.append("    ,   RQS.BKG_REF_NO BOOKING_NO" ).append("\n"); 
		query.append("    ,   CGO.STS_CT" ).append("\n"); 
		query.append("    ,   CGO.PRP_SHP_NM        PRP_SHP_NM" ).append("\n"); 
		query.append("    ,   CGO.HZD_DESC          HZD_DESC" ).append("\n"); 
		query.append("    ,   CGO.DCGO_STS_CD       DCGO_STS_CD" ).append("\n"); 
		query.append("    ,   CGO.DIFF_RMK   		  DIFF_RMK" ).append("\n"); 
		query.append("    ,	CGO.SPCL_CGO_CATE_CD   AS SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("    ,   SCG_GET_MPA1_NET_FNC(RQS.VSL_CD, RQS.SKD_VOY_NO, RQS.SKD_DIR_CD, RQS.POL_CD, RQS.POD_CD, CGO.IMDG_CLSS_CD) AS NET_WGT_SUM" ).append("\n"); 
		query.append("    ,   CGO.DCGO_REF_NO   AS DCGO_REF_NO" ).append("\n"); 
		query.append("    ,   CASE WHEN (SELECT COUNT(1) " ).append("\n"); 
		query.append("                   FROM   SCG_PRNR_APRO_RQST  RQ" ).append("\n"); 
		query.append("                        , COM_EML_SND_INFO    EM" ).append("\n"); 
		query.append("                   WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND    RQ.EML_SND_NO       = EM.EML_SND_NO" ).append("\n"); 
		query.append("                   AND    EM.EML_PROC_STS_CD  = '1'           -- ::'1'-'W','3'-'Y','4'-'F':: --" ).append("\n"); 
		query.append("                   AND    RQ.CRR_CD           = RQS.CRR_CD" ).append("\n"); 
		query.append("                   AND    RQ.BKG_REF_NO       = RQS.BKG_REF_NO" ).append("\n"); 
		query.append("                   AND    RQ.VSL_CD           = RQS.VSL_CD" ).append("\n"); 
		query.append("                   AND    RQ.SKD_VOY_NO       = RQS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND    RQ.SKD_DIR_CD       = RQS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND	  RQ.POL_CD			  = RQS.POL_CD" ).append("\n"); 
		query.append("                   AND	  RQ.POD_CD			  = RQS.POD_CD" ).append("\n"); 
		query.append("                   ) > 0  THEN 'W'" ).append("\n"); 
		query.append("             WHEN (SELECT COUNT(1) " ).append("\n"); 
		query.append("                   FROM   SCG_PRNR_APRO_RQST  RQ" ).append("\n"); 
		query.append("                        , COM_EML_SND_INFO    EM" ).append("\n"); 
		query.append("                   WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND    RQ.EML_SND_NO       = EM.EML_SND_NO" ).append("\n"); 
		query.append("                   AND    EM.EML_PROC_STS_CD  = '3'           -- ::'1'-'W','3'-'Y','4'-'F':: --" ).append("\n"); 
		query.append("                   AND    RQ.CRR_CD           = RQS.CRR_CD" ).append("\n"); 
		query.append("                   AND    RQ.BKG_REF_NO       = RQS.BKG_REF_NO" ).append("\n"); 
		query.append("                   AND    RQ.VSL_CD           = RQS.VSL_CD" ).append("\n"); 
		query.append("                   AND    RQ.SKD_VOY_NO       = RQS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND    RQ.SKD_DIR_CD       = RQS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND	  RQ.POL_CD			  = RQS.POL_CD" ).append("\n"); 
		query.append("                   AND	  RQ.POD_CD			  = RQS.POD_CD" ).append("\n"); 
		query.append("                   ) > 0  THEN 'Y'" ).append("\n"); 
		query.append("             WHEN (SELECT COUNT(1) " ).append("\n"); 
		query.append("                   FROM   SCG_PRNR_APRO_RQST  RQ" ).append("\n"); 
		query.append("                        , COM_EML_SND_INFO    EM" ).append("\n"); 
		query.append("                   WHERE  1 = 1" ).append("\n"); 
		query.append("                   AND    RQ.EML_SND_NO       = EM.EML_SND_NO" ).append("\n"); 
		query.append("                   AND    EM.EML_PROC_STS_CD  = '4'           -- ::'1'-'W','3'-'Y','4'-'F':: --" ).append("\n"); 
		query.append("                   AND    RQ.CRR_CD           = RQS.CRR_CD" ).append("\n"); 
		query.append("                   AND    RQ.BKG_REF_NO       = RQS.BKG_REF_NO" ).append("\n"); 
		query.append("                   AND    RQ.VSL_CD           = RQS.VSL_CD" ).append("\n"); 
		query.append("                   AND    RQ.SKD_VOY_NO       = RQS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND    RQ.SKD_DIR_CD       = RQS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND	  RQ.POL_CD			  = RQS.POL_CD" ).append("\n"); 
		query.append("                   AND	  RQ.POD_CD			  = RQS.POD_CD" ).append("\n"); 
		query.append("                   ) > 0  THEN 'F'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END  EML_SND_HIS_FLG" ).append("\n"); 
		query.append("    ,	CGO.PRNR_CGO_RQST_SEQ||'' AS PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("    FROM SCG_PRNR_APRO_RQST      RQS" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("         SELECT T.*" ).append("\n"); 
		query.append("              , AVG(DECODE(T.AUTH_STS_CD,'Y',1,'N',2,-999)) OVER (PARTITION BY T.CRR_CD, T.BKG_REF_NO, T.SPCL_CGO_RQST_SEQ) STS_CT" ).append("\n"); 
		query.append("           FROM SCG_PRNR_APRO_RQST_CGO T" ).append("\n"); 
		query.append("         ) CGO" ).append("\n"); 
		query.append("       , SCG_IMDG_UN_NO          SUN" ).append("\n"); 
		query.append("       , MDM_VSL_CNTR            MDM" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    #if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("      AND RQS.RGN_SHP_OPR_CD    = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("      AND RQS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("      AND RQS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("      AND RQS.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${scg_flg} == 'DG1' || ${scg_flg} == 'SCG_DG') " ).append("\n"); 
		query.append("      AND RQS.DG_FLG            = 'Y'" ).append("\n"); 
		query.append("      AND RQS.AWK_FLG           = 'N'" ).append("\n"); 
		query.append("    #elseif (${scg_flg} == 'AWK' || ${scg_flg} == 'SCG_AWK' || ${scg_flg} == 'SCG_45') " ).append("\n"); 
		query.append("      AND RQS.DG_FLG            = 'N'" ).append("\n"); 
		query.append("      AND RQS.AWK_FLG           = 'Y'" ).append("\n"); 
		query.append("    #if (${scg_flg} == 'SCG_AWK') " ).append("\n"); 
		query.append("      --::2015-04-07::--AND CGO.CNTR_TPSZ_CD <> 'D7'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${scg_flg} == 'SCG_45') " ).append("\n"); 
		query.append("      --::2015-04-07::--AND CGO.CNTR_TPSZ_CD = 'D7'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      AND RQS.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("      AND RQS.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("      AND RQS.PRNR_CGO_RQST_SEQ = CGO.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("      AND RQS.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("      AND RQS.VSL_CD            = MDM.VSL_CD" ).append("\n"); 
		query.append("      AND MDM.DELT_FLG 		    = 'N' " ).append("\n"); 
		query.append("      AND CGO.IMDG_UN_NO        = SUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("      AND CGO.IMDG_UN_NO_SEQ    = SUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND RQS.LST_RQST_DAT_FLG 	= 'Y'" ).append("\n"); 
		query.append("    -- VOP_SCG_0023(Approved)" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'Y') " ).append("\n"); 
		query.append("      AND (CGO.STS_CT = 1 OR CGO.AUTH_STS_CD = 'Y')" ).append("\n"); 
		query.append("    -- VOP_SCG_0023(Reject)" ).append("\n"); 
		query.append("    #elseif (${auth_flg} == 'N')" ).append("\n"); 
		query.append("      AND CGO.AUTH_STS_CD = 'N'" ).append("\n"); 
		query.append("    -- VOP_SCG_0023(Unapproved)" ).append("\n"); 
		query.append("    #elseif (${auth_flg} == 'U')" ).append("\n"); 
		query.append("      AND CGO.AUTH_STS_CD IN ('R','P')" ).append("\n"); 
		query.append("    -- VOP_SCG_0023(ALL)" ).append("\n"); 
		query.append("    #elseif (${auth_flg} == 'YN')" ).append("\n"); 
		query.append("      AND (CGO.STS_CT = 1 OR (CGO.AUTH_STS_CD IN('Y','N','R','P')))" ).append("\n"); 
		query.append("    -- VOP_SCG_0022" ).append("\n"); 
		query.append("    #elseif (${auth_flg} == 'S')" ).append("\n"); 
		query.append("      #if (${func_flg} == 'MNL')" ).append("\n"); 
		query.append("        AND RQS.SRC_TP_CD  <> 'EDI' --20150723" ).append("\n"); 
		query.append("        AND (CGO.AUTH_STS_CD IN('Y','N','R','P','C') OR CGO.AUTH_STS_CD IS NULL)" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("        AND RQS.SRC_TP_CD = 'EDI' " ).append("\n"); 
		query.append("        --:2015-12-23:--AND RQS.EDI_UNMAP_KND_CD IS NOT NULL" ).append("\n"); 
		query.append("        AND CGO.AUTH_STS_CD IS NULL" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("    -- VOP_SCG_5001(Pending)" ).append("\n"); 
		query.append("    #elseif (${auth_flg} == 'P')" ).append("\n"); 
		query.append("      AND CGO.AUTH_STS_CD = 'P'" ).append("\n"); 
		query.append("    -- VOP_SCG_5001(Request)" ).append("\n"); 
		query.append("    #elseif (${auth_flg} == 'R')" ).append("\n"); 
		query.append("      AND CGO.AUTH_STS_CD = 'R'" ).append("\n"); 
		query.append("    -- VOP_SCG_5001(ALL)" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND (CGO.AUTH_STS_CD IN('R','P') OR ((CGO.AUTH_STS_CD = 'Y' OR CGO.AUTH_STS_CD = 'N') AND CGO.STS_CT < 1))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ($slan_cd.size() > 0) " ).append("\n"); 
		query.append("      AND RQS.SLAN_CD IN ( " ).append("\n"); 
		query.append("        #foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("          #if($velocityCount < $slan_cd.size()) " ).append("\n"); 
		query.append("            '$key', " ).append("\n"); 
		query.append("          #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("      AND RQS.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '')" ).append("\n"); 
		query.append("      AND RQS.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cgo_opr_cd} != '')" ).append("\n"); 
		query.append("      AND CGO.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${booking_no} != '') " ).append("\n"); 
		query.append("      AND RQS.BKG_REF_NO = @[booking_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${apro_ref_no} != '') " ).append("\n"); 
		query.append("      AND CGO.APRO_REF_NO = @[apro_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("      AND CGO.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${imdg_un_no_seq} != '') " ).append("\n"); 
		query.append("      AND CGO.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("      AND CGO.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${prp_shp_nm} != '') " ).append("\n"); 
		query.append("      AND CGO.PRP_SHP_NM LIKE '%'||@[prp_shp_nm]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${apro_ref_no} != '') " ).append("\n"); 
		query.append("      AND CGO.APRO_REF_NO = @[apro_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${from_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("        AND RQS.ETA_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYYMMDD') AND TO_DATE(@[to_eta_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("    #elseif (${from_eta_dt} != '') " ).append("\n"); 
		query.append("        AND RQS.ETA_DT	<= NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,BKG_COM_USER_LOC_FNC(@[upd_usr_id])), SYSDATE) + TO_NUMBER(@[from_eta_dt])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${src_tp_cd} != '')" ).append("\n"); 
		query.append("        AND RQS.SRC_TP_CD = @[src_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${dcgo_ref_no} != '')" ).append("\n"); 
		query.append("        AND CGO.DCGO_REF_NO = @[dcgo_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${func_flg} == 'MNL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${from_req_dt} != '') " ).append("\n"); 
		query.append("        AND TO_DATE(DECODE(CGO.AUTH_STS_CD, NULL," ).append("\n"); 
		query.append("            TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(GLOBALDATE_PKG.GET_LOCCD_FNC(RQS.RQST_OFC_CD), CGO.UPD_DT,'GMT'), CGO.UPD_DT),'YYYYMMDD')," ).append("\n"); 
		query.append("            TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(GLOBALDATE_PKG.GET_LOCCD_FNC(RQS.RQST_OFC_CD), CGO.CGO_RQST_DT,'GMT'), CGO.CGO_RQST_DT),'YYYYMMDD')" ).append("\n"); 
		query.append("            ),'YYYYMMDD')	>= TO_DATE(@[from_req_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${to_req_dt} != '') " ).append("\n"); 
		query.append("        AND TO_DATE(DECODE(CGO.AUTH_STS_CD, NULL," ).append("\n"); 
		query.append("            TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(GLOBALDATE_PKG.GET_LOCCD_FNC(RQS.RQST_OFC_CD), CGO.UPD_DT,'GMT'), CGO.UPD_DT),'YYYYMMDD')," ).append("\n"); 
		query.append("            TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(GLOBALDATE_PKG.GET_LOCCD_FNC(RQS.RQST_OFC_CD), CGO.CGO_RQST_DT,'GMT'), CGO.CGO_RQST_DT),'YYYYMMDD')" ).append("\n"); 
		query.append("            ),'YYYYMMDD')	<= TO_DATE(@[to_req_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${from_req_dt} != '') " ).append("\n"); 
		query.append("        AND	RQS.CRE_DT	>= TO_DATE(@[from_req_dt]	,'YYYYMMDD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${to_req_dt} != '') " ).append("\n"); 
		query.append("        AND	RQS.CRE_DT	<= TO_DATE(@[to_req_dt]		,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${func_flg} == 'EDI')" ).append("\n"); 
		query.append("    AND RQS.EDI_UNMAP_KND_CD IS NOT NULL" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         --=============================================================================" ).append("\n"); 
		query.append("        ) XX" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("ORDER BY ORD_SEQ," ).append("\n"); 
		query.append("         VPS_ETA_DT," ).append("\n"); 
		query.append("         CGO_OPR_CD," ).append("\n"); 
		query.append("         SLAN_CD," ).append("\n"); 
		query.append("         VSL_CD ," ).append("\n"); 
		query.append("         SKD_VOY_NO," ).append("\n"); 
		query.append("         SKD_DIR_CD," ).append("\n"); 
		query.append("         CRR_CD," ).append("\n"); 
		query.append("         POL_CD," ).append("\n"); 
		query.append("         POD_CD," ).append("\n"); 
		query.append("         BKG_NO," ).append("\n"); 
		query.append("         SPCL_CNTR_SEQ," ).append("\n"); 
		query.append("         SPCL_CGO_SEQ" ).append("\n"); 

	}
}