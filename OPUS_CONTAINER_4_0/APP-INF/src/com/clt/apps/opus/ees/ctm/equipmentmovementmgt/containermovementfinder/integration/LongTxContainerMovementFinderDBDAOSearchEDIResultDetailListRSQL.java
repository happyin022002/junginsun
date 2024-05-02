/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOSearchEDIResultDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOSearchEDIResultDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOSearchEDIResultDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divide",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOSearchEDIResultDetailListRSQL").append("\n"); 
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
		query.append("SELECT E.CNTR_NO" ).append("\n"); 
		query.append("       ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,E.EDI_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,E.EDI_GATE_IO_CD" ).append("\n"); 
		query.append("       ,E.EVNT_YD_CD" ).append("\n"); 
		query.append("       ,TO_CHAR (E.EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVNT_DT" ).append("\n"); 
		query.append("       ,TO_CHAR (E.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT" ).append("\n"); 
		query.append("#if (${divide} == 'edi_12h' || ${divide} == 'edi_24h' || ${divide} == 'edi_48h' || ${divide} == 'edi_over' || ${divide} == 'edi_ttl')" ).append("\n"); 
		query.append("       ,UPPER(@[divide]) AS METHOD" ).append("\n"); 
		query.append("       ,ROUND((E.CRE_LOCL_DT - E.EVNT_DT) * 24, 1)  AS GAP" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       ,DECODE (R.EDI_RMK, NULL, 'There is no error MSG history', R.EDI_RMK) AS MVMT_EDI_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM CTM_MVMT_EDI_MSG E" ).append("\n"); 
		query.append("       ,CTM_EDI_RSLT_RMK R" ).append("\n"); 
		query.append("       ,MST_CONTAINER C" ).append("\n"); 
		query.append("       ,MDM_LOCATION ML" ).append("\n"); 
		query.append("       ,MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND E.IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("#if (${rcc} == 'Total')" ).append("\n"); 
		query.append("#if (${rcc_cd} == '' || ${rcc_cd} == 'ALL')" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_AREA_CD IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_AREA_CD = (SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("                                   FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                  WHERE CNT_CD = SUBSTR (@[rcc_cd], 0, 2)" ).append("\n"); 
		query.append("                                    AND SUBSTR (SYS_AREA_GRP_ID, 0, 1) != 'D')" ).append("\n"); 
		query.append("   AND ME.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lcc_cd} != '')" ).append("\n"); 
		query.append("   AND ME.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("   AND E.EVNT_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("   AND E.EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${rcc} == '')" ).append("\n"); 
		query.append("#if (${yard} != '')" ).append("\n"); 
		query.append("   AND E.EVNT_YD_CD = @[yard]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND E.EVNT_YD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_AREA_CD = (SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("                                   FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                  WHERE CNT_CD = SUBSTR (@[rcc], 0, 2)" ).append("\n"); 
		query.append("                                    AND SUBSTR (SYS_AREA_GRP_ID, 0, 1) != 'D')" ).append("\n"); 
		query.append("   AND E.EVNT_YD_CD = @[yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND E.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_TP_CD = R.MVMT_EDI_TP_CD(+)" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_TP_ID = R.MVMT_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_AREA_CD = R.MVMT_EDI_MSG_AREA_CD(+)" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_YRMONDY = R.MVMT_EDI_MSG_YRMONDY(+)" ).append("\n"); 
		query.append("   AND E.MVMT_EDI_MSG_SEQ = R.MVMT_EDI_MSG_SEQ(+)" ).append("\n"); 
		query.append("   AND R.RTY_KNT(+) = 0" ).append("\n"); 
		query.append("   AND ME.SCC_CD(+) = ML.SCC_CD" ).append("\n"); 
		query.append("   AND ML.LOC_CD(+) = SUBSTR (E.EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("#if (${divide} == 'int_err')" ).append("\n"); 
		query.append("   AND R.MVMT_EDI_RSLT_CD = 'N'" ).append("\n"); 
		query.append("#elseif (${divide} == 'int_ignr')" ).append("\n"); 
		query.append("   AND R.MVMT_EDI_RSLT_CD IN ('X', 'I')" ).append("\n"); 
		query.append("#elseif (${divide} == 'int_ttl')" ).append("\n"); 
		query.append("   AND E.RTY_KNT = E.RTY_KNT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND R.MVMT_EDI_RSLT_CD = 'Y'" ).append("\n"); 
		query.append("   #if (${gap_radio} == '12')" ).append("\n"); 
		query.append("      #if (${divide} == 'edi_12h')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 0.5" ).append("\n"); 
		query.append("      #elseif (${divide} == 'edi_over')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 0.5 " ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 2" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #elseif (${gap_radio} == '24')" ).append("\n"); 
		query.append("      #if (${divide} == 'edi_24h')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 0.5" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 1" ).append("\n"); 
		query.append("      #elseif (${divide} == 'edi_over')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 1 " ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 2" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #elseif (${gap_radio} == '48')" ).append("\n"); 
		query.append("      #if (${divide} == 'edi_48h')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 0.5" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 2" ).append("\n"); 
		query.append("      #elseif (${divide} == 'edi_over')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 2" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      #if (${divide} == 'edi_12h')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 0.5" ).append("\n"); 
		query.append("      #elseif (${divide} == 'edi_24h')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 0.5 " ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 1" ).append("\n"); 
		query.append("      #elseif (${divide} == 'edi_48h')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 1 " ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) < 2" ).append("\n"); 
		query.append("      #elseif (${divide} == 'edi_over')" ).append("\n"); 
		query.append("         AND ROUND(E.CRE_LOCL_DT - E.EVNT_DT, 2) >= 2" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}