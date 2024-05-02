/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315CurrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.03.16 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315CurrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for currinfovo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315CurrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315CurrInfoRSQL").append("\n"); 
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
		query.append("--''curr_cop_no," ).append("\n"); 
		query.append("--''curr_stnd_edi_sts_cd," ).append("\n"); 
		query.append("--''curr_act_cd," ).append("\n"); 
		query.append("--''curr_act_sts_mapg_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("''curr_event_dt                 ," ).append("\n"); 
		query.append("''curr_event_yard               ," ).append("\n"); 
		query.append("''vsl_nm," ).append("\n"); 
		query.append("''vsl_cnt_cd," ).append("\n"); 
		query.append("''lloyd_cd," ).append("\n"); 
		query.append("''curr_vvd						," ).append("\n"); 
		query.append("''curr_cop_dtl_seq              ," ).append("\n"); 
		query.append("''curr_bound" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",''pick_up_no" ).append("\n"); 
		query.append("--''rly_name," ).append("\n"); 
		query.append("--''rly_port," ).append("\n"); 
		query.append("--''rly_amsqual," ).append("\n"); 
		query.append("--''rly_amsport" ).append("\n"); 
		query.append(",'' dtl_update_skip_flag" ).append("\n"); 
		query.append("--the part from currsor is_curr_vvd" ).append("\n"); 
		query.append(",'' is_pod_ata_replace" ).append("\n"); 
		query.append(",'' pod_ata_event_dt" ).append("\n"); 
		query.append(",'' pod_ata_event_dt_gmt" ).append("\n"); 
		query.append(",'' pod_ata_yard" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}