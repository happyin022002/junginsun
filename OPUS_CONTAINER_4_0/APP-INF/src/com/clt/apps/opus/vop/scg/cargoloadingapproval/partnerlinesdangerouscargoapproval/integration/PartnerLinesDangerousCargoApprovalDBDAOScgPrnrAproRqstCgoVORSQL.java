/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dangerous CGO Application Details for Partner Lines 의 Cago 조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVORSQL").append("\n"); 
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
		query.append("	DECODE(CGO.OUT_N1ST_IMDG_PCK_QTY,'0','',CGO.OUT_N1ST_IMDG_PCK_QTY)                                   AS OUT_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",   DECODE(CGO.OUT_N1ST_IMDG_PCK_CD,'0','',CGO.OUT_N1ST_IMDG_PCK_CD)                                     AS OUT_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append("--  2016-02-16 'ZZZ' -> DESC for EDI START" ).append("\n"); 
		query.append(",   CASE WHEN  " ).append("\n"); 
		query.append("    (SELECT PK1.IMDG_PCK_DESC FROM  SCG_IMDG_PCK_CD PK1 WHERE PK1.IMDG_PCK_CD = CGO.OUT_N1ST_IMDG_PCK_CD) IS NULL" ).append("\n"); 
		query.append("    THEN CGO.OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("    ELSE (SELECT PK1.IMDG_PCK_DESC FROM  SCG_IMDG_PCK_CD PK1 WHERE PK1.IMDG_PCK_CD = CGO.OUT_N1ST_IMDG_PCK_CD)" ).append("\n"); 
		query.append("    END  OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("--,   (SELECT PK1.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK1 WHERE PK1.IMDG_PCK_CD = CGO.OUT_N1ST_IMDG_PCK_CD) AS OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("--  2016-02-16 'ZZZ' -> DESC for EDI END" ).append("\n"); 
		query.append(",	DECODE(CGO.OUT_N2ND_IMDG_PCK_QTY,'0','',CGO.OUT_N2ND_IMDG_PCK_QTY)                                   AS OUT_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.OUT_N2ND_IMDG_PCK_CD,'0','',CGO.OUT_N2ND_IMDG_PCK_CD)                                     AS OUT_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK2.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK2 WHERE PK2.IMDG_PCK_CD = CGO.OUT_N2ND_IMDG_PCK_CD) AS OUT_N2ND_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	CGO.MAX_IN_PCK_QTY                             AS MAX_IN_PCK_QTY" ).append("\n"); 
		query.append(",	CGO.MAX_IN_PCK_TP_CD                           AS MAX_IN_PCK_TP_CD" ).append("\n"); 
		query.append(",	CGO.CNEE_DTL_DESC                              AS CNEE_DTL_DESC" ).append("\n"); 
		query.append(",	CGO.NET_EXPLO_WGT                              AS NET_EXPLO_WGT" ).append("\n"); 
		query.append(",	CGO.RADA_SKD_NO                                AS RADA_SKD_NO" ).append("\n"); 
		query.append(",	CGO.RADA_AMT                                   AS RADA_AMT" ).append("\n"); 
		query.append(",	CGO.RADA_UT_CD                                 AS RADA_UT_CD  " ).append("\n"); 
		query.append(",	CGO.RADA_TRSP_NO                               AS RADA_TRSP_NO" ).append("\n"); 
		query.append(",   DECODE(CGO.DIFF_RMK,'0','',CGO.DIFF_RMK)       AS DIFF_RMK" ).append("\n"); 
		query.append(",	TO_CHAR(CGO.CGO_RQST_DT,'YYYY-MM-DD')          AS CGO_RQST_DT" ).append("\n"); 
		query.append(",	CGO.CRE_USR_ID                                 AS CRE_USR_ID" ).append("\n"); 
		query.append(",	CGO.CRE_DT                                     AS CRE_DT" ).append("\n"); 
		query.append(",	CGO.UPD_USR_ID                                 AS UPD_USR_ID" ).append("\n"); 
		query.append(",	CGO.UPD_DT                                     AS UPD_DT" ).append("\n"); 
		query.append(",	DECODE(CGO.CNTR_REF_NO,'0','',CGO.CNTR_REF_NO) AS CNTR_REF_NO" ).append("\n"); 
		query.append(",	CGO.SPCL_CGO_CATE_CD                           AS SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CGO.CNTR_TPSZ_CD                               AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	DECODE(CGO.AUTH_STS_CD,'R','','I','',TO_CHAR(CGO.AUTH_DT,'YYYY-MM-DD')) AS AUTH_DT" ).append("\n"); 
		query.append(",	CGO.AUTH_OFC_CD                                AS AUTH_OFC_CD" ).append("\n"); 
		query.append(",	DECODE(CGO.AUTH_STS_CD,'R','','I','',CGO.AUTH_USR_ID) AS AUTH_USR_ID" ).append("\n"); 
		query.append(",	CGO.AUTH_STS_CD                                AS AUTH_STS_CD" ).append("\n"); 
		query.append(",   CGO.SPCL_CGO_AUTH_RJCT_CD                      AS SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append(",   CGO.SPCL_CGO_AUTH_RMK                          AS SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append(",	DECODE(CGO.APRO_REF_NO,'0','',CGO.APRO_REF_NO) AS APRO_REF_NO" ).append("\n"); 
		query.append(",	CGO.CGO_OPR_CD                                 AS CGO_OPR_CD" ).append("\n"); 
		query.append(",	CGO.CRR_CD                                     AS CRR_CD" ).append("\n"); 
		query.append(",	CGO.BKG_REF_NO                                 AS BKG_REF_NO" ).append("\n"); 
		query.append(",	CGO.SPCL_CGO_RQST_SEQ                          AS SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",	CGO.PRNR_CGO_RQST_SEQ                          AS PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	CGO.SPCL_CNTR_SEQ                              AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append(",	CGO.SPCL_CGO_SEQ                               AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append(",	CGO.IMDG_UN_NO                                 AS IMDG_UN_NO" ).append("\n"); 
		query.append(",	CGO.IMDG_UN_NO_SEQ                             AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	SUN.CFR_FLG                                    AS CFR_FLG" ).append("\n"); 
		query.append(",	CGO.IMDG_CLSS_CD                               AS IMDG_CLSS_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N1ST_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N1ST_IMDG_SUBS_RSK_LBL_CD) AS N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N2ND_IMDG_SUBS_RSK_LBL_CD) AS N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N3RD_IMDG_SUBS_RSK_LBL_CD) AS N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N4TH_IMDG_SUBS_RSK_LBL_CD) AS N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append(",	CGO.IMDG_CO_GRP_CD                                                         AS IMDG_CO_GRP_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.IMDG_PCK_GRP_CD,'1','I','2','II','3','III','')                  AS IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(",	CGO.IMDG_LMT_QTY_FLG                                                       AS IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(",	CGO.IMDG_EXPT_QTY_FLG                                                      AS IMDG_EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	CGO.MRN_POLUT_FLG                                                          AS MRN_POLUT_FLG" ).append("\n"); 
		query.append("--,   DECODE(CGO.FLSH_PNT_CDO_TEMP,'0','',CGO.FLSH_PNT_CDO_TEMP)                 AS FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",   CGO.FLSH_PNT_CDO_TEMP		                 AS FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append(",	CGO.PRP_SHP_NM                                                             AS PRP_SHP_NM" ).append("\n"); 
		query.append(",	DECODE(CGO.HZD_DESC,'0','',CGO.HZD_DESC)                                   AS HZD_DESC" ).append("\n"); 
		query.append(",	DECODE(CGO.DCGO_STS_CD, 'N', '', CGO.DCGO_STS_CD)                          AS DCGO_STS_CD" ).append("\n"); 
		query.append(",	CGO.MEAS_QTY                                                               AS MEAS_QTY" ).append("\n"); 
		query.append(",	CGO.MEAS_TP_CD                                                             AS MEAS_TP_CD" ).append("\n"); 
		query.append(",	CGO.PCK_QTY                                                                AS PCK_QTY" ).append("\n"); 
		query.append(",	CGO.PCK_TP_CD                                                              AS PCK_TP_CD" ).append("\n"); 
		query.append(",	CGO.CLOD_FLG                                                               AS CLOD_FLG" ).append("\n"); 
		query.append(",	CGO.SPCL_STWG_RQST_DESC                                                    AS SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append(",	CGO.CGO_LCL_FLG                                                            AS CGO_LCL_FLG" ).append("\n"); 
		query.append("--,	DECODE(CGO.EMER_RSPN_GID_NO,'0','',CGO.EMER_RSPN_GID_NO)                   AS EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("--,	DECODE(CGO.EMER_RSPN_GID_CHR_NO,'0','',CGO.EMER_RSPN_GID_CHR_NO)           AS EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append("--, DECODE(CGO.EMER_CNTC_PHN_NO,'0','',CGO.EMER_CNTC_PHN_NO)                   AS EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("--, DECODE(CGO.EMER_CNTC_PSON_NM,'0','',CGO.EMER_CNTC_PSON_NM)                 AS EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("--,	DECODE(CGO.EMER_TEMP_CTNT,'0','',CGO.EMER_TEMP_CTNT)                       AS EMER_TEMP_CTNT" ).append("\n"); 
		query.append("--,	DECODE(CGO.CTRL_TEMP_CTNT,'0','',CGO.CTRL_TEMP_CTNT)                       AS CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("--,	DECODE(CGO.EMS_NO,'0','',CGO.EMS_NO)                                       AS EMS_NO" ).append("\n"); 
		query.append("--,	DECODE(CGO.CMDT_DESC,'0','',CGO.CMDT_DESC)                                 AS CMDT_DESC" ).append("\n"); 
		query.append(",	CGO.EMER_RSPN_GID_NO                	  	AS EMER_RSPN_GID_NO" ).append("\n"); 
		query.append(",	CGO.EMER_RSPN_GID_CHR_NO           			AS EMER_RSPN_GID_CHR_NO" ).append("\n"); 
		query.append(",   CGO.EMER_CNTC_PHN_NO                  		AS EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append(",   CGO.EMER_CNTC_PSON_NM                 		AS EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append(",	CGO.EMER_TEMP_CTNT                       	AS EMER_TEMP_CTNT" ).append("\n"); 
		query.append(",	CGO.CTRL_TEMP_CTNT                      	AS CTRL_TEMP_CTNT" ).append("\n"); 
		query.append(",	CGO.EMS_NO                                  AS EMS_NO" ).append("\n"); 
		query.append(",	CGO.CMDT_DESC                               AS CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	CGO.TTL_DIM_LEN                                                            AS TTL_DIM_LEN   " ).append("\n"); 
		query.append(",	CGO.TTL_DIM_WDT                                                            AS TTL_DIM_WDT      " ).append("\n"); 
		query.append(",	CGO.TTL_DIM_HGT                                                            AS TTL_DIM_HGT      " ).append("\n"); 
		query.append(",	CGO.FWRD_OVR_DIM_LEN                                                       AS FWRD_OVR_DIM_LEN " ).append("\n"); 
		query.append(",	CGO.BKWD_OVR_DIM_LEN                                                       AS BKWD_OVR_DIM_LEN " ).append("\n"); 
		query.append(",	CGO.HGT_OVR_DIM_LEN                                                        AS HGT_OVR_DIM_LEN  " ).append("\n"); 
		query.append(",	CGO.LF_SD_OVR_DIM_LEN                                                      AS LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.RT_SD_OVR_DIM_LEN                                                      AS RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CGO.VOID_SLT_QTY                                                           AS VOID_SLT_QTY     " ).append("\n"); 
		query.append(",	CGO.NET_WGT                                                                AS NET_WGT          " ).append("\n"); 
		query.append(",	CGO.GRS_WGT                                                                AS GRS_WGT          " ).append("\n"); 
		query.append(",   DECODE(CGO.WGT_UT_CD,'0','',CGO.WGT_UT_CD)                                                          AS WGT_UT_CD" ).append("\n"); 
		query.append(",   DECODE(CGO.PSA_NO,'0','',CGO.PSA_NO)                                                                AS PSA_NO" ).append("\n"); 
		query.append("--,   DECODE(CGO.CERTI_NO,'0','',CGO.CERTI_NO)                                                            AS CERTI_NO" ).append("\n"); 
		query.append(",  CGO.CERTI_NO                                                          	   AS CERTI_NO" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N1ST_IMDG_PCK_QTY,'0','',CGO.IN_N1ST_IMDG_PCK_QTY)                                    AS IN_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N1ST_IMDG_PCK_CD,'0','',CGO.IN_N1ST_IMDG_PCK_CD)                                      AS IN_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append("--  2016-02-16 'ZZZ' -> DESC for EDI START" ).append("\n"); 
		query.append(",   CASE WHEN " ).append("\n"); 
		query.append("    (SELECT PK3.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK3 WHERE PK3.IMDG_PCK_CD = CGO.IN_N1ST_IMDG_PCK_CD) IS NULL" ).append("\n"); 
		query.append("    THEN CGO.IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("    ELSE (SELECT PK3.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK3 WHERE PK3.IMDG_PCK_CD = CGO.IN_N1ST_IMDG_PCK_CD)" ).append("\n"); 
		query.append("    END  IN_N1ST_IMDG_PCK_DESC   " ).append("\n"); 
		query.append("--,   (SELECT PK3.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK3 WHERE PK3.IMDG_PCK_CD = CGO.IN_N1ST_IMDG_PCK_CD) AS IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("--  2016-02-16 'ZZZ' -> DESC for EDI END" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N2ND_IMDG_PCK_QTY,'0','',CGO.IN_N2ND_IMDG_PCK_QTY)                                    AS IN_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.IN_N2ND_IMDG_PCK_CD,'0','',CGO.IN_N2ND_IMDG_PCK_CD)                                      AS IN_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK4.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK4 WHERE PK4.IMDG_PCK_CD = CGO.IN_N2ND_IMDG_PCK_CD) AS IN_N2ND_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",   SUN.HCDG_PCK_RSTR_DESC                                                                              AS HCDG_PCK_RSTR_DESC     " ).append("\n"); 
		query.append(",   SUN.HCDG_INTMD_BC_RSTR_DESC                                                                         AS HCDG_INTMD_BC_RSTR_DESC" ).append("\n"); 
		query.append(",   SUN.HCDG_TNK_RSTR_DESC                                                                              AS HCDG_TNK_RSTR_DESC     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   CONCAT(SUN.IMDG_LMT_QTY, SUN.IMDG_LMT_QTY_MEAS_UT_CD) 												AS IMDG_LMT_QTY" ).append("\n"); 
		query.append("--,   SUN.IMDG_LMT_QTY                                                                                    AS IMDG_LMT_QTY   " ).append("\n"); 
		query.append("--,   SUN.IMDG_LMT_QTY_MEAS_UT_CD                                                                         AS IMDG_LMT_QTY_MEAS_UT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   SUN.IMDG_LMT_QTY_DESC																				AS IMDG_LMT_QTY_DESC" ).append("\n"); 
		query.append(",   SUN.IMDG_EXPT_QTY_CD                                                                                AS IMDG_EXPT_QTY_CD  " ).append("\n"); 
		query.append(",   SUN.IMDG_EXPT_QTY_DESC																			    AS IMDG_EXPT_QTY_DESC			" ).append("\n"); 
		query.append(",   SUN.IMDG_COMP_GRP_CD                                                                                AS IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append(",   SUN.HCDG_FLG                                                                                        AS HCDG_FLG" ).append("\n"); 
		query.append(",   SUN.IMDG_SUBS_RSK_LBL_RMK                                                                           AS IMDG_SUBS_RSK_LBL_RMK" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("     SELECT SP.IMDG_SPCL_PROVI_NO " ).append("\n"); 
		query.append("       FROM SCG_IMDG_UN_NO_SPCL_PROVI SP " ).append("\n"); 
		query.append("      WHERE SP.IMDG_UN_NO     = CGO.IMDG_UN_NO" ).append("\n"); 
		query.append("        AND SP.IMDG_UN_NO_SEQ = CGO.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("        AND SP.IMDG_SPCL_PROVI_NO IN (274, 318)" ).append("\n"); 
		query.append("     ) AS IMDG_SPCL_PROVI_NO " ).append("\n"); 
		query.append(",	DECODE(CGO.INTMD_N1ST_IMDG_PCK_QTY,'0','',CGO.INTMD_N1ST_IMDG_PCK_QTY)                                    AS INTMD_N1ST_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.INTMD_N1ST_IMDG_PCK_CD,'0','',CGO.INTMD_N1ST_IMDG_PCK_CD)                                      AS INTMD_N1ST_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK5.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK5 WHERE PK5.IMDG_PCK_CD = CGO.INTMD_N1ST_IMDG_PCK_CD)    AS INTMD_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	DECODE(CGO.INTMD_N2ND_IMDG_PCK_QTY,'0','',CGO.INTMD_N2ND_IMDG_PCK_QTY)                                    AS INTMD_N2ND_IMDG_PCK_QTY" ).append("\n"); 
		query.append(",	DECODE(CGO.INTMD_N2ND_IMDG_PCK_CD,'0','',CGO.INTMD_N2ND_IMDG_PCK_CD)                                      AS INTMD_N2ND_IMDG_PCK_CD" ).append("\n"); 
		query.append(",   (SELECT PK6.IMDG_PCK_DESC FROM SCG_IMDG_PCK_CD PK6 WHERE PK6.IMDG_PCK_CD = CGO.INTMD_N2ND_IMDG_PCK_CD)    AS INTMD_N2ND_IMDG_PCK_DESC" ).append("\n"); 
		query.append(",  CGO.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("--,  DECODE(CGO.IMDG_SEGR_GRP_NO, NULL, DECODE(INSTR(CGO.PRP_SHP_NM, 'N.O.S'), 0, NULL ," ).append("\n"); 
		query.append("--         (SELECT MAX(IMDG_SEGR_GRP_NO) FROM SCG_IMDG_SEGR_GRP WHERE IMDG_SEGR_GRP_NM = 'NONE')), CGO.IMDG_SEGR_GRP_NO) AS IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append(",  CGO.RSD_FLG" ).append("\n"); 
		query.append(",    '' VSL_CD" ).append("\n"); 
		query.append(",    '' SKD_VOY_NO" ).append("\n"); 
		query.append(",    '' SKD_DIR_CD" ).append("\n"); 
		query.append(",    '' SLAN_CD" ).append("\n"); 
		query.append(",    '' POL_CD" ).append("\n"); 
		query.append(",    '' POD_CD" ).append("\n"); 
		query.append(",	 '' DG_FLG" ).append("\n"); 
		query.append(",	 '' AWK_FLG" ).append("\n"); 
		query.append(",  CGO.DCGO_REF_NO AS DCGO_REF_NO" ).append("\n"); 
		query.append(",  CGO.DCGO_REF_NO AS ORG_DCGO_REF_NO" ).append("\n"); 
		query.append(",  (SELECT MAX(DECODE(ROWNUM, 1, IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL WHERE IMDG_UN_NO = CGO.IMDG_UN_NO) AS HCDG_TNK_RSTR_DESC1" ).append("\n"); 
		query.append(",  (SELECT MAX(DECODE(ROWNUM, 2, IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL WHERE IMDG_UN_NO = CGO.IMDG_UN_NO) AS HCDG_TNK_RSTR_DESC2" ).append("\n"); 
		query.append(",  (SELECT MAX(DECODE(ROWNUM, 3, IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL WHERE IMDG_UN_NO = CGO.IMDG_UN_NO) AS HCDG_TNK_RSTR_DESC3" ).append("\n"); 
		query.append(",  (SELECT MAX(DECODE(ROWNUM, 4, IMDG_SEGR_GRP_NO, NULL)) FROM SCG_IMDG_SEGR_GRP_DTL WHERE IMDG_UN_NO = CGO.IMDG_UN_NO) AS HCDG_TNK_RSTR_DESC4" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append(",  CGO.DCGO_SEQ" ).append("\n"); 
		query.append(",  CGO.IMDG_AMDT_NO" ).append("\n"); 
		query.append(",  (SELECT LISTAGG (EDI_UNMAP_DTL_CD, ',') WITHIN GROUP (ORDER BY BKG_REF_NO)" ).append("\n"); 
		query.append("      FROM SCG_PRNR_RQST_CGO_UNMAP" ).append("\n"); 
		query.append("     WHERE CRR_CD = CGO.CRR_CD" ).append("\n"); 
		query.append("       AND BKG_REF_NO = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("       AND SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("       AND SPCL_CNTR_SEQ = CGO.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("       AND SPCL_CGO_SEQ = CGO.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("       AND PRNR_CGO_RQST_SEQ = CGO.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("       AND EDI_UNMAP_CORR_RSLT_CD = 'N'" ).append("\n"); 
		query.append("   ) EDI_UNMAP_DTL_CD" ).append("\n"); 
		query.append(",  (SELECT CNTR_TPSZ_CD_CTNT" ).append("\n"); 
		query.append("      FROM SCG_PRNR_SPCL_CGO_TRSM_DTL" ).append("\n"); 
		query.append("     WHERE BKG.CRR_CD = CGO.CRR_CD" ).append("\n"); 
		query.append("       AND BKG.MAPG_TRSM_BND_CD = TRSM_BND_CD" ).append("\n"); 
		query.append("       AND BKG.MAPG_TRSM_DT = TRSM_DT" ).append("\n"); 
		query.append("       AND BKG.MAPG_TRSM_SPCL_CGO_CATE_CD = SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("       AND BKG.MAPG_PRNR_SPCL_CGO_SEQ = PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("       AND CGO.SPCL_CNTR_SEQ = CNTR_SEQ" ).append("\n"); 
		query.append("       AND CGO.SPCL_CGO_SEQ = CGO_SEQ" ).append("\n"); 
		query.append("   ) UNMAP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST     BKG" ).append("\n"); 
		query.append("   , SCG_PRNR_APRO_RQST_CGO CGO" ).append("\n"); 
		query.append("   , SCG_IMDG_UN_NO         SUN" ).append("\n"); 
		query.append("WHERE BKG.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("  AND BKG.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("  AND BKG.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("  AND BKG.PRNR_CGO_RQST_SEQ = CGO.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.CRR_CD         = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ref_no} != '')" ).append("\n"); 
		query.append("AND	BKG.BKG_REF_NO     = @[bkg_ref_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prnr_cgo_rqst_seq} != '')" ).append("\n"); 
		query.append("AND	BKG.PRNR_CGO_RQST_SEQ = @[prnr_cgo_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_cgo_rqst_seq} != '')" ).append("\n"); 
		query.append("  #if (${before} == 'Y')" ).append("\n"); 
		query.append("    --AND	BKG.SPCL_CGO_RQST_SEQ = NVL((	SELECT 	MAX(SPCL_CGO_RQST_SEQ)" ).append("\n"); 
		query.append("    --                                 	FROM 	SCG_PRNR_APRO_RQST_CGO" ).append("\n"); 
		query.append("    --                                 	WHERE 	CRR_CD 					= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("    --                                 	AND 	BKG_REF_NO 				= [bkg_ref_no]" ).append("\n"); 
		query.append("	--									AND		PRNR_CGO_RQST_SEQ		= BKG.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("    --                                 	AND 	AUTH_STS_CD 			IN ('Y','N'))," ).append("\n"); 
		query.append("    --                                 [spcl_cgo_rqst_seq])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND	BKG.SPCL_CGO_RQST_SEQ =		(	SELECT 	MAX(SPCL_CGO_RQST_SEQ)" ).append("\n"); 
		query.append("                                     	FROM 	SCG_PRNR_APRO_RQST_CGO" ).append("\n"); 
		query.append("                                     	WHERE 	CRR_CD 					= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("                                     	AND 	BKG_REF_NO 				= @[bkg_ref_no]" ).append("\n"); 
		query.append("										AND		PRNR_CGO_RQST_SEQ		= BKG.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("                                     	AND 	AUTH_STS_CD 			IN ('Y','N'))" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND	BKG.SPCL_CGO_RQST_SEQ = @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != '')" ).append("\n"); 
		query.append("AND BKG.RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND	BKG.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.POL_CD||BKG.POL_CLPT_IND_SEQ = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND	BKG.POD_CD||BKG.POD_CLPT_IND_SEQ = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_opr_cd} != '')" ).append("\n"); 
		query.append("AND CGO.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CGO.IMDG_UN_NO     = SUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND CGO.IMDG_UN_NO_SEQ = SUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY CGO.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("       , CGO.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("       , CGO.CNTR_REF_NO" ).append("\n"); 

	}
}