/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueDetailReturn2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOAddQueueDetailReturn2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOAddQueueDetailReturn2CSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOAddQueueDetailReturn2CSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddQueueDetailReturn2CSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_AMD_RSN" ).append("\n"); 
		query.append("(   SR_KND_CD," ).append("\n"); 
		query.append("    SR_NO," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    SR_AMD_TP_CD," ).append("\n"); 
		query.append("    SR_AMD_SEQ," ).append("\n"); 
		query.append("    SR_AMD_RSN_TP_CD, SR_AMD_RSN_CD, SR_AMD_RSN_SEQ, /* 향후 삭제*/" ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 SUBSTR(@[src_cd],1,1)," ).append("\n"); 
		query.append("     @[sr_no]," ).append("\n"); 
		query.append("     @[bkg_no]," ).append("\n"); 
		query.append("     @[sr_knd_cd]/* 0421의 SR_KND_CD*//* 파라메터로 SR_AMD_TP_CD 받아옴 */," ).append("\n"); 
		query.append("    (SELECT NVL(MAX(SR_AMD_SEQ) + 1,0) " ).append("\n"); 
		query.append("                      FROM BKG_SR_AMD_RSN" ).append("\n"); 
		query.append("                     WHERE SR_KND_CD    = @[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("			  						   AND SR_NO        = @[sr_no]" ).append("\n"); 
		query.append("										   AND BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("										   AND SR_AMD_TP_CD = @[sr_knd_cd]/* 0421의 SR_KND_CD*/" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    ' ', ' ', 0, --NULL, NULL , 0, /* 향후 삭제*/" ).append("\n"); 
		query.append("     @[usr_id]," ).append("\n"); 
		query.append("     SYSDATE," ).append("\n"); 
		query.append("     @[usr_id]," ).append("\n"); 
		query.append("     SYSDATE   " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}