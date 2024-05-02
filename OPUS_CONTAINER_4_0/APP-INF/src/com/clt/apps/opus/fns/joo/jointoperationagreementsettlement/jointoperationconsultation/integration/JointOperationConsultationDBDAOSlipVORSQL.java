/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlipVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlipVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 0024, 0069
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlipVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlipVORSQL").append("\n"); 
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
		query.append("SELECT rownum seq_num," ).append("\n"); 
		query.append("	   s.dr_cr_cd," ).append("\n"); 
		query.append("       s.acct_cd ," ).append("\n"); 
		query.append("       DECODE(c.slp_tp_cd,'06',''||vndr_seq, '18', cust_cnt_cd" ).append("\n"); 
		query.append("              ||cust_seq) vndr," ).append("\n"); 
		query.append("       s.ctr_cd           ," ).append("\n"); 
		query.append("       s.loc_cd           ," ).append("\n"); 
		query.append("       TO_CHAR(s.eff_dt, 'yyyy-mm-dd') eff_dt," ).append("\n"); 
		query.append("       s.csr_locl_amt     ," ).append("\n"); 
		query.append("       s.slp_desc         ," ).append("\n"); 
		query.append("       s.vsl_cd           ," ).append("\n"); 
		query.append("       s.skd_voy_no       ," ).append("\n"); 
		query.append("       s.skd_dir_cd       ," ).append("\n"); 
		query.append("       s.rev_dir_cd       ," ).append("\n"); 
		query.append("       s.key_no           ," ).append("\n"); 
		query.append("       s.vsl_cd||s.skd_voy_no||s.skd_dir_cd||s.rev_dir_cd as vvd" ).append("\n"); 
		query.append("FROM   joo_csr c," ).append("\n"); 
		query.append("       joo_slip s" ).append("\n"); 
		query.append("WHERE  1             =1" ).append("\n"); 
		query.append("   AND c.slp_tp_cd   = s.slp_tp_cd" ).append("\n"); 
		query.append("   AND c.slp_func_cd = s.slp_func_cd" ).append("\n"); 
		query.append("   AND c.slp_ofc_cd  = s.slp_ofc_cd" ).append("\n"); 
		query.append("   AND c.slp_iss_dt  = s.slp_iss_dt" ).append("\n"); 
		query.append("   AND c.slp_ser_no  = s.slp_ser_no" ).append("\n"); 
		query.append("   AND c.slp_tp_cd || c.slp_func_cd || c.slp_ofc_cd || c.slp_iss_dt || c.slp_ser_no  = @[csr_no]" ).append("\n"); 
		query.append("#if (${fr_dt} != '' && ${to_dt}  != '')" ).append("\n"); 
		query.append("	#if (${gubun} == 'slp_iss_dt') " ).append("\n"); 
		query.append("	AND c.cre_dt between to_date(REPLACE(@[fr_dt],'-',''), 'YYYYMMDD') and to_date(REPLACE(@[to_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("	#elseif (${gubun} == 'eff_dt')  " ).append("\n"); 
		query.append("    AND c.eff_dt between to_date(REPLACE(@[fr_dt],'-',''), 'YYYYMMDD') and to_date(REPLACE(@[to_dt],'-',''), 'YYYYMMDD')	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}