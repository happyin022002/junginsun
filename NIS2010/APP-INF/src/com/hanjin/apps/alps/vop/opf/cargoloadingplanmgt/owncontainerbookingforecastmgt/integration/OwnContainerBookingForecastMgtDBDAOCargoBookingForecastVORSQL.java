/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCargoBookingForecastVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.16 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCargoBookingForecastVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoBookingForecastVO
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCargoBookingForecastVORSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCargoBookingForecastVORSQL").append("\n"); 
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
		query.append("SELECT cntr_wgt_grp_seq," ).append("\n"); 
		query.append("slan_cd," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("pol_cd," ).append("\n"); 
		query.append("cntr_wgt_grp_cd," ).append("\n"); 
		query.append("wgt_grp_cd_desc," ).append("\n"); 
		query.append("max(decode(full_mty_cd,'F',decode(cntr_sz_cd,2,FM_LMT_WGT))) as cntr_lmt_wgt1," ).append("\n"); 
		query.append("max(decode(full_mty_cd,'F',decode(cntr_sz_cd,2,TO_LMT_WGT))) as cntr_lmt_wgt2," ).append("\n"); 
		query.append("max(decode(full_mty_cd,'F',decode(cntr_sz_cd,4,FM_LMT_WGT))) as cntr_lmt_wgt3," ).append("\n"); 
		query.append("max(decode(full_mty_cd,'F',decode(cntr_sz_cd,4,TO_LMT_WGT))) as cntr_lmt_wgt4," ).append("\n"); 
		query.append("max(cre_usr_id) as cre_usr_id," ).append("\n"); 
		query.append("max(upd_usr_id) as upd_usr_id" ).append("\n"); 
		query.append("FROM opf_cgo_bkg_fcast_wgt_grp" ).append("\n"); 
		query.append("WHERE slan_cd = @[slan_cd]" ).append("\n"); 
		query.append("AND skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("GROUP BY cntr_wgt_grp_seq, slan_cd, skd_dir_cd, pol_cd, cntr_wgt_grp_cd, wgt_grp_cd_desc, CNTR_WGT_GRP_SEQ" ).append("\n"); 
		query.append("ORDER BY cntr_wgt_grp_seq ASC, NVL(cntr_lmt_wgt1,0) DESC, NVL(cntr_lmt_wgt3,0) DESC" ).append("\n"); 

	}
}