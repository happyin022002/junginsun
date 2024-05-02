/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiIcustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiIcustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiIcustRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiIcustRSQL").append("\n"); 
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
		query.append("SELECT FF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT '{I_BKG_CUST' || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_TP:' || BC.XTER_CUST_TP_CD || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_NM1:' || BKG_TOKEN_NL_FNC(NVL(CUST_NM, ''), 1, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_NM2:' || BKG_TOKEN_NL_FNC(NVL(CUST_NM, ''), 2, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_ADDR1:' || BKG_TOKEN_NL_FNC(NVL(BC.CUST_ADDR, ''), 1, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_ADDR2:' || BKG_TOKEN_NL_FNC(NVL(BC.CUST_ADDR, ''), 2, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_ADDR3:' || BKG_TOKEN_NL_FNC(NVL(BC.CUST_ADDR, ''), 3, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_ADDR4:' || BKG_TOKEN_NL_FNC(NVL(BC.CUST_ADDR, ''), 4, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_ADDR5:' || BKG_TOKEN_NL_FNC(NVL(BC.CUST_ADDR, ''), 5, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_NM1:' || BKG_TOKEN_NL_FNC(NVL(BC.CNTC_NM, ''), 1, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_NM2:' || BKG_TOKEN_NL_FNC(NVL(BC.CNTC_NM, ''), 2, '') || CHR(10) ||" ).append("\n"); 
		query.append("       'CNT_CD:' || BC.CNT_CD || CHR(10)  ||" ).append("\n"); 
		query.append("       'CUST_CD:' || BC.CUST_SEQ || CHR(10)  ||" ).append("\n"); 
		query.append("       'UN_CUST_CD:' || BC.UN_LOC_CD || CHR(10)  ||" ).append("\n"); 
		query.append("       'PCC_CUST_CD:' || BC.PRNR_CUST_CD || CHR(10)  ||" ).append("\n"); 
		query.append("       'PARTNER_REF_NO:' || BC.PRNR_REF_NO || CHR(10)  ||" ).append("\n"); 
		query.append("       'IBCS_CUST_LOC:' || BC.LOC_CTNT || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_STREET:' || BC.ST_NM || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_LOC_CD:' || BC.LOC_CD || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_LOC_NM:' || BC.LOC_NM || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_STAT_CD:' || BC.STE_CD || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_ZIP_CD:' || BC.PST_CTNT || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_CNT_CD:' || BC.CNT_CD || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_TP:' || BC.XTER_CUST_CNTC_TP_CD || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_NM::' || BC.CNTC_NM || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_TEL:' || BC.CNTC_PHN_NO_CTNT || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_FAX:' || BC.CNTC_FAX_NO || CHR(10) ||" ).append("\n"); 
		query.append("       'IBCS_C_EMAIL:' || BC.CNTC_EML || CHR(10) ||" ).append("\n"); 
		query.append("       '}I_BKG_CUST' || CHR(10) AS FF" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER(PARTITION BY BK.XTER_SNDR_ID,BK.XTER_RQST_NO,BC.XTER_CUST_TP_CD ORDER BY BK.UPLD_DT DESC) RNUM " ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST BK, BKG_XTER_CUST BC" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BK.XTER_RQST_NO = BC.XTER_RQST_NO" ).append("\n"); 
		query.append("  AND BK.XTER_RQST_SEQ = BC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("  AND BK.XTER_SNDR_ID = BC.XTER_SNDR_ID" ).append("\n"); 
		query.append("  --AND BC.XTER_CUST_TP_CD IN ('S','C','F','N','A','MS')" ).append("\n"); 
		query.append("  AND BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("  AND BK.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                       FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                       WHERE BXRM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                         AND BXRM.BKG_UPLD_STS_CD = 'F') " ).append("\n"); 
		query.append(") FF" ).append("\n"); 
		query.append("WHERE RNUM = 1" ).append("\n"); 

	}
}