/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FFCommCalculationDBDAOModifyACMBKGInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOModifyACMBKGInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOModifyACMBKGInfoUSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOModifyACMBKGInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_ioc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOModifyACMBKGInfoUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_AGN_BKG_INFO TBL" ).append("\n"); 
		query.append(" USING" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                  FRT.BKG_NO," ).append("\n"); 
		query.append("                  BKG.BL_NO," ).append("\n"); 
		query.append("                  BKG.BL_NO_TP," ).append("\n"); 
		query.append("                  BKG.BL_TP_CD," ).append("\n"); 
		query.append("                  BKG.BKG_STS_CD," ).append("\n"); 
		query.append("                  BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                  DOC.BL_CVRD_TP_CD," ).append("\n"); 
		query.append("                  BKG.CHN_AGN_CD                     AS CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("                  BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("                  CRB.CLT_OFC_CD," ).append("\n"); 
		query.append("                  BKG.BKG_CRE_DT," ).append("\n"); 
		query.append("                  DOC.BDR_FLG," ).append("\n"); 
		query.append("                  DOC.BDR_DT," ).append("\n"); 
		query.append("                  BKG.POR_CD," ).append("\n"); 
		query.append("                  BAR.POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("                  BAR.POR_AR_OFC_CD," ).append("\n"); 
		query.append("                  BKG.POL_CD," ).append("\n"); 
		query.append("                  BAR.POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("                  BAR.POL_AR_OFC_CD," ).append("\n"); 
		query.append("                  BKG.POD_CD," ).append("\n"); 
		query.append("                  BAR.POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("                  BAR.POD_AR_OFC_CD," ).append("\n"); 
		query.append("                  BKG.DEL_CD," ).append("\n"); 
		query.append("                  BAR.DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("                  BAR.DEL_AR_OFC_CD," ).append("\n"); 
		query.append("                  BKG.RCV_TERM_CD                      AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("                  BKG.DE_TERM_CD                       AS BKG_DE_TERM_CD," ).append("\n"); 
		query.append("--                  (" ).append("\n"); 
		query.append("--                      SELECT" ).append("\n"); 
		query.append("--                             REP_TRD_CD" ).append("\n"); 
		query.append("--                        FROM MDM_REV_LANE" ).append("\n"); 
		query.append("--                       WHERE RLANE_CD = FRT.RLANE_CD" ).append("\n"); 
		query.append("--                  )                                      AS TRD_CD, " ).append("\n"); 
		query.append("                  CRB.TRD_CD, -- [CHM-201324678] ACM 계산 시, Trade 정보 source 변경 요청" ).append("\n"); 
		query.append("                  BKG.SLAN_CD," ).append("\n"); 
		query.append("                  FRT.RLANE_CD," ).append("\n"); 
		query.append("                  FRT.REV_VVD_CD," ).append("\n"); 
		query.append("                  FRT.TRNK_SLAN_CD," ).append("\n"); 
		query.append("                  FRT.TRNK_RLANE_CD," ).append("\n"); 
		query.append("                  FRT.TRNK_VSL_CD," ).append("\n"); 
		query.append("                  FRT.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("                  FRT.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("                  FRT.TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("                  BKG.SVC_SCP_CD," ).append("\n"); 
		query.append("                  NVL (BKG.PRE_RLY_PORT_CD, '*')       AS PRE_PORT_CD," ).append("\n"); 
		query.append("                  NVL (BKG.PST_RLY_PORT_CD, '*')       AS PST_PORT_CD," ).append("\n"); 
		query.append("				  FRT.FMC_NO," ).append("\n"); 
		query.append("                  NULL                                 AS COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("                  'ACM SYSTEM'                         AS UPD_USR_ID," ).append("\n"); 
		query.append("                  SYSDATE                              AS UPD_DT," ).append("\n"); 
		query.append("                  'ACM SYSTEM'                         AS CRE_USR_ID," ).append("\n"); 
		query.append("                  SYSDATE                              AS CRE_DT" ).append("\n"); 
		query.append("                  --FRT.SHPR_CNT_CD," ).append("\n"); 
		query.append("                  --FRT.SHPR_SEQ," ).append("\n"); 
		query.append("                  --FRT.FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("                  --FRT.FRT_FWRD_SEQ," ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("--                  NULL                                 AS BKG_CA_NO," ).append("\n"); 
		query.append("--                  NULL                                 AS BKG_CA_DT," ).append("\n"); 
		query.append("--                " ).append("\n"); 
		query.append("--                  " ).append("\n"); 
		query.append("--                  " ).append("\n"); 
		query.append("--                  " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("--                  BKG.REP_CMDT_CD," ).append("\n"); 
		query.append("--                  BKG.CMDT_CD," ).append("\n"); 
		query.append("--                  BKG.SC_NO," ).append("\n"); 
		query.append("--                  BKG.RFA_NO," ).append("\n"); 
		query.append("--                  NVL (BKG.DCGO_FLG, 'N')              AS SPCL_DG_CGO_FLG," ).append("\n"); 
		query.append("--                  NVL (BKG.RC_FLG, 'N')                AS SPCL_RC_FLG," ).append("\n"); 
		query.append("--                  NVL (BKG.AWK_CGO_FLG, 'N')           AS SPCL_AWK_CGO_FLG," ).append("\n"); 
		query.append("--                  NVL (BKG.BB_CGO_FLG, 'N')            AS SPCL_BB_CGO_FLG," ).append("\n"); 
		query.append("--                  'N'                                  AS SPCL_RD_CGO_FLG," ).append("\n"); 
		query.append("--                  BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("--                  FRT.SLS_OFC_CD," ).append("\n"); 
		query.append("--                  NULL                                 AS RHQ_CD," ).append("\n"); 
		query.append("--                  NVL (BKG.SOC_FLG, 'N')               AS BKG_SOC_FLG," ).append("\n"); 
		query.append("--                  NVL (BKG.DBL_BKG_FLG, 'N')           AS BKG_DBL_FLG," ).append("\n"); 
		query.append("--                  " ).append("\n"); 
		query.append("--                  FRT.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("--                  FRT.BKG_PPD_FRT_AMT," ).append("\n"); 
		query.append("--                  FRT.BKG_PPD_OTR_AMT," ).append("\n"); 
		query.append("--                  FRT.BKG_CLT_FRT_AMT," ).append("\n"); 
		query.append("--                  FRT.BKG_CLT_OTR_AMT," ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("             FROM BKG_BOOKING   BKG," ).append("\n"); 
		query.append("                  BKG_BL_DOC DOC, " ).append("\n"); 
		query.append("                  MAS_RGST_BKG CRB," ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                  SELECT " ).append("\n"); 
		query.append("                     B.BKG_NO" ).append("\n"); 
		query.append("                    ,B.BKG_OFC_CD" ).append("\n"); 
		query.append("                    ,OB.AR_OFC_CD AS BKG_OFC_AR " ).append("\n"); 
		query.append("                    ,B.POR_CD" ).append("\n"); 
		query.append("                    ,L1.FINC_CTRL_OFC_CD AS POR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    ,O1.AR_OFC_CD AS POR_AR_OFC_CD" ).append("\n"); 
		query.append("                    ,B.POL_CD" ).append("\n"); 
		query.append("                    ,L2.FINC_CTRL_OFC_CD AS POL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    ,O2.AR_OFC_CD AS POL_AR_OFC_CD" ).append("\n"); 
		query.append("                    ,B.POD_CD" ).append("\n"); 
		query.append("                    ,L3.FINC_CTRL_OFC_CD AS POD_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    ,O3.AR_OFC_CD AS POD_AR_OFC_CD" ).append("\n"); 
		query.append("                    ,B.DEL_CD" ).append("\n"); 
		query.append("                    ,L4.FINC_CTRL_OFC_CD AS DEL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                    ,O4.AR_OFC_CD AS DEL_AR_OFC_CD" ).append("\n"); 
		query.append("                  FROM " ).append("\n"); 
		query.append("                     BKG_BOOKING B" ).append("\n"); 
		query.append("                    ,MDM_LOCATION L1" ).append("\n"); 
		query.append("                    ,MDM_LOCATION L2" ).append("\n"); 
		query.append("                    ,MDM_LOCATION L3" ).append("\n"); 
		query.append("                    ,MDM_LOCATION L4" ).append("\n"); 
		query.append("                    ,MDM_ORGANIZATION OB" ).append("\n"); 
		query.append("                    ,MDM_ORGANIZATION O1" ).append("\n"); 
		query.append("                    ,MDM_ORGANIZATION O2" ).append("\n"); 
		query.append("                    ,MDM_ORGANIZATION O3" ).append("\n"); 
		query.append("                    ,MDM_ORGANIZATION O4" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND B.BKG_NO = @[bkg_no]--'DUS101173700'" ).append("\n"); 
		query.append("                    AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("                    AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("                    AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("                    AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("                    AND B.BKG_OFC_CD = OB.OFC_CD " ).append("\n"); 
		query.append("                    AND L1.FINC_CTRL_OFC_CD = O1.OFC_CD " ).append("\n"); 
		query.append("                    AND L2.FINC_CTRL_OFC_CD = O2.OFC_CD " ).append("\n"); 
		query.append("                    AND L3.FINC_CTRL_OFC_CD = O3.OFC_CD " ).append("\n"); 
		query.append("                    AND L4.FINC_CTRL_OFC_CD = O4.OFC_CD " ).append("\n"); 
		query.append("                  ) BAR," ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                      SELECT" ).append("\n"); 
		query.append("                             INP.BKG_NO," ).append("\n"); 
		query.append("                             INP.SHPR_CNT_CD," ).append("\n"); 
		query.append("                             INP.SHPR_SEQ," ).append("\n"); 
		query.append("                             INP.FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("                             INP.FRT_FWRD_SEQ," ).append("\n"); 
		query.append("                             INP.RLANE_CD," ).append("\n"); 
		query.append("                             INP.REV_VVD_CD," ).append("\n"); 
		query.append("                             INP.TRNK_SLAN_CD," ).append("\n"); 
		query.append("                             INP.TRNK_RLANE_CD," ).append("\n"); 
		query.append("                             INP.TRNK_VSL_CD," ).append("\n"); 
		query.append("                             INP.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("                             INP.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("                             INP.TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("                             INP.FMC_NO," ).append("\n"); 
		query.append("                             INP.SLS_OFC_CD," ).append("\n"); 
		query.append("                             INP.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("                             SUM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD      = 'OFT'" ).append("\n"); 
		query.append("                         AND BCR.CURR_CD     = 'USD'" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD      = 'OFT'" ).append("\n"); 
		query.append("                         AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                           )                                      AS BKG_PPD_FRT_AMT," ).append("\n"); 
		query.append("                             SUM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD      = 'OFT'" ).append("\n"); 
		query.append("                        THEN 0" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                         AND BCR.CURR_CD     = 'USD'" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("                         AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                           )                                      AS BKG_PPD_OTR_AMT," ).append("\n"); 
		query.append("                             SUM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD      = 'OFT'" ).append("\n"); 
		query.append("                         AND BCR.CURR_CD     = 'USD'" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD      = 'OFT'" ).append("\n"); 
		query.append("                         AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                           )                                      AS BKG_CLT_FRT_AMT," ).append("\n"); 
		query.append("                             SUM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                         AND BCR.CHG_CD      = 'OFT'" ).append("\n"); 
		query.append("                        THEN 0" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                         AND BCR.CURR_CD     = 'USD'" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("                        WHEN BCR.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("                         AND NVL (MXR.USD_LOCL_XCH_RT, 0) <> 0" ).append("\n"); 
		query.append("                        THEN BCR.CHG_AMT / MXR.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                           )                                      AS BKG_CLT_OTR_AMT" ).append("\n"); 
		query.append("                        FROM BKG_CHG_RT    BCR," ).append("\n"); 
		query.append("                             GL_MON_XCH_RT MXR," ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                                 SELECT" ).append("\n"); 
		query.append("                                        @[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("                                        @[shpr_cnt_cd] AS SHPR_CNT_CD," ).append("\n"); 
		query.append("                                        @[shpr_cust_seq] AS SHPR_SEQ," ).append("\n"); 
		query.append("                                        @[bkg_ff_cnt_cd] AS FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("                                        @[bkg_ff_seq] AS FRT_FWRD_SEQ," ).append("\n"); 
		query.append("                                        @[comm_rlane_cd] AS RLANE_CD," ).append("\n"); 
		query.append("                                        @[rev_vvd_cd] AS REV_VVD_CD," ).append("\n"); 
		query.append("                                        @[slan_cd] AS TRNK_SLAN_CD," ).append("\n"); 
		query.append("                                        @[rlane_cd] AS TRNK_RLANE_CD," ).append("\n"); 
		query.append("                                        @[vsl_cd] AS TRNK_VSL_CD," ).append("\n"); 
		query.append("                                        @[skd_voy_no] AS TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("                                        @[skd_dir_cd] AS TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("                                        @[rlane_dir_cd] AS TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("                                        @[fmc_no] AS FMC_NO," ).append("\n"); 
		query.append("                                        @[bkg_sls_ofc_cd] AS SLS_OFC_CD," ).append("\n"); 
		query.append("                                        @[estm_ioc_div_cd] AS ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                                   FROM DUAL" ).append("\n"); 
		query.append("                           ) INP" ).append("\n"); 
		query.append("                       WHERE BCR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                         AND BCR.CURR_CD              = MXR.CURR_CD" ).append("\n"); 
		query.append("                         AND BCR.BKG_NO               = INP.BKG_NO" ).append("\n"); 
		query.append("                         AND MXR.ACCT_XCH_RT_LVL      = '1'" ).append("\n"); 
		query.append("                         AND MXR.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                          IN" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                                 SELECT" ).append("\n"); 
		query.append("                                   CASE" ).append("\n"); 
		query.append("                                   WHEN RAT.RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                                   THEN TO_CHAR (LEAST (RAT.RT_APLY_DT, SYSDATE), 'YYYYMM')" ).append("\n"); 
		query.append("                                   WHEN RAT.RT_APLY_DT IS NULL" ).append("\n"); 
		query.append("                                    AND" ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                   NVL (SUM (CNTR_VOL_QTY), 0)" ).append("\n"); 
		query.append("                                              FROM BKG_CONTAINER BCN" ).append("\n"); 
		query.append("                                             WHERE BCN.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                      =" ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                   NVL (SUM (QTY.OP_CNTR_QTY), 0)" ).append("\n"); 
		query.append("                                              FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                                             WHERE QTY.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                               AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                    AND SUBSTR (BKG.POR_CD, 1, 2) = 'US'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.POR_CD, 1, 2) = 'MX'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.POR_CD, 1, 2) = 'CA'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.POR_CD, 1, 2) = 'BR'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.DEL_CD, 1, 2) = 'MX'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.DEL_CD, 1, 2) = 'CA'" ).append("\n"); 
		query.append("                                     OR SUBSTR (BKG.DEL_CD, 1, 2) = 'BR'" ).append("\n"); 
		query.append("                                   THEN" ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                              CASE" ).append("\n"); 
		query.append("                                              WHEN MAX (BCN.CGO_RCV_DT) IS NULL" ).append("\n"); 
		query.append("                                              THEN TO_CHAR (SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                                              ELSE TO_CHAR (LEAST (MAX (BCN.CGO_RCV_DT), SYSDATE), 'YYYYMM')" ).append("\n"); 
		query.append("                                               END RT_APLY_DT" ).append("\n"); 
		query.append("                                              FROM BKG_CONTAINER BCN" ).append("\n"); 
		query.append("                                             WHERE BCN.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                                    TO_CHAR (LEAST (MAX (VSK.INIT_ETD_DT), SYSDATE), 'YYYYMM')" ).append("\n"); 
		query.append("                                              FROM BKG_VVD          VVD," ).append("\n"); 
		query.append("                                                   VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                                             WHERE VVD.BKG_NO       = BKG.BKG_NO" ).append("\n"); 
		query.append("                                               AND VVD.POL_CD       = BKG.POL_CD" ).append("\n"); 
		query.append("                                               AND VVD.VSL_CD       = VSK.VSL_CD" ).append("\n"); 
		query.append("                                               AND VVD.SKD_VOY_NO   = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                               AND VVD.SKD_DIR_CD   = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                                               AND VVD.POL_CD       = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                                    END AS RT_APLY_DT" ).append("\n"); 
		query.append("                                   FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("                                        BKG_RATE    RAT" ).append("\n"); 
		query.append("                                  WHERE BKG.BKG_NO = RAT.BKG_NO" ).append("\n"); 
		query.append("                                    AND BKG.BKG_NO = INP.BKG_NO" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                ) FRT" ).append("\n"); 
		query.append("            WHERE FRT.BKG_NO               = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND FRT.BKG_NO               = DOC.BKG_NO" ).append("\n"); 
		query.append("            AND FRT.BKG_NO               = CRB.BKG_NO " ).append("\n"); 
		query.append("            AND FRT.BKG_NO               = BAR.BKG_NO" ).append("\n"); 
		query.append("     ) PSD" ).append("\n"); 
		query.append("    ON" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("       TBL.BKG_NO = PSD.BKG_NO" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED" ).append("\n"); 
		query.append("  THEN" ).append("\n"); 
		query.append("           UPDATE" ).append("\n"); 
		query.append("              SET               " ).append("\n"); 
		query.append("                  TBL.BL_NO                    = PSD.BL_NO               " ).append("\n"); 
		query.append("                  ,TBL.BL_NO_TP                 = PSD.BL_NO_TP            " ).append("\n"); 
		query.append("                  ,TBL.BL_TP_CD                 = PSD.BL_TP_CD            " ).append("\n"); 
		query.append("                  ,TBL.BKG_STS_CD               = PSD.BKG_STS_CD          " ).append("\n"); 
		query.append("                  ,TBL.BKG_CGO_TP_CD            = PSD.BKG_CGO_TP_CD       " ).append("\n"); 
		query.append("                  ,TBL.BL_CVRD_TP_CD            = PSD.BL_CVRD_TP_CD       " ).append("\n"); 
		query.append("                  ,TBL.CHN_BKG_AGN_CD           = PSD.CHN_BKG_AGN_CD      " ).append("\n"); 
		query.append("                  ,TBL.BKG_OFC_CD               = PSD.BKG_OFC_CD          " ).append("\n"); 
		query.append("                  ,TBL.CLT_OFC_CD               = PSD.CLT_OFC_CD          " ).append("\n"); 
		query.append("                  ,TBL.BKG_CRE_DT               = PSD.BKG_CRE_DT          " ).append("\n"); 
		query.append("                  ,TBL.BDR_FLG                  = PSD.BDR_FLG             " ).append("\n"); 
		query.append("                  ,TBL.BDR_DT                   = PSD.BDR_DT              " ).append("\n"); 
		query.append("                  ,TBL.POR_CD                   = PSD.POR_CD              " ).append("\n"); 
		query.append("                  ,TBL.POR_FINC_CTRL_OFC_CD     = PSD.POR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.POR_AR_OFC_CD            = PSD.POR_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.POL_CD                   = PSD.POL_CD              " ).append("\n"); 
		query.append("                  ,TBL.POL_FINC_CTRL_OFC_CD     = PSD.POL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.POL_AR_OFC_CD            = PSD.POL_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.POD_CD                   = PSD.POD_CD              " ).append("\n"); 
		query.append("                  ,TBL.POD_FINC_CTRL_OFC_CD     = PSD.POD_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.POD_AR_OFC_CD            = PSD.POD_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.DEL_CD                   = PSD.DEL_CD              " ).append("\n"); 
		query.append("                  ,TBL.DEL_FINC_CTRL_OFC_CD     = PSD.DEL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.DEL_AR_OFC_CD            = PSD.DEL_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.BKG_RCV_TERM_CD          = PSD.BKG_RCV_TERM_CD     " ).append("\n"); 
		query.append("                  ,TBL.BKG_DE_TERM_CD           = PSD.BKG_DE_TERM_CD      " ).append("\n"); 
		query.append("                  ,TBL.TRD_CD                   = PSD.TRD_CD              " ).append("\n"); 
		query.append("                  ,TBL.SLAN_CD                  = PSD.SLAN_CD             " ).append("\n"); 
		query.append("                  ,TBL.RLANE_CD                 = PSD.RLANE_CD            " ).append("\n"); 
		query.append("                  ,TBL.REV_VVD_CD               = PSD.REV_VVD_CD          " ).append("\n"); 
		query.append("                  ,TBL.TRNK_SLAN_CD             = PSD.TRNK_SLAN_CD        " ).append("\n"); 
		query.append("                  ,TBL.TRNK_RLANE_CD            = PSD.TRNK_RLANE_CD       " ).append("\n"); 
		query.append("                  ,TBL.TRNK_VSL_CD              = PSD.TRNK_VSL_CD         " ).append("\n"); 
		query.append("                  ,TBL.TRNK_SKD_VOY_NO          = PSD.TRNK_SKD_VOY_NO     " ).append("\n"); 
		query.append("                  ,TBL.TRNK_SKD_DIR_CD          = PSD.TRNK_SKD_DIR_CD     " ).append("\n"); 
		query.append("                  ,TBL.TRNK_REV_DIR_CD          = PSD.TRNK_REV_DIR_CD     " ).append("\n"); 
		query.append("                  ,TBL.SVC_SCP_CD               = PSD.SVC_SCP_CD          " ).append("\n"); 
		query.append("                  ,TBL.PRE_PORT_CD              = PSD.PRE_PORT_CD         " ).append("\n"); 
		query.append("                  ,TBL.PST_PORT_CD              = PSD.PST_PORT_CD " ).append("\n"); 
		query.append("                  ,TBL.FMC_NO             		= PSD.FMC_NO " ).append("\n"); 
		query.append("                  ,TBL.COMM_PROC_RSLT_RSN       = PSD.COMM_PROC_RSLT_RSN  " ).append("\n"); 
		query.append("                  ,TBL.UPD_DT                   = PSD.UPD_DT              " ).append("\n"); 
		query.append("  WHEN NOT MATCHED" ).append("\n"); 
		query.append("  THEN" ).append("\n"); 
		query.append("           INSERT" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                  TBL.BKG_NO              " ).append("\n"); 
		query.append("                  ,TBL.BL_NO               " ).append("\n"); 
		query.append("                  ,TBL.BL_NO_TP            " ).append("\n"); 
		query.append("                  ,TBL.BL_TP_CD            " ).append("\n"); 
		query.append("                  ,TBL.BKG_STS_CD          " ).append("\n"); 
		query.append("                  ,TBL.BKG_CGO_TP_CD       " ).append("\n"); 
		query.append("                  ,TBL.BL_CVRD_TP_CD       " ).append("\n"); 
		query.append("                  ,TBL.CHN_BKG_AGN_CD      " ).append("\n"); 
		query.append("                  ,TBL.BKG_OFC_CD          " ).append("\n"); 
		query.append("                  ,TBL.CLT_OFC_CD          " ).append("\n"); 
		query.append("                  ,TBL.BKG_CRE_DT          " ).append("\n"); 
		query.append("                  ,TBL.BDR_FLG             " ).append("\n"); 
		query.append("                  ,TBL.BDR_DT              " ).append("\n"); 
		query.append("                  ,TBL.POR_CD              " ).append("\n"); 
		query.append("                  ,TBL.POR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.POR_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.POL_CD              " ).append("\n"); 
		query.append("                  ,TBL.POL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.POL_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.POD_CD              " ).append("\n"); 
		query.append("                  ,TBL.POD_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.POD_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.DEL_CD              " ).append("\n"); 
		query.append("                  ,TBL.DEL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TBL.DEL_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,TBL.BKG_RCV_TERM_CD     " ).append("\n"); 
		query.append("                  ,TBL.BKG_DE_TERM_CD      " ).append("\n"); 
		query.append("                  ,TBL.TRD_CD              " ).append("\n"); 
		query.append("                  ,TBL.SLAN_CD             " ).append("\n"); 
		query.append("                  ,TBL.RLANE_CD            " ).append("\n"); 
		query.append("                  ,TBL.REV_VVD_CD          " ).append("\n"); 
		query.append("                  ,TBL.TRNK_SLAN_CD        " ).append("\n"); 
		query.append("                  ,TBL.TRNK_RLANE_CD       " ).append("\n"); 
		query.append("                  ,TBL.TRNK_VSL_CD         " ).append("\n"); 
		query.append("                  ,TBL.TRNK_SKD_VOY_NO     " ).append("\n"); 
		query.append("                  ,TBL.TRNK_SKD_DIR_CD     " ).append("\n"); 
		query.append("                  ,TBL.TRNK_REV_DIR_CD     " ).append("\n"); 
		query.append("                  ,TBL.SVC_SCP_CD          " ).append("\n"); 
		query.append("                  ,TBL.PRE_PORT_CD         " ).append("\n"); 
		query.append("                  ,TBL.PST_PORT_CD         " ).append("\n"); 
		query.append("                  ,TBL.FMC_NO        " ).append("\n"); 
		query.append("                  ,TBL.COMM_PROC_RSLT_RSN  " ).append("\n"); 
		query.append("                  ,TBL.UPD_USR_ID          " ).append("\n"); 
		query.append("                  ,TBL.UPD_DT              " ).append("\n"); 
		query.append("                  ,TBL.CRE_USR_ID          " ).append("\n"); 
		query.append("                  ,TBL.CRE_DT              " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           VALUES" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                  PSD.BKG_NO              " ).append("\n"); 
		query.append("                  ,PSD.BL_NO               " ).append("\n"); 
		query.append("                  ,PSD.BL_NO_TP            " ).append("\n"); 
		query.append("                  ,PSD.BL_TP_CD            " ).append("\n"); 
		query.append("                  ,PSD.BKG_STS_CD          " ).append("\n"); 
		query.append("                  ,PSD.BKG_CGO_TP_CD       " ).append("\n"); 
		query.append("                  ,PSD.BL_CVRD_TP_CD       " ).append("\n"); 
		query.append("                  ,PSD.CHN_BKG_AGN_CD      " ).append("\n"); 
		query.append("                  ,PSD.BKG_OFC_CD          " ).append("\n"); 
		query.append("                  ,PSD.CLT_OFC_CD          " ).append("\n"); 
		query.append("                  ,PSD.BKG_CRE_DT          " ).append("\n"); 
		query.append("                  ,PSD.BDR_FLG             " ).append("\n"); 
		query.append("                  ,PSD.BDR_DT              " ).append("\n"); 
		query.append("                  ,PSD.POR_CD              " ).append("\n"); 
		query.append("                  ,PSD.POR_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,PSD.POR_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,PSD.POL_CD              " ).append("\n"); 
		query.append("                  ,PSD.POL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,PSD.POL_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,PSD.POD_CD              " ).append("\n"); 
		query.append("                  ,PSD.POD_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,PSD.POD_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,PSD.DEL_CD              " ).append("\n"); 
		query.append("                  ,PSD.DEL_FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,PSD.DEL_AR_OFC_CD       " ).append("\n"); 
		query.append("                  ,PSD.BKG_RCV_TERM_CD     " ).append("\n"); 
		query.append("                  ,PSD.BKG_DE_TERM_CD      " ).append("\n"); 
		query.append("                  ,PSD.TRD_CD              " ).append("\n"); 
		query.append("                  ,PSD.SLAN_CD             " ).append("\n"); 
		query.append("                  ,PSD.RLANE_CD            " ).append("\n"); 
		query.append("                  ,PSD.REV_VVD_CD          " ).append("\n"); 
		query.append("                  ,PSD.TRNK_SLAN_CD        " ).append("\n"); 
		query.append("                  ,PSD.TRNK_RLANE_CD       " ).append("\n"); 
		query.append("                  ,PSD.TRNK_VSL_CD         " ).append("\n"); 
		query.append("                  ,PSD.TRNK_SKD_VOY_NO     " ).append("\n"); 
		query.append("                  ,PSD.TRNK_SKD_DIR_CD     " ).append("\n"); 
		query.append("                  ,PSD.TRNK_REV_DIR_CD     " ).append("\n"); 
		query.append("                  ,PSD.SVC_SCP_CD          " ).append("\n"); 
		query.append("                  ,PSD.PRE_PORT_CD         " ).append("\n"); 
		query.append("                  ,PSD.PST_PORT_CD    " ).append("\n"); 
		query.append("                  ,PSD.FMC_NO           " ).append("\n"); 
		query.append("                  ,PSD.COMM_PROC_RSLT_RSN  " ).append("\n"); 
		query.append("                  ,PSD.UPD_USR_ID          " ).append("\n"); 
		query.append("                  ,PSD.UPD_DT              " ).append("\n"); 
		query.append("                  ,PSD.CRE_USR_ID          " ).append("\n"); 
		query.append("                  ,PSD.CRE_DT              " ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}