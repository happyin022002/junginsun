/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.24 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Woo-Seok
 * @see 
 * @since J2EE 1.4
 */

public class TCharIODeliveryScheduleDAOFmsShpYdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ship Yard Registration / Window Update
	  * </pre>
	  */
	public TCharIODeliveryScheduleDAOFmsShpYdUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_yd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update fms_shp_yd set" ).append("\n"); 
		query.append("shp_yd_nm = @[shp_yd_nm]," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("where	yd_seq = @[yd_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration").append("\n"); 
		query.append("FileName : TCharIODeliveryScheduleDAOFmsShpYdUSQL").append("\n"); 
		query.append("Developer: 최우석").append("\n");
		query.append("*/").append("\n"); 
	}
}