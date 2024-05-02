/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOVerifyChassisGensetSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOVerifyChassisGensetSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis, GenSet Velidation Check
	  * f_cmd : SEARCH03
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOVerifyChassisGensetSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOVerifyChassisGensetSOManageRSQL").append("\n"); 
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
		query.append("SELECT   NVL (COUNT (eq_no), 0) cnt" ).append("\n"); 
		query.append(",eq_no" ).append("\n"); 
		query.append(",TO_CHAR (locl_cre_dt, 'YYYYMMDD') cre_dt" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord" ).append("\n"); 
		query.append("WHERE locl_cre_dt > SYSDATE - 14" ).append("\n"); 
		query.append("AND delt_flg <> 'Y'" ).append("\n"); 
		query.append("#foreach(${key} in ${eq_no_fm_loc})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("AND ((EQ_NO =SUBSTR('key',1,10) AND FM_NOD_CD = SUBSTR('key',11,17))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("OR (EQ_NO =SUBSTR('key',1,10) AND FM_NOD_CD = SUBSTR('key',11,17))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY eq_no" ).append("\n"); 
		query.append(",locl_cre_dt" ).append("\n"); 

	}
}