/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchRehandlingVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.07 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchRehandlingVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * opf에서 호출시 해당 request 건의 rehandling vvd를 조회한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchRehandlingVvdRSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchRehandlingVvdRSQL").append("\n"); 
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
		query.append("select cod.vsl_cd||cod.skd_voy_no||cod.skd_dir_cd vvd" ).append("\n"); 
		query.append(", new_vvd.pod_yd_cd new_pod_yd_cd" ).append("\n"); 
		query.append(", old_vvd.pod_yd_cd old_pod_yd_cd" ).append("\n"); 
		query.append(", cod.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append("from bkg_cod_vvd old_vvd" ).append("\n"); 
		query.append(", bkg_cod_vvd new_vvd" ).append("\n"); 
		query.append(", (select distinct" ).append("\n"); 
		query.append("cod.bkg_no" ).append("\n"); 
		query.append(", cod.cod_rqst_seq" ).append("\n"); 
		query.append(", vvd.vsl_cd, vvd.skd_voy_no, vvd.skd_dir_cd" ).append("\n"); 
		query.append(", cod.COD_RHND_PORT_YD_CD" ).append("\n"); 
		query.append("from bkg_cod cod, bkg_cod_vvd vvd" ).append("\n"); 
		query.append("where cod.bkg_no       = vvd.bkg_no" ).append("\n"); 
		query.append("and cod.cod_rqst_seq = vvd.cod_rqst_seq" ).append("\n"); 
		query.append("and cod.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("and cod.cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and cod.COD_RHND_PORT_YD_CD = vvd.pod_yd_cd) cod" ).append("\n"); 
		query.append("where old_vvd.bkg_no       = cod.bkg_no" ).append("\n"); 
		query.append("and old_vvd.cod_rqst_seq = cod.cod_rqst_seq" ).append("\n"); 
		query.append("and old_vvd.vsl_cd       = cod.vsl_cd" ).append("\n"); 
		query.append("and old_vvd.skd_voy_no   = cod.skd_voy_no" ).append("\n"); 
		query.append("and old_vvd.skd_dir_cd   = cod.skd_dir_cd" ).append("\n"); 
		query.append("and old_vvd.vvd_op_cd    = 'O'" ).append("\n"); 
		query.append("and new_vvd.bkg_no       = cod.bkg_no" ).append("\n"); 
		query.append("and new_vvd.cod_rqst_seq = cod.cod_rqst_seq" ).append("\n"); 
		query.append("and new_vvd.vsl_cd       = cod.vsl_cd" ).append("\n"); 
		query.append("and new_vvd.skd_voy_no   = cod.skd_voy_no" ).append("\n"); 
		query.append("and new_vvd.skd_dir_cd   = cod.skd_dir_cd" ).append("\n"); 
		query.append("and new_vvd.vvd_op_cd    = 'N'" ).append("\n"); 

	}
}