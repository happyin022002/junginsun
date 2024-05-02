/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrsCommonDBDAOSearchTrsSOHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2012.02.23 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsCommonDBDAOSearchTrsSOHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsSOHistoryVO 를 생성하는 query 로 TRS 의 History 생성 VO 를 create 할 때 쓰인다.
	  * </pre>
	  */
	public TrsCommonDBDAOSearchTrsSOHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.trscommon.integration").append("\n"); 
		query.append("FileName : TrsCommonDBDAOSearchTrsSOHistoryVORSQL").append("\n"); 
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
		query.append("select '' as upln_so_flg," ).append("\n"); 
		query.append("  '' as inv_vndr_seq," ).append("\n"); 
		query.append("  '' as trsp_so_seq," ).append("\n"); 
		query.append("  '' as cop_no," ).append("\n"); 
		query.append("  '' as cre_dt," ).append("\n"); 
		query.append("  '' as so_rout_desc," ).append("\n"); 
		query.append("  '' as trsp_so_ofc_cty_cd," ).append("\n"); 
		query.append("  '' as rpln_umch_flg," ).append("\n"); 
		query.append("  '' as eq_no," ).append("\n"); 
		query.append("  '' as cop_pln_rout_desc," ).append("\n"); 
		query.append("  '' as trsp_so_his_desc," ).append("\n"); 
		query.append("  '' as trsp_so_sts_cd," ).append("\n"); 
		query.append("  '' as trsp_so_evnt_cd," ).append("\n"); 
		query.append("  '' as upd_usr_id," ).append("\n"); 
		query.append("  '' as cop_so_sts_cd," ).append("\n"); 
		query.append("  '' as upd_dt," ).append("\n"); 
		query.append("  '' as rout_rpln_flg," ).append("\n"); 
		query.append("  '' as wo_iss_no," ).append("\n"); 
		query.append("  '' as inv_no," ).append("\n"); 
		query.append("  '' as cost_act_grp_cd," ).append("\n"); 
		query.append("  '' as cre_usr_id," ).append("\n"); 
		query.append("  '' as cost_act_grp_seq," ).append("\n"); 
		query.append("  '' as trsp_his_seq," ).append("\n"); 
		query.append("  '' as wo_prv_grp_seq," ).append("\n"); 
		query.append("  '' as hjl_flg," ).append("\n"); 
		query.append("  '' as cre_ofc_cd," ).append("\n"); 
		query.append("  '' as src_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}