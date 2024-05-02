/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCheckBkgQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.08
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2010.09.08 박만건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCheckBkgQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bkg 수량과 type을 가져온다.
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCheckBkgQtyRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCheckBkgQtyRSQL").append("\n"); 
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
		query.append("-- Booking에서 Booking Quantity가 저장되던 저장되지 않던 반드시 제공되어야 하는데" ).append("\n"); 
		query.append("-- Flex Height처리시 경우에 따라서 Booking에서 Quantity를 제공하지 않는 경우가 있다." ).append("\n"); 
		query.append("-- 해당 경우 PRD에서 저장되어있는 Booking Quantity를 조회해서 Application 구동 오류가 발생하지 않도록 처리한다." ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD AS C_TPSZ," ).append("\n"); 
		query.append("       OP_CNTR_QTY AS C_QTY" ).append("\n"); 
		query.append("FROM BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}