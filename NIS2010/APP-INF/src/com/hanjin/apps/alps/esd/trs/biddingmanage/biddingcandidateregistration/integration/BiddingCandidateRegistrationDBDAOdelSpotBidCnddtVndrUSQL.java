/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateRegistrationDBDAOdelSpotBidCnddtVndrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BiddingCandidateRegistrationDBDAOdelSpotBidCnddtVndrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * delSpotBidCnddtVndr
	  * </pre>
	  */
	public BiddingCandidateRegistrationDBDAOdelSpotBidCnddtVndrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_cnddt_term_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration").append("\n"); 
		query.append("FileName : BiddingCandidateRegistrationDBDAOdelSpotBidCnddtVndrUSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_CNDDT_VNDR" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SPOT_BID_CNDDT_TERM_SEQ = @[spot_bid_cnddt_term_seq]" ).append("\n"); 
		query.append("#if(${vndr_seq} != '' && ${vndr_seq} != 'null')" ).append("\n"); 
		query.append("   AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}