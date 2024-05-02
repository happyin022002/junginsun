/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOUsaHistoryInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.22 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOUsaHistoryInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, UsaHistoryInfoVO 생성용
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOUsaHistoryInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOUsaHistoryInfoVORSQL").append("\n"); 
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
		query.append("'' cnt_cd," ).append("\n"); 
		query.append("'' bl_no," ).append("\n"); 
		query.append("'' his_seq," ).append("\n"); 
		query.append("'' cre_usr_id," ).append("\n"); 
		query.append("'' upd_usr_id," ).append("\n"); 
		query.append("'' his_tp_id," ).append("\n"); 
		query.append("'' his_itm_ctnt," ).append("\n"); 
		query.append("'' pre_ctnt," ).append("\n"); 
		query.append("'' crnt_ctnt" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}