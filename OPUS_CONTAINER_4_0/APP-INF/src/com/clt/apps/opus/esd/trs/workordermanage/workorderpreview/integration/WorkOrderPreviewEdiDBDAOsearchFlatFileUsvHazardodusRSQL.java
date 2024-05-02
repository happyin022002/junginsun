/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvHazardodusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvHazardodusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hazardodus
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvHazardodusRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvHazardodusRSQL").append("\n"); 
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
		query.append("	SELECT REPLACE(REPLACE(DG.PRP_SHP_NM, CHR(10), ''), CHR(13), '') AS CMDD" ).append("\n"); 
		query.append("		  ,'International' AS SHP_QUAL" ).append("\n"); 
		query.append("		  ,REPLACE(REPLACE(DG.IMDG_CLSS_CD, CHR(10), ''), CHR(13), '') AS CLASS" ).append("\n"); 
		query.append("		  ,'' AS CLASS_QUAL" ).append("\n"); 
		query.append("		  ,'UN' || DG.IMDG_UN_NO AS UN_NO" ).append("\n"); 
		query.append("		  ,DG.GRS_WGT AS WGT" ).append("\n"); 
		query.append("		  ,NVL(DG.WGT_UT_CD, 'KG') AS WGTUNIT" ).append("\n"); 
		query.append("		  ,DECODE(DG.IMDG_PCK_GRP_CD, '1', 'Group I', '2', 'Group II', '3', 'Group III', '') AS D_PKG_GRP" ).append("\n"); 
		query.append("		  ,DG.IMDG_LMT_QTY_FLG AS IMO_LIMIT" ).append("\n"); 
		query.append("		  ,DECODE(SUBSTR(DG.PRP_SHP_NM, LENGTH(DG.PRP_SHP_NM) - 7, 8), ', N.O.S.', SUBSTR(DG.PRP_SHP_NM, 1, 50), '') AS NOS" ).append("\n"); 
		query.append("		  ,SUBSTR(REPLACE(REPLACE(DG.HZD_DESC, CHR(10), ''), CHR(13), ''), 1, 100) AS TECH_NAME" ).append("\n"); 
		query.append("		  ,DG.OUT_IMDG_PCK_CD1 AS D_PKG_UNIT" ).append("\n"); 
		query.append("		  ,DG.OUT_IMDG_PCK_QTY1 AS D_PKG_QTY" ).append("\n"); 
		query.append("		  ,SUBSTR(IMDG.IMDG_PCK_DESC, 1, 25) AS D_PKG" ).append("\n"); 
		query.append("		  ,SUBSTR(REPLACE(REPLACE(DG.EMER_CNTC_PSON_NM, CHR(10), ''), CHR(13), ''), 1, 60) AS CONTACT_NM" ).append("\n"); 
		query.append("		  ,DG.EMER_CNTC_PHN_NO_CTNT AS CONTACT_TEL" ).append("\n"); 
		query.append("		  ,SUBSTR(REPLACE(REPLACE(DG.EMER_CNTC_PSON_NM, CHR(10), ''), CHR(13), ''), 1, 20) AS CONTACT_REF" ).append("\n"); 
		query.append("		  ,'' AS REPORT_IND" ).append("\n"); 
		query.append("		  ,NVL2(DG.FLSH_PNT_CDO_TEMP, 'CE', '') AS FLASH_UNIT" ).append("\n"); 
		query.append("		  ,DG.FLSH_PNT_CDO_TEMP AS FLASH" ).append("\n"); 
		query.append("		  ,DG.MRN_POLUT_FLG AS MAR_POLL" ).append("\n"); 
		query.append("		  ,SUBSTR(REPLACE(REPLACE(DG.DIFF_RMK, CHR(10), ''), CHR(13), ''), 1, 80) AS HS_COMMENT" ).append("\n"); 
		query.append("	  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("		  ,BKG_DG_CGO       DG" ).append("\n"); 
		query.append("		  ,SCG_IMDG_PCK_CD  IMDG" ).append("\n"); 
		query.append("	 WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	   AND SO.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("	   AND NVL(SO.EQ_NO, 'XX') = NVL2(SO.EQ_NO, NVL(DG.CNTR_NO, NVL(SO.EQ_NO, 'XX')), 'XX')" ).append("\n"); 
		query.append("	   AND DG.OUT_IMDG_PCK_CD1 = IMDG.IMDG_PCK_CD(+)" ).append("\n"); 
		query.append("	   AND NVL(IMDG.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("	 ORDER BY DG.DG_CNTR_SEQ, DG.CNTR_CGO_SEQ" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("  ON 1 = 1" ).append("\n"); 

	}
}