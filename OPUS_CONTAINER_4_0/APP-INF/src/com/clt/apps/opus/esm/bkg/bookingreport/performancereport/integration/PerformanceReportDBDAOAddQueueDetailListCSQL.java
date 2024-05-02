/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueDetailListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOAddQueueDetailListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOAddQueueDetailListCSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOAddQueueDetailListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("message",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_kind",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wrk_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddQueueDetailListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SR_KND_CD," ).append("\n"); 
		query.append("SR_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("SR_HIS_SEQ," ).append("\n"); 
		query.append("SR_STS_CD," ).append("\n"); 
		query.append("SR_PROC_STS_CD," ).append("\n"); 
		query.append("ATND_USR_ID," ).append("\n"); 
		query.append("ST_DT," ).append("\n"); 
		query.append("DIFF_RMK," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[sr_kind]," ).append("\n"); 
		query.append("@[sr_no]," ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("(SELECT NVL(MAX(SR_HIS_SEQ),0)+1" ).append("\n"); 
		query.append("FROM   BKG_SR_HIS" ).append("\n"); 
		query.append("WHERE SR_KND_CD =@[sr_kind]" ).append("\n"); 
		query.append("AND SR_NO =@[sr_no]" ).append("\n"); 
		query.append("AND BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("DECODE(@[wrk_grp_cd], 'I', 'ID', 'R', 'RD', 'A', 'AD', '  ')," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[message]," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}