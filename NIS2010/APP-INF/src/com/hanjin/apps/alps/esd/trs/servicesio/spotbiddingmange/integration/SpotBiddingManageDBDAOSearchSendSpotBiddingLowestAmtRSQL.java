/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOSearchSendSpotBiddingLowestAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.10.07 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBiddingManageDBDAOSearchSendSpotBiddingLowestAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bidding Number의 최저가 조회
	  * </pre>
	  */
	public SpotBiddingManageDBDAOSearchSendSpotBiddingLowestAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration").append("\n"); 
		query.append("FileName : SpotBiddingManageDBDAOSearchSendSpotBiddingLowestAmtRSQL").append("\n"); 
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
		query.append("SELECT Y.BID_NO" ).append("\n"); 
		query.append("       ,Y.BID_CURR_CD" ).append("\n"); 
		query.append("       ,ROUND(Y.BID_AMT,2) BID_AMT" ).append("\n"); 
		query.append("       ,ROUND(Y.USD_AMT,2) USD_AMT" ).append("\n"); 
		query.append("       ,Y.CURR_DT" ).append("\n"); 
		query.append("   FROM	( SELECT RANK() OVER(PARTITION BY X.SPOT_BID_NO ORDER BY X.USD_AMT ASC,X.LOCL_UPD_DT DESC) RNK" ).append("\n"); 
		query.append("		        ,X.SPOT_BID_NO BID_NO" ).append("\n"); 
		query.append("       	        ,X.SPOT_BID_CURR_CD BID_CURR_CD" ).append("\n"); 
		query.append("    	        ,X.SPOT_BID_AMT BID_AMT" ).append("\n"); 
		query.append("   	            ,X.USD_AMT" ).append("\n"); 
		query.append("				,X.CURR_DT" ).append("\n"); 
		query.append("      	   FROM ( SELECT A.SPOT_BID_NO" ).append("\n"); 
		query.append("     	                ,B.SPOT_BID_CURR_CD" ).append("\n"); 
		query.append("         	            ,B.SPOT_BID_AMT" ).append("\n"); 
		query.append("             	        ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),'YYYYMMDD HH24:MI:SS') CURR_DT" ).append("\n"); 
		query.append("              	        ,TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(B.SPOT_BID_CURR_CD,SPOT_BID_AMT,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),'YYYYMMDD')) USD_AMT" ).append("\n"); 
		query.append("                        ,B.LOCL_UPD_DT" ).append("\n"); 
		query.append("          	        FROM TRS_SPOT_BID A" ).append("\n"); 
		query.append("                    	,TRS_SPOT_BID_VNDR B" ).append("\n"); 
		query.append("         	       WHERE A.SPOT_BID_NO = B.SPOT_BID_NO" ).append("\n"); 
		query.append("            	     AND B.SPOT_BID_VNDR_STS_CD = 'S'" ).append("\n"); 
		query.append("					 AND B.SPOT_BID_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("                     AND B.SPOT_BID_AMT > 0" ).append("\n"); 
		query.append("	  	    	     AND A.SPOT_BID_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${arr_bid_no}) " ).append("\n"); 
		query.append("	#if($velocityCount == 1)						" ).append("\n"); 
		query.append("		'$key'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	    ,'$key'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("						) " ).append("\n"); 
		query.append("      	           ) X" ).append("\n"); 
		query.append("       ) Y" ).append("\n"); 
		query.append("  WHERE Y.RNK = 1" ).append("\n"); 

	}
}