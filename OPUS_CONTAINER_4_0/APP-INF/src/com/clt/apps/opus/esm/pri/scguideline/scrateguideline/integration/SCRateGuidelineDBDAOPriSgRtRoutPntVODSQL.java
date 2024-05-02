/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.05.13 박성수
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

public class SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route Point 삭제
	  * </pre>
	  */
	public SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM pri_sg_rt_rout_pnt" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND gline_seq = @[gline_seq]" ).append("\n"); 
		query.append("AND prc_cust_tp_cd = @[prc_cust_tp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == \"1\")" ).append("\n"); 
		query.append("AND cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == \"2\")" ).append("\n"); 
		query.append("AND cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND cmdt_hdr_seq = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND rout_seq = @[rout_seq]" ).append("\n"); 
		query.append("AND org_dest_tp_cd = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("AND rout_pnt_seq = @[rout_pnt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scrateguideline.integration").append("\n"); 
		query.append("FileName : SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}