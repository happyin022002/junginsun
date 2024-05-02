/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOVIEInvoiceExrateMainUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.29 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationBackEndDBDAOVIEInvoiceExrateMainUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율정보 Update
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOVIEInvoiceExrateMainUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOVIEInvoiceExrateMainUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN A" ).append("\n"); 
		query.append("SET A.USD_XCH_RT = @[usd_xch_rt]," ).append("\n"); 
		query.append("A.XCH_RT_DT = @[xch_rt_dt]," ).append("\n"); 
		query.append("A.INV_TTL_LOCL_AMT = (SELECT ROUND(NVL(SUM(CHG_AMT*INV_XCH_RT),0)) FROM INV_AR_CHG WHERE AR_IF_NO = A.AR_IF_NO)," ).append("\n"); 
		query.append("A.UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}