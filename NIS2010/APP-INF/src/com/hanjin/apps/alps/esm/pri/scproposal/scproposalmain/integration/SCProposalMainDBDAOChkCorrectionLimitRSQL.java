/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCProposalMainDBDAOChkCorrectionLimitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.11.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOChkCorrectionLimitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.06.02 전윤주 [CHM-201430580] s/c 자동 filing 기능 추가
	  * * 2014.09.13 송호진 [CHM-201430558] 반영 포함 Check Out
	  * * 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * * 2017.11.28 송민석 [CSR-2620] 체크기간을 48시간에서 10일로 변경함
	  * </pre>
	  */
	public SCProposalMainDBDAOChkCorrectionLimitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOChkCorrectionLimitRSQL").append("\n"); 
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
		query.append("/* 10day 기준으로 변경함. 10일 기간중 종료 날짜가 주말일경우 48시간을 더 늘려줌 */" ).append("\n"); 
		query.append("SELECT COUNT(*) ETC1" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC') US_EST_SYS_DT --현재 미 동부 시간 filing 기준  " ).append("\n"); 
		query.append("              ,DATE_AFTER_10DAY        " ).append("\n"); 
		query.append("          FROM (  " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                     CASE " ).append("\n"); 
		query.append("                       WHEN AFTER_10_DATE = '1' OR AFTER_10_DATE = '7' " ).append("\n"); 
		query.append("                           THEN AFTER_10DAY_DT + 2 --주말이 중간에 있는 경우 2일 추가" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                           FMC_FILE_CFM_DT + 10 -- 기본은 filing 날짜 + 10일 추가" ).append("\n"); 
		query.append("                     END AS DATE_AFTER_10DAY          " ).append("\n"); 
		query.append("                 FROM(SELECT TO_CHAR(MAX(FMC_FILE_CFM_DT), 'D') CFM_DAY" ).append("\n"); 
		query.append("                            ,TO_CHAR(MAX(FMC_FILE_CFM_DT) + 10, 'D') AFTER_10_DATE " ).append("\n"); 
		query.append("                            ,MAX(FMC_FILE_CFM_DT) FMC_FILE_CFM_DT" ).append("\n"); 
		query.append("                            ,MAX(FMC_FILE_CFM_DT) + 10 AFTER_10DAY_DT" ).append("\n"); 
		query.append("                       FROM  PRI_SP_FILE_PROG     A1" ).append("\n"); 
		query.append("                      WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                        AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE US_EST_SYS_DT <= DATE_AFTER_10DAY        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 기존 48시간 기준 쿼리" ).append("\n"); 
		query.append("SELECT COUNT(*) ETC1" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('NYCSC') US_EST_SYS_DT --현재 미 동부 시간 filing 기준  " ).append("\n"); 
		query.append("              ,DATE_AFTER_48        " ).append("\n"); 
		query.append("          FROM (         " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                     CASE " ).append("\n"); 
		query.append("                       WHEN CFM_DAY = '1' " ).append("\n"); 
		query.append("                           THEN TO_DATE(TO_CHAR(FMC_FILE_CFM_DT +0 + 2 , 'YYYY-MM-DD') || '23:59:59', 'YYYY-MM-DD HH24:MI:SS') --일요일 filing 이면 화요일 23:59:59까지" ).append("\n"); 
		query.append("                       WHEN CFM_DAY = '7'   " ).append("\n"); 
		query.append("                           THEN TO_DATE(TO_CHAR(FMC_FILE_CFM_DT +1 + 2 , 'YYYY-MM-DD') || '23:59:59', 'YYYY-MM-DD HH24:MI:SS') --토요일 filing 이면 화요일 23:59:59 까지    " ).append("\n"); 
		query.append("                       WHEN AFTER_48_DAY = '1' OR AFTER_48_DAY = '7' " ).append("\n"); 
		query.append("                           THEN AFTER_48_DT + 2 --주말이 중간에 있는 경우 2일 추가" ).append("\n"); 
		query.append("                       ELSE" ).append("\n"); 
		query.append("                           FMC_FILE_CFM_DT + 2 -- 기본은 filing 날짜 + 2일 추가" ).append("\n"); 
		query.append("                     END AS DATE_AFTER_48          " ).append("\n"); 
		query.append("                 FROM(SELECT TO_CHAR(MAX(FMC_FILE_CFM_DT), 'D') CFM_DAY" ).append("\n"); 
		query.append("                            ,TO_CHAR(MAX(FMC_FILE_CFM_DT) + 2, 'D') AFTER_48_DAY " ).append("\n"); 
		query.append("                            ,MAX(FMC_FILE_CFM_DT) FMC_FILE_CFM_DT" ).append("\n"); 
		query.append("                            ,MAX(FMC_FILE_CFM_DT) + 2 AFTER_48_DT" ).append("\n"); 
		query.append("                       FROM  PRI_SP_FILE_PROG     A1" ).append("\n"); 
		query.append("                      WHERE PROP_NO = [prop_no]" ).append("\n"); 
		query.append("                        AND AMDT_SEQ = [amdt_seq]" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE US_EST_SYS_DT <= DATE_AFTER_48" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}