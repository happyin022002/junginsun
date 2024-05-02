/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusQtyRSQL.java
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

public class EBookingReceiptDBDAOsearchOpusQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusQty
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusQtyRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchOpusQtyRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	OP_CNTR_QTY" ).append("\n"); 
		query.append(",	ACT_CNTR_QTY" ).append("\n"); 
		query.append(",	DCGO_QTY" ).append("\n"); 
		query.append(",	AWK_CGO_QTY" ).append("\n"); 
		query.append(",	RC_QTY" ).append("\n"); 
		query.append(",	BB_CGO_QTY" ).append("\n"); 
		query.append(",	SOC_QTY" ).append("\n"); 
		query.append(",	EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append(",	MER_HNGR_QTY" ).append("\n"); 
		query.append(",	CRR_HNGR_QTY" ).append("\n"); 
		query.append(",	CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append(",	CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append(",	CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append(",	ORG_CNTR_QTY" ).append("\n"); 
		query.append(",	DEST_CNTR_QTY" ).append("\n"); 
		query.append(",	OB_TRO_QTY" ).append("\n"); 
		query.append(",	IB_TRO_QTY" ).append("\n"); 
		query.append(",	FLEX_HGT_FLG" ).append("\n"); 
		query.append("from bkg_quantity" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}