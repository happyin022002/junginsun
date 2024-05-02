/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchTpbBasicAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.20 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchTpbBasicAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTpbBasicAmt
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchTpbBasicAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchTpbBasicAmtRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(N3PTY_BIL_BZC_AMT, BZC_AMT)	INV_BSZ_N3PTY_AMT	," ).append("\n"); 
		query.append("N3PTY_VNDR_SEQ INV_BSZ_N3PTY_VNDR_SEQ               ," ).append("\n"); 
		query.append("N3PTY_OFC_CD INV_BSZ_N3PTY_OFC_CD					," ).append("\n"); 
		query.append("N3PTY_DESC INV_BSZ_N3PTY_DESC						," ).append("\n"); 
		query.append("N3PTY_CUST_SEQ INV_BSZ_CUST_SEQ						," ).append("\n"); 
		query.append("N3PTY_CUST_CNT_CD	INV_BSZ_CUST_CNT_CD				," ).append("\n"); 
		query.append("N3PTY_BIL_TP_CD INV_BSZ_BILL_CASE                   ," ).append("\n"); 
		query.append("'' INV_BZC_BILL_CASE                                    ," ).append("\n"); 
		query.append("'' INV_BZC_BILLER_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD 		= @[TRSP_SO_OFC_CTY_CD]" ).append("\n"); 
		query.append("AND TRSP_SO_SEQ 				= @[TRSP_SO_SEQ]" ).append("\n"); 

	}
}