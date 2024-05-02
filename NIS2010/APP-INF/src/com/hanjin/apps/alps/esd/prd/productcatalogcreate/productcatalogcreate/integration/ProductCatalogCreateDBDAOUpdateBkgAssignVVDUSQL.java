/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdateBkgAssignVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.16 
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

public class ProductCatalogCreateDBDAOUpdateBkgAssignVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateBkgAssignVVD
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdateBkgAssignVVDUSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdateBkgAssignVVDUSQL").append("\n"); 
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
		query.append("UPDATE prd_prod_ctl_rout_dtl D" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("vsl_cd      = SUBSTR(@[vvd],1,4)," ).append("\n"); 
		query.append("skd_voy_no  = SUBSTR(@[vvd],5,4)," ).append("\n"); 
		query.append("skd_dir_cd  = SUBSTR(@[vvd],9,1)," ).append("\n"); 
		query.append("vsl_slan_cd = ( SELECT slan_cd FROM vsk_vsl_port_skd" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("vsl_cd     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND skd_voy_no = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND skd_dir_cd = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND ROWNUM = 1 )," ).append("\n"); 
		query.append("crr_cd = ( SELECT crr_cd FROM mdm_vsl_cntr" ).append("\n"); 
		query.append("WHERE vsl_cd = SUBSTR(@[vvd],1,4))," ).append("\n"); 
		query.append("upd_dt = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("D.pctl_no IN (SELECT pctl_no FROM bkg_booking WHERE bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("UNION -- COP HDR의 모든 PCTL NO 에도 VVD UPDATE" ).append("\n"); 
		query.append("SELECT DISTINCT pctl_no FROM sce_cop_hdr" ).append("\n"); 
		query.append("WHERE bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("AND SUBSTR(D.dest_nod_cd, 1, 5) = @[port]" ).append("\n"); 
		query.append("AND D.nod_lnk_div_cd = 'L'" ).append("\n"); 
		query.append("AND D.trsp_mod_cd IN ('WD','VD')" ).append("\n"); 
		query.append("AND D.pctl_io_bnd_cd = 'T'" ).append("\n"); 

	}
}