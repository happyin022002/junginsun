/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdatePrdDtlByPseudoVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.01.21 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOUpdatePrdDtlByPseudoVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdDtlByPseudoVvd
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdatePrdDtlByPseudoVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pseudo_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdatePrdDtlByPseudoVvdUSQL").append("\n"); 
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
		query.append("UPDATE prd_prod_ctl_rout_dtl" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("vsl_cd = DECODE(vsl_cd,(SELECT trnk_vsl_cd FROM prd_prod_ctl_mst WHERE pctl_no = @[pctl_no]),subStr(@[pseudo_vvd],1,4),'')," ).append("\n"); 
		query.append("skd_voy_no = DECODE(vsl_cd,(SELECT trnk_vsl_cd FROM prd_prod_ctl_mst WHERE pctl_no = @[pctl_no]),subStr(@[pseudo_vvd],5,4),'')," ).append("\n"); 
		query.append("skd_dir_cd = DECODE(vsl_cd,(SELECT trnk_vsl_cd FROM prd_prod_ctl_mst WHERE pctl_no = @[pctl_no]),subStr(@[pseudo_vvd],9,1),'')" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("AND vsl_cd IS NOT NULL" ).append("\n"); 
		query.append("AND skd_voy_no IS NOT NULL" ).append("\n"); 
		query.append("AND skd_dir_cd IS NOT NULL" ).append("\n"); 

	}
}