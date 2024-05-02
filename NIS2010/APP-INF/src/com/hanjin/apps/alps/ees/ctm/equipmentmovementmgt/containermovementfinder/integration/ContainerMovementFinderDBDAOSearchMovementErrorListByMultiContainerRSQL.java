/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementErrorListByMultiContainerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.04 
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

public class ContainerMovementFinderDBDAOSearchMovementErrorListByMultiContainerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi 오류 건 조회.
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementErrorListByMultiContainerRSQL(){
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
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementErrorListByMultiContainerRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("  BL_NO," ).append("\n"); 
		query.append("  CALL_SGN_LLOYD," ).append("\n"); 
		query.append("  CALL_SGN_NO," ).append("\n"); 
		query.append("  LLOYD_NO," ).append("\n"); 
		query.append("  CHSS_NO," ).append("\n"); 
		query.append("  CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNTR_SEAL_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  CRE_LOCL_DT," ).append("\n"); 
		query.append("  VVD_CD," ).append("\n"); 
		query.append("  CRNT_VSL_CD," ).append("\n"); 
		query.append("  CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("  CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("  DEST_YD_CD," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  EDI_BKG_NO," ).append("\n"); 
		query.append("  EDI_GATE_IO_CD," ).append("\n"); 
		query.append("  EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("  EVNT_DT," ).append("\n"); 
		query.append("  EVNT_YD_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("  MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("  MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("  MVMT_EDI_RMK," ).append("\n"); 
		query.append("  CNMV_RMK," ).append("\n"); 
		query.append("  MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("  MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("  MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("  RTY_KNT," ).append("\n"); 
		query.append("  VNDR_SEQ," ).append("\n"); 
		query.append("  MGST_NO," ).append("\n"); 
		query.append("  WBL_NO," ).append("\n"); 
		query.append("  PKUP_NO," ).append("\n"); 
		query.append("  LCC_CD," ).append("\n"); 
		query.append("  VGM," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  VGM_VRFY_DT," ).append("\n"); 
		query.append("  VGM_SIG_CTNT," ).append("\n"); 
		query.append("  VGM_REF_NO," ).append("\n"); 
		query.append("  VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("  VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("   SELECT ROW_NUMBER() OVER (ORDER BY EVNT_DT) AS ROWNO," ).append("\n"); 
		query.append("     BKG_NO," ).append("\n"); 
		query.append("     BL_NO," ).append("\n"); 
		query.append("     CALL_SGN_LLOYD," ).append("\n"); 
		query.append("     CALL_SGN_NO," ).append("\n"); 
		query.append("     LLOYD_NO," ).append("\n"); 
		query.append("     CHSS_NO," ).append("\n"); 
		query.append("     CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("     CNTR_NO," ).append("\n"); 
		query.append("     CNTR_SEAL_NO," ).append("\n"); 
		query.append("     CNTR_TPSZ_CD," ).append("\n"); 
		query.append("     CRE_LOCL_DT," ).append("\n"); 
		query.append("     VVD_CD," ).append("\n"); 
		query.append("     CRNT_VSL_CD," ).append("\n"); 
		query.append("     CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("     CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("     DEST_YD_CD," ).append("\n"); 
		query.append("     POL_CD," ).append("\n"); 
		query.append("     POD_CD," ).append("\n"); 
		query.append("     EDI_BKG_NO," ).append("\n"); 
		query.append("     EDI_GATE_IO_CD," ).append("\n"); 
		query.append("     EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("     EVNT_DT," ).append("\n"); 
		query.append("     EVNT_YD_CD," ).append("\n"); 
		query.append("     MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("     MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("     MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("     MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("     MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("     MVMT_EDI_RMK," ).append("\n"); 
		query.append("     CNMV_RMK," ).append("\n"); 
		query.append("     MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("     MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("     MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("     RTY_KNT," ).append("\n"); 
		query.append("     VNDR_SEQ," ).append("\n"); 
		query.append("     MGST_NO," ).append("\n"); 
		query.append("     WBL_NO," ).append("\n"); 
		query.append("     PKUP_NO," ).append("\n"); 
		query.append("     LCC_CD," ).append("\n"); 
		query.append("     VGM," ).append("\n"); 
		query.append("     VGM_MZD_TP_CD," ).append("\n"); 
		query.append("     VGM_WGT_UT_CD," ).append("\n"); 
		query.append("     VGM_WGT_QTY," ).append("\n"); 
		query.append("     VGM_VRFY_DT," ).append("\n"); 
		query.append("     VGM_SIG_CTNT," ).append("\n"); 
		query.append("     VGM_REF_NO," ).append("\n"); 
		query.append("     VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("     VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("      SELECT /*+ USE_NL(D B A) */" ).append("\n"); 
		query.append("        D.BKG_NO," ).append("\n"); 
		query.append("        D.EDI_BL_NO AS BL_NO," ).append("\n"); 
		query.append("        NVL(D.CALL_SGN_NO, D.LLOYD_NO) AS CALL_SGN_LLOYD," ).append("\n"); 
		query.append("        D.CALL_SGN_NO AS CALL_SGN_NO," ).append("\n"); 
		query.append("        D.LLOYD_NO AS LLOYD_NO," ).append("\n"); 
		query.append("        D.CHSS_NO," ).append("\n"); 
		query.append("        D.CNTR_FULL_STS_CD," ).append("\n"); 
		query.append("        D.CNTR_NO," ).append("\n"); 
		query.append("        D.CNTR_SEAL_NO," ).append("\n"); 
		query.append("        D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        TO_CHAR(D.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("        D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("        D.CRNT_VSL_CD," ).append("\n"); 
		query.append("        D.CRNT_SKD_VOY_NO," ).append("\n"); 
		query.append("        D.CRNT_SKD_DIR_CD," ).append("\n"); 
		query.append("        D.DEST_YD_CD," ).append("\n"); 
		query.append("        D.BKG_POL_CD AS POL_CD," ).append("\n"); 
		query.append("        D.BKG_POD_CD AS POD_CD," ).append("\n"); 
		query.append("        D.EDI_BKG_NO," ).append("\n"); 
		query.append("        D.EDI_GATE_IO_CD," ).append("\n"); 
		query.append("        D.EDI_MVMT_STS_CD," ).append("\n"); 
		query.append("        TO_CHAR(D.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT," ).append("\n"); 
		query.append("        D.EVNT_YD_CD," ).append("\n"); 
		query.append("        D.MVMT_EDI_MSG_AREA_CD," ).append("\n"); 
		query.append("        D.MVMT_EDI_MSG_SEQ," ).append("\n"); 
		query.append("        D.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("        D.MVMT_EDI_MSG_YRMONDY," ).append("\n"); 
		query.append("        D.MVMT_EDI_TP_CD," ).append("\n"); 
		query.append("        D.MVMT_EDI_RMK," ).append("\n"); 
		query.append("        D.CNMV_RMK," ).append("\n"); 
		query.append("        D.MVMT_EDI_SGHT_CD," ).append("\n"); 
		query.append("        D.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("        D.MVMT_EDI_RSLT_CD," ).append("\n"); 
		query.append("        D.RTY_KNT," ).append("\n"); 
		query.append("        D.VNDR_SEQ," ).append("\n"); 
		query.append("        D.MGST_NO," ).append("\n"); 
		query.append("        D.WBL_NO," ).append("\n"); 
		query.append("        D.PKUP_NO," ).append("\n"); 
		query.append("        A.LCC_CD," ).append("\n"); 
		query.append("        D.VGM_WGT_QTY || ' ' || D.VGM_WGT_UT_CD AS VGM," ).append("\n"); 
		query.append("        D.VGM_MZD_TP_CD," ).append("\n"); 
		query.append("        DECODE(D.VGM_WGT_UT_CD, 'KGM', 'KGS', D.VGM_WGT_UT_CD) AS VGM_WGT_UT_CD," ).append("\n"); 
		query.append("        D.VGM_WGT_QTY," ).append("\n"); 
		query.append("        D.VGM_VRFY_DT," ).append("\n"); 
		query.append("        D.VGM_SIG_CTNT," ).append("\n"); 
		query.append("        D.VGM_REF_NO," ).append("\n"); 
		query.append("        D.VGM_WGT_PTY_CTNT," ).append("\n"); 
		query.append("        D.VGM_VRFY_ORD_CTNT" ).append("\n"); 
		query.append("      FROM CTM_MVMT_EDI_MSG D," ).append("\n"); 
		query.append("        MDM_LOCATION B," ).append("\n"); 
		query.append("        MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("      WHERE 1 = 1" ).append("\n"); 
		query.append("        AND D.MVMT_EDI_RSLT_CD <> 'Y'" ).append("\n"); 
		query.append("        AND 1 = CASE WHEN D.MVMT_EDI_RSLT_CD <> 'N'" ).append("\n"); 
		query.append("                            AND (D.MVMT_EDI_RMK LIKE 'Time gap between event and receiving date is%'" ).append("\n"); 
		query.append("                                 OR D.MVMT_EDI_RMK LIKE 'The same data already%'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                       THEN 1" ).append("\n"); 
		query.append("                     WHEN D.MVMT_EDI_RSLT_CD = 'N' THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("        AND A.SCC_CD(+) = B.SCC_CD" ).append("\n"); 
		query.append("        AND B.LOC_CD(+) = SUBSTR(D.EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("        AND D.CNTR_NO IN (" ).append("\n"); 
		query.append("  #foreach ($cntr_cd in ${cntr_no_list})" ).append("\n"); 
		query.append("      #if ($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${divflag} == 1 || ${divflag} == 3)" ).append("\n"); 
		query.append("        AND D.EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYYMMDD') AND TO_DATE (@[p_date2], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND D.CRE_DT BETWEEN TO_DATE (@[p_date1], 'YYYYMMDD') AND TO_DATE (@[p_date2], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("        AND D.EDI_BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("        AND D.CRNT_VSL_CD || D.CRNT_SKD_VOY_NO || D.CRNT_SKD_DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vgm_wgt_qty} != '')" ).append("\n"); 
		query.append("  #if (${vgm_wgt_qty} == 'Y')" ).append("\n"); 
		query.append("        AND D.VGM_WGT_QTY IS NOT NULL" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("        AND D.VGM_WGT_QTY IS NULL" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '')" ).append("\n"); 
		query.append("    AND D.EVNT_YD_CD LIKE @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("    AND D.EVNT_YD_CD IN (SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                         WHERE LOC_CD IN (SELECT LOC_CD" ).append("\n"); 
		query.append("                                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                          WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                            AND SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                           WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    #if (${lcc_cd} != '' && ${lcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                                             AND LCC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($lcc_cd in ${lcc_cd_list})" ).append("\n"); 
		query.append("        #if ($velocityCount < $lcc_cd_list.size()) '$lcc_cd', #else '$lcc_cd' #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("                                                                          )" ).append("\n"); 
		query.append("    #elseif (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                                             AND RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                                          )" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND D.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  #foreach ($tpsz_cd in ${cntr_tpsz_cd_list})" ).append("\n"); 
		query.append("    #if ($velocityCount < $cntr_tpsz_cd_list.size()) '$tpsz_cd', #else '$tpsz_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("    AND D.EDI_MVMT_STS_CD IN (" ).append("\n"); 
		query.append("  #foreach ($status_cd in ${mvmt_sts_cd_list})" ).append("\n"); 
		query.append("    #if ($velocityCount < $mvmt_sts_cd_list.size()) '$status_cd', #else '$status_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("WHERE ROWNO BETWEEN ((1000 * (TO_NUMBER(@[pagerows]) - 1)) + 1) AND ((1000 * (TO_NUMBER(@[pagerows]) - 1)) + 1000)" ).append("\n"); 

	}
}