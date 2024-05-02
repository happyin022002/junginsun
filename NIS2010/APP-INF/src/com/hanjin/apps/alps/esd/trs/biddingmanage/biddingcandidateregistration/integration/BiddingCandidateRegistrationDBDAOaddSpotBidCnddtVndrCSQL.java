/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateRegistrationDBDAOaddSpotBidCnddtVndrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.30 
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

public class BiddingCandidateRegistrationDBDAOaddSpotBidCnddtVndrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSpotBidCnddtVndr
	  * </pre>
	  */
	public BiddingCandidateRegistrationDBDAOaddSpotBidCnddtVndrCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_exist_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_vndr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration").append("\n"); 
		query.append("FileName : BiddingCandidateRegistrationDBDAOaddSpotBidCnddtVndrCSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("  INTO TRS_SPOT_BID_CNDDT_VNDR SBCV USING DUAL ON (SPOT_BID_CNDDT_TERM_SEQ = @[spot_bid_cnddt_term_seq]" ).append("\n"); 
		query.append("           AND VNDR_SEQ = @[vndr_seq])" ).append("\n"); 
		query.append("       WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (SPOT_BID_CNDDT_TERM_SEQ," ).append("\n"); 
		query.append("               VNDR_SEQ," ).append("\n"); 
		query.append("               SPOT_BID_VNDR_EML," ).append("\n"); 
		query.append("               SP_PTAL_EXIST_FLG," ).append("\n"); 
		query.append("               CRE_OFC_CD," ).append("\n"); 
		query.append("               LOCL_CRE_DT," ).append("\n"); 
		query.append("               LOCL_UPD_DT," ).append("\n"); 
		query.append("               CRE_USR_ID," ).append("\n"); 
		query.append("               CRE_DT," ).append("\n"); 
		query.append("               UPD_USR_ID," ).append("\n"); 
		query.append("               UPD_DT )" ).append("\n"); 
		query.append("VALUES(@[spot_bid_cnddt_term_seq]," ).append("\n"); 
		query.append("               @[vndr_seq]," ).append("\n"); 
		query.append("               @[spot_bid_vndr_eml]," ).append("\n"); 
		query.append("               @[sp_ptal_exist_flg]," ).append("\n"); 
		query.append("--               (SELECT SP_EXIST_FLG FROM TRS_SVC_PROV_PTAL_USR_IF WHERE 1=1 AND SP_VNDR_SEQ = [vndr_seq] AND ROWNUM = 1)," ).append("\n"); 
		query.append("               @[cre_ofc_cd]," ).append("\n"); 
		query.append("               GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("               GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("               @[cre_usr_id]," ).append("\n"); 
		query.append("               SYSDATE," ).append("\n"); 
		query.append("               @[cre_usr_id]," ).append("\n"); 
		query.append("               SYSDATE )" ).append("\n"); 
		query.append("       WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("   SET SBCV.SPOT_BID_VNDR_EML = @[spot_bid_vndr_eml]," ).append("\n"); 
		query.append("       SBCV.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("       SBCV.UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("       SBCV.UPD_DT = SYSDATE" ).append("\n"); 

	}
}