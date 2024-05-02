/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleasePlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.06 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleasePlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_slse 테이블의 데이터 조회
	  * </pre>
	  */
	public OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleasePlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanScheduleInputDBDAOSearchYearSubleasePlanRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("D.INTG_CD_VAL_CTNT RCC_CD" ).append("\n"); 
		query.append(", '' TOTSUM" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 01, CNTR_VOL_QTY)) S1_01_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 02, CNTR_VOL_QTY)) S1_02_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 03, CNTR_VOL_QTY)) S1_03_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 04, CNTR_VOL_QTY)) S1_04_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 05, CNTR_VOL_QTY)) S1_05_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 06, CNTR_VOL_QTY)) S1_06_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 07, CNTR_VOL_QTY)) S1_07_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 08, CNTR_VOL_QTY)) S1_08_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 09, CNTR_VOL_QTY)) S1_09_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 10, CNTR_VOL_QTY)) S1_10_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 11, CNTR_VOL_QTY)) S1_11_CNTR_VOL_QTY" ).append("\n"); 
		query.append(", SUM (DECODE (PLN_MON, 12, CNTR_VOL_QTY)) S1_12_CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.PLN_MON" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(") RCC_CD" ).append("\n"); 
		query.append(", SUM (A.CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_SLSE A" ).append("\n"); 
		query.append(", EQR_WK_PRD B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.PLN_YRWK = B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fmPlnYrwk] and @[toPlnYrwk]" ).append("\n"); 
		query.append("AND A.SCNR_ID =  @[scnrId]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("B.PLN_MON" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("C.RCC_CD(+) = D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND D.INTG_CD_ID = 'CD00255'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("D.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}