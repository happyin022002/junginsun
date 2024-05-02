/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanAvailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.12.29 장준우
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

public class LeasePlanDBDAONewVanCNTRDeliveryPlanAvailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 AGMT No에 대한 유효성을 검증한다.
	  * </pre>
	  */
	public LeasePlanDBDAONewVanCNTRDeliveryPlanAvailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanAvailRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT TO_CHAR(TO_DATE(A.PLN_YRMON,'YYYYMM'),'YYYY-MM') AS DUP_YRMON" ).append("\n"); 
		query.append("FROM    LSE_NEW_VAN_DE_PLN A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = 'HHO'" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND     A.PLN_YRMON <> @[pln_yrmon]" ).append("\n"); 
		query.append("AND     A.PLN_YRMON LIKE SUBSTR(@[pln_yrmon],1,4)||'%'" ).append("\n"); 

	}
}