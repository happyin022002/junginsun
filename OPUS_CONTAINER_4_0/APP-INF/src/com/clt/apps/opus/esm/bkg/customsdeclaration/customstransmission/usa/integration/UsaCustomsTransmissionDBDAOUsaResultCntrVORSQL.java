/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOUsaResultCntrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.06 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOUsaResultCntrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOUsaResultCntrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOUsaResultCntrVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' in_bl" ).append("\n"); 
		query.append(", '' in_vvd" ).append("\n"); 
		query.append(", '' in_pod" ).append("\n"); 
		query.append(", '' icr_seq" ).append("\n"); 
		query.append(", '' old_cntr_c_flag" ).append("\n"); 
		query.append(", '' qty_69" ).append("\n"); 
		query.append(", '' irc_qty" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}