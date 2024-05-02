/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : YardManageDBDAOSearchZonePostCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.07.22 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOSearchZonePostCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchZonePostCode
	  * </pre>
	  */
	public YardManageDBDAOSearchZonePostCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("node_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration").append("\n"); 
		query.append("FileName : YardManageDBDAOSearchZonePostCodeRSQL").append("\n"); 
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
		query.append("SELECT zn_cd, zn_seq, zip_cd, dstr_nm" ).append("\n"); 
		query.append("FROM   mdm_zn_dtl" ).append("\n"); 
		query.append("WHERE  zn_cd = @[node_code]" ).append("\n"); 

	}
}