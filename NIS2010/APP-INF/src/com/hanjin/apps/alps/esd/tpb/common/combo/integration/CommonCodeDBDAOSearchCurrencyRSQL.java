/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB Manual Registration Currency Combo
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCurrencyRSQL").append("\n"); 
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
		query.append("SELECT BIL_CURR_CD, BIL_CURR_CD AS BIL_CURR_CD1 FROM MDM_ORGANIZATION WHERE OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("UNION ALL SELECT 'USD' AS BIL_CURR_CD, 'USD' AS BIL_CURR_CD1 FROM DUAL" ).append("\n"); 
		query.append("UNION SELECT 'CAD' AS BIL_CURR_CD, 'CAD' AS BIL_CURR_CD1 FROM DUAL WHERE 'US' = @[s_cnt_cd]" ).append("\n"); 
		query.append("UNION SELECT 'EUR' AS BIL_CURR_CD, 'EUR' AS BIL_CURR_CD1 FROM DUAL WHERE 'HAMRU' = @[s_rhq_cd] --HAMUR 조직변경" ).append("\n"); 
		query.append("UNION SELECT 'HKD' AS BIL_CURR_CD, 'HKD' AS BIL_CURR_CD1 FROM DUAL WHERE 'SZPSC' = @[s_ofc_cd] --SZPBB 조직변경" ).append("\n"); 

	}
}