/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcombineBkgQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcombineBkgQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * combineBkgQty
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcombineBkgQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcombineBkgQtyRSQL").append("\n"); 
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
		query.append("SELECT @[mst_bkg_no] BKG_NO" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", MAX(EQ_SUBST_CNTR_TPSZ_CD) AS EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", SUM(OP_CNTR_QTY) OP_CNTR_QTY" ).append("\n"); 
		query.append(", SUM(ACT_CNTR_QTY) ACT_CNTR_QTY" ).append("\n"); 
		query.append(", SUM(DCGO_QTY) DCGO_QTY" ).append("\n"); 
		query.append(", SUM(AWK_CGO_QTY) AWK_CGO_QTY" ).append("\n"); 
		query.append(", SUM(RC_QTY) RC_QTY" ).append("\n"); 
		query.append(", SUM(BB_CGO_QTY) BB_CGO_QTY" ).append("\n"); 
		query.append(", SUM(SOC_QTY) SOC_QTY" ).append("\n"); 
		query.append(", SUM(EQ_SUBST_CGO_QTY) EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append(", SUM(MER_HNGR_QTY) MER_HNGR_QTY" ).append("\n"); 
		query.append(", SUM(CRR_HNGR_QTY) CRR_HNGR_QTY" ).append("\n"); 
		query.append(", SUM(CRR_HNGR_SGL_BAR_QTY) CRR_HNGR_SGL_BAR_QTY" ).append("\n"); 
		query.append(", SUM(CRR_HNGR_DBL_BAR_QTY) CRR_HNGR_DBL_BAR_QTY" ).append("\n"); 
		query.append(", SUM(CRR_HNGR_TPL_BAR_QTY) CRR_HNGR_TPL_BAR_QTY" ).append("\n"); 
		query.append(", SUM(ORG_CNTR_QTY) ORG_CNTR_QTY" ).append("\n"); 
		query.append(", SUM(DEST_CNTR_QTY) DEST_CNTR_QTY" ).append("\n"); 
		query.append(", SUM(OB_TRO_QTY) OB_TRO_QTY" ).append("\n"); 
		query.append(", SUM(IB_TRO_QTY) IB_TRO_QTY" ).append("\n"); 
		query.append(", CASE WHEN SUM(DECODE(FLEX_HGT_FLG,'Y',1,'N',0, 0)) = 0 THEN 'N' ELSE 'Y' END FLEX_HGT_FLG" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${bkg_no} in ${bkg_no_list})" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}