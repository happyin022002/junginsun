/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAORataBkgQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAORataBkgQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BLDocumentationCMDBDAORataBkgQtyRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAORataBkgQtyRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      'BKG' CATEGORY" ).append("\n"); 
		query.append(",      sum(decode(DRY_CGO_FLG, 'Y', OP_CNTR_QTY, 0)) DRY_CGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(DCGO_FLG, 'Y', OP_CNTR_QTY, 0)) DCGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(RC_FLG, 'Y', OP_CNTR_QTY, 0)) RC_FLG" ).append("\n"); 
		query.append(",      sum(decode(AWK_CGO_FLG, 'Y', OP_CNTR_QTY, 0)) AWK_CGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(BB_CGO_FLG, 'Y', OP_CNTR_QTY, 0)) BB_CGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(CRR_HNGR_SGL_BAR_USE_FLG, 'Y', OP_CNTR_QTY, 0)) +" ).append("\n"); 
		query.append("sum(decode(CRR_HNGR_DBL_BAR_USE_FLG, 'Y', OP_CNTR_QTY, 0)) +" ).append("\n"); 
		query.append("sum(decode(CRR_HNGR_TPL_BAR_USE_FLG, 'Y', OP_CNTR_QTY, 0)) +" ).append("\n"); 
		query.append("sum(decode(MER_HNGR_FLG, 'Y', OP_CNTR_QTY, 0)) HNGR_FLG" ).append("\n"); 
		query.append(",      sum(decode(SOC_FLG, 'Y', OP_CNTR_QTY, 0)) SOC_FLG" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'Y', OP_CNTR_QTY, 0)) RCV_TERM_Y" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'D', OP_CNTR_QTY, 0)) RCV_TERM_D" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'S', OP_CNTR_QTY, 0)) RCV_TERM_S" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'T', OP_CNTR_QTY, 0)) RCV_TERM_T" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'I', OP_CNTR_QTY, 0)) RCV_TERM_I" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'Y', OP_CNTR_QTY, 0)) DE_TERM_Y" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'D', OP_CNTR_QTY, 0)) DE_TERM_D" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'S', OP_CNTR_QTY, 0)) DE_TERM_S" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'T', OP_CNTR_QTY, 0)) DE_TERM_T" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'O', OP_CNTR_QTY, 0)) DE_TERM_O" ).append("\n"); 
		query.append(",      sum(OP_CNTR_QTY) OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM   (SELECT DECODE(A.FLEX_HGT_FLG, 'Y', DECODE(B.CNTR_TPSZ_CD, 'D5', 'D4', B.CNTR_TPSZ_CD), B.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      B.DRY_CGO_FLG" ).append("\n"); 
		query.append(",      B.DCGO_FLG" ).append("\n"); 
		query.append(",      B.RC_FLG" ).append("\n"); 
		query.append(",      B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      B.BB_CGO_FLG" ).append("\n"); 
		query.append(",      B.CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append(",      B.CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append(",      B.CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append(",      B.MER_HNGR_FLG" ).append("\n"); 
		query.append(",      B.SOC_FLG" ).append("\n"); 
		query.append(",      B.RCV_TERM_CD" ).append("\n"); 
		query.append(",      B.DE_TERM_CD" ).append("\n"); 
		query.append(",      B.OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS A, BKG_QTY_DTL_HIS B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    B.CNTR_TPSZ_CD NOT LIKE 'Q%')" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      'BKG' CATEGORY" ).append("\n"); 
		query.append(",      sum(decode(DRY_CGO_FLG, 'Y', OP_CNTR_QTY, 0)) DRY_CGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(DCGO_FLG, 'Y', OP_CNTR_QTY, 0)) DCGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(RC_FLG, 'Y', OP_CNTR_QTY, 0)) RC_FLG" ).append("\n"); 
		query.append(",      sum(decode(AWK_CGO_FLG, 'Y', OP_CNTR_QTY, 0)) AWK_CGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(BB_CGO_FLG, 'Y', OP_CNTR_QTY, 0)) BB_CGO_FLG" ).append("\n"); 
		query.append(",      sum(decode(CRR_HNGR_SGL_BAR_USE_FLG, 'Y', OP_CNTR_QTY, 0)) +" ).append("\n"); 
		query.append("sum(decode(CRR_HNGR_DBL_BAR_USE_FLG, 'Y', OP_CNTR_QTY, 0)) +" ).append("\n"); 
		query.append("sum(decode(CRR_HNGR_TPL_BAR_USE_FLG, 'Y', OP_CNTR_QTY, 0)) +" ).append("\n"); 
		query.append("sum(decode(MER_HNGR_FLG, 'Y', OP_CNTR_QTY, 0)) HNGR_FLG" ).append("\n"); 
		query.append(",      sum(decode(SOC_FLG, 'Y', OP_CNTR_QTY, 0)) SOC_FLG" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'Y', OP_CNTR_QTY, 0)) RCV_TERM_Y" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'D', OP_CNTR_QTY, 0)) RCV_TERM_D" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'S', OP_CNTR_QTY, 0)) RCV_TERM_S" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'T', OP_CNTR_QTY, 0)) RCV_TERM_T" ).append("\n"); 
		query.append(",      sum(decode(RCV_TERM_CD, 'I', OP_CNTR_QTY, 0)) RCV_TERM_I" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'Y', OP_CNTR_QTY, 0)) DE_TERM_Y" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'D', OP_CNTR_QTY, 0)) DE_TERM_D" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'S', OP_CNTR_QTY, 0)) DE_TERM_S" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'T', OP_CNTR_QTY, 0)) DE_TERM_T" ).append("\n"); 
		query.append(",      sum(decode(DE_TERM_CD, 'O', OP_CNTR_QTY, 0)) DE_TERM_O" ).append("\n"); 
		query.append(",      sum(OP_CNTR_QTY) OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM   (SELECT DECODE(A.FLEX_HGT_FLG, 'Y', DECODE(B.CNTR_TPSZ_CD, 'D5', 'D4', B.CNTR_TPSZ_CD), B.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      B.DRY_CGO_FLG" ).append("\n"); 
		query.append(",      B.DCGO_FLG" ).append("\n"); 
		query.append(",      B.RC_FLG" ).append("\n"); 
		query.append(",      B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      B.BB_CGO_FLG" ).append("\n"); 
		query.append(",      B.CRR_HNGR_SGL_BAR_USE_FLG" ).append("\n"); 
		query.append(",      B.CRR_HNGR_DBL_BAR_USE_FLG" ).append("\n"); 
		query.append(",      B.CRR_HNGR_TPL_BAR_USE_FLG" ).append("\n"); 
		query.append(",      B.MER_HNGR_FLG" ).append("\n"); 
		query.append(",      B.SOC_FLG" ).append("\n"); 
		query.append(",      B.RCV_TERM_CD" ).append("\n"); 
		query.append(",      B.DE_TERM_CD" ).append("\n"); 
		query.append(",      B.OP_CNTR_QTY" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_QTY_DTL B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    B.CNTR_TPSZ_CD NOT LIKE 'Q%')" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}