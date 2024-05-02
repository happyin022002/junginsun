/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderRemarkDBDAOMultiWorkOrderRemarkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderRemarkDBDAOMultiWorkOrderRemarkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiWorkOrderRemark
	  * </pre>
	  */
	public WorkOrderRemarkDBDAOMultiWorkOrderRemarkCSQL(){
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
		params.put("wo_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderremark.integration ").append("\n"); 
		query.append("FileName : WorkOrderRemarkDBDAOMultiWorkOrderRemarkCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_WRK_ORD_INSTR	(" ).append("\n"); 
		query.append("WO_INSTR_OFC_CD    	," ).append("\n"); 
		query.append("TRSP_BND_CD        	," ).append("\n"); 
		query.append("TRSP_COST_MOD_CD   	," ).append("\n"); 
		query.append("TRSP_CRR_MOD_CD    	," ).append("\n"); 
		query.append("WO_INSTR_RMK       	," ).append("\n"); 
		query.append("CRE_OFC_CD         	," ).append("\n"); 
		query.append("CRE_USR_ID         	," ).append("\n"); 
		query.append("CRE_DT             	," ).append("\n"); 
		query.append("UPD_USR_ID			," ).append("\n"); 
		query.append("UPD_DT             	," ).append("\n"); 
		query.append("LOCL_CRE_DT			," ).append("\n"); 
		query.append("LOCL_UPD_DT" ).append("\n"); 
		query.append(") VALUES ( 	@[wo_instr_ofc_cd]  ," ).append("\n"); 
		query.append("@[trsp_bnd_cd]      ," ).append("\n"); 
		query.append("@[trsp_cost_mod_cd] ," ).append("\n"); 
		query.append("@[trsp_crr_mod_cd]  ," ).append("\n"); 
		query.append("@[wo_instr_rmk]     ," ).append("\n"); 
		query.append("@[cre_ofc_cd]       ," ).append("\n"); 
		query.append("@[cre_usr_id]       ," ).append("\n"); 
		query.append("SYSDATE				," ).append("\n"); 
		query.append("@[cre_usr_id]		," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}