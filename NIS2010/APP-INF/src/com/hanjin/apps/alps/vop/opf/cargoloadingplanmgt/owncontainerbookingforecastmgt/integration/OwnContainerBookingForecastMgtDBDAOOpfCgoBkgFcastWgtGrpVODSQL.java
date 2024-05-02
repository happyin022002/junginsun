/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVODSQL.java
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;
 
/**
 *
 * @author Sunyoung
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM opf_cgo_bkg_fcast_wgt_grp" ).append("\n"); 
		query.append("WHERE	slan_cd = @[slan_cd]" ).append("\n"); 
		query.append("AND	skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("AND	cntr_sz_cd = @[cntr_sz_cd]" ).append("\n"); 
		query.append("AND	full_mty_cd = @[full_mty_cd]" ).append("\n"); 
		query.append("AND cntr_wgt_grp_cd = @[cntr_wgt_grp_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastWgtGrpVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}