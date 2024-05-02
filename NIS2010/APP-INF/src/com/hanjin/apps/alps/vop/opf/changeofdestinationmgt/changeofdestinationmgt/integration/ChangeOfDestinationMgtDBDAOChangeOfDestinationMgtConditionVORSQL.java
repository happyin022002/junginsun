/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOChangeOfDestinationMgtConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.03.04 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOChangeOfDestinationMgtConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOChangeOfDestinationMgtConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOChangeOfDestinationMgtConditionVORSQL").append("\n"); 
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
		query.append("  '' vsl_cd      " ).append("\n"); 
		query.append(", '' rso  " ).append("\n"); 
		query.append(", '' cnt" ).append("\n"); 
		query.append(", '' skd_voy_no" ).append("\n"); 
		query.append(", '' old_pod" ).append("\n"); 
		query.append(", '' cntr_cgo_tp_cd" ).append("\n"); 
		query.append(", '' bl_no" ).append("\n"); 
		query.append(", '' skd_dir_cd" ).append("\n"); 
		query.append(", '' pagerows" ).append("\n"); 
		query.append(", '' vvd   " ).append("\n"); 
		query.append(", '' ibflag" ).append("\n"); 
		query.append(", '' bkg_no      " ).append("\n"); 
		query.append(", '' tpsz" ).append("\n"); 
		query.append(", '' cod_rhnd_port_cd" ).append("\n"); 
		query.append(", '' slan_cd" ).append("\n"); 
		query.append(", '' cod_rqst_seq" ).append("\n"); 
		query.append(", '' new_pod" ).append("\n"); 
		query.append(", '' cod" ).append("\n"); 
		query.append(", '' cgo_cate_cd" ).append("\n"); 
		query.append(", '' cod_rqst_rsn_cd" ).append("\n"); 
		query.append(", '' cod_sts_cd " ).append("\n"); 
		query.append(", '' fr_dt       " ).append("\n"); 
		query.append(", '' to_dt " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}