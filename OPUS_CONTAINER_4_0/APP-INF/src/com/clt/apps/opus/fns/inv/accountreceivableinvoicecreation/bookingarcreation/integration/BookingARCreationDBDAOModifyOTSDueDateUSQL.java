/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyOTSDueDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyOTSDueDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify OTS Due Date
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyOTSDueDateUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyOTSDueDateUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_HDR " ).append("\n"); 
		query.append("SET (DUE_DT, BKG_REF_NO, UPD_USR_ID, UPD_DT) " ).append("\n"); 
		query.append("    = ( SELECT DUE_DT, INV_REF_NO, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append("        FROM INV_AR_MN A" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = @[ar_if_no] )" ).append("\n"); 
		query.append("WHERE (CLT_OFC_CD, BL_NO, INV_NO) IN ( SELECT A.AR_OFC_CD, A.BL_SRC_NO, DECODE(B.OTS_SMRY_CD, 'BL', '**********', NVL(A.INV_NO, '**********'))" ).append("\n"); 
		query.append("                                       FROM INV_AR_MN A," ).append("\n"); 
		query.append("                                            INV_AR_STUP_OFC B" ).append("\n"); 
		query.append("                                       WHERE A.AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                                       AND A.AR_IF_NO = @[ar_if_no])" ).append("\n"); 

	}
}