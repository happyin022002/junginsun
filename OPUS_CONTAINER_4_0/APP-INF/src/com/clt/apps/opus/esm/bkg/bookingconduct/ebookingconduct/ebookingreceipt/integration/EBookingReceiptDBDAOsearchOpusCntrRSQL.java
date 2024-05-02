/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchOpusCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusCntr
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusCntrRSQL").append("\n"); 
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
		query.append("SELECT CNTR.BKG_NO" ).append("\n"); 
		query.append(", CNTR.CNTR_NO" ).append("\n"); 
		query.append(", CNTR.CNTR_NO CNTR_NO_OLD" ).append("\n"); 
		query.append(", CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR.CNTR_PRT_FLG" ).append("\n"); 
		query.append(", SEAL.CNTR_SEAL_NO SEAL_NO1" ).append("\n"); 
		query.append(", CNTR.PCK_QTY" ).append("\n"); 
		query.append(", CNTR.PCK_TP_CD" ).append("\n"); 
		query.append(", CNTR.CNTR_WGT" ).append("\n"); 
		query.append(", CNTR.WGT_UT_CD" ).append("\n"); 
		query.append(", CNTR.MEAS_QTY" ).append("\n"); 
		query.append(", CNTR.MEAS_UT_CD" ).append("\n"); 
		query.append(", REF.CUST_REF_NO_CTNT PO_NO" ).append("\n"); 
		query.append(", CNTR.CNTR_CFM_FLG" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR, BKG_CNTR_SEAL_NO SEAL, BKG_REFERENCE REF" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO       = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO      = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("and 1                 = SEAL.CNTR_SEAL_SEQ(+)" ).append("\n"); 
		query.append("AND CNTR.BKG_NO       = REF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'CTPO'            = REF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO      = REF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND CNTR.BKG_NO       = @[bkg_no]" ).append("\n"); 

	}
}