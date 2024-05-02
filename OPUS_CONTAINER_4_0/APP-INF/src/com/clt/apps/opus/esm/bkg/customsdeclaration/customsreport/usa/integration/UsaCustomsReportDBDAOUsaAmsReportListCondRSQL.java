/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsReportDBDAOUsaAmsReportListCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.19 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOUsaAmsReportListCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0041화면 조회조건, AmsReportListCondVO 생성용
	  * </pre>
	  */
	public UsaCustomsReportDBDAOUsaAmsReportListCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOUsaAmsReportListCondRSQL").append("\n"); 
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
		query.append("SELECT '' vvd," ).append("\n"); 
		query.append("	'' pol," ).append("\n"); 
		query.append("	'' pod," ).append("\n"); 
		query.append("	'' hub," ).append("\n"); 
		query.append("	'' eq_ofc," ).append("\n"); 
		query.append("	'' b_stf," ).append("\n"); 
		query.append("	'' l_rep," ).append("\n"); 
		query.append("	'' rcv_term_cd," ).append("\n"); 
		query.append("	'' de_term_cd," ).append("\n"); 
		query.append("	'' pmib_tp," ).append("\n"); 
		query.append("	'' filer," ).append("\n"); 
		query.append("	'' customs_result_code_grp," ).append("\n"); 
		query.append("	'' customs_result_code," ).append("\n"); 
		query.append("	'' cust_arr_exp," ).append("\n"); 
		query.append("	'' fromd," ).append("\n"); 
		query.append("	'' tod," ).append("\n"); 
		query.append("	'' fromt," ).append("\n"); 
		query.append("	'' tot," ).append("\n"); 
		query.append("	'' mbl_no," ).append("\n"); 
		query.append("	'' ams_file_no," ).append("\n"); 
		query.append("	'' pgm_no," ).append("\n"); 
		query.append("	'' date_search," ).append("\n"); 
		query.append("	'' general_or_rail," ).append("\n"); 
		query.append("	'' tmp1," ).append("\n"); 
		query.append("	'' tmp2," ).append("\n"); 
		query.append("	'' tmp3," ).append("\n"); 
		query.append("	'' tmp4," ).append("\n"); 
		query.append("	'' tmp5," ).append("\n"); 
		query.append("	'' start_no," ).append("\n"); 
		query.append("	'' end_no," ).append("\n"); 
		query.append("	'' page_no," ).append("\n"); 
		query.append("	'' excl_rls" ).append("\n"); 
		query.append("   ,'' last_bl" ).append("\n"); 
		query.append("   ,'' last_rnum" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}