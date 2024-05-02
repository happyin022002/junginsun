/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchVermasMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchVermasMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchVermasMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brac_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchVermasMainRSQL").append("\n"); 
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
		query.append("      'MSG_REF_NO:' || BXVR.XTER_VGM_DOC_ID    || CHR(10)" ).append("\n"); 
		query.append("    ||'MSG_STS:'    || @[brac_cd]   || CHR(10)" ).append("\n"); 
		query.append("    ||'MSG_ISS_DT:' || TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')     || CHR(10)" ).append("\n"); 
		query.append("	||'ORG_SND:'	|| CASE WHEN ECOM.USR_ID = '304' THEN BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("		                    WHEN ECOM.USR_ID IN ('322','COD') THEN ECOM.USR_ID" ).append("\n"); 
		query.append("                            WHEN ECOM.USR_ID IS NOT NULL THEN 'ECOM'" ).append("\n"); 
		query.append("                            WHEN BXVR.XTER_SNDR_ID IS NOT NULL THEN BXVR.XTER_SNDR_ID" ).append("\n"); 
		query.append("                            ELSE '' END || CHR(10)" ).append("\n"); 
		query.append("    ||'YD_CD:'      || @[ref_cd]    || CHR(10)" ).append("\n"); 
		query.append("    ||'YD_NM:'      || (SELECT MY.YD_NM FROM MDM_YARD MY WHERE MY.YD_CD = @[ref_cd] AND ROWNUM = 1)    || CHR(10)                  " ).append("\n"); 
		query.append("    ||'YD_LOC_NAME:'|| (SELECT ML.LOC_NM FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(@[ref_cd],1,5) AND ROWNUM = 1)    || CHR(10)" ).append("\n"); 
		query.append("    ||'PARTNER_IND:'|| CHR(10)" ).append("\n"); 
		query.append("    ||'{REF_INFO'                              || CHR(10)" ).append("\n"); 
		query.append("    ||'REF_TP:'     || 'SI'                    || CHR(10)" ).append("\n"); 
		query.append("    ||'REF_NO:'     || BXVR.REF_NO             || CHR(10)" ).append("\n"); 
		query.append("    ||'REF_DT:'     || TO_CHAR(BXVR.VGM_REF_DT, 'YYYYMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("    ||'}REF_INFO'                              || CHR(10)" ).append("\n"); 
		query.append("    ||'{CNTR_INFO'                             || CHR(10)" ).append("\n"); 
		query.append("    ||'CNTR_NO:'    || BC.CNTR_NO            || CHR(10)" ).append("\n"); 
		query.append("    ||'CNTR_TPSZ:'  || BC.CNTR_TPSZ_CD         || CHR(10)   " ).append("\n"); 
		query.append("    ||'SOC_IND:'    || DECODE(BC.SOC_FLG,'Y','1','0') || CHR(10)  " ).append("\n"); 
		query.append("    ||'FM_IND:'     || BB.BKG_CGO_TP_CD        || CHR(10)  " ).append("\n"); 
		query.append("    || (SELECT '{CNTR_REF_INFO'                        || CHR(10)" ).append("\n"); 
		query.append("              ||'REF_TP:'      || 'BM'                 || CHR(10)" ).append("\n"); 
		query.append("              ||'REF_NO:'      || BB.BL_NO             || CHR(10)" ).append("\n"); 
		query.append("              ||'}CNTR_REF_INFO' || CHR(10) " ).append("\n"); 
		query.append("       FROM DUAL)" ).append("\n"); 
		query.append("    || (SELECT '{CNTR_REF_INFO'                        || CHR(10)" ).append("\n"); 
		query.append("              ||'REF_TP:'      || 'BN'                 || CHR(10)" ).append("\n"); 
		query.append("              ||'REF_NO:'      || BB.BKG_NO            || CHR(10)" ).append("\n"); 
		query.append("              ||'}CNTR_REF_INFO' || CHR(10) " ).append("\n"); 
		query.append("       FROM DUAL)" ).append("\n"); 
		query.append("    || (SELECT '{CNTR_REF_INFO'                        || CHR(10)" ).append("\n"); 
		query.append("              ||'REF_TP:'      || 'SI'                 || CHR(10)" ).append("\n"); 
		query.append("              ||'REF_NO:'      || MST.XTER_RQST_NO     || CHR(10)" ).append("\n"); 
		query.append("              ||'}CNTR_REF_INFO' || CHR(10) " ).append("\n"); 
		query.append("       FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("       WHERE MST.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("       AND   MST.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("       AND   ROWNUM = 1)" ).append("\n"); 
		query.append("    || CASE WHEN (SELECT COUNT(*) FROM BKG_CNTR_SEAL_NO BCSN" ).append("\n"); 
		query.append("                                  WHERE BCSN.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                                  AND   BCSN.CNTR_NO = BC.CNTR_NO) = 0 " ).append("\n"); 
		query.append("                 THEN TO_CLOB('{SEAL_INFO'|| CHR(10) ||'SEAL_TP:' || CHR(10) ||'SEAL_NO:' || CHR(10) ||'}SEAL_INFO')" ).append("\n"); 
		query.append("       ELSE  TO_CLOB(BKG_JOIN_CLOB_FNC(CURSOR((SELECT '{SEAL_INFO'                             || CHR(10)" ).append("\n"); 
		query.append("                                                     ||'SEAL_TP:'|| BCSN.SEAL_PTY_TP_CD  || CHR(10)" ).append("\n"); 
		query.append("                                                     ||'SEAL_NO:'|| BCSN.CNTR_SEAL_NO     || CHR(10)" ).append("\n"); 
		query.append("                                                     ||'}SEAL_INFO' " ).append("\n"); 
		query.append("                                               FROM  BKG_CNTR_SEAL_NO BCSN" ).append("\n"); 
		query.append("                                  WHERE BCSN.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                                  AND   BCSN.CNTR_NO = BC.CNTR_NO)), CHR(10))) " ).append("\n"); 
		query.append("       END || CHR(10)" ).append("\n"); 
		query.append("    ||'{MEAS_INFO'                             || CHR(10)" ).append("\n"); 
		query.append("    ||'MEAS_TP:'    || 'V'                     || CHR(10)" ).append("\n"); 
		query.append("    ||'MEAS_UT:'    || BC.VGM_WGT_UT_CD        || CHR(10)" ).append("\n"); 
		query.append("    ||'MEAS:'       || BC.VGM_WGT              || CHR(10)" ).append("\n"); 
		query.append("    ||'MEAS_DT:'    || TO_CHAR(BC.VGM_WGT_UPD_DT,'YYYYMMDDHH24MI')        || CHR(10)" ).append("\n"); 
		query.append("    ||'}MEAS_INFO'                             || CHR(10)" ).append("\n"); 
		query.append("    ||'{TRSP_INFO'                             || CHR(10)" ).append("\n"); 
		query.append("    ||'VSL_CONSORT_VOY:'|| (SELECT VSK_COMMON_PKG.GET_CSSM_VOY_NO_FNC(VVDT.VSL_CD,VVDT.SKD_VOY_NO,VVDT.SKD_DIR_CD,VVDT.POL_CD,'O') " ).append("\n"); 
		query.append("                                       FROM BKG_VVD VVDT WHERE VVDT.BKG_NO = BB.BKG_NO AND VVDT.VSL_PRE_PST_CD = 'T' AND ROWNUM = 1 )|| CHR(10)" ).append("\n"); 
		query.append("    ||'VSL_NM:'     || (SELECT MVC.VSL_ENG_NM FROM MDM_VSL_CNTR MVC WHERE BB.VSL_CD = MVC.VSL_CD AND ROWNUM = 1)  || CHR(10)" ).append("\n"); 
		query.append("    ||'}TRSP_INFO'                             || CHR(10)" ).append("\n"); 
		query.append("    ||'{DOC_INFO'                              || CHR(10)" ).append("\n"); 
		query.append("    ||'DOC_TP:'     || CASE WHEN BXC.XTER_SNDR_ID IS NOT NULL THEN NVL(BXC.VGM_DOC_TP_CD,'SM1')" ).append("\n"); 
		query.append("                            WHEN BXVC.XTER_SNDR_ID IS NOT NULL THEN NVL((SELECT BXVC1.VGM_DOC_TP_CD " ).append("\n"); 
		query.append("                                                                        FROM BKG_XTER_VGM_CUST BXVC1 " ).append("\n"); 
		query.append("                                                                        WHERE BXVC1.XTER_SNDR_ID = BXVC1.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                                                        AND BXVC1.XTER_VGM_DOC_ID = BXVC1.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                                                        AND BXVC1.XTER_VGM_RQST_SEQ = BXVC1.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                                                        AND BXVC1.VGM_DOC_TP_CD IN ('SM1','SM2')" ).append("\n"); 
		query.append("                                                                        AND ROWNUM = 1),'SM1')" ).append("\n"); 
		query.append("                            WHEN ECOM.BKG_NO IS NOT NULL THEN NVL(ECOM.VGM_DOC_TP_CD,'SM1')" ).append("\n"); 
		query.append("                            ELSE 'SM1' END        || CHR(10)" ).append("\n"); 
		query.append("    ||'DOC_ID:'     || CASE WHEN BXC.XTER_SNDR_ID IS NOT NULL THEN BXC.VGM_DOC_ID_NO" ).append("\n"); 
		query.append("                            WHEN BXVC.XTER_SNDR_ID IS NOT NULL THEN BXVC.VGM_DOC_ID" ).append("\n"); 
		query.append("                            ELSE '' END        || CHR(10)" ).append("\n"); 
		query.append("    ||'{DOC_DATE_INFO'                         || CHR(10)" ).append("\n"); 
		query.append("    ||'DATE_TP:'    || 'WAT'                   || CHR(10)" ).append("\n"); 
		query.append("    ||'DATE:'       || TO_CHAR(BC.VGM_WGT_UPD_DT,'YYYYMMDDHH24MI')        || CHR(10)" ).append("\n"); 
		query.append("    ||'}DOC_DATE_INFO'  || CHR(10)" ).append("\n"); 
		query.append("    || CASE WHEN BXC.XTER_SNDR_ID IS NOT NULL THEN " ).append("\n"); 
		query.append("                    TO_CLOB('{CUST_INFO'     || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_TP:'    || 'AM' ||CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CD_TP:' ||  CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CD:'    || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_NM1:'   || CHR(10) ||'CUST_NM2:' || CHR(10) ||'CUST_NM3:' || CHR(10) ||'CUST_NM4:' || CHR(10) ||'CUST_NM5:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_ADDR1:' || CHR(10) ||'CUST_ADDR2:' || CHR(10) ||'CUST_ADDR3:' || CHR(10) ||'CUST_ADDR4:' || CHR(10) ||'CUST_ADDR5:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CTY_NM:' || CHR(10) ||'CUST_STE:' || CHR(10) ||'CUST_PST_CD:' || CHR(10) ||'CUST_CNT_CD:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CNTC_TP:' || BXC.VGM_CUST_CNTC_TP_CD || CHR(10)" ).append("\n"); 
		query.append("                             ||'CUST_CNTC_NM:' || BXC.VGM_CUST_CNTC_NM || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_FAX:' || BXC.VGM_CUST_FAX_NO || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_EML:' || BXC.VGM_CUST_EML || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_PHN:' || BXC.VGM_CUST_PHN_NO || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_ML_ADDR:' || BXC.VGM_CUST_ADDR || CHR(10)" ).append("\n"); 
		query.append("                             ||'}CUST_INFO')" ).append("\n"); 
		query.append("            WHEN ECOM.BKG_NO IS NOT NULL THEN" ).append("\n"); 
		query.append("                    TO_CLOB('{CUST_INFO'     || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_TP:'    || 'AM'|| CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CD_TP:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CD:'    || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_NM1:'   || CHR(10) ||'CUST_NM2:' || CHR(10) ||'CUST_NM3:' || CHR(10) ||'CUST_NM4:' || CHR(10) ||'CUST_NM5:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_ADDR1:' || CHR(10) ||'CUST_ADDR2:' || CHR(10) ||'CUST_ADDR3:' || CHR(10) ||'CUST_ADDR4:' || CHR(10) ||'CUST_ADDR5:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CTY_NM:' || CHR(10) ||'CUST_STE:' || CHR(10) ||'CUST_PST_CD:' || CHR(10) ||'CUST_CNT_CD:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_CNTC_TP:' || DECODE(ECOM.ESIG_CO_NM,NULL,'','RP') || CHR(10)" ).append("\n"); 
		query.append("                             ||'CUST_CNTC_NM:' || ECOM.ESIG_CO_NM || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_FAX:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_EML:' || ECOM.CUST_EML || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_PHN:' || CHR(10) " ).append("\n"); 
		query.append("                             ||'CUST_ML_ADDR:' || CHR(10)" ).append("\n"); 
		query.append("                             ||'}CUST_INFO')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            WHEN BXVC.XTER_SNDR_ID IS NOT NULL THEN" ).append("\n"); 
		query.append("            TO_CLOB(BKG_JOIN_CLOB_FNC(CURSOR((SELECT '{CUST_INFO'                                      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_TP:'        || NVL(BXVC1.VGM_CUST_TP_CD, 'AM')       || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_CD_TP:'     || BXVC1.VGM_CUST_CD_TP_CTNT  || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_CD:'        || BXVC1.VGM_CUST_CD_CTNT     || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_NM1:'       || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_NM,1, ''), '*', '-'), ':', '-')          || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_NM2:'       || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_NM,2, ''), '*', '-'), ':', '-')          || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_NM3:'       || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_NM,3, ''), '*', '-'), ':', '-')          || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_NM4:'       || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_NM,4, ''), '*', '-'), ':', '-')          || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_NM5:'       || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_NM,5, ''), '*', '-'), ':', '-')          || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_ADDR1:'     || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_ADDR,1, ''), '*', '-'), ':', '-')        || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_ADDR2:'     || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_ADDR,2, ''), '*', '-'), ':', '-')        || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_ADDR3:'     || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_ADDR,3, ''), '*', '-'), ':', '-')        || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_ADDR4:'     || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_ADDR,4, ''), '*', '-'), ':', '-')        || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_ADDR5:'     || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(BXVC1.VGM_CUST_ADDR,5, ''), '*', '-'), ':', '-')        || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_CTY_NM:'    || BXVC1.VGM_CUST_CTY_NM      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_STE:'       || BXVC1.VGM_CUST_STE_NM      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_PST_CD:'    || BXVC1.VGM_PST_CD_CTNT      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_CNT_CD:'    || BXVC1.VGM_CUST_CNT_CD      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_CNTC_TP:'   || BXVC1.VGM_CUST_CNTC_TP_CD  || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_CNTC_NM:'   || BXVC1.VGM_CUST_CNTC_NM     || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_FAX:'       || BXVC1.VGM_CUST_FAX_NO      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_EML:'       || BXVC1.VGM_CUST_EML         || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_PHN:'       || BXVC1.VGM_CUST_PHN_NO      || CHR(10)" ).append("\n"); 
		query.append("                                                ||'CUST_ML_ADDR:'   || BXVC1.VGM_CUST_PST_ADDR    || CHR(10)" ).append("\n"); 
		query.append("                                                ||'}CUST_INFO'  " ).append("\n"); 
		query.append("                                         FROM  BKG_XTER_VGM_CUST BXVC1" ).append("\n"); 
		query.append("                                         WHERE BXVC1.XTER_SNDR_ID = BXVR.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                         AND   BXVC1.XTER_VGM_DOC_ID = BXVR.XTER_VGM_DOC_ID" ).append("\n"); 
		query.append("                                         AND   BXVC1.XTER_VGM_RQST_SEQ = BXVR.XTER_VGM_RQST_SEQ" ).append("\n"); 
		query.append("                                         AND   BXVC1.CNTR_NO = BXVR.CNTR_NO)), CHR(10))) " ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("                  TO_CLOB('{CUST_INFO'|| CHR(10) ||'CUST_TP:' || CHR(10) ||'CUST_CD_TP:' || CHR(10) ||'CUST_CD:' || CHR(10) " ).append("\n"); 
		query.append("                         ||'CUST_NM1:' || CHR(10) ||'CUST_NM2:' || CHR(10) ||'CUST_NM3:' || CHR(10) ||'CUST_NM4:' || CHR(10) ||'CUST_NM5:' || CHR(10) " ).append("\n"); 
		query.append("                         ||'CUST_ADDR1:' || CHR(10) ||'CUST_ADDR2:' || CHR(10) ||'CUST_ADDR3:' || CHR(10) ||'CUST_ADDR4:' || CHR(10) ||'CUST_ADDR5:' || CHR(10) " ).append("\n"); 
		query.append("                         ||'CUST_CTY_NM:' || CHR(10) ||'CUST_STE:' || CHR(10) ||'CUST_PST_CD:' || CHR(10) ||'CUST_CNT_CD:' || CHR(10) ||'CUST_CNTC_TP:' || CHR(10)" ).append("\n"); 
		query.append("                         ||'CUST_CNTC_NM:' || CHR(10) ||'CUST_FAX:' || CHR(10) ||'CUST_EML:' || CHR(10) ||'CUST_PHN:' || CHR(10) ||'CUST_ML_ADDR:' || CHR(10)" ).append("\n"); 
		query.append("                         ||'}CUST_INFO')" ).append("\n"); 
		query.append("      END || CHR(10)" ).append("\n"); 
		query.append("    ||'}DOC_INFO'                    || CHR(10)" ).append("\n"); 
		query.append("    ||'}CNTR_INFO'" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB                     " ).append("\n"); 
		query.append("     ,BKG_CONTAINER BC                   " ).append("\n"); 
		query.append("     ,BKG_XTER_VGM_RQST BXVR" ).append("\n"); 
		query.append("     ,BKG_XTER_VGM_CUST BXVC" ).append("\n"); 
		query.append("     ,BKG_XTER_VGM ECOM" ).append("\n"); 
		query.append("     ,BKG_XTER_CNTR BXC" ).append("\n"); 
		query.append("WHERE   BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BB.BKG_NO = BC.BKG_NO                   " ).append("\n"); 
		query.append("AND   BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   BC.CNTR_NO = BXVR.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   BC.XTER_SNDR_ID = BXVR.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND   BC.XTER_VGM_DOC_ID = BXVR.XTER_VGM_DOC_ID(+)" ).append("\n"); 
		query.append("AND   BC.XTER_VGM_RQST_SEQ = BXVR.XTER_VGM_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND   BXVR.XTER_SNDR_ID = BXVC.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND   BXVR.XTER_VGM_DOC_ID = BXVC.XTER_VGM_DOC_ID(+)" ).append("\n"); 
		query.append("AND   BXVR.XTER_VGM_RQST_SEQ = BXVC.XTER_VGM_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND   BXVR.CNTR_NO = BXVC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   BXVC.XTER_REF_SEQ(+) = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   BC.BKG_NO = ECOM.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BC.CNTR_NO = ECOM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   BC.XTER_VGM_DOC_ID = ECOM.BKG_NO(+)" ).append("\n"); 
		query.append("AND   BC.XTER_VGM_RQST_SEQ = ECOM.VGM_SEQ(+)" ).append("\n"); 
		query.append("AND   BC.XTER_VGM_USR_ID = ECOM.USR_ID(+)" ).append("\n"); 
		query.append("AND   DECODE(BC.XTER_SNDR_ID,'WEB',BC.BKG_NO,'') = ECOM.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   ECOM.XTER_SNDR_ID = BXC.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND   ECOM.XTER_RQST_NO = BXC.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND   ECOM.XTER_RQST_SEQ = BXC.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND   ECOM.CNTR_NO = BXC.CNTR_NO(+)" ).append("\n"); 

	}
}