/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAppointRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.25 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAppointRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {APPOINTMENT
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAppointRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvAppointRSQL").append("\n"); 
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
		query.append("SELECT '' APPT_REF" ).append("\n"); 
		query.append("      ,SUBSTR(D.DOR_ADDR, 1, 50) AS APPT_NM" ).append("\n"); 
		query.append("      ,SUBSTR(D.DOR_ADDR, 51, 50) APPT_ADD1" ).append("\n"); 
		query.append("      ,SUBSTR(D.DOR_ADDR, 101, 50) APPT_ADD2" ).append("\n"); 
		query.append("      ,SUBSTR(D.DOR_ADDR, 151, 50) APPT_ADD3" ).append("\n"); 
		query.append("      ,'' AS APPT_ADD4" ).append("\n"); 
		query.append("      ,B.LOC_LOCL_LANG_NM AS APPT_CITY" ).append("\n"); 
		query.append("      ,NVL(C.STE_NM, LTRIM(REGEXP_SUBSTR(B.LOC_NM, '+[^,]+', 1, 2))) AS APPT_SATE" ).append("\n"); 
		query.append("      ,SUBSTR(D.LOC_CD, 1, 2) AS APPT_CNT" ).append("\n"); 
		query.append("      ,DECODE(D.TRO_SUB_SEQ, SO.TRO_SUB_SEQ, SO.DOR_PST_CD, D.DOR_ZIP_ID) AS APPT_POSTAL" ).append("\n"); 
		query.append("      ,'' AS APPT_TZ" ).append("\n"); 
		query.append("      ,DECODE(D.TRO_SUB_SEQ, SO.TRO_SUB_SEQ, SO.CNTC_PSON_NM, D.CNTC_PSON_NM) AS APPT_CONTACT_NM" ).append("\n"); 
		query.append("      ,DECODE(D.TRO_SUB_SEQ, SO.TRO_SUB_SEQ, SO.CNTC_PSON_PHN_NO, D.CNTC_PHN_NO) AS APPT_CONTACT_TE" ).append("\n"); 
		query.append("      ,'' AS APPT_COMMENT" ).append("\n"); 
		query.append("      ,NVL(TRIM(D.LOD_REF_NO), '') AS LOAD_REF" ).append("\n"); 
		query.append("      ,TRIM(REPLACE(REPLACE(SO.SPCL_INSTR_RMK, CHR(13), ''), CHR(10), '')) AS SPCL_INSTR" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(NVL(SO.MLT_STOP_DE_FLG, 'N'), 'Y', D.ARR_DT, TMP.DOR_NOD_PLN_DT), 'YYYYMMDDHH24MISS') AS APPT_PLN_DT" ).append("\n"); 
		query.append("      ,'' AS APPT_ACTL_INDT" ).append("\n"); 
		query.append("      ,'' AS APPT_ACTL_OUTDT" ).append("\n"); 
		query.append("      ,DECODE (SO.DOR_SVC_TP_CD,'UD', 'Undecided','LL', 'Live Load','LU', 'Live Unload','ST', 'Street Turn','DP', 'Drop and Pick', 'Delivery') AS APPT_TYPE" ).append("\n"); 
		query.append("  FROM TRS_TRSP_WRK_ORD_PRV_TMP TMP" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("      ,BKG_EUR_TRO_DTL  D" ).append("\n"); 
		query.append("      ,MDM_LOCATION     B" ).append("\n"); 
		query.append("      ,MDM_STATE        C" ).append("\n"); 
		query.append(" WHERE TMP.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("   AND TMP.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND TMP.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND TMP.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND SO.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("   AND SO.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND SO.TRSP_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("   AND SO.TRO_SEQ = D.TRO_SEQ" ).append("\n"); 
		query.append("   AND D.LOC_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("   AND B.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.STE_CD = C.STE_CD(+)" ).append("\n"); 
		query.append(" ORDER BY D.TRO_SUB_SEQ" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("  ON 1 = 1" ).append("\n"); 

	}
}