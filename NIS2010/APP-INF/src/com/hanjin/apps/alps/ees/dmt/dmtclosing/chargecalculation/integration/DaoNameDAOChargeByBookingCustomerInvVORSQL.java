/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOChargeByBookingCustomerInvVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOChargeByBookingCustomerInvVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeByBookingCustomerInvVO
	  * </pre>
	  */
	public DaoNameDAOChargeByBookingCustomerInvVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",'' DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",'' FT_END_DT" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' INV_CURR_CD" ).append("\n"); 
		query.append(",'' INV_CHG_AMT" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' EXP_DEL_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtclosing.chargecalculation.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOChargeByBookingCustomerInvVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}