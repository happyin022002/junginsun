/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusCSQL.java
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

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0088 Estimate Performance Change Status Inquiry
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusCSQL(){
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
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_ESTM_ACT_RSLT_ANAL (" ).append("\n"); 
		query.append("	ADJ_RMK" ).append("\n"); 
		query.append("	, EXE_YRMON" ).append("\n"); 
		query.append("	, JB_EXE_YRMON" ).append("\n"); 
		query.append("	, REV_YRMON" ).append("\n"); 
		query.append("	, JO_ESTM_ANAL_ID" ).append("\n"); 
		query.append("	, JO_CRR_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, REV_DIR_CD" ).append("\n"); 
		query.append("	, RLANE_CD" ).append("\n"); 
		query.append("	, JO_STL_JB_CD" ).append("\n"); 
		query.append("	, ACCT_CD" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	@[adj_rmk]" ).append("\n"); 
		query.append("	, @[exe_yrmon]" ).append("\n"); 
		query.append("	, @[jb_exe_yrmon]" ).append("\n"); 
		query.append("	, @[rev_yrmon]" ).append("\n"); 
		query.append("	, @[estm_option]" ).append("\n"); 
		query.append("	, @[jo_crr_cd]" ).append("\n"); 
		query.append("	, SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("	, SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("	, SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	, SUBSTR(@[vvd], 10, 1)" ).append("\n"); 
		query.append("	, @[rlane_cd]" ).append("\n"); 
		query.append("	, DECODE(@[jo_stl_jb_cd], 'JOINT OPERATION', '101', 'LEASE', '102', 'ADDITIONAL', '103')" ).append("\n"); 
		query.append("	, @[acct_cd]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}