/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOSendDetailLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.09 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOSendDetailLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SendDetailLogVO 생성용
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOSendDetailLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOSendDetailLogRSQL").append("\n"); 
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
		query.append("'' snd_proc_id," ).append("\n"); 
		query.append("'' seq," ).append("\n"); 
		query.append("'' vvd," ).append("\n"); 
		query.append("'' pol," ).append("\n"); 
		query.append("'' pod," ).append("\n"); 
		query.append("'' cntr_count," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' usr_id," ).append("\n"); 
		query.append("'' msg," ).append("\n"); 
		query.append("'' tmp1," ).append("\n"); 
		query.append("'' tmp2," ).append("\n"); 
		query.append("'' tmp3," ).append("\n"); 
		query.append("'' snd_dt," ).append("\n"); 
		query.append("'' dtl_seq," ).append("\n"); 
		query.append("'' bl_no" ).append("\n"); 
		query.append(",'' isf_act_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}