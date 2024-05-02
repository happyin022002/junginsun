/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에서 넘너오는 값
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' eta_Dt," ).append("\n"); 
		query.append("'' auth_No," ).append("\n"); 
		query.append("'' del_Cd," ).append("\n"); 
		query.append("'' vsl_Nm," ).append("\n"); 
		query.append("'' etd_Dt," ).append("\n"); 
		query.append("'' bl_No," ).append("\n"); 
		query.append("'' act_Wgt," ).append("\n"); 
		query.append("'' bkg_No," ).append("\n"); 
		query.append("'' pol_Cd," ).append("\n"); 
		query.append("'' carrier_No," ).append("\n"); 
		query.append("'' wgt_Ut_Cd," ).append("\n"); 
		query.append("'' meas_Qty," ).append("\n"); 
		query.append("'' cgo_Tp," ).append("\n"); 
		query.append("'' pck_Qty," ).append("\n"); 
		query.append("'' reg_No," ).append("\n"); 
		query.append("'' pck_Tp_Cd," ).append("\n"); 
		query.append("'' meas_Ut_Cd," ).append("\n"); 
		query.append("'' customs_Office_Code," ).append("\n"); 
		query.append("'' vvd_Number," ).append("\n"); 
		query.append("'' call_Port," ).append("\n"); 
		query.append("'' vsl_cd," ).append("\n"); 
		query.append("'' skd_voy_no," ).append("\n"); 
		query.append("'' skd_dir_cd," ).append("\n"); 
		query.append("'' pod_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}