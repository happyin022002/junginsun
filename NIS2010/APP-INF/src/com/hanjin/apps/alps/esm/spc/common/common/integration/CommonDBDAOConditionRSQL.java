/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.04 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HJ.LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC 공통으로 사용 하는 조건 VO.
	  * </pre>
	  */
	public CommonDBDAOConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOConditionRSQL").append("\n"); 
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
		query.append("'' bound," ).append("\n"); 
		query.append("'' dir_cd," ).append("\n"); 
		query.append("'' duration," ).append("\n"); 
		query.append("'' fcast," ).append("\n"); 
		query.append("'' ioc_cd," ).append("\n"); 
		query.append("'' lane," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' office," ).append("\n"); 
		query.append("'' pod_cd," ).append("\n"); 
		query.append("'' pol_cd," ).append("\n"); 
		query.append("'' rlane_cd," ).append("\n"); 
		query.append("'' skd_dir_cd," ).append("\n"); 
		query.append("'' skd_voy_no," ).append("\n"); 
		query.append("'' subtrade," ).append("\n"); 
		query.append("'' sub_trd_cd," ).append("\n"); 
		query.append("'' trade," ).append("\n"); 
		query.append("'' trd_cd," ).append("\n"); 
		query.append("'' user_ofc," ).append("\n"); 
		query.append("'' vsl_cd," ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' week," ).append("\n"); 
		query.append("'' year," ).append("\n"); 
		query.append("'' rep_trade," ).append("\n"); 
		query.append("'' sub_trade" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}