/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementListByMultiContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchMovementListByMultiContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0465 : 컨테이너 번호에 의한 Multi Container 의 Each Container LIST 조회
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementListByMultiContainerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementListByMultiContainerRSQL").append("\n"); 
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
		query.append("SELECT CNMV_CYC_NO," ).append("\n"); 
		query.append("  CNMV_CO_CD," ).append("\n"); 
		query.append("  MVMT_STS_CD," ).append("\n"); 
		query.append("  MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("  ORG_YD_CD," ).append("\n"); 
		query.append("  DEST_YD_CD," ).append("\n"); 
		query.append("  CNMV_EVNT_DT," ).append("\n"); 
		query.append("  VVD_CD," ).append("\n"); 
		query.append("  BKG_KNT," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  BL_NO," ).append("\n"); 
		query.append("  DECODE(FCNTR_FLG, 'Y', 'F', 'M') AS FCNTR_FLG," ).append("\n"); 
		query.append("  DECODE(OB_CNTR_FLG, 'Y', 'O', 'I') AS OB_CNTR_FLG," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("  BKG_CGO_TP_CD," ).append("\n"); 
		query.append("  CNTR_DMG_FLG," ).append("\n"); 
		query.append("  CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("  CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("  CNTR_DISP_FLG," ).append("\n"); 
		query.append("  IMDT_EXT_FLG," ).append("\n"); 
		query.append("  CNTR_RFUB_FLG," ).append("\n"); 
		query.append("  SPCL_CGO_FLG," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  VNDR_ABBR_NM," ).append("\n"); 
		query.append("  MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("  CHSS_NO," ).append("\n"); 
		query.append("  MGST_NO," ).append("\n"); 
		query.append("  CNTR_SEAL_NO," ).append("\n"); 
		query.append("  WBL_NO," ).append("\n"); 
		query.append("  PKUP_NO," ).append("\n"); 
		query.append("  UPD_LOCL_DT," ).append("\n"); 
		query.append("  CRE_LOCL_DT," ).append("\n"); 
		query.append("  UPD_DT," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  OFC_CD," ).append("\n"); 
		query.append("  USR_NM," ).append("\n"); 
		query.append("  CNMV_RMK," ).append("\n"); 
		query.append("  CNMV_YR," ).append("\n"); 
		query.append("  CNMV_SEQ," ).append("\n"); 
		query.append("  CNMV_SPLIT_NO," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  VGM_VRFY_DT," ).append("\n"); 
		query.append("  VGM_SIG_CTNT," ).append("\n"); 
		query.append("  VGM_REF_NO," ).append("\n"); 
		query.append("  VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("  VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("   SELECT A.CNMV_CYC_NO," ).append("\n"); 
		query.append("     A.CNMV_CO_CD," ).append("\n"); 
		query.append("     A.MVMT_STS_CD," ).append("\n"); 
		query.append("     A.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("     A.ORG_YD_CD," ).append("\n"); 
		query.append("     A.DEST_YD_CD," ).append("\n"); 
		query.append("     TO_CHAR(A.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("     A.CRNT_VSL_CD || A.CRNT_SKD_VOY_NO || A.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("     A.BKG_KNT," ).append("\n"); 
		query.append("     A.BKG_NO," ).append("\n"); 
		query.append("     A.BL_NO," ).append("\n"); 
		query.append("     A.FCNTR_FLG," ).append("\n"); 
		query.append("     A.OB_CNTR_FLG," ).append("\n"); 
		query.append("     A.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("     A.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("     A.CNTR_DMG_FLG," ).append("\n"); 
		query.append("     NVL2(MST.CNTR_HNGR_RCK_CD, 'Y', 'N') AS CNTR_HNGR_RCK_CD," ).append("\n"); 
		query.append("     NVL(MST.CNTR_HNGR_BAR_ATCH_KNT, '') AS CNTR_HNGR_BAR_ATCH_KNT," ).append("\n"); 
		query.append("     A.CNTR_DISP_FLG," ).append("\n"); 
		query.append("     A.IMDT_EXT_FLG," ).append("\n"); 
		query.append("     A.CNTR_RFUB_FLG," ).append("\n"); 
		query.append("     A.SPCL_CGO_FLG," ).append("\n"); 
		query.append("     C.VNDR_SEQ," ).append("\n"); 
		query.append("     C.VNDR_ABBR_NM," ).append("\n"); 
		query.append("     A.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("     TRIM(A.CHSS_NO) AS CHSS_NO," ).append("\n"); 
		query.append("     TRIM(A.MGST_NO) AS MGST_NO," ).append("\n"); 
		query.append("     TRIM(A.CNTR_SEAL_NO) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("     TRIM(A.WBL_NO) AS WBL_NO," ).append("\n"); 
		query.append("     TRIM(A.PKUP_NO) AS PKUP_NO," ).append("\n"); 
		query.append("     TO_CHAR(A.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS UPD_LOCL_DT," ).append("\n"); 
		query.append("     TO_CHAR(A.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("     TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("     TO_CHAR(A.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("     A.OFC_CD," ).append("\n"); 
		query.append("     TRIM(A.USR_NM) AS USR_NM," ).append("\n"); 
		query.append("     TRIM(A.CNMV_RMK) AS CNMV_RMK," ).append("\n"); 
		query.append("     A.CNMV_YR," ).append("\n"); 
		query.append("     A.CNMV_SEQ," ).append("\n"); 
		query.append("     A.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("     A.CNTR_NO," ).append("\n"); 
		query.append("     A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("     A.VGM_MZD_TP_CD," ).append("\n"); 
		query.append("     DECODE(A.VGM_WGT_UT_CD, 'KGM', 'KGS', A.VGM_WGT_UT_CD) AS VGM_WGT_UT_CD," ).append("\n"); 
		query.append("     A.VGM_WGT_QTY," ).append("\n"); 
		query.append("     TO_CHAR(A.VGM_VRFY_DT, 'YYYY-MM-DD HH24:MI') AS VGM_VRFY_DT," ).append("\n"); 
		query.append("     A.VGM_SIG_CTNT," ).append("\n"); 
		query.append("     A.VGM_REF_NO," ).append("\n"); 
		query.append("     A.VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("     A.VGM_VRFY_ORD_CTNT," ).append("\n"); 
		query.append("     ROW_NUMBER() OVER(ORDER BY A.CNTR_NO, A.CNMV_YR, A.CNMV_SEQ, A.CNMV_SPLIT_NO) AS RN" ).append("\n"); 
		query.append("   FROM CTM_MOVEMENT A," ).append("\n"); 
		query.append("     MDM_VENDOR C," ).append("\n"); 
		query.append("     MST_CONTAINER MST" ).append("\n"); 
		query.append("  WHERE 1 = 1" ).append("\n"); 
		query.append("    AND A.CNTR_NO = MST.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("    AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("  #foreach ($cntr_cd in ${cntr_no_list})" ).append("\n"); 
		query.append("      #if ($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${divflag} == 1 || ${divflag} == 3)" ).append("\n"); 
		query.append("    AND A.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYYMMDD') AND TO_DATE (@[p_date2], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND A.CRE_DT BETWEEN TO_DATE (@[p_date1], 'YYYYMMDD') AND TO_DATE (@[p_date2], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("    AND (A.BKG_NO = @[bkg_no] OR A.BL_NO = @[bkg_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("    AND A.CRNT_VSL_CD || A.CRNT_SKD_VOY_NO || A.CRNT_SKD_DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vgm_wgt_qty} != '')" ).append("\n"); 
		query.append("  #if (${vgm_wgt_qty} == 'Y')" ).append("\n"); 
		query.append("    AND A.VGM_WGT_QTY IS NOT NULL" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND A.VGM_WGT_QTY IS NULL" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mvmt_inp_tp_cd} != '')" ).append("\n"); 
		query.append("  #if (${mvmt_inp_tp_cd} == 'EDI')" ).append("\n"); 
		query.append("    AND A.MVMT_INP_TP_CD IN ('EDI', 'SPP')" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("    AND A.MVMT_INP_TP_CD = 'MAN'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '')" ).append("\n"); 
		query.append("    AND A.ORG_YD_CD LIKE @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND A.ORG_YD_CD IN (SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                        WHERE LOC_CD IN (SELECT LOC_CD" ).append("\n"); 
		query.append("                                         FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                         WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                           AND SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                          WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    #if (${lcc_cd} != '' && ${lcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                                            AND LCC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($lcc_cd in ${lcc_cd_list})" ).append("\n"); 
		query.append("        #if ($velocityCount < $lcc_cd_list.size()) '$lcc_cd', #else '$lcc_cd' #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("                                                                          )" ).append("\n"); 
		query.append("    #elseif (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                                            AND RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  #foreach ($tpsz_cd in ${cntr_tpsz_cd_list})" ).append("\n"); 
		query.append("    #if ($velocityCount < $cntr_tpsz_cd_list.size()) '$tpsz_cd', #else '$tpsz_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("    AND A.MVMT_STS_CD IN (" ).append("\n"); 
		query.append("  #foreach ($status_cd in ${mvmt_sts_cd_list})" ).append("\n"); 
		query.append("    #if ($velocityCount < $mvmt_sts_cd_list.size()) '$status_cd', #else '$status_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND RN BETWEEN ((1000 * (TO_NUMBER(@[pagerows]) - 1)) + 1) AND ((1000 * (TO_NUMBER(@[pagerows]) - 1)) + 1000)" ).append("\n"); 
		query.append("ORDER BY CNTR_NO, CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO" ).append("\n"); 

	}
}