/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Reason 코드의 정합성을 체크한다.
	  * 2011.08.16 김민아 [CHM-201112982] [TDR] R/H의 acct 관련 보완요청 : 두개의 코드 값을 한번에 체크한다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstwg_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL").append("\n"); 
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
		query.append("SELECT  RSTWG_RSN_CD" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  RSTWG_RSN_CD" ).append("\n"); 
		query.append("               ,MAX(RSTWG_RSN_CD_FULL_DESC) AS RSTWG_RSN_CD_FULL_DESC" ).append("\n"); 
		query.append("               ,SUM(COUNT(1)) OVER() AS TOT_CNT" ).append("\n"); 
		query.append("               ,DELT_FLG" ).append("\n"); 
		query.append("          FROM  OPF_RSTWG_RSN_CD" ).append("\n"); 
		query.append("         WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND  (RSTWG_CD_TP_CD = 'S' AND RSTWG_RSN_CD = SUBSTR(@[rstwg_rsn_cd], 1, 1))" ).append("\n"); 
		query.append("            OR  (RSTWG_CD_TP_CD = 'R' AND RSTWG_RSN_CD = SUBSTR(@[rstwg_rsn_cd], 2))" ).append("\n"); 
		query.append("        GROUP BY RSTWG_RSN_CD, DELT_FLG, RSTWG_CD_TP_CD" ).append("\n"); 
		query.append("        ORDER BY RSTWG_CD_TP_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  TOT_CNT > 1" ).append("\n"); 
		query.append("   AND  ROWNUM = 1" ).append("\n"); 
		query.append("GROUP BY RSTWG_RSN_CD, DELT_FLG" ).append("\n"); 

	}
}