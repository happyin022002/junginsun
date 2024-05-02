/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConstraintManageDBDAOUpdateNodeConstraintUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOUpdateNodeConstraintUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateNodeConstraint
	  * </pre>
	  */
	public ConstraintManageDBDAOUpdateNodeConstraintUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cnst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cnst_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_nod_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cnst_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_pnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOUpdateNodeConstraintUSQL").append("\n"); 
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
		query.append("UPDATE PRD_NOD_CNST_MGMT " ).append("\n"); 
		query.append("SET   NOD_CNST_ITM_CD = @[nod_cnst_itm_cd], " ).append("\n"); 
		query.append("	  PCTL_CNST_ITM_NM = (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("						  WHERE INTG_CD_ID = 'CD01386' AND INTG_CD_VAL_CTNT = @[nod_cnst_itm_cd] ), " ).append("\n"); 
		query.append("	  NOD_CNST_RMK = @[nod_cnst_rmk] , " ).append("\n"); 
		query.append("	  CNTR_TP_CD = @[cntr_tp_cd] , " ).append("\n"); 
		query.append("	  SVC_USE_FLG = @[svc_use_flg] , " ).append("\n"); 
		query.append("	  EFF_FM_DT = REPLACE(@[eff_fm_dt], '-','') , " ).append("\n"); 
		query.append("	  EFF_TO_DT = REPLACE(@[eff_to_dt], '-','') , " ).append("\n"); 
		query.append("	  UPD_USR_ID = @[upd_usr_id] , " ).append("\n"); 
		query.append("	  UPD_OFC_CD = @[upd_ofc_cd] , " ).append("\n"); 
		query.append("	  UPD_DT = SYSDATE ," ).append("\n"); 
		query.append("	  PORT_PNT_CD = @[port_pnt_cd]," ).append("\n"); 
		query.append("      VSL_SLAN_CD = @[vsl_slan_cd]," ).append("\n"); 
		query.append("      VSL_CD      = substr(@[vvd], 1,4)," ).append("\n"); 
		query.append("      SKD_VOY_NO  = substr(@[vvd], 5,4)," ).append("\n"); 
		query.append("      SKD_DIR_CD  = substr(@[vvd], 9,1)" ).append("\n"); 
		query.append("WHERE NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("AND   NOD_CNST_ITM_CD = @[old_nod_cnst_itm_cd]" ).append("\n"); 
		query.append("AND   NOD_CNST_SEQ = TO_NUMBER(@[nod_cnst_seq])" ).append("\n"); 

	}
}