/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltOnTimeRtoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.04.14 임창빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltOnTimeRtoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK_VSL_SKD_RSLT 테이블 조회
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltOnTimeRtoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ratio_opt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delay_opt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ontime_opt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sum_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltOnTimeRtoRSQL").append("\n"); 
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
		query.append("/********************************************************************************************/" ).append("\n"); 
		query.append("-- Period 1 " ).append("\n"); 
		query.append("-- 1. TTL_CALL01    : Total Calling Count" ).append("\n"); 
		query.append("-- 2. ONTIME_CALL01 : On-Time Calling Count" ).append("\n"); 
		query.append("-- 3. DUR_RATIO01   : 정시율 Round((ONTIME_CALL01 / TTL_CALL01) * 100), 1)" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- Period 2 " ).append("\n"); 
		query.append("-- 1. TTL_CALL02    : Total Calling Count" ).append("\n"); 
		query.append("-- 2. ONTIME_CALL02 : On-Time Calling Count" ).append("\n"); 
		query.append("-- 3. DUR_RATIO02   : 정시율 Round((ONTIME_CALL02 / TTL_CALL02) * 100), 1)" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- Period 1 과 Period 2 에 차이(기간에 정시율 변화 추이를 표시)" ).append("\n"); 
		query.append("-- DIFF_RAT = (DUR_RATIO01) - (DUR_RATIO02)" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- Max Date(start_date1, start_date2, end_date1, end_date2) 중 가장 큰 날짜가 기준이 됨." ).append("\n"); 
		query.append("-- 1. TTL_CALL03    : Max Date에 년도 ~ 해당 월까지 Calling Count" ).append("\n"); 
		query.append("-- 2. ONTIME_CALL03 : Max Date에 년도 ~ 해당 월까지 On-Time Calling Count" ).append("\n"); 
		query.append("-- 3. DUR_RATIO03   : 정시율 Round((ONTIME_CALL03 / TTL_CALL03) * 100), 1)" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- A. Total Call수 = SUM(DECODE(VSKD_RSLT_XCLD_CD, :ratio_opt, 0, 'S', 0, 1))" ).append("\n"); 
		query.append("-- ratio_opt컬럼에 의미는?" ).append("\n"); 
		query.append("-- 1. A : Arrival On-time Ratio 산출 선택시" ).append("\n"); 
		query.append("--        VSKD_RSLT_XCLD_CD = 'A'는 'Arrival 표시되지 않음'란 의미로,실적 생성시 ATA를 입력" ).append("\n"); 
		query.append("--        입력하지 못하는 상태임으로 실적(COUNT)에서는 누락시킨다는 의미이다." ).append("\n"); 
		query.append("-- 2. D : Departure On-time Ratio 산출 선택시" ).append("\n"); 
		query.append("--        VSKD_RSLT_XCLD_CD = 'D'는 'Departure 표시되지 않음'란 의미로,실적 생성시 ATD를 입력" ).append("\n"); 
		query.append("--        입력하지 못하는 상태임으로 실적(COUNT)에서는 누락시킨다는 의미이다." ).append("\n"); 
		query.append("-- 3. S : Arrival, Departure On-time Ratio 산출 선택시 모두 누락 시킨다.Skip Call에 의미" ).append("\n"); 
		query.append("--        VSKD_RSLT_XCLD_CD = 'S'는 Skip Calling를 의미함으로 실적(COUNT)에서는 누락시킨다." ).append("\n"); 
		query.append("-- B. On Time Calling 수 :" ).append("\n"); 
		query.append("--    SUM(DECODE(VSKD_RSLT_XCLD_CD, :ratio_opt, 0, 'S', 0, " ).append("\n"); 
		query.append("--               DECODE(SIGN(:ontime_opt - " ).append("\n"); 
		query.append("--                            DECODE(:delay_opt || :ratio_opt" ).append("\n"); 
		query.append("--                             , 'EA', XCLD_BRTH_DLAY_HRS" ).append("\n"); 
		query.append("--                             , 'ED', XCLD_DEP_DLAY_HRS" ).append("\n"); 
		query.append("--                             , 'IA', INCL_BRTH_DLAY_HRS" ).append("\n"); 
		query.append("--                             , 'ID', INCL_DEP_DLAY_HRS))" ).append("\n"); 
		query.append("--                       , -1, 0, 1)) )" ).append("\n"); 
		query.append("/********************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT GRP_ID" ).append("\n"); 
		query.append("       , TTL_CALL01, ONTIME_CALL01, NVL(DUR_RATIO01, 0) AS DUR_RATIO01" ).append("\n"); 
		query.append("       , TTL_CALL02, ONTIME_CALL02, NVL(DUR_RATIO02, 0) AS DUR_RATIO02" ).append("\n"); 
		query.append("       , (NVL(DUR_RATIO01,0) - NVL(DUR_RATIO02,0)) AS DIFF_RAT" ).append("\n"); 
		query.append("       , TTL_CALL03" ).append("\n"); 
		query.append("       , ONTIME_CALL03" ).append("\n"); 
		query.append("       , DUR_RATIO03" ).append("\n"); 
		query.append("FROM   ( /* Period 1 과 Period 2에 합집합 */" ).append("\n"); 
		query.append("       SELECT  T0.GRP_ID" ).append("\n"); 
		query.append("               , T1.TTL_CALL AS TTL_CALL01, T1.ONTIME_CALL AS ONTIME_CALL01, DECODE(T1.TTL_CALL, 0, 0, ROUND((T1.ONTIME_CALL / T1.TTL_CALL) * 100, 1) ) AS DUR_RATIO01" ).append("\n"); 
		query.append("               , T2.TTL_CALL AS TTL_CALL02, T2.ONTIME_CALL AS ONTIME_CALL02, DECODE(T2.TTL_CALL, 0, 0, ROUND((T2.ONTIME_CALL / T2.TTL_CALL) * 100, 1) ) AS DUR_RATIO02" ).append("\n"); 
		query.append("               , T3.TTL_CALL AS TTL_CALL03, T3.ONTIME_CALL AS ONTIME_CALL03, DECODE(T3.TTL_CALL, 0, 0, ROUND((T3.ONTIME_CALL / T3.TTL_CALL) * 100, 1) ) AS DUR_RATIO03" ).append("\n"); 
		query.append("       FROM    (" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("               SELECT  T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')' AS GRP_ID" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("               SELECT  T1.VSL_CD AS GRP_ID" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("               SELECT  T2.VSL_SLAN_CD AS GRP_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               FROM    VSK_VSL_SKD_RSLT  T1," ).append("\n"); 
		query.append("                       VSK_VSL_SKD       T2," ).append("\n"); 
		query.append("                       MDM_VSL_CNTR      T3" ).append("\n"); 
		query.append("               WHERE   1 = 1" ).append("\n"); 
		query.append("               AND     T1.VSL_CD         = T2.VSL_CD" ).append("\n"); 
		query.append("               AND     T1.SKD_VOY_NO     = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND     T1.SKD_DIR_CD     = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND     T1.VSL_CD         = T3.VSL_CD" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("               AND     T3.CRR_CD         = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND     T1.ACT_INP_YRMON >= TO_CHAR(TO_DATE(@[start_date1], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("               AND     T1.ACT_INP_YRMON <= TO_CHAR(TO_DATE(@[end_date1], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("               AND     T1.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("               AND     T2.VSL_SLAN_CD    = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("               AND     VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--               AND      (NVL(SKD_CNG_STS_CD, ' ')||CLPT_IND_SEQ) NOT IN (' 2')" ).append("\n"); 
		query.append("               UNION" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("               SELECT  T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')' AS GRP_ID" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("               SELECT  T1.VSL_CD AS GRP_ID" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("               SELECT  T2.VSL_SLAN_CD AS GRP_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               FROM    VSK_VSL_SKD_RSLT  T1," ).append("\n"); 
		query.append("                       VSK_VSL_SKD       T2," ).append("\n"); 
		query.append("                       MDM_VSL_CNTR      T3" ).append("\n"); 
		query.append("               WHERE   1                = 1" ).append("\n"); 
		query.append("               AND     T1.VSL_CD        = T2.VSL_CD" ).append("\n"); 
		query.append("               AND     T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND     T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND     T1.VSL_CD        = T3.VSL_CD" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("               AND     T3.CRR_CD           = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND     T1.ACT_INP_YRMON >= TO_CHAR(TO_DATE(@[start_date2], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("               AND     T1.ACT_INP_YRMON <= TO_CHAR(TO_DATE(@[end_date2], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("               AND     T1.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("               AND     T2.VSL_SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("               AND     VPS_PORT_CD          = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--               AND      (NVL(SKD_CNG_STS_CD, ' ')||CLPT_IND_SEQ) NOT IN (' 2')" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("               GROUP BY T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')'     " ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("               GROUP BY T1.VSL_CD" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("               GROUP BY T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               )T0," ).append("\n"); 
		query.append("               ( /* Period 1 집합 */" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("               SELECT   T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')' AS GRP_ID," ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("               SELECT   T1.VSL_CD AS GRP_ID," ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("               SELECT   T2.VSL_SLAN_CD AS GRP_ID," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        SUM(DECODE(VSKD_RSLT_XCLD_CD, @[ratio_opt], 0, 'S', 0, 1)) TTL_CALL," ).append("\n"); 
		query.append("                        SUM(DECODE(VSKD_RSLT_XCLD_CD, @[ratio_opt], 0, 'S', 0, " ).append("\n"); 
		query.append("                        DECODE(SIGN(@[ontime_opt] - " ).append("\n"); 
		query.append("                              DECODE(@[delay_opt] || @[ratio_opt], 'EA', XCLD_BRTH_DLAY_HRS, 'ED', XCLD_DEP_DLAY_HRS, 'IA', INCL_BRTH_DLAY_HRS, 'ID', INCL_DEP_DLAY_HRS)" ).append("\n"); 
		query.append("                                             ), -1, 0, 1)) ) ONTIME_CALL" ).append("\n"); 
		query.append("               FROM     VSK_VSL_SKD_RSLT     T1," ).append("\n"); 
		query.append("                        VSK_VSL_SKD          T2," ).append("\n"); 
		query.append("                        MDM_VSL_CNTR         T3" ).append("\n"); 
		query.append("               WHERE    1 = 1" ).append("\n"); 
		query.append("               AND      T1.VSL_CD         = T2.VSL_CD" ).append("\n"); 
		query.append("               AND      T1.SKD_VOY_NO     = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND      T1.SKD_DIR_CD     = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND      T1.VSL_CD         = T3.VSL_CD" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("               AND      T3.CRR_CD         = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND      T1.ACT_INP_YRMON >= TO_CHAR(TO_DATE(@[start_date1], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("               AND      T1.ACT_INP_YRMON <= TO_CHAR(TO_DATE(@[end_date1], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("               AND      T1.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("               AND      T2.VSL_SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("               AND      VPS_PORT_CD          = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--               AND      (NVL(SKD_CNG_STS_CD, ' ')||CLPT_IND_SEQ) NOT IN (' 2')" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("               GROUP BY T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')'     " ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("               GROUP BY T1.VSL_CD" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("               GROUP BY T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               )T1," ).append("\n"); 
		query.append("               ( /* Period 2 집합 */" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("               SELECT   T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')' AS GRP_ID," ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("               SELECT   T1.VSL_CD AS GRP_ID," ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("               SELECT   T2.VSL_SLAN_CD AS GRP_ID," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        SUM(DECODE(VSKD_RSLT_XCLD_CD, @[ratio_opt], 0, 'S', 0, 1)) TTL_CALL," ).append("\n"); 
		query.append("                        SUM(DECODE(VSKD_RSLT_XCLD_CD, @[ratio_opt], 0, 'S', 0," ).append("\n"); 
		query.append("                             DECODE(SIGN(@[ontime_opt] - " ).append("\n"); 
		query.append("                                  DECODE(@[delay_opt] || @[ratio_opt], 'EA', XCLD_BRTH_DLAY_HRS, 'ED', XCLD_DEP_DLAY_HRS, 'IA', INCL_BRTH_DLAY_HRS, 'ID', INCL_DEP_DLAY_HRS)" ).append("\n"); 
		query.append("                             ), -1, 0, 1)) ) ONTIME_CALL" ).append("\n"); 
		query.append("                FROM    VSK_VSL_SKD_RSLT     T1," ).append("\n"); 
		query.append("                        VSK_VSL_SKD          T2," ).append("\n"); 
		query.append("                        MDM_VSL_CNTR         T3" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     T1.VSL_CD          = T2.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_VOY_NO      = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T1.SKD_DIR_CD      = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     T1.VSL_CD          = T3.VSL_CD" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("                AND      T3.CRR_CD         = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND      T1.ACT_INP_YRMON >= TO_CHAR(TO_DATE(@[start_date2], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND      T1.ACT_INP_YRMON <= TO_CHAR(TO_DATE(@[end_date2], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                AND      T1.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("                AND      T2.VSL_SLAN_CD    = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("                AND      VPS_PORT_CD       = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--                AND     (NVL(SKD_CNG_STS_CD, ' ')||CLPT_IND_SEQ) NOT IN (' 2')" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("                GROUP BY T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')'     " ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("                GROUP BY T1.VSL_CD" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("                GROUP BY T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) T2," ).append("\n"); 
		query.append("                ( /* 입력 받은 Date 중에서 가장 큰 YYYY-MM에 해당하는 YYYY-01부터 YYYY-MM(Max Date)까지에 Call Count & On-Time Call */" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("                SELECT   T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')' AS GRP_ID," ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("                SELECT   T1.VSL_CD AS GRP_ID," ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("                SELECT   T2.VSL_SLAN_CD AS GRP_ID," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         SUM(DECODE(VSKD_RSLT_XCLD_CD, @[ratio_opt], 0, 'S', 0, 1)) TTL_CALL," ).append("\n"); 
		query.append("                         SUM(DECODE(VSKD_RSLT_XCLD_CD, @[ratio_opt], 0, 'S', 0," ).append("\n"); 
		query.append("                              DECODE(SIGN(@[ontime_opt] - " ).append("\n"); 
		query.append("                                   DECODE(@[delay_opt] || @[ratio_opt], 'EA', XCLD_BRTH_DLAY_HRS, 'ED', XCLD_DEP_DLAY_HRS, 'IA', INCL_BRTH_DLAY_HRS, 'ID', INCL_DEP_DLAY_HRS)" ).append("\n"); 
		query.append("                              ), -1, 0, 1)) ) ONTIME_CALL" ).append("\n"); 
		query.append("                 FROM    VSK_VSL_SKD_RSLT     T1," ).append("\n"); 
		query.append("                         VSK_VSL_SKD          T2," ).append("\n"); 
		query.append("                         MDM_VSL_CNTR         T3" ).append("\n"); 
		query.append("                 WHERE   1 = 1" ).append("\n"); 
		query.append("                 AND     T1.VSL_CD         = T2.VSL_CD" ).append("\n"); 
		query.append("                 AND     T1.SKD_VOY_NO     = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND     T1.SKD_DIR_CD     = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND     T1.VSL_CD         = T3.VSL_CD" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("                 AND     T3.CRR_CD         = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND     T1.ACT_INP_YRMON >= SUBSTR(@[sum_date], 1, 4)||'01'" ).append("\n"); 
		query.append("                 AND     T1.ACT_INP_YRMON <= TO_CHAR(TO_DATE(@[sum_date], 'YYYY-MM'), 'YYYYMM')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                 AND      T1.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("                 AND      T2.VSL_SLAN_CD   = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_port_cd} != '')" ).append("\n"); 
		query.append("                 AND      VPS_PORT_CD      = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--                 AND      (NVL(SKD_CNG_STS_CD, ' ')||CLPT_IND_SEQ) NOT IN (' 2')" ).append("\n"); 
		query.append("#if (${grp_id} == 'A') " ).append("\n"); 
		query.append("                 GROUP BY T1.VPS_PORT_CD || ' (' || T1.SKD_DIR_CD || ')'     " ).append("\n"); 
		query.append("#elseif (${grp_id} == 'B') " ).append("\n"); 
		query.append("                 GROUP BY T1.VSL_CD" ).append("\n"); 
		query.append("#elseif (${grp_id} == 'C') " ).append("\n"); 
		query.append("                 GROUP BY T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ) T3" ).append("\n"); 
		query.append("               WHERE   1 = 1" ).append("\n"); 
		query.append("               AND     T0.GRP_ID = T1.GRP_ID (+)" ).append("\n"); 
		query.append("               AND     T0.GRP_ID = T2.GRP_ID (+)" ).append("\n"); 
		query.append("               AND     T0.GRP_ID = T3.GRP_ID (+)" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("ORDER BY GRP_ID" ).append("\n"); 

	}
}