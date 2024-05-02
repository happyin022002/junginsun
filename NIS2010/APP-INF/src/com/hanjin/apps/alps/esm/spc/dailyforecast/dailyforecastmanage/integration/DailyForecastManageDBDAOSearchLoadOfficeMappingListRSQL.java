/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchLoadOfficeMappingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2014.05.22 김시몬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author simonkim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchLoadOfficeMappingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchLoadOfficeMappingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custcntcd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("custseq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchLoadOfficeMappingListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         C.CUST_CNT_CD||C.CUST_SEQ AS CUST_CODE," ).append("\n"); 
		query.append("         MC.CUST_LGL_ENG_NM        AS CUST_NM  ," ).append("\n"); 
		query.append("         NVL(C.SC_NO, ' ')         AS SC_NO    ," ).append("\n"); 
		query.append("         NVL(C.SC_NO, NVL2(@[rfa_no], NVL(C.RFA_NO, ' '), ' ')) AS RFA_NO," ).append("\n"); 
		query.append("         --DECODE(C.TRD_CD, 'AES', NVL2(--[rfa_no], NVL(C.RFA_NO, ' '), ' '), NVL(C.RFA_NO, ' ')) AS RFA_NO," ).append("\n"); 
		query.append("         C.TRD_CD        ," ).append("\n"); 
		query.append("         C.SUB_TRD_CD    ," ).append("\n"); 
		query.append("         C.IOC_TS_CD     ," ).append("\n"); 
		query.append("         C.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         C.RLANE_CD      ," ).append("\n"); 
		query.append("         'R' AS FLAG" ).append("\n"); 
		query.append("    FROM SPC_CTRT_FCAST_OFC_MAPG C ," ).append("\n"); 
		query.append("         MDM_CUSTOMER            MC" ).append("\n"); 
		query.append("   WHERE C.TRD_CD              = @[trade]" ).append("\n"); 
		query.append("#if (${subTrade} != '')" ).append("\n"); 
		query.append("     AND C.SUB_TRD_CD          = @[subTrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("     AND C.RLANE_CD           IN ( ${rlane_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND C.IOC_TS_CD           = @[ioc]" ).append("\n"); 
		query.append("     AND C.CTRT_OFC_CD         = @[ofc_cd]" ).append("\n"); 
		query.append("     AND C.CUST_CNT_CD         = @[custcntcd]" ).append("\n"); 
		query.append("     AND C.CUST_SEQ            = @[custseq]" ).append("\n"); 
		query.append("     AND NVL(C.SC_NO, NVL(C.RFA_NO, 'X')) = NVL(@[sc_no], NVL(@[rfa_no], 'X'))" ).append("\n"); 
		query.append("     --AND DECODE(C.TRD_CD, 'AES', NVL(C.RFA_NO, 'X'), NVL(C.SC_NO, 'X')) = DECODE(C.TRD_CD, 'AES', NVL (--[rfa_no], 'X'), COALESCE (--[sc_no], C.SC_NO, 'X'))" ).append("\n"); 
		query.append("     AND MC.CUST_CNT_CD        = C.CUST_CNT_CD" ).append("\n"); 
		query.append("     AND MC.CUST_SEQ           = C.CUST_SEQ" ).append("\n"); 
		query.append("ORDER BY C.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         C.RLANE_CD" ).append("\n"); 

	}
}