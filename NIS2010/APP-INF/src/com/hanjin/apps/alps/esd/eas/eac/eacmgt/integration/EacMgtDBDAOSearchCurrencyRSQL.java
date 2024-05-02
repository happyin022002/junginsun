/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EacMgtDBDAOSearchCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.17
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.08.17 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Currency 값을 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchCurrencyRSQL").append("\n"); 
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
		query.append("SELECT BIL_CURR_CD, BIL_CURR_CD AS BIL_CURR_CD1 FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("UNION ALL SELECT 'USD' AS BIL_CURR_CD, 'USD' AS BIL_CURR_CD1 FROM DUAL" ).append("\n"); 
		query.append("UNION SELECT 'CAD' AS BIL_CURR_CD, 'CAD' AS BIL_CURR_CD1 FROM DUAL WHERE 'US' = (SELECT DECODE(C.CNT_CD,'HQ','KR',C.CNT_CD) CNT_CD" ).append("\n"); 
		query.append("                                                                                   FROM MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                                                                                      , MDM_LOCATION C    " ).append("\n"); 
		query.append("                                                                                  WHERE 1 = 1" ).append("\n"); 
		query.append("                                                                                    AND B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                                                                    AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                                                                    AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                                                                    AND B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("                                                                                 )" ).append("\n"); 
		query.append("UNION SELECT DECODE(@[ofc_cd],'HFABA','ILS','EUR') AS BIL_CURR_CD, DECODE(@[ofc_cd],'HFABA','ILS','EUR') AS BIL_CURR_CD1 FROM DUAL WHERE 'HAMRU' = TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(@[ofc_cd])" ).append("\n"); 
		query.append("UNION SELECT 'HKD' AS BIL_CURR_CD, 'HKD' AS BIL_CURR_CD1 FROM DUAL WHERE 'SZPSC' = @[ofc_cd]" ).append("\n"); 

	}
}