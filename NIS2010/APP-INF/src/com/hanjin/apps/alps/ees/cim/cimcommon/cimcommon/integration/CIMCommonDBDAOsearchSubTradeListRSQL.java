/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CIMCommonDBDAOsearchSubTradeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOsearchSubTradeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade별 Sub trade 조회
	  * 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
	  * </pre>
	  */
	public CIMCommonDBDAOsearchSubTradeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOsearchSubTradeListRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD ||'|'||" ).append("\n"); 
		query.append("          B.SUB_TRD_CD ||'|'||" ).append("\n"); 
		query.append("          NVL(B.SUB_TRD_NM, ( SELECT T.TRD_NM" ).append("\n"); 
		query.append("                                FROM MDM_TRADE T" ).append("\n"); 
		query.append("                               WHERE T.TRD_CD = A.TRD_CD)" ).append("\n"); 
		query.append("          ) AS SUB_TRD_NM" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    B.TRD_CD  ," ).append("\n"); 
		query.append("                    B.SUB_TRD_CD" ).append("\n"); 
		query.append("               FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                    MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                    MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("              WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("                AND B.DELT_FLG   IN ('N', null)" ).append("\n"); 
		query.append("                AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("      #if ( ${trade} == 'TP' )" ).append("\n"); 
		query.append("	  	AND B.TRD_CD = 'TPS'" ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'TA' )" ).append("\n"); 
		query.append("	  	AND B.TRD_CD  = 'TAS'" ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'TE' )" ).append("\n"); 
		query.append("	  	AND B.TRD_CD  = 'AES'" ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'EM' )" ).append("\n"); 
		query.append("	  	AND B.TRD_CD  = 'EMS'" ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'AA' )" ).append("\n"); 
		query.append("	  	AND B.FM_CONTI_CD = 'A' " ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'MM' )" ).append("\n"); 
		query.append("	  	AND B.FM_CONTI_CD = 'M' " ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'EE' )" ).append("\n"); 
		query.append("	  	AND B.FM_CONTI_CD = 'E' " ).append("\n"); 
		query.append("	  #elseif ( ${trade} == 'AL' )" ).append("\n"); 
		query.append("	  	AND 1 = 1" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("	  	AND B.TRD_CD  = DECODE(@[trade], NULL, B.TRD_CD, @[trade])" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("          ) A," ).append("\n"); 
		query.append("          MDM_SUB_TRD B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("          B.SUB_TRD_CD" ).append("\n"); 

	}
}