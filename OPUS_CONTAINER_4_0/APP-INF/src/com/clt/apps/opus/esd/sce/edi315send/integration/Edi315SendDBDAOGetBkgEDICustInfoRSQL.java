/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOGetBkgEDICustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.08.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetBkgEDICustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetBkgEDICustInfo
	  * </pre>
	  */
	public Edi315SendDBDAOGetBkgEDICustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetBkgEDICustInfoRSQL").append("\n"); 
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
		query.append("SELECT  '{CUST_INFO' || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_TP : ' || BKG_CUST_TP_CD || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_CD : ' || CUST_SEQ || CHR(10)  ||" ).append("\n"); 
		query.append("       'UN_CUST_CD : ' || (SELECT UN_LOC_CD FROM BKG_XTER_RQST_MST BK,BKG_XTER_CUST BC" ).append("\n"); 
		query.append("                            WHERE BK.BKG_NO =  @[e_bkg_no]" ).append("\n"); 
		query.append("                            AND BK.XTER_RQST_NO = BC.XTER_RQST_NO" ).append("\n"); 
		query.append("                            AND BK.XTER_RQST_SEQ = BC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                            AND BK.XTER_SNDR_ID = BC.XTER_SNDR_ID " ).append("\n"); 
		query.append("                            AND XTER_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("                            AND ROWNUM = 1) || CHR(10)  ||" ).append("\n"); 
		query.append("       'PCC_CUST_CD : ' ||(SELECT PRNR_CUST_CD FROM BKG_XTER_RQST_MST BK,BKG_XTER_CUST BC" ).append("\n"); 
		query.append("                            WHERE BK.BKG_NO =  @[e_bkg_no]" ).append("\n"); 
		query.append("                            AND BK.XTER_RQST_NO = BC.XTER_RQST_NO" ).append("\n"); 
		query.append("                            AND BK.XTER_RQST_SEQ = BC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                            AND BK.XTER_SNDR_ID = BC.XTER_SNDR_ID " ).append("\n"); 
		query.append("                            AND PRNR_CUST_CD is not null" ).append("\n"); 
		query.append("                            AND XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1) || CHR(10)  ||" ).append("\n"); 
		query.append("       'PARTNER_REF_NO : ' || (SELECT PRNR_REF_NO FROM BKG_XTER_RQST_MST BK,BKG_XTER_CUST BC" ).append("\n"); 
		query.append("                            WHERE BK.BKG_NO =  @[e_bkg_no]" ).append("\n"); 
		query.append("                            AND BK.XTER_RQST_NO = BC.XTER_RQST_NO" ).append("\n"); 
		query.append("                            AND BK.XTER_RQST_SEQ = BC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                            AND BK.XTER_SNDR_ID = BC.XTER_SNDR_ID " ).append("\n"); 
		query.append("                            AND PRNR_REF_NO is not null" ).append("\n"); 
		query.append("                            AND XTER_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1) || CHR(10)  ||" ).append("\n"); 
		query.append("       'CUST_NM : ' || BKG_TOKEN_NL_FNC(NVL(CUST_NM, ''), 1, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_NM2 : ' || BKG_TOKEN_NL_FNC(NVL(CUST_NM, ''), 2, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR : ' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 1, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR2 : ' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 2, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR3 : ' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 3, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR4 : ' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 4, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ADDR5 : ' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 5, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_CITY_CD : ' || '' || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_CITY_NM : ' || CUST_CTY_NM || CHR(10) ||" ).append("\n"); 
		query.append("       --'IBCS_CUST_LOC :' || BC.LOC_CTNT || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_STAT_CD : ' || CUST_STE_CD  || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_ZIP_CD : ' || CUST_ZIP_ID || CHR(10) ||" ).append("\n"); 
		query.append("       'CUST_CNT_CD : ' || CUST_CNT_CD  || CHR(10) ||" ).append("\n"); 
		query.append("       '}CUST_INFO' || CHR(10) AS CUST_INFO  " ).append("\n"); 
		query.append("FROM  BKG_CUSTOMER " ).append("\n"); 
		query.append("WHERE BKG_NO = @[e_bkg_no]" ).append("\n"); 
		query.append(" AND BKG_CUST_TP_CD IN ('A','C','E','F','N','S')" ).append("\n"); 
		query.append(" AND CUST_SEQ IS NOT NULL" ).append("\n"); 

	}
}