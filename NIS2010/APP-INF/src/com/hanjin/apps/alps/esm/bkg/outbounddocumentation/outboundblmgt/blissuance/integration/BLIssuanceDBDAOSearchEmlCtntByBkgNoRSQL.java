/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchEmlCtntByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.03.04 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchEmlCtntByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEmlCtntByBkgNo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchEmlCtntByBkgNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchEmlCtntByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT REGEXP_REPLACE((" ).append("\n"); 
		query.append("(SELECT NVL(EML_CTNT,' ') ||  chr(13) || chr(10)  EML_CTNT" ).append("\n"); 
		query.append("FROM BKG_RPT_ITM_STUP" ).append("\n"); 
		query.append("WHERE BKG_OFC_CD = (SELECT BKG_OFC_CD " ).append("\n"); 
		query.append("                     FROM BKG_BOOKING " ).append("\n"); 
		query.append("                    WHERE BKG_NO= @[bkg_no])" ).append("\n"); 
		query.append("  AND (CUST_CNT_CD IS NULL OR  CUST_SEQ IS NULL)" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("|| " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT NVL(EML_CTNT,' ') EML_CTNT" ).append("\n"); 
		query.append("FROM BKG_RPT_ITM_STUP STUP, BKG_CUSTOMER B" ).append("\n"); 
		query.append("WHERE STUP.BKG_OFC_CD = (SELECT BKG_OFC_CD " ).append("\n"); 
		query.append("                     FROM BKG_BOOKING " ).append("\n"); 
		query.append("                    WHERE BKG_NO= @[bkg_no])" ).append("\n"); 
		query.append("  AND B.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("  AND B.BKG_CUST_TP_CD IN ('S','F')" ).append("\n"); 
		query.append("  AND B.CUST_CNT_CD = STUP.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND B.CUST_SEQ = STUP.CUST_SEQ" ).append("\n"); 
		query.append("  AND ROWNUM = 1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ),'[[:cntrl:]]$','') as EML_CTNT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}