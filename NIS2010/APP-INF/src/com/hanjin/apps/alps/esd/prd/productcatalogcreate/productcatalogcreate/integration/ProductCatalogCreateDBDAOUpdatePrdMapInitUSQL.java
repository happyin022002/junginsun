/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdatePrdMapInitUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.13 
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

public class ProductCatalogCreateDBDAOUpdatePrdMapInitUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdMapInit
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdatePrdMapInitUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_list",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdatePrdMapInitUSQL").append("\n"); 
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
		query.append("UPDATE PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("SET CRNT_FLG='N'" ).append("\n"); 
		query.append("WHERE BKG_NO IN " ).append("\n"); 
		query.append("          ( SELECT @[bkg_no] AS BKG_NO FROM DUAL" ).append("\n"); 
		query.append("           UNION ALL" ).append("\n"); 
		query.append("            SELECT COLUMN_VALUE AS BKG_NO " ).append("\n"); 
		query.append("              FROM TABLE(SELECT BKG_SPLIT_FNC(@[bkg_no_list], ',') BKG_NO_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("-- transaction이 실패할 수 있으므로 이를 보완하기 위해 처리" ).append("\n"); 

	}
}