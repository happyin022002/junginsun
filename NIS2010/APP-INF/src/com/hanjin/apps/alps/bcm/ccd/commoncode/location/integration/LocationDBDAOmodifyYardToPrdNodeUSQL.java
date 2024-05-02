/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOmodifyYardToPrdNodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOmodifyYardToPrdNodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정된 Yard 정보를 Prd Node에도 반영
	  * </pre>
	  */
	public LocationDBDAOmodifyYardToPrdNodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOmodifyYardToPrdNodeUSQL").append("\n"); 
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
		query.append("UPDATE prd_node SET " ).append("\n"); 
		query.append("    nod_nm 	       = @[yd_nm] " ).append("\n"); 
		query.append("  ,	nod_tp_cd      = #if(${yd_fcty_tp_psdo_yd_flg} =='Y')" ).append("\n"); 
		query.append("					    'Y'" ).append("\n"); 
		query.append("                     #elseif(${yd_fcty_tp_mrn_tml_flg} =='Y')" ).append("\n"); 
		query.append("					    'M'" ).append("\n"); 
		query.append("                     #elseif(${yd_fcty_tp_brg_rmp_flg} =='Y')" ).append("\n"); 
		query.append("                     	'B'" ).append("\n"); 
		query.append("                     #elseif(${yd_fcty_tp_rail_rmp_flg} == 'Y')" ).append("\n"); 
		query.append("                     	'R'" ).append("\n"); 
		query.append("                     #elseif(${yd_fcty_tp_cy_flg} == 'Y')" ).append("\n"); 
		query.append("                     	'Y'" ).append("\n"); 
		query.append("                     #elseif(${yd_fcty_tp_cfs_flg} =='Y')" ).append("\n"); 
		query.append("                     	'S'" ).append("\n"); 
		query.append("                     #elseif(${yd_fcty_tp_psdo_yd_flg} !='Y' && ${yd_fcty_tp_mrn_tml_flg} !='Y' " ).append("\n"); 
		query.append("                             && ${yd_fcty_tp_brg_rmp_flg} !='Y' && ${yd_fcty_tp_rail_rmp_flg} !='Y' " ).append("\n"); 
		query.append("                             && ${yd_fcty_tp_cy_flg}  !='Y' && ${yd_fcty_tp_cfs_flg} !='Y' )" ).append("\n"); 
		query.append("                     	'Y'" ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("  , onf_hir_yd_flg = 'N'" ).append("\n"); 
		query.append("  ,	delt_flg       = @[delt_flg] " ).append("\n"); 
		query.append("  ,	upd_usr_id     = @[usr_id] " ).append("\n"); 
		query.append("  ,	upd_dt 	       = sysdate" ).append("\n"); 
		query.append("WHERE nod_cd       = @[yd_cd]" ).append("\n"); 

	}
}