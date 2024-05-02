/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOsearchCHSAtdtHistoryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.12 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOsearchCHSAtdtHistoryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOsearchCHSAtdtHistoryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOsearchCHSAtdtHistoryDataRSQL").append("\n"); 
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
		query.append("SELECT AAA.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  ROWNUM AS NO" ).append("\n"); 
		query.append(",AA.EQ_NO" ).append("\n"); 
		query.append(",AA.CNTR_NO" ).append("\n"); 
		query.append(",TO_CHAR(AA.ATCH_dT,'YYYY-MM-DD HH24:MI:SS') ATCH_DT" ).append("\n"); 
		query.append(",AA.ATCH_YD ATCH_YD_CD" ).append("\n"); 
		query.append(",DECODE(TO_CHAR(TO_DATE( AA.DTCH_DT ,'YYYY-MM-DD HH24:MI:SS') ,'YYYY-MM-DD HH24:MI:SS') ,'8888-12-31 00:00:00','' ,TO_CHAR(TO_DATE( AA.DTCH_DT ,'YYYY-MM-DD HH24:MI:SS') ,'YYYY-MM-DD HH24:MI:SS') ) DTCH_DT" ).append("\n"); 
		query.append(",AA.DTCH_YD dtch_yd_cd" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ATDT.EQ_NO" ).append("\n"); 
		query.append(",ATDT.CNTR_NO" ).append("\n"); 
		query.append(", DECODE(ATCH_dT, DT_LAG1, DECODE(LAG1, DT_LAG2, DECODE(LAG2,DT_LAG3, DECODE( LAG3,DT_LAG4 ,DECODE( LAG4, DT_LAG5 , DECODE(LAG5, DT_LAG6, DECODE(LAG6,DT_LAG7," ).append("\n"); 
		query.append("DECODE( LAG7,DT_LAG8, DECODE( LAG8, DT_LAG9, LAG9, LAG8) ,LAG7), LAG6), LAG5), LAG4), LAG3), LAG2 ), LAG1 ), ATCH_DT )   ATCH_DT" ).append("\n"); 
		query.append(", SUBSTR( MIN(ATDT.ATCH_YDDT)  , 15) ATCH_YD" ).append("\n"); 
		query.append(", SUBSTR( MAX(ATDT.DTCH_YDDT)  , 1,14) DTCH_DT" ).append("\n"); 
		query.append(", SUBSTR( MAX(ATDT.DTCH_YDDT)  , 15) DTCH_YD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ INDEX(A XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("A.EQ_NO" ).append("\n"); 
		query.append(",A.CNTR_NO" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,1) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG1" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,2) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG2" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,3) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG3" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,4) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG4" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,5) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG5" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,6) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG6" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,7) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG7" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,8) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG8" ).append("\n"); 
		query.append(",LAG(A.ATCH_DT,9) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) LAG9" ).append("\n"); 
		query.append(",LAG(DTCH_DT,1) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG1" ).append("\n"); 
		query.append(",LAG(DTCH_DT,2) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG2" ).append("\n"); 
		query.append(",LAG(DTCH_DT,3) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG3" ).append("\n"); 
		query.append(",LAG(DTCH_DT,4) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG4" ).append("\n"); 
		query.append(",LAG(DTCH_DT,5) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG5" ).append("\n"); 
		query.append(",LAG(DTCH_DT,6) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG6" ).append("\n"); 
		query.append(",LAG(DTCH_DT,7) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG7" ).append("\n"); 
		query.append(",LAG(DTCH_DT,8) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG8" ).append("\n"); 
		query.append(",LAG(DTCH_DT,9) OVER (PARTITION BY A.EQ_NO,A.CNTR_NO  ORDER BY ATCH_DT) DT_LAG9" ).append("\n"); 
		query.append(",A.ATCH_DT" ).append("\n"); 
		query.append(",A.DTCH_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.ATCH_DT,'YYYYMMDDHH24MISS') || A.ATCH_YD_CD ATCH_YDDT" ).append("\n"); 
		query.append(",TO_CHAR(A.DTCH_DT,'YYYYMMDDHH24MISS') || A.DTCH_YD_CD DTCH_YDDT" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} != '' )" ).append("\n"); 
		query.append("AND A.ATCH_DT BETWEEN  TO_DATE(@[str_mvmt_dt],'YYYY-MM-DD')  AND  TO_DATE(@[end_mvmt_dt],'YYYY-MM-DD') +1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.EQ_NO" ).append("\n"); 
		query.append(",ATCH_DT" ).append("\n"); 
		query.append(") ATDT" ).append("\n"); 
		query.append("GROUP BY ATDT.EQ_NO" ).append("\n"); 
		query.append(",ATDT.CNTR_NO" ).append("\n"); 
		query.append(", DECODE(ATCH_dT, DT_LAG1, DECODE(LAG1, DT_LAG2, DECODE(LAG2,DT_LAG3, DECODE( LAG3,DT_LAG4 ,DECODE( LAG4, DT_LAG5 , DECODE(LAG5, DT_LAG6, DECODE(LAG6,DT_LAG7," ).append("\n"); 
		query.append("DECODE( LAG7,DT_LAG8, DECODE( LAG8, DT_LAG9, LAG9, LAG8) ,LAG7), LAG6), LAG5), LAG4), LAG3), LAG2 ), LAG1 ), ATCH_DT )" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${str_mvmt_dt} == '' )" ).append("\n"); 
		query.append("WHERE AAA.NO < 301" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY AAA.ATCH_DT" ).append("\n"); 

	}
}