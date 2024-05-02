/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EbookingReceiptDBDAOSearchXterTroDtlForBOKCONRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EbookingReceiptDBDAOSearchXterTroDtlForBOKCONRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * e-bkg receipt BOKCON flat file 생성을 위해 Tro detail 정보를 조회한다.
	  * </pre>
	  */
	public EbookingReceiptDBDAOSearchXterTroDtlForBOKCONRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EbookingReceiptDBDAOSearchXterTroDtlForBOKCONRSQL").append("\n"); 
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
		query.append("--searchXterTroDtlForAck" ).append("\n"); 
		query.append("SELECT  '{I_BKG_TRO_DTL'                                                ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRD_SEQ:'       || NVL(T.TRO_SEQ,           X.TRO_SEQ)	    ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_SUBSEQ:'    || NVL(T.TRO_SUB_SEQ,       X.TRO_SUB_SEQ)  ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_CNTRTS_CD:'     || NVL(T.CNTR_TPSZ_CD,      X.CNTR_TPSZ_CD) ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRD_QTY:'       || NVL(T.TRO_QTY,           X.CNTR_QTY) 	||CHR(10)||	" ).append("\n"); 
		query.append("        'IB_TRO_REQ_DT:'    || TO_CHAR(NVL(T.DOR_ARR_DT,X.DOR_RQST_DT),'YYYYMMDDHH24MI')||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRD_IND:'       || NVL(T.BKG_TRSP_MZD_CD,   X.BKG_TRSP_MOD_CD)	||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_PICKUP_LOC:'|| NVL(T.PKUP_LOC_CD,       X.PKUP_LOC_CD)      ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_CUST_REF:'  || CUST_REF_NO	                                ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_PICKUP_CY:' || NVL(X.PKUP_YD_CD,        T.PKUP_YD_CD)       ||CHR(10)||" ).append("\n"); 
		query.append("        '}I_BKG_TRO_DTL'                                                ||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("  FROM BKG_XTER_TRO_DTL X," ).append("\n"); 
		query.append("       (SELECT D.TRO_SEQ, " ).append("\n"); 
		query.append("               D.TRO_SUB_SEQ," ).append("\n"); 
		query.append("               D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               D.TRO_QTY," ).append("\n"); 
		query.append("               D.DOR_ARR_DT," ).append("\n"); 
		query.append("               '' BKG_TRSP_MZD_CD," ).append("\n"); 
		query.append("               D.PKUP_LOC_CD," ).append("\n"); 
		query.append("               D.PKUP_YD_CD" ).append("\n"); 
		query.append("        FROM BKG_TRO T, BKG_TRO_DTL D" ).append("\n"); 
		query.append("        WHERE T.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND T.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("        AND T.RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("        AND T.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("        AND T.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("        AND T.RTN_TRO_FLG = D.RTN_TRO_FLG" ).append("\n"); 
		query.append("        AND T.TRO_SEQ = D.TRO_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT D.TRO_SEQ, " ).append("\n"); 
		query.append("               D.TRO_SUB_SEQ," ).append("\n"); 
		query.append("               T.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               1 TRO_QTY," ).append("\n"); 
		query.append("               D.ARR_DT DOR_ARR_DT," ).append("\n"); 
		query.append("               T.BKG_TRSP_MZD_CD," ).append("\n"); 
		query.append("               SUBSTR(T.CNTR_PKUP_YD_CD,1,5) PKUP_LOC_CD," ).append("\n"); 
		query.append("               T.CNTR_PKUP_YD_CD PKUP_YD_CD" ).append("\n"); 
		query.append("        FROM BKG_EUR_TRO T, BKG_EUR_TRO_DTL D" ).append("\n"); 
		query.append("        WHERE T.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND T.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("        AND T.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("        AND T.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("        AND T.TRO_SEQ = D.TRO_SEQ) T" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   AND X.TRO_SEQ = T.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND X.TRO_SUB_SEQ = T.TRO_SUB_SEQ(+)" ).append("\n"); 

	}
}