/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageDBDAOSearchCntrTurnTimeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.11.10 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastManageDBDAOSearchCntrTurnTimeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_ECC_TURN_TM 테이블 데이터 조회
	  * </pre>
	  */
	public CntrForecastManageDBDAOSearchCntrTurnTimeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastManageDBDAOSearchCntrTurnTimeInfoRSQL").append("\n"); 
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
		query.append("MAX(DECODE ( RUMM , 1 ,CO_CD)) CO_CD" ).append("\n"); 
		query.append(", MAX(DECODE ( RUMM , 1 ,FM_ECC_CD)) FM_ECC_CD" ).append("\n"); 
		query.append(", MAX(DECODE ( RUMM , 1 ,TO_ECC_CD)) TO_ECC_CD" ).append("\n"); 
		query.append("-- project_name : 신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록" ).append("\n"); 
		query.append("-- CSR No : R200903240002 - Cntr Tpsz 자동화, modified by Haeng-ji, Lee(2009.04.03)" ).append("\n"); 
		query.append(", ROUND(SUM(TT_RTO_DYS)/DECODE((" ).append("\n"); 
		query.append("#foreach( ${key} in ${tpsz})" ).append("\n"); 
		query.append("#if(${key} == '02')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif(${key} == 'O4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S4', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif(${key} == 'F2')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif(${key} == 'F4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F5', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($velocityCount < $tpsz.size() )" ).append("\n"); 
		query.append("+" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 0" ).append("\n"); 
		query.append(", 1" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("#foreach( ${key} in ${tpsz})" ).append("\n"); 
		query.append("#if(${key} == '02')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif(${key} == 'O4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S4', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif(${key} == 'F2')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A2', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#elseif(${key} == 'F4')" ).append("\n"); 
		query.append("DECODE(NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A4', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F5', TT_RTO_DYS)),0), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("DECODE(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($velocityCount < $tpsz.size() )" ).append("\n"); 
		query.append("+" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 2" ).append("\n"); 
		query.append(") AVG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tpsztype} != '')" ).append("\n"); 
		query.append("#foreach( ${key} in ${tpsz})" ).append("\n"); 
		query.append("#if(${key} == 'O2')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S2', TT_RTO_DYS)),0)  ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#elseif(${key} == 'O4')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'S4', TT_RTO_DYS)),0)   ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#elseif(${key} == 'F2')" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A2', TT_RTO_DYS)),0)   ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#elseif(${key} == 'F4')" ).append("\n"); 
		query.append("--		     		    	 project_name : 신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록" ).append("\n"); 
		query.append(",NVL(MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS )),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'F5', TT_RTO_DYS)),0)" ).append("\n"); 
		query.append("+ NVL(MAX(DECODE(CNTR_TPSZ_CD, 'A4', TT_RTO_DYS)),0)   ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",MAX(DECODE(CNTR_TPSZ_CD, '${key}', TT_RTO_DYS ))   ${key}TT_RTO_DYS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",SCNR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.SCNR_ID," ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.FM_ECC_CD," ).append("\n"); 
		query.append("A.TO_ECC_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.IO_BND_CD ," ).append("\n"); 
		query.append("A.TT_RTO_DYS," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY CO_CD,FM_ECC_CD ,TO_ECC_CD ,IO_BND_CD ,CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_ECC_TURN_TM  A" ).append("\n"); 
		query.append(", EQR_ECC_MST B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.SCNR_ID = @[scnrId]" ).append("\n"); 
		query.append("AND  A.FM_ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append("#if (${tpsztype} != '')" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach( ${key} in ${tpsz})" ).append("\n"); 
		query.append("#if($velocityCount < $tpsz.size() )" ).append("\n"); 
		query.append("'${key}'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${location} == 'R') --LOCATION 타입이 RCC 일때" ).append("\n"); 
		query.append("AND B.RCC_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${locationArr})" ).append("\n"); 
		query.append("#if($velocityCount < $locationArr.size() )" ).append("\n"); 
		query.append("'${key}'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${location} == 'L')   	--LOCATION 타입이 LCC 일때" ).append("\n"); 
		query.append("AND B.LCC_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${locationArr})" ).append("\n"); 
		query.append("#if($velocityCount < $locationArr.size() )" ).append("\n"); 
		query.append("'${key}'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${location} == 'E') 	--LOCATION 타입이 ECC 일때" ).append("\n"); 
		query.append("AND B.ECC_CD IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${locationArr})" ).append("\n"); 
		query.append("#if($velocityCount < $locationArr.size() )" ).append("\n"); 
		query.append("'${key}'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[bound]" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RUMM" ).append("\n"); 
		query.append(", FM_ECC_CD" ).append("\n"); 
		query.append(", TO_ECC_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", SCNR_ID" ).append("\n"); 
		query.append(", CO_CD" ).append("\n"); 
		query.append("ORDER by" ).append("\n"); 
		query.append("FM_ECC_CD  ASC" ).append("\n"); 

	}
}