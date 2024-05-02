/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOUsaArrHeaderCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOUsaArrHeaderCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, UsaArrHeaderCondVO 생성용
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOUsaArrHeaderCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOUsaArrHeaderCondVORSQL").append("\n"); 
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
		query.append("'' vvd," ).append("\n"); 
		query.append("'' vsl_flag," ).append("\n"); 
		query.append("'' bl_cnt," ).append("\n"); 
		query.append("'' vsl_eng_nm," ).append("\n"); 
		query.append("'' tmpstr4," ).append("\n"); 
		query.append("'' vsl_lloyd," ).append("\n"); 
		query.append("'' vps_eta_dt," ).append("\n"); 
		query.append("'' crr_bat_no" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}