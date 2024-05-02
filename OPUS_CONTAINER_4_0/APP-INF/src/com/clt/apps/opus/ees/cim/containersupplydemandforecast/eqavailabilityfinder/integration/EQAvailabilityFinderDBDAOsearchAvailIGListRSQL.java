/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQAvailabilityFinderDBDAOsearchAvailIGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.07.15 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQAvailabilityFinderDBDAOsearchAvailIGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IG(I/B MTY Generation) 예측수량을 Detail하게 조회
	  * </pre>
	  */
	public EQAvailabilityFinderDBDAOsearchAvailIGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration").append("\n"); 
		query.append("FileName : EQAvailabilityFinderDBDAOsearchAvailIGListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	TO_CHAR(A.FCAST_DT,'YYYY-MM-DD') FCAST_DT" ).append("\n"); 
		query.append("   ,A.YD_CD" ).append("\n"); 
		query.append("   ,A.BKG_NO" ).append("\n"); 
		query.append("   ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   ,A.CNTR_QTY CNTR_VOL_QTY" ).append("\n"); 
		query.append("   ,B.DE_TERM_CD" ).append("\n"); 
		query.append("   ,(SELECT REPLACE(REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' '),CHR(10), ' ')" ).append("\n"); 
		query.append("    FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("    WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("    AND W.BKG_CUST_TP_CD='S') SHPR                               " ).append("\n"); 
		query.append("                                                                 " ).append("\n"); 
		query.append("   ,(SELECT REPLACE(REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' '),CHR(10), ' ')" ).append("\n"); 
		query.append("    FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("    WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("    AND W.BKG_CUST_TP_CD='C') CNEE                               " ).append("\n"); 
		query.append("                                                                 " ).append("\n"); 
		query.append("   ,(SELECT REPLACE(REPLACE(SUBSTR(W.CUST_NM,1,50),CHR(13)||chr(10),' '),CHR(10), ' ')" ).append("\n"); 
		query.append("    FROM BKG_CUSTOMER W                                          " ).append("\n"); 
		query.append("    WHERE A.BKG_NO = W.BKG_NO                                    " ).append("\n"); 
		query.append("    AND W.BKG_CUST_TP_CD='N') NTFY  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    CIM_AVAL_DTL A, BKG_BOOKING B ,MDM_LOCATION L, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("WHERE A.CNTR_AVAL_FCAST_TP_CD='IG'" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("AND   L.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("    AND L.LOC_CD = SUBSTR(@[loc_cd],1,5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("	AND A.FCAST_DT BETWEEN TO_DATE(@[fcast_dt],'YYYYMMDD') AND TO_DATE(@[fcast_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   L.LOC_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("ORDER BY  A.FCAST_DT ,A.YD_CD ,A.BKG_NO ,A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}