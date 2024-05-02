/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPortCctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.13 
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

public class ProductCatalogCreateDBDAOSearchPortCctRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPortCct
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPortCctRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPortCctRSQL").append("\n"); 
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
		query.append("SELECT 		DISTINCT TO_CHAR(PRD_COMMON_PKG.PRD_GET_CCT_BY_PC_FNC(@[pctl_no]),'yyyy-mm-dd HH24:MI') CCT" ).append("\n"); 
		query.append("		,	M.DG_SPCL_FLG" ).append("\n"); 
		query.append("		,	M.RF_SPCL_FLG" ).append("\n"); 
		query.append("		,	M.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("		,	D.ORG_NOD_CD PORT" ).append("\n"); 
		query.append("FROM 		PRD_PROD_CTL_MST 			M" ).append("\n"); 
		query.append("		,	PRD_PROD_CTL_ROUT_DTL 		D" ).append("\n"); 
		query.append("		,	VSK_VSL_PORT_SKD 			S" ).append("\n"); 
		query.append("WHERE 		M.PCTL_NO 					= @[pctl_no] --'B0912210000296960001'" ).append("\n"); 
		query.append("AND 		M.PCTL_NO 					= D.PCTL_NO" ).append("\n"); 
		query.append("AND 		D.PCTL_IO_BND_CD 			= 'T'" ).append("\n"); 
		query.append("AND 		D.TRSP_MOD_CD 				IN ('WD','VD')" ).append("\n"); 
		query.append("AND 		SUBSTR(D.ORG_NOD_CD, 1, 5) 	= M.POL_CD" ).append("\n"); 
		query.append("AND 		S.VSL_CD		(+) 		= D.VSL_CD" ).append("\n"); 
		query.append("AND 		S.SKD_VOY_NO	(+) 		= D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 		S.SKD_DIR_CD	(+) 		= D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 		S.CLPT_IND_SEQ	(+) 		= D.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND 		S.YD_CD			(+) 		= D.ORG_NOD_CD" ).append("\n"); 

	}
}