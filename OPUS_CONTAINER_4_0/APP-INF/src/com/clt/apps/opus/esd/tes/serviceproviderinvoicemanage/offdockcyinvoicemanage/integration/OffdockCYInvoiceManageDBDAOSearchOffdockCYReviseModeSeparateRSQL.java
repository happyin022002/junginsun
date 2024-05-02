/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYReviseModeSeparateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.09.03 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdockCYReviseModeSeparateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOffdockCYReviseModeSeparate
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdockCYReviseModeSeparateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdockCYReviseModeSeparateRSQL").append("\n"); 
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
		query.append("SELECT NVL(RVIS_CNTR_LIST_CD,'N')	RVIS_CNTR_LIST_CD" ).append("\n"); 
		query.append("FROM TES_TML_SO_COST" ).append("\n"); 
		query.append("WHERE LGS_COST_CD = @[param_lgs_cost_cd]" ).append("\n"); 

	}
}