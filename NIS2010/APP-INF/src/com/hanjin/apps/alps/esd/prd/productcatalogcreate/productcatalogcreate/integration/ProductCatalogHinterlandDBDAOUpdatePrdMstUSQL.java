/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOUpdatePrdMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogHinterlandDBDAOUpdatePrdMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogHinterlandDBDAOUpdatePrdMstUSQL
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOUpdatePrdMstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOUpdatePrdMstUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("SET MTY_PKUP_YD_CD = REGEXP_REPLACE(MTY_PKUP_YD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",POR_CD = REGEXP_REPLACE(POR_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",POR_NOD_CD = REGEXP_REPLACE(POR_NOD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",FULL_RTN_YD_CD = REGEXP_REPLACE(FULL_RTN_YD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",FULL_PKUP_YD_CD= REGEXP_REPLACE(FULL_PKUP_YD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",POL_CD = REGEXP_REPLACE(POL_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",POL_NOD_CD = REGEXP_REPLACE(POL_NOD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",POD_CD = REGEXP_REPLACE(POD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",POD_NOD_CD = REGEXP_REPLACE(POD_NOD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",DEL_CD = REGEXP_REPLACE(DEL_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",DEL_NOD_CD = REGEXP_REPLACE(DEL_NOD_CD,'USLGB.*','')" ).append("\n"); 
		query.append(",MTY_RTN_YD_CD = REGEXP_REPLACE(MTY_RTN_YD_CD,'USLGB.*','')" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] || '%')" ).append("\n"); 

	}
}