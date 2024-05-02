/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterTroDtlForAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.22 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterTroDtlForAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confrim edi 중 tro dtl 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterTroDtlForAckRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterTroDtlForAckRSQL").append("\n"); 
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
		query.append("select  '{I_BKG_TRO_DTL'                            ||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRD_SEQ:'       || TRO_SEQ	            ||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRO_SUBSEQ:'    || TRO_SUB_SEQ		    ||CHR(10)||" ).append("\n"); 
		query.append("'IB_CNTRTS_CD:'     || CNTR_TPSZ_CD		    ||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRD_QTY:'       || CNTR_QTY 	        ||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRO_REQ_DT:'    || TO_CHAR(DOR_RQST_DT,'YYYYMMDDHH24MI')||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRD_IND:'       || BKG_TRSP_MOD_CD		||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRO_PICKUP_LOC:'|| PKUP_LOC_CD	        ||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRO_CUST_REF:'  || CUST_REF_NO	        ||CHR(10)||" ).append("\n"); 
		query.append("'IB_TRO_PICKUP_CY:' || PKUP_YD_CD           ||CHR(10)||" ).append("\n"); 
		query.append("'}I_BKG_TRO_DTL'                            ||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("from bkg_xter_tro_dtl" ).append("\n"); 
		query.append("where XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}