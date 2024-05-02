/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOChangeOfDestinationMgtConditionVORSQL.java
*@FileTitle : ChangeOfDestinationMgtDBDAOCODEmailSendRSQL
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.07.29 원종규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
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
		query.append("'' rso" ).append("\n"); 
		query.append(",   '' slan_cd" ).append("\n"); 
		query.append(",   '' vsl_cd" ).append("\n"); 
		query.append(",   '' skd_voy_no" ).append("\n"); 
		query.append(",   '' skd_dir_cd" ).append("\n"); 
		query.append(",   '' cod" ).append("\n"); 
		query.append(",   '' bkg_no" ).append("\n"); 
		query.append(",   '' bl_no" ).append("\n"); 
		query.append(",   '' vvd                --TES Parameter" ).append("\n"); 
		query.append(",   '' cod_rqst_seq" ).append("\n"); 
		query.append(",   '' cnt" ).append("\n"); 
		query.append(",   '' old_pod" ).append("\n"); 
		query.append(",   '' cod_rhnd_port_cd   --TES Parameter" ).append("\n"); 
		query.append(",   '' tpsz               --TES Parameter" ).append("\n"); 
		query.append(",   '' cntr_cgo_tp_cd     --TES Parameter" ).append("\n"); 
		query.append(",   '' new_pod" ).append("\n"); 
		query.append(",   '' cgo_cate_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}