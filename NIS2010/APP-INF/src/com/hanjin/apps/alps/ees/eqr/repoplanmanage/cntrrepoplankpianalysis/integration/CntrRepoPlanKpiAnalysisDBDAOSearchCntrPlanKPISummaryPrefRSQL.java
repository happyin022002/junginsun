/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanKpiAnalysisDBDAOSearchCntrPlanKPISummaryPrefRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanKpiAnalysisDBDAOSearchCntrPlanKPISummaryPrefRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0071 컨테이너 이송 계획 KPI 요약 조회>
	  * PORT별 재고대비 운송모드별 실행 KPI 데이터 조회 (Pref)
	  * 
	  * <Change History>
	  * 1	2009.09.21	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanKpiAnalysisDBDAOSearchCntrPlanKPISummaryPrefRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("data0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prefFrom",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("radiocomp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prefTo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanKpiAnalysisDBDAOSearchCntrPlanKPISummaryPrefRSQL").append("\n"); 
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
		query.append("RCC_CD ECC_CD" ).append("\n"); 
		query.append(",REPO_PLN_ID" ).append("\n"); 
		query.append(",'' UTILIZATION" ).append("\n"); 
		query.append(",SUM(DECODE ( DIV , 'MTY' , CNTR_QTY )) / @[data0]   MTY" ).append("\n"); 
		query.append(",SUM(DECODE ( DIV , 'ONH' , CNTR_QTY ))   ONHIRE" ).append("\n"); 
		query.append(",SUM(DECODE ( DIV , 'OFH' , CNTR_QTY ))   OFFHIRE" ).append("\n"); 
		query.append(",'' LF" ).append("\n"); 
		query.append(",'' MB" ).append("\n"); 
		query.append(",'' RCOST" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("----- [MTY] 조회주차의 첫날짜의 EQR_INVT_SNAP 조회 후 주차의 AVG" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${radioopr} == '0')" ).append("\n"); 
		query.append("#if (${typeBy} == 'R')" ).append("\n"); 
		query.append("A.RCC_CD" ).append("\n"); 
		query.append("#elseif (${typeBy} == 'C')" ).append("\n"); 
		query.append("A.CNT_CD" ).append("\n"); 
		query.append("#elseif (${typeBy} == 'L')" ).append("\n"); 
		query.append("A.LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A.ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("ECC_CD = T.ECC_CD" ).append("\n"); 
		query.append(") RCC_CD" ).append("\n"); 
		query.append(", '' REPO_PLN_ID" ).append("\n"); 
		query.append(", SUM(T.CNTR_VOL_QTY) AS CNTR_QTY" ).append("\n"); 
		query.append(", 'MTY' DIV" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_INVT_SNAP T" ).append("\n"); 
		query.append("#if (${type} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append(", (SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${type} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${type} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrAtEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrAtEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T.SNAP_DT IN (" ).append("\n"); 
		query.append("#foreach ($key in ${arrMtyPerfStr})" ).append("\n"); 
		query.append("#if($velocityCount < $arrMtyPerfStr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN(SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00244' )" ).append("\n"); 
		query.append("#if (${type} != '')" ).append("\n"); 
		query.append("AND (T.ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${radiocomp} != '' && ${radiocomp} != 'B')" ).append("\n"); 
		query.append("#if (${radiocomp} == 'H')" ).append("\n"); 
		query.append("AND SUBSTR(CNTR_SYS_AREA_GRP_ID,0,1) <> 'S'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND SUBSTR(CNTR_SYS_AREA_GRP_ID,0,1) = 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("T.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----- [ONH]" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${radioopr} == '0')" ).append("\n"); 
		query.append("#if (${typeBy} == 'R')" ).append("\n"); 
		query.append("B.RCC_CD" ).append("\n"); 
		query.append("#elseif (${typeBy} == 'C')" ).append("\n"); 
		query.append("B.CNT_CD" ).append("\n"); 
		query.append("#elseif (${typeBy} == 'L')" ).append("\n"); 
		query.append("B.LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("B.ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append(", EQR_ECC_MST B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = SUBSTR(T.TO_YD_CD,0,5)" ).append("\n"); 
		query.append("AND A.ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append(") RCC_CD" ).append("\n"); 
		query.append(", '' REPO_PLN_ID" ).append("\n"); 
		query.append(", SUM(T.CNTR_QTY)  CNTR_QTY" ).append("\n"); 
		query.append(", 'ONH' DIV" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_EXE_PLN T" ).append("\n"); 
		query.append("#if (${type} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append(", (SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${type} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${type} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrAtEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrAtEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T.ONF_HIR_DIV_CD = 'O'" ).append("\n"); 
		query.append("AND T.PLN_YRWK BETWEEN @[prefFrom] AND  @[prefTo]" ).append("\n"); 
		query.append("#if (${type} != '')" ).append("\n"); 
		query.append("AND (SUBSTR(T.TO_YD_CD,0,5) = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${radiocomp} != '')" ).append("\n"); 
		query.append("#if (${radiocomp} == 'B')" ).append("\n"); 
		query.append("AND CO_CD IN ('H','S')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND CO_CD = @[radiocomp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("T.TO_YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----- [OFF]" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${radioopr} == '0')" ).append("\n"); 
		query.append("#if (${typeBy} == 'R')" ).append("\n"); 
		query.append("B.RCC_CD" ).append("\n"); 
		query.append("#elseif (${typeBy} == 'C')" ).append("\n"); 
		query.append("B.CNT_CD" ).append("\n"); 
		query.append("#elseif (${typeBy} == 'L')" ).append("\n"); 
		query.append("B.LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("B.ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append(", EQR_ECC_MST B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("SCC_CD = SUBSTR(T.FM_YD_CD,0,5)" ).append("\n"); 
		query.append("AND A.ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append(") RCC_CD" ).append("\n"); 
		query.append(", '' REPO_PLN_ID" ).append("\n"); 
		query.append(", SUM(T.CNTR_QTY)  CNTR_QTY" ).append("\n"); 
		query.append(", 'OFH' DIV" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_EXE_PLN T" ).append("\n"); 
		query.append("#if (${type} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append(", (SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${type} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${type} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrAtEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrAtEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T.ONF_HIR_DIV_CD = 'F'" ).append("\n"); 
		query.append("AND T.PLN_YRWK BETWEEN @[prefFrom] AND  @[prefTo]" ).append("\n"); 
		query.append("#if (${type} != '')" ).append("\n"); 
		query.append("AND (SUBSTR(T.FM_YD_CD,0,5) = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${radiocomp} != '')" ).append("\n"); 
		query.append("#if (${radiocomp} == 'B')" ).append("\n"); 
		query.append("AND CO_CD IN ('H','S')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND CO_CD = @[radiocomp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("T.FM_YD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("RCC_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RCC_CD ,REPO_PLN_ID" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 

	}
}