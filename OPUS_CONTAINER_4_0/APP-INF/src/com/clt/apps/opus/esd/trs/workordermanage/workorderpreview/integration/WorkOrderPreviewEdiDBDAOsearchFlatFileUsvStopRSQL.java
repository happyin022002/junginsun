/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvStopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvStopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STOP
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvStopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvStopRSQL").append("\n"); 
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
		query.append("SELECT T1.* " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  WITH US_TZ AS" ).append("\n"); 
		query.append("   (SELECT DECODE(LEVEL, 1, '-300', 2, '-360', 3, '-420', 4, '-480', 5, '-540', 6, '-540') VAL" ).append("\n"); 
		query.append("          ,DECODE(LEVEL, 1, 'EDT', 2, 'CDT', 3, 'MDT', 4, 'PDT', 5, 'AKDT', 6, 'HST') NM" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append("    CONNECT BY LEVEL < 7)," ).append("\n"); 
		query.append("  CA_TZ AS" ).append("\n"); 
		query.append("   (SELECT DECODE(LEVEL, 1, '-210', 2, '-240', 3, '-300', 4, '-360', 5, '-420', 6, '-480') VAL" ).append("\n"); 
		query.append("          ,DECODE(LEVEL, 1, 'NDT', 2, 'ADT', 3, 'EDT', 4, 'CDT', 5, 'MDT', 6, 'PDT') NM" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append("    CONNECT BY LEVEL < 7)" ).append("\n"); 
		query.append("  SELECT 'Pickup' AS STOP_TP" ).append("\n"); 
		query.append("        ,Y.YD_NM  AS STOP_NM" ).append("\n"); 
		query.append("        ,'1' AS STOP_NO" ).append("\n"); 
		query.append("        ,SO.FM_NOD_CD STOP_LOC" ).append("\n"); 
		query.append("        ,'' STOP_REF" ).append("\n"); 
		query.append("        ,SUBSTR(Y.YD_LOCL_LANG_ADDR, 0, DECODE(SIGN(INSTR(Y.YD_LOCL_LANG_ADDR, ',')), 1, INSTR(Y.YD_LOCL_LANG_ADDR, ',') - 1, LENGTH(Y.YD_LOCL_LANG_ADDR))) STOP_ADD1" ).append("\n"); 
		query.append("        ,SUBSTR(Y.YD_LOCL_LANG_ADDR, DECODE(SIGN(INSTR(Y.YD_LOCL_LANG_ADDR, ',')), 1, INSTR(Y.YD_LOCL_LANG_ADDR, ',') + 1, 0)) STOP_ADD2" ).append("\n"); 
		query.append("        ,Y.YD_LOC_CTY_NM STOP_CITY" ).append("\n"); 
		query.append("        ,T.STE_NM STOP_STATE" ).append("\n"); 
		query.append("        ,SUBSTR(SO.FM_NOD_CD, 1, 2) STOP_CNT" ).append("\n"); 
		query.append("        ,Y.ZIP_CD STOP_POSTAL" ).append("\n"); 
		query.append("        ,DECODE(L.CNT_CD, 'US', US_TZ.NM, 'CA', CA_TZ.NM) STOP_TZ" ).append("\n"); 
		query.append("        ,'' STOP_CONTACT_NM" ).append("\n"); 
		query.append("        ,'' STOP_CONTACT_TE" ).append("\n"); 
		query.append("        ,'' STOP_COMMENT" ).append("\n"); 
		query.append("        ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("        ,MDM_YARD         Y" ).append("\n"); 
		query.append("        ,MDM_LOCATION     L" ).append("\n"); 
		query.append("        ,MDM_STATE     T" ).append("\n"); 
		query.append("        ,US_TZ" ).append("\n"); 
		query.append("        ,CA_TZ" ).append("\n"); 
		query.append("   WHERE SO.FM_NOD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("     AND NVL(SO.FM_NOD_CD, 'X') != 'X'" ).append("\n"); 
		query.append("     AND NVL(SO.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("     AND SUBSTR(SO.FM_NOD_CD, 1, 5) = L.LOC_CD(+)" ).append("\n"); 
		query.append("     AND L.CNT_CD = T.CNT_CD(+)" ).append("\n"); 
		query.append("     AND L.STE_CD = T.STE_CD(+)" ).append("\n"); 
		query.append("     AND L.GMT_HRS = US_TZ.VAL(+)" ).append("\n"); 
		query.append("     AND L.GMT_HRS = CA_TZ.VAL(+)" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT DECODE(SO.DOR_SVC_TP_CD, 'DP', 'Drop and Pick', 'Delivery') AS STOP_TP" ).append("\n"); 
		query.append("        ,NVL(SO.FCTRY_NM, 'Call NYK for delivery information') AS STOP_NM" ).append("\n"); 
		query.append("        ,'2' AS STOP_NO" ).append("\n"); 
		query.append("        ,'' STOP_LOC" ).append("\n"); 
		query.append("        ,'' STOP_REF" ).append("\n"); 
		query.append("        ,SO.DOR_DE_ADDR STOP_ADD1" ).append("\n"); 
		query.append("        ,'' STOP_ADD2" ).append("\n"); 
		query.append("        ,REGEXP_SUBSTR(L.LOC_NM, '+[^,]+', 1, 1) STOP_CITY" ).append("\n"); 
		query.append("        ,T.STE_NM STOP_STATE" ).append("\n"); 
		query.append("        ,SUBSTR(SO.DOR_NOD_CD, 1, 2) STOP_CNT" ).append("\n"); 
		query.append("        ,SO.DOR_PST_CD STOP_POSTAL" ).append("\n"); 
		query.append("        ,DECODE(L.CNT_CD, 'US', US_TZ.NM, 'CA', CA_TZ.NM) STOP_TZ" ).append("\n"); 
		query.append("        ,SO.CNTC_PSON_NM STOP_CONTACT_NM" ).append("\n"); 
		query.append("        ,SO.CNTC_PSON_PHN_NO STOP_CONTACT_TE" ).append("\n"); 
		query.append("	    ,(CASE WHEN SO.DOR_SVC_TP_CD <> 'DP' THEN" ).append("\n"); 
		query.append("					   (SELECT MAX(DECODE(IBD.IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("										 ,'62'" ).append("\n"); 
		query.append("										 ,'TE' || ' ' || '-' || ' ' || IBD.IBD_TRSP_NO || ' '" ).append("\n"); 
		query.append("										 ,''))" ).append("\n"); 
		query.append("						 FROM BKG_CSTMS_ADV_BL A, BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("						WHERE A.CNT_CD = L.CNT_CD" ).append("\n"); 
		query.append("						  AND A.CNT_CD = IBD.CNT_CD(+)" ).append("\n"); 
		query.append("						  AND A.BL_NO  = IBD.BL_NO(+)" ).append("\n"); 
		query.append("						  AND A.BL_NO  = SO.BL_NO" ).append("\n"); 
		query.append("						  AND A.DEL_CD = SUBSTR(SO.DOR_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("	     END) || TRIM(SO.SPCL_INSTR_RMK)  AS STOP_COMMENT" ).append("\n"); 
		query.append("        ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("        ,MDM_LOCATION     L" ).append("\n"); 
		query.append("        ,MDM_STATE     T" ).append("\n"); 
		query.append("        ,US_TZ" ).append("\n"); 
		query.append("        ,CA_TZ" ).append("\n"); 
		query.append("   WHERE NVL(SO.DOR_NOD_CD, 'X') != 'X'" ).append("\n"); 
		query.append("     AND SUBSTR(SO.DOR_NOD_CD, 1, 5) = L.LOC_CD(+)" ).append("\n"); 
		query.append("     AND NVL(SO.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]  " ).append("\n"); 
		query.append("     AND L.CNT_CD = T.CNT_CD(+)" ).append("\n"); 
		query.append("     AND L.STE_CD = T.STE_CD(+)" ).append("\n"); 
		query.append("     AND L.GMT_HRS = US_TZ.VAL(+)" ).append("\n"); 
		query.append("     AND L.GMT_HRS = CA_TZ.VAL(+)" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT DECODE(SO.TRSP_SO_TP_CD, 'M', 'Delivery', 'Return')  STOP_TP" ).append("\n"); 
		query.append("        ,Y.YD_NM AS STOP_NM" ).append("\n"); 
		query.append("        ,DECODE(NVL(SO.DOR_NOD_CD, 'X'),'X','2','3') AS STOP_NO" ).append("\n"); 
		query.append("        ,SO.TO_NOD_CD STOP_LOC" ).append("\n"); 
		query.append("        ,'' STOP_REF" ).append("\n"); 
		query.append("        ,SUBSTR(Y.YD_LOCL_LANG_ADDR, 0, DECODE(SIGN(INSTR(Y.YD_LOCL_LANG_ADDR, ',')), 1, INSTR(Y.YD_LOCL_LANG_ADDR, ',') - 1, LENGTH(Y.YD_LOCL_LANG_ADDR))) STOP_ADD1" ).append("\n"); 
		query.append("        ,SUBSTR(Y.YD_LOCL_LANG_ADDR, DECODE(SIGN(INSTR(Y.YD_LOCL_LANG_ADDR, ',')), 1, INSTR(Y.YD_LOCL_LANG_ADDR, ',') + 1, 0)) STOP_ADD2" ).append("\n"); 
		query.append("        ,Y.YD_LOC_CTY_NM STOP_CITY" ).append("\n"); 
		query.append("        ,T.STE_NM STOP_STATE" ).append("\n"); 
		query.append("        ,SUBSTR(SO.TO_NOD_CD, 1, 2) STOP_CNT" ).append("\n"); 
		query.append("        ,Y.ZIP_CD STOP_POSTAL" ).append("\n"); 
		query.append("        ,DECODE(L.CNT_CD, 'US', US_TZ.NM, 'CA', CA_TZ.NM) STOP_TZ" ).append("\n"); 
		query.append("        ,'' STOP_CONTACT_NM" ).append("\n"); 
		query.append("        ,'' STOP_CONTACT_TE" ).append("\n"); 
		query.append("	    ,'' STOP_COMMENT" ).append("\n"); 
		query.append("        ,TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("        ,MDM_YARD         Y" ).append("\n"); 
		query.append("        ,MDM_LOCATION     L" ).append("\n"); 
		query.append("        ,MDM_STATE     	  T" ).append("\n"); 
		query.append("        ,US_TZ" ).append("\n"); 
		query.append("        ,CA_TZ" ).append("\n"); 
		query.append("   WHERE SO.TO_NOD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("     AND NVL(SO.TO_NOD_CD, 'X') != 'X'" ).append("\n"); 
		query.append("     AND NVL(SO.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]   " ).append("\n"); 
		query.append("     AND SUBSTR(SO.TO_NOD_CD, 1, 5) = L.LOC_CD(+)" ).append("\n"); 
		query.append("     AND L.CNT_CD = T.CNT_CD(+)" ).append("\n"); 
		query.append("     AND L.STE_CD = T.STE_CD(+)" ).append("\n"); 
		query.append("     AND L.GMT_HRS = US_TZ.VAL(+)" ).append("\n"); 
		query.append("     AND L.GMT_HRS = CA_TZ.VAL(+)" ).append("\n"); 
		query.append("   ORDER BY STOP_NO" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("  ON 1 = 1" ).append("\n"); 

	}
}