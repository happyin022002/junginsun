/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateGuidelineDBDAORsltRateCustTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.12 박성수
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
 * @since J2EE 1.4
 */

public class SCRateGuidelineDBDAORsltRateCustTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate - Customer Type 재조회
	  * </pre>
	  */
	public SCRateGuidelineDBDAORsltRateCustTpRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
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
		query.append("SELECT a.intg_cd_val_ctnt as cd," ).append("\n"); 
		query.append("a.intg_cd_val_dp_desc nm," ).append("\n"); 
		query.append("nvl(b.rate_cnt, 0) as rate_cnt" ).append("\n"); 
		query.append("FROM nisadm.com_intg_cd_dtl a," ).append("\n"); 
		query.append("(SELECT prc_cust_tp_cd, COUNT(*) AS rate_cnt" ).append("\n"); 
		query.append("FROM pri_sg_rt_cmdt_hdr" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("GROUP BY svc_scp_cd, gline_seq, prc_cust_tp_cd) b" ).append("\n"); 
		query.append("WHERE a.intg_cd_val_ctnt = b.prc_cust_tp_cd(+)" ).append("\n"); 
		query.append("AND a.intg_cd_id = 'CD01714'" ).append("\n"); 
		query.append("ORDER BY a.intg_cd_val_dp_seq" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAORsltRateCustTpRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}