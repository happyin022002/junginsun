/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOCntrRtBkgQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCntrRtBkgQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BlRatingDBDAOCntrRtBkgQtyRSQL(){
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
		query.append("FileName : BlRatingDBDAOCntrRtBkgQtyRSQL").append("\n"); 
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
		query.append("SELECT bkg_no" ).append("\n"); 
		query.append(",      cntr_tpsz_cd" ).append("\n"); 
		query.append(",      op_cntr_qty" ).append("\n"); 
		query.append(",      eq_subst_cntr_tpsz_cd" ).append("\n"); 
		query.append("--,      eq_subst_cgo_qty" ).append("\n"); 
		query.append("FROM   bkg_qty_dtl" ).append("\n"); 
		query.append("WHERE  bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND    eq_subst_cntr_tpsz_cd IS NOT NULL" ).append("\n"); 
		query.append("--AND    eq_subst_cgo_qty > 0" ).append("\n"); 
		query.append("AND    NOT (CNTR_TPSZ_CD LIKE 'R%' AND RC_FLG = 'N')" ).append("\n"); 

	}
}