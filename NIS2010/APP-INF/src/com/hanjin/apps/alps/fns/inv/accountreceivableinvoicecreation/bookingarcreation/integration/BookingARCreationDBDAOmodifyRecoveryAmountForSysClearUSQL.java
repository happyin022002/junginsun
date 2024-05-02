/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOmodifyRecoveryAmountForSysClearUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOmodifyRecoveryAmountForSysClearUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Issue 작업과 Sys Clear 작업에 불일치 문제를 해결한다.
	  * Issue 작업 중간에 Sys Clear 작업이 된 Amount A/F IF 정보를 변경한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOmodifyRecoveryAmountForSysClearUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOmodifyRecoveryAmountForSysClearUSQL").append("\n"); 
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
		query.append("UPDATE  INV_AR_AMT" ).append("\n"); 
		query.append("SET     ERP_IF_GL_DT  = @[erp_if_gl_dt]" ).append("\n"); 
		query.append(", UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT      = TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     AR_IF_NO = (" ).append("\n"); 
		query.append("SELECT AR_IF_NO FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     INV_CLR_FLG = 'Y'" ).append("\n"); 
		query.append("AND     AR_IF_NO  = @[ar_if_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}