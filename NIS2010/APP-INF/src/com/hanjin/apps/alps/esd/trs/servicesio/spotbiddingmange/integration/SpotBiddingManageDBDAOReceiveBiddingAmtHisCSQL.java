/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOReceiveBiddingAmtHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.07.07 신동일
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

public class SpotBiddingManageDBDAOReceiveBiddingAmtHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_SPOT_BID_VNDR_HIS 저장
	  * </pre>
	  */
	public SpotBiddingManageDBDAOReceiveBiddingAmtHisCSQL(){
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
		query.append("FileName : SpotBiddingManageDBDAOReceiveBiddingAmtHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_SPOT_BID_VNDR_HIS(" ).append("\n"); 
		query.append("            SPOT_BID_NO" ).append("\n"); 
		query.append("           ,VNDR_SEQ" ).append("\n"); 
		query.append("           ,SPOT_BID_VNDR_HIS_SEQ" ).append("\n"); 
		query.append("           ,SPOT_BID_VNDR_STS_CD" ).append("\n"); 
		query.append("           ,SPOT_BID_CURR_CD" ).append("\n"); 
		query.append("           ,SPOT_BID_AMT" ).append("\n"); 
		query.append("           ,LOCL_CRE_DT" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("    )VALUES(" ).append("\n"); 
		query.append("            @[bid_no]" ).append("\n"); 
		query.append("           ,@[bid_vndr_seq]" ).append("\n"); 
		query.append("           ,(SELECT CASE WHEN NVL(MAX(SPOT_BID_VNDR_HIS_SEQ),0) = 0 THEN 1" ).append("\n"); 
		query.append("                         ELSE MAX(SPOT_BID_VNDR_HIS_SEQ) +1" ).append("\n"); 
		query.append("					 END" ).append("\n"); 
		query.append("               FROM TRS_SPOT_BID_VNDR_HIS" ).append("\n"); 
		query.append("              WHERE SPOT_BID_NO =  @[bid_no]" ).append("\n"); 
		query.append("                AND VNDR_SEQ = @[bid_vndr_seq] )" ).append("\n"); 
		query.append("           ,@[bid_vndr_sts_cd]" ).append("\n"); 
		query.append("           ,@[bid_curr_cd]" ).append("\n"); 
		query.append("           ,@[bid_amt]" ).append("\n"); 
		query.append("           ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[bid_vndr_seq]))" ).append("\n"); 
		query.append("           ,@[bid_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[bid_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("  	)" ).append("\n"); 

	}
}