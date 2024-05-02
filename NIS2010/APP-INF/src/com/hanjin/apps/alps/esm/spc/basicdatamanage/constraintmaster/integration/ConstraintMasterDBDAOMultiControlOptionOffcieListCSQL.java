/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.10 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane Control Option Offcie List 에 값 입력시 사용
	  * ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL - 패키지 이동으로 신규 생성
	  * </pre>
	  */
	public ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ctrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_loc_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOMultiControlOptionOffcieListCSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_LANE_CTRL_OFC D1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[trd_cd] TRD_CD" ).append("\n"); 
		query.append("         , @[sub_trd_cd] SUB_TRD_CD" ).append("\n"); 
		query.append("         , @[rlane_cd] RLANE_CD" ).append("\n"); 
		query.append("         , @[dir_cd] DIR_CD" ).append("\n"); 
		query.append("         , @[aloc_ctrl_tp_cd] ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("         , @[ctrl_loc_acct_cd] CTRL_LOC_ACCT_CD" ).append("\n"); 
		query.append("         , @[upd_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("		 , @[ofc_cd] OFC_CD" ).append("\n"); 
		query.append("         , SYSDATE CRE_DT" ).append("\n"); 
		query.append("         , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("         , SYSDATE UPD_DT" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") D2" ).append("\n"); 
		query.append("ON ( D1.TRD_CD = D2.TRD_CD" ).append("\n"); 
		query.append("    AND D1.SUB_TRD_CD = D2.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND D1.RLANE_CD = D2.RLANE_CD" ).append("\n"); 
		query.append("    AND D1.DIR_CD = D2.DIR_CD" ).append("\n"); 
		query.append("    AND D1.ALOC_CTRL_TP_CD = D2.ALOC_CTRL_TP_CD" ).append("\n"); 
		query.append("    AND D1.CTRL_LOC_ACCT_CD = D2.CTRL_LOC_ACCT_CD " ).append("\n"); 
		query.append("	AND D1.OFC_CD = D2.OFC_CD " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("TRD_CD," ).append("\n"); 
		query.append("SUB_TRD_CD," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("ALOC_CTRL_TP_CD," ).append("\n"); 
		query.append("CTRL_LOC_ACCT_CD," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[trd_cd]," ).append("\n"); 
		query.append("@[sub_trd_cd]," ).append("\n"); 
		query.append("@[rlane_cd]," ).append("\n"); 
		query.append("@[dir_cd]," ).append("\n"); 
		query.append("@[aloc_ctrl_tp_cd]," ).append("\n"); 
		query.append("@[ctrl_loc_acct_cd]," ).append("\n"); 
		query.append("@[ofc_cd]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}