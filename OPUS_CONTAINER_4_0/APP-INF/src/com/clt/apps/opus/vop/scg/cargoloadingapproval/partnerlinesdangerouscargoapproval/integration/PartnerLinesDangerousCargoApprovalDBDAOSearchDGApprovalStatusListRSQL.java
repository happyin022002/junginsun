/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOSearchDGApprovalStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26 
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

public class PartnerLinesDangerousCargoApprovalDBDAOSearchDGApprovalStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Application Request & Approval Status for Partner Lines 조회
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOSearchDGApprovalStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOSearchDGApprovalStatusListRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("  RQS.SPCL_CGO_RQST_SEQ AS SPCL_CGO_APRO_RQST_SEQ," ).append("\n"); 
		query.append("  RQS.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("  '1' AS VSL_SEQ,  " ).append("\n"); 
		query.append("  RQS.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("  RQS.SLAN_CD," ).append("\n"); 
		query.append("  RQS.VSL_CD," ).append("\n"); 
		query.append("  RQS.SKD_VOY_NO," ).append("\n"); 
		query.append("  RQS.SKD_DIR_CD," ).append("\n"); 
		query.append("  CGO.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("  CGO.BKG_REF_NO AS BKG_NO," ).append("\n"); 
		query.append("  DECODE(CGO.AUTH_STS_CD,'C','C','') AS BKG_STS_CD," ).append("\n"); 
		query.append("  CGO.SPCL_CNTR_SEQ AS DG_CNTR_SEQ," ).append("\n"); 
		query.append("  CGO.SPCL_CGO_SEQ AS CNTR_CGO_SEQ," ).append("\n"); 
		query.append("  DECODE(CGO.SPCL_RQST_FLG, 'Y','S','')||'R'||CGO.SPCL_CGO_RQST_SEQ AS RQST_AUTH_CD," ).append("\n"); 
		query.append("  RQS.RQST_OFC_CD AS RQST_OFC_CD," ).append("\n"); 
		query.append("  TO_CHAR(CGO.UPD_DT,'YYYY-MM-DD') AS RQST_DT,  " ).append("\n"); 
		query.append("  --TO_CHAR(SYSDATE,'YYYY-MM-DD') AS RQST_GDT,  " ).append("\n"); 
		query.append("  TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC( GLOBALDATE_PKG.GET_LOCCD_FNC(RQS.RQST_OFC_CD), CGO.CGO_RQST_DT,'GMT'), CGO.CGO_RQST_DT),'YYYY-MM-DD') RQST_GDT," ).append("\n"); 
		query.append("  CGO.CRE_USR_ID AS RQST_USR_ID," ).append("\n"); 
		query.append("  DECODE(CGO.AUTH_STS_CD, 'R', NULL, CGO.AUTH_STS_CD) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("  DECODE(CGO.AUTH_STS_CD, 'R', null, 'C', null, TO_CHAR(CGO.AUTH_DT,'YYYY-MM-DD')) AS AUTH_DT,  " ).append("\n"); 
		query.append("  --DECODE(CGO.AUTH_STS_CD, 'R', NULL, 'X', NULL, TO_CHAR(SYSDATE,'YYYY-MM-DD')) AS AUTH_GDT," ).append("\n"); 
		query.append("  TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC( GLOBALDATE_PKG.GET_LOCCD_FNC(CGO.AUTH_OFC_CD), CGO.AUTH_DT,'GMT'), CGO.AUTH_DT),'YYYY-MM-DD') AS AUTH_GDT," ).append("\n"); 
		query.append("  DECODE(CGO.AUTH_STS_CD, 'R', null, 'C', null, CGO.AUTH_USR_ID) AS AUTH_USR_ID," ).append("\n"); 
		query.append("  CGO.SPCL_CGO_AUTH_RJCT_CD," ).append("\n"); 
		query.append("  CGO.SPCL_CGO_AUTH_RMK," ).append("\n"); 
		query.append("  RQS.POL_CD," ).append("\n"); 
		query.append("  RQS.POD_CD," ).append("\n"); 
		query.append("  DECODE(CGO.APRO_REF_NO,'0','',CGO.APRO_REF_NO) APRO_REF_NO," ).append("\n"); 
		query.append("  CGO.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  'DD' AS SCG_FLG," ).append("\n"); 
		query.append("  CGO.IMDG_UN_NO," ).append("\n"); 
		query.append("  CGO.IMDG_UN_NO_SEQ," ).append("\n"); 
		query.append("  CGO.IMDG_CLSS_CD,  " ).append("\n"); 
		query.append("  (DECODE(CGO.N1ST_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N1ST_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("  ||DECODE(CGO.N2ND_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N2ND_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("  ||DECODE(CGO.N3RD_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N3RD_IMDG_SUBS_RSK_LBL_CD)||DECODE(NVL(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,''),'','','0','','/')" ).append("\n"); 
		query.append("  ||DECODE(CGO.N4TH_IMDG_SUBS_RSK_LBL_CD,'0','',CGO.N4TH_IMDG_SUBS_RSK_LBL_CD)) IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("  CGO.MRN_POLUT_FLG," ).append("\n"); 
		query.append("  DECODE(CGO.IMDG_PCK_GRP_CD,'1','I','2','II','3','III','') IMDG_PCK_GRP_CD," ).append("\n"); 
		query.append("  CGO.IMDG_LMT_QTY_FLG," ).append("\n"); 
		query.append("  CGO.IMDG_EXPT_QTY_FLG," ).append("\n"); 
		query.append("  CGO.FLSH_PNT_CDO_TEMP," ).append("\n"); 
		query.append("  CGO.GRS_WGT," ).append("\n"); 
		query.append("  CGO.NET_WGT," ).append("\n"); 
		query.append("  DECODE(TRIM(CGO.IN_N1ST_IMDG_PCK_CD),'','',CGO.IN_N1ST_IMDG_PCK_QTY||'×'||CGO.IN_N1ST_IMDG_PCK_CD)||" ).append("\n"); 
		query.append("  DECODE(TRIM(CGO.IN_N2ND_IMDG_PCK_CD),'','',', '||CGO.IN_N2ND_IMDG_PCK_QTY||'×'||CGO.IN_N2ND_IMDG_PCK_CD) AS IN_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("  DECODE(TRIM(CGO.OUT_N1ST_IMDG_PCK_CD),'','',CGO.OUT_N1ST_IMDG_PCK_QTY||'×'||CGO.OUT_N1ST_IMDG_PCK_CD)||" ).append("\n"); 
		query.append("  DECODE(TRIM(CGO.OUT_N2ND_IMDG_PCK_CD),'','',', '||CGO.OUT_N2ND_IMDG_PCK_QTY||'×'||CGO.OUT_N2ND_IMDG_PCK_CD) AS OUT_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("  DECODE(TRIM(CGO.INTMD_N1ST_IMDG_PCK_CD),'','',CGO.INTMD_N1ST_IMDG_PCK_QTY||'×'||CGO.INTMD_N1ST_IMDG_PCK_CD)||" ).append("\n"); 
		query.append("  DECODE(TRIM(CGO.INTMD_N2ND_IMDG_PCK_CD),'','',', '||CGO.INTMD_N2ND_IMDG_PCK_QTY||'×'||CGO.INTMD_N2ND_IMDG_PCK_CD) AS INTMD_IMDG_PCK_QTY1," ).append("\n"); 
		query.append("  CGO.PSA_NO," ).append("\n"); 
		query.append("  SUN.HCDG_FLG," ).append("\n"); 
		query.append("  '' AS SPCL_RQST_DESC" ).append("\n"); 
		query.append("FROM SCG_PRNR_APRO_RQST RQS, SCG_PRNR_APRO_RQST_CGO CGO, SCG_IMDG_UN_NO SUN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND RQS.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("  AND RQS.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND RQS.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND RQS.DG_FLG            = 'Y'" ).append("\n"); 
		query.append("  AND RQS.AWK_FLG           = 'N'" ).append("\n"); 
		query.append("  AND RQS.CRR_CD            = CGO.CRR_CD" ).append("\n"); 
		query.append("  AND RQS.BKG_REF_NO        = CGO.BKG_REF_NO" ).append("\n"); 
		query.append("  AND RQS.SPCL_CGO_RQST_SEQ = CGO.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("  AND RQS.PRNR_CGO_RQST_SEQ = CGO.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("  AND RQS.SRC_TP_CD <> 'EDI'" ).append("\n"); 
		query.append("  AND RQS.BKG_REF_NO = @[booking_no]" ).append("\n"); 
		query.append("  AND CGO.AUTH_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("  AND CGO.IMDG_UN_NO        = SUN.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("  AND CGO.IMDG_UN_NO_SEQ    = SUN.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("  ORDER BY RQS.SPCL_CGO_RQST_SEQ, CGO.SPCL_CNTR_SEQ, CGO.SPCL_CGO_SEQ" ).append("\n"); 

	}
}