/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderRemarkDBDAOSearchWorkOrderRemarkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderRemarkDBDAOSearchWorkOrderRemarkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public WorkOrderRemarkDBDAOSearchWorkOrderRemarkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderremark.integration").append("\n"); 
		query.append("FileName : WorkOrderRemarkDBDAOSearchWorkOrderRemarkListRSQL").append("\n"); 
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
		query.append("      WO_INSTR_OFC_CD                    ," ).append("\n"); 
		query.append("      TRSP_BND_CD                        ," ).append("\n"); 
		query.append("      TRSP_COST_MOD_CD                   ," ).append("\n"); 
		query.append("      TRSP_CRR_MOD_CD                    ," ).append("\n"); 
		query.append("      WO_INSTR_RMK                       ," ).append("\n"); 
		query.append("      TO_CHAR(UPD_DT, 'YYYYMMDD') CRE_DT ," ).append("\n"); 
		query.append("      UPD_USR_ID CRE_USR_ID              ," ).append("\n"); 
		query.append("      CRE_OFC_CD" ).append("\n"); 
		query.append("FROM  TRS_TRSP_WRK_ORD_INSTR" ).append("\n"); 
		query.append("WHERE WO_INSTR_OFC_CD	 = @[f_usr_ofc_cd]" ).append("\n"); 
		query.append("#if ( ${f_trsp_cost_mod_cd} != 'ALL' && ${f_trsp_cost_mod_cd} != '' )" ).append("\n"); 
		query.append("AND   TRSP_COST_MOD_CD = @[f_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trsp_crr_mod_cd} != 'ALL' && ${f_trsp_crr_mod_cd} != '' )" ).append("\n"); 
		query.append("AND   TRSP_CRR_MOD_CD  = @[f_trsp_crr_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${f_trsp_bnd_cd} != 'ALL' && ${f_trsp_bnd_cd} != '' )" ).append("\n"); 
		query.append("AND   TRSP_BND_CD      = @[f_trsp_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}