/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAORemoveChassisGensetListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.12 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAORemoveChassisGensetListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis,Genset Delete
	  * f_cmd : REMOVELIST
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAORemoveChassisGensetListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("formUsrOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SoOfc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SoSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("formUsrId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAORemoveChassisGensetListUSQL").append("\n"); 
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
		query.append("SET delt_flg = 'Y'" ).append("\n"); 
		query.append(",upd_usr_id = @[formUsrId]" ).append("\n"); 
		query.append(",upd_dt = SYSDATE" ).append("\n"); 
		query.append(",locl_upd_dt = globaldate_pkg.time_local_ofc_fnc (@[formUsrOfcCd])" ).append("\n"); 
		query.append("WHERE trsp_so_ofc_cty_cd = @[SoOfc]" ).append("\n"); 
		query.append("AND trsp_so_seq = @[SoSeq]" ).append("\n"); 
		query.append("AND trsp_wo_seq IS NULL" ).append("\n"); 

	}
}