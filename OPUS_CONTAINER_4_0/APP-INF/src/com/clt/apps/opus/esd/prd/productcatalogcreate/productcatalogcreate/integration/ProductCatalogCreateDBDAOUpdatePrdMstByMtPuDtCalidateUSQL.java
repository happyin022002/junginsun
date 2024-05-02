/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdatePrdMstByMtPuDtCalidateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.30 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOUpdatePrdMstByMtPuDtCalidateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdMstByMtPuDtCalidate
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdatePrdMstByMtPuDtCalidateUSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdatePrdMstByMtPuDtCalidateUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("SET PCTL_NO = 'X'|| SUBSTR(PCTL_NO,2)" ).append("\n"); 
		query.append("WHERE NOT EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X' FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND PCTL_NO = @[pctl_no]" ).append("\n"); 

	}
}