/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : YardManageDBDAOSearchNodeDefaultSpInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOSearchNodeDefaultSpInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public YardManageDBDAOSearchNodeDefaultSpInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration").append("\n"); 
		query.append("FileName : YardManageDBDAOSearchNodeDefaultSpInfoListRSQL").append("\n"); 
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
		query.append("SELECT YD_CD," ).append("\n"); 
		query.append("        YD_NM," ).append("\n"); 
		query.append("        OFC_CD," ).append("\n"); 
		query.append("        DECODE(YD_FCTY_TP_MRN_TML_FLG, 'Y', 'Y', 'N', ' ') AS YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("        DECODE(YD_FCTY_TP_BRG_RMP_FLG, 'Y', 'Y', 'N', ' ') AS YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("        DECODE(YD_FCTY_TP_CY_FLG, 'Y', 'Y', 'N', ' ') AS YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("        DECODE(YD_FCTY_TP_CFS_FLG, 'Y', 'Y', 'N', ' ') AS YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("        DECODE(YD_FCTY_TP_RAIL_RMP_FLG, 'Y', 'Y', 'N', ' ') AS YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("        DECODE(YD_FCTY_TP_PSDO_YD_FLG, 'Y', 'Y', 'N', ' ') AS YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("		DECODE(YD_CHR_CD,'N','ON DOCK','F','OFF DOCK') AS YD_CHR_CD," ).append("\n"); 
		query.append("	    DECODE(os,'A','Terminal/CY Handling','B','Stevedoring','C','Security','D','Wharfage','E','Assessment','F','Storage') AS os," ).append("\n"); 
		query.append("		SP_CODE," ).append("\n"); 
		query.append("		SP_NAME," ).append("\n"); 
		query.append("'' as LOC_CD," ).append("\n"); 
		query.append("'' as COUNTRY," ).append("\n"); 
		query.append("'' as N4TH_VNDR_CNT_CD," ).append("\n"); 
		query.append("'' as N4TH_VNDR_SEQ," ).append("\n"); 
		query.append("'' as N5TH_VNDR_CNT_CD," ).append("\n"); 
		query.append("'' as N5TH_VNDR_SEQ," ).append("\n"); 
		query.append("'' as N6TH_VNDR_CNT_CD," ).append("\n"); 
		query.append("'' as N6TH_VNDR_SEQ," ).append("\n"); 
		query.append("'' as updUsrId," ).append("\n"); 
		query.append("'' as country_code," ).append("\n"); 
		query.append("'' as incl_sub_ofc_flg," ).append("\n"); 
		query.append("'' as old_ofc_cd," ).append("\n"); 
		query.append("'' as VNDR_SEQ," ).append("\n"); 
		query.append("'' as VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' as VNDR_CNT_CD," ).append("\n"); 
		query.append("'' as chk_vndr_seq," ).append("\n"); 
		query.append("'' as update_yn," ).append("\n"); 
		query.append("'' as chk_os_all," ).append("\n"); 
		query.append("'' as chk_os_a," ).append("\n"); 
		query.append("'' as chk_os_b," ).append("\n"); 
		query.append("'' as chk_os_c," ).append("\n"); 
		query.append("'' as chk_os_d," ).append("\n"); 
		query.append("'' as chk_os_e," ).append("\n"); 
		query.append("'' as chk_os_f" ).append("\n"); 
		query.append("  FROM (SELECT YD_CD," ).append("\n"); 
		query.append("               YD_NM," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("               YD_CHR_CD," ).append("\n"); 
		query.append("               'A' AS OS," ).append("\n"); 
		query.append("               LPAD(TO_CHAR(N1ST_VNDR_SEQ), 6, '0') AS SP_CODE," ).append("\n"); 
		query.append("               (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = N1ST_VNDR_SEQ) AS SP_NAME," ).append("\n"); 
		query.append("                 LOC_CD," ).append("\n"); 
		query.append("                 DELT_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT YD_CD," ).append("\n"); 
		query.append("               YD_NM," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("               YD_CHR_CD," ).append("\n"); 
		query.append("               'B' AS OS," ).append("\n"); 
		query.append("               LPAD(TO_CHAR(N2ND_VNDR_SEQ), 6, '0') AS SP_CODE," ).append("\n"); 
		query.append("               (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = N2ND_VNDR_SEQ) AS SP_NAME," ).append("\n"); 
		query.append("                 LOC_CD," ).append("\n"); 
		query.append("                 DELT_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT YD_CD," ).append("\n"); 
		query.append("               YD_NM," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("               YD_CHR_CD," ).append("\n"); 
		query.append("               'C' AS OS," ).append("\n"); 
		query.append("               LPAD(TO_CHAR(N3RD_VNDR_SEQ), 6, '0') AS SP_CODE," ).append("\n"); 
		query.append("               (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = N3RD_VNDR_SEQ) AS SP_NAME," ).append("\n"); 
		query.append("                 LOC_CD," ).append("\n"); 
		query.append("                 DELT_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT YD_CD," ).append("\n"); 
		query.append("               YD_NM," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("               YD_CHR_CD," ).append("\n"); 
		query.append("               'D' AS OS," ).append("\n"); 
		query.append("               LPAD(TO_CHAR(N4TH_VNDR_SEQ), 6, '0') AS SP_CODE," ).append("\n"); 
		query.append("               (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = N4TH_VNDR_SEQ) AS SP_NAME," ).append("\n"); 
		query.append("                 LOC_CD," ).append("\n"); 
		query.append("                 DELT_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT YD_CD," ).append("\n"); 
		query.append("               YD_NM," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("               YD_CHR_CD," ).append("\n"); 
		query.append("               'E' AS OS," ).append("\n"); 
		query.append("               LPAD(TO_CHAR(N5TH_VNDR_SEQ), 6, '0') AS SP_CODE," ).append("\n"); 
		query.append("               (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = N5TH_VNDR_SEQ) AS SP_NAME," ).append("\n"); 
		query.append("                 LOC_CD," ).append("\n"); 
		query.append("                 DELT_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT YD_CD," ).append("\n"); 
		query.append("               YD_NM," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               YD_FCTY_TP_MRN_TML_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_BRG_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CY_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_CFS_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_RAIL_RMP_FLG," ).append("\n"); 
		query.append("               YD_FCTY_TP_PSDO_YD_FLG," ).append("\n"); 
		query.append("               YD_CHR_CD," ).append("\n"); 
		query.append("               'F' AS OS," ).append("\n"); 
		query.append("               LPAD(TO_CHAR(N6TH_VNDR_SEQ), 6, '0') AS SP_CODE," ).append("\n"); 
		query.append("               (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                  FROM MDM_VENDOR" ).append("\n"); 
		query.append("                 WHERE VNDR_SEQ = N6TH_VNDR_SEQ) AS SP_NAME," ).append("\n"); 
		query.append("                 LOC_CD," ).append("\n"); 
		query.append("                 DELT_FLG" ).append("\n"); 
		query.append("          FROM MDM_YARD" ).append("\n"); 
		query.append("      ORDER BY 1, 2, os)" ).append("\n"); 
		query.append(" WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append(" #if(${yd_cd} != '')" ).append("\n"); 
		query.append("   AND YD_CD LIKE @[yd_cd] || '%' " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if(${yd_nm} != '')" ).append("\n"); 
		query.append("   AND YD_NM LIKE @[yd_nm] || '%' " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if(${ofc_cd} != '' && ${incl_sub_ofc_flg} == 'N')" ).append("\n"); 
		query.append("   AND OFC_CD IN (@[ofc_cd])" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if(${yd_chr_cd} != '')" ).append("\n"); 
		query.append("   AND YD_CHR_CD LIKE @[yd_chr_cd] || '%' " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if(${loc_cd} != '')" ).append("\n"); 
		query.append("   AND LOC_CD LIKE @[loc_cd] || '%' " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${country} != '')" ).append("\n"); 
		query.append("   AND SUBSTR(YD_CD,0,2) LIKE @[country] || '%' " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${incl_sub_ofc_flg} == 'Y' && ${ofc_cd} != '' )" ).append("\n"); 
		query.append("   AND OFC_CD IN (SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("				   WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("				CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("						START WITH OFC_CD = @[old_ofc_cd])" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_all} == 'ALL' )" ).append("\n"); 
		query.append("		AND (1=1 " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_all} != 'ALL' )" ).append("\n"); 
		query.append("		AND (1=2" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_a} == 'Y' )" ).append("\n"); 
		query.append("	OR os = 'A'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_b} == 'Y' )" ).append("\n"); 
		query.append("	OR os = 'B'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_c} == 'Y' )" ).append("\n"); 
		query.append("	OR os = 'C'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_d} == 'Y' )" ).append("\n"); 
		query.append("	OR os = 'D'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_e} == 'Y' )" ).append("\n"); 
		query.append("	OR os = 'E'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${chk_os_f} == 'Y' )" ).append("\n"); 
		query.append("	OR os = 'F'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}