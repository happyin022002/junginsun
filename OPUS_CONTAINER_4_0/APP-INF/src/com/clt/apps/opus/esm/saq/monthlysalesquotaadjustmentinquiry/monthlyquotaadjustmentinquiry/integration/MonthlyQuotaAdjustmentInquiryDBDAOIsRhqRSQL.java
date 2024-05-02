/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentInquiryDBDAOIsRhqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.04.28 이상용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentInquiryDBDAOIsRhqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * isRhq
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentInquiryDBDAOIsRhqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orgCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentInquiryDBDAOIsRhqRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      DECODE(NVL(MIN(OFC_CD), 'X'), 'X', 'X', 'O') AS IS_RHQ" ).append("\n"); 
		query.append("FROM  SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append("WHERE LVL = 2" ).append("\n"); 
		query.append("AND   OFC_CD = @[orgCd]			" ).append("\n"); 

	}
}