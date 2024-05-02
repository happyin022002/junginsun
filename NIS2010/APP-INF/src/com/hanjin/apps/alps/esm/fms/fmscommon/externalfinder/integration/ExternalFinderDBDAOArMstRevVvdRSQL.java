/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalFinderDBDAOArMstRevVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.26 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOArMstRevVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD Code Select
	  * </pre>
	  */
	public ExternalFinderDBDAOArMstRevVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOArMstRevVvdRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("skd_voy_no," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("rlane_dir_cd," ).append("\n"); 
		query.append("voy_tp_cd," ).append("\n"); 
		query.append("slan_cd," ).append("\n"); 
		query.append("port_chk_flg," ).append("\n"); 
		query.append("lod_qty," ).append("\n"); 
		query.append("rev_port_cd," ).append("\n"); 
		query.append("rev_yrmon," ).append("\n"); 
		query.append("com_vvd_flg," ).append("\n"); 
		query.append("vvd_com_lvl," ).append("\n"); 
		query.append("rlane_cd," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("eai_evnt_dt" ).append("\n"); 
		query.append("from ar_mst_rev_vvd" ).append("\n"); 
		query.append("where	vsl_cd = substr(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("and	skd_voy_no = substr(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("and	skd_dir_cd = substr(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("and	rlane_dir_cd = substr(@[vvd_cd],10,1)" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 

	}
}