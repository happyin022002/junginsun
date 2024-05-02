/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchBkgQtyDtlInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
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

public class EBookingReceiptDBDAOSearchBkgQtyDtlInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchBkgQtyDtlInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchBkgQtyDtlInterfaceRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       DE_TERM_CD," ).append("\n"); 
		query.append("       OP_CNTR_QTY," ).append("\n"); 
		query.append("       DRY_CGO_FLG," ).append("\n"); 
		query.append("       AWK_CGO_FLG," ).append("\n"); 
		query.append("       DCGO_FLG," ).append("\n"); 
		query.append("       RC_FLG," ).append("\n"); 
		query.append("       BB_CGO_FLG," ).append("\n"); 
		query.append("       SOC_FLG," ).append("\n"); 
		query.append("       EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_QTY_DTL Q" ).append("\n"); 
		query.append("WHERE Q.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND Q.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND Q.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 

	}
}