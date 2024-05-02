/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcombineBkgQtyDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
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

public class GeneralBookingReceiptDBDAOcombineBkgQtyDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * combineBkgQtyDtl
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcombineBkgQtyDtlRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOcombineBkgQtyDtlRSQL").append("\n"); 
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
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , RCV_TERM_CD " ).append("\n"); 
		query.append("        , DE_TERM_CD" ).append("\n"); 
		query.append("        , EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , SUM(OP_CNTR_QTY) OP_CNTR_QTY" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(AWK_CGO_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END AWK_CGO_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(DCGO_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END DCGO_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(RC_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END RC_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(BB_CGO_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END BB_CGO_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(SOC_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END SOC_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(CRR_HNGR_SGL_BAR_USE_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(DRY_CGO_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END DRY_CGO_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(CRR_HNGR_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END CRR_HNGR_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(MER_HNGR_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END MER_HNGR_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SUM(DECODE(CRR_HNGR_TPL_BAR_USE_FLG,'Y',1,'N',0)) = 0 THEN 'N' ELSE 'Y' END CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append("  FROM BKG_QTY_DTL" ).append("\n"); 
		query.append(" WHERE BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${bkg_no} in ${bkg_no_list}) " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" GROUP BY CNTR_TPSZ_CD, RCV_TERM_CD, DE_TERM_CD, EQ_SUBST_CNTR_TPSZ_CD" ).append("\n"); 

	}
}