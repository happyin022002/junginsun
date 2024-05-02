/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateGuidelineDBDAOOrgPriSgRtRoutViaVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.12 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class SCRateGuidelineDBDAOOrgPriSgRtRoutViaVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Origin Via 조회
	  * </pre>
	  */
	public SCRateGuidelineDBDAOOrgPriSgRtRoutViaVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT svc_scp_cd," ).append("\n"); 
		query.append("gline_seq," ).append("\n"); 
		query.append("prc_cust_tp_cd," ).append("\n"); 
		query.append("cmdt_hdr_seq," ).append("\n"); 
		query.append("rout_seq," ).append("\n"); 
		query.append("org_dest_tp_cd," ).append("\n"); 
		query.append("rout_via_seq," ).append("\n"); 
		query.append("rout_via_port_tp_cd," ).append("\n"); 
		query.append("rout_via_port_def_cd," ).append("\n"); 
		query.append("decode(rout_via_port_tp_cd," ).append("\n"); 
		query.append("'G'," ).append("\n"); 
		query.append("(SELECT prc_grp_loc_desc" ).append("\n"); 
		query.append("FROM pri_sg_grp_loc" ).append("\n"); 
		query.append("WHERE svc_scp_cd = a.svc_scp_cd" ).append("\n"); 
		query.append("AND gline_seq = a.gline_seq" ).append("\n"); 
		query.append("AND prc_grp_loc_cd = a.rout_via_port_def_cd" ).append("\n"); 
		query.append("AND rownum = 1)," ).append("\n"); 
		query.append("'L'," ).append("\n"); 
		query.append("(SELECT loc_nm" ).append("\n"); 
		query.append("FROM mdm_location" ).append("\n"); 
		query.append("WHERE loc_cd = a.rout_via_port_def_cd" ).append("\n"); 
		query.append("AND rownum = 1)) AS rout_via_port_def_nm," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("FROM pri_sg_rt_rout_via a" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("AND prc_cust_tp_cd = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("AND cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("AND org_dest_tp_cd = 'O'" ).append("\n"); 
		query.append("ORDER BY decode(rout_via_port_tp_cd, 'G', '1', 'L', '2'), rout_via_port_def_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAOOrgPriSgRtRoutViaVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}