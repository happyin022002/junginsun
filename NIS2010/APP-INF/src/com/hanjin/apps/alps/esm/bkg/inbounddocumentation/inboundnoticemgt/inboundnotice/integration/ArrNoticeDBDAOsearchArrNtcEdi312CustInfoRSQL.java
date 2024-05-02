/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ArrNoticeDBDAOsearchArrNtcEdi312CustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrNoticeDBDAOsearchArrNtcEdi312CustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchArrNtcEdi312CustInfo
	  * </pre>
	  */
	public ArrNoticeDBDAOsearchArrNtcEdi312CustInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrNoticeDBDAOsearchArrNtcEdi312CustInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CUST_INFO'                        					   || CHR (10) || " ).append("\n"); 
		query.append("       'BCS_TP:'         ||  BCST.BKG_CUST_TP_CD              || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_CD:'        || BCST.CUST_CNT_CD||BCST.CUST_SEQ			    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_NM1:'       || NVL(REPLACE(BCST.CUST_NM, CHR(13)||CHR(10), ' '),' ')   || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_NM2:'       || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR1:'     || NVL(REPLACE(BCST.CUST_ADDR, CHR(13)||CHR(10), ' '),' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR2:'     || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR3:'     || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_C_NM1:'     || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_C_NM2:'     || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_CUST_LOC:'  || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_STREET:'    || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_LOC_CD:'    || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_LOC_NM:'    || ''			 				    || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ZIP_CD:'    || BCST.CUST_ZIP_ID	    				    || CHR(10) ||" ).append("\n"); 
		query.append("       '}CUST_INFO'      || CHR(10)" ).append("\n"); 
		query.append(" FROM BKG_CUSTOMER BCST" ).append("\n"); 
		query.append(" WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append(" AND   BCST.CUST_NM IS NOT NULL" ).append("\n"); 

	}
}