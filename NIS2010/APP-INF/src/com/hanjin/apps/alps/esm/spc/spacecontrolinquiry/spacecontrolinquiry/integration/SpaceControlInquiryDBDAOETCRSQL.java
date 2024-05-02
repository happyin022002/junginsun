/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOETCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.05
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.08.05 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceControlInquiryDBDAOETCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ETC Data
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOETCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpaceControlInquiryDBDAOETCRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM AS NUM," ).append("\n"); 
		query.append("         Z.COST_YR    ," ).append("\n"); 
		query.append("         Z.COST_WK1   ," ).append("\n"); 
		query.append("         Z.SLS_FM_DT  ," ).append("\n"); 
		query.append("         Z.SLS_TO_DT" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("            SELECT T.COST_YR   AS COST_YR  ," ).append("\n"); 
		query.append("                   T.COST_WK   AS COST_WK1 ," ).append("\n"); 
		query.append("                   T.SLS_FM_DT AS SLS_FM_DT," ).append("\n"); 
		query.append("                   T.SLS_TO_DT AS SLS_TO_DT" ).append("\n"); 
		query.append("              FROM MAS_WK_PRD T" ).append("\n"); 
		query.append("              WHERE T.COST_YR||T.COST_WK >= (SELECT MIN(DISTINCT(SUBSTR(SLS_YRMON, 1,4)||COST_WK))" ).append("\n"); 
		query.append("                								FROM MAS_MON_VVD" ).append("\n"); 
		query.append("												WHERE COST_YRMON = @[rev_month]" ).append("\n"); 
		query.append("												AND TRD_CD = @[trade]" ).append("\n"); 
		query.append("--               								WHERE SLS_YRMON = '201301'" ).append("\n"); 
		query.append("                                                AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("               AND T.COST_YR||T.COST_WK <= (SELECT MAX(DISTINCT(SUBSTR(SLS_YRMON, 1,4)||COST_WK))" ).append("\n"); 
		query.append("                								FROM MAS_MON_VVD" ).append("\n"); 
		query.append("												WHERE COST_YRMON = @[rev_month]" ).append("\n"); 
		query.append("												AND TRD_CD = @[trade]" ).append("\n"); 
		query.append("--               								WHERE SLS_YRMON = '201301'" ).append("\n"); 
		query.append("                                                AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("          ORDER BY T.COST_YR||T.COST_WK" ).append("\n"); 
		query.append("         ) Z" ).append("\n"); 
		query.append("ORDER BY NUM     ," ).append("\n"); 
		query.append("         COST_YR ," ).append("\n"); 
		query.append("         COST_WK1" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("            SELECT T.COST_YR   AS COST_YR  ," ).append("\n"); 
		query.append("                   T.COST_WK   AS COST_WK1 ," ).append("\n"); 
		query.append("                   T.SLS_FM_DT AS SLS_FM_DT," ).append("\n"); 
		query.append("                   T.SLS_TO_DT AS SLS_TO_DT" ).append("\n"); 
		query.append("              FROM MAS_WK_PRD T" ).append("\n"); 
		query.append("             WHERE T.COST_YR||T.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("          ORDER BY T.COST_YR||T.COST_WK" ).append("\n"); 
		query.append("         ) Z" ).append("\n"); 
		query.append("   WHERE ROWNUM <= @[duration]" ).append("\n"); 
		query.append("ORDER BY NUM     ," ).append("\n"); 
		query.append("         COST_YR ," ).append("\n"); 
		query.append("         COST_WK1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
