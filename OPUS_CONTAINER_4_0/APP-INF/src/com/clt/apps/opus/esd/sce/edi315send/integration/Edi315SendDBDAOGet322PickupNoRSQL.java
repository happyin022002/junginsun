/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOGet322PickupNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.10.29 전병석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGet322PickupNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for get322_pickup_no
	  * </pre>
	  */
	public Edi315SendDBDAOGet322PickupNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_curr_event_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGet322PickupNoRSQL").append("\n"); 
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
		query.append("SELECT  NVL(PKUP_EDI_322_NO,'  ') pick_no" ).append("\n"); 
		query.append("FROM edi_322_msg" ).append("\n"); 
		query.append("WHERE EVNT_DT   = TO_DATE(@[e_curr_event_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND     EQ_NO like substr(@[e_cntr_no], 1, 10) || '%'" ).append("\n"); 
		query.append("AND     PKUP_EDI_322_NO is not null" ).append("\n"); 
		query.append("AND     rownum = 1" ).append("\n"); 

	}
}