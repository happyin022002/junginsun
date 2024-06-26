/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderRemarkDAOMultiWorkOrderRemarkDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.08.18 최진오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JIN O CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderRemarkDBDAOMultiWorkOrderRemarkDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderRemark DELETE
	  * </pre>
	  */
	public WorkOrderRemarkDBDAOMultiWorkOrderRemarkDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_instr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderremark.integration").append("\n"); 
		query.append("FileName : WorkOrderRemarkDAOMultiWorkOrderRemarkDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM  TRS_TRSP_WRK_ORD_INSTR" ).append("\n"); 
		query.append("WHERE WO_INSTR_OFC_CD  = @[wo_instr_ofc_cd]" ).append("\n"); 
		query.append("AND   TRSP_BND_CD      = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("AND   TRSP_COST_MOD_CD = @[trsp_cost_mod_cd]" ).append("\n"); 
		query.append("AND   TRSP_CRR_MOD_CD  = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("AND   HJL_NO IS NULL" ).append("\n"); 

	}
}