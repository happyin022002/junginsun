/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQAvailabilityFinderDBDAOsearchAvailTpSzListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQAvailabilityFinderDBDAOsearchAvailTpSzListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Availability 조회
	  * </pre>
	  */
	public EQAvailabilityFinderDBDAOsearchAvailTpSzListRSQL(){
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
		params.put("rstr_usg_lbl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration").append("\n"); 
		query.append("FileName : EQAvailabilityFinderDBDAOsearchAvailTpSzListRSQL").append("\n"); 
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
		query.append("SELECT A.SCC_CD AS SCC_CD" ).append("\n"); 
		query.append("       ,  TO_CHAR(A.FCAST_DT,'YYYYMMDD') AS FCAST_DT" ).append("\n"); 
		query.append("       ,  A.CNTR_TPSZ_CD AS TP_CD" ).append("\n"); 
		query.append("       ,  SUM(A.EA) EA1" ).append("\n"); 
		query.append("       ,  SUM(A.BR) BR1" ).append("\n"); 
		query.append("       ,  SUM(A.PUP) PUP1" ).append("\n"); 
		query.append("       ,  SUM(A.RO) RO1" ).append("\n"); 
		query.append("       ,  SUM(A.OFH) OFH1" ).append("\n"); 
		query.append("       ,  SUM(A.DG) DG1" ).append("\n"); 
		query.append("       ,  SUM(A.SN) SN1" ).append("\n"); 
		query.append("       ,  SUM(A.IG) IG1" ).append("\n"); 
		query.append("       ,  SUM(A.RTN) RTN1" ).append("\n"); 
		query.append("       ,  SUM(A.RI) RI1" ).append("\n"); 
		query.append("       ,  SUM(A.ONH) ONH1" ).append("\n"); 
		query.append("    FROM CIM_AVAL_SMRY_V A," ).append("\n"); 
		query.append("                     (          " ).append("\n"); 
		query.append("                         SELECT" ).append("\n"); 
		query.append("                             MAX(DECODE(RANK,1,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL1 " ).append("\n"); 
		query.append("                            ,MAX(DECODE(RANK,2,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL2 " ).append("\n"); 
		query.append("                            ,MAX(DECODE(RANK,3,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL3 " ).append("\n"); 
		query.append("                            ,MAX(DECODE(RANK,4,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL4" ).append("\n"); 
		query.append("               , @[loc_type_code] AS LOC_TP " ).append("\n"); 
		query.append("                         FROM" ).append("\n"); 
		query.append("                         (" ).append("\n"); 
		query.append("                             SELECT" ).append("\n"); 
		query.append("                                    A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                    ,RANK() OVER (ORDER BY A.CNTR_TPSZ_CD) RANK" ).append("\n"); 
		query.append("                               FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("                               WHERE A.CNTR_TPSZ_CD IN (@[cntr_tpsz_cd_val1],@[cntr_tpsz_cd_val2],@[cntr_tpsz_cd_val3],@[cntr_tpsz_cd_val4])" ).append("\n"); 
		query.append("                               ORDER BY A.RPT_DP_SEQ" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                     ) C" ).append("\n"); 
		query.append("        , MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("    WHERE D.SCC_CD = A.SCC_CD" ).append("\n"); 
		query.append("           #if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("                     AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("                     AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("                     AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("                     AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("               AND A.YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("                     AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${rstr_usg_lbl} != '')" ).append("\n"); 
		query.append("                     AND A.RSTR_USG_TP_LBL_DESC LIKE '%'|| @[rstr_usg_lbl] ||'%'" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD IN (@[cntr_tpsz_cd_val1],@[cntr_tpsz_cd_val2],@[cntr_tpsz_cd_val3],@[cntr_tpsz_cd_val4])" ).append("\n"); 
		query.append("    GROUP BY A.SCC_CD, A.CNTR_TPSZ_CD,  A.FCAST_DT" ).append("\n"); 
		query.append("    ORDER BY A.SCC_CD, A.CNTR_TPSZ_CD,  A.FCAST_DT" ).append("\n"); 

	}
}