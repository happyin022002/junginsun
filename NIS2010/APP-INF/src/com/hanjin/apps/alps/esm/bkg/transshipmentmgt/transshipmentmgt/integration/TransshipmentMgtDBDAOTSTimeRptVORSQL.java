/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TransshipmentMgtDBDAOTSTimeRptVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.27
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.01.27 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOTSTimeRptVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransshipmentMgtDBDAOTSTimeRptVORSQL
	  * </pre>
	  */
	public TransshipmentMgtDBDAOTSTimeRptVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOTSTimeRptVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'' as trade," ).append("\n"); 
		query.append("'' as sub_trade," ).append("\n"); 
		query.append("'' as lane," ).append("\n"); 
		query.append("'' as vvd," ).append("\n"); 
		query.append("'' as division," ).append("\n"); 
		query.append("'' as total," ).append("\n"); 
		query.append("'' as dt_seq," ).append("\n"); 
		query.append("'' as yard_cd," ).append("\n"); 
		query.append("'' as cntr_no," ).append("\n"); 
		query.append("'' as s_days," ).append("\n"); 
		query.append("'' as type_size," ).append("\n"); 
		query.append("'' as mv," ).append("\n"); 
		query.append("'' as event_date," ).append("\n"); 
		query.append("'' as bl_no," ).append("\n"); 
		query.append("'' as pol," ).append("\n"); 
		query.append("'' as next_port," ).append("\n"); 
		query.append("'' as pod," ).append("\n"); 
		query.append("'' as lane," ).append("\n"); 
		query.append("'' as former_vvd," ).append("\n"); 
		query.append("'' as lane," ).append("\n"); 
		query.append("'' as next_vvd," ).append("\n"); 
		query.append("'' as etd_date," ).append("\n"); 
		query.append("''  AS COUNT01," ).append("\n"); 
		query.append("''  AS COUNT02," ).append("\n"); 
		query.append("''  AS COUNT03," ).append("\n"); 
		query.append("''  AS COUNT04," ).append("\n"); 
		query.append("''  AS COUNT05," ).append("\n"); 
		query.append("''  AS COUNT06," ).append("\n"); 
		query.append("''  AS COUNT07," ).append("\n"); 
		query.append("''  AS COUNT08," ).append("\n"); 
		query.append("''  AS COUNT09," ).append("\n"); 
		query.append("''  AS COUNT10," ).append("\n"); 
		query.append("''  AS COUNT11," ).append("\n"); 
		query.append("''  AS COUNT12," ).append("\n"); 
		query.append("''  AS COUNT13," ).append("\n"); 
		query.append("''  AS COUNT14," ).append("\n"); 
		query.append("''  AS COUNT15," ).append("\n"); 
		query.append("''  AS COUNT16," ).append("\n"); 
		query.append("''  AS COUNT17," ).append("\n"); 
		query.append("''  AS COUNT18," ).append("\n"); 
		query.append("''  AS COUNT19," ).append("\n"); 
		query.append("''  AS COUNT20," ).append("\n"); 
		query.append("''  AS COUNT21," ).append("\n"); 
		query.append("''  AS COUNT22," ).append("\n"); 
		query.append("''  AS COUNT23," ).append("\n"); 
		query.append("''  AS COUNT24," ).append("\n"); 
		query.append("''  AS COUNT25," ).append("\n"); 
		query.append("''  AS COUNT26," ).append("\n"); 
		query.append("''  AS COUNT27," ).append("\n"); 
		query.append("''  AS COUNT28," ).append("\n"); 
		query.append("''  AS COUNT29," ).append("\n"); 
		query.append("''  AS COUNT30," ).append("\n"); 
		query.append("''  AS COUNT31," ).append("\n"); 
		query.append("''  AS COUNT32," ).append("\n"); 
		query.append("''  AS COUNT33," ).append("\n"); 
		query.append("''  AS COUNT34," ).append("\n"); 
		query.append("''  AS COUNT35," ).append("\n"); 
		query.append("''  AS COUNT36," ).append("\n"); 
		query.append("''  AS COUNT37," ).append("\n"); 
		query.append("''  AS COUNT38," ).append("\n"); 
		query.append("''  AS COUNT39," ).append("\n"); 
		query.append("''  AS COUNT40," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as pod_yd_cd," ).append("\n"); 
		query.append("'' as bkg_no," ).append("\n"); 
		query.append("'' as cntr_no," ).append("\n"); 
		query.append("'' as stay_day," ).append("\n"); 
		query.append("'' as cntr_tpsz_cd," ).append("\n"); 
		query.append("'' as cnmv_sts_cd," ).append("\n"); 
		query.append("'' as event_dt," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as bl_no," ).append("\n"); 
		query.append("'' as pol_cd," ).append("\n"); 
		query.append("'' as next_port," ).append("\n"); 
		query.append("'' as pod_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as frmr_lane," ).append("\n"); 
		query.append("'' as frmr_vvd," ).append("\n"); 
		query.append("'' as next_lane," ).append("\n"); 
		query.append("'' as next_vvd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as etd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as special," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as sh_nm," ).append("\n"); 
		query.append("'' as cn_nm," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as from_dt," ).append("\n"); 
		query.append("'' as to_dt," ).append("\n"); 
		query.append("'' as p_pol," ).append("\n"); 
		query.append("'' as p_lane," ).append("\n"); 
		query.append("'' as p_vvd," ).append("\n"); 
		query.append("'' as p_company," ).append("\n"); 
		query.append("'' as p_type_size," ).append("\n"); 
		query.append("'' as p_soc," ).append("\n"); 
		query.append("'' as location," ).append("\n"); 
		query.append("'' as period," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'' as tpsz," ).append("\n"); 
		query.append("'' as rdtype," ).append("\n"); 
		query.append("'' as tscntr," ).append("\n"); 
		query.append("'' as soc," ).append("\n"); 
		query.append("'' as inquiry_level" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}