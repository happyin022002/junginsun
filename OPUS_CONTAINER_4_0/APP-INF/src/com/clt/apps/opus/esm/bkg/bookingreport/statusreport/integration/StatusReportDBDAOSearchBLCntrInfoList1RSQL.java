/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLCntrInfoList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLCntrInfoList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLCntrInfoList1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLCntrInfoList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_prn_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cptr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_srnd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rlse_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_rlse_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_srnd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_prn_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_srnd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("internet_bl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLCntrInfoList1RSQL").append("\n"); 
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
		query.append("           ROWNUM RNUM" ).append("\n"); 
		query.append("        ,Z.*" ).append("\n"); 
		query.append("        ,CASE WHEN EX_MVMT_REF_NO IS NOT NULL THEN 'Y' ELSE '' END AS CSTMS_DECL -- 36.Custom details  Customs Declaration Typ" ).append("\n"); 
		query.append("        ,CASE WHEN EX_MVMT_REF_NO IS NOT NULL THEN 'Y' ELSE '' END AS CSTMS_REQ -- 39.Custom details  Customs Required" ).append("\n"); 
		query.append("        ,CASE WHEN EX_MVMT_REF_NO IS NOT NULL THEN 'Y' ELSE '' END AS CSTMS_SYS_RDY -- 40.Custom details  Customs System Ready" ).append("\n"); 
		query.append("        ,CASE WHEN EX_MVMT_REF_NO IS NOT NULL THEN 'Y' ELSE '' END AS CSTMS_USR_RDY -- 41.Custom details  Customs User Ready  " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        ,SUM(DECODE(Z.RN_BKG, 1, 1, 0)) OVER () AS CNT_BKG" ).append("\n"); 
		query.append("        ,SUM(DECODE(Z.RN_BKG, 1, 1, 0)) OVER () AS CNT_BL" ).append("\n"); 
		query.append("    	,NVL(COUNT(DISTINCT Z.CNTR_NO) OVER(),0) AS CNT_CNTR" ).append("\n"); 
		query.append("        ,SUM(DECODE(Z.RN_BKG, 1, Z.PCK_QTY, 0)) OVER () AS CNT_PCK" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(ROUND(SUM(DECODE(Z.RN_BKG, 1, DECODE(Z.WGT_UT_CD, 'LBS', NVL(Z.ACT_WGT,0) *0.4536, Z.ACT_WGT)/1000, 0)) OVER (),3),'999,999,999,990.999')) AS SUM_WGT_TON			--Sum Weight(Ton)" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(ROUND(SUM(DECODE(Z.RN_BKG, 1, DECODE(Z.WGT_UT_CD, 'LBS', NVL(Z.ACT_WGT,0) *0.4536, Z.ACT_WGT), 0)) OVER (),3),'999,999,999,990.999')) AS SUM_GRS_WGT_KGS				--Gross Weight(KG)" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(ROUND(SUM(DECODE(Z.RN_BKG, 1, DECODE(Z.WGT_UT_CD, 'LBS', NVL(Z.ACT_WGT,0) *0.4536, Z.ACT_WGT), 0)) OVER (),3),'999,999,999,990.999')) AS SUM_NET_WGT_KGS				--Net Weight(KG)" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(ROUND(SUM(DECODE(Z.RN_BKG, 1, DECODE(Z.WGT_UT_CD, 'KGS', NVL(Z.ACT_WGT,0) *2.2046, Z.ACT_WGT), 0)) OVER (),3),'999,999,999,990.999')) AS SUM_WGT_LBS						--Net Weight(LBS)" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(ROUND(SUM(DECODE(Z.RN_BKG, 1, DECODE(Z.MEAS_UT_CD, 'CBF', NVL(Z.MEAS_QTY,0) *0.028317, Z.MEAS_QTY), 0)) OVER (),3),'999,999,999,990.999')) AS SUM_GRS_MEA_CBM	--Gross Measurement(CBM)" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(ROUND(SUM(DECODE(Z.RN_BKG, 1, DECODE(Z.MEAS_UT_CD, 'CBF', NVL(Z.MEAS_QTY,0) *0.028317, Z.MEAS_QTY), 0)) OVER (),3),'999,999,999,990.999')) AS SUM_NET_MEA_CBM	--Net Measurement(CBM)" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(SUM(DECODE(Z.RN_BKG, 1, CCT_TTL_AMT, 0.0)) OVER (),'999,999,999,990.999')) AS SUM_CCT_AMT																	--SUM OF COLLECT FREIGHT" ).append("\n"); 
		query.append("        ,TRIM(TO_CHAR(SUM(DECODE(Z.RN_BKG, 1, CPT_TTL_AMT, 0.0)) OVER (),'999,999,999,990.999')) AS SUM_PPD_AMT																	--SUM OF PREPAID FREIGHT            " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("			 --BKG & B/L Info" ).append("\n"); 
		query.append("			       BKG.DOC_USR_ID" ).append("\n"); 
		query.append("			      ,BKG.BL_NO" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(MIN(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),A.CRE_DT,BKG.POL_CD)),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			          FROM BKG_HIS_DTL A" ).append("\n"); 
		query.append("			              ,COM_USER B" ).append("\n"); 
		query.append("			         WHERE A.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("			           AND A.HIS_CATE_NM = 'O.B/L PRINT' " ).append("\n"); 
		query.append("			           AND A.CRE_USR_ID = B.USR_ID) AS BL_PRT_DT" ).append("\n"); 
		query.append("			      ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("			      ,TO_CHAR(SRD.EVNT_DT,'YYYY-MM-DD HH24:MI') AS SRD_DT" ).append("\n"); 
		query.append("			      ,BKG.BL_TP_CD" ).append("\n"); 
		query.append("			      ,BKG.KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append("			      ,BKG.BKG_NO" ).append("\n"); 
		query.append("				  ,ISS.OBL_ISS_OFC_CD AS CAPT_OFC" ).append("\n"); 
		query.append("			      ,TO_CHAR(MIN(CNTR.CGO_RCV_DT) OVER (PARTITION BY BKG.BKG_NO),'YYYY-MM-DD HH24:MI') AS CRD" ).append("\n"); 
		query.append("                  ,(SELECT DECODE(COUNT(COP_NO), SUM(CASE WHEN COP_STS_CD IN ('T','F','M') THEN 1 ELSE 0 END), 'Y', '')" ).append("\n"); 
		query.append("                      FROM SCE_COP_HDR A" ).append("\n"); 
		query.append("                     WHERE A.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                       AND A.BKG_NO = BKG.BKG_NO) AS CGO_RLSE_STS" ).append("\n"); 
		query.append("                  ,BKG.SCAC_CD AS SCAC_NM" ).append("\n"); 
		query.append("			      ,ISS.OBL_ISS_USR_ID AS CLR_BY" ).append("\n"); 
		query.append("			      ,TO_CHAR(ISS.OBL_INET_PRN_DT,'YYYY-MM-DD HH24:MI') AS OBL_INET_PRN_DT" ).append("\n"); 
		query.append("			      ,TO_CHAR(OBL_ISS_DT,'YYYY-MM-DD HH24:MI') AS OBL_ISS_DT" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT HBL.HBL_NO" ).append("\n"); 
		query.append("			                             FROM BKG_HBL HBL" ).append("\n"); 
		query.append("			                            WHERE BKG.BKG_NO = HBL.BKG_NO),';') AS HBL_NO" ).append("\n"); 
		query.append("                  ,(SELECT NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("                     WHERE A.CUST_CNT_CD = FF.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND A.CUST_SEQ = FF.CUST_SEQ) AS NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("			      ,TO_CHAR(DOC.BL_OBRD_DT,'YYYY-MM-DD HH24:MI') AS BL_OBRD_DT" ).append("\n"); 
		query.append("			      ,OBL_RLSE_FLG" ).append("\n"); 
		query.append("			      ,BKG.SPLIT_FLG" ).append("\n"); 
		query.append("			      ,OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("			      ,OBL_ISS_OFC_CD AS BKG_ISS_OFC_CD" ).append("\n"); 
		query.append("			      ,BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("			      ,SLS_LOC.RGN_CD AS OB_SLS_RGN_CD" ).append("\n"); 
		query.append("			      ,BKG.OB_SREP_CD" ).append("\n"); 
		query.append("			      ,BKG.SCAC_CD" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(MIN(XTER.RQST_DT) OVER (PARTITION BY BKG.BKG_NO),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			          FROM BKG_XTER_RQST_MST XTER" ).append("\n"); 
		query.append("			         WHERE XTER.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("			           AND BKG.BKG_NO = XTER.BKG_NO" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS SI_DT" ).append("\n"); 
		query.append("			      ,USR.OFC_CD AS SRD_OFC" ).append("\n"); 
		query.append("			 --Cargo & Commodity" ).append("\n"); 
		query.append("			      ,CMDT.CMDT_NM" ).append("\n"); 
		query.append("			      ,NVL(SUBSTR(DECODE(BKG.DCGO_FLG,'Y',',DG','')||DECODE(BKG.RC_FLG,'Y',',RF','')||DECODE(BKG.AWK_CGO_FLG,'Y',',AW','')||DECODE(BKG.BB_CGO_FLG,'Y',',BB','')||DECODE(BKG.RD_CGO_FLG,'Y',',RD',''),2),'DR') AS CGO_NATURE" ).append("\n"); 
		query.append("			      ,DOC.ACT_WGT" ).append("\n"); 
		query.append("			      ,DOC.MEAS_UT_CD" ).append("\n"); 
		query.append("			      ,DOC.ACT_WGT AS GRS_WGT" ).append("\n"); 
		query.append("			      ,DOC.WGT_UT_CD AS GRS_WGT_UT_CD" ).append("\n"); 
		query.append("				  ,CM.CMDT_HS_CD" ).append("\n"); 
		query.append("				  ,HS.HAMO_CD_DESC" ).append("\n"); 
		query.append("			      ,DOC.MEAS_QTY" ).append("\n"); 
		query.append("			      ,DOC.MEAS_UT_CD AS NT_MEAS_UT_CD" ).append("\n"); 
		query.append("			      ,DOC.ACT_WGT AS NT_WGT_QTY" ).append("\n"); 
		query.append("			      ,DOC.WGT_UT_CD AS NT_WGT_UT_CD" ).append("\n"); 
		query.append("			      ,DOC.PCK_QTY" ).append("\n"); 
		query.append("			      ,DOC.PCK_TP_CD" ).append("\n"); 
		query.append("			      ,CMDT.CMDT_NM AS ST_CMDT_NM" ).append("\n"); 
		query.append("			      ,(SELECT B.TARE_WGT" ).append("\n"); 
		query.append("                      FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                          ,MST_CNTR_SPEC B" ).append("\n"); 
		query.append("                     WHERE A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                       AND A.CNTR_NO = CNTR.CNTR_NO) AS TARE_WGT" ).append("\n"); 
		query.append("			      ,DOC.ACT_WGT AS ACT_TOT_WGT" ).append("\n"); 
		query.append("			 --Charge" ).append("\n"); 
		query.append("			      ,(SELECT MAX(CRT.CURR_CD) OVER (PARTITION BY BKG.BKG_NO)" ).append("\n"); 
		query.append("			          FROM BKG_CHG_RT CRT" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = CRT.BKG_NO" ).append("\n"); 
		query.append("			           AND CRT.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("			           AND CRT.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS COL_CURR_CD" ).append("\n"); 
		query.append("			      ,(SELECT ROUND(SUM(DECODE(USD_XCH_RT, 0, 0, INV_TTL_LOCL_AMT / USD_XCH_RT)), 3)" ).append("\n"); 
		query.append("                      FROM INV_AR_MN AR" ).append("\n"); 
		query.append("                     WHERE (AR_OFC_CD, BL_SRC_NO, AR_IF_NO) IN (" ).append("\n"); 
		query.append("                                SELECT AR_OFC_CD, BL_SRC_NO, MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                  FROM INV_AR_MN AR " ).append("\n"); 
		query.append("                                 WHERE AR.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                   AND AR.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                   AND AR.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                   AND AR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 GROUP BY AR_OFC_CD, BL_SRC_NO)" ).append("\n"); 
		query.append("                       AND AR.INV_DELT_DIV_CD <> 'X'" ).append("\n"); 
		query.append("                       AND AR.BKG_NO = BKG.BKG_NO) AS CCT_TTL_AMT" ).append("\n"); 
		query.append("                  ,(SELECT MAX(XCH_RT_DT)" ).append("\n"); 
		query.append("                      FROM INV_AR_MN AR" ).append("\n"); 
		query.append("                     WHERE (AR_OFC_CD, BL_SRC_NO, AR_IF_NO) IN (" ).append("\n"); 
		query.append("                                SELECT AR_OFC_CD, BL_SRC_NO, MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                  FROM INV_AR_MN AR " ).append("\n"); 
		query.append("                                 WHERE AR.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                   AND AR.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                   AND AR.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                   AND AR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 GROUP BY AR_OFC_CD, BL_SRC_NO)" ).append("\n"); 
		query.append("                       AND AR.INV_DELT_DIV_CD <> 'X'" ).append("\n"); 
		query.append("                       AND AR.BKG_NO = BKG.BKG_NO) AS IB_XCH_RT_DT" ).append("\n"); 
		query.append("                  ,(SELECT MAX(XCH_RT_DT)" ).append("\n"); 
		query.append("                      FROM INV_AR_MN AR" ).append("\n"); 
		query.append("                     WHERE (AR_OFC_CD, BL_SRC_NO, AR_IF_NO) IN (" ).append("\n"); 
		query.append("                                SELECT AR_OFC_CD, BL_SRC_NO, MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                  FROM INV_AR_MN AR " ).append("\n"); 
		query.append("                                 WHERE AR.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                   AND AR.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                   AND AR.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                   AND AR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 GROUP BY AR_OFC_CD, BL_SRC_NO)" ).append("\n"); 
		query.append("                       AND AR.INV_DELT_DIV_CD <> 'X'" ).append("\n"); 
		query.append("                       AND AR.BKG_NO = BKG.BKG_NO) AS OB_XCH_RT_DT" ).append("\n"); 
		query.append("			      ,(SELECT MAX(CRT.CURR_CD) OVER (PARTITION BY BKG.BKG_NO)" ).append("\n"); 
		query.append("			          FROM BKG_CHG_RT CRT" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = CRT.BKG_NO" ).append("\n"); 
		query.append("			           AND CRT.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("			           AND CRT.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS PRE_CURR_CD" ).append("\n"); 
		query.append("			      ,(SELECT ROUND(SUM(DECODE(USD_XCH_RT, 0, 0, INV_TTL_LOCL_AMT / USD_XCH_RT)), 3)" ).append("\n"); 
		query.append("                      FROM INV_AR_MN AR" ).append("\n"); 
		query.append("                     WHERE (AR_OFC_CD, BL_SRC_NO, AR_IF_NO) IN (" ).append("\n"); 
		query.append("                                SELECT AR_OFC_CD, BL_SRC_NO, MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                  FROM INV_AR_MN AR " ).append("\n"); 
		query.append("                                 WHERE AR.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                   AND AR.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                   AND AR.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                   AND AR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                 GROUP BY AR_OFC_CD, BL_SRC_NO)" ).append("\n"); 
		query.append("                       AND AR.INV_DELT_DIV_CD <> 'X'" ).append("\n"); 
		query.append("                       AND AR.BKG_NO = BKG.BKG_NO) AS CPT_TTL_AMT" ).append("\n"); 
		query.append("			 --Customer " ).append("\n"); 
		query.append("			      ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("			      ,SUBSTR(CNTR.CNTR_TPSZ_CD, -1) AS CNTR_SZ" ).append("\n"); 
		query.append("			      ,DECODE(BKG.BKG_CGO_TP_CD, 'P', 'M', 'F') AS CNTR_STS" ).append("\n"); 
		query.append("			      ,SUBSTR(CNTR.CNTR_TPSZ_CD, 1, 1) AS CNTR_TP" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("										 FROM BKG_CNTR_SEAL_NO CNTR_SEAL" ).append("\n"); 
		query.append("										WHERE CNTR.BKG_NO = CNTR_SEAL.BKG_NO" ).append("\n"); 
		query.append("										  AND CNTR.CNTR_NO = CNTR_SEAL.CNTR_NO),';') AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("			      ,REPLACE(NF.CUST_NM,CHR(10),' ') AS NF_CUST_NM" ).append("\n"); 
		query.append("			      ,REPLACE(AN.CUST_NM,CHR(10),' ') AS AN_CUST_NM" ).append("\n"); 
		query.append("				  ,'' AS N3RD_NTFY_PTY" ).append("\n"); 
		query.append("			      ,REPLACE(CN.CUST_NM,CHR(10),' ') AS CN_CUST_NM" ).append("\n"); 
		query.append("			      ,REPLACE(FF.CUST_NM,CHR(10),' ') AS FF_CUST_NM" ).append("\n"); 
		query.append("			      ,FF_ADDR.CNTC_PSON_NM AS FF_CNTC_PSON_NM" ).append("\n"); 
		query.append("			      ,(SELECT A.INTL_PHN_NO || A.PHN_NO" ).append("\n"); 
		query.append("			          FROM MDM_CUST_CNTC_PNT A" ).append("\n"); 
		query.append("			              ,BKG_CUSTOMER B" ).append("\n"); 
		query.append("			         WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("			           AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("			           AND B.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS FW_CNTC_NUM" ).append("\n"); 
		query.append("			      ,ISS.OBL_INET_FLG" ).append("\n"); 
		query.append("			      ,REPLACE(SH.CUST_NM,CHR(10),' ') AS SH_CUST_NM" ).append("\n"); 
		query.append("			      ,SH_ADDR.CNTC_PSON_NM AS SH_CNTC_PSON_NM" ).append("\n"); 
		query.append("			      ,(SELECT A.INTL_PHN_NO || A.PHN_NO" ).append("\n"); 
		query.append("			          FROM MDM_CUST_CNTC_PNT A" ).append("\n"); 
		query.append("			              ,BKG_CUSTOMER B" ).append("\n"); 
		query.append("			         WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("			           AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("			           AND B.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS SH_CNTC_NUM" ).append("\n"); 
		query.append("			 --Inbound Info" ).append("\n"); 
		query.append("			      ,(SELECT /*+ INDEX_DESC(A XPKBKG_DO_DTL) */ RLSE_STS_CD" ).append("\n"); 
		query.append("			          FROM BKG_DO_DTL A" ).append("\n"); 
		query.append("			         WHERE A.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS RLSE_STS_CD" ).append("\n"); 
		query.append("                  ,(SELECT SLS_OFC_CD" ).append("\n"); 
		query.append("                      FROM MDM_LOCATION A" ).append("\n"); 
		query.append("                     WHERE A.LOC_CD = BKG.DEL_CD) AS IB_CTRL_OFC" ).append("\n"); 
		query.append("			      ,(SELECT DECODE(COUNT(TROI.BKG_NO) OVER (PARTITION BY TROI.BKG_NO), 0, 'N', 'Y')     " ).append("\n"); 
		query.append("			          FROM BKG_EUR_TRO TROI" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = TROI.BKG_NO" ).append("\n"); 
		query.append("			           AND TROI.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS TROI" ).append("\n"); 
		query.append("                  ,(SELECT DECODE(COUNT(DECODE(DECODE(A.CR_MK_FLG, 'Y', 'Y', DECODE(A.STL_FLG, 'Y','Y', 'N')), 'Y', 0, 1)), 0, 'Y', 'N') CLR_FLG" ).append("\n"); 
		query.append("                      FROM SAR_OTS_HDR A" ).append("\n"); 
		query.append("                     WHERE A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                       AND A.BKG_IO_BND_CD = 'I') AS IB_FRH_FLG" ).append("\n"); 
		query.append("			 --Rate & Invoice" ).append("\n"); 
		query.append("			      ,NVL(BKG.TAA_NO,NVL(BKG.RFA_NO,BKG.SC_NO)) AS TRF_CD" ).append("\n"); 
		query.append("			 --Reference No" ).append("\n"); 
		query.append("			      ,IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("			      ,(SELECT CRN_BL.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("			          FROM BKG_VVD CRN_VVD" ).append("\n"); 
		query.append("			              ,BKG_CSTMS_RTM_BL CRN_BL" ).append("\n"); 
		query.append("			              ,BKG_CSTMS_RTM_VSL CRN_VSL" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = CRN_VVD.BKG_NO" ).append("\n"); 
		query.append("			           AND BKG.BKG_NO = CRN_BL.BKG_NO" ).append("\n"); 
		query.append("			           AND CRN_VVD.POD_CD LIKE 'NL%'" ).append("\n"); 
		query.append("			           AND CRN_VVD.VSL_CD = CRN_VSL.VSL_CD" ).append("\n"); 
		query.append("			           AND CRN_VVD.SKD_VOY_NO = CRN_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("			           AND CRN_VVD.SKD_DIR_CD = CRN_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("			           AND CRN_VSL.VSL_CALL_REF_NO = CRN_BL.VSL_CALL_REF_NO) AS CRN" ).append("\n"); 
		query.append("			      ,(SELECT XPT_LIC_NO" ).append("\n"); 
		query.append("			          FROM BKG_XPT_IMP_LIC XIL" ).append("\n"); 
		query.append("			         WHERE BKG.BKG_NO = XIL.BKG_NO" ).append("\n"); 
		query.append("			           AND XPT_LIC_NO IS NOT NULL" ).append("\n"); 
		query.append("			           AND ROWNUM = 1) AS XPT_LIC_NO" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT NVL(EUR_BL.MVMT_REF_NO, (SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("			                                				             FROM BKG_CSTMS_EUR_BL EBL" ).append("\n"); 
		query.append("			                                 				            WHERE EBL.MSG_SND_NO = (SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("			                                                    	                              FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("			                                                    	                             WHERE BL_NO = EUR_BL.BL_NO" ).append("\n"); 
		query.append("			                                                    	 			                   AND CSTMS_PORT_CD  = EUR_BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("			                                                    	 			                   AND (  VSL_CD != EUR_BL.VSL_CD" ).append("\n"); 
		query.append("			                                                    	 			                        OR SKD_VOY_NO != EUR_BL.SKD_VOY_NO" ).append("\n"); 
		query.append("			                                                    	 			                        OR SKD_DIR_CD != EUR_BL.SKD_DIR_CD)" ).append("\n"); 
		query.append("			                                					                                )" ).append("\n"); 
		query.append("			                                				           )" ).append("\n"); 
		query.append("			                                     ) " ).append("\n"); 
		query.append("			                             FROM BKG_CSTMS_EUR_BL EUR_BL" ).append("\n"); 
		query.append("			                            WHERE EUR_BL.BL_NO = BKG.BL_NO),';') AS MVMT_REF_NO" ).append("\n"); 
		query.append("			      ,IBD_TRSP_NO" ).append("\n"); 
		query.append("			 --Route & Schedule" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = SUBSTR(VVD.VVD_1,1,4) AND V.SKD_VOY_NO = SUBSTR(VVD.VVD_1,5,4) AND V.SKD_DIR_CD = SUBSTR(VVD.VVD_1,9,1) AND V.VPS_PORT_CD = VVD.POD_1 AND ROWNUM = 1) AS N1ST_POD_ETA" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = SUBSTR(VVD.VVD_1,1,4) AND V.SKD_VOY_NO = SUBSTR(VVD.VVD_1,5,4) AND V.SKD_DIR_CD = SUBSTR(VVD.VVD_1,9,1) AND V.VPS_PORT_CD = VVD.POD_1 AND ROWNUM = 1) AS N1ST_POD_ETD" ).append("\n"); 
		query.append("			      ,TO_CHAR(N1ST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') N1ST_POL_ETA" ).append("\n"); 
		query.append("			      ,TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') N1ST_POL_ETD" ).append("\n"); 
		query.append("			      ,VVD.VVD_1" ).append("\n"); 
		query.append("			      ,VVD.VVD_2" ).append("\n"); 
		query.append("			      ,VVD.VVD_3" ).append("\n"); 
		query.append("			      ,VVD.VVD_4" ).append("\n"); 
		query.append("			      ,DECODE(LAST_SKD.ACT_INP_FLG,'Y',TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),'') AS LAST_POD_ATA" ).append("\n"); 
		query.append("			      ,(SELECT DECODE(ACT_INP_FLG,'Y',TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),'') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = TRUNK.VSL_CD AND V.SKD_VOY_NO = TRUNK.SKD_VOY_NO AND V.SKD_DIR_CD = TRUNK.SKD_DIR_CD AND V.VPS_PORT_CD = TRUNK.POD_CD AND ROWNUM = 1) AS TRUNK_POD_ATA" ).append("\n"); 
		query.append("			      ,DECODE(N1ST_SKD.ACT_INP_FLG,'Y',TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),'') AS N1ST_POD_ATD" ).append("\n"); 
		query.append("			      ,(SELECT DECODE(ACT_INP_FLG,'Y',TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),'') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = TRUNK.VSL_CD AND V.SKD_VOY_NO = TRUNK.SKD_VOY_NO AND V.SKD_DIR_CD = TRUNK.SKD_DIR_CD AND V.VPS_PORT_CD = TRUNK.POL_CD AND ROWNUM = 1) AS TRUNK_POL_ATA" ).append("\n"); 
		query.append("			      ,BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("			      ,BKG.SLAN_CD BL_SLAN_CD" ).append("\n"); 
		query.append("			      ,BKG.VSL_CD" ).append("\n"); 
		query.append("			      ,BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("			      ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS BL_VVD" ).append("\n"); 
		query.append("			      ,TO_CHAR(N1ST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') N1ST_POL_ETB" ).append("\n"); 
		query.append("			      ,TO_CHAR(LAST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') LAST_POD_ETB" ).append("\n"); 
		query.append("			      ,BKG.BLCK_STWG_CD" ).append("\n"); 
		query.append("			      ,'' AS DEL_ATA" ).append("\n"); 
		query.append("			      ,BKG.DEL_CD" ).append("\n"); 
		query.append("			      ,SUBSTR(BKG.DEL_CD,1,2) DEL_CNT_CD" ).append("\n"); 
		query.append("			      ,'' AS DEL_ETA" ).append("\n"); 
		query.append("			      ,(SELECT LOC_NM FROM MDM_LOCATION MDM WHERE MDM.LOC_CD = BKG.DEL_CD) AS DEL_NM" ).append("\n"); 
		query.append("			      ,DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("			      ,VVD.POD_1 AS N1ST_POD" ).append("\n"); 
		query.append("			      " ).append("\n"); 
		query.append("			      ,(SELECT LOC_NM FROM MDM_LOCATION MDM WHERE MDM.LOC_CD = BKG.POD_CD) AS FINAL_DEST_NM" ).append("\n"); 
		query.append("			      ,TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') FINAL_POD_ETA" ).append("\n"); 
		query.append("			      ,TO_CHAR(LAST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') FINAL_POD_ETD" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = SUBSTR(VVD.LAST_VVD,1,4) AND V.SKD_VOY_NO = SUBSTR(VVD.LAST_VVD,5,4) AND V.SKD_DIR_CD = SUBSTR(VVD.LAST_VVD,9,1) AND V.VPS_PORT_CD = NVL(VVD.POL_4,NVL(POL_3,NVL(POL_2,POL_1))) AND ROWNUM = 1) AS FINAL_POL_ETA" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = SUBSTR(VVD.LAST_VVD,1,4) AND V.SKD_VOY_NO = SUBSTR(VVD.LAST_VVD,5,4) AND V.SKD_DIR_CD = SUBSTR(VVD.LAST_VVD,9,1) AND V.VPS_PORT_CD = NVL(VVD.POL_4,NVL(POL_3,NVL(POL_2,POL_1))) AND ROWNUM = 1) AS FINAL_POL_ETD" ).append("\n"); 
		query.append("			      ,VVD.LAST_VVD" ).append("\n"); 
		query.append("			      ,BKG.SLAN_CD" ).append("\n"); 
		query.append("			      ,VVD.LAST_VVD AS DIS_LAST_VVD" ).append("\n"); 
		query.append("			      ,VVD.VVD_1 AS OB_VVD_1" ).append("\n"); 
		query.append("				  ,DECODE(BKG.RCV_TERM_CD, 'D', 'C', 'M')||NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'C', 'M')" ).append("\n"); 
		query.append("                                        FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                                       WHERE TRO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                         AND TRO.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                         AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                         AND TRO.CXL_FLG = 'N'), DECODE(BKG.DE_TERM_CD, 'D', 'C', 'M')) AS HLG_TP" ).append("\n"); 
		query.append("				  ,ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("				  ,BKG.POD_CD BKG_POD_CD" ).append("\n"); 
		query.append("				  ,VVD.LAST_POD" ).append("\n"); 
		query.append("				  ,SUBSTR(VVD.LAST_VVD,1,4) AS LAST_VSL" ).append("\n"); 
		query.append("			      , (SELECT TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                       FROM CTM_MOVEMENT CTM " ).append("\n"); 
		query.append("                      WHERE CTM.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                        AND CTM.CNMV_YR = CNTR.CNMV_YR" ).append("\n"); 
		query.append("                        AND CTM.CNMV_ID_NO = CNTR.CNMV_ID_NO" ).append("\n"); 
		query.append("                        AND CTM.MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("                    ) POD_ATA_IC_DT" ).append("\n"); 
		query.append("				  ,BKG.POD_CD POD_CD" ).append("\n"); 
		query.append("				  ,TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') LAST_POD_ETA" ).append("\n"); 
		query.append("				  ,TO_CHAR(LAST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') POD_ETB" ).append("\n"); 
		query.append("			      ,(SELECT LOC_NM FROM MDM_LOCATION MDM WHERE MDM.LOC_CD = BKG.POD_CD) AS POD_NM" ).append("\n"); 
		query.append("				  " ).append("\n"); 
		query.append("			      ,BKG.POL_CD BKG_POL_CD" ).append("\n"); 
		query.append("				  ,SUBSTR(VVD.VVD_1,1,4) AS FIRST_VSL" ).append("\n"); 
		query.append("			      ,BKG.POL_CD" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD = 'T' AND BKG_NO=BKG.BKG_NO) AS FIRST_POL_CUTOFF_DT" ).append("\n"); 
		query.append("			      ,TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') POL_ETD" ).append("\n"); 
		query.append("			      ,(SELECT LOC_NM FROM MDM_LOCATION MDM WHERE MDM.LOC_CD = BKG.POL_CD) AS POL_NM" ).append("\n"); 
		query.append("			      " ).append("\n"); 
		query.append("			      ,BKG.POR_CD" ).append("\n"); 
		query.append("			      ,SUBSTR(BKG.POR_CD,1,2) POR_CNT_CD" ).append("\n"); 
		query.append("			      ,(SELECT LOC_NM FROM MDM_LOCATION MDM WHERE MDM.LOC_CD = BKG.POR_CD) AS POR_NM" ).append("\n"); 
		query.append("			      " ).append("\n"); 
		query.append("			      ,VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD AS POST1_VVD" ).append("\n"); 
		query.append("			      ,VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD AS POST2_VVD" ).append("\n"); 
		query.append("			      ,VVD3.VSL_CD||VVD3.SKD_VOY_NO||VVD3.SKD_DIR_CD AS POST3_VVD" ).append("\n"); 
		query.append("			      ,VVD4.VSL_CD||VVD4.SKD_VOY_NO||VVD4.SKD_DIR_CD AS POST4_VVD" ).append("\n"); 
		query.append("			      ,BKG.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("			      ,VVD1.VSL_CD AS POST_VSL" ).append("\n"); 
		query.append("			      ,VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD AS POST_VVD" ).append("\n"); 
		query.append("			      ,VVD5.POD_CD AS PRE1_POD_CD" ).append("\n"); 
		query.append("			      ,VVD5.POL_CD AS PRE1_POL_CD" ).append("\n"); 
		query.append("			      ,VVD5.VSL_CD||VVD5.SKD_VOY_NO||VVD5.SKD_DIR_CD AS PRE1_VVD" ).append("\n"); 
		query.append("			      ,VVD6.POD_CD AS PRE2_POD_CD" ).append("\n"); 
		query.append("			      ,VVD6.POL_CD AS PRE2_POL_CD" ).append("\n"); 
		query.append("			      ,VVD6.VSL_CD||VVD6.SKD_VOY_NO||VVD6.SKD_DIR_CD AS PRE2_VVD" ).append("\n"); 
		query.append("			      ,VVD7.POD_CD AS PRE3_POD_CD" ).append("\n"); 
		query.append("			      ,VVD7.POL_CD AS PRE3_POL_CD" ).append("\n"); 
		query.append("			      ,VVD7.VSL_CD||VVD7.SKD_VOY_NO||VVD7.SKD_DIR_CD AS PRE3_VVD" ).append("\n"); 
		query.append("			      ,VVD8.POD_CD AS PRE4_POD_CD" ).append("\n"); 
		query.append("			      ,VVD8.POL_CD AS PRE4_POL_CD" ).append("\n"); 
		query.append("			      ,VVD8.VSL_CD||VVD8.SKD_VOY_NO||VVD8.SKD_DIR_CD AS PRE4_VVD" ).append("\n"); 
		query.append("			      ,BKG.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("			      ,(SELECT VSL_NM FROM MDM_VSL_CNTR WHERE VSL_CD = VVD5.VSL_CD) AS PRE_VSL" ).append("\n"); 
		query.append("			      ,DECODE(VVD8.POD_CD, '', DECODE(VVD7.POD_CD, '', DECODE(VVD6.POD_CD, '', VVD5.VSL_CD||VVD5.SKD_VOY_NO||VVD5.SKD_DIR_CD, VVD6.VSL_CD||VVD6.SKD_VOY_NO||VVD6.SKD_DIR_CD), VVD7.VSL_CD||VVD7.SKD_VOY_NO||VVD7.SKD_DIR_CD), VVD8.VSL_CD||VVD8.SKD_VOY_NO||VVD8.SKD_DIR_CD) AS PRE_VVD" ).append("\n"); 
		query.append("			      ,BKG.RCV_TERM_CD || '/' || BKG.DE_TERM_CD AS RD_TERM" ).append("\n"); 
		query.append("			      ,VVD.POD_1 AS TS_PORT1" ).append("\n"); 
		query.append("			      ,VVD.POD_2 AS TS_PORT2" ).append("\n"); 
		query.append("			      ,VVD.POD_3 AS TS_PORT3" ).append("\n"); 
		query.append("			      ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS TVVD" ).append("\n"); 
		query.append("			      ,(SELECT TRD_CD FROM COA_RGST_BKG C WHERE C.BKG_NO = BKG.BKG_NO) AS TRD_CD" ).append("\n"); 
		query.append("			      ,NVL(CNTR.RCV_TERM_CD, BKG.RCV_TERM_CD)||'/'||NVL(CNTR.DE_TERM_CD, BKG.DE_TERM_CD) AS TRAF_MOD" ).append("\n"); 
		query.append("			      ,BKG.SLAN_CD TRUNK_SLAN_CD" ).append("\n"); 
		query.append("			      ,TRUNK.POD_CD AS TRUNK_POD_CD" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = TRUNK.VSL_CD AND V.SKD_VOY_NO = TRUNK.SKD_VOY_NO AND V.SKD_DIR_CD = TRUNK.SKD_DIR_CD AND V.VPS_PORT_CD = TRUNK.POD_CD AND ROWNUM=1) AS TRUNK_POD_ETA" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = TRUNK.VSL_CD AND V.SKD_VOY_NO = TRUNK.SKD_VOY_NO AND V.SKD_DIR_CD = TRUNK.SKD_DIR_CD AND V.VPS_PORT_CD = TRUNK.POD_CD AND ROWNUM=1) AS TRUNK_POD_ETD" ).append("\n"); 
		query.append("			      ,TRUNK.POL_CD AS TRUNK_POL_CD" ).append("\n"); 
		query.append("			      ,(SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD HH24:MI') FROM VSK_VSL_PORT_SKD V WHERE V.VSL_CD = TRUNK.VSL_CD AND V.SKD_VOY_NO = TRUNK.SKD_VOY_NO AND V.SKD_DIR_CD = TRUNK.SKD_DIR_CD AND V.VPS_PORT_CD = TRUNK.POL_CD AND ROWNUM=1) AS TRUNK_POL_ETA" ).append("\n"); 
		query.append("			      ,TRUNK.VSL_CD AS TRUNK_VSL" ).append("\n"); 
		query.append("			      ,TRUNK.VSL_CD||TRUNK.SKD_VOY_NO||TRUNK.SKD_DIR_CD AS TRUNK_VVD" ).append("\n"); 
		query.append("			      ,(SELECT VSL_NM FROM MDM_VSL_CNTR WHERE VSL_CD = TRUNK.VSL_CD) AS TRUNK_VSL_NM" ).append("\n"); 
		query.append("			      ,BKG_JOIN_FNC(CURSOR(SELECT NVL(EX_EUR_BL.MVMT_REF_NO, (SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("			                            								    FROM BKG_CSTMS_EUR_IO_BL EBL" ).append("\n"); 
		query.append("			                            								   WHERE EBL.MSG_SND_NO = (SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("			                                                               	                         FROM BKG_CSTMS_EUR_IO_SND" ).append("\n"); 
		query.append("			                            								                            WHERE BL_NO          = EX_EUR_BL.BL_NO" ).append("\n"); 
		query.append("			                                                            							  AND CSTMS_PORT_CD  = EX_EUR_BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("			                                                                                          AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("			                                                                                		  AND (   VSL_CD != EX_EUR_BL.VSL_CD " ).append("\n"); 
		query.append("			                                                                                		       OR SKD_VOY_NO != EX_EUR_BL.SKD_VOY_NO " ).append("\n"); 
		query.append("			                                                                                		       OR SKD_DIR_CD != EX_EUR_BL.SKD_DIR_CD)" ).append("\n"); 
		query.append("			                            									                              )" ).append("\n"); 
		query.append("			                                                                 AND EBL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("			                            								  ))" ).append("\n"); 
		query.append("										 FROM BKG_CSTMS_EUR_IO_BL EX_EUR_BL" ).append("\n"); 
		query.append("										WHERE BKG.BL_NO = EX_EUR_BL.BL_NO),';') AS EX_MVMT_REF_NO -- 상위 항목들을 위한 값" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						,ROW_NUMBER() OVER (PARTITION BY BKG.BKG_NO ORDER BY BKG.BL_NO) AS RN_BKG			" ).append("\n"); 
		query.append("						,DOC.WGT_UT_CD" ).append("\n"); 
		query.append("			  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("			      ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("			      ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("			      ,PRD_PROD_CTL_MST PCTL" ).append("\n"); 
		query.append("			      ,BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("			      ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("			      ,BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("			      ,BKG_HAMO_TRF HS" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER SH" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER FF" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER NF" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER AN" ).append("\n"); 
		query.append("			      ,BKG_CUSTOMER CN" ).append("\n"); 
		query.append("			      ,BKG_DOC_PROC_SKD SRD" ).append("\n"); 
		query.append("			      ,COM_USER USR" ).append("\n"); 
		query.append("			      ,MDM_ORGANIZATION SLS_ORG" ).append("\n"); 
		query.append("			      ,MDM_LOCATION SLS_LOC" ).append("\n"); 
		query.append("			      ,MDM_COMMODITY CMDT" ).append("\n"); 
		query.append("			      ,(SELECT BKG_NO" ).append("\n"); 
		query.append("			              ,VVD_1" ).append("\n"); 
		query.append("			              ,VVD_2" ).append("\n"); 
		query.append("			              ,VVD_3" ).append("\n"); 
		query.append("			              ,VVD_4" ).append("\n"); 
		query.append("			              ,POL_1" ).append("\n"); 
		query.append("			              ,POL_2" ).append("\n"); 
		query.append("			              ,POL_3" ).append("\n"); 
		query.append("			              ,POL_4" ).append("\n"); 
		query.append("			              ,POL_CLPT_IND_SEQ_1" ).append("\n"); 
		query.append("			              ,DECODE(POD_4, '', DECODE(POD_3, '', DECODE(POD_2, '', VVD_1, VVD_2), VVD_3), VVD_4) AS LAST_VVD" ).append("\n"); 
		query.append("			              ,COALESCE(POD_4, POD_3, POD_2, POD_1) AS LAST_POD" ).append("\n"); 
		query.append("			              ,DECODE(POD_4, '', DECODE(POD_3, '', DECODE(POD_2, '', POD_CLPT_IND_SEQ_1, POD_CLPT_IND_SEQ_2), POD_CLPT_IND_SEQ_3), POD_CLPT_IND_SEQ_4) AS LAST_POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			              ,POD_1" ).append("\n"); 
		query.append("			              ,POD_2" ).append("\n"); 
		query.append("			              ,POD_3" ).append("\n"); 
		query.append("			          FROM (" ).append("\n"); 
		query.append("			                SELECT LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_1" ).append("\n"); 
		query.append("			                      ,LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_2" ).append("\n"); 
		query.append("			                      ,LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_3" ).append("\n"); 
		query.append("			                      ,LEAD(VSL_CD || SKD_VOY_NO || SKD_DIR_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_4" ).append("\n"); 
		query.append("			                      ,LEAD(POL_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_1" ).append("\n"); 
		query.append("			                      ,LEAD(POL_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_2" ).append("\n"); 
		query.append("			                      ,LEAD(POL_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_3" ).append("\n"); 
		query.append("			                      ,LEAD(POL_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_4" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CD, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_1" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_2" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CD, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_3" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CD, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_4" ).append("\n"); 
		query.append("			                      ,LEAD(POL_CLPT_IND_SEQ, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POL_CLPT_IND_SEQ_1" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CLPT_IND_SEQ, 0) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_1" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CLPT_IND_SEQ, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_2" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CLPT_IND_SEQ, 2) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_3" ).append("\n"); 
		query.append("			                      ,LEAD(POD_CLPT_IND_SEQ, 3) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS POD_CLPT_IND_SEQ_4" ).append("\n"); 
		query.append("			                      ,ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS RN" ).append("\n"); 
		query.append("			                      ,BKG_NO" ).append("\n"); 
		query.append("			                  FROM BKG_VVD" ).append("\n"); 
		query.append("			               )" ).append("\n"); 
		query.append("			         WHERE RN = 1" ).append("\n"); 
		query.append("			       ) VVD" ).append("\n"); 
		query.append("                  ,BKG_VVD TRUNK" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD1" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD2" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD3" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD4" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD5" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD6" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD7" ).append("\n"); 
		query.append("                  ,BKG_VVD VVD8" ).append("\n"); 
		query.append("			      ,VSK_VSL_PORT_SKD N1ST_SKD" ).append("\n"); 
		query.append("			      ,VSK_VSL_PORT_SKD LAST_SKD" ).append("\n"); 
		query.append("			      ,MDM_CUST_ADDR FF_ADDR" ).append("\n"); 
		query.append("			      ,MDM_CUST_ADDR SH_ADDR" ).append("\n"); 
		query.append("			 WHERE BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("			   AND BKG.PCTL_NO = PCTL.PCTL_NO" ).append("\n"); 
		query.append("			   AND BKG.BL_NO = IBD.BL_NO (+)" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = CNTR.BKG_NO (+)" ).append("\n"); 
		query.append("			   AND CNTR.BKG_NO = CM.BKG_NO (+)" ).append("\n"); 
		query.append("			   AND CNTR.CNTR_NO = CM.CNTR_NO (+)" ).append("\n"); 
		query.append("			   AND CM.CMDT_HS_CD = HS.HAMO_TRF_CD (+)" ).append("\n"); 
		query.append("			   AND HS.HAMO_TP_CD (+) = 'H'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = SH.BKG_NO" ).append("\n"); 
		query.append("			   AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = FF.BKG_NO" ).append("\n"); 
		query.append("			   AND FF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = NF.BKG_NO" ).append("\n"); 
		query.append("			   AND NF.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = AN.BKG_NO" ).append("\n"); 
		query.append("			   AND AN.BKG_CUST_TP_CD = 'A'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = CN.BKG_NO" ).append("\n"); 
		query.append("			   AND CN.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = SRD.BKG_NO (+)" ).append("\n"); 
		query.append("			   AND SRD.BKG_DOC_PROC_TP_CD (+) = 'OBLSRD'" ).append("\n"); 
		query.append("			   AND SRD.DOC_PERF_DELT_FLG (+) = 'N'" ).append("\n"); 
		query.append("			   AND SRD.EVNT_USR_ID = USR.USR_ID (+)" ).append("\n"); 
		query.append("			   AND BKG.OB_SLS_OFC_CD = SLS_ORG.OFC_CD (+)" ).append("\n"); 
		query.append("			   AND SLS_ORG.LOC_CD = SLS_LOC.LOC_CD (+)   " ).append("\n"); 
		query.append("			   AND BKG.CMDT_CD = CMDT.CMDT_CD" ).append("\n"); 
		query.append("			   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("			   AND FF.CUST_CNT_CD = FF_ADDR.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("			   AND FF.CUST_SEQ = FF_ADDR.CUST_SEQ (+)" ).append("\n"); 
		query.append("			   AND 'Y' = FF_ADDR.PRMRY_CHK_FLG (+)" ).append("\n"); 
		query.append("			   AND SH.CUST_CNT_CD = SH_ADDR.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("			   AND SH.CUST_SEQ = SH_ADDR.CUST_SEQ (+)" ).append("\n"); 
		query.append("			   AND 'S' = SH_ADDR.PRMRY_CHK_FLG (+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO         = TRUNK.BKG_NO(+)" ).append("\n"); 
		query.append("               AND BKG.VSL_CD         = TRUNK.VSL_CD(+)" ).append("\n"); 
		query.append("               AND BKG.SKD_VOY_NO     = TRUNK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND BKG.SKD_DIR_CD     = TRUNK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND 'T'                = TRUNK.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD1.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 1 = VVD1.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD1.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD2.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 2 = VVD2.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD2.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD3.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 3 = VVD3.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD3.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD4.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 4 = VVD4.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'U' = VVD4.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD5.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 1 = VVD5.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD5.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD6.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 2 = VVD6.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD6.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD7.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 3 = VVD7.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD7.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("               AND BKG.BKG_NO = VVD8.BKG_NO(+)" ).append("\n"); 
		query.append("               AND 4 = VVD8.VSL_SEQ(+)" ).append("\n"); 
		query.append("               AND 'S' = VVD8.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("			   AND SUBSTR(VVD.VVD_1, 1, 4) = N1ST_SKD.VSL_CD (+)" ).append("\n"); 
		query.append("			   AND SUBSTR(VVD.VVD_1, 5, 4) = N1ST_SKD.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("			   AND SUBSTR(VVD.VVD_1, -1) = N1ST_SKD.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("			   AND VVD.POL_1 = N1ST_SKD.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("			   AND VVD.POL_CLPT_IND_SEQ_1 = N1ST_SKD.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("			   AND SUBSTR(VVD.LAST_VVD, 1, 4) = LAST_SKD.VSL_CD (+)" ).append("\n"); 
		query.append("			   AND SUBSTR(VVD.LAST_VVD, 5, 4) = LAST_SKD.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("			   AND SUBSTR(VVD.LAST_VVD, -1) = LAST_SKD.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("			   AND VVD.LAST_POD = LAST_SKD.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("			   AND VVD.LAST_POD_CLPT_IND_SEQ = LAST_SKD.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("               AND BKG.BKG_STS_CD IN ('F', 'W', 'A') " ).append("\n"); 
		query.append("          #if (${sail_from_dt} != '') " ).append("\n"); 
		query.append("             AND N1ST_SKD.VPS_ETD_DT >= TO_DATE(@[sail_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${sail_to_dt} != '') " ).append("\n"); 
		query.append("             AND N1ST_SKD.VPS_ETD_DT <= TO_DATE(@[sail_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${pol_cd} != '') " ).append("\n"); 
		query.append("             AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("             AND BKG.POL_NOD_CD = @[pol_yard_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${arr_from_dt} != '') " ).append("\n"); 
		query.append("             AND LAST_SKD.VPS_ETA_DT >= TO_DATE(@[arr_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${arr_to_dt} != '') " ).append("\n"); 
		query.append("             AND LAST_SKD.VPS_ETA_DT <= TO_DATE(@[arr_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${pod_cd} != '') " ).append("\n"); 
		query.append("             AND BKG.POD_CD  = @[pod_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("             AND BKG.POD_NOD_CD  = @[pod_yard_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("    	  #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("             AND @[vvd_cd] IN (VVD.VVD_1,VVD.VVD_2,VVD.VVD_3,VVD.VVD_4)" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${dir_cd} != '')" ).append("\n"); 
		query.append("             AND BKG.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${por_cd} != '')" ).append("\n"); 
		query.append("             AND BKG.POR_CD       = @[por_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${del_cd} != '')" ).append("\n"); 
		query.append("             AND BKG.DEL_CD       = @[del_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${r_term} != '')" ).append("\n"); 
		query.append("             AND BKG.RCV_TERM_CD  IN (@[r_term])" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${d_term} != '')" ).append("\n"); 
		query.append("             AND BKG.DE_TERM_CD   IN (@[d_term])" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${bl_srnd_from_dt} != '')" ).append("\n"); 
		query.append("             AND SRD.EVNT_DT >= TO_DATE(@[bl_srnd_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${bl_srnd_to_dt} != '')" ).append("\n"); 
		query.append("             AND SRD.EVNT_DT <= TO_DATE(@[bl_srnd_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${trf_cd} != '')" ).append("\n"); 
		query.append("             AND @[trf_cd] IN (BKG.SC_NO, BKG.RFA_NO, BKG.TAA_NO)" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${crr_cd} != '')" ).append("\n"); 
		query.append("             AND BKG.SCAC_CD      = @[crr_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${obl_iss_usr_id} != '')" ).append("\n"); 
		query.append("             AND ISS.OBL_ISS_USR_ID LIKE @[obl_iss_usr_id]||'%' 	" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${bl_sts_cd} == 'RDY')" ).append("\n"); 
		query.append("             AND ISS.BL_RDY_FLG = 'Y'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'NRD')" ).append("\n"); 
		query.append("             AND ISS.BL_RDY_FLG = 'N'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'ISS')" ).append("\n"); 
		query.append("             AND ISS.OBL_ISS_FLG = 'Y'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'NIS')" ).append("\n"); 
		query.append("             AND ISS.OBL_ISS_FLG = 'N'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'PRT')" ).append("\n"); 
		query.append("             AND ISS.OBL_PRN_FLG = 'Y'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'NPT')" ).append("\n"); 
		query.append("             AND ISS.OBL_PRN_FLG = 'N'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'RLS')" ).append("\n"); 
		query.append("             AND ISS.OBL_RLSE_FLG = 'Y'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'SRR')" ).append("\n"); 
		query.append("             AND ISS.OBL_SRND_FLG = 'Y'" ).append("\n"); 
		query.append("          #elseif (${bl_sts_cd} == 'RCV')" ).append("\n"); 
		query.append("             AND ISS.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${por_cd2} != '')" ).append("\n"); 
		query.append("             AND SUBSTR(BKG.POR_CD, 1, 2) = @[por_cd2]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${pod_cd2} != '')" ).append("\n"); 
		query.append("             AND SUBSTR(BKG.POD_CD, 1, 2) = @[pod_cd2]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${internet_bl} != '')" ).append("\n"); 
		query.append("             AND ISS.OBL_INET_FLG      = @[internet_bl]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${vvd_cd2} != '')" ).append("\n"); 
		query.append("             AND LAST_SKD.VSL_CD = SUBSTR(@[vvd_cd2],1,4)" ).append("\n"); 
		query.append("             AND LAST_SKD.SKD_VOY_NO = SUBSTR(@[vvd_cd2],5,4)" ).append("\n"); 
		query.append("             AND LAST_SKD.SKD_DIR_CD = SUBSTR(@[vvd_cd2],9,1)" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${bl_rlse_ofc_cd} != '')" ).append("\n"); 
		query.append("             AND ISS.OBL_ISS_OFC_CD = @[bl_rlse_ofc_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${bl_srnd_ofc_cd} != '')" ).append("\n"); 
		query.append("             AND USR.OFC_CD = @[bl_srnd_ofc_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cptr_ofc_cd} != '')" ).append("\n"); 
		query.append("             AND ISS.OBL_ISS_OFC_CD = @[cptr_ofc_cd]" ).append("\n"); 
		query.append("          #end      " ).append("\n"); 
		query.append("          #if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '')" ).append("\n"); 
		query.append("           #if(${cust_cnt_cd} !='' && ${cust_seq} != '')" ).append("\n"); 
		query.append("             AND ( 1=2" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("              OR (SH.CUST_CNT_CD = @[cust_cnt_cd] AND SH.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("              OR (CN.CUST_CNT_CD = @[cust_cnt_cd] AND CN.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("              OR (NF.CUST_CNT_CD = @[cust_cnt_cd] AND NF.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("              OR (FF.CUST_CNT_CD = @[cust_cnt_cd] AND FF.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("              OR (AN.CUST_CNT_CD = @[cust_cnt_cd] AND AN.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${cust_nm} !='')" ).append("\n"); 
		query.append("             AND ( 1=2" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("              OR SH.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("              OR CN.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("              OR NF.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("              OR FF.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("              OR AN.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${cust_grp_id} !='')					--SJH.20150129.ADD" ).append("\n"); 
		query.append("             AND ( 1=2" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("    		  OR (SH.CUST_CNT_CD, SH.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("              OR (CN.CUST_CNT_CD, CN.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("              OR (NF.CUST_CNT_CD, NF.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("              OR (FF.CUST_CNT_CD, FF.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("              OR (AN.CUST_CNT_CD, AN.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    #if (${sc_rfa_gbn} == 'S') " ).append("\n"); 
		query.append("	     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("	               AND BKG.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("	     #end" ).append("\n"); 
		query.append("	    #elseif (${sc_rfa_gbn} == 'R') " ).append("\n"); 
		query.append("	     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("	               AND BKG.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("	     #end" ).append("\n"); 
		query.append("	    #elseif (${sc_rfa_gbn} == 'T') " ).append("\n"); 
		query.append("	     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("	               AND BKG.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("	     #end" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ) Z" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("    #if (${bl_prn_from_dt} != '') " ).append("\n"); 
		query.append("       AND TO_DATE(BL_PRT_DT,'YYYY-MM-DD HH24:MI') >= TO_DATE(@[bl_prn_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_prn_to_dt} != '') " ).append("\n"); 
		query.append("       AND TO_DATE(BL_PRT_DT,'YYYY-MM-DD HH24:MI') <= TO_DATE(@[bl_prn_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${cgo_rlse_sts_cd} != '')" ).append("\n"); 
		query.append("       AND RLSE_STS_CD = @[cgo_rlse_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${bl_tp_cd} == 'H')" ).append("\n"); 
		query.append("       AND HBL_NO IS NOT NULL" ).append("\n"); 
		query.append("    #elseif (${bl_tp_cd} == 'M')" ).append("\n"); 
		query.append("       AND BKG_STS_CD = 'S'" ).append("\n"); 
		query.append("    #elseif (${bl_tp_cd} == 'O')" ).append("\n"); 
		query.append("       AND (HBL_NO IS NULL AND BKG_STS_CD <> 'S' AND BL_TP_CD <> 'W')" ).append("\n"); 
		query.append("    #elseif (${bl_tp_cd} == 'W')" ).append("\n"); 
		query.append("       AND BL_TP_CD = 'W'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 end" ).append("\n"); 
		query.append("	#if (${orderby} != '')" ).append("\n"); 
		query.append("       ORDER BY ${orderby}" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}