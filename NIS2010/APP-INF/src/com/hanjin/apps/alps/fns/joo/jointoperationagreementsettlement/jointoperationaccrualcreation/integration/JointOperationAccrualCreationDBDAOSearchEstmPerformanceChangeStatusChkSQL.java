/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusChkSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.01.26 조병연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JO BYEANG YEAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusChkSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0088 Estimate Performance Change Status Inquiry
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusChkSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("jb_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusChkSQL").append("\n"); 
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
		query.append("SELECT ADJ_RMK" ).append("\n"); 
		query.append("FROM JOO_ESTM_ACT_RSLT_ANAL" ).append("\n"); 
		query.append("WHERE EXE_YRMON				= @[exe_yrmon]" ).append("\n"); 
		query.append("	AND  JB_EXE_YRMON 		= @[jb_exe_yrmon] " ).append("\n"); 
		query.append("	AND  JO_ESTM_ANAL_ID 	= @[estm_option]	-- Initial Estimate(INI), Adjusted Estimate(ADJ)" ).append("\n"); 
		query.append("	AND  JO_CRR_CD 			= @[jo_crr_cd]" ).append("\n"); 
		query.append("	AND  VSL_CD||SKD_VOY_NO||SKD_DIR_CD||REV_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("	AND  RLANE_CD			= @[rlane_cd]" ).append("\n"); 
		query.append("	AND  JO_STL_JB_CD		= DECODE(@[jo_stl_jb_cd], 'JOINT OPERATION', '101', 'LEASE', '102', 'ADDITIONAL', '103')" ).append("\n"); 
		query.append("	AND  ACCT_CD			= @[acct_cd]" ).append("\n"); 

	}
}