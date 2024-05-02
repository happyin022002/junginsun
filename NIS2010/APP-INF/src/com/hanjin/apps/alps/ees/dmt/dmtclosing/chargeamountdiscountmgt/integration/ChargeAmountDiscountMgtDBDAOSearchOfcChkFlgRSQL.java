/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchOfcChkFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchOfcChkFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchOfcChkFlg
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchOfcChkFlgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchOfcChkFlgRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_CLOB_FNC(CURSOR( SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                            FROM dmt_hrd_cdg_ctnt" ).append("\n"); 
		query.append("                            WHERE HRD_CDG_ID = 'AFT_BKG_OFC_CHK'" ).append("\n"); 
		query.append("                          ), '|'" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}