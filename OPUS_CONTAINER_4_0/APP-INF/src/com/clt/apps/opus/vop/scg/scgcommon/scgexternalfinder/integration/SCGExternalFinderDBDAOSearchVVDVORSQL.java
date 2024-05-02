/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchVVDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.01.21 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchVVDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 정보 조회
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchVVDVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchVVDVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     vs.vsl_cd" ).append("\n"); 
		query.append("   , vs.skd_voy_no" ).append("\n"); 
		query.append("   , vs.skd_dir_cd" ).append("\n"); 
		query.append("   , mc.vsl_eng_nm" ).append("\n"); 
		query.append("   , vs.vsl_slan_cd" ).append("\n"); 
		query.append("   , ml.vsl_slan_nm" ).append("\n"); 
		query.append("   , mc.crr_cd vsl_opr_tp_cd" ).append("\n"); 
		query.append("   , vc.crr_nm vsl_opr_tp_nm" ).append("\n"); 
		query.append("FROM vsk_vsl_skd vs" ).append("\n"); 
		query.append("   , mdm_vsl_cntr mc" ).append("\n"); 
		query.append("   , mdm_carrier vc" ).append("\n"); 
		query.append("   , mdm_vsl_svc_lane ml" ).append("\n"); 
		query.append("WHERE vs.vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("AND	vs.skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	vs.skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND vs.vsl_cd = mc.vsl_cd" ).append("\n"); 
		query.append("AND mc.crr_cd = vc.crr_cd" ).append("\n"); 
		query.append("AND	vs.vsl_slan_cd = ml.vsl_slan_cd" ).append("\n"); 

	}
}