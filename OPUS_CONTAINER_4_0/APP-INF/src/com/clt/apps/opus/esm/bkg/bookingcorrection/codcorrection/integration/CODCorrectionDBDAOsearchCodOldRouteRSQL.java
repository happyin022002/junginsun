/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodOldRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.25 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodOldRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodOldRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("codRqstSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodOldRouteRSQL").append("\n"); 
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
		query.append("select vsl_pre_pst_cd" ).append("\n"); 
		query.append(", vsl_seq" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", pol_yd_cd" ).append("\n"); 
		query.append(", pod_yd_cd" ).append("\n"); 
		query.append(", pol_clpt_ind_seq" ).append("\n"); 
		query.append(", pod_clpt_ind_seq" ).append("\n"); 
		query.append("from bkg_cod_vvd" ).append("\n"); 
		query.append("where bkg_no       = @[bkgNo]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[codRqstSeq]" ).append("\n"); 
		query.append("and vvd_op_cd    = 'O'" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select vsl_pre_pst_cd" ).append("\n"); 
		query.append(", vsl_seq" ).append("\n"); 
		query.append(", vsl_cd" ).append("\n"); 
		query.append(", skd_voy_no" ).append("\n"); 
		query.append(", skd_dir_cd" ).append("\n"); 
		query.append(", slan_cd" ).append("\n"); 
		query.append(", pol_cd||substr(pol_yd_cd, 6, 2) pol_yd_cd" ).append("\n"); 
		query.append(", pod_cd||substr(pod_yd_cd, 6, 2) pod_yd_cd" ).append("\n"); 
		query.append(",pol_clpt_ind_seq" ).append("\n"); 
		query.append(",pod_clpt_ind_seq" ).append("\n"); 
		query.append("from bkg_vvd" ).append("\n"); 
		query.append("where bkg_no       = @[bkgNo]" ).append("\n"); 
		query.append("having (select COUNT(1)" ).append("\n"); 
		query.append("from bkg_cod_vvd" ).append("\n"); 
		query.append("where bkg_no       = @[bkgNo]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[codRqstSeq]" ).append("\n"); 
		query.append("and vvd_op_cd    = 'O') = 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY vsl_pre_pst_cd, vsl_seq" ).append("\n"); 

	}
}