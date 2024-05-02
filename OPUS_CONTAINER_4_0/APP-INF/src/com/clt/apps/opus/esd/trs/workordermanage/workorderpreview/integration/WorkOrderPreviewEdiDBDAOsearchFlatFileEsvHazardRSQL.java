/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvHazardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvHazardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {HAZARDODUS
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvHazardRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvHazardRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT DG.BKG_NO" ).append("\n"); 
		query.append("			  ,DG.DCGO_SEQ" ).append("\n"); 
		query.append("			  ,DG.PRP_SHP_NM AS PRO_SH_NAME" ).append("\n"); 
		query.append("			  ,DG.HZD_DESC AS TECH_NAME" ).append("\n"); 
		query.append("			  ,P.IMDG_PCK_DESC AS D_PKG" ).append("\n"); 
		query.append("			  ,DG.OUT_IMDG_PCK_CD1 AS D_PKG_CD" ).append("\n"); 
		query.append("			  ,DG.OUT_IMDG_PCK_QTY1 AS D_PKG_QTY" ).append("\n"); 
		query.append("			  ,DG.IMDG_UN_NO AS UN_NO" ).append("\n"); 
		query.append("			  ,'' EMS_NO" ).append("\n"); 
		query.append("			  ,CASE WHEN DG.IMDG_PCK_GRP_CD IN ('1', '2', '3') THEN DG.IMDG_PCK_GRP_CD END D_PKG_GRP" ).append("\n"); 
		query.append("			  ,DG.IMDG_CLSS_CD AS CLASS" ).append("\n"); 
		query.append("			  ,DG.FLSH_PNT_CDO_TEMP AS FLASH" ).append("\n"); 
		query.append("			  ,'C' AS FLASH_UNIT" ).append("\n"); 
		query.append("			  ,DG.IMDG_LMT_QTY_FLG AS IMO_LIMIT" ).append("\n"); 
		query.append("			  ,'' AS IMO_LIMIT_QTY" ).append("\n"); 
		query.append("			  ,'' AS REPORT_QTY" ).append("\n"); 
		query.append("			  ,DG.MRN_POLUT_FLG AS MAR_POLL" ).append("\n"); 
		query.append("			  ,SUBSTR(REPLACE(REPLACE(DG.DIFF_RMK, CHR(10), ''), CHR(13), ''), 1, 80) AS REMARK" ).append("\n"); 
		query.append("			  ,'' AS RESTRICT_CD" ).append("\n"); 
		query.append("			  ,'' AS CONTACT_TYPE" ).append("\n"); 
		query.append("			  ,DG.EMER_CNTC_PHN_NO_CTNT AS CONTACT_NO" ).append("\n"); 
		query.append("			  ,SUBSTR(REPLACE(REPLACE(DG.EMER_CNTC_PSON_NM, CHR(10), ''), CHR(13), ''), 1, 60) AS CONTACT_INFO" ).append("\n"); 
		query.append("			  ,DG.CNTR_NO" ).append("\n"); 
		query.append("			  ,DG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD   SO" ).append("\n"); 
		query.append("			  ,BKG_EUR_TRO_DG_SEQ DG_SEQ" ).append("\n"); 
		query.append("			  ,BKG_DG_CGO         DG" ).append("\n"); 
		query.append("			  ,SCG_IMDG_PCK_CD    P" ).append("\n"); 
		query.append("		 WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("		   AND SUBSTR(SO.COST_ACT_GRP_CD, 1, 2) = 'OD'" ).append("\n"); 
		query.append("		   AND SO.BKG_NO = DG_SEQ.BKG_NO" ).append("\n"); 
		query.append("		   AND SO.TRSP_BND_CD = DG_SEQ.IO_BND_CD" ).append("\n"); 
		query.append("		   AND SO.TRO_SEQ = DG_SEQ.TRO_SEQ" ).append("\n"); 
		query.append("		   AND DG_SEQ.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("		   AND DG_SEQ.TRO_DCGO_SEQ = DG.DCGO_SEQ" ).append("\n"); 
		query.append("		   AND NVL(SO.EQ_NO, 'XXX') = NVL2(SO.EQ_NO, NVL(DG.CNTR_NO, NVL(SO.EQ_NO, 'XXX')), 'XXX')" ).append("\n"); 
		query.append("		   AND DG.OUT_IMDG_PCK_CD1 = P.IMDG_PCK_CD(+)" ).append("\n"); 
		query.append("		   AND NVL(P.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("		SELECT DG.BKG_NO" ).append("\n"); 
		query.append("			  ,DG.DCGO_SEQ" ).append("\n"); 
		query.append("			  ,DG.PRP_SHP_NM AS PRO_SH_NAME" ).append("\n"); 
		query.append("			  ,DG.HZD_DESC AS TECH_NAME" ).append("\n"); 
		query.append("			  ,P.IMDG_PCK_DESC AS D_PKG" ).append("\n"); 
		query.append("			  ,DG.OUT_IMDG_PCK_CD1 AS D_PKG_CD" ).append("\n"); 
		query.append("			  ,DG.OUT_IMDG_PCK_QTY1 AS D_PKG_QTY" ).append("\n"); 
		query.append("			  ,DG.IMDG_UN_NO AS UN_NO" ).append("\n"); 
		query.append("			  ,'' EMS_NO" ).append("\n"); 
		query.append("			  ,CASE WHEN DG.IMDG_PCK_GRP_CD IN ('1', '2', '3') THEN DG.IMDG_PCK_GRP_CD END D_PKG_GRP" ).append("\n"); 
		query.append("			  ,DG.IMDG_CLSS_CD AS CLASS" ).append("\n"); 
		query.append("			  ,DG.FLSH_PNT_CDO_TEMP AS FLASH" ).append("\n"); 
		query.append("			  ,'C' AS FLASH_UNIT" ).append("\n"); 
		query.append("			  ,DG.IMDG_LMT_QTY_FLG AS IMO_LIMIT" ).append("\n"); 
		query.append("			  ,'' AS IMO_LIMIT_QTY" ).append("\n"); 
		query.append("			  ,'' AS REPORT_QTY" ).append("\n"); 
		query.append("			  ,DG.MRN_POLUT_FLG AS MAR_POLL" ).append("\n"); 
		query.append("			  ,SUBSTR(REPLACE(REPLACE(DG.DIFF_RMK, CHR(10), ''), CHR(13), ''), 1, 80) AS REMARK" ).append("\n"); 
		query.append("			  ,'' AS RESTRICT_CD" ).append("\n"); 
		query.append("			  ,'' AS CONTACT_TYPE" ).append("\n"); 
		query.append("			  ,DG.EMER_CNTC_PHN_NO_CTNT AS CONTACT_NO" ).append("\n"); 
		query.append("			  ,SUBSTR(REPLACE(REPLACE(DG.EMER_CNTC_PSON_NM, CHR(10), ''), CHR(13), ''), 1, 60) AS CONTACT_INFO" ).append("\n"); 
		query.append("			  ,DG.CNTR_NO" ).append("\n"); 
		query.append("			  ,DG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("			  ,BKG_DG_CGO       DG" ).append("\n"); 
		query.append("			  ,SCG_IMDG_PCK_CD  P" ).append("\n"); 
		query.append("		 WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("		   AND SUBSTR(SO.COST_ACT_GRP_CD, 1, 2) <> 'OD'" ).append("\n"); 
		query.append("		   AND SO.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("		   AND NVL(SO.EQ_NO, 'XXX') = NVL2(SO.EQ_NO, NVL(DG.CNTR_NO, NVL(SO.EQ_NO, 'XXX')), 'XXX')" ).append("\n"); 
		query.append("		   AND DG.OUT_IMDG_PCK_CD1 = P.IMDG_PCK_CD(+)" ).append("\n"); 
		query.append("		   AND NVL(P.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}