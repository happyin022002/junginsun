/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRISimulationDBDAOSearchRevenueDetailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchRevenueDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get the result for Revenue Detail Info of Selected Container Size,Commodity
	  * </pre>
	  */
	public PRISimulationDBDAOSearchRevenueDetailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchRevenueDetailInfoRSQL").append("\n"); 
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
		query.append("SELECT X.*," ).append("\n"); 
		query.append("       DECODE(X.FRT_INCL_XCLD_DIV_CD,'N',X.CHG_AMT_USD,0) AS NET_AMT_USD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT C.CHG_CD," ).append("\n"); 
		query.append("               C.CURR_CD," ).append("\n"); 
		query.append("               C.CHG_UT_AMT," ).append("\n"); 
		query.append("               C.RAT_UT_CD," ).append("\n"); 
		query.append("               TO_CHAR(C.RAT_AS_QTY) AS RAT_AS_QTY," ).append("\n"); 
		query.append("               TO_CHAR(C.CHG_AMT) AS CHG_AMT," ).append("\n"); 
		query.append("               TO_CHAR(C.APLY_XCH_RTO) AS APLY_XCH_RTO," ).append("\n"); 
		query.append("               TO_CHAR(ROUND(C.APLY_XCH_RTO * C.CHG_AMT,2)) AS CHG_AMT_USD," ).append("\n"); 
		query.append("               C.FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("               C.FRT_TERM_CD," ).append("\n"); 
		query.append("               R.PRC_CGO_TP_CD AS CGO_TP_CD," ).append("\n"); 
		query.append("               C.SVC_SCP_CD," ).append("\n"); 
		query.append("               C.RT_SEQ," ).append("\n"); 
		query.append("               1 ORD" ).append("\n"); 
		query.append("          FROM PRI_SIM_RT R, PRI_SIM_CHG_RT C" ).append("\n"); 
		query.append("         WHERE R.PCTL_NO = C.PCTL_NO" ).append("\n"); 
		query.append("           AND R.CNTR_SZ_CD = C.CNTR_SZ_CD" ).append("\n"); 
		query.append("           AND R.CMDT_CD = C.CMDT_CD" ).append("\n"); 
		query.append("           AND R.CMDT_SEQ = C.CMDT_SEQ" ).append("\n"); 
		query.append("           AND R.AUTO_RAT_FLG = C.AUTO_RAT_FLG" ).append("\n"); 
		query.append("           AND C.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("           AND C.CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append("           AND C.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("           AND C.CMDT_SEQ = @[cmdt_seq]" ).append("\n"); 
		query.append("           AND C.AUTO_RAT_FLG = NVL(@[auto_rat_flg],'Y')" ).append("\n"); 
		query.append("           AND C.RAT_UT_CD NOT IN ('CM','MT')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("        SELECT C.CHG_CD," ).append("\n"); 
		query.append("               C.CURR_CD," ).append("\n"); 
		query.append("               C.CHG_UT_AMT," ).append("\n"); 
		query.append("               C.RAT_UT_CD," ).append("\n"); 
		query.append("               '-' AS RAT_AS_QTY," ).append("\n"); 
		query.append("               '-' AS CHG_AMT," ).append("\n"); 
		query.append("               '-' AS APLY_XCH_RTO," ).append("\n"); 
		query.append("               '-' AS CHG_AMT_USD," ).append("\n"); 
		query.append("               C.FRT_INCL_XCLD_DIV_CD," ).append("\n"); 
		query.append("               C.FRT_TERM_CD," ).append("\n"); 
		query.append("               R.PRC_CGO_TP_CD AS CGO_TP_CD," ).append("\n"); 
		query.append("               C.SVC_SCP_CD," ).append("\n"); 
		query.append("               C.RT_SEQ," ).append("\n"); 
		query.append("               2 ORD" ).append("\n"); 
		query.append("          FROM PRI_SIM_RT R, PRI_SIM_CHG_RT C" ).append("\n"); 
		query.append("         WHERE R.PCTL_NO = C.PCTL_NO" ).append("\n"); 
		query.append("           AND R.CNTR_SZ_CD = C.CNTR_SZ_CD" ).append("\n"); 
		query.append("           AND R.CMDT_CD = C.CMDT_CD" ).append("\n"); 
		query.append("           AND R.CMDT_SEQ = C.CMDT_SEQ" ).append("\n"); 
		query.append("           AND R.AUTO_RAT_FLG = C.AUTO_RAT_FLG" ).append("\n"); 
		query.append("           AND C.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("           AND C.CNTR_SZ_CD = @[cntr_sz_cd]" ).append("\n"); 
		query.append("           AND C.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("           AND C.CMDT_SEQ = @[cmdt_seq]" ).append("\n"); 
		query.append("           AND C.AUTO_RAT_FLG = NVL(@[auto_rat_flg],'Y')" ).append("\n"); 
		query.append("           AND C.RAT_UT_CD IN ('CM','MT')" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("ORDER BY X.ORD, X.RT_SEQ" ).append("\n"); 

	}
}