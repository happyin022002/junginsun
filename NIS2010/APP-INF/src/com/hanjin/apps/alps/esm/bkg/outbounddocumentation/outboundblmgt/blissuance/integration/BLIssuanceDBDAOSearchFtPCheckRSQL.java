/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchFtPCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.19 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchFtPCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DRAFT B/L 을 화주의 FTP에 직접 등록을 위한 FTP Check
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchFtPCheckRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchFtPCheckRSQL").append("\n"); 
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
		query.append("SELECT 'Y' " ).append("\n"); 
		query.append("FROM BKG_BOOKING BB, BKG_CUSTOMER BC, " ).append("\n"); 
		query.append("    ( SELECT ATTR_CTNT1 BKG_CUST_TP_CD, ATTR_CTNT2 CUST_CNT_CD , ATTR_CTNT3 CUST_SEQ, ATTR_CTNT4 POD_CD " ).append("\n"); 
		query.append("        FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("       WHERE HRD_CDG_ID = 'PDF_FTP_CUSTOMER' ) AA" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("  AND BC.BKG_CUST_TP_CD = AA.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("  AND BC.CUST_CNT_CD = AA.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND BC.CUST_SEQ = AA.CUST_SEQ" ).append("\n"); 
		query.append("  AND BB.POD_CD = AA.POD_CD" ).append("\n"); 
		query.append("  AND BB.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}