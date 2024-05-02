/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchChangedDataForSysClearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchChangedDataForSysClearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이슈 대상 중에 이미 Sys Clear가 실행된 AR IF NO를 조회한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchChangedDataForSysClearRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchChangedDataForSysClearRSQL").append("\n"); 
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
		query.append("SELECT  AR_IF_NO" ).append("\n"); 
		query.append("FROM    INV_AR_MN" ).append("\n"); 
		query.append("WHERE    INV_CLR_FLG = 'Y'" ).append("\n"); 
		query.append("AND       AR_IF_NO IN (" ).append("\n"); 
		query.append("SELECT AR_IF_NO" ).append("\n"); 
		query.append("FROM   INV_AR_ISS_FTR" ).append("\n"); 
		query.append("WHERE  INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}