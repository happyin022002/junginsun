/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateGuidelineDBDAORsltRtCmdtDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.05 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungsoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateGuidelineDBDAORsltRtCmdtDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cmdt Detail조회
	  * </pre>
	  */
	public SCRateGuidelineDBDAORsltRtCmdtDetailVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT a.svc_scp_cd," ).append("\n"); 
		query.append("a.gline_seq," ).append("\n"); 
		query.append("a.prc_cust_tp_cd," ).append("\n"); 
		query.append("a.cmdt_hdr_seq," ).append("\n"); 
		query.append("a.cmdt_seq," ).append("\n"); 
		query.append("a.prc_cmdt_tp_cd," ).append("\n"); 
		query.append("a.prc_cmdt_def_cd," ).append("\n"); 
		query.append("decode(a.prc_cmdt_tp_cd," ).append("\n"); 
		query.append("'G'," ).append("\n"); 
		query.append("(SELECT prc_grp_cmdt_desc" ).append("\n"); 
		query.append("FROM pri_sg_grp_cmdt" ).append("\n"); 
		query.append("WHERE svc_scp_cd = a.svc_scp_cd" ).append("\n"); 
		query.append("AND gline_seq = a.gline_seq" ).append("\n"); 
		query.append("AND prc_cust_tp_cd = a.prc_cust_tp_cd" ).append("\n"); 
		query.append("AND prc_grp_cmdt_cd = a.prc_cmdt_def_cd" ).append("\n"); 
		query.append("AND rownum = 1)," ).append("\n"); 
		query.append("'C'," ).append("\n"); 
		query.append("(SELECT cmdt_nm" ).append("\n"); 
		query.append("FROM mdm_commodity" ).append("\n"); 
		query.append("WHERE cmdt_cd = a.prc_cmdt_def_cd" ).append("\n"); 
		query.append("AND rownum = 1)) AS prc_cmdt_def_nm," ).append("\n"); 
		query.append("a.cre_usr_id," ).append("\n"); 
		query.append("a.cre_dt," ).append("\n"); 
		query.append("a.upd_usr_id," ).append("\n"); 
		query.append("a.upd_dt" ).append("\n"); 
		query.append("FROM pri_sg_rt_cmdt a" ).append("\n"); 
		query.append("WHERE a.svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND a.gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("AND a.prc_cust_tp_cd = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("ORDER BY decode(a.prc_cmdt_tp_cd, 'G', '1', 'C', '2'), a.prc_cmdt_def_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAORsltRtCmdtDetailVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}