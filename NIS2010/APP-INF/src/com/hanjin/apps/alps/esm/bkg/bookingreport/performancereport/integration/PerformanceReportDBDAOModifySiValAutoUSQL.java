/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOModifySiValAutoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.21 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifySiValAutoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PerformanceReportDBDAOModifySiValAutoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o_result",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o_err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_pgm_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifySiValAutoUSQL").append("\n"); 
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
		query.append("-------------------------------------------------------- " ).append("\n"); 
		query.append("##<call_pgm_type>" ).append("\n"); 
		query.append("##B,F	BL Confim" ).append("\n"); 
		query.append("##E	AES" ).append("\n"); 
		query.append("##C	CAED" ).append("\n"); 
		query.append("##I	IE" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${call_pgm_type} == 'QA' || ${call_pgm_type} == 'B')" ).append("\n"); 
		query.append("CALL BKG_DPCS_COMMON_PKG.BL_ISSUE_UPD_PRC" ).append("\n"); 
		query.append("(@[bkg_no]" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",@[call_pgm_type]" ).append("\n"); 
		query.append(",@[o_result]" ).append("\n"); 
		query.append(",@[o_err_msg])" ).append("\n"); 
		query.append("#elseif (${call_pgm_type} == 'F' || ${call_pgm_type} == 'E' || ${call_pgm_type} == 'I' || ${call_pgm_type} == 'C')" ).append("\n"); 
		query.append("CALL BKG_DPCS_COMMON_PKG.BKG_XPT_IMP_LIC_UPD_PRC" ).append("\n"); 
		query.append("(@[bkg_no]" ).append("\n"); 
		query.append(",@[xter_sndr_id]" ).append("\n"); 
		query.append(",@[xter_rqst_no]" ).append("\n"); 
		query.append(",@[xter_rqst_seq]" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",@[o_result]" ).append("\n"); 
		query.append(",@[o_err_msg])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}