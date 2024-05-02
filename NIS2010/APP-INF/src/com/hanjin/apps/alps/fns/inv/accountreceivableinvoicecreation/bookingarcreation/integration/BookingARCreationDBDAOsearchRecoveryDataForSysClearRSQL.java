/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchRecoveryDataForSysClearRSQL.java
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

public class BookingARCreationDBDAOsearchRecoveryDataForSysClearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchRecoveryDataForSysClearRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchRecoveryDataForSysClearRSQL").append("\n"); 
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
		query.append(", INV_NO" ).append("\n"); 
		query.append(", DUE_DT" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT ERP_IF_GL_DT" ).append("\n"); 
		query.append("FROM   INV_AR_AMT S" ).append("\n"); 
		query.append("WHERE  S.AR_IF_NO = T.AR_IF_NO" ).append("\n"); 
		query.append("AND    ROWNUM     = 1" ).append("\n"); 
		query.append(") AS ERP_IF_GL_DT" ).append("\n"); 
		query.append(", ISS_DT" ).append("\n"); 
		query.append(", INV_REF_NO" ).append("\n"); 
		query.append(", BKG_TEU_QTY" ).append("\n"); 
		query.append(", BKG_FEU_QTY" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT,'YYYYMMDDHH24MISS') UPD_DT" ).append("\n"); 
		query.append("FROM  INV_AR_MN T" ).append("\n"); 
		query.append("WHERE AR_IF_NO IN (" ).append("\n"); 
		query.append("SELECT AR_IF_NO" ).append("\n"); 
		query.append("FROM   INV_AR_ISS_FTR" ).append("\n"); 
		query.append("WHERE  INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}