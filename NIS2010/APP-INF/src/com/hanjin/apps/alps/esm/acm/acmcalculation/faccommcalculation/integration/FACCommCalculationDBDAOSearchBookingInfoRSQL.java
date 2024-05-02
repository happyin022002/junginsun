/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchBookingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchBookingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchBookingInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchBookingInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BKG.POR_CD," ).append("\n"); 
		query.append("  POR.RGN_CD AS POR_RGN_CD," ).append("\n"); 
		query.append("  POR.CNT_CD AS POR_CNT_CD," ).append("\n"); 
		query.append("  POR.STE_CD AS POR_STE_CD," ).append("\n"); 
		query.append("  POR.SCONTI_CD AS POR_SCONTI_CD," ).append("\n"); 
		query.append("  POR.CONTI_CD AS POR_CONTI_CD," ).append("\n"); 
		query.append("  CASE WHEN BKG.BKG_OFC_CD = 'BSLBA' THEN 'BSLBA'" ).append("\n"); 
		query.append("       WHEN POL.FINC_CTRL_OFC_CD = 'GLWBA' THEN 'GLWBA'" ).append("\n"); 
		query.append("       ELSE POR.FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("  END AS POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN BKG.BKG_OFC_CD = 'BSLBA' THEN OBK.AR_OFC_CD" ).append("\n"); 
		query.append("       WHEN POL.FINC_CTRL_OFC_CD = 'GLWBA' THEN OOL.AR_OFC_CD" ).append("\n"); 
		query.append("       ELSE OOR.AR_OFC_CD" ).append("\n"); 
		query.append("  END AS POR_AR_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN BKG.BKG_OFC_CD = 'BSLBA' THEN OBK.AP_OFC_CD" ).append("\n"); 
		query.append("       WHEN POL.FINC_CTRL_OFC_CD = 'GLWBA' THEN OOL.AP_OFC_CD" ).append("\n"); 
		query.append("       ELSE OOR.AP_OFC_CD" ).append("\n"); 
		query.append("  END AS POR_AP_OFC_CD," ).append("\n"); 
		query.append("  BKG.POL_CD," ).append("\n"); 
		query.append("  POL.RGN_CD AS POL_RGN_CD," ).append("\n"); 
		query.append("  POL.CNT_CD AS POL_CNT_CD," ).append("\n"); 
		query.append("  POL.STE_CD AS POL_STE_CD," ).append("\n"); 
		query.append("  POL.SCONTI_CD AS POL_SCONTI_CD," ).append("\n"); 
		query.append("  POL.CONTI_CD AS POL_CONTI_CD," ).append("\n"); 
		query.append("  POL.FINC_CTRL_OFC_CD AS POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  OOL.AR_OFC_CD AS POL_AR_OFC_CD," ).append("\n"); 
		query.append("  OOL.AP_OFC_CD AS POL_AP_OFC_CD," ).append("\n"); 
		query.append("  BKG.POD_CD," ).append("\n"); 
		query.append("  POD.RGN_CD AS POD_RGN_CD," ).append("\n"); 
		query.append("  POD.CNT_CD AS POD_CNT_CD," ).append("\n"); 
		query.append("  POD.STE_CD AS POD_STE_CD," ).append("\n"); 
		query.append("  POD.SCONTI_CD AS POD_SCONTI_CD," ).append("\n"); 
		query.append("  POD.CONTI_CD AS POD_CONTI_CD," ).append("\n"); 
		query.append("  POD.FINC_CTRL_OFC_CD AS POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  OOD.AR_OFC_CD AS POD_AR_OFC_CD," ).append("\n"); 
		query.append("  OOD.AP_OFC_CD AS POD_AP_OFC_CD," ).append("\n"); 
		query.append("  BKG.DEL_CD," ).append("\n"); 
		query.append("  DEL.RGN_CD AS DEL_RGN_CD," ).append("\n"); 
		query.append("  DEL.CNT_CD AS DEL_CNT_CD," ).append("\n"); 
		query.append("  DEL.STE_CD AS DEL_STE_CD," ).append("\n"); 
		query.append("  DEL.SCONTI_CD AS DEL_SCONTI_CD," ).append("\n"); 
		query.append("  DEL.CONTI_CD AS DEL_CONTI_CD," ).append("\n"); 
		query.append("  CASE WHEN BRT.CLT_OFC_CD = 'BUDSC' AND POD.LOC_CD IN ('DEHAM', 'NLRTM', 'SIKOP') THEN 'BUDSC'" ).append("\n"); 
		query.append("       WHEN POD.FINC_CTRL_OFC_CD = 'GLWBA' THEN 'GLWBA'" ).append("\n"); 
		query.append("       WHEN POD.FINC_CTRL_OFC_CD = 'BUDSC' THEN 'BUDSC'" ).append("\n"); 
		query.append("       ELSE DEL.FINC_CTRL_OFC_CD" ).append("\n"); 
		query.append("  END AS DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN ORT.OFC_CD = 'BUDSC' AND POD.LOC_CD IN ('DEHAM', 'NLRTM', 'SIKOP') THEN ORT.AR_OFC_CD" ).append("\n"); 
		query.append("       WHEN POD.FINC_CTRL_OFC_CD = 'GLWBA' THEN OOD.AR_OFC_CD" ).append("\n"); 
		query.append("       WHEN POD.FINC_CTRL_OFC_CD = 'BUDSC' THEN OOD.AR_OFC_CD" ).append("\n"); 
		query.append("       ELSE OEL.AR_OFC_CD" ).append("\n"); 
		query.append("  END AS DEL_AR_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN ORT.OFC_CD = 'BUDSC' AND POD.LOC_CD IN ('DEHAM', 'NLRTM', 'SIKOP') THEN ORT.AP_OFC_CD" ).append("\n"); 
		query.append("       WHEN POD.FINC_CTRL_OFC_CD = 'GLWBA' THEN OOD.AP_OFC_CD" ).append("\n"); 
		query.append("       WHEN POD.FINC_CTRL_OFC_CD = 'BUDSC' THEN OOD.AP_OFC_CD" ).append("\n"); 
		query.append("       ELSE OEL.AP_OFC_CD" ).append("\n"); 
		query.append("  END AS DEL_AP_OFC_CD," ).append("\n"); 
		query.append("  BKG.RCV_TERM_CD," ).append("\n"); 
		query.append("  BKG.DE_TERM_CD," ).append("\n"); 
		query.append("  BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("  BKG.BKG_OFC_CD AS BKG_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("  OBK.AR_OFC_CD AS BKG_AR_OFC_CD," ).append("\n"); 
		query.append("  OBK.LOC_CD AS BKG_OFC_LOC_CD," ).append("\n"); 
		query.append("  BKG.OB_SLS_OFC_CD AS BKG_SLS_OFC_CD," ).append("\n"); 
		query.append("  BKG.BKG_STS_CD," ).append("\n"); 
		query.append("  CASE WHEN BKG.BKG_CGO_TP_CD = 'B' OR BKG.BKG_CGO_TP_CD = 'R' OR BKG.BKG_CGO_TP_CD = 'F' THEN 'F'" ).append("\n"); 
		query.append("       ELSE 'M'" ).append("\n"); 
		query.append("  END AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  BKG.CMDT_CD," ).append("\n"); 
		query.append("  BKG.REP_CMDT_CD," ).append("\n"); 
		query.append("  NVL(BKG.BL_NO, ' ') AS BL_NO," ).append("\n"); 
		query.append("  NVL(BKG.DBL_BKG_FLG, 'N') AS DBL_BKG_FLG," ).append("\n"); 
		query.append("  NVL(BKG.SOC_FLG, 'N') AS BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("  NVL(TO_CHAR(BKG.BKG_CRE_DT, 'YYYYMMDD'), ' ') AS BKG_CRE_DT," ).append("\n"); 
		query.append("  CASE WHEN NVL(BKG.CHN_AGN_CD, ' ') = ' ' THEN ' '" ).append("\n"); 
		query.append("       ELSE SUBSTR(BKG.BKG_OFC_CD, 1, 3) || BKG.CHN_AGN_CD" ).append("\n"); 
		query.append("  END AS BKG_OFC_AGN_CD," ).append("\n"); 
		query.append("  NVL(BKG.DCGO_FLG, 'N') AS SPCL_DG_CGO_FLG," ).append("\n"); 
		query.append("  NVL(BKG.RC_FLG, 'N') AS SPCL_RC_FLG," ).append("\n"); 
		query.append("  NVL(BKG.AWK_CGO_FLG, 'N') AS SPCL_AWK_CGO_FLG," ).append("\n"); 
		query.append("  NVL(BKG.BB_CGO_FLG, 'N') AS SPCL_BB_CGO_FLG," ).append("\n"); 
		query.append("  NVL(BKG.PRE_RLY_PORT_CD, '*') AS PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("  NVL(BKG.PST_RLY_PORT_CD, '*') AS PST_RLY_PORT_CD," ).append("\n"); 
		query.append("  NVL(BRT.CLT_OFC_CD, '*') AS BSL_DEL_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN BRT.CLT_OFC_CD = 'BSLBA' THEN ORT.AR_OFC_CD" ).append("\n"); 
		query.append("       ELSE BRT.CLT_OFC_CD" ).append("\n"); 
		query.append("  END AS BSL_DEL_AR_OFC_CD," ).append("\n"); 
		query.append("  CASE WHEN BRT.CLT_OFC_CD = 'BSLBA' THEN ORT.AP_OFC_CD" ).append("\n"); 
		query.append("       ELSE BRT.CLT_OFC_CD" ).append("\n"); 
		query.append("  END AS BSL_DEL_AP_OFC_CD," ).append("\n"); 
		query.append("  BKG.CTRT_OFC_CD," ).append("\n"); 
		query.append("  BKG.SC_NO," ).append("\n"); 
		query.append("  BKG.RFA_NO," ).append("\n"); 
		query.append("  BKG.SVC_SCP_CD AS BKG_SVC_SCP_CD," ).append("\n"); 
		query.append("  CASE WHEN BKG.SVC_SCP_CD IS NULL THEN '1'" ).append("\n"); 
		query.append("       ELSE '0'" ).append("\n"); 
		query.append("  END AS SVC_SCP_CHECK," ).append("\n"); 
		query.append("  (SELECT NVL(BBL.BL_CVRD_TP_CD, 'N')" ).append("\n"); 
		query.append("   FROM BKG_BL_DOC BBL" ).append("\n"); 
		query.append("   WHERE BBL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("  ) AS COVERED_CHECK," ).append("\n"); 
		query.append("  CST.*" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_RATE BRT," ).append("\n"); 
		query.append("  MDM_LOCATION POR," ).append("\n"); 
		query.append("  MDM_LOCATION POL," ).append("\n"); 
		query.append("  MDM_LOCATION POD," ).append("\n"); 
		query.append("  MDM_LOCATION DEL," ).append("\n"); 
		query.append("  MDM_ORGANIZATION OBK," ).append("\n"); 
		query.append("  MDM_ORGANIZATION OOR," ).append("\n"); 
		query.append("  MDM_ORGANIZATION OOL," ).append("\n"); 
		query.append("  MDM_ORGANIZATION OOD," ).append("\n"); 
		query.append("  MDM_ORGANIZATION OEL," ).append("\n"); 
		query.append("  MDM_ORGANIZATION ORT," ).append("\n"); 
		query.append("  (SELECT CST.BKG_NO," ).append("\n"); 
		query.append("     CST.SHPR_CNT_CD," ).append("\n"); 
		query.append("     CST.SHPR_CUST_SEQ," ).append("\n"); 
		query.append("     CST.FF_CNT_CD," ).append("\n"); 
		query.append("     CST.FF_CUST_SEQ," ).append("\n"); 
		query.append("     CST.BKG_FF_CNT_CD," ).append("\n"); 
		query.append("     CST.BKG_FF_SEQ," ).append("\n"); 
		query.append("     CASE WHEN CST.FMC_NO IS NOT NULL THEN CST.FMC_NO" ).append("\n"); 
		query.append("          WHEN CST.FMC_NO_MDM IS NOT NULL THEN CST.FMC_NO_MDM" ).append("\n"); 
		query.append("          ELSE CST.FMC_NO_MDM" ).append("\n"); 
		query.append("     END AS FMC_NO," ).append("\n"); 
		query.append("     CASE WHEN TRIM(CST.FMC_NO) IS NOT NULL OR TRIM(CST.FMC_NO_MDM) IS NOT NULL OR TRIM(CST.FMC_NO_PREV) IS NOT NULL THEN '0'" ).append("\n"); 
		query.append("          ELSE '1'" ).append("\n"); 
		query.append("     END AS FF_FMC_CHECK_FLAG," ).append("\n"); 
		query.append("     CST.REFERENCE_NO," ).append("\n"); 
		query.append("     CST.SH_FF_CHECK_FLAG," ).append("\n"); 
		query.append("     CST.FF_CHECK" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("     SELECT BCS.BKG_NO," ).append("\n"); 
		query.append("       NVL(BCS.CUST_CNT_CD, '*') AS SHPR_CNT_CD," ).append("\n"); 
		query.append("       NVL(TO_CHAR(BCS.CUST_SEQ, 'FM000000'), '*') AS SHPR_CUST_SEQ," ).append("\n"); 
		query.append("       NVL(BC2.CUST_CNT_CD, '*') AS FF_CNT_CD," ).append("\n"); 
		query.append("       NVL(TO_CHAR(BC2.CUST_SEQ, 'FM000000'), '*') AS FF_CUST_SEQ," ).append("\n"); 
		query.append("       NVL(BC2.CUST_CNT_CD, '*') AS BKG_FF_CNT_CD," ).append("\n"); 
		query.append("       NVL(TO_CHAR(BC2.CUST_SEQ, 'FM000000'), '*') AS BKG_FF_SEQ," ).append("\n"); 
		query.append("       (SELECT MAX(CUST_REF_NO_CTNT)" ).append("\n"); 
		query.append("        FROM BKG_REFERENCE FMC" ).append("\n"); 
		query.append("        WHERE FMC.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("          AND FMC.BKG_REF_TP_CD = 'FMCN'" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS FMC_NO," ).append("\n"); 
		query.append("       (SELECT MCS.FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append("        FROM MDM_CUSTOMER MCS" ).append("\n"); 
		query.append("        WHERE MCS.CUST_CNT_CD = BC2.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND MCS.CUST_SEQ = BC2.CUST_SEQ" ).append("\n"); 
		query.append("          AND MCS.RVIS_CNTR_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS FMC_NO_MDM," ).append("\n"); 
		query.append("       (SELECT INF.FMC_NO" ).append("\n"); 
		query.append("        FROM ACM_AGN_BKG_INFO INF" ).append("\n"); 
		query.append("        WHERE INF.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("       ) AS FMC_NO_PREV," ).append("\n"); 
		query.append("       NVL(BC2.REF_NO, '*') AS REFERENCE_NO," ).append("\n"); 
		query.append("       CASE BCS.CUST_CNT_CD || BCS.CUST_SEQ WHEN BC2.CUST_CNT_CD || BC2.CUST_SEQ THEN 1" ).append("\n"); 
		query.append("                                            ELSE 0" ).append("\n"); 
		query.append("       END AS SH_FF_CHECK_FLAG," ).append("\n"); 
		query.append("       CASE WHEN LTRIM(BC2.CUST_CNT_CD) IS NULL THEN 1" ).append("\n"); 
		query.append("            WHEN LTRIM(BC2.CUST_SEQ) IS NULL THEN 1" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS FF_CHECK" ).append("\n"); 
		query.append("     FROM BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("       BKG_CUSTOMER BC2" ).append("\n"); 
		query.append("     WHERE BCS.BKG_NO = BC2.BKG_NO(+)" ).append("\n"); 
		query.append("       AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       AND BC2.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("       AND BCS.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   ) CST" ).append("\n"); 
		query.append("  ) CST" ).append("\n"); 
		query.append("WHERE BKG.POR_CD = POR.LOC_CD" ).append("\n"); 
		query.append("  AND BKG.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("  AND BKG.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("  AND BKG.DEL_CD = DEL.LOC_CD" ).append("\n"); 
		query.append("  AND BKG.BKG_OFC_CD = OBK.OFC_CD(+)" ).append("\n"); 
		query.append("  AND POR.FINC_CTRL_OFC_CD = OOR.OFC_CD(+)" ).append("\n"); 
		query.append("  AND POL.FINC_CTRL_OFC_CD = OOL.OFC_CD(+)" ).append("\n"); 
		query.append("  AND POD.FINC_CTRL_OFC_CD = OOD.OFC_CD(+)" ).append("\n"); 
		query.append("  AND DEL.FINC_CTRL_OFC_CD = OEL.OFC_CD(+)" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = BRT.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BRT.CLT_OFC_CD = ORT.OFC_CD(+) " ).append("\n"); 
		query.append("  AND BKG.BKG_NO = CST.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}