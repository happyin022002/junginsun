/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOBkgBookingVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.22 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOBkgBookingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOBkgBookingVORSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_vsl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT a.bkg_no," ).append("\n");
		query.append("b.cntr_no," ).append("\n");
		query.append("b.cntr_tpsz_cd," ).append("\n");
		query.append("b.mf_cfm_flg" ).append("\n");
		query.append("FROM   bkg_booking a, bkg_container b" ).append("\n");
		query.append("WHERE  b.bkg_no = a.bkg_no" ).append("\n");
		query.append("AND    a.vsl_cd = @[vvd_vsl]" ).append("\n");
		query.append("AND    a.skd_voy_no = @[vvd_voy]" ).append("\n");
		query.append("AND    a.skd_dir_cd = @[vvd_dir]" ).append("\n");
		query.append("AND    a.bkg_ofc_cd = @[bkg_ofc_cd]" ).append("\n");
		query.append("AND    a.pol_cd = @[bkg_pol]" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${bkg_pod} != '')" ).append("\n");
		query.append("AND    a.pod_cd = @[bkg_pod]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${cfm_flg} != '' && ${cfm_flg} != 'All')" ).append("\n");
		query.append("AND    b.mf_cfm_flg = @[cfm_flg]" ).append("\n");
		query.append("#end" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n");
		query.append("FileName : BLDocumentationBLDBDAOBkgBookingVORSQL").append("\n");
		query.append("*/").append("\n");
	}
}