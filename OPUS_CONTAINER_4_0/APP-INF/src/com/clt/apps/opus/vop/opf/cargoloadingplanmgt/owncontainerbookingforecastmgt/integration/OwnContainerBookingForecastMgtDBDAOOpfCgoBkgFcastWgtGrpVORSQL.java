/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.19 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfCgoBkgFcastWgtGrpVO Select
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVORSQL").append("\n"); 
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
		query.append("slan_cd" ).append("\n"); 
		query.append(",	skd_dir_cd" ).append("\n"); 
		query.append(",	pol_cd" ).append("\n"); 
		query.append(",	cntr_sz_cd" ).append("\n"); 
		query.append(",	full_mty_cd" ).append("\n"); 
		query.append(",	cntr_wgt_grp_cd" ).append("\n"); 
		query.append(",	wgt_grp_cd_desc" ).append("\n"); 
		query.append(",	fm_lmt_wgt" ).append("\n"); 
		query.append(",	to_lmt_wgt" ).append("\n"); 
		query.append(",	cntr_wgt_grp_seq" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append("FROM opf_cgo_bkg_fcast_wgt_grp" ).append("\n"); 
		query.append("WHERE	slan_cd = @[slan_cd]" ).append("\n"); 
		query.append("AND	skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("AND	cntr_sz_cd = @[cntr_sz_cd]" ).append("\n"); 
		query.append("AND	full_mty_cd = @[full_mty_cd]" ).append("\n"); 
		query.append("AND	cntr_wgt_grp_cd = @[cntr_wgt_grp_cd]" ).append("\n"); 

	}
}