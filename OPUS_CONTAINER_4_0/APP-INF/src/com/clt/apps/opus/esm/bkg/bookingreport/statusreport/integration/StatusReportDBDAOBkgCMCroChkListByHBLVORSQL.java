/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOBkgCMCroChkListByHBLVORSQL.java
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

public class StatusReportDBDAOBkgCMCroChkListByHBLVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public StatusReportDBDAOBkgCMCroChkListByHBLVORSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : StatusReportDBDAOBkgCMCroChkListByHBLVORSQL").append("\n"); 
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
		query.append("WITH  BKG_VVD_TMP  AS (" ).append("\n"); 
		query.append("     SELECT A.BKG_NO" ).append("\n"); 
		query.append("         ,A.POL_CD" ).append("\n"); 
		query.append("         ,A.POD_CD" ).append("\n"); 
		query.append("         ,B.CNTR_NO" ).append("\n"); 
		query.append("         ,C.CNTR_MF_NO" ).append("\n"); 
		query.append("         ,C.HAMO_TRF_CD" ).append("\n"); 
		query.append("         ,C.CMDT_HS_CD" ).append("\n"); 
		query.append("         ,C.NCM_NO" ).append("\n"); 
		query.append("         ,DECODE(C.CNTR_MF_MK_DESC, NULL, 'N', 'Y') CM_MK" ).append("\n"); 
		query.append("         ,DECODE(C.CNTR_MF_GDS_DESC, NULL, 'N', 'Y') CM_DS" ).append("\n"); 
		query.append("         ,DECODE(C.CNTR_MF_NO, NULL, 'N', 'Y') CM_AMS" ).append("\n"); 
		query.append("         ,C.PCK_QTY CM_PCK" ).append("\n"); 
		query.append("         ,C.CNTR_MF_WGT CM_WGT" ).append("\n"); 
		query.append("         ,C.MEAS_QTY CM_MEAS" ).append("\n"); 
		query.append("   FROM   (SELECT BV.BKG_NO" ).append("\n"); 
		query.append("                 ,BV.POL_CD" ).append("\n"); 
		query.append("                 ,BV.POD_CD" ).append("\n"); 
		query.append("				 ,(	SELECT BK.USA_CSTMS_FILE_CD || ',' || BK.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append("             		FROM   BKG_BOOKING BK " ).append("\n"); 
		query.append("             		WHERE  BK.BKG_NO = BV.BKG_NO ) CSTMS_FILE_CD" ).append("\n"); 
		query.append("           FROM   BKG_VVD BV" ).append("\n"); 
		query.append("           WHERE  0 = 0 " ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("      		AND     BV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      		AND     BV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("      		AND     BV.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("      		AND     BV.POL_CD LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("      		AND     BV.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			) A" ).append("\n"); 
		query.append("         ,BKG_CONTAINER B" ).append("\n"); 
		query.append("         ,BKG_CNTR_MF_DESC C" ).append("\n"); 
		query.append("   WHERE  A.BKG_NO = B.BKG_NO(+) " ).append("\n"); 
		query.append("   AND    B.BKG_NO = C.BKG_NO(+) " ).append("\n"); 
		query.append("   AND    B.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT  *" ).append("\n"); 
		query.append("FROM   (SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("              ,BKG.BL_NO                                           AS B_BL_NO" ).append("\n"); 
		query.append("              ,VVD.POL_CD                                          AS B_POL_CD" ).append("\n"); 
		query.append("              ,VVD.POD_CD                                          AS B_POD_CD" ).append("\n"); 
		query.append("              ,DECODE(BKG.BL_TP_CD,'W','W','')                     AS BL_TP_CD" ).append("\n"); 
		query.append("              ,BKG.BKG_CGO_TP_CD                                   AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("              ,HBL.HBL_NO                                          AS B_HBL_NO" ).append("\n"); 
		query.append("              ,HBL.CNTR_MF_NO                                      AS B_USA_CSTMS_FILE_NO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------------	SHIPPER" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(H_S.CUST_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_NM_FLG, RUL_ALL.SHPR_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_NM_FLG, RUL_ALL.SHPR_NM_FLG) END  AS B_CUST_NM_S" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("              ,CASE WHEN NVL(H_S.CUST_ADDR,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.SHPR_ADDR_FLG, RUL_ALL.SHPR_ADDR_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.SHPR_ADDR_FLG, RUL_ALL.SHPR_ADDR_FLG) END  AS B_CUST_ADDR_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_S.CTY_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.SHPR_CTY_FLG, RUL_ALL.SHPR_CTY_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.SHPR_CTY_FLG, RUL_ALL.SHPR_CTY_FLG) END  AS B_CUST_CT_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_S.CUST_CNT_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.SHPR_CNT_FLG, RUL_ALL.SHPR_CNT_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.SHPR_CNT_FLG, RUL_ALL.SHPR_CNT_FLG) END  AS B_CUST_CN_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------------  CONSIGNEE	" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_C.CUST_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.CNEE_NM_FLG, RUL_ALL.CNEE_NM_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.CNEE_NM_FLG, RUL_ALL.CNEE_NM_FLG) END  AS B_CUST_NM_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_C.CUST_ADDR,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.CNEE_ADDR_FLG, RUL_ALL.CNEE_ADDR_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.CNEE_ADDR_FLG, RUL_ALL.CNEE_ADDR_FLG) END  AS B_CUST_ADDR_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_C.CTY_NM,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.CNEE_CTY_FLG, RUL_ALL.CNEE_CTY_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.CNEE_CTY_FLG, RUL_ALL.CNEE_CTY_FLG) END  AS B_CUST_CT_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_C.STE_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.CNEE_STE_FLG, RUL_ALL.CNEE_STE_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.CNEE_STE_FLG, RUL_ALL.CNEE_STE_FLG) END  AS B_CUST_ST_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(H_C.CUST_CNT_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("					WHEN NVL(RUL_LOC.CNEE_CNT_FLG, RUL_ALL.CNEE_CNT_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("					ELSE NVL(RUL_LOC.CNEE_CNT_FLG, RUL_ALL.CNEE_CNT_FLG) END  AS B_CUST_CN_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------------    NOTIFY     " ).append("\n"); 
		query.append("              ,CASE WHEN NVL(H_N.CUST_NM,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_NM_FLG, RUL_ALL.NTFY_NM_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_NM_FLG, RUL_ALL.NTFY_NM_FLG) END  AS B_CUST_NM_N" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("              ,CASE WHEN NVL(H_N.CUST_ADDR,'N') <> 'N'  THEN  'Y' " ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.NTFY_ADDR_FLG, RUL_ALL.NTFY_ADDR_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.NTFY_ADDR_FLG, RUL_ALL.NTFY_ADDR_FLG) END  AS B_CUST_ADDR_N" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,REPLACE(C_C.CUST_NM,CHR(10),' ')         AS CUST_NM" ).append("\n"); 
		query.append("              ,REPLACE(C_S.CUST_NM,CHR(10),' ')         AS S_CUST_NM" ).append("\n"); 
		query.append("              ,REPLACE(C_N.CUST_NM,CHR(10),' ')         AS N_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------------------- House B/L Data				  " ).append("\n"); 
		query.append("              ,NVL(HBL.PCK_QTY,0)                                  AS B_PCK_QTY_DA" ).append("\n"); 
		query.append("              ,NVL(HBL.HBL_WGT,0)                                  AS B_HBL_WGT_DA" ).append("\n"); 
		query.append("              ,NVL(HBL.CMDT_MEAS_QTY,0)                            AS B_MEAS_QTY_DA" ).append("\n"); 
		query.append("              ,CASE WHEN HBL.PCK_QTY = CM_HBL.CM_PCK_HBL  THEN  'Y'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.PCK_FLG, RUL_ALL.PCK_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.PCK_FLG, RUL_ALL.PCK_FLG) END  AS B_PCK_QTY_CHK" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("              ,CASE WHEN HBL.HBL_WGT  = CM_HBL.CM_WGT_HBL  THEN  'Y'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.WGT_FLG, RUL_ALL.WGT_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.WGT_FLG, RUL_ALL.WGT_FLG) END  AS B_HBL_WGT_CHK" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("              ,CASE WHEN HBL.CMDT_MEAS_QTY = CM_HBL.CM_MEAS_HBL  THEN  'Y'" ).append("\n"); 
		query.append("                    WHEN NVL(RUL_LOC.MEAS_FLG, RUL_ALL.MEAS_FLG) ='Y' THEN 'E' " ).append("\n"); 
		query.append("                    ELSE NVL(RUL_LOC.MEAS_FLG, RUL_ALL.MEAS_FLG) END  AS B_MEAS_QTY_CHK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------C/M(Container Manifest)" ).append("\n"); 
		query.append("			  ,NVL(VVD.CM_PCK,0)                                AS B_PCK_QTY_CM" ).append("\n"); 
		query.append("      		  ,NVL(VVD.CM_WGT,0)                                AS B_CNTR_WGT_CM" ).append("\n"); 
		query.append("      		  ,NVL(VVD.CM_MEAS,0)                               AS B_MEAS_QTY_CM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          	  ,CASE WHEN NVL(VVD.CM_DS,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_DESC_FLG, RUL_ALL.CNTR_MF_DESC_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_DESC_FLG, RUL_ALL.CNTR_MF_DESC_FLG) END  AS B_CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(VVD.CM_MK,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_MK_FLG, RUL_ALL.CNTR_MF_MK_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_MK_FLG, RUL_ALL.CNTR_MF_MK_FLG) END  AS B_CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(VVD.HAMO_TRF_CD,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_CMDT_FLG, RUL_ALL.CNTR_MF_CMDT_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_CMDT_FLG, RUL_ALL.CNTR_MF_CMDT_FLG) END  AS B_CNTR_MF_HTS" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("           	  ,CASE WHEN NVL(VVD.NCM_NO,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.CNTR_MF_NCM_FLG, RUL_ALL.CNTR_MF_NCM_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.CNTR_MF_NCM_FLG, RUL_ALL.CNTR_MF_NCM_FLG) END  AS B_CNTR_MF_NCM" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("           	  ,CASE WHEN NVL(VVD.CM_AMS,'N') <> 'N'  THEN  'Y'" ).append("\n"); 
		query.append("                	WHEN NVL(RUL_LOC.XPT_IMP_REF_FLG1, RUL_ALL.XPT_IMP_REF_FLG1) ='Y' THEN 'E'" ).append("\n"); 
		query.append("                	ELSE NVL(RUL_LOC.XPT_IMP_REF_FLG1, RUL_ALL.XPT_IMP_REF_FLG1) END  AS B_CNTR_MF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------- Container " ).append("\n"); 
		query.append("              ,CNT.CNTR_NO                                         AS B_CNTR_NO" ).append("\n"); 
		query.append("              ,NVL(CNT.PCK_QTY,0)                                  AS B_PCK_QTY_CO" ).append("\n"); 
		query.append("              ,NVL(CNT.CNTR_WGT,0)                                 AS B_CNTR_WGT_CO" ).append("\n"); 
		query.append("              ,NVL(CNT.MEAS_QTY,0)                                 AS B_MEAS_QTY_CO" ).append("\n"); 
		query.append("              ,CASE WHEN NVL(BKG_JOIN_FNC(CURSOR( SELECT /*+ INDEX(BKG_CNTR_SEAL_NO XAK1BKG_CNTR_SEAL_NO) */  --> 힌트 추가" ).append("\n"); 
		query.append("                                       CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                FROM   BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                                WHERE  BKG_NO = CNT.BKG_NO AND CNTR_NO = CNT.CNTR_NO)),'N') <> 'N' THEN 'Y'" ).append("\n"); 
		query.append("      				WHEN  NVL(RUL_LOC.SEAL_NO_FLG, RUL_ALL.SEAL_NO_FLG) ='Y' THEN 'E'" ).append("\n"); 
		query.append("      				ELSE  'N' END  AS B_CNTR_SEAL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,'0' Seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tab_item} != '') " ).append("\n"); 
		query.append("	          ,@[tab_item] TAB_ITEM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        FROM   BKG_VVD_TMP      VVD" ).append("\n"); 
		query.append("              ,BKG_BOOKING      BKG" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_S" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_C" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER     C_N" ).append("\n"); 
		query.append("              ,BKG_HBL_CUST     H_S" ).append("\n"); 
		query.append("              ,BKG_HBL_CUST     H_C" ).append("\n"); 
		query.append("              ,BKG_HBL_CUST     H_N" ).append("\n"); 
		query.append("              ,BKG_HBL          HBL" ).append("\n"); 
		query.append("              ,BKG_BL_DOC       DOC" ).append("\n"); 
		query.append("              ,BKG_CONTAINER    CNT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			  ,BKG_CSTMS_RULE_STUP RUL_LOC" ).append("\n"); 
		query.append("			  ,BKG_CSTMS_RULE_STUP RUL_ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ,(SELECT CM.BKG_NO" ).append("\n"); 
		query.append("					  ,CM.CNTR_MF_NO" ).append("\n"); 
		query.append("                      ,SUM(CM.PCK_QTY) AS CM_PCK_HBL" ).append("\n"); 
		query.append("                      ,SUM(CM.CNTR_MF_WGT) AS CM_WGT_HBL" ).append("\n"); 
		query.append("                      ,SUM(CM.MEAS_QTY) AS CM_MEAS_HBL" ).append("\n"); 
		query.append("                FROM BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("                WHERE EXISTS (SELECT *" ).append("\n"); 
		query.append("                              FROM BKG_VVD_TMP VVD_TMP" ).append("\n"); 
		query.append("                              WHERE CM.BKG_NO = VVD_TMP.BKG_NO)" ).append("\n"); 
		query.append("                GROUP BY CM.BKG_NO" ).append("\n"); 
		query.append("					  ,CM.CNTR_MF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ) CM_HBL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO(+) = VVD.BKG_NO" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_S.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = C_N.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = CNT.BKG_NO(+)" ).append("\n"); 
		query.append("		AND VVD.CNTR_NO = CNT.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = HBL.BKG_NO(+)  " ).append("\n"); 
		query.append("		AND  VVD.CNTR_MF_NO = HBL.CNTR_MF_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     AND HBL.BKG_NO = H_S.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND HBL.HBL_SEQ = H_S.HBL_SEQ(+)" ).append("\n"); 
		query.append("                     AND HBL.BKG_NO = H_C.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND HBL.HBL_SEQ = H_C.HBL_SEQ(+)" ).append("\n"); 
		query.append("                     AND HBL.BKG_NO = H_N.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND HBL.HBL_SEQ = H_N.HBL_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND C_S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND C_C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND C_N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND H_S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("        AND H_C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("        AND H_N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND VVD.BKG_NO = CM_HBL.BKG_NO(+)" ).append("\n"); 
		query.append("		AND VVD.CNTR_MF_NO = CM_HBL.CNTR_MF_NO(+)" ).append("\n"); 
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
		query.append("        AND 'H' = RUL_LOC.BL_TP_CD (+)" ).append("\n"); 
		query.append("        AND 'N' = RUL_LOC.DELT_FLG (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND 'CTM' = RUL_ALL.CSTMS_DIV_ID (+)" ).append("\n"); 
		query.append("        AND 'Y' = RUL_ALL.FROB_FLG (+)" ).append("\n"); 
		query.append("        AND 'H' = RUL_ALL.BL_TP_CD (+)" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("        AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("        AND BKG.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("        AND BKG.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("        ORDER BY BKG.BL_NO, BKG.BKG_NO, B_USA_CSTMS_FILE_NO,C_C.CUST_NM" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#if (${chk_err} != '' && ${chk_err} == '0')" ).append("\n"); 
		query.append("  WHERE B_CUST_NM_S = 'E'" ).append("\n"); 
		query.append("    OR B_CUST_ADDR_S = 'E'" ).append("\n"); 
		query.append("	OR B_CUST_CT_S = 'E'" ).append("\n"); 
		query.append("	OR B_CUST_CN_S = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    OR B_CUST_NM_C = 'E'" ).append("\n"); 
		query.append("    OR B_CUST_ADDR_C = 'E'" ).append("\n"); 
		query.append("	OR B_CUST_CT_C = 'E'" ).append("\n"); 
		query.append("	OR B_CUST_ST_C = 'E'" ).append("\n"); 
		query.append("	OR B_CUST_CN_C = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    OR B_CUST_NM_N = 'E'" ).append("\n"); 
		query.append("    OR B_CUST_ADDR_N = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    OR B_PCK_QTY_CHK = 'E'" ).append("\n"); 
		query.append("    OR B_HBL_WGT_CHK = 'E'" ).append("\n"); 
		query.append("    OR B_MEAS_QTY_CHK = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	OR B_CNTR_MF_GDS_DESC  = 'E'" ).append("\n"); 
		query.append("	OR B_CNTR_MF_MK_DESC = 'E'" ).append("\n"); 
		query.append("    OR B_CNTR_MF_HTS = 'E'" ).append("\n"); 
		query.append("	OR B_CNTR_MF_NCM = 'E'" ).append("\n"); 
		query.append("	OR B_CNTR_MF_NO = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    OR B_CNTR_SEAL_SEQ = 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}