/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanKpiAnalysisDBDAOGetForecastedSeaInventoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
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

public class CntrRepoPlanKpiAnalysisDBDAOGetForecastedSeaInventoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0136 Forecasted M/B>
	  * Weekly Sea Inventory 조회
	  * 
	  * <Change History>
	  * 1	2009.09.23	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanKpiAnalysisDBDAOGetForecastedSeaInventoryRSQL(){
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
		params.put("fmPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanKpiAnalysisDBDAOGetForecastedSeaInventoryRSQL").append("\n"); 
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
		query.append("A.PLN_YRWK WEEK," ).append("\n"); 
		query.append("A.ECC_CD PORT," ).append("\n"); 
		query.append("A.VSL_LST_PORT_CD LASTPORT," ).append("\n"); 
		query.append("TO_CHAR(A.VSL_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD," ).append("\n"); 
		query.append("A.VSL_SLAN_CD LAND," ).append("\n"); 
		query.append("A.VSL_CD||SKD_VOY_NO||SKD_DIR_CD  VVD," ).append("\n"); 
		query.append("A.VSL_BSA_SPC BSA," ).append("\n"); 
		query.append("A.VSL_RSDL_SPC REDIUALSPC," ).append("\n"); 
		query.append("A.USD_VSL_RSDL_SPC USEDSPC," ).append("\n"); 
		query.append("(A.VSL_RSDL_SPC - A.USD_VSL_RSDL_SPC)  UNUSEDSPC," ).append("\n"); 
		query.append("DECODE (A.VSL_RSDL_SPC ,'0','0'," ).append("\n"); 
		query.append("ROUND((A.USD_VSL_RSDL_SPC / A.VSL_RSDL_SPC * 100 ),2)) RATION" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_USD_RSDL_SPC A" ).append("\n"); 
		query.append(", (SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($arrFmEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${fmtype} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${fmtype} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrFmEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrFmEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) B" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("REPO_PLN_ID =	@[repo_pln_Id]" ).append("\n"); 
		query.append("AND A.PLN_YRWK BETWEEN @[fmPlnYrwk]  AND @[toPlnYrwk]" ).append("\n"); 
		query.append("AND A.ECC_CD  = B.ECC_CD" ).append("\n"); 
		query.append("AND A.VSL_LST_PORT_CD <>'ZZZZZ'" ).append("\n"); 
		query.append("AND A.ECC_CD <> 'XXXXX'" ).append("\n"); 
		query.append("#if ($arrVvd.size() > 0)" ).append("\n"); 
		query.append("AND A.VSL_CD||SKD_VOY_NO||SKD_DIR_CD IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrVvd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVvd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($arrVslSlanCd.size() > 0)" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD IN(" ).append("\n"); 
		query.append("#foreach ($key in ${arrVslSlanCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrVslSlanCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY WEEK ,PORT ASC" ).append("\n"); 

	}
}