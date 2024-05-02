/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlIssInfo1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlIssInfo1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBlIssInfo1
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlIssInfo1RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlIssInfo1RSQL").append("\n"); 
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
		query.append("DECODE(NVL(CHN_AGN_CD, '*'), '*', DECODE(RT_BL_TP_CD, 'C', 1, 'B', 1, CHG_IND.CNT), 1)" ).append("\n"); 
		query.append("||'|'|| MK_IND.CNT" ).append("\n"); 
		query.append("||'|'|| CHG_PPD_IND.CNT" ).append("\n"); 
		query.append("||'|'|| CHG_PPD_THIRD_IND.CNT" ).append("\n"); 
		query.append("||'|'|| NVL(MND.MND_CNT, 0)" ).append("\n"); 
		query.append("||'|'|| NVL(RATE.RATE_CNT, 0)" ).append("\n"); 
		query.append("||'|'|| NVL(CNTR.CNTR_CNT, 0)" ).append("\n"); 
		query.append("||'|'|| NVL(CUST.CUST_CNT, 0)" ).append("\n"); 
		query.append("AS " ).append("\n"); 
		query.append("BL_NOT_READY" ).append("\n"); 
		query.append("FROM 			" ).append("\n"); 
		query.append("BKG_BOOKING BKG ,			" ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, C.RT_BL_TP_CD, COUNT(B.BKG_NO) CNT			" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, 			" ).append("\n"); 
		query.append("            BKG_CHG_RT B," ).append("\n"); 
		query.append("            BKG_RATE C			" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]			" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append(" AND        A.BKG_NO = C.BKG_NO(+)			" ).append("\n"); 
		query.append(" GROUP BY   A.BKG_NO , C.RT_BL_TP_CD) CHG_IND,			" ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, COUNT(B.BKG_NO) CNT			" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, 			" ).append("\n"); 
		query.append("            BKG_BL_MK_DESC B			" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]			" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)			" ).append("\n"); 
		query.append(" GROUP BY   A.BKG_NO ) MK_IND,			" ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, COUNT(B.BKG_NO) CNT			" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, 			" ).append("\n"); 
		query.append("            BKG_CHG_RT B			" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]			" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)			" ).append("\n"); 
		query.append(" AND        B.FRT_TERM_CD (+) = 'P'			" ).append("\n"); 
		query.append(" AND        B.N3PTY_RCV_OFC_CD(+) IS NULL			" ).append("\n"); 
		query.append(" GROUP BY   A.BKG_NO ) CHG_PPD_IND, 			" ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, COUNT(B.BKG_NO) CNT			" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, 			" ).append("\n"); 
		query.append("            BKG_CHG_RT B			" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]			" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)			" ).append("\n"); 
		query.append(" AND        B.FRT_TERM_CD (+) = 'P'			" ).append("\n"); 
		query.append(" AND        B.N3PTY_RCV_OFC_CD(+) IS NOT NULL			" ).append("\n"); 
		query.append(" GROUP BY   A.BKG_NO ) CHG_PPD_THIRD_IND, " ).append("\n"); 
		query.append("(SELECT     A.BKG_NO BKG_NO, " ).append("\n"); 
		query.append("            --DECODE((NVL(B.PCK_QTY, '0')||NVL(B.ACT_WGT, '0')||NVL(B.CSTMS_DESC, '*')), '00*', 0, 1) MND_CNT " ).append("\n"); 
		query.append("			DECODE(NVL(LENGTH(B.CMDT_DESC), 0), 0, 0, 1) MND_CNT " ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, BKG_BL_MK_DESC B" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO  " ).append("\n"); 
		query.append(") MND," ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, " ).append("\n"); 
		query.append("            DECODE(NVL(B.RT_BL_TP_CD, 'N'), 'C', 1, 'B', 1, COUNT(C.BKG_NO)) RATE_CNT" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A," ).append("\n"); 
		query.append("            BKG_RATE B," ).append("\n"); 
		query.append("            BKG_CHG_RT C" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)  " ).append("\n"); 
		query.append(" AND        A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append(" GROUP BY   A.BKG_NO, B.RT_BL_TP_CD) RATE," ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, " ).append("\n"); 
		query.append("            DECODE(A.BB_CGO_FLG ,'Y',1,NVL(COUNT(B.CNTR_NO), 0)) CNTR_CNT" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append(" GROUP BY   A.BKG_NO, A.BB_CGO_FLG) CNTR," ).append("\n"); 
		query.append("(SELECT     A.BKG_NO, " ).append("\n"); 
		query.append("            DECODE(NVL(CUST_NM, '*'), '*', 0, 1) CUST_CNT" ).append("\n"); 
		query.append(" FROM       BKG_BOOKING A, BKG_CUSTOMER B" ).append("\n"); 
		query.append(" WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append(" AND        BKG_CUST_TP_CD(+) = 'C') CUST	" ).append("\n"); 
		query.append("WHERE   BKG.BKG_NO = @[bkg_no]			" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CHG_IND.BKG_NO			" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = MK_IND.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CHG_PPD_IND.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CHG_PPD_THIRD_IND.BKG_NO" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = MND.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CUST.BKG_NO(+)" ).append("\n"); 

	}
}