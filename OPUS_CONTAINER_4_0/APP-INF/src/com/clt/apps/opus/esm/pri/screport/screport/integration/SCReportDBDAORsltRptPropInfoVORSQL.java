/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCReportDBDAORsltRptPropInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltRptPropInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltRptPropInfoVO
	  * </pre>
	  */
	public SCReportDBDAORsltRptPropInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltRptPropInfoVORSQL").append("\n"); 
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
		query.append("WITH input_params AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("prop_no                 ," ).append("\n"); 
		query.append("MAX(amdt_seq) amdt_seq" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_mn" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_no =" ).append("\n"); 
		query.append("#if (${sc_no} != \"\")" ).append("\n"); 
		query.append("(SELECT prop_no FROM pri_sp_hdr WHERE sc_no = @[sc_no])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("@[prop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND prop_sts_cd in ('I','Q','A','F')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("prop_no" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("mn.prop_no      		," ).append("\n"); 
		query.append("mn.amdt_seq     		," ).append("\n"); 
		query.append("TO_CHAR(dur.ctrt_eff_dt,'YYYY-MM-DD') eff_dt," ).append("\n"); 
		query.append("TO_CHAR(dur.ctrt_exp_dt,'YYYY-MM-DD') exp_dt" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("input_params hdr  	," ).append("\n"); 
		query.append("pri_sp_mn mn    	," ).append("\n"); 
		query.append("pri_sp_dur dur" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("hdr.prop_no 	= mn.prop_no" ).append("\n"); 
		query.append("AND hdr.amdt_seq 	= mn.amdt_seq" ).append("\n"); 
		query.append("AND hdr.prop_no 	= dur.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq 	= dur.amdt_seq" ).append("\n"); 

	}
}