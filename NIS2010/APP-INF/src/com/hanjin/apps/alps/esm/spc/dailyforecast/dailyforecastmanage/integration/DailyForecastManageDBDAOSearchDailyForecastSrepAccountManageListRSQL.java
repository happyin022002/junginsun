/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDailyForecastSrepAccountManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchDailyForecastSrepAccountManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDailyForecastSrepAccountManageList
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchDailyForecastSrepAccountManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("salesRep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subTrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration ").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchDailyForecastSrepAccountManageListRSQL").append("\n"); 
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
		query.append("SELECT T.SREP_CD    ," ).append("\n"); 
		query.append("       T.TRD_CD     ," ).append("\n"); 
		query.append("       T.SUB_TRD_CD ," ).append("\n"); 
		query.append("       T.RLANE_CD   ," ).append("\n"); 
		query.append("       T.DIR_CD     ," ).append("\n"); 
		query.append("       T.IOC_TS_CD  ," ).append("\n"); 
		query.append("       T.CUST_CNT_CD," ).append("\n"); 
		query.append("       T.CUST_SEQ   ," ).append("\n"); 
		query.append("       C.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("       T.FCAST_CUST_TP_CD" ).append("\n"); 
		query.append("  FROM SPC_SLS_REP_CUST_MAPG T," ).append("\n"); 
		query.append("       MDM_CUSTOMER          c" ).append("\n"); 
		query.append(" WHERE C.CUST_CNT_CD(+) = T.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND C.CUST_SEQ   (+) = T.CUST_SEQ" ).append("\n"); 
		query.append("   AND T.SREP_CD        = @[salesRep]" ).append("\n"); 
		query.append("   AND T.TRD_CD         = @[trade]" ).append("\n"); 
		query.append("   AND T.SUB_TRD_CD     = @[subTrade]" ).append("\n"); 
		query.append("   AND T.RLANE_CD       = @[lane]" ).append("\n"); 
		query.append("   AND T.DIR_CD         = @[bound]" ).append("\n"); 
		query.append("   AND T.IOC_TS_CD      = @[ioc]" ).append("\n"); 

	}
}