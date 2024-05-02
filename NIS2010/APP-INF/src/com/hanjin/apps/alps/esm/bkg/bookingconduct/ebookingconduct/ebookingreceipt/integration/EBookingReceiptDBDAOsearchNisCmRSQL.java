/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchNisCmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.11
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.01.11 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchNisCmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNisCm
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchNisCmRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchNisCmRSQL").append("\n"); 
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
		query.append("SELECT  CM.CNTR_NO" ).append("\n"); 
		query.append("      , CM.PCK_QTY" ).append("\n"); 
		query.append("      , CM.PCK_TP_CD" ).append("\n"); 
		query.append("      , CM.CNTR_MF_WGT" ).append("\n"); 
		query.append("      , CM.WGT_UT_CD" ).append("\n"); 
		query.append("      , CM.MEAS_QTY" ).append("\n"); 
		query.append("      , CM.MEAS_UT_CD" ).append("\n"); 
		query.append("      , CM.CNTR_MF_SEQ CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , NVL(CM.HAMO_TRF_CD, ' ') HAMO_TRF_CD" ).append("\n"); 
		query.append("      , NVL(CM.NCM_NO, '  ') NCM_NO" ).append("\n"); 
		query.append("      , NVL(REF.CUST_REF_NO_CTNT, '   ') PO_NO" ).append("\n"); 
		query.append("      , '  ' CNTR_MF_DTL_DESC" ).append("\n"); 
		query.append("      , CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("      , CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("	  , CM.CNTR_MF_NO" ).append("\n"); 
		query.append("	  , CM.DCGO_SEQ" ).append("\n"); 
		query.append("	  , NVL(CM.CMDT_HS_CD, ' ') CMDT_HS_CD" ).append("\n"); 
		query.append("      , ( SELECT CNTR_TPSZ_CD FROM BKG_CONTAINER C WHERE C.BKG_NO = CM.BKG_NO AND C.CNTR_NO = CM.CNTR_NO AND ROWNUM <= 1 ) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , NVL(BKG_JOIN_FNC(CURSOR( SELECT  DTL.NCM_NO" ).append("\n"); 
		query.append("                                 FROM    BKG_CNTR_MF_DESC_DTL DTL" ).append("\n"); 
		query.append("                                 WHERE   DTL.BKG_NO = CM.BKG_NO" ).append("\n"); 
		query.append("                                 AND     DTL.CNTR_NO = CM.CNTR_NO" ).append("\n"); 
		query.append("                                 AND     DTL.CNTR_MF_SEQ = CM.CNTR_MF_SEQ" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                        ),CM.NCM_NO    ) NCM_MULTI_NO" ).append("\n"); 
		query.append("	  , WPM_TRT_CD" ).append("\n"); 
		query.append("FROM    BKG_CNTR_MF_DESC CM, BKG_REFERENCE REF" ).append("\n"); 
		query.append("WHERE   CM.BKG_NO        = REF.BKG_NO        (+)" ).append("\n"); 
		query.append("AND     CM.CNTR_MF_SEQ   = REF.CNTR_MF_SEQ   (+)" ).append("\n"); 
		query.append("AND     'CMPO'           = REF.BKG_REF_TP_CD (+)" ).append("\n"); 
		query.append("AND     CM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("        CM.CNTR_NO" ).append("\n"); 
		query.append("      , CM.CNTR_MF_SEQ" ).append("\n"); 
		query.append("      , CM.PCK_QTY" ).append("\n"); 
		query.append("      , CM.CNTR_MF_WGT" ).append("\n"); 
		query.append("      , CM.MEAS_QTY" ).append("\n"); 
		query.append("      , CM.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("      , CM.CNTR_MF_GDS_DESC" ).append("\n"); 

	}
}