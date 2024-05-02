/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOSearchSpotBiddingInvataionVndrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.09.08 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BiddingCandidateDBDAOSearchSpotBiddingInvataionVndrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bidding Cancel mail 보낼 S/P 조회
	  * </pre>
	  */
	public BiddingCandidateDBDAOSearchSpotBiddingInvataionVndrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration ").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOSearchSpotBiddingInvataionVndrRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT A.VNDR_SEQ" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_IVT_VNDR A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("  AND A.SPOT_BID_NO IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_bid_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    	,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}