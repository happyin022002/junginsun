/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderDetailDBDAOupdateWorkOrderOpenFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 이상훈
*@LastVersion : 1.0
* 2009.11.10 이상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Hoon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderDetailDBDAOupdateWorkOrderOpenFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Work Order Open Flag Update
	  * </pre>
	  */
	public WorkOrderDetailDBDAOupdateWorkOrderOpenFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderDetailDBDAOupdateWorkOrderOpenFlagUSQL").append("\n"); 
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
		query.append("UPDATE  trs_trsp_wrk_ord" ).append("\n"); 
		query.append("SET	wo_opn_flg	 = 'Y'," ).append("\n"); 
		query.append("upd_usr_id = NVL(upd_usr_id,@[user_id])," ).append("\n"); 
		query.append("upd_dt =  NVL(upd_dt,globaldate_pkg.time_local_ofc_fnc(cre_ofc_cd))" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND  trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND  trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 

	}
}