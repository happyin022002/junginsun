/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDAOMultiControlOptionOffcieListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.10 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDAOMultiControlOptionOffcieListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConstraintMasterDBDAOMultiControlOptionOffcieListUSQL
	  * </pre>
	  */
	public ConstraintMasterDAOMultiControlOptionOffcieListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration ").append("\n"); 
		query.append("FileName : ConstraintMasterDAOMultiControlOptionOffcieListUSQL").append("\n"); 
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
		query.append("UPDATE SPC_ALOC_LANE_CTRL_OFC" ).append("\n"); 
		query.append("SET OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("	AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("	AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("	AND ALOC_CTRL_TP_CD = @[aloc_ctrl_tp_cd]" ).append("\n"); 
		query.append("	AND CTRL_LOC_ACC_TP_CD = @[ctrl_loc_acct_cd]" ).append("\n"); 

	}
}