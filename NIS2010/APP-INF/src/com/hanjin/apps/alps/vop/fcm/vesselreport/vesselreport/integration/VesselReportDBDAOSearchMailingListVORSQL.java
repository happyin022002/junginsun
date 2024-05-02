/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselReportDBDAOSearchMailingListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchMailingListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mail Preview
	  * </pre>
	  */
	public VesselReportDBDAOSearchMailingListVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchMailingListVORSQL").append("\n"); 
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
		query.append("WITH A AS (" ).append("\n"); 
		query.append(" SELECT '' BODY_CONTS" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",B AS (" ).append("\n"); 
		query.append("SELECT 'DEPARTURE REPORT MISSING'||' ('||to_char(sysdate, 'YYYY/MM/DD')||')' SUBJECT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",C AS (" ).append("\n"); 
		query.append("SELECT USR_EML FROM_PSN " ).append("\n"); 
		query.append("  FROM COM_USER" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",D AS (" ).append("\n"); 
		query.append("        SELECT      SUBSTR( MAX(SYS_CONNECT_BY_PATH(VSL_EML, '; ')),2) AS TO_PSN" ).append("\n"); 
		query.append("          FROM        (" ).append("\n"); 
		query.append("                        SELECT VSL_CD" ).append("\n"); 
		query.append("                             , VSL_EML" ).append("\n"); 
		query.append("                             , SEQ" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT DISTINCT" ).append("\n"); 
		query.append("                                       INFO.VSL_CD" ).append("\n"); 
		query.append("                                     , INFO.VSL_EML VSL_EML" ).append("\n"); 
		query.append("                                     , ROWNUM SEQ" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                                  FROM MDM_VSL_CNTR  INFO" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("								#if( ${vel_vsl_cd} != '' )" ).append("\n"); 
		query.append("								   AND INFO.VSL_CD IN (" ).append("\n"); 
		query.append("                                                      #foreach($sVslCd in ${vel_vsl_cd})" ).append("\n"); 
		query.append("                                                      '$sVslCd'," ).append("\n"); 
		query.append("                                                      #end" ).append("\n"); 
		query.append("                                                      ''" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("								#end                                             " ).append("\n"); 
		query.append("                                 ) MAIL                                 " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           START WITH  SEQ = 1" ).append("\n"); 
		query.append("         CONNECT BY PRIOR SEQ = SEQ-1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",E AS (" ).append("\n"); 
		query.append("SELECT '' CC_PSN" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT (SELECT SUBJECT FROM B) SUBJECT" ).append("\n"); 
		query.append("      ,(SELECT BODY_CONTS FROM A) BODY_CONTS" ).append("\n"); 
		query.append("      ,(SELECT FROM_PSN FROM C) FROM_PSN" ).append("\n"); 
		query.append("      ,(SELECT TO_PSN FROM D) TO_PSN" ).append("\n"); 
		query.append("      ,(SELECT CC_PSN FROM E) CC_PSN" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}