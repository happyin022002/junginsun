/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSMSendDBDAOSearchBkgBoundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendDBDAOSearchBkgBoundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgBound
	  * </pre>
	  */
	public CSMSendDBDAOSearchBkgBoundRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsend.integration").append("\n"); 
		query.append("FileName : CSMSendDBDAOSearchBkgBoundRSQL").append("\n"); 
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
		query.append("select case when pod_cd = 'NOT_EXIST' then pod_cd" ).append("\n"); 
		query.append("when pod_cd like 'US%' or del_cd like 'US%' then 'US_BOUND'" ).append("\n"); 
		query.append("else 'NOT_US_BOUND' end as CK" ).append("\n"); 
		query.append("from (select nvl(max(pod_cd), 'NOT_EXIST') as pod_cd," ).append("\n"); 
		query.append("nvl(max(del_cd), 'NOT_EXIST') as del_cd" ).append("\n"); 
		query.append("from bkg_booking" ).append("\n"); 
		query.append("where bkg_No = @[bkg_no])" ).append("\n"); 

	}
}