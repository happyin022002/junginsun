/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchYardListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchYardListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * issue date에 해당하는 야드만 조회
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchYardListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchYardListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT P.YD_CD, Y.YD_NM" ).append("\n"); 
		query.append("FROM PSO_YD_CHG P, MDM_YARD Y" ).append("\n"); 
		query.append("WHERE SUBSTR(P.YD_CD,1,5) = @[port_cd]" ).append("\n"); 
		query.append("AND P.LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND P.YD_CD = Y.YD_CD" ).append("\n"); 
		query.append("#if( ${issue_date} != '' )" ).append("\n"); 
		query.append("AND TO_DATE(REPLACE(@[issue_date], '-', ''), 'YYYYMMDD') BETWEEN P.EFF_DT AND P.EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY P.YD_CD" ).append("\n"); 

	}
}