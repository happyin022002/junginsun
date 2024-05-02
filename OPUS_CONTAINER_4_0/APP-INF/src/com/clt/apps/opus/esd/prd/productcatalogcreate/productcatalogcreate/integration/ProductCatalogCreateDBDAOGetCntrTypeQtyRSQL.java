/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOGetCntrTypeQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.04 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOGetCntrTypeQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetCntrTypeQty
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOGetCntrTypeQtyRSQL(){
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
		params.put("cop_map_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOGetCntrTypeQtyRSQL").append("\n"); 
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
		query.append("SELECT cntr_tpsz_cd,count(*) qty" ).append("\n"); 
		query.append("FROM PRD_BKG_COP_MAP H" ).append("\n"); 
		query.append("WHERE H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and h.COP_MAPG_SEQ = @[cop_map_seq]" ).append("\n"); 
		query.append("AND H.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND H.CRNT_FLG NOT IN ('X','O')" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}