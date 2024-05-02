/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReplanManageDBDAOSearchActualTerminalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchActualTerminalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * terminal change 대상을 sce_act_tml_if table 에서 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchActualTerminalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchActualTerminalRSQL").append("\n"); 
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
		query.append("act_rcv_dt, act_rcv_no, vsl_cd, skd_voy_no," ).append("\n"); 
		query.append("skd_dir_cd, vps_port_cd, clpt_ind_seq, nod_cd, clpt_ind_seq call_yd_ind_seq," ).append("\n"); 
		query.append("tml_if_sts_cd, cop_evnt_seq, cre_dt, upd_dt, call_yd_ind_cng_flg" ).append("\n"); 
		query.append("FROM SCE_ACT_TML_IF" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ACT_RCV_DT  > TO_CHAR(SYSDATE-3, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND TML_IF_STS_CD = '00'" ).append("\n"); 
		query.append("AND ROWNUM < 11" ).append("\n"); 

	}
}