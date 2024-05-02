/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOModifyChassisGensetSOManageCmbUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOModifyChassisGensetSOManageCmbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combinded Update 
	  * f_cmd : MODIFY
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOModifyChassisGensetSOManageCmbUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOModifyChassisGensetSOManageCmbUSQL").append("\n"); 
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
		query.append("UPDATE trs_trsp_svc_ord" ).append("\n"); 
		query.append("   SET trsp_so_cmb_seq = NULL" ).append("\n"); 
		query.append("      ,trsp_so_cmb_tp_cd = NULL" ).append("\n"); 
		query.append("      ,upd_dt = SYSDATE" ).append("\n"); 
		query.append("      ,upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,locl_upd_dt = globaldate_pkg.time_local_ofc_fnc (cre_ofc_cd)" ).append("\n"); 
		query.append(" WHERE trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND trsp_so_cmb_seq = @[trsp_so_cmb_seq]" ).append("\n"); 

	}
}