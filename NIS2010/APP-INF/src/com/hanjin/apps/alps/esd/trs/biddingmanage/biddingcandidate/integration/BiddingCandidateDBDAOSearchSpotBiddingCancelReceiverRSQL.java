/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOSearchSpotBiddingCancelReceiverRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.23
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.09.23 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BiddingCandidateDBDAOSearchSpotBiddingCancelReceiverRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bidding Cancel e-mail 받을  Address
	  * </pre>
	  */
	public BiddingCandidateDBDAOSearchSpotBiddingCancelReceiverRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOSearchSpotBiddingCancelReceiverRSQL").append("\n"); 
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
		query.append("SELECT REPLACE(WM_CONCAT(DISTINCT MODI_SPOT_BID_VNDR_EML), ',', ';') VNDR_EML_ADDR" ).append("\n"); 
		query.append("  FROM (SELECT SPOT_BID_NO," ).append("\n"); 
		query.append("               VNDR_SEQ," ).append("\n"); 
		query.append("               REGEXP_SUBSTR( MODI_SPOT_BID_VNDR_EML, '[^;]+', 1, LEVEL ) AS MODI_SPOT_BID_VNDR_EML ," ).append("\n"); 
		query.append("               LEVEL AS LV ," ).append("\n"); 
		query.append("               LAG( LEVEL, 1, 0 ) OVER( PARTITION BY SPOT_BID_NO, VNDR_SEQ" ).append("\n"); 
		query.append("                 ORDER BY LEVEL ) AS LG" ).append("\n"); 
		query.append("          FROM (SELECT SPOT_BID_NO," ).append("\n"); 
		query.append("                       VNDR_SEQ," ).append("\n"); 
		query.append("                       MODI_SPOT_BID_VNDR_EML" ).append("\n"); 
		query.append("                  FROM TRS_SPOT_BID_IVT_VNDR" ).append("\n"); 
		query.append("                 WHERE SPOT_BID_NO IN ( " ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_bid_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    	,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(" ) CONNECT BY REGEXP_SUBSTR( MODI_SPOT_BID_VNDR_EML, '[^;]+', 1, LEVEL ) IS NOT NULL )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND LV <> LG" ).append("\n"); 

	}
}