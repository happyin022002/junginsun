/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDailyForecastHistorySrepAcctList
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * 2016.06.07 #14443 Incident 처리 (SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO comma 추가)
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdvoyno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("salesOffice",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslcd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("salesRep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skddircd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subOffice",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL").append("\n"); 
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
		query.append("SELECT A.SLS_OFC_CD  AS SLS_OFC_CD , " ).append("\n"); 
		query.append("         A.SREP_USR_ID AS SREP_USR_ID," ).append("\n"); 
		query.append("         NVL(D.USR_NM, '*'||A.SREP_USR_ID) AS SREP_NM," ).append("\n"); 
		query.append("         TO_CHAR(A.MODI_GDT, 'YYYY-MM-DD HH24:MI:SS') AS MODI_GDT," ).append("\n"); 
		query.append("         NVL(E.USR_NM, '*'||A.CFM_USR_ID) AS MODI_USR," ).append("\n"); 
		query.append("         DECODE(A.FCAST_CUST_TP_CD, '0', NULL, A.FCAST_CUST_TP_CD)        AS FCAST_CUST_TP_CD," ).append("\n"); 
		query.append("         DECODE(A.FCAST_CUST_TP_CD, '0', NULL, A.CUST_CNT_CD||A.CUST_SEQ) AS CUST_CD         ," ).append("\n"); 
		query.append("         DECODE(B.CUST_ABBR_NM, NULL, B.CUST_LGL_ENG_NM, B.CUST_ABBR_NM)  AS CUST_NM         ," ).append("\n"); 
		query.append("         --20160211.ADD" ).append("\n"); 
		query.append("         A.CTRT_NO,								--20160325.MOD" ).append("\n"); 
		query.append("         A.CTRT_CUST_CNT_CD||A.CTRT_CUST_SEQ    AS CTRT_CUST_CD," ).append("\n"); 
		query.append("        (SELECT DECODE(CUST_ABBR_NM, NULL, CUST_LGL_ENG_NM, CUST_ABBR_NM)  FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND CUST_CNT_CD = A.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CUST_SEQ    = A.CTRT_CUST_SEQ ) 	AS CTRT_CUST_NM," ).append("\n"); 
		query.append("         DECODE(A.FCAST_CUST_TP_CD, '0', '+', DECODE(A.POL_YD_CD, '0000000', '+', POL_YD_CD)) AS POL_CD," ).append("\n"); 
		query.append("         DECODE(A.FCAST_CUST_TP_CD, '0', '+', DECODE(A.POD_YD_CD, '0000000', '+', POD_YD_CD)) AS POD_CD," ).append("\n"); 
		query.append("         NVL(A.FCAST_TTL_QTY, 0) + NVL(A.FCAST_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(A.TRD_CD, A.RLANE_CD, A.DIR_CD, A.VSL_CD,A.SKD_VOY_NO, 'D5') + NVL(A.FCAST_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(A.TRD_CD, A.RLANE_CD, A.DIR_CD, A.VSL_CD, A.SKD_VOY_NO,'D7') + NVL(A.FCAST_53FT_QTY, 0) * 2  AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("         A.FCAST_TTL_QTY        AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("         A.FCAST_40FT_HC_QTY    AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_45FT_HC_QTY    AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_53FT_QTY       AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("         A.FCAST_RF_QTY         AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("         A.FCAST_TTL_WGT        AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("         A.USD_BKG_TTL_QTY      AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("         A.USD_BKG_20FT_QTY     AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_40FT_QTY     AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_40FT_HC_QTY  AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("         A.USD_BKG_45FT_HC_QTY  AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("         A.USD_BKG_53FT_QTY     AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_RF_QTY       AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("         A.USD_BKG_TTL_WGT      AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("         DECODE(A.FCAST_CUST_TP_CD, '0', 1, DECODE(A.POD_YD_CD, '0000000', 2, 3)) AS LVL" ).append("\n"); 
		query.append("        ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD 	AS VVD_CD 		--20160215.ADD" ).append("\n"); 
		query.append("    FROM SPC_DLY_FCAST_CUST_HIS A," ).append("\n"); 
		query.append("         MDM_CUSTOMER           B," ).append("\n"); 
		query.append("         MDM_SLS_REP            C," ).append("\n"); 
		query.append("         COM_USER               D," ).append("\n"); 
		query.append("         COM_USER               E," ).append("\n"); 
		query.append("         COA_MON_VVD            V          						--20160215.ADD" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND A.IOC_TS_CD      = @[ioc]" ).append("\n"); 
		query.append("     AND A.SLS_RGN_OFC_CD = @[salesOffice]" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD  LIKE @[subOffice]||'%'" ).append("\n"); 
		query.append("     AND A.CFM_FLG        = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("     AND A.VSL_CD         = @[vslcd]" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO     = @[skdvoyno]" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD     = @[skddircd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("     AND A.TRD_CD     LIKE @[trade]    ||'%'" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD LIKE @[subTrade] ||'%'" ).append("\n"); 
		query.append("     AND A.RLANE_CD   LIKE @[lane]     ||'%'" ).append("\n"); 
		query.append("     AND A.DIR_CD     LIKE @[bound]    ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${customer} != '')" ).append("\n"); 
		query.append("     AND DECODE(a.fcast_cust_tp_cd, '0', '1', a.cust_cnt_cd) = DECODE(a.fcast_cust_tp_cd, '0', '1', @[custcntcd])" ).append("\n"); 
		query.append("     AND DECODE(a.fcast_cust_tp_cd, '0', '1', a.cust_seq)    = DECODE(a.fcast_cust_tp_cd, '0', '1', @[custseq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A.SREP_USR_ID LIKE @[salesRep]||'%'" ).append("\n"); 
		query.append("     AND A.CUST_CNT_CD    = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("     AND A.CUST_SEQ       = B.CUST_SEQ   (+)" ).append("\n"); 
		query.append("     AND A.SREP_USR_ID    = C.SREP_CD    (+)" ).append("\n"); 
		query.append("     AND C.EMPE_CD        = D.USR_ID     (+)" ).append("\n"); 
		query.append("     AND A.CFM_USR_ID     = E.USR_ID     (+)" ).append("\n"); 
		query.append("#if (${customer} != '')" ).append("\n"); 
		query.append("     AND EXISTS ( SELECT '1'" ).append("\n"); 
		query.append("                    FROM SPC_DLY_FCAST_CUST_HIS B" ).append("\n"); 
		query.append("                   WHERE A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("                     AND A.DIR_CD      = B.DIR_CD" ).append("\n"); 
		query.append("                     AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("                     AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                     AND A.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                     AND A.IOC_TS_CD   = B.IOC_TS_CD" ).append("\n"); 
		query.append("                     AND A.SREP_USR_ID = B.SREP_USR_ID" ).append("\n"); 
		query.append("                     AND B.cust_cnt_cd = @[custcntcd]" ).append("\n"); 
		query.append("                     AND B.cust_seq    = @[custseq]" ).append("\n"); 
		query.append("                     AND A.MODI_GDT    = B.MODI_GDT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--20160215.ADD" ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("     AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK  IN ( SELECT COST_YR||COST_WK" ).append("\n"); 
		query.append("                                                         FROM (  SELECT P.COST_YR," ).append("\n"); 
		query.append("                                                                        P.COST_WK" ).append("\n"); 
		query.append("                                                                   FROM COA_WK_PRD P" ).append("\n"); 
		query.append("                                                                  WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                                               ORDER BY P.COST_YR||P.COST_WK ) Z" ).append("\n"); 
		query.append("                                                        WHERE ROWNUM <= @[duration] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND A.RLANE_CD    = V.RLANE_CD" ).append("\n"); 
		query.append("     AND A.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD  = V.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND A.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD  = V.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("         A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD , 	--20160215.ADD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         SREP_USR_ID  ," ).append("\n"); 
		query.append("         MODI_GDT DESC," ).append("\n"); 
		query.append("         FCAST_CUST_TP_CD DESC," ).append("\n"); 
		query.append("         CUST_CD," ).append("\n"); 
		query.append("         CTRT_NO,			            --20160211.ADD, 20160325.MOD" ).append("\n"); 
		query.append("         CTRT_CUST_CD,					--20160211.ADD" ).append("\n"); 
		query.append("         POL_CD ," ).append("\n"); 
		query.append("         POD_CD" ).append("\n"); 

	}
}