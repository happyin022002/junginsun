/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOSearchBiddingCandidateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BiddingCandidateDBDAOSearchBiddingCandidateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bidding Candidate Vendor 조회
	  * </pre>
	  */
	public BiddingCandidateDBDAOSearchBiddingCandidateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOSearchBiddingCandidateListRSQL").append("\n"); 
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
		query.append("SELECT A.SPOT_BID_CNDDT_TERM_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,A.FM_NOD_CD" ).append("\n"); 
		query.append("      ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,A.TO_NOD_CD" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR X " ).append("\n"); 
		query.append("         WHERE X.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("           AND X.DELT_FLG  = 'N') VNDR_NM" ).append("\n"); 
		query.append("      ,B.SPOT_BID_VNDR_EML AS VNDR_EML_ADDR" ).append("\n"); 
		query.append("      ,B.SP_PTAL_EXIST_FLG AS SPP_FLG" ).append("\n"); 
		query.append("      ,A.SPOT_BID_OFC_CD" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_CNDDT_TERM A" ).append("\n"); 
		query.append("      ,TRS_SPOT_BID_CNDDT_VNDR B" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD C" ).append("\n"); 
		query.append(" WHERE A.SPOT_BID_CNDDT_TERM_SEQ = B.SPOT_BID_CNDDT_TERM_SEQ" ).append("\n"); 
		query.append("   AND A.SPOT_BID_OFC_CD = C.CRE_OFC_CD" ).append("\n"); 
		query.append("   AND A.TRSP_CRR_MOD_CD = C.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("   AND A.FM_NOD_CD IS NULL" ).append("\n"); 
		query.append("   AND A.VIA_NOD_CD IS NULL" ).append("\n"); 
		query.append("   AND A.DOR_NOD_CD IS NULL" ).append("\n"); 
		query.append("   AND A.TO_NOD_CD IS NULL" ).append("\n"); 
		query.append("--   AND B.SP_PTAL_EXIST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.CRE_OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_CRR_MOD_CD = C.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("#if ($arr_so_no.size() > 0)" ).append("\n"); 
		query.append("	AND (C.TRSP_SO_OFC_CTY_CD,C.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_so_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("		(SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("    	,(SUBSTR('$key',1,3),SUBSTR('$key',4))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY A.SPOT_BID_CNDDT_TERM_SEQ" ).append("\n"); 
		query.append("	     ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	     ,A.FM_NOD_CD" ).append("\n"); 
		query.append("	     ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("	     ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("	     ,A.TO_NOD_CD" ).append("\n"); 
		query.append("	     ,B.VNDR_SEQ" ).append("\n"); 
		query.append("	     ,B.SPOT_BID_VNDR_EML" ).append("\n"); 
		query.append("         ,B.SP_PTAL_EXIST_FLG" ).append("\n"); 
		query.append("	     ,A.SPOT_BID_OFC_CD" ).append("\n"); 
		query.append("  ORDER BY B.VNDR_SEQ" ).append("\n"); 

	}
}