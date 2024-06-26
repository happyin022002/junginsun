/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchSIBkgQtyDtlInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.19 Do Soon Choi
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

public class EBookingReceiptDBDAOSearchSIBkgQtyDtlInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchSIBkgQtyDtlInterfaceRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchSIBkgQtyDtlInterfaceRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("     SUBST_SEQ, " ).append("\n"); 
		query.append("     RCV_TERM_CD, " ).append("\n"); 
		query.append("     DE_TERM_CD, " ).append("\n"); 
		query.append("     DRY_CGO_FLG, " ).append("\n"); 
		query.append("     OP_CNTR_QTY, " ).append("\n"); 
		query.append("     AWK_CGO_FLG, " ).append("\n"); 
		query.append("     DCGO_FLG, " ).append("\n"); 
		query.append("     RC_FLG, " ).append("\n"); 
		query.append("     BB_CGO_FLG, " ).append("\n"); 
		query.append("     SOC_FLG, " ).append("\n"); 
		query.append("     MER_HNGR_FLG, " ).append("\n"); 
		query.append("     CRR_HNGR_FLG, " ).append("\n"); 
		query.append("     CRR_HNGR_SGL_BAR_USE_FLG, " ).append("\n"); 
		query.append("     CRR_HNGR_DBL_BAR_USE_FLG, " ).append("\n"); 
		query.append("     CRR_HNGR_TPL_BAR_USE_FLG, " ).append("\n"); 
		query.append("     EQ_SUBST_CNTR_TPSZ_CD " ).append("\n"); 
		query.append("FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}