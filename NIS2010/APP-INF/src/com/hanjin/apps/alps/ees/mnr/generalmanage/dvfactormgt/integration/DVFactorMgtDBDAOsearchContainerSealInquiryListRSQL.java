/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DVFactorMgtDBDAOsearchContainerSealInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DVFactorMgtDBDAOsearchContainerSealInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
	  *                                                           - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
	  *                                                           - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
	  * 2012.01.02 김상수 [CHM-201215406-01] Seal Management Inquiry Fuction 교체
	  *                                                           - Seal Number가 없거나 1~3자리 모두 들어올수 있는 상황으로
	  *                                                             바뀌게 되어 조회시 위의 내용을 수용하는 Function 교체
	  *                                                             MNR_SEAL_PERF_FNC -> MNR_BKG_SEAL_PERF_FNC
	  * 2012.02.07 신혜정 [선처리] 특수문자 처리 변경
	  * 
	  * 2012.09.11 조경완 [CHM-201220024-01] Inquiry 시, Time Error 건은 back end job으로 처리 예정
	  * 								  - 기존의 MNR_BKG_SEAL_PERF_FNC Procedure 를 여러번 사용하던 
	  * 								    구조에서 MNR_SEAL_QTY_FNC Procedure 를 한번만 사용하는 
	  * 								    구조로 수정
	  * </pre>
	  */
	public DVFactorMgtDBDAOsearchContainerSealInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_knd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_mm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_yy",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_yy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOsearchContainerSealInquiryListRSQL").append("\n"); 
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
		query.append("WITH LV_SEAL_PERF0 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ NO_QUERY_TRANSFORMATION */" ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("PLN_YRMON," ).append("\n"); 
		query.append("SEAL_KND_NM," ).append("\n"); 
		query.append("PLN_QTY," ).append("\n"); 
		query.append("SEAL_NO_PFX_NM," ).append("\n"); 
		query.append("N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("MM_QTY," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY, 1,10)),0) MM_01," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,11,10)),0) MM_02," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,21,10)),0) MM_03," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,31,10)),0) MM_04," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,41,10)),0) MM_05," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,51,10)),0) MM_06," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,61,10)),0) MM_07," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,71,10)),0) MM_08," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,81,10)),0) MM_09," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,91,10)),0) MM_10," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,101,10)),0) MM_11," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,111,10)),0) MM_12," ).append("\n"); 
		query.append("NVL(TO_NUMBER(SUBSTR(MM_QTY,121,10)),0) MM_13," ).append("\n"); 
		query.append("CNTR_SEAL_LOST_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT OFC_CD," ).append("\n"); 
		query.append("PLN_YRMON," ).append("\n"); 
		query.append("SEAL_KND_NM," ).append("\n"); 
		query.append("(TO_NUMBER(LST_SER_RNG_SEAL_NO) - TO_NUMBER(N1ST_SER_RNG_SEAL_NO) + 1) AS PLN_QTY," ).append("\n"); 
		query.append("SEAL_NO_PFX_NM," ).append("\n"); 
		query.append("N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("MNR_SEAL_QTY_FNC(PLN_YRMON, SEAL_NO_PFX_NM, N1ST_SER_RNG_SEAL_NO, LST_SER_RNG_SEAL_NO) AS MM_QTY," ).append("\n"); 
		query.append("CNTR_SEAL_LOST_QTY" ).append("\n"); 
		query.append("FROM MNR_SEAL_PLN" ).append("\n"); 
		query.append("WHERE PLN_YRMON BETWEEN @[fr_yy]||@[fr_mm] AND @[to_yy]||@[to_mm]" ).append("\n"); 
		query.append("#if (${seal_knd_nm} != '')" ).append("\n"); 
		query.append("AND SEAL_KND_NM = @[seal_knd_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '' && ${ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("LV_SEAL_PERF AS" ).append("\n"); 
		query.append("(SELECT SUBSTR(PLN_YRMON, 1, 4) AS PLAN_YEAR," ).append("\n"); 
		query.append("DECODE(SUBSTR(PLN_YRMON, 5, 2), '01', '1st Half', '2nd Half') AS PLAN_HALF," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("SEAL_KND_NM," ).append("\n"); 
		query.append("PLN_QTY," ).append("\n"); 
		query.append("SEAL_NO_PFX_NM," ).append("\n"); 
		query.append("N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("MM_01," ).append("\n"); 
		query.append("MM_02," ).append("\n"); 
		query.append("MM_03," ).append("\n"); 
		query.append("MM_04," ).append("\n"); 
		query.append("MM_05," ).append("\n"); 
		query.append("MM_06," ).append("\n"); 
		query.append("MM_07," ).append("\n"); 
		query.append("MM_08," ).append("\n"); 
		query.append("MM_09," ).append("\n"); 
		query.append("MM_10," ).append("\n"); 
		query.append("MM_11," ).append("\n"); 
		query.append("MM_12," ).append("\n"); 
		query.append("(NVL(MM_01, 0) + NVL(MM_02, 0) + NVL(MM_03, 0) + NVL(MM_04, 0) + NVL(MM_05, 0) + NVL(MM_06, 0) + NVL(MM_07, 0) + NVL(MM_08, 0) + NVL(MM_09, 0) + NVL(MM_10, 0) + NVL(MM_11, 0) + NVL(MM_12, 0)) AS MM_TTL," ).append("\n"); 
		query.append("MM_13," ).append("\n"); 
		query.append("CNTR_SEAL_LOST_QTY," ).append("\n"); 
		query.append("(PLN_QTY - (NVL(MM_01, 0) + NVL(MM_02, 0) + NVL(MM_03, 0) + NVL(MM_04, 0) + NVL(MM_05, 0) + NVL(MM_06, 0) + NVL(MM_07, 0) + NVL(MM_08, 0) + NVL(MM_09, 0) + NVL(MM_10, 0) + NVL(MM_11, 0) + NVL(MM_12, 0)) - MM_13 - CNTR_SEAL_LOST_QTY) AS CURR_QTY" ).append("\n"); 
		query.append("FROM (SELECT * FROM LV_SEAL_PERF0))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(OFC_CD, 'G.TTL') AS OFC_CD," ).append("\n"); 
		query.append("PLAN_YEAR," ).append("\n"); 
		query.append("PLAN_HALF," ).append("\n"); 
		query.append("DECODE(SEAL_KND_NM, 'S', 'High Security', 'G', 'General', 'B', 'Barrier', 'P', 'Plastic', 'S.TTL') AS SEAL_KND_NM," ).append("\n"); 
		query.append("SUM(PLN_QTY) AS PLN_QTY," ).append("\n"); 
		query.append("SEAL_NO_PFX_NM," ).append("\n"); 
		query.append("N1ST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("NVL2(SEAL_KND_NM, '', '') AS SEAL_DELIM," ).append("\n"); 
		query.append("LST_SER_RNG_SEAL_NO," ).append("\n"); 
		query.append("SUM(MM_01) AS MM_01," ).append("\n"); 
		query.append("SUM(MM_02) AS MM_02," ).append("\n"); 
		query.append("SUM(MM_03) AS MM_03," ).append("\n"); 
		query.append("SUM(MM_04) AS MM_04," ).append("\n"); 
		query.append("SUM(MM_05) AS MM_05," ).append("\n"); 
		query.append("SUM(MM_06) AS MM_06," ).append("\n"); 
		query.append("SUM(MM_07) AS MM_07," ).append("\n"); 
		query.append("SUM(MM_08) AS MM_08," ).append("\n"); 
		query.append("SUM(MM_09) AS MM_09," ).append("\n"); 
		query.append("SUM(MM_10) AS MM_10," ).append("\n"); 
		query.append("SUM(MM_11) AS MM_11," ).append("\n"); 
		query.append("SUM(MM_12) AS MM_12," ).append("\n"); 
		query.append("SUM(MM_TTL) AS MM_TTL," ).append("\n"); 
		query.append("SUM(MM_13) AS MM_13," ).append("\n"); 
		query.append("SUM(CNTR_SEAL_LOST_QTY) AS CNTR_SEAL_LOST_QTY," ).append("\n"); 
		query.append("SUM(CURR_QTY) AS CURR_QTY" ).append("\n"); 
		query.append("FROM LV_SEAL_PERF" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS((OFC_CD, PLAN_YEAR, PLAN_HALF, SEAL_KND_NM, SEAL_NO_PFX_NM, N1ST_SER_RNG_SEAL_NO, LST_SER_RNG_SEAL_NO), (OFC_CD), '1')" ).append("\n"); 

	}
}