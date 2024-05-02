/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOSearchCntrOffHireRepoPlanDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOSearchCntrOffHireRepoPlanDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0054 컨테이너 수급 예측실적 및 정확도 조회(Off-Hire)>
	  * EQR_ONF_HIR_PLN 테이블에서 데이터 조회
	  * 
	  * <Change History>
	  * 1	2009.09.10	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOSearchCntrOffHireRepoPlanDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_Id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOSearchCntrOffHireRepoPlanDtRSQL").append("\n"); 
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
		query.append("PLN_YRWK" ).append("\n"); 
		query.append(", ECC_CD" ).append("\n"); 
		query.append(", ONF_HIR_DIV_CD CNTR_LSTM_CD" ).append("\n"); 
		query.append("#foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append(", SUM(DECODE ( CNTR_TPSZ_CD , '$key' , CNTR_QTY )) ${key}CNTR_QTY" ).append("\n"); 
		query.append(", SUM(DECODE ( CNTR_TPSZ_CD , '$key' , ONF_HIR_COST_AMT)) ${key}ONF_HIR_COST_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", REPO_PLN_ID" ).append("\n"); 
		query.append(", ONF_HIR_DIV_CD" ).append("\n"); 
		query.append(", MAX(DECODE(CRE_DT,UPD_DT,'N','Y')) AS TIMEGAP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN_YRWK" ).append("\n"); 
		query.append(", ONF_HIR_DIV_CD" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${typeby_4} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${typeby_4} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${typeby_4} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("E.ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") ECC_CD" ).append("\n"); 
		query.append(", CNTR_LSTM_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", ONF_HIR_COST_AMT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", PLN_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY PLN_YRWK,ECC_CD, CNTR_LSTM_CD, CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PLN.REPO_PLN_ID" ).append("\n"); 
		query.append(", PLN.PLN_YRWK" ).append("\n"); 
		query.append(", ONF_HIR_DIV_CD" ).append("\n"); 
		query.append(", PLN.ECC_CD ECC_CD" ).append("\n"); 
		query.append(", CNTR_LSTM_CD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", ONF_HIR_COST_AMT" ).append("\n"); 
		query.append(", QTY.UPD_USR_ID" ).append("\n"); 
		query.append(", QTY.UPD_DT" ).append("\n"); 
		query.append(", QTY.CRE_DT" ).append("\n"); 
		query.append(", QTY.PLN_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_ONF_HIR_PLN PLN" ).append("\n"); 
		query.append(", EQR_ONF_HIR_PLN_QTY QTY" ).append("\n"); 
		query.append("#if (${type_4} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append(", (SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${type_4} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${type_4} == 'L')" ).append("\n"); 
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
		query.append("PLN.REPO_PLN_ID = QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK = QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND PLN.PLN_SEQ = QTY.PLN_SEQ" ).append("\n"); 
		query.append("AND PLN.REPO_PLN_ID = @[repo_pln_Id]" ).append("\n"); 
		query.append("#if (${term_4} != '')" ).append("\n"); 
		query.append("AND ONF_HIR_DIV_CD = @[term_4]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ONF_HIR_DIV_CD IN ('F','S')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${type_4} != '')" ).append("\n"); 
		query.append("AND (PLN.ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND PLN.PLN_YRWK BETWEEN '${fmplnyr_4}${fmplnwk_4}' AND '${toplnyr_4}${toplnwk_4}'" ).append("\n"); 
		query.append("#if ($arrCntrTpszCd.size() > 0)" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrCntrTpszCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("PLN_YRWK DESC" ).append("\n"); 
		query.append(") E" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("PLN_YRWK,  ECC_CD, REPO_PLN_ID, ONF_HIR_DIV_CD" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("PLN_YRWK,  ECC_CD" ).append("\n"); 

	}
}