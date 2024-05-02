/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerEdiDBDAOSearchUsrPerformanceSettingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOSearchUsrPerformanceSettingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchUsrPerformanceSettingInfo
	  * </pre>
	  */
	public CustomerEdiDBDAOSearchUsrPerformanceSettingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOSearchUsrPerformanceSettingInfoRSQL").append("\n"); 
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
		query.append("SELECT   a||'%'||b||'%'||c as code  ," ).append("\n"); 
		query.append(" d as text" ).append("\n"); 
		query.append("FROM  ( select edi_grp_cd a, cust_trd_prnr_id b, edi_grp_desc c, edi_cgo_rmk d from edi_usr_cust where cre_usr_id = @[user_id] and edi_sts_seq = '2' )   " ).append("\n"); 
		query.append("ORDER BY text" ).append("\n"); 

	}
}