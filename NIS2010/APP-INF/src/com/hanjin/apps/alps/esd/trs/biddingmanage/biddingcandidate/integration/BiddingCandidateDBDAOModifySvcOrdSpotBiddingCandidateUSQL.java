/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOModifySvcOrdSpotBiddingCandidateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.26
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.08.26 신동일
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

public class BiddingCandidateDBDAOModifySvcOrdSpotBiddingCandidateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bidding항목을 Sevice Order에 데이터 적용
	  * </pre>
	  */
	public BiddingCandidateDBDAOModifySvcOrdSpotBiddingCandidateUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOModifySvcOrdSpotBiddingCandidateUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("   SET A.SPOT_BID_FLG 		= @[spot_bid_flg]" ).append("\n"); 
		query.append("      ,A.SPOT_BID_NO 		= @[spot_bid_no]" ).append("\n"); 
		query.append("      ,A.SPOT_BID_DUE_DT 	= TO_DATE(@[spot_bid_due_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("      ,A.LOCL_UPD_DT 		= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append("	  ,A.UPD_USR_ID 		= @[usr_id]" ).append("\n"); 
		query.append("	  ,A.UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ 		= @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND A.DELT_FLG 			= 'N'" ).append("\n"); 

	}
}