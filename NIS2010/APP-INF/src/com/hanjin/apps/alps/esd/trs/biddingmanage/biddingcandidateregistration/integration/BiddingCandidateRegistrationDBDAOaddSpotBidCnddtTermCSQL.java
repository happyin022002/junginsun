/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.07 
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

public class BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSpotBidCnddtTerm
	  * </pre>
	  */
	public BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL(){
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
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration").append("\n"); 
		query.append("FileName : BiddingCandidateRegistrationDBDAOaddSpotBidCnddtTermCSQL").append("\n"); 
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
		query.append("  INTO TRS_SPOT_BID_CNDDT_TERM USING DUAL ON (SPOT_BID_OFC_CD = @[spot_bid_ofc_cd]" ).append("\n"); 
		query.append("           AND TRSP_CRR_MOD_CD = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("           AND NVL(@[fm_nod_cd], ' ')  LIKE SUBSTR(FM_NOD_CD, 1, LENGTH(@[fm_nod_cd]))||'%'" ).append("\n"); 
		query.append("           AND NVL(@[via_nod_cd], ' ') LIKE SUBSTR(VIA_NOD_CD, 1, LENGTH(@[via_nod_cd]))||'%'" ).append("\n"); 
		query.append("           AND NVL(@[dor_nod_cd], ' ') LIKE SUBSTR(DOR_NOD_CD, 1, LENGTH(@[dor_nod_cd]))||'%'" ).append("\n"); 
		query.append("           AND NVL(@[to_nod_cd], ' ')  LIKE SUBSTR(TO_NOD_CD, 1, LENGTH(@[to_nod_cd]))||'%'" ).append("\n"); 
		query.append("#if( (${fm_nod_cd} != '' && ${fm_nod_cd} != 'null') || (${via_nod_cd} != '' && ${via_nod_cd} != 'null') ||" ).append("\n"); 
		query.append("     (${dor_nod_cd} != '' && ${dor_nod_cd} != 'null') || (${to_nod_cd} != '' && ${to_nod_cd} != 'null') )" ).append("\n"); 
		query.append("           AND NOT (FM_NOD_CD IS NULL AND VIA_NOD_CD IS NULL AND DOR_NOD_CD IS NULL AND TO_NOD_CD IS NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("       WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (SPOT_BID_CNDDT_TERM_SEQ," ).append("\n"); 
		query.append("               SPOT_BID_OFC_CD," ).append("\n"); 
		query.append("               TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("               FM_NOD_CD," ).append("\n"); 
		query.append("               VIA_NOD_CD," ).append("\n"); 
		query.append("               DOR_NOD_CD," ).append("\n"); 
		query.append("               TO_NOD_CD," ).append("\n"); 
		query.append("               LOCL_CRE_DT," ).append("\n"); 
		query.append("               LOCL_UPD_DT," ).append("\n"); 
		query.append("               CRE_OFC_CD," ).append("\n"); 
		query.append("               CRE_USR_ID," ).append("\n"); 
		query.append("               CRE_DT," ).append("\n"); 
		query.append("               UPD_USR_ID," ).append("\n"); 
		query.append("               UPD_DT )" ).append("\n"); 
		query.append("VALUES(TO_CHAR(SYSDATE, 'yyyymmdd')||TRS_SPOT_BID_CNDT_TERM_SEQ.NEXTVAL," ).append("\n"); 
		query.append("               @[spot_bid_ofc_cd]," ).append("\n"); 
		query.append("               @[trsp_crr_mod_cd]," ).append("\n"); 
		query.append("               @[fm_nod_cd]," ).append("\n"); 
		query.append("               @[via_nod_cd]," ).append("\n"); 
		query.append("               @[dor_nod_cd]," ).append("\n"); 
		query.append("               @[to_nod_cd]," ).append("\n"); 
		query.append("               GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("               GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("               @[cre_ofc_cd]," ).append("\n"); 
		query.append("               @[cre_usr_id]," ).append("\n"); 
		query.append("               SYSDATE," ).append("\n"); 
		query.append("               @[cre_usr_id]," ).append("\n"); 
		query.append("               SYSDATE )" ).append("\n"); 

	}
}