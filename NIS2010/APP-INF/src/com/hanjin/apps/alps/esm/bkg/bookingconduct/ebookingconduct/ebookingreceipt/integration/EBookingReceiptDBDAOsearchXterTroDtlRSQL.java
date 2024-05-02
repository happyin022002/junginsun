/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.26
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.08.26 윤용상
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

public class EBookingReceiptDBDAOsearchXterTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterTroDtl
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterTroDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterTroDtlRSQL").append("\n"); 
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
		query.append("SELECT b.TRO_SEQ" ).append("\n"); 
		query.append("        , b.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , b.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , b.CNTR_QTY" ).append("\n"); 
		query.append("        , b.DOR_RQST_DT" ).append("\n"); 
		query.append("		, b.BKG_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, b.DOR_ADDR_TP_CD" ).append("\n"); 
		query.append("        , a.cntr_rtn_yd_cd" ).append("\n"); 
		query.append("        , a.cntr_rtn_dt" ).append("\n"); 
		query.append("FROM BKG_XTER_TRO_DTL b, BKG_XTER_TRO a" ).append("\n"); 
		query.append(" WHERE b.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND b.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND b.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("   and a.XTER_SNDR_ID = b.XTER_SNDR_ID" ).append("\n"); 
		query.append("   and a.XTER_RQST_NO = b.XTER_RQST_NO" ).append("\n"); 
		query.append("   and a.XTER_RQST_SEQ= b.XTER_RQST_SEQ" ).append("\n"); 
		query.append("   and a.tro_seq = b.tro_seq" ).append("\n"); 

	}
}