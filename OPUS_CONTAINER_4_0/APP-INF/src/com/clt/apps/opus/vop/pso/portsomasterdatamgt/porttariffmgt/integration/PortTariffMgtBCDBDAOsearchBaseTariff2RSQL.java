/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchBaseTariff2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchBaseTariff2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select formula의 tariff조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchBaseTariff2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchBaseTariff2RSQL").append("\n"); 
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
		query.append("SELECT T22.DP_NO AS SEQ" ).append("\n"); 
		query.append("     , T21.CURR_CD CURRENCY" ).append("\n"); 
		query.append("     , (SELECT PSO_OBJ_CD" ).append("\n"); 
		query.append("          FROM PSO_OBJ_LIST" ).append("\n"); 
		query.append("         WHERE OBJ_LIST_NO = T22.OBJ_LIST_NO ) OBJECT" ).append("\n"); 
		query.append("     , T22.OBJ_LIST_NO AS OBJECT_CODE" ).append("\n"); 
		query.append("     , T22.OBJ_LIST_NO AS UOM" ).append("\n"); 
		query.append("     , PSO_TRF_TP_CD AS RATE_CODE" ).append("\n"); 
		query.append("     , T23.FM_VAL RANGE_FROM" ).append("\n"); 
		query.append("     , T23.TO_VAL RANGE_TO" ).append("\n"); 
		query.append("     , T23.TRF_RT_AMT RATE_VALUE" ).append("\n"); 
		query.append("     , T23.COND_NO AS CONDITION" ).append("\n"); 
		query.append("     , T21.FOML_NO AS FORMULA_NO" ).append("\n"); 
		query.append("     , T22.PSO_TRF_TP_CD" ).append("\n"); 
		query.append("     , T23.PORT_TRF_NO" ).append("\n"); 
		query.append("     , T23.TRF_SEQ" ).append("\n"); 
		query.append("     , T21.COND_ALS_NM" ).append("\n"); 
		query.append("  FROM (SELECT T1.CURR_CD" ).append("\n"); 
		query.append("             , T2.PSO_CHG_TP_CD" ).append("\n"); 
		query.append("             , T3.CHG_XPR_NO" ).append("\n"); 
		query.append("             , T3.CHG_XPR_SEQ" ).append("\n"); 
		query.append("             , T3.FOML_NO" ).append("\n"); 
		query.append("             , T4.ROW_NO AS ROW_NO" ).append("\n"); 
		query.append("             , MAX(DECODE(FOML_SEQ, 1, OBJ_LIST_NO)) AS OBJ_CD" ).append("\n"); 
		query.append("             , MAX(DECODE(FOML_SEQ, 2, PSO_FOML_OPR_CD)) AS OPR" ).append("\n"); 
		query.append("             , MAX(DECODE(FOML_SEQ, 3, OBJ_LIST_NO)) AS RATE" ).append("\n"); 
		query.append("             , T3.COND_ALS_NM" ).append("\n"); 
		query.append("          FROM PSO_YD_CHG T1" ).append("\n"); 
		query.append("             , PSO_YD_CHG_XPR T2" ).append("\n"); 
		query.append("             , PSO_CHG_XPR_DTL T3" ).append("\n"); 
		query.append("             , PSO_FOML_DTL T4" ).append("\n"); 
		query.append("             , (SELECT T2.ACCT_CD" ).append("\n"); 
		query.append("                     , T2.LGS_COST_CD" ).append("\n"); 
		query.append("                     , LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                  FROM PSO_INV_OFC_COST T1" ).append("\n"); 
		query.append("                     , TES_LGS_COST T2" ).append("\n"); 
		query.append("                 WHERE T1.LGS_COST_CD = T2.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND T1.OFC_CD = @[OFC_CD]" ).append("\n"); 
		query.append("                   AND T2.ACCT_CD <> '999999'" ).append("\n"); 
		query.append("                   AND LENGTH(T2.LGS_COST_CD) > 4" ).append("\n"); 
		query.append("                 ORDER BY 1 " ).append("\n"); 
		query.append("               ) T5" ).append("\n"); 
		query.append("         WHERE T1.YD_CHG_NO = T2.YD_CHG_NO" ).append("\n"); 
		query.append("           AND T1.YD_CHG_VER_SEQ = T2.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("           AND T1.LGS_COST_CD = T5.LGS_COST_CD" ).append("\n"); 
		query.append("            --AND     T1.LST_FLG          = 'Y'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("#if( ${port_cd} == '' )" ).append("\n"); 
		query.append("           AND T1.YD_CD = @[combo1] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND T1.YD_CD = @[port_cd] || @[combo1] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND T1.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("#if( ${acct_cd} == '')" ).append("\n"); 
		query.append("           AND T1.LGS_COST_CD = @[combo3] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND T5.ACCT_CD = @[acct_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND T1.YD_CHG_VER_SEQ = @[combo4]" ).append("\n"); 
		query.append("           AND T2.CHG_XPR_NO = T3.CHG_XPR_NO" ).append("\n"); 
		query.append("           AND T3.FOML_NO = T4.FOML_NO" ).append("\n"); 
		query.append("         GROUP BY T1.CURR_CD" ).append("\n"); 
		query.append("             , T2.PSO_CHG_TP_CD" ).append("\n"); 
		query.append("             , T3.CHG_XPR_NO" ).append("\n"); 
		query.append("             , T3.CHG_XPR_SEQ" ).append("\n"); 
		query.append("             , COND_NO" ).append("\n"); 
		query.append("             , T3.FOML_NO" ).append("\n"); 
		query.append("             , T4.ROW_NO" ).append("\n"); 
		query.append("             , T3.COND_ALS_NM" ).append("\n"); 
		query.append("       ) T21" ).append("\n"); 
		query.append("     , PSO_TARIFF T22" ).append("\n"); 
		query.append("     , PSO_TRF_DTL T23" ).append("\n"); 
		query.append(" WHERE T21.CHG_XPR_NO = T22.CHG_XPR_NO" ).append("\n"); 
		query.append("   AND T21.CHG_XPR_SEQ = T22.CHG_XPR_SEQ" ).append("\n"); 
		query.append("   AND T22.PORT_TRF_NO = T23.PORT_TRF_NO" ).append("\n"); 
		query.append(" ORDER BY PORT_TRF_NO, TRF_SEQ" ).append("\n"); 

	}
}