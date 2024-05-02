/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchBokCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
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

public class StatusReportDBDAOSearchBokCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAOSearchBokCntrListRSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBokCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_en",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctr_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_a",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("b_staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_mt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_wgt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sts_cd_op",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_tn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_vl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd_w",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grs_wgt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_oc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sts_cd_vs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sts_cd_ic",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_x",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd_ts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBokCntrListRSQL").append("\n"); 
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
		query.append("SELECT NVL(COUNT(DISTINCT BKG_Z.BKG_NO) OVER(),0) TOTAL_BKG," ).append("\n"); 
		query.append("	   NVL(COUNT(DISTINCT BKG_Z.CNTR_NO) OVER(),0) TOTAL_CNTR," ).append("\n"); 
		query.append("	   NVL(SUM(DECODE(CNTR_1,1,PCK_QTY,0)) OVER(),0) AS TTL_PCK_QTY," ).append("\n"); 
		query.append("	   NVL(SUM(DECODE(BKG_1,1,TEU,0)) OVER(),0) AS TTL_TEU," ).append("\n"); 
		query.append("	   NVL(SUM(DECODE(BKG_1,1,FEU,0)) OVER(),0) AS TTL_FEU," ).append("\n"); 
		query.append("	   RTRIM(TO_CHAR(SUM(DECODE(CNTR_1,1,GRS_WGT_KG,0)) OVER(), 'FM999,999,999.9'), '.') AS TTL_GRS_WGT_KG," ).append("\n"); 
		query.append("	   RTRIM(TO_CHAR(SUM(DECODE(CNTR_1,1,GRS_WGT_LB,0)) OVER(), 'FM999,999,999.9'), '.') AS TTL_GRS_WGT_LB," ).append("\n"); 
		query.append("	   RTRIM(TO_CHAR(SUM(DECODE(CNTR_1,1,TARE_WGT,0)) OVER(), 'FM999,999,999.9'), '.') AS TTL_TARE_WGT_KG," ).append("\n"); 
		query.append("	   RTRIM(TO_CHAR(SUM(DECODE(CNTR_1,1,TARE_LBS,0)) OVER(), 'FM999,999,999.9'), '.') AS TTL_TARE_WGT_LB," ).append("\n"); 
		query.append("	   RTRIM(TO_CHAR(SUM(DECODE(BKG_1,1,CGO_WGT_KG,0)) OVER(), 'FM999,999,999.9'), '.') AS TTL_CGO_WGT_KG," ).append("\n"); 
		query.append("	   RTRIM(TO_CHAR(SUM(DECODE(BKG_1,1,CGO_WGT_LB,0)) OVER(), 'FM999,999,999.9'), '.') AS TTL_CGO_WGT_LB," ).append("\n"); 
		query.append("	   CASE WHEN GRS_WGT_KG>=0 AND GRS_WGT_KG<10000 THEN 'L'" ).append("\n"); 
		query.append("            WHEN GRS_WGT_KG>10000 AND GRS_WGT_KG<=16000 THEN 'M'" ).append("\n"); 
		query.append("            WHEN GRS_WGT_KG>16000 AND GRS_WGT_KG<=22000 THEN 'H'" ).append("\n"); 
		query.append("            ELSE 'XH'" ).append("\n"); 
		query.append("       END AS WGT_BND," ).append("\n"); 
		query.append("       (SELECT YD_NM" ).append("\n"); 
		query.append("          FROM MDM_YARD MDM " ).append("\n"); 
		query.append("         WHERE MDM.YD_CD = BKG_Z.IB_PKUP_YD_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS IB_PKUP_YD_NM," ).append("\n"); 
		query.append("       COP_EE.EST_PKUP_DT," ).append("\n"); 
		query.append("       COP_EE.ACT_PKUP_DT," ).append("\n"); 
		query.append("       COP_EE.MTY_PKUP_LOC," ).append("\n"); 
		query.append("       COP_IO.EST_RTN_DT," ).append("\n"); 
		query.append("       COP_IO.ACT_RTN_DT," ).append("\n"); 
		query.append("       COP_IO.FULL_RTN_LOC," ).append("\n"); 
		query.append("       COP_MT.MTY_RTN_LOC," ).append("\n"); 
		query.append("       SUBSTR(SCE_COP_DLV_DT_FNC(COP_EE.COP_NO, BKG_Z.BKG_NO), 1, INSTR(SCE_COP_DLV_DT_FNC(COP_EE.COP_NO, BKG_Z.BKG_NO), '#', 1, 1)-1 ) AS CGO_AVAL_DT," ).append("\n"); 
		query.append("       NVL((SELECT /*+ INDEX_DESC(MN XPKPRI_TAA_MN)*/" ).append("\n"); 
		query.append("               MDM.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM PRI_TAA_MN MN," ).append("\n"); 
		query.append("               PRI_TAA_HDR HDR," ).append("\n"); 
		query.append("               MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("         WHERE MN.TAA_PROP_NO = HDR.TAA_PROP_NO" ).append("\n"); 
		query.append("           AND HDR.TAA_NO = BKG_Z.TAA_NO" ).append("\n"); 
		query.append("           AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("           AND MDM.CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND MDM.CUST_SEQ = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1    --TAA" ).append("\n"); 
		query.append("       ),NVL(" ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(MN XPKPRI_RP_MN)*/" ).append("\n"); 
		query.append("               MDM.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM PRI_RP_MN MN," ).append("\n"); 
		query.append("               PRI_RP_HDR HDR," ).append("\n"); 
		query.append("               MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("         WHERE MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("           AND HDR.RFA_NO = BKG_Z.RFA_NO" ).append("\n"); 
		query.append("           AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("           AND MDM.CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND MDM.CUST_SEQ = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1   --RFA" ).append("\n"); 
		query.append("       )," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(MN XPKPRI_SP_MN)*/" ).append("\n"); 
		query.append("               MDM.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM PRI_SP_MN MN," ).append("\n"); 
		query.append("               PRI_SP_HDR HDR," ).append("\n"); 
		query.append("               PRI_SP_CTRT_PTY PTY," ).append("\n"); 
		query.append("               MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("         WHERE MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("           AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("           AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("           AND HDR.SC_NO = BKG_Z.SC_NO" ).append("\n"); 
		query.append("           AND PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("           AND MDM.CUST_CNT_CD = PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND MDM.CUST_SEQ = PTY.CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1   --SC" ).append("\n"); 
		query.append("       ))) AS CTRT_CUST," ).append("\n"); 
		query.append("       DECODE(NVL(CMRN_REF_NO,''),'','N','Y') AS XPT_DECL_RCV," ).append("\n"); 
		query.append("       BKG_Z.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT ROW_NUMBER() OVER (PARTITION BY BK.BKG_NO ORDER BY CNTR.CNTR_NO) AS BKG_1," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY BK.BKG_NO, CNTR.CNTR_NO ORDER BY CM.CNTR_MF_SEQ) AS CNTR_1," ).append("\n"); 
		query.append("        --BKG & B/L Info" ).append("\n"); 
		query.append("               BK.BL_NO," ).append("\n"); 
		query.append("               ISS.OBL_ISS_OFC_CD," ).append("\n"); 
		query.append("               TO_CHAR(BK.CRE_DT,'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("               BK.BKG_NO," ).append("\n"); 
		query.append("               BK.BKG_OFC_CD," ).append("\n"); 
		query.append("               BK.CRE_USR_ID," ).append("\n"); 
		query.append("               BK.BKG_STS_CD," ).append("\n"); 
		query.append("               BK.CTRT_SREP_CD," ).append("\n"); 
		query.append("               BK.OB_SREP_CD," ).append("\n"); 
		query.append("               NVL((SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = BK.BKG_NO AND ROWNUM=1),'N') AS RATE_STS," ).append("\n"); 
		query.append("               (SELECT LOC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = BK.BKG_OFC_CD) AS SLS_AREA," ).append("\n"); 
		query.append("               BK.OB_SREP_CD AS SLS_CD," ).append("\n"); 
		query.append("               BK.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("               BK.SCAC_CD," ).append("\n"); 
		query.append("               BK.STWG_CD AS SPCL_HNDL_INST," ).append("\n"); 
		query.append("               BK.SPLIT_FLG," ).append("\n"); 
		query.append("               REPLACE(BK.XTER_RMK,CHR(10),' ') AS XTER_RMK," ).append("\n"); 
		query.append("               REPLACE(BK.INTER_RMK,CHR(10),' ') AS INTER_RMK," ).append("\n"); 
		query.append("               REPLACE(BK.VNDR_RMK,CHR(10),' ') AS VNDR_RMK," ).append("\n"); 
		query.append("        --Cargo & Commodity" ).append("\n"); 
		query.append("               CM.MEAS_QTY AS LCL_MEAS_QTY," ).append("\n"); 
		query.append("               CM.MEAS_UT_CD AS LCL_MEAS_UT_CD," ).append("\n"); 
		query.append("               NVL(SUBSTR(DECODE(BK.DCGO_FLG,'Y',',DG','')||DECODE(BK.RC_FLG,'Y',',RF','')||DECODE(BK.AWK_CGO_FLG,'Y',',AW','')||DECODE(BK.BB_CGO_FLG,'Y',',BB','')||DECODE(BK.RD_CGO_FLG,'Y',',RD',''),2),'DR') AS CGO_N," ).append("\n"); 
		query.append("               ROUND(DECODE(DOC.WGT_UT_CD, 'KGS', DOC.ACT_WGT, ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3)),1) AS CGO_WGT_KG,--BKG별 WEIGHT" ).append("\n"); 
		query.append("               ROUND(DECODE(DOC.WGT_UT_CD, 'KGS', ROUND(NVL(DOC.ACT_WGT,0)*2.2046,3), DOC.ACT_WGT),2) AS CGO_WGT_LB," ).append("\n"); 
		query.append("               BK.CMDT_CD AS CMDT_CD," ).append("\n"); 
		query.append("               (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BK.CMDT_CD) AS CMDT_DESC," ).append("\n"); 
		query.append("               CM.CMDT_HS_CD AS CMDT_HS_CD," ).append("\n"); 
		query.append("               SUBSTR(CM.CMDT_HS_CD,1,4) AS CMDT_HS_GRP_CD," ).append("\n"); 
		query.append("               CM.HAMO_TRF_CD AS HTS_CD," ).append("\n"); 
		query.append("               CM.NCM_NO," ).append("\n"); 
		query.append("               CM.PCK_QTY AS LCL_PCK_QTY," ).append("\n"); 
		query.append("               DECODE(BK.RCV_TERM_CD, 'S', BK.POR_CD, '') AS OB_CFS_LOC," ).append("\n"); 
		query.append("               REPLACE(CM.CNTR_MF_GDS_DESC,CHR(10),' ') AS LCL_CNTR_MF_GDS_DESC," ).append("\n"); 
		query.append("               CM.PCK_TP_CD AS LCL_PCK_TP_CD," ).append("\n"); 
		query.append("        --Container" ).append("\n"); 
		query.append("               NVL((SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD = 'F' AND BKG_NO=BK.BKG_NO),(SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD='R' AND BKG_NO=BK.BKG_NO)) AS CGO_CUTOFF_DT," ).append("\n"); 
		query.append("               ROUND(DECODE(CNTR.WGT_UT_CD, 'KGS', CNTR.CNTR_WGT, ROUND(NVL(CNTR.CNTR_WGT,0)*0.4536,3)),1) AS GRS_WGT_KG,--CNTR별 WEIGHT" ).append("\n"); 
		query.append("               ROUND(DECODE(CNTR.WGT_UT_CD, 'KGS', ROUND(NVL(CNTR.CNTR_WGT,0)*2.2046,3), CNTR.CNTR_WGT),2) AS GRS_WGT_LB," ).append("\n"); 
		query.append("               CNTR.CNTR_NO," ).append("\n"); 
		query.append("               CNTR.CNTR_VOL_QTY," ).append("\n"); 
		query.append("               (SELECT SUM(DECODE(CNTR_SZ_CD, 2, 1, 2) * OP_CNTR_QTY)" ).append("\n"); 
		query.append("                  FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("                       MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                 WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                   AND QTY.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD) AS TEU," ).append("\n"); 
		query.append("               (SELECT SUM(DECODE(CNTR_SZ_CD, 2, 0.5, 1) * OP_CNTR_QTY)" ).append("\n"); 
		query.append("                  FROM BKG_QUANTITY QTY," ).append("\n"); 
		query.append("                       MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                 WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                   AND QTY.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD) AS FEU," ).append("\n"); 
		query.append("               CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               CNTR.CNMV_STS_CD," ).append("\n"); 
		query.append("               (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00252' AND INTG_CD_VAL_CTNT = CNTR.CNMV_STS_CD) AS CNMV_STS_DESC," ).append("\n"); 
		query.append("               NVL((SELECT B.TARE_WGT" ).append("\n"); 
		query.append("                      FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                          ,MST_CNTR_SPEC B" ).append("\n"); 
		query.append("                     WHERE A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                       AND A.CNTR_NO = CNTR.CNTR_NO)" ).append("\n"); 
		query.append("                 , (SELECT CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                      FROM MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                     WHERE MDM.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("               ) AS TARE_WGT," ).append("\n"); 
		query.append("               NVL((SELECT ROUND(B.TARE_WGT * 0.00045,2)" ).append("\n"); 
		query.append("                      FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                          ,MST_CNTR_SPEC B" ).append("\n"); 
		query.append("                     WHERE A.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                       AND A.CNTR_NO = CNTR.CNTR_NO)" ).append("\n"); 
		query.append("                 , (SELECT ROUND(CNTR_TPSZ_TARE_WGT * 0.00045,2)" ).append("\n"); 
		query.append("                      FROM MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                     WHERE MDM.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("               ) AS TARE_LBS," ).append("\n"); 
		query.append("               (SELECT PKUP_YD_CD FROM BKG_PKUP_NTC_PKUP_NO WHERE BKG_NO = BK.BKG_NO AND CNTR_NO = CNTR.CNTR_NO AND ROWNUM = 1) AS IB_PKUP_YD_CD," ).append("\n"); 
		query.append("               (SELECT CSTMS_LOC_CD FROM BKG_CSTMS_ADV_BL WHERE BKG_NO = BK.BKG_NO AND BL_NO = BK.BL_NO AND CNT_CD = 'US') AS IB_CLR_LOC_CD," ).append("\n"); 
		query.append("               NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'C', 'M')" ).append("\n"); 
		query.append("                        FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                       WHERE TRO.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                         AND TRO.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                         AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                         AND TRO.CXL_FLG = 'N'), DECODE(BK.DE_TERM_CD, 'D', 'C', 'M')) AS IB_HLG_BKG," ).append("\n"); 
		query.append("               DECODE(BK.RCV_TERM_CD, 'D', 'C', 'M') AS OB_HLG_BKG," ).append("\n"); 
		query.append("               CNTR.PCK_TP_CD," ).append("\n"); 
		query.append("               CNTR.PCK_QTY," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                     FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                    WHERE BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                                      AND CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                      AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("                           ),',') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("               (SELECT COUNT(CNTR_SEAL_SEQ)" ).append("\n"); 
		query.append("                  FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                 WHERE BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("                   AND CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                 GROUP BY BKG_NO, CNTR_NO) AS CNTR_SEAL_CNT," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD||'-'||EQ_SUBST_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                     FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                    WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                      AND EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                           ),',') AS EQ_SUBST_TP," ).append("\n"); 
		query.append("        --Customer" ).append("\n"); 
		query.append("               (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = C.CUST_CNT_CD AND CUST_SEQ = C.CUST_SEQ) AS C_CUST," ).append("\n"); 
		query.append("               (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = F.CUST_CNT_CD AND CUST_SEQ = F.CUST_SEQ) AS F_CUST," ).append("\n"); 
		query.append("               (SELECT CNTC_PSON_NM FROM MDM_CUST_ADDR WHERE CUST_CNT_CD = F.CUST_CNT_CD AND CUST_SEQ = F.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS F_CNTC_NM," ).append("\n"); 
		query.append("               (SELECT PHN_NO FROM MDM_CUST_CNTC_PNT WHERE CUST_CNT_CD = F.CUST_CNT_CD AND CUST_SEQ = F.CUST_SEQ AND ROWNUM = 1) AS F_CNTC_NO," ).append("\n"); 
		query.append("               F.CUST_CNT_CD AS F_CNT_CD," ).append("\n"); 
		query.append("               (SELECT STE_CD FROM MDM_CUST_ADDR WHERE CUST_CNT_CD = F.CUST_CNT_CD AND CUST_SEQ = F.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS F_STE_CD," ).append("\n"); 
		query.append("               (SELECT CUST_GRP_ID FROM MDM_CUSTOMER WHERE CUST_CNT_CD = S.CUST_CNT_CD AND CUST_SEQ = S.CUST_SEQ) AS S_GRP_CUST," ).append("\n"); 
		query.append("               '' AS CTRL_PTY, --BKG MAIN 작업 후 컬럼 매핑 해야 함" ).append("\n"); 
		query.append("               (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = S.CUST_CNT_CD AND CUST_SEQ = S.CUST_SEQ) AS S_CUST_NM," ).append("\n"); 
		query.append("               (SELECT CNTC_PSON_NM FROM MDM_CUST_ADDR WHERE CUST_CNT_CD = S.CUST_CNT_CD AND CUST_SEQ = S.CUST_SEQ AND PRMRY_CHK_FLG = 'Y' AND ROWNUM = 1) AS S_CNTC_NM," ).append("\n"); 
		query.append("               (SELECT PHN_NO FROM MDM_CUST_CNTC_PNT WHERE CUST_CNT_CD = S.CUST_CNT_CD AND CUST_SEQ = S.CUST_SEQ AND ROWNUM = 1) AS S_CNTC_NO," ).append("\n"); 
		query.append("        --Reference No" ).append("\n"); 
		query.append("               EBFF.CUST_REF_NO_CTNT AS EBFF_REF_NO," ).append("\n"); 
		query.append("               EBRF.CUST_REF_NO_CTNT AS EBRF_REF_NO," ).append("\n"); 
		query.append("               EBSH.CUST_REF_NO_CTNT AS EBSH_REF_NO," ).append("\n"); 
		query.append("               DECODE(DG.SPCL_CGO_APRO_CD,'Y','Y','N') AS DG_CERTI_FLG," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT EUR_BL.MVMT_REF_NO" ).append("\n"); 
		query.append("									 FROM BKG_CSTMS_EUR_BL EUR_BL" ).append("\n"); 
		query.append("									WHERE BK.BL_NO = EUR_BL.BL_NO),';') AS ENS_MRN," ).append("\n"); 
		query.append("               DECODE(CNTR.CNTR_NO, NULL, " ).append("\n"); 
		query.append("                                      BKG_JOIN_FNC(CURSOR(SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                                            FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                                           WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                             AND CUCR.BKG_REF_TP_CD = 'CMRN'" ).append("\n"); 
		query.append("                                                           ORDER BY CUCR.REF_SEQ" ).append("\n"); 
		query.append("                                                          ),',')," ).append("\n"); 
		query.append("                                      (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                         FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                        WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                          AND CUCR.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                          AND CUCR.BKG_REF_TP_CD = 'CMRN')) AS CMRN_REF_NO," ).append("\n"); 
		query.append("               BKG_JOIN_FNC(CURSOR(SELECT EX_EUR_BL.MVMT_REF_NO" ).append("\n"); 
		query.append("									 FROM BKG_CSTMS_EUR_IO_BL EX_EUR_BL" ).append("\n"); 
		query.append("									WHERE BK.BL_NO = EX_EUR_BL.BL_NO),';') AS EXS_MRN," ).append("\n"); 
		query.append("               FINV.CUST_REF_NO_CTNT AS FINV_REF_NO," ).append("\n"); 
		query.append("               (SELECT AES_INLND_TRNS_NO FROM BKG_XPT_IMP_LIC WHERE BKG_NO = BK.BKG_NO AND IO_BND_CD = 'O' AND CNT_CD = 'US' AND ROWNUM = 1) AS AES_ITN_NO," ).append("\n"); 
		query.append("               CNTR.PO_NO," ).append("\n"); 
		query.append("               RGBK.CUST_REF_NO_CTNT AS RGBK_REF_NO," ).append("\n"); 
		query.append("               ESSH.CUST_REF_NO_CTNT AS ESSH_REF_NO," ).append("\n"); 
		query.append("               ESFF.CUST_REF_NO_CTNT AS ESFF_REF_NO," ).append("\n"); 
		query.append("               ESRF.CUST_REF_NO_CTNT AS ESRF_REF_NO," ).append("\n"); 
		query.append("               BK.TWN_SO_NO," ).append("\n"); 
		query.append("               BK.SI_FLG," ).append("\n"); 
		query.append("               DECODE(CNTR.CNTR_NO, NULL, " ).append("\n"); 
		query.append("                                      BKG_JOIN_FNC(CURSOR(SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                                            FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                                           WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                             AND CUCR.BKG_REF_TP_CD = 'CUCR'" ).append("\n"); 
		query.append("                                                           ORDER BY CUCR.REF_SEQ" ).append("\n"); 
		query.append("                                                          ),',')," ).append("\n"); 
		query.append("                                      (SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("                                         FROM BKG_REFERENCE CUCR" ).append("\n"); 
		query.append("                                        WHERE CUCR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                          AND CUCR.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("                                          AND CUCR.BKG_REF_TP_CD = 'CUCR')) AS CUCR_REF_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        --Route & Schedule" ).append("\n"); 
		query.append("               BK.BLCK_STWG_CD," ).append("\n"); 
		query.append("               BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD AS T_VVD," ).append("\n"); 
		query.append("               (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = BK.VSL_CD) AS T_VSL_NM," ).append("\n"); 
		query.append("               COA.TRD_CD," ).append("\n"); 
		query.append("               COA.SVC_SCP_CD," ).append("\n"); 
		query.append("               BK.DE_TERM_CD," ).append("\n"); 
		query.append("               BK.RCV_TERM_CD," ).append("\n"); 
		query.append("               (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) AS POR_CNT_CD," ).append("\n"); 
		query.append("               BK.POR_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD) AS POR_NM," ).append("\n"); 
		query.append("               VVD5.POL_CD AS VVD1_POL_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD5.POL_CD) AS VVD1_POL_NM," ).append("\n"); 
		query.append("               VVD6.POL_CD AS VVD2_POL_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD6.POL_CD) AS VVD2_POL_NM," ).append("\n"); 
		query.append("               VVD7.POL_CD AS VVD3_POL_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD7.POL_CD) AS VVD3_POL_NM," ).append("\n"); 
		query.append("               VVD8.POL_CD AS VVD4_POL_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD8.POL_CD) AS VVD4_POL_NM," ).append("\n"); 
		query.append("               VVD5.POD_CD AS VVD1_POD_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD5.POD_CD) AS VVD1_POD_NM," ).append("\n"); 
		query.append("               VVD6.POD_CD AS VVD2_POD_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD6.POD_CD) AS VVD2_POD_NM," ).append("\n"); 
		query.append("               VVD7.POD_CD AS VVD3_POD_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD7.POD_CD) AS VVD3_POD_NM," ).append("\n"); 
		query.append("               VVD8.POD_CD AS VVD4_POD_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD8.POD_CD) AS VVD4_POD_NM," ).append("\n"); 
		query.append("               BK.POD_CD AS LAST_POD_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POD_CD) AS LAST_POD_NM," ).append("\n"); 
		query.append("               (SELECT CNT_CD FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) AS DEL_CNT_CD," ).append("\n"); 
		query.append("               BK.DEL_CD," ).append("\n"); 
		query.append("               (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) AS DEL_NM," ).append("\n"); 
		query.append("               VVD5.VSL_CD||VVD5.SKD_VOY_NO||VVD5.SKD_DIR_CD AS PRE1_VVD," ).append("\n"); 
		query.append("               VVD6.VSL_CD||VVD6.SKD_VOY_NO||VVD6.SKD_DIR_CD AS PRE2_VVD," ).append("\n"); 
		query.append("               VVD7.VSL_CD||VVD7.SKD_VOY_NO||VVD7.SKD_DIR_CD AS PRE3_VVD," ).append("\n"); 
		query.append("               VVD8.VSL_CD||VVD8.SKD_VOY_NO||VVD8.SKD_DIR_CD AS PRE4_VVD," ).append("\n"); 
		query.append("               VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD AS POST1_VVD," ).append("\n"); 
		query.append("               VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD AS POST2_VVD," ).append("\n"); 
		query.append("               VVD3.VSL_CD||VVD3.SKD_VOY_NO||VVD3.SKD_DIR_CD AS POST3_VVD," ).append("\n"); 
		query.append("               VVD4.VSL_CD||VVD4.SKD_VOY_NO||VVD4.SKD_DIR_CD AS POST4_VVD," ).append("\n"); 
		query.append("               DECODE(NVL(CNTR.DE_TERM_CD, BK.DE_TERM_CD),'S','LCL','FCL') AS TRAF_MOD_IB," ).append("\n"); 
		query.append("               DECODE(NVL(CNTR.RCV_TERM_CD, BK.RCV_TERM_CD),'S','LCL','FCL') AS TRAF_MOD_OB," ).append("\n"); 
		query.append("               BK.DEST_TRNS_MOD_CD AS TRSP_MOD_IB," ).append("\n"); 
		query.append("               BK.ORG_TRNS_MOD_CD AS TRSP_MOD_OB," ).append("\n"); 
		query.append("               BK.SLAN_CD AS TRUNK_SLAN_CD," ).append("\n"); 
		query.append("               TRUNK.POD_CD AS TRUNK_POD_CD," ).append("\n"); 
		query.append("               TRUNK.POL_CD AS TRUNK_POL_CD," ).append("\n"); 
		query.append("               BK.VSL_CD AS TRUNK_VSL_CD," ).append("\n"); 
		query.append("               (SELECT TO_CHAR(NVL(MNL_SET_DT,SYS_SET_DT),'YYYY-MM-DD HH24:MI') FROM BKG_CLZ_TM WHERE CLZ_TP_CD = 'T' AND BKG_NO=BK.BKG_NO) AS FIRST_POL_CUTOFF_DT," ).append("\n"); 
		query.append("               TO_CHAR(N1ST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') AS FIRST_POL_ETB," ).append("\n"); 
		query.append("               TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') AS FIRST_POL_ETD," ).append("\n"); 
		query.append("               DECODE(N1ST_SKD.ACT_INP_FLG,'Y',TO_CHAR(N1ST_SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),'') AS FIRST_POL_ATD," ).append("\n"); 
		query.append("               TO_CHAR(LAST_SKD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') AS LAST_POD_ETB," ).append("\n"); 
		query.append("               TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS LAST_POD_ETA," ).append("\n"); 
		query.append("               DECODE(LAST_SKD.ACT_INP_FLG,'Y',TO_CHAR(LAST_SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),'') AS LAST_POD_ATA," ).append("\n"); 
		query.append("        --Rate & Invoice" ).append("\n"); 
		query.append("               BK.RFA_NO," ).append("\n"); 
		query.append("               BK.SC_NO," ).append("\n"); 
		query.append("               BK.TAA_NO," ).append("\n"); 
		query.append("        --Reefer Info" ).append("\n"); 
		query.append("               RF.CTRL_ATMS_FLG," ).append("\n"); 
		query.append("               RF.MODI_ATMS_FLG," ).append("\n"); 
		query.append("               REPLACE(RF.DIFF_RMK,CHR(10),' ') AS RF_RMK," ).append("\n"); 
		query.append("               RF.CDO_TEMP AS RF_TEMP," ).append("\n"); 
		query.append("               DECODE(RF.CNTR_VENT_TP_CD,'P',RF.VENT_RTO||'%',RF.CBM_PER_HR_QTY||'CMH') AS VENT," ).append("\n"); 
		query.append("        --AK Info" ).append("\n"); 
		query.append("               REPLACE(AWK.DIFF_RMK,CHR(10),' ') AS AWK_RMK," ).append("\n"); 
		query.append("               AWK.GRS_WGT AS AWK_GRS_WGT," ).append("\n"); 
		query.append("               AWK.NET_WGT AS AWK_NET_WGT," ).append("\n"); 
		query.append("               AWK.OVR_FWRD_LEN AS AWK_OVR_FWRD_LEN," ).append("\n"); 
		query.append("               AWK.OVR_HGT AS AWK_OVR_HGT," ).append("\n"); 
		query.append("               AWK.OVR_LF_LEN AS AWK_OVR_LF_LEN," ).append("\n"); 
		query.append("               AWK.OVR_BKWD_LEN AS AWK_OVR_BKWD_LEN," ).append("\n"); 
		query.append("               AWK.OVR_RT_LEN AS AWK_OVR_RT_LEN," ).append("\n"); 
		query.append("               AWK.TTL_DIM_HGT AS AWK_TTL_DIM_HGT," ).append("\n"); 
		query.append("               AWK.TTL_DIM_LEN AS AWK_TTL_DIM_LEN," ).append("\n"); 
		query.append("               AWK.TTL_DIM_WDT AS AWK_TTL_DIM_WDT," ).append("\n"); 
		query.append("        --DG Info" ).append("\n"); 
		query.append("               REPLACE(DG.DIFF_RMK,CHR(10),' ') AS DG_RMK," ).append("\n"); 
		query.append("               DG.IMDG_CLSS_CD," ).append("\n"); 
		query.append("               DG.IMDG_UN_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("               BKG_BL_ISS ISS," ).append("\n"); 
		query.append("               BKG_BL_DOC DOC," ).append("\n"); 
		query.append("               BKG_CUSTOMER S," ).append("\n"); 
		query.append("               BKG_CUSTOMER C," ).append("\n"); 
		query.append("               BKG_CUSTOMER F," ).append("\n"); 
		query.append("#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("               BKG_CUSTOMER N," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("               BKG_CUSTOMER A," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               BKG_REFERENCE FINV," ).append("\n"); 
		query.append("               BKG_REFERENCE EBRF," ).append("\n"); 
		query.append("               BKG_REFERENCE EBSH," ).append("\n"); 
		query.append("               BKG_REFERENCE EBFF," ).append("\n"); 
		query.append("               BKG_REFERENCE ESRF," ).append("\n"); 
		query.append("               BKG_REFERENCE ESSH," ).append("\n"); 
		query.append("               BKG_REFERENCE ESFF," ).append("\n"); 
		query.append("               BKG_REFERENCE RGBK," ).append("\n"); 
		query.append("               COA_RGST_BKG COA," ).append("\n"); 
		query.append("               BKG_VVD VVD1," ).append("\n"); 
		query.append("               BKG_VVD VVD2," ).append("\n"); 
		query.append("               BKG_VVD VVD3," ).append("\n"); 
		query.append("               BKG_VVD VVD4," ).append("\n"); 
		query.append("               BKG_VVD VVD5," ).append("\n"); 
		query.append("               BKG_VVD VVD6," ).append("\n"); 
		query.append("               BKG_VVD VVD7," ).append("\n"); 
		query.append("               BKG_VVD VVD8," ).append("\n"); 
		query.append("               BKG_VVD TRUNK," ).append("\n"); 
		query.append("               BKG_VVD N1ST_VVD," ).append("\n"); 
		query.append("               BKG_VVD LAST_VVD," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD N1ST_SKD," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD LAST_SKD," ).append("\n"); 
		query.append("               BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("               BKG_CNTR_MF_DESC CM," ).append("\n"); 
		query.append("               BKG_AWK_CGO AWK," ).append("\n"); 
		query.append("               BKG_DG_CGO DG," ).append("\n"); 
		query.append("               BKG_RF_CGO RF," ).append("\n"); 
		query.append("               SCE_COP_HDR COP             " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = DOC.BKG_NO" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = CM.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = COA.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = AWK.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = AWK.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = DG.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = DG.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = RF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.BKG_NO  = COP.BKG_NO(+)" ).append("\n"); 
		query.append("           AND CNTR.CNTR_NO = COP.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = S.BKG_NO" ).append("\n"); 
		query.append("           AND S.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = C.BKG_NO" ).append("\n"); 
		query.append("           AND C.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("           AND BK.BKG_NO    = F.BKG_NO" ).append("\n"); 
		query.append("           AND F.BKG_CUST_TP_CD ='F'" ).append("\n"); 
		query.append("#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("           AND BK.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("           AND N.BKG_CUST_TP_CD ='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("           AND BK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND A.BKG_CUST_TP_CD ='A'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND BK.BKG_NO = FINV.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'FINV'    = FINV.BKG_REF_TP_CD(+)--Invoice Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = EBRF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'EBRF'    = EBRF.BKG_REF_TP_CD(+)--BKG Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = EBSH.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'EBSH'    = EBSH.BKG_REF_TP_CD(+)--BKG SH Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = EBFF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'EBFF'    = EBFF.BKG_REF_TP_CD(+)--BKG FF Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = ESRF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'ESRF'    = ESRF.BKG_REF_TP_CD(+)--S/I Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = ESSH.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'ESSH'    = ESSH.BKG_REF_TP_CD(+)--S/I SH Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = ESFF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'ESFF'    = ESFF.BKG_REF_TP_CD(+)--S/I FF Ref. No." ).append("\n"); 
		query.append("           AND BK.BKG_NO = RGBK.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'RGBK'    = RGBK.BKG_REF_TP_CD(+)--Regional BKG No." ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD1.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 1 = VVD1.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'U' = VVD1.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD2.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 2 = VVD2.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'U' = VVD2.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD3.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 3 = VVD3.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'U' = VVD3.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD4.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 4 = VVD4.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'U' = VVD4.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD5.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 1 = VVD5.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'S' = VVD5.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD6.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 2 = VVD6.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'S' = VVD6.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD7.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 3 = VVD7.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'S' = VVD7.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO = VVD8.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 4 = VVD8.VSL_SEQ(+)" ).append("\n"); 
		query.append("           AND 'S' = VVD8.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND BK.BKG_NO         = TRUNK.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BK.VSL_CD         = TRUNK.VSL_CD(+)" ).append("\n"); 
		query.append("           AND BK.SKD_VOY_NO     = TRUNK.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND BK.SKD_DIR_CD     = TRUNK.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND 'T'               = TRUNK.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("           AND (N1ST_VVD.BKG_NO, N1ST_VVD.VSL_PRE_PST_CD, N1ST_VVD.VSL_SEQ) " ).append("\n"); 
		query.append("                                         = (SELECT /*+ index(v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                                    V2.BKG_NO, V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                                              FROM BKG_VVD V2" ).append("\n"); 
		query.append("                                             WHERE V2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("           AND (LAST_VVD.BKG_NO, LAST_VVD.VSL_PRE_PST_CD, LAST_VVD.VSL_SEQ) " ).append("\n"); 
		query.append("                                         = (SELECT /*+ index_desc(v2 xpkbkg_vvd) */ " ).append("\n"); 
		query.append("                                                    V2.BKG_NO, V2.VSL_PRE_PST_CD, V2.VSL_SEQ" ).append("\n"); 
		query.append("                                              FROM BKG_VVD V2" ).append("\n"); 
		query.append("                                             WHERE V2.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("           AND N1ST_VVD.VSL_CD     = N1ST_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND N1ST_VVD.SKD_VOY_NO = N1ST_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND N1ST_VVD.SKD_DIR_CD = N1ST_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND N1ST_VVD.POL_CD     = N1ST_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND N1ST_SKD.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append("           AND LAST_VVD.VSL_CD     = LAST_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND LAST_VVD.SKD_VOY_NO = LAST_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND LAST_VVD.SKD_DIR_CD = LAST_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND LAST_VVD.POD_CD     = LAST_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND LAST_SKD.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '' && ${trunk_flag} != '')" ).append("\n"); 
		query.append("           AND BK.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND BK.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND BK.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '' && ${trunk_flag} == '')" ).append("\n"); 
		query.append("           AND @[vvd_cd] IN (VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD, VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD, VVD3.VSL_CD||VVD3.SKD_VOY_NO||VVD3.SKD_DIR_CD, VVD4.VSL_CD||VVD4.SKD_VOY_NO||VVD4.SKD_DIR_CD," ).append("\n"); 
		query.append("                             VVD5.VSL_CD||VVD5.SKD_VOY_NO||VVD5.SKD_DIR_CD, VVD6.VSL_CD||VVD6.SKD_VOY_NO||VVD6.SKD_DIR_CD, VVD7.VSL_CD||VVD7.SKD_VOY_NO||VVD7.SKD_DIR_CD, VVD8.VSL_CD||VVD8.SKD_VOY_NO||VVD8.SKD_DIR_CD," ).append("\n"); 
		query.append("                             TRUNK.VSL_CD||TRUNK.SKD_VOY_NO||TRUNK.SKD_DIR_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane_cd} != '') " ).append("\n"); 
		query.append("           AND BK.SLAN_CD = @[lane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '') " ).append("\n"); 
		query.append("           AND BK.SKD_DIR_CD IN (${dir_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND @[pol_cd] IN (VVD1.POL_CD, VVD2.POL_CD, VVD3.POL_CD, VVD4.POL_CD, VVD5.POL_CD, VVD6.POL_CD, VVD7.POL_CD, VVD8.POL_CD, TRUNK.POL_CD)" ).append("\n"); 
		query.append(" #if (${pol_local} != '')" ).append("\n"); 
		query.append("           AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_ts} != '')" ).append("\n"); 
		query.append("           AND BK.POL_CD <> @[pol_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("           AND @[pol_yard_cd] IN (VVD1.POL_YD_CD, VVD2.POL_YD_CD, VVD3.POL_YD_CD, VVD4.POL_YD_CD, VVD5.POL_YD_CD, VVD6.POL_YD_CD, VVD7.POL_YD_CD, VVD8.POL_YD_CD, TRUNK.POL_YD_CD)" ).append("\n"); 
		query.append(" #if (${pol_local} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(BK.POL_NOD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pol_ts} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(BK.POL_NOD_CD,-2) <> @[pol_yard_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("           AND @[pod_cd] IN (VVD1.POD_CD, VVD2.POD_CD, VVD3.POD_CD, VVD4.POD_CD, VVD5.POD_CD, VVD6.POD_CD, VVD7.POD_CD, VVD8.POD_CD, TRUNK.POD_CD)" ).append("\n"); 
		query.append(" #if (${pod_local} != '')" ).append("\n"); 
		query.append("           AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_ts} != '')" ).append("\n"); 
		query.append("           AND BK.POD_CD <> @[pod_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("           AND @[pod_yard_cd] IN (VVD1.POD_YD_CD, VVD2.POD_YD_CD, VVD3.POD_YD_CD, VVD4.POD_YD_CD, VVD5.POD_YD_CD, VVD6.POD_YD_CD, VVD7.POD_YD_CD, VVD8.POD_YD_CD, TRUNK.POD_YD_CD)" ).append("\n"); 
		query.append(" #if (${pod_local} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(BK.POD_NOD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${pod_ts} != '')" ).append("\n"); 
		query.append("           AND SUBSTR(BK.POD_NOD_CD,-2) <> @[pod_yard_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("           AND BK.POR_CD LIKE @[por_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("           AND BK.DEL_CD LIKE @[del_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${r_term} != '') " ).append("\n"); 
		query.append("           AND BK.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${d_term} != '') " ).append("\n"); 
		query.append("           AND BK.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${board_from_dt} != '') " ).append("\n"); 
		query.append("           AND N1ST_SKD.VPS_ETD_DT >= TO_DATE(@[board_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${board_to_dt} != '') " ).append("\n"); 
		query.append("           AND N1ST_SKD.VPS_ETD_DT <= TO_DATE(@[board_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_from_dt} != '') " ).append("\n"); 
		query.append("           AND BK.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_to_dt} != '') " ).append("\n"); 
		query.append("           AND BK.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_kind} != '') " ).append("\n"); 
		query.append("           AND BK.XTER_BKG_RQST_CD IN (${bkg_kind})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${b_ofc_cd} != '') " ).append("\n"); 
		query.append(" #if(${b_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("           AND BK.BKG_OFC_CD IN ( ${b_ofc_cd_sub} )" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("           AND BK.BKG_OFC_CD = @[b_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${b_staff_id} != '') " ).append("\n"); 
		query.append("           AND BK.DOC_USR_ID = @[b_staff_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_flag} != '') " ).append("\n"); 
		query.append("           AND EXISTS ( SELECT  'Y' FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                         WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                           AND CORR_NO IS NOT NULL" ).append("\n"); 
		query.append("                           AND CORR_NO <> '0000000001')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_rlse_ofc_cd} != '') " ).append("\n"); 
		query.append("           AND ISS.OBL_ISS_OFC_CD = @[bl_rlse_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_type} != '') " ).append("\n"); 
		query.append("           AND EXISTS  ( SELECT 'Y'" ).append("\n"); 
		query.append("                           FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                          WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                            AND CNTR_TPSZ_CD IN (${eq_type})" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("           AND BK.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_wgt_from} != '')" ).append("\n"); 
		query.append(" #if (${cgo_wgt_kg} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', DOC.ACT_WGT, ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3)) >= @[cgo_wgt_from]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cgo_wgt_lb} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', ROUND(NVL(DOC.ACT_WGT,0)*2.2046,3), DOC.ACT_WGT) >= @[cgo_wgt_from]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_wgt_to} != '')" ).append("\n"); 
		query.append(" #if (${cgo_wgt_kg} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', DOC.ACT_WGT, ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3)) <= @[cgo_wgt_to]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${cgo_wgt_lb} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', ROUND(NVL(DOC.ACT_WGT,0)*2.2046,3), DOC.ACT_WGT) <= @[cgo_wgt_to]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${grs_wgt_from} != '')" ).append("\n"); 
		query.append(" #if (${grs_wgt_kg} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', DOC.ACT_WGT, ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3)) >= @[grs_wgt_from]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${grs_wgt_lb} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', ROUND(NVL(DOC.ACT_WGT,0)*2.2046,3), DOC.ACT_WGT) >= @[grs_wgt_from]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${grs_wgt_to} != '')" ).append("\n"); 
		query.append(" #if (${grs_wgt_kg} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', DOC.ACT_WGT, ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3)) <= @[grs_wgt_to]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${grs_wgt_lb} != '')" ).append("\n"); 
		query.append("           AND DECODE(DOC.WGT_UT_CD, 'KGS', ROUND(NVL(DOC.ACT_WGT,0)*2.2046,3), DOC.ACT_WGT) <= @[grs_wgt_to]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctr_rfa_cd} == 'C') " ).append("\n"); 
		query.append(" #if (${ctr_rfa_no} != '') " ).append("\n"); 
		query.append("           AND BK.SC_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif (${ctr_rfa_cd} == 'R') " ).append("\n"); 
		query.append(" #if (${ctr_rfa_no} != '') " ).append("\n"); 
		query.append("           AND BK.RFA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#elseif (${ctr_rfa_cd} == 'T') " ).append("\n"); 
		query.append(" #if (${ctr_rfa_no} != '') " ).append("\n"); 
		query.append("           AND BK.TAA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd_f} != '' || ${bkg_sts_cd_x} != '' || ${bkg_sts_cd_a} != '' || ${bkg_sts_cd_w} != '') " ).append("\n"); 
		query.append("           AND BK.BKG_STS_CD IN ( @[bkg_sts_cd_f], @[bkg_sts_cd_x], @[bkg_sts_cd_a], @[bkg_sts_cd_w]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${non_sp_cargo} != '') " ).append("\n"); 
		query.append("           AND BK.WT_RSN_SPCL_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${holding} != '') " ).append("\n"); 
		query.append("           AND BK.WT_RSN_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sts_cd_en} != '' || ${cntr_sts_cd_op} != '' || ${cntr_sts_cd_ic} != '' || ${cntr_sts_cd_tn} != '' || ${cntr_sts_cd_id} != ''" ).append("\n"); 
		query.append("  || ${cntr_sts_cd_ts} != '' || ${cntr_sts_cd_mt} != '' || ${cntr_sts_cd_vd} != '' || ${cntr_sts_cd_oc} != '' || ${cntr_sts_cd_vl} != '') " ).append("\n"); 
		query.append("           AND CNTR.CNMV_STS_CD IN ( @[cntr_sts_cd_en], @[cntr_sts_cd_op], @[cntr_sts_cd_ic], @[cntr_sts_cd_tn], @[cntr_sts_cd_id], @[cntr_sts_cd_ts], @[cntr_sts_cd_mt], @[cntr_sts_cd_vs], @[cntr_sts_cd_oc], @[cntr_sts_cd_vl]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '')                                        " ).append("\n"); 
		query.append(" #if(${cust_cnt_cd} !='' && ${cust_seq} != '')" ).append("\n"); 
		query.append("           AND ( 1=2" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("              OR (S.CUST_CNT_CD = @[cust_cnt_cd] AND S.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("              OR (C.CUST_CNT_CD = @[cust_cnt_cd] AND C.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("              OR (N.CUST_CNT_CD = @[cust_cnt_cd] AND N.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("              OR (F.CUST_CNT_CD = @[cust_cnt_cd] AND F.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("              OR (A.CUST_CNT_CD = @[cust_cnt_cd] AND A.CUST_SEQ = TO_NUMBER(@[cust_seq]))" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${cust_nm} !='')" ).append("\n"); 
		query.append("           AND ( 1=2" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("              OR S.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("              OR C.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("              OR N.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("              OR F.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("              OR A.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("       #if(${cust_grp_id} !='')					--SJH.20150129.ADD" ).append("\n"); 
		query.append("         AND ( 1=2" ).append("\n"); 
		query.append("        #if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("		  OR (S.CUST_CNT_CD, S.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("          OR (C.CUST_CNT_CD, C.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("          OR (N.CUST_CNT_CD, N.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("          OR (F.CUST_CNT_CD, F.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("          OR (A.CUST_CNT_CD, A.CUST_SEQ) IN (SELECT CUST_CNT_CD, CUST_SEQ FROM MDM_CUSTOMER WHERE CUST_GRP_ID = @[cust_grp_id])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sp_cargo_dg} !=''||${sp_cargo_rf} != ''||${sp_cargo_ak} != ''||${sp_cargo_bb} != ''||${sp_cargo_hg} != ''||${sp_cargo_soc} != ''||${sp_cargo_eq} != ''||${sp_cargo_rd} != ''||${sp_cargo_pm} != ''||${sp_cargo_pc} != ''||${sp_cargo_fg} != ''||${sp_cargo_hd} != ''||${sp_cargo_rb} != '')" ).append("\n"); 
		query.append("           AND ( 1=2 " ).append("\n"); 
		query.append(" #if (${sp_cargo_dg} != '') " ).append("\n"); 
		query.append("              OR BK.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sp_cargo_rf} != '') " ).append("\n"); 
		query.append("              OR BK.RC_FLG = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sp_cargo_ak} != '') " ).append("\n"); 
		query.append("              OR BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sp_cargo_bb} != '') " ).append("\n"); 
		query.append("              OR BK.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sp_cargo_bb} != '') " ).append("\n"); 
		query.append("              OR BK.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${sp_cargo_hg} != '') " ).append("\n"); 
		query.append("              OR BK.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) BKG_Z," ).append("\n"); 
		query.append("       (SELECT H.BKG_NO AS C_BKG_NO, H.CNTR_NO AS C_CNTR_NO, H.COP_NO, TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI') AS EST_PKUP_DT, TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI') AS ACT_PKUP_DT, SUBSTR(D.NOD_CD,1,5) AS MTY_PKUP_LOC, ROW_NUMBER() OVER (PARTITION BY H.BKG_NO, H.CNTR_NO ORDER BY D.COP_DTL_SEQ) AS RNUM" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("               SCE_COP_DTL D" ).append("\n"); 
		query.append("         WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("           AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND D.STND_EDI_STS_CD = 'EE'" ).append("\n"); 
		query.append("       ) COP_EE," ).append("\n"); 
		query.append("       (SELECT H.BKG_NO AS C_BKG_NO, H.CNTR_NO AS C_CNTR_NO, TO_CHAR(D.ESTM_DT,'YYYY-MM-DD HH24:MI') AS EST_RTN_DT, TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI') AS ACT_RTN_DT, SUBSTR(D.NOD_CD,1,5) AS FULL_RTN_LOC, ROW_NUMBER() OVER (PARTITION BY H.BKG_NO, H.CNTR_NO ORDER BY D.COP_DTL_SEQ) AS RNUM" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("               SCE_COP_DTL D" ).append("\n"); 
		query.append("         WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("           AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND D.STND_EDI_STS_CD = 'IO'" ).append("\n"); 
		query.append("       ) COP_IO," ).append("\n"); 
		query.append("       (SELECT H.BKG_NO AS C_BKG_NO, H.CNTR_NO AS C_CNTR_NO, SUBSTR(D.NOD_CD,1,5) AS MTY_RTN_LOC, ROW_NUMBER() OVER (PARTITION BY H.BKG_NO, H.CNTR_NO ORDER BY D.COP_DTL_SEQ) AS RNUM" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("               SCE_COP_DTL D" ).append("\n"); 
		query.append("         WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("           AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND D.STND_EDI_STS_CD = 'MT'" ).append("\n"); 
		query.append("       ) COP_MT," ).append("\n"); 
		query.append("       (SELECT H.BKG_NO AS C_BKG_NO, H.CNTR_NO AS C_CNTR_NO, TO_CHAR(D.ACT_DT,'YYYY-MM-DD HH24:MI') AS ACT_LODG_DT, ROW_NUMBER() OVER (PARTITION BY H.BKG_NO, H.CNTR_NO ORDER BY D.COP_DTL_SEQ) AS RNUM" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("               SCE_COP_DTL D" ).append("\n"); 
		query.append("         WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("           AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND D.STND_EDI_STS_CD = 'AEL'" ).append("\n"); 
		query.append("       ) COP_AEL" ).append("\n"); 
		query.append(" WHERE BKG_Z.BKG_NO = COP_EE.C_BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG_Z.CNTR_NO = COP_EE.C_CNTR_NO(+)" ).append("\n"); 
		query.append("   AND COP_EE.RNUM(+) = 1" ).append("\n"); 
		query.append("   AND BKG_Z.BKG_NO = COP_IO.C_BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG_Z.CNTR_NO = COP_IO.C_CNTR_NO(+)" ).append("\n"); 
		query.append("   AND COP_IO.RNUM(+) = 1" ).append("\n"); 
		query.append("   AND BKG_Z.BKG_NO = COP_MT.C_BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG_Z.CNTR_NO = COP_MT.C_CNTR_NO(+)" ).append("\n"); 
		query.append("   AND COP_MT.RNUM(+) = 1" ).append("\n"); 
		query.append("   AND BKG_Z.BKG_NO = COP_AEL.C_BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG_Z.CNTR_NO = COP_AEL.C_CNTR_NO(+)" ).append("\n"); 
		query.append("   AND COP_AEL.RNUM(+) = 1" ).append("\n"); 
		query.append("#if (${wgt_bnd_xh} != '') " ).append("\n"); 
		query.append("   AND GRS_WGT_KG>22000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wgt_bnd_h} != '') " ).append("\n"); 
		query.append("   AND GRS_WGT_KG>16000" ).append("\n"); 
		query.append("   AND GRS_WGT_KG<=22000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wgt_bnd_m} != '') " ).append("\n"); 
		query.append("   AND GRS_WGT_KG>10000" ).append("\n"); 
		query.append("   AND GRS_WGT_KG<=16000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wgt_bnd_l} != '') " ).append("\n"); 
		query.append("   AND GRS_WGT_KG>=0" ).append("\n"); 
		query.append("   AND GRS_WGT_KG<=10000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rate_sts_r} != '' && ${rate_sts_u} == '')" ).append("\n"); 
		query.append("   AND RATE_STS = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rate_sts_u} != '' && ${rate_sts_r} == '')" ).append("\n"); 
		query.append("   AND RATE_STS = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${orderby} == '') " ).append("\n"); 
		query.append("ORDER BY BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY ${orderby}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}