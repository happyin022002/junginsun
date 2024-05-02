/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이승열
*@LastVersion : 1.0
* 2009.04.28 이승열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seungyol Lee
 * @see 
 * @since J2EE 1.4
 */

public class TCharIODeliveryScheduleDAOCheckShpYdUseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ship Yard Registration Check
	  * </pre>
	  */
	public TCharIODeliveryScheduleDAOCheckShpYdUseRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("shp_nm" ).append("\n"); 
		query.append("from fms_new_bld_skd" ).append("\n"); 
		query.append("where yd_seq in (" ).append("\n"); 
		query.append("#foreach($key IN ${yd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $yd_seq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : ${comment}").append("\n"); 
		query.append("FileName : TCharIODeliveryScheduleDAOCheckShpYdUseRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}