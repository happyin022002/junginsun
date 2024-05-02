/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtTermListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.04 
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

public class BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtTermListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpotBidCnddtTermList
	  * </pre>
	  */
	public BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtTermListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidateregistration.integration").append("\n"); 
		query.append("FileName : BiddingCandidateRegistrationDBDAOSearchSpotBidCnddtTermListRSQL").append("\n"); 
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
		query.append("       SPOT_BID_OFC_CD," ).append("\n"); 
		query.append("       TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("       FM_NOD_CD," ).append("\n"); 
		query.append("       VIA_NOD_CD," ).append("\n"); 
		query.append("       DOR_NOD_CD," ).append("\n"); 
		query.append("       TO_NOD_CD," ).append("\n"); 
		query.append("       SUBSTR(FM_NOD_CD, 1, 5) AS FM_LOC_VALUE," ).append("\n"); 
		query.append("       SUBSTR(FM_NOD_CD, 6, 2) AS FM_YARD_VALUE," ).append("\n"); 
		query.append("       SUBSTR(TO_NOD_CD, 1, 5) AS TO_LOC_VALUE," ).append("\n"); 
		query.append("       SUBSTR(TO_NOD_CD, 6, 2) AS TO_YARD_VALUE," ).append("\n"); 
		query.append("       SUBSTR(VIA_NOD_CD, 1, 5) AS VIA_LOC_VALUE," ).append("\n"); 
		query.append("       SUBSTR(VIA_NOD_CD, 6, 2) AS VIA_YARD_VALUE," ).append("\n"); 
		query.append("       SUBSTR(DOR_NOD_CD, 1, 5) AS DOR_LOC_VALUE," ).append("\n"); 
		query.append("       SUBSTR(DOR_NOD_CD, 6, 2) AS DOR_YARD_VALUE" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_CNDDT_TERM" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if($spot_bid_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("   AND SPOT_BID_OFC_CD IN (" ).append("\n"); 
		query.append("   #foreach( ${key} IN ${spot_bid_ofc_cd}) " ).append("\n"); 
		query.append("	 #if($velocityCount < $spot_bid_ofc_cd.size()) " ).append("\n"); 
		query.append("		'${key}'," ).append("\n"); 
		query.append("	 #else " ).append("\n"); 
		query.append("		'${key}'" ).append("\n"); 
		query.append("	 #end " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${trsp_crr_mod_cd} != 'ALL' && ${trsp_crr_mod_cd} != '')" ).append("\n"); 
		query.append("   AND TRSP_CRR_MOD_CD = @[trsp_crr_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY SPOT_BID_OFC_CD, TRSP_CRR_MOD_CD, FM_NOD_CD, VIA_NOD_CD, DOR_NOD_CD, TO_NOD_CD" ).append("\n"); 

	}
}