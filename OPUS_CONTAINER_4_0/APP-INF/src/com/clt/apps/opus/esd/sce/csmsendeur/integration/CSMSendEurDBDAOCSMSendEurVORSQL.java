/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSMSendEurDBDAOCSMSendEurVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.csmsendeur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSMSendEurDBDAOCSMSendEurVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSMSendEurVO
	  * </pre>
	  */
	public CSMSendEurDBDAOCSMSendEurVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.csmsendeur.integration").append("\n"); 
		query.append("FileName : CSMSendEurDBDAOCSMSendEurVORSQL").append("\n"); 
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
		query.append("'' as act_rcv_no," ).append("\n"); 
		query.append("'' as bkg_no," ).append("\n"); 
		query.append("'' as act_dt," ).append("\n"); 
		query.append("'' as cntr_no," ).append("\n"); 
		query.append("'' as csm_cnt_cd," ).append("\n"); 
		query.append("'' as is_multi_rows," ).append("\n"); 
		query.append("'' as nod_cd," ).append("\n"); 
		query.append("'' as act_rcv_dt," ).append("\n"); 
		query.append("'' as act_sts_mapg_cd," ).append("\n"); 
		query.append("'' as act_umch_tp_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}