/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOInvoiceUserIdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.03 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOInvoiceUserIdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1
	  * </pre>
	  */
	public BookingARCreationDBDAOInvoiceUserIdUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("UPDATE INV_AR_MN SET" ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	AR_IF_NO = @[ar_if_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvoiceUserIdUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}