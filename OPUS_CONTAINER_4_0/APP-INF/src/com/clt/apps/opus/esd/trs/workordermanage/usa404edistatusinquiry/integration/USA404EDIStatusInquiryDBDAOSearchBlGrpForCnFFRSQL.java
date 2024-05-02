/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearchBlGrpForCnFFRSQL.java
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

public class USA404EDIStatusInquiryDBDAOSearchBlGrpForCnFFRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA404EDIStatusInquiryDBDAOSearchBlGrpForCnFF
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearchBlGrpForCnFFRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearchBlGrpForCnFFRSQL").append("\n"); 
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
		query.append("SELECT T.*" ).append("\n"); 
		query.append("  FROM (SELECT  /*+ LEADING(BC) USE_NL(B) USE_NL(B1)*/ " ).append("\n"); 
		query.append("               BC.BKG_NO BL_BKGNO" ).append("\n"); 
		query.append("              ,B1.BL_NO BL_BLNO" ).append("\n"); 
		query.append("              ,BC.CNTR_NO EQ_NO" ).append("\n"); 
		query.append("              ,SUM_PCK_QTY BL_LADEQTY" ).append("\n"); 
		query.append("              ,REPLACE(REPLACE(D.CNTR_MF_GDS_DESC, CHR(13), ' '), CHR(10), ' ') BL_LADEDESC" ).append("\n"); 
		query.append("              ,D.HAMO_TRF_CD BL_COMMCODE" ).append("\n"); 
		query.append("              ,D.PCK_TP_CD BL_PACKFORM" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("              ,BKG_BOOKING B" ).append("\n"); 
		query.append("              ,BKG_BOOKING B1" ).append("\n"); 
		query.append("              ,(SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,CNTR_NO" ).append("\n"); 
		query.append("                      ,CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("                      ,HAMO_TRF_CD" ).append("\n"); 
		query.append("                      ,SUM_PCK_QTY" ).append("\n"); 
		query.append("                      ,CASE	WHEN FIRST_PCK_TP_CD = LAST_PCK_TP_CD THEN FIRST_PCK_TP_CD" ).append("\n"); 
		query.append("                         	ELSE 'PC'" ).append("\n"); 
		query.append("                       END PCK_TP_CD" ).append("\n"); 
		query.append("                  FROM (SELECT K.BKG_NO" ).append("\n"); 
		query.append("                              ,K.CNTR_NO" ).append("\n"); 
		query.append("                              ,K.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                              ,K.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("                              ,K.HAMO_TRF_CD" ).append("\n"); 
		query.append("                              ,SUM(NVL(PCK_QTY, 0)) OVER(PARTITION BY K.BKG_NO, K.CNTR_NO) SUM_PCK_QTY" ).append("\n"); 
		query.append("                              ,MIN(K.CNTR_MF_SEQ) OVER(PARTITION BY K.BKG_NO, K.CNTR_NO) MIN_CNTR_MF_SEQ" ).append("\n"); 
		query.append("                              ,FIRST_VALUE(K.PCK_TP_CD) OVER(PARTITION BY K.BKG_NO, K.CNTR_NO ORDER BY K.PCK_TP_CD) FIRST_PCK_TP_CD" ).append("\n"); 
		query.append("                              ,LAST_VALUE(K.PCK_TP_CD) OVER(PARTITION BY K.BKG_NO, K.CNTR_NO ORDER BY K.PCK_TP_CD) LAST_PCK_TP_CD" ).append("\n"); 
		query.append("                          FROM BKG_CNTR_MF_DESC K)" ).append("\n"); 
		query.append("                 WHERE CNTR_MF_SEQ = MIN_CNTR_MF_SEQ) D" ).append("\n"); 
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
		query.append("           AND BC.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BC.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("         ORDER BY BC.BKG_NO, B1.BL_NO, BC.CNTR_NO) T" ).append("\n"); 
		query.append(" RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("    ON 1 = 1" ).append("\n"); 

	}
}