/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
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

public class BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSpotBidCnddtTermHis
	  * </pre>
	  */
	public BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spot_bid_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration").append("\n"); 
		query.append("FileName : BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermHisCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO TRS_SPOT_BID_CNDDT_TERM_HIS (SPOT_BID_CNDDT_TERM_SEQ, SPOT_BID_CNDDT_TERM_HIS_SEQ, SPOT_BID_OFC_CD, TRSP_CRR_MOD_CD , FM_NOD_CD , VIA_NOD_CD , DOR_NOD_CD , TO_NOD_CD , LOCL_CRE_DT , CRE_OFC_CD , DELT_FLG , CRE_USR_ID , CRE_DT , UPD_USR_ID , UPD_DT)" ).append("\n"); 
		query.append("SELECT SPOT_BID_CNDDT_TERM_SEQ," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(SPOT_BID_CNDDT_TERM_HIS_SEQ)+1, 1)" ).append("\n"); 
		query.append("          FROM TRS_SPOT_BID_CNDDT_TERM_HIS" ).append("\n"); 
		query.append("         WHERE SPOT_BID_CNDDT_TERM_SEQ = SBCT.SPOT_BID_CNDDT_TERM_SEQ)," ).append("\n"); 
		query.append("       SPOT_BID_OFC_CD," ).append("\n"); 
		query.append("       TRSP_CRR_MOD_CD ," ).append("\n"); 
		query.append("       FM_NOD_CD ," ).append("\n"); 
		query.append("       VIA_NOD_CD ," ).append("\n"); 
		query.append("       DOR_NOD_CD ," ).append("\n"); 
		query.append("       TO_NOD_CD ," ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) LOCL_CRE_DT ," ).append("\n"); 
		query.append("       @[cre_ofc_cd] CRE_OFC_CD ," ).append("\n"); 
		query.append("       DELT_FLG ," ).append("\n"); 
		query.append("       @[cre_usr_id] CRE_USR_ID ," ).append("\n"); 
		query.append("       SYSDATE CRE_DT ," ).append("\n"); 
		query.append("       @[cre_usr_id] UPD_USR_ID ," ).append("\n"); 
		query.append("       SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_CNDDT_TERM SBCT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SPOT_BID_OFC_CD = @[spot_bid_ofc_cd]" ).append("\n"); 
		query.append("   AND TRSP_CRR_MOD_CD = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("   AND NVL(FM_NOD_CD, ' ') = NVL(@[fm_nod_cd], ' ')" ).append("\n"); 
		query.append("   AND NVL(VIA_NOD_CD, ' ') = NVL(@[via_nod_cd], ' ')" ).append("\n"); 
		query.append("   AND NVL(DOR_NOD_CD, ' ') = NVL(@[dor_nod_cd], ' ')" ).append("\n"); 
		query.append("   AND NVL(TO_NOD_CD, ' ') = NVL(@[to_nod_cd], ' ')" ).append("\n"); 

	}
}