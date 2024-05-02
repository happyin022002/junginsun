/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BiddingCandidateDBDAOSearchInvitationVendorRSQL.java
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

public class BiddingCandidateDBDAOSearchInvitationVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Spot Bid Invitation Vendor 조회
	  * </pre>
	  */
	public BiddingCandidateDBDAOSearchInvitationVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.integration").append("\n"); 
		query.append("FileName : BiddingCandidateDBDAOSearchInvitationVendorRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ, VNDR_LGL_ENG_NM, VNDR_EML, SP_PTAL_EXIST_FLG, RNK FROM (" ).append("\n"); 
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,REPLACE(B.VNDR_EML,',',';') VNDR_EML" ).append("\n"); 
		query.append("      ,NVL((SELECT MAX(MAX(SP_EXIST_FLG) KEEP(DENSE_RANK LAST ORDER BY SP_USR_IF_SEQ)) FROM TRS_SVC_PROV_PTAL_USR_IF WHERE SP_VNDR_SEQ = A.VNDR_SEQ GROUP BY SP_USR_ID), 'N') AS SP_PTAL_EXIST_FLG " ).append("\n"); 
		query.append("      ,RANK() OVER(PARTITION BY A.VNDR_SEQ ORDER BY DECODE(B.CNTC_DIV_CD, 'EMAIL', 0, 1) ASC, B.UPD_DT DESC ) RNK" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A" ).append("\n"); 
		query.append("      ,MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("--   AND B.CNTC_DIV_CD = 'EMAIL' " ).append("\n"); 
		query.append("--   AND B.VNDR_EML IS NOT NULL" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("--   AND ROWNUM = 1" ).append("\n"); 
		query.append(") WHERE 1=1 AND RNK = 1" ).append("\n"); 

	}
}