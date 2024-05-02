/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchWpmDescForBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchWpmDescForBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL body에 찍힐 WPM관련 문구를 생성한다.
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchWpmDescForBlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchWpmDescForBlRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN N_RMK IS NOT NULL AND Y_RMK IS NOT NULL THEN CHR(13)||CHR(10) || N_RMK || CHR(13)||CHR(10) || Y_RMK" ).append("\n"); 
		query.append("            WHEN N_RMK IS NOT NULL THEN CHR(13)||CHR(10) || N_RMK " ).append("\n"); 
		query.append("            WHEN Y_RMK IS NOT NULL THEN CHR(13)||CHR(10) || Y_RMK " ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("            END AS RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT (SELECT SUM(PCK_QTY) || ' WOODEN PACKAGE MATERIAL :' || CHR(13)||CHR(10) || UPPER((SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                                                                    FROM COM_INTG_CD_DTL DTL " ).append("\n"); 
		query.append("                                                                   WHERE DTL.INTG_CD_ID = 'CD03478' " ).append("\n"); 
		query.append("                                                                     AND DTL.INTG_CD_VAL_CTNT = WPM_TRT_CD))" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("                  FROM BKG_CNTR_MF_DESC_HIS " ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  FROM BKG_CNTR_MF_DESC " ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND WPM_TRT_CD = 'N'" ).append("\n"); 
		query.append("                GROUP BY WPM_TRT_CD) N_RMK" ).append("\n"); 
		query.append("              ,(SELECT SUM(PCK_QTY) ||' WOODEN PACKAGE MATERIAL :' || CHR(13)||CHR(10) || UPPER((SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("                                                                   FROM COM_INTG_CD_DTL DTL " ).append("\n"); 
		query.append("                                                                  WHERE DTL.INTG_CD_ID = 'CD03478' " ).append("\n"); 
		query.append("                                                                    AND DTL.INTG_CD_VAL_CTNT = WPM_TRT_CD)) " ).append("\n"); 
		query.append(" #if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("                  FROM BKG_CNTR_MF_DESC_HIS " ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  FROM BKG_CNTR_MF_DESC " ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND WPM_TRT_CD = 'Y'" ).append("\n"); 
		query.append("                GROUP BY WPM_TRT_CD) Y_RMK" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}