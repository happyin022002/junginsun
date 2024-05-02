/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOSearchExportInfoDNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchExportInfoDNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DownLoad시 Export Lic No를 구한다.
	  * </pre>
	  */
	public KorManifestListDBDAOSearchExportInfoDNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchExportInfoDNRSQL").append("\n"); 
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
		query.append("      NVL(REPLACE(XPT_LIC_NO,'-',''),TS_REF_NO) E_BME_ELNO" ).append("\n"); 
		query.append("     , DECODE(DIVD_FLG,'1',NVL(DIVD_PCK_QTY,0),NVL(PCK_QTY,0)) E_BME_PKG_QTY" ).append("\n"); 
		query.append("     , DECODE(DIVD_FLG,'1',NVL(DIVD_PCK_TP_CD,' '),NVL(PCK_TP_CD,' ')) E_BME_PKG_TP" ).append("\n"); 
		query.append("     , DECODE(DIVD_FLG,'1',TRUNC(DECODE(NVL(DIVD_WGT_UT_CD,'  '),'LBS',ROUND(NVL(DIVD_WGT,0)*0.4536,3), NVL(DIVD_WGT,0)),2),TRUNC(DECODE(NVL(WGT_UT_CD,'  '),'LBS',ROUND(NVL(MF_WGT,0)*0.4536,3), NVL(MF_WGT,0)),2)) E_BME_WGT_QTY" ).append("\n"); 
		query.append("     , DECODE(DIVD_FLG,'1',DECODE(NVL(DIVD_WGT_UT_CD,' '),'LBS','KGS',NVL(DIVD_WGT_UT_CD,' ')),DECODE(NVL(WGT_UT_CD,' '),'LBS','KGS',NVL(WGT_UT_CD,' '))) E_BME_WGT_TP" ).append("\n"); 
		query.append("     , DECODE(TRIM(DIVD_SEQ), NULL, 'N', 'Y') E_BME_DIV_IND" ).append("\n"); 
		query.append("     , NVL(TRIM(DIVD_SEQ),'0') E_BME_DIV_SEQ" ).append("\n"); 
		query.append("     , NVL(SAM_PCK_QTY,0) E_BME_DPKG_QTY" ).append("\n"); 
		query.append("     , NVL(SAM_PCK_TP_CD,' ') E_BME_DPKG_TP" ).append("\n"); 
		query.append("     , NVL(DIVD_WGT,0) E_BME_DWGT_QTY" ).append("\n"); 
		query.append("     , NVL(DIVD_WGT_UT_CD,' ') E_BME_DWGT_TP" ).append("\n"); 
		query.append("     , NVL(SAM_PCK_ID,' ') E_BME_SMP_SEQ" ).append("\n"); 
		query.append("  FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[a_bkg_no]" ).append("\n"); 
		query.append("   AND IO_BND_CD	= 'O'" ).append("\n"); 
		query.append("   AND CNT_CD 		= 'KR'" ).append("\n"); 
		query.append("ORDER BY NVL(REPLACE(XPT_LIC_NO,'-',''),TS_REF_NO)" ).append("\n"); 

	}
}