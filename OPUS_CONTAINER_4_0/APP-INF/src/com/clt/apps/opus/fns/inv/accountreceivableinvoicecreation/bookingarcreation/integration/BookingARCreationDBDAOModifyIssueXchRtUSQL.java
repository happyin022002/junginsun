/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyIssueXchRtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyIssueXchRtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyIssueXchRt
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyIssueXchRtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration ").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyIssueXchRtUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG A" ).append("\n"); 
		query.append("    SET ISS_XCH_RT = INV_XCH_RT" ).append("\n"); 
		query.append("      , UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("      , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("  WHERE EXISTS (SELECT AR_IF_NO, AR_IF_SER_NO, CHG_SEQ" ).append("\n"); 
		query.append("                  FROM INV_AR_ISS_DTL" ).append("\n"); 
		query.append("                 WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                   AND AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("                   AND CHG_SEQ = A.CHG_SEQ)" ).append("\n"); 

	}
}