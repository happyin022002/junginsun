/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBkgReferenceInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.14 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchBkgReferenceInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Reference 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBkgReferenceInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchBkgReferenceInterfaceRSQL").append("\n"); 
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
		query.append("SELECT 'FINV' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(FINV.INV_REF_NO, RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST FINV, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE FINV.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND FINV.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND FINV.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND FINV.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'FINV' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'EBRF' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(DECODE(DOC_TP_CD,'B',XTER_RQST_NO), RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST EBRF, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE EBRF.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND EBRF.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND EBRF.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND EBRF.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'EBRF' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'EBSH' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(DECODE(DOC_TP_CD,'B',DECODE(XTER_SNDR_ID,'SEANACCS',CUST_REF_NO, SHPR_REF_NO)), RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST EBSH, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE EBSH.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND EBSH.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND EBSH.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND EBSH.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'EBSH' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'EBFF' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(DECODE(DOC_TP_CD,'B',FWRD_REF_NO), RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST EBFF, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE EBFF.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND EBFF.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND EBFF.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND EBFF.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'EBFF' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ESRF' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(DECODE(DOC_TP_CD,'S', XTER_RQST_NO), RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST ESRF, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE ESRF.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND ESRF.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND ESRF.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND ESRF.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'ESRF' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ESSH' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(DECODE(DOC_TP_CD,'S',DECODE(XTER_SNDR_ID,'SEANACCS',CUST_REF_NO, SHPR_REF_NO)), RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST ESSH, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE ESSH.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND ESSH.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND ESSH.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND ESSH.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'ESSH' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ESFF' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(DECODE(DOC_TP_CD,'S',FWRD_REF_NO), RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST ESFF, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE ESFF.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND ESFF.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND ESFF.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND ESFF.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'ESFF' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'RGBK' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       RF.CUST_REF_NO_CTNT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST RGBK, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE RGBK.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND RGBK.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND RGBK.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND RGBK.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'RGBK' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'XMRN' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       NVL(XMRN.XPT_MRN_NO, RF.CUST_REF_NO_CTNT) CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST XMRN, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE XMRN.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XMRN.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XMRN.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND XMRN.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'XMRN' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'FMCN' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       RF.CUST_REF_NO_CTNT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST XMRN, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE XMRN.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XMRN.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XMRN.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND XMRN.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'FMCN' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'FFNO' BKG_REF_TP_CD, " ).append("\n"); 
		query.append("       RF.CUST_REF_NO_CTNT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST XMRN, BKG_REFERENCE RF" ).append("\n"); 
		query.append("WHERE XMRN.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XMRN.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XMRN.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND XMRN.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'FFNO' = RF.BKG_REF_TP_CD(+)" ).append("\n"); 

	}
}