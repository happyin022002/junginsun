/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOgetPickUpFirmsCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOgetPickUpFirmsCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getPickUpFirmsCode
	  * </pre>
	  */
	public Edi315SendDBDAOgetPickUpFirmsCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOgetPickUpFirmsCodeRSQL").append("\n"); 
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
		query.append("SELECT YD2.YD_CSTMS_NO AS PKUP_FIRMS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT DECODE( ANTC.VSL_INFO_SET_FLG --- VSL_INFO_SET_FLG에 영향받는 7항목(처리)" ).append("\n"); 
		query.append("          , 'Y', ANTC.PKUP_YD_CD , NVL(DECODE( BKGM.POD_CD , 'BEANR', AHDG.ATTR_CTNT3 , 'NLRTM', RCNV.ATTR_CTNT2 , NULL ) , NVL(SUBSTR(BKGM.COP_VAL, 15), VSK_ETA_YD_CD) ) ) AS PKUP_YD_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT BKGM.BKG_NO AS BKG_NO ," ).append("\n"); 
		query.append("          BKGM.POD_CD ," ).append("\n"); 
		query.append("          BKGM.VSL_CD ," ).append("\n"); 
		query.append("          BKGM.SKD_VOY_NO ," ).append("\n"); 
		query.append("          BKGM.SKD_DIR_CD ," ).append("\n"); 
		query.append("          VSKD.YD_CD AS VSK_ETA_YD_CD ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT SUBSTR( MAX ( DECODE(COPD.ACT_CD, 'FITRDO', '1', '0') || NVL(TO_CHAR(COPD.PLN_DT, 'YYYYMMDDHH24MISS'), '00000000000000') || NVL(TO_CHAR(NVL(COPD.ACT_DT, COPD.ESTM_DT), 'YYYYMMDDHH24MISS'), '00000000000000') || COPD.NOD_CD ) , 16) COP_VAL" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR COPM ," ).append("\n"); 
		query.append("              SCE_COP_DTL COPD" ).append("\n"); 
		query.append("            WHERE SUBSTR(BKGM.DEL_CD, 1, 2) = 'US'" ).append("\n"); 
		query.append("              AND COPM.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("              AND COPD.COP_NO = COPM.COP_NO" ).append("\n"); 
		query.append("              AND COPM.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("              AND COPD.ACT_CD IN ('FITRDO'," ).append("\n"); 
		query.append("                  'FUVMAD') -- FITRDO우선 처리" ).append("\n"); 
		query.append("              ) AS COP_VAL" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKGM ," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD VSKD ," ).append("\n"); 
		query.append("          BKG_VVD BVVD" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND BKGM.BL_NO = @[bkg_no] -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("          AND BVVD.VSL_CD = VSKD.VSL_CD(+) -- Duration이 아닌경우에는 데이터를 추출하기 위하여 해당과 같이 처리한다. (20100106 Park Mangeon)" ).append("\n"); 
		query.append("          AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND BVVD.POD_CD = VSKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("          AND BKGM.BKG_NO =BVVD.BKG_NO" ).append("\n"); 
		query.append("          AND BKGM.POD_CD = BVVD.POD_CD ) BKGM LEFT OUTER JOIN BKG_ARR_NTC ANTC ON (ANTC.BKG_NO = BKGM.BKG_NO) LEFT OUTER JOIN BKG_CSTMS_ANR_VVD AVVD -- ANRBS" ).append("\n"); 
		query.append("      ON ( AVVD.VSL_CD = BKGM.VSL_CD" ).append("\n"); 
		query.append("          AND AVVD.SKD_VOY_NO = BKGM.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND AVVD.SKD_DIR_CD = BKGM.SKD_DIR_CD ) LEFT OUTER JOIN BKG_HRD_CDG_CTNT AHDG -- ANRSU SUB CODE" ).append("\n"); 
		query.append("      ON ( AHDG.HRD_CDG_ID = 'ANR_CSTMS_BRTH_CD'" ).append("\n"); 
		query.append("          AND AHDG.ATTR_CTNT2 = AVVD.BRTH_DESC ) LEFT OUTER JOIN BKG_CSTMS_RTM_VSL RVVD -- NLRTM   " ).append("\n"); 
		query.append("      ON ( RVVD.VSL_CD = BKGM.VSL_CD" ).append("\n"); 
		query.append("          AND RVVD.SKD_VOY_NO = BKGM.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND RVVD.SKD_DIR_CD = BKGM.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND RVVD.VSL_CALL_REF_STS_CD <> 'C' ) LEFT OUTER JOIN BKG_CSTMS_CD_CONV_CTNT RCNV -- NLRTM SUB " ).append("\n"); 
		query.append("      ON ( RCNV.CNT_CD = 'NL'" ).append("\n"); 
		query.append("          AND RCNV.CSTMS_DIV_ID = 'BERTH_CD'" ).append("\n"); 
		query.append("          AND RCNV.ATTR_CTNT1 = RVVD.BRTH_CTNT) ) INQS ," ).append("\n"); 
		query.append("  MDM_YARD YD2 -- P/Up FIRMS " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND YD2.YD_CD(+) = INQS.PKUP_YD_CD" ).append("\n"); 

	}
}