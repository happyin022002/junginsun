/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchSalesRepVolExistListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchSalesRepVolExistListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Individual 을 언체크 할경우 해당 S.Rep, 화주, S.office 에 이번주 이후에 물량을 준게 있는지 확인한다.
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchSalesRepVolExistListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchSalesRepVolExistListRSQL").append("\n"); 
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
		query.append("SELECT  RLANE_CD||' : '||SUBSTR(XMLAGG(XMLELEMENT(COST_YRWK, ',' || COST_YRWK) ORDER BY COST_YRWK).EXTRACT('//text()'),2) COST_YRWK_LIST --order by 가능" ).append("\n"); 
		query.append("   FROM  " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A1.RLANE_CD, A3.COST_YRWK" ).append("\n"); 
		query.append("    FROM SPC_DLY_FCAST_CUST A1, " ).append("\n"); 
		query.append("         SPC_SLS_REP_CUST   A2," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT B1.TRD_CD, B1.SUB_TRD_CD, B1.VSL_CD, B1.SKD_VOY_NO, B1.DIR_CD, SUBSTR(B1.SLS_YRMON, 1, 4)||B1.COST_WK AS COST_YRWK" ).append("\n"); 
		query.append("            FROM MAS_MON_VVD B1" ).append("\n"); 
		query.append("           WHERE SUBSTR(B1.SLS_YRMON, 1, 4)||B1.COST_WK >= ( SELECT /*+ INDEX(P XPKMAS_WK_PRD)*/ B2.COST_YR||B2.COST_WK COST_YRWK" ).append("\n"); 
		query.append("                                                               FROM MAS_WK_PRD B2" ).append("\n"); 
		query.append("                                                              WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN B2.SLS_FM_DT AND B2.SLS_TO_DT" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("             AND SUBSTR(B1.SLS_YRMON, 1, 4)||B1.COST_WK <= ( SELECT /*+ INDEX(P XPKMAS_WK_PRD)*/ B2.COST_YR||B2.COST_WK COST_YRWK" ).append("\n"); 
		query.append("                                                               FROM MAS_WK_PRD B2" ).append("\n"); 
		query.append("                                                              WHERE TO_CHAR(SYSDATE+60, 'YYYYMMDD') BETWEEN B2.SLS_FM_DT AND B2.SLS_TO_DT" ).append("\n"); 
		query.append("                                                            )    " ).append("\n"); 
		query.append("             AND TRD_CD = @[trade]                                             " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("         ) A3" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A1.SREP_USR_ID  = @[srep_cd]" ).append("\n"); 
		query.append("    AND A1.FCAST_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("    AND A1.CUST_CNT_CD  = SUBSTR(@[cust_cd], 0, 2)" ).append("\n"); 
		query.append("    AND A1.CUST_SEQ     = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("    AND A2.INDIV_CUST_USE_FLG = 'Y'" ).append("\n"); 
		query.append("    AND A1.TRD_CD       = @[trade]" ).append("\n"); 
		query.append("    AND A1.SREP_USR_ID  = A2.SREP_CD" ).append("\n"); 
		query.append("    AND A1.CUST_CNT_CD  = A2.CUST_CNT_CD         " ).append("\n"); 
		query.append("    AND A1.CUST_SEQ     = A2.CUST_SEQ" ).append("\n"); 
		query.append("    AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD   = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD   = A3.SUB_TRD_CD  " ).append("\n"); 
		query.append("    AND A1.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("    AND A1.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A1.SKD_DIR_CD   = A3.DIR_CD" ).append("\n"); 
		query.append("    AND (A1.FCAST_TTL_QTY > 0 OR A1.FCAST_TTL_WGT > 0 " ).append("\n"); 
		query.append("        OR A1.FCAST_20FT_DRY_QTY > 0 OR A1.FCAST_20FT_QTY > 0 " ).append("\n"); 
		query.append("        OR A1.FCAST_40FT_DRY_QTY > 0 OR A1.FCAST_40FT_HC_QTY > 0 OR A1.FCAST_40FT_QTY > 0" ).append("\n"); 
		query.append("        OR A1.FCAST_45FT_HC_QTY > 0  OR A1.FCAST_53FT_QTY > 0 " ).append("\n"); 
		query.append("        OR A1.FCAST_RD_QTY > 0 OR A1.FCAST_RF_QTY > 0" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" ) TB" ).append("\n"); 
		query.append("GROUP BY RLANE_CD" ).append("\n"); 

	}
}