/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdateAssignVvdMasterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.17 
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

public class ProductCatalogCreateDBDAOUpdateAssignVvdMasterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateAssignVvdMaster
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdateAssignVvdMasterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdateAssignVvdMasterUSQL").append("\n"); 
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
		query.append("SET" ).append("\n"); 
		query.append("trnk_vsl_cd = SUBSTR(@[vvd],1,4)," ).append("\n"); 
		query.append("trnk_skd_voy_no = SUBSTR(@[vvd],5,4)," ).append("\n"); 
		query.append("trnk_skd_dir_cd = SUBSTR(@[vvd],9,1)," ).append("\n"); 
		query.append("upd_dt = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("pctl_no IN (SELECT pctl_no FROM bkg_booking WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("UNION -- COP HDR의 모든 PCTL NO 에도 VVD UPDATE" ).append("\n"); 
		query.append("SELECT DISTINCT pctl_no FROM sce_cop_hdr" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no])" ).append("\n"); 

	}
}