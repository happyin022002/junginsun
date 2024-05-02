/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
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

public class PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORT_CD를 입력받아 지역통화를 구한다. <단건조회>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchLocalCurrencyByPortCdRSQL").append("\n"); 
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
		query.append("WITH V_CURRENCY AS (" ).append("\n"); 
		query.append("    SELECT NVL(A.CURR_CD, B.AR_CURR_CD) AS CURRENCY" ).append("\n"); 
		query.append("      FROM MDM_CURRENCY A" ).append("\n"); 
		query.append("         , MDM_ORGANIZATION B" ).append("\n"); 
		query.append("     WHERE A.CNT_CD(+) = SUBSTR(B.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("       AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND B.LOC_CD = @[port_cd]" ).append("\n"); 
		query.append("     GROUP BY  NVL(A.CURR_CD, B.AR_CURR_CD)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("/*n or 0 건일경우 MDM_LOCATION 에서 Ofc_cd에 연결된 Currency를 재조회 한다.*/  " ).append("\n"); 
		query.append("SELECT CASE WHEN CURR_CNT = 1  THEN ( SELECT V.CURRENCY" ).append("\n"); 
		query.append("                                        FROM V_CURRENCY V" ).append("\n"); 
		query.append("                                       WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("           ELSE (  SELECT NVL(C.CURR_CD, O.AR_CURR_CD)" ).append("\n"); 
		query.append("                      FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                         , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                         , MDM_CURRENCY C" ).append("\n"); 
		query.append("                     WHERE 1=1" ).append("\n"); 
		query.append("                       AND L.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND L.LOC_CD = @[port_cd]" ).append("\n"); 
		query.append("                       AND L.FINC_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                       AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND L.CNT_CD = C.CNT_CD(+)" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("       END AS CURRENCY       " ).append("\n"); 
		query.append("  FROM (SELECT COUNT(*) AS CURR_CNT FROM V_CURRENCY)" ).append("\n"); 

	}
}