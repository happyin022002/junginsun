/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueStatusByWebSiAuditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.08 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyQueueStatusByWebSiAuditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Web SI Audit 처리된 Queue의 QA Status를 업데이트
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueStatusByWebSiAuditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueStatusByWebSiAuditUSQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST R " ).append("\n"); 
		query.append("SET SR_WRK_STS_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,DPCS_DOC_FM_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,BL_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("   ,BL_AUD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,BL_AUD_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,CRNT_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT = SYSDATE	" ).append("\n"); 
		query.append("WHERE BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                  FROM BKG_XTER_RQST_MST " ).append("\n"); 
		query.append("                  WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                  AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                  AND XTER_RQST_SEQ = @[xter_rqst_seq])" ).append("\n"); 
		query.append("AND R.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND R.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND R.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append(" AND R.SR_CRNT_STS_CD !='XX'" ).append("\n"); 

	}
}