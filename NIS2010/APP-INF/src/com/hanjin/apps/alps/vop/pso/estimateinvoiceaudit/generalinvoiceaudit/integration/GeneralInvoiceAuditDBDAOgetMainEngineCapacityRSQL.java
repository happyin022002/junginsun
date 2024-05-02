/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetMainEngineCapacityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetMainEngineCapacityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VESSEL의 MAIN ENGINE 값 가져오기 ( 기준 : KW )
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetMainEngineCapacityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetMainEngineCapacityRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MN_ENG_HOR_PWR_UT_CD = 'KW' THEN" ).append("\n"); 
		query.append("                 NVL(MN_ENG_BHP_PWR,0)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 NVL(MN_ENG_BHP_PWR,0) * 0.7356" ).append("\n"); 
		query.append("            END AS MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR A" ).append("\n"); 
		query.append(" WHERE VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 

	}
}