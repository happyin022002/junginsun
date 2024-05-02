/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DistanceCreationDBDAOsearchDistanceCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.10.05 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DistanceCreationDBDAOsearchDistanceCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDistanceCreation
	  * </pre>
	  */
	public DistanceCreationDBDAOsearchDistanceCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_zip",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_zip",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_frm_node",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.integration").append("\n"); 
		query.append("FileName : DistanceCreationDBDAOsearchDistanceCreationRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("rownum seq ," ).append("\n"); 
		query.append("SUBSTR(fm_nod_cd, 1, 5) fm_nod_cd," ).append("\n"); 
		query.append("SUBSTR(fm_nod_cd, 6) fm_nod_cd_sub," ).append("\n"); 
		query.append("fm_nod_zip_cd_ctnt  ," ).append("\n"); 
		query.append("SUBSTR(to_nod_cd, 1, 5) to_nod_cd," ).append("\n"); 
		query.append("SUBSTR(to_nod_cd, 6) to_nod_cd_sub," ).append("\n"); 
		query.append("to_nod_zip_cd_ctnt  ," ).append("\n"); 
		query.append("bzc_dist     		," ).append("\n"); 
		query.append("dist_meas_ut_cd     ," ).append("\n"); 
		query.append("conv_dist  			," ).append("\n"); 
		query.append("conv_meas_ut_cd  	," ).append("\n"); 
		query.append("to_char(cre_dt,'YYYYMMDD') cre_dt," ).append("\n"); 
		query.append("cre_usr_id          ," ).append("\n"); 
		query.append("to_char(upd_dt,'YYYYMMDD') upd_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("fm_nod_cd||to_nod_cd duple1," ).append("\n"); 
		query.append("decode(delt_flg,'Y','D','') delt_flg" ).append("\n"); 
		query.append("FROM TRS_AGMT_DIST A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 
		query.append("#if(${hid_frm_node}!= '' && $hid_frm_node.length()==7)" ).append("\n"); 
		query.append("AND A.fm_nod_cd = @[hid_frm_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hid_frm_node}!= '' && $hid_frm_node.length()==5)" ).append("\n"); 
		query.append("AND SUBSTR(fm_nod_cd, 1, 5) = @[hid_frm_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hid_to_node}!= '' && $hid_to_node.length()==7)" ).append("\n"); 
		query.append("AND A.to_nod_cd = @[hid_to_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${hid_to_node}!= '' && $hid_to_node.length()==5)" ).append("\n"); 
		query.append("AND SUBSTR(to_nod_cd, 1, 5) = @[hid_to_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${frm_zip}!='')" ).append("\n"); 
		query.append("AND A.fm_nod_zip_cd_ctnt = @[frm_zip]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${to_zip}!='')" ).append("\n"); 
		query.append("AND A.to_nod_zip_cd_ctnt =  @[to_zip]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}