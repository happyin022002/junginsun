/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSendRevenueVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSendRevenueVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RevenueVVD I/F
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSendRevenueVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("statusflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration ").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSendRevenueVVDRSQL").append("\n"); 
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
		query.append("select SAC_REV_VVD_PKG.AR_MASTER_REVENUE_VVD( @[vsl_cd],@[skd_voy_no],@[skd_dir_cd],@[statusflag])  AS RST" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}