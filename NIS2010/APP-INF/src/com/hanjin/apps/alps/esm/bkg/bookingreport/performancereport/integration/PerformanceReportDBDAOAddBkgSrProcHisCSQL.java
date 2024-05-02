/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOAddBkgSrProcHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOAddBkgSrProcHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddBkgSrProcHis
	  * </pre>
	  */
	public PerformanceReportDBDAOAddBkgSrProcHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cate_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddBkgSrProcHisCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_PROC_HIS " ).append("\n"); 
		query.append("VALUES (@[sr_no], @[fax_log_ref_no], " ).append("\n"); 
		query.append("        (SELECT NVL(MAX(SR_PROC_SEQ),0) + 1" ).append("\n"); 
		query.append("           FROM  BKG_SR_PROC_HIS" ).append("\n"); 
		query.append("          WHERE SR_NO = @[sr_no]" ).append("\n"); 
		query.append("            AND FAX_LOG_REF_NO = @[fax_log_ref_no])," ).append("\n"); 
		query.append("        @[sr_proc_tp_cd]," ).append("\n"); 
		query.append("        GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, NVL(BKG_COM_USER_LOC_FNC(@[usr_id]), 'KRPUS'))," ).append("\n"); 
		query.append("        GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'GMT')," ).append("\n"); 
		query.append("        @[usr_id], @[pre_ctnt], @[crnt_ctnt], @[usr_id], SYSDATE, @[usr_id], SYSDATE,@[his_cate_nm])" ).append("\n"); 

	}
}