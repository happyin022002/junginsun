/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchBkgCroChkListByBLVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.03.24 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBkgCroChkListByBLVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL에 따른 Cross Check 리스트 조회
	  * </pre>
	  */
	public StatusReportDBDAOSearchBkgCroChkListByBLVORSQL(){
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
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_item",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBkgCroChkListByBLVORSQL").append("\n"); 
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
		query.append("#if (${tab_item} == '')" ).append("\n"); 
		query.append("SELECT '' BKG_NO" ).append("\n"); 
		query.append("      ,'' BL_NO" ).append("\n"); 
		query.append("      ,'' POL_CD" ).append("\n"); 
		query.append("      ,'' POD_CD" ).append("\n"); 
		query.append("      ,'' BL_TP_CD" ).append("\n"); 
		query.append("      ,'' USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("      ,'' CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("      ,'' OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("      ,'' OBL_ISS_USR_ID" ).append("\n"); 
		query.append("      ,'' CUST_NM_S" ).append("\n"); 
		query.append("      ,'' CUST_ADDR_S" ).append("\n"); 
		query.append("      ,'' CUST_CTY_NM_S" ).append("\n"); 
		query.append("      ,'' CSTMS_DECL_CNT_CD_S" ).append("\n"); 
		query.append("      ,'' CUST_ZIP_ID_S" ).append("\n"); 
		query.append("      ,'' CUST_NM_C" ).append("\n"); 
		query.append("      ,'' CUST_ADDR_C" ).append("\n"); 
		query.append("      ,'' CUST_CTY_NM_C" ).append("\n"); 
		query.append("      ,'' CSTMS_DECL_CNT_CD_C" ).append("\n"); 
		query.append("	  ,'' CUST_STE_CD_C" ).append("\n"); 
		query.append("      ,'' CUST_ZIP_ID_C" ).append("\n"); 
		query.append("      ,'' CUST_NM_N" ).append("\n"); 
		query.append("      ,'' CUST_ADDR_N" ).append("\n"); 
		query.append("      ,'' CUST_CTY_NM_N" ).append("\n"); 
		query.append("      ,'' CSTMS_DECL_CNT_CD_N" ).append("\n"); 
		query.append("	  ,'' CUST_STE_CD_N" ).append("\n"); 
		query.append("      ,'' CUST_ZIP_ID_N                            " ).append("\n"); 
		query.append("	  ,'' CUST_NM " ).append("\n"); 
		query.append("      ,'' S_CUST_NM " ).append("\n"); 
		query.append("      ,'' N_CUST_NM " ).append("\n"); 
		query.append("      ,'' PCK_QTY_DA" ).append("\n"); 
		query.append("      ,'' ACT_WGT" ).append("\n"); 
		query.append("      ,'' MEAS_QTY_DA" ).append("\n"); 
		query.append("      ,'' PCK_QTY_CHK" ).append("\n"); 
		query.append("      ,'' ACT_WET_CHK" ).append("\n"); 
		query.append("      ,'' MEAS_QTY_CHK" ).append("\n"); 
		query.append("      ,'' PCK_QTY_CM" ).append("\n"); 
		query.append("      ,'' CNTR_MF_WGT" ).append("\n"); 
		query.append("      ,'' MEAS_QTY_CM" ).append("\n"); 
		query.append("      ,'' CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("      ,'' CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("      ,'' CNTR_NO" ).append("\n"); 
		query.append("      ,'' PCK_QTY_CO" ).append("\n"); 
		query.append("      ,'' CNTR_WGT" ).append("\n"); 
		query.append("      ,'' MEAS_QTY_CO" ).append("\n"); 
		query.append("      ,'' CNTR_SEAL_SEQ" ).append("\n"); 
		query.append("	  ,'' Seq" ).append("\n"); 
		query.append("	  ,'' B_BL_NO             " ).append("\n"); 
		query.append("	  ,'' B_USA_CSTMS_FILE_NO " ).append("\n"); 
		query.append("	  ,'' B_HBL_NO            " ).append("\n"); 
		query.append("	  ,'' B_CUST_NM_S         " ).append("\n"); 
		query.append("	  ,'' B_CUST_ADDR_S       " ).append("\n"); 
		query.append("	  ,'' B_CUST_NM_C         " ).append("\n"); 
		query.append("	  ,'' B_CUST_ADDR_C       " ).append("\n"); 
		query.append("	  ,'' B_CUST_NM_N         " ).append("\n"); 
		query.append("	  ,'' B_CUST_ADDR_N       " ).append("\n"); 
		query.append("	  ,'' B_PCK_QTY_DA        " ).append("\n"); 
		query.append("	  ,'' B_HBL_WGT_DA        " ).append("\n"); 
		query.append("	  ,'' B_MEAS_QTY_DA       " ).append("\n"); 
		query.append("	  ,'' B_PCK_QTY_CHK       " ).append("\n"); 
		query.append("	  ,'' B_HBL_WGT_CHK       " ).append("\n"); 
		query.append("	  ,'' B_MEAS_QTY_CHK      " ).append("\n"); 
		query.append("	  ,'' B_PCK_QTY_CM        " ).append("\n"); 
		query.append("	  ,'' B_CNTR_WGT_CM       " ).append("\n"); 
		query.append("	  ,'' B_MEAS_QTY_CM       " ).append("\n"); 
		query.append("	  ,'' B_CNTR_MF_MK_DESC   " ).append("\n"); 
		query.append("	  ,'' B_CNTR_MF_GDS_DESC  " ).append("\n"); 
		query.append("	  ,'' B_CNTR_MF_NO        " ).append("\n"); 
		query.append("	  ,'' B_CNTR_NO           " ).append("\n"); 
		query.append("	  ,'' B_CNTR_SEAL_SEQ " ).append("\n"); 
		query.append("	  ,'' B_PCK_QTY_CO        " ).append("\n"); 
		query.append("	  ,'' B_CNTR_WGT_CO       " ).append("\n"); 
		query.append("	  ,'' B_MEAS_QTY_CO  " ).append("\n"); 
		query.append("	  ,'' TAB_ITEM" ).append("\n"); 
		query.append("	  ,'' CNTR_MF_HTS" ).append("\n"); 
		query.append("	  ,'' CNTR_MF_HS" ).append("\n"); 
		query.append("	  ,'' CNTR_MF_NCM" ).append("\n"); 
		query.append("	  ,'' B_CNTR_MF_HTS" ).append("\n"); 
		query.append("	  ,'' B_CNTR_MF_HS" ).append("\n"); 
		query.append("	  ,'' B_CNTR_MF_NCM" ).append("\n"); 
		query.append("	  ,'' B_CUST_CT_S" ).append("\n"); 
		query.append("	  ,'' B_CUST_CN_S" ).append("\n"); 
		query.append("      ,'' B_CUST_CT_C" ).append("\n"); 
		query.append("      ,'' B_CUST_ST_C" ).append("\n"); 
		query.append("	  ,'' B_CUST_CN_C" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("WITH  BKG_VVD_TMP  AS" ).append("\n"); 
		query.append("     (SELECT  BV.BKG_NO, BV.POL_CD, BV.POD_CD," ).append("\n"); 
		query.append("			 (SELECT BK.USA_CSTMS_FILE_CD || ',' || BK.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("             FROM   BKG_BOOKING BK " ).append("\n"); 
		query.append("             WHERE  BK.BKG_NO = BV.BKG_NO ) CSTMS_FILE_CD" ).append("\n"); 
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
		query.append("              ,VVD.POL_CD" ).append("\n"); 
		query.append("              ,VVD.POD_CD" ).append("\n"); 
		query.append("              ,DECODE(BKG.BL_TP_CD,'W','W','')                                     AS BL_TP_CD" ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,NVL(BKG.USA_CSTMS_FILE_CD,'-') AS USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append("              ,NVL(BKG.CND_CSTMS_FILE_CD,'-') AS CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("              ,ISS.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("              ,ISS.OBL_ISS_USR_ID" ).append("\n"); 
		query.append("--------------------- Shipper" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.CUST_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_NM_FLG, RUL_ALL.SHPR_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_NM_FLG, RUL_ALL.SHPR_NM_FLG) END  CUST_NM_S" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.CUST_ADDR,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_ADDR_FLG, RUL_ALL.SHPR_ADDR_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_ADDR_FLG, RUL_ALL.SHPR_ADDR_FLG) END  CUST_ADDR_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.CUST_CTY_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_CTY_FLG, RUL_ALL.SHPR_CTY_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_CTY_FLG, RUL_ALL.SHPR_CTY_FLG) END  CUST_CTY_NM_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.CSTMS_DECL_CNT_CD,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_CNT_FLG, RUL_ALL.SHPR_CNT_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_CNT_FLG, RUL_ALL.SHPR_CNT_FLG) END  CSTMS_DECL_CNT_CD_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.CUST_ZIP_ID,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_ZIP_FLG, RUL_ALL.SHPR_ZIP_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_ZIP_FLG, RUL_ALL.SHPR_ZIP_FLG) END  CUST_ZIP_ID_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.EUR_CSTMS_ST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_ST_NM_FLG, RUL_ALL.SHPR_ST_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_ST_NM_FLG, RUL_ALL.SHPR_ST_NM_FLG) END  CUST_ST_NM_S" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_S.EORI_NO,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_EORI_NO_FLG, RUL_ALL.SHPR_EORI_NO_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_EORI_NO_FLG, RUL_ALL.SHPR_EORI_NO_FLG) END  CUST_EORI_NO_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------- tax ID		" ).append("\n"); 
		query.append("		#if (${pol_cd} != '') " ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(LIC.MX_SHPR_TAX_ID, 'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("		      	    WHEN (LIC.MX_CNEE_TAX_ID IS NOT NULL OR LIC.MX_NTFY_TAX_ID IS NOT NULL) THEN 'N'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) ='Y' THEN 'E'" ).append("\n"); 
		query.append("		 	   		ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) END AS CUST_TAX_ID_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(LIC.MX_CNEE_TAX_ID, 'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("		      		WHEN (LIC.MX_SHPR_TAX_ID IS NOT NULL OR LIC.MX_NTFY_TAX_ID IS NOT NULL) THEN 'N'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) ='Y' THEN 'E'" ).append("\n"); 
		query.append("		 	   		ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) END AS CUST_TAX_ID_C" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(LIC.MX_NTFY_TAX_ID, 'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("		      		WHEN (LIC.MX_CNEE_TAX_ID IS NOT NULL OR LIC.MX_SHPR_TAX_ID IS NOT NULL) THEN 'N'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) ='Y' THEN 'E'" ).append("\n"); 
		query.append("		 	   		ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) END AS CUST_TAX_ID_N" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(LIC.MX_SHPR_TAX_ID, 'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("		      		WHEN (LIC.MX_CNEE_TAX_ID IS NOT NULL OR LIC.MX_NTFY_TAX_ID IS NOT NULL) THEN 'N'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) ='Y' THEN 'E'" ).append("\n"); 
		query.append("		 	   		ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) END AS CUST_TAX_ID_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(LIC.MX_CNEE_TAX_ID, 'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("		      		WHEN (LIC.MX_SHPR_TAX_ID IS NOT NULL OR LIC.MX_NTFY_TAX_ID IS NOT NULL) THEN 'N'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) ='Y' THEN 'E'" ).append("\n"); 
		query.append("		 	   		ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) END AS CUST_TAX_ID_C" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(LIC.MX_NTFY_TAX_ID, 'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("		      		WHEN (LIC.MX_CNEE_TAX_ID IS NOT NULL OR LIC.MX_SHPR_TAX_ID IS NOT NULL) THEN 'N'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) ='Y' THEN 'E'" ).append("\n"); 
		query.append("		 	   		ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG6, RUL_ALL.XPT_IMP_REF_FLG6) END AS CUST_TAX_ID_N" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------- Consignee" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.CUST_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_NM_FLG, RUL_ALL.CNEE_NM_FLG) ='Y' THEN DECODE(BKG.CUST_TO_ORD_FLG,'Y','Y','E') " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_NM_FLG, RUL_ALL.CNEE_NM_FLG) END  CUST_NM_C" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.CUST_ADDR,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_ADDR_FLG, RUL_ALL.CNEE_ADDR_FLG) ='Y' THEN DECODE(BKG.CUST_TO_ORD_FLG,'Y','Y','E') " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_ADDR_FLG, RUL_ALL.CNEE_ADDR_FLG) END  CUST_ADDR_C" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.CUST_CTY_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_CTY_FLG, RUL_ALL.CNEE_CTY_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_CTY_FLG, RUL_ALL.CNEE_CTY_FLG) END  CUST_CTY_NM_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.CSTMS_DECL_CNT_CD,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_CNT_FLG, RUL_ALL.CNEE_CNT_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_CNT_FLG, RUL_ALL.CNEE_CNT_FLG) END  CSTMS_DECL_CNT_CD_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.CUST_STE_CD,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_STE_FLG, RUL_ALL.CNEE_STE_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_STE_FLG, RUL_ALL.CNEE_STE_FLG) END  CUST_STE_CD_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.CUST_ZIP_ID,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_ZIP_FLG, RUL_ALL.CNEE_ZIP_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_ZIP_FLG, RUL_ALL.CNEE_ZIP_FLG) END  CUST_ZIP_ID_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.EUR_CSTMS_ST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_ST_NM_FLG, RUL_ALL.CNEE_ST_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_ST_NM_FLG, RUL_ALL.CNEE_ST_NM_FLG) END  CUST_ST_NM_C" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_C.EORI_NO,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.CNEE_EORI_NO_FLG, RUL_ALL.CNEE_EORI_NO_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.CNEE_EORI_NO_FLG, RUL_ALL.CNEE_EORI_NO_FLG) END  CUST_EORI_NO_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------------Notify" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.CUST_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_NM_FLG, RUL_ALL.NTFY_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_NM_FLG, RUL_ALL.NTFY_NM_FLG) END  CUST_NM_N" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.CUST_ADDR,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_ADDR_FLG, RUL_ALL.NTFY_ADDR_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_ADDR_FLG, RUL_ALL.NTFY_ADDR_FLG) END  CUST_ADDR_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.CUST_CTY_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_CTY_FLG, RUL_ALL.NTFY_CTY_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_CTY_FLG, RUL_ALL.NTFY_CTY_FLG) END CUST_CTY_NM_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.CSTMS_DECL_CNT_CD,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_CNT_FLG, RUL_ALL.NTFY_CNT_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_CNT_FLG, RUL_ALL.NTFY_CNT_FLG) END CSTMS_DECL_CNT_CD_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.CUST_STE_CD,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_STE_FLG, RUL_ALL.NTFY_STE_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_STE_FLG, RUL_ALL.NTFY_STE_FLG) END CUST_STE_CD_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.CUST_ZIP_ID,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_ZIP_FLG, RUL_ALL.NTFY_ZIP_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_ZIP_FLG, RUL_ALL.NTFY_ZIP_FLG) END CUST_ZIP_ID_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.EUR_CSTMS_ST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_ST_NM_FLG, RUL_ALL.NTFY_ST_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_ST_NM_FLG, RUL_ALL.NTFY_ST_NM_FLG) END CUST_ST_NM_N" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(C_N.EORI_NO,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_EORI_NO_FLG, RUL_ALL.NTFY_EORI_NO_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_EORI_NO_FLG, RUL_ALL.NTFY_EORI_NO_FLG) END CUST_EORI_NO_N" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------B/L Data" ).append("\n"); 
		query.append("              ,REPLACE(C_C.CUST_NM,CHR(10),' ')         AS CUST_NM" ).append("\n"); 
		query.append("              ,REPLACE(C_S.CUST_NM,CHR(10),' ')         AS S_CUST_NM" ).append("\n"); 
		query.append("              ,REPLACE(C_N.CUST_NM,CHR(10),' ')         AS N_CUST_NM" ).append("\n"); 
		query.append("              ,NVL(DOC.PCK_QTY,0)                                  AS PCK_QTY_DA" ).append("\n"); 
		query.append("              ,NVL(DOC.ACT_WGT,0)                                  AS ACT_WGT" ).append("\n"); 
		query.append("              ,NVL(DOC.MEAS_QTY,0)                                 AS MEAS_QTY_DA" ).append("\n"); 
		query.append("              ,CASE WHEN DOC.PCK_QTY = CM_CNT_BKG.CM_PCK_CHK  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.PCK_FLG, RUL_ALL.PCK_FLG) = 'Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.PCK_FLG, RUL_ALL.PCK_FLG) END  AS PCK_QTY_CHK" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("              ,CASE WHEN DOC.ACT_WGT = CM_CNT_BKG.CM_WGT_CHK  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.WGT_FLG, RUL_ALL.WGT_FLG) = 'Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.WGT_FLG, RUL_ALL.WGT_FLG) END  AS ACT_WET_CHK" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("              ,CASE WHEN DOC.MEAS_QTY = CM_CNT_BKG.CM_MEAS_CHK  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.MEAS_FLG, RUL_ALL.MEAS_FLG) = 'Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.MEAS_FLG, RUL_ALL.MEAS_FLG) END  AS MEAS_QTY_CHK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------C/M" ).append("\n"); 
		query.append("              ,NVL(CM_CNT.CM_PCK, 0)                                  AS PCK_QTY_CM" ).append("\n"); 
		query.append("              ,NVL(CM_CNT.CM_WGT, 0)                                  AS CNTR_MF_WGT" ).append("\n"); 
		query.append("              ,NVL(CM_CNT.CM_MEAS, 0)                                 AS MEAS_QTY_CM" ).append("\n"); 
		query.append("          	  ,CASE WHEN NVL(CM_CNT.CM_DS,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_DESC_FLG, RUL_ALL.CNTR_MF_DESC_FLG)= 'Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_DESC_FLG, RUL_ALL.CNTR_MF_DESC_FLG) END  AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(CM_CNT.CM_MK,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_MK_FLG, RUL_ALL.CNTR_MF_MK_FLG)= 'Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_MK_FLG, RUL_ALL.CNTR_MF_MK_FLG) END  AS CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(CM_CNT.HAMO_TRF_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_CMDT_FLG, RUL_ALL.CNTR_MF_CMDT_FLG)= 'Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_CMDT_FLG, RUL_ALL.CNTR_MF_CMDT_FLG) END  AS CNTR_MF_HTS" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           	  ,CASE WHEN NVL(CM_CNT.CMDT_HS_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CMDT_HS_CD_FLG, RUL_ALL.CMDT_HS_CD_FLG)= 'Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CMDT_HS_CD_FLG, RUL_ALL.CMDT_HS_CD_FLG) END  AS CNTR_MF_HS" ).append("\n"); 
		query.append("                	" ).append("\n"); 
		query.append("           	  ,CASE WHEN NVL(CM_CNT.NCM_NO,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_NCM_FLG, RUL_ALL.CNTR_MF_NCM_FLG)= 'Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_NCM_FLG, RUL_ALL.CNTR_MF_NCM_FLG) END  AS CNTR_MF_NCM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------Container" ).append("\n"); 
		query.append("              ,CNT.CNTR_NO" ).append("\n"); 
		query.append("              ,NVL(CNT.PCK_QTY,0)                                  AS PCK_QTY_CO" ).append("\n"); 
		query.append("              ,NVL(CNT.CNTR_WGT,0)                                 AS CNTR_WGT" ).append("\n"); 
		query.append("              ,NVL(CNT.MEAS_QTY,0)                                 AS MEAS_QTY_CO" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(BKG_JOIN_FNC(CURSOR( SELECT /*+ INDEX(BKG_CNTR_SEAL_NO XAK1BKG_CNTR_SEAL_NO) */  --> 힌트 추가" ).append("\n"); 
		query.append("                                       CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                FROM   BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                WHERE  BKG_NO = CNT.BKG_NO AND CNTR_NO = CNT.CNTR_NO)),'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("      				WHEN  NVL(RUL_LOC.SEAL_NO_FLG, RUL_ALL.SEAL_NO_FLG)= 'Y' THEN 'E'" ).append("\n"); 
		query.append("      				ELSE  NVL(RUL_LOC.SEAL_NO_FLG, RUL_ALL.SEAL_NO_FLG) END  AS CNTR_SEAL_SEQ    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,'0' Seq" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tab_item} != '') " ).append("\n"); 
		query.append("	          ,@[tab_item] TAB_ITEM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM   BKG_VVD_TMP      VVD" ).append("\n"); 
		query.append("              ,BKG_BOOKING      BKG" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_S" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_C" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_N" ).append("\n"); 
		query.append("              ,BKG_BL_ISS       ISS" ).append("\n"); 
		query.append("              ,BKG_BL_DOC       DOC" ).append("\n"); 
		query.append("              ,BKG_CONTAINER    CNT" ).append("\n"); 
		query.append("              ,(SELECT B.BKG_NO" ).append("\n"); 
		query.append("                      ,B.CNTR_NO" ).append("\n"); 
		query.append("                      ,SUM(C.PCK_QTY) AS CM_PCK" ).append("\n"); 
		query.append("                      ,SUM(C.CNTR_MF_WGT) AS CM_WGT" ).append("\n"); 
		query.append("                      ,SUM(C.MEAS_QTY) AS CM_MEAS" ).append("\n"); 
		query.append("                      ,0 AS CM_PCK_CHK" ).append("\n"); 
		query.append("                      ,0 AS CM_WGT_CHK" ).append("\n"); 
		query.append("                      ,0 AS CM_MEAS_CHK" ).append("\n"); 
		query.append("                      ,CASE WHEN SUM(DECODE(C.CNTR_MF_MK_DESC,NULL,1,0)) > 0 THEN NULL ELSE 'Y' END AS CM_MK" ).append("\n"); 
		query.append("                      ,CASE WHEN SUM(DECODE(C.CNTR_MF_GDS_DESC,NULL,1,0)) > 0 THEN NULL ELSE 'Y' END AS CM_DS" ).append("\n"); 
		query.append("                      ,CASE WHEN SUM(DECODE(C.HAMO_TRF_CD,NULL,1,0)) > 0 THEN NULL ELSE 'Y' END AS HAMO_TRF_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN SUM(DECODE(C.CMDT_HS_CD,NULL,1,0)) > 0 THEN NULL ELSE 'Y' END AS CMDT_HS_CD" ).append("\n"); 
		query.append("                      ,CASE WHEN SUM(DECODE(C.NCM_NO,NULL,1,0)) > 0 THEN NULL ELSE 'Y' END AS NCM_NO" ).append("\n"); 
		query.append("                FROM BKG_VVD_TMP       A," ).append("\n"); 
		query.append("                     BKG_CONTAINER     B," ).append("\n"); 
		query.append("                     BKG_CNTR_MF_DESC  C" ).append("\n"); 
		query.append("                WHERE A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                  AND B.BKG_NO  = C.BKG_NO(+)" ).append("\n"); 
		query.append("                  AND B.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("                GROUP BY B.BKG_NO" ).append("\n"); 
		query.append("                        ,B.CNTR_NO" ).append("\n"); 
		query.append("             ) CM_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,(SELECT A.BKG_NO" ).append("\n"); 
		query.append("                      ,SUM(C.PCK_QTY) AS CM_PCK_CHK" ).append("\n"); 
		query.append("                      ,SUM(C.CNTR_MF_WGT) AS CM_WGT_CHK" ).append("\n"); 
		query.append("                      ,SUM(C.MEAS_QTY) AS CM_MEAS_CHK" ).append("\n"); 
		query.append("                FROM BKG_VVD_TMP       A," ).append("\n"); 
		query.append("                     BKG_CNTR_MF_DESC  C" ).append("\n"); 
		query.append("                WHERE A.BKG_NO  = C.BKG_NO(+)" ).append("\n"); 
		query.append("                GROUP BY A.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ) CM_CNT_BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		      ,BKG_XPT_IMP_LIC LIC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,BKG_CSTMS_RULE_STUP RUL_LOC" ).append("\n"); 
		query.append("			  ,BKG_CSTMS_RULE_STUP RUL_ALL" ).append("\n"); 
		query.append("		      " ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO(+) = VVD.BKG_NO" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_S.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_N.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = CNT.BKG_NO(+)" ).append("\n"); 
		query.append("        AND CNT.BKG_NO = CM_CNT.BKG_NO(+)" ).append("\n"); 
		query.append("        AND CNT.CNTR_NO = CM_CNT.CNTR_NO(+)" ).append("\n"); 
		query.append("        AND CNT.BKG_NO = CM_CNT_BKG.BKG_NO(+)" ).append("\n"); 
		query.append("        AND C_S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND C_C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND C_N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO = LIC.BKG_NO(+)" ).append("\n"); 
		query.append("		AND LIC.XPT_IMP_SEQ (+) = 1" ).append("\n"); 
		query.append("		#if (${pol_cd} != '') " ).append("\n"); 
		query.append("			AND     LIC.CNT_CD(+) = SUBSTR(@[pol_cd],1,2)" ).append("\n"); 
		query.append("			AND     LIC.IO_BND_CD(+) ='O'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND     LIC.CNT_CD(+) =  SUBSTR(@[pod_cd],1,2)" ).append("\n"); 
		query.append("			AND     LIC.IO_BND_CD(+) ='I'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("        AND SUBSTR(VVD.POL_CD,1,2) = RUL_LOC.CNT_CD (+)" ).append("\n"); 
		query.append("        AND VVD.POL_CD = RUL_LOC.LOC_CD (+)" ).append("\n"); 
		query.append("        AND 'E' = RUL_LOC.XPT_IMP_CD (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND SUBSTR(VVD.POL_CD,1,2) = RUL_ALL.CNT_CD (+)" ).append("\n"); 
		query.append("        AND 'ALL' = RUL_ALL.LOC_CD (+)" ).append("\n"); 
		query.append("        AND 'E' = RUL_ALL.XPT_IMP_CD (+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND SUBSTR(VVD.POD_CD,1,2) = RUL_LOC.CNT_CD (+)" ).append("\n"); 
		query.append("        AND VVD.POD_CD = RUL_LOC.LOC_CD (+)" ).append("\n"); 
		query.append("        AND 'I' = RUL_LOC.XPT_IMP_CD (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND SUBSTR(VVD.POD_CD,1,2) = RUL_ALL.CNT_CD (+)" ).append("\n"); 
		query.append("        AND 'ALL' = RUL_ALL.LOC_CD (+)" ).append("\n"); 
		query.append("        AND 'I' = RUL_ALL.XPT_IMP_CD (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND 'CTM' = RUL_LOC.CSTMS_DIV_ID (+)" ).append("\n"); 
		query.append("        AND 'Y' = RUL_LOC.FROB_FLG (+)" ).append("\n"); 
		query.append("        AND 'M' = RUL_LOC.BL_TP_CD (+)" ).append("\n"); 
		query.append("        AND 'N' = RUL_LOC.DELT_FLG (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND 'CTM' = RUL_ALL.CSTMS_DIV_ID (+)" ).append("\n"); 
		query.append("        AND 'Y' = RUL_ALL.FROB_FLG (+)" ).append("\n"); 
		query.append("        AND 'M' = RUL_ALL.BL_TP_CD (+)" ).append("\n"); 
		query.append("        AND 'N' = RUL_ALL.DELT_FLG (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.POL_NOD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_yd_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.POD_NOD_CD = @[pod_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("        AND ( C_S.CUST_CNT_CD = @[cust_cnt_cd] AND C_S.CUST_SEQ = @[cust_seq] OR" ).append("\n"); 
		query.append("              C_C.CUST_CNT_CD = @[cust_cnt_cd] AND C_C.CUST_SEQ = @[cust_seq] OR" ).append("\n"); 
		query.append("              C_N.CUST_CNT_CD = @[cust_cnt_cd] AND C_N.CUST_SEQ = @[cust_seq] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usa_cstms_file_cd} != '' && ${cnd_cstms_file_cd} != '') " ).append("\n"); 
		query.append("		 AND (BKG.USA_CSTMS_FILE_CD = @[usa_cstms_file_cd]" ).append("\n"); 
		query.append("			OR BKG.CND_CSTMS_FILE_CD = @[cnd_cstms_file_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${usa_cstms_file_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.USA_CSTMS_FILE_CD = @[usa_cstms_file_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cnd_cstms_file_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.CND_CSTMS_FILE_CD = @[cnd_cstms_file_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("        AND BKG.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("        AND BKG.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_iss_ofc_cd} != '') " ).append("\n"); 
		query.append("        AND ISS.OBL_ISS_OFC_CD = @[obl_iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_iss_usr_id} != '') " ).append("\n"); 
		query.append("        AND ISS.OBL_ISS_USR_ID = @[obl_iss_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ORDER BY BKG.BL_NO, BKG.BKG_NO, C_C.CUST_NM" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${chk_err} != '' && ${chk_err} == '0')" ).append("\n"); 
		query.append(" WHERE CUST_NM_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_ADDR_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_CTY_NM_S = 'E'" ).append("\n"); 
		query.append("   OR CSTMS_DECL_CNT_CD_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_ZIP_ID_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_ST_NM_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_EORI_NO_S = 'E'" ).append("\n"); 
		query.append("   OR CUST_TAX_ID_S = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OR CUST_NM_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_ADDR_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_CTY_NM_C = 'E'" ).append("\n"); 
		query.append("   OR CSTMS_DECL_CNT_CD_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_STE_CD_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_ZIP_ID_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_ST_NM_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_EORI_NO_C = 'E'" ).append("\n"); 
		query.append("   OR CUST_TAX_ID_C = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OR CUST_NM_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_ADDR_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_CTY_NM_N = 'E'" ).append("\n"); 
		query.append("   OR CSTMS_DECL_CNT_CD_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_STE_CD_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_ZIP_ID_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_ST_NM_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_EORI_NO_N = 'E'" ).append("\n"); 
		query.append("   OR CUST_TAX_ID_N = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OR PCK_QTY_CHK = 'E'" ).append("\n"); 
		query.append("   OR ACT_WET_CHK = 'E'" ).append("\n"); 
		query.append("   OR MEAS_QTY_CHK = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OR CNTR_MF_MK_DESC = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_GDS_DESC = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_HTS = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_HS = 'E'" ).append("\n"); 
		query.append("   OR CNTR_MF_NCM = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   OR CNTR_SEAL_SEQ = 'E'" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}