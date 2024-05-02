/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOModifySpotBiddingStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.09.08 신동일
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

public class BiddingCandidateDBDAOModifySpotBiddingStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpotBidding Cancel할 경우 Bidding Status 변경
	  * </pre>
	  */
	public BiddingCandidateDBDAOModifySpotBiddingStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOModifySpotBiddingStatusUSQL").append("\n"); 
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
		query.append("UPDATE TRS_SPOT_BID A" ).append("\n"); 
		query.append("   SET A.SPOT_BID_STS_CD = CASE WHEN A.SPOT_BID_DUE_DT < GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD) THEN 'F'" ).append("\n"); 
		query.append("           					    ELSE 'C' " ).append("\n"); 
		query.append("				            END" ).append("\n"); 
		query.append("      ,A.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("      ,A.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE A.SPOT_BID_NO IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_bid_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    	,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}