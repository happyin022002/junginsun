/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAOcreatePriMotFileRtLogDtlMatchingTariffCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.10
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.06.10 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOcreatePriMotFileRtLogDtlMatchingTariffCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일별 데이터 중에서 OFT 가 Null or Zero 인 경우에 대해 MOT Tariff 정보를 Matching 시켜
	  * 해당 Surcharge Data 를 복제 생성 
	  * PRI_MOT_TRF_RT_SCG_DTL -> PRI_MOT_FILE_RT_LOG_DTL
	  * </pre>
	  */
	public SCReportDBDAOcreatePriMotFileRtLogDtlMatchingTariffCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exec_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOcreatePriMotFileRtLogDtlMatchingTariffCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_MOT_FILE_RT_LOG_DTL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT  A.BAT_EXE_DT" ).append("\n"); 
		query.append("        ,   A.MOT_FILE_RT_LOG_SEQ" ).append("\n"); 
		query.append("        ,   RANK () OVER ( PARTITION BY A.MOT_FILE_RT_LOG_SEQ ORDER BY  D.MOT_TRF_CHG_CD  ) AS SCG_SEQ" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,   CASE WHEN D.MOT_TRF_CHG_CD = '01' THEN DECODE ( D.SVC_SCP_CD, 'TPE', 'BUC', 'BAF' ) " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '02' THEN DECODE ( D.SVC_SCP_CD, 'AEW', 'CAF', 'IAA', 'CAF' ) " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '03' THEN 'OTH'" ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '04' THEN DECODE ( D.SVC_SCP_CD, 'TPE', 'DDC', 'DTH' ) " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '05' THEN 'APR' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '06' THEN 'CSR' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '07' THEN 'PCC' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '08' THEN 'PCS' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '09' THEN 'STF' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '10' THEN 'ACT' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '11' THEN 'DDC' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '12' THEN 'DDF' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '13' THEN 'NFC' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '14' THEN 'ENS' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '15' THEN 'DHF' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '16' THEN 'DIS' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '17' THEN 'GOH' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '18' THEN 'WSC' " ).append("\n"); 
		query.append("                 WHEN D.MOT_TRF_CHG_CD = '19' THEN 'PSC' END AS CHG_CD" ).append("\n"); 
		query.append("        ,   C.MOT_TRF_CNTR_TP_CD AS RAT_UT_CD" ).append("\n"); 
		query.append("        ,   D.MOT_TRF_CHG_AMT AS MOT_FILE_CHG_AMT" ).append("\n"); 
		query.append("        ,   'SYSTEM'" ).append("\n"); 
		query.append("        ,   SYSDATE" ).append("\n"); 
		query.append("        ,   'SYSTEM'" ).append("\n"); 
		query.append("        ,   SYSDATE" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    FROM    PRI_MOT_FILE_RT_LOG A" ).append("\n"); 
		query.append("        ,   PRI_MOT_FILE_LOC_PPT B" ).append("\n"); 
		query.append("        ,   PRI_MOT_TRF_MN M" ).append("\n"); 
		query.append("        ,   PRI_MOT_TRF_RT C" ).append("\n"); 
		query.append("        ,   PRI_MOT_TRF_RT_SCG_DTL D" ).append("\n"); 
		query.append("    WHERE   A.BAT_EXE_DT = TO_DATE (@[exec_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("    AND   ( A.MOT_FILE_RT_AMT IS NULL OR A.MOT_FILE_RT_AMT = 0 )" ).append("\n"); 
		query.append("    AND     A.MOT_FILE_DEST_CD = B.MOT_FILE_LOC_CD" ).append("\n"); 
		query.append("    AND     B.ORG_DEST_TP_CD = 'D'" ).append("\n"); 
		query.append("    AND     B.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     M.MOT_TRF_SEQ = ( SELECT MAX ( X.MOT_TRF_SEQ ) FROM PRI_MOT_TRF_MN X WHERE X.SVC_SCP_CD = B.SVC_SCP_CD AND X.EFF_DT <= A.BAT_EXE_DT AND X.CFM_FLG = 'Y' )" ).append("\n"); 
		query.append("    AND     M.SVC_SCP_CD = C.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     M.MOT_TRF_SEQ = C.MOT_TRF_SEQ" ).append("\n"); 
		query.append("    AND     C.RT_SEQ = (    SELECT  MAX ( X.RT_SEQ ) " ).append("\n"); 
		query.append("                            FROM    PRI_MOT_TRF_RT X" ).append("\n"); 
		query.append("                            WHERE   X.SVC_SCP_CD = M.SVC_SCP_CD" ).append("\n"); 
		query.append("                            AND     X.MOT_TRF_SEQ = M.MOT_TRF_SEQ" ).append("\n"); 
		query.append("                            AND     X.MOT_TRF_ORG_CD = A.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                            AND     X.MOT_TRF_DEST_CD = A.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                            AND     X.MOT_TRF_CNTR_TP_CD = A.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("                            AND     X.MOT_TRF_CMDT_TP_CD = A.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                            AND     X.MOT_TRF_CNTR_SZ_CD = A.MOT_FILE_CNTR_SZ_CD )" ).append("\n"); 
		query.append("    AND     C.SVC_SCP_CD = D.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND     C.MOT_TRF_SEQ = D.MOT_TRF_SEQ" ).append("\n"); 
		query.append("    AND     C.RT_SEQ = D.RT_SEQ" ).append("\n"); 

	}
}