/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_scnr_dmst 테이블의 데이터 조회
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticPlanRSQL(){
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
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchYearDomesticPlanRSQL").append("\n"); 
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
		query.append("MAX (DECODE (PLN_MON, 01, CNTR_VOL_QTY)) S1_01_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 02, CNTR_VOL_QTY)) S1_02_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 03, CNTR_VOL_QTY)) S1_03_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 04, CNTR_VOL_QTY)) S1_04_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 05, CNTR_VOL_QTY)) S1_05_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 06, CNTR_VOL_QTY)) S1_06_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 07, CNTR_VOL_QTY)) S1_07_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 08, CNTR_VOL_QTY)) S1_08_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 09, CNTR_VOL_QTY)) S1_09_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 10, CNTR_VOL_QTY)) S1_10_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 11, CNTR_VOL_QTY)) S1_11_CNTR_VOL_QTY," ).append("\n"); 
		query.append("MAX (DECODE (PLN_MON, 12, CNTR_VOL_QTY)) S1_12_CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	 B.PLN_MON" ).append("\n"); 
		query.append(",SUM (A.CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM	EQR_SCNR_DMST A, EQR_WK_PRD B" ).append("\n"); 
		query.append("WHERE	A.PLN_YRWK	= B.PLN_YR || B.PLN_WK" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fmPlnYrwk] AND @[toPlnYrwk]" ).append("\n"); 
		query.append("AND A.SCNR_ID	=  @[scnr_id]" ).append("\n"); 
		query.append("GROUP BY B.PLN_MON" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}