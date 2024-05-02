/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiNtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.05 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiNtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiNtcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiNtcRSQL").append("\n"); 
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
		query.append("SELECT '{BKG_NOTICE' || CHR(10) ||" ).append("\n"); 
		query.append("'PU_CY:'      ||A.PKUP_YD_CD ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYNAME:'  || B.YD_NM     ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYADDR1:' || BKG_TOKEN_NL_FNC(B.YD_ADDR, 1, '') ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYADDR2:' || BKG_TOKEN_NL_FNC(B.YD_ADDR, 2, '') ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYADDR3:' || BKG_TOKEN_NL_FNC(B.YD_ADDR, 3, '') ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYADDR4:' || BKG_TOKEN_NL_FNC(B.YD_ADDR, 4, '') ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYADDR5:' || BKG_TOKEN_NL_FNC(B.YD_ADDR, 5, '') ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYPOST:'  || B.ZIP_CD    ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYTEL:'   || B.PHN_NO    ||CHR(10) ||" ).append("\n"); 
		query.append("'PU_CYFAX:'   || B.FAX_NO    ||CHR(10) ||" ).append("\n"); 
		query.append("'}BKG_NOTICE' || CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_ARR_NTC A, MDM_YARD B" ).append("\n"); 
		query.append("WHERE  B.YD_CD = A.PKUP_YD_CD" ).append("\n"); 
		query.append("AND  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY A.PKUP_YD_CD, B.YD_NM, B.YD_ADDR, B.ZIP_CD, B.PHN_NO, B.FAX_NO" ).append("\n"); 

	}
}