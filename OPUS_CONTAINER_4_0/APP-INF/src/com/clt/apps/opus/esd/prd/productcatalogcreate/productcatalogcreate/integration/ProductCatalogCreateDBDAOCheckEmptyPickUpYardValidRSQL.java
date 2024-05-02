/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCheckEmptyPickUpYardValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCheckEmptyPickUpYardValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkEmptyPickUpYardValid
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCheckEmptyPickUpYardValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_yd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCheckEmptyPickUpYardValidRSQL").append("\n"); 
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
		query.append("SELECT COUNT(YD_CD) CNT" ).append("\n"); 
		query.append("	FROM MDM_YARD X" ).append("\n"); 
		query.append(" WHERE X.YD_CD = @[chk_yd]" ).append("\n"); 
		query.append("	 AND (X.YD_FCTY_TP_MRN_TML_FLG = 'Y' OR X.YD_FCTY_TP_CY_FLG = 'Y' OR X.YD_FCTY_TP_RAIL_RMP_FLG = 'Y')" ).append("\n"); 
		query.append("	 AND X.DELT_FLG = 'N'" ).append("\n"); 

	}
}