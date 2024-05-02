/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOReceiveBiddingAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.15
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.09.15 신동일
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

public class SpotBiddingManageDBDAOReceiveBiddingAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BIDDING STATUS, BIDDING CURRENCY,BIDDING AMOUNT 변경
	  * </pre>
	  */
	public SpotBiddingManageDBDAOReceiveBiddingAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_vndr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration").append("\n"); 
		query.append("FileName : SpotBiddingManageDBDAOReceiveBiddingAmtUSQL").append("\n"); 
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
		query.append("UPDATE TRS_SPOT_BID_VNDR A" ).append("\n"); 
		query.append("   SET A.SPOT_BID_VNDR_STS_CD = @[bid_vndr_sts_cd]" ).append("\n"); 
		query.append("      ,A.SPOT_BID_CURR_CD = @[bid_curr_cd]" ).append("\n"); 
		query.append("      ,A.SPOT_BID_AMT = @[bid_amt]" ).append("\n"); 
		query.append("      ,A.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[bid_vndr_seq]))" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID = @[bid_usr_id]" ).append("\n"); 
		query.append("      ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE A.SPOT_BID_NO =  @[bid_no]" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[bid_vndr_seq]" ).append("\n"); 
		query.append("   AND 'P' = (SELECT SPOT_BID_STS_CD FROM TRS_SPOT_BID WHERE SPOT_BID_NO = @[bid_no] AND DELT_FLG = 'N')" ).append("\n"); 

	}
}