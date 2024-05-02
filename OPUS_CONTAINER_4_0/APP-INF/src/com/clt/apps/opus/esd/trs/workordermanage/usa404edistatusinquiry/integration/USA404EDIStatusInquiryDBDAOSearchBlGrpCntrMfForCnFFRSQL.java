/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearchBlGrpCntrMfForCnFFRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearchBlGrpCntrMfForCnFFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA404EDIStatusInquiryDBDAOSearchBlGrpCntrMfForCnFF
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearchBlGrpCntrMfForCnFFRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_ind",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearchBlGrpCntrMfForCnFFRSQL").append("\n"); 
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
		query.append("WITH V1 AS (" ).append("\n"); 
		query.append(" SELECT ROW_NUMBER() OVER(ORDER BY BKG_NO, CNTR_MF_SEQ) RN" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_MF_SEQ" ).append("\n"); 
		query.append("      ,PCK_QTY" ).append("\n"); 
		query.append("      ,PCK_TP_CD" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(CNTR_MF_GDS_DESC, CHR(10), ' '), CHR(13), ' ') CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("      ,CNTR_MF_WGT" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC D" ).append("\n"); 
		query.append(" WHERE (BKG_NO, CNTR_NO) IN" ).append("\n"); 
		query.append("       (SELECT /*+ LEADING(BC) USE_NL(B) USE_NL(B1)*/ " ).append("\n"); 
		query.append("			   BC.BKG_NO, BC.CNTR_NO" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER BC, BKG_BOOKING B, BKG_BOOKING B1" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR M, SCE_COP_HDR S, TRS_TRSP_RAIL_BIL_ORD O" ).append("\n"); 
		query.append("                 WHERE O.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                   AND O.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                   AND O.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND NVL(O.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND S.COP_NO = O.COP_NO" ).append("\n"); 
		query.append("                   AND S.MST_COP_NO = M.COP_NO" ).append("\n"); 
		query.append("                   AND M.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("           AND B.BKG_NO <> B1.BKG_NO" ).append("\n"); 
		query.append("           AND B.VSL_CD = B1.VSL_CD" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = B1.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = B1.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND B1.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("           AND BC.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("           AND B1.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND (B1.BKG_STS_CD = 'W' OR B1.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT O.BKG_NO, O.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_ORD O" ).append("\n"); 
		query.append("         WHERE O.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND O.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND O.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("           AND NVL(O.DELT_FLG, 'N') <> 'Y')" ).append("\n"); 
		query.append("   AND 'I' = @[bound_ind]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT T.RN               CM_LINE_ITEM" ).append("\n"); 
		query.append("      ,T.PCK_QTY          CM_PACKQTY" ).append("\n"); 
		query.append("      ,T.CNTR_MF_GDS_DESC CM_PACKDESC" ).append("\n"); 
		query.append("      ,T.PCK_TP_CD        CM_PACKFORM" ).append("\n"); 
		query.append("      ,T.CNTR_MF_WGT      CM_WEIGHT" ).append("\n"); 
		query.append("  FROM (SELECT RN, PCK_QTY, CNTR_MF_GDS_DESC, PCK_TP_CD, CNTR_MF_WGT" ).append("\n"); 
		query.append("          FROM V1" ).append("\n"); 
		query.append("         WHERE RN < 25" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT RN, PCK_QTY, CNTR_MF_GDS_DESC, PCK_TP_CD, CNTR_MF_WGT" ).append("\n"); 
		query.append("          FROM (SELECT MIN(RN) RN" ).append("\n"); 
		query.append("                      ,SUM(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("                      ,MIN(CNTR_MF_GDS_DESC) CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("                      ,CASE WHEN MAX(PTC) > 1 THEN 'PC'" ).append("\n"); 
		query.append("                            ELSE MAX(PCK_TP_CD)" ).append("\n"); 
		query.append("                       END PCK_TP_CD" ).append("\n"); 
		query.append("                      ,SUM(CNTR_MF_WGT) CNTR_MF_WGT" ).append("\n"); 
		query.append("                  FROM (SELECT RN" ).append("\n"); 
		query.append("                              ,PCK_QTY" ).append("\n"); 
		query.append("                              ,PCK_TP_CD" ).append("\n"); 
		query.append("                              ,RANK() OVER(ORDER BY PCK_TP_CD) PTC" ).append("\n"); 
		query.append("                              ,FIRST_VALUE(CNTR_MF_GDS_DESC) OVER(ORDER BY RN ASC) CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("                              ,CNTR_MF_WGT" ).append("\n"); 
		query.append("                          FROM V1" ).append("\n"); 
		query.append("                         WHERE RN >= 25))" ).append("\n"); 
		query.append("         WHERE RN IS NOT NULL) T" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}