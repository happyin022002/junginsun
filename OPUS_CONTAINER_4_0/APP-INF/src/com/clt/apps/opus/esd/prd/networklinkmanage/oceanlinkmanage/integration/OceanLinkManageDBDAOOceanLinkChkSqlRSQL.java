/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OceanLinkManageDBDAOOceanLinkChkSqlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAOOceanLinkChkSqlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기등록된 Ocean Link의 존재유무를 체크한다.
	  * </pre>
	  */
	public OceanLinkManageDBDAOOceanLinkChkSqlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("podprot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lanecd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("polprot",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAOOceanLinkChkSqlRSQL").append("\n"); 
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
		query.append("SELECT 'X' " ).append("\n"); 
		query.append("FROM PRD_PF_TZ_TM " ).append("\n"); 
		query.append("WHERE FM_PORT_CD = @[polprot] " ).append("\n"); 
		query.append("AND TO_PORT_CD = @[podprot] " ).append("\n"); 
		query.append("AND VSL_SLAN_CD = @[lanecd]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dircd]" ).append("\n"); 
		query.append("AND DELT_FLG <> 'Y'" ).append("\n"); 

	}
}