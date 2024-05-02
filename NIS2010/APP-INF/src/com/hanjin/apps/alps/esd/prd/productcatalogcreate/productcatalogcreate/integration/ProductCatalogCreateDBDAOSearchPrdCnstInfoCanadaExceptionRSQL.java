/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdCnstInfoCanadaExceptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchPrdCnstInfoCanadaExceptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogCreateDBDAOSearchPrdCnstInfoCanadaExceptionRSQL
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdCnstInfoCanadaExceptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdCnstInfoCanadaExceptionRSQL").append("\n"); 
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
		query.append("SELECT 'Y' CA_CNST" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST MST , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("WHERE MST.PCTL_NO = DECODE(@[pctl_no], NULL, NULL, @[pctl_no])" ).append("\n"); 
		query.append("AND MST.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("AND 'A' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = MST.POL_CD )" ).append("\n"); 
		query.append("AND (MST.POD_CD LIKE 'US%' OR MST.POD_CD LIKE 'CA%' )" ).append("\n"); 
		query.append("AND MST.DEL_CD LIKE 'CA%'" ).append("\n"); 
		query.append("AND Q.CNTR_TPSZ_CD ='D7'" ).append("\n"); 
		query.append("AND (POD_CD NOT IN ('CAVAN')OR DEL_CD NOT IN ('CAVAN'))" ).append("\n"); 

	}
}