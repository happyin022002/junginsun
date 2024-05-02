/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCReportDBDAORsltRptPropListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltRptPropListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltRptPropList
	  * </pre>
	  */
	public SCReportDBDAORsltRptPropListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltRptPropListVORSQL").append("\n"); 
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
		query.append("hdr.sc_no			," ).append("\n"); 
		query.append("mn.amdt_seq			," ).append("\n"); 
		query.append("mn.prop_no			," ).append("\n"); 
		query.append("pty.ctrt_pty_nm		," ).append("\n"); 
		query.append("mn.prop_ofc_cd		," ).append("\n"); 
		query.append("CASE WHEN mqc.fnl_mqc_qty IS NULL OR mqc.fnl_mqc_qty = 0 THEN mqc.prop_mqc_qty" ).append("\n"); 
		query.append("ELSE mqc.fnl_mqc_qty" ).append("\n"); 
		query.append("END AS fnl_mqc_qty," ).append("\n"); 
		query.append("TO_CHAR(dur.ctrt_eff_dt,'YYYY-MM-DD') eff_dt			," ).append("\n"); 
		query.append("TO_CHAR(dur.ctrt_exp_dt,'YYYY-MM-DD') exp_dt			," ).append("\n"); 
		query.append("TO_CHAR(mn.file_dt,'YYYY-MM-DD') file_dt" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_hdr hdr      ," ).append("\n"); 
		query.append("pri_sp_mn mn        ," ).append("\n"); 
		query.append("pri_sp_dur dur      ," ).append("\n"); 
		query.append("pri_sp_ctrt_pty pty ," ).append("\n"); 
		query.append("pri_sp_mqc mqc" ).append("\n"); 
		query.append("#if (${cd_tp} == \"3\")" ).append("\n"); 
		query.append(",(SELECT" ).append("\n"); 
		query.append("prop_no,amdt_seq    ," ).append("\n"); 
		query.append("MAX(prop_prog_seq)  ," ).append("\n"); 
		query.append("prop_sts_cd         ," ).append("\n"); 
		query.append("prog_usr_id         ," ).append("\n"); 
		query.append("prog_ofc_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("pri_sp_prog" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("prop_sts_cd = 'A'" ).append("\n"); 
		query.append("AND prog_ofc_cd = @[cd1]" ).append("\n"); 
		query.append("AND prog_usr_id = @[cd2]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("prop_no," ).append("\n"); 
		query.append("amdt_seq," ).append("\n"); 
		query.append("prop_sts_cd," ).append("\n"); 
		query.append("prog_usr_id," ).append("\n"); 
		query.append("prog_ofc_cd) prog" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("hdr.prop_no = mn.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq = (SELECT MAX(amdt_seq)from pri_sp_mn mn where mn.prop_no = hdr.prop_no and mn.prop_sts_cd in ('I','Q', 'A', 'F'))" ).append("\n"); 
		query.append("AND mn.prop_no  = pty.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq = pty.amdt_seq" ).append("\n"); 
		query.append("AND mn.prop_no  = mqc.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq = mqc.amdt_seq" ).append("\n"); 
		query.append("AND mn.prop_no  = dur.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq = dur.amdt_seq" ).append("\n"); 
		query.append("AND pty.prc_ctrt_pty_tp_cd = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cd_tp} == \"1\")" ).append("\n"); 
		query.append("AND hdr.sc_no = @[cd1]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${cd_tp} == \"2\")" ).append("\n"); 
		query.append("AND mn.prop_no = @[cd1]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${cd_tp} == \"3\")" ).append("\n"); 
		query.append("AND mn.prop_no    = prog.prop_no" ).append("\n"); 
		query.append("AND mn.amdt_seq   = prog.amdt_seq" ).append("\n"); 
		query.append("AND mn.file_dt BETWEEN TO_DATE(NVL(@[eff_dt],'00010101'),'YYYYMMDD') AND TO_DATE(NVL(@[exp_dt],'99991231'),'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${cd_tp} == \"4\")" ).append("\n"); 
		query.append("AND mn.prop_ofc_cd = @[cd1]" ).append("\n"); 
		query.append("AND mn.prop_srep_cd LIKE @[cd2]||'%'" ).append("\n"); 
		query.append("AND mn.cre_dt BETWEEN TO_DATE(NVL(@[eff_dt],'00010101'),'YYYYMMDD') AND TO_DATE(NVL(@[exp_dt],'99991231'),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}