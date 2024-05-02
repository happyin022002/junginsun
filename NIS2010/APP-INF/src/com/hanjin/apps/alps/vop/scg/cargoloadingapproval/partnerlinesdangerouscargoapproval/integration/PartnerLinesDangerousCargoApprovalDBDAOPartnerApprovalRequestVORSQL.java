/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOPartnerApprovalRequestVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOPartnerApprovalRequestVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO APVL for Partner Lines 의 Request 조회
	  * --------------------------------------------------------------------------------------------
	  * 2012.01.11 김민아 [CHM-201115273-01] [VOP-SCG] SPCL CGO APVL for Partner Lines - AWK 보완
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOPartnerApprovalRequestVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("booking_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOPartnerApprovalRequestVORSQL").append("\n"); 
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
		query.append("    RQS.DG_FLG " ).append("\n"); 
		query.append(",   RQS.AWK_FLG " ).append("\n"); 
		query.append(",   RQS.RGN_SHP_OPR_CD " ).append("\n"); 
		query.append(",   RQS.VSL_CD" ).append("\n"); 
		query.append(",   RQS.SKD_VOY_NO" ).append("\n"); 
		query.append(",	RQS.SKD_DIR_CD" ).append("\n"); 
		query.append(",	RQS.SLAN_CD" ).append("\n"); 
		query.append(",   RQS.CRR_CD" ).append("\n"); 
		query.append(",	CGO.CGO_OPR_CD" ).append("\n"); 
		query.append(",	RQS.POL_CD||RQS.POL_CLPT_IND_SEQ AS POL_CD" ).append("\n"); 
		query.append(",   RQS.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	TO_CHAR(RQS.ETA_DT, 'YYYY-MM-DD HH24:MI') ETA_DT" ).append("\n"); 
		query.append(",	RQS.POD_CD||RQS.POD_CLPT_IND_SEQ AS POD_CD" ).append("\n"); 
		query.append(",   RQS.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	RQS.BKG_REF_NO" ).append("\n"); 
		query.append(",	RQS.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",	CGO.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append(",	CGO.SPCL_CGO_SEQ" ).append("\n"); 
		query.append(",	CGO.AUTH_STS_CD" ).append("\n"); 
		query.append(",	DECODE(CGO.APRO_REF_NO,'0','',CGO.APRO_REF_NO) APRO_REF_NO" ).append("\n"); 
		query.append(",	CGO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	DECODE(CGO.CMDT_DESC,'0','',CGO.CMDT_DESC) CMDT_DESC" ).append("\n"); 
		query.append(",	CGO.TTL_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.TTL_DIM_WDT" ).append("\n"); 
		query.append(",	CGO.TTL_DIM_HGT" ).append("\n"); 
		query.append(",	CGO.FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	DECODE(CGO.IMDG_UN_NO,'0','',CGO.IMDG_UN_NO) IMDG_UN_NO" ).append("\n"); 
		query.append(",	DECODE(CGO.IMDG_UN_NO_SEQ,'0','',CGO.IMDG_UN_NO_SEQ) IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	CGO.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N1ST_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N1ST_IMDG_SUBS_RSK_LBL_CD) N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N2ND_IMDG_SUBS_RSK_LBL_CD) N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N3RD_IMDG_SUBS_RSK_LBL_CD) N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N4TH_IMDG_SUBS_RSK_LBL_CD) N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	(DECODE(CGO.N1ST_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N1ST_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("   ||DECODE(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N2ND_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("   ||DECODE(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N3RD_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("   ||DECODE(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N4TH_IMDG_SUBS_RSK_LBL_CD)) IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	CGO.MRN_POLUT_FLG" ).append("\n"); 
		query.append(",   DECODE(CGO.IMDG_PCK_GRP_CD,'1','I','2','II','3','III','') IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	CGO.IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	CGO.IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",   DECODE(CGO.FLSH_PNT_CDO_TEMP,'0','',CGO.FLSH_PNT_CDO_TEMP) FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	CGO.GRS_WGT" ).append("\n"); 
		query.append(",	CGO.NET_WGT" ).append("\n"); 
		query.append(",	CGO.GRS_CAPA_QTY" ).append("\n"); 
		query.append(",	CGO.VOID_SLT_QTY" ).append("\n"); 
		query.append(",   DECODE(CGO.PSA_NO,'0','',CGO.PSA_NO) PSA_NO" ).append("\n"); 
		query.append(",	TO_CHAR(CGO.CGO_RQST_DT,'YYYY-MM-DD') CGO_RQST_DT -- TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',CGO.CGO_RQST_DT,'GMT'),'YYYY-MM-DD') " ).append("\n"); 
		query.append(",	DECODE(CGO.AUTH_STS_CD,'R','',TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',CGO.AUTH_DT,'GMT'),'YYYY-MM-DD HH24:MI:SS')) AUTH_DT" ).append("\n"); 
		query.append(",	RQS.CRE_USR_ID" ).append("\n"); 
		query.append(",	RQS.UPD_USR_ID" ).append("\n"); 
		query.append(",	RQS.UPD_DT" ).append("\n"); 
		query.append(",   DECODE(RQS.DG_FLG,'Y','DG','AK') SCG_FLG" ).append("\n"); 
		query.append(",   CGO.AUTH_STS_CD AUTH_FLG" ).append("\n"); 
		query.append(",	RQS.SLAN_CD SLAN_CD1" ).append("\n"); 
		query.append(",   RQS.BKG_REF_NO BOOKING_NO" ).append("\n"); 
		query.append(",   CGO.STS_CT" ).append("\n"); 
		query.append(",   '' FROM_ETA_DT" ).append("\n"); 
		query.append(",   '' TO_ETA_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   DECODE(CGO.CNTR_REF_NO,'0','',CGO.CNTR_REF_NO) CNTR_REF_NO" ).append("\n"); 
		query.append(",   DECODE(CGO.WGT_UT_CD,'0','KGS',CGO.WGT_UT_CD)  WGT_UT_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.WGT_UT_CD,'0','KGS',CGO.WGT_UT_CD)  WGT_UT_CD2" ).append("\n"); 
		query.append(",   CGO.PRP_SHP_NM        PRP_SHP_NM" ).append("\n"); 
		query.append(",   CGO.HZD_DESC          HZD_DESC" ).append("\n"); 
		query.append(",   CGO.DCGO_STS_CD       DCGO_STS_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.EMER_CNTC_PHN_NO,'0','',CGO.EMER_CNTC_PHN_NO) EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append(",   DECODE(CGO.EMER_CNTC_PSON_NM,'0','',CGO.EMER_CNTC_PSON_NM)  EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",   DECODE(CGO.CERTI_NO,'0','',CGO.CERTI_NO)                    CERTI_NO" ).append("\n"); 
		query.append(",   DECODE(CGO.DIFF_RMK,'0','',CGO.DIFF_RMK)                    DIFF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   DECODE(CGO.OUT_N1ST_IMDG_PCK_QTY,'0','',CGO.OUT_N1ST_IMDG_PCK_QTY)                                   AS OUT_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",   DECODE(CGO.OUT_N1ST_IMDG_PCK_CD,'0','',CGO.OUT_N1ST_IMDG_PCK_CD)                                     AS OUT_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK1.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK1 WHERE PK1.IMDG_PCK_CD = CGO.OUT_N1ST_IMDG_PCK_CD) AS OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	DECODE(CGO.OUT_N2ND_IMDG_PCK_QTY,'0','',CGO.OUT_N2ND_IMDG_PCK_QTY)                                   AS OUT_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.OUT_N2ND_IMDG_PCK_CD,'0','',CGO.OUT_N2ND_IMDG_PCK_CD)                                     AS OUT_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK2.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK2 WHERE PK2.IMDG_PCK_CD = CGO.OUT_N2ND_IMDG_PCK_CD) AS OUT_N2ND_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N1ST_IMDG_PCK_QTY,'0','',CGO.IN_N1ST_IMDG_PCK_QTY)                                     AS IN_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N1ST_IMDG_PCK_CD,'0','',CGO.IN_N1ST_IMDG_PCK_CD)                                       AS IN_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK3.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK3 WHERE PK3.IMDG_PCK_CD = CGO.IN_N1ST_IMDG_PCK_CD)  AS IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N2ND_IMDG_PCK_QTY,'0','',CGO.IN_N2ND_IMDG_PCK_QTY)                                     AS IN_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N2ND_IMDG_PCK_CD,'0','',CGO.IN_N2ND_IMDG_PCK_CD)                                       AS IN_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK4.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK4 WHERE PK4.IMDG_PCK_CD = CGO.IN_N2ND_IMDG_PCK_CD)  AS IN_N2ND_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	CGO.MAX_IN_PCK_QTY                                                                                   AS MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	CGO.MAX_IN_PCK_TP_CD                                                                                 AS MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",   SUN.HCDG_PCK_RSTR_DESC                                                                               AS HCDG_PCK_RSTR_DESC     " ).append("\n"); 
		query.append(",   SUN.HCDG_INTMD_BC_RSTR_DESC                                                                          AS HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",   SUN.HCDG_TNK_RSTR_DESC                                                                               AS HCDG_TNK_RSTR_DESC     " ).append("\n"); 
		query.append(",   SUN.IMDG_LMT_QTY                                                                                     AS IMDG_LMT_QTY   " ).append("\n"); 
		query.append(",   SUN.IMDG_EXPT_QTY_CD                                                                                 AS IMDG_EXPT_QTY_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	DECODE(CGO.EMS_NO,'0','',CGO.EMS_NO)                                       AS EMS_NO" ).append("\n"); 
		query.append(",	DECODE(CGO.CTRL_TEMP_CTNT,'0','',CGO.CTRL_TEMP_CTNT)                       AS CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	DECODE(CGO.EMER_RSPN_GID_NO,'0','',CGO.EMER_RSPN_GID_NO)                   AS EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	DECODE(CGO.EMER_RSPN_GID_CHR_NO,'0','',CGO.EMER_RSPN_GID_CHR_NO)           AS EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",	DECODE(CGO.EMER_TEMP_CTNT,'0','',CGO.EMER_TEMP_CTNT)                       AS EMER_TEMP_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	CGO.CNEE_DTL_DESC                              AS CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	CGO.NET_EXPLO_WGT                              AS NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	CGO.RADA_SKD_NO                                AS RADA_SKD_NO" ).append("\n"); 
		query.append(",	CGO.RADA_AMT                                   AS RADA_AMT" ).append("\n"); 
		query.append(",	CGO.RADA_UT_CD                                 AS RADA_UT_CD  " ).append("\n"); 
		query.append(",	CGO.RADA_TRSP_NO                               AS RADA_TRSP_NO" ).append("\n"); 
		query.append(",	CGO.SPCL_CGO_CATE_CD                           AS SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CGO.AUTH_OFC_CD                                AS AUTH_OFC_CD" ).append("\n"); 
		query.append(",	CGO.AUTH_USR_ID                                AS AUTH_USR_ID" ).append("\n"); 
		query.append(",	CGO.IMDG_CO_GRP_CD                             AS IMDG_CO_GRP_CD" ).append("\n"); 
		query.append(",	CGO.MEAS_QTY                                   AS MEAS_QTY" ).append("\n"); 
		query.append(",	CGO.MEAS_TP_CD                                 AS MEAS_TP_CD" ).append("\n"); 
		query.append(",	CGO.PCK_QTY                                    AS PCK_QTY" ).append("\n"); 
		query.append(",	CGO.PCK_TP_CD                                  AS PCK_TP_CD" ).append("\n"); 
		query.append(",	CGO.CLOD_FLG                                   AS CLOD_FLG" ).append("\n"); 
		query.append(",	CGO.SPCL_STWG_RQST_DESC                        AS SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	CGO.CGO_LCL_FLG                                AS CGO_LCL_FLG" ).append("\n"); 
		query.append(",   SUN.IMDG_LMT_QTY_MEAS_UT_CD                    AS IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append(",   SUN.IMDG_COMP_GRP_CD                           AS IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   SUN.HCDG_FLG                                   AS HCDG_FLG" ).append("\n"); 
		query.append(",   SUN.IMDG_SUBS_RSK_LBL_RMK                      AS IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("     SELECT SP.IMDG_SPCL_PROVI_NO " ).append("\n"); 
		query.append("       FROM SCG_IMDG_UN_NO_SPCL_PROVI SP " ).append("\n"); 
		query.append("      WHERE SP.IMDG_UN_NO     = CGO.IMDG_UN_NO" ).append("\n"); 
		query.append("        AND SP.IMDG_UN_NO_SEQ = CGO.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("        AND SP.IMDG_SPCL_PROVI_NO = 274" ).append("\n"); 
		query.append("     ) AS IMDG_SPCL_PROVI_NO " ).append("\n"); 
		query.append(",   SCG_GET_MPA1_NET_FNC(RQS.VSL_CD, RQS.SKD_VOY_NO, RQS.SKD_DIR_CD, RQS.POL_CD, RQS.POD_CD, CGO.IMDG_CLSS_CD) AS NET_WGT_SUM" ).append("\n"); 
		query.append(",   CGO.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("#if (${scg_flg} == 'AWK' || ${scg_flg} == 'SCG_AWK')" ).append("\n"); 
		query.append(",   CASE WHEN CGO.APRO_REF_NO <> '0' THEN  'Dear partner,'||'`'||'`'||" ).append("\n"); 
		query.append("                                           'Approval Ref No : '||CGO.APRO_REF_NO||'`'||" ).append("\n"); 
		query.append("                                                   'VVD : '||(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = RQS.VSL_CD)||' '||RQS.SKD_VOY_NO||RQS.SKD_DIR_CD||'`'||" ).append("\n"); 
		query.append("                                                   'POL/POD : '||RQS.POL_CD||'/'||RQS.POD_CD||'`'||" ).append("\n"); 
		query.append("                                                   'ETA POL : '||TO_CHAR(RQS.ETA_DT, 'YYYY-MM-DD')||'`'||" ).append("\n"); 
		query.append("                                                   'CNTR :'||CGO.CNTR_TPSZ_CD||' x '||" ).append("\n"); 
		query.append("                                                   ( SELECT MAX(SPCL_CNTR_SEQ) " ).append("\n"); 
		query.append("                                                       FROM SCG_PRNR_APRO_RQST_CGO A" ).append("\n"); 
		query.append("                                                      WHERE RQS.CRR_CD            = A.CRR_CD" ).append("\n"); 
		query.append("                                                        AND RQS.BKG_REF_NO        = A.BKG_REF_NO" ).append("\n"); 
		query.append("                                                        AND RQS.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                        AND RQS.CRR_CD            = A.CRR_CD )||'`'||'`'||" ).append("\n"); 
		query.append("                                                    'Acceptable to load it on subject VVD.'||'`'||" ).append("\n"); 
		query.append("                                                    'Approval subject to safe lashing/stuffing and feasibility to handle in terminal.'||'`'||" ).append("\n"); 
		query.append("                                                    'Void : TEU'" ).append("\n"); 
		query.append("              END AS EMAIL_INFO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",   CASE WHEN CGO.APRO_REF_NO <> '0' THEN  'Dear partner,'||'`'||'`'||" ).append("\n"); 
		query.append("                                           'Approval Ref No : '||CGO.APRO_REF_NO||'`'||" ).append("\n"); 
		query.append("                                                   'VVD : '||(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = RQS.VSL_CD)||' '||RQS.SKD_VOY_NO||RQS.SKD_DIR_CD||'`'||" ).append("\n"); 
		query.append("                                                   'POL/POD : '||RQS.POL_CD||'/'||RQS.POD_CD||'`'||" ).append("\n"); 
		query.append("                                                   'ETA POL : '||TO_CHAR(RQS.ETA_DT, 'YYYY-MM-DD')||'`'||" ).append("\n"); 
		query.append("                                                   'CNTR :'||CGO.CNTR_TPSZ_CD||' x '||" ).append("\n"); 
		query.append("                                                   ( SELECT MAX(SPCL_CNTR_SEQ) " ).append("\n"); 
		query.append("                                                       FROM SCG_PRNR_APRO_RQST_CGO A" ).append("\n"); 
		query.append("                                                      WHERE RQS.CRR_CD            = A.CRR_CD" ).append("\n"); 
		query.append("                                                        AND RQS.BKG_REF_NO        = A.BKG_REF_NO" ).append("\n"); 
		query.append("                                                        AND RQS.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                        AND RQS.CRR_CD            = A.CRR_CD )||'`'||'`'||" ).append("\n"); 
		query.append("                                                    'Acceptable to load it on subject VVD.'||'`'||" ).append("\n"); 
		query.append("                                                    'Approval subject to meet IMDG code, carrier/local regulation and no waste.'||'`'|| " ).append("\n"); 
		query.append("                                                    'But temperature control should not be required during transportation.'" ).append("\n"); 
		query.append("              END AS EMAIL_INFO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST      RQS" ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("     SELECT T.*" ).append("\n"); 
		query.append("          , AVG(DECODE(T.AUTH_STS_CD,'Y',1,'N',2,-999)) OVER(PARTITION BY T.CRR_CD, T.BKG_REF_NO, T.SPCL_CGO_RQST_SEQ) STS_CT" ).append("\n"); 
		query.append("       FROM SCG_PRNR_APRO_RQST_CGO T" ).append("\n"); 
		query.append("     ) CGO" ).append("\n"); 
		query.append("   , SCG_IMDG_UN_NO          SUN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("  AND RQS.RGN_SHP_OPR_CD    = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("  AND RQS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("  AND RQS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("  AND RQS.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${scg_flg} == 'DG1' || ${scg_flg} == 'SCG_DG') " ).append("\n"); 
		query.append("  AND RQS.DG_FLG            = 'Y'" ).append("\n"); 
		query.append("  AND RQS.AWK_FLG           = 'N'" ).append("\n"); 
		query.append("#elseif (${scg_flg} == 'AWK' || ${scg_flg} == 'SCG_AWK' || ${scg_flg} == 'SCG_45') " ).append("\n"); 
		query.append("  AND RQS.DG_FLG            = 'N'" ).append("\n"); 
		query.append("  AND RQS.AWK_FLG           = 'Y'" ).append("\n"); 
		query.append("#if (${scg_flg} == 'SCG_AWK') " ).append("\n"); 
		query.append("  AND CGO.CNTR_TPSZ_CD <> 'D7'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_flg} == 'SCG_45') " ).append("\n"); 
		query.append("  AND CGO.CNTR_TPSZ_CD = 'D7'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND RQS.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("  AND RQS.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("  AND RQS.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("  AND CGO.IMDG_UN_NO        = SUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("  AND CGO.IMDG_UN_NO_SEQ    = SUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("  AND RQS.BKG_REF_NO        LIKE @[bkg_ref_no]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auth_flg} == 'Y') " ).append("\n"); 
		query.append("  AND (CGO.STS_CT = 1 OR CGO.AUTH_STS_CD = 'Y')" ).append("\n"); 
		query.append("#elseif (${auth_flg} == 'N') " ).append("\n"); 
		query.append("  AND (CGO.STS_CT > 1 OR CGO.AUTH_STS_CD = 'N')" ).append("\n"); 
		query.append("#elseif (${auth_flg} == 'YN') " ).append("\n"); 
		query.append("  AND (CGO.STS_CT >= 1 OR CGO.AUTH_STS_CD = 'Y' OR CGO.AUTH_STS_CD = 'N')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auth_sts_cd}=='Y')" ).append("\n"); 
		query.append(" AND (CGO.STS_CT >= 1 OR CGO.AUTH_STS_CD = 'Y' OR CGO.AUTH_STS_CD = 'N')" ).append("\n"); 
		query.append("#elseif (${auth_sts_cd}=='R')" ).append("\n"); 
		query.append(" AND CGO.AUTH_STS_CD = @[auth_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- AND (CGO.AUTH_STS_CD = 'R' OR ((CGO.AUTH_STS_CD = 'Y' OR CGO.AUTH_STS_CD = 'N') AND CGO.STS_CT < 1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd1} != '')" ).append("\n"); 
		query.append("  AND RQS.SLAN_CD = @[slan_cd1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("  AND RQS.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("  AND RQS.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cgo_opr_cd} != '')" ).append("\n"); 
		query.append("  AND CGO.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${booking_no} != '') " ).append("\n"); 
		query.append("  AND RQS.BKG_REF_NO = @[booking_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${apro_ref_no} != '') " ).append("\n"); 
		query.append("  AND CGO.APRO_REF_NO = @[apro_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("  AND CGO.IMDG_UN_NO = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no_seq} != '') " ).append("\n"); 
		query.append("  AND CGO.IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("  AND CGO.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prp_shp_nm} != '') " ).append("\n"); 
		query.append("  AND CGO.PRP_SHP_NM LIKE '%'||@[prp_shp_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${from_eta_dt} != '' && ${to_eta_dt} != '') " ).append("\n"); 
		query.append("  AND CGO.CGO_RQST_DT BETWEEN TO_DATE(@[from_eta_dt],'YYYY-MM-DD') AND TO_DATE(@[to_eta_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    RQS.ETA_DT" ).append("\n"); 
		query.append(",   CGO.CGO_OPR_CD" ).append("\n"); 
		query.append(",   RQS.VSL_CD" ).append("\n"); 
		query.append(",   RQS.SKD_VOY_NO" ).append("\n"); 
		query.append(",	RQS.SKD_DIR_CD" ).append("\n"); 
		query.append(",	RQS.POL_CD" ).append("\n"); 
		query.append(",	RQS.POD_CD" ).append("\n"); 
		query.append(",	RQS.BKG_REF_NO" ).append("\n"); 
		query.append(",	RQS.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",   CGO.CGO_RQST_DT" ).append("\n"); 
		query.append(",   CGO.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append(",	CGO.SPCL_CGO_SEQ" ).append("\n"); 

	}
}