/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAOremovePriMotFileRtLogDtlZeroOftDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.24 송호진
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

public class SCReportDBDAOremovePriMotFileRtLogDtlZeroOftDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일별 데이터 중 OFT 가 Null 이거나 Zero 인 경우에 대해 생성된 Surcharge Detail 삭제
	  * MOT Tariff Matching 을 위한 준비 과정
	  * PRI_MOT_FILE_RT_LOG_DTL
	  * </pre>
	  */
	public SCReportDBDAOremovePriMotFileRtLogDtlZeroOftDSQL(){
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
		query.append("FileName : SCReportDBDAOremovePriMotFileRtLogDtlZeroOftDSQL").append("\n"); 
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
		query.append("DELETE  PRI_MOT_FILE_RT_LOG_DTL A" ).append("\n"); 
		query.append("    WHERE   A.BAT_EXE_DT = TO_DATE (@[exec_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("    AND     A.MOT_FILE_RT_LOG_SEQ IN ( SELECT  B.MOT_FILE_RT_LOG_SEQ" ).append("\n"); 
		query.append("                                       FROM    PRI_MOT_FILE_RT_LOG B" ).append("\n"); 
		query.append("                                       WHERE   B.BAT_EXE_DT = TO_DATE (@[exec_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("                                       AND   ( B.MOT_FILE_RT_AMT IS NULL OR B.MOT_FILE_RT_AMT = 0 ) )" ).append("\n"); 

	}
}