/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.18 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAONewVanCNTRDeliveryPlanCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신조장비(OW/LP/OL) 계획목록 전체건수를 조회한다.
	  * </pre>
	  */
	public LeasePlanDBDAONewVanCNTRDeliveryPlanCountRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	COUNT(*) TOTAL_CNT" ).append("\n"); 
		query.append("FROM	LSE_NEW_VAN_DE_PLN" ).append("\n"); 
		query.append("WHERE	PLN_YRMON = @[pln_yrmon]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanCountRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}