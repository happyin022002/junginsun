/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOUsaMiHiHeadFootRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.13 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOUsaMiHiHeadFootRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim VO생성용
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOUsaMiHiHeadFootRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOUsaMiHiHeadFootRSQL").append("\n"); 
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
		query.append("SELECT '' trsp_msg_tp_cd, '' vvd, '' vsl_flag, '' vsl_eng_nm," ).append("\n"); 
		query.append("'' bl_cnt, '' vsl_lloyd, '' loc_amsport, '' vps_eta_dt, '' vps_etd_dt," ).append("\n"); 
		query.append("'' line_count, '' master_bl_cnt, '' pol_name, '' pod_name, '' crr_bat_no" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}