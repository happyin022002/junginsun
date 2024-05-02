/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCheckBeforeBkgSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.04.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCheckBeforeBkgSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transaction이 보장되지 않는 상태에서 bkg split을 처리하기 위한 방안으로
	  * split을 처리하기 전에 sce정보가 변경이 되었는지 확인하여 데이터가 있을 경우 오류 처리를 위한 동작을 수행한다.
	  * 
	  * 이는, 화면에서 2회이상 정상적인 split을 처리할 때에도 동일하게 오류를 발생시키게 처리된다.
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCheckBeforeBkgSplitRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_list",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCheckBeforeBkgSplitRSQL").append("\n"); 
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
		query.append("SELECT MAX(CHK_EXISTS) CHK_EXISTS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT COUNT(1) CHK_EXISTS" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR" ).append("\n"); 
		query.append("    WHERE BKG_NO IN" ).append("\n"); 
		query.append("               ( SELECT COLUMN_VALUE AS BKG_NO " ).append("\n"); 
		query.append("                  FROM TABLE(SELECT BKG_SPLIT_FNC(@[bkg_no_list], ',') BKG_NO_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("     AND BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT(1) CHK_EXISTS" ).append("\n"); 
		query.append("    FROM BKG_BOOKING" ).append("\n"); 
		query.append("    WHERE BKG_NO IN" ).append("\n"); 
		query.append("               ( SELECT COLUMN_VALUE AS BKG_NO " ).append("\n"); 
		query.append("                  FROM TABLE(SELECT BKG_SPLIT_FNC(@[bkg_no_list], ',') BKG_NO_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("     AND BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}