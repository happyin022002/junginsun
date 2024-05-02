/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.09.17 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM CHANG SIK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.SearchCHSCoPoolChargeListData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSCoPoolChargeListDataRSQL").append("\n"); 
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
		query.append("SELECT A.INV_NO," ).append("\n"); 
		query.append("A.CHSS_MGST_INV_STS_CD" ).append("\n"); 
		query.append("FROM CGM_PAY_INV A" ).append("\n"); 
		query.append("WHERE A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.CHSS_MGST_INV_KND_CD = 'CP'" ).append("\n"); 
		query.append("ORDER BY A.INV_NO" ).append("\n"); 

	}
}