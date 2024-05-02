/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgSrFaxListVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.19 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBkgSrFaxListVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOBkgSrFaxListVOUSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgSrFaxListVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration ").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgSrFaxListVOUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_FAX SET " ).append("\n"); 
		query.append("	SR_MTCH_STS_CD = 'D'" ).append("\n"); 
		query.append(",	SR_TRNS_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",	SR_TRNS_DT = SYSDATE" ).append("\n"); 
		query.append(",   UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",   UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	SR_KND_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("AND	FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}