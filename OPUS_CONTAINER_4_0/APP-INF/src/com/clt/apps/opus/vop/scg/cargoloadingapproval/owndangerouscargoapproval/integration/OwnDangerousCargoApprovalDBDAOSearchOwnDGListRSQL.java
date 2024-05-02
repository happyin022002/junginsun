/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchOwnDGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.10 
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

public class OwnDangerousCargoApprovalDBDAOSearchOwnDGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG-Part1, DG-Part2조회
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchOwnDGListRSQL(){
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
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchOwnDGListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       BOOKING_NO ," ).append("\n"); 
		query.append("       BKG_STS_CD ," ).append("\n"); 
		query.append("       DG_CNTR_SEQ ," ).append("\n"); 
		query.append("       CNTR_CGO_SEQ ," ).append("\n"); 
		query.append("       RQST_DAY ," ).append("\n"); 
		query.append("       SPCL_CGO_AUTH_CD ," ).append("\n"); 
		query.append("       SPCL_CGO_AUTH_RJCT_CD ," ).append("\n"); 
		query.append("       APRO_REF_NO ," ).append("\n"); 
		query.append("       CASE WHEN EDI_CHK 		<> 'Y' OR EDI_CHK IS NULL				THEN '0' " ).append("\n"); 
		query.append("			WHEN EDI_SND_NO 	= 'Y'  									THEN '1'" ).append("\n"); 
		query.append("            WHEN MAX(SPCL_CGO_AUTH_CD) OVER(PARTITION BY RNK )  <> 'P' 	THEN '0'" ).append("\n"); 
		query.append("            ELSE '1'" ).append("\n"); 
		query.append("       END EDI_CHK_TYPE," ).append("\n"); 
		query.append("       CASE WHEN EML_CHK = 'S' 				                                             THEN '1' " ).append("\n"); 
		query.append("			WHEN EML_CHK = 'N' OR  MAX(SPCL_CGO_AUTH_CD) OVER(PARTITION BY RNK )  <> 'P' THEN '0'" ).append("\n"); 
		query.append("            ELSE '1'" ).append("\n"); 
		query.append("       END EML_CHK_TYPE," ).append("\n"); 
		query.append("       EDI_SND_NO ," ).append("\n"); 
		query.append("       EML_SND_NO ," ).append("\n"); 
		query.append("       EML_SND_HIS_FLG ," ).append("\n"); 
		query.append("       EDI_SND_HIS_FLG ," ).append("\n"); 
		query.append("       EML_CHK ," ).append("\n"); 
		query.append("       EML_ADDR ," ).append("\n"); 
		query.append("       PRE_SEQ ," ).append("\n"); 
		query.append("       EDI_MSG_STS_CD ," ).append("\n"); 
		query.append("       EDI_DEL_STS_CD ," ).append("\n"); 
		query.append("       SLAN_CD ," ).append("\n"); 
		query.append("       VSL_CD ," ).append("\n"); 
		query.append("       VSL_NM ," ).append("\n"); 
		query.append("       SKD_VOY_NO ," ).append("\n"); 
		query.append("       SKD_DIR_CD ," ).append("\n"); 
		query.append("       PRP_SHP_NM ," ).append("\n"); 
		query.append("       DIFF_RMK ," ).append("\n"); 
		query.append("       DCGO_STS_CD ," ).append("\n"); 
		query.append("       CRR_CD ," ).append("\n"); 
		query.append("       CRR_CODE ," ).append("\n"); 
		query.append("       POR_CD ," ).append("\n"); 
		query.append("       POL_CD ," ).append("\n"); 
		query.append("       EDI_CHK ," ).append("\n"); 
		query.append("       MAPG_TRSM_BND_CD ," ).append("\n"); 
		query.append("       MAPG_TRSM_DT ," ).append("\n"); 
		query.append("       MAPG_TRSM_SPCL_CGO_CATE_CD ," ).append("\n"); 
		query.append("       MAPG_PRNR_SPCL_CGO_SEQ ," ).append("\n"); 
		query.append("       MAPG_EDI_TRSM_STS_CD ," ).append("\n"); 
		query.append("       VPS_ETA_DT ," ).append("\n"); 
		query.append("       POD_CD ," ).append("\n"); 
		query.append("       DEL_CD ," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("       DG_TP ," ).append("\n"); 
		query.append("       IMDG_UN_NO ," ).append("\n"); 
		query.append("       IMDG_SEGR_GRP_NM ," ).append("\n"); 
		query.append("       IMDG_UN_NO_SEQ ," ).append("\n"); 
		query.append("       IMDG_CLSS_CD ," ).append("\n"); 
		query.append("       IMDG_SUBS_RSK_LBL_CD ," ).append("\n"); 
		query.append("       MRN_POLUT_FLG ," ).append("\n"); 
		query.append("       IMDG_PCK_GRP_CD ," ).append("\n"); 
		query.append("       IMDG_LMT_QTY_FLG ," ).append("\n"); 
		query.append("       IMDG_EXPT_QTY_FLG ," ).append("\n"); 
		query.append("       FLSH_PNT_CDO_TEMP ," ).append("\n"); 
		query.append("       GRS_WGT ," ).append("\n"); 
		query.append("       NET_WGT ," ).append("\n"); 
		query.append("       PSA_NO ," ).append("\n"); 
		query.append("       HCDG_FLG ," ).append("\n"); 
		query.append("       BKG_NO ," ).append("\n"); 
		query.append("       SPCL_CGO_APRO_RQST_SEQ ," ).append("\n"); 
		query.append("       SPCL_CGO_RQST_SEQ ," ).append("\n"); 
		query.append("       VSL_PRE_PST_CD ," ).append("\n"); 
		query.append("       VSL_SEQ ," ).append("\n"); 
		query.append("       CNTR_NO ," ).append("\n"); 
		query.append("       DCGO_REF_NO ," ).append("\n"); 
		query.append("       DCGO_SEQ ," ).append("\n"); 
		query.append("       DCGO_QTY ," ).append("\n"); 
		query.append("       LST_RQST_DAT_FLG ," ).append("\n"); 
		query.append("       BKG_RCV_TERM_CD ," ).append("\n"); 
		query.append("       BKG_DE_TERM_CD ," ).append("\n"); 
		query.append("       POL_CLPT_IND_SEQ ," ).append("\n"); 
		query.append("       POD_CLPT_IND_SEQ ," ).append("\n"); 
		query.append("       POL_YD_CD ," ).append("\n"); 
		query.append("       POD_YD_CD ," ).append("\n"); 
		query.append("       RGN_SHP_OPR_CD ," ).append("\n"); 
		query.append("       SPCL_CGO_CATE_CD ," ).append("\n"); 
		query.append("       SPCL_CGO_AUTH_NO ," ).append("\n"); 
		query.append("       AUTH_OFC_CD ," ).append("\n"); 
		query.append("       SPCL_CGO_AUTH_SEQ ," ).append("\n"); 
		query.append("       NET_WGT_SUM ," ).append("\n"); 
		query.append("       SCG_FLG ," ).append("\n"); 
		query.append("       RQST_AUTH_CD ," ).append("\n"); 
		query.append("       RQST_OFC_CD ," ).append("\n"); 
		query.append("       RQST_DT ," ).append("\n"); 
		query.append("       RQST_GDT ," ).append("\n"); 
		query.append("       RQST_USR_ID ," ).append("\n"); 
		query.append("       AUTH_DT ," ).append("\n"); 
		query.append("       AUTH_GDT ," ).append("\n"); 
		query.append("       AUTH_USR_ID ," ).append("\n"); 
		query.append("       SPCL_CGO_AUTH_RMK ," ).append("\n"); 
		query.append("       SPCL_RQST_DESC ," ).append("\n"); 
		query.append("       IN_IMDG_PCK_QTY1 ," ).append("\n"); 
		query.append("       OUT_IMDG_PCK_QTY1 ," ).append("\n"); 
		query.append("       INTMD_IMDG_PCK_QTY1 ," ).append("\n"); 
		query.append("       IMDG_SEGR_GRP_NO ," ).append("\n"); 
		query.append("       RSD_FLG ," ).append("\n"); 
		query.append("       CFR_FLG ," ).append("\n"); 
		query.append("       ITM_STS_CD ," ).append("\n"); 
		query.append("       --2016-07-01" ).append("\n"); 
		query.append("       UPD_DT " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("    SELECT RANK() OVER( ORDER BY A.VPS_ETA_DT, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CRR_CD, A.POL_CD, A.POD_CD, A.BKG_NO ) AS RNK" ).append("\n"); 
		query.append("         , BOOKING_NO" ).append("\n"); 
		query.append("         , BKG_STS_CD" ).append("\n"); 
		query.append("         , DG_CNTR_SEQ" ).append("\n"); 
		query.append("         , CNTR_CGO_SEQ" ).append("\n"); 
		query.append("         , RQST_DAY" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append("         , APRO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , EDI_SND_NO" ).append("\n"); 
		query.append("         , EML_SND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("            " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("         , CASE WHEN (SELECT COUNT(1) " ).append("\n"); 
		query.append("                      FROM   SCG_VVD_APRO_RQST   RQ" ).append("\n"); 
		query.append("                      WHERE  1 = 1" ).append("\n"); 
		query.append("                      AND    RQ.BKG_NO           = A.BOOKING_NO   " ).append("\n"); 
		query.append("                      AND    RQ.VSL_PRE_PST_CD   = A.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                      AND    RQ.VSL_SEQ          = A.VSL_SEQ" ).append("\n"); 
		query.append("                      AND    RQ.VSL_CD           = A.VSL_CD" ).append("\n"); 
		query.append("                      AND    RQ.SKD_VOY_NO       = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND    RQ.SKD_DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND    RQ.MAPG_EDI_TRSM_STS_CD = 'S'     " ).append("\n"); 
		query.append("                      ) > 0  THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("            END  EDI_SND_HIS_FLG " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , EML_CHK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , EML_ADDR" ).append("\n"); 
		query.append("         , PRE_SEQ" ).append("\n"); 
		query.append("         , DECODE(EDI_MSG_STS_CD, 'NR', 'N', EDI_MSG_STS_CD) EDI_MSG_STS_CD" ).append("\n"); 
		query.append("         , DECODE(EDI_MSG_STS_CD, 'NR', 'Y', 'N')            EDI_DEL_STS_CD" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , VSL_NM" ).append("\n"); 
		query.append("         , SKD_VOY_NO" ).append("\n"); 
		query.append("         , SKD_DIR_CD" ).append("\n"); 
		query.append("         , PRP_SHP_NM" ).append("\n"); 
		query.append("         , DIFF_RMK" ).append("\n"); 
		query.append("         , DCGO_STS_CD" ).append("\n"); 
		query.append("         , CRR_CD" ).append("\n"); 
		query.append("         , CRR_CODE" ).append("\n"); 
		query.append("         , POR_CD" ).append("\n"); 
		query.append("         , POL_CD" ).append("\n"); 
		query.append("         , EDI_CHK" ).append("\n"); 
		query.append("         , MAPG_TRSM_BND_CD" ).append("\n"); 
		query.append("         , MAPG_TRSM_DT" ).append("\n"); 
		query.append("         , MAPG_TRSM_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("         , MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("         , MAPG_EDI_TRSM_STS_CD" ).append("\n"); 
		query.append("         , VPS_ETA_DT" ).append("\n"); 
		query.append("         , POD_CD" ).append("\n"); 
		query.append("         , DEL_CD" ).append("\n"); 
		query.append("         , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , DG_TP" ).append("\n"); 
		query.append("         , IMDG_UN_NO" ).append("\n"); 
		query.append("         , IMDG_SEGR_GRP_NM" ).append("\n"); 
		query.append("         , IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("         , IMDG_CLSS_CD" ).append("\n"); 
		query.append("         , IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("         , MRN_POLUT_FLG" ).append("\n"); 
		query.append("         , IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("         , IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("         , IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append("         , FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("         , GRS_WGT" ).append("\n"); 
		query.append("         , NET_WGT" ).append("\n"); 
		query.append("         , PSA_NO" ).append("\n"); 
		query.append("         , HCDG_FLG" ).append("\n"); 
		query.append("         , BKG_NO" ).append("\n"); 
		query.append("         , SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("         , SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("         , VSL_PRE_PST_CD" ).append("\n"); 
		query.append("         , VSL_SEQ" ).append("\n"); 
		query.append("         , CNTR_NO" ).append("\n"); 
		query.append("         , DCGO_REF_NO" ).append("\n"); 
		query.append("         , DCGO_SEQ" ).append("\n"); 
		query.append("         , DCGO_QTY" ).append("\n"); 
		query.append("         , LST_RQST_DAT_FLG" ).append("\n"); 
		query.append("         , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("         , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("         , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("         , POL_YD_CD" ).append("\n"); 
		query.append("         , POD_YD_CD" ).append("\n"); 
		query.append("         , RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append("         , AUTH_OFC_CD" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("         , NET_WGT_SUM" ).append("\n"); 
		query.append("         , SCG_FLG" ).append("\n"); 
		query.append("         , RQST_AUTH_CD" ).append("\n"); 
		query.append("         , RQST_OFC_CD" ).append("\n"); 
		query.append("         , RQST_DT" ).append("\n"); 
		query.append("         , RQST_GDT" ).append("\n"); 
		query.append("         , RQST_USR_ID" ).append("\n"); 
		query.append("         , AUTH_DT" ).append("\n"); 
		query.append("         , AUTH_GDT" ).append("\n"); 
		query.append("         , AUTH_USR_ID" ).append("\n"); 
		query.append("         , SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append("         , SPCL_RQST_DESC" ).append("\n"); 
		query.append("         , IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("         , OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("         , INTMD_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("         , IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("         , NVL(RSD_FLG, 'N') RSD_FLG" ).append("\n"); 
		query.append("         , CFR_FLG" ).append("\n"); 
		query.append("         , ITM_STS_CD" ).append("\n"); 
		query.append("          --2016-07-01" ).append("\n"); 
		query.append("         , UPD_DT" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("    SELECT	A.BKG_NO AS BOOKING_NO," ).append("\n"); 
		query.append("            A.BKG_STS_CD," ).append("\n"); 
		query.append("            A.DG_CNTR_SEQ," ).append("\n"); 
		query.append("            A.CNTR_CGO_SEQ, " ).append("\n"); 
		query.append("            ROUND(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE) - A.RQST_GDT,1) AS RQST_DAY, " ).append("\n"); 
		query.append("            DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',DECODE(A.SPCL_RQST_FLG,'Y','S','')||'R'||A.SPCL_CGO_RQST_SEQ,G.SPCL_CGO_AUTH_CD) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("            SUBSTR(DECODE(NVL(G.SPCL_CGO_AUTH_CD,'R'),'R',DECODE(A.SPCL_RQST_FLG,'Y','','')||'R'||A.SPCL_CGO_RQST_SEQ,G.SPCL_CGO_AUTH_CD),1,1) AS SPCL_CGO_AUTH_CD_CHK, " ).append("\n"); 
		query.append("            G.SPCL_CGO_AUTH_RJCT_CD, " ).append("\n"); 
		query.append("            G.APRO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,	DECODE(A.MAPG_EDI_TRSM_STS_CD, 'S', 'Y', 'SX', 'Y', NVL(A.MAPG_EDI_TRSM_STS_CD, '')) AS EDI_SND_NO" ).append("\n"); 
		query.append("        ,	(SELECT DECODE(EML_PROC_STS_CD,'1','W','3','Y','4','F','')" ).append("\n"); 
		query.append("             FROM   COM_EML_SND_INFO   	EM" ).append("\n"); 
		query.append("             WHERE  EM.EML_SND_NO 		= A.OALL_EML_SND_NO) AS EML_SND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,	CASE WHEN LENGTH(NVL(TRIM(A.OALL_EML_SND_NO),0)) = 1 AND A.CRR_CD IN ('HLC', 'OOL', 'HMM', 'HSD')	/*'HAM'*/ " ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN LENGTH(NVL(TRIM(A.OALL_EML_SND_NO),0)) > 1" ).append("\n"); 
		query.append("                    THEN 'S'" ).append("\n"); 
		query.append("                 ELSE 'N' " ).append("\n"); 
		query.append("            END  AS EML_CHK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,	(" ).append("\n"); 
		query.append("             SELECT CNTC_PSON_EML_CTNT" ).append("\n"); 
		query.append("               FROM SCG_CNTC_PNT" ).append("\n"); 
		query.append("              WHERE RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("                AND CRR_CD = A.CRR_CD" ).append("\n"); 
		query.append("                AND SLAN_CD = A.SLAN_CD" ).append("\n"); 
		query.append("                AND SPCL_CGO_CATE_CD = 'DG'" ).append("\n"); 
		query.append("                AND CNTC_PSON_EML_CTNT IS NOT NULL" ).append("\n"); 
		query.append("                AND DELT_FLG != 'Y'              " ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("            ) EML_ADDR ," ).append("\n"); 
		query.append("            A.PRE_SEQ," ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			--:2016-05-03:No need this column:--" ).append("\n"); 
		query.append("			NULL			AS EDI_MSG_STS_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("            CASE WHEN A.CRR_CD IN ('HLC', 'OOL', 'HMM', 'HSD') THEN " ).append("\n"); 
		query.append("                 (SELECT CASE WHEN A.CRR_CD IN('HLC') AND CONTI_CD IN ('A', 'E', 'M') THEN 'Y'" ).append("\n"); 
		query.append("                              WHEN A.CRR_CD IN ('OOL', 'HMM', 'HSD') AND CONTI_CD = 'E' THEN 'Y'" ).append("\n"); 
		query.append("                         ELSE 'N'" ).append("\n"); 
		query.append("                     END EDI_CHK" ).append("\n"); 
		query.append("                    FROM MDM_LOCATION " ).append("\n"); 
		query.append("                   WHERE LOC_CD = A.POL_CD" ).append("\n"); 
		query.append("                     AND NVL(DELT_FLG, 'N') <> 'Y'	" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            END EDI_CHK ," ).append("\n"); 
		query.append("            A.MAPG_TRSM_BND_CD," ).append("\n"); 
		query.append("            A.MAPG_TRSM_DT," ).append("\n"); 
		query.append("            A.MAPG_TRSM_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("            A.MAPG_PRNR_SPCL_CGO_SEQ," ).append("\n"); 
		query.append("            A.MAPG_EDI_TRSM_STS_CD," ).append("\n"); 
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
		query.append("            A.HCDG_FLG, " ).append("\n"); 
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
		query.append("            A.BKG_RCV_TERM_CD, " ).append("\n"); 
		query.append("            A.BKG_DE_TERM_CD, " ).append("\n"); 
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
		query.append("            '' AS SCG_FLG, " ).append("\n"); 
		query.append("            '' AS RQST_AUTH_CD, " ).append("\n"); 
		query.append("            A.RQST_OFC_CD, " ).append("\n"); 
		query.append("            TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI') AS RQST_DT, " ).append("\n"); 
		query.append("            TO_CHAR(A.RQST_GDT,'YYYY-MM-DD HH24:MI') AS RQST_GDT, " ).append("\n"); 
		query.append("            A.RQST_USR_ID, " ).append("\n"); 
		query.append("            TO_CHAR(G.AUTH_DT,'YYYY-MM-DD HH24:MI')AS AUTH_DT, " ).append("\n"); 
		query.append("            TO_CHAR(G.AUTH_GDT,'YYYY-MM-DD HH24:MI')AS AUTH_GDT, " ).append("\n"); 
		query.append("            G.AUTH_USR_ID, " ).append("\n"); 
		query.append("            G.SPCL_CGO_AUTH_RMK, " ).append("\n"); 
		query.append("            A.SPCL_RQST_DESC, " ).append("\n"); 
		query.append("            A.IN_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("            A.OUT_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("            A.INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("            A.IMDG_SEGR_GRP_NO," ).append("\n"); 
		query.append("            A.RSD_FLG," ).append("\n"); 
		query.append("            A.CFR_FLG," ).append("\n"); 
		query.append("             CASE " ).append("\n"); 
		query.append("                 WHEN(SELECT /*+ INDEX_DESC(XPKSCG_AUTHORIZATION) */ COUNT(BKG_NO) FROM SCG_AUTHORIZATION WHERE BKG_NO = A.BKG_NO AND SPCL_CGO_CATE_CD = 'DG' AND SPCL_CGO_AUTH_CD IN ('Y','N') AND ROWNUM = 1 ) >= 1 THEN " ).append("\n"); 
		query.append("                     (SELECT  DECODE(COUNT(B.BKG_NO), 0," ).append("\n"); 
		query.append("                                     'N'," ).append("\n"); 
		query.append("                                      DECODE(MAX(B.IMDG_CLSS_CD||B.IMDG_UN_NO||B.IMDG_UN_NO_SEQ||B.PRP_SHP_NM||B.HZD_DESC||B.GRS_WGT||B.NET_WGT||B.IMDG_PCK_GRP_CD||B.PSA_NO||B.FLSH_PNT_CDO_TEMP||B.EMS_NO||B.MRN_POLUT_FLG||B.EMER_CNTC_PHN_NO_CTNT||B.EMER_CNTC_PSON_NM||B.CERTI_NO||B.NET_EXPLO_WGT||B.OUT_IMDG_PCK_QTY1||B.OUT_IMDG_PCK_CD1||B.OUT_IMDG_PCK_QTY2||B.OUT_IMDG_PCK_CD2||B.IN_IMDG_PCK_QTY1||B.IN_IMDG_PCK_CD1||B.IN_IMDG_PCK_QTY2||B.IN_IMDG_PCK_CD2)," ).append("\n"); 
		query.append("                                             MAX(S.IMDG_CLSS_CD||S.IMDG_UN_NO||S.IMDG_UN_NO_SEQ||S.PRP_SHP_NM||S.HZD_DESC||S.GRS_WGT||S.NET_WGT||S.IMDG_PCK_GRP_CD||S.PSA_NO||S.FLSH_PNT_CDO_TEMP||S.EMS_NO||S.MRN_POLUT_FLG||S.EMER_CNTC_PHN_NO_CTNT||S.EMER_CNTC_PSON_NM||S.CERTI_NO||S.NET_EXPLO_WGT||S.OUT_IMDG_PCK_QTY1||S.OUT_IMDG_PCK_CD1||S.OUT_IMDG_PCK_QTY2||S.OUT_IMDG_PCK_CD2||S.IN_IMDG_PCK_QTY1||S.IN_IMDG_PCK_CD1||S.IN_IMDG_PCK_QTY2||S.IN_IMDG_PCK_CD2)," ).append("\n"); 
		query.append("                                             '','U'" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                        FROM BKG_DG_CGO B," ).append("\n"); 
		query.append("                             SCG_DG_CGO S" ).append("\n"); 
		query.append("                       WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                         AND B.DCGO_SEQ = A.DCGO_SEQ" ).append("\n"); 
		query.append("                         AND S.SPCL_CGO_APRO_RQST_SEQ = (SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) FROM SCG_AUTHORIZATION WHERE BKG_NO=A.BKG_NO AND SPCL_CGO_CATE_CD = 'DG' AND SPCL_CGO_AUTH_CD IN ('Y','N'))" ).append("\n"); 
		query.append("                         AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("                         AND B.DCGO_SEQ = S.DCGO_SEQ" ).append("\n"); 
		query.append("                      )       " ).append("\n"); 
		query.append("                ELSE ''" ).append("\n"); 
		query.append("             END ITM_STS_CD" ).append("\n"); 
		query.append("			--2016-06-28" ).append("\n"); 
		query.append("            -- ,ROW_NUMBER() OVER (PARTITION BY NVL(G.BKG_NO, A.BKG_NO), NVL(G.SPCL_CGO_APRO_RQST_SEQ, A.SPCL_CGO_APRO_RQST_SEQ), NVL(G.DCGO_SEQ, A.DCGO_SEQ), NVL(G.VSL_PRE_PST_CD, A.VSL_PRE_PST_CD), NVL(G.VSL_SEQ, A.VSL_SEQ)" ).append("\n"); 
		query.append("        	--ORDER BY DECODE(G.APRO_REF_NO,NULL,9,1), G.UPD_DT DESC) AS CORR_AUTH_SEQ" ).append("\n"); 
		query.append("            --2016-07-01" ).append("\n"); 
		query.append("		     ,NVL(G.UPD_DT, sysdate) AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM	" ).append("\n"); 
		query.append("        (	SELECT 	" ).append("\n"); 
		query.append("                #if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2' || ${auth_flg} == 'ALL') " ).append("\n"); 
		query.append("                    /*+ ORDERED USE_NL(B C V E D F A) */ " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
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
		query.append("                    --::2015-06-20::--B.EML_SND_NO, " ).append("\n"); 
		query.append("                    --::2015-06-20::--C.EML_SND_NO	AS	VVD_EML_SND_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    C.INDIV_EML_SND_NO," ).append("\n"); 
		query.append("                    C.OALL_EML_SND_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    B.LST_RQST_DAT_FLG, " ).append("\n"); 
		query.append("                    B.BKG_RCV_TERM_CD, " ).append("\n"); 
		query.append("                    B.BKG_DE_TERM_CD, " ).append("\n"); 
		query.append("                    B.RQST_OFC_CD, " ).append("\n"); 
		query.append("                    B.RQST_DT, " ).append("\n"); 
		query.append("                    B.RQST_GDT, " ).append("\n"); 
		query.append("                    B.RQST_USR_ID, " ).append("\n"); 
		query.append("                    C.MAPG_TRSM_BND_CD," ).append("\n"); 
		query.append("                    C.MAPG_TRSM_DT," ).append("\n"); 
		query.append("                    C.MAPG_TRSM_SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("                    C.MAPG_PRNR_SPCL_CGO_SEQ," ).append("\n"); 
		query.append("                    C.MAPG_EDI_TRSM_STS_CD," ).append("\n"); 
		query.append("                    C.VSL_PRE_PST_CD, " ).append("\n"); 
		query.append("                    C.VSL_SEQ, " ).append("\n"); 
		query.append("                    C.VSL_CD, " ).append("\n"); 
		query.append("                    (SELECT MAX(SC1.SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                       FROM SCG_APRO_RQST SC1 " ).append("\n"); 
		query.append("                          , SCG_VVD_APRO_RQST SC2" ).append("\n"); 
		query.append("                      WHERE SC1.BKG_NO                 = C.BKG_NO" ).append("\n"); 
		query.append("                        AND SC2.MAPG_EDI_TRSM_STS_CD   = 'S'" ).append("\n"); 
		query.append("                        AND SC1.BKG_NO                 = SC2.BKG_NO" ).append("\n"); 
		query.append("                        AND SC1.SPCL_CGO_APRO_RQST_SEQ = SC2.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                        AND SC2.VSL_PRE_PST_CD         = C.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                    )PRE_SEQ," ).append("\n"); 
		query.append("                    (SELECT SUM(DECODE(SC2.MAPG_EDI_TRSM_STS_CD, 'S', 1, 0)) MAPG_EDI_TRSM_STS_CD_CNT" ).append("\n"); 
		query.append("                       FROM SCG_APRO_RQST SC1 " ).append("\n"); 
		query.append("                          , SCG_VVD_APRO_RQST SC2" ).append("\n"); 
		query.append("                      WHERE SC1.BKG_NO                 = C.BKG_NO" ).append("\n"); 
		query.append("                        AND SC2.MAPG_EDI_TRSM_STS_CD   = 'S'" ).append("\n"); 
		query.append("                        AND SC1.BKG_NO                 = SC2.BKG_NO" ).append("\n"); 
		query.append("                        AND SC1.SPCL_CGO_APRO_RQST_SEQ = SC2.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                        AND SC2.VSL_PRE_PST_CD         = C.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                    )PRE_TRSM_STS_CD_CNT," ).append("\n"); 
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
		query.append("                    F.IN_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("                    F.OUT_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("                    F.INTMD_IMDG_PCK_QTY1, " ).append("\n"); 
		query.append("                    F.PSA_NO, " ).append("\n"); 
		query.append("                    F.HCDG_FLG, " ).append("\n"); 
		query.append("                    F.SPCL_RQST_FLG, " ).append("\n"); 
		query.append("                    F.SPCL_RQST_DESC," ).append("\n"); 
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
		query.append("                ,	" ).append("\n"); 
		query.append("                    #if (${scg_flg} == 'SCG_DG' && ${auth_flg} != 'ALL')" ).append("\n"); 
		query.append("                    SCG_DG_CGO F " ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                    BKG_DG_CGO F" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
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
		query.append("        #if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2' || ${auth_flg} == 'ALL') " ).append("\n"); 
		query.append("            AND 	B.RQST_DT 					> SYSTIMESTAMP - 300" ).append("\n"); 
		query.append("            AND 	V.VPS_ETA_DT 				> SYSTIMESTAMP - 300" ).append("\n"); 
		query.append("            AND 	F.SPCL_CGO_APRO_CD 			NOT IN ('C','D','N')" ).append("\n"); 
		query.append("            AND 	A.BKG_STS_CD 				!= 'X'" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            /*2014.12.08 dg part1, dg part2 통합" ).append("\n"); 
		query.append("            #if (${scg_flg} == 'DG1' || ${scg_flg} == 'DG2')" ).append("\n"); 
		query.append("                #if (${scg_flg} == 'DG1')" ).append("\n"); 
		query.append("                    AND 	(F.BKG_NO, F.DG_CNTR_SEQ) IN (" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                    AND 	(F.BKG_NO, F.DG_CNTR_SEQ) NOT IN (" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                    SELECT BKG_NO, DG_CNTR_SEQ " ).append("\n"); 
		query.append("                      FROM BKG_DG_CGO " ).append("\n"); 
		query.append("                     WHERE BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                       AND (IMDG_CLSS_CD LIKE '1%' OR IMDG_CLSS_CD LIKE '2%' OR IMDG_CLSS_CD LIKE '7%' OR IMDG_CLSS_CD='5.2' OR PSA_NO = '1')) " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            */" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND 	A.BKG_STS_CD 				!= 'X'" ).append("\n"); 
		query.append("            AND 	B.SPCL_CGO_APRO_RQST_SEQ 	= F.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("            AND 	F.SPCL_CGO_APRO_CD 			NOT IN ('C','D')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
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
		query.append("        --2016-06-23 검색 조건 추가 --" ).append("\n"); 
		query.append("        #if (${booking_no} != '') " ).append("\n"); 
		query.append("            AND 	A.BKG_NO 			= @[booking_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${dcgo_ref_no} != '') " ).append("\n"); 
		query.append("            AND 	F.DCGO_REF_NO 		= @[dcgo_ref_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        --2016-06-23 검색 조건 추가 --" ).append("\n"); 
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
		query.append("                                               " ).append("\n"); 
		query.append("            ) A, " ).append("\n"); 
		query.append("            --2016-07-14 SCG_AUTHORIZATION 중복 데이터 추출 후 JOIN --" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT CC.* FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT ROW_NUMBER() OVER (PARTITION BY NVL(AA.BKG_NO, BB.BKG_NO), NVL(AA.SPCL_CGO_APRO_RQST_SEQ, BB.SPCL_CGO_APRO_RQST_SEQ), NVL(AA.DCGO_SEQ, BB.DCGO_SEQ), NVL(AA.VSL_PRE_PST_CD, BB.VSL_PRE_PST_CD), NVL(AA.VSL_SEQ, BB.VSL_SEQ)" ).append("\n"); 
		query.append("        	ORDER BY DECODE(AA.APRO_REF_NO,NULL,9,1), AA.UPD_DT DESC) AS CORR_AUTH_SEQ" ).append("\n"); 
		query.append("            ,AA.*" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            SCG_AUTHORIZATION AA, " ).append("\n"); 
		query.append("            SCG_AUTHORIZATION BB " ).append("\n"); 
		query.append("            WHERE   AA.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("             AND 	AA.SPCL_CGO_APRO_RQST_SEQ 	= BB.SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("             AND 	AA.VSL_PRE_PST_CD 			= BB.VSL_PRE_PST_CD " ).append("\n"); 
		query.append("             AND 	AA.VSL_SEQ 					= BB.VSL_SEQ  " ).append("\n"); 
		query.append("             AND    AA.DCGO_SEQ                 = BB.DCGO_SEQ" ).append("\n"); 
		query.append("             AND    AA.SPCL_CGO_AUTH_SEQ        = BB.SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append("            ) CC" ).append("\n"); 
		query.append("            WHERE CC.CORR_AUTH_SEQ = 1" ).append("\n"); 
		query.append("            )G" ).append("\n"); 
		query.append("            --2016-07-14 SCG_AUTHORIZATION 중복 데이터 추출 후 JOIN --" ).append("\n"); 
		query.append("    WHERE	A.BKG_NO 					= G.BKG_NO (+) " ).append("\n"); 
		query.append("    AND 	A.SPCL_CGO_APRO_RQST_SEQ 	= G.SPCL_CGO_APRO_RQST_SEQ (+) " ).append("\n"); 
		query.append("    AND 	A.VSL_PRE_PST_CD 			= G.VSL_PRE_PST_CD (+) " ).append("\n"); 
		query.append("    AND 	A.VSL_SEQ 					= G.VSL_SEQ (+) " ).append("\n"); 
		query.append("    AND 	A.DCGO_SEQ 					= G.DCGO_SEQ (+) " ).append("\n"); 
		query.append("    #if (${apro_ref_no} != '') " ).append("\n"); 
		query.append("    AND     G.APRO_REF_NO 		= @[apro_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'A') " ).append("\n"); 
		query.append("        AND	NVL(SPCL_CGO_AUTH_CD_CHK,'R') IN ('R','P')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'P') " ).append("\n"); 
		query.append("        AND	SPCL_CGO_AUTH_CD_CHK 		  = 'P'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'R') " ).append("\n"); 
		query.append("        AND NVL(SPCL_CGO_AUTH_CD_CHK,'R') = 'R'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("        AND SPCL_CGO_AUTH_CD_CHK		IN ('Y','N')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${auth_flg} == 'ALL') " ).append("\n"); 
		query.append("        AND SPCL_CGO_AUTH_CD_CHK     	IN ('R','P')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    --2016-06-28" ).append("\n"); 
		query.append("    --  AND  A.CORR_AUTH_SEQ 			= 1  " ).append("\n"); 
		query.append(")             " ).append("\n"); 
		query.append("WHERE RNK < 1000" ).append("\n"); 
		query.append("ORDER BY RNK, DG_CNTR_SEQ, CNTR_CGO_SEQ" ).append("\n"); 

	}
}