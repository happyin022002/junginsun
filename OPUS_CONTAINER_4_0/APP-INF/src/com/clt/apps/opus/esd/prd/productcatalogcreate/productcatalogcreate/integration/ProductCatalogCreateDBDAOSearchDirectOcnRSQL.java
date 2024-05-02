/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchDirectOcnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.04.28 정선용
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

public class ProductCatalogCreateDBDAOSearchDirectOcnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDirectOcn
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchDirectOcnRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchDirectOcnRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM PRD_OCN_ROUT O," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT PCTL_NO, ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append("from PRD_PROD_CTL_rout_dtl D--, PRD_OCN_ROUT O" ).append("\n"); 
		query.append("where pctl_no LIKE @[hd_pctl_no]||'%' --'B091210000026871%'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE ROUT_ORG_NOD_CD = ORG_LOC_CD" ).append("\n"); 
		query.append("AND ROUT_DEST_NOD_CD = DEST_LOC_CD" ).append("\n"); 
		query.append("AND T.ROUT_SEQ = O.ROUT_SEQ" ).append("\n"); 
		query.append("ORDER BY LNK_KNT,DECODE(UPD_IND_CD, 'G',1, 'S', 2, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7)" ).append("\n"); 

	}
}