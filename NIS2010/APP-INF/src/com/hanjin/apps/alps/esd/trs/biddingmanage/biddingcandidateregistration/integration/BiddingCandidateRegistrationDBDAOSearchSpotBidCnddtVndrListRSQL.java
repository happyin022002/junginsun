/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtVndrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
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

public class BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtVndrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpotBidCnddtVndrList
	  * </pre>
	  */
	public BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtVndrListRSQL(){
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
		query.append("FileName : BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtVndrListRSQL").append("\n"); 
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
		query.append("SELECT SPOT_BID_CNDDT_TERM_SEQ," ).append("\n"); 
		query.append("       LPAD(VNDR_SEQ, 6, '0') VNDR_SEQ," ).append("\n"); 
		query.append("       TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ) AS VNDR_NM," ).append("\n"); 
		query.append("       SPOT_BID_VNDR_EML," ).append("\n"); 
		query.append("       SP_PTAL_EXIST_FLG," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       (SELECT USR_NM FROM COM_USER WHERE 1=1 AND USR_ID = SBCV.UPD_USR_ID AND ROWNUM = 1) AS UPD_USR_NM," ).append("\n"); 
		query.append("       TO_CHAR(UPD_DT, 'yyyy-mm-dd-hh24:mi:ss') AS UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_CNDDT_VNDR SBCV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SPOT_BID_CNDDT_TERM_SEQ = @[spot_bid_cnddt_term_seq]" ).append("\n"); 
		query.append("#if(${vndr_seq} != '')" ).append("\n"); 
		query.append("   AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY VNDR_SEQ" ).append("\n"); 

	}
}