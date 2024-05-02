/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchActRcvIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.04 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchActRcvIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * actual mapping 내역을 조회한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchActRcvIfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_umch_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchActRcvIfRSQL").append("\n"); 
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
		query.append("select act_rcv_dt," ).append("\n"); 
		query.append("  act_rcv_no," ).append("\n"); 
		query.append("  bkg_no," ).append("\n"); 
		query.append("  cntr_no," ).append("\n"); 
		query.append("  act_dt," ).append("\n"); 
		query.append("  act_sts_mapg_cd," ).append("\n"); 
		query.append("  nod_cd," ).append("\n"); 
		query.append("  act_rcv_tp_cd," ).append("\n"); 
		query.append("  umch_chk_dt," ).append("\n"); 
		query.append("  vsl_cd," ).append("\n"); 
		query.append("  skd_voy_no," ).append("\n"); 
		query.append("  skd_dir_cd," ).append("\n"); 
		query.append("  err_msg," ).append("\n"); 
		query.append("  cop_evnt_seq" ).append("\n"); 
		query.append("from sce_act_rcv_if" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("	act_rcv_dt between @[act_fm_dt] and @[act_to_dt]" ).append("\n"); 
		query.append("#if (${act_bkg_no} != '') " ).append("\n"); 
		query.append("	and bkg_no = @[act_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_cntr_no} != '') " ).append("\n"); 
		query.append("	and cntr_no = @[act_cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_bl_no} != '') " ).append("\n"); 
		query.append("	and bkg_no = (select bkg_no from bkg_booking where bl_no = @[act_bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_cop_no} != '') " ).append("\n"); 
		query.append("	and cop_no = @[act_cop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_umch_tp_cd} != '') " ).append("\n"); 
		query.append("	and act_umch_tp_cd = @[act_umch_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${act_rcv_tp_cd} != '') " ).append("\n"); 
		query.append("	and act_rcv_tp_cd = @[act_rcv_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}