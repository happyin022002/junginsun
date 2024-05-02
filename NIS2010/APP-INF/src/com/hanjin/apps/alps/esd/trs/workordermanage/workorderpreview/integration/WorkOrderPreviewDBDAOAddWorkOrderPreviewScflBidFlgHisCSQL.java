/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewScflBidFlgHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewScflBidFlgHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddWorkOrderPreviewScflBidFlgHis
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewScflBidFlgHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewScflBidFlgHisCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO TRS_SPOT_BID_VNDR_HIS(SPOT_BID_NO, VNDR_SEQ, SPOT_BID_VNDR_HIS_SEQ, SPOT_BID_VNDR_STS_CD, SPOT_BID_CURR_CD, SPOT_BID_AMT, LOCL_CRE_DT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT SPOT_BID_NO," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(SPOT_BID_VNDR_HIS_SEQ)+1, 1)" ).append("\n"); 
		query.append("          FROM TRS_SPOT_BID_VNDR_HIS" ).append("\n"); 
		query.append("         WHERE SPOT_BID_NO = SBV.SPOT_BID_NO" ).append("\n"); 
		query.append("           AND VNDR_SEQ = SBV.VNDR_SEQ) SPOT_BID_VNDR_HIS_SEQ," ).append("\n"); 
		query.append("       SPOT_BID_VNDR_STS_CD," ).append("\n"); 
		query.append("       SPOT_BID_CURR_CD," ).append("\n"); 
		query.append("       SPOT_BID_AMT," ).append("\n"); 
		query.append("       LOCL_CRE_DT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_VNDR SBV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SPOT_BID_NO = @[spot_bid_no]" ).append("\n"); 
		query.append("   AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}