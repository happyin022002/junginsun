/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOaddNewObjectCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOaddNewObjectCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 object를 추가한다
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOaddNewObjectCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_list_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_list_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_obj_list_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_list_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_obj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOaddNewObjectCSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("  INTO PSO_OBJ_LIST t1 USING DUAL ON (t1.OBJ_LIST_NO = @[obj_list_no])" ).append("\n"); 
		query.append("       WHEN MATCHED THEN" ).append("\n"); 
		query.append("            UPDATE" ).append("\n"); 
		query.append("               SET OBJ_LIST_NM = @[obj_list_nm]" ).append("\n"); 
		query.append("                 , PSO_OBJ_LIST_TP_CD = @[pso_obj_list_tp_cd]" ).append("\n"); 
		query.append("                 , PSO_OBJ_CD = @[pso_obj_cd]" ).append("\n"); 
		query.append("                 , PSO_MEAS_UT_CD = @[pso_meas_ut_cd]" ).append("\n"); 
		query.append("                 , OBJ_LIST_ABBR_NM = @[obj_list_abbr_nm]" ).append("\n"); 
		query.append("                 , DFLT_CTNT = @[dflt_ctnt]" ).append("\n"); 
		query.append("                 , DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append("                 , UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("                 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("             WHERE OBJ_LIST_NO = @[obj_list_no]" ).append("\n"); 
		query.append("       WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("            INSERT ( OBJ_LIST_NO " ).append("\n"); 
		query.append("                   , OBJ_LIST_NM " ).append("\n"); 
		query.append("                   , PSO_OBJ_LIST_TP_CD " ).append("\n"); 
		query.append("                   , PSO_OBJ_CD " ).append("\n"); 
		query.append("                   , PSO_MEAS_UT_CD " ).append("\n"); 
		query.append("                   , OBJ_LIST_ABBR_NM " ).append("\n"); 
		query.append("                   , DFLT_CTNT " ).append("\n"); 
		query.append("                   , DIFF_RMK " ).append("\n"); 
		query.append("                   , CRE_USR_ID " ).append("\n"); 
		query.append("                   , CRE_DT " ).append("\n"); 
		query.append("                   , UPD_USR_ID " ).append("\n"); 
		query.append("                   , UPD_DT ) VALUES ( " ).append("\n"); 
		query.append("                     @[obj_list_no]" ).append("\n"); 
		query.append("                   , @[obj_list_nm]" ).append("\n"); 
		query.append("                   , @[pso_obj_list_tp_cd]" ).append("\n"); 
		query.append("                   , (SELECT NVL(MAX(TO_NUMBER(PSO_OBJ_CD)),0) + 1 FROM PSO_OBJ_LIST )" ).append("\n"); 
		query.append("                   , @[pso_meas_ut_cd]" ).append("\n"); 
		query.append("                   , @[obj_list_abbr_nm]" ).append("\n"); 
		query.append("                   , @[dflt_ctnt]" ).append("\n"); 
		query.append("                   , @[diff_rmk]" ).append("\n"); 
		query.append("                   , @[cre_usr_id]" ).append("\n"); 
		query.append("                   , SYSDATE" ).append("\n"); 
		query.append("                   , @[cre_usr_id]" ).append("\n"); 
		query.append("                   , SYSDATE )" ).append("\n"); 

	}
}