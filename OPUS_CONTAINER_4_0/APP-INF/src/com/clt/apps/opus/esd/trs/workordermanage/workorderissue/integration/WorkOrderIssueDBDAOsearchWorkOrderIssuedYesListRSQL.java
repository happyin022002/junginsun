/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderIssuedYesList
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_radio",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_cost_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_svc_provider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BIL_CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchWorkOrderIssuedYesListRSQL").append("\n"); 
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
		query.append("SELECT T.*" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.KGS_WGT_STR, '[^|]+', 1, 4) VGM_KGS_WGT " ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.KGS_WGT_STR, '[^|]+', 1, 1) KGS_NET_WGT" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.KGS_WGT_STR, '[^|]+', 1, 2) KGS_TARE_WGT" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.KGS_WGT_STR, '[^|]+', 1, 3) KGS_GROSS_WGT" ).append("\n"); 
		query.append("	  ,REGEXP_SUBSTR(T.LBS_WGT_STR, '[^|]+', 1, 4) VGM_LBS_WGT" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.LBS_WGT_STR, '[^|]+', 1, 1) LBS_NET_WGT" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.LBS_WGT_STR, '[^|]+', 1, 2) LBS_TARE_WGT" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.LBS_WGT_STR, '[^|]+', 1, 3) LBS_GROSS_WGT     " ).append("\n"); 
		query.append("	  ,VNDR_CM AS VNDR_CM_IMG" ).append("\n"); 
		query.append("      ,DECODE(T.TRSP_SO_TP_CD, 'M', T.INTER_RMK, 'H', T.INTER_RMK, DECODE(T.INTER_RMK_CHK, '', '', 'Y')) AS INTER_RMK" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.PKUP_INFO, '[^^]+', 1, 1) AS CNTR_PKUP_NO" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.FOC, '[^|]+', 1, 1) AS CGO_FRT_RCV_IND_FLG" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.FOC, '[^|]+', 1, 2) AS CGO_OBL_RCV_IND_FLG" ).append("\n"); 
		query.append("      ,REGEXP_SUBSTR(T.FOC, '[^|]+', 1, 3) AS CGO_CSTMS_CLR_IND_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN T.CONTI_CD = 'E' AND  T.TRSP_BND_CD = 'I' AND (REGEXP_SUBSTR(T.FOC, '[^|]', 1, 1) = 'N' OR REGEXP_SUBSTR(T.FOC, '[^|]', 1, 2) = 'N') THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END FO_FLG" ).append("\n"); 
		query.append("	  ,T.CNG_IND_FLG AS CNG_IND_FLG_IMG" ).append("\n"); 
		query.append("      ,CASE WHEN CONTI_CD = 'E' AND TRSP_BND_CD = 'I' AND TRSP_CRR_MOD_NM = 'TD' THEN DO_HLD_FLG" ).append("\n"); 
		query.append("			ELSE 'N'" ).append("\n"); 
		query.append("       END DO_HLD_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			TO_CHAR(NVL(RCL.MNL_SET_DT,RCL.SYS_SET_DT), 'YYYY-MM-DD HH24:MI:SS') R_CCT," ).append("\n"); 
		query.append("			TO_CHAR(NVL(PCL.MNL_SET_DT,PCL.SYS_SET_DT), 'YYYY-MM-DD HH24:MI:SS') T_CCT," ).append("\n"); 
		query.append("			'Y' WO_ISSUED," ).append("\n"); 
		query.append("			CASE WHEN WO_RJCT_FLG = 'Y' THEN '1' ELSE '0' END REJECTED_CHECK ," ).append("\n"); 
		query.append("		    DECODE((SELECT COUNT(*) FROM TRS_EDI_USA_RCV_MSG VDCM WHERE VDCM.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD AND VDCM.TRSP_SO_SEQ = A.TRSP_SO_SEQ AND VDCM.RCV_MSG_STS_CD IS NULL), 0, 'N', 'Y') VNDR_CM,			" ).append("\n"); 
		query.append("			NVL((SELECT CNG_IND_FLG FROM TRS_TRSP_SVC_ORD_CNG ZZ WHERE ZZ.TRSP_SO_OFC_CTY_CD= A.TRSP_SO_OFC_CTY_CD AND ZZ.TRSP_SO_SEQ = A.TRSP_SO_SEQ AND ZZ.TRSP_SO_SUB_SEQ = 1 AND ZZ.BKG_NO = A.BKG_NO), 'N') CNG_IND_FLG," ).append("\n"); 
		query.append("            CASE WHEN A.TRSP_SO_TP_CD || A.TRSP_COST_DTL_MOD_CD IN ('YCY', 'YLS', 'YTS') AND SCE.CNTR_NO IS NOT NULL AND A.EQ_NO IS NULL THEN DECODE(SCE.CNTR_NO, 'COMU0000000', '', 'Y')" ).append("\n"); 
		query.append("                 ELSE  ''" ).append("\n"); 
		query.append("            END COP_FLG,         " ).append("\n"); 
		query.append("            CASE WHEN A.TRSP_SO_TP_CD || A.TRSP_COST_DTL_MOD_CD IN ('YCY', 'YLS', 'YTS') AND SCE.CNTR_NO IS NOT NULL AND A.EQ_NO IS NULL THEN DECODE(SCE.CNTR_NO, 'COMU0000000', '', SCE.CNTR_NO)" ).append("\n"); 
		query.append("                 ELSE A.EQ_NO" ).append("\n"); 
		query.append("            END EQ_NO, " ).append("\n"); 
		query.append("			A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("            (SELECT MAX(RF.PWR_SPL_CBL_FLG)" ).append("\n"); 
		query.append("               FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("              WHERE A.BKG_NO = RF.BKG_NO" ).append("\n"); 
		query.append("                AND RF.RC_SEQ = DECODE(A.CONTI_CD, 'E', NVL((SELECT ET.RC_SEQ FROM BKG_EUR_TRO ET WHERE ET.BKG_NO = A.BKG_NO AND ET.TRO_SEQ = A.TRO_SEQ AND ET.RC_SEQ IS NOT NULL AND ROWNUM = 1), RF.RC_SEQ), RF.RC_SEQ)" ).append("\n"); 
		query.append("                AND A.EQ_TPSZ_CD = RF.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                AND NVL(A.EQ_NO, 'XX') = DECODE(A.CONTI_CD, 'E', NVL(RF.CNTR_NO, 'XX'), RF.CNTR_NO)" ).append("\n"); 
		query.append("                AND NVL(A.SPCL_CGO_CNTR_TP_CD, 'XX') = DECODE(A.CONTI_CD, 'E', NVL(A.SPCL_CGO_CNTR_TP_CD, 'XX'), 'RF')) PWR_SPL_CBL_FLG," ).append("\n"); 
		query.append("			A.EQ_KND_CD," ).append("\n"); 
		query.append("			CASE WHEN A.TRSP_BND_CD = 'I' THEN (SELECT ECC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(A.TO_NOD_CD, 1, 5)) AND ROWNUM = 1)" ).append("\n"); 
		query.append("			ELSE (SELECT ECC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(A.FM_NOD_CD, 1, 5)) AND ROWNUM = 1)" ).append("\n"); 
		query.append("			END AS ECC_CD," ).append("\n"); 
		query.append("			A.CGO_TP_CD ," ).append("\n"); 
		query.append("			COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00748', A.CGO_TP_CD) AS CGO_TP_NM ," ).append("\n"); 
		query.append("			A.TRSP_COST_DTL_MOD_CD ," ).append("\n"); 
		query.append("			COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00594', A.TRSP_COST_DTL_MOD_CD) AS TRSP_COST_DTL_MOD_NM," ).append("\n"); 
		query.append("			A.TRSP_SO_CMB_SEQ ," ).append("\n"); 
		query.append("			A.TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("			COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00283', A.TRSP_CRR_MOD_CD) AS TRSP_CRR_MOD_NM ," ).append("\n"); 
		query.append("			SUBSTR(A.FM_NOD_CD, 1, 5) FM_LOC_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.FM_NOD_CD, 6, 2) FM_YARD_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.TO_NOD_CD, 1, 5) TO_LOC_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.TO_NOD_CD, 6, 2) TO_YARD_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.DOR_NOD_CD, 1, 5) DOR_LOC_VALUE ," ).append("\n"); 
		query.append("			SUBSTR(A.DOR_NOD_CD, 6, 2) DOR_YARD_VALUE ," ).append("\n"); 
		query.append("			DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', A.CUST_CNT_CD||A.CUST_SEQ, '') AS CUST_CNT_CD_SEQ," ).append("\n"); 
		query.append("			A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ  AS ACT_CUST_CD ," ).append("\n"); 
		query.append("			A.CUST_NOMI_TRKR_FLG ," ).append("\n"); 
		query.append("			A.CUST_CNT_CD ," ).append("\n"); 
		query.append("			A.CUST_SEQ ," ).append("\n"); 
		query.append("			A.DOR_DE_ADDR ," ).append("\n"); 
		query.append("			A.MLT_STOP_DE_FLG ," ).append("\n"); 
		query.append("            CASE WHEN A.CONTI_CD = 'M' THEN (SELECT NVL(RLSE.FRT_CLT_FLG, 'N') || '|' || NVL(RLSE.OBL_RDEM_FLG, 'N') || '|' || NVL(RLSE.CSTMS_CLR_CD, 'N') FROM BKG_CGO_RLSE RLSE WHERE A.BL_NO = RLSE.BL_NO(+))" ).append("\n"); 
		query.append("                 ELSE (SELECT NVL((SELECT MIN(DECODE(SA.CR_MK_FLG, 'Y', 'Y', NVL(DECODE(NVL(BK.BL_TP_CD, 'N'), 'W', 'Y', DECODE(NVL(BL.OBL_SRND_FLG, 'N'), 'Y', 'Y')), DECODE(SA.STL_FLG, 'Y', 'Y', 'N'))))" ).append("\n"); 
		query.append("                                     FROM SAR_OTS_HDR SA" ).append("\n"); 
		query.append("                                         ,BKG_BL_ISS  BL" ).append("\n"); 
		query.append("                                         ,BKG_BOOKING BK" ).append("\n"); 
		query.append("                                    WHERE SA.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                      AND SA.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("                                      AND BL.BKG_NO = BK.BKG_NO), 'N') || '|' ||" ).append("\n"); 
		query.append("                              NVL((SELECT NVL(DECODE(NVL(BK.BL_TP_CD, 'N'), 'W', 'Y', DECODE(NVL(BL.OBL_SRND_FLG, 'N'), 'Y', 'Y')), BL.OBL_RDEM_FLG) OBL_RDEM_FLG" ).append("\n"); 
		query.append("                                     FROM BKG_BL_ISS  BL" ).append("\n"); 
		query.append("                                         ,BKG_BOOKING BK" ).append("\n"); 
		query.append("                                    WHERE BL.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                      AND A.BKG_NO = BK.BKG_NO), 'N') || '|' || 'N'" ).append("\n"); 
		query.append("                         FROM DUAL)" ).append("\n"); 
		query.append("            END FOC ," ).append("\n"); 
		query.append("		    CASE WHEN A.TRSP_BND_CD = 'O' AND A.CONTI_CD = 'M' AND A.TRSP_COST_DTL_MOD_CD <> 'DR' THEN" ).append("\n"); 
		query.append("					(SELECT PKUP_EDI_322_NO || '^^^'" ).append("\n"); 
		query.append("					 FROM (SELECT  G.BKG_EDI_322_NO" ).append("\n"); 
		query.append("								  ,G.EQ_NO" ).append("\n"); 
		query.append("								  ,G.DEST_LOC_NM" ).append("\n"); 
		query.append("								  ,G.PKUP_EDI_322_NO" ).append("\n"); 
		query.append("								  ,ROW_NUMBER() OVER(partition BY G.EQ_NO, G.BKG_EDI_322_NO, G.DEST_LOC_NM order by G.EVNT_DT DESC, G.EQ_NO DESC, G.EDI_322_STS_CD DESC) RK" ).append("\n"); 
		query.append("							  FROM EDI_322_MSG G) P1" ).append("\n"); 
		query.append("					WHERE P1.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("					  AND P1.BKG_EDI_322_NO = A.BKG_NO" ).append("\n"); 
		query.append("					  AND P1.DEST_LOC_NM = A.FM_NOD_CD" ).append("\n"); 
		query.append("					  AND P1.RK = 1" ).append("\n"); 
		query.append("					  AND ROWNUM=1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				 ELSE TRS_GET_PKUP_NO_FNC(A.BKG_NO, A.EQ_NO, '', '', '', A.FM_NOD_CD)	  " ).append("\n"); 
		query.append("		    END PKUP_INFO ,    				" ).append("\n"); 
		query.append("			A.CNTR_WGT ," ).append("\n"); 
		query.append("			NVL(A.WGT_MEAS_UT_CD, 'LBS') AS WGT_UT_CD," ).append("\n"); 
		query.append("			TRS_GET_COM_SO_RAIL_WGT_FNC('S', A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, NULL, A.BKG_NO, A.EQ_NO, A.EQ_TPSZ_CD, 'KGS', A.COP_NO, 'Y') KGS_WGT_STR," ).append("\n"); 
		query.append("			TRS_GET_COM_SO_RAIL_WGT_FNC('S', A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, NULL, A.BKG_NO, A.EQ_NO, A.EQ_TPSZ_CD, 'LBS', A.COP_NO, 'Y') LBS_WGT_STR," ).append("\n"); 
		query.append("			A.SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("			CASE WHEN D.DCGO_FLG ='Y' THEN 'DG' WHEN D.BB_CGO_FLG ='Y' THEN 'BB' WHEN D.AWK_CGO_FLG='Y' THEN 'AK' WHEN D.RC_FLG ='Y' THEN 'RF' WHEN D.RD_CGO_FLG ='Y' THEN 'RD' ELSE '' END BKGSPE ," ).append("\n"); 
		query.append("			' ' MORE_CANDIDATES ," ).append("\n"); 
		query.append("			A.TRSP_RQST_ORD_REV_AMT REVENUE ," ).append("\n"); 
		query.append("			A.REV_CURR_CD ," ).append("\n"); 
		query.append("			A.N3PTY_BIL_FLG ," ).append("\n"); 
		query.append("			A.BKG_NO BKG_NO ," ).append("\n"); 
		query.append("			A.BL_NO BL_NO ," ).append("\n"); 
		query.append("			A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD ," ).append("\n"); 
		query.append("			A.SLAN_CD LANE ," ).append("\n"); 
		query.append("			FDR_VSL_CD||FDR_SKD_VOY_NO||FDR_SKD_DIR_CD FDR_VVD ," ).append("\n"); 
		query.append("			NVL(A.DTN_USE_FLG, 'N') DTN_USE_FLG ," ).append("\n"); 
		query.append("			NVL(A.WO_BL_NO_ISS_FLG, 'N') WO_BL_NO_ISS_FLG ," ).append("\n"); 
		query.append("			TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') SO_CRE_DT ," ).append("\n"); 
		query.append("			TO_CHAR(WRK.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') WO_ISSUE_DT ," ).append("\n"); 
		query.append("			'' WO_RJCT_DT," ).append("\n"); 
		query.append("    		DECODE((SELECT MAX(RMK.BKG_NO)" ).append("\n"); 
		query.append("	   				FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("	  				WHERE RMK.BKG_NO IN (A.BKG_NO, 'DUM000000000')" ).append("\n"); 
		query.append("					AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, A.EQ_NO, 'X')" ).append("\n"); 
		query.append("					AND NVL(RMK.TRSP_SO_OFC_CTY_CD, 'XX') = NVL2(RMK.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_OFC_CTY_CD, 'XX')" ).append("\n"); 
		query.append("					AND NVL(RMK.TRSP_SO_SEQ, '99999') = NVL2(RMK.TRSP_SO_SEQ, A.TRSP_SO_SEQ, '99999')" ).append("\n"); 
		query.append("					AND NVL(RMK.DELT_FLG, 'X') = 'N'), '', '', 'Y') AS INTER_RMK_CHK ," ).append("\n"); 
		query.append("            A.INTER_RMK ," ).append("\n"); 
		query.append("            DECODE(A.TRSP_SO_TP_CD, 'M', '', 'H', '', 'O', '', '1') INTER_RMK_IMG ," ).append("\n"); 
		query.append("			A.SPCL_INSTR_RMK ," ).append("\n"); 
		query.append("			WRK.WO_RMK ," ).append("\n"); 
		query.append("			NVL((SELECT 'Y' FROM CIM_CNTR_STK STK WHERE A.TRSP_SO_OFC_CTY_CD = STK.SO_OFC_CTY_CD AND A.TRSP_SO_SEQ = STK.SO_SEQ GROUP BY SO_SEQ),'N') MTY_RR_FLG," ).append("\n"); 
		query.append("			A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ AS TRSP_SO_OFC_CTY_CD_SEQ ," ).append("\n"); 
		query.append("			A.TRSP_SO_OFC_CTY_CD ," ).append("\n"); 
		query.append("			A.TRSP_SO_SEQ ," ).append("\n"); 
		query.append("			A.TRSP_SO_SEQ AS surcharge_key," ).append("\n"); 
		query.append("			A.TRSP_SO_TP_CD ," ).append("\n"); 
		query.append("			A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ ," ).append("\n"); 
		query.append("			A.TRSP_WO_OFC_CTY_CD ," ).append("\n"); 
		query.append("			A.TRSP_WO_SEQ ," ).append("\n"); 
		query.append("			A.CRE_OFC_CD ," ).append("\n"); 
		query.append("			TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') CRE_DT ," ).append("\n"); 
		query.append("			DECODE(VNDR.DELT_FLG, 'Y', '', A.VNDR_SEQ) AS VNDR_SEQ," ).append("\n"); 
		query.append("			DECODE(VNDR.DELT_FLG, 'Y', '', A.VNDR_SEQ) AS PRESET_VNDR_SEQ ," ).append("\n"); 
		query.append("			DECODE(VNDR.DELT_FLG, 'Y', '', VNDR.VNDR_LGL_ENG_NM) AS VNDR_NM ," ).append("\n"); 
		query.append("			NVL(VNDR.WO_EDI_USE_FLG, 'N') WO_EDI_USE_FLG ," ).append("\n"); 
		query.append("			A.TRSP_DFLT_VNDR_FLG AS DEFAULT_SP_FLG ," ).append("\n"); 
		query.append("			NVL(A.TRSP_FRST_FLG , 'N') TRSP_FRST_FLG ," ).append("\n"); 
		query.append("			A.TRSP_RJCT_RSN_CD ," ).append("\n"); 
		query.append("			A.TRSP_RQST_BKG_FLG ," ).append("\n"); 
		query.append("			A.TRSP_SO_CMB_TP_CD ," ).append("\n"); 
		query.append("			A.TRSP_BND_CD ," ).append("\n"); 
		query.append("            A.CONTI_CD ," ).append("\n"); 
		query.append("			A.CMDT_CD ," ).append("\n"); 
		query.append("			A.FM_NOD_CD ," ).append("\n"); 
		query.append("			DECODE(LENGTH(A.FM_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(A.FM_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.FM_NOD_CD)) FM_NOD_CD_NM," ).append("\n"); 
		query.append("			A.VIA_NOD_CD ," ).append("\n"); 
		query.append("			DECODE(LENGTH(A.VIA_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(A.VIA_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.VIA_NOD_CD)) VIA_NOD_CD_NM," ).append("\n"); 
		query.append("			A.DOR_NOD_CD ," ).append("\n"); 
		query.append("			DECODE(LENGTH(A.DOR_NOD_CD), 7, (SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = A.DOR_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.DOR_NOD_CD)) AS DOR_NOD_CD_NM," ).append("\n"); 
		query.append("			A.TO_NOD_CD," ).append("\n"); 
		query.append("			DECODE(LENGTH(A.TO_NOD_CD), 7, TRS_COMMON_PKG.GET_YD_CD_NM_FNC(A.TO_NOD_CD), 5, (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.TO_NOD_CD)) TO_NOD_CD_NM," ).append("\n"); 
		query.append("			CASE WHEN TRSP_SO_CMB_TP_CD = 'BD' THEN COUNT(A.TRSP_SO_SEQ) OVER (PARTITION BY TRSP_SO_CMB_TP_CD, TRSP_SO_CMB_SEQ) ELSE 1 END BUNDLING_NO ," ).append("\n"); 
		query.append("			NVL(A.CURR_CD, @[BIL_CURR_CD]) AS CURR_CD," ).append("\n"); 
		query.append("			NVL(A.WGT_MEAS_UT_CD, 'LBS')  WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("			NVL(A.ETC_ADD_AMT, 0) ETC_ADD_AMT," ).append("\n"); 
		query.append("			NVL(A.BZC_AMT, 0) BZC_AMT ," ).append("\n"); 
		query.append("			NVL(A.FUEL_SCG_AMT, 0) FUEL_SCG_AMT," ).append("\n"); 
		query.append("			NVL(A.NEGO_AMT, 0) NEGO_AMT ," ).append("\n"); 
		query.append("			ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(A.CURR_CD, (NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.ETC_ADD_AMT, 0)), TO_CHAR(SYSDATE, 'YYYYMM')), 2) AS WO_TOT_AMT_USD," ).append("\n"); 
		query.append("			'' WO_RJCT_INDCT ," ).append("\n"); 
		query.append("			DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', 'CNT', 'NYK') AS SP_TYPE ," ).append("\n"); 
		query.append("			A.TRSP_AGMT_RT_TP_CD ," ).append("\n"); 
		query.append("			COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00954',A.TRSP_AGMT_RT_TP_CD) AS TRSP_AGMT_RT_TP_NM," ).append("\n"); 
		query.append("			A.TRSP_AGMT_WY_TP_CD," ).append("\n"); 
		query.append("			DECODE(A.TRSP_SO_CMB_TP_CD, 'BS', 'Stack', 'BF', 'Flatbed', '') AS TRSP_SO_CMB_TP_NM," ).append("\n"); 
		query.append("			COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00279',A.TRSP_SO_TP_CD)	AS TRSP_SO_TP_NM," ).append("\n"); 
		query.append("            TO_CHAR(A.N1ST_NOD_PLN_DT, 'YYYY-MM-DD HH24:MI:SS') N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("            TO_CHAR(A.LST_NOD_PLN_DT,  'YYYY-MM-DD HH24:MI:SS') LST_NOD_PLN_DT," ).append("\n"); 
		query.append("            TO_CHAR(A.DOR_NOD_PLN_DT,  'YYYY-MM-DD HH24:MI:SS') DOR_NOD_PLN_DT," ).append("\n"); 
		query.append("			A.COP_NO," ).append("\n"); 
		query.append("			A.COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("			A.COST_ACT_GRP_CD COST_ACT_GRP_CD," ).append("\n"); 
		query.append("			DECODE (A.TRSP_COST_DTL_MOD_CD,'DR', DECODE (NVL (A.TRO_SEQ, ''),'', 'N','Y'),'') TRO_CNFM," ).append("\n"); 
		query.append("			DECODE(A.TRSP_COST_DTL_MOD_CD,'DR', A.TRO_SEQ, '') AS TRO_SEQ," ).append("\n"); 
		query.append("			(SELECT LISTAGG(DECODE(NVL(U.EQ_SUBST_CGO_QTY, 0), 0, U.CNTR_TPSZ_CD ||' '||U.OP_CNTR_QTY, U.CNTR_TPSZ_CD||' '||U.OP_CNTR_QTY ||'-SUB '||U.EQ_SUBST_CNTR_TPSZ_CD ||' '||U.EQ_SUBST_CGO_QTY ), ', ') WITHIN GROUP (ORDER BY U.BKG_NO)" ).append("\n"); 
		query.append("			   FROM BKG_QUANTITY U" ).append("\n"); 
		query.append("			  WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            ) AS BKG_QTY," ).append("\n"); 
		query.append("			A.IB_VVD_CD,																		 " ).append("\n"); 
		query.append("			A.OB_VVD_CD,																		 " ).append("\n"); 
		query.append("			A.REF_ID,																		 " ).append("\n"); 
		query.append("			NVL(USR1.USR_NM,A.CRE_USR_ID)	SO_CRE_NM," ).append("\n"); 
		query.append("			NVL(USR2.USR_NM,WRK.UPD_USR_ID)	WO_CRE_NM,															 " ).append("\n"); 
		query.append("			A.FCTRY_NM,					 " ).append("\n"); 
		query.append("			A.DOR_PST_CD,																	 " ).append("\n"); 
		query.append("			A.CNTC_PSON_PHN_NO,																 " ).append("\n"); 
		query.append("			A.CNTC_PSON_FAX_NO,																 " ).append("\n"); 
		query.append("			A.CNTC_PSON_NM,																	 " ).append("\n"); 
		query.append("			A.TRO_CFM_OFC_CD,																 " ).append("\n"); 
		query.append("			A.TRO_CFM_USR_ID,																 " ).append("\n"); 
		query.append("			TO_CHAR(A.TRO_CFM_UPD_DT, 'YYYY-MM-DD') AS TRO_CFM_UPD_DT,						 " ).append("\n"); 
		query.append("			TO_CHAR(A.TRO_CFM_UPD_DT, 'HH24:MI:SS') AS TRO_CFM_UPD_TM,						 " ).append("\n"); 
		query.append("			(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ') FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = A.BKG_NO AND CUST.BKG_CUST_TP_CD = 'S' ) AS SHPR_CUST_NM," ).append("\n"); 
		query.append("			(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ') FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = A.BKG_NO AND CUST.BKG_CUST_TP_CD = 'C' ) AS CNEE_CUST_NM," ).append("\n"); 
		query.append("			(SELECT REPLACE (CUST_NM, CHR (13) || CHR (10),' ') FROM BKG_CUSTOMER CUST WHERE CUST.BKG_NO = A.BKG_NO AND CUST.BKG_CUST_TP_CD = 'N' ) AS NTFY_CUST_NM," ).append("\n"); 
		query.append("			A.N3PTY_BIL_BZC_AMT	AS N3PTY_BZC_AMT,											 " ).append("\n"); 
		query.append("			A.N3PTY_VNDR_SEQ AS N3PTY_BZC_VNDR_SEQ,											 " ).append("\n"); 
		query.append("			A.N3PTY_OFC_CD AS N3PTY_BZC_OFC_CD,												 " ).append("\n"); 
		query.append("			A.N3PTY_DESC AS N3PTY_BZC_DESC,													 " ).append("\n"); 
		query.append("			A.N3PTY_CUST_SEQ AS N3PTY_BZC_CUST_SEQ,											 " ).append("\n"); 
		query.append("			A.N3PTY_CUST_CNT_CD AS N3PTY_BZC_CUST_CNT_CD,									 " ).append("\n"); 
		query.append("			A.N3PTY_BIL_TP_CD AS N3PTY_BZC_TP_CD," ).append("\n"); 
		query.append("			A.TRSP_AGMT_OFC_CTY_CD    PO_TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("			A.TRSP_AGMT_SEQ           PO_TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("			A.TRSP_AGMT_RT_TP_CD      PO_TRSP_AGMT_RT_TP_CD," ).append("\n"); 
		query.append("			A.TRSP_AGMT_WY_TP_CD      PO_WAY_TYPE," ).append("\n"); 
		query.append("			COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00954', A.TRSP_AGMT_RT_TP_CD)      PO_TRSP_AGMT_RT_TP_NM," ).append("\n"); 
		query.append("			DECODE(A.CUST_NOMI_TRKR_FLG, 'Y', 'CNT', 'NYK')      PO_SP_TYPE," ).append("\n"); 
		query.append("			A.CUST_NOMI_TRKR_FLG      PO_CUST_NOMI_TRKR_FLG," ).append("\n"); 
		query.append("			A.ACT_CUST_CNT_CD         PO_CUST_CNT_CD," ).append("\n"); 
		query.append("			A.ACT_CUST_SEQ            PO_CUST_SEQ," ).append("\n"); 
		query.append("			A.ACT_CUST_CNT_CD||ACT_CUST_SEQ    PO_CUST_CNT_CD_SEQ," ).append("\n"); 
		query.append("			A.CURR_CD                 PO_LOCAL_CURR_CD," ).append("\n"); 
		query.append("			NVL(A.BZC_AMT, 0)         PO_BASIC_RT," ).append("\n"); 
		query.append("			NVL(A.FUEL_SCG_AMT, 0)    PO_FUEL_SCG_RT," ).append("\n"); 
		query.append("			''                        PO_OVER_WGT_SCG_RT," ).append("\n"); 
		query.append("			NVL(A.BZC_AMT, 0) + NVL(A.FUEL_SCG_AMT,0) + NVL(A.NEGO_AMT,0) + NVL(A.ETC_ADD_AMT,0) AS     PO_LOCAL_CURR_TOT_AMT," ).append("\n"); 
		query.append("			ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC( A.CURR_CD, A.BZC_AMT+A.FUEL_SCG_AMT+A.NEGO_AMT+A.ETC_ADD_AMT, TO_CHAR(WRK.CRE_DT, 'YYYYMM' ) ), 2)  PO_USD_CURR_TOT_AMT," ).append("\n"); 
		query.append("			''                        PO_RTN_CD," ).append("\n"); 
		query.append("			''                        PO_RTN_MSG," ).append("\n"); 
		query.append("			A.TRS_SUB_STS_CD   TRS_SUB_STS_CD," ).append("\n"); 
		query.append("			WRK.WO_ISS_STS_CD," ).append("\n"); 
		query.append("            MCNT.CNMV_STS_CD AS CNMV_STS_CD," ).append("\n"); 
		query.append("            MCNT.CRNT_YD_CD AS CRNT_YD_CD," ).append("\n"); 
		query.append("            TO_CHAR(MCNT.CNMV_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_DT," ).append("\n"); 
		query.append("		    NVL(A.TRSP_DFLT_VNDR_FLG, 'N') TRSP_DFLT_VNDR_FLG," ).append("\n"); 
		query.append("			DECODE(A.CGO_TP_CD, 'F', DECODE(B.BKG_STS_CD, 'W', 'W')) BKG_STS_CD," ).append("\n"); 
		query.append("			DECODE(A.CGO_TP_CD, 'F', DECODE(B.BKG_STS_CD, 'W', INTG.INTG_CD_VAL_DESC)) BKG_STS_CD_NM," ).append("\n"); 
		query.append("            A.CNTR_SLT_NO," ).append("\n"); 
		query.append("            DECODE(B.BKG_CGO_TP_CD,'R','Y','N') RVN_MPT_CNTR," ).append("\n"); 
		query.append("            DECODE((SELECT R.DO_HLD_FLG FROM BKG_DO_REF R WHERE R.BKG_NO(+) = A.BKG_NO)" ).append("\n"); 
		query.append("                   ,'Y'" ).append("\n"); 
		query.append("                   ,'Y'" ).append("\n"); 
		query.append("                   ,(SELECT NVL2(MAX(R1.BKG_NO),'Y','N') DO_HLD_FLG FROM BKG_IB_CGO_RLSE_HLD_CNTR R1 WHERE R1.BKG_NO(+) = A.BKG_NO AND R1.CNTR_NO(+) = A.EQ_NO)" ).append("\n"); 
		query.append("                  ) AS DO_HLD_FLG," ).append("\n"); 
		query.append("            A.SCG_IND_CD" ).append("\n"); 
		query.append("		FROM TRS_TRSP_SVC_ORD A ,  " ).append("\n"); 
		query.append("			BKG_BOOKING B , " ).append("\n"); 
		query.append("			BKG_CLZ_TM RCL," ).append("\n"); 
		query.append("			BKG_CLZ_TM PCL, " ).append("\n"); 
		query.append("			BKG_CONTAINER D ,  " ).append("\n"); 
		query.append("			MDM_VENDOR VNDR ,  " ).append("\n"); 
		query.append("			TRS_TRSP_WRK_ORD WRK," ).append("\n"); 
		query.append("			COM_USER USR1," ).append("\n"); 
		query.append("			COM_USER USR2," ).append("\n"); 
		query.append("            MST_CONTAINER MCNT," ).append("\n"); 
		query.append("			SCE_COP_HDR SCE," ).append("\n"); 
		query.append("			COM_INTG_CD_DTL INTG" ).append("\n"); 
		query.append("		#if(${ruoh} == 'Y')" ).append("\n"); 
		query.append("			,(SELECT EQ_NO" ).append("\n"); 
		query.append("                    ,NVL2(MST_COMMON_PKG.MST_RU_LBL_GET_FNC(EQ_NO), 'Y', 'N') RUOH_FLG" ).append("\n"); 
		query.append("                    ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                    ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("				FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("				WHERE EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("				AND EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("			 ) RUOH" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		WHERE A.BKG_NO =B.BKG_NO(+)  " ).append("\n"); 
		query.append("			AND A.BKG_NO =D.BKG_NO(+)  " ).append("\n"); 
		query.append("      		AND A.COP_NO = SCE.COP_NO(+)" ).append("\n"); 
		query.append("      		AND SCE.COP_STS_CD(+) IN ('C', 'T', 'F')" ).append("\n"); 
		query.append(" #if(${cop_flg} != '')" ).append("\n"); 
		query.append("		    AND (CASE WHEN SCE.CNTR_NO IS NOT NULL AND A.EQ_NO IS NULL AND A.TRSP_SO_TP_CD || A.TRSP_COST_DTL_MOD_CD IN( 'YCY', 'YLS', 'YTS') THEN DECODE(SCE.CNTR_NO, 'COMU0000000', '', 'Y') " ).append("\n"); 
		query.append("				     ELSE '' " ).append("\n"); 
		query.append("				END) = @[cop_flg]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("			AND A.BKG_NO = RCL.BKG_NO(+)" ).append("\n"); 
		query.append("			AND RCL.CLZ_TP_CD(+) = 'R'" ).append("\n"); 
		query.append("			AND A.BKG_NO = PCL.BKG_NO(+)" ).append("\n"); 
		query.append("			AND PCL.CLZ_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("			AND A.EQ_NO =D.CNTR_NO(+)  " ).append("\n"); 
		query.append("			AND A.VNDR_SEQ =VNDR.VNDR_SEQ (+)  " ).append("\n"); 
		query.append("			AND A.TRSP_WO_OFC_CTY_CD =WRK.TRSP_WO_OFC_CTY_CD (+)  " ).append("\n"); 
		query.append("			AND A.TRSP_WO_SEQ =WRK.TRSP_WO_SEQ (+)  " ).append("\n"); 
		query.append("			AND NVL(A.DELT_FLG, 'N') = 'N'  " ).append("\n"); 
		query.append("			AND A.INV_NO IS NULL" ).append("\n"); 
		query.append("			AND	A.CRE_USR_ID					=USR1.USR_ID (+)" ).append("\n"); 
		query.append("			AND	WRK.CRE_USR_ID                	=USR2.USR_ID (+)" ).append("\n"); 
		query.append("			AND WRK.WO_ISS_STS_CD <> 'X'" ).append("\n"); 
		query.append("            AND A.EQ_NO = MCNT.CNTR_NO(+)" ).append("\n"); 
		query.append("          #if(${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("            AND MCNT.CNMV_STS_CD = @[cnmv_sts_cd] " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if(${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("            AND MCNT.CRNT_YD_CD = @[crnt_yd_cd] " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("			AND B.BKG_STS_CD = INTG.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("			AND INTG.INTG_CD_ID(+) = 'CD00769'" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("        -- 2015.07.20	CHAN WOO PARK" ).append("\n"); 
		query.append("        -- User ID 검색조건 추가" ).append("\n"); 
		query.append("        #if(${user_id} != '')" ).append("\n"); 
		query.append("            AND WRK.CRE_USR_ID = @[user_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($cntr_slt_no.size() > 0)" ).append("\n"); 
		query.append("		-- 2016.02.02 CHAN WOO PARK" ).append("\n"); 
		query.append("        -- Slot Reference No 검색조건 추가" ).append("\n"); 
		query.append("		AND A.CNTR_SLT_NO IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${cntr_slt_no})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${wo_iss_sts_cd} != '')" ).append("\n"); 
		query.append("			AND WRK.WO_ISS_STS_CD = @[wo_iss_sts_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${dor_arr_dt} != '')" ).append("\n"); 
		query.append("			AND A.DOR_NOD_PLN_DT BETWEEN TO_DATE(@[dor_arr_dt]||NVL(@[dor_arr_tm], '0000')||'00', 'YYYYMMDDHH24MISS') AND TO_DATE(@[dor_arr_dt]||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($dor_pst_cd.size() > 0)" ).append("\n"); 
		query.append("			AND A.DOR_PST_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${dor_pst_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($fm_lcc_cd.size() > 0)" ).append("\n"); 
		query.append("		-- 2015.02.04    Hyungwook Choi" ).append("\n"); 
		query.append("			AND (SELECT LCC_CD" ).append("\n"); 
		query.append("				   FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("				  WHERE SCC_CD = (SELECT SCC_CD" ).append("\n"); 
		query.append("									FROM MDM_LOCATION" ).append("\n"); 
		query.append("								   WHERE LOC_CD = SUBSTR(A.FM_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("					AND ROWNUM = 1) IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${fm_lcc_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($to_lcc_cd.size() > 0)" ).append("\n"); 
		query.append("		-- 2015.02.04    Hyungwook Choi" ).append("\n"); 
		query.append("			AND (SELECT LCC_CD" ).append("\n"); 
		query.append("				   FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("				  WHERE SCC_CD = (SELECT SCC_CD" ).append("\n"); 
		query.append("									FROM MDM_LOCATION" ).append("\n"); 
		query.append("								   WHERE LOC_CD = SUBSTR(A.TO_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("					AND ROWNUM = 1) IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${to_lcc_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($ecc_cd.size() > 0)" ).append("\n"); 
		query.append("		-- 2015.02.05    Hyungwook Choi" ).append("\n"); 
		query.append("			AND CASE WHEN A.TRSP_BND_CD = 'I' THEN " ).append("\n"); 
		query.append("					( SELECT ECC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("					  WHERE SCC_CD = (SELECT SCC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("									  WHERE LOC_CD = SUBSTR(A.TO_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("						AND ROWNUM = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				ELSE " ).append("\n"); 
		query.append("					( SELECT ECC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("					  WHERE SCC_CD = (SELECT SCC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("									  WHERE LOC_CD = SUBSTR(A.FM_NOD_CD, 1, 5))" ).append("\n"); 
		query.append("					   AND ROWNUM = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				END IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${ecc_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($input_office.size() > 0)" ).append("\n"); 
		query.append("			AND WRK.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${input_office})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${ruoh} == 'Y')" ).append("\n"); 
		query.append("            AND A.TRSP_SO_OFC_CTY_CD = RUOH.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("            AND A.TRSP_SO_SEQ = RUOH.TRSP_SO_SEQ" ).append("\n"); 
		query.append("			AND A.EQ_NO = RUOH.EQ_NO" ).append("\n"); 
		query.append("			AND RUOH.RUOH_FLG = 'Y'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		-- Searching Conditions - 20141118    Hyungwook Choi" ).append("\n"); 
		query.append("		---------------------W/O Issued Yes --------------------------" ).append("\n"); 
		query.append("			AND (A.TRSP_WO_OFC_CTY_CD,A.TRSP_WO_SEQ) IN (				" ).append("\n"); 
		query.append("					SELECT IN_SVC.TRSP_WO_OFC_CTY_CD, IN_SVC.TRSP_WO_SEQ	" ).append("\n"); 
		query.append("					FROM TRS_TRSP_SVC_ORD IN_SVC	" ).append("\n"); 
		query.append("					,	 TRS_TRSP_WRK_ORD IN_WRK" ).append("\n"); 
		query.append("					,    TRS_TRSP_SVC_ORD_CNG CNG " ).append("\n"); 
		query.append("					WHERE 1=1					" ).append("\n"); 
		query.append("					AND	IN_SVC.DELT_FLG='N'" ).append("\n"); 
		query.append("					AND IN_SVC.TRSP_WO_OFC_CTY_CD 	= IN_WRK.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("					AND IN_SVC.TRSP_WO_SEQ			= IN_WRK.TRSP_WO_SEQ" ).append("\n"); 
		query.append("		#if(${form_usr_ofc_cd} != '')" ).append("\n"); 
		query.append("			AND	IN_SVC.TRSP_SO_OFC_CTY_CD	= SUBSTR(@[form_usr_ofc_cd],1,3)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if($so_no.size() > 0)  " ).append("\n"); 
		query.append("			AND (IN_SVC.TRSP_SO_OFC_CTY_CD||IN_SVC.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${so_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					'$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("				   ,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($init_sono_arrs.size() > 0)  " ).append("\n"); 
		query.append("			AND (IN_SVC.TRSP_SO_OFC_CTY_CD,IN_SVC.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${init_sono_arrs})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 11))" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("				   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 11))  " ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND IN_SVC.TRSP_SO_STS_CD = 'I'  " ).append("\n"); 
		query.append("		AND IN_SVC.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("		AND IN_SVC.INV_NO IS NULL											" ).append("\n"); 
		query.append("		AND	IN_WRK.TRSP_WO_OFC_CTY_CD	= SUBSTR(@[form_usr_ofc_cd],1,3)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${fmdate} != '' && ${todate} != '' && ${dt_radio} != '')  " ).append("\n"); 
		query.append("			#if( ${dt_radio} == 'plan_dpt')" ).append("\n"); 
		query.append("				AND IN_SVC.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if( ${dt_radio} == 'dor_arr')" ).append("\n"); 
		query.append("				 AND IN_SVC.DOR_NOD_PLN_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if( ${dt_radio} == 'so_create')" ).append("\n"); 
		query.append("				AND IN_SVC.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if( ${dt_radio} == 'wo_issue')" ).append("\n"); 
		query.append("				AND IN_WRK.LOCL_CRE_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if( ${dt_radio} == 'wo_reject')" ).append("\n"); 
		query.append("				AND IN_SVC.UPD_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("				AND IN_SVC.WO_RJCT_FLG = 'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if( ${dt_radio} == 'plan_rtn')" ).append("\n"); 
		query.append("				AND IN_SVC.LST_NOD_PLN_DT BETWEEN TO_DATE(@[fmdate]||'000000','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${combo_svc_provider} != '' && ${combo_svc_provider} != 'null')  " ).append("\n"); 
		query.append("			AND IN_SVC.VNDR_SEQ = @[combo_svc_provider]		" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($wo_no.size() > 0) " ).append("\n"); 
		query.append("			AND (IN_SVC.TRSP_WO_OFC_CTY_CD,IN_SVC.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("		#foreach($code IN ${wo_no})  " ).append("\n"); 
		query.append("			#if($velocityCount == 1)  " ).append("\n"); 
		query.append("				(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 10))" ).append("\n"); 
		query.append("			#else  " ).append("\n"); 
		query.append("			   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 10))  " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${trs_cost_md_cd} != 'ALL' && ${trs_cost_md_cd} != '')  " ).append("\n"); 
		query.append("			AND IN_SVC.TRSP_COST_DTL_MOD_CD = @[trs_cost_md_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($trs_sub_sts_cd.size() > 0)  " ).append("\n"); 
		query.append("		AND IN_SVC.TRS_SUB_STS_CD IN( " ).append("\n"); 
		query.append("		#foreach($code IN ${trs_sub_sts_cd})  " ).append("\n"); 
		query.append("			#if($velocityCount == 1)  " ).append("\n"); 
		query.append("				'$code' " ).append("\n"); 
		query.append("			#else  " ).append("\n"); 
		query.append("				,'$code' " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${trs_md_cd} != 'ALL' && ${trs_md_cd} != '')  " ).append("\n"); 
		query.append("			AND IN_SVC.TRSP_CRR_MOD_CD = @[trs_md_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${trs_bnd_cd} != 'ALL' && ${trs_bnd_cd} != '')  " ).append("\n"); 
		query.append("			AND IN_SVC.TRSP_BND_CD = @[trs_bnd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${trs_so_tp_cd} != 'ALL' && ${trs_so_tp_cd} != '')  " ).append("\n"); 
		query.append("			AND IN_SVC.TRSP_SO_TP_CD = @[trs_so_tp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${fm_nod} != '' && ${fm_nod} != 'null')  " ).append("\n"); 
		query.append("			#if ($fm_nod.length() == 5)  " ).append("\n"); 
		query.append("				AND IN_SVC.FM_NOD_CD LIKE @[fm_nod] || '%'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND IN_SVC.FM_NOD_CD = @[fm_nod]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${to_nod} != '' && ${to_nod} != 'null')  " ).append("\n"); 
		query.append("			#if ($to_nod.length() == 5)  " ).append("\n"); 
		query.append("				AND IN_SVC.TO_NOD_CD LIKE @[to_nod] || '%'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND IN_SVC.TO_NOD_CD = @[to_nod]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${via_nod} != '' && ${via_nod} != 'null')  " ).append("\n"); 
		query.append("			#if ($via_nod.length() == 5)  " ).append("\n"); 
		query.append("				AND IN_SVC.VIA_NOD_CD LIKE @[via_nod] || '%'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND IN_SVC.VIA_NOD_CD = @[via_nod]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${dor_nod} != '' && ${dor_nod} != 'null')  " ).append("\n"); 
		query.append("			#if ($dor_nod.length() == 5)  " ).append("\n"); 
		query.append("				AND IN_SVC.DOR_NOD_CD LIKE @[dor_nod] || '%'" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND IN_SVC.DOR_NOD_CD = @[dor_nod]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($tvvd_no.size() > 0)" ).append("\n"); 
		query.append("			AND (IN_SVC.VSL_CD,IN_SVC.SKD_VOY_NO,IN_SVC.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("		#foreach($code IN ${tvvd_no})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("			(SUBSTR('$code', 1, 4),SUBSTR('$code', 5, 4),SUBSTR('$code',9))  " ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("			, (SUBSTR('$code', 1, 4),SUBSTR('$code', 5, 4),SUBSTR('$code',9))  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${f_vvd_radio} == 'I' && $fvvd_no.size() > 0 )" ).append("\n"); 
		query.append("			#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					AND IN_SVC.IB_VVD_CD IN ('$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("				,'$code'" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end 	" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end 	" ).append("\n"); 
		query.append("		#if(${f_vvd_radio} == 'O' && $fvvd_no.size() > 0)" ).append("\n"); 
		query.append("				AND IN_SVC.OB_VVD_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					'$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${f_vvd_radio} == 'A' && $fvvd_no.size() > 0)" ).append("\n"); 
		query.append("					AND (IN_SVC.IB_VVD_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					'$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#foreach($code IN ${fvvd_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					 )OR IN_SVC.OB_VVD_CD IN ('$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($bkg_no.size() > 0)  " ).append("\n"); 
		query.append("			AND IN_SVC.BKG_NO IN( " ).append("\n"); 
		query.append("		#foreach($code IN ${bkg_no})  " ).append("\n"); 
		query.append("			#if($velocityCount == 1)  " ).append("\n"); 
		query.append("				'$code' " ).append("\n"); 
		query.append("			#else  " ).append("\n"); 
		query.append("				,'$code' " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($bl_no.size() > 0)  " ).append("\n"); 
		query.append("			AND IN_SVC.BL_NO IN(" ).append("\n"); 
		query.append("		#foreach($code IN ${bl_no})  " ).append("\n"); 
		query.append("			#if($velocityCount == 1)  " ).append("\n"); 
		query.append("				'$code' " ).append("\n"); 
		query.append("			#else  " ).append("\n"); 
		query.append("				,'$code' " ).append("\n"); 
		query.append("			#end  " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${eq_radio} != '' && ${eq_radio} != 'null')  " ).append("\n"); 
		query.append("			AND IN_SVC.EQ_KND_CD = @[eq_radio]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($eq_no.size() > 0)  " ).append("\n"); 
		query.append("			AND IN_SVC.EQ_NO IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${eq_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					'$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("					 ,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($mty_rfrn_no.size() > 0)  " ).append("\n"); 
		query.append("			AND IN_SVC.REF_ID IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${mty_rfrn_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					'$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("					 ,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND IN_SVC.TRSP_SO_OFC_CTY_CD = CNG.TRSP_SO_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("		AND IN_SVC.TRSP_SO_SEQ = CNG.TRSP_SO_SEQ (+)" ).append("\n"); 
		query.append("		AND CNG.TRSP_SO_SUB_SEQ(+) = 1" ).append("\n"); 
		query.append("#if(${src_keep_flg} == 'Y' )" ).append("\n"); 
		query.append("        AND (" ).append("\n"); 
		query.append("			(IN_SVC.TRSP_SO_OFC_CTY_CD||IN_SVC.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${keep_so_no})  " ).append("\n"); 
		query.append("				#if($velocityCount == 1)  " ).append("\n"); 
		query.append("					'$code'" ).append("\n"); 
		query.append("				#else  " ).append("\n"); 
		query.append("				   ,'$code'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#if(${trs_chg_tp_cd} == 'S')" ).append("\n"); 
		query.append("			OR CNG.CNG_IND_FLG = 'Y'" ).append("\n"); 
		query.append("		#elseif(${trs_chg_tp_cd} == 'V')" ).append("\n"); 
		query.append("			OR EXISTS (SELECT 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD= IN_SVC.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = IN_SVC.TRSP_SO_SEQ AND RCV_MSG_STS_CD IS NULL)" ).append("\n"); 
		query.append("		#elseif(${trs_chg_tp_cd} == 'A')" ).append("\n"); 
		query.append("			OR (CNG.CNG_IND_FLG = 'Y'" ).append("\n"); 
		query.append("				OR EXISTS (SELECT 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD= IN_SVC.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = IN_SVC.TRSP_SO_SEQ AND RCV_MSG_STS_CD IS NULL)" ).append("\n"); 
		query.append("			   )	" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#elseif(${src_keep_flg} == 'N')" ).append("\n"); 
		query.append("	#if(${trs_chg_tp_cd} == 'S')" ).append("\n"); 
		query.append("		AND CNG.CNG_IND_FLG = 'Y'" ).append("\n"); 
		query.append("	#elseif(${trs_chg_tp_cd} == 'V')" ).append("\n"); 
		query.append("		AND EXISTS (SELECT 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD= IN_SVC.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = IN_SVC.TRSP_SO_SEQ AND RCV_MSG_STS_CD IS NULL)" ).append("\n"); 
		query.append("	#elseif(${trs_chg_tp_cd} == 'A')" ).append("\n"); 
		query.append("		AND (CNG.CNG_IND_FLG = 'Y'" ).append("\n"); 
		query.append("			OR EXISTS (SELECT 1 FROM TRS_EDI_USA_RCV_MSG WHERE TRSP_SO_OFC_CTY_CD= IN_SVC.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = IN_SVC.TRSP_SO_SEQ AND RCV_MSG_STS_CD IS NULL)" ).append("\n"); 
		query.append("		)	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($eq_tpsz_cd.size() > 0)" ).append("\n"); 
		query.append("		AND IN_SVC.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${eq_tpsz_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($spcl_cgo_cntr_tp_cd.size() > 0)" ).append("\n"); 
		query.append("		AND IN_SVC.SPCL_CGO_CNTR_TP_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${spcl_cgo_cntr_tp_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($cop_no.size() > 0)" ).append("\n"); 
		query.append("		AND IN_SVC.COP_NO IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${cop_no})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if($cgo_tp_cd.size() > 0)" ).append("\n"); 
		query.append("		AND IN_SVC.CGO_TP_CD IN (" ).append("\n"); 
		query.append("			#foreach($code IN ${cgo_tp_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1)" ).append("\n"); 
		query.append("					 '$code'" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					,'$code'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		---------------------W/O Issued Yes --------------------------" ).append("\n"); 
		query.append("		GROUP BY IN_SVC.TRSP_WO_OFC_CTY_CD,	IN_SVC.TRSP_WO_SEQ" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 

	}
}