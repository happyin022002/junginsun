/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEquipmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.07.19 박찬우
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEquipmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {EQUIPMENT
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEquipmentRSQL(){
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
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEquipmentRSQL").append("\n"); 
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
		query.append("	#if(${cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("		SELECT SO.BKG_NO" ).append("\n"); 
		query.append("			  ,SO.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("			  ,SO.EQ_TPSZ_CD AS CNTR_TPSZ" ).append("\n"); 
		query.append("			  ,'' AS EQ_COMMENT" ).append("\n"); 
		query.append("			  ,'' AS FUMIGATE" ).append("\n"); 
		query.append("			  ,'' AS TRIAXLE" ).append("\n"); 
		query.append("--			  ,SUBSTR(DECODE(NVL(SO.EQ_NO, 'XX'), 'XX', F.CMDT_NM, C.DIFF_RMK), 1, 50) CMDD" ).append("\n"); 
		query.append("              ,CASE WHEN SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                    THEN NVL((SELECT REPLACE(REPLACE(CM.CNTR_MF_GDS_DESC, CHR(13), ''), CHR(10), ' ')" ).append("\n"); 
		query.append("                                FROM BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("                               WHERE SO.BKG_NO = CM.BKG_NO(+)" ).append("\n"); 
		query.append("                                 AND SO.EQ_NO = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("                                 AND CM.CNTR_MF_SEQ = 1), F.CMDT_NM)" ).append("\n"); 
		query.append("                    WHEN TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("                    THEN NVL((SELECT CMDD.CMDT_NM" ).append("\n"); 
		query.append("                                FROM BKG_EUR_TRO TRO," ).append("\n"); 
		query.append("                                     MDM_COMMODITY CMDD" ).append("\n"); 
		query.append("                               WHERE SO.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("                                 AND SO.TRSP_BND_CD = TRO.IO_BND_CD" ).append("\n"); 
		query.append("                                 AND SO.TRO_SEQ = TRO.TRO_SEQ" ).append("\n"); 
		query.append("                                 AND SO.TRO_SUB_SEQ = TRO.RQST_SUB_SEQ" ).append("\n"); 
		query.append("                                 AND SO.EQ_TPSZ_CD = TRO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 AND TRO.CMDT_CD = CMDD.CMDT_CD(+)" ).append("\n"); 
		query.append("                                 AND TRO.CXL_FLG = 'N'), F.CMDT_NM)" ).append("\n"); 
		query.append("                    ELSE F.CMDT_NM" ).append("\n"); 
		query.append("               END CMDD" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(X.CNTR_TYPE, 'X') != 'X' THEN X.CNTR_TYPE" ).append("\n"); 
		query.append("					WHEN B.DCGO_FLG = 'Y' AND B.AWK_CGO_FLG = 'Y' THEN 'Awkward Dangerous'" ).append("\n"); 
		query.append("					WHEN B.DCGO_FLG = 'Y' AND B.RC_FLG = 'Y' THEN 'Reefer Dangerous'" ).append("\n"); 
		query.append("					WHEN B.DCGO_FLG = 'Y' 		THEN 'Dangerous'" ).append("\n"); 
		query.append("					WHEN B.RC_FLG = 'Y' 		THEN 'Reefer'" ).append("\n"); 
		query.append("					WHEN B.BB_CGO_FLG = 'Y' 	THEN 'Break Bulk'" ).append("\n"); 
		query.append("					WHEN B.AWK_CGO_FLG = 'Y' 	THEN 'Awkward'" ).append("\n"); 
		query.append("					WHEN NVL(B.DCGO_FLG, 'N') = 'N' AND NVL(B.RC_FLG, 'N') = 'N' AND NVL(B.BB_CGO_FLG, 'N') = 'N' AND NVL(B.AWK_CGO_FLG, 'N') = 'N' THEN 'General'" ).append("\n"); 
		query.append("					ELSE ''" ).append("\n"); 
		query.append("			   END CNTR_TYPE" ).append("\n"); 
		query.append("			  ,B.CMDT_CD AS HS_CD" ).append("\n"); 
		query.append("			  ,C.PCK_QTY AS PKG_QTY" ).append("\n"); 
		query.append("			  ,C.PCK_TP_CD AS PKG_CD" ).append("\n"); 
		query.append("			  ,D.PCK_NM AS PKG_TYPE" ).append("\n"); 
		query.append("			  ,SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			  ,SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("			  ,BKG_BOOKING      B" ).append("\n"); 
		query.append("			  ,BKG_CONTAINER    C" ).append("\n"); 
		query.append("			  ,MDM_PCK_TP       D" ).append("\n"); 
		query.append("			  ,MDM_COMMODITY    F" ).append("\n"); 
		query.append("			  ,(SELECT NVL(TRIM(DECODE(SIGN(TRO.RC_SEQ), 1, 'Reefer ') || DECODE(SIGN(TRO.AWK_CGO_SEQ), 1, 'Awkward ') || DECODE(SIGN(DGSEQ.DCGO_SEQ), 1, 'Dangerous')), 'General') CNTR_TYPE" ).append("\n"); 
		query.append("					  ,SVC.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					  ,SVC.TRSP_SO_SEQ" ).append("\n"); 
		query.append("				  FROM TRS_TRSP_SVC_ORD   SVC" ).append("\n"); 
		query.append("					  ,BKG_EUR_TRO        TRO" ).append("\n"); 
		query.append("					  ,BKG_EUR_TRO_DG_SEQ DGSEQ" ).append("\n"); 
		query.append("				 WHERE SVC.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("				   AND SVC.TRSP_BND_CD = TRO.IO_BND_CD" ).append("\n"); 
		query.append("				   AND SVC.TRO_SEQ = TRO.TRO_SEQ" ).append("\n"); 
		query.append("				   AND SVC.TRO_SUB_SEQ = TRO.RQST_SUB_SEQ" ).append("\n"); 
		query.append("				   AND SVC.EQ_TPSZ_CD = TRO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				   AND TRO.BKG_NO = DGSEQ.BKG_NO" ).append("\n"); 
		query.append("				   AND TRO.IO_BND_CD = DGSEQ.IO_BND_CD" ).append("\n"); 
		query.append("				   AND TRO.TRO_SEQ = DGSEQ.TRO_SEQ" ).append("\n"); 
		query.append("				   AND SVC.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("				   AND SVC.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("				   AND ROWNUM = 1) X" ).append("\n"); 
		query.append("		 WHERE SO.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		   AND SO.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND SO.EQ_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("		   AND C.PCK_TP_CD = D.PCK_CD(+)" ).append("\n"); 
		query.append("		   AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("		   AND B.CMDT_CD = F.CMDT_CD(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_OFC_CTY_CD = X.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = X.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		SELECT SO.BKG_NO" ).append("\n"); 
		query.append("			  ,SO.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("			  ,SO.EQ_TPSZ_CD AS CNTR_TPSZ" ).append("\n"); 
		query.append("			  ,'' AS EQ_COMMENT" ).append("\n"); 
		query.append("			  ,'' AS FUMIGATE" ).append("\n"); 
		query.append("			  ,'' AS TRIAXLE" ).append("\n"); 
		query.append("			  ,'' CMDD" ).append("\n"); 
		query.append("			  ,CASE WHEN NVL(X.CNTR_TYPE, 'X') != 'X' THEN X.CNTR_TYPE END CNTR_TYPE" ).append("\n"); 
		query.append("			  ,'' AS HS_CD" ).append("\n"); 
		query.append("			  ,'' AS PKG_QTY" ).append("\n"); 
		query.append("			  ,'' AS PKG_CD" ).append("\n"); 
		query.append("			  ,'' AS PKG_TYPE" ).append("\n"); 
		query.append("			  ,SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("			  ,SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("		  FROM TRS_TRSP_SVC_ORD SO     " ).append("\n"); 
		query.append("			  ,(SELECT NVL(TRIM(DECODE(SIGN(TRO.RC_SEQ), 1, 'Reefer ') || DECODE(SIGN(TRO.AWK_CGO_SEQ), 1, 'Awkward ') || DECODE(SIGN(DGSEQ.DCGO_SEQ), 1, 'Dangerous')), 'General') CNTR_TYPE" ).append("\n"); 
		query.append("					  ,SVC.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("					  ,SVC.TRSP_SO_SEQ" ).append("\n"); 
		query.append("				  FROM TRS_TRSP_SVC_ORD   SVC" ).append("\n"); 
		query.append("					  ,BKG_EUR_TRO        TRO" ).append("\n"); 
		query.append("					  ,BKG_EUR_TRO_DG_SEQ DGSEQ" ).append("\n"); 
		query.append("				 WHERE SVC.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("				   AND SVC.TRSP_BND_CD = TRO.IO_BND_CD" ).append("\n"); 
		query.append("				   AND SVC.TRO_SEQ = TRO.TRO_SEQ" ).append("\n"); 
		query.append("				   AND SVC.TRO_SUB_SEQ = TRO.RQST_SUB_SEQ" ).append("\n"); 
		query.append("				   AND SVC.EQ_TPSZ_CD = TRO.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				   AND TRO.BKG_NO = DGSEQ.BKG_NO" ).append("\n"); 
		query.append("				   AND TRO.IO_BND_CD = DGSEQ.IO_BND_CD" ).append("\n"); 
		query.append("				   AND TRO.TRO_SEQ = DGSEQ.TRO_SEQ" ).append("\n"); 
		query.append("				   AND SVC.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("				   AND SVC.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("				   AND ROWNUM = 1) X" ).append("\n"); 
		query.append("		 WHERE SO.TRSP_SO_OFC_CTY_CD = X.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = X.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("		   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(" ) T1" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}