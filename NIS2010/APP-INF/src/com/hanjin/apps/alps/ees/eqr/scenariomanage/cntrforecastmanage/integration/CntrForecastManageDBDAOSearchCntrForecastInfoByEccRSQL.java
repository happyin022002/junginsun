/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageDBDAOSearchCntrForecastInfoByEccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastManageDBDAOSearchCntrForecastInfoByEccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이너 forecast 정보 조회 (ByECC) EQR_AVG_FCAST, EQR_SCNR_MST,  eqr_ob_fcast, eqr_sls_inp_fcast,  eqr_sls_stat_fcast
	  * 
	  * <Change History>
	  * 1	2009.08.12	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrForecastManageDBDAOSearchCntrForecastInfoByEccRSQL(){
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
		params.put("SYrWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EYrWk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration").append("\n"); 
		query.append("FileName : CntrForecastManageDBDAOSearchCntrForecastInfoByEccRSQL").append("\n"); 
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
		query.append("A.FCAST_YRWK," ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("TO_CHAR (TO_DATE (A.FCAST_DT, 'yyyymmdd'),'DY','NLS_DATE_LANGUAGE=AMERICAN') WEEKDAY," ).append("\n"); 
		query.append("A.FM_ECC_CD," ).append("\n"); 
		query.append("A.TO_ECC_CD," ).append("\n"); 
		query.append("A.FCAST_DEL_DT," ).append("\n"); 
		query.append("A.FCAST_DEL_YRWK," ).append("\n"); 
		query.append("'Demand vol' AS DIV," ).append("\n"); 
		query.append("#foreach( $key in ${arrCntrTpszCd})" ).append("\n"); 
		query.append("#if (${fmToAt} == '1')" ).append("\n"); 
		query.append("SUM (DECODE (A.CNTR_TPSZ_CD, '$key', A.CNTR_VOL_QTY, 0)) ${key}_CNTR_VOL_QTY," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUM (DECODE (A.CNTR_TPSZ_CD, '$key', A.CNTR_VOL_QTY, 0)) ${key}_CNTR_VOL_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("A.FCAST_DT," ).append("\n"); 
		query.append("DENSE_RANK() OVER (ORDER BY FCAST_YRWK, FM_ECC_CD, TO_ECC_CD ) AS FLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.FCAST_YRWK," ).append("\n"); 
		query.append("A.CO_CD CO_CD," ).append("\n"); 
		query.append("'Demand vol'," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${fmToAt} == '1')" ).append("\n"); 
		query.append("#if (${fmTypeBy} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${fmTypeBy} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${fmTypeBy} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${atTypeBy} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${atTypeBy} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${atTypeBy} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.FM_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") FM_ECC_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${fmToAt} == '1')" ).append("\n"); 
		query.append("#if (${toTypeBy} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${toTypeBy} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${toTypeBy} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${atTypeBy} == 'R')" ).append("\n"); 
		query.append("RCC_CD" ).append("\n"); 
		query.append("#elseif (${atTypeBy} == 'C')" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append("#elseif (${atTypeBy} == 'L')" ).append("\n"); 
		query.append("LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM EQR_ECC_MST" ).append("\n"); 
		query.append("WHERE A.TO_ECC_CD = ECC_CD" ).append("\n"); 
		query.append(") TO_ECC_CD," ).append("\n"); 
		query.append("FCAST_DEL_DT," ).append("\n"); 
		query.append("FCAST_DEL_YRWK," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("MAX(A.CNTR_VOL_QTY)CNTR_VOL_QTY," ).append("\n"); 
		query.append("A.FCAST_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_OB_FCAST A," ).append("\n"); 
		query.append("#if (${fmToAt} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($arrFmEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${fmType} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${fmType} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrFmEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrFmEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${atType} != '' && $arrAtEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${atType} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${atType} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrAtEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrAtEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) C" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fmToAt} == '1')" ).append("\n"); 
		query.append("(SELECT ECC_CD FROM EQR_ECC_MST WHERE 1 = 1" ).append("\n"); 
		query.append("#if ($arrToEccCd.size() > 0)" ).append("\n"); 
		query.append("#if (${toType} == 'R')" ).append("\n"); 
		query.append("AND RCC_CD" ).append("\n"); 
		query.append("#elseif (${toType} == 'L')" ).append("\n"); 
		query.append("AND LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ECC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrToEccCd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrToEccCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")) D" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${fmToAt} == '1')" ).append("\n"); 
		query.append("A.FM_ECC_CD = C.ECC_CD AND A.TO_ECC_CD = D.ECC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(A.FM_ECC_CD = C.ECC_CD OR A.TO_ECC_CD = C.ECC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.SCNR_ID = @[scnrId]" ).append("\n"); 
		query.append("AND A.FCAST_YRWK BETWEEN @[SYrWk] AND @[EYrWk]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SCNR_ID, A.FCAST_YRWK, A.CO_CD, 'Demand vol', A.FM_ECC_CD," ).append("\n"); 
		query.append("A.TO_ECC_CD, A.FCAST_DEL_DT, A.FCAST_DEL_YRWK, A.FCAST_DT, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")a" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SCNR_ID, A.FCAST_YRWK, A.CO_CD, 'Demand vol', A.FM_ECC_CD," ).append("\n"); 
		query.append("A.TO_ECC_CD, A.FCAST_DT, A.FCAST_DEL_DT, A.FCAST_DEL_YRWK" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("SCNR_ID, A.FCAST_YRWK, 'Demand vol', A.FM_ECC_CD, A.TO_ECC_CD, A.FCAST_DT" ).append("\n"); 

	}
}