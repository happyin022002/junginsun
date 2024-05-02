/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
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

public class ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRouteInfoByPctlNo
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL(){
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
		query.append("FileName : ProductCatalogCreateDBDAOSearchRouteInfoByPctlNoRSQL").append("\n"); 
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
		query.append("SELECT POR_CD,POL_CD,POD_CD,DEL_CD,CNST_FLG," ).append("\n"); 
		query.append("	(SELECT to_char(ARR_ST_DT,'yyyy-mm-dd') FROM PRD_PROD_CTL_ROUT_DTL P WHERE  P.PCTL_NO = D.PCTL_NO AND MTY_YD_FLG='Y' AND PCTL_IO_BND_CD='O'" ).append("\n"); 
		query.append("	) MT_PU_DATE," ).append("\n"); 
		query.append("	(SELECT to_char(MAX(ARR_ST_DT),'yyyy-mm-dd') FROM PRD_PROD_CTL_ROUT_DTL P WHERE  P.PCTL_NO = D.PCTL_NO AND PCTL_IO_BND_CD='I' AND NOD_LNK_DIV_CD = 'N' AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("	) EST_ARR_DATE," ).append("\n"); 
		query.append("	LTRIM (TO_CHAR (TRUNC (TTL_TZTM_HRS / 24, 0), '00'))  TRANSIT_DAY," ).append("\n"); 
		query.append("	TTL_EXPN_AMT," ).append("\n"); 
		query.append("    TRUNC(((CML_OCN_TZTM_HRS + CML_INLND_TZTM_HRS)/24)) CML_TZTM_DAY," ).append("\n"); 
		query.append("	PCTL_NO,MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("	( " ).append("\n"); 
		query.append("    	SELECT " ).append("\n"); 
		query.append("    	TO_CHAR(min(ARR_ST_DT), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    	FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("    	WHERE  PCTL_NO = d.PCTL_NO" ).append("\n"); 
		query.append("    	AND TRSP_MOD_CD IN ('WD','VD') " ).append("\n"); 
		query.append("    	AND PCTL_IO_BND_CD = 'T' " ).append("\n"); 
		query.append("    ) LOAD_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST D" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("ORDER BY PCTL_NO" ).append("\n"); 

	}
}