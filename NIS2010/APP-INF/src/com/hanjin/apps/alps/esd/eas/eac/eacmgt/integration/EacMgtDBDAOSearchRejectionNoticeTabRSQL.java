/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchRejectionNoticeTabRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchRejectionNoticeTabRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rejection Notice Tab 를 조회한다.
	  * </pre>
	  */
	public EacMgtDBDAOSearchRejectionNoticeTabRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cntc_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchRejectionNoticeTabRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,A.ZIP_CD" ).append("\n"); 
		query.append("      ,A.ENG_ADDR" ).append("\n"); 
		query.append("      ,(SELECT Y.STE_NM " ).append("\n"); 
		query.append("          FROM MDM_LOCATION X" ).append("\n"); 
		query.append("              ,MDM_STATE    Y" ).append("\n"); 
		query.append("         WHERE X.CNT_CD = Y.CNT_CD" ).append("\n"); 
		query.append("           AND X.STE_CD = Y.STE_CD" ).append("\n"); 
		query.append("           AND X.LOC_CD = A.LOC_CD" ).append("\n"); 
		query.append("       ) STE_NM" ).append("\n"); 
		query.append("      , B.VNDR_EML" ).append("\n"); 
		query.append("      , B.PHN_NO" ).append("\n"); 
		query.append("      , B.FAX_NO" ).append("\n"); 
		query.append("      , B.EAC_EML_USE_FLG" ).append("\n"); 
		query.append("      , B.EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("      , (SELECT NTC_CC_RCV_EML FROM EAS_EXPN_AUD_CS_PSON_CFG WHERE EAC_USR_ID = @[usr_id] ) AS NTC_CC_RCV_EML" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A " ).append("\n"); 
		query.append("     , (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("             , VNDR_EML" ).append("\n"); 
		query.append("             , PHN_NO" ).append("\n"); 
		query.append("             , FAX_NO" ).append("\n"); 
		query.append("             , EAC_EML_USE_FLG" ).append("\n"); 
		query.append("             , EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("          FROM EAS_EXPN_AUD_CS_CNTC_PNT" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("           AND VNDR_CNTC_PNT_SEQ = @[vndr_cntc_pnt_seq]" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}