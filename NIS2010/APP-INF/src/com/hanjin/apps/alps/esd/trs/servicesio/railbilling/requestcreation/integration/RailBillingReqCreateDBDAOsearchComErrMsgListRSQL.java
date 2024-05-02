/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchComErrMsgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.11.02 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchComErrMsgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RailBilling Verify 결과 메세지를 return 하기 위한 Com Error Msg 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchComErrMsgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchComErrMsgListRSQL").append("\n"); 
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
		query.append("SELECT err_msg_cd" ).append("\n"); 
		query.append(", lang_tp_cd" ).append("\n"); 
		query.append(", ERR_LVL_CD err_tp_cd" ).append("\n"); 
		query.append(", err_msg" ).append("\n"); 
		query.append("FROM com_err_msg" ).append("\n"); 
		query.append("WHERE err_msg_cd like 'TRS%'" ).append("\n"); 
		query.append("AND lang_tp_cd = 'ENG'" ).append("\n"); 

	}
}