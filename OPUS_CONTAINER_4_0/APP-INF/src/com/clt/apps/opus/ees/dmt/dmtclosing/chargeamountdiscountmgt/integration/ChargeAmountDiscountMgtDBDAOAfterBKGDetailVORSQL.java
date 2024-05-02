/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOAfterBKGDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOAfterBKGDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking Request Container 결과목록 정보를 저장할 VO 객체를 생성하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOAfterBKGDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOAfterBKGDetailVORSQL").append("\n"); 
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
		query.append("SELECT	'' TVVD" ).append("\n"); 
		query.append(", 	'' POR_CD" ).append("\n"); 
		query.append(", 	'' POL_CD" ).append("\n"); 
		query.append(", 	'' POD_CD" ).append("\n"); 
		query.append(",	'' DEL_CD" ).append("\n"); 
		query.append(", 	'' RD" ).append("\n"); 
		query.append(",   '' DCGO_FLG" ).append("\n"); 
		query.append(",	'' RC_FLG" ).append("\n"); 
		query.append(", 	'' AWK_CGO_FLG" ).append("\n"); 
		query.append(",	'' BB_CGO_FLG" ).append("\n"); 
		query.append(", 	'' RD_CGO_FLG" ).append("\n"); 
		query.append(", 	'' SOC_FLG" ).append("\n"); 
		query.append(", 	'' CMDT_CD" ).append("\n"); 
		query.append(",	'' CMDT_NM" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' BKG_NO" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}