/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBidWorkOrderIssueDBDAOsearchWorkOrderBidVndrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBidWorkOrderIssueDBDAOsearchWorkOrderBidVndrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderBidVndrList
	  * </pre>
	  */
	public SpotBidWorkOrderIssueDBDAOsearchWorkOrderBidVndrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.integration").append("\n"); 
		query.append("FileName : SpotBidWorkOrderIssueDBDAOsearchWorkOrderBidVndrListRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ," ).append("\n"); 
		query.append("       TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("       SPOT_BID_CURR_CD," ).append("\n"); 
		query.append("       SPOT_BID_AMT," ).append("\n"); 
		query.append("       TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(SPOT_BID_CURR_CD, SPOT_BID_AMT, TO_CHAR(UPD_DT, 'YYYYMMDD')) AS SPOT_BID_USD_AMT" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_VNDR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SPOT_BID_NO = @[spot_bid_no]" ).append("\n"); 
		query.append("   AND SPOT_BID_VNDR_STS_CD = 'S'" ).append("\n"); 
		query.append("   AND SPOT_BID_AMT > 0" ).append("\n"); 
		query.append(" ORDER BY TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(SPOT_BID_CURR_CD, SPOT_BID_AMT, TO_CHAR(UPD_DT, 'YYYYMMDD'))" ).append("\n"); 

	}
}