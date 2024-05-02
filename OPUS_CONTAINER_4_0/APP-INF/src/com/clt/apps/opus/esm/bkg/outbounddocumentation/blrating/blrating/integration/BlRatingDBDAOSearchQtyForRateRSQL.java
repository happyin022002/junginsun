/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOSearchQtyForRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.09.01 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchQtyForRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchQtyForRate
	  * </pre>
	  */
	public BlRatingDBDAOSearchQtyForRateRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchQtyForRateRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("OP_CNTR_QTY," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN RC_QTY > 0 OR AWK_CGO_QTY>0 OR BB_CGO_QTY>0 OR DCGO_QTY > 0 THEN 0" ).append("\n"); 
		query.append("ELSE OP_CNTR_QTY" ).append("\n"); 
		query.append("END AS DR_QTY ," ).append("\n"); 
		query.append("RC_QTY," ).append("\n"); 
		query.append("AWK_CGO_QTY," ).append("\n"); 
		query.append("BB_CGO_QTY," ).append("\n"); 
		query.append("DCGO_QTY," ).append("\n"); 
		query.append("(SELECT MIN(IMDG_CLSS_CD) FROM BKG_DG_CGO WHERE BKG_NO = QNT.BKG_NO) AS IMDG_CLSS_CD," ).append("\n"); 
		query.append("EQ_SUBST_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("EQ_SUBST_CGO_QTY," ).append("\n"); 
		query.append("CRR_HNGR_SGL_BAR_QTY," ).append("\n"); 
		query.append("CRR_HNGR_DBL_BAR_QTY," ).append("\n"); 
		query.append("MER_HNGR_QTY" ).append("\n"); 
		query.append("FROM BKG_QUANTITY QNT" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}