/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EbookingReceiptDBDAOSearchXterRqstMstForBOKCONRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.06.27 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EbookingReceiptDBDAOSearchXterRqstMstForBOKCONRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * e-bkg receipt BOKCON flat file 생성을 위해 Request master 정보를 조회한다.
	  * </pre>
	  */
	public EbookingReceiptDBDAOSearchXterRqstMstForBOKCONRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EbookingReceiptDBDAOSearchXterRqstMstForBOKCONRSQL").append("\n"); 
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
		query.append("--searchXterRqstMstForAck" ).append("\n"); 
		query.append("SELECT  'IB_NO:'            || XTER_RQST_NO                                     ||CHR(10)||" ).append("\n"); 
		query.append("        'BKG_NO_AUT:'       || B.BKG_NO                                         ||CHR(10)||" ).append("\n"); 
		query.append("        'BKG_STS:'          || 'Y'                                              ||CHR(10)||" ).append("\n"); 
		query.append("        'SED_IND:'          || DECODE(B.BKG_STS_CD, 'X', '3'," ).append("\n"); 
		query.append("                                DECODE((SELECT COUNT(XTER_RQST_NO) " ).append("\n"); 
		query.append("                                        FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("                                         WHERE XTER_SNDR_ID = M.XTER_SNDR_ID" ).append("\n"); 
		query.append("										   AND XTER_RQST_NO = M.XTER_RQST_NO" ).append("\n"); 
		query.append("                                           AND AUTO_CFM_EDI_FLG = 'Y'),0,'9',DECODE(XTER_BKG_RQST_STS_CD,'X','3','7')))  ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_PO_NO:'         || PO_NO                                            ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_C_ID:'          || CUST_ID                                          ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POL_CD:'        || NVL(B.POL_CD,M.POL_CD)   ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POL_NM:'        || NVL(D.POL_NM,M.POL_NM)   ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POR_CD:'        || NVL(B.POR_CD,M.POR_CD)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POR_NM:'        || NVL(D.POR_NM,M.POR_NM)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POD_CD:'        || NVL(B.POD_CD,M.POD_CD)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_POD_NM:'        || NVL(D.POD_NM,M.POD_NM)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_DEL_CD:'        || NVL(B.DEL_CD,M.DEL_CD)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_DEL_NM:'        || NVL(D.DEL_NM,M.DEL_NM)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SHIP_EXP_DT:'   || TO_CHAR(SHP_EXP_DT, 'YYYYMMDDHH24MI')||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SHIP_DT:'       || to_char(NVL(B.LODG_DUE_DT,M.RQST_DEP_DT),'YYYYMMDDHH24MI')||CHR(10)||" ).append("\n"); 
		query.append("        'IB_VSL_CD:'        || NVL(B.VSL_CD,M.VSL_CD)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_VVD_NM:'        || NVL((SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = B.VSL_CD),M.VSL_NM)||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SKD_VOYAGE_NO:' || NVL(B.SKD_VOY_NO||B.SKD_DIR_CD,M.SKD_VOY_NO||M.SKD_DIR_CD)		||CHR(10)||" ).append("\n"); 
		query.append("		'IB_PRE_VSL_NM:'	|| (SELECT MV.VSL_ENG_NM " ).append("\n"); 
		query.append("		                          FROM BKG_VVD PRE, MDM_VSL_CNTR MV " ).append("\n"); 
		query.append("								WHERE 'S' = PRE.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("		 					      AND B.PRE_RLY_PORT_CD= PRE.POD_CD(+)" ).append("\n"); 
		query.append("		  					      AND B.BKG_NO = PRE.BKG_NO(+)" ).append("\n"); 
		query.append("							      AND MV.VSL_CD = PRE.VSL_CD)||CHR(10)||" ).append("\n"); 
		query.append("		'IB_PRE_VSL_VOY:'   || (SELECT PRE.SKD_VOY_NO||PRE.SKD_DIR_CD " ).append("\n"); 
		query.append("		                          FROM BKG_VVD PRE, MDM_VSL_CNTR MV " ).append("\n"); 
		query.append("								WHERE 'S' = PRE.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("		 					      AND B.PRE_RLY_PORT_CD= PRE.POD_CD(+)" ).append("\n"); 
		query.append("		  					      AND B.BKG_NO = PRE.BKG_NO(+)" ).append("\n"); 
		query.append("							      AND MV.VSL_CD = PRE.VSL_CD)||CHR(10)||" ).append("\n"); 
		query.append("		'IB_POST_VSL_NM:'	|| (SELECT MV.VSL_ENG_NM " ).append("\n"); 
		query.append("		                          FROM BKG_VVD PST, MDM_VSL_CNTR MV " ).append("\n"); 
		query.append("								WHERE 'U' = PST.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("		 					      AND B.PRE_RLY_PORT_CD= PST.POD_CD(+)" ).append("\n"); 
		query.append("		  					      AND B.BKG_NO = PST.BKG_NO(+)" ).append("\n"); 
		query.append("							      AND MV.VSL_CD = PST.VSL_CD)||CHR(10)||" ).append("\n"); 
		query.append("		'IB_POST_VSL_VOY:'   || (SELECT PST.SKD_VOY_NO||PST.SKD_DIR_CD " ).append("\n"); 
		query.append("		                          FROM BKG_VVD PST, MDM_VSL_CNTR MV " ).append("\n"); 
		query.append("								WHERE 'U' = PST.VSL_PRE_PST_CD(+)					" ).append("\n"); 
		query.append("		 					      AND B.PRE_RLY_PORT_CD= PST.POD_CD(+)" ).append("\n"); 
		query.append("		  					      AND B.BKG_NO = PST.BKG_NO(+)" ).append("\n"); 
		query.append("							      AND MV.VSL_CD = PST.VSL_CD)||CHR(10)||" ).append("\n"); 
		query.append("		'IB_FRT_TERM:'		|| FRT_TERM_CD ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_DEL_ETA:'		|| (SELECT to_char(MAX(ESTM_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  	FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 	WHERE B.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("							   	AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("							   	AND DTL.NOD_CD = B.DEL_NOD_CD" ).append("\n"); 
		query.append("							   	AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   	AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_')) ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_CY_CLOSE_DT:'	|| (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("							  	FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("							 	WHERE B.BKG_NO = CLZ.BKG_NO" ).append("\n"); 
		query.append("							   	AND CLZ_TP_CD = 'T') ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_PICKUP_CY_NM:'	|| (SELECT YD_NM" ).append("\n"); 
		query.append("							   FROM MDM_YARD MY" ).append("\n"); 
		query.append("							   WHERE B.MTY_PKUP_YD_CD = MY.YD_CD) ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_RMK:'           || NVL(REPLACE(B.XTER_RMK, CHR(13)||CHR(10), ' '),REPLACE(M.XTER_BKG_RMK1, CHR(13)||CHR(10), ' '))||CHR(10)||" ).append("\n"); 
		query.append("        'IB_SI_NO:'         || SI_NO							||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("  FROM BKG_XTER_RQST_MST M, BKG_BOOKING B, BKG_BL_DOC D    " ).append("\n"); 
		query.append(" WHERE 1=1   " ).append("\n"); 
		query.append("   AND XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   AND M.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("   and rownum =1" ).append("\n"); 

	}
}