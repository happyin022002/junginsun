/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDailyForecastHistorySrepAcctListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : Okyoung Im
*@LastVersion : 1.0
* 2014.08.21 Okyoung Im
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Okyoung Im
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
	  * Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [Trouble Shooting] 진마리아 SC Join 오류 수정
	  * [Trouble Shooting] 진마리아 Rlane이 대상항차와 join되어 있지 않아 조회가 두배로 되는 오류 수정
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * * 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청	
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
		params.put("vslcd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("salesRep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("salesOffice",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("subOffice",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
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
		query.append("SELECT A.SLS_OFC_CD  AS SLS_OFC_CD ," ).append("\n"); 
		query.append("         A.SREP_USR_ID AS SREP_USR_ID," ).append("\n"); 
		query.append("         NVL(D.USR_NM, '*'||A.SREP_USR_ID) AS SREP_NM," ).append("\n"); 
		query.append("         TO_CHAR(A.MODI_GDT, 'YYYY-MM-DD HH24:MI:SS') AS MODI_GDT," ).append("\n"); 
		query.append("         NVL(E.USR_NM, '*'||A.CFM_USR_ID) AS MODI_USR," ).append("\n"); 
		query.append("         CASE WHEN A.CUST_CNT_CD = '00' THEN NULL" ).append("\n"); 
		query.append("              ELSE " ).append("\n"); 
		query.append("                     NVL((SELECT DISTINCT CUST_CTRL_CD --20130424 DISTINCT 추가" ).append("\n"); 
		query.append("                            FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("                           WHERE COST_YRWK||'-'||VER_SEQ = (SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                   DECODE(V.DIR_CD, NULL, '200001-1', COST_YRWK||'-'||VER_SEQ)" ).append("\n"); 
		query.append("                                                              FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                                             WHERE SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                               AND TRD_CD  = V.TRD_CD" ).append("\n"); 
		query.append("                                                               AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                               AND ROWNUM  = 1)" ).append("\n"); 
		query.append("                             AND TRD_CD          = V.TRD_CD" ).append("\n"); 
		query.append("                             AND CUST_CNT_CD     = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST_SEQ        = A.CUST_SEQ" ).append("\n"); 
		query.append("                             AND NVL(SC_NO,NVL(RFA_NO, 'X')) = NVL(A.SC_NO,NVL(A.RFA_NO, 'X'))" ).append("\n"); 
		query.append("                             --AND DECODE(TRD_CD, 'AES', NVL(RFA_NO, 'X'), NVL(SC_NO, 'X')) = DECODE(TRD_CD, 'AES', NVL(A.RFA_NO, 'X'), NVL(A.SC_NO, 'X'))" ).append("\n"); 
		query.append("                         ), 'C') " ).append("\n"); 
		query.append("         END AS FCAST_CUST_TP_CD," ).append("\n"); 
		query.append("         CASE WHEN A.CUST_CNT_CD='00' THEN NULL ELSE DECODE(A.USA_BKG_MOD_CD, 'X', 'OTHERS', 'OTH', 'OTHERS', A.USA_BKG_MOD_CD) END USA_BKG_MOD_CD," ).append("\n"); 
		query.append("         DECODE(A.CUST_CNT_CD, '00', NULL, A.CUST_CNT_CD||A.CUST_SEQ) AS CUST_CD         ," ).append("\n"); 
		query.append("         DECODE(B.CUST_ABBR_NM, NULL, B.CUST_LGL_ENG_NM, B.CUST_ABBR_NM)  AS CUST_NM         ," ).append("\n"); 
		query.append("         DECODE(A.CUST_CNT_CD, '00', '+', DECODE(A.POL_YD_CD, '0000000', '+', POL_YD_CD)) AS POL_CD," ).append("\n"); 
		query.append("         DECODE(A.CUST_CNT_CD, '00', '+', DECODE(A.POD_YD_CD, '0000000', '+', POD_YD_CD)) AS POD_CD," ).append("\n"); 
		query.append("         DECODE(A.CUST_CNT_CD, '00', '+', DECODE(A.POD_YD_CD, '0000000', '+', DECODE(A.DEST_LOC_CD, 'XXXXX', 'OTHERS', A.DEST_LOC_CD))) AS DEST_LOC_CD," ).append("\n"); 
		query.append("         NVL(A.FCAST_TTL_QTY, 0) + NVL(A.FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.FCAST_53FT_QTY, 0) * 2  AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("         A.FCAST_TTL_QTY        AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("         NVL(A.FCAST_20FT_DRY_QTY, 0)        AS FCAST_20FT_DRY_QTY  ," ).append("\n"); 
		query.append("         NVL(A.FCAST_40FT_DRY_QTY, 0)        AS FCAST_40FT_DRY_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_40FT_HC_QTY    AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_45FT_HC_QTY    AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("         A.FCAST_53FT_QTY       AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("         A.FCAST_RF_QTY         AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("         NVL(A.FCAST_RD_QTY, 0)   AS FCAST_RD_QTY       ," ).append("\n"); 
		query.append("         A.FCAST_TTL_WGT        AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("         A.USD_BKG_TTL_QTY      AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("         A.USD_BKG_20FT_QTY     AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_40FT_QTY     AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("         NVL(A.USD_BKG_20FT_DRY_QTY, 0)        AS USD_BKG_20FT_DRY_QTY  ," ).append("\n"); 
		query.append("         NVL(A.USD_BKG_40FT_DRY_QTY, 0)        AS USD_BKG_40FT_DRY_QTY  ," ).append("\n"); 
		query.append("         A.USD_BKG_40FT_HC_QTY  AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("         A.USD_BKG_45FT_HC_QTY  AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("         A.USD_BKG_53FT_QTY     AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("         A.USD_BKG_RF_QTY       AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("         NVL(A.USD_BKG_RD_QTY, 0)       AS USD_BKG_RD_QTY     ," ).append("\n"); 
		query.append("         A.USD_BKG_TTL_WGT      AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_TTL_QTY, 0) + NVL(A.CTRT_FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.CTRT_FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.CTRT_FCAST_53FT_QTY, 0) * 2  AS CFCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_TTL_QTY, 0)        AS CFCAST_TTL_QTY      ," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_40FT_HC_QTY, 0)    AS CFCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_45FT_HC_QTY, 0)    AS CFCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_53FT_QTY, 0)       AS CFCAST_53FT_QTY     ," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_RF_QTY, 0)         AS CFCAST_RF_QTY       ," ).append("\n"); 
		query.append("         NVL(A.CTRT_FCAST_TTL_WGT, 0)        AS CFCAST_TTL_WGT      ," ).append("\n"); 
		query.append("         DECODE(A.USA_BKG_MOD_CD, 'X', 1, DECODE(A.CUST_CNT_CD, '00', 2, DECODE(A.POD_YD_CD, '0000000', 3, DECODE(A.DEST_LOC_CD, 'XXXXX', 4, 5)))) AS LVL" ).append("\n"); 
		query.append("--         DECODE(A.CUST_CNT_CD, '00', 1, DECODE(A.POD_YD_CD, '0000000', 2, 3)) AS LVL" ).append("\n"); 
		query.append("         --USA_BKG_MOD_CD, DEST_LOC_CD, FCAST_20FT_DRY_QTY, FCAST_40FT_DRY_QTY, FCAST_RD_QTY, CFM_20FT_DRY_QTY, CFM_40FT_DRY_QTY, CFM_RD_QTY, USD_BKG_20FT_DRY_QTY, USD_BKG_40FT_DRY_QTY, USD_BKG_RD_QTY " ).append("\n"); 
		query.append("    FROM SPC_DLY_FCAST_CUST_HIS A," ).append("\n"); 
		query.append("         MDM_CUSTOMER           B," ).append("\n"); 
		query.append("         MDM_SLS_REP            C," ).append("\n"); 
		query.append("         COM_USER               D," ).append("\n"); 
		query.append("         COM_USER               E," ).append("\n"); 
		query.append("         MAS_MON_VVD            V," ).append("\n"); 
		query.append("         SPC_HD_HUL_MST         H" ).append("\n"); 
		query.append("   WHERE A.VSL_CD         = @[vslcd]" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO     = @[skdvoyno]" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD     = @[skddircd]" ).append("\n"); 
		query.append("     AND A.IOC_TS_CD      = @[ioc]" ).append("\n"); 
		query.append("     AND A.SLS_RGN_OFC_CD = @[salesOffice]" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD  LIKE @[subOffice]||'%'" ).append("\n"); 
		query.append("     AND A.CFM_FLG        = 'Y'" ).append("\n"); 
		query.append("     AND A.VSL_CD         = V.VSL_CD" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO     = V.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("     AND DECODE(A.IOC_TS_CD, 'T', 'I', A.IOC_TS_CD) = V.IOC_CD     " ).append("\n"); 
		query.append("     AND A.TRD_CD         = V.TRD_CD" ).append("\n"); 
		query.append("     AND A.RLANE_CD       = V.RLANE_CD" ).append("\n"); 
		query.append("     AND A.TRD_CD         = H.TRD_CD  (+)" ).append("\n"); 
		query.append("     AND A.RLANE_CD       = H.RLANE_CD(+)" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD     = H.DIR_CD  (+)" ).append("\n"); 
		query.append("#if (${customer} != '')" ).append("\n"); 
		query.append("     AND DECODE(A.FCAST_CUST_TP_CD, '0', '1', A.CUST_CNT_CD||TO_CHAR(A.CUST_SEQ, 'FM000000')) IN (${customer}, '1')" ).append("\n"); 
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
		query.append("                     AND B.CUST_CNT_CD||TO_CHAR(B.CUST_SEQ, 'FM000000') IN (${customer})" ).append("\n"); 
		query.append("                     AND A.MODI_GDT    = B.MODI_GDT" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SREP_USR_ID  ," ).append("\n"); 
		query.append("         MODI_GDT DESC," ).append("\n"); 
		query.append("         FCAST_CUST_TP_CD DESC," ).append("\n"); 
		query.append("         DECODE(CUST_CD, 'XX999999', 'ZZZZZ', CUST_CD)," ).append("\n"); 
		query.append("         USA_BKG_MOD_CD," ).append("\n"); 
		query.append("         POL_CD ," ).append("\n"); 
		query.append("         POD_CD ," ).append("\n"); 
		query.append("         DECODE(DEST_LOC_CD, 'XXXXX', 'ZZZZZ', DEST_LOC_CD)" ).append("\n"); 

	}
}
