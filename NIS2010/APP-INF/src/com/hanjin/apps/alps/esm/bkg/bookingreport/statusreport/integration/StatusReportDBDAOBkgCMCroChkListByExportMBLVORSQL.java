/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOBkgCMCroChkListByExportMBLVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgCMCroChkListByExportMBLVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOBkgCMCroChkListByExportMBLVORSQL
	  * </pre>
	  */
	public StatusReportDBDAOBkgCMCroChkListByExportMBLVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("entr_clss_tp_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgCMCroChkListByExportMBLVORSQL").append("\n"); 
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
		query.append("WITH  BKG_VVD_TMP  AS " ).append("\n"); 
		query.append("     (SELECT  BV.BKG_NO, BV.POL_CD, BV.POD_CD," ).append("\n"); 
		query.append("			 (SELECT BK.USA_CSTMS_FILE_CD || ',' || BK.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("             FROM   BKG_BOOKING BK " ).append("\n"); 
		query.append("             WHERE  BK.BKG_NO = BV.BKG_NO ) CSTMS_FILE_CD," ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            (SELECT CASE WHEN  NVL(BK.USA_CSTMS_FILE_CD,' ') <> ' ' THEN 'US'" ).append("\n"); 
		query.append("                         WHEN  NVL(BK.CND_CSTMS_FILE_CD,' ') <> ' ' THEN 'CA'" ).append("\n"); 
		query.append("                         ELSE  SUBSTR(BV.POD_CD,1,2) END" ).append("\n"); 
		query.append("             FROM   BKG_BOOKING BK " ).append("\n"); 
		query.append("             WHERE  BK.BKG_NO = BV.BKG_NO ) CNT_CD" ).append("\n"); 
		query.append("      FROM    BKG_VVD BV" ).append("\n"); 
		query.append("      WHERE   0 = 0" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("      AND     BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      AND     BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND     BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("      AND     BV.POL_CD LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("      AND     BV.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT  *" ).append("\n"); 
		query.append("FROM   (SELECT --/*+ Rule */   --> 힌트 제거" ).append("\n"); 
		query.append("               BKG.BKG_NO" ).append("\n"); 
		query.append("              ,BKG.BL_NO" ).append("\n"); 
		query.append("              ,DECODE(BKG.BL_TP_CD,'W','W','')                                     AS BL_TP_CD" ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,NVL(BKG.USA_CSTMS_FILE_CD,'-') AS USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("              ,NVL(BKG.CND_CSTMS_FILE_CD,'-') AS CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_S.CUST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_S.CUST_NM,'N') = 'N' AND (POL_V.SHPR_NM_FLG = 'E' OR POD_V.SHPR_NM_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.SHPR_NM_FLG, POD_V.SHPR_NM_FLG) END  AS CUST_NM_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_S.CUST_ADDR,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_S.CUST_ADDR,'N') = 'N' AND (POL_V.SHPR_ADDR_FLG = 'E' OR POD_V.SHPR_ADDR_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.SHPR_ADDR_FLG, POD_V.SHPR_ADDR_FLG) END  AS CUST_ADDR_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_S.CUST_CTY_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_S.CUST_CTY_NM,'N') = 'N' AND (POL_V.SHPR_CTY_FLG = 'E' OR POD_V.SHPR_CTY_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.SHPR_CTY_FLG, POD_V.SHPR_CTY_FLG) END  AS CUST_CTY_NM_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_S.CSTMS_DECL_CNT_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_S.CSTMS_DECL_CNT_CD,'N') = 'N' AND (POL_V.SHPR_CNT_FLG = 'E' OR POD_V.SHPR_CNT_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.SHPR_CNT_FLG, POD_V.SHPR_CNT_FLG) END  AS CSTMS_DECL_CNT_CD_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_S.CUST_ZIP_ID,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_S.CUST_ZIP_ID,'N') = 'N' AND (POL_V.SHPR_ZIP_FLG = 'E' OR POD_V.SHPR_ZIP_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.SHPR_ZIP_FLG, POD_V.SHPR_ZIP_FLG) END  AS CUST_ZIP_ID_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_C.CUST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_C.CUST_NM,'N') = 'N' AND (POL_V.CNEE_NM_FLG = 'E' OR POD_V.CNEE_NM_FLG = 'E') THEN DECODE(BKG.CUST_TO_ORD_FLG,'Y','Y','E')" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.CNEE_NM_FLG, POD_V.CNEE_NM_FLG) END  AS CUST_NM_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_C.CUST_ADDR,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_C.CUST_ADDR,'N') = 'N' AND (POL_V.CNEE_ADDR_FLG = 'E' OR POD_V.CNEE_ADDR_FLG = 'E') THEN DECODE(BKG.CUST_TO_ORD_FLG,'Y','Y','E')" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.CNEE_ADDR_FLG, POD_V.CNEE_ADDR_FLG) END  AS CUST_ADDR_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_C.CUST_CTY_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_C.CUST_CTY_NM,'N') = 'N' AND (POL_V.CNEE_CTY_FLG = 'E' OR POD_V.CNEE_CTY_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.CNEE_CTY_FLG, POD_V.CNEE_CTY_FLG) END  AS CUST_CTY_NM_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_C.CSTMS_DECL_CNT_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_C.CSTMS_DECL_CNT_CD,'N') = 'N' AND (POL_V.CNEE_CNT_FLG = 'E' OR POD_V.CNEE_CNT_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.CNEE_CNT_FLG, POD_V.CNEE_CNT_FLG) END  AS CSTMS_DECL_CNT_CD_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_C.CUST_STE_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_C.CUST_STE_CD,'N') = 'N' AND (POL_V.CNEE_STE_FLG = 'E' OR POD_V.CNEE_STE_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.CNEE_STE_FLG, POD_V.CNEE_STE_FLG) END  AS CUST_STE_CD_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_C.CUST_ZIP_ID,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_C.CUST_ZIP_ID,'N') = 'N' AND (POL_V.CNEE_ZIP_FLG = 'E' OR POD_V.CNEE_ZIP_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.CNEE_ZIP_FLG, POD_V.CNEE_ZIP_FLG) END  AS CUST_ZIP_ID_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_N.CUST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_N.CUST_NM,'N') = 'N' AND (POL_V.NTFY_NM_FLG = 'E' OR POD_V.NTFY_NM_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.NTFY_NM_FLG, POD_V.NTFY_NM_FLG) END  AS CUST_NM_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_N.CUST_ADDR,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_N.CUST_ADDR,'N') = 'N' AND (POL_V.NTFY_ADDR_FLG = 'E' OR POD_V.NTFY_ADDR_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.NTFY_ADDR_FLG, POD_V.NTFY_ADDR_FLG) END  AS CUST_ADDR_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_N.CUST_CTY_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_N.CUST_CTY_NM,'N') = 'N' AND (POL_V.NTFY_CTY_FLG = 'E' OR POD_V.NTFY_CTY_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.NTFY_CTY_FLG, POD_V.NTFY_CTY_FLG) END  AS CUST_CTY_NM_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_N.CSTMS_DECL_CNT_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_N.CSTMS_DECL_CNT_CD,'N') = 'N' AND (POL_V.NTFY_CNT_FLG = 'E' OR POD_V.NTFY_CNT_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.NTFY_CNT_FLG, POD_V.NTFY_CNT_FLG) END  AS CSTMS_DECL_CNT_CD_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_N.CUST_STE_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_N.CUST_STE_CD,'N') = 'N' AND (POL_V.NTFY_STE_FLG = 'E' OR POD_V.NTFY_STE_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.NTFY_STE_FLG, POD_V.NTFY_STE_FLG) END  AS CUST_STE_CD_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		,CASE WHEN NVL(C_N.CUST_ZIP_ID,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("		WHEN NVL(C_N.CUST_ZIP_ID,'N') = 'N' AND (POL_V.NTFY_ZIP_FLG = 'E' OR POD_V.NTFY_ZIP_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("		ELSE NVL(POL_V.NTFY_ZIP_FLG, POD_V.NTFY_ZIP_FLG) END  AS CUST_ZIP_ID_N" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,NVL(REPLACE(C_C.CUST_NM,CHR(13) || CHR(10),' '),' ')         AS CUST_NM" ).append("\n"); 
		query.append("              ,NVL(REPLACE(C_S.CUST_NM,CHR(13) || CHR(10),' '),' ')         AS S_CUST_NM" ).append("\n"); 
		query.append("              ,NVL(REPLACE(C_N.CUST_NM,CHR(13) || CHR(10),' '),' ')         AS N_CUST_NM" ).append("\n"); 
		query.append("              ,NVL(DOC.PCK_QTY,0)                                  AS PCK_QTY_DA" ).append("\n"); 
		query.append("              ,NVL(DOC.ACT_WGT,0)                                  AS ACT_WGT" ).append("\n"); 
		query.append("              ,NVL(DOC.MEAS_QTY,0)                                 AS MEAS_QTY_DA" ).append("\n"); 
		query.append("              ,CASE WHEN DOC.PCK_QTY = CM_CNT.CM_PCK_CHK  THEN  'Y' " ).append("\n"); 
		query.append("                      WHEN (POL_V.CNTR_PCK_FLG = 'E' OR POD_V.CNTR_PCK_FLG = 'E') THEN 'E' " ).append("\n"); 
		query.append("                      ELSE NVL(NVL(POL_V.CNTR_PCK_FLG, POD_V.CNTR_PCK_FLG),'N') END  AS PCK_QTY_CHK" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                ,CASE WHEN DOC.ACT_WGT = CM_CNT.CM_WGT_CHK  THEN  'Y' " ).append("\n"); 
		query.append("                      WHEN (POL_V.CNTR_WGT_FLG = 'E' OR POD_V.CNTR_WGT_FLG = 'E') THEN 'E' " ).append("\n"); 
		query.append("                      ELSE NVL(NVL(POL_V.CNTR_WGT_FLG, POD_V.CNTR_WGT_FLG),'N') END  AS ACT_WET_CHK" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                ,CASE WHEN DOC.MEAS_QTY = CM_CNT.CM_MEAS_CHK  THEN  'Y' " ).append("\n"); 
		query.append("                      WHEN (POL_V.CNTR_MEAS_FLG = 'E' OR POD_V.CNTR_MEAS_FLG = 'E') THEN 'E' " ).append("\n"); 
		query.append("                      ELSE NVL(NVL(POL_V.CNTR_MEAS_FLG, POD_V.CNTR_MEAS_FLG),'N') END  AS MEAS_QTY_CHK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,NVL(CM_CNT.CM_PCK, 0)                                  AS PCK_QTY_CM" ).append("\n"); 
		query.append("              ,NVL(CM_CNT.CM_WGT, 0)                                  AS CNTR_MF_WGT" ).append("\n"); 
		query.append("              ,NVL(CM_CNT.CM_MEAS, 0)                                 AS MEAS_QTY_CM" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(CM_CNT.CM_MK,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(CM_CNT.CM_MK,'N') = 'N' AND (POL_V.CNTR_MF_MK_FLG= 'E' OR POD_V.CNTR_MF_MK_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(POL_V.CNTR_MF_MK_FLG, POD_V.CNTR_MF_MK_FLG) END  AS CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          	  ,CASE WHEN NVL(CM_CNT.CM_DS,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(CM_CNT.CM_DS,'N') = 'N' AND (POL_V.CNTR_MF_DESC_FLG = 'E' OR POD_V.CNTR_MF_DESC_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(POL_V.CNTR_MF_DESC_FLG, POD_V.CNTR_MF_DESC_FLG) END  AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CNT.CNTR_NO" ).append("\n"); 
		query.append("              ,NVL(CNT.PCK_QTY,0)                                  AS PCK_QTY_CO" ).append("\n"); 
		query.append("              ,NVL(CNT.CNTR_WGT,0)                                 AS CNTR_WGT" ).append("\n"); 
		query.append("              ,NVL(CNT.MEAS_QTY,0)                                 AS MEAS_QTY_CO" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(BKG_JOIN_FNC(CURSOR( SELECT /*+ INDEX(BKG_CNTR_SEAL_NO XAK1BKG_CNTR_SEAL_NO) */  --> 힌트 추가" ).append("\n"); 
		query.append("                                       CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                FROM   BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                WHERE  BKG_NO = CNT.BKG_NO AND CNTR_NO = CNT.CNTR_NO)),'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("      				WHEN  POL_V.SEAL_NO_FLG = 'E' OR  POD_V.SEAL_NO_FLG = 'E' THEN 'E'" ).append("\n"); 
		query.append("      				ELSE  'N' END  AS CNTR_SEAL_SEQ    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,'0' Seq" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(CM_CNT.HAMO_TRF_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(CM_CNT.HAMO_TRF_CD,'N') = 'N' AND (POL_V.CNTR_MF_CMDT_FLG = 'E' OR POD_V.CNTR_MF_CMDT_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(POL_V.CNTR_MF_CMDT_FLG, POD_V.CNTR_MF_CMDT_FLG) END  AS CNTR_MF_HTS" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           	  ,CASE WHEN NVL(CM_CNT.CMDT_HS_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(CM_CNT.CMDT_HS_CD,'N') = 'N' AND (POL_V.CNTR_MF_NCM_FLG = 'E' OR POD_V.CNTR_MF_NCM_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(POL_V.CNTR_MF_NCM_FLG, POD_V.CNTR_MF_NCM_FLG) END  AS CNTR_MF_HS" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("           	  ,CASE WHEN NVL(CM_CNT.NCM_NO,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(CM_CNT.NCM_NO,'N') = 'N' AND (POL_V.CNTR_MF_NCM_FLG = 'E' OR POD_V.CNTR_MF_NCM_FLG = 'E') THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(POL_V.CNTR_MF_NCM_FLG, POD_V.CNTR_MF_NCM_FLG) END  AS CNTR_MF_NCM" ).append("\n"); 
		query.append("                ,REPLACE(C_S.CUST_ADDR,CHR(13) || CHR(10),' ') AS S_CUST_ADDR_NM	 " ).append("\n"); 
		query.append("				,NVL(TO_CHAR(LIC.AES_INLND_TRNS_NO),' ') AES_INLND_TRNS_NO /*ACE*/" ).append("\n"); 
		query.append("				,NVL(LIC.ENTR_CLSS_TP_CD,'G') ENTR_CLSS_TP_CD /*TE,IE*/" ).append("\n"); 
		query.append("				,NVL(LIC.ENTR_CLSS_RMK,' ') ENTR_CLSS_RMK /* In-Bond Nbr*/" ).append("\n"); 
		query.append("			    ,NVL((SELECT A.CNTR_TPSZ_CD || ( CASE WHEN A.OP_CNTR_QTY < 1 THEN '-0'||A.OP_CNTR_QTY ELSE '-'||A.OP_CNTR_QTY END)" ).append("\n"); 
		query.append("				         FROM BKG_QUANTITY A" ).append("\n"); 
		query.append("				   	     WHERE A.BKG_NO = CNT.BKG_NO" ).append("\n"); 
		query.append("					    AND A.CNTR_TPSZ_CD = CNT.CNTR_TPSZ_CD),' ') BKG_QTY" ).append("\n"); 
		query.append("				, NVL((SELECT MIN(A.CNTR_TPSZ_CD) || ( CASE WHEN SUM(A.CNTR_VOL_QTY) < 1 THEN '-0'||SUM(A.CNTR_VOL_QTY) ELSE '-'||SUM(A.CNTR_VOL_QTY) END)" ).append("\n"); 
		query.append("				          FROM BKG_CONTAINER A" ).append("\n"); 
		query.append("				          WHERE A.BKG_NO = CNT.BKG_NO" ).append("\n"); 
		query.append("				          AND A.CNTR_TPSZ_CD = CNT.CNTR_TPSZ_CD),' ') CNTR_QTY" ).append("\n"); 
		query.append("		         ,NVL(DOC.PCK_CMDT_DESC,' ') PCK_CMDT_DESC" ).append("\n"); 
		query.append("                 ,(SELECT (CASE WHEN COUNT(*) = 0 THEN 'N' ELSE 'Y' END) FROM BKG_BL_MK_DESC X WHERE X.BKG_NO = BKG.BKG_NO) MD" ).append("\n"); 
		query.append("		         ,NVL(DOC.PCK_TP_CD,' ') PCK_TP_CD" ).append("\n"); 
		query.append("		         ,NVL(BKG.DCGO_FLG,' ') DCGO_FLG /*DG*/" ).append("\n"); 
		query.append("		         ,NVL(BKG.VEH_CMDT_FLG,' ') VEH_CMDT_FLG /*AUTO*/" ).append("\n"); 
		query.append("		         ,NVL(BKG.SI_FLG,' ') SI_FLG /*Via S/I*/" ).append("\n"); 
		query.append("		         ,BKG.XTER_SI_CD /*Via S/I*/" ).append("\n"); 
		query.append("		         " ).append("\n"); 
		query.append("		         " ).append("\n"); 
		query.append("				,' '  vsl_Cd," ).append("\n"); 
		query.append("				' ' pol_Cd," ).append("\n"); 
		query.append("				' ' pod_Cd," ).append("\n"); 
		query.append("				' ' pol_Yd_Cd," ).append("\n"); 
		query.append("				' ' pod_Yd_Cd," ).append("\n"); 
		query.append("				' ' chk_Err," ).append("\n"); 
		query.append("				' ' entr_clss_tp_gubun," ).append("\n"); 
		query.append("                ' ' skd_voy_no, " ).append("\n"); 
		query.append("                ' ' skd_dir_cd" ).append("\n"); 
		query.append("		         " ).append("\n"); 
		query.append("        FROM   BKG_VVD_TMP      VVD" ).append("\n"); 
		query.append("              ,BKG_BOOKING      BKG" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_S" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_C" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_N" ).append("\n"); 
		query.append("              ,BKG_BL_DOC       DOC" ).append("\n"); 
		query.append("              ,BKG_CONTAINER    CNT" ).append("\n"); 
		query.append("            ,(SELECT  A.CNTR_NO," ).append("\n"); 
		query.append("                      A.BKG_NO," ).append("\n"); 
		query.append("                      SUM(PCK_QTY)      OVER (PARTITION BY BKG_NO,CNTR_NO)  CM_PCK," ).append("\n"); 
		query.append("                      SUM(CNTR_MF_WGT)  OVER (PARTITION BY BKG_NO,CNTR_NO)  CM_WGT," ).append("\n"); 
		query.append("                      SUM(MEAS_QTY)     OVER (PARTITION BY BKG_NO,CNTR_NO)  CM_MEAS," ).append("\n"); 
		query.append("                      SUM(PCK_QTY)      OVER (PARTITION BY BKG_NO)  CM_PCK_CHK," ).append("\n"); 
		query.append("                      SUM(CNTR_MF_WGT)  OVER (PARTITION BY BKG_NO)  CM_WGT_CHK," ).append("\n"); 
		query.append("                      SUM(MEAS_QTY)     OVER (PARTITION BY BKG_NO)  CM_MEAS_CHK," ).append("\n"); 
		query.append("                      A.CM_MK," ).append("\n"); 
		query.append("                      A.CM_DS," ).append("\n"); 
		query.append("					  A.HAMO_TRF_CD," ).append("\n"); 
		query.append("					  A.CMDT_HS_CD," ).append("\n"); 
		query.append("					  A.NCM_NO" ).append("\n"); 
		query.append("              FROM   (SELECT  B.BKG_NO," ).append("\n"); 
		query.append("                              B.CNTR_NO," ).append("\n"); 
		query.append("							  C.HAMO_TRF_CD," ).append("\n"); 
		query.append("							  C.CMDT_HS_CD," ).append("\n"); 
		query.append("							  C.NCM_NO," ).append("\n"); 
		query.append("                              DECODE(SUM(DECODE(C.CNTR_MF_MK_DESC,NULL,0,1)),0,'N','Y')  CM_MK," ).append("\n"); 
		query.append("                              DECODE(SUM(DECODE(C.CNTR_MF_GDS_DESC,NULL,0,1)),0,'N','Y') CM_DS," ).append("\n"); 
		query.append("                              SUM(C.PCK_QTY)      PCK_QTY," ).append("\n"); 
		query.append("                              SUM(C.CNTR_MF_WGT)  CNTR_MF_WGT," ).append("\n"); 
		query.append("                              SUM(C.MEAS_QTY)     MEAS_QTY" ).append("\n"); 
		query.append("                      FROM    BKG_VVD_TMP       A," ).append("\n"); 
		query.append("                              BKG_CONTAINER     B," ).append("\n"); 
		query.append("                              BKG_CNTR_MF_DESC  C" ).append("\n"); 
		query.append("                      WHERE   A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                      AND     B.BKG_NO = C.BKG_NO (+)" ).append("\n"); 
		query.append("                      AND     B.CNTR_NO = C.CNTR_NO (+)" ).append("\n"); 
		query.append("                      GROUP BY B.BKG_NO, B.CNTR_NO,C.HAMO_TRF_CD,C.CMDT_HS_CD,C.NCM_NO" ).append("\n"); 
		query.append("                     )  A" ).append("\n"); 
		query.append("             ) CM_CNT," ).append("\n"); 
		query.append("              BKG_CSTMS_RULE_STUP_POL_V  POL_V," ).append("\n"); 
		query.append("              BKG_CSTMS_RULE_STUP_POD_V  POD_V," ).append("\n"); 
		query.append("			  (" ).append("\n"); 
		query.append("					SELECT BKG_NO," ).append("\n"); 
		query.append("							TO_CHAR(AES_INLND_TRNS_NO) AES_INLND_TRNS_NO, /*ACE*/" ).append("\n"); 
		query.append("							NVL(ENTR_CLSS_TP_CD,'G') ENTR_CLSS_TP_CD, /*TE,IE*/" ).append("\n"); 
		query.append("							ENTR_CLSS_RMK /* In-Bond Nbr*/" ).append("\n"); 
		query.append("					FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("					WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("					AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("					AND XPT_IMP_SEQ = '1'" ).append("\n"); 
		query.append("					#if (${entr_clss_tp_gubun} != '') " ).append("\n"); 
		query.append("					AND NVL(ENTR_CLSS_TP_CD,'G')  = @[entr_clss_tp_gubun]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				) LIC" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO(+) = VVD.BKG_NO" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_S.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_N.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = CNT.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = LIC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND CNT.BKG_NO = CM_CNT.BKG_NO(+)" ).append("\n"); 
		query.append("        AND CNT.CNTR_NO = CM_CNT.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND C_S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND C_C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND C_N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("		AND BKG.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("	    AND VVD.CNT_CD = POL_V.CNT_CD (+)" ).append("\n"); 
		query.append("        --AND SUBSTR(VVD.POL_CD,1,2) = POL_V.CNT_CD (+)" ).append("\n"); 
		query.append("        AND NVL(VVD.POL_CD,'X') = NVL(POL_V.LOC_CD(+), NVL(VVD.POL_CD,'X'))" ).append("\n"); 
		query.append("        AND 'M' = POL_V.BL_TP_CD (+)" ).append("\n"); 
		query.append("	    AND VVD.CNT_CD = POD_V.CNT_CD (+)	" ).append("\n"); 
		query.append("        --AND SUBSTR(VVD.POD_CD,1,2) = POD_V.CNT_CD (+)" ).append("\n"); 
		query.append("        AND NVL(VVD.POD_CD,'X') = NVL(POD_V.LOC_CD(+), NVL(VVD.POD_CD,'X'))" ).append("\n"); 
		query.append("        AND 'M' = POD_V.BL_TP_CD (+)" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.POL_NOD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_yd_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.POD_NOD_CD = @[pod_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ORDER BY BKG.BL_NO, BKG.BKG_NO, C_C.CUST_NM" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${chk_err} != '' && ${chk_err} == '0')" ).append("\n"); 
		query.append(" WHERE CUST_NM_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_ADDR_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_CTY_NM_S = 'E'" ).append("\n"); 
		query.append("   OR CSTMS_DECL_CNT_CD_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_ZIP_ID_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_NM_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_ADDR_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_CTY_NM_C = 'E'" ).append("\n"); 
		query.append("   OR CSTMS_DECL_CNT_CD_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_STE_CD_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_ZIP_ID_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_NM_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_ADDR_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_CTY_NM_N = 'E'" ).append("\n"); 
		query.append("   OR CSTMS_DECL_CNT_CD_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_STE_CD_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_ZIP_ID_N = 'E'" ).append("\n"); 
		query.append("   OR PCK_QTY_CHK = 'E'" ).append("\n"); 
		query.append("   OR ACT_WET_CHK = 'E'" ).append("\n"); 
		query.append("   OR MEAS_QTY_CHK = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_MK_DESC = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_GDS_DESC = 'E'" ).append("\n"); 
		query.append("   OR CNTR_SEAL_SEQ = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_HTS = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_HS = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_NCM = 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}