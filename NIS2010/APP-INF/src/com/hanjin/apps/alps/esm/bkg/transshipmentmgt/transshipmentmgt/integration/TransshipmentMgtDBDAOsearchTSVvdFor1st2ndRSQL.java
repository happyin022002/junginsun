/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTSVvdFor1st2ndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2010.01.08 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchTSVvdFor1st2ndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * esm_bkg_495 화면에서 vvd를 drop down으로 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTSVvdFor1st2ndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTSVvdFor1st2ndRSQL").append("\n"); 
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
		query.append("select DISTINCT skd.vsl_cd||skd.skd_voy_no||skd.skd_dir_cd val" ).append("\n"); 
		query.append(",skd.vsl_cd||skd.skd_voy_no||skd.skd_dir_cd name" ).append("\n"); 
		query.append("from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_cd} !='')" ).append("\n"); 
		query.append("where skd.vps_port_cd = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_cd} !='' && ${loc_yd_cd} !='')" ).append("\n"); 
		query.append("and skd.yd_cd       = @[loc_cd]||@[loc_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vps_dt_flag} =='A')" ).append("\n"); 
		query.append("#if(${vps_etd_dt} !='')" ).append("\n"); 
		query.append("and skd.vps_eta_dt  > to_date(@[vps_etd_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("and skd.vps_eta_dt  < to_date(@[vps_etd_dt],'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${vps_etd_dt} !='')" ).append("\n"); 
		query.append("and skd.vps_etd_dt  > to_date(@[vps_etd_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("and skd.vps_etd_dt  < to_date(@[vps_etd_dt],'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}