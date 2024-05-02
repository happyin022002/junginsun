/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOInvIssContainerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.22 
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

public class BookingARCreationDBDAOInvIssContainerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssContainer
	  * </pre>
	  */
	public BookingARCreationDBDAOInvIssContainerCSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOInvIssContainerCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_CNTR " ).append("\n"); 
		query.append("(AR_IF_NO, CNTR_SEQ, CNTR_NO, CNTR_TPSZ_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)                  " ).append("\n"); 
		query.append("SELECT B.AR_IF_NO" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER (PARTITION BY B.AR_IF_NO ORDER BY B.AR_IF_NO,C.CNTR_NO)" ).append("\n"); 
		query.append("      ,C.CNTR_NO,C.CNTR_TPSZ_CD,@[user_id],SYSDATE,@[user_id],SYSDATE" ).append("\n"); 
		query.append("  FROM INV_AR_MN B" ).append("\n"); 
		query.append("      ,BKG_CONTAINER C" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = C.BKG_NO " ).append("\n"); 
		query.append("   AND B.AR_IF_NO IN (SELECT DISTINCT A.AR_IF_NO " ).append("\n"); 
		query.append("                        FROM INV_AR_ISS_FTR A," ).append("\n"); 
		query.append("					 	     INV_AR_MN B" ).append("\n"); 
		query.append("                       WHERE A.INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("					     AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("					     AND B.REV_TP_CD||B.REV_SRC_CD NOT IN ('MIV','MIC','MOC')" ).append("\n"); 
		query.append("						)" ).append("\n"); 

	}
}