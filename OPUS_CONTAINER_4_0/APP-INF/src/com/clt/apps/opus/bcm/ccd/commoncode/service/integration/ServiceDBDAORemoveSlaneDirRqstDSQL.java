/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ServiceDBDAORemoveSlaneDirRqstDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.07.10 윤태승
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YunTaeSeung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAORemoveSlaneDirRqstDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request VSL DIR cd 완전 삭제
	  * </pre>
	  */
	public ServiceDBDAORemoveSlaneDirRqstDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAORemoveSlaneDirRqstDSQL").append("\n"); 
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
		query.append("DELETE FROM MDM_VSL_SVC_LANE_DIR_RQST" ).append("\n"); 
		query.append(" WHERE RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("   AND VSL_SLAN_DIR_CD = @[vsl_slan_dir_cd]" ).append("\n"); 

	}
}