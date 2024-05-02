/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAOLongTermCNTRDeliveryPerformanceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.06.21 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAOLongTermCNTRDeliveryPerformanceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Long Term Lease Container  Delivery Performance Detail Search
	  * </pre>
	  */
	public LeasePlanDBDAOLongTermCNTRDeliveryPerformanceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onhire_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOLongTermCNTRDeliveryPerformanceDetailRSQL").append("\n"); 
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
		query.append("SELECT ONHR.CNTR_NO" ).append("\n"); 
		query.append("     , ONHR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , ONHR.LSTM_CD" ).append("\n"); 
		query.append("     , TO_CHAR(ONHR.ONHIRE_DT,'YYYY-MM-DD') AS ONHIRE_DT" ).append("\n"); 
		query.append("     , ONHR.ONHIRE_LOC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(OFHR.CNTR_STS_EVNT_DT,'YYYY-MM-DD') AS OFFHIRE_DT" ).append("\n"); 
		query.append("     , OFHR.YD_CD            AS OFFHIRE_LOC_CD" ).append("\n"); 
		query.append("     , ROUND(OFHR.CNTR_STS_EVNT_DT - ONHR.ONHIRE_DT) - ONHR.FREE_DYS + 1 AS USED_DYS" ).append("\n"); 
		query.append("     , ONHR.FREE_DYS " ).append("\n"); 
		query.append("     , ONHR.MIN_ONHIRE_DYS" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("         SELECT HS.CNTR_NO" ).append("\n"); 
		query.append("              , CN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , CN.LSTM_CD" ).append("\n"); 
		query.append("              , HS.CNTR_STS_EVNT_DT  AS ONHIRE_DT" ).append("\n"); 
		query.append("              , HS.YD_CD             AS ONHIRE_LOC_CD" ).append("\n"); 
		query.append("              , HS.RNTL_CHG_FREE_DYS AS FREE_DYS" ).append("\n"); 
		query.append("              , HS.CNTR_MIN_ONH_DYS  AS MIN_ONHIRE_DYS" ).append("\n"); 
		query.append("              , HS.AGMT_CTY_CD" ).append("\n"); 
		query.append("              , HS.AGMT_SEQ" ).append("\n"); 
		query.append("              , HS.CNTR_STS_SEQ" ).append("\n"); 
		query.append("         FROM   MST_CONTAINER CN" ).append("\n"); 
		query.append("              , MST_CNTR_STS_HIS HS" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${de_mon} != '')" ).append("\n"); 
		query.append("         AND    TO_CHAR(HS.CNTR_STS_EVNT_DT,'YYYYMM') = @[de_yr] || @[de_mon]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND    TO_CHAR(HS.CNTR_STS_EVNT_DT,'YYYY') = @[de_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND    substr(nvl(HS.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("         AND    HS.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("         AND    HS.CNTR_STS_CD in ('LSI','DII')" ).append("\n"); 
		query.append("#if (${onhire_loc_cd} != '')" ).append("\n"); 
		query.append("         AND    HS.LCC_CD = @[onhire_loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND    HS.LCC_CD IN ( SELECT DISTINCT C.LCC_CD " ).append("\n"); 
		query.append("                               FROM   LSE_LONG_TERM_DE_PLN PLN" ).append("\n"); 
		query.append("								    , MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("							   WHERE  PLN.DEL_CD = C.SCC_CD" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '')" ).append("\n"); 
		query.append("                               AND    PLN.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("                               AND    PLN.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pln_yr} != '')" ).append("\n"); 
		query.append("                               AND    PLN.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_yr} != '')" ).append("\n"); 
		query.append("                               AND    SUBSTR(PLN.DE_YRMON, 0, 4) = @[de_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND    CN.CNTR_NO = HS.CNTR_NO" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("         AND    CN.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("         AND    HS.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '')" ).append("\n"); 
		query.append("         AND    HS.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) ONHR" ).append("\n"); 
		query.append("     , MST_CNTR_STS_HIS OFHR" ).append("\n"); 
		query.append("WHERE  ONHR.CNTR_NO = OFHR.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    ONHR.CNTR_STS_SEQ = OFHR.PRNR_STS_SEQ(+)" ).append("\n"); 

	}
}