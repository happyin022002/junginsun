/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssChgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.25 
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

public class BookingARCreationDBDAOInvIssChgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssChg
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssChgUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssChgUSQL").append("\n"); 
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
		query.append("SET INV_ISS_FLG ='Y'" ).append("\n"); 
		query.append("--,INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append(",UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO IN (SELECT V1.AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_ISS_FTR V1" ).append("\n"); 
		query.append("WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", V1.VSL_CD" ).append("\n"); 
		query.append(", V1.SKD_VOY_NO" ).append("\n"); 
		query.append(", V1.SKD_DIR_CD" ).append("\n"); 
		query.append(", V1.IO_BND_CD" ).append("\n"); 
		query.append(", V1.PORT_CD" ).append("\n"); 
		query.append(", V1.SVC_SCP_CD" ).append("\n"); 
		query.append("#if (${inv_mlt_bl_iss_flg} != 'Y')" ).append("\n"); 
		query.append(", V1.BL_SRC_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append(", V1.INV_SPLIT_CD" ).append("\n"); 
		query.append(", V1.USD_XCH_RT" ).append("\n"); 
		query.append(", V1.AR_OFC_CD" ).append("\n"); 
		query.append(", V1.AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}